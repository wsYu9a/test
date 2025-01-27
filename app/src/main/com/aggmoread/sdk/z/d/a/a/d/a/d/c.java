package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.text.TextUtils;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.b.a;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c extends com.aggmoread.sdk.z.d.a.a.d.a.a implements com.aggmoread.sdk.z.d.a.a.c.o.d {

    /* renamed from: p */
    protected Map<String, Object> f5308p;

    /* renamed from: q */
    protected com.aggmoread.sdk.z.d.a.a.d.a.c f5309q;

    /* renamed from: r */
    private com.aggmoread.sdk.z.d.a.a.c.o.b f5310r;

    public class a implements a.c<String> {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.k f5311a;

        public a(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
            this.f5311a = kVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.b.a.c
        public void a(String str) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("XXXXX", "title " + str);
            if (!TextUtils.isEmpty(str)) {
                if (com.aggmoread.sdk.z.d.a.a.e.m.j(c.this.f5276i)) {
                    this.f5311a.a(k.b.C, str);
                }
                com.aggmoread.sdk.z.d.a.a.e.m.a(c.this.f5308p, str);
            }
            this.f5311a.b();
            c.this.m();
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ a.c f5313b;

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ String f5315b;

            public a(String str) {
                this.f5315b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.c cVar = b.this.f5313b;
                if (cVar != null) {
                    cVar.a(this.f5315b);
                }
            }
        }

        public b(a.c cVar) {
            this.f5313b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Thread.sleep(500L);
                    com.aggmoread.sdk.z.d.a.a.e.n.a(new a(c.this.getTitle()));
                } catch (Exception e10) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("XXXXX", "title info err " + e10.getMessage());
                    com.aggmoread.sdk.z.d.a.a.e.n.a(new a(null));
                }
            } catch (Throwable th2) {
                com.aggmoread.sdk.z.d.a.a.e.n.a(new a(null));
                throw th2;
            }
        }
    }

    public c(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar);
        this.f5308p = new HashMap();
        if (map != null) {
            map.put(AMConst.ExtrasKey.AD_ID, this.f5273f);
            this.f5308p.putAll(map);
        }
    }

    public void m() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar;
        if ((this.f5275h.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.o.e) && com.aggmoread.sdk.z.d.a.a.e.m.b(this.f5276i) && (bVar = this.f5310r) != null) {
            bVar.onAdExposed();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5276i)) {
            b(i10);
        }
    }

    public void b(int i10) {
    }

    public com.aggmoread.sdk.z.d.a.a.d.a.c c() {
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = this.f5309q;
        return cVar != null ? cVar : this.f5275h.f5874t;
    }

    public void d() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.onADCloseOverlay();
        }
    }

    public void e() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.onADOpenOverlay();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5273f;
    }

    public abstract String getTitle();

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5308p);
    }

    public void i() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar;
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i);
        boolean a10 = kVar.a(k.b.f6046n, this.f5273f).a(this.f5276i, a(), this.f5278k, this.f5281n);
        kVar.b();
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5281n, false, true);
        if (!a10 || (bVar = this.f5310r) == null) {
            return;
        }
        bVar.onAdClicked();
    }

    public void j() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i).a(k.b.f6046n, this.f5273f).a(4).b();
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void k() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        p();
    }

    public void l() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.onADLeftApplication();
        }
    }

    public void n() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.onRenderFail();
        }
    }

    public void o() {
        com.aggmoread.sdk.z.d.a.a.c.o.b bVar = this.f5310r;
        if (bVar != null) {
            bVar.onRenderSuccess();
        }
    }

    public void p() {
        com.aggmoread.sdk.z.d.a.a.d.b.k a10 = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i).a(6).a(k.b.f6046n, this.f5273f).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5275h, this.f5276i, this.f5308p));
        if (com.aggmoread.sdk.z.d.a.a.e.m.e()) {
            a(new a(a10));
        } else {
            a10.b();
            m();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5276i)) {
            b(i10, i11, str);
        }
    }

    public void b(int i10, int i11, String str) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void a(com.aggmoread.sdk.z.d.a.a.c.o.a aVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void a(com.aggmoread.sdk.z.d.a.a.c.o.b bVar) {
        this.f5310r = bVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5309q = cVar;
    }

    private void a(a.c<String> cVar) {
        com.aggmoread.sdk.z.d.a.a.e.n.b(new b(cVar));
    }
}
