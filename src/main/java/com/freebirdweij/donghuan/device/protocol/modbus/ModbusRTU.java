package com.freebirdweij.donghuan.device.protocol.modbus;

import java.io.ByteArrayOutputStream;

public class ModbusRTU {
    private SerialPortManager serialPortManager;
    private int slaveId;

    public ModbusRTU(String portName, int baudRate, int dataBits, int stopBits, int parity, int slaveId) throws Exception {
        this.serialPortManager = new SerialPortManager(portName, baudRate, dataBits, stopBits, parity);
        this.slaveId = slaveId;
    }

    public ModbusRTU(String portName, int baudRate, int dataBits, int stopBits, int parity) {
        //TODO Auto-generated constructor stub
    }

    public void open() throws Exception {
        serialPortManager.open();
    }

    public void close() {
        serialPortManager.close();
    }

    public byte[] readHoldingRegisters(int startAddress, int quantity) throws Exception {
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x03);
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

    public void writeSingleRegister(int registerAddress, int value) throws Exception {
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x06);
        request.setData(new byte[] {
            (byte)(registerAddress >> 8),
            (byte)(registerAddress & 0xFF),
            (byte)(value >> 8),
            (byte)(value & 0xFF)
        });
        byte[] requestFrame = request.build();
        serialPortManager.write(requestFrame);
        byte[] responseFrame = serialPortManager.read();

        ModbusResponse response = new ModbusResponse(responseFrame);
        if (response.isException()) {
            throw new ModbusException(response.getExceptionCode());
        }
        // Optionally verify the response matches the request
    }

    /**
     * 读取离散输入
     *
     * @param startAddress 起始地址
     * @param quantity     要读取的离散输入数量
     * @return 表示离散输入状态的布尔数组
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public boolean[] readDiscreteInputs(int startAddress, int quantity) throws Exception {
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x02); // 读取离散输入功能码
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

       boolean[] inputs = new boolean[quantity];
        for (int i = 0; i < quantity; i++) {
            inputs[i] = (response.getData()[1 + i / 8] & (1 << (i % 8))) != 0;
        }
        return inputs;
    }

    /**
     * 读取线圈状态
     *
     * @param startAddress 起始地址
     * @param quantity     要读取的线圈数量
     * @return 表示线圈状态的布尔数组
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public boolean[] readCoils(int startAddress, int quantity) throws Exception {
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x01); // 读取线圈功能码
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

        boolean[] coils = new boolean[quantity];
        for (int i = 0; i < quantity; i++) {
            coils[i] = (response.getData()[1 + i / 8] & (1 << (i % 8))) != 0;
        }
        return coils;
    }

    /**
     * 读取输入寄存器
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

    /**
     * 写入多个寄存器
     *
     * @param startAddress 起始地址
     * @param values       要写入的寄存器值数组
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public void writeMultipleRegisters(int startAddress, int[] values) throws Exception {
        int quantity = values.length;
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x10); // 写入多个寄存器功能码

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write((byte)(startAddress >> 8));
        baos.write((byte)(startAddress & 0xFF));
        baos.write((byte)(quantity >> 8));
        baos.write((byte)(quantity & 0xFF));
        baos.write((byte)(quantity * 2)); // 字节数

        for (int value : values) {
            baos.write((byte)(value >> 8));
            baos.write((byte)(value & 0xFF));
        }

        request.setData(baos.toByteArray());
        byte[] requestFrame = request.build();
        serialPortManager.write(requestFrame);
        byte[] responseFrame = serialPortManager.read();

        ModbusResponse response = new ModbusResponse(responseFrame);
        if (response.isException()) {
            throw new ModbusException(response.getExceptionCode());
        }
        // 可选：验证响应是否与请求匹配
    }

    /**
     * 写入单个线圈状态
     *
     * @param coilAddress 线圈地址
     * @param value        要设置的状态（true为ON，false为OFF）
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public void writeSingleCoil(int coilAddress, boolean value) throws Exception {
        int outputValue = value ? 0xFF00 : 0x0000;
        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x05); // 写入单个线圈功能码
        request.setData(new byte[] {
            (byte)(coilAddress >> 8),
            (byte)(coilAddress & 0xFF),
            (byte)(outputValue >> 8),
            (byte)(outputValue & 0xFF)
        });
        byte[] requestFrame = request.build();
        serialPortManager.write(requestFrame);
        byte[] responseFrame = serialPortManager.read();

        ModbusResponse response = new ModbusResponse(responseFrame);
        if (response.isException()) {
            throw new ModbusException(response.getExceptionCode());
        }
        // 可选：验证响应是否与请求匹配
    }

    /**
     * 写入多个线圈状态
     *
     * @param startAddress 起始线圈地址
     * @param values       要设置的线圈状态数组（true为ON，false为OFF）
     * @throws Exception 通信失败或收到错误响应时抛出
     */
    public void writeMultipleCoils(int startAddress, boolean[] values) throws Exception {
        int quantity = values.length;
        if (quantity < 1 || quantity > 0x07B0) { // Modbus协议限制，最大数量为 1968
            throw new IllegalArgumentException("Quantity of coils must be between 1 and 1968.");
        }

        ModbusRequest request = new ModbusRequest();
        request.setSlaveId(slaveId);
        request.setFunctionCode(0x0F); // 写入多个线圈功能码

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write((byte)(startAddress >> 8));
        baos.write((byte)(startAddress & 0xFF));
        baos.write((byte)(quantity >> 8));
        baos.write((byte)(quantity & 0xFF));

        int byteCount = (quantity + 7) / 8;
        baos.write((byte)byteCount);

        byte[] coilBytes = new byte[byteCount];
        for (int i = 0; i < quantity; i++) {
            if (values[i]) {
                coilBytes[i / 8] |= (1 << (i % 8));
            }
        }
        baos.write(coilBytes);

        request.setData(baos.toByteArray());
        byte[] requestFrame = request.build();
        serialPortManager.write(requestFrame);
        byte[] responseFrame = serialPortManager.read();

        ModbusResponse response = new ModbusResponse(responseFrame);
        if (response.isException()) {
            throw new ModbusException(response.getExceptionCode());
        }

        // 验证响应中的起始地址和数量是否与请求匹配
        byte[] responseData = response.getData();
        int responseStartAddress = ((responseData[0] & 0xFF) << 8) | (responseData[1] & 0xFF);
        int responseQuantity = ((responseData[2] & 0xFF) << 8) | (responseData[3] & 0xFF);

        if (responseStartAddress != startAddress || responseQuantity != quantity) {
            throw new Exception("Response does not match the request parameters.");
        }
    }

    // 可扩展更多功能，如写入多个线圈等
}
