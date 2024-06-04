import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {

    private BigDecimal saldoDisponivel = BigDecimal.ZERO;
    private Scanner scanner = new Scanner(System.in);

    public String dadosCliente() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.println("Digite a agência com dígito: ");
        String agencia = scanner.next(); // Formatamos em string por conta do hífen Ex: 0011-1

        System.out.println("Digite seu nome: ");
        scanner.nextLine(); // Consumir a nova linha pendente
        String nomeCliente = scanner.nextLine();

        String mensagem = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, "
                + "sua agência é " + agencia + ", Conta: " + numeroConta + " e seu saldo de R$" + saldoDisponivel + " já está disponível para saque";

        return mensagem;
    }

    public void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Depósito");
        System.out.println("2. Transferência");
        System.out.println("3. Saldo");
        System.out.println("4. Sair");
    }

    public void menu() {
        int opcaoCliente;
        BigDecimal saldoAtualizado = saldoDisponivel;
        BigDecimal valorDeposito;
        BigDecimal valorTransferencia;

        while (true) {
            exibirMenu();
            opcaoCliente = scanner.nextInt();
            switch (opcaoCliente) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    valorDeposito = new BigDecimal(scanner.next());
                    saldoAtualizado = saldoAtualizado.add(valorDeposito);
                    System.out.printf("Saldo atualizado: R$ %.2f\n", saldoAtualizado);
                    break;
                case 2:
                    System.out.print("Digite o valor da transferência: ");
                    valorTransferencia = new BigDecimal(scanner.next());
                    if (valorTransferencia.compareTo(saldoAtualizado) <= 0) {
                        saldoAtualizado = saldoAtualizado.subtract(valorTransferencia);
                        System.out.printf("Saldo atualizado: R$ %.2f\n", saldoAtualizado);
                    } else {
                        System.out.println("Saldo insuficiente para a transferência.");
                    }
                    break;
                case 3:
                    System.out.printf("Saldo disponível: R$ %.2f\n", saldoAtualizado);
                    break;
                case 4:
                    System.out.println("Obrigado por usar nosso sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Digite uma opção válida");
            }
        }
    }
}