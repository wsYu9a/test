package com.ss.android.downloadlib.lg;

import java.lang.ref.SoftReference;

/* loaded from: classes4.dex */
public class i<P, R> implements Runnable {

    /* renamed from: g */
    private SoftReference<j<P, R>> f24328g;
    private i<R, ?> gv;

    /* renamed from: i */
    private int f24329i;

    /* renamed from: j */
    private P f24330j;
    private i<?, P> q;
    private R zx;

    public interface j<PARAM, RESULT> {
        RESULT j(PARAM param);
    }

    private i(int i2, j<P, R> jVar, P p) {
        this.f24329i = i2;
        this.f24328g = new SoftReference<>(jVar);
        this.f24330j = p;
    }

    public static <P, R> i<P, R> j(j<P, R> jVar, P p) {
        return new i<>(2, jVar, p);
    }

    private R zx() {
        return this.zx;
    }

    @Override // java.lang.Runnable
    public void run() {
        i<?, P> iVar;
        if (this.f24329i == 0 && !nt.j()) {
            com.ss.android.downloadlib.lg.j().zx().post(this);
            return;
        }
        if (this.f24329i == 1 && nt.j()) {
            com.ss.android.downloadlib.g.j().j(this);
            return;
        }
        if (this.f24329i == 2 && nt.j()) {
            com.ss.android.downloadlib.g.j().zx(this);
            return;
        }
        if (this.f24330j == null && (iVar = this.q) != null) {
            this.f24330j = iVar.zx();
        }
        j<P, R> jVar = this.f24328g.get();
        if (jVar == null) {
            return;
        }
        this.zx = jVar.j(this.f24330j);
        i<R, ?> iVar2 = this.gv;
        if (iVar2 != null) {
            iVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> i<R, NR> j(int i2, j<R, NR> jVar) {
        i iVar = (i<R, ?>) new i(i2, jVar, null);
        this.gv = iVar;
        iVar.q = this;
        return iVar;
    }

    public <NR> i<R, NR> j(j<R, NR> jVar) {
        return j(0, jVar);
    }

    public void j() {
        i<?, P> iVar = this.q;
        if (iVar != null) {
            iVar.j();
        } else {
            run();
        }
    }
}
