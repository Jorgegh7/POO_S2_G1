public abstract class Cuenta {
    private long numeroCuenta;
    private long saldoCuenta;

    public Cuenta(long numeroCuenta, long saldoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
    }


    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public long getSaldoCuenta() {
        return saldoCuenta;
    }
    public void setSaldoCuenta(long saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }


    public void depositar(String rut, long deposito){
        saldoCuenta= saldoCuenta + deposito;
        System.out.println("Tu saldo actual es: $" + saldoCuenta);

    }

    public void girar(String rut, long giro) {

    }

    public static long saldoInicialCuenta(){
        return 0;
    }

    public void imprimirCuenta(){
        System.out.println("------------------");
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldoCuenta);
        System.out.println("------------------");
    }

    public static long numeroAleatorioCuenta(){
        double numeroAleatorio = (Math.random()*10000000) +110000000;
        numeroAleatorio = Math.round(numeroAleatorio);
        return (long) numeroAleatorio;
    }

    public abstract void estadoCuenta();

    @Override
    public String toString() {
        return "-----------------------" + '\n' +
                "Numero Cuenta: " + getNumeroCuenta()+ '\n' +
                "Saldo: $" + getSaldoCuenta() + " CLP" + '\n' +
                "-----------------------";
    }
}
