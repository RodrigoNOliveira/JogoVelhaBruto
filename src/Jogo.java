import java.util.Scanner;
import java.util.InputMismatchException;

public class Jogo {
    private Scanner scanner = new Scanner(System.in);    
    private Jogador jogador1;
    private Jogador jogador2;
    public Tabuleiro tabu;
    private int jogada = 0;

    public Jogo(){
        tabu = new Tabuleiro();

    }

    public void iniciar(){
        tabu.criaTabu();
        
        cdstJgdr();
        System.out.println();
        System.out.println();
        System.out.println("+-----------+");
        System.out.println("JOGO DA VELHA");
        System.out.println("+-----------+");
        tabu.mostraTabu();
        while ( Jogar() );
    }
    

    public void cdstJgdr(){
      System.out.println("----------------------");
        System.out.println("\nQuem vai ser o Jogador 1: \n");
        if(defJgd() == 1){
            this.jogador1 = new Humano(1);
        } else { this.jogador1 = new PC(1);}
        System.out.println("----------------------");
        System.out.println("\nQuem vai ser o Jogador 2: \n");
        if(defJgd() == 1){
            this.jogador2 = new Humano(2);
        } else { this.jogador2 = new PC(2);}
        System.out.println("----------------------");
    }

    public int defJgd(){
        int opcao = 0;
        do{
          System.out.println();
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");

            try {
            opcao = scanner.nextInt();
            if(opcao != 1 && opcao != 2)
                System.out.println("\nOpção inválida! Tente novamente\n");
            }
            catch (InputMismatchException e){
                  System.out.println("\nOpção inválida! Digite um dos valores apresentados na tela!!!\n");
  
                  scanner.nextLine();
                }
            
        }while(opcao != 1 && opcao != 2);
        
        return opcao;
    }


    public boolean Jogar(){
        if (tabu.checa() == 0){
        jogada ++;
        System.out.println();
        System.out.println("\n***** Rodada: " + jogada + " *****\n");
        System.out.println("Vez do jogador: " + jgd() + "\n");


        if (jgd() == 1){
            jogador1.jogar(tabu);
        }
        else {
            jogador2.jogar(tabu);
        }
        
        if (jogada == 9){
            if (tabu.checa() == 2 || tabu.checa() == 1){
                return true;
            }else {
            System.out.println("+---------------------+");
            System.out.println("|      Deu velha      |");
            System.out.println("+---------------------+");
            return false;}
            }
        return true;
    } else {
        if(tabu.checa() == 2){
            System.out.println("+---------------------+");
            System.out.println("| O jogador 1 ganhou! |");
            System.out.println("+---------------------+");
        } else if (tabu.checa()==1){
            System.out.println("+---------------------+");
            System.out.println("| O jogador 2 ganhou! |");
            System.out.println("+---------------------+");
        }
        return false;
    }
        }
    public int jgd(){
        if (jogada%2 != 0){
            return 1;
        }
        else return 2;

    }





}