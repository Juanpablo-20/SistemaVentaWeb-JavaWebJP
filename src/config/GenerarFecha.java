package config;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerarFecha {

    static Calendar calendar = Calendar.getInstance();
    static String fecha;

    public GenerarFecha() {
    }

    public String Fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }

    public static String FechaBD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }

    public static String FechaBD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(date);
        return fecha;
    }

    public static Date primerDiaMes() {
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        return calendar.getTime();
    }
    public static Date ultimoDiaMes() {
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

}