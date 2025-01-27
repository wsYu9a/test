package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@p5.m
/* loaded from: classes2.dex */
public abstract class g<OutputT> extends AbstractFuture.i<OutputT> {

    /* renamed from: d */
    public static final b f10480d;

    /* renamed from: e */
    public static final Logger f10481e = Logger.getLogger(g.class.getName());

    /* renamed from: b */
    @CheckForNull
    public volatile Set<Throwable> f10482b = null;

    /* renamed from: c */
    public volatile int f10483c;

    public static abstract class b {
        public b() {
        }

        public abstract void a(g<?> gVar, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(g<?> gVar);

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class c extends b {

        /* renamed from: a */
        public final AtomicReferenceFieldUpdater<g<?>, Set<Throwable>> f10484a;

        /* renamed from: b */
        public final AtomicIntegerFieldUpdater<g<?>> f10485b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f10484a = atomicReferenceFieldUpdater;
            this.f10485b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.g.b
        public void a(g<?> gVar, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            k.a.a(this.f10484a, gVar, set, set2);
        }

        @Override // com.google.common.util.concurrent.g.b
        public int b(g<?> gVar) {
            return this.f10485b.decrementAndGet(gVar);
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        @Override // com.google.common.util.concurrent.g.b
        public void a(g<?> gVar, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (gVar) {
                try {
                    if (gVar.f10482b == set) {
                        gVar.f10482b = set2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.g.b
        public int b(g<?> gVar) {
            int p10;
            synchronized (gVar) {
                p10 = g.p(gVar);
            }
            return p10;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        b dVar;
        Throwable th2 = null;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(g.class, Set.class, "b"), AtomicIntegerFieldUpdater.newUpdater(g.class, "c"));
        } catch (Throwable th3) {
            dVar = new d();
            th2 = th3;
        }
        f10480d = dVar;
        if (th2 != null) {
            f10481e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    public g(int i10) {
        this.f10483c = i10;
    }

    public static /* synthetic */ int p(g gVar) {
        int i10 = gVar.f10483c - 1;
        gVar.f10483c = i10;
        return i10;
    }

    public abstract void q(Set<Throwable> set);

    public final void r() {
        this.f10482b = null;
    }

    public final int s() {
        return f10480d.b(this);
    }

    public final Set<Throwable> t() {
        Set<Throwable> set = this.f10482b;
        if (set != null) {
            return set;
        }
        Set<Throwable> p10 = Sets.p();
        q(p10);
        f10480d.a(this, null, p10);
        Set<Throwable> set2 = this.f10482b;
        Objects.requireNonNull(set2);
        return set2;
    }
}
