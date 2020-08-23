package id.doddee.jalurpipa.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Lob;

/**
 * A DTO for the {@link id.doddee.jalurpipa.domain.Customer} entity.
 */
public class CustomerDTO implements Serializable {
    private Long id;

    private Long objectId;

    private Double yCoordinate;

    private Double xCoordinate;

    private String refId;

    private String tagId;

    private String name;

    private String pipeName;

    private Integer yearInstalled;

    private String owner;

    private String stationType;

    private Integer lineStream;

    private String customerType;

    private String identification;

    private String equipment;

    private String type;

    private String manuMeter;

    private String manuFilter;

    private String manuEngine;

    private String codeStand;

    private String fluida;

    private String flowRate;

    private String pressureIn;

    private String pressureOut;

    private String temperature;

    private String basePressure;

    private String baseTemperature;

    private LocalDate inspection;

    private LocalDate expired;

    private String coiNumber;

    private String coiDoc;

    private String coiReport;

    private String reEngRla;

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

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPipeName() {
        return pipeName;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public Integer getYearInstalled() {
        return yearInstalled;
    }

    public void setYearInstalled(Integer yearInstalled) {
        this.yearInstalled = yearInstalled;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public Integer getLineStream() {
        return lineStream;
    }

    public void setLineStream(Integer lineStream) {
        this.lineStream = lineStream;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManuMeter() {
        return manuMeter;
    }

    public void setManuMeter(String manuMeter) {
        this.manuMeter = manuMeter;
    }

    public String getManuFilter() {
        return manuFilter;
    }

    public void setManuFilter(String manuFilter) {
        this.manuFilter = manuFilter;
    }

    public String getManuEngine() {
        return manuEngine;
    }

    public void setManuEngine(String manuEngine) {
        this.manuEngine = manuEngine;
    }

    public String getCodeStand() {
        return codeStand;
    }

    public void setCodeStand(String codeStand) {
        this.codeStand = codeStand;
    }

    public String getFluida() {
        return fluida;
    }

    public void setFluida(String fluida) {
        this.fluida = fluida;
    }

    public String getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(String flowRate) {
        this.flowRate = flowRate;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public String getPressureOut() {
        return pressureOut;
    }

    public void setPressureOut(String pressureOut) {
        this.pressureOut = pressureOut;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBasePressure() {
        return basePressure;
    }

    public void setBasePressure(String basePressure) {
        this.basePressure = basePressure;
    }

    public String getBaseTemperature() {
        return baseTemperature;
    }

    public void setBaseTemperature(String baseTemperature) {
        this.baseTemperature = baseTemperature;
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

    public String getCoiNumber() {
        return coiNumber;
    }

    public void setCoiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
    }

    public String getCoiDoc() {
        return coiDoc;
    }

    public void setCoiDoc(String coiDoc) {
        this.coiDoc = coiDoc;
    }

    public String getCoiReport() {
        return coiReport;
    }

    public void setCoiReport(String coiReport) {
        this.coiReport = coiReport;
    }

    public String getReEngRla() {
        return reEngRla;
    }

    public void setReEngRla(String reEngRla) {
        this.reEngRla = reEngRla;
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
        if (!(o instanceof CustomerDTO)) {
            return false;
        }

        return id != null && id.equals(((CustomerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
            "id=" + getId() +
            ", objectId=" + getObjectId() +
            ", yCoordinate=" + getyCoordinate() +
            ", xCoordinate=" + getxCoordinate() +
            ", refId='" + getRefId() + "'" +
            ", tagId='" + getTagId() + "'" +
            ", name='" + getName() + "'" +
            ", pipeName='" + getPipeName() + "'" +
            ", yearInstalled=" + getYearInstalled() +
            ", owner='" + getOwner() + "'" +
            ", stationType='" + getStationType() + "'" +
            ", lineStream=" + getLineStream() +
            ", customerType='" + getCustomerType() + "'" +
            ", identification='" + getIdentification() + "'" +
            ", equipment='" + getEquipment() + "'" +
            ", type='" + getType() + "'" +
            ", manuMeter='" + getManuMeter() + "'" +
            ", manuFilter='" + getManuFilter() + "'" +
            ", manuEngine='" + getManuEngine() + "'" +
            ", codeStand='" + getCodeStand() + "'" +
            ", fluida='" + getFluida() + "'" +
            ", flowRate='" + getFlowRate() + "'" +
            ", pressureIn='" + getPressureIn() + "'" +
            ", pressureOut='" + getPressureOut() + "'" +
            ", temperature='" + getTemperature() + "'" +
            ", basePressure='" + getBasePressure() + "'" +
            ", baseTemperature='" + getBaseTemperature() + "'" +
            ", inspection='" + getInspection() + "'" +
            ", expired='" + getExpired() + "'" +
            ", coiNumber='" + getCoiNumber() + "'" +
            ", coiDoc='" + getCoiDoc() + "'" +
            ", coiReport='" + getCoiReport() + "'" +
            ", reEngRla='" + getReEngRla() + "'" +
            ", file='" + getFile() + "'" +
            ", areaId=" + getAreaId() +
            ", areaName='" + getAreaName() + "'" +
            "}";
    }
}
