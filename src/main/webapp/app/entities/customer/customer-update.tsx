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
import { getEntity, updateEntity, createEntity, setBlob, reset } from './customer.reducer';
import { ICustomer } from 'app/shared/model/customer.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ICustomerUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CustomerUpdate = (props: ICustomerUpdateProps) => {
  const [areaId, setAreaId] = useState('0');
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { customerEntity, areas, loading, updating } = props;

  const { file, fileContentType } = customerEntity;

  const handleClose = () => {
    props.history.push('/customer' + props.location.search);
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
        ...customerEntity,
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
          <h2 id="jalurpipaApp.customer.home.createOrEditLabel">
            <Translate contentKey="jalurpipaApp.customer.home.createOrEditLabel">Create or edit a Customer</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : customerEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="customer-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="customer-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              {
                !isNew &&
                <AvGroup>
                  <AvGroup>
                    <Label id="objectIdLabel" for="customer-objectId">
                      <Translate contentKey="jalurpipaApp.customer.objectId">Object Id</Translate>
                    </Label>
                    <AvField id="customer-objectId" type="string" className="form-control" name="objectId" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="yCoordinateLabel" for="customer-yCoordinate">
                      <Translate contentKey="jalurpipaApp.customer.yCoordinate">Y Coordinate</Translate>
                    </Label>
                    <AvField id="customer-yCoordinate" type="string" className="form-control" name="yCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="xCoordinateLabel" for="customer-xCoordinate">
                      <Translate contentKey="jalurpipaApp.customer.xCoordinate">X Coordinate</Translate>
                    </Label>
                    <AvField id="customer-xCoordinate" type="string" className="form-control" name="xCoordinate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="refIdLabel" for="customer-refId">
                      <Translate contentKey="jalurpipaApp.customer.refId">Ref Id</Translate>
                    </Label>
                    <AvField id="customer-refId" type="text" name="refId" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="tagIdLabel" for="customer-tagId">
                      <Translate contentKey="jalurpipaApp.customer.tagId">Tag Id</Translate>
                    </Label>
                    <AvField id="customer-tagId" type="text" name="tagId" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="nameLabel" for="customer-name">
                      <Translate contentKey="jalurpipaApp.customer.name">Name</Translate>
                    </Label>
                    <AvField id="customer-name" type="text" name="name" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="pipeNameLabel" for="customer-pipeName">
                      <Translate contentKey="jalurpipaApp.customer.pipeName">Pipe Name</Translate>
                    </Label>
                    <AvField id="customer-pipeName" type="text" name="pipeName" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="yearInstalledLabel" for="customer-yearInstalled">
                      <Translate contentKey="jalurpipaApp.customer.yearInstalled">Year Installed</Translate>
                    </Label>
                    <AvField id="customer-yearInstalled" type="string" className="form-control" name="yearInstalled" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="ownerLabel" for="customer-owner">
                      <Translate contentKey="jalurpipaApp.customer.owner">Owner</Translate>
                    </Label>
                    <AvField id="customer-owner" type="text" name="owner" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="stationTypeLabel" for="customer-stationType">
                      <Translate contentKey="jalurpipaApp.customer.stationType">Station Type</Translate>
                    </Label>
                    <AvField id="customer-stationType" type="text" name="stationType" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="lineStreamLabel" for="customer-lineStream">
                      <Translate contentKey="jalurpipaApp.customer.lineStream">Line Stream</Translate>
                    </Label>
                    <AvField id="customer-lineStream" type="string" className="form-control" name="lineStream" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="customerTypeLabel" for="customer-customerType">
                      <Translate contentKey="jalurpipaApp.customer.customerType">Customer Type</Translate>
                    </Label>
                    <AvField id="customer-customerType" type="text" name="customerType" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="identificationLabel" for="customer-identification">
                      <Translate contentKey="jalurpipaApp.customer.identification">Identification</Translate>
                    </Label>
                    <AvField id="customer-identification" type="text" name="identification" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="equipmentLabel" for="customer-equipment">
                      <Translate contentKey="jalurpipaApp.customer.equipment">Equipment</Translate>
                    </Label>
                    <AvField id="customer-equipment" type="text" name="equipment" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="typeLabel" for="customer-type">
                      <Translate contentKey="jalurpipaApp.customer.type">Type</Translate>
                    </Label>
                    <AvField id="customer-type" type="text" name="type" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="manuMeterLabel" for="customer-manuMeter">
                      <Translate contentKey="jalurpipaApp.customer.manuMeter">Manu Meter</Translate>
                    </Label>
                    <AvField id="customer-manuMeter" type="text" name="manuMeter" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="manuFilterLabel" for="customer-manuFilter">
                      <Translate contentKey="jalurpipaApp.customer.manuFilter">Manu Filter</Translate>
                    </Label>
                    <AvField id="customer-manuFilter" type="text" name="manuFilter" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="manuEngineLabel" for="customer-manuEngine">
                      <Translate contentKey="jalurpipaApp.customer.manuEngine">Manu Engine</Translate>
                    </Label>
                    <AvField id="customer-manuEngine" type="text" name="manuEngine" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="codeStandLabel" for="customer-codeStand">
                      <Translate contentKey="jalurpipaApp.customer.codeStand">Code Stand</Translate>
                    </Label>
                    <AvField id="customer-codeStand" type="text" name="codeStand" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="fluidaLabel" for="customer-fluida">
                      <Translate contentKey="jalurpipaApp.customer.fluida">Fluida</Translate>
                    </Label>
                    <AvField id="customer-fluida" type="text" name="fluida" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="flowRateLabel" for="customer-flowRate">
                      <Translate contentKey="jalurpipaApp.customer.flowRate">Flow Rate</Translate>
                    </Label>
                    <AvField id="customer-flowRate" type="text" name="flowRate" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="pressureInLabel" for="customer-pressureIn">
                      <Translate contentKey="jalurpipaApp.customer.pressureIn">Pressure In</Translate>
                    </Label>
                    <AvField id="customer-pressureIn" type="text" name="pressureIn" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="pressureOutLabel" for="customer-pressureOut">
                      <Translate contentKey="jalurpipaApp.customer.pressureOut">Pressure Out</Translate>
                    </Label>
                    <AvField id="customer-pressureOut" type="text" name="pressureOut" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="temperatureLabel" for="customer-temperature">
                      <Translate contentKey="jalurpipaApp.customer.temperature">Temperature</Translate>
                    </Label>
                    <AvField id="customer-temperature" type="text" name="temperature" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="basePressureLabel" for="customer-basePressure">
                      <Translate contentKey="jalurpipaApp.customer.basePressure">Base Pressure</Translate>
                    </Label>
                    <AvField id="customer-basePressure" type="text" name="basePressure" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="baseTemperatureLabel" for="customer-baseTemperature">
                      <Translate contentKey="jalurpipaApp.customer.baseTemperature">Base Temperature</Translate>
                    </Label>
                    <AvField id="customer-baseTemperature" type="text" name="baseTemperature" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="inspectionLabel" for="customer-inspection">
                      <Translate contentKey="jalurpipaApp.customer.inspection">Inspection</Translate>
                    </Label>
                    <AvField id="customer-inspection" type="date" className="form-control" name="inspection" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="expiredLabel" for="customer-expired">
                      <Translate contentKey="jalurpipaApp.customer.expired">Expired</Translate>
                    </Label>
                    <AvField id="customer-expired" type="date" className="form-control" name="expired" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="coiNumberLabel" for="customer-coiNumber">
                      <Translate contentKey="jalurpipaApp.customer.coiNumber">Coi Number</Translate>
                    </Label>
                    <AvField id="customer-coiNumber" type="text" name="coiNumber" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="coiDocLabel" for="customer-coiDoc">
                      <Translate contentKey="jalurpipaApp.customer.coiDoc">Coi Doc</Translate>
                    </Label>
                    <AvField id="customer-coiDoc" type="text" name="coiDoc" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="coiReportLabel" for="customer-coiReport">
                      <Translate contentKey="jalurpipaApp.customer.coiReport">Coi Report</Translate>
                    </Label>
                    <AvField id="customer-coiReport" type="text" name="coiReport" />
                  </AvGroup>
                  <AvGroup>
                    <Label id="reEngRlaLabel" for="customer-reEngRla">
                      <Translate contentKey="jalurpipaApp.customer.reEngRla">Re Eng Rla</Translate>
                    </Label>
                    <AvField id="customer-reEngRla" type="text" name="reEngRla" />
                  </AvGroup>
                </AvGroup>
              }
              {
                isNew &&
                <AvGroup>
                  <AvGroup>
                    <Label id="fileLabel" for="file">
                      <Translate contentKey="jalurpipaApp.customer.file">File</Translate>
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
                        required: { value: isNew && true, errorMessage: translate('entity.validation.required') },
                      }}
                    />
                  </AvGroup>
                </AvGroup>
              }
              <AvGroup>
                <Label for="customer-area">
                  <Translate contentKey="jalurpipaApp.customer.area">Area</Translate>
                </Label>
                <AvInput id="customer-area" type="select" className="form-control" name="areaId" required>
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
              <Button tag={Link} id="cancel-save" to="/customer" replace color="info">
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
  customerEntity: storeState.customer.entity,
  loading: storeState.customer.loading,
  updating: storeState.customer.updating,
  updateSuccess: storeState.customer.updateSuccess,
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

export default connect(mapStateToProps, mapDispatchToProps)(CustomerUpdate);
