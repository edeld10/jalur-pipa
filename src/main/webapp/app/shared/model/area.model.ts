import { ICustomer } from 'app/shared/model/customer.model';
import { IPipe } from 'app/shared/model/pipe.model';

export interface IArea {
  id?: number;
  name?: string;
  description?: string;
  code?: string;
  customers?: ICustomer[];
  pipes?: IPipe[];
  regionName?: string;
  regionId?: number;
}

export const defaultValue: Readonly<IArea> = {};
