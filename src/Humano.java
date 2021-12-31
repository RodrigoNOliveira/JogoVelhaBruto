import java.util.Scanner;
import java.util.InputMismatchException;

public class Humano extends Jogador {
    private Scanner scanner= new Scanner(System.in);

    public Humano(int jogador) {
        super(jogador);
        this.jogador = jogador;

        System.out.println("\nJogador HUMANO iniciado");
    }

    @Override
    public void jogar(Tabuleiro tabu) {
        Escolha(tabu);
        if (escolha > 0 & escolha < 4) {

            linha = 0;
            coluna = escolha -1;
        }else if (escolha > 3 & escolha < 7) {
            linha = 1;
            coluna = escolha - 4;
        } else {
            linha = 2;
            coluna = escolha - 7;}
        tabu.setPsc(linha, coluna, jogador);
    }

    @Override
    public void Escolha(Tabuleiro tabu) {
        
          do {
            do {try {
                System.out.print("Digite a casa desejada: ");
                 
                escolha = scanner.nextInt();
                if (escolha < 1 || escolha > 9) {

                    System.out.println("\nEscolha invalida.\n");
                }
                }
                catch (InputMismatchException e){
                  System.out.println("\nOpção inválida! Digite um dos valores apresentados na tela!!!\n");
  
                  scanner.nextLine();
                }
            } while (escolha < 1 || escolha > 9);
          
            

            if (!checaPsc(escolha, linha, coluna, tabu)) {
                System.out.println("\nEsse local ja foi escolhido\n");
            }
        } while (!checaPsc(escolha, linha, coluna, tabu));

    
}
}