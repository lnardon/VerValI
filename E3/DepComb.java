public class DepComb {
    public enum SITUACAO {NORMAL,SOBRAVISO,EMERGENCIA}
    public enum TIPOPOSTO {COMUM, ESTRATEGICO}

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int qtdGasolina;
    private int qtdAditivo;
    private int qtdAlcool1;
    private int qtdAlcool2;
    private SITUACAO situacao;

    public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        qtdGasolina = tGasolina;
        qtdAditivo = tAditivo;
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
        
    }

    public int recebeGasolina(int qtdade){
        
    }

    public int revcebeAlcool1(int qtdade){
        
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