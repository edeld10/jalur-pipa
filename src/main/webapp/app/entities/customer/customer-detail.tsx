import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, openFile, byteSize, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './customer.reducer';
import { ICustomer } from 'app/shared/model/customer.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICustomerDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CustomerDetail = (props: ICustomerDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { customerEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jalurpipaApp.customer.detail.title">Customer</Translate> [<b>{customerEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="objectId">
              <Translate contentKey="jalurpipaApp.customer.objectId">Object Id</Translate>
            </span>
          </dt>
          <dd>{customerEntity.objectId}</dd>
          <dt>
            <span id="yCoordinate">
              <Translate contentKey="jalurpipaApp.customer.yCoordinate">Y Coordinate</Translate>
            </span>
          </dt>
          <dd>{customerEntity.yCoordinate}</dd>
          <dt>
            <span id="xCoordinate">
              <Translate contentKey="jalurpipaApp.customer.xCoordinate">X Coordinate</Translate>
            </span>
          </dt>
          <dd>{customerEntity.xCoordinate}</dd>
          <dt>
            <span id="refId">
              <Translate contentKey="jalurpipaApp.customer.refId">Ref Id</Translate>
            </span>
          </dt>
          <dd>{customerEntity.refId}</dd>
          <dt>
            <span id="tagId">
              <Translate contentKey="jalurpipaApp.customer.tagId">Tag Id</Translate>
            </span>
          </dt>
          <dd>{customerEntity.tagId}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="jalurpipaApp.customer.name">Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.name}</dd>
          <dt>
            <span id="pipeName">
              <Translate contentKey="jalurpipaApp.customer.pipeName">Pipe Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.pipeName}</dd>
          <dt>
            <span id="yearInstalled">
              <Translate contentKey="jalurpipaApp.customer.yearInstalled">Year Installed</Translate>
            </span>
          </dt>
          <dd>{customerEntity.yearInstalled}</dd>
          <dt>
            <span id="owner">
              <Translate contentKey="jalurpipaApp.customer.owner">Owner</Translate>
            </span>
          </dt>
          <dd>{customerEntity.owner}</dd>
          <dt>
            <span id="stationType">
              <Translate contentKey="jalurpipaApp.customer.stationType">Station Type</Translate>
            </span>
          </dt>
          <dd>{customerEntity.stationType}</dd>
          <dt>
            <span id="lineStream">
              <Translate contentKey="jalurpipaApp.customer.lineStream">Line Stream</Translate>
            </span>
          </dt>
          <dd>{customerEntity.lineStream}</dd>
          <dt>
            <span id="customerType">
              <Translate contentKey="jalurpipaApp.customer.customerType">Customer Type</Translate>
            </span>
          </dt>
          <dd>{customerEntity.customerType}</dd>
          <dt>
            <span id="identification">
              <Translate contentKey="jalurpipaApp.customer.identification">Identification</Translate>
            </span>
          </dt>
          <dd>{customerEntity.identification}</dd>
          <dt>
            <span id="equipment">
              <Translate contentKey="jalurpipaApp.customer.equipment">Equipment</Translate>
            </span>
          </dt>
          <dd>{customerEntity.equipment}</dd>
          <dt>
            <span id="type">
              <Translate contentKey="jalurpipaApp.customer.type">Type</Translate>
            </span>
          </dt>
          <dd>{customerEntity.type}</dd>
          <dt>
            <span id="manuMeter">
              <Translate contentKey="jalurpipaApp.customer.manuMeter">Manu Meter</Translate>
            </span>
          </dt>
          <dd>{customerEntity.manuMeter}</dd>
          <dt>
            <span id="manuFilter">
              <Translate contentKey="jalurpipaApp.customer.manuFilter">Manu Filter</Translate>
            </span>
          </dt>
          <dd>{customerEntity.manuFilter}</dd>
          <dt>
            <span id="manuEngine">
              <Translate contentKey="jalurpipaApp.customer.manuEngine">Manu Engine</Translate>
            </span>
          </dt>
          <dd>{customerEntity.manuEngine}</dd>
          <dt>
            <span id="codeStand">
              <Translate contentKey="jalurpipaApp.customer.codeStand">Code Stand</Translate>
            </span>
          </dt>
          <dd>{customerEntity.codeStand}</dd>
          <dt>
            <span id="fluida">
              <Translate contentKey="jalurpipaApp.customer.fluida">Fluida</Translate>
            </span>
          </dt>
          <dd>{customerEntity.fluida}</dd>
          <dt>
            <span id="flowRate">
              <Translate contentKey="jalurpipaApp.customer.flowRate">Flow Rate</Translate>
            </span>
          </dt>
          <dd>{customerEntity.flowRate}</dd>
          <dt>
            <span id="pressureIn">
              <Translate contentKey="jalurpipaApp.customer.pressureIn">Pressure In</Translate>
            </span>
          </dt>
          <dd>{customerEntity.pressureIn}</dd>
          <dt>
            <span id="pressureOut">
              <Translate contentKey="jalurpipaApp.customer.pressureOut">Pressure Out</Translate>
            </span>
          </dt>
          <dd>{customerEntity.pressureOut}</dd>
          <dt>
            <span id="temperature">
              <Translate contentKey="jalurpipaApp.customer.temperature">Temperature</Translate>
            </span>
          </dt>
          <dd>{customerEntity.temperature}</dd>
          <dt>
            <span id="basePressure">
              <Translate contentKey="jalurpipaApp.customer.basePressure">Base Pressure</Translate>
            </span>
          </dt>
          <dd>{customerEntity.basePressure}</dd>
          <dt>
            <span id="baseTemperature">
              <Translate contentKey="jalurpipaApp.customer.baseTemperature">Base Temperature</Translate>
            </span>
          </dt>
          <dd>{customerEntity.baseTemperature}</dd>
          <dt>
            <span id="inspection">
              <Translate contentKey="jalurpipaApp.customer.inspection">Inspection</Translate>
            </span>
          </dt>
          <dd>
            {customerEntity.inspection ? <TextFormat value={customerEntity.inspection} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="expired">
              <Translate contentKey="jalurpipaApp.customer.expired">Expired</Translate>
            </span>
          </dt>
          <dd>
            {customerEntity.expired ? <TextFormat value={customerEntity.expired} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="coiNumber">
              <Translate contentKey="jalurpipaApp.customer.coiNumber">Coi Number</Translate>
            </span>
          </dt>
          <dd>{customerEntity.coiNumber}</dd>
          <dt>
            <span id="coiDoc">
              <Translate contentKey="jalurpipaApp.customer.coiDoc">Coi Doc</Translate>
            </span>
          </dt>
          <dd>{customerEntity.coiDoc}</dd>
          <dt>
            <span id="coiReport">
              <Translate contentKey="jalurpipaApp.customer.coiReport">Coi Report</Translate>
            </span>
          </dt>
          <dd>{customerEntity.coiReport}</dd>
          <dt>
            <span id="reEngRla">
              <Translate contentKey="jalurpipaApp.customer.reEngRla">Re Eng Rla</Translate>
            </span>
          </dt>
          <dd>{customerEntity.reEngRla}</dd>
          <dt>
            <span id="file">
              <Translate contentKey="jalurpipaApp.customer.file">File</Translate>
            </span>
          </dt>
          <dd>
            {customerEntity.file ? (
              <div>
                {customerEntity.fileContentType ? (
                  <a onClick={openFile(customerEntity.fileContentType, customerEntity.file)}>
                    <Translate contentKey="entity.action.open">Open</Translate>&nbsp;
                  </a>
                ) : null}
                <span>
                  {customerEntity.fileContentType}, {byteSize(customerEntity.file)}
                </span>
              </div>
            ) : null}
          </dd>
          <dt>
            <Translate contentKey="jalurpipaApp.customer.area">Area</Translate>
          </dt>
          <dd>{customerEntity.areaName ? customerEntity.areaName : ''}</dd>
        </dl>
        <Button tag={Link} to="/customer" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/customer/${customerEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ customer }: IRootState) => ({
  customerEntity: customer.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CustomerDetail);
