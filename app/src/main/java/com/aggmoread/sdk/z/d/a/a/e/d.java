package com.aggmoread.sdk.z.d.a.a.e;

import android.content.Context;
import android.os.Build;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
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

/* loaded from: classes.dex */
public class d {

    public static class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f6083b;

        /* renamed from: c */
        final /* synthetic */ Map f6084c;

        /* renamed from: d */
        final /* synthetic */ c f6085d;

        public a(String str, Map map, c cVar) {
            this.f6083b = str;
            this.f6084c = map;
            this.f6085d = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.aggmoread.sdk.z.d.a.a.e.d$c] */
        /* JADX WARN: Type inference failed for: r2v8, types: [com.aggmoread.sdk.z.d.a.a.d.b.i] */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v4, types: [com.aggmoread.sdk.z.d.a.a.d.b.i] */
        @Override // java.lang.Runnable
        public void run() {
            ?? r32;
            byte[] bArr;
            int i10 = -1;
            byte[] bArr2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f6083b).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                Map map = this.f6084c;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f6084c.get(str));
                    }
                }
                httpURLConnection.connect();
                i10 = httpURLConnection.getResponseCode();
                if (i10 == 200) {
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
                    bArr2 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002001, "HTTP error，statusCode=" + i10);
                }
                r32 = bArr2;
                bArr2 = bArr;
            } catch (UnsupportedEncodingException e10) {
                r32 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error, response encoding error.", e10);
            } catch (MalformedURLException e11) {
                r32 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002004, "HTTP errror, url parse error.", e11);
            } catch (IOException e12) {
                r32 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002005, "HTTP error, network error.", e12);
            } catch (Exception e13) {
                r32 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002007, "HTTP error,other error.", e13);
            }
            this.f6085d.a(i10, bArr2, r32);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f6086b;

        /* renamed from: c */
        final /* synthetic */ Map f6087c;

        /* renamed from: d */
        final /* synthetic */ byte[] f6088d;

        /* renamed from: e */
        final /* synthetic */ boolean f6089e;

        /* renamed from: f */
        final /* synthetic */ c f6090f;

        public b(String str, Map map, byte[] bArr, boolean z10, c cVar) {
            this.f6086b = str;
            this.f6087c = map;
            this.f6088d = bArr;
            this.f6089e = z10;
            this.f6090f = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            com.aggmoread.sdk.z.d.a.a.d.b.i iVar;
            byte[] bArr;
            int i10 = -1;
            com.aggmoread.sdk.z.d.a.a.d.b.i iVar2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f6086b).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                Map map = this.f6087c;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f6087c.get(str));
                    }
                }
                httpURLConnection.setRequestProperty("Content-length", Integer.toString(this.f6088d.length));
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(this.f6088d);
                i10 = httpURLConnection.getResponseCode();
                if (i10 == 200) {
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
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("response");
                        sb2.append(this.f6089e ? "-ads2" : "");
                        e.a(byteArray, sb2.toString());
                        bArr = byteArray;
                    } catch (UnsupportedEncodingException e10) {
                        e = e10;
                        iVar2 = byteArray;
                        iVar = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error, response encoding error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f6090f.a(i10, bArr, iVar2);
                    } catch (MalformedURLException e11) {
                        e = e11;
                        iVar2 = byteArray;
                        iVar = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002004, "HTTP errror, url parse error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f6090f.a(i10, bArr, iVar2);
                    } catch (IOException e12) {
                        e = e12;
                        iVar2 = byteArray;
                        iVar = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002005, "HTTP error, network error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f6090f.a(i10, bArr, iVar2);
                    } catch (Exception e13) {
                        e = e13;
                        iVar2 = byteArray;
                        iVar = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002007, "HTTP error,other error.", e);
                        bArr = iVar2;
                        iVar2 = iVar;
                        this.f6090f.a(i10, bArr, iVar2);
                    }
                } else {
                    bArr = 0;
                    iVar2 = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002001, "HTTP error，statusCode=" + i10);
                }
            } catch (UnsupportedEncodingException e14) {
                e = e14;
            } catch (MalformedURLException e15) {
                e = e15;
            } catch (IOException e16) {
                e = e16;
            } catch (Exception e17) {
                e = e17;
            }
            this.f6090f.a(i10, bArr, iVar2);
        }
    }

    public interface c {
        void a(int i10, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar);
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(str.getBytes("UTF-8"));
            return a(messageDigest.digest());
        } catch (Exception e10) {
            e.b("AMHTTAG", "Exception " + e10.getMessage());
            return null;
        }
    }

    public static Map<Object, Object> b(Map<Object, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        f fVar = new f(map);
        try {
            fVar.b(d.C0183d.f5897e, com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getPackageName());
            fVar.b(d.C0183d.f5895c, com.aggmoread.sdk.z.d.a.a.e.c.e());
            fVar.b(d.C0183d.f5903k, com.aggmoread.sdk.z.d.a.a.e.c.q());
            fVar.b(d.C0183d.f5898f, com.aggmoread.sdk.z.d.a.a.e.c.g());
            fVar.b(d.C0183d.f5899g, Build.BRAND);
            fVar.b(d.C0183d.f5900h, Build.MODEL);
            fVar.b(d.C0183d.f5901i, com.aggmoread.sdk.z.d.a.a.e.c.p());
            fVar.b(d.C0183d.f5902j, com.aggmoread.sdk.z.d.a.a.e.c.B());
        } catch (Exception e10) {
            e.b("AMHTTAG", "e = " + e10.getMessage());
        }
        return fVar.f6092a;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (i10 < 15) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i10));
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static Map<Object, Object> a(Map<Object, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        f fVar = new f(map);
        try {
            fVar.b(d.c.f5885a, com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getPackageName());
            fVar.b(d.c.f5886b, com.aggmoread.sdk.z.d.a.a.e.c.e());
            fVar.b(d.c.f5887c, com.aggmoread.sdk.z.d.a.a.e.c.q());
            fVar.b(d.c.f5889e, com.aggmoread.sdk.z.d.a.a.e.c.g());
        } catch (Exception e10) {
            e.b("AMHTTAG", "e = " + e10.getMessage());
        }
        return fVar.f6092a;
    }

    public static void a(Context context) {
    }

    public static void a(String str, Map<String, String> map, c cVar) {
        if (n.b(new a(str, map, cVar))) {
            return;
        }
        cVar.a(-1, null, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002007, "thread err."));
    }

    public static void a(String str, byte[] bArr, Map<String, String> map, c cVar) {
        e.b("AMHTTAG", str);
        boolean contains = str.contains("qd/r");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request");
        sb2.append(contains ? "-ads2" : "");
        e.a(bArr, sb2.toString());
        e.b("AMHTTAG", "vo false");
        if (n.b(new b(str, map, bArr, contains, cVar))) {
            return;
        }
        cVar.a(-1, null, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002007, "thread err."));
    }
}
