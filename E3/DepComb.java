public class DepComb {
    public enum SITUACAO {NORMAL,SOBRAVISO,EMERGENCIA}
    public enum TIPOPOSTO {COMUM, ESTRATEGICO}

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;
    
    public static final int MISTURA_ADITIVO = 5;    // 5%
    public static final int MISTURA_ALCOOL = 25;    // 25%
    public static final int MISTURA_GASOLINA = 70;  // 70%

    private int qtdGasolina;
    private int qtdAditivo;
    private int qtdAlcool1;
    private int qtdAlcool2;
    private SITUACAO situacao;

    public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        qtdGasolina = tGasolina;
        qtdAditivo = tAditivo;
        qtdAlcool1 = (tAlcool1 + tAlcool2)/2;
        qtdAlcool2 = (tAlcool1 + tAlcool2)/2;
        defineSituacao();
    }

    public void defineSituacao(){
        int qtdDisponivel;
        // Adicional aqui o calculo de qtd de combustivel disponivel
        if(qtdDisponivel > 0.5) {
            situacao = SITUACAO.NORMAL;
        } else if(qtdDisponivel > 0.25){
            situacao = SITUACAO.SOBRAVISO;
        } else {
            situacao = SITUACAO.EMERGENCIA;
        }
    }

    public SITUACAO getSituacao(){
        return situacao;
    }

    public int getGasolina(){
        return qtdGasolina;
    }

    public int getAditivo(){
        return  qtdAditivo;
    }

    public int getAlcool1(){
        return  qtdAlcool1; 
    }

    public int getAlcool2(){
        return  qtdAlcool2;  
    }

    public int recebeAditivo(int qtdade){
        if(qtdade > 0) {
            if ((qtdAditivo + qtdade) >= MAX_ADITIVO) {
                int ret = MAX_ADITIVO - qtdAditivo;
                qtdAditivo = MAX_ADITIVO;
    
                return ret;
            }
            else {
                qtdAditivo += qtdade;
    
                return qtdade;
            }
        }
        else {
            return -1;
        }
    }
    
    public int recebeGasolina(int qtdade){
        if(qtdade > 0) {
            if ((qtdGasolina + qtdade) >= MAX_GASOLINA) {
                int ret = MAX_GASOLINA - qtdGasolina;
                qtdGasolina = MAX_GASOLINA;
    
                return ret;
            }
            else {
                qtdGasolina += qtdade;
    
                return qtdade;
            }
        }
        else {
            return -1;
        }
    }
    
    public int recebeAlcool(int qtdade){
        if(qtdade > 0) {
            if ((qtdAlcool1 + qtdAlcool2 + qtdade) >= MAX_ALCOOL) {
                int ret = MAX_ALCOOL - (qtdAlcool1 + qtdAlcool2);
                qtdAlcool1 = MAX_ALCOOL / 2;
                qtdAlcool2 = MAX_ALCOOL / 2;
    
                return ret;
            }
            else {
                qtdAlcool1 += qtdade / 2;
                qtdAlcool2 += qtdade / 2;
    
                return qtdade;
            }
        }
        else {
            return -1;
        }
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto){
        switch(situacao){
            case NORMAL:
                System.out.println("1");
                break;
            case SOBRAVISO:
                if(tipoPosto == ESTRATEGICO){

                } else {

                }
                System.out.println("2");
                break;
            case EMERGENCIA:
                if(tipoPosto == ESTRATEGICO){

                } else {

                }
                System.out.println("3");
                break;
        }
    }

}