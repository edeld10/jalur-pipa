package id.doddee.jalurpipa.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelImporter<T> {
    private byte[] file;

    public ExcelImporter(byte[] file) {
        this.file = file;
    }

    abstract T buildData(Row row);

    protected String getCellValue(int cellIdx, Row row) {
        return row.getCell(cellIdx).getStringCellValue();
    }

    protected double getNumericValue(int cellIdx, Row row) {
        return row.getCell(cellIdx).getNumericCellValue();
    }

    public List<T> importToList() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new ByteArrayInputStream(file));
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<T> list = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();
        rows.next(); //skip header
        while (rows.hasNext()) {
            Row row = rows.next();
            list.add(buildData(row));
        }
        return list;
    }
}
