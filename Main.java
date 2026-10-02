import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Boleto[][] sala = new Boleto[5][5];

        System.out.println("===== CINE =====");
        System.out.println("La sala tiene " + (sala.length * sala[0].length) + " asientos.");

        System.out.println("\n¿Cuántos boletos desea comprar?");
        int cantidadBoletos = sc.nextInt();

        if (cantidadBoletos <= 0) {

            System.out.println("La cantidad debe ser mayor que 0.");

        } else if (cantidadBoletos > sala.length * sala[0].length) {

            System.out.println("No hay suficientes asientos.");

        } else {

            for (int i = 1; i <= cantidadBoletos; i++) {

                System.out.println("\n--- Boleto " + i + " ---");

                System.out.println("Ingrese la fila (1-" + sala.length + "):");
                int fila = sc.nextInt();

                System.out.println("Ingrese la columna (1- " + sala[0].length + "):");
                int columna = sc.nextInt();

                if (fila >= 1 && fila <= sala.length &&
                        columna >= 1 && columna <= sala[0].length) {

                    fila--;
                    columna--;

                    if (sala[fila][columna] == null) {

                        System.out.println("Asiento disponible.");

                        System.out.println("¿Qué tipo de boleto desea?");
                        System.out.println("1. General");
                        System.out.println("2. VIP");

                        int tipo = sc.nextInt();

                        if (tipo == 1) {

                            BoletoGeneral boleto = new BoletoGeneral("G00" + i,fila + 1,columna + 1,35.09);

                            sala[fila][columna] = boleto;
                            Boleto.registraVenta(boleto.calcularPrecioFinal());

                        } else if (tipo == 2) {

                            BoletoVIP boleto = new BoletoVIP("V00" + i,fila + 1,columna + 1,44.80,2.00);

                            sala[fila][columna] = boleto;
                            Boleto.registraVenta(boleto.calcularPrecioFinal());

                        } else {

                            System.out.println("Tipo de boleto incorrecto.");
                            i--;
                            continue;
                        }

                        System.out.println("\n--- BOLETO ---");
                        System.out.println(sala[fila][columna]);

                    } else {

                        System.out.println("El asiento está ocupado.");
                        i--;
                    }

                } else {

                    System.out.println("Dirección incorrecta.");
                    i--;
                }
            }
        }

        System.out.println("\n===============CINE===============");

        for (int i = 0; i < sala.length; i++) {

            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j] == null) {
                    System.out.print("[O] ");
                } else {
                    System.out.print("[X] ");
                }
            }

            System.out.println();
        }

        System.out.println("===============VENTAS DEL DIA=============");
        System.out.println("Boletos vendidos : " + Boleto.getTotalBoletosVendidos());
        System.out.println("Cantidad generada : " + Boleto.getDineroCaja());

        System.out.println("\n===== BUSCAR BOLETO =====");
        System.out.println("Ingrese el código del boleto:");
        String codigoBuscar = sc.next();

        boolean encontrado = false;

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j] != null &&
                        sala[i][j].getCodigo().equals(codigoBuscar)) {

                    System.out.println("\nBoleto encontrado:");
                    System.out.println(sala[i][j]);

                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Boleto no encontrado.");
        }

        System.out.println("===== BOLETOS ORDENADOS POR PRECIO =====");

        Boleto[] boletos = new Boleto[Boleto.getTotalBoletosVendidos()];
        int posicion = 0;

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {

                if (sala[i][j] != null) {
                    boletos[posicion] = sala[i][j];
                    posicion++;
                }
            }
        }

        for (int i = 0; i < boletos.length - 1; i++) {

            for (int j = 0; j < boletos.length - 1 - i; j++) {

                if (boletos[j].calcularPrecioFinal() < boletos[j + 1].calcularPrecioFinal()) {

                    Boleto aux = boletos[j];
                    boletos[j] = boletos[j + 1];
                    boletos[j + 1] = aux;
                }
            }
        }

        System.out.println("-----------Boletos ordenados:-----------");

        for (int i = 0; i < boletos.length; i++) {
            System.out.println(boletos[i]);
            System.out.println();
        }
        sc.close();
    }
}