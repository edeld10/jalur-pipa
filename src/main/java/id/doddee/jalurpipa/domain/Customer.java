package id.doddee.jalurpipa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "y_coordinate")
    private Double yCoordinate;

    @Column(name = "x_coordinate")
    private Double xCoordinate;

    @Column(name = "ref_id")
    private String refId;

    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "name")
    private String name;

    @Column(name = "pipe_name")
    private String pipeName;

    @Column(name = "year_installed")
    private Integer yearInstalled;

    @Column(name = "owner")
    private String owner;

    @Column(name = "station_type")
    private String stationType;

    @Column(name = "line_stream")
    private Integer lineStream;

    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "identification")
    private String identification;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "type")
    private String type;

    @Column(name = "manu_meter")
    private String manuMeter;

    @Column(name = "manu_filter")
    private String manuFilter;

    @Column(name = "manu_engine")
    private String manuEngine;

    @Column(name = "code_stand")
    private String codeStand;

    @Column(name = "fluida")
    private String fluida;

    @Column(name = "flow_rate")
    private String flowRate;

    @Column(name = "pressure_in")
    private String pressureIn;

    @Column(name = "pressure_out")
    private String pressureOut;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "base_pressure")
    private String basePressure;

    @Column(name = "base_temperature")
    private String baseTemperature;

    @Column(name = "inspection")
    private LocalDate inspection;

    @Column(name = "expired")
    private LocalDate expired;

    @Column(name = "coi_number")
    private String coiNumber;

    @Column(name = "coi_doc")
    private String coiDoc;

    @Column(name = "coi_report")
    private String coiReport;

    @Column(name = "re_eng_rla")
    private String reEngRla;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type", nullable = false)
    private String fileContentType;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "customers", allowSetters = true)
    private Area area;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public Customer objectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public Customer yCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
        return this;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public Customer xCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
        return this;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getRefId() {
        return refId;
    }

    public Customer refId(String refId) {
        this.refId = refId;
        return this;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTagId() {
        return tagId;
    }

    public Customer tagId(String tagId) {
        this.tagId = tagId;
        return this;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPipeName() {
        return pipeName;
    }

    public Customer pipeName(String pipeName) {
        this.pipeName = pipeName;
        return this;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public Integer getYearInstalled() {
        return yearInstalled;
    }

    public Customer yearInstalled(Integer yearInstalled) {
        this.yearInstalled = yearInstalled;
        return this;
    }

    public void setYearInstalled(Integer yearInstalled) {
        this.yearInstalled = yearInstalled;
    }

    public String getOwner() {
        return owner;
    }

    public Customer owner(String owner) {
        this.owner = owner;
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStationType() {
        return stationType;
    }

    public Customer stationType(String stationType) {
        this.stationType = stationType;
        return this;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public Integer getLineStream() {
        return lineStream;
    }

    public Customer lineStream(Integer lineStream) {
        this.lineStream = lineStream;
        return this;
    }

    public void setLineStream(Integer lineStream) {
        this.lineStream = lineStream;
    }

    public String getCustomerType() {
        return customerType;
    }

    public Customer customerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getIdentification() {
        return identification;
    }

    public Customer identification(String identification) {
        this.identification = identification;
        return this;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEquipment() {
        return equipment;
    }

    public Customer equipment(String equipment) {
        this.equipment = equipment;
        return this;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getType() {
        return type;
    }

    public Customer type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManuMeter() {
        return manuMeter;
    }

    public Customer manuMeter(String manuMeter) {
        this.manuMeter = manuMeter;
        return this;
    }

    public void setManuMeter(String manuMeter) {
        this.manuMeter = manuMeter;
    }

    public String getManuFilter() {
        return manuFilter;
    }

    public Customer manuFilter(String manuFilter) {
        this.manuFilter = manuFilter;
        return this;
    }

    public void setManuFilter(String manuFilter) {
        this.manuFilter = manuFilter;
    }

    public String getManuEngine() {
        return manuEngine;
    }

    public Customer manuEngine(String manuEngine) {
        this.manuEngine = manuEngine;
        return this;
    }

    public void setManuEngine(String manuEngine) {
        this.manuEngine = manuEngine;
    }

    public String getCodeStand() {
        return codeStand;
    }

    public Customer codeStand(String codeStand) {
        this.codeStand = codeStand;
        return this;
    }

    public void setCodeStand(String codeStand) {
        this.codeStand = codeStand;
    }

    public String getFluida() {
        return fluida;
    }

    public Customer fluida(String fluida) {
        this.fluida = fluida;
        return this;
    }

    public void setFluida(String fluida) {
        this.fluida = fluida;
    }

    public String getFlowRate() {
        return flowRate;
    }

    public Customer flowRate(String flowRate) {
        this.flowRate = flowRate;
        return this;
    }

    public void setFlowRate(String flowRate) {
        this.flowRate = flowRate;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public Customer pressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
        return this;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public String getPressureOut() {
        return pressureOut;
    }

    public Customer pressureOut(String pressureOut) {
        this.pressureOut = pressureOut;
        return this;
    }

    public void setPressureOut(String pressureOut) {
        this.pressureOut = pressureOut;
    }

    public String getTemperature() {
        return temperature;
    }

    public Customer temperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBasePressure() {
        return basePressure;
    }

    public Customer basePressure(String basePressure) {
        this.basePressure = basePressure;
        return this;
    }

    public void setBasePressure(String basePressure) {
        this.basePressure = basePressure;
    }

    public String getBaseTemperature() {
        return baseTemperature;
    }

    public Customer baseTemperature(String baseTemperature) {
        this.baseTemperature = baseTemperature;
        return this;
    }

    public void setBaseTemperature(String baseTemperature) {
        this.baseTemperature = baseTemperature;
    }

    public LocalDate getInspection() {
        return inspection;
    }

    public Customer inspection(LocalDate inspection) {
        this.inspection = inspection;
        return this;
    }

    public void setInspection(LocalDate inspection) {
        this.inspection = inspection;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public Customer expired(LocalDate expired) {
        this.expired = expired;
        return this;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public String getCoiNumber() {
        return coiNumber;
    }

    public Customer coiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
        return this;
    }

    public void setCoiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
    }

    public String getCoiDoc() {
        return coiDoc;
    }

    public Customer coiDoc(String coiDoc) {
        this.coiDoc = coiDoc;
        return this;
    }

    public void setCoiDoc(String coiDoc) {
        this.coiDoc = coiDoc;
    }

    public String getCoiReport() {
        return coiReport;
    }

    public Customer coiReport(String coiReport) {
        this.coiReport = coiReport;
        return this;
    }

    public void setCoiReport(String coiReport) {
        this.coiReport = coiReport;
    }

    public String getReEngRla() {
        return reEngRla;
    }

    public Customer reEngRla(String reEngRla) {
        this.reEngRla = reEngRla;
        return this;
    }

    public void setReEngRla(String reEngRla) {
        this.reEngRla = reEngRla;
    }

    public byte[] getFile() {
        return file;
    }

    public Customer file(byte[] file) {
        this.file = file;
        return this;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public Customer fileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
        return this;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public Area getArea() {
        return area;
    }

    public Customer area(Area area) {
        this.area = area;
        return this;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
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
            ", fileContentType='" + getFileContentType() + "'" +
            "}";
    }
}
