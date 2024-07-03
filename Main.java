import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner (System.in);

        System.out.print("##--Escolha uma alternativa--##\n");
        System.out.print("|------------------------------|\n");
        System.out.print("|  1  -  Novo Jogo             |\n");
        System.out.print("|  2  -  Carregar jogo         |\n");
        System.out.print("|  3  -  Sair                  |\n");
        System.out.print("|------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = scn.nextInt();

        switch (opcao) {
            case 1: 
                Jogador player1 = new Jogador(50, 0, 0);
                Jogador player2 = new Jogador(50, 0, 0);
                System.out.println("...Que vença o melhor!...\n");
                Tabuleiro firstBoard = new Tabuleiro();
                firstBoard.mostreTab();
                boolean jogoOn = player1.vida > 0 && player2.vida > 0;
                while(jogoOn){
                    System.out.println("Turno do Player 1:");
                    firstBoard.selecao();
                    firstBoard.atualizarTabuleiro();
                    firstBoard.mostreTab();
                    if (player2.vida <= 0) {
                        System.out.println("PARABENS PELA VITORIA PLAYER 1");
                        break;
                    }
                    if (player2.vida > 0){
                        System.out.println("Turno do Player 2:");
                        firstBoard.selecao();
                        firstBoard.atualizarTabuleiro();
                        firstBoard.mostreTab();
                    }
                    if (player1.vida<= 0){
                        System.out.println("PARABENS PELA VITORIA PLAYER 2");
                        break;                      
                    }
                }
            case 2: 
                System.out.print("\nCarregando jogo...\n");
                // chamar save
                break;
            case 3: 
                System.out.println("\nAté logo!");
                scn.close();
            default: 
                System.out.print("\nOpção Inválida!");
                break;
         
        }
    }
}