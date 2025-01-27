package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class ag extends com.heytap.nearx.a.a.b<ag, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<ag> f19579c = new b();

    /* renamed from: d */
    public static final c f19580d = c.NO_TYPE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final c f19581e;

    /* renamed from: f */
    public final List<String> f19582f;

    public static final class a extends b.a<ag, a> {

        /* renamed from: c */
        public c f19583c;

        /* renamed from: d */
        public List<String> f19584d = com.heytap.nearx.a.a.a.b.a();

        public a a(c cVar) {
            this.f19583c = cVar;
            return this;
        }

        public ag b() {
            return new ag(this.f19583c, this.f19584d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ag> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ag.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ag agVar) {
            c cVar = agVar.f19581e;
            return (cVar != null ? c.f19593i.a(1, (int) cVar) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, (int) agVar.f19582f) + agVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ag agVar) throws IOException {
            c cVar = agVar.f19581e;
            if (cVar != null) {
                c.f19593i.a(gVar, 1, cVar);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, agVar.f19582f);
            gVar.a(agVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ag a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(c.f19593i.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                } else if (b2 != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.f19584d.add(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public enum c implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        VIDEO_START(1),
        VIDEO_PROCESS_25_PERCENT(2),
        VIDEO_PROCESS_50_PERCENT(3),
        VIDEO_PROCESS_75_PERCENT(4),
        VIDEO_COMPLETE(5),
        VIDEO_CLICK(6),
        VIDEO_CLOSE(7);


        /* renamed from: i */
        public static final com.heytap.nearx.a.a.e<c> f19593i = com.heytap.nearx.a.a.e.a(c.class);

        /* renamed from: j */
        private final int f19594j;

        c(int i2) {
            this.f19594j = i2;
        }

        public static c fromValue(int i2) {
            switch (i2) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return VIDEO_START;
                case 2:
                    return VIDEO_PROCESS_25_PERCENT;
                case 3:
                    return VIDEO_PROCESS_50_PERCENT;
                case 4:
                    return VIDEO_PROCESS_75_PERCENT;
                case 5:
                    return VIDEO_COMPLETE;
                case 6:
                    return VIDEO_CLICK;
                case 7:
                    return VIDEO_CLOSE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19594j;
        }
    }

    public ag(c cVar, List<String> list, ByteString byteString) {
        super(f19579c, byteString);
        this.f19581e = cVar;
        this.f19582f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19581e != null) {
            sb.append(", videoTrackType=");
            sb.append(this.f19581e);
        }
        if (!this.f19582f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f19582f);
        }
        StringBuilder replace = sb.replace(0, 2, "VideoTrackEvent{");
        replace.append('}');
        return replace.toString();
    }
}
