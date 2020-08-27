package id.doddee.jalurpipa.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class CommonHelper {

    public static Long doubleToLong(Double value) {
        return Optional.ofNullable(value).map(Double::longValue).orElse(null);
    }

    public static Integer doubleToInteger(Double value) {
        return Optional.ofNullable(value).map(Double::intValue).orElse(null);
    }

    public static LocalDate dateToLocalDate(Date date) {
        return Optional.ofNullable(date).map(date1 -> date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).orElse(null);
    }

    public static java.sql.Date localDateToSqlDate(LocalDate localDate) {
        return Optional.ofNullable(localDate).map(java.sql.Date::valueOf).orElse(null);
    }

    public static LocalDate stringToLocalDate(String s, String pattern) {
        return DateHelper.stringToDate(s, pattern).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
