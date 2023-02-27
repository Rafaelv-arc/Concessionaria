
package com.mycompany.informacoes;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Rafael, Maria, Gezeel, Isaque e Vitor
 */

// Vetores
public class Informacoes {
     public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public Carro leCarro (){

        String [] valores = new String [2];
        String [] nomeVal = {"Modelo(Texto)", " a Marca do Veiculo ou Automovel", "o tipo do Cambio", "Preço em R$"};
        valores = leValores (nomeVal);

        Carro atlCar = new Carro (valores[0],valores[1],valores[2],valores[3]);
        return atlCar;
    }

    public Caminhao leCaminhao (){

        String [] valores = new String [2];
        String [] nomeVal = {"Modelo(Texto)", "a Marca do Veiculo ou Automovel", "Carga", "Preço em R$"};
        valores = leValores (nomeVal);

        Caminhao atlCam = new Caminhao (valores[0],valores[1],valores[2],valores[3]);
        return atlCam;
    }

    public Moto leMoto (){

        String [] valores = new String [2];
        String [] nomeVal = {"Modelo(Texto)", "a Marca do Veiculo ou Automovel", "Cilindrada", "Preço em R$"};
        valores = leValores (nomeVal);

        Moto atlMoto = new Moto (valores[0],valores[1],valores[2],valores[3]);
        return atlMoto;
    }

    // Métodos
    
    public void mostraVeiculo(String dados){
        JOptionPane.showMessageDialog(null,"VEICULO\n-------\n +" +dados);
    }

    // com tratamento de erro
    
    public void salvaVeiculos (ArrayList<Comercio> comercio1){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("AQUI VAI O CAMINHO ATÉ CHEGAR NO ARQUIVO\\ProjetoJava\\Codigo\\informações.txt"));
            for (int i=0; i < comercio1.size(); i++)
                outputStream.writeObject(comercio1.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
        } catch (IOException ex) {
        } finally {  
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    // ArrayList
    
    @SuppressWarnings("finally")
    public ArrayList<Comercio> recuperaVeiculos (){
        ArrayList<Comercio> comercio2 = new ArrayList<Comercio>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("AQUI VAI O CAMNHO ATÉ CHEGAR NO ARQUIVO\\"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Comercio) {
                    comercio2.add((Comercio) obj);
                }
            }
        } catch (EOFException ex) { 
            System.out.println("End of file reached.");
        } catch (ClassNotFoundException | IOException ex) {
        } finally {  //Close the ObjectInputStream
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
            }
            return comercio2;
        }
    }

    // ArrayList e switch(case)
    public void menuVeiculos (){

        ArrayList<Comercio> comercio3 = new ArrayList<>();


        String menu = "";
        String entrada;
        int opc1, opc2;

        do {
            menu = "Controle \n" +
                    "Opções:\n" +
                    "1. Entrar Veiculos\n" +
                    "2. Exibir Veiculos\n" +
                    "3. Limpar Veiculos\n" +
                    "4. Gravar Veiculos\n" +
                    "5. Recuperar Veiculos\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");

            while (!numeroInteiroValido(entrada)) {
                entrada = JOptionPane.showInputDialog(null, menu +
                        "\n\nEntrada inválida! Digite um número inteiro.");
            }
            opc1 = Integer.valueOf(entrada);

            switch (opc1) {
                case 1 -> {
                    // Entrar dados
                    menu = "Entrada de Veiculos \n" +
                            "Opções:\n" +
                            "1. Carro\n" +
                            "2. Caimhao\n" +
                            "3. Moto\n";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    while (!numeroInteiroValido(entrada)) {
                        entrada = JOptionPane.showInputDialog(null, menu +
                                "\n\nEntrada inválida! Digite um número inteiro.");
                    }
                    opc2 = Integer.valueOf(entrada);

                    switch (opc2){
                        case 1: comercio3.add((Comercio) leCarro());
                        break;
                        case 2: comercio3.add((Comercio) leCaminhao());
                        break;
                        case 3: comercio3.add((Comercio) leMoto());
                        break;
                        default:
                            JOptionPane.showMessageDialog(null,"Veiculo para entrada NÃO escolhido!");
                    }
                }
                case 2 -> {
                    // Exibir dados
                    if (comercio3.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Entre com as informações primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < comercio3.size(); i++)	{
                        dados += comercio3.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                }
                case 3 -> {
                    // Limpar Dados
                    if (comercio3.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Entre com as informações primeiramente");
                        break;
                    }
                    comercio3.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                }
                case 4 -> {
                    // Grava Dados
                    if (comercio3.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Entre com as informações primeiramente");
                        break;
                    }
                    salvaVeiculos(comercio3);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                }
                case 5 -> {
                    // Recupera Dados
                    comercio3 = recuperaVeiculos();
                    if (comercio3.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                }
                case 9 -> JOptionPane.showMessageDialog(null,"Fim");
            }
        } while (opc1 != 9);
    }

    private boolean numeroInteiroValido(String s) {
        boolean resultado;
        try {
            Integer.parseInt(s);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }
        return resultado;
    }
    
    
    
// Execução !!!!!!!!!!
    
    
    public static void main (String [] args){
        Informacoes info = new Informacoes ();
        info.menuVeiculos();
    }
}
