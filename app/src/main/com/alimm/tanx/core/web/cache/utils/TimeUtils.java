package com.alimm.tanx.core.web.cache.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class TimeUtils {
    private static final String STARD_FROMAT = "yyyy-MM-dd HH:mm:ss";

    public static boolean compare(Date date, Date date2) {
        return (date == null || date2 == null || date.getTime() - date2.getTime() <= 0) ? false : true;
    }

    public static Date formatGMT(String str) {
        if (str.indexOf("GMT") < 0) {
            try {
                return new Date(Long.valueOf(str).longValue() * 1000);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).parse(str.trim());
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat(STARD_FROMAT).format(new Date());
    }

    public static Date getStardTime(String str) {
        try {
            return new SimpleDateFormat(STARD_FROMAT).parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Date getStardTime(Long l10) {
        try {
            return new Date(l10.longValue() * 1000);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
