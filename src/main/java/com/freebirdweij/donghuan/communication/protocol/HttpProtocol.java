package com.freebirdweij.donghuan.communication.protocol;
//HTTP 协议类（假设的实现，具体实现可借助 HTTP 客户端库）
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.freebirdweij.donghuan.communication.protocol.base.CommunicationProtocol;

/**
 * HttpProtocol 类实现了 HTTP 协议的通信。
 */
public class HttpProtocol implements CommunicationProtocol {
    private HttpURLConnection connection;
    private String deviceAddress;
    private int port;

    public HttpProtocol(String deviceAddress, int port) {
        this.deviceAddress = deviceAddress;
        this.port = port;
    }

    @Override
    public void connect() {
        try {
            URL url = new URL("http://" + deviceAddress + ":" + port);
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            handleError(e);
        }
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            connection.disconnect();
        }
    }

    @Override
    public String sendData(String data) {
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data.getBytes());

            int responseCode = connection.getResponseCode();
            return "HTTP Response Code: " + responseCode;
        } catch (IOException e) {
            handleError(e);
            return "Failed to send data";
        }
    }

    @Override
    public String receiveData() {
        try {
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }
        } catch (IOException e) {
            handleError(e);
        }
        return "Failed to receive data";
    }

    private void handleError(Exception e) {
        System.out.println("HTTP error: " + e.getMessage());
    }

    @Override
    public void sendBytes(byte[] data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendBytes'");
    }

    @Override
    public byte[] receiveBytes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveBytes'");
    }
}
