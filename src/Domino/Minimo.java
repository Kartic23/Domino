package Domino;
import java.util.ArrayList;

/**
 * Subclasse da Classe Jogador.
 * Categoria de jogador que joga sempre a peca de menor valor
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Minimo extends Jogador{

    /**
     * Construtor da subclasse Minimo
     * @param name representa o nome do Jogador
     */
    public Minimo(String name) {
        super(name);
    }

    /**
     * Metodo que calcula o indice da peca com menor valor de um Arraylist
     * @param jogaveis Arraylist que representa as pecas jogaveis
     * @return indice da peca com menor valor do Arraylist
     */
    public int minimo_entre_as_pecas(ArrayList<Peca> jogaveis){
        int minimo = jogaveis.get(0).total_peca();
        int indice = 0;
        for (int i = 1; i < jogaveis.size(); i++) {
            if (minimo > jogaveis.get(i).total_peca()){
                minimo = jogaveis.get(i).total_peca();
                indice = i;
            }
        }
        return indice;
    }

    /**
     * Metodo que joga a peca de menor valor do seu lote de pecas e, em caso de nao ter pecas para jogar, passa a sua vez
     * @param tabuleiro representa o tabuleiro onde estao todas as pecas colocadas
     * @param coordenadas representa o conjunto das coordenadas de cada canto
     * @param cantos representa o conjunto das pecas de cada canto
     */
    public void play(Tabuleiro tabuleiro,ArrayList<Coordenadas> coordenadas, ArrayList<Peca> cantos){
        ArrayList<Peca> pecas_jogaveis = new ArrayList<>();
        ArrayList<Integer> cantos_jogaveis = new ArrayList<>();
        int[] indices = new int[7];
        int m = 0;
        for (int i = 0; i < cantos.size(); i++) {
            for (int j = 0; j < this.minhas_pecas.size(); j++) {
                if(this.minhas_pecas.get(j).getA() == cantos.get(i).getA() || this.minhas_pecas.get(j).getB() == cantos.get(i).getA()){
                    if (!pecas_jogaveis.contains(this.minhas_pecas.get(j)) ){
                        cantos_jogaveis.add(i);
                        pecas_jogaveis.add(this.minhas_pecas.get(j));
                        indices[m++] = j;
                    }
                }
            }
        }
        System.out.println("Jogada nº" +(tabuleiro.getN_jogadas() + 1)+ " jogada pelo Jogador: " + this.getNome());
        if (pecas_jogaveis.size() != 0) {
            int indice = minimo_entre_as_pecas(pecas_jogaveis);
            System.out.print("Vou introduzir a peca: ");
            System.out.println(pecas_jogaveis.get(indice).toString());
            boolean check = tabuleiro.adicionar_peca(pecas_jogaveis.get(indice), coordenadas.get(cantos_jogaveis.get(indice)), cantos.get(cantos_jogaveis.get(indice)).getA());
            if (check){
                this.minhas_pecas.remove(indices[indice]);
            }
        }
        else{
            System.out.println("Não tenho nenhuma peca correspondente aos cantos possiveis!!");
        }
    }

}
