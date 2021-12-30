public abstract class Jogador {
    protected int jogador;
    protected int escolha;
    protected int linha, coluna;



    public Jogador(int jogador){
        this.jogador = jogador;
    }


    public abstract void jogar(Tabuleiro tabu);

    public abstract void Escolha(Tabuleiro tabu);

    public boolean checaPsc(int escolha ,int linha, int coluna, Tabuleiro tabu){

        
        if (escolha > 0 & escolha < 4) {

            linha = 0;
            coluna = escolha -1;
            if(tabu.getPsc(linha,coluna) != "X" &(tabu.getPsc(linha,coluna) != "O" )){
              
                return true;
            }else {
                return false;
            }

        }else if (escolha > 3 & escolha < 7) {
            linha = 1;
            coluna = escolha - 4;
            if(tabu.getPsc(linha,coluna) != "X" &(tabu.getPsc(linha,coluna) != "O" )){
               
                return true;} else {
                    return false;
                }
        } else {
            linha = 2;
            coluna = escolha - 7;
            if(tabu.getPsc(linha,coluna) != "X" & (tabu.getPsc(linha,coluna) != "O" )){
               
                return true;}else {
                    return false;
                }

        }

            
        
    }
}
