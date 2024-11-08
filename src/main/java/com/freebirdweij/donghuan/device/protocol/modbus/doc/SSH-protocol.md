# 《SST-HT00温湿度传感器（MODBUS）通讯协议总结》

## 一、概述
1. **引言**
   - 通讯规约描述了本机通讯的读、写命令格式及信息和数据的定义，供第三方开发使用。
2. **电气特点及符合标准**
   - 主通信接口采用标准串行RS485通讯口，使用接线端子。
   - 信息传输方式为异步方式，字节格式为起始位1位，数据位8位，停止位1位，无校验。
   - 数据传输速率可选1200b/s、2400b/s、4800b/s、9600b/s、19200b/s，缺省为9600b/s。
   - 符合MODUBS RTU协议标准。

## 二、MODBUS RTU通信协议详述
1. **协议基本规则**
   - RS485通讯回路采用主/从方式，数据在主站（如PC）和多个子站（如SST - HT00）之间传递，通讯不能从子站开始，主站初始化和控制信息传递。
   - 传送分为主/从传送和从/主传送两种方式，以“信息帧”方式传递，若接收到含未知命令的信息帧则不响应。
   - “信息帧”是由字节构成的字符串（最多255个字节），由信息头和编码数据构成，兼容RTU通讯规约。
2. **信息帧结构描述**
   - 信息帧组成：|地址|功能码|数据地址|数据1|数据…|数据n|CRC16|

## 三、字节格式
 - 通讯传输为异步方式，以字节为单位，主站和子站间传递的字节帧是10位（无校验位）的串行数据流。

## 四、命令报文格式
1. **读数据**
   - 主站发送：|地址|功能码|数据起始地址高位|数据起始地址低位|数据个数高位|数据个数低位|CRC16高位|CRC16低位|
   - 返回：|地址|功能码|字节长度|数据1高位|数据1低位|数据2高位|数据2低位|…|CRC16高位|CRC16低位|

## 五、SST - HT00内部报文信息
1. **功能代码相关信息**
   - 04H功能码：
     - 数据起始地址0000H，数据个数1，内容为温度值。
     - 数据起始地址0001H，数据个数1，内容为湿度值。
     - 数据起始地址0030H，数据个数1，内容为露点值（带露点功能有此项）。
2. **数据表示方式**
   - 每一个数据用两个字节整数表示，高位在前，低位在后。
   - 带符号整数范围 -32768 - 32767，上传数据需除十，正数范围为16进制0X0000 - 0X7FFF，负数采用正数补码方式传输，范围为16进制0X8000 - 0XFFFF。

## 六、网络采样定时
 - 上位机读取数据每次间隔时间不小于500ms，推荐值1s。

## 七、命令举例
1. **读所有数据**
   - 设地址为1，上位机发送：01 04 0000 0002 71CB（读从数据起始地址为0000H开始的2个模拟量），下位机返回：01 04 04，温度H，温度L，湿度H，湿度L，CRCL，CRCH。
2. **带露点功能的温湿度读取露点指令**
   - 上位机发送：01 04 00 30 00 01 31 C5（读从数据起始地址为0030H开始的1个模拟量），下位机返回：01 04 02，温度H，温度L，CRCL，CRCH。
3. **只读温度数据**
   - 上位机发送：01 04 0000 0001 31CA（读从数据起始地址为0000H开始的1个模拟量），下位机返回：01 04 02，温度H，温度L，CRCH，CRCL。
4. **只读湿度数据**
   - 上位机发送：01 04 0001 0001 600A（读从数据起始地址为0001H开始的1个模拟量），下位机返回：01 04 02，湿度H，湿度L，CRCH，CRCL。