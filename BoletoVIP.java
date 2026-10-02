public class BoletoVIP extends Boleto {
    private double recargoAdicional;

    public double getRecargoAdicional() {
        return recargoAdicional;
    }

    public void setRecargoAdicional(double recargoAdicional) {
        if (recargoAdicional >= 0) {
            this.recargoAdicional = recargoAdicional;
        } else {
            System.out.println("El recargo no puede ser negativo.");
        }
    }

    public BoletoVIP(String codigo, int fila, int columna, double precioBase, double recargoAdicional) {
        super(codigo, fila, columna, precioBase);
        this.recargoAdicional = recargoAdicional;
    }

    @Override

    public double calcularPrecioFinal() {
        return this.getPrecioBase() + this.recargoAdicional;
    }

    @Override
    public void imprimirBoleto() {
        System.out.println("Codigo : " + getCodigo() + "\n Fila : " + getFila() + "\n Columna : " + getColumna()
                + " \n Precio Base " + getPrecioBase() + "\n Recargo Adicional : " + getRecargoAdicional()
                + "\n Precio final : " + calcularPrecioFinal());
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nRecargo Adicional: " + getRecargoAdicional();
    }
}
