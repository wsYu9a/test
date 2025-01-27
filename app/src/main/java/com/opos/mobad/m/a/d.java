package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class d extends com.heytap.nearx.a.a.b<d, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<d> f21269c = new b();

    /* renamed from: d */
    public static final Integer f21270d = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final Integer f21271e;

    public static final class a extends b.a<d, a> {

        /* renamed from: c */
        public Integer f21272c;

        public a a(Integer num) {
            this.f21272c = num;
            return this;
        }

        public d b() {
            Integer num = this.f21272c;
            if (num != null) {
                return new d(this.f21272c, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "cacheInternal");
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<d> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
            return com.heytap.nearx.a.a.e.f9025d.a(1, (int) dVar.f21271e) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, dVar.f21271e);
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 != 1) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public d(Integer num, ByteString byteString) {
        super(f21269c, byteString);
        this.f21271e = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cacheInternal=");
        sb.append(this.f21271e);
        StringBuilder replace = sb.replace(0, 2, "ChannelAdConfig{");
        replace.append('}');
        return replace.toString();
    }
}
