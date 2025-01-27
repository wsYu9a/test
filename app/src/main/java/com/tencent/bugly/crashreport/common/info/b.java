package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import com.kuaishou.weapon.p0.an;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String[] f24758a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    private static final String[] f24759b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    private static final String[] f24760c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d */
    private static String f24761d;

    /* renamed from: e */
    private static String f24762e;

    public static String a(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "null" : string.toLowerCase();
        } catch (Throwable th) {
            if (!X.b(th)) {
                X.c("Failed to get Android ID.", new Object[0]);
            }
            return "fail";
        }
    }

    public static String b(Context context) {
        return ca.a(context, "ro.board.platform");
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (X.b(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String e() {
        return "";
    }

    public static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f24759b;
            if (i2 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i2], 1);
                arrayList.add(Integer.valueOf(i2));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static String f() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (X.b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static long g() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (X.b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long h() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!X.b(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!X.b(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!X.b(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!X.b(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j2 = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!X.b(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!X.b(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = j2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!X.b(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!X.b(e9)) {
                    e9.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        if (!X.b(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e11) {
                    if (X.b(e11)) {
                        return -2L;
                    }
                    e11.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!X.b(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!X.b(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!X.b(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!X.b(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!X.b(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e5) {
                if (!X.b(e5)) {
                    e5.printStackTrace();
                }
            }
            return parseLong;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!X.b(e6)) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e7) {
                    if (X.b(e7)) {
                        return -2L;
                    }
                    e7.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        if (!X.b(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!X.b(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long l() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (X.b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String m() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (X.b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String n() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f24760c;
            if (i2 >= strArr.length) {
                break;
            }
            if (i2 == 0) {
                if (!new File(strArr[i2]).exists()) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else if (new File(strArr[i2]).exists()) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static int o() {
        Method method;
        try {
            method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
        } catch (Exception unused) {
        }
        return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00bb: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:82:0x00bb */
    public static int p() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        int i2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    StringBuilder sb = new StringBuilder();
                    sb.append("/proc/");
                    sb.append(Process.myPid());
                    sb.append("/maps");
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(sb.toString()), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } catch (FileNotFoundException e5) {
                            e4 = e5;
                            e4.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i2;
                        } catch (UnsupportedEncodingException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i2;
                        } catch (IOException e7) {
                            e2 = e7;
                            e2.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i2;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i2 |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i2 |= 128;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e8) {
                    bufferedReader2 = null;
                    e4 = e8;
                } catch (UnsupportedEncodingException e9) {
                    bufferedReader2 = null;
                    e3 = e9;
                } catch (IOException e10) {
                    bufferedReader2 = null;
                    e2 = e10;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader;
        }
    }

    public static boolean q() {
        boolean z;
        String[] strArr = f24758a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static int b() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i2 = 0;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(an.f9076b) && stackTraceElement.getMethodName().equals("main")) {
                    i2 |= 4;
                }
                if (stackTraceElement.getClassName().equals(an.f9076b) && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i2 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i2 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i3 = i3 + 1) == 2) {
                    i2 |= 32;
                }
            }
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L77
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L77
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L77
            if (r0 != 0) goto L10
            r3 = 0
            return r3
        L10:
            int r1 = r0.getType()     // Catch: java.lang.Exception -> L77
            r2 = 1
            if (r1 != r2) goto L1b
            java.lang.String r3 = "WIFI"
            goto L83
        L1b:
            int r0 = r0.getType()     // Catch: java.lang.Exception -> L77
            if (r0 != 0) goto L81
            java.lang.String r0 = "phone"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L77
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L77
            if (r3 == 0) goto L81
            int r3 = r3.getNetworkType()     // Catch: java.lang.Exception -> L77
            switch(r3) {
                case 1: goto L5f;
                case 2: goto L5c;
                case 3: goto L59;
                case 4: goto L56;
                case 5: goto L53;
                case 6: goto L50;
                case 7: goto L4d;
                case 8: goto L4a;
                case 9: goto L47;
                case 10: goto L44;
                case 11: goto L41;
                case 12: goto L3e;
                case 13: goto L3b;
                case 14: goto L38;
                case 15: goto L35;
                default: goto L32;
            }     // Catch: java.lang.Exception -> L77
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            goto L62
        L35:
            java.lang.String r3 = "HSPA+"
            goto L83
        L38:
            java.lang.String r3 = "eHRPD"
            goto L83
        L3b:
            java.lang.String r3 = "LTE"
            goto L83
        L3e:
            java.lang.String r3 = "EVDO_B"
            goto L83
        L41:
            java.lang.String r3 = "iDen"
            goto L83
        L44:
            java.lang.String r3 = "HSPA"
            goto L83
        L47:
            java.lang.String r3 = "HSUPA"
            goto L83
        L4a:
            java.lang.String r3 = "HSDPA"
            goto L83
        L4d:
            java.lang.String r3 = "1xRTT"
            goto L83
        L50:
            java.lang.String r3 = "EVDO_A"
            goto L83
        L53:
            java.lang.String r3 = "EVDO_0"
            goto L83
        L56:
            java.lang.String r3 = "CDMA"
            goto L83
        L59:
            java.lang.String r3 = "UMTS"
            goto L83
        L5c:
            java.lang.String r3 = "EDGE"
            goto L83
        L5f:
            java.lang.String r3 = "GPRS"
            goto L83
        L62:
            r0.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = "MOBILE("
            r0.append(r1)     // Catch: java.lang.Exception -> L77
            r0.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = ")"
            r0.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Exception -> L77
            goto L83
        L77:
            r3 = move-exception
            boolean r0 = com.tencent.bugly.proguard.X.b(r3)
            if (r0 != 0) goto L81
            r3.printStackTrace()
        L81:
            java.lang.String r3 = "unknown"
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        String a2 = ca.a(context, "ro.miui.ui.version.name");
        if (!ca.b(a2) && !a2.equals("fail")) {
            return "XiaoMi/MIUI/" + a2;
        }
        String a3 = ca.a(context, "ro.build.version.emui");
        if (!ca.b(a3) && !a3.equals("fail")) {
            return "HuaWei/EMOTION/" + a3;
        }
        String a4 = ca.a(context, "ro.lenovo.series");
        if (!ca.b(a4) && !a4.equals("fail")) {
            return "Lenovo/VIBE/" + ca.a(context, "ro.build.version.incremental");
        }
        String a5 = ca.a(context, "ro.build.nubia.rom.name");
        if (!ca.b(a5) && !a5.equals("fail")) {
            return "Zte/NUBIA/" + a5 + "_" + ca.a(context, "ro.build.nubia.rom.code");
        }
        String a6 = ca.a(context, "ro.meizu.product.model");
        if (!ca.b(a6) && !a6.equals("fail")) {
            return "Meizu/FLYME/" + ca.a(context, "ro.build.display.id");
        }
        String a7 = ca.a(context, "ro.build.version.opporom");
        if (!ca.b(a7) && !a7.equals("fail")) {
            return "Oppo/COLOROS/" + a7;
        }
        String a8 = ca.a(context, "ro.vivo.os.build.display.id");
        if (!ca.b(a8) && !a8.equals("fail")) {
            return "vivo/FUNTOUCH/" + a8;
        }
        String a9 = ca.a(context, "ro.aa.romver");
        if (!ca.b(a9) && !a9.equals("fail")) {
            return "htc/" + a9 + "/" + ca.a(context, "ro.build.description");
        }
        String a10 = ca.a(context, "ro.lewa.version");
        if (!ca.b(a10) && !a10.equals("fail")) {
            return "tcl/" + a10 + "/" + ca.a(context, "ro.build.display.id");
        }
        String a11 = ca.a(context, "ro.gn.gnromvernumber");
        if (!ca.b(a11) && !a11.equals("fail")) {
            return "amigo/" + a11 + "/" + ca.a(context, "ro.build.display.id");
        }
        String a12 = ca.a(context, "ro.build.tyd.kbstyle_version");
        if (!ca.b(a12) && !a12.equals("fail")) {
            return "dido/" + a12;
        }
        return ca.a(context, "ro.build.fingerprint") + "/" + ca.a(context, "ro.build.rom.id");
    }

    public static boolean f(Context context) {
        return (((g(context) | b()) | p()) | o()) > 0;
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (X.b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static int g(Context context) {
        int i2;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i2 = 1;
        } catch (Exception unused) {
            i2 = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i2 | 2;
        } catch (Exception unused2) {
            return i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        r0 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            java.lang.String r1 = "fail"
            if (r5 == 0) goto L4b
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.tencent.bugly.proguard.ca.a(r4, r5)     // Catch: java.lang.Throwable -> L65
            boolean r2 = com.tencent.bugly.proguard.ca.b(r5)     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto L17
            boolean r2 = r5.equals(r1)     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L1d
        L17:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.tencent.bugly.proguard.ca.a(r4, r5)     // Catch: java.lang.Throwable -> L65
        L1d:
            boolean r4 = com.tencent.bugly.proguard.ca.b(r5)     // Catch: java.lang.Throwable -> L65
            if (r4 != 0) goto L4b
            boolean r4 = r5.equals(r1)     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L2a
            goto L4b
        L2a:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r4 = com.tencent.bugly.crashreport.common.info.b.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r0.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "ABI list: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L65
            r0.append(r5)     // Catch: java.lang.Throwable -> L65
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L65
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L65
            com.tencent.bugly.proguard.X.a(r4, r0, r3)     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L65
            r0 = r4[r2]     // Catch: java.lang.Throwable -> L65
        L4b:
            if (r0 != 0) goto L53
            java.lang.String r4 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L65
        L53:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = ""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65
            r4.append(r0)     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L65
            return r4
        L65:
            r4 = move-exception
            boolean r5 = com.tencent.bugly.proguard.X.b(r4)
            if (r5 != 0) goto L6f
            r4.printStackTrace()
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.a(android.content.Context, boolean):java.lang.String");
    }

    public static boolean i(Context context) {
        double maxMemory = Runtime.getRuntime().maxMemory();
        Double.isNaN(maxMemory);
        float f2 = (float) ((maxMemory * 1.0d) / 1048576.0d);
        double d2 = Runtime.getRuntime().totalMemory();
        Double.isNaN(d2);
        float f3 = (float) ((d2 * 1.0d) / 1048576.0d);
        float f4 = f2 - f3;
        X.a("maxMemory : %f", Float.valueOf(f2));
        X.a("totalMemory : %f", Float.valueOf(f3));
        X.a("freeMemory : %f", Float.valueOf(f4));
        return f4 < 10.0f;
    }

    public static boolean h(Context context) {
        return (e(context) == null && n() == null) ? false : true;
    }
}
