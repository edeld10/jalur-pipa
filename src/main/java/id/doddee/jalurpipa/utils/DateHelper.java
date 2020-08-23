package id.doddee.jalurpipa.utils;

import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateHelper {
    public static final String DATE_PATTERN = "mm/dd/YYYY";

    public static String dateToString(Date date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        LocalDate localDate = LocalDate.fromDateFields(date);
        return localDate.toString(formatter);
    }

    public static Date stringToDate(String s, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        LocalDate localDate = LocalDate.parse(s, formatter);
        return localDate.toDate();
    }
}
