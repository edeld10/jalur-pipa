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
import { getEntities } from './customer.reducer';
import { ICustomer } from 'app/shared/model/customer.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';

export interface ICustomerProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Customer = (props: ICustomerProps) => {
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

  const { customerList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="customer-heading">
        <Translate contentKey="jalurpipaApp.customer.home.title">Customers</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jalurpipaApp.customer.home.createLabel">Create new Customer</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {customerList && customerList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('objectId')}>
                  <Translate contentKey="jalurpipaApp.customer.objectId">Object Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('yCoordinate')}>
                  <Translate contentKey="jalurpipaApp.customer.yCoordinate">Y Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('xCoordinate')}>
                  <Translate contentKey="jalurpipaApp.customer.xCoordinate">X Coordinate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('refId')}>
                  <Translate contentKey="jalurpipaApp.customer.refId">Ref Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('tagId')}>
                  <Translate contentKey="jalurpipaApp.customer.tagId">Tag Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('name')}>
                  <Translate contentKey="jalurpipaApp.customer.name">Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pipeName')}>
                  <Translate contentKey="jalurpipaApp.customer.pipeName">Pipe Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('yearInstalled')}>
                  <Translate contentKey="jalurpipaApp.customer.yearInstalled">Year Installed</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('owner')}>
                  <Translate contentKey="jalurpipaApp.customer.owner">Owner</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('stationType')}>
                  <Translate contentKey="jalurpipaApp.customer.stationType">Station Type</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('lineStream')}>
                  <Translate contentKey="jalurpipaApp.customer.lineStream">Line Stream</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('customerType')}>
                  <Translate contentKey="jalurpipaApp.customer.customerType">Customer Type</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('identification')}>
                  <Translate contentKey="jalurpipaApp.customer.identification">Identification</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('equipment')}>
                  <Translate contentKey="jalurpipaApp.customer.equipment">Equipment</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('type')}>
                  <Translate contentKey="jalurpipaApp.customer.type">Type</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('manuMeter')}>
                  <Translate contentKey="jalurpipaApp.customer.manuMeter">Manu Meter</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('manuFilter')}>
                  <Translate contentKey="jalurpipaApp.customer.manuFilter">Manu Filter</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('manuEngine')}>
                  <Translate contentKey="jalurpipaApp.customer.manuEngine">Manu Engine</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('codeStand')}>
                  <Translate contentKey="jalurpipaApp.customer.codeStand">Code Stand</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('fluida')}>
                  <Translate contentKey="jalurpipaApp.customer.fluida">Fluida</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('flowRate')}>
                  <Translate contentKey="jalurpipaApp.customer.flowRate">Flow Rate</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pressureIn')}>
                  <Translate contentKey="jalurpipaApp.customer.pressureIn">Pressure In</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pressureOut')}>
                  <Translate contentKey="jalurpipaApp.customer.pressureOut">Pressure Out</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('temperature')}>
                  <Translate contentKey="jalurpipaApp.customer.temperature">Temperature</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('basePressure')}>
                  <Translate contentKey="jalurpipaApp.customer.basePressure">Base Pressure</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('baseTemperature')}>
                  <Translate contentKey="jalurpipaApp.customer.baseTemperature">Base Temperature</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('inspection')}>
                  <Translate contentKey="jalurpipaApp.customer.inspection">Inspection</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('expired')}>
                  <Translate contentKey="jalurpipaApp.customer.expired">Expired</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('coiNumber')}>
                  <Translate contentKey="jalurpipaApp.customer.coiNumber">Coi Number</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('coiDoc')}>
                  <Translate contentKey="jalurpipaApp.customer.coiDoc">Coi Doc</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('coiReport')}>
                  <Translate contentKey="jalurpipaApp.customer.coiReport">Coi Report</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('reEngRla')}>
                  <Translate contentKey="jalurpipaApp.customer.reEngRla">Re Eng Rla</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('file')}>
                  <Translate contentKey="jalurpipaApp.customer.file">File</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="jalurpipaApp.customer.area">Area</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {customerList.map((customer, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${customer.id}`} color="link" size="sm">
                      {customer.id}
                    </Button>
                  </td>
                  <td>{customer.objectId}</td>
                  <td>{customer.yCoordinate}</td>
                  <td>{customer.xCoordinate}</td>
                  <td>{customer.refId}</td>
                  <td>{customer.tagId}</td>
                  <td>{customer.name}</td>
                  <td>{customer.pipeName}</td>
                  <td>{customer.yearInstalled}</td>
                  <td>{customer.owner}</td>
                  <td>{customer.stationType}</td>
                  <td>{customer.lineStream}</td>
                  <td>{customer.customerType}</td>
                  <td>{customer.identification}</td>
                  <td>{customer.equipment}</td>
                  <td>{customer.type}</td>
                  <td>{customer.manuMeter}</td>
                  <td>{customer.manuFilter}</td>
                  <td>{customer.manuEngine}</td>
                  <td>{customer.codeStand}</td>
                  <td>{customer.fluida}</td>
                  <td>{customer.flowRate}</td>
                  <td>{customer.pressureIn}</td>
                  <td>{customer.pressureOut}</td>
                  <td>{customer.temperature}</td>
                  <td>{customer.basePressure}</td>
                  <td>{customer.baseTemperature}</td>
                  <td>
                    {customer.inspection ? <TextFormat type="date" value={customer.inspection} format={APP_LOCAL_DATE_FORMAT} /> : null}
                  </td>
                  <td>{customer.expired ? <TextFormat type="date" value={customer.expired} format={APP_LOCAL_DATE_FORMAT} /> : null}</td>
                  <td>{customer.coiNumber}</td>
                  <td>{customer.coiDoc}</td>
                  <td>{customer.coiReport}</td>
                  <td>{customer.reEngRla}</td>
                  <td>
                    {customer.file ? (
                      <div>
                        {customer.fileContentType ? (
                          <a onClick={openFile(customer.fileContentType, customer.file)}>
                            <Translate contentKey="entity.action.open">Open</Translate>
                            &nbsp;
                          </a>
                        ) : null}
                        <span>
                          {customer.fileContentType}, {byteSize(customer.file)}
                        </span>
                      </div>
                    ) : null}
                  </td>
                  <td>{customer.areaName ? <Link to={`area/${customer.areaId}`}>{customer.areaName}</Link> : ''}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${customer.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${customer.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
                        to={`${match.url}/${customer.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
              <Translate contentKey="jalurpipaApp.customer.home.notFound">No Customers found</Translate>
            </div>
          )
        )}
      </div>
      {props.totalItems ? (
        <div className={customerList && customerList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ customer }: IRootState) => ({
  customerList: customer.entities,
  loading: customer.loading,
  totalItems: customer.totalItems,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Customer);
