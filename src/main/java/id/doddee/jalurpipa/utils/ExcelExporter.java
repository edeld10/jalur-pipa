package id.doddee.jalurpipa.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public abstract class ExcelExporter<T> {
    private SXSSFSheet sheet;
    private String sheetName;
    private List<String> headers;
    protected List<T> data;

    public ExcelExporter(String sheetName, List<String> headers, List<T> data) {
        this.sheetName = sheetName;
        this.headers = headers;
        this.data = data;
    }

    abstract void buildExcel();

    protected Row createRow(int rowIdx) {
        return sheet.createRow(rowIdx);
    }

    protected void createCell(int cellIdx, String value, Row row) {
        Cell cell = row.createCell(cellIdx);
        cell.setCellValue(value);
    }

    private void createCellWithStyle(int cellIdx, String value, CellStyle style, Row row) {
        Cell cell = row.createCell(cellIdx);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    public byte[] exportToExcel() throws IOException {
        ByteArrayOutputStream baos;
        try (SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
            sheet = workbook.createSheet(sheetName);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row row = createRow(0);
            AtomicInteger cellIdx = new AtomicInteger();
            headers.forEach(
                s -> {
                    createCellWithStyle(cellIdx.getAndIncrement(), s, headerCellStyle, row);
                }
            );

            buildExcel();
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        }
        return baos.toByteArray();
    }
}
