public class Jogador {
    
    public int vida;
    public int exp;
    public int ouro;

    public Jogador(int vida, int exp, int ouro) {
        this.vida = vida;
        this.exp = exp;
        this.ouro = ouro;
    }

    public void perderVida(int vidaPerdida){
        this.vida -= vidaPerdida;
    }

    public void ganharVida(int maisVida){
        this.vida += maisVida;
    }
    public void perderOuro(int ouroPerdido){
        this.ouro -= ouroPerdido;
    }
    public void ganharOuro(int ouroGanho){
        this.ouro -= ouroGanho;
    }
    public void ganharExp(int expGanho){
        this.exp += expGanho;
    }
    public void perderExp(int expPerdido){
        this.exp -= expPerdido;
    }
}
