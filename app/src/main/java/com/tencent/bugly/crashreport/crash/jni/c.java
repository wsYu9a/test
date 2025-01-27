package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.constant.AdClickConstants;
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
    private static List<File> f22534a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb2.append(str2);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader a10 = ca.a(str, "map_record.txt");
        if (a10 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = a10.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = a10.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb2.append("  ");
                    sb2.append(readLine2);
                    sb2.append("\n");
                }
                return sb2.toString();
            }
            try {
                a10.close();
            } catch (Exception e10) {
                X.b(e10);
            }
            return null;
        } catch (Throwable th2) {
            try {
                X.b(th2);
                try {
                    a10.close();
                } catch (Exception e11) {
                    X.b(e11);
                }
                return null;
            } finally {
                try {
                    a10.close();
                } catch (Exception e12) {
                    X.b(e12);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a10 = ca.a(str, "reg_record.txt");
        if (a10 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = a10.readLine();
            if (readLine == null || !readLine.startsWith(str2)) {
                try {
                    a10.close();
                } catch (Exception e10) {
                    X.b(e10);
                }
                return null;
            }
            int i10 = 18;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                String readLine2 = a10.readLine();
                if (readLine2 == null) {
                    break;
                }
                if (i11 % 4 == 0) {
                    if (i11 > 0) {
                        sb2.append("\n");
                    }
                    sb2.append("  ");
                } else {
                    if (readLine2.length() > 16) {
                        i10 = 28;
                    }
                    sb2.append("                ".substring(0, i10 - i12));
                }
                i12 = readLine2.length();
                sb2.append(readLine2);
                i11++;
            }
            sb2.append("\n");
            return sb2.toString();
        } catch (Throwable th2) {
            try {
                X.b(th2);
                try {
                    a10.close();
                } catch (Exception e11) {
                    X.b(e11);
                }
                return null;
            } finally {
                try {
                    a10.close();
                } catch (Exception e12) {
                    X.b(e12);
                }
            }
        }
    }

    public static Map<String, Integer> d(String str) {
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
        } catch (Exception e10) {
            X.b("error format intStateStr %s", str);
            e10.printStackTrace();
            return null;
        }
    }

    public static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
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
            Map<String, Integer> d10 = d(str3);
            if (d10 == null) {
                X.b("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                d10.get("sino").intValue();
                d10.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    X.b("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = str5 == null ? "unknown" : str5;
                String str7 = map.get("codeMsg");
                if (str7 == null) {
                    str7 = "unknown";
                }
                String str8 = map.get("tombPath");
                String str9 = str8 == null ? "unknown" : str8;
                String str10 = map.get("signalName");
                if (str10 == null) {
                    str10 = "unknown";
                }
                map.get("errnoMsg");
                String str11 = map.get("stack");
                if (str11 == null) {
                    str11 = "unknown";
                }
                String str12 = map.get("jstack");
                if (str12 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str11);
                    sb2.append("java:\n");
                    sb2.append(str12);
                    str11 = sb2.toString();
                }
                Integer num = d10.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str7;
                    str2 = str10;
                } else {
                    str2 = str10 + "(" + str7 + ")";
                    str = "KERNEL";
                }
                String str13 = map.get("nativeLog");
                byte[] a10 = (str13 == null || str13.isEmpty()) ? null : ca.a((File) null, str13, "BuglyNativeLog.txt");
                String str14 = map.get("sendingProcess");
                if (str14 == null) {
                    str14 = "unknown";
                }
                Integer num2 = d10.get("spd");
                if (num2 != null) {
                    str14 = str14 + "(" + num2 + ")";
                }
                String str15 = str14;
                String str16 = map.get("threadName");
                if (str16 == null) {
                    str16 = "unknown";
                }
                Integer num3 = d10.get("et");
                if (num3 != null) {
                    str16 = str16 + "(" + num3 + ")";
                }
                String str17 = str16;
                String str18 = map.get("processName");
                String str19 = str18 != null ? str18 : "unknown";
                Integer num4 = d10.get("ep");
                if (num4 != null) {
                    str19 = str19 + "(" + num4 + ")";
                }
                String str20 = str19;
                String str21 = map.get("key-value");
                if (str21 != null) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str21.split("\n");
                    int length = split.length;
                    int i10 = 0;
                    while (i10 < length) {
                        String[] split2 = split[i10].split("=");
                        String[] strArr = split;
                        if (split2.length == 2) {
                            hashMap2.put(split2[0], split2[1]);
                        }
                        i10++;
                        split = strArr;
                    }
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str17, (d10.get("ets").intValue() * 1000) + (d10.get("etms").intValue() / 1000), str2, str6, a(str11), str, str15, str9, map.get("sysLogPath"), map.get("jniLogPath"), str4, a10, hashMap, false, false);
                if (packageCrashDatas != null) {
                    String str22 = map.get("userId");
                    if (str22 != null) {
                        X.a("[Native record info] userId: %s", str22);
                        packageCrashDatas.f22386m = str22;
                    }
                    String str23 = map.get("sysLog");
                    if (str23 != null) {
                        packageCrashDatas.f22396w = str23;
                    }
                    String str24 = map.get("appVersion");
                    if (str24 != null) {
                        X.a("[Native record info] appVersion: %s", str24);
                        packageCrashDatas.f22379f = str24;
                    }
                    String str25 = map.get("isAppForeground");
                    if (str25 != null) {
                        X.a("[Native record info] isAppForeground: %s", str25);
                        packageCrashDatas.O = str25.equalsIgnoreCase("true");
                    }
                    String str26 = map.get(AdClickConstants.ACTIVITY_LAUNCH_TIME);
                    if (str26 != null) {
                        X.a("[Native record info] launchTime: %s", str26);
                        try {
                            packageCrashDatas.N = Long.parseLong(str26);
                        } catch (NumberFormatException e10) {
                            if (!X.b(e10)) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    packageCrashDatas.f22399z = null;
                    packageCrashDatas.f22384k = true;
                }
                return packageCrashDatas;
            } catch (Throwable th2) {
                X.b("error format", new Object[0]);
                th2.printStackTrace();
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
        } catch (Throwable th2) {
            X.b(th2);
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
    public static java.lang.String a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L29
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L29
        Lb:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L23
            r3 = -1
            if (r2 == r3) goto L30
            if (r2 != 0) goto L25
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L23
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L23
            r1.close()
            return r4
        L23:
            r4 = move-exception
            goto L2b
        L25:
            r1.write(r2)     // Catch: java.lang.Throwable -> L23
            goto Lb
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
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.c.a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a10;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e10) {
                            e = e10;
                            bufferedInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a11 = a(bufferedInputStream);
                            if (a11 != null && a11.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a10 = a(bufferedInputStream);
                                        if (a10 == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = a10;
                                        }
                                    }
                                    hashMap.put(str2, a10);
                                }
                                if (str2 != null) {
                                    X.b("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a12 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                                return a12;
                            }
                            X.b("record read fail! %s", a11);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                            return null;
                        } catch (IOException e15) {
                            e = e15;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
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
        StringBuilder sb2 = new StringBuilder();
        String c10 = c(str, str2);
        if (c10 != null && !c10.isEmpty()) {
            sb2.append("Register infos:\n");
            sb2.append(c10);
        }
        String b10 = b(str, str2);
        if (b10 != null && !b10.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append("System SO infos:\n");
            sb2.append(b10);
        }
        return sb2.toString();
    }

    public static void a(boolean z10, String str) {
        if (str != null) {
            f22534a.add(new File(str, "rqd_record.eup"));
            f22534a.add(new File(str, "reg_record.txt"));
            f22534a.add(new File(str, "map_record.txt"));
            f22534a.add(new File(str, "backup_record.txt"));
            if (z10) {
                b(str);
            }
        }
        List<File> list = f22534a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f22534a) {
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
    public static String a(String str, int i10, String str2, boolean z10) {
        BufferedReader bufferedReader = null;
        if (str != null && i10 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                X.c("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f22534a.add(file);
                X.a("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ca.a(new File(str), i10, z10);
                }
                String sb2 = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str2);
                                sb3.append("[ ]*:");
                                if (Pattern.compile(sb3.toString()).matcher(readLine).find()) {
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                }
                                if (i10 > 0 && sb2.length() > i10) {
                                    if (z10) {
                                        sb2.delete(i10, sb2.length());
                                        break;
                                    }
                                    sb2.delete(0, sb2.length() - i10);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                try {
                                    X.b(th);
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("\n[error:");
                                    sb4.append(th.toString());
                                    sb4.append("]");
                                    sb2.append(sb4.toString());
                                    String sb5 = sb2.toString();
                                    if (bufferedReader == null) {
                                        return sb5;
                                    }
                                    bufferedReader.close();
                                    sb2 = sb5;
                                    return sb2;
                                } catch (Throwable th3) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e10) {
                                            X.b(e10);
                                        }
                                    }
                                    throw th3;
                                }
                            }
                        }
                        String sb6 = sb2.toString();
                        bufferedReader2.close();
                        sb2 = sb6;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    return sb2;
                } catch (Exception e11) {
                    X.b(e11);
                    return sb2;
                }
            }
        }
        return null;
    }
}
