import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Item } from '../../modelos/Item';
import { ConsumoService } from '../../services/consumo.service';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.css']
})
export class ResultadoComponent implements OnInit {

  @Input() idEleccion:number;
  @Output() salir= new EventEmitter();
  public items:Array<Item>;
  public cargando:boolean = false;

  constructor(public _consumoService: ConsumoService) { 
    this.items = new Array();
  }

  ngOnInit() {
    this.cargarResultadosEleccion(this.idEleccion);
  }

  cargarResultadosEleccion(idEleccion){
    this.ejecutarCargando();
    this._consumoService.getPeticion("eleccion/resultados/"+idEleccion).subscribe(
      result => {
        let opciones = result.opciones;
        for (let i in opciones) {
            this.items.push(new Item(opciones[i].nombre, opciones[i].url, opciones[i].cantidadVotos));
        }
        this.terminarCargando();
      },
      error => {
        console.log(<any>error);
      }
    );
  }

  volverAPrincipal(){
    this.salir.emit();
  }

  ejecutarCargando(){
    this.cargando = true;
  }

  terminarCargando(){
    this.cargando = false;
  }
}
