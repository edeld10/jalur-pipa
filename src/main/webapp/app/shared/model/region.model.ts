import { IArea } from 'app/shared/model/area.model';

export interface IRegion {
  id?: number;
  name?: string;
  description?: string;
  code?: string;
  areas?: IArea[];
}

export const defaultValue: Readonly<IRegion> = {};
