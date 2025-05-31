import java.util.HashMap;

public class CuentaCredito extends Cuenta implements InformacionProducto{

    private HashMap<Integer, Long> listaCreditos = new HashMap<>();
    private HashMap<Integer, Long> listaAbonos = new HashMap<>();

    private static long limiteCredito= 1000000;
    private long deudaCredito =0;
    int numeroGiros=0;
    int numeroAbonos=0;


    public CuentaCredito(long numeroCuenta, long saldoCuenta) {
        super(numeroCuenta, saldoCuenta);
    }

    public void estadoCuenta(){
        System.out.println("------------------------");
        System.out.println("Cuenta de Credito");
        System.out.println("------------------------");
        System.out.println("Numero de Cuenta: " + getNumeroCuenta());
        System.out.println("Limite de deuda: $" + limiteCredito);
        System.out.println("Crédito disponible: $" + (limiteCredito - deudaCredito));
        System.out.println("Deuda: $" + deudaCredito);
        System.out.println("------------------------");

    }

    public void abonar(String rut, long abono) {
        if(abono<=0 ) {
            System.out.println("Numero ingresado invalido");
        }else if(deudaCredito==0){
            System.out.println("Tu Cuenta de Credito se encuentra en $0");
            System.out.println("No puedes realizar un abono");

        }else if (abono> deudaCredito) {
            System.out.println("Has ingresado un numero mayor a tu deuda");
        }else{
            deudaCredito = deudaCredito - abono;
            System.out.println("Realizaste un abono por el valor de: $" + abono);
            System.out.println("El valor de tu credito total es: $" + deudaCredito);
            numeroAbonos++;
            listaAbonos.put(numeroAbonos, abono);
        }
    }

    @Override
    public void girar(String rut, long credito) {
        super.girar(rut, credito);

        if(credito <1000 || credito>=limiteCredito){
            System.out.println("Monto ingresado invalido");
        } else if (credito + deudaCredito > limiteCredito) {
            System.out.println("No puedes contratar el credito por sobrecupo");
        }else{
            deudaCredito = deudaCredito +credito;
            System.out.println("Contrataste un credito por el valor de: $" + credito);
            System.out.println("Valor Total Credito: $" + deudaCredito);
            numeroGiros++;
            listaCreditos.put(numeroGiros, credito);
        }
    }

    @Override
    public void informacionTransacciones() {
        if (!listaCreditos.isEmpty()) {
            for (int i = 0; i < listaCreditos.size(); i++) {
                System.out.println("Credito Numero:" + (i+1));
                System.out.println("Valor Credito: $" + listaCreditos.get(i + 1));
                System.out.println();
            }
        }else {
            System.out.println("No has realizado giros en tu Cuenta de Credito");
            System.out.println();
        }

        if (!listaAbonos.isEmpty()){
            for(int i=0; i<listaAbonos.size(); i++){
                System.out.println("Abono Numero:" +(i+1));
                System.out.println("Valor Abono: $" + listaAbonos.get(i + 1));
                System.out.println();
            }
        }else {
            System.out.println("No has realizado Abonos en tu cuenta");
        }
    }
}
