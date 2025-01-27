package com.aggmoread.sdk.z.d.a.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.ViewConfiguration;
import androidx.media3.common.C;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.bi;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static boolean f6076a = true;

    /* renamed from: b */
    public static long f6077b;

    /* renamed from: c */
    public static String f6078c;

    /* renamed from: d */
    public static int f6079d;

    /* renamed from: e */
    public static HashMap<String, Boolean> f6080e;

    /* renamed from: f */
    public static com.aggmoread.sdk.z.d.a.a.e.a f6081f;

    /* renamed from: g */
    static char[] f6082g;

    public static class a implements d.c {
        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            if (iVar != null || bArr == null) {
                return;
            }
            try {
                String optString = new JSONObject(new String(bArr)).optString("ip");
                Log.i("AMDEHTAG", "ip  " + optString);
                h.a().b("netIpAddress", optString);
                h.a().b("netIpAddress_lastTime", System.currentTimeMillis());
            } catch (Exception e10) {
                e10.printStackTrace();
                Log.i("AMDEHTAG", "get net ip err ," + e10.getMessage());
            }
        }
    }

    static {
        new Point(0, 0);
        f6080e = new HashMap<>();
        new AtomicBoolean();
        new AtomicBoolean();
        f6077b = System.currentTimeMillis();
        HashMap<String, Boolean> hashMap = f6080e;
        Boolean bool = Boolean.FALSE;
        hashMap.put(ke.e.f27807e, bool);
        f6080e.put("oppo", bool);
        HashMap<String, Boolean> hashMap2 = f6080e;
        Boolean bool2 = Boolean.TRUE;
        hashMap2.put("huawei", bool2);
        f6080e.put("honor", bool2);
        f6080e.put("samsung", bool2);
        f6080e.put("lenovo", bool2);
        f6080e.put("meitu", bool2);
        f6080e.put("lge", bool);
        f6082g = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    public static void A() {
    }

    public static boolean B() {
        try {
            return C();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean C() {
        try {
            if (!a() && !b()) {
                if (!c()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean D() {
        return f6076a && System.currentTimeMillis() - f6077b < 30000;
    }

    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static String b(Context context) {
        return null;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String d() {
        return h.a().a("device_androidid", "");
    }

    public static String e() {
        try {
            return com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getPackageManager().getPackageInfo(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getPackageName(), 0).versionName;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0053 -> B:14:0x005a). Please report as a decompilation issue!!! */
    public static String f() {
        FileInputStream fileInputStream;
        String str = "";
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        str = new BufferedReader(new InputStreamReader(fileInputStream)).readLine().trim();
                        try {
                            str = str.substring(0, 36);
                        } catch (Throwable unused2) {
                        }
                        fileInputStream.close();
                    } catch (IOException unused3) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        return str;
    }

    public static String g() {
        return h.a().a("deviceId", (String) null);
    }

    public static long h() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String i() {
        return h.a().a("sdk_identifier", (String) null);
    }

    public static String j() {
        return h.a().a("device_imsi", "");
    }

    public static long k() {
        ActivityManager activityManager = (ActivityManager) com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String l() {
        if (f6078c == null) {
            synchronized (c.class) {
                try {
                    if (f6078c == null) {
                        String a10 = d.a("xx00");
                        f6078c = a10;
                        f6078c = a10 == null ? "00xx" : a10.substring(0, 10);
                    }
                } finally {
                }
            }
        }
        return f6078c;
    }

    public static String m() {
        String a10 = h.a().a("netIpAddress", "");
        long currentTimeMillis = System.currentTimeMillis() - h.a().a("netIpAddress_lastTime", 0L);
        e.b("AMDEHTAG", "getNetIpAddress delay = " + currentTimeMillis);
        if (currentTimeMillis > 600000) {
            n();
        }
        return a10;
    }

    private static void n() {
        d.a("https://s.peplle.cn:28427/op/getIp", null, new a());
    }

    public static String o() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            connectivityManager = (ConnectivityManager) com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getSystemService("connectivity");
        } catch (Exception e10) {
            e.a("err " + e10);
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return "wifi";
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype == 20) {
                        return "5G";
                    }
                    switch (subtype) {
                        case 0:
                            return "none";
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                    return "none";
                                }
                            }
                            return "3G";
                    }
                    e.a("err " + e10);
                }
            }
            return "none";
        }
        return "none";
    }

    public static String p() {
        String str = Build.VERSION.RELEASE;
        if (str.length() == 1) {
            str = str + ".0.0";
        }
        if (str.length() != 3) {
            return str;
        }
        return str + ".0";
    }

    public static String q() {
        return "8091910";
    }

    public static String r() {
        return h.a().a("device_sero", "");
    }

    public static long s() {
        return System.currentTimeMillis() - (SystemClock.elapsedRealtimeNanos() / C.MICROS_PER_SECOND);
    }

    public static long t() {
        return Build.TIME;
    }

    public static int u() {
        if (f6079d == 0) {
            int scaledTouchSlop = ViewConfiguration.get(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q).getScaledTouchSlop();
            f6079d = scaledTouchSlop * scaledTouchSlop;
        }
        return f6079d;
    }

    public static String v() {
        StructTimespec structTimespec;
        long j10;
        long j11;
        try {
            int i10 = Build.VERSION.SDK_INT;
            StructStat stat = Os.stat("/data/data");
            if (i10 < 27) {
                return stat.st_atime + ".0";
            }
            structTimespec = stat.st_atim;
            StringBuilder sb2 = new StringBuilder();
            j10 = structTimespec.tv_sec;
            sb2.append(j10);
            sb2.append(p1.b.f29697h);
            j11 = structTimespec.tv_nsec;
            sb2.append(j11);
            return sb2.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void w() {
        String str;
        z();
        y();
        com.aggmoread.sdk.z.d.a.a.c.j b10 = com.aggmoread.sdk.z.d.a.a.d.b.g.a().b();
        if (b10 != null) {
            Log.i("AMDEHTAG", "oaid " + b10.o());
        }
        Log.i("AMDEHTAG", "can't use phone state!");
        Log.i("AMDEHTAG", " use controller device info");
        com.aggmoread.sdk.z.d.a.a.c.j b11 = com.aggmoread.sdk.z.d.a.a.d.b.g.a().b();
        if (b11 != null) {
            h.a().b("device_androidid", b11.h());
            str = b11.j();
            if (TextUtils.isEmpty(str)) {
                str = b11.h();
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = b(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q, false);
        }
        h.a().b("deviceId", str);
    }

    public static void x() {
    }

    private static void y() {
        if (TextUtils.isEmpty(i())) {
            String c10 = m.c(UUID.randomUUID().toString() + System.currentTimeMillis() + p() + c(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q) + Build.BRAND + Build.MODEL);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initIdentifier str ");
            sb2.append(c10);
            Log.i("AMDEHTAG", sb2.toString());
            h.a().b("sdk_identifier", c10);
        }
    }

    public static void z() {
        h.a().b("netIpAddress", (String) null);
        h.a().b("netIpAddress_lastTime", 0L);
        n();
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            i10 = (i10 * 31) + c10;
        }
        return i10;
    }

    public static String b(Context context, boolean z10) {
        StringBuilder sb2;
        try {
            String encodeToString = Base64.encodeToString(a(context, z10), 2);
            String uuid = UUID.randomUUID().toString();
            if (!TextUtils.isEmpty(uuid)) {
                String[] split = uuid.split("-");
                if (split.length > 1) {
                    int a10 = i.a(0, split.length - 1);
                    sb2 = new StringBuilder();
                    sb2.append("ska+");
                    sb2.append(encodeToString);
                    sb2.append(split[a10]);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("ska+");
                    sb3.append(encodeToString);
                    sb3.append(split[0]);
                    sb2 = sb3;
                }
                encodeToString = sb2.toString();
            }
            return a(encodeToString, 3);
        } catch (Exception e10) {
            e10.printStackTrace();
            return a("ska+" + e(context), 3);
        }
    }

    private static boolean c() {
        Process process;
        BufferedReader bufferedReader = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", bi.f10829y});
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    String readLine = bufferedReader2.readLine();
                    process.destroy();
                    a(bufferedReader2);
                    return readLine != null;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    if (process != null) {
                        process.destroy();
                    }
                    a(bufferedReader);
                    return false;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            process = null;
        }
    }

    public static String d(Context context) {
        return System.getProperty("http.agent");
    }

    public static String e(Context context) {
        return UUID.randomUUID().toString();
    }

    public static boolean f(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static String a(String str, int i10) {
        StringBuilder sb2 = new StringBuilder(str);
        int length = str.length();
        int length2 = f6082g.length;
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.insert(i.a(4, length - 1), f6082g[i.a(0, length2 - 1)]);
        }
        return sb2.toString();
    }

    private static boolean b() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i10 = 0; i10 < 10; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static String a(byte[] bArr) {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return Base64.encodeToString(mac.doFinal(bArr), 2);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    private static boolean a() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 24) % 256), (byte) ((i10 >> 16) % 256), (byte) ((i10 >> 8) % 256), (byte) (i10 % 256)};
    }

    private static byte[] a(Context context, boolean z10) {
        Random random;
        String b10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a10 = a(currentTimeMillis);
        byte[] a11 = a(nextInt);
        byteArrayOutputStream.write(a10, 0, 4);
        byteArrayOutputStream.write(a11, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        if (z10) {
            try {
                b10 = b(context);
            } catch (Exception unused) {
                random = new Random();
            }
            byteArrayOutputStream.write(a(a(b10)), 0, 4);
            byteArrayOutputStream.write(a(a(a(byteArrayOutputStream.toByteArray()))));
            return byteArrayOutputStream.toByteArray();
        }
        random = new Random();
        b10 = String.valueOf(random.nextInt());
        byteArrayOutputStream.write(a(a(b10)), 0, 4);
        byteArrayOutputStream.write(a(a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }
}
