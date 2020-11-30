package pkg8.reinas;

import static pkg8.reinas.Helpers.logLn;
import static pkg8.reinas.Helpers.readString;
import static pkg8.reinas.Helpers.isNumber;
import static pkg8.reinas.Helpers.isNumberInRange;

public class Reinas {

    public static void main(String[] args) {
        logLn("Algorítmo de las 8 reinas");
        logLn("Coloque la cantidad de reinas");
        boolean seguir = true;

        while (seguir) {
            String str = readString();
            if (!str.isEmpty() && isNumber(str)) {
                int queens = Integer.parseInt(str);
                if (isNumberInRange(queens)) {
                    new MainProgram(queens);
                    seguir = false;
                } else {
                    logLn("El valor ingresado no es un numero en el rango 1-8.\nIntente de nuevo:");
                }
            } else {
                logLn("El valor ingresado no es un numero valido.\nIntente de nuevo:");
            }
        }
    }
}
