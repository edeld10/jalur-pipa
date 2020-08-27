import { Moment } from 'moment';

export interface IPipe {
  id?: number;
  objectId?: number;
  yStartCoordinate?: number;
  xStartCoordinate?: number;
  yEndCoordinate?: number;
  xEndCoordinate?: number;
  tagId?: string;
  pipeName?: string;
  description?: string;
  diameter?: number;
  diameterUn?: string;
  material?: string;
  operationType?: string;
  constructionYear?: number;
  p1Length?: number;
  actualLength?: number;
  comparisonStandard?: string;
  lokClass?: number;
  pipeMaterial?: string;
  penTools?: string;
  row?: string;
  maopDp?: string;
  maxTemperature?: string;
  ploNumber?: string;
  coiNumber?: string;
  raPipe?: string;
  inspection?: string;
  expired?: string;
  modified?: string;
  ploDocument?: string;
  ploReport?: string;
  coiDocument?: string;
  raDocument?: string;
  fileContentType?: string;
  file?: any;
  areaName?: string;
  areaId?: number;
}

export const defaultValue: Readonly<IPipe> = {};
