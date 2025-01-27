package com.shu.priory.param;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.an;
import com.kuaishou.weapon.p0.bi;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    private static final String[] f17183a = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};

    /* renamed from: b */
    private static final SimpleDateFormat f17184b = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return "";
        }
    }

    public static int b(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return 100;
        }
    }

    public static String c() {
        return com.shu.priory.utils.d.a().a("init.svc.adbd");
    }

    public static boolean d() {
        return e() || f();
    }

    public static String e(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    public static boolean f() {
        try {
            throw new Exception("gg");
        } catch (Exception e10) {
            for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(an.f10772b)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String g() {
        ArrayMap arrayMap;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            arrayMap = (ArrayMap) declaredField.get(invoke);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (arrayMap.size() < 1) {
            return null;
        }
        for (Object obj : arrayMap.values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                return ((Activity) declaredField3.get(obj)).getClass().getName();
            }
        }
        return null;
    }

    private static int h() {
        return Build.VERSION.SDK_INT;
    }

    private static JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bid", Build.ID);
            jSONObject.put("bhd", Build.HARDWARE);
            jSONObject.put("bfp", Build.FINGERPRINT);
            jSONObject.put("ca1", Build.CPU_ABI);
            jSONObject.put("ca2", Build.CPU_ABI2);
            jSONObject.put("bd", Build.DISPLAY);
        } catch (JSONException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
        }
        return jSONObject;
    }

    private static String j() {
        return TimeZone.getDefault().getDisplayName(true, 0);
    }

    private static JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[1024];
            String str = "";
            String str2 = "";
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            String str3 = "null";
            if (TextUtils.isEmpty(str2)) {
                str2 = "null";
            }
            InputStream inputStream2 = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr2 = new byte[1024];
            while (inputStream2.read(bArr2) != -1) {
                str = str + new String(bArr2);
            }
            inputStream2.close();
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            String readLine = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")).readLine();
            if (!TextUtils.isEmpty(readLine)) {
                str3 = readLine;
            }
            jSONObject.put("maf", str2.trim());
            jSONObject.put("mif", str.trim());
            jSONObject.put("cuf", str3);
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
        }
        return jSONObject;
    }

    private static int l(Context context) {
        return 0;
    }

    private static int m(Context context) {
        return 0;
    }

    private static int n(Context context) {
        return 0;
    }

    private static long o() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    private static long p() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    private static long q() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    private static boolean r() {
        String str = Build.TAGS;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("test-keys");
    }

    private static boolean s() {
        boolean z10 = false;
        for (String str : f17183a) {
            z10 = new File(str).exists();
            if (z10) {
                break;
            }
        }
        return z10;
    }

    private static boolean t() {
        return Debug.isDebuggerConnected();
    }

    private static String a(long j10) {
        return f17184b.format(new Date(j10));
    }

    private static String b(String str) {
        String a10 = com.shu.priory.utils.d.a().a(str);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return a10;
    }

    public static boolean c(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_STATE");
            return context.registerReceiver(null, intentFilter).getExtras().getBoolean("connected");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if ((r3.contains("goldfish") | r3.contains("android")) != false) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.Context r7) {
        /*
            java.lang.String r0 = "gsm.version.baseband"
            java.lang.String r0 = b(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            java.lang.String r3 = "1.0.0.0"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            java.lang.String r3 = "ro.build.flavor"
            java.lang.String r3 = b(r3)
            if (r3 == 0) goto L2e
            java.lang.String r4 = "vbox"
            boolean r4 = r3.contains(r4)
            if (r4 != 0) goto L2e
            java.lang.String r4 = "sdk_gphone"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L30
        L2e:
            int r0 = r0 + 1
        L30:
            java.lang.String r3 = "ro.product.board"
            java.lang.String r3 = b(r3)
            java.lang.String r4 = "android"
            if (r3 == 0) goto L47
            boolean r5 = r3.contains(r4)
            java.lang.String r6 = "goldfish"
            boolean r3 = r3.contains(r6)
            r3 = r3 | r5
            if (r3 == 0) goto L49
        L47:
            int r0 = r0 + 1
        L49:
            java.lang.String r3 = "ro.board.platform"
            java.lang.String r3 = b(r3)
            if (r3 == 0) goto L57
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L59
        L57:
            int r0 = r0 + 1
        L59:
            java.lang.String r3 = "ro.hardware"
            java.lang.String r3 = b(r3)
            if (r3 != 0) goto L64
            int r0 = r0 + 1
            goto L80
        L64:
            java.lang.String r4 = r3.toLowerCase()
            java.lang.String r5 = "ttvm"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L73
        L70:
            int r0 = r0 + 10
            goto L80
        L73:
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r4 = "nox"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L80
            goto L70
        L80:
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            java.lang.String r3 = "android.hardware.camera.flash"
            boolean r7 = r7.hasSystemFeature(r3)
            if (r7 != 0) goto L8e
            int r0 = r0 + 1
        L8e:
            r7 = 3
            if (r0 <= r7) goto L92
            goto L93
        L92:
            r1 = 0
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.param.d.d(android.content.Context):boolean");
    }

    public static boolean e() {
        try {
            ClassLoader.getSystemClassLoader().loadClass(an.f10771a).newInstance();
            try {
                ClassLoader.getSystemClassLoader().loadClass(an.f10772b).newInstance();
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        } catch (ClassNotFoundException unused3) {
            return false;
        } catch (IllegalAccessException | InstantiationException unused4) {
            return true;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!s(context) || d(context) || t() || r(context) || b() || e()) {
                return false;
            }
            return !f();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ams", h(context));
            jSONObject.put("tis", n());
            jSONObject.put("ais", o());
            jSONObject.put("tes", p());
            jSONObject.put("aes", q());
        } catch (JSONException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
        }
        return jSONObject;
    }

    private static long h(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return 0L;
        }
    }

    private static Signature[] i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return null;
        }
    }

    private static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.packageName;
            String str2 = packageInfo.versionName;
            long j10 = packageInfo.firstInstallTime;
            long j11 = packageInfo.lastUpdateTime;
            jSONObject.put(com.umeng.analytics.pro.f.T, str2);
            jSONObject.put("pn", str);
            jSONObject.put("fi", a(j10));
            jSONObject.put("lu", a(j11));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, th2.getMessage());
        }
        return jSONObject;
    }

    private static JSONObject k(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rt", l(context));
            jSONObject.put("ia", m(context));
            jSONObject.put("ra", n(context));
        } catch (JSONException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
        }
        return jSONObject;
    }

    private static String l() {
        try {
            return new BufferedReader(new FileReader("/proc/cpuinfo")).readLine();
        } catch (IOException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r2 == null) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.util.Scanner r2 = new java.util.Scanner     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
        L12:
            boolean r1 = r2.hasNextLine()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            if (r1 == 0) goto L3c
            java.lang.String r1 = r2.nextLine()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            java.lang.String r3 = ": "
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            int r3 = r1.length     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r4 = 1
            if (r3 <= r4) goto L12
            r3 = 0
            r3 = r1[r3]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r1 = r1[r4]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r0.put(r3, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            goto L12
        L37:
            r0 = move-exception
            r1 = r2
            goto L5b
        L3a:
            r1 = move-exception
            goto L46
        L3c:
            r2.close()
            goto L52
        L40:
            r0 = move-exception
            goto L5b
        L42:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L46:
            java.lang.String r3 = "IFLY_AD_SDK"
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L37
            com.shu.priory.utils.h.d(r3, r1)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L52
            goto L3c
        L52:
            java.lang.String r1 = "Hardware"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L5b:
            if (r1 == 0) goto L60
            r1.close()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.param.d.m():java.lang.String");
    }

    private static long n() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    private static String o(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
        return activityInfo == null ? "" : activityInfo.packageName;
    }

    private static String p(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        int parseInt = Integer.parseInt(property2);
        if (TextUtils.isEmpty(property)) {
            return "";
        }
        return property + ":" + parseInt;
    }

    private static String q(Context context) {
        return context.getPackageCodePath();
    }

    private static boolean r(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static boolean s(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0 || !TextUtils.isEmpty(System.getProperty("http.proxyHost"))) {
                return false;
            }
            return TextUtils.isEmpty(System.getProperty("http.proxyPort"));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(Context context, String str) {
        for (Signature signature : i(context)) {
            if ("SHA1".equals(str)) {
                return a(signature, "SHA1");
            }
        }
        return null;
    }

    public static boolean b() {
        if (new File("/system/bin/su").exists() && a("/system/bin/su")) {
            return true;
        }
        return (new File("/system/xbin/su").exists() && a("/system/xbin/su")) || r() || s();
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            h.d(SDKConstants.TAG, e10.getMessage());
            return "";
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(n3.a.f28757w, h());
            jSONObject.put("bi", i());
            jSONObject.put("tz", j());
            jSONObject.put("ip", a());
            jSONObject.put("cf", k());
            jSONObject.put("ci", l());
            jSONObject.put("ch", m());
            jSONObject.put("mi", g(context));
            jSONObject.put("sg", a(context, "SHA1"));
            jSONObject.put("pi", j(context));
            jSONObject.put("ti", k(context));
            jSONObject.put("lp", o(context));
            jSONObject.put(bi.f10821q, p(context));
            jSONObject.put("ro", b());
            jSONObject.put("em", d(context));
            jSONObject.put("fd", e(context));
            jSONObject.put(x2.b.f31791m, q(context));
            jSONObject.put("xp", d());
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, th2.getMessage());
        }
        return jSONObject;
    }

    private static boolean a(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (IOException e10) {
                h.d(SDKConstants.TAG, e10.getMessage());
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th2) {
            if (process != null) {
                process.destroy();
            }
            throw th2;
        }
    }
}
