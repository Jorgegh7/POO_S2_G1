import java.util.HashMap;

public class CuentaCorriente extends Cuenta implements InformacionProducto {

    int numeroGiro=0;
    int numeroDeposito=0;
    private HashMap<Integer, Long> listaGiros = new HashMap<>();
    private HashMap<Integer, Long> listaDepositos = new HashMap<>();

    public CuentaCorriente(long numeroCuenta, long saldoCuenta) {
        super(numeroCuenta, saldoCuenta);
    }

    public void estadoCuenta() {
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
            setSaldoCuenta(getSaldoCuenta() - giro);
            System.out.println("Tu saldo actual es: $" + getSaldoCuenta());
            numeroGiro++;
            listaGiros.put(numeroGiro, giro);
        }
    }

    @Override
    public void depositar(String rut, long deposito) {
        super.depositar(rut, deposito);
        numeroDeposito++;
        listaDepositos.put(numeroDeposito, deposito);
    }

    @Override
    public void informacionTransacciones() {
        if (!listaDepositos.isEmpty()){
            for(int i=0; i<listaDepositos.size(); i++){
                System.out.println("Deposito Numero:" +(i+1));
                System.out.println("Valor Deposito: $" + listaDepositos.get(i + 1));
                System.out.println();

            }
        }else {
            System.out.println("No has realizado giros en tu cuenta");
        }

        if (!listaGiros.isEmpty()) {
            for (int i = 0; i < listaGiros.size(); i++) {
                System.out.println("Giro Numero:" + (i+1));
                System.out.println("Valor Giro: $" + listaGiros.get(i + 1));
                System.out.println();
            }
        }else {
            System.out.println("No has realizado giros en tu cuenta");
            System.out.println();
        }
    }
}
