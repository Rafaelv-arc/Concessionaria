
package com.mycompany.informacoes;


public class Caminhao extends Comercio{
    private String capacidadeCarga;
	
	public Caminhao (String modelo, String marca, String capacidadeCarga, String preco) {
		super (modelo, marca, "Caminhao", preco);
		this.capacidadeCarga = capacidadeCarga;
	}


    public String getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(String capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
	

	public String toString (){
		return super.toString() + "Capacidade de Carga: " + this.getCapacidadeCarga();
	}
}

