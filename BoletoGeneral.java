public class BoletoGeneral extends Boleto {
    public BoletoGeneral(String codigo, int fila, int columna, double precioBase) {
        super(codigo, fila, columna, precioBase);

    }

    public BoletoGeneral(String codigo, int fila, int columna) {
        this(codigo, fila, columna, 35.09);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase();
    }

    @Override
    public void imprimirBoleto() {
        System.out.println("Codigo : " + getCodigo() + "\n Fila : " + getFila() + "\n Columna : " + getColumna()
                + " \n Precio Base " + getPrecioBase());
    }

}
