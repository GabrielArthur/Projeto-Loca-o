export interface Cliente{

  id: string;
  nome: string;
  sobrenome: string;
  email: string;
  endereco: {
    cep: string,
    logradouro: string,
    bairro: string,
    cidade: string,
    uf: string,
  }

}
