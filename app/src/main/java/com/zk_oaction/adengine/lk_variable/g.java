package com.zk_oaction.adengine.lk_variable;

import java.util.HashMap;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35050a;

    /* renamed from: b */
    private HashMap<String, d> f35051b = new HashMap<>();

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f35052a;

        /* renamed from: b */
        final /* synthetic */ String f35053b;

        a(String str, String str2) {
            this.f35052a = str;
            this.f35053b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = (d) g.this.f35051b.get(this.f35052a);
            if (dVar == null) {
                dVar = new d(g.this.f35050a, this.f35052a);
                g.this.d(dVar);
            }
            dVar.f(this.f35053b);
        }
    }

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35050a = cVar;
    }

    public d a(String str) {
        d dVar;
        synchronized (this) {
            dVar = this.f35051b.get(str);
        }
        return dVar;
    }

    public void c() {
        synchronized (this) {
            this.f35051b.clear();
        }
    }

    public void d(d dVar) {
        synchronized (this) {
            if (this.f35051b.get(dVar.h()) == null) {
                this.f35051b.put(dVar.h(), dVar);
            }
        }
    }

    public void e(String str, f fVar) {
        synchronized (this) {
            d dVar = this.f35051b.get(str);
            if (dVar == null) {
                dVar = new d(this.f35050a, str);
                d(dVar);
            }
            dVar.b(fVar);
        }
    }

    public void f(String str, String str2) {
        synchronized (this) {
            a aVar = new a(str, str2);
            if (this.f35050a != null) {
                Thread currentThread = Thread.currentThread();
                com.zk_oaction.adengine.lk_sdk.c cVar = this.f35050a;
                if (currentThread != cVar.S) {
                    cVar.U.post(aVar);
                }
            }
            aVar.run();
        }
    }

    public String h(String str) {
        String e2;
        StringBuilder sb;
        synchronized (this) {
            if ("screen_height".equals(str) && this.f35050a.e0() != 0.0f) {
                sb = new StringBuilder();
                sb.append(this.f35050a.e0());
                sb.append("");
            } else if (!"screen_width".equals(str) || this.f35050a.i0() == 0.0f) {
                d dVar = this.f35051b.get(str);
                if (dVar == null) {
                    dVar = new d(this.f35050a, str);
                    d(dVar);
                }
                e2 = dVar.e();
            } else {
                sb = new StringBuilder();
                sb.append(this.f35050a.i0());
                sb.append("");
            }
            e2 = sb.toString();
        }
        return e2;
    }
}
