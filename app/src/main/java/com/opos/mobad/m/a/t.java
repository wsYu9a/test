package com.opos.mobad.m.a;

import com.cdo.oaps.ad.OapsKey;
import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class t extends com.heytap.nearx.a.a.b<t, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<t> f21433c = new b();

    /* renamed from: d */
    public static final w f21434d = w.UNKNOWN_STATUS;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final String f21435e;

    /* renamed from: f */
    public final w f21436f;

    public static final class a extends b.a<t, a> {

        /* renamed from: c */
        public String f21437c;

        /* renamed from: d */
        public w f21438d;

        public a a(w wVar) {
            this.f21438d = wVar;
            return this;
        }

        public a a(String str) {
            this.f21437c = str;
            return this;
        }

        public t b() {
            String str = this.f21437c;
            if (str != null) {
                return new t(this.f21437c, this.f21438d, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(str, OapsKey.KEY_TOKEN);
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) tVar.f21435e);
            w wVar = tVar.f21436f;
            return (wVar != null ? w.f21461d.a(2, (int) wVar) : 0) + a2 + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, tVar.f21435e);
            w wVar = tVar.f21436f;
            if (wVar != null) {
                w.f21461d.a(gVar, 2, wVar);
            }
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    try {
                        aVar.a(w.f21461d.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                }
            }
        }
    }

    public t(String str, w wVar, ByteString byteString) {
        super(f21433c, byteString);
        this.f21435e = str;
        this.f21436f = wVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", token=");
        sb.append(this.f21435e);
        if (this.f21436f != null) {
            sb.append(", vipStatus=");
            sb.append(this.f21436f);
        }
        StringBuilder replace = sb.replace(0, 2, "UserAccountInfo{");
        replace.append('}');
        return replace.toString();
    }
}
