package com.martian.libmars.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.format.Time;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes2.dex */
public class p0 {

    /* renamed from: a */
    private static final SimpleDateFormat f10181a = new SimpleDateFormat(b.d.b.f.f4408b, Locale.CHINA);

    public static String A(Date date) {
        long time = new Date().getTime() - date.getTime();
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

    public static long B(String time) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time);
            if (parse != null) {
                return parse.getTime();
            }
            return -1L;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String C(long diffTimeMS) {
        if (diffTimeMS == 0) {
            return "";
        }
        long j2 = diffTimeMS / 86400000;
        long j3 = diffTimeMS - (86400000 * j2);
        long j4 = j3 / 3600000;
        long j5 = (j3 - (3600000 * j4)) / 60000;
        if (j2 == 0) {
            if (j4 != 0) {
                return j4 + "小时";
            }
            if (j5 == 0) {
                return "少于1分钟";
            }
            return j5 + "分钟";
        }
        if (j2 > 365) {
            return (j2 / 365) + "年";
        }
        if (j2 > 30) {
            return (j2 / 30) + "月";
        }
        return j2 + "天";
    }

    public static String D(Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Error";
        }
    }

    public static String E(String time) {
        switch (new Date(Date.parse(time)).getDay()) {
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

    public static boolean F(String time) {
        Date date = new Date(Date.parse(time));
        Date date2 = new Date(k());
        return date.getYear() == date2.getYear() && date.getDate() == date2.getDate() && date.getMonth() == date2.getMonth();
    }

    public static Drawable G(Context context, String path) {
        try {
            return Drawable.createFromStream(context.getAssets().open(path), null);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.gc();
            return null;
        }
    }

    public static Date H(String latestChapterUpdateTime) {
        try {
            return f10181a.parse(latestChapterUpdateTime);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String I(int xcts, Calendar target) {
        if (xcts == -2) {
            return "前天";
        }
        if (xcts == -1) {
            return "昨天";
        }
        if (xcts == 0) {
            return "今天";
        }
        if (xcts == 1) {
            return "明天";
        }
        if (xcts == 2) {
            return "后天";
        }
        return (target.get(2) + 1) + "月" + target.get(5) + "号";
    }

    public static void a(Drawable paramDrawable, String paramString) throws Exception {
        new File(paramString.substring(0, paramString.lastIndexOf("/"))).mkdirs();
        File file = new File(paramString);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ((BitmapDrawable) paramDrawable).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static String b(long timeDiff) {
        StringBuilder sb = new StringBuilder();
        long j2 = timeDiff / 86400000;
        if (j2 > 0) {
            sb.append(j2);
            sb.append("天 ");
        }
        long j3 = timeDiff - (((j2 * 24) * 3600) * 1000);
        long j4 = j3 / 3600000;
        sb.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j4)));
        long j5 = j3 - ((j4 * 3600) * 1000);
        long j6 = j5 / 60000;
        sb.append(String.format(Locale.getDefault(), "%02d:", Long.valueOf(j6)));
        sb.append(String.format(Locale.getDefault(), "%02d", Long.valueOf((j5 - ((j6 * 60) * 1000)) / 1000)));
        return sb.toString();
    }

    public static String c(long timeDiff) {
        StringBuilder sb = new StringBuilder();
        long j2 = (timeDiff / 86400000) * 24;
        long j3 = timeDiff - ((j2 * 3600) * 1000);
        long j4 = j3 / 3600000;
        long j5 = j3 - ((3600 * j4) * 1000);
        long j6 = j5 / 60000;
        sb.append(String.format(Locale.getDefault(), "%02d\n分\n", Long.valueOf((j2 * 60) + j6 + (j4 * 60))));
        sb.append(String.format(Locale.getDefault(), "%02d\n秒\n", Long.valueOf((j5 - ((j6 * 60) * 1000)) / 1000)));
        return sb.toString();
    }

    public static String d(long timeDiff) {
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

    public static Bitmap e(Context ctx, String path) {
        try {
            return BitmapFactory.decodeStream(ctx.getAssets().open(path));
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap f(Context ctx, String path, BitmapFactory.Options opts) {
        try {
            return BitmapFactory.decodeStream(ctx.getAssets().open(path), null, opts);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long g(long timeDiff) {
        return timeDiff / 3600000;
    }

    public static long h(long timeDiff) {
        return (timeDiff - (g(timeDiff) * 3600000)) / 60000;
    }

    public static long i(long timeDiff) {
        return ((timeDiff - ((g(timeDiff) * 3600) * 1000)) - ((h(timeDiff) * 60) * 1000)) / 1000;
    }

    public static String j() {
        Time time = new Time();
        time.setToNow();
        return time.format("%Y-%m-%d");
    }

    public static long k() {
        Time time = new Time();
        time.setToNow();
        return time.toMillis(true);
    }

    public static String l() {
        Time time = new Time();
        time.setToNow();
        return time.format("%Y%m%d%H%M%S");
    }

    public static String m(String format) {
        Time time = new Time();
        time.setToNow();
        return time.format(format);
    }

    public static String n(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String o(Date date) {
        return new SimpleDateFormat(b.d.b.f.f4408b).format(date);
    }

    public static String p(Date date) {
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
        return I((int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000), calendar2);
    }

    public static long q(Date date) {
        return ((new Date().getTime() - date.getTime()) - TimeZone.getDefault().getRawOffset()) / 86400000;
    }

    public static String r(long time) {
        if (time == 0) {
            return "时间未知";
        }
        Time time2 = new Time();
        time2.set(time);
        return time2.format("%Y-%m-%d %H:%M:%S");
    }

    public static String s(long time, String format) {
        if (time == 0) {
            return "时间未知";
        }
        Time time2 = new Time();
        time2.set(time);
        return time2.format(format);
    }

    public static InputStream t(Context ctx, String filename) throws IOException {
        return ctx.getAssets().open(filename);
    }

    public static String u(Context ctx, String filename) {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                inputStream = ctx.getAssets().open(filename);
                try {
                    if (com.martian.libsupport.l.p()) {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (IOException unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return sb.toString();
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                        bufferedReader = bufferedReader2;
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused3) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return sb.toString();
    }

    public static String v() {
        return UUID.randomUUID().toString();
    }

    public static String w(String TimeAndDate) {
        if (TimeAndDate == null || TimeAndDate.length() <= 0) {
            return "时间未知";
        }
        if (TimeAndDate.length() < 14) {
            return TimeAndDate;
        }
        if (TimeAndDate.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
            return (((((((("" + TimeAndDate.substring(0, 4)) + "-") + TimeAndDate.substring(4, 6)) + "-") + TimeAndDate.substring(6, 8)) + " ") + TimeAndDate.substring(9, 11)) + ":") + TimeAndDate.substring(11, 13);
        }
        if (TimeAndDate.length() != 14) {
            return TimeAndDate;
        }
        return (((((((("" + TimeAndDate.substring(0, 4)) + "-") + TimeAndDate.substring(4, 6)) + "-") + TimeAndDate.substring(6, 8)) + " ") + TimeAndDate.substring(8, 10)) + ":") + TimeAndDate.substring(10, 12);
    }

    public static String x(long time) {
        if (time == 0) {
            return "时间未知";
        }
        Time time2 = new Time();
        time2.set(time);
        return time2.format("%Y%m%d%H%M%S");
    }

    public static String y(Date date) {
        return p(date) + new SimpleDateFormat("HH:mm").format(date);
    }

    public static String z(long date) {
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
}
