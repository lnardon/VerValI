package aula;

public class Encomenda {
    private int estqUmKg;
    private int estqCincoKg;

    public Encomenda(int estqUmKg,int estqCincoKg){
        this.estqUmKg = estqUmKg;
        this.estqCincoKg = estqCincoKg;
    }

    public int[] qtdadeBarras(int peso){
        if (peso > 0 && this.estqUmKg >= 0 && this.estqCincoKg >= 0) {
            if((this.estqUmKg + (this.estqCincoKg * 5)) < peso) {
                int[] semEstoque = new int[1];
                semEstoque[0] = -1;
                return semEstoque;
            }
            else {
                int[] encomenda = new int[2];
    
                for(int i = 0; i <= (this.estqCincoKg * 5); i += 5) {
                    encomenda[0] = i;
    
                    if(i > peso) {
                        encomenda[0] -= 5;
                        break;
                    }
                }
    
                encomenda[1] = Math.abs(encomenda[0] - peso);
                encomenda[0] = encomenda[0] / 5;
    
                return encomenda;
            }
        }
        else {
            int[] erro = new int[1];
            erro[0] = -999;
            return erro;
        }
    }    
}
