package aula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RankingTest {
    private Ranking r;

    @BeforeEach
    public void inicializa() {
        r = new Ranking();
    }

    // Testa adição de elemento na lista.
    @Test
    public void testaAdd() {
        boolean retorno = r.add(new Record("Lucas",270));
        assertEquals(true, retorno);
    }

    // Testa adição de elemento na lista sendo seu score menor que os 10 primeiros colocados no ranking.
    @Test
    public void testaAddMenor() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        r.add(new Record("Lucas",180));
        r.add(new Record("Georgia",161));
        r.add(new Record("Lucas",200));
        r.add(new Record("Matheus",220));
        r.add(new Record("Matheus",100));
        r.add(new Record("Lucas",792));
        r.add(new Record("Georgia",1620));
        r.add(new Record("Lucas",3200));
        r.add(new Record("Matheus",2520));
        r.add(new Record("Lucas",1810));
        r.add(new Record("Georgia",1361));
        r.add(new Record("Lucas",2010));
        r.add(new Record("Matheus",2260));
        r.add(new Record("Matheus",1040));
        r.add(new Record("Lucas",7922));
        r.add(new Record("Matheus",1040));
        boolean retorno = r.add(new Record("Lucas",2));
        assertEquals(false, retorno);
    }

    // Testa se o metodo retorna o valor correto para o numero de recordes registrados.
    @Test
    public void testaNumRecords() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        int retorno = r.numRecords();
        assertEquals(4, retorno);
    }

    //Testa se metodo retorna corretamento o score de um recorde de uma determinada posição no ranking.
    @Test
    public void testaGetScore() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        r.add(new Record("Copstein",140));
        Record retorno = r.getScore(3);
        assertEquals(140, retorno.getScore());
    }

    //Testa se metodo retorna recorde nulo em caso de index inexistente.
    @Test
    public void testaGetScoreMaior() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        r.add(new Record("Copstein",140));
        Record retorno = r.getScore(7);
        assertEquals(null, retorno);
    }

    //Testa se metodo retorna corretamente o pior score de todo o ranking.
    @Test
    public void testaWorstScore() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        r.add(new Record("Copstein",140));
        Record retorno = r.worstScore();
        assertEquals(79, retorno.getScore());
    }

    //Testa se metodo retorna corretamente o melhor score de todo o ranking.
    @Test
    public void testaBestScore() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        r.add(new Record("Copstein",140));
        Record retorno = r.bestScore();
        assertEquals(300, retorno.getScore());
    }
}
