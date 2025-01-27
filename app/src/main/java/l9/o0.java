package l9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.format.Time;
import androidx.exifinterface.media.ExifInterface;
import com.martian.libmars.comm.request.MTHttpGetParams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class o0 {

    /* renamed from: a */
    public static final SimpleDateFormat f28029a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static String A(Date date) {
        return r(date) + new SimpleDateFormat("HH:mm").format(date);
    }

    public static String B(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        float timeInMillis = (calendar.getTimeInMillis() - j10) / 8.64E7f;
        if (timeInMillis <= -1.0f) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j10));
        }
        if (timeInMillis > -1.0f && timeInMillis <= 0.0f) {
            return "今天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
        }
        if (timeInMillis > 0.0f && timeInMillis <= 1.0f) {
            return "昨天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
        }
        if (timeInMillis > 1.0f && timeInMillis <= 2.0f) {
            return "前天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
        }
        long time = (new Date().getTime() - j10) / 86400000;
        if (time > 365) {
            return (time / 365) + "年前";
        }
        if (timeInMillis > 30.0f) {
            return (time / 30) + "月前";
        }
        return time + "天前";
    }

    public static String C(Date date) {
        return B(date.getTime());
    }

    public static long D(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return -1L;
        } catch (ParseException e10) {
            e10.printStackTrace();
            return -1L;
        }
    }

    public static String E(long j10) {
        if (j10 == 0) {
            return "";
        }
        long j11 = j10 / 86400000;
        long j12 = j10 - (86400000 * j11);
        long j13 = j12 / 3600000;
        long j14 = (j12 - (3600000 * j13)) / 60000;
        if (j11 == 0) {
            if (j13 != 0) {
                return j13 + "小时";
            }
            if (j14 == 0) {
                return "少于1分钟";
            }
            return j14 + "分钟";
        }
        if (j11 > 365) {
            return (j11 / 365) + "年";
        }
        if (j11 > 30) {
            return (j11 / 30) + "月";
        }
        return j11 + "天";
    }

    public static String F(long j10) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - j10;
            if (currentTimeMillis < TimeUnit.MINUTES.toMillis(1L)) {
                return "刚刚";
            }
            if (currentTimeMillis < TimeUnit.HOURS.toMillis(1L)) {
                return TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis) + "分钟前";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            float timeInMillis = (calendar.getTimeInMillis() - j10) / 8.64E7f;
            if (timeInMillis <= -1.0f) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j10));
            }
            if (timeInMillis > -1.0f && timeInMillis <= 0.0f) {
                return "今天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
            }
            if (timeInMillis > 0.0f && timeInMillis <= 1.0f) {
                return "昨天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
            }
            if (timeInMillis <= 1.0f || timeInMillis > 2.0f) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j10));
            }
            return "前天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String G(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Error";
        }
    }

    public static String H(String str) {
        switch (new Date(Date.parse(str)).getDay()) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            default:
                return "星期日";
        }
    }

    public static boolean I(String str) {
        Date date = new Date(Date.parse(str));
        Date date2 = new Date(m());
        return date.getYear() == date2.getYear() && date.getDate() == date2.getDate() && date.getMonth() == date2.getMonth();
    }

    public static boolean J(Date date) {
        long time = (new Date().getTime() - date.getTime()) / 86400000;
        return time >= 0 && time <= 7;
    }

    public static Drawable K(Context context, String str) {
        try {
            return Drawable.createFromStream(context.getAssets().open(str), null);
        } catch (Exception e10) {
            e10.printStackTrace();
            System.gc();
            return null;
        }
    }

    public static Date L(String str) {
        try {
            return f28029a.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String M(int i10, Calendar calendar) {
        if (i10 == -2) {
            return "前天";
        }
        if (i10 == -1) {
            return "昨天";
        }
        if (i10 == 0) {
            return "今天";
        }
        if (i10 == 1) {
            return "明天";
        }
        if (i10 == 2) {
            return "后天";
        }
        return (calendar.get(2) + 1) + "月" + calendar.get(5) + "号";
    }

    public static void a(Drawable drawable, String str) throws Exception {
        new File(str.substring(0, str.lastIndexOf("/"))).mkdirs();
        File file = new File(str);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ((BitmapDrawable) drawable).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static String b(long j10) {
        StringBuilder sb2 = new StringBuilder();
        long j11 = j10 / 86400000;
        if (j11 > 0) {
            sb2.append(j11);
            sb2.append("天 ");
        }
        Long.signum(j11);
        long j12 = j10 - (j11 * 86400000);
        long j13 = j12 / 3600000;
        if (j13 >= 10) {
            sb2.append(String.format(Locale.getDefault(), "%02d小时", Long.valueOf(j13)));
        } else if (j13 > 0) {
            sb2.append(String.format(Locale.getDefault(), "%01d小时", Long.valueOf(j13)));
        }
        long j14 = j12 - (j13 * 3600000);
        long j15 = j14 / 60000;
        if (j15 >= 10) {
            sb2.append(String.format(Locale.getDefault(), "%02d分", Long.valueOf(j15)));
        } else if (j15 > 0) {
            sb2.append(String.format(Locale.getDefault(), "%01d分", Long.valueOf(j15)));
        }
        long j16 = (j14 - (j15 * 60000)) / 1000;
        if (j16 >= 10) {
            sb2.append(String.format(Locale.getDefault(), "%02d秒", Long.valueOf(j16)));
        } else if (j16 > 0) {
            sb2.append(String.format(Locale.getDefault(), "%01d秒", Long.valueOf(j16)));
        }
        return sb2.toString();
    }

    public static String c(long j10) {
        StringBuilder sb2 = new StringBuilder();
        long j11 = j10 / 86400000;
        if (j11 > 0) {
            sb2.append(j11);
            sb2.append("天 ");
        }
        Long.signum(j11);
        long j12 = j10 - (j11 * 86400000);
        long j13 = j12 / 3600000;
        sb2.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j13)));
        long j14 = j12 - (j13 * 3600000);
        long j15 = j14 / 60000;
        sb2.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j15)));
        sb2.append(String.format(Locale.getDefault(), "%02d", Long.valueOf((j14 - (j15 * 60000)) / 1000)));
        return sb2.toString();
    }

    public static String d(long j10) {
        StringBuilder sb2 = new StringBuilder();
        long j11 = j10 / 86400000;
        long j12 = j10 - (86400000 * j11);
        long j13 = j12 / 3600000;
        long j14 = j12 - (3600000 * j13);
        long j15 = j14 / 60000;
        sb2.append(String.format(Locale.getDefault(), "%02d\n分\n", Long.valueOf((j11 * 1440) + j15 + (j13 * 60))));
        sb2.append(String.format(Locale.getDefault(), "%02d\n秒\n", Long.valueOf((j14 - (j15 * 60000)) / 1000)));
        return sb2.toString();
    }

    public static String e(long j10) {
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

    public static Bitmap f(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Bitmap g(Context context, String str, BitmapFactory.Options options) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str), null, options);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static long h(long j10) {
        return j10 / 3600000;
    }

    public static long i(long j10) {
        return (j10 - (h(j10) * 3600000)) / 60000;
    }

    public static long j(long j10) {
        return ((j10 - (h(j10) * 3600000)) - (i(j10) * 60000)) / 1000;
    }

    public static String k() {
        Time time = new Time();
        time.setToNow();
        return time.format("%Y-%m-%d");
    }

    public static long l() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public static long m() {
        Time time = new Time();
        time.setToNow();
        return time.toMillis(true);
    }

    public static String n() {
        Time time = new Time();
        time.setToNow();
        return time.format("%Y%m%d%H%M%S");
    }

    public static String o(String str) {
        Time time = new Time();
        time.setToNow();
        return time.format(str);
    }

    public static String p(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String q(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String r(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((System.currentTimeMillis() / 1000) * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        return M((int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000), calendar2);
    }

    public static long s(Date date) {
        return ((new Date().getTime() - date.getTime()) - TimeZone.getDefault().getRawOffset()) / 86400000;
    }

    public static String t(long j10) {
        if (j10 == 0) {
            return "时间未知";
        }
        Time time = new Time();
        time.set(j10);
        return time.format("%Y-%m-%d %H:%M:%S");
    }

    public static String u(long j10, String str) {
        if (j10 == 0) {
            return "时间未知";
        }
        Time time = new Time();
        time.set(j10);
        return time.format(str);
    }

    public static InputStream v(Context context, String str) throws IOException {
        return context.getAssets().open(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String w(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>(r5, r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
        L1a:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            if (r1 == 0) goto L29
            r0.append(r1)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            goto L1a
        L24:
            r0 = move-exception
            r1 = r6
            goto L61
        L27:
            r1 = move-exception
            goto L4a
        L29:
            r6.close()     // Catch: java.io.IOException -> L2d
            goto L31
        L2d:
            r6 = move-exception
            r6.printStackTrace()
        L31:
            if (r5 == 0) goto L5c
            r5.close()     // Catch: java.io.IOException -> L37
            goto L5c
        L37:
            r5 = move-exception
            r5.printStackTrace()
            goto L5c
        L3c:
            r0 = move-exception
            goto L61
        L3e:
            r6 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L4a
        L43:
            r0 = move-exception
            r5 = r1
            goto L61
        L46:
            r5 = move-exception
            r6 = r1
            r1 = r5
            r5 = r6
        L4a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L57
            r6.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r6 = move-exception
            r6.printStackTrace()
        L57:
            if (r5 == 0) goto L5c
            r5.close()     // Catch: java.io.IOException -> L37
        L5c:
            java.lang.String r5 = r0.toString()
            return r5
        L61:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r6 = move-exception
            r6.printStackTrace()
        L6b:
            if (r5 == 0) goto L75
            r5.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r5 = move-exception
            r5.printStackTrace()
        L75:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.o0.w(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String x() {
        return UUID.randomUUID().toString();
    }

    public static String y(String str) {
        if (str == null || str.length() == 0) {
            return "时间未知";
        }
        if (str.length() < 14) {
            return str;
        }
        if (str.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
            return (((((((("" + str.substring(0, 4)) + "-") + str.substring(4, 6)) + "-") + str.substring(6, 8)) + " ") + str.substring(9, 11)) + ":") + str.substring(11, 13);
        }
        if (str.length() != 14) {
            return str;
        }
        return (((((((("" + str.substring(0, 4)) + "-") + str.substring(4, 6)) + "-") + str.substring(6, 8)) + " ") + str.substring(8, 10)) + ":") + str.substring(10, 12);
    }

    public static String z(long j10) {
        if (j10 == 0) {
            return "时间未知";
        }
        Time time = new Time();
        time.set(j10);
        return time.format("%Y%m%d%H%M%S");
    }
}
