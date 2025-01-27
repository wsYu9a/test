package com.google.common.util.concurrent;

import b5.u;
import b5.z;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.Striped;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p5.w;
import p5.x0;

@a5.a
@a5.c
@p5.m
/* loaded from: classes2.dex */
public abstract class Striped<L> {

    /* renamed from: a */
    public static final int f10384a = 1024;

    /* renamed from: b */
    public static final int f10385b = -1;

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i10) {
            super(i10, false);
        }
    }

    public static class b<L> extends d<L> {

        /* renamed from: d */
        public final Object[] f10386d;

        public /* synthetic */ b(int i10, z zVar, a aVar) {
            this(i10, zVar);
        }

        @Override // com.google.common.util.concurrent.Striped
        public L j(int i10) {
            return (L) this.f10386d[i10];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int v() {
            return this.f10386d.length;
        }

        public b(int i10, z<L> zVar) {
            super(i10);
            int i11 = 0;
            u.e(i10 <= 1073741824, "Stripes must be <= 2^30)");
            this.f10386d = new Object[this.f10390c + 1];
            while (true) {
                Object[] objArr = this.f10386d;
                if (i11 >= objArr.length) {
                    return;
                }
                objArr[i11] = zVar.get();
                i11++;
            }
        }
    }

    @a5.d
    public static class c<L> extends d<L> {

        /* renamed from: d */
        public final ConcurrentMap<Integer, L> f10387d;

        /* renamed from: e */
        public final z<L> f10388e;

        /* renamed from: f */
        public final int f10389f;

        public c(int i10, z<L> zVar) {
            super(i10);
            int i11 = this.f10390c;
            this.f10389f = i11 == -1 ? Integer.MAX_VALUE : i11 + 1;
            this.f10388e = zVar;
            this.f10387d = new MapMaker().m().i();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L j(int i10) {
            if (this.f10389f != Integer.MAX_VALUE) {
                u.C(i10, v());
            }
            L l10 = this.f10387d.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10;
            }
            L l11 = this.f10388e.get();
            return (L) com.google.common.base.a.a(this.f10387d.putIfAbsent(Integer.valueOf(i10), l11), l11);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int v() {
            return this.f10389f;
        }
    }

    public static abstract class d<L> extends Striped<L> {

        /* renamed from: c */
        public final int f10390c;

        public d(int i10) {
            super();
            u.e(i10 > 0, "Stripes must be positive");
            this.f10390c = i10 > 1073741824 ? -1 : Striped.g(i10) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L i(Object obj) {
            return j(k(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int k(Object obj) {
            return Striped.w(obj.hashCode()) & this.f10390c;
        }
    }

    @a5.d
    public static class e<L> extends d<L> {

        /* renamed from: d */
        public final AtomicReferenceArray<a<? extends L>> f10391d;

        /* renamed from: e */
        public final z<L> f10392e;

        /* renamed from: f */
        public final int f10393f;

        /* renamed from: g */
        public final ReferenceQueue<L> f10394g;

        public static final class a<L> extends WeakReference<L> {

            /* renamed from: a */
            public final int f10395a;

            public a(L l10, int i10, ReferenceQueue<L> referenceQueue) {
                super(l10, referenceQueue);
                this.f10395a = i10;
            }
        }

        public e(int i10, z<L> zVar) {
            super(i10);
            this.f10394g = new ReferenceQueue<>();
            int i11 = this.f10390c;
            int i12 = i11 == -1 ? Integer.MAX_VALUE : i11 + 1;
            this.f10393f = i12;
            this.f10391d = new AtomicReferenceArray<>(i12);
            this.f10392e = zVar;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L j(int i10) {
            if (this.f10393f != Integer.MAX_VALUE) {
                u.C(i10, v());
            }
            a<? extends L> aVar = this.f10391d.get(i10);
            L l10 = aVar == null ? null : aVar.get();
            if (l10 != null) {
                return l10;
            }
            L l11 = this.f10392e.get();
            a aVar2 = new a(l11, i10, this.f10394g);
            while (!x0.a(this.f10391d, i10, aVar, aVar2)) {
                aVar = this.f10391d.get(i10);
                L l12 = aVar == null ? null : aVar.get();
                if (l12 != null) {
                    return l12;
                }
            }
            x();
            return l11;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int v() {
            return this.f10393f;
        }

        public final void x() {
            while (true) {
                Reference<? extends L> poll = this.f10394g.poll();
                if (poll == null) {
                    return;
                }
                a aVar = (a) poll;
                x0.a(this.f10391d, aVar.f10395a, aVar, null);
            }
        }
    }

    public static final class f extends p5.r {

        /* renamed from: a */
        public final Condition f10396a;

        /* renamed from: b */
        public final h f10397b;

        public f(Condition condition, h hVar) {
            this.f10396a = condition;
            this.f10397b = hVar;
        }

        @Override // p5.r
        public Condition a() {
            return this.f10396a;
        }
    }

    public static final class g extends w {

        /* renamed from: b */
        public final Lock f10398b;

        /* renamed from: c */
        public final h f10399c;

        public g(Lock lock, h hVar) {
            this.f10398b = lock;
            this.f10399c = hVar;
        }

        @Override // p5.w
        public Lock a() {
            return this.f10398b;
        }

        @Override // p5.w, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new f(this.f10398b.newCondition(), this.f10399c);
        }
    }

    public static final class h implements ReadWriteLock {

        /* renamed from: b */
        public final ReadWriteLock f10400b = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new g(this.f10400b.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new g(this.f10400b.writeLock(), this);
        }
    }

    public /* synthetic */ Striped(a aVar) {
        this();
    }

    public static int g(int i10) {
        return 1 << l5.f.p(i10, RoundingMode.CEILING);
    }

    public static <L> Striped<L> h(int i10, z<L> zVar) {
        return new b(i10, zVar);
    }

    public static /* synthetic */ Lock l() {
        return new ReentrantLock(false);
    }

    public static /* synthetic */ Semaphore m(int i10) {
        return new Semaphore(i10, false);
    }

    public static /* synthetic */ Semaphore n(int i10) {
        return new PaddedSemaphore(i10);
    }

    public static <L> Striped<L> o(int i10, z<L> zVar) {
        return i10 < 1024 ? new e(i10, zVar) : new c(i10, zVar);
    }

    public static Striped<Lock> p(int i10) {
        return o(i10, new z() { // from class: p5.v0
            @Override // b5.z
            public final Object get() {
                Lock l10;
                l10 = Striped.l();
                return l10;
            }
        });
    }

    public static Striped<ReadWriteLock> q(int i10) {
        return o(i10, new z() { // from class: p5.s0
            @Override // b5.z
            public final Object get() {
                return new Striped.h();
            }
        });
    }

    public static Striped<Semaphore> r(int i10, int i11) {
        return o(i10, new z() { // from class: p5.u0

            /* renamed from: b */
            public final /* synthetic */ int f29833b;

            public /* synthetic */ u0(int i112) {
                i11 = i112;
            }

            @Override // b5.z
            public final Object get() {
                Semaphore m10;
                m10 = Striped.m(i11);
                return m10;
            }
        });
    }

    public static Striped<Lock> s(int i10) {
        return h(i10, new z() { // from class: com.google.common.util.concurrent.t
            @Override // b5.z
            public final Object get() {
                return new Striped.PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> t(int i10) {
        return h(i10, new z() { // from class: p5.w0
            @Override // b5.z
            public final Object get() {
                return new ReentrantReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> u(int i10, int i11) {
        return h(i10, new z() { // from class: p5.t0

            /* renamed from: b */
            public final /* synthetic */ int f29831b;

            public /* synthetic */ t0(int i112) {
                i11 = i112;
            }

            @Override // b5.z
            public final Object get() {
                Semaphore n10;
                n10 = Striped.n(i11);
                return n10;
            }
        });
    }

    public static int w(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    public Iterable<L> f(Iterable<? extends Object> iterable) {
        ArrayList r10 = Lists.r(iterable);
        if (r10.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[r10.size()];
        for (int i10 = 0; i10 < r10.size(); i10++) {
            iArr[i10] = k(r10.get(i10));
        }
        Arrays.sort(iArr);
        int i11 = iArr[0];
        r10.set(0, j(i11));
        for (int i12 = 1; i12 < r10.size(); i12++) {
            int i13 = iArr[i12];
            if (i13 == i11) {
                r10.set(i12, r10.get(i12 - 1));
            } else {
                r10.set(i12, j(i13));
                i11 = i13;
            }
        }
        return Collections.unmodifiableList(r10);
    }

    public abstract L i(Object obj);

    public abstract L j(int i10);

    public abstract int k(Object obj);

    public abstract int v();

    public Striped() {
    }
}
