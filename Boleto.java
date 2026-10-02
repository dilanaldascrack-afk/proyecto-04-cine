public abstract class Boleto implements Facturable {
    private String codigo;
    private int fila;
    private int columna;
    private double precioBase;
    private static int totalBoletosVendidos = 0;
    private static double dineroCaja = 0;

    public Boleto(String codigo, int fila, int columna, double precioBase) {
        this.codigo = codigo;
        this.fila = fila;
        this.columna = columna;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public static int getTotalBoletosVendidos() {
        return totalBoletosVendidos;
    }

    public static double getDineroCaja() {
        return dineroCaja;
    }

    public void setFila(int fila) {
        if (fila > 0) {
            this.fila = fila;
        } else {
            System.out.println("La fila debe ser mayor que 0.");
        }
    }

    public void setColumna(int columna) {
        if (columna > 0) {
            this.columna = columna;
        } else {
            System.out.println("La columna debe ser mayor que 0.");
        }
    }

    public void setCodigo(String codigo) {
        if (codigo != null) {
            this.codigo = codigo;
        } else {
            System.out.println("El código no puede estar vacío.");
        }
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase >= 0) {
            this.precioBase = precioBase;
        } else {
            System.out.println("El precio no puede ser negativo.");
        }
    }

    public double calcularPrecioFinal() {
        return precioBase;
    }

    public static void registraVenta(double precio) {
        totalBoletosVendidos++;
        dineroCaja += precio;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo()
                + "\nFila: " + getFila()
                + "\nColumna: " + getColumna()
                + "\nPrecio Base: " + getPrecioBase()
                + "\nPrecio Final: " + calcularPrecioFinal();
    }
}
