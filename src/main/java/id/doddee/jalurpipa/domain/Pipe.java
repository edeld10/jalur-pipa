package id.doddee.jalurpipa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Pipe.
 */
@Entity
@Table(name = "pipe")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Pipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "y_start_coordinate")
    private Double yStartCoordinate;

    @Column(name = "x_start_coordinate")
    private Double xStartCoordinate;

    @Column(name = "y_end_coordinate")
    private Double yEndCoordinate;

    @Column(name = "x_end_coordinate")
    private Double xEndCoordinate;

    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "pipe_name")
    private String pipeName;

    @Column(name = "description")
    private String description;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "diameter_un")
    private String diameterUn;

    @Column(name = "material")
    private String material;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "construction_year")
    private Integer constructionYear;

    @Column(name = "p_1_length")
    private Integer p1Length;

    @Column(name = "actual_length")
    private Integer actualLength;

    @Column(name = "comparison_standard")
    private String comparisonStandard;

    @Column(name = "lok_class")
    private Integer lokClass;

    @Column(name = "pipe_material")
    private String pipeMaterial;

    @Column(name = "pen_tools")
    private String penTools;

    @Column(name = "row")
    private String row;

    @Column(name = "maop_dp")
    private String maopDp;

    @Column(name = "max_temperature")
    private String maxTemperature;

    @Column(name = "plo_number")
    private String ploNumber;

    @Column(name = "coi_number")
    private String coiNumber;

    @Column(name = "ra_pipe")
    private String raPipe;

    @Column(name = "inspection")
    private LocalDate inspection;

    @Column(name = "expired")
    private LocalDate expired;

    @Column(name = "modified")
    private LocalDate modified;

    @Column(name = "plo_document")
    private String ploDocument;

    @Column(name = "plo_report")
    private String ploReport;

    @Column(name = "coi_document")
    private String coiDocument;

    @Column(name = "ra_document")
    private String raDocument;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type", nullable = false)
    private String fileContentType;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "pipes", allowSetters = true)
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

    public Pipe objectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Double getyStartCoordinate() {
        return yStartCoordinate;
    }

    public Pipe yStartCoordinate(Double yStartCoordinate) {
        this.yStartCoordinate = yStartCoordinate;
        return this;
    }

    public void setyStartCoordinate(Double yStartCoordinate) {
        this.yStartCoordinate = yStartCoordinate;
    }

    public Double getxStartCoordinate() {
        return xStartCoordinate;
    }

    public Pipe xStartCoordinate(Double xStartCoordinate) {
        this.xStartCoordinate = xStartCoordinate;
        return this;
    }

    public void setxStartCoordinate(Double xStartCoordinate) {
        this.xStartCoordinate = xStartCoordinate;
    }

    public Double getyEndCoordinate() {
        return yEndCoordinate;
    }

    public Pipe yEndCoordinate(Double yEndCoordinate) {
        this.yEndCoordinate = yEndCoordinate;
        return this;
    }

    public void setyEndCoordinate(Double yEndCoordinate) {
        this.yEndCoordinate = yEndCoordinate;
    }

    public Double getxEndCoordinate() {
        return xEndCoordinate;
    }

    public Pipe xEndCoordinate(Double xEndCoordinate) {
        this.xEndCoordinate = xEndCoordinate;
        return this;
    }

    public void setxEndCoordinate(Double xEndCoordinate) {
        this.xEndCoordinate = xEndCoordinate;
    }

    public String getTagId() {
        return tagId;
    }

    public Pipe tagId(String tagId) {
        this.tagId = tagId;
        return this;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getPipeName() {
        return pipeName;
    }

    public Pipe pipeName(String pipeName) {
        this.pipeName = pipeName;
        return this;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public String getDescription() {
        return description;
    }

    public Pipe description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public Pipe diameter(Integer diameter) {
        this.diameter = diameter;
        return this;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getDiameterUn() {
        return diameterUn;
    }

    public Pipe diameterUn(String diameterUn) {
        this.diameterUn = diameterUn;
        return this;
    }

    public void setDiameterUn(String diameterUn) {
        this.diameterUn = diameterUn;
    }

    public String getMaterial() {
        return material;
    }

    public Pipe material(String material) {
        this.material = material;
        return this;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOperationType() {
        return operationType;
    }

    public Pipe operationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public Pipe constructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
        return this;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Integer getp1Length() {
        return p1Length;
    }

    public Pipe p1Length(Integer p1Length) {
        this.p1Length = p1Length;
        return this;
    }

    public void setp1Length(Integer p1Length) {
        this.p1Length = p1Length;
    }

    public Integer getActualLength() {
        return actualLength;
    }

    public Pipe actualLength(Integer actualLength) {
        this.actualLength = actualLength;
        return this;
    }

    public void setActualLength(Integer actualLength) {
        this.actualLength = actualLength;
    }

    public String getComparisonStandard() {
        return comparisonStandard;
    }

    public Pipe comparisonStandard(String comparisonStandard) {
        this.comparisonStandard = comparisonStandard;
        return this;
    }

    public void setComparisonStandard(String comparisonStandard) {
        this.comparisonStandard = comparisonStandard;
    }

    public Integer getLokClass() {
        return lokClass;
    }

    public Pipe lokClass(Integer lokClass) {
        this.lokClass = lokClass;
        return this;
    }

    public void setLokClass(Integer lokClass) {
        this.lokClass = lokClass;
    }

    public String getPipeMaterial() {
        return pipeMaterial;
    }

    public Pipe pipeMaterial(String pipeMaterial) {
        this.pipeMaterial = pipeMaterial;
        return this;
    }

    public void setPipeMaterial(String pipeMaterial) {
        this.pipeMaterial = pipeMaterial;
    }

    public String getPenTools() {
        return penTools;
    }

    public Pipe penTools(String penTools) {
        this.penTools = penTools;
        return this;
    }

    public void setPenTools(String penTools) {
        this.penTools = penTools;
    }

    public String getRow() {
        return row;
    }

    public Pipe row(String row) {
        this.row = row;
        return this;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getMaopDp() {
        return maopDp;
    }

    public Pipe maopDp(String maopDp) {
        this.maopDp = maopDp;
        return this;
    }

    public void setMaopDp(String maopDp) {
        this.maopDp = maopDp;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public Pipe maxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getPloNumber() {
        return ploNumber;
    }

    public Pipe ploNumber(String ploNumber) {
        this.ploNumber = ploNumber;
        return this;
    }

    public void setPloNumber(String ploNumber) {
        this.ploNumber = ploNumber;
    }

    public String getCoiNumber() {
        return coiNumber;
    }

    public Pipe coiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
        return this;
    }

    public void setCoiNumber(String coiNumber) {
        this.coiNumber = coiNumber;
    }

    public String getRaPipe() {
        return raPipe;
    }

    public Pipe raPipe(String raPipe) {
        this.raPipe = raPipe;
        return this;
    }

    public void setRaPipe(String raPipe) {
        this.raPipe = raPipe;
    }

    public LocalDate getInspection() {
        return inspection;
    }

    public Pipe inspection(LocalDate inspection) {
        this.inspection = inspection;
        return this;
    }

    public void setInspection(LocalDate inspection) {
        this.inspection = inspection;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public Pipe expired(LocalDate expired) {
        this.expired = expired;
        return this;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public LocalDate getModified() {
        return modified;
    }

    public Pipe modified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public String getPloDocument() {
        return ploDocument;
    }

    public Pipe ploDocument(String ploDocument) {
        this.ploDocument = ploDocument;
        return this;
    }

    public void setPloDocument(String ploDocument) {
        this.ploDocument = ploDocument;
    }

    public String getPloReport() {
        return ploReport;
    }

    public Pipe ploReport(String ploReport) {
        this.ploReport = ploReport;
        return this;
    }

    public void setPloReport(String ploReport) {
        this.ploReport = ploReport;
    }

    public String getCoiDocument() {
        return coiDocument;
    }

    public Pipe coiDocument(String coiDocument) {
        this.coiDocument = coiDocument;
        return this;
    }

    public void setCoiDocument(String coiDocument) {
        this.coiDocument = coiDocument;
    }

    public String getRaDocument() {
        return raDocument;
    }

    public Pipe raDocument(String raDocument) {
        this.raDocument = raDocument;
        return this;
    }

    public void setRaDocument(String raDocument) {
        this.raDocument = raDocument;
    }

    public byte[] getFile() {
        return file;
    }

    public Pipe file(byte[] file) {
        this.file = file;
        return this;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public Pipe fileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
        return this;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public Area getArea() {
        return area;
    }

    public Pipe area(Area area) {
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
        if (!(o instanceof Pipe)) {
            return false;
        }
        return id != null && id.equals(((Pipe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pipe{" +
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
            ", fileContentType='" + getFileContentType() + "'" +
            "}";
    }
}
