public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(long numeroCuenta, long saldoCuenta) {
        super(numeroCuenta, saldoCuenta);
    }
public void estadoCuenta(){
    System.out.println("Numero de Cuenta: " + getNumeroCuenta());
    System.out.println("Saldo: $" + getSaldoCuenta());
}

    @Override
    public void imprimirCuenta() {
        System.out.println("------------------------");
        System.out.println("Cuenta de Corriente");
        System.out.println("------------------------");
        System.out.println("Numero de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: $" + getSaldoCuenta());
        System.out.println("------------------------");

    }

    @Override
    public void girar(String rut, long giro) {
        super.girar(rut, giro);
        if (giro <= 0 || giro > getSaldoCuenta()) {
            System.out.println("Accion invalida");
        } else {
            setSaldoCuenta(getSaldoCuenta()-giro);
            System.out.println("Tu saldo actual es: $" + getSaldoCuenta());
        }
    }
}
