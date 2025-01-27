package com.opos.mobad.service.h;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.b.b.e;
import java.io.IOException;
import java.util.HashMap;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class b {

    public interface a<T> {
        T b(BufferedSource bufferedSource) throws IOException;
    }

    /* renamed from: com.opos.mobad.service.h.b$b */
    public static final class C0487b<T> {

        /* renamed from: a */
        public final int f23682a;

        /* renamed from: b */
        public final String f23683b;

        /* renamed from: c */
        public final T f23684c;

        public C0487b(int i2, T t) {
            this.f23682a = i2;
            this.f23683b = null;
            this.f23684c = t;
        }

        public C0487b(int i2, String str) {
            this.f23682a = i2;
            this.f23683b = str;
            this.f23684c = null;
        }
    }

    public static final <T> C0487b a(Context context, String str, byte[] bArr, a<T> aVar) {
        Throwable th;
        e a2;
        C0487b c0487b;
        String a3;
        T t = (T) null;
        if (context == null || TextUtils.isEmpty(str)) {
            return new C0487b(-1, (String) null);
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-protobuf");
            hashMap.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
            hashMap.put(HttpHeaders.ACCEPT, "application/x-protobuf");
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
            if (bArr != null && bArr.length >= 1024) {
                com.opos.cmn.an.f.a.b(MiConfigSingleton.t0, "data.length >= 1024 ,need gzip compress.");
                bArr = com.opos.cmn.b.c.a.a(bArr);
                hashMap.put("Content-Encoding", "gzip");
            }
            d.a a4 = new d.a().a("POST").b(str).a(hashMap);
            if (bArr != null) {
                a4.a(bArr);
            }
            a2 = com.opos.cmn.func.b.b.b.a().a(context, a4.a());
        } catch (Throwable th2) {
            th = th2;
        }
        if (a2 == null) {
            if (a2 != null) {
                a2.a();
            }
            return new C0487b(-1, "unknown error.");
        }
        try {
            boolean z = false;
            com.opos.cmn.an.f.a.b(MiConfigSingleton.t0, "fetchAd netResponse=", a2);
            int i2 = a2.f17168a;
            if (200 == i2) {
                if (aVar != null) {
                    com.opos.cmn.func.b.b.a aVar2 = a2.f17173f;
                    if (aVar2 != null && (a3 = aVar2.a("Content-Encoding")) != null) {
                        z = "gzip".equalsIgnoreCase(a3);
                    }
                    Source source = Okio.source(a2.f17170c);
                    if (z) {
                        source = new GzipSource(source);
                    }
                    BufferedSource buffer = Okio.buffer(source);
                    t = aVar.b(buffer);
                    source.close();
                    buffer.close();
                }
                c0487b = new C0487b(a2.f17168a, t);
            } else {
                c0487b = new C0487b(i2, a2.f17169b);
            }
            a2.a();
            return c0487b;
        } catch (Throwable th3) {
            th = th3;
            t = (T) a2;
            try {
                com.opos.cmn.an.f.a.a(MiConfigSingleton.t0, "", th);
                return new C0487b(-1, "unknown error.");
            } finally {
                if (t != null) {
                    t.a();
                }
            }
        }
    }
}
