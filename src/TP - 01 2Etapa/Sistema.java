import java.time.LocalDateTime;
import java.util.*;

import Evento.Evento;
import Evento.Tipos.Concerto;
import Evento.Tipos.Teatro;
import Evento.Tipos.Filme;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class Sistema{           

    //scanner do sistema
    public Scanner sc = new Scanner(System.in);

    public void cadastrar_eventos()
    {

        Object tipoEvento;
        String nome_evento;
        String local_evento;
        Date data_evento;
        float preco_ingresso;
        String opcao;


        JOptionPane.showMessageDialog(null, "Vamos comecar o cadastro de eventos!!!");
        JOptionPane.showMessageDialog(null, "Qual tipo de evento voce ira cadastrar\nEscolha as opcoes a seguir:\n[c] - concerto \n [f] - filme \n [t] - teatro");
        String [] itens = {"Concerto" , "Filme" , "Teatro"}; 
        tipoEvento = JOptionPane.showInputDialog(null, "Escolha um dos eventos", "Opcoes",JOptionPane.INFORMATION_MESSAGE, null,itens, itens [0]); 
    
        opcao = tipoEvento.toString();
       
        nome_evento = JOptionPane.showInputDialog("Digite o nome do evento : ");

        
        local_evento =  JOptionPane.showInputDialog("Digite o Local do evento : ");

       
        preco_ingresso =  Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do ingresso"));

        
        switch (opcao) {
            case "Concerto":

                Evento concerto = new Concerto(nome_evento, null, local_evento, preco_ingresso);
               

                break;

            case "Filme":
                Evento filme = new Filme(nome_evento, null, local_evento, preco_ingresso);

                break;

            case "Teatro":
                Evento teatro = new Teatro(nome_evento, null, local_evento, preco_ingresso);
                break;
            default:
            JOptionPane.showMessageDialog(null, "Opcao invalida","Alerta de uso !!!", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    public static void main(String[] args) 
    {
        int opcao;
        Sistema bilheteria = new Sistema();
        Date d = new Date();
        
        //area do funcionario fazer a manuntencao do sistema
        JFrame frame = new JFrame("");
        System.out.println(d);
        JOptionPane.showMessageDialog(null, "Olá !!! Seja Bem Vindo a nossa BILHETERIA!!!");
        do{
            //menu simples + escolha de opcao
            JOptionPane.showMessageDialog(null, "Area do Funcionario");
            JOptionPane.showMessageDialog(null, "[0] - Para Encerrar o sistema\n[1] - Para o Cadastro de Eventos\n[2] - Para a Venda de Ingressos\n[3] - Para a Mostrar Eventos\n[4] - Para Mostrar Ingressos\n[5] - Para mostrar o Relatorio de receitas");
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao"));

          

            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando");
                    break;

                case 1:
                    bilheteria.cadastrar_eventos();
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Opcao invalida","Alerta de uso !!!", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        }while(opcao != 0);
        
    }

}