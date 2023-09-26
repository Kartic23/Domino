package Domino;
import java.util.ArrayList;

/**
 * Cria os quatro jogadores e as pecas do Domino
 * Implementa a rotacao do jogo e as suas jogadas
 * @author Daniel Fernandes
 * @author Diogo Zacarias
 * @author Kartic Premgi
 * @version 1.0
 */
public class Jogo {
    ArrayList<Peca> Pecas;
    Humano Humano;
    Random Automatico_1;
    Minimo Automatico_2;
    Maximo Automatico_3;

    /**
     * Construtor da Classe Jogo.
     * Cria todas as 28 pecas do Domino e inicializa os 4 jogadores
     */
    public Jogo(){
        this.Pecas = new ArrayList<>();
        for(int i = 0 ; i <= 6 ; i++){
            for(int j = i ; j <= 6 ; j++){
                this.Pecas.add(new Peca(i,j));
            }
        }
        this.Humano = new Humano("Humano");
        this.Automatico_1 = new Random("Automatico_1");
        this.Automatico_2 = new Minimo("Automatico_2");
        this.Automatico_3 = new Maximo("Automatico_3");
    }


    /**
     * Metodo que escolhe um indice aleatorio do Arraylist
     * @return um indice aleotorio do arraylist das Pecas
     */
    public int selecao_aleatoria(){
        return (int) (Math.random() * Pecas.size());
    }

    /**
     * Metodo que distribui sete pecas para cada jogador de forma aleatoria
     */
    public void distribuir_pecas(){
        int aleatoria;
        for (int i = 0; i < 7; i++){
            aleatoria = selecao_aleatoria();
            this.Humano.minhas_pecas.add(this.Pecas.get(aleatoria));
            this.Pecas.remove(aleatoria);
            aleatoria = selecao_aleatoria();
            this.Automatico_1.minhas_pecas.add(this.Pecas.get(aleatoria));
            this.Pecas.remove(aleatoria);
            aleatoria = selecao_aleatoria();
            this.Automatico_2.minhas_pecas.add(this.Pecas.get(aleatoria));
            this.Pecas.remove(aleatoria);
            aleatoria = selecao_aleatoria();
            this.Automatico_3.minhas_pecas.add(this.Pecas.get(aleatoria));
            this.Pecas.remove(aleatoria);
        }
    }

    /**
     * Metodo que decidira quem ira comecar o jogo. O jogador que tiver a peca "6|6" sera sempre o primeiro.
     * @param Humano Jogador Humano
     * @param Aut1 Jogador Automatico_1
     * @param Aut2 Jogador Automatico_2
     * @param Aut3 Jogador Automatico_3
     * @pre Humano.minhaspecas.size() > 0
     * @pre Aut1.minhaspecas.size() > 0
     * @pre Aut2.minhaspecas.size() > 0
     * @pre Aut3.minhaspecas.size() > 0
     * @return array de Jogador que sera a ordem do jogo
     */
    public Jogador[] quem_vai_comecar_o_jogo(Jogador Humano, Jogador Aut1, Jogador Aut2,Jogador Aut3){
        Jogador[] res = new Jogador[10];
        Jogador[] temp = {Humano,Aut1,Aut2,Aut3};
        int comeco = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < temp[i].minhas_pecas.size(); j++){
                if (temp[i].minhas_pecas.get(j).getA()  == temp[i].minhas_pecas.get(j).getB() && temp[i].minhas_pecas.get(j).getA() == 6){
                    comeco = i;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            res[i]=temp[comeco];
            comeco++;
            if (comeco == 4) {
                comeco=0;
            }
        }
        return res;
    }

    /**
     * Metodo que efetua a primeira jogada, que sera sempre o jogador que contem a peca 6|6
     * @pre name = jogador que contem a peca 6|6
     * @post eliminacao
     * @param name sera o nome do Jogador que vai introduzir a primeira peca que sera a 6|6
     * @param tabuleiro e o tabuleiro de jogo
     */
    public void primeira_jogada(String name, Tabuleiro tabuleiro){
        System.out.println("Jogada nº1 jogada pelo Jogador: " + name);
        System.out.println("Peça a ser introduzida: 6|6;");
        tabuleiro.adicionar_peca(new Peca(6,6),new Coordenadas(50,50),6);
        switch (name) {
            case "Humano" -> {
                int i = this.Humano.indice_de_uma_certa_peca(new Peca(6,6));
                this.Humano.minhas_pecas.remove(i);
            }
            case "Automatico_1" -> {
                int i = this.Automatico_1.indice_de_uma_certa_peca(new Peca(6,6));
                this.Automatico_1.minhas_pecas.remove(i);
            }
            case "Automatico_2" -> {
                int i = this.Automatico_2.indice_de_uma_certa_peca(new Peca(6,6));
                this.Automatico_2.minhas_pecas.remove(i);
            }
            case "Automatico_3" -> {
                int i = this.Automatico_3.indice_de_uma_certa_peca(new Peca(6,6));
                this.Automatico_3.minhas_pecas.remove(i);
            }
        }
    }

    /**
     * Metodo que ira rodar pelos quatro jogadores ate que um fica sem pecas
     * @param ordem representa a ordem de cada jogador
     * @param tabuleiro e onde guardamos todas as pecas colocadas
     * @return o indice do vencedor do array Ordem
     */
    public int jogo(Jogador[] ordem,Tabuleiro tabuleiro){
        int contador = 0;
        int vencedor;
        while(true){
            if(tabuleiro.getN_jogadas() == 0){
                primeira_jogada(ordem[contador].getNome(),tabuleiro);
            }
            else{
                switch (ordem[contador].getNome()) {
                    case "Humano" -> {
                        System.out.println("Suas Pecas são:");
                        this.Humano.print_minhas_pecas();
                        this.Humano.play(tabuleiro, tabuleiro.getCantos_coordenadas(), tabuleiro.getCantos_valor());
                    }
                    case "Automatico_1" -> this.Automatico_1.play(tabuleiro, tabuleiro.getCantos_coordenadas(), tabuleiro.getCantos_valor());
                    case "Automatico_2" -> this.Automatico_2.play(tabuleiro, tabuleiro.getCantos_coordenadas(), tabuleiro.getCantos_valor());
                    case "Automatico_3" -> this.Automatico_3.play(tabuleiro, tabuleiro.getCantos_coordenadas(), tabuleiro.getCantos_valor());
                }
            }
            tabuleiro.print_tabuleiro();
            if(ordem[contador].sem_pecas()){
                vencedor = contador;
                break;
            }
            tabuleiro.print_cantos_coordenada();
            contador++;
            if(contador == 4) {
                contador = 0;
            }
        }
        return vencedor;
    }


    /**
     * Metodo que compara v com w
     * @param v valor a comparar
     * @param w valor a comparar
     * @return true se v for menor que w, caso contrario false
     */
    protected boolean less(int v, int w) {
        return v < w;
    }


    /**
     * Metodo que troca a posicao i pela j e vice-versa
     * @param a array que representa a pontuacao de cada jogador
     * @param i posicao a mudar
     * @param j posicao a mudar
     * @param b array que representa o nome de cada jogador
     */
    protected void exchange(int[] a, int i, int j, String[] b) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        String w = b[i];
        b[i] = b[j];
        b[j] = w;
    }

    /**
     * Metodo que ordena o dois arrays recebidos
     * @param a array que representa a pontuacao de cada jogador
     * @param b array que representa o nome de cada jogador
     * @pre a.length > 1
     * @post a ordenado
     */
    public void sort(int[] a,String [] b){
        for (int i = 1; i < 3; i++){
            for(int j = i; j > 0 ; j--){
                if(less(a[j],a[j-1])){
                    exchange(a, j,j-1,b);
                }
                else break;
            }
        }
    }

    /**
     * Metodo calcula, ordena e faz impressao da classificacao final
     * @pre indice_vencedor >= 0
     * @pre 3 >= indice_vencedor
     * @pre ordem != null
     * @param indice_vencedor indice do vencedor
     * @param ordem array da ordem de jogar
     */
    public void classificacao(int indice_vencedor, Jogador[] ordem){
        System.out.println("1ºLugar: " + ordem[indice_vencedor].getNome() + " que é o vencedor.");
        int[] totais = new int[4];
        String[] nomes = new String[4];
        int m = 0;
        for (int i = 0; i < 4 ; i++){
            if (i != indice_vencedor){
                totais[m] = ordem[i].total_valor_das_pecas();
                nomes[m] = ordem[i].getNome();
                m++;
            }
        }
        sort(totais,nomes);
        for (int i = 0; i < 3; i++) {
            System.out.println((i+2) + "ºLugar: " + nomes[i] + " com " + totais[i] + " pontos.");
        }
    }

    /**
     * Metodo que cria o tabuleiro e manda para a funcao que faz rodar o jogo
     */
    public void play(){
        distribuir_pecas();
        System.out.println("Player Humano:");
        Humano.print_minhas_pecas();
        Jogador[] ordem = quem_vai_comecar_o_jogo(Humano,Automatico_1,Automatico_2,Automatico_3);
        System.out.println("Ordem de rotação dos jogadores: ");
        for (int i = 0; i < 4; i++){
            System.out.println(i+1 + "º: " + ordem[i].getNome());
        }
        Tabuleiro tabuleiro = new Tabuleiro();
        int indice_vencedor = jogo(ordem,tabuleiro);
        classificacao(indice_vencedor,ordem);
    }
}