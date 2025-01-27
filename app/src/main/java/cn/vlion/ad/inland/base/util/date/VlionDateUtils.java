package cn.vlion.ad.inland.base.util.date;

import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class VlionDateUtils {
    private static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private static final String FORMAT_YYYY_MM_DD_HH_mm = "yyyyMMddHHmm";

    public static String dateFormatDay() {
        return new SimpleDateFormat(FORMAT_YYYY_MM_DD, Locale.getDefault()).format(new Date());
    }

    public static long dateFormatMinute() {
        try {
            return System.currentTimeMillis() / 60000;
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("Down 策略 : dateFormatMinute  Throwable==");
            a10.append(th2.toString());
            LogVlion.e(a10.toString());
            return 0L;
        }
    }

    public static String getFormatDate(Long l10) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(l10);
    }
}
