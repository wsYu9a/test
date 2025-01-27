package com.martian.ttbook.b.c.a.a.e;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.bh;
import com.opos.acs.st.utils.ErrorContants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static boolean f15810a = true;

    /* renamed from: b */
    public static long f15811b;

    /* renamed from: c */
    public static String f15812c;

    /* renamed from: d */
    public static int f15813d;

    /* renamed from: e */
    public static HashMap<String, Boolean> f15814e;

    /* renamed from: f */
    private static AtomicBoolean f15815f;

    /* renamed from: g */
    private static AtomicBoolean f15816g;

    /* renamed from: h */
    static char[] f15817h;

    static {
        new Point(0, 0);
        f15814e = new HashMap<>();
        f15815f = new AtomicBoolean();
        f15816g = new AtomicBoolean();
        f15811b = System.currentTimeMillis();
        HashMap<String, Boolean> hashMap = f15814e;
        Boolean bool = Boolean.FALSE;
        hashMap.put("vivo", bool);
        f15814e.put("oppo", bool);
        HashMap<String, Boolean> hashMap2 = f15814e;
        Boolean bool2 = Boolean.TRUE;
        hashMap2.put("huawei", bool2);
        f15814e.put("honor", bool2);
        f15814e.put("samsung", bool2);
        f15814e.put("lenovo", bool2);
        f15814e.put("meitu", bool2);
        f15814e.put("lge", bool);
        f15817h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    private static void A() {
        f.c().j("device_androidid", n());
    }

    public static void B() {
        String d2 = f.c().d(com.alipay.mobilesecuritysdk.deviceID.c.w, null);
        d.g("DEVHELTAG", "DID " + d2);
        if (TextUtils.isEmpty(d2)) {
            d2 = j(com.martian.ttbook.b.c.a.a.d.b.j.q);
            d.g("DEVHELTAG", "UID  " + d2);
            f.c().j(com.alipay.mobilesecuritysdk.deviceID.c.w, d2);
        } else {
            try {
                String h2 = h(com.martian.ttbook.b.c.a.a.d.b.j.q);
                d.g("DEVHELTAG", "IE = " + h2);
                if (!TextUtils.isEmpty(h2) && !d2.equals(h2)) {
                    f.c().j(com.alipay.mobilesecuritysdk.deviceID.c.w, h2);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(d2)) {
            d2 = j(com.martian.ttbook.b.c.a.a.d.b.j.q);
            f.c().j(com.alipay.mobilesecuritysdk.deviceID.c.w, d2);
        }
        d.g("DEVHELTAG", " F IE  = " + d2);
    }

    public static void C() {
        if (f15815f.compareAndSet(false, true)) {
            Log.i("DEVHELTAG", "init imsi ");
            Context context = com.martian.ttbook.b.c.a.a.d.b.j.q;
            String d2 = f.c().d("device_imsi", "");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return;
            }
            try {
                d.g("DEVHELTAG", "initIMSI checkPermission");
                if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9318c) == 0) {
                    d2 = telephonyManager.getSubscriberId();
                }
            } catch (Exception e2) {
                d.c("DEVHELTAG", "exception:%s", e2);
            }
            if (TextUtils.isEmpty(d2)) {
                d2 = "000000000000000";
            }
            f.c().j("device_imsi", d2);
        }
    }

    public static void D() {
        if (f15816g.compareAndSet(false, true)) {
            Log.i("DEVHELTAG", "init serial");
            f.c().j("device_sero", x());
        }
    }

    public static boolean E() {
        try {
            return F();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean F() {
        try {
            if (!e() && !i()) {
                if (!k()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean G() {
        return f15810a && System.currentTimeMillis() - f15811b < 30000;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }

    private static String b(String str, int i2) {
        StringBuilder sb = new StringBuilder(str);
        int length = str.length();
        int length2 = f15817h.length;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.insert(g.a(4, length - 1), f15817h[g.a(0, length2 - 1)]);
        }
        return sb.toString();
    }

    private static String c(byte[] bArr) {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return Base64.encodeToString(mac.doFinal(bArr), 2);
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static boolean e() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static byte[] f(int i2) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i2 % 256)};
        int i3 = i2 >> 8;
        int i4 = i3 >> 8;
        return bArr;
    }

    private static byte[] g(Context context) {
        String valueOf;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] f2 = f(currentTimeMillis);
        byte[] f3 = f(nextInt);
        byteArrayOutputStream.write(f2, 0, 4);
        byteArrayOutputStream.write(f3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            valueOf = h(context);
        } catch (Exception unused) {
            valueOf = String.valueOf(new Random().nextInt());
        }
        byteArrayOutputStream.write(f(a(valueOf)), 0, 4);
        byteArrayOutputStream.write(f(a(c(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private static String h(Context context) {
        String deviceId;
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 23) {
            d.g("DEVHELTAG", Integer.toString(23));
            if (com.martian.ttbook.b.c.a.a.d.b.j.q.checkSelfPermission(com.kuaishou.weapon.p0.g.f9318c) != 0) {
                return null;
            }
            d.g("DEVHELTAG", Integer.toString(23) + "  have P");
            deviceId = ((TelephonyManager) com.martian.ttbook.b.c.a.a.d.b.j.q.getSystemService("phone")).getDeviceId();
            if (deviceId == null) {
                return deviceId;
            }
            sb = new StringBuilder();
        } else {
            d.g("DEVHELTAG", Integer.toString(23));
            deviceId = ((TelephonyManager) com.martian.ttbook.b.c.a.a.d.b.j.q.getSystemService("phone")).getDeviceId();
            if (deviceId == null) {
                return deviceId;
            }
            sb = new StringBuilder();
        }
        sb.append(Integer.toString(23));
        sb.append(" ");
        sb.append(deviceId);
        d.g("DEVHELTAG", sb.toString());
        return deviceId;
    }

    private static boolean i() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static String j(Context context) {
        String m;
        d.g("DEVHELTAG", "getDeviceUID enter");
        try {
            m = h(context);
            if (TextUtils.isEmpty(m)) {
                m = "";
            }
            if (TextUtils.isEmpty(m)) {
                m = l();
            }
            if (TextUtils.isEmpty(m)) {
                m = m(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            m = m(context);
        }
        return TextUtils.isEmpty(m) ? ErrorContants.NET_ERROR : m;
    }

    private static boolean k() {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", bh.y});
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            process = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            process.destroy();
            d(bufferedReader);
            return readLine != null;
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (process != null) {
                process.destroy();
            }
            d(bufferedReader2);
            return false;
        }
    }

    public static String l() {
        return f.c().d("device_androidid", "");
    }

    public static String m(Context context) {
        StringBuilder sb;
        try {
            String encodeToString = Base64.encodeToString(g(context), 2);
            String uuid = UUID.randomUUID().toString();
            if (!TextUtils.isEmpty(uuid)) {
                String[] split = uuid.split("-");
                if (split.length > 1) {
                    int a2 = g.a(0, split.length - 1);
                    sb = new StringBuilder();
                    sb.append("ska+");
                    sb.append(encodeToString);
                    sb.append(split[a2]);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ska+");
                    sb2.append(encodeToString);
                    sb2.append(split[0]);
                    sb = sb2;
                }
                encodeToString = sb.toString();
            }
            return b(encodeToString, 3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return b("ska+" + o(context), 3);
        }
    }

    private static String n() {
        try {
            return Settings.Secure.getString(com.martian.ttbook.b.c.a.a.d.b.j.q.getContentResolver(), "android_id");
        } catch (Exception e2) {
            d.c("DEVHELTAG", "exception:%s", e2);
            return "";
        }
    }

    public static String o(Context context) {
        UUID randomUUID;
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if ("9774d56d682e549c".equals(string) || string == null) {
                String h2 = h(context);
                randomUUID = h2 != null ? UUID.nameUUIDFromBytes(h2.getBytes("utf8")) : UUID.randomUUID();
            } else {
                randomUUID = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            randomUUID = UUID.randomUUID();
        }
        return randomUUID.toString();
    }

    public static String p() {
        try {
            return com.martian.ttbook.b.c.a.a.d.b.j.q.getPackageManager().getPackageInfo(com.martian.ttbook.b.c.a.a.d.b.j.q.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String q() {
        return f.c().d(com.alipay.mobilesecuritysdk.deviceID.c.w, null);
    }

    public static String r() {
        return f.c().d("device_imsi", "");
    }

    public static String s() {
        if (f15812c == null) {
            synchronized (b.class) {
                if (f15812c == null) {
                    String a2 = c.a("xx00");
                    f15812c = a2;
                    f15812c = a2 == null ? "00xx" : a2.substring(0, 10);
                }
            }
        }
        return f15812c;
    }

    public static String t() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            connectivityManager = (ConnectivityManager) com.martian.ttbook.b.c.a.a.d.b.j.q.getSystemService("connectivity");
        } catch (Exception e2) {
            d.a("err " + e2);
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return com.alipay.mobilesecuritysdk.constant.a.I;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 0:
                            return com.baidu.mobads.sdk.internal.a.f5472a;
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
                                    return com.baidu.mobads.sdk.internal.a.f5472a;
                                }
                            }
                            return "3G";
                    }
                    d.a("err " + e2);
                }
            }
            return com.baidu.mobads.sdk.internal.a.f5472a;
        }
        return com.baidu.mobads.sdk.internal.a.f5472a;
    }

    public static String u() {
        String str = Build.VERSION.RELEASE;
        if (str.length() == 1) {
            str = str + ".0.0";
        }
        if (str.length() != 3) {
            return str;
        }
        return str + ".0";
    }

    public static String v() {
        return com.martian.ttbook.sdk.a.f15866d;
    }

    public static String w() {
        return f.c().d("device_sero", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static String x() {
        ?? r0 = 0;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                r0 = Build.getSerial();
            } else if (i2 > 24) {
                r0 = Build.SERIAL;
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                r0 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.serialno");
            }
            return r0;
        } catch (Exception e2) {
            Object[] objArr = new Object[1];
            objArr[r0] = e2;
            d.c("DEVHELTAG", "exception:%s", objArr);
            return "";
        }
    }

    public static int y() {
        if (f15813d == 0) {
            int scaledTouchSlop = ViewConfiguration.get(com.martian.ttbook.b.c.a.a.d.b.j.q).getScaledTouchSlop();
            f15813d = scaledTouchSlop * scaledTouchSlop;
        }
        return f15813d;
    }

    public static void z() {
        com.martian.ttbook.b.c.a.a.d.b.g.b().g();
        Log.i("DEVHELTAG", "read phone state info ");
        A();
        B();
    }
}
