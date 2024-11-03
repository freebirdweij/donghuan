说明
**Device**类是抽象类，包含设备的通用属性和方法，所有设备都继承自该类。
每个具体的设备类（如UPSDevice、AirConditionerDevice、TemperatureHumiditySensor）都有各自的特定属性，并实现了monitor()方法来展示设备的监控数据。
测试主类MonitoringSystem展示了如何创建设备实例并调用其监控方法。
**SwitchingPowerSupply**类用于监控开关电源的输入/输出电压、输出电流和负载情况。
**Generator**类监控发电机的燃料水平、输出功率和运行状态。
**DistributionCabinet**类用于监控配电柜中每个支路的电流、电压和开关状态。
WaterLeakSensor 用于监控是否存在漏水现象。
SmokeDetector 用于监控是否存在烟雾，帮助预防火灾。
AccessControlSystem 用于监控门禁系统的状态及最近的访问信息。
CCTVSystem 用于监控视频监控系统是否正在录制，并提供最后一次录制时间。
VibrationSensor 用于监控设备或环境的振动水平，防止设备受损。
通过这种面向对象的设计，你可以轻松扩展更多类型的设备。