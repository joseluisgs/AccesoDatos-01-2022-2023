package es.joseluisgs.dam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExrpesionesRegulares {
    public void run() {
        patronExacto("abc");
        contieneCadena("wabcrt");
        cadenaEmpieza("abcrty");
        cadenaEmpieza2("abcrty");
        cadenaEmpieza2("Abcrty");
        cadenaConLongitud("abcfrtya");
        cadenaNoEmpiezaConLongitud("adbgsre");
        cadenaNoEmpiezaConLongitud("abcdrt");
        cadenaSoloTieneAoB("abbbbabababa");
        cadenaSoloTiene1YNoSeguidoDe2("11133231167");
        esEmailValido("perico.palotes@iesluisvives.es");
    }

    private void patronExacto(String cadena) {
        Pattern pat = Pattern.compile("abc");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void contieneCadena(String cadena) {
        Pattern pat = Pattern.compile(".*abc.*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaEmpieza(String cadena) {
        Pattern pat = Pattern.compile("^abc.*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("Válido");
        } else {
            System.out.println("No Válido");
        }
    }

    private void cadenaEmpieza2(String cadena) {
        Pattern pat = Pattern.compile("^[aA]bc.*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaConLongitud(String cadena) {
        Pattern pat = Pattern.compile("[a-zA-Z]{5,10}");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaNoEmpiezaConLongitud(String cadena) {
        Pattern pat = Pattern.compile("^[^\\d].*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaNoAcabaConDigito(String cadena) {
        Pattern pat = Pattern.compile(".*[^\\d]$");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaSoloTieneAoB(String cadena) {
        Pattern pat = Pattern.compile("(a|b)+");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void cadenaSoloTiene1YNoSeguidoDe2(String cadena) {
        Pattern pat = Pattern.compile(".*1(?!2).*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private void esEmailValido(String email) {
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        if(mat.find()){
            System.out.println("Correo Válido");
        }else{
            System.out.println("Correo No Válido");
        }
    }
}
