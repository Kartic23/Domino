package Domino;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Testes unitarios
 */
public class JUnitTest {

    /**
     * Teste ao construtor da Classe Jogo
     */
    @Test
    public void testConstrutor_Jogo() {
        Jogo A = new Jogo();
        Assertions.assertEquals(0,A.Pecas.get(0).getA());Assertions.assertEquals(0,A.Pecas.get(0).getB());
        Assertions.assertEquals(0,A.Pecas.get(1).getA());Assertions.assertEquals(1,A.Pecas.get(1).getB());
        Assertions.assertEquals(0,A.Pecas.get(2).getA());Assertions.assertEquals(2,A.Pecas.get(2).getB());
        Assertions.assertEquals(0,A.Pecas.get(3).getA());Assertions.assertEquals(3,A.Pecas.get(3).getB());
        Assertions.assertEquals(0,A.Pecas.get(4).getA());Assertions.assertEquals(4,A.Pecas.get(4).getB());
        Assertions.assertEquals(0,A.Pecas.get(5).getA());Assertions.assertEquals(5,A.Pecas.get(5).getB());
        Assertions.assertEquals(0,A.Pecas.get(6).getA());Assertions.assertEquals(6,A.Pecas.get(6).getB());
        Assertions.assertEquals(1,A.Pecas.get(7).getA());Assertions.assertEquals(1,A.Pecas.get(7).getB());
        Assertions.assertEquals(1,A.Pecas.get(8).getA());Assertions.assertEquals(2,A.Pecas.get(8).getB());
        Assertions.assertEquals(1,A.Pecas.get(9).getA());Assertions.assertEquals(3,A.Pecas.get(9).getB());
        Assertions.assertEquals(1,A.Pecas.get(10).getA());Assertions.assertEquals(4,A.Pecas.get(10).getB());
        Assertions.assertEquals(1,A.Pecas.get(11).getA());Assertions.assertEquals(5,A.Pecas.get(11).getB());
        Assertions.assertEquals(1,A.Pecas.get(12).getA());Assertions.assertEquals(6,A.Pecas.get(12).getB());
        Assertions.assertEquals(2,A.Pecas.get(13).getA());Assertions.assertEquals(2,A.Pecas.get(13).getB());
        Assertions.assertEquals(2,A.Pecas.get(14).getA());Assertions.assertEquals(3,A.Pecas.get(14).getB());
        Assertions.assertEquals(2,A.Pecas.get(15).getA());Assertions.assertEquals(4,A.Pecas.get(15).getB());
        Assertions.assertEquals(2,A.Pecas.get(16).getA());Assertions.assertEquals(5,A.Pecas.get(16).getB());
        Assertions.assertEquals(2,A.Pecas.get(17).getA());Assertions.assertEquals(6,A.Pecas.get(17).getB());
        Assertions.assertEquals(3,A.Pecas.get(18).getA());Assertions.assertEquals(3,A.Pecas.get(18).getB());
        Assertions.assertEquals(3,A.Pecas.get(19).getA());Assertions.assertEquals(4,A.Pecas.get(19).getB());
        Assertions.assertEquals(3,A.Pecas.get(20).getA());Assertions.assertEquals(5,A.Pecas.get(20).getB());
        Assertions.assertEquals(3,A.Pecas.get(21).getA());Assertions.assertEquals(6,A.Pecas.get(21).getB());
        Assertions.assertEquals(4,A.Pecas.get(22).getA());Assertions.assertEquals(4,A.Pecas.get(22).getB());
        Assertions.assertEquals(4,A.Pecas.get(23).getA());Assertions.assertEquals(5,A.Pecas.get(23).getB());
        Assertions.assertEquals(4,A.Pecas.get(24).getA());Assertions.assertEquals(6,A.Pecas.get(24).getB());
        Assertions.assertEquals(5,A.Pecas.get(25).getA());Assertions.assertEquals(5,A.Pecas.get(25).getB());
        Assertions.assertEquals(5,A.Pecas.get(26).getA());Assertions.assertEquals(6,A.Pecas.get(26).getB());
        Assertions.assertEquals(6,A.Pecas.get(27).getA()); Assertions.assertEquals(6,A.Pecas.get(27).getB());
    }

    /**
     * Teste ao construtor da Classe Tabuleiro
     */
    @Test
    public void Test_Construtor_Tabuleiro(){
        Tabuleiro A = new Tabuleiro();
        Assertions.assertEquals(A.getN_jogadas(),0);
        Assertions.assertEquals(A.getCantos_coordenadas().size(),0);
        Assertions.assertEquals(A.getCantos_valor().size(),0);
    }

    /**
     * Teste ao construtor da Classe Peca
     */
    @Test
    public void test_Construtor_Peca(){
        Peca A = new Peca(3,4);
        Assertions.assertEquals(3,A.getA());
        Assertions.assertEquals(4,A.getB());
        Peca B = new Peca(2,2);
        Assertions.assertEquals(2,B.getA());
        Assertions.assertEquals(2,B.getB());
    }

    /**
     * Teste a funcao total peca da classe Peca
     */
    @Test
    public void test_total_peca(){
        Peca A = new Peca(2,3);
        Assertions.assertEquals(5,A.total_peca());
        Peca B = new Peca(0,4);
        Assertions.assertEquals(4,B.total_peca());
    }

    /**
     * Teste a funcao peca_dupla da Classe Peca
     */
    @Test
    public void test_peca_dupla(){
        Peca A = new Peca(2,3);
        Assertions.assertFalse(A.dupla());
        Peca B = new Peca(3,3);
        Assertions.assertTrue(B.dupla());
    }

    /**
     * Teste ao Construtor da Classe Coordenadas
     */
    @Test
    public void test_construtor_Coordenadas(){
        Coordenadas A = new Coordenadas(2,3);
        Assertions.assertEquals(2,A.getX());
        Assertions.assertEquals(3,A.getY());
        Coordenadas B = new Coordenadas(0,0);
        Assertions.assertEquals(0,B.getX());
        Assertions.assertEquals(0, B.getY());

    }

    /**
     * Teste ao Construtor da Classe Coordenadas
     */
    @Test
    public void test_Construtor_Jogador(){
        Jogador A  = new Jogador("Kartic");
        Assertions.assertEquals(A.getNome(),"Kartic");
        Assertions.assertEquals(A.minhas_pecas.size(),0);
    }

    /**
     * Teste a funcao sem_pecas da Classe Jogador
     */
    @Test
    public void test_Jogador_sem_pecas(){
        Jogador A = new Jogador("A");
        Assertions.assertTrue(A.sem_pecas());
        A.minhas_pecas.add(new Peca(2,2));
        Assertions.assertFalse(A.sem_pecas());
    }


    /**
     * Teste a funcao total_valor_das_pecas da Classe Jogador
     */
    @Test
    public void test_Jogador_total_valor_das_pecas(){
        Jogador A = new Jogador("A");
        A.minhas_pecas.add(new Peca(3,2));
        A.minhas_pecas.add(new Peca(1,2));
        A.minhas_pecas.add(new Peca(6,2));
        A.minhas_pecas.add(new Peca(2,2));
        Assertions.assertEquals(20,A.total_valor_das_pecas());
        A.minhas_pecas.remove(2);
        Assertions.assertEquals(12,A.total_valor_das_pecas());
        Jogador B = new Jogador("A");
        B.minhas_pecas.add(new Peca(0,0));
        B.minhas_pecas.add(new Peca(1,0));
        B.minhas_pecas.add(new Peca(6,0));
        B.minhas_pecas.add(new Peca(2,0));
        Assertions.assertEquals(9,B.total_valor_das_pecas());
    }

    /**
     * Teste a funcao indice_de_uma_peca da Classe Jogador
     */
    @Test
    public void test_Jogador_indice_de_uma_peca(){
        Jogador A = new Jogador("A");
        A.minhas_pecas.add(new Peca(6,6));
        A.minhas_pecas.add(new Peca(2,6));
        A.minhas_pecas.add(new Peca(4,4));
        A.minhas_pecas.add(new Peca(2,3));
        A.minhas_pecas.add(new Peca(1,2));
        A.minhas_pecas.add(new Peca(1,5));
        A.minhas_pecas.add(new Peca(0,0));
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(6,6)),0);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(2,6)),1);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(4,4)),2);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(2,3)),3);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(1,2)),4);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(1,5)),5);
        Assertions.assertEquals(A.indice_de_uma_certa_peca(new Peca(0,0)),6);
    }


    /**
     * Teste ao construtor da Classe Minimo
     */
    @Test
    public void Test_Construtor_Minimo(){
        Minimo A = new Minimo("Daniel");
        Assertions.assertEquals(A.getNome(),"Daniel");
        Minimo B = new Minimo("Diogo");
        Assertions.assertEquals(B.getNome(),"Diogo");
    }

    /**
     * Teste a funcao minimo_entre_pecas da Classe Minimo
     */
    @Test
    public void Test_minimo_entre_pecas(){
        Minimo A = new Minimo("Diogo");
        A.minhas_pecas.add(new Peca(2,3));
        A.minhas_pecas.add(new Peca(1,3));
        A.minhas_pecas.add(new Peca(2,4));
        A.minhas_pecas.add(new Peca(4,5));
        A.minhas_pecas.add(new Peca(0,2));
        A.minhas_pecas.add(new Peca(2,6));
        Assertions.assertEquals(A.minimo_entre_as_pecas(A.minhas_pecas),4);
    }

    /**
     * Teste ao construtor da Classe Random
     */
    @Test
    public void Test_Construtor_Random(){
        Random A = new Random("Daniel");
        Assertions.assertEquals(A.getNome(),"Daniel");
        Random B = new Random("Kartic");
        Assertions.assertEquals(B.getNome(),"Kartic");
    }

    /**
     * Teste ao construtor da Classe Humano
     */
    @Test
    public void Test_Construtor_Humano(){
        Humano A = new Humano("Manuel");
        Assertions.assertEquals(A.getNome(),"Manuel");
        Humano B = new Humano("Francisco");
        Assertions.assertEquals(B.getNome(),"Francisco");
    }


    /**
     * Teste a funcao indice_da_peca da Classe Humano
     */
    @Test
    public void Test_indice_da_peca(){
        Humano A = new Humano("A");
        A.minhas_pecas.add(new Peca(2,3));
        A.minhas_pecas.add(new Peca(1,3));
        A.minhas_pecas.add(new Peca(2,4));
        A.minhas_pecas.add(new Peca(4,5));
        A.minhas_pecas.add(new Peca(0,2));
        A.minhas_pecas.add(new Peca(2,6));
        Assertions.assertEquals(A.indice_da_peca("2|3"),0);
        Assertions.assertEquals(A.indice_da_peca("2|4"),2);
        Assertions.assertEquals(A.indice_da_peca("3|4"),-1);

    }

    /**
     * Teste a funcao indice_da_peca_cantos da Classe Humano
     */
    @Test
    public void Test_indice_da_peca_cantos(){
        Humano A = new Humano("A");
        ArrayList<Peca> B = new ArrayList<>();
        B.add(new Peca(6,6));
        B.add(new Peca(2,3));
        B.add(new Peca(4,4));
        B.add(new Peca(4,2));
        B.add(new Peca(6,3));
        B.add(new Peca(0,1));
        Assertions.assertEquals(A.indice_da_peca_cantos("4|4",B),2);
        Assertions.assertEquals(A.indice_da_peca_cantos("2|3",B),1);
        Assertions.assertEquals(A.indice_da_peca_cantos("5|4",B),-1);
    }


    /**
     * Teste ao construtor da Classe Maximo
     */
    @Test
    public void Test_Construtor_Maximo(){
        Maximo A = new Maximo("Diogo");
        Assertions.assertEquals(A.getNome(),"Diogo");
        Maximo B = new Maximo("Jaime");
        Assertions.assertEquals(B.getNome(),"Jaime");
    }

    /**
     * Teste a funcao maximo_entre_pecas da Classe Minimo
     */
    @Test
    public void Test_maximo_entre_pecas(){
        Maximo A = new Maximo("Kartic");
        A.minhas_pecas.add(new Peca(2,3));
        A.minhas_pecas.add(new Peca(1,3));
        A.minhas_pecas.add(new Peca(2,4));
        A.minhas_pecas.add(new Peca(4,5));
        A.minhas_pecas.add(new Peca(0,2));
        A.minhas_pecas.add(new Peca(2,6));
        Assertions.assertEquals(A.maximo_entre_as_pecas(A.minhas_pecas),3);
    }


}
