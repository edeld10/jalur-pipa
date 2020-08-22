import { Moment } from 'moment';

export interface ICustomer {
  id?: number;
  objectId?: number;
  yCoordinate?: number;
  xCoordinate?: number;
  refId?: string;
  tagId?: string;
  name?: string;
  pipeName?: string;
  yearInstalled?: number;
  owner?: string;
  stationType?: string;
  lineStream?: number;
  customerType?: string;
  identification?: string;
  equipment?: string;
  type?: string;
  manuMeter?: string;
  manuFilter?: string;
  manuEngine?: string;
  codeStand?: string;
  fluida?: string;
  flowRate?: string;
  pressureIn?: string;
  pressureOut?: string;
  temperature?: string;
  basePressure?: string;
  baseTemperature?: string;
  inspection?: string;
  expired?: string;
  coiNumber?: string;
  coiDoc?: string;
  coiReport?: string;
  reEngRla?: string;
  fileContentType?: string;
  file?: any;
  areaName?: string;
  areaId?: number;
}

export const defaultValue: Readonly<ICustomer> = {};
