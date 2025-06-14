import java.util.HashMap;

public class CuentaAhorro extends Cuenta implements InformacionProducto{
    int numeroGiros=0;
    int numeroDeposito=0;
    private HashMap<Integer, Long> listaGiros = new HashMap<>();
    private HashMap<Integer, Long> listaDepositos = new HashMap<>();


    public CuentaAhorro(long numeroCuenta, long saldoCuenta) {
        super(numeroCuenta, saldoCuenta);
    }

    public void estadoCuenta(){
        System.out.println("------------------------");
        System.out.println("Cuenta de Ahorros");
        System.out.println("------------------------");
        System.out.println("Numero de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: $" + getSaldoCuenta());
        System.out.println("Numero de giros:" + numeroGiros);
        System.out.println("------------------------");
    }

    @Override
    public void depositar(String rut, long deposito) {
        super.depositar(rut, deposito);
        numeroDeposito++;
        listaDepositos.put(numeroDeposito, deposito);
    }

    @Override
    public void girar(String rut, long giro) {
        super.girar(rut, giro);
        System.out.println("La cuenta de ahorro permite un maximo de 2 giros");
        System.out.println("El monto maximo por giro permitido es de $100.000 CLP");

        if(giro<=0){
            System.out.println("Valor ingresado invalido");
        } else if (giro>getSaldoCuenta()) {
            System.out.println("El giro ingresado supera tu saldo actual");
        } else if (giro>100000) {
            System.out.println("El maximo permitido por giro es $100.000 CLP");
        } else if (numeroGiros==2) {
            System.out.println("Alcanzaste el maximo de giros permitido");
        }else{
            numeroGiros++;
            setSaldoCuenta(getSaldoCuenta()-giro);
            estadoCuenta();
            listaGiros.put(numeroGiros, giro);
        }
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
