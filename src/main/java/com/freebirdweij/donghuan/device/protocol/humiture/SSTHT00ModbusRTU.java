package com.freebirdweij.donghuan.device.protocol.humiture;

import com.freebirdweij.donghuan.device.protocol.modbus.ModbusException;
import com.freebirdweij.donghuan.device.protocol.modbus.ModbusRTU;
import com.freebirdweij.donghuan.device.protocol.modbus.ModbusRequest;
import com.freebirdweij.donghuan.device.protocol.modbus.ModbusResponse;
import com.freebirdweij.donghuan.device.protocol.modbus.SerialPortManager;

public class SSTHT00ModbusRTU extends ModbusRTU{
    private SerialPortManager serialPortManager;
    private int slaveId;

    public SSTHT00ModbusRTU(String portName, int baudRate, int dataBits, int stopBits, int parity, int slaveId) throws Exception {
        super(portName, baudRate, dataBits, stopBits, parity);
        this.slaveId = slaveId;
    }

    public void open() throws Exception {
        serialPortManager.open();
    }

    public void close() {
        serialPortManager.close();
    }

    // Existing methods...

    /**
     * 读取所有数据（温度和湿度）
     *
     * @return 包含温度和湿度值的Data对象
     * @throws Exception 通信失败或接收错误响应时抛出
     */
    public Data readAllData() throws Exception {
        // 读取起始地址为0000H的2个寄存器（温度和湿度）
        byte[] responseData = readInputRegisters(0x0000, 2);
        
        if (responseData.length < 4) {
            throw new Exception("响应数据长度不足.");
        }

        // 解析温度
        int tempRaw = ((responseData[0] & 0xFF) << 8) | (responseData[1] & 0xFF);
        double temperature = parseSignedValue(tempRaw) / 10.0;

        // 解析湿度
        int humidityRaw = ((responseData[2] & 0xFF) << 8) | (responseData[3] & 0xFF);
        double humidity = parseSignedValue(humidityRaw) / 10.0;

        return new Data(temperature, humidity, null);
    }

    /**
     * 读取温度数据
     *
     * @return 温度值
     * @throws Exception 通信失败或接收错误响应时抛出
     */
    public double readTemperature() throws Exception {
        // 读取起始地址为0000H的1个寄存器（温度）
        byte[] responseData = readInputRegisters(0x0000, 1);
        
        if (responseData.length < 2) {
            throw new Exception("响应数据长度不足.");
        }

        // 解析温度
        int tempRaw = ((responseData[0] & 0xFF) << 8) | (responseData[1] & 0xFF);
        return parseSignedValue(tempRaw) / 10.0;
    }

    /**
     * 读取湿度数据
     *
     * @return 湿度值
     * @throws Exception 通信失败或接收错误响应时抛出
     */
    public double readHumidity() throws Exception {
        // 读取起始地址为0001H的1个寄存器（湿度）
        byte[] responseData = readInputRegisters(0x0001, 1);
        
        if (responseData.length < 2) {
            throw new Exception("响应数据长度不足.");
        }

        // 解析湿度
        int humidityRaw = ((responseData[0] & 0xFF) << 8) | (responseData[1] & 0xFF);
        return parseSignedValue(humidityRaw) / 10.0;
    }

    /**
     * 读取露点数据
     *
     * @return 露点值
     * @throws Exception 通信失败或接收错误响应时抛出
     */
    public Double readDewPoint() throws Exception {
        // 检查是否支持露点功能
        // 这里假设设备支持露点功能，读取起始地址为0030H的1个寄存器
        byte[] responseData = readInputRegisters(0x0030, 1);
        
        if (responseData.length < 2) {
            throw new Exception("响应数据长度不足.");
        }

        // 解析露点
        int dewPointRaw = ((responseData[0] & 0xFF) << 8) | (responseData[1] & 0xFF);
        return parseSignedValue(dewPointRaw) / 10.0;
    }

    /**
     * 解析有符号的16位整数
     *
     * @param value 原始值
     * @return 有符号的整数
     */
    private int parseSignedValue(int value) {
        if (value >= 0x8000) {
            return value - 0x10000;
        }
        return value;
    }

    /**
     * 读取多个输入寄存器
     *
     * @param startAddress 起始地址
     * @param quantity     要读取的输入寄存器数量
     * @return 输入寄存器值的字节数组
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public byte[] readInputRegisters(int startAddress, int quantity) throws Exception {
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x04); // 读取输入寄存器功能码
        request.setData(new byte[] {
            (byte)(startAddress >> 8),
            (byte)(startAddress & 0xFF),
            (byte)(quantity >> 8),
            (byte)(quantity & 0xFF)
        });
        byte[] requestFrame = request.build();
        serialPortManager.write(requestFrame);
        byte[] responseFrame = serialPortManager.read();

        ModbusResponse response = new ModbusResponse(responseFrame);
        if (response.isException()) {
            throw new ModbusException(response.getExceptionCode());
        }
        return response.getData();
    }

    // 其他现有方法...

    /**
     * 数据类用于封装温度、湿度和露点数据
     */
    public static class Data {
        private double temperature;
        private double humidity;
        private Double dewPoint; // 可为空

        public Data(double temperature, double humidity, Double dewPoint) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.dewPoint = dewPoint;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public Double getDewPoint() {
            return dewPoint;
        }

        @Override
        public String toString() {
            return "Data{" +
                   "temperature=" + temperature +
                   ", humidity=" + humidity +
                   (dewPoint != null ? ", dewPoint=" + dewPoint : "") +
                   '}';
        }
    }
}
