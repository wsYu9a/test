package f3;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final String f25961a = "msp";

    /* renamed from: b */
    public static final String f25962b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c */
    public static final CookieManager f25963c = new CookieManager();

    /* renamed from: f3.a$a */
    public static final class C0696a {

        /* renamed from: a */
        public final String f25964a;

        /* renamed from: b */
        public final byte[] f25965b;

        /* renamed from: c */
        public final Map<String, String> f25966c;

        public C0696a(String str, Map<String, String> map, byte[] bArr) {
            this.f25964a = str;
            this.f25965b = bArr;
            this.f25966c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f25964a, this.f25966c);
        }
    }

    public static final class b {

        /* renamed from: a */
        public final Map<String, List<String>> f25967a;

        /* renamed from: b */
        public final String f25968b;

        /* renamed from: c */
        public final byte[] f25969c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f25967a = map;
            this.f25968b = str;
            this.f25969c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static f3.a.b a(android.content.Context r11, f3.a.C0696a r12) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.a.a(android.content.Context, f3.a$a):f3.a$b");
    }

    public static String b(Context context) {
        try {
            NetworkInfo a10 = com.alipay.sdk.m.w.b.a(null, context);
            if (a10 != null && a10.isAvailable()) {
                return a10.getType() == 1 ? "wifi" : a10.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Proxy d(Context context) {
        String b10 = b(context);
        if (b10 != null && !b10.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }
}
