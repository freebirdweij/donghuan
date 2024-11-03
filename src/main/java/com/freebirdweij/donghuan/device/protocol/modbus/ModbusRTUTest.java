package com.freebirdweij.donghuan.device.protocol.modbus;

public class ModbusRTUTest {
    public static void main(String[] args) {
        try {
            ModbusRTU modbus = new ModbusRTU("COM3", 9600, 8, 1, 0, 1);
            modbus.open();

            // 读取保持寄存器
            byte[] registers = modbus.readHoldingRegisters(0x0000, 2);
            System.out.printf("读取到的寄存器值: %02X %02X\n", registers[0], registers[1]);

            // 写单个寄存器
            modbus.writeSingleRegister(0x0001, 0x1234);
            System.out.println("写入寄存器成功");
            // 读取10个线圈的状态
            boolean[] coils = modbus.readCoils(0, 10);
            for (int i = 0; i < coils.length; i++) {
                System.out.println("Coil " + i + ": " + (coils[i] ? "ON" : "OFF"));
            }

            // 写入多个寄存器
            int[] registerValues = { 100, 200, 300 };
            modbus.writeMultipleRegisters(0, registerValues);

            // 写入单个线圈
            modbus.writeSingleCoil(5, true);

            // 读取10个线圈的状态
            coils = modbus.readCoils(0, 10);
            for (int i = 0; i < coils.length; i++) {
                System.out.println("Coil " + i + ": " + (coils[i] ? "ON" : "OFF"));
            }

            // 写入多个线圈的状态
            boolean[] newCoilStates = { true, false, true, true, false, false, true, false, true, true };
            modbus.writeMultipleCoils(0, newCoilStates);
            System.out.println("Successfully wrote multiple coils.");

            // 读取更新后的线圈状态
            boolean[] updatedCoils = modbus.readCoils(0, 10);
            for (int i = 0; i < updatedCoils.length; i++) {
                System.out.println("Coil " + i + ": " + (updatedCoils[i] ? "ON" : "OFF"));
            }

            // 读取5个输入寄存器
            byte[] inputRegisters = modbus.readInputRegisters(0x0000, 5);
            for (int i = 0; i < inputRegisters.length; i += 2) {
                int registerValue = ((inputRegisters[i] & 0xFF) << 8) | (inputRegisters[i + 1] & 0xFF);
                System.out.println("Input Register " + (i / 2) + ": " + registerValue);
            }

            // 写入多个寄存器
            modbus.writeMultipleRegisters(0, registerValues);
            System.out.println("Successfully wrote multiple registers.");

            // 写入单个线圈
            modbus.writeSingleCoil(5, true);
            System.out.println("Successfully wrote single coil.");

            modbus.close();
        } catch (ModbusException me) {
            System.err.println("Modbus 异常: " + me.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}