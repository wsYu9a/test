package com.vivo.ic.dm.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.network.h;
import com.vivo.ic.dm.q.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final int f28571a = 7;

    /* renamed from: b */
    public static final String f28572b = "com.vivo.ic_wifi_key";

    /* renamed from: c */
    public static final int f28573c = 0;

    /* renamed from: d */
    private static final int f28574d = 0;

    /* renamed from: e */
    private static final int f28575e = 1;

    /* renamed from: f */
    private static final int f28576f = 2;

    /* renamed from: g */
    private static final int f28577g = 3;

    /* renamed from: h */
    private static final String f28578h = "CheckAuthWifi";

    /* renamed from: i */
    private static final int f28579i = 6000;

    /* renamed from: j */
    private static final int f28580j = 3;
    private static final String k = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6";
    private static final String[] l = {"<html[\\s\\S]*?>", "<head[\\s\\S]*?>", "<title[\\s\\S]*?>", "<link[\\s\\S]*?>", "<script[\\s\\S]*?>", "<body[\\s\\S]*?>"};
    private static final int m = 6;
    private static a n;
    private static a o;
    public String q;
    private int t;
    private final Object p = new Object();
    private volatile int r = 0;
    private String s = null;

    /* renamed from: com.vivo.ic.dm.p.a$a */
    class RunnableC0569a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f28581a;

        RunnableC0569a(Context context) {
            this.f28581a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            boolean a2 = aVar.a(this.f28581a, aVar.t);
            synchronized (a.this.p) {
                a.this.r = a2 ? 3 : 2;
                a aVar2 = a.this;
                aVar2.s = aVar2.b(this.f28581a);
                VLog.i(a.f28578h, "recheckAuthWifi " + a.this.s + " result " + a.this.r);
                a.this.p.notifyAll();
            }
        }
    }

    private static class b extends Throwable {
        private b() {
        }

        /* synthetic */ b(RunnableC0569a runnableC0569a) {
            this();
        }
    }

    private static class c {

        /* renamed from: a */
        int f28583a;

        /* renamed from: b */
        String f28584b;

        /* renamed from: c */
        String f28585c;

        private c() {
        }

        /* synthetic */ c(RunnableC0569a runnableC0569a) {
            this();
        }
    }

    private a(int i2) {
        this.q = null;
        this.t = i2;
        if (a("ro.vivo.product.overseas", "yes").equals("yes")) {
            return;
        }
        this.q = "https://wifi.vivo.com.cn/generate_204";
    }

    public void e(Context context) {
        if (this.r == 0) {
            a(context);
        }
    }

    public boolean f(Context context) {
        String b2 = b(context);
        String str = this.s;
        if (str == null || !str.equals(b2) || this.r != 2) {
            a(context);
            synchronized (this.p) {
                if (this.r != 2 && this.r != 3) {
                    try {
                        this.p.wait(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return this.r == 3;
    }

    public static a b() {
        if (n == null) {
            synchronized (a.class) {
                if (n == null) {
                    n = new a(1);
                }
            }
        }
        return n;
    }

    private String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return String.valueOf(0);
            }
            String simOperator = telephonyManager.getSimOperator();
            if (simOperator != null && simOperator.length() >= 5) {
                StringBuilder sb = new StringBuilder();
                try {
                    int length = simOperator.length();
                    if (length > 6) {
                        length = 6;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!Character.isDigit(simOperator.charAt(i2))) {
                            if (sb.length() > 0) {
                                break;
                            }
                        } else {
                            sb.append(simOperator.charAt(i2));
                        }
                    }
                    return sb.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return String.valueOf(0);
                }
            }
            return String.valueOf(0);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private String d(Context context) {
        NetworkInfo activeNetworkInfo;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType() || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            return connectionInfo.getSSID();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static a a() {
        if (o == null) {
            synchronized (a.class) {
                if (o == null) {
                    o = new a(2);
                }
            }
        }
        return o;
    }

    public String b(Context context) {
        String d2 = d(context);
        return TextUtils.isEmpty(d2) ? c(context) : d2;
    }

    public boolean a(Context context, int i2) {
        if (this.q == null) {
            String a2 = com.vivo.ic.dm.p.b.b().a(f28572b, (String) null);
            if (a2 == null) {
                this.q = "";
            } else {
                this.q = "https://" + a2 + "/generate_204";
            }
        }
        if (TextUtils.isEmpty(this.q)) {
            return false;
        }
        if (i2 == 2) {
            return a(i2);
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((activeNetworkInfo == null || activeNetworkInfo.getType() != 0) && activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED && activeNetworkInfo.getType() == 1) {
            return a(i2);
        }
        return false;
    }

    private static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private boolean a(int i2) {
        HttpURLConnection httpURLConnection = null;
        c cVar = new c(null);
        String str = this.q;
        cVar.f28585c = str;
        cVar.f28584b = str;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (!z2 && i3 < 10) {
            try {
                try {
                    try {
                        httpURLConnection = a(cVar.f28584b, i2);
                    } catch (b unused) {
                        VLog.i(f28578h, "checkAuthHttpsUrl HandleRedirectThrowable:" + i3);
                        i3++;
                        if (httpURLConnection == null) {
                        }
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                            VLog.i(f28578h, "Exception e:" + e2);
                            e2.printStackTrace();
                        }
                    }
                } catch (SocketTimeoutException unused2) {
                    VLog.i(f28578h, "checkAuthHttpsUrl SocketTimeoutException:" + i3);
                    i3++;
                    if (i3 >= 3) {
                        z2 = true;
                        z3 = false;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
                if (httpURLConnection == null) {
                    return false;
                }
                z3 = a(cVar, httpURLConnection);
                httpURLConnection.disconnect();
                z2 = true;
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        z = z3;
        VLog.i(f28578h, "check " + z + " by AuthWifi " + this.t);
        return z;
    }

    private HttpURLConnection a(String str, int i2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) h.a().b(new URL(str), null, i2);
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setReadTimeout(6000);
        httpURLConnection.setRequestProperty("User-Agent", k);
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:3|4|(5:9|(1:31)|17|(2:26|27)|(3:20|21|22)(1:25))|32|33|34|36|37|(2:38|(1:40)(1:41))|42|(3:44|(1:(2:46|(1:49)(1:48))(2:55|56))|(3:53|(0)|(0)(0)))|57|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0155, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0156, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x015a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0147, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x014b, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x014c, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
    
        com.vivo.ic.VLog.d(com.vivo.ic.dm.p.a.f28578h, "matcher.group " + r7.group());
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a8, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0117, code lost:
    
        com.vivo.ic.VLog.i(com.vivo.ic.dm.p.a.f28578h, "checkAuthHttpsData SSLPeerUnverifiedException:" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x012b, code lost:
    
        if (r11 != null) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0135, code lost:
    
        if (r12 != null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0141, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0137, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013b, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012d, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0131, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0132, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c8, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e8, code lost:
    
        com.vivo.ic.VLog.i(com.vivo.ic.dm.p.a.f28578h, "checkAuthHttpsData IOException:" + r1);
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ff, code lost:
    
        if (r11 != null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0109, code lost:
    
        if (r12 == null) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010b, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0101, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0105, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0106, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d7, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00d8, code lost:
    
        r12 = r11;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0113, code lost:
    
        r1 = r11;
        r11 = r12;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00d2, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00d3, code lost:
    
        r12 = r11;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00e4, code lost:
    
        r1 = r11;
        r11 = r12;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00cd, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ce, code lost:
    
        r12 = r11;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00de, code lost:
    
        r0 = r11;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0145, code lost:
    
        if (r11 != 0) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x014f, code lost:
    
        if (r1 != 0) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0151, code lost:
    
        r1.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0 A[Catch: Exception -> 0x010f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x010f, blocks: (B:20:0x00c0, B:79:0x010b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b A[Catch: Exception -> 0x010f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x010f, blocks: (B:20:0x00c0, B:79:0x010b), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.vivo.ic.dm.p.a.c r11, java.net.HttpURLConnection r12) throws com.vivo.ic.dm.p.a.b {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.p.a.a(com.vivo.ic.dm.p.a$c, java.net.HttpURLConnection):boolean");
    }

    private void a(c cVar, HttpURLConnection httpURLConnection, int i2) throws b {
        VLog.i(f28578h, "handleHttpsRedirect got HTTP redirect " + i2);
        if (cVar.f28583a >= 7) {
            return;
        }
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        VLog.d(f28578h, "handleHttpsRedirect Location :" + headerField);
        try {
            String uri = new URI(cVar.f28585c).resolve(new URI(headerField)).toString();
            cVar.f28583a++;
            cVar.f28584b = uri;
            throw new b(null);
        } catch (URISyntaxException unused) {
            VLog.d(f28578h, "Couldn't resolve redirect URI " + headerField + " for " + cVar.f28585c);
        }
    }

    public void a(Context context) {
        if (this.r == 1) {
            VLog.i(f28578h, "checking AuthWifi " + this.t);
            return;
        }
        this.r = 1;
        RunnableC0569a runnableC0569a = new RunnableC0569a(context);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d.b().a(runnableC0569a, "check_auth");
        } else {
            runnableC0569a.run();
        }
    }
}
