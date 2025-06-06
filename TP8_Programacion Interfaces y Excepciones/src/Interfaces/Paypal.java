package Interfaces;

public class Paypal implements PagoConDescuento{
    private String email;
    private double montoAPagar;
    final double MAXIMODESCUENTO = 80;
    final double MONTOMINIMODESCUENTO = 2000;

    public Paypal(String email) {
        this.email = email;
        this.montoAPagar = 0;
    }

    @Override
    public void procesarPago(double monto) {
        this.montoAPagar = monto;
        System.out.println("Procesando el pago de $" + monto + " de la cuenta PayPal " + email);
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        if (validarDescuento(porcentaje)) {
            this.montoAPagar = montoAPagar - montoAPagar * porcentaje / 100;
            System.out.printf("Se aplicó el descuento del %.0f%%\nMonto con descuento: $%.2f%n",
                    porcentaje, montoAPagar);
        } else {
            System.out.printf("Monto a pagar $%.02f %n", montoAPagar);
        }
        System.out.println();
    }
    private boolean validarDescuento(double porcentaje){
        boolean esValido = true;
        if (porcentaje > MAXIMODESCUENTO) {
            System.out.printf("No se realizo el descuento: El máximo de descuento a aplicar es del %.0f%% %n", MAXIMODESCUENTO);
            esValido = false;
        }
        if (montoAPagar < MONTOMINIMODESCUENTO) {
            System.out.printf("No se realizo el descuento: El monto mínimo para aplicar descuento es de $%.0f%n", MONTOMINIMODESCUENTO);
            esValido = false;
        }
        return esValido;
    }
}
