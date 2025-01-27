package ej;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/* loaded from: classes4.dex */
public final class a {
    public static Date a(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static GregorianCalendar b(ZonedDateTime zonedDateTime) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(m(zonedDateTime.getZone()));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setFirstDayOfWeek(2);
        gregorianCalendar.setMinimalDaysInFirstWeek(4);
        try {
            gregorianCalendar.setTimeInMillis(zonedDateTime.toInstant().toEpochMilli());
            return gregorianCalendar;
        } catch (ArithmeticException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static Instant c(Timestamp timestamp) {
        return Instant.ofEpochSecond(timestamp.getTime() / 1000, timestamp.getNanos());
    }

    public static Instant d(Calendar calendar) {
        return Instant.ofEpochMilli(calendar.getTimeInMillis());
    }

    public static Instant e(Date date) {
        return Instant.ofEpochMilli(date.getTime());
    }

    public static LocalDate f(java.sql.Date date) {
        return LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }

    public static LocalDateTime g(Timestamp timestamp) {
        return LocalDateTime.of(timestamp.getYear() + 1900, timestamp.getMonth() + 1, timestamp.getDate(), timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds(), timestamp.getNanos());
    }

    public static LocalTime h(Time time) {
        return LocalTime.of(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public static java.sql.Date i(LocalDate localDate) {
        return new java.sql.Date(localDate.getYear() - 1900, localDate.getMonthValue() - 1, localDate.getDayOfMonth());
    }

    public static Time j(LocalTime localTime) {
        return new Time(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    public static Timestamp k(Instant instant) {
        try {
            Timestamp timestamp = new Timestamp(instant.getEpochSecond() * 1000);
            timestamp.setNanos(instant.getNano());
            return timestamp;
        } catch (ArithmeticException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static Timestamp l(LocalDateTime localDateTime) {
        return new Timestamp(localDateTime.getYear() - 1900, localDateTime.getMonthValue() - 1, localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano());
    }

    public static TimeZone m(ZoneId zoneId) {
        String id2 = zoneId.getId();
        if (id2.startsWith("+") || id2.startsWith("-")) {
            id2 = "GMT" + id2;
        } else if (id2.equals("Z")) {
            id2 = "UTC";
        }
        return TimeZone.getTimeZone(id2);
    }

    public static ZoneId n(TimeZone timeZone) {
        return ZoneId.of(timeZone.getID(), ZoneId.SHORT_IDS);
    }

    public static ZonedDateTime o(Calendar calendar) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(calendar.getTimeInMillis()), n(calendar.getTimeZone()));
    }
}
