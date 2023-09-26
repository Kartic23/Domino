package Domino;

/**
 * Cria cada peca do Domino, representada por dois lados
 *
 * @inv lados >= 0
 * @inv 6 >= lados
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */

public class Peca{
    private int A;
    private int B;

    /**
     * Construtor da classe Peca
     * @pre x >= 0
     * @pre 6 >= x
     * @pre y >= 0
     * @pre 6 >= y
     * @param x vai representar o lado A da peca
     * @param y vai representar o lado B da peca
     */
    public Peca(int x,int y) {
        if(0 <= x && x <= 6 && 0 <= y && y <= 6){
            this.A = x;
            this.B = y;
        }
    }

    /**
     * @return o numero do lado A
     */
    public int getA() {
        return this.A;
    }

    /**
     * @return o numero do lado B
     */
    public int getB() {
        return this.B;
    }

    /**
     * Metodo que soma os dois lados da peca e retorna esse valor
     * @return o valor da soma dos lado da peca
     */
    public int total_peca(){
        return (this.A + this.B);
    }

    /**
     * @return true se for dupla, false nao for dupla
     */
    public boolean dupla(){
        return this.A == this.B;
    }


    @Override
    public String toString(){
        return this.A + "|" + this.B  + "; " ;
    }
}
