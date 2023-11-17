import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private static Scanner sc = new Scanner(System.in, "UTF-8");

    private Client() {
    }

    public static void main(String[] args) {
        Double x, y;
        String response;

        System.out.println("escolha a operação:\n1) Soma\n2) Subtracao\n3) Multiplicacao\n4) Divisao");
        int resp = sc.nextInt();
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            Calculator stub = (Calculator) registry.lookup("Calculator");

            switch (resp) {
                case 1:
                    System.out.println("Esta operação realizara uma soma de x+y\n preencha o valor de x:");
                    x = sc.nextDouble();
                    System.out.println("preencha o valor de y:");
                    y = sc.nextDouble();

                    response = stub.sum(x, y).toString();
                    System.out.println("response: " + response);
                    break;
                case 2:
                    System.out.println("Esta operação realizara uma subtracao de x-y\n preencha o valor de x:");
                    x = sc.nextDouble();
                    System.out.println("preencha o valor de y:");
                    y = sc.nextDouble();

                    response = stub.subtract(x, y).toString();
                    System.out.println("response: " + response);
                    break;

                case 3:
                    System.out.println("Esta operação realizara uma multiplicacao de x*y\n preencha o valor de x:");
                    x = sc.nextDouble();
                    System.out.println("preencha o valor de y:");
                    y = sc.nextDouble();

                    response = stub.multiply(x, y).toString();
                    System.out.println("response: " + response);
                    break;

                case 4:
                    System.out.println("Esta operação realizara uma divisao de x/y\n preencha o valor de x:");
                    x = sc.nextDouble();
                    System.out.println("preencha o valor de y:");
                    y = sc.nextDouble();

                    response = stub.divide(x, y).toString();
                    System.out.println("response: " + response);
                    break;

                default:
                    System.out.println("Nenhuma opcao valida selecionada.");
                    break;
            }
            main(args);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        sc.close();
    }
}