package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.text.TextUtils;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.b.a;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b extends com.aggmoread.sdk.z.d.a.a.d.a.a implements com.aggmoread.sdk.z.d.a.a.c.n.a {

    /* renamed from: p */
    protected Map<String, Object> f5298p;

    /* renamed from: q */
    protected com.aggmoread.sdk.z.d.a.a.c.n.d f5299q;

    /* renamed from: r */
    protected com.aggmoread.sdk.z.d.a.a.c.n.b f5300r;

    /* renamed from: s */
    protected com.aggmoread.sdk.z.d.a.a.d.a.c f5301s;

    public class a implements a.c<String> {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.k f5302a;

        public a(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
            this.f5302a = kVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.b.a.c
        public void a(String str) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("XXXXX", "title " + str);
            if (!TextUtils.isEmpty(str)) {
                if (com.aggmoread.sdk.z.d.a.a.e.m.j(b.this.f5276i)) {
                    this.f5302a.a(k.b.C, str);
                }
                com.aggmoread.sdk.z.d.a.a.e.m.a(b.this.f5298p, str);
            }
            this.f5302a.b();
            b.this.e();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.b$b */
    public class RunnableC0117b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ a.c f5304b;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.b$b$a */
        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ String f5306b;

            public a(String str) {
                this.f5306b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.c cVar = RunnableC0117b.this.f5304b;
                if (cVar != null) {
                    cVar.a(this.f5306b);
                }
            }
        }

        public RunnableC0117b(a.c cVar) {
            this.f5304b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Thread.sleep(500L);
                    com.aggmoread.sdk.z.d.a.a.e.n.a(new a(b.this.getTitle()));
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

    public b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar);
        this.f5298p = new HashMap();
        if (map != null) {
            map.put(AMConst.ExtrasKey.AD_ID, this.f5273f);
            this.f5298p.putAll(map);
        }
    }

    public void e() {
        if (this.f5300r == null || !com.aggmoread.sdk.z.d.a.a.e.m.b(this.f5276i)) {
            return;
        }
        this.f5300r.onAdExposed();
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
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = this.f5301s;
        return cVar != null ? cVar : this.f5275h.f5874t;
    }

    public void d() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        i();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5273f;
    }

    public abstract String getTitle();

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5298p);
    }

    public void i() {
        com.aggmoread.sdk.z.d.a.a.d.b.k a10 = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i).a(6).a(k.b.f6046n, this.f5273f).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5275h, this.f5276i, this.f5298p));
        if (com.aggmoread.sdk.z.d.a.a.e.m.e()) {
            a(new a(a10));
        } else {
            a10.b();
            e();
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

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void a(com.aggmoread.sdk.z.d.a.a.c.n.b bVar) {
        this.f5300r = bVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void a(com.aggmoread.sdk.z.d.a.a.c.n.d dVar) {
        this.f5299q = dVar;
    }

    private void a(a.c<String> cVar) {
        com.aggmoread.sdk.z.d.a.a.e.n.b(new RunnableC0117b(cVar));
    }
}
