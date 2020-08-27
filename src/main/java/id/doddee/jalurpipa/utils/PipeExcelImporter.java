package id.doddee.jalurpipa.utils;

import static id.doddee.jalurpipa.utils.CommonHelper.dateToLocalDate;
import static id.doddee.jalurpipa.utils.CommonHelper.doubleToInteger;
import static id.doddee.jalurpipa.utils.CommonHelper.doubleToLong;

import id.doddee.jalurpipa.domain.Pipe;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Row;

public class PipeExcelImporter extends ExcelImporter<Pipe> {

    public PipeExcelImporter(byte[] file) {
        super(file);
    }

    @Override
    Pipe buildData(Row row) {
        AtomicInteger cellIdx = new AtomicInteger();
        return new Pipe()
            .objectId(doubleToLong(getNumericValue(cellIdx.getAndIncrement(), row)))
            .yStartCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .xStartCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .yEndCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .xEndCoordinate(getNumericValue(cellIdx.getAndIncrement(), row))
            .tagId(getCellValue(cellIdx.getAndIncrement(), row))
            .pipeName(getCellValue(cellIdx.getAndIncrement(), row))
            .description(getCellValue(cellIdx.getAndIncrement(), row))
            .diameter(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .diameterUn(getCellValue(cellIdx.getAndIncrement(), row))
            .material(getCellValue(cellIdx.getAndIncrement(), row))
            .operationType(getCellValue(cellIdx.getAndIncrement(), row))
            .constructionYear(Integer.parseInt(getCellValue(cellIdx.getAndIncrement(), row)))
            .p1Length(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .actualLength(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .comparisonStandard(getCellValue(cellIdx.getAndIncrement(), row))
            .lokClass(doubleToInteger(getNumericValue(cellIdx.getAndIncrement(), row)))
            .pipeMaterial(getCellValue(cellIdx.getAndIncrement(), row))
            .penTools(getCellValue(cellIdx.getAndIncrement(), row))
            .row(getCellValue(cellIdx.getAndIncrement(), row))
            .maopDp(getCellValue(cellIdx.getAndIncrement(), row))
            .maxTemperature(getCellValue(cellIdx.getAndIncrement(), row))
            .ploNumber(getCellValue(cellIdx.getAndIncrement(), row))
            .coiNumber(getCellValue(cellIdx.getAndIncrement(), row))
            .raPipe(getCellValue(cellIdx.getAndIncrement(), row))
            .inspection(dateToLocalDate(getDateValue(cellIdx.getAndIncrement(), row)))
            .expired(dateToLocalDate(getDateValue(cellIdx.getAndIncrement(), row)))
            .modified(dateToLocalDate(getDateValue(cellIdx.getAndIncrement(), row)))
            .ploDocument(getCellValue(cellIdx.getAndIncrement(), row))
            .ploReport(getCellValue(cellIdx.getAndIncrement(), row))
            .coiDocument(getCellValue(cellIdx.getAndIncrement(), row))
            .raDocument(getCellValue(cellIdx.getAndIncrement(), row));
    }
}
