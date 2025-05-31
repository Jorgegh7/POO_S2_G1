import java.util.Scanner;

public class BankBostonMain {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        Scanner scanner= new Scanner(System.in);
        int opcionMenuPrincipal;
        
        Administracion.Bienvenida();

        do {
            Administracion.Menu();
            opcionMenuPrincipal= scanner.nextInt();

            switch (opcionMenuPrincipal) {
                case 1:
                    Cliente.registroCliente(cliente);
                    break;
                case 2:
                    if(Administracion.listaCliente.isEmpty()){
                        System.out.println("Aun no eres Cliente del Banco");
                    }else{
                        Cliente.impresionDatosCliente();
                    }
                    break;
                case 3:
                    scanner= new Scanner(System.in);

                    System.out.println("Escoge tu opción:");
                    System.out.println();
                    System.out.println("1. Cuenta Corriente");
                    System.out.println("2. Cuenta de Ahorros");
                    System.out.println("3. Cuenta de Credito");
                    System.out.println("4. Salir");

                    int opcionCuenta= scanner.nextInt();

                    switch (opcionCuenta){
                        case 1:
                            int opcionMenu= Administracion.menuInternoCuentas();
                            switch (opcionMenu){


                                case 1:
                                    String rutVerificado=VerificarRut.verificarRut();
                                    if(Administracion.clienteRegistradoPorRut.containsKey(rutVerificado)){
                                        if(Administracion.cuentaCorrienteRegistadaPorRut.containsKey(rutVerificado)){
                                            System.out.println("Ya posees una cuenta registrada");
                                            System.out.println("No puedes poseer mas de una Cuenta Corriente");
                                        }else{
                                            CuentaCorriente cuentaCorriente= new CuentaCorriente(CuentaCorriente.numeroAleatorioCuenta(), CuentaCorriente.saldoInicialCuenta());
                                            Administracion.cuentaCorrienteRegistadaPorRut.put(rutVerificado, cuentaCorriente);
                                            System.out.println("Cuenta creada con exito");
                                            System.out.println();
                                            cuentaCorriente.imprimirCuenta();
                                        }
                                    }else{
                                        System.out.println("Debes registrate como Cliente primero");
                                    }
                                    break;


                                case 2:
                                    String rutVerificado2=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCorrienteRegistadaPorRut.containsKey(rutVerificado2)){
                                        CuentaCorriente cuentaCorrienteConsulta = (CuentaCorriente) Administracion.cuentaCorrienteRegistadaPorRut.get(rutVerificado2);
                                        cuentaCorrienteConsulta.imprimirCuenta();
                                    }else {
                                        System.out.println("No posees una cuenta Corriente registrada");
                                    }
                                    break;

                                case 3:
                                    String rutVerificado3=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCorrienteRegistadaPorRut.containsKey(rutVerificado3)){
                                        CuentaCorriente cuentaCorrienteConsulta = (CuentaCorriente) Administracion.cuentaCorrienteRegistadaPorRut.get(rutVerificado3);
                                        System.out.println("Ingresa el valor que deseas girar");
                                        Scanner scannerGiro = new Scanner(System.in);
                                        long giro= scannerGiro.nextInt();
                                        cuentaCorrienteConsulta.girar(rutVerificado3, giro);

                                    }else {
                                        System.out.println("No posees una cuenta Corriente registrada");
                                    }

                                    break;
                                case 4:
                                    String rutVerificado4=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCorrienteRegistadaPorRut.containsKey(rutVerificado4)){
                                        Scanner scannerDeposito = new Scanner(System.in);
                                        CuentaCorriente cuentaCorrienteConsulta = (CuentaCorriente) Administracion.cuentaCorrienteRegistadaPorRut.get(rutVerificado4);
                                        System.out.println("Ingresa el monto que deseas depositar:");
                                        long deposito = scannerDeposito.nextInt();
                                        cuentaCorrienteConsulta.depositar(rutVerificado4, deposito);

                                    }else {
                                        System.out.println("No posees una cuenta Corriente registrada");
                                    }
                                    break;
                                case 5:
                                    String rutVerificado5=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCorrienteRegistadaPorRut.containsKey(rutVerificado5)) {
                                        CuentaCorriente cuentaCorrienteConsulta = (CuentaCorriente) Administracion.cuentaCorrienteRegistadaPorRut.get(rutVerificado5);
                                        System.out.println("Estado actual de cuenta");
                                        cuentaCorrienteConsulta.imprimirCuenta();
                                        cuentaCorrienteConsulta.informacionTransacciones();
                                    }else{
                                        System.out.println("No posees una cuenta corriente registrada");
                                    }
                                    break;

                                case 6:
                                    Administracion.Menu();
                                    break;
                            }
                            break;


                        case 2:
                            opcionMenu= Administracion.menuInternoCuentas();
                            switch (opcionMenu) {
                                case 1:
                                    Scanner scannerRut = new Scanner(System.in);

                                    System.out.println("Ingresa tu rut");
                                    String rut= scannerRut.nextLine();
                                    Cliente.rut(rut);
                                    String rutVerificado = rut;
                                    if(Administracion.clienteRegistradoPorRut.containsKey(rutVerificado)){
                                        if(Administracion.cuentaAhorroRegistadaPorRut.containsKey(rutVerificado)){
                                            System.out.println("Ya posees una cuenta registrada");
                                            System.out.println("No puedes poseer mas de una Cuenta Ahorro");
                                        }else{
                                            CuentaAhorro cuentaAhorro= new CuentaAhorro(CuentaAhorro.numeroAleatorioCuenta(), CuentaAhorro.saldoInicialCuenta());
                                            Administracion.cuentaAhorroRegistadaPorRut.put(rutVerificado, cuentaAhorro);
                                            System.out.println("Cuenta creada con exito");
                                            cuentaAhorro.estadoCuenta();
                                        }
                                    }else{
                                        System.out.println("Debes registrate como Cliente primero");
                                    }
                                    break;
                                case 2:
                                    String rutVerificado2=VerificarRut.verificarRut();
                                    if(Administracion.cuentaAhorroRegistadaPorRut.containsKey(rutVerificado2)){
                                        CuentaAhorro cuentaAhorroConsulta = (CuentaAhorro) Administracion.cuentaAhorroRegistadaPorRut.get(rutVerificado2);
                                        cuentaAhorroConsulta.estadoCuenta();
                                    }else {
                                        System.out.println("No posees una cuenta Ahorro registrada");
                                    }
                                    break;
                                case 3:
                                    String rutVerificado3=VerificarRut.verificarRut();
                                    if(Administracion.cuentaAhorroRegistadaPorRut.containsKey(rutVerificado3)){
                                        CuentaAhorro cuentaAhorroConsulta = (CuentaAhorro) Administracion.cuentaAhorroRegistadaPorRut.get(rutVerificado3);
                                        System.out.println("Ingresa el valor que deseas girar");
                                        Scanner scannerGiro = new Scanner(System.in);
                                        long giro= scannerGiro.nextInt();
                                        cuentaAhorroConsulta.girar(rutVerificado3, giro);

                                    }else {
                                        System.out.println("No posees una cuenta Ahorros registrada");
                                    }
                                    break;
                                case 4:
                                    String rutVerificado4=VerificarRut.verificarRut();
                                    if(Administracion.cuentaAhorroRegistadaPorRut.containsKey(rutVerificado4)){
                                        Scanner scannerDeposito = new Scanner(System.in);
                                        CuentaAhorro cuentaAhorroConsulta = (CuentaAhorro) Administracion.cuentaAhorroRegistadaPorRut.get(rutVerificado4);
                                        System.out.println("Ingresa el monto que deseas depositar:");
                                        long deposito = scannerDeposito.nextInt();
                                        cuentaAhorroConsulta.depositar(rutVerificado4, deposito);
                                    }else {
                                        System.out.println("No posees una cuenta Ahorro registrada");
                                    }
                                    break;
                                case 5:
                                    String rutVerificado5=VerificarRut.verificarRut();
                                    if(Administracion.cuentaAhorroRegistadaPorRut.containsKey(rutVerificado5)) {
                                        CuentaAhorro cuentaAhorroConsulta = (CuentaAhorro) Administracion.cuentaAhorroRegistadaPorRut.get(rutVerificado5);
                                        System.out.println("Estado actual de cuenta");
                                        cuentaAhorroConsulta.imprimirCuenta();
                                        cuentaAhorroConsulta.informacionTransacciones();
                                    }else{
                                        System.out.println("No posees una Cuenta Ahorro registrada");
                                    }
                                    break;
                                case 6:
                                    Administracion.Menu();
                                    break;
                            }
                            break;


                        case 3:
                            opcionMenu= Administracion.menuCredito();
                            switch (opcionMenu) {
                                case 1:
                                    Scanner scannerRut = new Scanner(System.in);

                                    System.out.println("Ingresa tu rut");
                                    String rut= scannerRut.nextLine();
                                    Cliente.rut(rut);
                                    String rutVerificado = rut;
                                    if(Administracion.clienteRegistradoPorRut.containsKey(rutVerificado)){
                                        if(Administracion.cuentaCreditoRegistadaPorRut.containsKey(rutVerificado)){
                                            System.out.println("Ya posees una cuenta registrada");
                                            System.out.println("No puedes poseer mas de una Cuenta Corriente");
                                        }else{
                                            CuentaCredito cuentaCredito= new CuentaCredito(CuentaCredito.numeroAleatorioCuenta(), CuentaCredito.saldoInicialCuenta());
                                            Administracion.cuentaCreditoRegistadaPorRut.put(rutVerificado, cuentaCredito);
                                            System.out.println("Cuenta creada con exito");
                                            cuentaCredito.estadoCuenta();
                                        }
                                    }else{
                                        System.out.println("Debes registrate como Cliente primero");
                                    }

                                    break;
                                case 2:
                                    String rutVerificado2=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCreditoRegistadaPorRut.containsKey(rutVerificado2)){
                                        CuentaCredito cuentaCredito = (CuentaCredito) Administracion.cuentaCreditoRegistadaPorRut.get(rutVerificado2);
                                        cuentaCredito.estadoCuenta();
                                    }else {
                                        System.out.println("No posees una cuenta Corriente registrada");
                                    }
                                    break;
                                case 3:
                                    String rutVerificado3=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCreditoRegistadaPorRut.containsKey(rutVerificado3)) {
                                        CuentaCredito cuentaCreditoConsulta = (CuentaCredito) Administracion.cuentaCreditoRegistadaPorRut.get(rutVerificado3);
                                        System.out.println("Ingresa el monto del Credito que deseas contratar");
                                        System.out.println("Este valor debe ser mayor a $1000");
                                        System.out.println("El cupo máximo de la Cuenta Credito es de $1.000.000 CLP");
                                        Scanner scannerGiro = new Scanner(System.in);
                                        long giro = scannerGiro.nextLong();
                                        cuentaCreditoConsulta.girar(rutVerificado3, giro);
                                    }
                                    break;
                                case 4:
                                    String rutVerificado4=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCreditoRegistadaPorRut.containsKey(rutVerificado4)) {
                                        Scanner scannerAbonar = new Scanner(System.in);
                                        CuentaCredito cuentaCreditoConsulta = (CuentaCredito) Administracion.cuentaCreditoRegistadaPorRut.get(rutVerificado4);
                                        System.out.println("Ingresa el monto que deseas Abonar:");
                                        long abonar = scannerAbonar.nextInt();
                                        cuentaCreditoConsulta.abonar(rutVerificado4, abonar);
                                    }
                                    break;

                                case 5:
                                    String rutVerificado5=VerificarRut.verificarRut();
                                    if(Administracion.cuentaCreditoRegistadaPorRut.containsKey(rutVerificado5)) {
                                        CuentaCredito cuentaCreditoConsulta = (CuentaCredito) Administracion.cuentaCreditoRegistadaPorRut.get(rutVerificado5);
                                        System.out.println("Estado actual de cuenta");
                                        cuentaCreditoConsulta.estadoCuenta();
                                        cuentaCreditoConsulta.informacionTransacciones();
                                    }else{
                                        System.out.println("No posees una Cuenta Credito registrada");
                                    }
                                    break;
                                case 6:
                                    Administracion.Menu();
                                    break;
                            }
                            break;
                            
                        case 4:
                            Administracion.Menu();
                            break;
                    }
                    break;
            }

        }while(opcionMenuPrincipal<4 && opcionMenuPrincipal !=0);

        System.out.println("Gracias por preferir Bank Boston");
        System.out.println("Hasta la proxima!");


    }
}
