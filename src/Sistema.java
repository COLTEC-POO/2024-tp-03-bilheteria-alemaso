import java.util.*;

import Evento.Evento;
import Evento.Tipos.Concerto;
import Evento.Tipos.Teatro;
import Evento.Tipos.Filme;
import Ingresso.Ingresso;
import Ingresso.Tipos_Ingressos.IngressoVIP;
import Ingresso.Tipos_Ingressos.Ingresso_Normal;
import Ingresso.Tipos_Ingressos.Meia_Entrada;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Sistema{

    public static void main(String[] args) {
        Sistema bilheteria = new Sistema();

        Evento[] eventos = new Evento[15]; // Atualmente, é um array estático
        int numEventos = 0; // Índice do array eventos

        JOptionPane.showMessageDialog(null, "Olá!!! Seja bem-vindo a nossa BILHETERIA!!!");

        boolean sair = false;
        do{
            String[] itens = {"Cadastrar eventos", "Comprar ingressos", "Mostrar eventos", "Relatorio de receitas", "Encerrar o sistema"};
            String opcao = JOptionPane.showInputDialog(null, "Escolha uma ação", "Bilheteria",
                    JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]).toString();

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
        tipoEvento = JOptionPane.showInputDialog(null, "Escolha o tipo de evento a ser cadastrado", "Cadastro",
                JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]).toString();
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
            s += "================================\n";
            s += eventos[i].toString();

            int ingressosDisponiveis = eventos[i].getQtdIngressos() - eventos[i].getTotalIngressosVendidos();

            s += "\nNúmero de ingressos disponíveis: " + ingressosDisponiveis;

            int[] maxIngressos = eventos[i].getMaxIngressos();
            for (int j = 0; j < 3; j ++){
                if(maxIngressos[j] > -1){
                    if (j == 1) {
                        s += "\nMeia-entradas disponíveis: ";
                    } else if (j == 2) {
                        s += "\nIngressos VIP disponíveis: ";
                    }

                    if (maxIngressos[j] < ingressosDisponiveis) {
                        s += maxIngressos[j] + "\n";
                    } else {
                        s += ingressosDisponiveis + "\n";
                    }
                }
            }

            if (i == numEventos - 1)
                s += "================================\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }

    void comprarIngressos(Evento[] eventos, int numEventos){
        String[] opcoesEvento = new String[numEventos];
        for(int i = 0; i < numEventos; i++) {
            opcoesEvento[i] = eventos[i].getNome();
        }

        String item = JOptionPane.showInputDialog(null, "Selecione o evento", "Compra de ingressos",
                JOptionPane.INFORMATION_MESSAGE, null, opcoesEvento, opcoesEvento[0]).toString();

        int indiceEvento = -1;
        if (item != null) {
            for (int i = 0; i < numEventos; i++) {
                if (item == opcoesEvento[i]) {
                    indiceEvento = i;
                    break;
                }
            }
        }

        String[] opcoesIngresso = {"Normal", "Meia", "VIP"};
        item = JOptionPane.showInputDialog(null, "Selecione o tipo de ingresso", "Compra de ingressos",
                JOptionPane.INFORMATION_MESSAGE, null, opcoesIngresso, opcoesIngresso[0]).toString();

        int indiceTipoIngresso = -1;
        for (int i = 0; i < opcoesIngresso.length; i++) {
            if (item == opcoesIngresso[i]) {
                indiceTipoIngresso = i;
                break;
            }
        }

        int numIngressosComprados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de ingressos a serem comprados:"));

        if ((eventos[indiceEvento].getMaxIngressos()[indiceTipoIngresso] >= numIngressosComprados
                || eventos[indiceEvento].getMaxIngressos()[indiceTipoIngresso] == -1)
                && eventos[indiceEvento].getTotalIngressosVendidos() + numIngressosComprados <= eventos[indiceEvento].getQtdIngressos() ){ // Sucesso na compra

            //Atualiza o array com o novo máximo de ingressos
            int[] novoMaximo = eventos[indiceEvento].getMaxIngressos();
            if(novoMaximo[indiceTipoIngresso] > -1)
                novoMaximo[indiceTipoIngresso] -= numIngressosComprados;
            eventos[indiceEvento].setMaxIngressos(novoMaximo);

            Ingresso[] ingressos = new Ingresso[eventos[indiceEvento].getQtdIngressos()];
            for (int i = 0; i < eventos[indiceEvento].getTotalIngressosVendidos(); i++){
                ingressos[i] = eventos[indiceEvento].getIngressos()[i];
            }

            //Instancia o numero ingressos comprados no array de ingressos com sua respectiva subclasse
            switch (indiceTipoIngresso){
                case 0:
                    for (int i = 0; i < numIngressosComprados; i++){
                        ingressos[eventos[indiceEvento].getTotalIngressosVendidos()] = new Ingresso_Normal(new Date(), eventos[indiceEvento].getPreco());
                        eventos[indiceEvento].setTotalIngressosVendidos(eventos[indiceEvento].getTotalIngressosVendidos() + 1); // ingressosVendidos++
                    }
                    break;

                case 1:
                    for (int i = 0; i < numIngressosComprados; i++){
                        ingressos[eventos[indiceEvento].getTotalIngressosVendidos()] = new Meia_Entrada(new Date(), eventos[indiceEvento].getPreco());
                        eventos[indiceEvento].setTotalIngressosVendidos(eventos[indiceEvento].getTotalIngressosVendidos() + 1); // ingressosVendidos++
                    }
                    break;

                case 2:
                    for (int i = 0; i < numIngressosComprados; i++){
                        ingressos[eventos[indiceEvento].getTotalIngressosVendidos()] = new IngressoVIP(new Date(), eventos[indiceEvento].getPreco());
                        eventos[indiceEvento].setTotalIngressosVendidos(eventos[indiceEvento].getTotalIngressosVendidos() + 1); // ingressosVendidos++
                    }
                    break;
            }

            eventos[indiceEvento].setIngressos(ingressos);
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha na compra: sem ingressos disponíveis.");
        }
    }

    void relatorioDeReceitas(Evento[] eventos, int numEventos){
        String s = "";
        String[] opcoesEvento = new String[numEventos + 1];
        for(int i = 0; i < numEventos; i++) {
            opcoesEvento[i] = eventos[i].getNome();
        }

        opcoesEvento[numEventos] = "Relatório geral";
        String item = (String) JOptionPane.showInputDialog(null, "Selecione o evento", "Compra de ingressos",
                JOptionPane.INFORMATION_MESSAGE, null, opcoesEvento, opcoesEvento[0]);

        int indiceEvento = numEventos;
        for (int i = 0; i < numEventos; i++) {
            if (item == opcoesEvento[i]) {
                indiceEvento = i;
                break;
            }
        }

        if (indiceEvento == numEventos) { // Relatório geral
            double total = 0;
            for (int i = 0; i < numEventos; i++){
                total += eventos[i].calculaReceita();
                s += "================================\n";
                s += eventos[i].exibeExtrato() + "\n";
            }
            s += "================================\n";
            s += "Renda total acumulada: R$" + total;
        } else { // Relatório de evento
            s += "================================\n";
            s += eventos[indiceEvento].exibeExtrato() + "\n";
            s += "================================\n";
            for (int i = 0 ; i < eventos[indiceEvento].getTotalIngressosVendidos(); i++){
                s += eventos[indiceEvento].getIngressos()[i].exibeExtrato() + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, s);
    }

}