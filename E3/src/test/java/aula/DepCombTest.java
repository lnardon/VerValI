package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DepCombTest {
    private DepComb depComb;

    // Testa venda para posto ESTRATEGICO em situacao NORMAL
    @Test
    public void vendaSituacaoNormalEstrategico() {
        depComb = new DepComb(500, 10000, 1250, 1250);
        int encomenda[] = depComb.encomendaCombustivel(4000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{300, 7200, 750, 750};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

        // Testa venda para posto COMUM em situacao SOBRAVISO
    @Test
    public void vendaSituacaoSobravisoComum() {
        depComb = new DepComb(300, 4000, 900, 900);
        int encomenda[] = depComb.encomendaCombustivel(200, DepComb.TIPOPOSTO.COMUM);
        int esperado[] = new int[]{290, 3860, 875, 875};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    // Testa venda para posto ESTRATEGICO em situacao EMERGENCIA
    @Test
    public void vendaSituacaoEmergenciaEstrategico() {
        depComb = new DepComb(249, 2499, 624, 624);
        int encomenda[] = depComb.encomendaCombustivel(2000, DepComb.TIPOPOSTO.ESTRATEGICO);
        System.out.println(depComb.getAditivo());
        System.out.println(depComb.getGasolina());
        System.out.println(depComb.getAlcool1());
        int esperado[] = new int[]{149, 1099, 374, 374};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    // Testa a nao venda para posto COMUM em situacao NORMAL porem com quantia que excede o limite de combustivel
    @Test
    public void naoVendeSituacaoNormalComum() {
        depComb = new DepComb(500, 10000, 1250, 1250);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.COMUM);
        int esperado[] = new int[]{-14};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    // Testa a nao venda para posto ESTRATEGICO em situacao SOBRAVISO porem com quantia que excede o limite de combustivel
    @Test
    public void naoVendeSituacaoSobravisoEstrategico() {
        depComb = new DepComb(300, 4000, 900, 900);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{-21};

        Assertions.assertArrayEquals(esperado, encomenda);
    }
    // Testa a nao venda para posto ESTRATEGICO em situacao EMERGENCIA porem com quantia que excede o limite de combustivel
    @Test
    public void naoVendeSituacaoEmergenciaComum() {
        depComb = new DepComb(249, 2499, 624, 624);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{-21};

        Assertions.assertArrayEquals(esperado, encomenda);
    }


    // Testa o recebimento de aditivo pelo deposito
    @ParameterizedTest
    @CsvSource({
        "0,250",
        "250,500",
        "251,500"
    })
    public void recebeAditivo(int recebido , int esperado) {
        depComb = new DepComb(250, 10000, 1250, 1250);
        depComb.recebeAditivo(recebido);

        Assertions.assertEquals(esperado, depComb.getAditivo());
    }

    // Testa o recebimento de gasolina pelo deposito
    @ParameterizedTest
    @CsvSource({
        "0,5000",
        "5000,10000",
        "5001,10000"
    })
    public void recebeGasolina(int recebido , int esperado) {
        depComb = new DepComb(250, 5000, 1250, 1250);
        depComb.recebeGasolina(recebido);

        Assertions.assertEquals(esperado, depComb.getGasolina());
    }

    // Testa o recebimento de alcool pelo deposito
    @ParameterizedTest
    @CsvSource({
        "0,2000",
        "500,2500",
        "501,2500"
    })
    public void recebeAlcool(int recebido , int esperado) {
        depComb = new DepComb(250, 5000, 1000, 1000);
        depComb.recebeAlcool(recebido);

        Assertions.assertEquals(esperado, depComb.getAlcool1() + depComb.getAlcool2());
    }

    // Testa o recebimento de aditivo invalido pelo deposito
    @ParameterizedTest
    @CsvSource({
        "0,-1",
        "-1,-1"
    })
    public void recebeAditivoInvalido(int recebido , int esperado) {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(esperado, depComb.recebeAditivo(recebido));
    }

    // Testa o recebimento de gasolina invalido pelo deposito
    @ParameterizedTest
    @CsvSource({
        "0,-1",
        "-1,-1"
    })
    public void recebeGasolinaInvalido(int recebido , int esperado) {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(esperado, depComb.recebeGasolina(recebido));
    }

    // Testa o recebimento de alcool invalido pelo deposito
    @ParameterizedTest
    @CsvSource({
        "-1,-500",
        "-1,0"
    })
    public void recebeAlcoolInvalido(int r , int input) {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(r, depComb.recebeAlcool(input));
    }
}