package Domino;

/**
 * Representara uma coordenada (x,y), que facilitara a introducao de uma peca na matriz
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Coordenadas {
    private final int x;
    private final int y;

    /**
     * Construtor da classe Coordenadas
     * @param x ira representar o x
     * @param y ira representar o y
     */
    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return valor de x
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return valor do y
     */
    public int getY(){
        return this.y;
    }
}
