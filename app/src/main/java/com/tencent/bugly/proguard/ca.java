package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.HttpHost;

/* loaded from: classes4.dex */
public class ca {

    /* renamed from: a */
    private static Map<String, String> f25048a;

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            if (X.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static Parcel d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static String a(long j2) {
        try {
            return new SimpleDateFormat(b.d.b.f.f4408b, Locale.US).format(new Date(j2));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(b.d.b.f.f4408b, Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] b(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        X.a("[Util] Zip %d bytes data with type %s", objArr);
        try {
            ha a2 = ga.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.a(bArr);
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static void c(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:5|(3:77|78|(17:82|83|84|8|9|10|11|12|(1:(2:14|(1:16)(1:17)))(0)|18|(2:19|(1:21)(1:22))|23|(2:33|34)|25|26|27|28))|7|8|9|10|11|12|(0)(0)|18|(3:19|(0)(0)|21)|23|(0)|25|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[Catch: all -> 0x0094, LOOP:0: B:14:0x005b->B:16:0x0061, LOOP_START, TryCatch #2 {all -> 0x0094, blocks: (B:12:0x004a, B:14:0x005b, B:16:0x0061, B:19:0x0065, B:21:0x006b, B:23:0x006f), top: B:11:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x0094, LOOP:1: B:19:0x0065->B:21:0x006b, LOOP_END, TryCatch #2 {all -> 0x0094, blocks: (B:12:0x004a, B:14:0x005b, B:16:0x0061, B:19:0x0065, B:21:0x006b, B:23:0x006f), top: B:11:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[EDGE_INSN: B:22:0x006f->B:23:0x006f BREAK  A[LOOP:1: B:19:0x0065->B:21:0x006b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e A[Catch: all -> 0x00bb, TRY_LEAVE, TryCatch #7 {all -> 0x00bb, blocks: (B:41:0x0098, B:43:0x009e), top: B:40:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.File r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 == 0) goto Ld6
            int r1 = r7.length()
            if (r1 != 0) goto Lb
            goto Ld6
        Lb:
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "rqdp{  ZF start}"
            com.tencent.bugly.proguard.X.a(r3, r2)
            java.lang.String r2 = "rqdp{  ZF end}"
            if (r6 == 0) goto L31
            boolean r3 = r6.exists()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L31
            boolean r3 = r6.canRead()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L31
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L96
            goto L33
        L2d:
            r6 = move-exception
            r8 = r0
            r4 = r8
            goto L98
        L31:
            r6 = r8
            r8 = r0
        L33:
            java.lang.String r3 = "UTF-8"
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L96
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L96
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L96
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L96
            r7.<init>()     // Catch: java.lang.Throwable -> L96
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L96
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L96
            r5 = 8
            r4.setMethod(r5)     // Catch: java.lang.Throwable -> L94
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L94
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L94
            r4.putNextEntry(r5)     // Catch: java.lang.Throwable -> L94
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L94
            if (r8 == 0) goto L65
        L5b:
            int r5 = r8.read(r6)     // Catch: java.lang.Throwable -> L94
            if (r5 <= 0) goto L65
            r4.write(r6, r1, r5)     // Catch: java.lang.Throwable -> L94
            goto L5b
        L65:
            int r5 = r3.read(r6)     // Catch: java.lang.Throwable -> L94
            if (r5 <= 0) goto L6f
            r4.write(r6, r1, r5)     // Catch: java.lang.Throwable -> L94
            goto L65
        L6f:
            r4.closeEntry()     // Catch: java.lang.Throwable -> L94
            r4.flush()     // Catch: java.lang.Throwable -> L94
            r4.finish()     // Catch: java.lang.Throwable -> L94
            byte[] r6 = r7.toByteArray()     // Catch: java.lang.Throwable -> L94
            if (r8 == 0) goto L86
            r8.close()     // Catch: java.io.IOException -> L82
            goto L86
        L82:
            r7 = move-exception
            r7.printStackTrace()
        L86:
            r4.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r7 = move-exception
            r7.printStackTrace()
        L8e:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.X.a(r2, r7)
            return r6
        L94:
            r6 = move-exception
            goto L98
        L96:
            r6 = move-exception
            r4 = r0
        L98:
            boolean r7 = com.tencent.bugly.proguard.X.b(r6)     // Catch: java.lang.Throwable -> Lbb
            if (r7 != 0) goto La1
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
        La1:
            if (r8 == 0) goto Lab
            r8.close()     // Catch: java.io.IOException -> La7
            goto Lab
        La7:
            r6 = move-exception
            r6.printStackTrace()
        Lab:
            if (r4 == 0) goto Lb5
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb5
        Lb1:
            r6 = move-exception
            r6.printStackTrace()
        Lb5:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.X.a(r2, r6)
            return r0
        Lbb:
            r6 = move-exception
            if (r8 == 0) goto Lc6
            r8.close()     // Catch: java.io.IOException -> Lc2
            goto Lc6
        Lc2:
            r7 = move-exception
            r7.printStackTrace()
        Lc6:
            if (r4 == 0) goto Ld0
            r4.close()     // Catch: java.io.IOException -> Lcc
            goto Ld0
        Lcc:
            r7 = move-exception
            r7.printStackTrace()
        Ld0:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.X.a(r2, r7)
            throw r6
        Ld6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ca.a(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    public static boolean c(String str) {
        if (b(str)) {
            return false;
        }
        if (str.length() > 255) {
            X.c("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return true;
        }
        X.c("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th) {
            if (X.b(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static void c(String str, String str2) {
        if (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().qa == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.m().qa.edit().putString(str, str2).apply();
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static byte[] b(long j2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j2);
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            hashMap = new HashMap(stringArrayList.size());
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                hashMap.put(stringArrayList.get(i2), stringArrayList2.get(i2));
            }
        } else {
            X.b("map parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static boolean b(Context context) {
        try {
        } catch (SecurityException unused) {
            X.b("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
        } catch (Exception e2) {
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return com.tencent.bugly.crashreport.common.info.a.m().C();
        }
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            return (runningTasks == null || runningTasks.isEmpty() || !runningTasks.get(0).topActivity.getPackageName().equals(packageName)) ? false : true;
        }
        return true;
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        X.a("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            ha a2 = ga.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                X.e(th.getMessage(), new Object[0]);
            } else if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        X.a("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            X.a("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            X.b(th);
            return false;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    public static String a(File file, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            ?? canRead = file.canRead();
            try {
                try {
                    if (canRead != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                MessageDigest messageDigest = MessageDigest.getInstance(str);
                                byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    messageDigest.update(bArr, 0, read);
                                }
                                String a2 = a(messageDigest.digest());
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return a2;
                            } catch (IOException e3) {
                                e = e3;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (NoSuchAlgorithmException e4) {
                                e = e4;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            fileInputStream = null;
                        } catch (NoSuchAlgorithmException e6) {
                            e = e6;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = canRead;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
        return null;
    }

    public static String b(String str, String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().qa == null) ? "" : com.tencent.bugly.crashreport.common.info.a.m().qa.getString(str, str2);
    }

    public static boolean a(File file, File file2, int i2) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        X.a("rqdp{  ZF start}", new Object[0]);
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th) {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                }
                if (!file2.exists() || !file2.canRead()) {
                    return false;
                }
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    } catch (Throwable th2) {
                        th = th2;
                        zipOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipOutputStream = null;
                }
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    if (i2 <= 1000) {
                        i2 = 1000;
                    }
                    byte[] bArr = new byte[i2];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    X.a("rqdp{  ZF end}", new Object[0]);
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream2 = fileInputStream;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        X.a("rqdp{  ZF end}", new Object[0]);
                        return false;
                    } catch (Throwable th5) {
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        X.a("rqdp{  ZF end}", new Object[0]);
                        throw th5;
                    }
                }
            }
            X.e("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        X.e("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    public static ArrayList<String> a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.e(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (f25048a == null) {
            f25048a = new HashMap();
            ArrayList<String> a2 = a(context, new String[]{(new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c", "getprop"});
            if (a2 != null && a2.size() > 0) {
                X.a(ca.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                Iterator<String> it = a2.iterator();
                while (it.hasNext()) {
                    Matcher matcher = compile.matcher(it.next());
                    if (matcher.find()) {
                        f25048a.put(matcher.group(1), matcher.group(2));
                    }
                }
                X.a(ca.class, "Systems properties number: %d.", Integer.valueOf(f25048a.size()));
            }
        }
        return f25048a.containsKey(str) ? f25048a.get(str) : "fail";
    }

    /* JADX WARN: Finally extract failed */
    public static void a(Context context, String str, String str2, int i2) {
        X.a("rqdp{  sv sd start} %s", str);
        if (str2 == null || str2.trim().length() <= 0) {
            return;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = null;
            try {
                if (file.length() >= i2) {
                    fileOutputStream = new FileOutputStream(file, false);
                } else {
                    fileOutputStream = new FileOutputStream(file, true);
                }
                fileOutputStream.write(str2.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (!X.b(th3)) {
                th3.printStackTrace();
            }
        }
        X.a("rqdp{  sv sd end}", new Object[0]);
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bundle.putString("pluginKey" + i2, (String) arrayList.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                bundle.putString("pluginVal" + i3 + "plugInId", ((PlugInBean) arrayList2.get(i3)).f24745a);
                bundle.putString("pluginVal" + i3 + "plugInUUID", ((PlugInBean) arrayList2.get(i3)).f24747c);
                bundle.putString("pluginVal" + i3 + "plugInVersion", ((PlugInBean) arrayList2.get(i3)).f24746b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i2 = 0; i2 < intValue; i2++) {
            arrayList.add(readBundle.getString("pluginKey" + i2));
        }
        for (int i3 = 0; i3 < intValue; i3++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i3 + "plugInId"), readBundle.getString("pluginVal" + i3 + "plugInVersion"), readBundle.getString("pluginVal" + i3 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                hashMap.put(arrayList.get(i4), PlugInBean.class.cast(arrayList2.get(i4)));
            }
        } else {
            X.b("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel d2 = d(bArr);
        try {
            return creator.createFromParcel(d2);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (d2 != null) {
                    d2.recycle();
                }
                return null;
            } finally {
                if (d2 != null) {
                    d2.recycle();
                }
            }
        }
    }

    public static String a(Context context, int i2, String str) {
        Process process = null;
        if (!AppInfo.a(context, "android.permission.READ_LOGS")) {
            X.e("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i2 > 0 && sb.length() > i2) {
                    sb.delete(0, sb.length() - i2);
                }
            }
            String sb2 = sb.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                process.getInputStream().close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return sb2;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n[error:");
                sb3.append(th.toString());
                sb3.append("]");
                sb.append(sb3.toString());
                return sb.toString();
            } finally {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, String> a(int i2, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i3 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i3];
                        if (i2 > 0 && sb.length() >= i2) {
                            sb.append("\n[Stack over limit size :" + i2 + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i3++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return hashMap;
    }

    public static boolean a(Context context, String str, long j2) {
        X.a("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j2) {
                    return false;
                }
                X.a("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                X.a("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            X.a("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            X.b(th);
            return false;
        }
    }

    public static String a(File file, int i2, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    if (i2 > 0 && sb.length() > i2) {
                        if (z) {
                            sb.delete(i2, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        X.b(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                X.b(e2);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                X.b(e3);
            }
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                X.b(th);
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e2) {
            X.b(e2);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            X.b("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        W c2 = W.c();
        if (c2 != null) {
            return c2.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
