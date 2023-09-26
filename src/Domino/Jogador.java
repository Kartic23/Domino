package Domino;
import java.util.ArrayList;

/**
 * Implementa o jogador e as suas funcoes.
 * Tem uma lista de pecas que serao as suas pecas e o seu respetivo nome
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Jogador{
    ArrayList<Peca> minhas_pecas;
    private final String nome;

    /**
     * Construtor da classe Jogador
     * @param name representa o nome do jogador
     * @pre true
     * @post getNome() = name
     */
    public Jogador(String name){
        this.minhas_pecas = new ArrayList<>();
        this.nome = name;
    }

    /**
     * @return nome do jogador
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Metodo que da impressao de todas as pecas presentes no Arraylist "minhas_pecas"
     */
    public void print_minhas_pecas(){
        for (Peca peca : minhas_pecas) {
            System.out.print(peca.toString());
        }
        System.out.println();
    }

    /** Metodo para retorno se o jogador tem pecas ou nao
     *    @return true se nao tiver pecas , false em caso de ter
     */
    public boolean sem_pecas(){
        return minhas_pecas.size() == 0;
    }

    /**
     * Metodo para retorno da soma do valor das pecas
     * @return a soma total das pecas
     */
    public int total_valor_das_pecas(){
        int total = 0;
        for (Peca peca : minhas_pecas) {
           total = total + peca.total_peca();
        }
        return total;
    }

    /**
     * Metodo que encontra o indice do Arraylist da peca recebida
     * @param A representa a peca a ser procurada
     * @return o indice de onde a peca encontra-se
     */
    public int indice_de_uma_certa_peca(Peca A){
        int indice = 0;
        for (int i = 0; i < this.minhas_pecas.size(); i++) {
            if((A.getA() == this.minhas_pecas.get(i).getA() && A.getB() == this.minhas_pecas.get(i).getB()) || (A.getB() == this.minhas_pecas.get(i).getA() && A.getA() == this.minhas_pecas.get(i).getB()) ){
                indice = i;
                break;
            }
        }
        return indice;
    }
}
