package aula;

public class DepComb {
    public enum SITUACAO {NORMAL,SOBRAVISO,EMERGENCIA}
    public enum TIPOPOSTO {COMUM, ESTRATEGICO}

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;
    
    public static final int MISTURA_ADITIVO = 5;
    public static final int MISTURA_ALCOOL = 25;
    public static final int MISTURA_GASOLINA = 70;

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
        if(qtdAditivo > MAX_ADITIVO/2 && qtdGasolina > MAX_GASOLINA/2 && (qtdAlcool1 + qtdAlcool2)/2 > MAX_ALCOOL/2) {
            situacao = SITUACAO.NORMAL;
        }
        else if(qtdAditivo <= MAX_ADITIVO/4 && qtdGasolina <= MAX_GASOLINA/4 && (qtdAlcool1 + qtdAlcool2)/2 <= MAX_ALCOOL/4) {
            situacao = SITUACAO.EMERGENCIA;
        }
        else {
            situacao = SITUACAO.SOBRAVISO;
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
        if (qtdade > 0) {
            double aditivo  = qtdAditivo - ((qtdade * MISTURA_ADITIVO) / 100);
            double gasolina = qtdGasolina - ((qtdade * MISTURA_GASOLINA) / 100);
            double alcool   = (qtdAlcool1 + qtdAlcool2) - ((qtdade * MISTURA_ALCOOL) / 100);
            
            switch(situacao){
                case NORMAL:
                    if(tipoPosto == TIPOPOSTO.ESTRATEGICO) {
                        if(aditivo >= 0 && gasolina >= 0 && alcool >= 0) {
                            qtdAditivo  = (int)aditivo;
                            qtdGasolina = (int)gasolina;
                            qtdAlcool1  = (int)alcool / 2;
                            qtdAlcool2  = (int)alcool / 2;

                            int[] encomenda = new int[4];
                            encomenda[0] = qtdAditivo;
                            encomenda[1] = qtdGasolina;
                            encomenda[2] = qtdAlcool1;
                            encomenda[3] = qtdAlcool2;
                            
                            return encomenda;
                        }
                        else {
                            int[] encomenda = new int[1];

                            encomenda[0] = -21;

                            return encomenda;
                        }
                    } 
                    else {
                        if(aditivo > 250 && gasolina > 5000 && alcool > 1250) {
                            qtdAditivo  = (int)aditivo;
                            qtdGasolina = (int)gasolina;
                            qtdAlcool1  = (int)alcool / 2;
                            qtdAlcool2  = (int)alcool / 2;

                            int[] encomenda = new int[4];
                            encomenda[0] = qtdAditivo;
                            encomenda[1] = qtdGasolina;
                            encomenda[2] = qtdAlcool1;
                            encomenda[3] = qtdAlcool2;
                            
                            return encomenda;
                        }
                        else {
                            int[] encomenda = new int[1];

                            encomenda[0] = -14;

                            return encomenda;
                        }
                    }
                case SOBRAVISO:
                    if(tipoPosto == TIPOPOSTO.ESTRATEGICO) {
                        if(aditivo >= 0 && gasolina >= 0 && alcool >= 0) {
                            qtdAditivo  = (int)aditivo;
                            qtdGasolina = (int)gasolina;
                            qtdAlcool1  = (int)alcool / 2;
                            qtdAlcool2  = (int)alcool / 2;

                            int[] encomenda = new int[4];
                            encomenda[0] = qtdAditivo;
                            encomenda[1] = qtdGasolina;
                            encomenda[2] = qtdAlcool1;
                            encomenda[3] = qtdAlcool2;
                            
                            return encomenda;
                        }
                        else {
                            int[] encomenda = new int[1];

                            encomenda[0] = -21;

                            return encomenda;
                        }
                    } 
                    else {
                        if(aditivo >= MAX_ADITIVO/4 && gasolina >= MAX_GASOLINA/4 && alcool >= MAX_ALCOOL/4) {
                            qtdAditivo  = (int)aditivo;
                            qtdGasolina = (int)gasolina;
                            qtdAlcool1  = (int)alcool / 2;
                            qtdAlcool2  = (int)alcool / 2;

                            int[] encomenda = new int[4];
                            encomenda[0] = qtdAditivo;
                            encomenda[1] = qtdGasolina;
                            encomenda[2] = qtdAlcool1;
                            encomenda[3] = qtdAlcool2;
                            
                            return encomenda;
                        }
                        else {
                            int[] encomenda = new int[1];

                            encomenda[0] = -14;

                            return encomenda;
                        }
                    }
                case EMERGENCIA:
                    if(tipoPosto == TIPOPOSTO.ESTRATEGICO) {
                        if(aditivo >= 0 && gasolina >= 0 && alcool >= 0) {
                            qtdAditivo  = (int)aditivo;
                            qtdGasolina = (int)gasolina;
                            qtdAlcool1  = (int)alcool / 2;
                            qtdAlcool2  = (int)alcool / 2;

                            int[] encomenda = new int[4];
                            encomenda[0] = qtdAditivo;
                            encomenda[1] = qtdGasolina;
                            encomenda[2] = qtdAlcool1;
                            encomenda[3] = qtdAlcool2;
                            
                            return encomenda;
                        }
                        else {
                            int[] encomenda = new int[1];

                            encomenda[0] = -21;

                            return encomenda;
                        }
                    } 
                    else {
                        int[] encomenda = new int[1];
                        encomenda[0] = -14;

                        return encomenda;
                    }
            }
        }
        int encomenda[] = new int[1];
        encomenda[0] = -7;
        return encomenda;

    }
}