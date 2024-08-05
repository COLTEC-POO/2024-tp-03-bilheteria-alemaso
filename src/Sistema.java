import java.util.*;



public class Sistema{

    //scanner do sistema
    public Scanner sc = new Scanner(System.in);

    public void cadastrar_eventos()
    {

    }
    public static void main(String[] args) 
    {
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