export interface IShipClass{
    id ?: number;
    name ?: string;
}

export class ShipClass implements IShipClass{
    id ?: number;
    name ?: string;

    constructor(data : IShipClass){
        this.id = data.id;
        this.name = data.name;
    }
}