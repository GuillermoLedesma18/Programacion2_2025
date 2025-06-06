package Interfaces;

public interface PagoConDescuento extends Pago {
    abstract void aplicarDescuento(double porcentaje);
}
