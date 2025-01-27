package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.w;
import com.vivo.google.android.exoplayer3.x;
import java.lang.Exception;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public abstract class y<I extends w, O extends x, E extends Exception> implements v<I, O, E> {

    /* renamed from: a */
    public final Thread f28276a;

    /* renamed from: b */
    public final Object f28277b = new Object();

    /* renamed from: c */
    public final LinkedList<I> f28278c = new LinkedList<>();

    /* renamed from: d */
    public final LinkedList<O> f28279d = new LinkedList<>();

    /* renamed from: e */
    public final I[] f28280e;

    /* renamed from: f */
    public final O[] f28281f;

    /* renamed from: g */
    public int f28282g;

    /* renamed from: h */
    public int f28283h;

    /* renamed from: i */
    public I f28284i;

    /* renamed from: j */
    public E f28285j;
    public boolean k;
    public boolean l;
    public int m;

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            y yVar = y.this;
            yVar.getClass();
            do {
                try {
                } catch (InterruptedException e2) {
                    throw new IllegalStateException(e2);
                }
            } while (yVar.e());
        }
    }

    public y(I[] iArr, O[] oArr) {
        this.f28280e = iArr;
        this.f28282g = iArr.length;
        for (int i2 = 0; i2 < this.f28282g; i2++) {
            this.f28280e[i2] = c();
        }
        this.f28281f = oArr;
        this.f28283h = oArr.length;
        for (int i3 = 0; i3 < this.f28283h; i3++) {
            this.f28281f[i3] = d();
        }
        a aVar = new a();
        this.f28276a = aVar;
        aVar.start();
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public final I a() {
        I i2;
        synchronized (this.f28277b) {
            g();
            g1.b(this.f28284i == null);
            int i3 = this.f28282g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f28280e;
                int i4 = i3 - 1;
                this.f28282g = i4;
                i2 = iArr[i4];
            }
            this.f28284i = i2;
        }
        return i2;
    }

    public final void a(int i2) {
        g1.b(this.f28282g == this.f28280e.length);
        for (I i3 : this.f28280e) {
            i3.e(i2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public final void a(I i2) {
        synchronized (this.f28277b) {
            g();
            g1.a(i2 == this.f28284i);
            this.f28278c.addLast(i2);
            f();
            this.f28284i = null;
        }
    }

    public void a(O o) {
        synchronized (this.f28277b) {
            b((y<I, O, E>) o);
            f();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public final O b() {
        synchronized (this.f28277b) {
            g();
            if (this.f28279d.isEmpty()) {
                return null;
            }
            return this.f28279d.removeFirst();
        }
    }

    public final void b(I i2) {
        i2.b();
        I[] iArr = this.f28280e;
        int i3 = this.f28282g;
        this.f28282g = i3 + 1;
        iArr[i3] = i2;
    }

    public final void b(O o) {
        d4 d4Var = (d4) o;
        d4Var.f28074a = 0;
        d4Var.f27293c = null;
        O[] oArr = this.f28281f;
        int i2 = this.f28283h;
        this.f28283h = i2 + 1;
        oArr[i2] = o;
    }

    public abstract I c();

    public abstract O d();

    public final boolean e() {
        synchronized (this.f28277b) {
            while (!this.l) {
                if (!this.f28278c.isEmpty() && this.f28283h > 0) {
                    break;
                }
                this.f28277b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.f28278c.removeFirst();
            O[] oArr = this.f28281f;
            int i2 = this.f28283h - 1;
            this.f28283h = i2;
            O o = oArr[i2];
            boolean z = this.k;
            this.k = false;
            if (removeFirst.c(4)) {
                o.b(4);
            } else {
                if (removeFirst.c(Integer.MIN_VALUE)) {
                    o.b(Integer.MIN_VALUE);
                }
                w3 w3Var = (w3) this;
                c4 c4Var = (c4) removeFirst;
                d4 d4Var = (d4) o;
                try {
                    ByteBuffer byteBuffer = c4Var.f28192c;
                    y3 a2 = w3Var.a(byteBuffer.array(), byteBuffer.limit(), z);
                    long j2 = c4Var.f28193d;
                    long j3 = c4Var.f27257f;
                    d4Var.f28255b = j2;
                    d4Var.f27293c = a2;
                    if (j3 != Long.MAX_VALUE) {
                        j2 = j3;
                    }
                    d4Var.f27294d = j2;
                    d4Var.f28074a &= Integer.MAX_VALUE;
                    e = null;
                } catch (a4 e2) {
                    e = e2;
                }
                this.f28285j = e;
                if (e != null) {
                    synchronized (this.f28277b) {
                    }
                    return false;
                }
            }
            synchronized (this.f28277b) {
                if (this.k) {
                    b((y<I, O, E>) o);
                } else if (o.c(Integer.MIN_VALUE)) {
                    this.m++;
                    b((y<I, O, E>) o);
                } else {
                    this.m = 0;
                    this.f28279d.addLast(o);
                }
                b((y<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    public final void f() {
        if (!this.f28278c.isEmpty() && this.f28283h > 0) {
            this.f28277b.notify();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public final void flush() {
        synchronized (this.f28277b) {
            this.k = true;
            this.m = 0;
            I i2 = this.f28284i;
            if (i2 != null) {
                b((y<I, O, E>) i2);
                this.f28284i = null;
            }
            while (!this.f28278c.isEmpty()) {
                b((y<I, O, E>) this.f28278c.removeFirst());
            }
            while (!this.f28279d.isEmpty()) {
                b((y<I, O, E>) this.f28279d.removeFirst());
            }
        }
    }

    public final void g() {
        E e2 = this.f28285j;
        if (e2 != null) {
            throw e2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public void release() {
        synchronized (this.f28277b) {
            this.l = true;
            this.f28277b.notify();
        }
        try {
            this.f28276a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
