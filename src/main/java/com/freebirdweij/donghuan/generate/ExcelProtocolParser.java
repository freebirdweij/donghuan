package com.freebirdweij.donghuan.generate;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * Excel解析器
 */
public class ExcelProtocolParser {

    public DeviceProtocolConfig parseExcel(MultipartFile excelFile) throws IOException {
        DeviceProtocolConfig config = new DeviceProtocolConfig();
        
        try (Workbook workbook = new XSSFWorkbook((XSSFFactory) excelFile)) {
            // 解析基本信息
            Sheet basicInfoSheet = workbook.getSheetAt(0);
            if (basicInfoSheet != null) {
                parseBasicInfo(basicInfoSheet, config);
            }
            // 解析数据点位
            Sheet dataPointsSheet = workbook.getSheetAt(1);
            if (dataPointsSheet != null) {
                parseDataPoints(dataPointsSheet, config);
            }
        }
        return config;
    }

    private void parseDataPoints(Sheet dataPointsSheet, DeviceProtocolConfig config) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseDataPoints'");
    }

    private void parseBasicInfo(Sheet basicInfoSheet, DeviceProtocolConfig config) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseBasicInfo'");
    }
}
