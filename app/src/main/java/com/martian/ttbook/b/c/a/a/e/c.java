package com.martian.ttbook.b.c.a.a.e;

import android.content.Context;
import android.os.Build;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.vivo.ic.webview.BridgeUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f15818a;

        /* renamed from: b */
        final /* synthetic */ Map f15819b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC0361c f15820c;

        a(String str, Map map, InterfaceC0361c interfaceC0361c) {
            this.f15818a = str;
            this.f15819b = map;
            this.f15820c = interfaceC0361c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.martian.ttbook.b.c.a.a.e.c$c] */
        /* JADX WARN: Type inference failed for: r2v8, types: [com.martian.ttbook.b.c.a.a.d.b.i] */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v4, types: [com.martian.ttbook.b.c.a.a.d.b.i] */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r3;
            byte[] bArr;
            byte[] bArr2 = null;
            int i2 = -1;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f15818a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                Map map = this.f15819b;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f15819b.get(str));
                    }
                }
                httpURLConnection.connect();
                i2 = httpURLConnection.getResponseCode();
                if (i2 == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[1024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    while (true) {
                        int read = bufferedInputStream.read(bArr3, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                } else {
                    bArr = null;
                    bArr2 = new com.martian.ttbook.b.c.a.a.d.b.i(10001, "HTTP error，statusCode=" + i2);
                }
                r3 = bArr2;
                bArr2 = bArr;
            } catch (UnsupportedEncodingException e2) {
                r3 = new com.martian.ttbook.b.c.a.a.d.b.i(10000, "HTTP error, response encoding error.", e2);
            } catch (MalformedURLException e3) {
                r3 = new com.martian.ttbook.b.c.a.a.d.b.i(10002, "HTTP errror, url parse error.", e3);
            } catch (IOException e4) {
                r3 = new com.martian.ttbook.b.c.a.a.d.b.i(MartianRPUserManager.f14921h, "HTTP error, network error.", e4);
            } catch (Exception e5) {
                r3 = new com.martian.ttbook.b.c.a.a.d.b.i(10006, "HTTP error,other error.", e5);
            }
            this.f15820c.a(i2, bArr2, r3);
        }
    }

    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f15821a;

        /* renamed from: b */
        final /* synthetic */ Map f15822b;

        /* renamed from: c */
        final /* synthetic */ byte[] f15823c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC0361c f15824d;

        b(String str, Map map, byte[] bArr, InterfaceC0361c interfaceC0361c) {
            this.f15821a = str;
            this.f15822b = map;
            this.f15823c = bArr;
            this.f15824d = interfaceC0361c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.c.a.a.d.b.i iVar;
            byte[] bArr;
            com.martian.ttbook.b.c.a.a.d.b.i iVar2 = null;
            int i2 = -1;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f15821a).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                Map map = this.f15822b;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f15822b.get(str));
                    }
                }
                httpURLConnection.setRequestProperty("Content-length", Integer.toString(this.f15823c.length));
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(this.f15823c);
                i2 = httpURLConnection.getResponseCode();
                if (i2 == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    while (true) {
                        int read = bufferedInputStream.read(bArr2, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        d.e(byteArray, BridgeUtils.CALL_JS_RESPONSE);
                        bArr = byteArray;
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        iVar2 = byteArray;
                        iVar = new com.martian.ttbook.b.c.a.a.d.b.i(10000, "HTTP error, response encoding error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f15824d.a(i2, bArr, iVar2);
                    } catch (MalformedURLException e3) {
                        e = e3;
                        iVar2 = byteArray;
                        iVar = new com.martian.ttbook.b.c.a.a.d.b.i(10002, "HTTP errror, url parse error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f15824d.a(i2, bArr, iVar2);
                    } catch (IOException e4) {
                        e = e4;
                        iVar2 = byteArray;
                        iVar = new com.martian.ttbook.b.c.a.a.d.b.i(MartianRPUserManager.f14921h, "HTTP error, network error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f15824d.a(i2, bArr, iVar2);
                    } catch (Exception e5) {
                        e = e5;
                        iVar2 = byteArray;
                        iVar = new com.martian.ttbook.b.c.a.a.d.b.i(10006, "HTTP error,other error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f15824d.a(i2, bArr, iVar2);
                    }
                } else {
                    bArr = 0;
                    iVar2 = new com.martian.ttbook.b.c.a.a.d.b.i(10001, "HTTP error，statusCode=" + i2);
                }
            } catch (UnsupportedEncodingException e6) {
                e = e6;
            } catch (MalformedURLException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            } catch (Exception e9) {
                e = e9;
            }
            this.f15824d.a(i2, bArr, iVar2);
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.e.c$c */
    public interface InterfaceC0361c {
        void a(int i2, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar);
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(str.getBytes("UTF-8"));
            return b(messageDigest.digest());
        } catch (Exception e2) {
            d.g("ADHTTPTAG", "Exception " + e2.getMessage());
            return null;
        }
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            if (i2 < 15) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i2));
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static Map<Object, Object> c(Map<Object, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        e eVar = new e(map);
        try {
            eVar.j(d.c.f15681a, com.martian.ttbook.b.c.a.a.d.b.j.q.getPackageName());
            eVar.j(d.c.f15682b, com.martian.ttbook.b.c.a.a.e.b.p());
            eVar.j(d.c.f15683c, com.martian.ttbook.b.c.a.a.e.b.v());
            eVar.j(d.c.f15685e, com.martian.ttbook.b.c.a.a.e.b.q());
        } catch (Exception e2) {
            d.g("ADHTTPTAG", "e = " + e2.getMessage());
        }
        return eVar.f15826a;
    }

    public static void d(Context context) {
    }

    public static void e(String str, Map<String, String> map, InterfaceC0361c interfaceC0361c) {
        if (j.e(new a(str, map, interfaceC0361c))) {
            return;
        }
        interfaceC0361c.a(-1, null, new com.martian.ttbook.b.c.a.a.d.b.i(10006, "thread err."));
    }

    public static void f(String str, byte[] bArr, Map<String, String> map, InterfaceC0361c interfaceC0361c) {
        d.g("ADHTTPTAG", str);
        d.e(bArr, "request");
        d.g("ADHTTPTAG", "vo false");
        if (j.e(new b(str, map, bArr, interfaceC0361c))) {
            return;
        }
        interfaceC0361c.a(-1, null, new com.martian.ttbook.b.c.a.a.d.b.i(10006, "thread err."));
    }

    public static Map<Object, Object> g(Map<Object, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        e eVar = new e(map);
        try {
            eVar.j(d.C0356d.f15693e, com.martian.ttbook.b.c.a.a.d.b.j.q.getPackageName());
            eVar.j(d.C0356d.f15691c, com.martian.ttbook.b.c.a.a.e.b.p());
            eVar.j(d.C0356d.k, com.martian.ttbook.b.c.a.a.e.b.v());
            eVar.j(d.C0356d.f15694f, com.martian.ttbook.b.c.a.a.e.b.q());
            eVar.j(d.C0356d.f15695g, Build.BRAND);
            eVar.j(d.C0356d.f15696h, Build.MODEL);
            eVar.j(d.C0356d.f15697i, com.martian.ttbook.b.c.a.a.e.b.u());
            eVar.k(d.C0356d.f15698j, com.martian.ttbook.b.c.a.a.e.b.E());
        } catch (Exception e2) {
            d.g("ADHTTPTAG", "e = " + e2.getMessage());
        }
        return eVar.f15826a;
    }
}
