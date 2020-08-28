import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Area from './area';
import AreaDetail from './area-detail';
import AreaUpdate from './area-update';
import AreaDeleteDialog from './area-delete-dialog';
import PrivateRoute from "app/shared/auth/private-route";
import {AUTHORITIES} from "app/config/constants";

const Routes = ({ match }) => (
  <>
    <Switch>
      <PrivateRoute exact path={`${match.url}/new`} component={AreaUpdate} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
      <PrivateRoute exact path={`${match.url}/:id/edit`} component={AreaUpdate} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={AreaDetail} />
      <ErrorBoundaryRoute path={match.url} component={Area} />
    </Switch>
    <PrivateRoute exact path={`${match.url}/:id/delete`} component={AreaDeleteDialog} hasAnyAuthorities={[AUTHORITIES.ADMIN]} />
  </>
);

export default Routes;
