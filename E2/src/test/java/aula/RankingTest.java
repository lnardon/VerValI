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

    @Test
    public void testaAdd() {
        boolean retorno = r.add(new Record("Lucas",270));
        assertEquals(true, retorno);
    }

    @Test
    public void testaNumRecords() {
        r.add(new Record("Lucas",79));
        r.add(new Record("Georgia",160));
        r.add(new Record("Lucas",300));
        r.add(new Record("Matheus",220));
        int retorno = r.numRecords();
        assertEquals(4, retorno);
    }
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
