export interface ICustomer {
  id?: number;
  fileContentType?: string;
  file?: any;
  areaName?: string;
  areaId?: number;
}

export const defaultValue: Readonly<ICustomer> = {};
