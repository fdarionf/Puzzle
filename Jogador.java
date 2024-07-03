public class Jogador {
    
    public int vida;
    public int exp;
    public int ouro;

    public Jogador(int vida, int exp, int ouro) {
        this.vida = vida;
        this.exp = exp;
        this.ouro = ouro;
    }

    public int getVida() {
        return vida;
    }

    public int getExp() {
        return exp;
    }

    public int getOuro() {
        return ouro;
    }
}
