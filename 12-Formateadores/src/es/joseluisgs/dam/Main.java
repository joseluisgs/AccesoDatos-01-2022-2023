package es.joseluisgs.dam;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        double numero = 123_456.789;
        LocalDateTime fecha = LocalDateTime.now();

        System.out.println(numero);
        System.out.println(fecha);

        Locale.setDefault(Locale.getDefault());
        System.out.println(Locale.getDefault());

        // Formatear la fecha
        System.out.println(dateParser(fecha, Locale.getDefault()));

        // Formatear el numero
        System.out.println(doubleParser(numero, new Locale("es", "ES")));

        // Formatear el dinero
        System.out.println(moneyParser(numero, new Locale("es", "ES")));

        // Formatear el porcentaje
        System.out.println(doublePercentParser(numero, new Locale("es", "ES")));

        String fechaString = "01/01/2020";
        String horaString = "11:13:14";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime fechaHora = LocalDateTime.parse(fechaString + " " + horaString, formatter);
        System.out.println(fechaHora);

        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(fechaHora.format(formatter));

        String token = ",";
        String cadena = "casa   , pepe   ,,                 , luis, jose      ";
        String[] palabras = cadena.split(token);
        for (String palabra : palabras) {
            if (!palabra.isBlank()) {
                System.out.println(palabra.trim());
            }
        }

        StringTokenizer st = new StringTokenizer(cadena, token);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken().trim());
        }

    }

    public static String dateParser(LocalDateTime date, Locale locale) {
        // private String pattern = "dd/MM/yyyy";
        return date.format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(locale));
    }

    public static String moneyParser(Double money, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(money);
    }

    public static String doubleParser(Double number, Locale locale) {
        return NumberFormat.getNumberInstance(locale).format(number);
    }

    public static String doublePercentParser(Double number, Locale locale) {
        return NumberFormat.getPercentInstance(locale).format(number);
    }
}
