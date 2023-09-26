package Domino;
import java.util.ArrayList;
import java.util.Objects;

/**
 * E onde vamos guardar as pecas que serao jogadas. Responsavel pela adicao de uma peca e pela contagem de jogadas
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Tabuleiro {
    String [][]A;
    private int n_jogadas;
    private final ArrayList<Coordenadas> cantos_coordenadas;
    private final ArrayList<Peca> cantos_valor;

    /**
     * Construtor do Tabuleiro
     * Cria o tabuleiro(matriz) e introduz um espaço branco em todos os lugares
     * Cria tambem as listas dos cantos e coordenadas
     * @post getN_jogadas = n_jogadas
     */
    public Tabuleiro(){
        this.A = new String[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                A[i][j] = " ";
            }
        }
        for (int i = 0; i < 100; i++) {
            this.A[0][i] = "_";
            if (i != 0){
                this.A[i][0] = "|";
            }
        }
        for (int i = 0; i < 100; i++) {
            this.A[99][i] = "_";
            if (i != 0 && i != 99){
                this.A[i][99] = "|";
            }
        }
        this.n_jogadas = 0;
        this.cantos_coordenadas = new ArrayList<>();
        this.cantos_valor = new ArrayList<>();
    }

    /**
     * @return o numero de jogadas
     */
    public int getN_jogadas(){ return this.n_jogadas; }


    /**
     * @return uma lista de pecas que sao os cantos
     */
    public ArrayList<Peca> getCantos_valor() {
        return cantos_valor;
    }


    /**
     * @return uma lista de coordenadas que sao as coordenadas dos cantos
     */
    public ArrayList<Coordenadas> getCantos_coordenadas() {
        return cantos_coordenadas;
    }

    /**
     * Metodo que adiciona um canto com a sua respetiva coordenada
     * @param A coordenada do canto
     * @param B Peca do canto, onde o lado A da peca representa o canto
     */
    public void add_Cantos(Coordenadas A, Peca B){
        this.cantos_coordenadas.add(A);
        this.cantos_valor.add(B);
    }


    /**
     * Metodo que remove um canto através de uma coordenada recebida
     * @pre A tem de pertencer a Lista de coordenadas
     * @post coordenada A removida
     * @param A coordenada a ser removida
     */
    public void remove_Cantos(Coordenadas A){
        int i;
        for(i=0 ; i < this.cantos_coordenadas.size();i++){
            if(this.cantos_coordenadas.get(i).getX() == A.getX() && this.cantos_coordenadas.get(i).getY() == A.getY()){
                break;
            }
        }
        this.cantos_coordenadas.remove(i);
        this.cantos_valor.remove(i);
    }

    /**
     * Metodo que adiciona ao tabuleiro uma peca horizontal no lado esquerdo
     * @pre x >= 0
     * @pre y >= 0
     * @post Peca esquerdo|direito adicionada
     * @param x valor da coordenada x
     * @param y valor da coordenada y
     * @param direito valor a ser colocado do lado direito
     * @param esquerdo valor a ser colocado do lado esquerdo
     */
    public void put_horizontal_esquerda(int x,int y,int direito, int esquerdo){
        this.A[y][x] = String.valueOf(direito);
        this.A[y][x-1] = String.valueOf(esquerdo);
    }

    /**
     * Metodo que adiciona ao tabuleiro uma peca horizontal no lado direito
     * @pre x >= 0
     * @pre y >= 0
     * @post Peca esquerdo|direito adicionada
     * @param x valor da coordenada x
     * @param y valor da coordenada y
     * @param esquerdo valor a ser colocado do lado esquerdo
     * @param direito valor a ser colocado do lado direito
     */
    public void put_horizontal_direita(int x,int y, int esquerdo, int direito){
        this.A[y][x] = String.valueOf(esquerdo);
        this.A[y][x+1] = String.valueOf(direito);
    }

    /**
     * Metodo que adiciona ao tabuleiro uma peca vertical em cima de uma peca
     * @pre x >= 0
     * @pre y >= 0
     * Peca cima|baixo adicionada
     * @param x valor da coordenada x
     * @param y valor da coordenada y
     * @param cima valor a ser colocado na parte de cima
     * @param baixo valor a ser colocado na parte de baixo
     */
    public void put_vertical_cima(int x,int y,int cima, int baixo){
        this.A[y][x] = String.valueOf(baixo);
        this.A[y-1][x] = "-";
        this.A[y-2][x] = String.valueOf(cima);
    }

    /**
     * Metodo que adiciona ao tabuleiro uma peca vertical em baixo de uma peca
     * @pre x >= 0
     * @pre y >= 0
     * Peca cima|baixo adicionada
     * @param x valor da coordenada x
     * @param y valor da coordenada y
     * @param cima valor a ser colocado na parte de cima
     * @param baixo valor a ser colocado na parte de baixo
     */
    public void put_vertical_baixo(int x,int y,int cima, int baixo){
        this.A[y][x] = String.valueOf(cima);
        this.A[y+1][x] = "-";
        this.A[y+2][x] = String.valueOf(baixo);
    }

    /**
     * Metodo que adiciona ao tabuleiro uma peca dupla vertical
     * @pre x >= 0
     * @pre y >= 0
     * Peca valor-valor adicionada
     * @param x valor da coordenada x
     * @param y valor da coordenada y
     * @param valor valor a ser colocado em cima e em baixo da coordenada recebida
     */
    public void put_dupla_vertical(int x, int y, int valor){
        this.A[y][x] = "-";
        this.A[y-1][x] = String.valueOf(valor);
        this.A[y+1][x] = String.valueOf(valor);
    }


    /**
     * Metodo que adiciona ao tabuleiro uma peca dupla horizontal
     * @pre x >= 0
     * @pre y >= 0
     * Peca valor-valor adicionada
     * @param x coordenada x
     * @param y coordenada y
     * @param valor valor de uma dos cantos da dupla
     */
    public void put_dupla_horizontal(int x, int y, int valor){
        this.A[y][x] = String.valueOf(valor) ;
        this.A[y][x+1] = "-";
        this.A[y][x+2] = String.valueOf(valor);
    }

    /**
     * Metodo que imprime todos os cantos jogaveis, onde o lado esquerdo corresponde ao lado do canto
     */
    public void print_cantos_coordenada(){
        System.out.println("Cantos Jogavéis:");
        for (int i = 0; i < this.cantos_coordenadas.size(); i++){
            System.out.println("Peca: " + this.cantos_valor.get(i).toString() );
        }
    }

    /**
     * Metodo que faz uma verificacao de todos os cantos, ou seja, verifica se algum dos cantos ja esta bloqueado ou nao
     * Os cantos a verificar serao todas as pecas verticais nao duplas e pecas horizontais nao duplas
     */
    public void check_cantos(){
        for (int i = 0; i < this.cantos_coordenadas.size(); i++) {
            if (Objects.equals(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX()], "-")) { //verifica se é vertical
                if (!Objects.equals(this.A[this.cantos_coordenadas.get(i).getY() - 1][this.cantos_coordenadas.get(i).getX()], this.A[this.cantos_coordenadas.get(i).getY() + 1][this.cantos_coordenadas.get(i).getX()])) { //verifica se n é dupla
                    if (this.cantos_valor.get(i).getA() == Integer.parseInt(this.A[this.cantos_coordenadas.get(i).getY() - 1][this.cantos_coordenadas.get(i).getX()])) { //verifica se o valor numerico é igual
                        if (!(this.A[this.cantos_coordenadas.get(i).getY() - 2][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() - 3][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() - 4][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() - 5][this.cantos_coordenadas.get(i).getX()]).equals("    ") || //verifica se todos os espaços em volta da peça colocavel são brancos, se sim então não existe colisão possivel (cima)
                                !(this.A[this.cantos_coordenadas.get(i).getY() - 2][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() - 3][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() - 4][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() - 5][this.cantos_coordenadas.get(i).getX() - 1]).equals("    ") ||
                                !(this.A[this.cantos_coordenadas.get(i).getY() - 2][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() - 3][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() - 4][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() - 5][this.cantos_coordenadas.get(i).getX() + 1]).equals("    ")) {

                            remove_Cantos(this.cantos_coordenadas.get(i));
                        }
                    } else if (this.cantos_valor.get(i).getA() == Integer.parseInt(this.A[this.cantos_coordenadas.get(i).getY() + 1][this.cantos_coordenadas.get(i).getX()])) {
                        if (!(this.A[this.cantos_coordenadas.get(i).getY() + 2][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() + 3][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() + 4][this.cantos_coordenadas.get(i).getX()] + this.A[this.cantos_coordenadas.get(i).getY() + 5][this.cantos_coordenadas.get(i).getX()]).equals("    ") || //verifica se todos os espaços em volta da peça colocavel são brancos, se sim então não existe colisão possivel (baixo)
                                !(this.A[this.cantos_coordenadas.get(i).getY() + 2][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() + 3][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() + 4][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY() + 5][this.cantos_coordenadas.get(i).getX() - 1]).equals("    ") ||
                                !(this.A[this.cantos_coordenadas.get(i).getY() + 2][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() + 3][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() + 4][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY() + 5][this.cantos_coordenadas.get(i).getX() + 1]).equals("    ")) {
                            remove_Cantos(this.cantos_coordenadas.get(i));
                        }
                    }
                }
            } else if (Integer.parseInt(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX()].substring(0, 1)) >= 0 && Integer.parseInt(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX()].substring(0, 1)) <= 6
                    && !Objects.equals(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 1], "-")) { //verifica se é uma peça horizontal não dupla (esquerda)
                if (Objects.equals(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() - 1], " ")) {
                    if (!(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() - 2] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() - 3] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() - 4]).equals("   ") //verifica se é possivel colocar as peças, se não, remove o canto
                            || !(this.A[this.cantos_coordenadas.get(i).getY()-1][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY()-2][this.cantos_coordenadas.get(i).getX() -1] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() - 1] +  this.A[this.cantos_coordenadas.get(i).getY()+1][this.cantos_coordenadas.get(i).getX() - 1] + this.A[this.cantos_coordenadas.get(i).getY()+2][this.cantos_coordenadas.get(i).getX() - 1]).equals("     ")) {
                        remove_Cantos(this.cantos_coordenadas.get(i));
                    }
                } else if (Objects.equals(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 1], " ")) { //verifica se é uma peça horizontal não dupla (direita)
                    if(!(this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 2] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 3] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 4]).equals("   ") //verifica se é possivel colocar as peças, se não, remove o canto
                    || !(this.A[this.cantos_coordenadas.get(i).getY()-1][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY()-2][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY()][this.cantos_coordenadas.get(i).getX() + 1] +  this.A[this.cantos_coordenadas.get(i).getY()+1][this.cantos_coordenadas.get(i).getX() + 1] + this.A[this.cantos_coordenadas.get(i).getY()+2][this.cantos_coordenadas.get(i).getX() + 1]).equals("     ")){

                        remove_Cantos(this.cantos_coordenadas.get(i));
                    }
                }
            }
        }
    }


    /**
     * Metodo que introduz uma peca numa peca vertical dupla
     * Ex:      +
     *          2
     *        + - +
     *          2
     *          +
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @param canto valor que correspondente a um dos lados da peca da coordenada recebida
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean introduzir_peca_dupla_vertical(Peca peca,Coordenadas P,int canto){
        boolean result = false;
        if((this.A[P.getY()][P.getX() - 1] + this.A[P.getY()][P.getX() - 2] + this.A[P.getY()][P.getX() - 3] +this.A[P.getY()][P.getX() - 4] +this.A[P.getY()][P.getX() - 5]).equals("     ")
                && (this.A[P.getY()-1][P.getX() - 1] + this.A[P.getY()-1][P.getX() - 2] + this.A[P.getY()-1][P.getX() - 3] +this.A[P.getY()-1][P.getX() - 4] +this.A[P.getY()-1][P.getX() - 5]).equals("     ")
                && (this.A[P.getY()+1][P.getX() - 1] + this.A[P.getY()+1][P.getX() - 2] + this.A[P.getY()+1][P.getX() - 3] +this.A[P.getY()+1][P.getX() - 4] +this.A[P.getY()+1][P.getX() - 5]).equals("     ")){
            //se estiver vazia à esquerda

            if(peca.getA() == canto) {
                result = true;
                put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()-3,P.getY()),new Peca(peca.getB(), peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()-3,P.getY()),new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY() - 2][P.getX()] + this.A[P.getY() - 3][P.getX()] + this.A[P.getY() - 4][P.getX()] + this.A[P.getY() - 5][P.getX()]).equals("    ")
                && (this.A[P.getY() - 2][P.getX()-1] + this.A[P.getY() - 3][P.getX()-1] + this.A[P.getY() - 4][P.getX()-1] + this.A[P.getY() - 5][P.getX()-1]).equals("    ")
                && (this.A[P.getY() - 2][P.getX()+1] + this.A[P.getY() - 3][P.getX()+1] + this.A[P.getY() - 4][P.getX()+1] + this.A[P.getY() - 5][P.getX()+1]).equals("    ")){
            //se estiver cheia à esquerda, vai para cima
            if(peca.getA() == canto) {
                result = true;
                put_vertical_cima(P.getX(),P.getY()-2, peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX(),P.getY()-3),new Peca(peca.getB(), peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_vertical_cima(P.getX(),P.getY()-2,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX(),P.getY()-3),new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY()][P.getX() + 1] + this.A[P.getY()][P.getX() + 2] + this.A[P.getY()][P.getX() + 3] +this.A[P.getY()][P.getX() + 4] +this.A[P.getY()][P.getX() + 5]).equals("     ")
                && (this.A[P.getY()-1][P.getX() + 1] + this.A[P.getY()-1][P.getX() + 2] + this.A[P.getY()-1][P.getX() + 3] +this.A[P.getY()-1][P.getX() + 4] +this.A[P.getY()-1][P.getX() + 5]).equals("     ")
                && (this.A[P.getY()+1][P.getX() + 1] + this.A[P.getY()+1][P.getX() + 2] + this.A[P.getY()+1][P.getX() + 3] +this.A[P.getY()+1][P.getX() + 4] +this.A[P.getY()+1][P.getX() + 5]).equals("     ")){
            //se estiver cheia à esquerda,e cima , vai para direita
            if(peca.getA() == canto) {
                result = true;
                put_horizontal_direita(P.getX()+2,P.getY(),peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()+3,P.getY()),new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_horizontal_direita(P.getX()+2,P.getY(), peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()+3,P.getY()),new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY() + 2][P.getX()] + this.A[P.getY() + 3][P.getX()] + this.A[P.getY() + 4][P.getX()] + this.A[P.getY() + 5][P.getX()]).equals("    ")
                && (this.A[P.getY() + 2][P.getX()-1] + this.A[P.getY() + 3][P.getX()-1] + this.A[P.getY() + 4][P.getX()-1] + this.A[P.getY() + 5][P.getX()-1]).equals("    ")
                && (this.A[P.getY() + 2][P.getX()+1] + this.A[P.getY() + 3][P.getX()+1] + this.A[P.getY() + 4][P.getX()+1] + this.A[P.getY() + 5][P.getX()+1]).equals("    ")){            //se estiver cheia à esquerda,cima ,direita, vai para baixo
            if(peca.getA() == canto) {
                result = true;
                put_vertical_baixo(P.getX(),P.getY()+2,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX(),P.getY()+3),new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_vertical_baixo(P.getX(),P.getY()+2, peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX(),P.getY()+3),new Peca(peca.getA(), peca.getB()));
            }
            remove_Cantos(P);
        }

        if(!(this.A[P.getY()][P.getX() - 1] + this.A[P.getY()][P.getX() - 2] + this.A[P.getY()][P.getX() - 3] +this.A[P.getY()][P.getX() - 4] +this.A[P.getY()][P.getX() - 5]).equals("     ")
                && !(this.A[P.getY()-1][P.getX() - 1] + this.A[P.getY()-1][P.getX() - 2] + this.A[P.getY()-1][P.getX() - 3] +this.A[P.getY()-1][P.getX() - 4] +this.A[P.getY()-1][P.getX() - 5]).equals("     ")
                && !(this.A[P.getY()+1][P.getX() - 1] + this.A[P.getY()+1][P.getX() - 2] + this.A[P.getY()+1][P.getX() - 3] +this.A[P.getY()+1][P.getX() - 4] +this.A[P.getY()+1][P.getX() - 5]).equals("     ")
                && !(this.A[P.getY() - 2][P.getX()] + this.A[P.getY() - 3][P.getX()] + this.A[P.getY() - 4][P.getX()] + this.A[P.getY() - 5][P.getX()]).equals("    ")
                && !(this.A[P.getY() - 2][P.getX()-1] + this.A[P.getY() - 3][P.getX()-1] + this.A[P.getY() - 4][P.getX()-1] + this.A[P.getY() - 5][P.getX()-1]).equals("    ")
                && !(this.A[P.getY() - 2][P.getX()+1] + this.A[P.getY() - 3][P.getX()+1] + this.A[P.getY() - 4][P.getX()+1] + this.A[P.getY() - 5][P.getX()+1]).equals("    ")
                && !(this.A[P.getY()][P.getX() + 1] + this.A[P.getY()][P.getX() + 2] + this.A[P.getY()][P.getX() + 3] +this.A[P.getY()][P.getX() + 4] +this.A[P.getY()][P.getX() + 5]).equals("     ")
                && !(this.A[P.getY()-1][P.getX() + 1] + this.A[P.getY()-1][P.getX() + 2] + this.A[P.getY()-1][P.getX() + 3] +this.A[P.getY()-1][P.getX() + 4] +this.A[P.getY()-1][P.getX() + 5]).equals("     ")
                && !(this.A[P.getY()+1][P.getX() + 1] + this.A[P.getY()+1][P.getX() + 2] + this.A[P.getY()+1][P.getX() + 3] +this.A[P.getY()+1][P.getX() + 4] +this.A[P.getY()+1][P.getX() + 5]).equals("     ")
                && !(this.A[P.getY() + 2][P.getX()] + this.A[P.getY() + 3][P.getX()] + this.A[P.getY() + 4][P.getX()] + this.A[P.getY() + 5][P.getX()]).equals("    ")
                && !(this.A[P.getY() + 2][P.getX()-1] + this.A[P.getY() + 3][P.getX()-1] + this.A[P.getY() + 4][P.getX()-1] + this.A[P.getY() + 5][P.getX()-1]).equals("    ")
                && !(this.A[P.getY() + 2][P.getX()+1] + this.A[P.getY() + 3][P.getX()+1] + this.A[P.getY() + 4][P.getX()+1] + this.A[P.getY() + 5][P.getX()+1]).equals("    ")){
            remove_Cantos(P);
        }
        return result;
    }


    /**
     * Metodo que adiciona uma peca dupla em cima/baixo de uma peca vertical
     * Ex:  +
     *      2
     *      -
     *      4
     *      +
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @param canto valor que correspondente a um dos lados da peca da coordenada recebida
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean introduzir_peca_dupla_em_cima_de_uma_peca_vertical(Peca peca,Coordenadas P,int canto){
        boolean result = false;
        if(Integer.parseInt(this.A[P.getY()-1][P.getX()].substring(0,1)) == canto ){//na parte de cima
            if((this.A[P.getY()-2][P.getX()-2] + this.A[P.getY()-2][P.getX()-1] + this.A[P.getY()-2][P.getX()] + this.A[P.getY()-2][P.getX()+1] + this.A[P.getY()-2][P.getX() + 2]).equals("     ")){
                put_dupla_horizontal(P.getX()-1,P.getY()-2,peca.getA());
                add_Cantos(new Coordenadas(P.getX()-1,P.getY()-2),new Peca(peca.getA(), peca.getB()));
                result = true;
            }
        }
        else if(Integer.parseInt(this.A[P.getY()+1][P.getX()].substring(0,1)) == canto ){//na parte de baixo
            if((this.A[P.getY()+2][P.getX()-2] + this.A[P.getY()+2][P.getX()-1] + this.A[P.getY()+2][P.getX()] + this.A[P.getY()+2][P.getX()+1] + this.A[P.getY()+2][P.getX() + 2]).equals("     ")){
                put_dupla_horizontal(P.getX()-1,P.getY()+2,peca.getA());
                add_Cantos(new Coordenadas(P.getX()-1,P.getY()+2),new Peca(peca.getA(), peca.getB()));
                result = true;
            }
        }
        return result;
    }

    /**
     * Metodo que introduz uma peca vertical em cima/baixo de uma peca vertical
     * Ex: +
     *     2
     *     -
     *     4
     *     +
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @param canto valor que correspondente a um dos lados da peca da coordenada recebida
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean introduzir_peca_vertical_em_cima_de_peca_vertical(Peca peca,Coordenadas P,int canto){
        boolean result = false;
        if(Integer.parseInt(this.A[P.getY()-1][P.getX()].substring(0,1)) == canto){
            if(Integer.parseInt(this.A[P.getY()-1][P.getX()].substring(0,1)) == peca.getA()) {
                put_vertical_cima(P.getX(),P.getY()-2,peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX(),P.getY()-3),new Peca(peca.getB(),peca.getA()));
            }
            else if(Integer.parseInt(this.A[P.getY()-1][P.getX()].substring(0,1)) == peca.getB()){
                put_vertical_cima(P.getX(),P.getY()-2,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX(),P.getY()-3),new Peca(peca.getA(), peca.getB()));
            }
            result = true;
        }
        else if(Integer.parseInt(this.A[P.getY()+1][P.getX()].substring(0,1)) == canto){
            if(Integer.parseInt(this.A[P.getY()+1][P.getX()].substring(0,1)) == peca.getA()) {
                result = true;
                put_vertical_baixo(P.getX(),P.getY()+2,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX(),P.getY()+3),new Peca(peca.getB(),peca.getA()));
            }
            else if(Integer.parseInt(this.A[P.getY()+1][P.getX()].substring(0,1)) == peca.getB()){
                result = true;
                put_vertical_baixo(P.getX(),P.getY()+2, peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX(),P.getY()+3),new Peca(peca.getA(), peca.getB()));
            }
        }
        return result;
    }

    /**
     * Metodo que introduz uma peca numa peca horizontal dupla
     * Ex:       +
     *        + 2-2 +
     *           +
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @param canto valor que correspondente a um dos lados da peca da coordenada recebida
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean introduzir_na_peca_dupla_horizontal(Peca peca,Coordenadas P,int canto){
        boolean result = false;
        if((this.A[P.getY()][P.getX() - 2] + this.A[P.getY()][P.getX() - 3] + this.A[P.getY()][P.getX() - 4]).equals("   ")){//esquerda
            if(peca.getA() == canto){
                result = true;
                put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()-3,P.getY()), new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()-3,P.getY()), new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY() - 1][P.getX() + 1] + this.A[P.getY() - 2][P.getX() + 1] + this.A[P.getY() - 3][P.getX() + 1] + this.A[P.getY() - 4][P.getX() + 1] + this.A[P.getY() - 4][P.getX()] + this.A[P.getY() - 4][P.getX() + 2]).equals("      ")){//cima
            if(peca.getA() == canto){
                result = true;
                put_vertical_cima(P.getX()+1,P.getY()-1,peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()+1,P.getY()-2), new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_vertical_cima(P.getX()+1,P.getY()-1,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()+1,P.getY()-2),new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY()][P.getX() + 4] + this.A[P.getY()][P.getX() + 5] + this.A[P.getY()][P.getX() + 6]).equals("   ")){//direita
            if(peca.getA() == canto){
                result = true;
                put_horizontal_direita(P.getX()+4,P.getY(),peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()+5,P.getY()),new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_horizontal_direita(P.getX()+4,P.getY(),peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()+5,P.getY()), new Peca(peca.getA(), peca.getB()));
            }
        }
        else if((this.A[P.getY() + 1][P.getX() + 1] + this.A[P.getY() + 2][P.getX() + 1] + this.A[P.getY() + 3][P.getX() + 1] + this.A[P.getY() + 4][P.getX() + 1] + this.A[P.getY() + 4][P.getX()] + this.A[P.getY() + 4][P.getX() + 2]).equals("      ") ){//baixo
            if(peca.getA() == canto){
                result = true;
                put_vertical_baixo(P.getX()+1,P.getY()+1,peca.getA(), peca.getB());
                add_Cantos(new Coordenadas(P.getX()+1,P.getY()+2), new Peca(peca.getB(),peca.getA()));
            }
            else if(peca.getB() == canto){
                result = true;
                put_vertical_baixo(P.getX()+1,P.getY()+1,peca.getB(), peca.getA());
                add_Cantos(new Coordenadas(P.getX()+1,P.getY()+2), new Peca(peca.getA(), peca.getB()));
            }
        }
        if(!(this.A[P.getY()][P.getX() - 2] + this.A[P.getY()][P.getX() - 3] + this.A[P.getY()][P.getX() - 4]).equals("   ")
                && !(this.A[P.getY() - 1][P.getX() + 1] + this.A[P.getY() - 2][P.getX() + 1] + this.A[P.getY() - 3][P.getX() + 1] + this.A[P.getY() - 4][P.getX() + 1] + this.A[P.getY() - 4][P.getX()] + this.A[P.getY() - 4][P.getX() + 2]).equals("      ")
                && !(this.A[P.getY()][P.getX() + 4] + this.A[P.getY()][P.getX() + 5] + this.A[P.getY()][P.getX() + 6]).equals("   ")
                && !(this.A[P.getY() + 1][P.getX() + 1] + this.A[P.getY() + 2][P.getX() + 1] + this.A[P.getY() + 3][P.getX() + 1] + this.A[P.getY() + 4][P.getX() + 1] + this.A[P.getY() + 4][P.getX()] + this.A[P.getY() + 4][P.getX() + 2]).equals("      ")){
            remove_Cantos(P);
        }
        return result;
    }

    /**
     * Metodo que adiciona uma peca horizontal ao lado de uma peca horizontal
     * Ex:    + 56 +
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean introduzir_peca_lado_de_uma_peca_horizontal(Peca peca,Coordenadas P){
        boolean result = false;
        if(peca.dupla()){
            if(Objects.equals(this.A[P.getY()][P.getX() - 1], " ")){
                if(Objects.equals(this.A[P.getY()][P.getX() - 2] + this.A[P.getY()-1][P.getX() - 2] + this.A[P.getY()+1][P.getX() - 2], "   ")){
                    put_dupla_vertical(P.getX()-2,P.getY(),peca.getA());
                    add_Cantos(new Coordenadas(P.getX()-2,P.getY()),new Peca(peca.getA(), peca.getB()));
                    result = true;
                }
                else{
                    remove_Cantos(P);
                }
            }
            else if(Objects.equals(this.A[P.getY()][P.getX() + 1], " ")){
                if(Objects.equals(this.A[P.getY()][P.getX() + 2] + this.A[P.getY()-1][P.getX() + 2] + this.A[P.getY()+1][P.getX() + 2], "   ")){
                    put_dupla_vertical(P.getX()+2,P.getY(),peca.getA());
                    add_Cantos(new Coordenadas(P.getX()+2,P.getY()),new Peca(peca.getA(), peca.getB()));
                    result = true;
                }
                else{
                    remove_Cantos(P);
                }
            }
        }
        else{
            if(Integer.parseInt(this.A[P.getY()][P.getX()].substring(0,1)) == peca.getA()){
                if(Objects.equals(this.A[P.getY()][P.getX() - 1], " ")){
                    put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getA(), peca.getB());
                    add_Cantos(new Coordenadas(P.getX()-3,P.getY()),new Peca(peca.getB(),peca.getA()));
                    result = true;
                }
                else if (Objects.equals(this.A[P.getY()][P.getX() + 1], " ")){
                    put_horizontal_direita(P.getX()+2,P.getY(), peca.getA(), peca.getB());
                    add_Cantos(new Coordenadas(P.getX()+3,P.getY()),new Peca(peca.getB(),peca.getA()));
                    result = true;
                }
            }
            else if(Integer.parseInt(this.A[P.getY()][P.getX()].substring(0,1)) == peca.getB()){
                if(Objects.equals(this.A[P.getY()][P.getX() - 1], " ")){
                    put_horizontal_esquerda(P.getX()-2,P.getY(),peca.getB(), peca.getA());
                    add_Cantos(new Coordenadas(P.getX()-3,P.getY()),new Peca(peca.getA(), peca.getB()));
                    result = true;
                }
                else if (Objects.equals(this.A[P.getY()][P.getX() + 1], " ")){
                    put_horizontal_direita(P.getX()+2,P.getY(), peca.getB(), peca.getA());
                    add_Cantos(new Coordenadas(P.getX()+3,P.getY()),new Peca(peca.getA(), peca.getB()));
                    result = true;
                }
            }
        }
        remove_Cantos(new Coordenadas(P.getX(),P.getY()));
        return result;
    }


    /**
     * Metodo que vai adicionar uma peca. Se a peca for adicionada retorna true, caso contrario retorna false
     * @pre peca.getA = canto || peca.getB = canto
     * @param peca peca que vai ser adicionada
     * @param P coordendada onde a peca sera adicionada
     * @param canto valor que correspondente a um dos lados da peca da coordenada recebida
     * @return true se a peca for adicionada, false caso contrario
     */
    public boolean adicionar_peca(Peca peca,Coordenadas P,int canto){
        boolean result = false;
        if (n_jogadas == 0){
            put_dupla_vertical(P.getX(),P.getY(),peca.getA());
            add_Cantos(new Coordenadas(P.getX(),P.getY()),new Peca(peca.getA(), peca.getB()));
            result = true;
        }
        else {
            if (Objects.equals(this.A[P.getY()][P.getX()], "-")) {// coordenada de uma peca vertical
                if (Objects.equals(this.A[P.getY() - 1][P.getX()], this.A[P.getY() + 1][P.getX()])) {//se a peca vertical for dupla
                    result = introduzir_peca_dupla_vertical(peca, P, canto);
                }
                else {
                    if (peca.getA() == peca.getB()) {//adicao de uma peca dupla em cima/baixo de uma peca vertical
                        result = introduzir_peca_dupla_em_cima_de_uma_peca_vertical(peca, P, canto);
                    }
                    else if (peca.getA() != peca.getB()) {//adicao de uma peca vertical em cima/baixo de uma vertical
                        result = introduzir_peca_vertical_em_cima_de_peca_vertical(peca, P, canto);
                    }
                    if (result) {
                        remove_Cantos(new Coordenadas(P.getX(), P.getY()));
                    }
                }
            }
            else if (Integer.parseInt(this.A[P.getY()][P.getX()].substring(0, 1)) >= 0 && Integer.parseInt(this.A[P.getY()][P.getX()].substring(0, 1)) <= 6 && Objects.equals(this.A[P.getY()][P.getX() + 1], "-")) {//dupla horizontal
                result = introduzir_na_peca_dupla_horizontal(peca, P, canto);
            }
            else if (Integer.parseInt(this.A[P.getY()][P.getX()].substring(0, 1)) >= 0 && Integer.parseInt(this.A[P.getY()][P.getX()].substring(0, 1)) <= 6) { //peça horizontal não dupla
                result = introduzir_peca_lado_de_uma_peca_horizontal(peca, P);
            }
        }
        check_cantos();
        this.n_jogadas++;
        return result;
    }

    /**
     * Metodo que imprime o tabuleiro
     */
    public void print_tabuleiro(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
}