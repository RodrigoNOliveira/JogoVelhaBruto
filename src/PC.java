import java.util.Random;

public class PC extends Jogador{
    Random gerador = new Random();


    public PC(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("\nJogador COMPUTADOR iniciado");
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
            do {   
                escolha = gerador.nextInt(9) + 1;
                if (escolha < 1 || escolha > 9){
                    System.out.println("Escolha invalida.");
                }
            }while(escolha < 1 || escolha > 9);
            if (escolha > 0 & escolha < 4) {

                linha = 0;
                coluna = escolha;

            } else if (escolha > 3 & escolha < 7) {
                linha = 1;
                coluna = escolha - 4;
            } else {
                linha = 2;
                coluna = escolha - 7;

            }
            
        } while (!checaPsc(escolha, linha, coluna, tabu));
        
        
        
        }
        
    }