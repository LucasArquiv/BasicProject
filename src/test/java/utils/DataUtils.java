package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static Date dataDiferencaDias(int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        return calendar.getTime();
    }

    public static String dataFormatada(Date data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
}
