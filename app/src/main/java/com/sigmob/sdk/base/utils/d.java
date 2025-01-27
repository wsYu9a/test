package com.sigmob.sdk.base.utils;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bt;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static String f18404a = null;

    /* renamed from: b */
    public static String f18405b = null;

    /* renamed from: c */
    public static File f18406c = null;

    /* renamed from: d */
    public static String f18407d = "SigHtmlResource";

    /* renamed from: e */
    public static String f18408e = "SigHtmlPrivacy";

    /* renamed from: f */
    public static String f18409f = "SigZipResource";

    /* renamed from: g */
    public static String f18410g = "SigCrashResource";

    public static void a() {
        if (f18404a != null) {
            File file = new File(f18404a);
            if (file.exists()) {
                FileUtil.deleteDirectory(f18404a);
            }
            if (!file.exists() || file.isFile()) {
                file.mkdirs();
            }
        }
    }

    public static File b() {
        try {
            File file = new File(f18405b, f18410g);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, String.format("%d.log", Long.valueOf(System.currentTimeMillis() / 1000)));
        } catch (Throwable th2) {
            SigmobLog.d("createCrash fail", th2);
            return null;
        }
    }

    public static String c() {
        return f18405b;
    }

    public static String d() {
        return f18404a;
    }

    public static File[] e() {
        try {
            File file = new File(f18405b, f18410g);
            if (file.exists()) {
                return FileUtil.orderByDate(file.getAbsolutePath());
            }
            file.mkdirs();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f() {
        String str = f18404a + File.separator + "downloadAPKLog";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static synchronized String g() {
        String sb2;
        synchronized (d.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f18404a);
            String str = File.separator;
            sb3.append(str);
            sb3.append(bt.f6951a);
            sb3.append(str);
            sb3.append("sdkLog.log");
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static String h() {
        String str = f18404a + File.separator + "nativeAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String i() {
        String str = f18404a + File.separator + "splashAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String j() {
        String str = f18404a + File.separator + "videoAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String k() {
        String str = f18404a + File.separator + "webCache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File[] a(File[] fileArr, int i10) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (int i11 = 0; i11 < fileArr.length && arrayList.size() > i10; i11++) {
            File file = fileArr[i11];
            if (file.exists()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static File b(String str) {
        File file = new File(f18405b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File c(String str) {
        File file = new File(f18405b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static synchronized String d(String str) {
        String sb2;
        synchronized (d.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f18404a);
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append("splashAdUnit");
            sb3.append(str2);
            sb3.append(str);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static String e(String str) {
        int lastIndexOf = str.lastIndexOf(p1.b.f29697h);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static File a(String str, String str2) {
        try {
            File file = new File(f18405b, f18407d);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            SigmobLog.d("SigHtmlResource: " + file2.getAbsolutePath());
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return file2;
        } catch (Exception e10) {
            e = e10;
            e.printStackTrace();
            return null;
        } catch (Throwable th2) {
            e = th2;
            e.printStackTrace();
            return null;
        }
    }

    public static File a(Context context) {
        if (f18406c == null) {
            File file = new File(f18405b, "SigDownload");
            f18406c = file;
            if (!file.exists()) {
                f18406c.mkdirs();
            }
        }
        return f18406c;
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(p1.b.f29697h);
        return lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
    }

    public static void a(Context context, String str) {
        File cacheDir = context.getCacheDir();
        File externalCacheDir = context.getExternalCacheDir();
        if (str != null) {
            File file = new File(cacheDir, str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(externalCacheDir, str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            externalCacheDir = file2;
            cacheDir = file;
        }
        f18404a = cacheDir.getAbsolutePath();
        f18405b = externalCacheDir.getAbsolutePath();
    }
}
