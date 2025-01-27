package com.martian.mibook.j;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes4.dex */
public class w2 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13687a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f13688b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f13689c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final int f13690d = 4;

    /* renamed from: e, reason: collision with root package name */
    private static final String f13691e = "yyyy/MM/dd HH:mm:ss";

    public static double a(long fileS, int sizeType) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (sizeType == 1) {
            return Double.parseDouble(decimalFormat.format(fileS));
        }
        if (sizeType == 2) {
            double d2 = fileS;
            Double.isNaN(d2);
            return Double.parseDouble(decimalFormat.format(d2 / 1024.0d));
        }
        if (sizeType == 3) {
            double d3 = fileS;
            Double.isNaN(d3);
            return Double.parseDouble(decimalFormat.format(d3 / 1048576.0d));
        }
        if (sizeType != 4) {
            return 0.0d;
        }
        double d4 = fileS;
        Double.isNaN(d4);
        return Double.parseDouble(decimalFormat.format(d4 / 1.073741824E9d));
    }

    public static String b(long fileS) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (fileS == 0) {
            return "0B";
        }
        if (fileS < 1024) {
            return decimalFormat.format(fileS) + "B";
        }
        if (fileS < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = fileS;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        }
        if (fileS < DownloadConstants.GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = fileS;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = fileS;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("GB");
        return sb3.toString();
    }

    public static String c(int numbers) {
        if (numbers <= 100000) {
            return numbers + "";
        }
        return (numbers / 10000) + "万";
    }

    public static String d(Long time) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f13691e, Locale.getDefault());
        calendar.setTimeInMillis(time.longValue());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String e(File file) {
        Calendar calendar = Calendar.getInstance();
        long lastModified = file.lastModified();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f13691e, Locale.getDefault());
        calendar.setTimeInMillis(lastModified);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static double f(String filePath, int sizeType) {
        long j2;
        File file = new File(filePath);
        try {
            j2 = file.isDirectory() ? i(file) : h(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            j2 = 0;
        }
        return a(j2, sizeType);
    }

    public static long g(File file) {
        try {
            return file.isDirectory() ? i(file) : h(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long h(File file) {
        long j2 = 0;
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            j2 = fileInputStream.available();
            fileInputStream.close();
            return j2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    private static long i(File f2) {
        File[] listFiles = f2.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (File file : listFiles) {
                j2 += file.isDirectory() ? i(file) : h(file);
            }
        }
        return j2;
    }

    public static String j(int numbers) {
        if (numbers <= 10000) {
            return numbers + "";
        }
        return (numbers / 10000) + "万";
    }
}
