package com.opos.exoplayer.core.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: a */
    private static final Comparator<a> f19058a = new Comparator<a>() { // from class: com.opos.exoplayer.core.i.q.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.f19067a - aVar2.f19067a;
        }
    };

    /* renamed from: b */
    private static final Comparator<a> f19059b = new Comparator<a>() { // from class: com.opos.exoplayer.core.i.q.2
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            float f2 = aVar.f19069c;
            float f3 = aVar2.f19069c;
            if (f2 < f3) {
                return -1;
            }
            return f3 < f2 ? 1 : 0;
        }
    };

    /* renamed from: c */
    private final int f19060c;

    /* renamed from: g */
    private int f19064g;

    /* renamed from: h */
    private int f19065h;

    /* renamed from: i */
    private int f19066i;

    /* renamed from: e */
    private final a[] f19062e = new a[5];

    /* renamed from: d */
    private final ArrayList<a> f19061d = new ArrayList<>();

    /* renamed from: f */
    private int f19063f = -1;

    /* renamed from: com.opos.exoplayer.core.i.q$1 */
    static final class AnonymousClass1 implements Comparator<a> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.f19067a - aVar2.f19067a;
        }
    }

    /* renamed from: com.opos.exoplayer.core.i.q$2 */
    static final class AnonymousClass2 implements Comparator<a> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            float f2 = aVar.f19069c;
            float f3 = aVar2.f19069c;
            if (f2 < f3) {
                return -1;
            }
            return f3 < f2 ? 1 : 0;
        }
    }

    private static class a {

        /* renamed from: a */
        public int f19067a;

        /* renamed from: b */
        public int f19068b;

        /* renamed from: c */
        public float f19069c;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public q(int i2) {
        this.f19060c = i2;
    }

    private void a() {
        if (this.f19063f != 1) {
            Collections.sort(this.f19061d, f19058a);
            this.f19063f = 1;
        }
    }

    private void b() {
        if (this.f19063f != 0) {
            Collections.sort(this.f19061d, f19059b);
            this.f19063f = 0;
        }
    }

    public float a(float f2) {
        b();
        float f3 = this.f19065h;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f19061d.size(); i3++) {
            a aVar = this.f19061d.get(i3);
            i2 += aVar.f19068b;
            if (i2 >= f2 * f3) {
                return aVar.f19069c;
            }
        }
        if (this.f19061d.isEmpty()) {
            return Float.NaN;
        }
        return this.f19061d.get(r7.size() - 1).f19069c;
    }

    public void a(int i2, float f2) {
        a aVar;
        int i3;
        a aVar2;
        int i4;
        a();
        int i5 = this.f19066i;
        if (i5 > 0) {
            a[] aVarArr = this.f19062e;
            int i6 = i5 - 1;
            this.f19066i = i6;
            aVar = aVarArr[i6];
        } else {
            aVar = new a();
        }
        int i7 = this.f19064g;
        this.f19064g = i7 + 1;
        aVar.f19067a = i7;
        aVar.f19068b = i2;
        aVar.f19069c = f2;
        this.f19061d.add(aVar);
        int i8 = this.f19065h + i2;
        while (true) {
            this.f19065h = i8;
            while (true) {
                int i9 = this.f19065h;
                int i10 = this.f19060c;
                if (i9 <= i10) {
                    return;
                }
                i3 = i9 - i10;
                aVar2 = this.f19061d.get(0);
                i4 = aVar2.f19068b;
                if (i4 <= i3) {
                    this.f19065h -= i4;
                    this.f19061d.remove(0);
                    int i11 = this.f19066i;
                    if (i11 < 5) {
                        a[] aVarArr2 = this.f19062e;
                        this.f19066i = i11 + 1;
                        aVarArr2[i11] = aVar2;
                    }
                }
            }
            aVar2.f19068b = i4 - i3;
            i8 = this.f19065h - i3;
        }
    }
}
