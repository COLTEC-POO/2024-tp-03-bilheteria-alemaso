
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Evento.Evento;
import Evento.Tipos.Concerto;
import Evento.Tipos.Teatro;
import Evento.Tipos.Filme;
import javax.swing.JOptionPane;

public class Sistema{

    public static void main(String[] args) {
        Sistema bilheteria = new Sistema();

        Evento[] eventos = new Evento[15]; // Atualmente, é um array estático
        int numEventos = 0; // Índice do array eventos

        JOptionPane.showMessageDialog(null, "Olá!!! Seja bem-vindo a nossa BILHETERIA!!!");

        boolean sair = false;
        do{
            String[] itens = {"Cadastrar eventos", "Comprar ingressos", "Mostrar eventos", "Mostrar ingressos", "Relatorio de receitas", "Encerrar o sistema"};
            String opcao = JOptionPane.showInputDialog(null, "Escolha uma ação", "Bilheteria", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]).toString();

            switch (opcao) {
                case "Cadastrar eventos":
                    eventos[numEventos] = bilheteria.cadastrarEvento();
                    numEventos++;
                    break;

                case "Comprar ingressos":
                    bilheteria.comprarIngressos(eventos, numEventos);
                    break;

                case "Mostrar eventos":
                    bilheteria.mostrarEventos(eventos, numEventos);
                    break;

                case "Mostrar ingressos":
                    bilheteria.mostrarIngressos(eventos, numEventos);
                    break;

                case "Relatorio de receitas":
                    bilheteria.relatorioDeReceitas(eventos, numEventos);
                    break;

                case "Encerrar o sistema":
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    sair = true;
                    break;
            }

        }while(sair == false);
    }

    Evento cadastrarEvento(){
        String tipoEvento;
        String nomeEvento;
        String localEvento;
        Date dataEvento = null;
        float precoIngresso;
        String data_evento;
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy , HH:mm");


        String [] itens = {"Concerto", "Filme", "Teatro"};
        tipoEvento = JOptionPane.showInputDialog(null, "Escolha o tipo de evento a ser cadastrado", "Cadastro", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]).toString();
        nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento :");
        localEvento = JOptionPane.showInputDialog("Digite o local do evento :");
        data_evento = JOptionPane.showInputDialog("Informe a data do Evento no formato : dd/MM//yyyy , HH:mm :");
        try
        {
            dataEvento = formato.parse(data_evento);
        }
        catch(ParseException z)
        {
            z.printStackTrace();
        }

        do {
            precoIngresso = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do ingresso:"));
        } while (precoIngresso < 0);

        Evento e;
        switch (tipoEvento) {
            case "Concerto":
                e = new Concerto(nomeEvento, dataEvento, localEvento, precoIngresso);
                break;

            case "Filme":
                e = new Filme(nomeEvento, dataEvento, localEvento, precoIngresso);
                break;

            case "Teatro":
                e = new Teatro(nomeEvento, dataEvento, localEvento, precoIngresso);
                break;

            default: // Esse caso nunca acontece, está aqui para burlar o java
                e = new Concerto(nomeEvento, dataEvento, localEvento, precoIngresso);
                break;
        }
        return e;
    }

    void mostrarEventos(Evento[] eventos, int numEventos){
        String s = "";
        for (int i = 0; i < numEventos; i++){
            s += eventos[i].toString(); 
            if (i == numEventos - 1) // Tira o último espaço
                break;
            s += "\n\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }

    void comprarIngressos(Evento[] eventos, int numEventos){
        String[] itens = new String[numEventos];
        for(int i = 0; i < numEventos; i++) {
            itens[i] = eventos[i].getNome();
            
        }

        JOptionPane.showInputDialog(null, "Selecione o evento", "Compra de ingressos", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
        // Tem que achar um jeito de transformar esse input no índice de eventos[] pra podermos usar nacompra de ingressos
        // Compra ingressos aqui
    }

    void mostrarIngressos(Evento[] eventos, int numEventos){
        String s = "";
        for (int i = 0; i < numEventos; i++){
            s += eventos[i].getNome();

            // A quantidade e tipo de cada ingresso disponível vai aqui

            if (i == numEventos - 1) // Tira o último espaço
                break;
            s += "\n\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }

    void relatorioDeReceitas(Evento[] eventos, int numEventos){
        String s = "";
        double total = 0;
        for (int i = 0; i < numEventos; i++){
            s += eventos[i].getNome();

            // A receita gerada por cada evento vai aqui
            // total += evento[i].calculaReceita();

            s += "\n\n";
        }
        s += "Total de receita acumulada: R$" + total;
        JOptionPane.showMessageDialog(null, s);
    }

}
