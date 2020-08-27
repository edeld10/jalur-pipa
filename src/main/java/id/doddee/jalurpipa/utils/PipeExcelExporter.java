package id.doddee.jalurpipa.utils;

import id.doddee.jalurpipa.domain.Pipe;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Row;

public class PipeExcelExporter extends ExcelExporter<Pipe> {

    public PipeExcelExporter(String sheetName, List<String> headers, List<Pipe> data) {
        super(sheetName, headers, data);
    }

    @Override
    void buildExcel() {
        AtomicInteger rowIdx = new AtomicInteger(1);
        AtomicInteger cellIdx = new AtomicInteger();
        data.forEach(
            pipe -> {
                Row row = createRow(rowIdx.getAndIncrement());
                createCell(cellIdx.getAndIncrement(), pipe.getObjectId().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getyStartCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getxStartCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getyEndCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getxEndCoordinate().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getTagId(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPipeName(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getDescription(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getDiameter().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getDiameterUn(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getMaterial(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getOperationType(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getConstructionYear().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getp1Length().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getActualLength().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getComparisonStandard(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getLokClass().toString(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPipeMaterial(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPenTools(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getRow(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getMaopDp(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getMaxTemperature(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPloNumber(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getCoiNumber(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getRaPipe(), row);
                createCell(cellIdx.getAndIncrement(), toString(pipe.getInspection()), row);
                createCell(cellIdx.getAndIncrement(), toString(pipe.getExpired()), row);
                createCell(cellIdx.getAndIncrement(), toString(pipe.getModified()), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPloDocument(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getPloReport(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getCoiDocument(), row);
                createCell(cellIdx.getAndIncrement(), pipe.getRaDocument(), row);
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
