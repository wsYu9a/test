package com.vivo.google.android.exoplayer3;

import java.util.LinkedList;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public abstract class h4 implements z3 {

    /* renamed from: a */
    public final LinkedList<c4> f27480a = new LinkedList<>();

    /* renamed from: b */
    public final LinkedList<d4> f27481b;

    /* renamed from: c */
    public final TreeSet<c4> f27482c;

    /* renamed from: d */
    public c4 f27483d;

    /* renamed from: e */
    public long f27484e;

    public h4() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f27480a.add(new c4());
        }
        this.f27481b = new LinkedList<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f27481b.add(new i4(this));
        }
        this.f27482c = new TreeSet<>();
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public c4 a() {
        g1.b(this.f27483d == null);
        if (this.f27480a.isEmpty()) {
            return null;
        }
        c4 pollFirst = this.f27480a.pollFirst();
        this.f27483d = pollFirst;
        return pollFirst;
    }

    @Override // com.vivo.google.android.exoplayer3.z3
    public void a(long j2) {
        this.f27484e = j2;
    }

    public abstract void a(c4 c4Var);

    @Override // com.vivo.google.android.exoplayer3.v
    public d4 b() {
        if (!this.f27481b.isEmpty()) {
            while (!this.f27482c.isEmpty() && this.f27482c.first().f28193d <= this.f27484e) {
                c4 pollFirst = this.f27482c.pollFirst();
                if (pollFirst.c(4)) {
                    d4 pollFirst2 = this.f27481b.pollFirst();
                    pollFirst2.b(4);
                    b(pollFirst);
                    return pollFirst2;
                }
                a(pollFirst);
                if (d()) {
                    y3 c2 = c();
                    if (!pollFirst.c(Integer.MIN_VALUE)) {
                        d4 pollFirst3 = this.f27481b.pollFirst();
                        long j2 = pollFirst.f28193d;
                        pollFirst3.f28255b = j2;
                        pollFirst3.f27293c = c2;
                        pollFirst3.f27294d = j2;
                        b(pollFirst);
                        return pollFirst3;
                    }
                }
                b(pollFirst);
            }
        }
        return null;
    }

    public final void b(c4 c4Var) {
        c4Var.b();
        this.f27480a.add(c4Var);
    }

    public abstract y3 c();

    public abstract boolean d();

    @Override // com.vivo.google.android.exoplayer3.v
    public void flush() {
        this.f27484e = 0L;
        while (!this.f27482c.isEmpty()) {
            b(this.f27482c.pollFirst());
        }
        c4 c4Var = this.f27483d;
        if (c4Var != null) {
            b(c4Var);
            this.f27483d = null;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.v
    public void a(c4 c4Var) {
        c4 c4Var2 = c4Var;
        g1.a(c4Var2 != null);
        g1.a(c4Var2 == this.f27483d);
        if (c4Var2.c(Integer.MIN_VALUE)) {
            b(c4Var2);
        } else {
            this.f27482c.add(c4Var2);
        }
        this.f27483d = null;
    }
}
