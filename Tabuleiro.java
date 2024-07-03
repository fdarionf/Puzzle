import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    private Random rand;
    private int [][] tab;
    private Scanner scan = new Scanner(System.in);
    private boolean vai  = true;
    private boolean[][] secPoint;

    public Tabuleiro(){  //CONSTRUTOR\\
        rand = new Random();
        tab  = new int[8][8];
        comecaTab();
        consertaTab();
    }

    private void comecaTab(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tab[i][j] = rand.nextInt(7) + 1;
            }
        }
    }

        /*public void trocaNum(){ //checar o file referencias
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (tab[i][j]){
                    case 1: 
                        tab[i][j] = Integer.parseInt("A");
                    case 2: 
                        tab[i][j] = Integer.parseInt("R");
                }
            }
        }
    }*/

    private int novoValor(int valorAtual) {
        int novoValor = valorAtual;
        while (novoValor == valorAtual) {
            novoValor = rand.nextInt(7) + 1;
        }
        return novoValor;
    }

    private void consertaTab() {
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 8; j++) {
                if (tab[i][j] == tab[i][j-1] && tab[i][j] == tab[i][j-2]) {
                    tab[i][j] = novoValor(tab[i][j]);
                }
            }
        }

        for (int j = 0; j < 8; j++) {
            for (int i = 2; i < 8; i++) {
                if (tab[i][j] == tab[i-1][j] && tab[i][j] == tab[i-2][j]) {
                    tab[i][j] = novoValor(tab[i][j]);
                }
            }
        }
    }

    public void mostreTab(){
        for(int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                System.out.printf("[%d] ", tab[i][j]);
            }
            System.out.println();
        }
    }

    private void inicializasecPoint() {
        secPoint = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                secPoint[i][j] = false;
            }
        }
    }


    public void verificaHorizontal() {  //Verifica as peças na horizontal e as marca
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (tab[i][j] == tab[i][j + 1] && tab[i][j] == tab[i][j + 2]) {
                    secPoint[i][j]     = true;
                    secPoint[i][j + 1] = true;
                    secPoint[i][j + 2] = true;
                }
            }
        }
    }
    
    public void verificaVertical() { //Verifica as peças na vertical e as marca
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 6; i++) {
                if (tab[i][j] == tab[i + 1][j] && tab[i][j] == tab[i + 2][j]) {
                    secPoint[i][j]     = true;
                    secPoint[i + 1][j] = true;
                    secPoint[i + 2][j] = true;
                }
            }
        }
    }

    private void removePecas() {
        for (int j = 0; j < 8; j++) {
            for (int i = 7; i >= 0; i--) {
                if (secPoint[i][j]) {
                    for (int k = i; k > 0; k--) {
                        tab[k][j] = tab[k - 1][j];
                    }
                    tab[0][j] = rand.nextInt(7) + 1;
                }
            }
        }
    }
    
    public void atualizarTabuleiro() {
        boolean houveRemocao;
        do {
            inicializasecPoint();
            verificaHorizontal();
            removePecas();
            houveRemocao = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (secPoint[i][j]) {
                        houveRemocao = true;
                    }
                }
            }
        } while (houveRemocao);
    
            // Agora, verifica sequências verticais
        do {
            inicializasecPoint();
            verificaVertical();
            removePecas();
            houveRemocao = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (secPoint[i][j]) {
                        houveRemocao = true;
                    }
                }
            }
        } while (houveRemocao);
    }

    public void selecao() {
        int i   = 0;
        int j   = 0;
            vai = true;
        System.out.println("Selecione as coordenadas da peça a qual você deseja mexer, primeiro linha depois coluna");
        while(vai) {
            i = scan.nextInt();
            j = scan.nextInt();
            if (i > 7 || j > 7) {
                System.out.println("Uma das coordenadas está errada, tente novamente (Valor mín: 0; Valor max: 7)");
            }else{
                vai = false;
            }
        }
        int aux;
        System.out.println("Agora escolha a direção de acordo com as teclas WASD");
        vai = true;
        while(vai) {
        String direcao = scan.next();
            switch (direcao) {
                case "w": 
                    if(i<=0){
                        break;
                    }
                    aux           = tab[i-1][j];
                    tab[i - 1][j] = tab[i][j];
                    tab[i][j]     = aux;
                    vai           = false;
                    break;
                case "a": 
                    if(j<=0){
                        break;
                    }
                    aux         = tab[i][j-1];
                    tab[i][j-1] = tab[i][j];
                    tab[i][j]   = aux;
                    vai         = false;
                    break;
                case "s": 
                    if(i==7){
                        break;
                    }
                    aux         = tab[i+1][j];
                    tab[i+1][j] = tab[i][j];
                    tab[i][j]   = aux;
                    vai         = false;
                    break;
                case "d": 
                    if (j==7){
                        break;
                    }
                    aux         = tab[i][j+1];
                    tab[i][j+1] = tab[i][j];
                    tab[i][j]   = aux;
                    vai         = false;
                    break;
            }
            if(vai) {
                System.out.println("Movimento inválido, tente novamente");
            }
        }
    }
}