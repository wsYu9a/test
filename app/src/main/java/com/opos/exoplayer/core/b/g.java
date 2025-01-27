package com.opos.exoplayer.core.b;

import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.b.f;
import java.lang.Exception;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a */
    private final Thread f17744a;

    /* renamed from: b */
    private final Object f17745b = new Object();

    /* renamed from: c */
    private final LinkedList<I> f17746c = new LinkedList<>();

    /* renamed from: d */
    private final LinkedList<O> f17747d = new LinkedList<>();

    /* renamed from: e */
    private final I[] f17748e;

    /* renamed from: f */
    private final O[] f17749f;

    /* renamed from: g */
    private int f17750g;

    /* renamed from: h */
    private int f17751h;

    /* renamed from: i */
    private I f17752i;

    /* renamed from: j */
    private E f17753j;
    private boolean k;
    private boolean l;
    private int m;

    /* renamed from: com.opos.exoplayer.core.b.g$1 */
    class AnonymousClass1 extends Thread {
        AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            g.this.k();
        }
    }

    protected g(I[] iArr, O[] oArr) {
        this.f17748e = iArr;
        this.f17750g = iArr.length;
        for (int i2 = 0; i2 < this.f17750g; i2++) {
            this.f17748e[i2] = g();
        }
        this.f17749f = oArr;
        this.f17751h = oArr.length;
        for (int i3 = 0; i3 < this.f17751h; i3++) {
            this.f17749f[i3] = h();
        }
        AnonymousClass1 anonymousClass1 = new Thread() { // from class: com.opos.exoplayer.core.b.g.1
            AnonymousClass1() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.k();
            }
        };
        this.f17744a = anonymousClass1;
        anonymousClass1.start();
    }

    private void b(I i2) {
        i2.a();
        I[] iArr = this.f17748e;
        int i3 = this.f17750g;
        this.f17750g = i3 + 1;
        iArr[i3] = i2;
    }

    private void b(O o) {
        o.a();
        O[] oArr = this.f17749f;
        int i2 = this.f17751h;
        this.f17751h = i2 + 1;
        oArr[i2] = o;
    }

    private void i() {
        E e2 = this.f17753j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void j() {
        if (m()) {
            this.f17745b.notify();
        }
    }

    public void k() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (l());
    }

    private boolean l() {
        synchronized (this.f17745b) {
            while (!this.l && !m()) {
                this.f17745b.wait();
            }
            if (!this.l) {
                I removeFirst = this.f17746c.removeFirst();
                O[] oArr = this.f17749f;
                int i2 = this.f17751h - 1;
                this.f17751h = i2;
                O o = oArr[i2];
                boolean z = this.k;
                this.k = false;
                if (removeFirst.c()) {
                    o.b(4);
                } else {
                    if (removeFirst.d_()) {
                        o.b(Integer.MIN_VALUE);
                    }
                    try {
                        this.f17753j = a(removeFirst, o, z);
                    } catch (OutOfMemoryError | RuntimeException e2) {
                        this.f17753j = a(e2);
                    }
                    if (this.f17753j != null) {
                        synchronized (this.f17745b) {
                        }
                    }
                }
                synchronized (this.f17745b) {
                    if (!this.k) {
                        if (o.d_()) {
                            this.m++;
                        } else {
                            o.f17743b = this.m;
                            this.m = 0;
                            this.f17747d.addLast(o);
                            b((g<I, O, E>) removeFirst);
                        }
                    }
                    b((g<I, O, E>) o);
                    b((g<I, O, E>) removeFirst);
                }
                return true;
            }
        }
        return false;
    }

    private boolean m() {
        return !this.f17746c.isEmpty() && this.f17751h > 0;
    }

    protected abstract E a(I i2, O o, boolean z);

    protected abstract E a(Throwable th);

    protected final void a(int i2) {
        com.opos.exoplayer.core.i.a.b(this.f17750g == this.f17748e.length);
        for (I i3 : this.f17748e) {
            i3.e(i2);
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public final void a(I i2) {
        synchronized (this.f17745b) {
            i();
            com.opos.exoplayer.core.i.a.a(i2 == this.f17752i);
            this.f17746c.addLast(i2);
            j();
            this.f17752i = null;
        }
    }

    protected void a(O o) {
        synchronized (this.f17745b) {
            b((g<I, O, E>) o);
            j();
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public final void c() {
        synchronized (this.f17745b) {
            this.k = true;
            this.m = 0;
            I i2 = this.f17752i;
            if (i2 != null) {
                b((g<I, O, E>) i2);
                this.f17752i = null;
            }
            while (!this.f17746c.isEmpty()) {
                b((g<I, O, E>) this.f17746c.removeFirst());
            }
            while (!this.f17747d.isEmpty()) {
                b((g<I, O, E>) this.f17747d.removeFirst());
            }
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
        synchronized (this.f17745b) {
            this.l = true;
            this.f17745b.notify();
        }
        try {
            this.f17744a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: e */
    public final I a() {
        I i2;
        synchronized (this.f17745b) {
            i();
            com.opos.exoplayer.core.i.a.b(this.f17752i == null);
            int i3 = this.f17750g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f17748e;
                int i4 = i3 - 1;
                this.f17750g = i4;
                i2 = iArr[i4];
            }
            this.f17752i = i2;
        }
        return i2;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: f */
    public final O b() {
        O removeFirst;
        synchronized (this.f17745b) {
            i();
            removeFirst = this.f17747d.isEmpty() ? null : this.f17747d.removeFirst();
        }
        return removeFirst;
    }

    protected abstract I g();

    protected abstract O h();
}
