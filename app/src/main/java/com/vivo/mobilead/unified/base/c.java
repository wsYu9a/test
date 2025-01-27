package com.vivo.mobilead.unified.base;

import com.vivo.ad.model.AdError;
import com.vivo.ad.model.r;
import com.vivo.mobilead.i.o;
import com.vivo.mobilead.unified.base.callback.j;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.z;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.vivo.mobilead.util.f1.b {

    /* renamed from: a */
    private j f29727a;

    /* renamed from: b */
    private String f29728b;

    /* renamed from: c */
    private String f29729c;

    /* renamed from: d */
    private int f29730d;

    /* renamed from: e */
    private int f29731e;

    /* renamed from: f */
    private String f29732f;

    /* renamed from: g */
    private int f29733g;

    /* renamed from: h */
    private int f29734h;
    private String l;
    private String n;
    private boolean o;
    private int p;

    /* renamed from: i */
    private int f29735i = -1;

    /* renamed from: j */
    private long f29736j = 2147483647L;
    private volatile boolean k = false;
    private boolean m = true;

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ long f29737a;

        /* renamed from: com.vivo.mobilead.unified.base.c$a$a */
        class C0611a implements o {

            /* renamed from: com.vivo.mobilead.unified.base.c$a$a$a */
            class C0612a extends com.vivo.mobilead.util.f1.b {

                /* renamed from: a */
                final /* synthetic */ AdError f29740a;

                C0612a(AdError adError) {
                    this.f29740a = adError;
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    if (c.this.k) {
                        return;
                    }
                    c.this.k = true;
                    c.this.f29727a.a(this.f29740a);
                }
            }

            C0611a() {
            }

            @Override // com.vivo.mobilead.i.o
            public void a(int i2, String str) {
                AdError adError = new AdError(i2, str, null, null);
                adError.setRequestId(c.this.f29732f);
                if (c.this.f29727a != null) {
                    C0612a c0612a = new C0612a(adError);
                    if (c.this.m) {
                        z.b().a(c0612a);
                    } else {
                        c0612a.run();
                    }
                }
                c cVar = c.this;
                cVar.a(null, "3000000", String.valueOf(cVar.f29734h));
            }

            @Override // com.vivo.mobilead.i.o
            public void a(List<com.vivo.ad.model.b> list) {
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ List f29742a;

            /* renamed from: b */
            final /* synthetic */ AdError f29743b;

            b(List list, AdError adError) {
                this.f29742a = list;
                this.f29743b = adError;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (this.f29742a.size() > 0) {
                    c.this.f29727a.a(this.f29742a, c.this.f29736j - (System.currentTimeMillis() - a.this.f29737a));
                } else {
                    if (c.this.k) {
                        return;
                    }
                    c.this.k = true;
                    c.this.f29727a.a(this.f29743b);
                }
            }
        }

        a(long j2) {
            this.f29737a = j2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:162:0x031e, code lost:
        
            if (com.vivo.mobilead.unified.base.c.this.m != false) goto L323;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0368, code lost:
        
            r0.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x036b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x0360, code lost:
        
            com.vivo.mobilead.util.z.b().a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x035e, code lost:
        
            if (com.vivo.mobilead.unified.base.c.this.m != false) goto L323;
         */
        @Override // com.vivo.mobilead.util.f1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void safelyRun() {
            /*
                Method dump skipped, instructions count: 911
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.unified.base.c.a.safelyRun():void");
        }
    }

    @Override // com.vivo.mobilead.util.f1.b
    public void safelyRun() {
        a1.e(new a(System.currentTimeMillis()));
    }

    public c b(String str) {
        this.f29728b = str;
        return this;
    }

    public c c(String str) {
        this.f29732f = str;
        return this;
    }

    public c d(String str) {
        this.f29729c = str;
        return this;
    }

    public c e(int i2) {
        this.f29734h = i2;
        return this;
    }

    public c f(int i2) {
        this.f29733g = i2;
        return this;
    }

    public c b(boolean z) {
        this.m = z;
        return this;
    }

    public c c(int i2) {
        this.f29735i = i2;
        return this;
    }

    public c d(int i2) {
        this.f29731e = i2;
        return this;
    }

    public c e(String str) {
        this.n = str;
        return this;
    }

    public c b(int i2) {
        this.p = i2;
        return this;
    }

    public static c a() {
        return new c();
    }

    public void a(com.vivo.ad.model.b bVar, String str, String str2) {
        r z;
        String valueOf = bVar == null ? "" : String.valueOf(bVar.j());
        String valueOf2 = String.valueOf(0);
        if (bVar != null && (z = bVar.z()) != null && 1 == z.a()) {
            valueOf2 = String.valueOf(1);
        }
        String str3 = valueOf2;
        String d2 = bVar != null ? bVar.d() : "";
        String valueOf3 = String.valueOf(1);
        if (this.f29730d == 5) {
            valueOf3 = String.valueOf(0);
        }
        w.a(this.f29728b, this.l, valueOf, str3, this.f29732f, d2, str, String.valueOf(this.f29733g), valueOf3, String.valueOf(this.f29730d), str2);
    }

    public void a(List<com.vivo.ad.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.vivo.ad.model.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().a().a(this.f29732f);
        }
    }

    public c a(String str) {
        this.l = str;
        return this;
    }

    public c a(long j2) {
        this.f29736j = j2;
        return this;
    }

    public c a(j jVar) {
        this.f29727a = jVar;
        return this;
    }

    public c a(int i2) {
        this.f29730d = i2;
        return this;
    }

    public c a(boolean z) {
        this.o = z;
        return this;
    }
}
