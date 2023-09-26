package Domino;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Representa o utilizador, pois este jogador ira fazer com que o utilizador digite no terminal
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Humano extends Jogador{

    /**
     * Construtor da subclasse Humano
     * @param name representa o nome do Jogador Humano
     */
    public Humano(String name){
        super(name);
    }

    /**
     * Metodo que descobre o indice da peca recebida na lista de cantos recebida, em caso de nao existir, retorna -1
     * @param peca peca a descobrir na lista de cantos recebida
     * @param cantos lista dos cantos
     * @return indice da peca recebida na lista de cantos, caso contrario, -1
     */
    public int indice_da_peca_cantos(String peca, ArrayList<Peca> cantos){
        int indice = -1;
        int lado1 = Integer.parseInt(peca.substring(0,1));
        int lado2 = Integer.parseInt(peca.substring(2,3));
        for (int i = 0; i < cantos.size(); i++){
            if ((cantos.get(i).getA() == lado1 && cantos.get(i).getB() == lado2) || (cantos.get(i).getA() == lado2 && cantos.get(i).getB() == lado1)){
                indice = i;
                break;
            }
        }
        return indice;
    }


    /**
     * Metodo que descobre o indice da peca recebida no seu lote de pecas, em caso de nao existir, retorna -1
     * @param peca peca a descobrir no seu lote de pecas
     * @return indice da peca recebida, caso contrario, -1
     */
    public int indice_da_peca(String peca){
        int indice = -1;
        int lado1 = Integer.parseInt(peca.substring(0,1));
        int lado2 = Integer.parseInt(peca.substring(2,3));
        for (int i = 0; i < this.minhas_pecas.size(); i++){
            if (this.minhas_pecas.get(i).getA() == lado1 && this.minhas_pecas.get(i).getB() == lado2){
                indice = i;
                break;
            }
        }
        return indice;
    }

    /**
     * Metodo que ira pedir ao utilizador para escrever a peca jogar e o seu respetivo canto
     * @param tabuleiro representa o tabuleiro onde estão todas as pecas colocadas
     * @param coordenadas representa o conjunto das coordenadas de cada canto
     * @param cantos representa o conjunto das pecas de cada canto
     */
    public void play(Tabuleiro tabuleiro,ArrayList<Coordenadas> coordenadas, ArrayList<Peca> cantos) {
        System.out.println("Introduza uma peca do seu lote de pecas. Em caso de não ter peca, introduza -1.");
        Scanner sc = new Scanner(System.in);
        String peca = sc.next();
        if (Objects.equals(peca, "-1")){
            System.out.println("Não tenho nenhuma peca correspondente aos cantos possiveis!!");
        }
        else{
            int indice = indice_da_peca(peca);
            if(indice == -1){
                while(indice == -1){
                    System.out.println("Essa peca não contem do seu lote de pecas. Volte a introduzir:");
                    peca = sc.next();
                    indice = indice_da_peca(peca);
                }
            }
            String peca_colada = sc.next();
            int indice_canto = indice_da_peca_cantos(peca_colada,cantos);
            if(indice_canto == -1){
                while(indice_canto == -1){
                    System.out.println("Este canto não contem do lote dos cantos possiveis. Volte a introduzir:");
                    peca_colada = sc.next();
                    indice_canto = indice_da_peca_cantos(peca_colada,cantos);
                }
            }
            boolean check = tabuleiro.adicionar_peca(this.minhas_pecas.get(indice),coordenadas.get(indice_canto),cantos.get(indice_canto).getA());
            if (check){
                this.minhas_pecas.remove(indice);
            }
            else{
                System.out.println("Falta de correspondencia entre a peca e o canto. Volte a introduzir:");
                play(tabuleiro,coordenadas,cantos);
            }
        }
    }

}
