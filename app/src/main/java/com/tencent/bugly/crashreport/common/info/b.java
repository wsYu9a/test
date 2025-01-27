package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import com.czhj.sdk.common.utils.RomUtils;
import com.kuaishou.weapon.p0.an;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import hf.e;
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
    private static final String[] f22332a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    private static final String[] f22333b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    private static final String[] f22334c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d */
    private static String f22335d = null;

    /* renamed from: e */
    private static String f22336e = null;

    public static String a(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "null" : string.toLowerCase();
        } catch (Throwable th2) {
            if (!X.b(th2)) {
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
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return -1;
            }
            th2.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return Build.BRAND;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    public static String e() {
        return "";
    }

    public static String f() {
        try {
            return Build.MODEL;
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return "fail";
            }
            th2.printStackTrace();
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
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return -2L;
            }
            th2.printStackTrace();
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    if (!X.b(e10)) {
                        e10.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e11) {
                    if (!X.b(e11)) {
                        e11.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e12) {
                    if (!X.b(e12)) {
                        e12.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e13) {
                    if (!X.b(e13)) {
                        e13.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j10 = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e14) {
                    if (!X.b(e14)) {
                        e14.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e15) {
                    if (!X.b(e15)) {
                        e15.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = j10 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e16) {
                if (!X.b(e16)) {
                    e16.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e17) {
                if (!X.b(e17)) {
                    e17.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = bufferedReader;
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        if (!X.b(e18)) {
                            e18.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e19) {
                    if (X.b(e19)) {
                        return -2L;
                    }
                    e19.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e20) {
                        if (!X.b(e20)) {
                            e20.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e21) {
                        if (!X.b(e21)) {
                            e21.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long i() {
        FileReader fileReader;
        Throwable th2;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th3) {
                th2 = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th2 = th4;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    if (!X.b(e10)) {
                        e10.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e11) {
                    if (!X.b(e11)) {
                        e11.printStackTrace();
                    }
                }
                return parseLong;
            }
            try {
                bufferedReader.close();
            } catch (IOException e12) {
                if (!X.b(e12)) {
                    e12.printStackTrace();
                }
            }
            try {
                fileReader.close();
                return -1L;
            } catch (IOException e13) {
                if (X.b(e13)) {
                    return -1L;
                }
                e13.printStackTrace();
                return -1L;
            }
        } catch (Throwable th5) {
            th2 = th5;
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e14) {
                        if (!X.b(e14)) {
                            e14.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e15) {
                    if (X.b(e15)) {
                        return -2L;
                    }
                    e15.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th6) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e16) {
                        if (!X.b(e16)) {
                            e16.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e17) {
                        if (!X.b(e17)) {
                            e17.printStackTrace();
                        }
                    }
                }
                throw th6;
            }
        }
    }

    public static long j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return -1L;
        }
    }

    public static long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
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
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return -2L;
            }
            th2.printStackTrace();
            return -2L;
        }
    }

    public static String m() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String n() {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            String[] strArr = f22334c;
            if (i10 >= strArr.length) {
                break;
            }
            if (i10 == 0) {
                if (!new File(strArr[i10]).exists()) {
                    arrayList.add(Integer.valueOf(i10));
                }
            } else if (new File(strArr[i10]).exists()) {
                arrayList.add(Integer.valueOf(i10));
            }
            i10++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static int o() {
        Method method;
        try {
            method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", null);
            method.setAccessible(true);
        } catch (Exception unused) {
        }
        return method.invoke(null, null).getClass().getName().startsWith("$Proxy") ? 256 : 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:75), block:B:82:0x004a */
    public static int p() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e10;
        UnsupportedEncodingException e11;
        FileNotFoundException e12;
        int i10 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("/proc/");
                    sb2.append(Process.myPid());
                    sb2.append("/maps");
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(sb2.toString()), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } catch (FileNotFoundException e13) {
                            e12 = e13;
                            e12.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i10;
                        } catch (UnsupportedEncodingException e14) {
                            e11 = e14;
                            e11.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i10;
                        } catch (IOException e15) {
                            e10 = e15;
                            e10.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return i10;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i10 |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i10 |= 128;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e16) {
                    bufferedReader2 = null;
                    e12 = e16;
                } catch (UnsupportedEncodingException e17) {
                    bufferedReader2 = null;
                    e11 = e17;
                } catch (IOException e18) {
                    bufferedReader2 = null;
                    e10 = e18;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e20) {
                e20.printStackTrace();
            }
            return i10;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader3 = bufferedReader;
        }
    }

    public static boolean q() {
        boolean z10;
        String[] strArr = f22332a;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (new File(strArr[i10]).exists()) {
                z10 = true;
                break;
            }
            i10++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z10;
    }

    public static int b() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e10) {
            int i10 = 0;
            int i11 = 0;
            for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(an.f10772b) && stackTraceElement.getMethodName().equals("main")) {
                    i10 |= 4;
                }
                if (stackTraceElement.getClassName().equals(an.f10772b) && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i10 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i10 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i11 = i11 + 1) == 2) {
                    i10 |= 32;
                }
            }
            return i10;
        }
    }

    public static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            String[] strArr = f22333b;
            if (i10 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i10], 1);
                arrayList.add(Integer.valueOf(i10));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i10++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L49
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L49
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L49
            if (r0 != 0) goto L10
            r3 = 0
            return r3
        L10:
            int r1 = r0.getType()     // Catch: java.lang.Exception -> L49
            r2 = 1
            if (r1 != r2) goto L1b
            java.lang.String r3 = "WIFI"
            goto L83
        L1b:
            int r0 = r0.getType()     // Catch: java.lang.Exception -> L49
            if (r0 != 0) goto L81
            java.lang.String r0 = "phone"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L49
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L49
            if (r3 == 0) goto L81
            int r3 = r3.getNetworkType()     // Catch: java.lang.Exception -> L49
            switch(r3) {
                case 1: goto L75;
                case 2: goto L72;
                case 3: goto L6f;
                case 4: goto L6c;
                case 5: goto L69;
                case 6: goto L66;
                case 7: goto L63;
                case 8: goto L60;
                case 9: goto L5d;
                case 10: goto L5a;
                case 11: goto L57;
                case 12: goto L54;
                case 13: goto L51;
                case 14: goto L4e;
                case 15: goto L4b;
                default: goto L32;
            }     // Catch: java.lang.Exception -> L49
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L49
            r0.<init>()     // Catch: java.lang.Exception -> L49
            java.lang.String r1 = "MOBILE("
            r0.append(r1)     // Catch: java.lang.Exception -> L49
            r0.append(r3)     // Catch: java.lang.Exception -> L49
            java.lang.String r3 = ")"
            r0.append(r3)     // Catch: java.lang.Exception -> L49
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Exception -> L49
            goto L83
        L49:
            r3 = move-exception
            goto L78
        L4b:
            java.lang.String r3 = "HSPA+"
            goto L83
        L4e:
            java.lang.String r3 = "eHRPD"
            goto L83
        L51:
            java.lang.String r3 = "LTE"
            goto L83
        L54:
            java.lang.String r3 = "EVDO_B"
            goto L83
        L57:
            java.lang.String r3 = "iDen"
            goto L83
        L5a:
            java.lang.String r3 = "HSPA"
            goto L83
        L5d:
            java.lang.String r3 = "HSUPA"
            goto L83
        L60:
            java.lang.String r3 = "HSDPA"
            goto L83
        L63:
            java.lang.String r3 = "1xRTT"
            goto L83
        L66:
            java.lang.String r3 = "EVDO_A"
            goto L83
        L69:
            java.lang.String r3 = "EVDO_0"
            goto L83
        L6c:
            java.lang.String r3 = "CDMA"
            goto L83
        L6f:
            java.lang.String r3 = "UMTS"
            goto L83
        L72:
            java.lang.String r3 = "EDGE"
            goto L83
        L75:
            java.lang.String r3 = "GPRS"
            goto L83
        L78:
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
        String a10 = ca.a(context, "ro.miui.ui.version.name");
        if (!ca.b(a10) && !a10.equals("fail")) {
            return "XiaoMi/MIUI/" + a10;
        }
        String a11 = ca.a(context, "ro.build.version.emui");
        if (!ca.b(a11) && !a11.equals("fail")) {
            return "HuaWei/EMOTION/" + a11;
        }
        String a12 = ca.a(context, "ro.lenovo.series");
        if (!ca.b(a12) && !a12.equals("fail")) {
            return "Lenovo/VIBE/" + ca.a(context, RomUtils.f8684w);
        }
        String a13 = ca.a(context, "ro.build.nubia.rom.name");
        if (!ca.b(a13) && !a13.equals("fail")) {
            return "Zte/NUBIA/" + a13 + e.f26694a + ca.a(context, "ro.build.nubia.rom.code");
        }
        String a14 = ca.a(context, "ro.meizu.product.model");
        if (!ca.b(a14) && !a14.equals("fail")) {
            return "Meizu/FLYME/" + ca.a(context, "ro.build.display.id");
        }
        String a15 = ca.a(context, "ro.build.version.opporom");
        if (!ca.b(a15) && !a15.equals("fail")) {
            return "Oppo/COLOROS/" + a15;
        }
        String a16 = ca.a(context, RomUtils.f8683v);
        if (!ca.b(a16) && !a16.equals("fail")) {
            return "vivo/FUNTOUCH/" + a16;
        }
        String a17 = ca.a(context, "ro.aa.romver");
        if (!ca.b(a17) && !a17.equals("fail")) {
            return "htc/" + a17 + "/" + ca.a(context, "ro.build.description");
        }
        String a18 = ca.a(context, "ro.lewa.version");
        if (!ca.b(a18) && !a18.equals("fail")) {
            return "tcl/" + a18 + "/" + ca.a(context, "ro.build.display.id");
        }
        String a19 = ca.a(context, "ro.gn.gnromvernumber");
        if (!ca.b(a19) && !a19.equals("fail")) {
            return "amigo/" + a19 + "/" + ca.a(context, "ro.build.display.id");
        }
        String a20 = ca.a(context, "ro.build.tyd.kbstyle_version");
        if (!ca.b(a20) && !a20.equals("fail")) {
            return "dido/" + a20;
        }
        return ca.a(context, "ro.build.fingerprint") + "/" + ca.a(context, RomUtils.C);
    }

    public static boolean f(Context context) {
        return (((g(context) | b()) | p()) | o()) > 0;
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    public static int g(Context context) {
        int i10;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i10 = 1;
        } catch (Exception unused) {
            i10 = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i10 | 2;
        } catch (Exception unused2) {
            return i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        r1 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            java.lang.String r0 = "fail"
            r1 = 0
            if (r5 == 0) goto L4e
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.tencent.bugly.proguard.ca.a(r4, r5)     // Catch: java.lang.Throwable -> L18
            boolean r2 = com.tencent.bugly.proguard.ca.b(r5)     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L1a
            boolean r2 = r5.equals(r0)     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L20
            goto L1a
        L18:
            r4 = move-exception
            goto L68
        L1a:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.tencent.bugly.proguard.ca.a(r4, r5)     // Catch: java.lang.Throwable -> L18
        L20:
            boolean r4 = com.tencent.bugly.proguard.ca.b(r5)     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4e
            boolean r4 = r5.equals(r0)     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L2d
            goto L4e
        L2d:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r4 = com.tencent.bugly.crashreport.common.info.b.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r1.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = "ABI list: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L18
            r1.append(r5)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L18
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L18
            com.tencent.bugly.proguard.X.a(r4, r1, r3)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L18
            r1 = r4[r2]     // Catch: java.lang.Throwable -> L18
        L4e:
            if (r1 != 0) goto L56
            java.lang.String r4 = "os.arch"
            java.lang.String r1 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L18
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r4.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r5 = ""
            r4.append(r5)     // Catch: java.lang.Throwable -> L18
            r4.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L18
            return r4
        L68:
            boolean r5 = com.tencent.bugly.proguard.X.b(r4)
            if (r5 != 0) goto L71
            r4.printStackTrace()
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.a(android.content.Context, boolean):java.lang.String");
    }

    public static boolean i(Context context) {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f10 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f11 = maxMemory - f10;
        X.a("maxMemory : %f", Float.valueOf(maxMemory));
        X.a("totalMemory : %f", Float.valueOf(f10));
        X.a("freeMemory : %f", Float.valueOf(f11));
        return f11 < 10.0f;
    }

    public static boolean h(Context context) {
        return (e(context) == null && n() == null) ? false : true;
    }
}
