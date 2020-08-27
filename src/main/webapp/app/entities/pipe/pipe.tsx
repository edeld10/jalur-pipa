import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import {
  openFile,
  byteSize,
  Translate,
  ICrudGetAllAction,
  TextFormat,
  getSortState,
  IPaginationBaseState,
  JhiPagination,
  JhiItemCount,
} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './pipe.reducer';
import { IPipe } from 'app/shared/model/pipe.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';

export interface IPipeProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Pipe = (props: IPipeProps) => {
  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getSortState(props.location, ITEMS_PER_PAGE), props.location.search)
  );

  const getAllEntities = () => {
    props.getEntities(paginationState.activePage - 1, paginationState.itemsPerPage, `${paginationState.sort},${paginationState.order}`);
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (props.location.search !== endURL) {
      props.history.push(`${props.location.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(props.location.search);
    const page = params.get('page');
    const sort = params.get('sort');
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [props.location.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === 'asc' ? 'desc' : 'asc',
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const { pipeList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="pipe-heading">
        <Translate contentKey="jalurpipaApp.pipe.home.title">Pipes</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jalurpipaApp.pipe.home.createLabel">Create new Pipe</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {pipeList && pipeList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('objectId')}>
                  <Translate contentKey="jalurpipaApp.pipe.objectId">Object Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('yStartCoordinate')}>
                  <Translate contentKey="jalurpipaApp.pipe.yStartCoordinate">Y Start Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('xStartCoordinate')}>
                  <Translate contentKey="jalurpipaApp.pipe.xStartCoordinate">X Start Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('yEndCoordinate')}>
                  <Translate contentKey="jalurpipaApp.pipe.yEndCoordinate">Y End Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('xEndCoordinate')}>
                  <Translate contentKey="jalurpipaApp.pipe.xEndCoordinate">X End Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('tagId')}>
                  <Translate contentKey="jalurpipaApp.pipe.tagId">Tag Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pipeName')}>
                  <Translate contentKey="jalurpipaApp.pipe.pipeName">Pipe Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('description')}>
                  <Translate contentKey="jalurpipaApp.pipe.description">Description</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('diameter')}>
                  <Translate contentKey="jalurpipaApp.pipe.diameter">Diameter</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('diameterUn')}>
                  <Translate contentKey="jalurpipaApp.pipe.diameterUn">Diameter Un</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('material')}>
                  <Translate contentKey="jalurpipaApp.pipe.material">Material</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('operationType')}>
                  <Translate contentKey="jalurpipaApp.pipe.operationType">Operation Type</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('constructionYear')}>
                  <Translate contentKey="jalurpipaApp.pipe.constructionYear">Construction Year</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('p1Length')}>
                  <Translate contentKey="jalurpipaApp.pipe.p1Length">P 1 Length</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('actualLength')}>
                  <Translate contentKey="jalurpipaApp.pipe.actualLength">Actual Length</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('comparisonStandard')}>
                  <Translate contentKey="jalurpipaApp.pipe.comparisonStandard">Comparison Standard</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('lokClass')}>
                  <Translate contentKey="jalurpipaApp.pipe.lokClass">Lok Class</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pipeMaterial')}>
                  <Translate contentKey="jalurpipaApp.pipe.pipeMaterial">Pipe Material</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('penTools')}>
                  <Translate contentKey="jalurpipaApp.pipe.penTools">Pen Tools</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('row')}>
                  <Translate contentKey="jalurpipaApp.pipe.row">Row</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('maopDp')}>
                  <Translate contentKey="jalurpipaApp.pipe.maopDp">Maop Dp</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('maxTemperature')}>
                  <Translate contentKey="jalurpipaApp.pipe.maxTemperature">Max Temperature</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('ploNumber')}>
                  <Translate contentKey="jalurpipaApp.pipe.ploNumber">Plo Number</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('coiNumber')}>
                  <Translate contentKey="jalurpipaApp.pipe.coiNumber">Coi Number</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('raPipe')}>
                  <Translate contentKey="jalurpipaApp.pipe.raPipe">Ra Pipe</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('inspection')}>
                  <Translate contentKey="jalurpipaApp.pipe.inspection">Inspection</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('expired')}>
                  <Translate contentKey="jalurpipaApp.pipe.expired">Expired</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('modified')}>
                  <Translate contentKey="jalurpipaApp.pipe.modified">Modified</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('ploDocument')}>
                  <Translate contentKey="jalurpipaApp.pipe.ploDocument">Plo Document</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('ploReport')}>
                  <Translate contentKey="jalurpipaApp.pipe.ploReport">Plo Report</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('coiDocument')}>
                  <Translate contentKey="jalurpipaApp.pipe.coiDocument">Coi Document</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('raDocument')}>
                  <Translate contentKey="jalurpipaApp.pipe.raDocument">Ra Document</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                {/*<th className="hand" onClick={sort('file')}>*/}
                  {/*<Translate contentKey="jalurpipaApp.pipe.file">File</Translate> <FontAwesomeIcon icon="sort" />*/}
                {/*</th>*/}
                <th>
                  <Translate contentKey="jalurpipaApp.pipe.area">Area</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {pipeList.map((pipe, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${pipe.id}`} color="link" size="sm">
                      {pipe.id}
                    </Button>
                  </td>
                  <td>{pipe.objectId}</td>
                  <td>{pipe.yStartCoordinate}</td>
                  <td>{pipe.xStartCoordinate}</td>
                  <td>{pipe.yEndCoordinate}</td>
                  <td>{pipe.xEndCoordinate}</td>
                  <td>{pipe.tagId}</td>
                  <td>{pipe.pipeName}</td>
                  <td>{pipe.description}</td>
                  <td>{pipe.diameter}</td>
                  <td>{pipe.diameterUn}</td>
                  <td>{pipe.material}</td>
                  <td>{pipe.operationType}</td>
                  <td>{pipe.constructionYear}</td>
                  <td>{pipe.p1Length}</td>
                  <td>{pipe.actualLength}</td>
                  <td>{pipe.comparisonStandard}</td>
                  <td>{pipe.lokClass}</td>
                  <td>{pipe.pipeMaterial}</td>
                  <td>{pipe.penTools}</td>
                  <td>{pipe.row}</td>
                  <td>{pipe.maopDp}</td>
                  <td>{pipe.maxTemperature}</td>
                  <td>{pipe.ploNumber}</td>
                  <td>{pipe.coiNumber}</td>
                  <td>{pipe.raPipe}</td>
                  <td>{pipe.inspection ? <TextFormat type="date" value={pipe.inspection} format={APP_LOCAL_DATE_FORMAT} /> : null}</td>
                  <td>{pipe.expired ? <TextFormat type="date" value={pipe.expired} format={APP_LOCAL_DATE_FORMAT} /> : null}</td>
                  <td>{pipe.modified ? <TextFormat type="date" value={pipe.modified} format={APP_LOCAL_DATE_FORMAT} /> : null}</td>
                  <td>{pipe.ploDocument}</td>
                  <td>{pipe.ploReport}</td>
                  <td>{pipe.coiDocument}</td>
                  <td>{pipe.raDocument}</td>
                  {/*<td>*/}
                    {/*{pipe.file ? (*/}
                      {/*<div>*/}
                        {/*{pipe.fileContentType ? (*/}
                          {/*<a onClick={openFile(pipe.fileContentType, pipe.file)}>*/}
                            {/*<Translate contentKey="entity.action.open">Open</Translate>*/}
                            {/*&nbsp;*/}
                          {/*</a>*/}
                        {/*) : null}*/}
                        {/*<span>*/}
                          {/*{pipe.fileContentType}, {byteSize(pipe.file)}*/}
                        {/*</span>*/}
                      {/*</div>*/}
                    {/*) : null}*/}
                  {/*</td>*/}
                  <td>{pipe.areaName ? <Link to={`area/${pipe.areaId}`}>{pipe.areaName}</Link> : ''}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${pipe.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${pipe.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${pipe.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="jalurpipaApp.pipe.home.notFound">No Pipes found</Translate>
            </div>
          )
        )}
      </div>
      {props.totalItems ? (
        <div className={pipeList && pipeList.length > 0 ? '' : 'd-none'}>
          <Row className="justify-content-center">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
          </Row>
          <Row className="justify-content-center">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={props.totalItems}
            />
          </Row>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

const mapStateToProps = ({ pipe }: IRootState) => ({
  pipeList: pipe.entities,
  loading: pipe.loading,
  totalItems: pipe.totalItems,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Pipe);
