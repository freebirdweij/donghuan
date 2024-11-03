package com.freebirdweij.donghuan.communication.method.serial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @date 2023-07-01 16:37
 * @since 1.8
 */
@CrossOrigin
@RestController
@RequestMapping("/serial")
public class SerialController {

    @Autowired
    SerialPortConfig serial;

    /**
     * 获取端口列表
     * @return
     */
    @GetMapping("/getSerialPortList")
    public List<String> getSerialPortList(){
        return serial.getSerialPortList();
    }

    /**
     * 字符串 转 HEX
     * @return
     */
    @GetMapping("/toHex")
    public String toHex(String str){
        return SerialUtil.toHex(str);
    }

    /**
     * HEX 转 字符串
     * @return
     */
    @GetMapping("/toStr")
    public String toStr(String hex){
        return SerialUtil.toStr(hex);
    }

}
