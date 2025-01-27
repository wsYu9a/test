package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
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
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes4.dex */
public class ca {

    /* renamed from: a */
    private static Map<String, String> f22715a;

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String b(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th3) {
            if (X.b(th3)) {
                return "fail";
            }
            th3.printStackTrace();
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
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    public static Parcel d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static String a(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j10));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] b(byte[] bArr, int i10) {
        if (bArr == null || i10 == -1) {
            return bArr;
        }
        X.a("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), i10 == 2 ? "Gzip" : com.sigmob.sdk.archives.d.f17516f);
        try {
            ha a10 = ga.a(i10);
            if (a10 == null) {
                return null;
            }
            return a10.a(bArr);
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public static void c(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(3:78|79|(17:83|85|86|8|9|10|11|12|(1:(2:14|(1:16)(1:17)))(0)|18|(2:19|(1:21)(1:22))|23|(2:25|26)|30|31|32|33))|11|12|(0)(0)|18|(3:19|(0)(0)|21)|23|(0)|30|31|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x0068, LOOP:0: B:14:0x005e->B:16:0x0064, LOOP_START, TryCatch #5 {all -> 0x0068, blocks: (B:12:0x004d, B:14:0x005e, B:16:0x0064, B:19:0x006a, B:21:0x0070, B:23:0x0074), top: B:11:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: all -> 0x0068, LOOP:1: B:19:0x006a->B:21:0x0070, LOOP_END, TryCatch #5 {all -> 0x0068, blocks: (B:12:0x004d, B:14:0x005e, B:16:0x0064, B:19:0x006a, B:21:0x0070, B:23:0x0074), top: B:11:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074 A[EDGE_INSN: B:22:0x0074->B:23:0x0074 BREAK  A[LOOP:1: B:19:0x006a->B:21:0x0070], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0 A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #2 {all -> 0x00a4, blocks: (B:42:0x009a, B:44:0x00a0), top: B:41:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.File r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
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
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        X.c("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return -1L;
            }
            th2.printStackTrace();
            return -1L;
        }
    }

    public static void c(String str, String str2) {
        if (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().f22315qa == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.m().f22315qa.edit().putString(str, str2).apply();
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static byte[] b(long j10) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(j10);
            return sb2.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
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
            for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                hashMap.put(stringArrayList.get(i10), stringArrayList2.get(i10));
            }
        } else {
            X.b("map parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static boolean b(Context context) {
        try {
            return com.tencent.bugly.crashreport.common.info.a.m().C();
        } catch (SecurityException unused) {
            X.b("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return true;
        } catch (Exception e10) {
            if (X.a(e10)) {
                return true;
            }
            e10.printStackTrace();
            return true;
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
        } catch (Throwable th2) {
            X.b(th2);
            return false;
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        if (bArr == null || i10 == -1) {
            return bArr;
        }
        X.a("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), i10 == 2 ? "Gzip" : com.sigmob.sdk.archives.d.f17516f);
        try {
            ha a10 = ga.a(i10);
            if (a10 == null) {
                return null;
            }
            return a10.b(bArr);
        } catch (Throwable th2) {
            if (th2.getMessage() != null && th2.getMessage().contains("Not in GZIP format")) {
                X.e(th2.getMessage(), new Object[0]);
            } else if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String b(String str, String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().f22315qa == null) ? "" : com.tencent.bugly.crashreport.common.info.a.m().f22315qa.getString(str, str2);
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
                                String a10 = a(messageDigest.digest());
                                try {
                                    fileInputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                                return a10;
                            } catch (IOException e11) {
                                e = e11;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (NoSuchAlgorithmException e12) {
                                e = e12;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        } catch (IOException e13) {
                            e = e13;
                            fileInputStream = null;
                        } catch (NoSuchAlgorithmException e14) {
                            e = e14;
                            fileInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = canRead;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static boolean a(File file, File file2, int i10) {
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
                } catch (Throwable th2) {
                    if (!X.b(th2)) {
                        th2.printStackTrace();
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
                    } catch (Throwable th3) {
                        th = th3;
                        zipOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipOutputStream = null;
                }
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    if (i10 <= 1000) {
                        i10 = 1000;
                    }
                    byte[] bArr = new byte[i10];
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
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    X.a("rqdp{  ZF end}", new Object[0]);
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream2 = fileInputStream;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        X.a("rqdp{  ZF end}", new Object[0]);
                        return false;
                    } catch (Throwable th6) {
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        X.a("rqdp{  ZF end}", new Object[0]);
                        throw th6;
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
                } catch (Throwable th2) {
                    th = th2;
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
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
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
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (f22715a == null) {
            f22715a = new HashMap();
            ArrayList<String> a10 = a(context, new String[]{(new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c", "getprop"});
            if (a10 != null && a10.size() > 0) {
                X.a(ca.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                Iterator<String> it = a10.iterator();
                while (it.hasNext()) {
                    Matcher matcher = compile.matcher(it.next());
                    if (matcher.find()) {
                        f22715a.put(matcher.group(1), matcher.group(2));
                    }
                }
                X.a(ca.class, "Systems properties number: %d.", Integer.valueOf(f22715a.size()));
            }
        }
        return f22715a.containsKey(str) ? f22715a.get(str) : "fail";
    }

    /* JADX WARN: Finally extract failed */
    public static void a(Context context, String str, String str2, int i10) {
        Throwable th2;
        FileOutputStream fileOutputStream;
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
            try {
                if (file.length() >= i10) {
                    fileOutputStream = new FileOutputStream(file, false);
                } else {
                    fileOutputStream = new FileOutputStream(file, true);
                }
                try {
                    fileOutputStream.write(str2.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        if (!X.b(th2)) {
                            th2.printStackTrace();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        X.a("rqdp{  sv sd end}", new Object[0]);
                    } catch (Throwable th4) {
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
                fileOutputStream = null;
            }
        } catch (Throwable th6) {
            if (!X.b(th6)) {
                th6.printStackTrace();
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

    public static String a(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
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
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                bundle.putString("pluginKey" + i10, (String) arrayList.get(i10));
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                bundle.putString("pluginVal" + i11 + "plugInId", ((PlugInBean) arrayList2.get(i11)).f22279a);
                bundle.putString("pluginVal" + i11 + "plugInUUID", ((PlugInBean) arrayList2.get(i11)).f22281c);
                bundle.putString("pluginVal" + i11 + "plugInVersion", ((PlugInBean) arrayList2.get(i11)).f22280b);
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
        for (int i10 = 0; i10 < intValue; i10++) {
            arrayList.add(readBundle.getString("pluginKey" + i10));
        }
        for (int i11 = 0; i11 < intValue; i11++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i11 + "plugInId"), readBundle.getString("pluginVal" + i11 + "plugInVersion"), readBundle.getString("pluginVal" + i11 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                hashMap.put(arrayList.get(i12), PlugInBean.class.cast(arrayList2.get(i12)));
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
        Parcel d10 = d(bArr);
        try {
            return creator.createFromParcel(d10);
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                if (d10 == null) {
                    return null;
                }
                d10.recycle();
                return null;
            } finally {
                if (d10 != null) {
                    d10.recycle();
                }
            }
        }
    }

    public static String a(Context context, int i10, String str) {
        String[] strArr;
        Process process = null;
        if (!AppInfo.a(context, "android.permission.READ_LOGS")) {
            X.e("no read_log permission!", new Object[0]);
            return null;
        }
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime"};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
                sb2.append("\n");
                if (i10 > 0 && sb2.length() > i10) {
                    sb2.delete(0, sb2.length() - i10);
                }
            }
            String sb3 = sb2.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                process.getInputStream().close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return sb3;
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\n[error:");
                sb4.append(th2.toString());
                sb4.append("]");
                sb2.append(sb4.toString());
                String sb5 = sb2.toString();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                return sb5;
            } catch (Throwable th3) {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th3;
            }
        }
    }

    public static Map<String, String> a(int i10, boolean z10) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id2 = Thread.currentThread().getId();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z10 || id2 != entry.getKey().getId()) {
                int i11 = 0;
                sb2.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i11];
                        if (i10 > 0 && sb2.length() >= i10) {
                            sb2.append("\n[Stack over limit size :" + i10 + " , has been cut!]");
                            break;
                        }
                        sb2.append(stackTraceElement.toString());
                        sb2.append("\n");
                        i11++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb2.toString());
                }
            }
        }
        return hashMap;
    }

    public static boolean a(Context context, String str, long j10) {
        X.a("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j10) {
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
        } catch (Throwable th2) {
            X.b(th2);
            return false;
        }
    }

    public static String a(File file, int i10, boolean z10) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                    sb2.append("\n");
                    if (i10 > 0 && sb2.length() > i10) {
                        if (z10) {
                            sb2.delete(i10, sb2.length());
                            break;
                        }
                        sb2.delete(0, sb2.length() - i10);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        X.b(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e10) {
                                X.b(e10);
                            }
                        }
                    }
                }
            }
            String sb3 = sb2.toString();
            try {
                bufferedReader.close();
            } catch (Exception e11) {
                X.b(e11);
            }
            return sb3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th2) {
                X.b(th2);
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
        } catch (NullPointerException e10) {
            X.b(e10);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th2) {
            X.b("[Util] Failed to start a thread to execute task with message: %s", th2.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        W c10 = W.c();
        if (c10 != null) {
            return c10.a(runnable);
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
