import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Data {

    public static String dateToString(Date fecha) {
        if (fecha == null) return null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fecha);
    }

    public static Date stringToDate(String fechaStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaUtil = formato.parse(fechaStr);
            return new Date(fechaUtil.getTime());
        } catch (ParseException e) {
            System.err.println("Error al parsear fecha: " + e.getMessage());
            return null;
        }
    }
}