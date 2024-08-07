import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Sistema{

    //scanner do sistema
    public Scanner sc = new Scanner(System.in);

    public void cadastrar_eventos(){

    }
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Bilheteria TP 03");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton btn = new JButton();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 300);
        panel.setSize(100,100);
        frame.setLayout(new BorderLayout());
        
        label.setText("Bem vindo à Bilheteria da paixão e força alemã!");

        panel.add(label, BorderLayout.CENTER);
        
        btn.setText("Start");
        frame.add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> JOptionPane.showMessageDialog(null, "OKa"));

        frame.add(panel);

        frame.setVisible(true);
        
        int opcao;
        Sistema bilheteria = new Sistema();
        Date d = new Date();
        //area do funcionario fazer a manuntencao do sistema
        System.out.println("BEM VINDO A NOSSA BILHETERIA!!!");
        System.out.println(d);
        System.out.println("-------------------------------");
        do{
            //menu simples
            System.out.println("Area do Funcionario : ");
            System.out.println("[0] - Encerrar sistema");
            System.out.println("-------------------------------");
            System.out.println("[1] - Cadastro de Eventos");
            System.out.println("-------------------------------");
            System.out.println("[2] - Venda de Ingressos");
            System.out.println("-------------------------------");
            System.out.println("[3] - Mostrar Eventos ");
            System.out.println("-------------------------------");
            System.out.println("[4] - Mostrar Ingressos ");
            System.out.println("-------------------------------");
            System.out.println("[5] - Relatorio de receitas");
            System.out.println("-------------------------------");
            opcao = bilheteria.sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando ... ...");
                    break;

                case 1:
                    bilheteria.cadastrar_eventos();
                    break;
                default:
                    System.out.println("Opcao Invalida , tente novamente (UMA OPCAO CORRETA) ... ");
                    break;
            }

        }while(opcao != 0);
        
    }

}