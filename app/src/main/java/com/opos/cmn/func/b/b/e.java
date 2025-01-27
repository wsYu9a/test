package com.opos.cmn.func.b.b;

import com.opos.cmn.an.g.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public final int f17168a;

    /* renamed from: b */
    public final String f17169b;

    /* renamed from: c */
    public final InputStream f17170c;

    /* renamed from: d */
    public final long f17171d;

    /* renamed from: e */
    @Deprecated
    public final Map<String, String> f17172e;

    /* renamed from: f */
    public final com.opos.cmn.func.b.b.a f17173f;

    /* renamed from: g */
    private final long f17174g;

    public static class a {

        /* renamed from: b */
        private String f17176b;

        /* renamed from: c */
        private InputStream f17177c;

        /* renamed from: e */
        private Map<String, String> f17179e;

        /* renamed from: f */
        private com.opos.cmn.func.b.b.a f17180f;

        /* renamed from: a */
        private int f17175a = -1;

        /* renamed from: d */
        private long f17178d = -1;

        /* renamed from: g */
        private long f17181g = -1;

        public a a(int i2) {
            this.f17175a = i2;
            return this;
        }

        public a a(long j2) {
            this.f17178d = j2;
            return this;
        }

        public a a(com.opos.cmn.func.b.b.a aVar) {
            this.f17180f = aVar;
            return this;
        }

        public a a(InputStream inputStream) {
            this.f17177c = inputStream;
            return this;
        }

        public a a(String str) {
            this.f17176b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f17179e = map;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(long j2) {
            this.f17181g = j2;
            return this;
        }
    }

    public e(a aVar) {
        this.f17168a = aVar.f17175a;
        this.f17169b = aVar.f17176b;
        this.f17170c = aVar.f17177c;
        this.f17171d = aVar.f17178d;
        this.f17172e = aVar.f17179e;
        this.f17173f = aVar.f17180f;
        this.f17174g = aVar.f17181g;
    }

    public void a() {
        long j2 = this.f17174g;
        if (j2 >= 0) {
            h.a(j2);
            return;
        }
        InputStream inputStream = this.f17170c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                com.opos.cmn.an.f.a.b("NetResponse", "close", e2);
            }
        }
    }

    public String toString() {
        return "NetResponse{code=" + this.f17168a + ", errMsg='" + this.f17169b + "', inputStream=" + this.f17170c + ", contentLength=" + this.f17171d + ", headerMap=" + this.f17172e + ", headers=" + this.f17173f + '}';
    }
}
