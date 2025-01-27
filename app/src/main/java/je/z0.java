package je;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a */
    public static final int f27549a = 1;

    /* renamed from: b */
    public static final int f27550b = 2;

    /* renamed from: c */
    public static final int f27551c = 3;

    /* renamed from: d */
    public static final int f27552d = 4;

    /* renamed from: e */
    public static final String f27553e = "yyyy/MM/dd HH:mm:ss";

    public static double a(long j10, int i10) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? l5.c.f27899e : Double.parseDouble(decimalFormat.format(j10 / 1.073741824E9d)) : Double.parseDouble(decimalFormat.format(j10 / 1048576.0d)) : Double.parseDouble(decimalFormat.format(j10 / 1024.0d)) : Double.parseDouble(decimalFormat.format(j10));
    }

    public static String b(long j10) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j10 == 0) {
            return "0B";
        }
        if (j10 < 1024) {
            return decimalFormat.format(j10) + "B";
        }
        if (j10 < 1048576) {
            return decimalFormat.format(j10 / 1024.0d) + "KB";
        }
        if (j10 < DownloadConstants.GB) {
            return decimalFormat.format(j10 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j10 / 1.073741824E9d) + "GB";
    }

    public static String c(int i10) {
        if (i10 <= 100000) {
            return i10 + "";
        }
        return (i10 / 10000) + "万";
    }

    public static String d(Long l10) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        calendar.setTimeInMillis(l10.longValue());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String e(File file) {
        Calendar calendar = Calendar.getInstance();
        long lastModified = file.lastModified();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        calendar.setTimeInMillis(lastModified);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static double f(String str, int i10) {
        long j10;
        File file = new File(str);
        try {
            j10 = file.isDirectory() ? i(file) : h(file);
        } catch (Exception e10) {
            e10.printStackTrace();
            j10 = 0;
        }
        return a(j10, i10);
    }

    public static long g(File file) {
        try {
            return file.isDirectory() ? i(file) : h(file);
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static long h(File file) {
        long j10 = 0;
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            j10 = fileInputStream.available();
            fileInputStream.close();
            return j10;
        } catch (IOException e10) {
            e10.printStackTrace();
            return j10;
        }
    }

    public static long i(File file) {
        File[] listFiles = file.listFiles();
        long j10 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j10 += file2.isDirectory() ? i(file2) : h(file2);
            }
        }
        return j10;
    }

    public static String j(int i10) {
        if (i10 <= 10000) {
            return i10 + "";
        }
        return (i10 / 10000) + "万";
    }
}
