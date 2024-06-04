public class Main {
    public static void main(String[] args) {
        ContaTerminal conta = new ContaTerminal();
        String mensagem = conta.dadosCliente();
        System.out.println(mensagem);
        conta.menu();
    }
}
