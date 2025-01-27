package b.b.a.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.exception.NetErrorException;
import java.io.IOException;
import java.net.URL;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ByteArrayEntity;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private Context f4265a;

    /* renamed from: b */
    String f4266b;

    private a(Context context) {
        this(context, null);
    }

    public a(Context context, String str) {
        this.f4265a = context;
        this.f4266b = str;
    }

    private String a() {
        return this.f4266b;
    }

    private static ByteArrayEntity c(b.b.a.c.c cVar, String str) throws IOException {
        String str2;
        if (cVar != null) {
            str2 = cVar.f4226c;
            if (!TextUtils.isEmpty(cVar.f4227d)) {
                str = cVar.f4227d + "=" + str;
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = b.b.a.c.c.f4224a;
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(str.getBytes("utf-8"));
        byteArrayEntity.setContentType(str2);
        return byteArrayEntity;
    }

    private void d(String str) {
        this.f4266b = str;
    }

    private URL e() {
        try {
            return new URL(this.f4266b);
        } catch (Exception unused) {
            return null;
        }
    }

    private HttpResponse f(String str) throws NetErrorException {
        return b(str, null);
    }

    private HttpHost g() {
        URL e2;
        if (Build.VERSION.SDK_INT < 11) {
            NetworkInfo j2 = j();
            if (j2 == null || !j2.isAvailable() || j2.getType() != 0) {
                return null;
            }
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null) {
                return new HttpHost(defaultHost, defaultPort);
            }
            return null;
        }
        String k = k();
        if ((k != null && !k.contains("wap")) || (e2 = e()) == null) {
            return null;
        }
        b.b.a.b.b.f4198a.equalsIgnoreCase(e2.getProtocol());
        String property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return new HttpHost(property, Integer.parseInt(property2));
    }

    private HttpHost h() {
        NetworkInfo j2 = j();
        if (j2 != null && j2.isAvailable() && j2.getType() == 0) {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null) {
                return new HttpHost(defaultHost, defaultPort);
            }
        }
        return null;
    }

    private HttpHost i() {
        URL e2;
        String k = k();
        if ((k != null && !k.contains("wap")) || (e2 = e()) == null) {
            return null;
        }
        b.b.a.b.b.f4198a.equalsIgnoreCase(e2.getProtocol());
        String property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return new HttpHost(property, Integer.parseInt(property2));
    }

    private NetworkInfo j() {
        try {
            return ((ConnectivityManager) this.f4265a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    private String k() {
        try {
            NetworkInfo j2 = j();
            return (j2 == null || !j2.isAvailable()) ? com.baidu.mobads.sdk.internal.a.f5472a : j2.getType() == 1 ? com.alipay.mobilesecuritysdk.constant.a.I : j2.getExtraInfo().toLowerCase();
        } catch (Exception unused) {
            return com.baidu.mobads.sdk.internal.a.f5472a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092 A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f7 A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0107 A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, LOOP:0: B:22:0x0101->B:24:0x0107, LOOP_END, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011c A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0132 A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: Exception -> 0x0143, SocketTimeoutException -> 0x0149, SocketException -> 0x0152, ConnectTimeoutException -> 0x0158, NetErrorException -> 0x0161, TryCatch #2 {NetErrorException -> 0x0161, SocketException -> 0x0152, SocketTimeoutException -> 0x0149, ConnectTimeoutException -> 0x0158, Exception -> 0x0143, blocks: (B:6:0x000e, B:8:0x001a, B:10:0x0020, B:14:0x0078, B:15:0x007d, B:17:0x0092, B:19:0x00f7, B:21:0x00fd, B:22:0x0101, B:24:0x0107, B:26:0x0111, B:28:0x011c, B:30:0x011f, B:32:0x0123, B:33:0x012c, B:35:0x0132, B:37:0x0135, B:39:0x0139, B:42:0x009a, B:44:0x00a3, B:46:0x00ad, B:47:0x00c3, B:50:0x00cb, B:51:0x002a, B:53:0x0030, B:55:0x004b, B:56:0x0055, B:58:0x005b, B:60:0x0061, B:62:0x0067, B:64:0x0071), top: B:5:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.apache.http.HttpResponse b(java.lang.String r10, b.b.a.c.c r11) throws com.alipay.sdk.exception.NetErrorException {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.e.a.b(java.lang.String, b.b.a.c.c):org.apache.http.HttpResponse");
    }
}
