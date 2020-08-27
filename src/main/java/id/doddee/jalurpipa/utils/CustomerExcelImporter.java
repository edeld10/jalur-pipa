package id.doddee.jalurpipa.utils;

import static id.doddee.jalurpipa.utils.CommonHelper.doubleToInteger;
import static id.doddee.jalurpipa.utils.CommonHelper.doubleToLong;
import static id.doddee.jalurpipa.utils.CommonHelper.stringToLocalDate;

import id.doddee.jalurpipa.domain.Customer;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Row;

public class CustomerExcelImporter extends ExcelImporter<Customer> {

    public CustomerExcelImporter(byte[] file) {
        super(file);
    }

    @Override
    Customer buildData(Row row) {
        AtomicInteger cellIdx = new AtomicInteger();
        return new Customer()
            .objectId(doubleToLong(getNumericValue(cellIdx.getAndIncrement(), row)))
            .yCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .xCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .refId(getCellValue(cellIdx.getAndIncrement(), row))
            .tagId(getCellValue(cellIdx.getAndIncrement(), row))
            .name(getCellValue(cellIdx.getAndIncrement(), row))
            .pipeName(getCellValue(cellIdx.getAndIncrement(), row))
            .yearInstalled(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .owner(getCellValue(cellIdx.getAndIncrement(), row))
            .stationType(getCellValue(cellIdx.getAndIncrement(), row))
            .lineStream(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .customerType(getCellValue(cellIdx.getAndIncrement(), row))
            .identification(getCellValue(cellIdx.getAndIncrement(), row))
            .equipment(getCellValue(cellIdx.getAndIncrement(), row))
            .type(getCellValue(cellIdx.getAndIncrement(), row))
            .manuMeter(getCellValue(cellIdx.getAndIncrement(), row))
            .manuFilter(getCellValue(cellIdx.getAndIncrement(), row))
            .manuEngine(getCellValue(cellIdx.getAndIncrement(), row))
            .codeStand(getCellValue(cellIdx.getAndIncrement(), row))
            .fluida(getCellValue(cellIdx.getAndIncrement(), row))
            .flowRate(getCellValue(cellIdx.getAndIncrement(), row))
            .pressureIn(getCellValue(cellIdx.getAndIncrement(), row))
            .pressureOut(getCellValue(cellIdx.getAndIncrement(), row))
            .temperature(getCellValue(cellIdx.getAndIncrement(), row))
            .basePressure(getCellValue(cellIdx.getAndIncrement(), row))
            .baseTemperature(getCellValue(cellIdx.getAndIncrement(), row))
            .inspection(stringToLocalDate(getCellValue(cellIdx.getAndIncrement(), row), DateHelper.DATE_PATTERN))
            .expired(stringToLocalDate(getCellValue(cellIdx.getAndIncrement(), row), DateHelper.DATE_PATTERN))
            .coiNumber(getCellValue(cellIdx.getAndIncrement(), row))
            .coiDoc(getCellValue(cellIdx.getAndIncrement(), row))
            .coiReport(getCellValue(cellIdx.getAndIncrement(), row))
            .reEngRla(getCellValue(cellIdx.getAndIncrement(), row));
    }
}
