export interface IEvent{
    id ?: null;
    name ?: null;
}

export class Event implements IEvent{
    id ?: null;
    name ?: null;
    
    constructor(data : IEvent){
        this.id = data.id;
        this.name = data.name;
    }
}