package id.doddee.jalurpipa.utils;

import id.doddee.jalurpipa.domain.Customer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Row;

public class CustomerExcelExporter extends ExcelExporter<Customer> {

    public CustomerExcelExporter(String sheetName, List<String> headers, List<Customer> data) {
        super(sheetName, headers, data);
    }

    @Override
    void buildExcel() {
        AtomicInteger rowIdx = new AtomicInteger(1);
        AtomicInteger cellIdx = new AtomicInteger();
        data.forEach(
            customer -> {
                Row row = createRow(rowIdx.getAndIncrement());
                createCell(cellIdx.getAndIncrement(), customer.getObjectId().toString(), row);
                createCell(cellIdx.getAndIncrement(), customer.getyCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), customer.getxCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), customer.getRefId(), row);
                createCell(cellIdx.getAndIncrement(), customer.getTagId(), row);
                createCell(cellIdx.getAndIncrement(), customer.getName(), row);
                createCell(cellIdx.getAndIncrement(), customer.getPipeName(), row);
                createCell(cellIdx.getAndIncrement(), customer.getYearInstalled().toString(), row);
                createCell(cellIdx.getAndIncrement(), customer.getOwner(), row);
                createCell(cellIdx.getAndIncrement(), customer.getStationType(), row);
                createCell(cellIdx.getAndIncrement(), customer.getLineStream().toString(), row);
                createCell(cellIdx.getAndIncrement(), customer.getCustomerType(), row);
                createCell(cellIdx.getAndIncrement(), customer.getIdentification(), row);
                createCell(cellIdx.getAndIncrement(), customer.getEquipment(), row);
                createCell(cellIdx.getAndIncrement(), customer.getType(), row);
                createCell(cellIdx.getAndIncrement(), customer.getManuMeter(), row);
                createCell(cellIdx.getAndIncrement(), customer.getManuFilter(), row);
                createCell(cellIdx.getAndIncrement(), customer.getManuEngine(), row);
                createCell(cellIdx.getAndIncrement(), customer.getCodeStand(), row);
                createCell(cellIdx.getAndIncrement(), customer.getFluida(), row);
                createCell(cellIdx.getAndIncrement(), customer.getFlowRate(), row);
                createCell(cellIdx.getAndIncrement(), customer.getPressureIn(), row);
                createCell(cellIdx.getAndIncrement(), customer.getPressureOut(), row);
                createCell(cellIdx.getAndIncrement(), customer.getTemperature(), row);
                createCell(cellIdx.getAndIncrement(), customer.getBasePressure(), row);
                createCell(cellIdx.getAndIncrement(), customer.getBaseTemperature(), row);
                createCell(cellIdx.getAndIncrement(), toString(customer.getInspection()), row);
                createCell(cellIdx.getAndIncrement(), toString(customer.getExpired()), row);
                createCell(cellIdx.getAndIncrement(), customer.getCoiNumber(), row);
                createCell(cellIdx.getAndIncrement(), customer.getCoiDoc(), row);
                createCell(cellIdx.getAndIncrement(), customer.getCoiReport(), row);
                createCell(cellIdx.getAndIncrement(), customer.getReEngRla(), row);
            }
        );
    }

    private String toString(LocalDate localDate) {
        return DateHelper.dateToString(
            Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
            DateHelper.DATE_PATTERN
        );
    }
}
