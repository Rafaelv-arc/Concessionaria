
package com.mycompany.informacoes;


public class Carro extends Comercio {
    
	private String tipoCambio;

    public Carro(String modelo, String marca, String tipoCambio, String preco) {
        super(modelo, marca, "Carro", preco);
        this.tipoCambio = tipoCambio;
    }


    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
	

       
	public String toString (){
		return super.toString() + "Tipo de Cambio: " + this.getTipoCambio();
	}
}

