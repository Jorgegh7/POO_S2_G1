import java.util.Scanner;

public class VerificarRut {
    String rut;

    public static String verificarRut(){
        Scanner scannerRut = new Scanner(System.in);
        System.out.println("Ingresa tu rut");
        String rut= scannerRut.nextLine();
        Cliente.rut(rut);
        String rutVerificado = rut;
        return rutVerificado;
    }



}
