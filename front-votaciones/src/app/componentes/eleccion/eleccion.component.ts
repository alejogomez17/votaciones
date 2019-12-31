import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Opcion } from '../../modelos/Opcion';
import { Peticion } from '../../modelos/Peticion';
import { ConsumoService } from '../../services/consumo.service';

@Component({
  selector: 'app-eleccion',
  templateUrl: './eleccion.component.html',
  styleUrls: ['./eleccion.component.css']
})
export class EleccionComponent implements OnInit {

  @Input() idEleccionSeleccionada: number;
  @Output() salir= new EventEmitter();
  public opciones: Array<Opcion>;
  public display: boolean = false;
  public votoRegistrado :boolean = false;
  public opcionSeleccionada: any;
  public cargando:boolean=false;

  constructor(public _consumoService: ConsumoService) {
    this.opcionSeleccionada = new Object();
    this.opcionSeleccionada.nombre = "";
    this.opcionSeleccionada.imagen = "";
    this.opciones = new Array();
  }


  ngOnInit() {
    this.cargarOpcionesDeEleccion(this.idEleccionSeleccionada);
  }

  imagen(seleccionada) {
    this.opcionSeleccionada = seleccionada;
    this.display = true;
  }

  showDialog() {
    this.display = true;
  }

  cargarOpcionesDeEleccion(idEleccion){
    this.ejecutarCargando();
    this._consumoService.getPeticion("opcionEleccion/eleccion/"+idEleccion).subscribe(
      result => {
        for (let i in result) {
          this.opciones.push(new Opcion(result[i].id, result[i].idOpcion.nombre, result[i].idOpcion.url));
        }
        this.terminarCargando();
      },
      error => {
        console.log(<any>error);
      }
    );
  }

  registrarVoto(){
    this.ejecutarCargando();
    let peticion = new Peticion();
    peticion.idEleccion = this.opcionSeleccionada.id;
    this._consumoService.postPeticion("voto/generar",peticion).subscribe(
      result => {
        if(result.respuesta){
          console.log('Voto registrado con éxito');
          this.votoRegistrado = true;
          this.opcionSeleccionada = new Object();
        }else{

        }
        this.terminarCargando();
      },
      error => {
        console.log(<any>error);
      }
    );
    this.display = false;
  }

  registrarNuevoVoto(){
    this.votoRegistrado = false;
    this.display = false;
  }
  volverAPrincipal(){
    this.salir.emit();
    this.votoRegistrado = false;
    this.display = false;
  }

  ejecutarCargando(){
    this.cargando = true;
  }

  terminarCargando(){
    this.cargando = false;
  }
  
}
