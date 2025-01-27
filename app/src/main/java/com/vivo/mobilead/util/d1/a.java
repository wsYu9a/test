package com.vivo.mobilead.util.d1;

import android.graphics.Color;
import com.vivo.mobilead.util.d1.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: f */
    private static final Comparator<b> f30569f = new C0666a();

    /* renamed from: a */
    final int[] f30570a;

    /* renamed from: b */
    final int[] f30571b;

    /* renamed from: c */
    final List<c.e> f30572c;

    /* renamed from: d */
    final c.InterfaceC0667c[] f30573d;

    /* renamed from: e */
    private final float[] f30574e = new float[3];

    /* renamed from: com.vivo.mobilead.util.d1.a$a */
    static class C0666a implements Comparator<b> {
        C0666a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    private class b {

        /* renamed from: a */
        private int f30575a;

        /* renamed from: b */
        private int f30576b;

        /* renamed from: c */
        private int f30577c;

        /* renamed from: d */
        private int f30578d;

        /* renamed from: e */
        private int f30579e;

        /* renamed from: f */
        private int f30580f;

        /* renamed from: g */
        private int f30581g;

        /* renamed from: h */
        private int f30582h;

        /* renamed from: i */
        private int f30583i;

        b(int i2, int i3) {
            this.f30575a = i2;
            this.f30576b = i3;
            c();
        }

        final boolean a() {
            return e() > 1;
        }

        final int b() {
            int f2 = f();
            a aVar = a.this;
            int[] iArr = aVar.f30570a;
            int[] iArr2 = aVar.f30571b;
            a.a(iArr, f2, this.f30575a, this.f30576b);
            Arrays.sort(iArr, this.f30575a, this.f30576b + 1);
            a.a(iArr, f2, this.f30575a, this.f30576b);
            int i2 = this.f30577c / 2;
            int i3 = 0;
            for (int i4 = this.f30575a; i4 <= this.f30576b; i4++) {
                i3 += iArr2[iArr[i4]];
                if (i3 >= i2) {
                    return i4;
                }
            }
            return this.f30575a;
        }

        final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f30570a;
            int[] iArr2 = aVar.f30571b;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.f30575a; i9 <= this.f30576b; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int f2 = a.f(i10);
                int e2 = a.e(i10);
                int d2 = a.d(i10);
                if (f2 > i5) {
                    i5 = f2;
                }
                if (f2 < i2) {
                    i2 = f2;
                }
                if (e2 > i6) {
                    i6 = e2;
                }
                if (e2 < i3) {
                    i3 = e2;
                }
                if (d2 > i7) {
                    i7 = d2;
                }
                if (d2 < i4) {
                    i4 = d2;
                }
            }
            this.f30578d = i2;
            this.f30579e = i5;
            this.f30580f = i3;
            this.f30581g = i6;
            this.f30582h = i4;
            this.f30583i = i7;
            this.f30577c = i8;
        }

        final c.e d() {
            int i2;
            int i3;
            a aVar = a.this;
            int[] iArr = aVar.f30570a;
            int[] iArr2 = aVar.f30571b;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = this.f30575a; i9 <= this.f30576b; i9++) {
                int i10 = iArr[i9];
                int i11 = iArr2[i10];
                i5 += i11;
                i8 += a.f(i10) * i11;
                i7 += a.e(i10) * i11;
                i6 += i11 * a.d(i10);
            }
            if (i5 != 0) {
                float f2 = i5;
                i4 = Math.round(i8 / f2);
                i2 = Math.round(i7 / f2);
                i3 = Math.round(i6 / f2);
            } else {
                i2 = 0;
                i3 = 0;
            }
            return new c.e(a.a(i4, i2, i3), i5);
        }

        final int e() {
            return (this.f30576b + 1) - this.f30575a;
        }

        final int f() {
            int i2 = this.f30579e - this.f30578d;
            int i3 = this.f30581g - this.f30580f;
            int i4 = this.f30583i - this.f30582h;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            return ((this.f30579e - this.f30578d) + 1) * ((this.f30581g - this.f30580f) + 1) * ((this.f30583i - this.f30582h) + 1);
        }

        final b h() {
            if (!a()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int b2 = b();
            b bVar = a.this.new b(b2 + 1, this.f30576b);
            this.f30576b = b2;
            c();
            return bVar;
        }
    }

    a(int[] iArr, int i2, c.InterfaceC0667c[] interfaceC0667cArr) {
        this.f30573d = interfaceC0667cArr;
        int[] iArr2 = new int[32768];
        this.f30571b = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int b2 = b(iArr[i3]);
            iArr[i3] = b2;
            iArr2[b2] = iArr2[b2] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && g(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.f30570a = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 > i2) {
            this.f30572c = c(i2);
            return;
        }
        this.f30572c = new ArrayList();
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = iArr3[i8];
            this.f30572c.add(new c.e(a(i9), iArr2[i9]));
        }
    }

    private static int b(int i2) {
        return b(Color.blue(i2), 8, 5) | (b(Color.red(i2), 8, 5) << 10) | (b(Color.green(i2), 8, 5) << 5);
    }

    public static int b(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    private List<c.e> c(int i2) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i2, f30569f);
        priorityQueue.offer(new b(0, this.f30570a.length - 1));
        a(priorityQueue, i2);
        return a(priorityQueue);
    }

    static int d(int i2) {
        return i2 & 31;
    }

    static int e(int i2) {
        return (i2 >> 5) & 31;
    }

    public static int f(int i2) {
        return (i2 >> 10) & 31;
    }

    private boolean g(int i2) {
        int a2 = a(i2);
        com.vivo.mobilead.util.d1.b.a(a2, this.f30574e);
        return a(a2, this.f30574e);
    }

    List<c.e> a() {
        return this.f30572c;
    }

    private void a(PriorityQueue<b> priorityQueue, int i2) {
        b poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    private List<c.e> a(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            c.e d2 = it.next().d();
            if (!a(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    static void a(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = d(i5) | (e(i5) << 10) | (f(i5) << 5);
                i3++;
            }
            return;
        }
        if (i2 != -1) {
            return;
        }
        while (i3 <= i4) {
            int i6 = iArr[i3];
            iArr[i3] = f(i6) | (d(i6) << 10) | (e(i6) << 5);
            i3++;
        }
    }

    private boolean a(c.e eVar) {
        return a(eVar.d(), eVar.b());
    }

    private boolean a(int i2, float[] fArr) {
        c.InterfaceC0667c[] interfaceC0667cArr = this.f30573d;
        if (interfaceC0667cArr != null && interfaceC0667cArr.length > 0) {
            int length = interfaceC0667cArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!this.f30573d[i3].a(i2, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int a(int i2, int i3, int i4) {
        return Color.rgb(b(i2, 5, 8), b(i3, 5, 8), b(i4, 5, 8));
    }

    private static int a(int i2) {
        return a(f(i2), e(i2), d(i2));
    }
}
