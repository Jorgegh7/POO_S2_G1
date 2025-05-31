import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Administracion {
    static ArrayList <Cliente> listaCliente = new ArrayList<>();
    static HashMap <String, Object> clienteRegistradoPorRut = new HashMap<>();
    static HashMap <String, Object> cuentaCorrienteRegistadaPorRut = new HashMap<>();
    static HashMap <String, Object> cuentaAhorroRegistadaPorRut = new HashMap<>();
    static HashMap <String, Object> cuentaCreditoRegistadaPorRut = new HashMap<>();


    public static void Bienvenida(){
        System.out.println("=================");
        System.out.println("|  BANK BOSTON  |");
        System.out.println("=================");
        System.out.println();
        System.out.println("Bienvenido a Bank Boston!");


    }

    public static void Menu(){
        System.out.println();
        System.out.println("Escoge tu opciòn:");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Ver datos Cliente");
        System.out.println("3. Cuentas");
        System.out.println("4. Salir");

    }

    public static int menuInternoCuentas(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Elige la acción que deseas realizar: ");
        System.out.println("1. Crear Cuenta");
        System.out.println("2. Ver Estado Cuenta");
        System.out.println("3. Giro");
        System.out.println("4. Deposito");
        System.out.println("5. Información de Giros y Deposito");
        System.out.println("6. Salir");

        int opcionMenu= scanner.nextInt();
        return opcionMenu;

    }

    public static int menuCredito(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Elige la acción que deseas realizar: ");
        System.out.println("1. Crear Cuenta");
        System.out.println("2. Ver Estado Cuenta");
        System.out.println("3. Credito");
        System.out.println("4. Abono");
        System.out.println("5. Salir");

        int opcionMenu= scanner.nextInt();
        return opcionMenu;
    }

}
