package aula;

public final class App {
    public static void main(String[] args) {
        Encomenda encomenda = new Encomenda(10, 5);
        int[] retorno = encomenda.qtdadeBarras(21);

        System.out.println(retorno[0]);
        System.out.println(retorno[1]);
    }
}
