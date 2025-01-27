package com.vivo.mobilead.unified.nativead;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.vivo.mobilead.unified.base.callback.m;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: i */
    private static volatile f f30484i;

    /* renamed from: e */
    private int f30489e;

    /* renamed from: g */
    private com.vivo.mobilead.unified.base.view.s.d f30491g;

    /* renamed from: b */
    private AtomicBoolean f30486b = new AtomicBoolean(false);

    /* renamed from: c */
    private AtomicBoolean f30487c = new AtomicBoolean(false);

    /* renamed from: d */
    private Handler f30488d = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: f */
    private boolean f30490f = false;

    /* renamed from: h */
    private m<com.vivo.mobilead.unified.base.view.s.d> f30492h = new b();

    /* renamed from: a */
    private List<com.vivo.mobilead.unified.base.view.s.d> f30485a = new ArrayList();

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.d();
                return false;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.c();
            return false;
        }
    }

    class b implements m<com.vivo.mobilead.unified.base.view.s.d> {
        b() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.m
        /* renamed from: a */
        public void d(com.vivo.mobilead.unified.base.view.s.d dVar) {
            if (dVar.b()) {
                f.this.f30491g = dVar;
            }
            f.this.g();
        }

        @Override // com.vivo.mobilead.unified.base.callback.m
        /* renamed from: b */
        public void a(com.vivo.mobilead.unified.base.view.s.d dVar) {
            f.this.f30490f = true;
            if (!f.this.a() && dVar.b()) {
                f.this.f30491g = dVar;
            }
            f.this.g();
        }

        @Override // com.vivo.mobilead.unified.base.callback.m
        /* renamed from: c */
        public void b(com.vivo.mobilead.unified.base.view.s.d dVar) {
            f.this.f30490f = false;
            if (f.this.f30491g == null) {
                f.this.b();
                return;
            }
            f fVar = f.this;
            fVar.d(fVar.f30491g);
            f.this.f30491g = null;
        }

        @Override // com.vivo.mobilead.unified.base.callback.m
        /* renamed from: d */
        public void c(com.vivo.mobilead.unified.base.view.s.d dVar) {
            if (f.this.f30491g != null) {
                f fVar = f.this;
                fVar.d(fVar.f30491g);
                f.this.f30491g = null;
            }
        }
    }

    private f() {
    }

    public static f e() {
        if (f30484i == null) {
            synchronized (f.class) {
                if (f30484i == null) {
                    f30484i = new f();
                }
            }
        }
        return f30484i;
    }

    private void f() {
        Iterator<com.vivo.mobilead.unified.base.view.s.d> it = this.f30485a.iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                this.f30486b.set(true);
                return;
            }
        }
        this.f30486b.set(false);
    }

    public void g() {
        this.f30488d.sendEmptyMessage(2);
    }

    public void b(com.vivo.mobilead.unified.base.view.s.d dVar) {
        if (dVar != null) {
            if (this.f30491g == dVar) {
                this.f30491g = null;
            }
            this.f30485a.remove(dVar);
            dVar.setVideoViewCallback(null);
            f();
        }
    }

    public void c(com.vivo.mobilead.unified.base.view.s.d dVar) {
        if (dVar != null) {
            dVar.c();
            f();
        }
    }

    public void d(com.vivo.mobilead.unified.base.view.s.d dVar) {
        if (dVar != null) {
            this.f30486b.set(true);
            dVar.e();
            this.f30487c.set(false);
        }
    }

    public void c() {
        if (this.f30487c.get()) {
            return;
        }
        this.f30487c.set(true);
        for (com.vivo.mobilead.unified.base.view.s.d dVar : this.f30485a) {
            if (dVar != null) {
                dVar.c();
            }
        }
        this.f30486b.set(false);
    }

    public void a(com.vivo.mobilead.unified.base.view.s.d dVar) {
        if (dVar == null || this.f30485a.contains(dVar)) {
            return;
        }
        this.f30485a.add(dVar);
        dVar.setVideoViewCallback(this.f30492h);
    }

    public void d() {
        int a2;
        if (this.f30490f || this.f30486b.get()) {
            return;
        }
        this.f30486b.set(true);
        com.vivo.mobilead.unified.base.view.s.d dVar = null;
        int i2 = 10000000;
        int i3 = 0;
        for (com.vivo.mobilead.unified.base.view.s.d dVar2 : this.f30485a) {
            if (dVar2.isShown()) {
                if (dVar2.b()) {
                    dVar2.c();
                }
                if (a() && (a2 = y0.a((View) dVar2)) > 25 && a2 >= i3) {
                    int c2 = n.c(dVar2);
                    if (a2 > i3) {
                        dVar = dVar2;
                        i3 = a2;
                    } else if (c2 < i2) {
                        dVar = dVar2;
                    }
                    i2 = c2;
                }
            }
        }
        if (dVar != null) {
            dVar.e();
            this.f30486b.set(true);
            this.f30487c.set(false);
            return;
        }
        this.f30486b.set(false);
    }

    public boolean a() {
        int l = h0.K().l();
        boolean z = l == 100;
        boolean z2 = l != 0;
        int i2 = this.f30489e;
        return (i2 == 1 && z2) || (i2 == 0 && z);
    }

    public void b() {
        if (this.f30490f) {
            return;
        }
        this.f30488d.removeMessages(1);
        this.f30488d.sendEmptyMessage(1);
    }

    public void a(int i2) {
        this.f30489e = i2;
    }
}
