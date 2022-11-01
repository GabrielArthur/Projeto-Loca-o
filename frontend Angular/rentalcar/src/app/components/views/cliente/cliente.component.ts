import { Component, OnInit, NgModule } from '@angular/core';
import { CepService } from './../../../services/cep.service';
import { Cliente } from './../../../models/cliente';


@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})

export class ClienteComponent implements OnInit {

  constructor(private cepService: CepService){
  }
  ngOnInit(): void {
  }

  consultaCep(valor: any, form: any){
    this.cepService.buscar(valor).subscribe((dados) => this.populaForm(dados, form));
  }

  populaForm(dados: any, form: any){
    form.setValue({
      cep: dados.cep,
      logradouro: dados.logradouro,
      bairro: dados.bairro,
      cidade: dados.localidade,
      uf: dados.uf,
    })
  }

  getDateFormatString(): string {
    return 'YYYY/MM/DD';
  }


  cliente!: Cliente;

  cadastroCliente(cliente : Cliente, form: any){
    form.setValue({

    })
  }

}
