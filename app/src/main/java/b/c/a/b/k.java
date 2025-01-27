package b.c.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bu;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

/* loaded from: classes.dex */
class k {

    /* renamed from: a */
    private static final String f4341a = m.a("T25lUGx1c1RW");

    /* renamed from: b */
    private static final String f4342b = "k";

    /* renamed from: c */
    public static final String f4343c = "TV";

    /* renamed from: d */
    private static h f4344d;

    private static class a {

        /* renamed from: a */
        public static final String f4345a = "k$a";

        private a() {
        }

        public static String a(String str) {
            StringBuilder sb = new StringBuilder();
            if (str != null && !str.equals("")) {
                try {
                    for (byte b2 : MessageDigest.getInstance(bu.f5659a).digest(str.getBytes())) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                    }
                } catch (NoSuchAlgorithmException e2) {
                    if (b.f4296b) {
                        b.a(e2.toString());
                    }
                }
            }
            return sb.toString();
        }
    }

    k() {
    }

    public static String a() {
        return b("eth0");
    }

    private static String b(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            if (b.f4296b) {
                b.a(e2.toString());
            }
        }
        return "02:00:00:00:00:00";
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(26)
    public static String c() {
        return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
    }

    public static String d() {
        return e().f4330a;
    }

    static h e() {
        h hVar = f4344d;
        if (hVar != null && !TextUtils.isEmpty(hVar.f4330a)) {
            return f4344d;
        }
        String c2 = c();
        String g2 = g(a());
        h hVar2 = new h(a.a(c2 + g2 + a.a(f4341a)), g.f4328i);
        if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(g2)) {
            Log.e(f4342b, "Invalid uuid : SN or MAC is null.");
        } else {
            hVar2.f4331b = g.f4329j;
            f4344d = hVar2;
        }
        return hVar2;
    }

    public static String f() {
        return b("wlan0");
    }

    private static String g(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        while (i2 < sb.length()) {
            if (':' == sb.charAt(i2)) {
                sb.deleteCharAt(i2);
                i2--;
            }
            i2++;
        }
        return sb.toString();
    }
}
