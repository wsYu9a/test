package ba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1466a = "yyyy/MM/dd HH:mm:ss";

    public static String a(long j10) {
        StringBuilder sb2 = new StringBuilder();
        long j11 = j10 / 86400000;
        if (j11 > 0) {
            sb2.append(j11);
            sb2.append("天 ");
        }
        Long.signum(j11);
        long j12 = j10 - (j11 * 86400000);
        long j13 = j12 / 3600000;
        if (j13 > 0) {
            sb2.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j13)));
        }
        long j14 = j12 - (j13 * 3600000);
        long j15 = j14 / 60000;
        sb2.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j15)));
        sb2.append(String.format(Locale.getDefault(), "%02d", Long.valueOf((j14 - (j15 * 60000)) / 1000)));
        return sb2.toString();
    }

    public static long b(Date date) {
        return date.getTime();
    }

    public static String c(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public static String d(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String e(long j10) {
        long time = new Date().getTime() - j10;
        long j11 = time / 86400000;
        long j12 = time - (86400000 * j11);
        long j13 = j12 / 3600000;
        long j14 = (j12 - (3600000 * j13)) / 60000;
        if (j11 == 0) {
            if (j13 != 0) {
                return j13 + "小时前";
            }
            if (j14 == 0) {
                return "刚刚";
            }
            return j14 + "分钟前";
        }
        if (j11 > 365) {
            return (j11 / 365) + "年前";
        }
        if (j11 > 30) {
            return (j11 / 30) + "月前";
        }
        return j11 + "天前";
    }

    public static Date f(long j10) throws ParseException {
        return j(d(new Date(j10), "yyyy/MM/dd HH:mm:ss"), "yyyy/MM/dd HH:mm:ss");
    }

    public static Date g(long j10, String str) throws ParseException {
        return j(d(new Date(j10), str), str);
    }

    public static String h(long j10) throws ParseException {
        return d(g(j10, "yyyy/MM/dd HH:mm:ss"), "yyyy/MM/dd HH:mm:ss");
    }

    public static String i(long j10, String str) throws ParseException {
        return d(g(j10, str), str);
    }

    public static Date j(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str);
    }

    public static long k(String str, String str2) throws ParseException {
        Date j10 = j(str, str2);
        if (j10 == null) {
            return 0L;
        }
        return b(j10);
    }
}
