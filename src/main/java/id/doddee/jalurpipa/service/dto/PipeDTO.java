package id.doddee.jalurpipa.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link id.doddee.jalurpipa.domain.Pipe} entity.
 */
public class PipeDTO implements Serializable {
    private Long id;

    private Long objectId;

    private Double yStartCoordinate;

    private Double xStartCoordinate;

    private Double yEndCoordinate;

    private Double xEndCoordinate;

    private String tagId;

    private String pipeName;

    private String description;

    private Integer diameter;

    private String diameterUn;

    private String material;

    private String operationType;

    private Integer constructionYear;

    private Integer p1Length;

    private Integer actualLength;

    private String comparisonStandard;

    private Integer lokClass;

    private String pipeMaterial;

    private String penTools;

    private String row;

    private String maopDp;

    private String maxTemperature;

    private String ploNumber;

    private String coiNumber;

    private String raPipe;

    private LocalDate inspection;

    private LocalDate expired;

    private LocalDate modified;

    private String ploDocument;

    private String ploReport;

    private String coiDocument;

    private String raDocument;

    @Lob
    private byte[] file;

    private String fileContentType;

    private Long areaId;

    private String areaName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Double getyStartCoordinate() {
        return yStartCoordinate;
    }

    public void setyStartCoordinate(Double yStartCoordinate) {
        this.yStartCoordinate = yStartCoordinate;
    }

    public Double getxStartCoordinate() {
        return xStartCoordinate;
    }

    public void setxStartCoordinate(Double xStartCoordinate) {
        this.xStartCoordinate = xStartCoordinate;
    }

    public Double getyEndCoordinate() {
        return yEndCoordinate;
    }

    public void setyEndCoordinate(Double yEndCoordinate) {
        this.yEndCoordinate = yEndCoordinate;
    }

    public Double getxEndCoordinate() {
        return xEndCoordinate;
    }

    public void setxEndCoordinate(Double xEndCoordinate) {
        this.xEndCoordinate = xEndCoordinate;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getPipeName() {
        return pipeName;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getDiameterUn() {
        return diameterUn;
    }

    public void setDiameterUn(String diameterUn) {
        this.diameterUn = diameterUn;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Integer getp1Length() {
        return p1Length;
    }

    public void setp1Length(Integer p1Length) {
        this.p1Length = p1Length;
    }

    public Integer getActualLength() {
        return actualLength;
    }

    public void setActualLength(Integer actualLength) {
        this.actualLength = actualLength;
    }

    public String getComparisonStandard() {
        return comparisonStandard;
    }

    public void setComparisonStandard(String comparisonStandard) {
        this.comparisonStandard = comparisonStandard;
    }

    public Integer getLokClass() {
        return lokClass;
    }

    public void setLokClass(Integer lokClass) {
        this.lokClass = lokClass;
    }

    public String getPipeMaterial() {
        return pipeMaterial;
    }

    public void setPipeMaterial(String pipeMaterial) {
        this.pipeMaterial = pipeMaterial;
    }

    public String getPenTools() {
        return penTools;
    }

    public void setPenTools(String penTools) {
        this.penTools = penTools;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getMaopDp() {
        return maopDp;
    }

    public void setMaopDp(String maopDp) {
        this.maopDp = maopDp;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getPloNumber() {
        return ploNumber;
    }

    public void setPloNumber(String ploNumber) {
        this.ploNumber = ploNumber;
    }

    public String getCoiNumber() {
        return coiNumber;
    }

    public void setCoiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
    }

    public String getRaPipe() {
        return raPipe;
    }

    public void setRaPipe(String raPipe) {
        this.raPipe = raPipe;
    }

    public LocalDate getInspection() {
        return inspection;
    }

    public void setInspection(LocalDate inspection) {
        this.inspection = inspection;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public String getPloDocument() {
        return ploDocument;
    }

    public void setPloDocument(String ploDocument) {
        this.ploDocument = ploDocument;
    }

    public String getPloReport() {
        return ploReport;
    }

    public void setPloReport(String ploReport) {
        this.ploReport = ploReport;
    }

    public String getCoiDocument() {
        return coiDocument;
    }

    public void setCoiDocument(String coiDocument) {
        this.coiDocument = coiDocument;
    }

    public String getRaDocument() {
        return raDocument;
    }

    public void setRaDocument(String raDocument) {
        this.raDocument = raDocument;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PipeDTO)) {
            return false;
        }

        return id != null && id.equals(((PipeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PipeDTO{" +
            "id=" + getId() +
            ", objectId=" + getObjectId() +
            ", yStartCoordinate=" + getyStartCoordinate() +
            ", xStartCoordinate=" + getxStartCoordinate() +
            ", yEndCoordinate=" + getyEndCoordinate() +
            ", xEndCoordinate=" + getxEndCoordinate() +
            ", tagId='" + getTagId() + "'" +
            ", pipeName='" + getPipeName() + "'" +
            ", description='" + getDescription() + "'" +
            ", diameter=" + getDiameter() +
            ", diameterUn='" + getDiameterUn() + "'" +
            ", material='" + getMaterial() + "'" +
            ", operationType='" + getOperationType() + "'" +
            ", constructionYear=" + getConstructionYear() +
            ", p1Length=" + getp1Length() +
            ", actualLength=" + getActualLength() +
            ", comparisonStandard='" + getComparisonStandard() + "'" +
            ", lokClass=" + getLokClass() +
            ", pipeMaterial='" + getPipeMaterial() + "'" +
            ", penTools='" + getPenTools() + "'" +
            ", row='" + getRow() + "'" +
            ", maopDp='" + getMaopDp() + "'" +
            ", maxTemperature='" + getMaxTemperature() + "'" +
            ", ploNumber='" + getPloNumber() + "'" +
            ", coiNumber='" + getCoiNumber() + "'" +
            ", raPipe='" + getRaPipe() + "'" +
            ", inspection='" + getInspection() + "'" +
            ", expired='" + getExpired() + "'" +
            ", modified='" + getModified() + "'" +
            ", ploDocument='" + getPloDocument() + "'" +
            ", ploReport='" + getPloReport() + "'" +
            ", coiDocument='" + getCoiDocument() + "'" +
            ", raDocument='" + getRaDocument() + "'" +
            ", file='" + getFile() + "'" +
            ", areaId=" + getAreaId() +
            ", areaName='" + getAreaName() + "'" +
            "}";
    }
}
