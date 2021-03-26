package aula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncomendaTest {
    private Encomenda encomenda;

    @BeforeEach
    public void inicializa() {
        encomenda = new Encomenda(10, 5);
    }

    @Test
    public void qtdCincoKg() {
        int[] retorno = encomenda.qtdadeBarras(20);
        assertEquals(4, retorno[0]);
        assertEquals(0, retorno[1]);
    }

    @Test
    public void qtdUmKg() {
        int[] retorno = encomenda.qtdadeBarras(3);
        assertEquals(1, retorno[0]);
        assertEquals(3, retorno[1]);
    }

    @Test
    public void qtdCincoKgUmkg() {
        int[] retorno = encomenda.qtdadeBarras(21);
        assertEquals(4, retorno[0]);
        assertEquals(1, retorno[1]);
    }
    
    @Test
    public void semEstoque() {
        int[] retorno = encomenda.qtdadeBarras(1000);
        assertEquals(-1, retorno[0]);
    }

    @Test
    public void encomendaGrande() {
        encomenda = new Encomenda(1000, 500);
        int[] retorno = encomenda.qtdadeBarras(3001);
        assertEquals(500, retorno[0]);
        assertEquals(501, retorno[1]);
    }

    @Test
    public void encomendaNegativa() {
        int[] retorno = encomenda.qtdadeBarras(-1000);
        assertEquals(-999, retorno[0]);
    }

    @Test
    public void estoqueNegativoUmKg() {
        encomenda = new Encomenda(-10, 5);
        int[] retorno = encomenda.qtdadeBarras(20);
        assertEquals(-999, retorno[0]);
    }

    @Test
    public void estoqueNegativoCincoKg() {
        encomenda = new Encomenda(10, -5);
        int[] retorno = encomenda.qtdadeBarras(20);
        assertEquals(-999, retorno[0]);
    }

    @Test
    public void estoqueNegativoAmbos() {
        encomenda = new Encomenda(-10, -5);
        int[] retorno = encomenda.qtdadeBarras(20);
        assertEquals(-999, retorno[0]);
    }
}
