package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import e5.t0;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
public final class q {

    public static class b {

        /* renamed from: a */
        public final MapMaker f9955a;

        /* renamed from: b */
        public boolean f9956b;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public <E> t0<E> a() {
            if (!this.f9956b) {
                this.f9955a.l();
            }
            return new d(this.f9955a);
        }

        public b b(int i10) {
            this.f9955a.a(i10);
            return this;
        }

        public b c() {
            this.f9956b = true;
            return this;
        }

        @a5.c("java.lang.ref.WeakReference")
        public b d() {
            this.f9956b = false;
            return this;
        }

        public b() {
            this.f9955a = new MapMaker();
            this.f9956b = true;
        }
    }

    public static class c<E> implements b5.n<E, E> {

        /* renamed from: b */
        public final t0<E> f9957b;

        public c(t0<E> t0Var) {
            this.f9957b = t0Var;
        }

        @Override // b5.n
        public E apply(E e10) {
            return this.f9957b.a(e10);
        }

        @Override // b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof c) {
                return this.f9957b.equals(((c) obj).f9957b);
            }
            return false;
        }

        public int hashCode() {
            return this.f9957b.hashCode();
        }
    }

    @a5.d
    public static final class d<E> implements t0<E> {

        /* renamed from: a */
        @a5.d
        public final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> f9958a;

        public /* synthetic */ d(MapMaker mapMaker, a aVar) {
            this(mapMaker);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.MapMakerInternalMap$i] */
        @Override // e5.t0
        public E a(E e10) {
            E e11;
            do {
                ?? entry = this.f9958a.getEntry(e10);
                if (entry != 0 && (e11 = (E) entry.getKey()) != null) {
                    return e11;
                }
            } while (this.f9958a.putIfAbsent(e10, MapMaker.Dummy.VALUE) != null);
            return e10;
        }

        public d(MapMaker mapMaker) {
            this.f9958a = MapMakerInternalMap.createWithDummyValues(mapMaker.h(Equivalence.equals()));
        }
    }

    public static <E> b5.n<E, E> a(t0<E> t0Var) {
        return new c((t0) b5.u.E(t0Var));
    }

    public static b b() {
        return new b();
    }

    public static <E> t0<E> c() {
        return b().c().a();
    }

    @a5.c("java.lang.ref.WeakReference")
    public static <E> t0<E> d() {
        return b().d().a();
    }
}
