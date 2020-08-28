import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, setFileData, openFile, byteSize, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IArea } from 'app/shared/model/area.model';
import { getEntities as getAreas } from 'app/entities/area/area.reducer';
import { getEntity, updateEntity, createEntity, setBlob, reset } from './pipe.reducer';
import { IPipe } from 'app/shared/model/pipe.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IPipeUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const PipeUpdate = (props: IPipeUpdateProps) => {
  const [areaId, setAreaId] = useState('0');
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { pipeEntity, areas, loading, updating } = props;

  const { file, fileContentType } = pipeEntity;

  const handleClose = () => {
    props.history.push('/pipe' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }

    props.getAreas();
  }, []);

  const onBlobChange = (isAnImage, name) => event => {
    setFileData(event, (contentType, data) => props.setBlob(name, data, contentType), isAnImage);
  };

  const clearBlob = name => () => {
    props.setBlob(name, undefined, undefined);
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...pipeEntity,
        ...values,
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jalurpipaApp.pipe.home.createOrEditLabel">
            <Translate contentKey="jalurpipaApp.pipe.home.createOrEditLabel">Create or edit a Pipe</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : pipeEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="pipe-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="pipe-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              {
                !isNew &&
                <AvGroup>
                  <AvGroup>
                    <Label id="objectIdLabel" for="pipe-objectId">
                      <Translate contentKey="jalurpipaApp.pipe.objectId">Object Id</Translate>
                    </Label>
                    <AvField id="pipe-objectId" type="string" className="form-control" name="objectId" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="yStartCoordinateLabel" for="pipe-yStartCoordinate">
                      <Translate contentKey="jalurpipaApp.pipe.yStartCoordinate">Y Start Coordinate</Translate>
                    </Label>
                    <AvField id="pipe-yStartCoordinate" type="string" className="form-control" name="yStartCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="xStartCoordinateLabel" for="pipe-xStartCoordinate">
                      <Translate contentKey="jalurpipaApp.pipe.xStartCoordinate">X Start Coordinate</Translate>
                    </Label>
                    <AvField id="pipe-xStartCoordinate" type="string" className="form-control" name="xStartCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="yEndCoordinateLabel" for="pipe-yEndCoordinate">
                      <Translate contentKey="jalurpipaApp.pipe.yEndCoordinate">Y End Coordinate</Translate>
                    </Label>
                    <AvField id="pipe-yEndCoordinate" type="string" className="form-control" name="yEndCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="xEndCoordinateLabel" for="pipe-xEndCoordinate">
                      <Translate contentKey="jalurpipaApp.pipe.xEndCoordinate">X End Coordinate</Translate>
                    </Label>
                    <AvField id="pipe-xEndCoordinate" type="string" className="form-control" name="xEndCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="tagIdLabel" for="pipe-tagId">
                      <Translate contentKey="jalurpipaApp.pipe.tagId">Tag Id</Translate>
                    </Label>
                    <AvField id="pipe-tagId" type="text" name="tagId" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="pipeNameLabel" for="pipe-pipeName">
                      <Translate contentKey="jalurpipaApp.pipe.pipeName">Pipe Name</Translate>
                    </Label>
                    <AvField id="pipe-pipeName" type="text" name="pipeName" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="descriptionLabel" for="pipe-description">
                      <Translate contentKey="jalurpipaApp.pipe.description">Description</Translate>
                    </Label>
                    <AvField id="pipe-description" type="text" name="description" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="diameterLabel" for="pipe-diameter">
                      <Translate contentKey="jalurpipaApp.pipe.diameter">Diameter</Translate>
                    </Label>
                    <AvField id="pipe-diameter" type="string" className="form-control" name="diameter" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="diameterUnLabel" for="pipe-diameterUn">
                      <Translate contentKey="jalurpipaApp.pipe.diameterUn">Diameter Un</Translate>
                    </Label>
                    <AvField id="pipe-diameterUn" type="text" name="diameterUn" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="materialLabel" for="pipe-material">
                      <Translate contentKey="jalurpipaApp.pipe.material">Material</Translate>
                    </Label>
                    <AvField id="pipe-material" type="text" name="material" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="operationTypeLabel" for="pipe-operationType">
                      <Translate contentKey="jalurpipaApp.pipe.operationType">Operation Type</Translate>
                    </Label>
                    <AvField id="pipe-operationType" type="text" name="operationType" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="constructionYearLabel" for="pipe-constructionYear">
                      <Translate contentKey="jalurpipaApp.pipe.constructionYear">Construction Year</Translate>
                    </Label>
                    <AvField id="pipe-constructionYear" type="string" className="form-control" name="constructionYear" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="p1LengthLabel" for="pipe-p1Length">
                      <Translate contentKey="jalurpipaApp.pipe.p1Length">P 1 Length</Translate>
                    </Label>
                    <AvField id="pipe-p1Length" type="string" className="form-control" name="p1Length" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="actualLengthLabel" for="pipe-actualLength">
                      <Translate contentKey="jalurpipaApp.pipe.actualLength">Actual Length</Translate>
                    </Label>
                    <AvField id="pipe-actualLength" type="string" className="form-control" name="actualLength" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="comparisonStandardLabel" for="pipe-comparisonStandard">
                      <Translate contentKey="jalurpipaApp.pipe.comparisonStandard">Comparison Standard</Translate>
                    </Label>
                    <AvField id="pipe-comparisonStandard" type="text" name="comparisonStandard" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="lokClassLabel" for="pipe-lokClass">
                      <Translate contentKey="jalurpipaApp.pipe.lokClass">Lok Class</Translate>
                    </Label>
                    <AvField id="pipe-lokClass" type="string" className="form-control" name="lokClass" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="pipeMaterialLabel" for="pipe-pipeMaterial">
                      <Translate contentKey="jalurpipaApp.pipe.pipeMaterial">Pipe Material</Translate>
                    </Label>
                    <AvField id="pipe-pipeMaterial" type="text" name="pipeMaterial" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="penToolsLabel" for="pipe-penTools">
                      <Translate contentKey="jalurpipaApp.pipe.penTools">Pen Tools</Translate>
                    </Label>
                    <AvField id="pipe-penTools" type="text" name="penTools" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="rowLabel" for="pipe-row">
                      <Translate contentKey="jalurpipaApp.pipe.row">Row</Translate>
                    </Label>
                    <AvField id="pipe-row" type="text" name="row" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="maopDpLabel" for="pipe-maopDp">
                      <Translate contentKey="jalurpipaApp.pipe.maopDp">Maop Dp</Translate>
                    </Label>
                    <AvField id="pipe-maopDp" type="text" name="maopDp" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="maxTemperatureLabel" for="pipe-maxTemperature">
                      <Translate contentKey="jalurpipaApp.pipe.maxTemperature">Max Temperature</Translate>
                    </Label>
                    <AvField id="pipe-maxTemperature" type="text" name="maxTemperature" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="ploNumberLabel" for="pipe-ploNumber">
                      <Translate contentKey="jalurpipaApp.pipe.ploNumber">Plo Number</Translate>
                    </Label>
                    <AvField id="pipe-ploNumber" type="text" name="ploNumber" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="coiNumberLabel" for="pipe-coiNumber">
                      <Translate contentKey="jalurpipaApp.pipe.coiNumber">Coi Number</Translate>
                    </Label>
                    <AvField id="pipe-coiNumber" type="text" name="coiNumber" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="raPipeLabel" for="pipe-raPipe">
                      <Translate contentKey="jalurpipaApp.pipe.raPipe">Ra Pipe</Translate>
                    </Label>
                    <AvField id="pipe-raPipe" type="text" name="raPipe" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="inspectionLabel" for="pipe-inspection">
                      <Translate contentKey="jalurpipaApp.pipe.inspection">Inspection</Translate>
                    </Label>
                    <AvField id="pipe-inspection" type="date" className="form-control" name="inspection" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="expiredLabel" for="pipe-expired">
                      <Translate contentKey="jalurpipaApp.pipe.expired">Expired</Translate>
                    </Label>
                    <AvField id="pipe-expired" type="date" className="form-control" name="expired" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="modifiedLabel" for="pipe-modified">
                      <Translate contentKey="jalurpipaApp.pipe.modified">Modified</Translate>
                    </Label>
                    <AvField id="pipe-modified" type="date" className="form-control" name="modified" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="ploDocumentLabel" for="pipe-ploDocument">
                      <Translate contentKey="jalurpipaApp.pipe.ploDocument">Plo Document</Translate>
                    </Label>
                    <AvField id="pipe-ploDocument" type="text" name="ploDocument" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="ploReportLabel" for="pipe-ploReport">
                      <Translate contentKey="jalurpipaApp.pipe.ploReport">Plo Report</Translate>
                    </Label>
                    <AvField id="pipe-ploReport" type="text" name="ploReport" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="coiDocumentLabel" for="pipe-coiDocument">
                      <Translate contentKey="jalurpipaApp.pipe.coiDocument">Coi Document</Translate>
                    </Label>
                    <AvField id="pipe-coiDocument" type="text" name="coiDocument" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="raDocumentLabel" for="pipe-raDocument">
                      <Translate contentKey="jalurpipaApp.pipe.raDocument">Ra Document</Translate>
                    </Label>
                    <AvField id="pipe-raDocument" type="text" name="raDocument" />
                  </AvGroup>
                </AvGroup>
              }
              {
                isNew &&
                <AvGroup>
                  <AvGroup>
                    <Label id="fileLabel" for="file">
                      <Translate contentKey="jalurpipaApp.pipe.file">File</Translate>
                    </Label>
                    <br />
                    {file ? (
                      <div>
                        {fileContentType ? (
                          <a onClick={openFile(fileContentType, file)}>
                            <Translate contentKey="entity.action.open">Open</Translate>
                          </a>
                        ) : null}
                        <br />
                        <Row>
                          <Col md="11">
                          <span>
                            {fileContentType}, {byteSize(file)}
                          </span>
                          </Col>
                          <Col md="1">
                            <Button color="danger" onClick={clearBlob('file')}>
                              <FontAwesomeIcon icon="times-circle" />
                            </Button>
                          </Col>
                        </Row>
                      </div>
                    ) : null}
                    <input id="file_file" type="file" onChange={onBlobChange(false, 'file')} />
                    <AvInput
                      type="hidden"
                      name="file"
                      value={file}
                      validate={{
                        required: { value: true, errorMessage: translate('entity.validation.required') },
                      }}
                    />
                  </AvGroup>
                </AvGroup>
              }
              <AvGroup>
                <Label for="pipe-area">
                  <Translate contentKey="jalurpipaApp.pipe.area">Area</Translate>
                </Label>
                <AvInput id="pipe-area" type="select" className="form-control" name="areaId" required>
                  <option value="" key="0" />
                  {areas
                    ? areas.map(otherEntity => (
                        <option value={otherEntity.id} key={otherEntity.id}>
                          {otherEntity.name}
                        </option>
                      ))
                    : null}
                </AvInput>
                <AvFeedback>
                  <Translate contentKey="entity.validation.required">This field is required.</Translate>
                </AvFeedback>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/pipe" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  areas: storeState.area.entities,
  pipeEntity: storeState.pipe.entity,
  loading: storeState.pipe.loading,
  updating: storeState.pipe.updating,
  updateSuccess: storeState.pipe.updateSuccess,
});

const mapDispatchToProps = {
  getAreas,
  getEntity,
  updateEntity,
  setBlob,
  createEntity,
  reset,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(PipeUpdate);
