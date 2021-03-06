import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './region.reducer';
import { IRegion } from 'app/shared/model/region.model';
import {APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT, AUTHORITIES} from 'app/config/constants';
import {hasAnyAuthority} from "app/shared/auth/private-route";

export interface IRegionDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const RegionDetail = (props: IRegionDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { regionEntity, isAdmin } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jalurpipaApp.region.detail.title">Region</Translate> [<b>{regionEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">
              <Translate contentKey="jalurpipaApp.region.name">Name</Translate>
            </span>
          </dt>
          <dd>{regionEntity.name}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="jalurpipaApp.region.description">Description</Translate>
            </span>
          </dt>
          <dd>{regionEntity.description}</dd>
          <dt>
            <span id="code">
              <Translate contentKey="jalurpipaApp.region.code">Code</Translate>
            </span>
          </dt>
          <dd>{regionEntity.code}</dd>
        </dl>
        <Button tag={Link} to="/region" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        {
          isAdmin &&
          <Button tag={Link} to={`/region/${regionEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
          </Button>
        }
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ region, authentication }: IRootState) => ({
  regionEntity: region.entity,
  isAdmin: hasAnyAuthority(authentication.account.authorities, [AUTHORITIES.ADMIN]),
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(RegionDetail);
