import { Component, OnInit } from '@angular/core';
import { ConsumoService } from '../../services/consumo.service';
import { Eleccion } from '../../modelos/Eleccion';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  public elecciones: Array<Eleccion>;
  public vista = 'eleccion';
  public eleccionSeleccionada :any;
  public cargando:boolean =false;
  constructor(public _consumoService: ConsumoService) { }

  ngOnInit() {
    this.elecciones = new Array();
    this.obtenerElecciones();
  }

  obtenerElecciones() {
    this.cargando = true;
    this.elecciones = new Array();
    this._consumoService.getPeticion("eleccion").subscribe(
      result => {
        for (let i in result) {
          this.elecciones.push(new Eleccion(result[i].id, result[i].nombre, result[i].inicio, result[i].fin));
        }
        this.cargando = false;
      },
      error => {
        console.log(<any>error);
      }
    );
  }

  iniciarVotacion(data){
    this.eleccionSeleccionada = data;
    this.vista = 'votacion';
  }

  verResultados(data){
    this.eleccionSeleccionada = data;
    this.vista = 'resultado';
  }

  cargar(){
    this.vista = 'eleccion';
  }

  ejecutarCargando(){
    this.cargando = true;
  }

  terminarCargando(){
    this.cargando = false;
  }

}
