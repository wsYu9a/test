package com.aggmoread.sdk.z.b.p;

import com.aggmoread.sdk.z.b.h.b;
import com.aggmoread.sdk.z.b.m.n;
import com.baidu.mobads.sdk.internal.am;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.aggmoread.sdk.z.b.p.a$a */
    public static class C0084a implements g {

        /* renamed from: a */
        final /* synthetic */ f f4764a;

        public C0084a(f fVar) {
            this.f4764a = fVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            JSONObject jSONObject = null;
            if (eVar == null) {
                if (bArr == null) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f4764a.a(i10, jSONObject, eVar);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4765b;

        /* renamed from: c */
        final /* synthetic */ Map f4766c;

        /* renamed from: d */
        final /* synthetic */ byte[] f4767d;

        /* renamed from: e */
        final /* synthetic */ g f4768e;

        public b(String str, Map map, byte[] bArr, g gVar) {
            this.f4765b = str;
            this.f4766c = map;
            this.f4767d = bArr;
            this.f4768e = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.aggmoread.sdk.z.b.p.a$g] */
        /* JADX WARN: Type inference failed for: r3v6, types: [com.aggmoread.sdk.z.b.g.e] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.aggmoread.sdk.z.b.g.e] */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v8 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r42;
            byte[] bArr;
            int i10 = -1;
            byte[] bArr2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4765b).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                Map map = this.f4766c;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f4766c.get(str));
                    }
                }
                httpURLConnection.setRequestProperty("Content-length", Integer.toString(this.f4767d.length));
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(this.f4767d);
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
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    com.aggmoread.sdk.z.b.d.d(str2, "api response");
                    bArr = str2.getBytes();
                } else {
                    bArr = null;
                    bArr2 = new com.aggmoread.sdk.z.b.g.e(10005, "HTTP error，statusCode=" + i10);
                }
                r42 = bArr2;
                bArr2 = bArr;
            } catch (Exception e10) {
                r42 = new com.aggmoread.sdk.z.b.g.e(10005, "HTTP error, response encoding error." + e10.getMessage());
            }
            this.f4768e.a(i10, bArr2, r42);
        }
    }

    public static class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4769b;

        /* renamed from: c */
        final /* synthetic */ Map f4770c;

        /* renamed from: d */
        final /* synthetic */ g f4771d;

        public c(String str, Map map, g gVar) {
            this.f4769b = str;
            this.f4770c = map;
            this.f4771d = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.aggmoread.sdk.z.b.p.a$g] */
        /* JADX WARN: Type inference failed for: r3v6, types: [com.aggmoread.sdk.z.b.g.e] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.aggmoread.sdk.z.b.g.e] */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r42;
            byte[] bArr;
            int i10 = -1;
            byte[] bArr2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4769b).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                Map map = this.f4770c;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f4770c.get(str));
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
                    bArr2 = new com.aggmoread.sdk.z.b.g.e(10005, "HTTP error，statusCode=" + i10);
                }
                r42 = bArr2;
                bArr2 = bArr;
            } catch (Exception e10) {
                r42 = new com.aggmoread.sdk.z.b.g.e(10005, "HTTP error, response encoding error." + e10.getMessage());
            }
            this.f4771d.a(i10, bArr2, r42);
        }
    }

    public static class d implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4772b;

        /* renamed from: c */
        final /* synthetic */ JSONObject f4773c;

        /* renamed from: d */
        final /* synthetic */ Map f4774d;

        /* renamed from: com.aggmoread.sdk.z.b.p.a$d$a */
        public class C0085a implements b.a {
            public C0085a(d dVar) {
            }
        }

        public d(String str, JSONObject jSONObject, Map map, f fVar) {
            this.f4772b = str;
            this.f4773c = jSONObject;
            this.f4774d = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aggmoread.sdk.z.b.h.a.d().c().a(this.f4772b, this.f4773c, this.f4774d, new C0085a(this));
        }
    }

    public static class e implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f4775b;

        /* renamed from: c */
        final /* synthetic */ Map f4776c;

        /* renamed from: com.aggmoread.sdk.z.b.p.a$e$a */
        public class C0086a implements b.a {
            public C0086a(e eVar) {
            }
        }

        public e(String str, Map map, g gVar) {
            this.f4775b = str;
            this.f4776c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aggmoread.sdk.z.b.h.a.d().c().a(this.f4775b, this.f4776c, new C0086a(this));
        }
    }

    public interface f {
        void a(int i10, JSONObject jSONObject, com.aggmoread.sdk.z.b.g.e eVar);
    }

    public interface g {
        void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar);
    }

    public static void a(String str, Map<String, String> map, g gVar) {
        if (!com.aggmoread.sdk.z.b.h.a.d().f() || com.aggmoread.sdk.z.b.h.a.d().c() == null) {
            n.a(new c(str, map, gVar));
        } else {
            b(str, map, gVar);
        }
    }

    private static void b(String str, Map<String, String> map, g gVar) {
        n.a(new e(str, map, gVar));
    }

    public static void a(String str, JSONObject jSONObject, Map<String, String> map, f fVar) {
        if (com.aggmoread.sdk.z.b.h.a.d().f() && com.aggmoread.sdk.z.b.h.a.d().c() != null) {
            b(str, jSONObject, map, fVar);
            return;
        }
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("Content-type", am.f6738d);
            a(str, bytes, map, new C0084a(fVar));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private static void b(String str, JSONObject jSONObject, Map<String, String> map, f fVar) {
        n.a(new d(str, jSONObject, map, fVar));
    }

    public static void a(String str, byte[] bArr, Map<String, String> map, g gVar) {
        n.a(new b(str, map, bArr, gVar));
    }
}
