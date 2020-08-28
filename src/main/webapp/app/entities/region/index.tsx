import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Region from './region';
import RegionDetail from './region-detail';
import RegionUpdate from './region-update';
import RegionDeleteDialog from './region-delete-dialog';
import PrivateRoute from "app/shared/auth/private-route";
import {AUTHORITIES} from "app/config/constants";

const Routes = ({ match }) => (
  <>
    <Switch>
      <PrivateRoute exact path={`${match.url}/new`} component={RegionUpdate} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
      <PrivateRoute exact path={`${match.url}/:id/edit`} component={RegionUpdate} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={RegionDetail} />
      <ErrorBoundaryRoute path={match.url} component={Region} />
    </Switch>
    <PrivateRoute exact path={`${match.url}/:id/delete`} component={RegionDeleteDialog} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
  </>
);

export default Routes;
