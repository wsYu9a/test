package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class q extends com.heytap.nearx.a.a.b<q, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<q> f19843c = new c();

    /* renamed from: d */
    public static final b f19844d = b.NO_TYPE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final b f19845e;

    /* renamed from: f */
    public final List<String> f19846f;

    public static final class a extends b.a<q, a> {

        /* renamed from: c */
        public b f19847c;

        /* renamed from: d */
        public List<String> f19848d = com.heytap.nearx.a.a.a.b.a();

        public a a(b bVar) {
            this.f19847c = bVar;
            return this;
        }

        public q b() {
            return new q(this.f19847c, this.f19848d, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        DOWNLOAD_START(1),
        DOWNLOAD_COMPLETE(2),
        INSTALL_COMPLETE(3);


        /* renamed from: e */
        public static final com.heytap.nearx.a.a.e<b> f19853e = com.heytap.nearx.a.a.e.a(b.class);

        /* renamed from: f */
        private final int f19855f;

        b(int i2) {
            this.f19855f = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return NO_TYPE;
            }
            if (i2 == 1) {
                return DOWNLOAD_START;
            }
            if (i2 == 2) {
                return DOWNLOAD_COMPLETE;
            }
            if (i2 != 3) {
                return null;
            }
            return INSTALL_COMPLETE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19855f;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<q> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(q qVar) {
            b bVar = qVar.f19845e;
            return (bVar != null ? b.f19853e.a(1, (int) bVar) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, (int) qVar.f19846f) + qVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, q qVar) throws IOException {
            b bVar = qVar.f19845e;
            if (bVar != null) {
                b.f19853e.a(gVar, 1, bVar);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, qVar.f19846f);
            gVar.a(qVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public q a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    try {
                        aVar.a(b.f19853e.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                } else if (b2 != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.f19848d.add(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public q(b bVar, List<String> list, ByteString byteString) {
        super(f19843c, byteString);
        this.f19845e = bVar;
        this.f19846f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19845e != null) {
            sb.append(", downLoadTrackType=");
            sb.append(this.f19845e);
        }
        if (!this.f19846f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f19846f);
        }
        StringBuilder replace = sb.replace(0, 2, "DownLoadTrackEvent{");
        replace.append('}');
        return replace.toString();
    }
}
