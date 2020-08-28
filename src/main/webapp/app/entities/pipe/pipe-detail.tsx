import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, openFile, byteSize, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './pipe.reducer';
import { IPipe } from 'app/shared/model/pipe.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPipeDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const PipeDetail = (props: IPipeDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { pipeEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jalurpipaApp.pipe.detail.title">Pipe</Translate> [<b>{pipeEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="objectId">
              <Translate contentKey="jalurpipaApp.pipe.objectId">Object Id</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.objectId}</dd>
          <dt>
            <span id="yStartCoordinate">
              <Translate contentKey="jalurpipaApp.pipe.yStartCoordinate">Y Start Coordinate</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.yStartCoordinate}</dd>
          <dt>
            <span id="xStartCoordinate">
              <Translate contentKey="jalurpipaApp.pipe.xStartCoordinate">X Start Coordinate</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.xStartCoordinate}</dd>
          <dt>
            <span id="yEndCoordinate">
              <Translate contentKey="jalurpipaApp.pipe.yEndCoordinate">Y End Coordinate</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.yEndCoordinate}</dd>
          <dt>
            <span id="xEndCoordinate">
              <Translate contentKey="jalurpipaApp.pipe.xEndCoordinate">X End Coordinate</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.xEndCoordinate}</dd>
          <dt>
            <span id="tagId">
              <Translate contentKey="jalurpipaApp.pipe.tagId">Tag Id</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.tagId}</dd>
          <dt>
            <span id="pipeName">
              <Translate contentKey="jalurpipaApp.pipe.pipeName">Pipe Name</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.pipeName}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="jalurpipaApp.pipe.description">Description</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.description}</dd>
          <dt>
            <span id="diameter">
              <Translate contentKey="jalurpipaApp.pipe.diameter">Diameter</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.diameter}</dd>
          <dt>
            <span id="diameterUn">
              <Translate contentKey="jalurpipaApp.pipe.diameterUn">Diameter Un</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.diameterUn}</dd>
          <dt>
            <span id="material">
              <Translate contentKey="jalurpipaApp.pipe.material">Material</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.material}</dd>
          <dt>
            <span id="operationType">
              <Translate contentKey="jalurpipaApp.pipe.operationType">Operation Type</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.operationType}</dd>
          <dt>
            <span id="constructionYear">
              <Translate contentKey="jalurpipaApp.pipe.constructionYear">Construction Year</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.constructionYear}</dd>
          <dt>
            <span id="p1Length">
              <Translate contentKey="jalurpipaApp.pipe.p1Length">P 1 Length</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.p1Length}</dd>
          <dt>
            <span id="actualLength">
              <Translate contentKey="jalurpipaApp.pipe.actualLength">Actual Length</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.actualLength}</dd>
          <dt>
            <span id="comparisonStandard">
              <Translate contentKey="jalurpipaApp.pipe.comparisonStandard">Comparison Standard</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.comparisonStandard}</dd>
          <dt>
            <span id="lokClass">
              <Translate contentKey="jalurpipaApp.pipe.lokClass">Lok Class</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.lokClass}</dd>
          <dt>
            <span id="pipeMaterial">
              <Translate contentKey="jalurpipaApp.pipe.pipeMaterial">Pipe Material</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.pipeMaterial}</dd>
          <dt>
            <span id="penTools">
              <Translate contentKey="jalurpipaApp.pipe.penTools">Pen Tools</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.penTools}</dd>
          <dt>
            <span id="row">
              <Translate contentKey="jalurpipaApp.pipe.row">Row</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.row}</dd>
          <dt>
            <span id="maopDp">
              <Translate contentKey="jalurpipaApp.pipe.maopDp">Maop Dp</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.maopDp}</dd>
          <dt>
            <span id="maxTemperature">
              <Translate contentKey="jalurpipaApp.pipe.maxTemperature">Max Temperature</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.maxTemperature}</dd>
          <dt>
            <span id="ploNumber">
              <Translate contentKey="jalurpipaApp.pipe.ploNumber">Plo Number</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.ploNumber}</dd>
          <dt>
            <span id="coiNumber">
              <Translate contentKey="jalurpipaApp.pipe.coiNumber">Coi Number</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.coiNumber}</dd>
          <dt>
            <span id="raPipe">
              <Translate contentKey="jalurpipaApp.pipe.raPipe">Ra Pipe</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.raPipe}</dd>
          <dt>
            <span id="inspection">
              <Translate contentKey="jalurpipaApp.pipe.inspection">Inspection</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.inspection ? <TextFormat value={pipeEntity.inspection} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="expired">
              <Translate contentKey="jalurpipaApp.pipe.expired">Expired</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.expired ? <TextFormat value={pipeEntity.expired} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="modified">
              <Translate contentKey="jalurpipaApp.pipe.modified">Modified</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.modified ? <TextFormat value={pipeEntity.modified} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="ploDocument">
              <Translate contentKey="jalurpipaApp.pipe.ploDocument">Plo Document</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.ploDocument}</dd>
          <dt>
            <span id="ploReport">
              <Translate contentKey="jalurpipaApp.pipe.ploReport">Plo Report</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.ploReport}</dd>
          <dt>
            <span id="coiDocument">
              <Translate contentKey="jalurpipaApp.pipe.coiDocument">Coi Document</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.coiDocument}</dd>
          <dt>
            <span id="raDocument">
              <Translate contentKey="jalurpipaApp.pipe.raDocument">Ra Document</Translate>
            </span>
          </dt>
          <dd>{pipeEntity.raDocument}</dd>
          {/*<dt>*/}
            {/*<span id="file">*/}
              {/*<Translate contentKey="jalurpipaApp.pipe.file">File</Translate>*/}
            {/*</span>*/}
          {/*</dt>*/}
          {/*<dd>*/}
            {/*{pipeEntity.file ? (*/}
              {/*<div>*/}
                {/*{pipeEntity.fileContentType ? (*/}
                  {/*<a onClick={openFile(pipeEntity.fileContentType, pipeEntity.file)}>*/}
                    {/*<Translate contentKey="entity.action.open">Open</Translate>&nbsp;*/}
                  {/*</a>*/}
                {/*) : null}*/}
                {/*<span>*/}
                  {/*{pipeEntity.fileContentType}, {byteSize(pipeEntity.file)}*/}
                {/*</span>*/}
              {/*</div>*/}
            {/*) : null}*/}
          {/*</dd>*/}
          <dt>
            <Translate contentKey="jalurpipaApp.pipe.area">Area</Translate>
          </dt>
          <dd>{pipeEntity.areaName ? pipeEntity.areaName : ''}</dd>
        </dl>
        <Button tag={Link} to="/pipe" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/pipe/${pipeEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ pipe }: IRootState) => ({
  pipeEntity: pipe.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(PipeDetail);
