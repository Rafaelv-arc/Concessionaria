
package com.mycompany.informacoes;
import java.io.Serializable;


public abstract class Comercio implements Serializable{

	private String modelo;
	private String marca;
	private String tipoAuto;
        private String preco;

    public Comercio() {
    }

    public Comercio(String modelo, String marca, String tipoAuto, String preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.tipoAuto = tipoAuto;
        this.preco = preco;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

        @Override
	public String toString () {
		String retorno;

		retorno =  "--------------------------" +
				"Modelo: " + this.getModelo() +
				"--------------------------\n" +
				"Marca: " + this.getMarca() +  "\n" +
				"Escolha do Automovel: " + this.getTipoAuto() + "\n" +
                                "Preço em R$: " + this.getPreco() + "\n";
		return retorno;
	}
}


