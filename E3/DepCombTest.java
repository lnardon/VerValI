import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DepCombTest {
    private DepComb depComb;

    @Test
    public void vendaSituacaoNormalEstrategico() {
        depComb = new DepComb(500, 10000, 1250, 1250);
        int encomenda[] = depComb.encomendaCombustivel(4000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{300, 7200, 750, 750};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    @Test
    public void vendaSituacaoSobravisoComum() {
        depComb = new DepComb(300, 4000, 900, 900);
        int encomenda[] = depComb.encomendaCombustivel(2000, DepComb.TIPOPOSTO.COMUM);
        int esperado[] = new int[]{200, 2600, 650, 650};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

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

    @Test
    public void naoVendeSituacaoNormalComum() {
        depComb = new DepComb(500, 10000, 1250, 1250);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.COMUM);
        int esperado[] = new int[]{-14};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    @Test
    public void naoVendeSituacaoSobravisoEstrategico() {
        depComb = new DepComb(300, 4000, 900, 900);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{-21};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    @Test
    public void naoVendeSituacaoEmergenciaComum() {
        depComb = new DepComb(249, 2499, 624, 624);
        int encomenda[] = depComb.encomendaCombustivel(12000, DepComb.TIPOPOSTO.ESTRATEGICO);
        int esperado[] = new int[]{-21};

        Assertions.assertArrayEquals(esperado, encomenda);
    }

    @Test
    public void recebeAditivo() {
        depComb = new DepComb(250, 10000, 1250, 1250);
        depComb.recebeAditivo(250);

        Assertions.assertEquals(500, depComb.getAditivo());
    }

    @Test
    public void recebeGasolina() {
        depComb = new DepComb(250, 5000, 1250, 1250);
        depComb.recebeGasolina(2500);

        Assertions.assertEquals(7500, depComb.getGasolina());
    }

    @Test
    public void recebeAlcool() {
        depComb = new DepComb(250, 5000, 1000, 1000);
        depComb.recebeAlcool(499);

        Assertions.assertEquals(2498, depComb.getAlcool1() + depComb.getAlcool2());
    }

    @Test
    public void recebeAditivoParaCompletar() {
        depComb = new DepComb(250, 10000, 1250, 1250);
        depComb.recebeAditivo(1000);

        Assertions.assertEquals(500, depComb.getAditivo());
    }

    @Test
    public void recebeGasolinaParaCompletar() {
        depComb = new DepComb(250, 5000, 1250, 1250);
        depComb.recebeGasolina(10000);

        Assertions.assertEquals(10000, depComb.getGasolina());
    }

    @Test
    public void recebeAlcoolParaCompletar() {
        depComb = new DepComb(250, 5000, 1000, 1000);
        depComb.recebeAlcool(10000);

        Assertions.assertEquals(2500, depComb.getAlcool1() + depComb.getAlcool2());
    }

    @Test
    public void recebeAditivoInvalido() {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(-1, depComb.recebeAditivo(-555));
    }

    @Test
    public void recebeGaslinaInvalido() {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(-1, depComb.recebeGasolina(-555));
    }

    @Test
    public void recebeAlcoolInvalido() {
        depComb = new DepComb(250, 10000, 1250, 1250);

        Assertions.assertEquals(-1, depComb.recebeAlcool(-555));
    }
}