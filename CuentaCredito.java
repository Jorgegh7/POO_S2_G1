import java.util.Scanner;

public class CuentaCredito extends Cuenta{
    private static long limiteCredito= 1000000;
    private long deudaCredito =0;
    public static long numeroCuentaCredito;

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
        if(abono<=0 ){
            System.out.println("Numero ingresado invalido");
        } else if (abono> deudaCredito) {
            System.out.println("Has ingresado un numero mayor a tu deuda");
        }else{
            deudaCredito = deudaCredito - abono;
            System.out.println("Realizaste un abono por el valor de: $" + abono);
            System.out.println("El valor de tu credito total es: $" + deudaCredito);

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
        }


    }

}
