export interface IArea {
  id?: number;
  name?: string;
  description?: string;
  code?: string;
  regionName?: string;
  regionId?: number;
}

export const defaultValue: Readonly<IArea> = {};
