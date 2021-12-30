import java.util.Scanner;

public class Jogo {
    private Scanner scanner = new Scanner(System.in);    
    private Jogador jogador1;
    private Jogador jogador2;
    private int opcao;
    public Tabuleiro tabu;
    private int jogada = 0;

    public Jogo(){
        tabu = new Tabuleiro();

    }

    public void iniciar(){
        tabu.criaTabu();
        cdstJgdr();
        while ( Jogar() );
    }
    

    public void cdstJgdr(){
        System.out.println("Quem vai ser o Jogador 1: ");
        if(defJgd() == 1){
            this.jogador1 = new Humano(1);
        } else { this.jogador1 = new PC(1);}
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 1: ");
        if(defJgd() == 1){
            this.jogador2 = new Humano(2);
        } else { this.jogador2 = new PC(2);}
    }

    public int defJgd(){
        int opcao = 0;
        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            
            if(opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(opcao != 1 && opcao != 2);
        
        return opcao;
    }


    public boolean Jogar(){
        if (tabu.checa() == 0){
        jogada ++;
        System.out.println();
        System.out.println("Rodada: " + jogada);
        System.out.println("Vez do jogador " + jgd());


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
            System.out.println("Deu velha!");
            return false;}
            }
        return true;
    } else {
        if(tabu.checa() == 2){
            System.out.println("O jogador 1 ganhou!");
        } else if (tabu.checa()==1){
            System.out.println("O jogador 2 ganhou!");
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
