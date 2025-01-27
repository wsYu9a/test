package a3;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: classes.dex */
public class d {
    public static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a10 = c.a(currentTimeMillis);
        byte[] a11 = c.a(nanoTime);
        byte[] a12 = c.a(nextInt);
        byte[] a13 = c.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a10, 0, bArr, 0, 4);
        System.arraycopy(a11, 0, bArr, 4, 4);
        System.arraycopy(a12, 0, bArr, 8, 4);
        System.arraycopy(a13, 0, bArr, 12, 4);
        return b.e(bArr, 2);
    }

    public static String b(Context context) {
        String c10 = f.b(null) ? c() : null;
        return f.b(c10) ? a() : c10;
    }

    public static String c() {
        String a10 = g.a("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(a10)) {
            a10 = g.a("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(a10) ? e() : a10;
    }

    public static String d(Context context) {
        return "";
    }

    public static String e() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", null).invoke(null, null);
        } catch (Exception unused) {
            return "";
        }
    }
}
