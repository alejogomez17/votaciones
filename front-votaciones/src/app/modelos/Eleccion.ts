export class Eleccion{
    public id:number;
    public nombre:string;
    public inicio:string;
    public fin:string;
    constructor(id, nombre, inicio, fin){
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }
}