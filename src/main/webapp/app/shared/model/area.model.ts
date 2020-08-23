import { ICustomer } from 'app/shared/model/customer.model';

export interface IArea {
  id?: number;
  name?: string;
  description?: string;
  code?: string;
  customers?: ICustomer[];
  regionName?: string;
  regionId?: number;
}

export const defaultValue: Readonly<IArea> = {};
