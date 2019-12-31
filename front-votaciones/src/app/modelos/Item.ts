export class Item{
    public nombre:string;
    public url:string;
    public cantidad:number;
    constructor(nombre, url, cantidad){
        this.nombre = nombre,
        this.url = url;
        this.cantidad = cantidad;
    }
}