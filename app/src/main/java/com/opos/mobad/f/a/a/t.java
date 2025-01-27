package com.opos.mobad.f.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class t<T> {

    /* renamed from: a */
    private final int f20631a;

    /* renamed from: b */
    private int f20632b;

    /* renamed from: c */
    private final List<b<T>> f20633c;

    /* renamed from: d */
    private Set<Integer> f20634d;

    public static class a<T> {

        /* renamed from: a */
        private List<b<T>> f20635a = new ArrayList();

        /* renamed from: b */
        private int f20636b = 0;

        public t<T> a() {
            return new t<>(this.f20635a, this.f20636b);
        }

        public void a(T t, int i2) {
            if (i2 <= 0) {
                return;
            }
            this.f20635a.add(new b<>(t, i2));
            this.f20636b += i2;
        }
    }

    private static class b<T> {

        /* renamed from: a */
        private final int f20637a;

        /* renamed from: b */
        private final T f20638b;

        public b(T t, int i2) {
            this.f20638b = t;
            this.f20637a = i2;
        }
    }

    private t(List<b<T>> list, int i2) {
        this.f20633c = list;
        this.f20631a = i2;
        this.f20632b = i2;
        this.f20634d = new HashSet(list.size());
    }

    /* synthetic */ t(List list, int i2, AnonymousClass1 anonymousClass1) {
        this(list, i2);
    }

    public T a() {
        if (this.f20632b <= 0 || this.f20633c.size() <= 0 || this.f20634d.size() >= this.f20633c.size()) {
            return null;
        }
        double random = Math.random();
        double d2 = this.f20632b;
        Double.isNaN(d2);
        int i2 = (int) (random * d2);
        int i3 = 0;
        for (int i4 = 0; i4 < this.f20633c.size(); i4++) {
            if (!this.f20634d.contains(Integer.valueOf(i4))) {
                b<T> bVar = this.f20633c.get(i4);
                i3 += Math.max(0, ((b) bVar).f20637a);
                if (i2 <= i3) {
                    T t = (T) ((b) bVar).f20638b;
                    this.f20634d.add(Integer.valueOf(i4));
                    this.f20632b -= ((b) bVar).f20637a;
                    return t;
                }
            }
        }
        return null;
    }

    public void b() {
        this.f20632b = this.f20631a;
        this.f20634d.clear();
    }
}
