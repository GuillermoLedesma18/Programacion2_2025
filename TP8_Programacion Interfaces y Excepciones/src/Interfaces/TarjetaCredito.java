package Interfaces;

public class TarjetaCredito implements PagoConDescuento{
    private String numero;
    private double montoAPagar;
    private final Double MAXIMODESCUENTO = 85.0;

    public TarjetaCredito(String numero) {
        this.numero = numero;
        this.montoAPagar = 0;
    }

    @Override
    public void procesarPago(double monto) {
        this.montoAPagar = monto;
        System.out.println("Procesando pago de $" + monto + "de la tarjeta xxxx-xxxx-xxxx-" + numero.substring(this.numero.length()-4));
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < MAXIMODESCUENTO) {
        this.montoAPagar = montoAPagar - montoAPagar * porcentaje / 100;
            System.out.printf("Se aplicó el descuento del %.0f%%\nMonto con descuento: $%.2f%n",
                    porcentaje, montoAPagar);
        }
        else  {
            System.out.printf("No se puede aplicar más del %.0f%% de descuento.%n", MAXIMODESCUENTO);
        }
    }
}
