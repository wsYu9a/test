package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static List<File> f24904a = new ArrayList();

    protected static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader a2 = ca.a(str, "map_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = a2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            try {
                a2.close();
            } catch (Exception e2) {
                X.b(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                X.b(th);
                try {
                    a2.close();
                } catch (Exception e3) {
                    X.b(e3);
                }
                return null;
            } finally {
                try {
                    a2.close();
                } catch (Exception e4) {
                    X.b(e4);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a2 = ca.a(str, "reg_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine == null || !readLine.startsWith(str2)) {
                try {
                    a2.close();
                } catch (Exception e2) {
                    X.b(e2);
                }
                return null;
            }
            int i2 = 18;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String readLine2 = a2.readLine();
                if (readLine2 == null) {
                    break;
                }
                if (i3 % 4 == 0) {
                    if (i3 > 0) {
                        sb.append("\n");
                    }
                    sb.append("  ");
                } else {
                    if (readLine2.length() > 16) {
                        i2 = 28;
                    }
                    sb.append("                ".substring(0, i2 - i4));
                }
                i4 = readLine2.length();
                sb.append(readLine2);
                i3++;
            }
            sb.append("\n");
            return sb.toString();
        } catch (Throwable th) {
            try {
                X.b(th);
                try {
                    a2.close();
                } catch (Exception e3) {
                    X.b(e3);
                }
                return null;
            } finally {
                try {
                    a2.close();
                } catch (Exception e4) {
                    X.b(e4);
                }
            }
        }
    }

    protected static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    X.b("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e2) {
            X.b("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    protected static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            X.b("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 != null && str3.trim().length() > 0) {
            Map<String, Integer> d2 = d(str3);
            if (d2 == null) {
                X.b("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                d2.get("sino").intValue();
                d2.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    X.b("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = EnvironmentCompat.MEDIA_UNKNOWN;
                String str7 = str5 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str5;
                String str8 = map.get("codeMsg");
                if (str8 == null) {
                    str8 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                String str9 = map.get("tombPath");
                String str10 = str9 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str9;
                String str11 = map.get("signalName");
                if (str11 == null) {
                    str11 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                map.get("errnoMsg");
                String str12 = map.get("stack");
                if (str12 == null) {
                    str12 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                String str13 = map.get("jstack");
                if (str13 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str12);
                    sb.append("java:\n");
                    sb.append(str13);
                    str12 = sb.toString();
                }
                Integer num = d2.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str8;
                    str2 = str11;
                } else {
                    str2 = str11 + "(" + str8 + ")";
                    str = "KERNEL";
                }
                String str14 = map.get("nativeLog");
                byte[] a2 = (str14 == null || str14.isEmpty()) ? null : ca.a((File) null, str14, "BuglyNativeLog.txt");
                String str15 = map.get("sendingProcess");
                if (str15 == null) {
                    str15 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                Integer num2 = d2.get("spd");
                if (num2 != null) {
                    str15 = str15 + "(" + num2 + ")";
                }
                String str16 = str15;
                String str17 = map.get("threadName");
                if (str17 == null) {
                    str17 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                Integer num3 = d2.get("et");
                if (num3 != null) {
                    str17 = str17 + "(" + num3 + ")";
                }
                String str18 = str17;
                String str19 = map.get("processName");
                if (str19 != null) {
                    str6 = str19;
                }
                Integer num4 = d2.get("ep");
                if (num4 != null) {
                    str6 = str6 + "(" + num4 + ")";
                }
                String str20 = str6;
                String str21 = map.get("key-value");
                if (str21 != null) {
                    HashMap hashMap2 = new HashMap();
                    for (String str22 : str21.split("\n")) {
                        String[] split = str22.split("=");
                        if (split.length == 2) {
                            hashMap2.put(split[0], split[1]);
                        }
                    }
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (d2.get("etms").intValue() / 1000) + (d2.get("ets").intValue() * 1000), str2, str7, a(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, a2, hashMap, false, false);
                if (packageCrashDatas != null) {
                    String str23 = map.get("userId");
                    if (str23 != null) {
                        X.a("[Native record info] userId: %s", str23);
                        packageCrashDatas.m = str23;
                    }
                    String str24 = map.get("sysLog");
                    if (str24 != null) {
                        packageCrashDatas.w = str24;
                    }
                    String str25 = map.get("appVersion");
                    if (str25 != null) {
                        X.a("[Native record info] appVersion: %s", str25);
                        packageCrashDatas.f24792f = str25;
                    }
                    String str26 = map.get("isAppForeground");
                    if (str26 != null) {
                        X.a("[Native record info] isAppForeground: %s", str26);
                        packageCrashDatas.O = str26.equalsIgnoreCase("true");
                    }
                    String str27 = map.get("launchTime");
                    if (str27 != null) {
                        X.a("[Native record info] launchTime: %s", str27);
                        try {
                            packageCrashDatas.N = Long.parseLong(str27);
                        } catch (NumberFormatException e2) {
                            if (!X.b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    packageCrashDatas.z = null;
                    packageCrashDatas.k = true;
                }
                return packageCrashDatas;
            } catch (Throwable th) {
                X.b("error format", new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
        X.b("no intStateStr", new Object[0]);
        return null;
    }

    public static void b(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        X.a("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            X.b(th);
        }
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static java.lang.String a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L29
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L29
        Lb:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L27
            r3 = -1
            if (r2 == r3) goto L30
            if (r2 != 0) goto L23
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L27
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L27
            r1.close()
            return r4
        L23:
            r1.write(r2)     // Catch: java.lang.Throwable -> L27
            goto Lb
        L27:
            r4 = move-exception
            goto L2b
        L29:
            r4 = move-exception
            r1 = r0
        L2b:
            com.tencent.bugly.proguard.X.b(r4)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L33
        L30:
            r1.close()
        L33:
            return r0
        L34:
            r4 = move-exception
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            goto L3c
        L3b:
            throw r4
        L3c:
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.c.a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a2;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a3 = a(bufferedInputStream);
                            if (a3 != null && a3.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a2 = a(bufferedInputStream);
                                        if (a2 == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = a2;
                                        }
                                    }
                                    hashMap.put(str2, a2);
                                }
                                if (str2 != null) {
                                    X.b("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a4 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                return a4;
                            }
                            X.b("record read fail! %s", a3);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            return null;
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = canRead;
                }
            }
            return null;
        }
        X.b("get eup record file args error", new Object[0]);
        return null;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String c2 = c(str, str2);
        if (c2 != null && !c2.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(c2);
        }
        String b2 = b(str, str2);
        if (b2 != null && !b2.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(b2);
        }
        return sb.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            f24904a.add(new File(str, "rqd_record.eup"));
            f24904a.add(new File(str, "reg_record.txt"));
            f24904a.add(new File(str, "map_record.txt"));
            f24904a.add(new File(str, "backup_record.txt"));
            if (z) {
                b(str);
            }
        }
        List<File> list = f24904a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f24904a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                X.a("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i2, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                X.c("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f24904a.add(file);
                X.a("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ca.a(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append("[ ]*:");
                                if (Pattern.compile(sb2.toString()).matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    X.b(th);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("\n[error:");
                                    sb3.append(th.toString());
                                    sb3.append("]");
                                    sb.append(sb3.toString());
                                    String sb4 = sb.toString();
                                    if (bufferedReader == null) {
                                        return sb4;
                                    }
                                    bufferedReader.close();
                                    sb = sb4;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            X.b(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb5 = sb.toString();
                        bufferedReader2.close();
                        sb = sb5;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e3) {
                    X.b(e3);
                    return sb;
                }
            }
        }
        return null;
    }
}
