
package com.mycompany.informacoes;


public class Moto extends Comercio{
    private String cilindrada;
	
	public Moto (String modelo, String marca, String cilindrada, String preco) {
		super (modelo, marca, "Moto", preco);
		this.cilindrada = cilindrada;
	}

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }
        

	public String toString (){
		return super.toString() + "Quantidade de Cilindradas: " + this.getCilindrada();
	}
}
