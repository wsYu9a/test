package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class w extends com.heytap.nearx.a.a.b<w, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<w> f19897c = new b();

    /* renamed from: d */
    public static final Integer f19898d = 100;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final String f19899e;

    /* renamed from: f */
    public final Integer f19900f;

    public static final class a extends b.a<w, a> {

        /* renamed from: c */
        public String f19901c;

        /* renamed from: d */
        public Integer f19902d;

        public a a(Integer num) {
            this.f19902d = num;
            return this;
        }

        public a a(String str) {
            this.f19901c = str;
            return this;
        }

        public w b() {
            return new w(this.f19901c, this.f19902d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<w> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, w.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(w wVar) {
            String str = wVar.f19899e;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            Integer num = wVar.f19900f;
            return a2 + (num != null ? com.heytap.nearx.a.a.e.f9025d.a(2, (int) num) : 0) + wVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, w wVar) throws IOException {
            String str = wVar.f19899e;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            Integer num = wVar.f19900f;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 2, num);
            }
            gVar.a(wVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public w a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public w(String str, Integer num, ByteString byteString) {
        super(f19897c, byteString);
        this.f19899e = str;
        this.f19900f = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19899e != null) {
            sb.append(", verName=");
            sb.append(this.f19899e);
        }
        if (this.f19900f != null) {
            sb.append(", verCode=");
            sb.append(this.f19900f);
        }
        StringBuilder replace = sb.replace(0, 2, "MarketInfo{");
        replace.append('}');
        return replace.toString();
    }
}
