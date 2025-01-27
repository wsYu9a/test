package com.martian.libsupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10593a = "yyyy/MM/dd HH:mm:ss";

    public static String a(long timeDiff) {
        StringBuilder sb = new StringBuilder();
        long j2 = timeDiff / 86400000;
        if (j2 > 0) {
            sb.append(j2);
            sb.append("天 ");
        }
        long j3 = timeDiff - (((j2 * 24) * 3600) * 1000);
        long j4 = j3 / 3600000;
        if (j4 > 0) {
            sb.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j4)));
        }
        long j5 = j3 - ((j4 * 3600) * 1000);
        long j6 = j5 / 60000;
        sb.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j6)));
        sb.append(String.format(Locale.getDefault(), "%02d", Long.valueOf((j5 - ((j6 * 60) * 1000)) / 1000)));
        return sb.toString();
    }

    public static long b(Date date) {
        return date.getTime();
    }

    public static String c(Date data) {
        return new SimpleDateFormat(f10593a).format(data);
    }

    public static String d(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    public static String e(long date) {
        long time = new Date().getTime() - date;
        long j2 = time / 86400000;
        long j3 = time - (86400000 * j2);
        long j4 = j3 / 3600000;
        long j5 = (j3 - (3600000 * j4)) / 60000;
        if (j2 == 0) {
            if (j4 != 0) {
                return j4 + "小时前";
            }
            if (j5 == 0) {
                return "刚刚";
            }
            return j5 + "分钟前";
        }
        if (j2 > 365) {
            return (j2 / 365) + "年前";
        }
        if (j2 > 30) {
            return (j2 / 30) + "月前";
        }
        return j2 + "天前";
    }

    public static Date f(long currentTime) throws ParseException {
        return j(d(new Date(currentTime), f10593a), f10593a);
    }

    public static Date g(long currentTime, String formatType) throws ParseException {
        return j(d(new Date(currentTime), formatType), formatType);
    }

    public static String h(long currentTime) throws ParseException {
        return d(g(currentTime, f10593a), f10593a);
    }

    public static String i(long currentTime, String formatType) throws ParseException {
        return d(g(currentTime, formatType), formatType);
    }

    public static Date j(String strTime, String formatType) throws ParseException {
        return new SimpleDateFormat(formatType).parse(strTime);
    }

    public static long k(String strTime, String formatType) throws ParseException {
        Date j2 = j(strTime, formatType);
        if (j2 == null) {
            return 0L;
        }
        return b(j2);
    }
}
