package com.martian.ttbook.b.c.a.a.b.a.d.a.c;

import android.app.Activity;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.qumeng.advlib.core.IMultiAdObject;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class c extends com.martian.ttbook.b.c.a.a.b.a.d.e {
    private String m;
    private IMultiAdObject n;
    private com.martian.ttbook.b.c.a.a.d.b.m.a o;
    private AtomicBoolean p;
    private com.martian.ttbook.b.c.a.a.c.l.a q;

    class a implements IMultiAdObject.MediaStateListener {
        a() {
        }

        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoCompleted");
            if (c.this.q != null) {
                c.this.q.h(c.this);
            }
        }

        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoPause");
            if (c.this.q != null) {
                c.this.q.e(c.this);
            }
        }

        public void c() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoReady");
            if (c.this.q != null) {
                c.this.q.k(c.this, -1L);
            }
        }

        public void d() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoResume");
        }

        public void e() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoStart");
            if (c.this.q != null) {
                c.this.q.b(c.this);
            }
        }

        public void f() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onVideoStop");
            if (c.this.q != null) {
                c.this.q.e(c.this);
            }
        }
    }

    class b implements IMultiAdObject.ADEventListener {
        b() {
        }

        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onADExposed");
            c.this.f15215f = System.currentTimeMillis();
            l.i(c.this.f15218j, true, true);
            if (c.this.l()) {
                c cVar = c.this;
                new k(cVar.f15212c, cVar.f15213d).a(5).c(k.b.n, c.this.f15210a).h();
                c cVar2 = c.this;
                com.martian.ttbook.b.c.a.a.c.e eVar = cVar2.f15212c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                    ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).c(cVar2);
                }
            }
        }

        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, IAdInterListener.AdCommandType.AD_CLICK);
            c cVar = c.this;
            k kVar = new k(cVar.f15212c, cVar.f15213d);
            k c2 = kVar.c(k.b.n, c.this.f15210a);
            c cVar2 = c.this;
            com.martian.ttbook.b.c.a.a.d.b.e eVar = cVar2.f15213d;
            com.martian.ttbook.b.c.a.a.d.b.m.a i2 = cVar2.i();
            c cVar3 = c.this;
            boolean g2 = c2.g(eVar, i2, cVar3.f15215f, cVar3.f15218j);
            kVar.h();
            l.i(c.this.f15218j, false, true);
            if (g2) {
                c cVar4 = c.this;
                com.martian.ttbook.b.c.a.a.c.e eVar2 = cVar4.f15212c.f15673g;
                if (eVar2 instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                    ((com.martian.ttbook.b.c.a.a.c.l.c) eVar2).i(cVar4);
                }
            }
        }

        public void c(String str) {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onAdFailed " + str);
            c cVar = c.this;
            com.martian.ttbook.b.c.a.a.c.e eVar = cVar.f15212c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).b(cVar);
            }
        }
    }

    public c(IMultiAdObject iMultiAdObject, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.m = "QMUNITAG";
        this.p = new AtomicBoolean();
        this.n = iMultiAdObject;
        com.martian.ttbook.b.c.a.a.b.a.d.a.b.g(this.l, com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(iMultiAdObject), eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        IMultiAdObject iMultiAdObject = this.n;
        if (iMultiAdObject != null) {
            iMultiAdObject.destroy();
            this.n = null;
            this.o = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView");
        if (this.o == null) {
            this.o = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView " + this.o);
        return this.o;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "ac " + this.o);
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.o;
        return aVar != null ? aVar : super.i();
    }

    public boolean l() {
        return this.p.compareAndSet(false, true);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render");
        if (this.n == null) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render failed");
            return;
        }
        if (this.o != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render enter ");
            this.n.setOnMediaStateListener(new a());
            this.n.bindView(this.o, new b());
            l.c(this.o, this.f15218j);
            l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, this.o, new View[0], new WeakReference(this.o), null);
            l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
            byte[] h2 = this.f15212c.r.h();
            if (h2 != null) {
                l.j(this.f15212c.f15668b, h2);
            }
        }
    }
}
