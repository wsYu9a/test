package e2;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.analytics.pro.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import m5.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b */
    public static b f25588b = new b();

    /* renamed from: a */
    public f f25589a;

    public static String A() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String B(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String C() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SystemClock.elapsedRealtime());
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String D(Context context) {
        long j10;
        try {
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            long j11 = 0;
            for (int i10 = 0; i10 < 5; i10++) {
                try {
                    j10 = new File(strArr[i10]).lastModified();
                } catch (Throwable unused) {
                    j10 = -1;
                }
                j11 = Math.max(j10, j11);
            }
            return "1:" + j11;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String E() {
        try {
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb2.append(com.sigmob.sdk.archives.tar.e.S + ":");
            for (int i10 = 0; i10 < 7; i10++) {
                sb2.append(new File(strArr[i10]).exists() ? "1" : "0");
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String F(android.content.Context r3) {
        /*
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L3f
            r1 = 0
            android.content.Intent r3 = r3.registerReceiver(r1, r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = "level"
            r1 = -1
            int r0 = r3.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = "status"
            int r3 = r3.getIntExtra(r2, r1)     // Catch: java.lang.Throwable -> L3f
            r1 = 2
            if (r3 == r1) goto L22
            r1 = 5
            if (r3 != r1) goto L20
            goto L22
        L20:
            r3 = 0
            goto L23
        L22:
            r3 = 1
        L23:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r1.<init>()     // Catch: java.lang.Throwable -> L3f
            if (r3 == 0) goto L2d
            java.lang.String r3 = "1"
            goto L2f
        L2d:
            java.lang.String r3 = "0"
        L2f:
            r1.append(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = ":"
            r1.append(r3)     // Catch: java.lang.Throwable -> L3f
            r1.append(r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L3f
            return r3
        L3f:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.b.F(android.content.Context):java.lang.String");
    }

    public static String G() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.sigmob.sdk.archives.tar.e.S);
        sb2.append(":");
        for (int i10 = 0; i10 <= 0; i10++) {
            try {
                Class.forName(strArr[0]);
                sb2.append("1");
            } catch (Throwable unused) {
                sb2.append("0");
            }
        }
        return sb2.toString();
    }

    public static String H(Context context) {
        if (d(context, g.f11101b)) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String I() {
        LineNumberReader lineNumberReader;
        StringBuilder sb2 = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb2.append(com.sigmob.sdk.archives.tar.e.S + ":");
        for (String str : linkedHashMap.keySet()) {
            char c10 = '0';
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c10 = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        sb2.append('0');
                        if (lineNumberReader == null) {
                        }
                        lineNumberReader.close();
                    }
                }
                sb2.append(c10);
            } catch (Throwable unused2) {
                lineNumberReader = null;
            }
            try {
                lineNumberReader.close();
            } catch (Throwable unused3) {
            }
        }
        return sb2.toString();
    }

    public static String J() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.sigmob.sdk.archives.tar.e.S + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c10 = '0';
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c10 = '1';
                }
            } catch (Throwable unused) {
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public static String K() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.sigmob.sdk.archives.tar.e.S + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            String str2 = (String) linkedHashMap.get(str);
            String e10 = t3.a.e(str, "");
            sb2.append((e10 == null || !e10.contains(str2)) ? '0' : '1');
        }
        return sb2.toString();
    }

    public static String L() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            if (fileReader == null) {
                return "";
            }
            try {
                fileReader.close();
                return "";
            } catch (Throwable unused5) {
                return "";
            }
        }
        if (t3.a.c(readLine)) {
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            fileReader.close();
            return "";
        }
        String trim = readLine.trim();
        try {
            bufferedReader.close();
        } catch (Throwable unused7) {
        }
        try {
            fileReader.close();
        } catch (Throwable unused8) {
        }
        return trim;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003d, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004f, code lost:
    
        if (r0 == null) goto L135;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String M() {
        /*
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L46
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L46
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L43
            r4 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L43
        L11:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L3d
            boolean r4 = t3.a.c(r2)     // Catch: java.lang.Throwable -> L3b
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L11
            int r4 = r2.length     // Catch: java.lang.Throwable -> L3b
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r2[r4]     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L3b
            if (r4 == 0) goto L11
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L3b
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Throwable -> L3b
            goto L3d
        L3b:
            goto L41
        L3d:
            r3.close()     // Catch: java.lang.Throwable -> L51
            goto L51
        L41:
            r2 = r3
            goto L48
        L43:
            r0 = r2
            goto L41
        L46:
            r0 = r2
        L48:
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L4e
            goto L4f
        L4e:
        L4f:
            if (r0 == 0) goto L54
        L51:
            r0.close()     // Catch: java.lang.Throwable -> L54
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.b.M():java.lang.String");
    }

    public static b a(f fVar) {
        b bVar = f25588b;
        bVar.f25589a = fVar;
        return bVar;
    }

    public static boolean d(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) != 0;
    }

    public static String e() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    public static String g() {
        long j10;
        try {
            StatFs statFs = new StatFs("/sdcard");
            j10 = statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if (r2 == null) goto L158;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i() {
        /*
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L54
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L54
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L54
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L54
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L51
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L51
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L4f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4f
            r1 = 1
            r5 = 1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L48
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L41
            if (r6 == 0) goto L48
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch: java.lang.Throwable -> L41
            if (r7 < 0) goto L43
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L41
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L41
            goto L48
        L41:
            goto L46
        L43:
            int r5 = r5 + 1
            goto L1b
        L46:
            r1 = r4
            goto L57
        L48:
            r4.close()     // Catch: java.lang.Throwable -> L4b
        L4b:
            r3.close()     // Catch: java.lang.Throwable -> L67
            goto L67
        L4f:
            goto L57
        L51:
            r3 = r1
            goto L57
        L54:
            r2 = r1
            r3 = r2
        L57:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Throwable -> L5d
            goto L5e
        L5d:
        L5e:
            if (r3 == 0) goto L65
            r3.close()     // Catch: java.lang.Throwable -> L64
            goto L65
        L64:
        L65:
            if (r2 == 0) goto L6c
        L67:
            r2.close()     // Catch: java.lang.Throwable -> L6b
            goto L6c
        L6b:
        L6c:
            if (r0 != 0) goto L70
            java.lang.String r0 = ""
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.b.i():java.lang.String");
    }

    public static String k() {
        String L = L();
        return !t3.a.c(L) ? L : M();
    }

    public static String m() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] split;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                split = bufferedReader.readLine().split(":\\s+", 2);
            } catch (Throwable unused2) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Throwable unused4) {
                    return "";
                }
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        if (split == null || split.length <= 1) {
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            bufferedReader.close();
            return "";
        }
        String str = split[1];
        try {
            fileReader.close();
        } catch (Throwable unused7) {
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        return str;
    }

    public static String n(Context context) {
        int i10 = 0;
        try {
            i10 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i10 == 1 ? "1" : "0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
    
        if (r0 == null) goto L95;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String o() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L31
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L31
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2e
            r5 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L28
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L26
            r5 = 1
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L26
            int r1 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L26
            long r1 = (long) r1
            goto L28
        L26:
            goto L2c
        L28:
            r4.close()     // Catch: java.lang.Throwable -> L3c
            goto L3c
        L2c:
            r3 = r4
            goto L33
        L2e:
            r0 = r3
            goto L2c
        L31:
            r0 = r3
        L33:
            if (r3 == 0) goto L3a
            r3.close()     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
        L3a:
            if (r0 == 0) goto L3f
        L3c:
            r0.close()     // Catch: java.lang.Throwable -> L3f
        L3f:
            java.lang.String r0 = java.lang.String.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.b.o():java.lang.String");
    }

    public static String p(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i10 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i10));
            jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static String q() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String r(android.content.Context r3) {
        /*
            if (r3 == 0) goto L4d
            java.lang.String r0 = "sensor"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L4d
            android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4d
            r0 = -1
            java.util.List r3 = r3.getSensorList(r0)     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4d
            int r0 = r3.size()     // Catch: java.lang.Throwable -> L4d
            if (r0 <= 0) goto L4d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4d
        L22:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L44
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L4d
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            int r2 = r1.getVersion()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getVendor()     // Catch: java.lang.Throwable -> L4d
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            goto L22
        L44:
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = t3.a.i(r3)     // Catch: java.lang.Throwable -> L4d
            goto L4e
        L4d:
            r3 = 0
        L4e:
            if (r3 != 0) goto L52
            java.lang.String r3 = ""
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.b.r(android.content.Context):java.lang.String");
    }

    public static String s() {
        long j10;
        try {
            StatFs statFs = new StatFs("/sdcard");
            j10 = statFs.getBlockSize() * statFs.getBlockCount();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    public static String t(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService(bt.f23586ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public static String u() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String v(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + h.f28447r + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String w() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String x(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.widthPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String y() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String z(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.heightPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String N() {
        String a10 = d.a("ip");
        if (a10 != null) {
            return a10;
        }
        if (this.f25589a.isBackgroundRunning()) {
            return "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && a10 == null) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            a10 = nextElement.getHostAddress().toString();
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        String str = a10 != null ? a10 : "";
        d.b("ip", str);
        return str;
    }

    public final String b() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public final synchronized String c(Context context) {
        String subscriberId = this.f25589a.getSubscriberId();
        if (subscriberId != null) {
            return subscriberId;
        }
        String a10 = d.a("imsi");
        if (a10 != null) {
            return a10;
        }
        if (this.f25589a.isBackgroundRunning()) {
            return "";
        }
        if (d(context, g.f11102c)) {
            return "";
        }
        if (a10 == null) {
            a10 = "";
        }
        d.b("imsi", a10);
        return a10;
    }

    public final synchronized String f(Context context) {
        try {
            String a10 = d.a("NetworkOperatorName");
            if (a10 != null) {
                return a10;
            }
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        a10 = telephonyManager.getNetworkOperatorName();
                    }
                } catch (Throwable unused) {
                }
            }
            if (a10 != null) {
                if ("null".equals(a10)) {
                }
                d.b("NetworkOperatorName", a10);
                return a10;
            }
            a10 = "";
            d.b("NetworkOperatorName", a10);
            return a10;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized String h(Context context) {
        String a10 = d.a("SimSerial");
        if (a10 != null) {
            return a10;
        }
        if (this.f25589a.isBackgroundRunning()) {
            return "";
        }
        if (d(context, g.f11102c)) {
            return "";
        }
        d.b("SimSerial", a10);
        return a10;
    }

    public final synchronized String j(Context context) {
        String androidId = this.f25589a.getAndroidId();
        if (androidId != null) {
            return androidId;
        }
        String a10 = d.a("ANDROIDID");
        if (a10 != null) {
            return a10;
        }
        if (this.f25589a.isBackgroundRunning()) {
            return "";
        }
        try {
            a10 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
        }
        if (a10 == null) {
            a10 = "";
        }
        d.b("ANDROIDID", a10);
        return a10;
    }

    public final String l(Context context) {
        try {
            String H = H(context);
            String N = N();
            if (t3.a.f(H) && t3.a.f(N)) {
                return H + ":" + N();
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
