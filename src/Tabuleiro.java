public class Tabuleiro {
    protected String[][] tabu = new String[3][3];
    private int cont = 0;

    public Tabuleiro() {

    }

    public void criaTabu() {
        for (int i = 0; i < tabu.length; i++) {
            for (int j = 0; j < tabu.length; j++) {
                cont++;
                String x = Integer.toString(cont);
                tabu[i][j] = x;

            }
        }
    }

    public void mostraTabu() {
      System.out.println( );
        System.out.println("-------------");
        for (int i = 0; i < tabu.length; i++) {
            for (int j = 0; j < tabu.length; j++) {
                System.out.print("| " + tabu[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
        System.out.println( );
    }

    public String getPsc(int coluna, int linha) {
        return tabu[coluna][linha];
    }

    public void setPsc(int linha, int coluna, int jogador) {
        if (jogador == 1) {
            tabu[linha][coluna] = "X";
        } else {
            tabu[linha][coluna] = "O";
        }

        mostraTabu();
    }

    public int checa() {
        for (int i = 0; i < tabu.length; i++) {
            if ((tabu[i][0] == "X") & (tabu[i][1] == "X") & (tabu[i][2] == "X")) {
                return 1;
            }
            if ((tabu[i][0] == "O") & (tabu[i][1] == "O") & (tabu[i][2] == "O")) {
                return 2;
            }

            if ((tabu[0][i] == "X") & (tabu[1][i] == "X") & (tabu[2][i] == "X")) {
                return 1;
            }
            if ((tabu[0][i] == "O") & (tabu[1][i] == "O") & (tabu[2][i] == "O")) {
                return 2;
            }
            }
            if ((tabu[0][0] == "X") & (tabu[1][1] == "X") & (tabu[2][2] == "X")) {
            return 1;
             }
            if ((tabu[0][0] == "O") & (tabu[1][1] == "O") & (tabu[2][2] == "O")) {
            return 2;
            }
            if ((tabu[0][2] == "X") & (tabu[1][1] == "X") & (tabu[2][0] == "X")) {
            return 1;
            }
            if ((tabu[0][2] == "O") & (tabu[1][1] == "O") & (tabu[2][0] == "O")) {
            return 2;
            }

        return 0;
    }

    public String[][] getTabu() {
        return tabu;
    }

    public void setTabu(String[][] tabu) {
        this.tabu = tabu;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

}