 **模板文件示例**
```freemarker
public class ${config.deviceType}Entity {
    <#list config.dataPoints as point>
    private ${point.dataType} ${point.name};
    </#list>
    
    // Getters and Setters
}
