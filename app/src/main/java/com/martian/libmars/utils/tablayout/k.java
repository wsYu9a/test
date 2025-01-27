package com.martian.libmars.utils.tablayout;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f10246a = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<Float> f10247b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private int f10248c;

    /* renamed from: d, reason: collision with root package name */
    private int f10249d;

    /* renamed from: e, reason: collision with root package name */
    private int f10250e;

    /* renamed from: f, reason: collision with root package name */
    private float f10251f;

    /* renamed from: g, reason: collision with root package name */
    private int f10252g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10253h;

    /* renamed from: i, reason: collision with root package name */
    private a f10254i;

    public interface a {
        void a(int index, int totalCount);

        void b(int index, int totalCount, float enterPercent, boolean leftToRight);

        void c(int index, int totalCount);

        void d(int index, int totalCount, float leavePercent, boolean leftToRight);
    }

    private void a(int index) {
        a aVar = this.f10254i;
        if (aVar != null) {
            aVar.a(index, this.f10248c);
        }
        this.f10246a.put(index, true);
    }

    private void b(int index, float enterPercent, boolean leftToRight, boolean force) {
        if (this.f10253h || index == this.f10249d || this.f10252g == 1 || force) {
            a aVar = this.f10254i;
            if (aVar != null) {
                aVar.b(index, this.f10248c, enterPercent, leftToRight);
            }
            this.f10247b.put(index, Float.valueOf(1.0f - enterPercent));
        }
    }

    private void c(int index, float leavePercent, boolean leftToRight, boolean force) {
        if (!this.f10253h && index != this.f10250e && this.f10252g != 1) {
            int i2 = this.f10249d;
            if (((index != i2 - 1 && index != i2 + 1) || this.f10247b.get(index, Float.valueOf(0.0f)).floatValue() == 1.0f) && !force) {
                return;
            }
        }
        a aVar = this.f10254i;
        if (aVar != null) {
            aVar.d(index, this.f10248c, leavePercent, leftToRight);
        }
        this.f10247b.put(index, Float.valueOf(leavePercent));
    }

    private void d(int index) {
        a aVar = this.f10254i;
        if (aVar != null) {
            aVar.c(index, this.f10248c);
        }
        this.f10246a.put(index, false);
    }

    public int e() {
        return this.f10249d;
    }

    public int f() {
        return this.f10252g;
    }

    public int g() {
        return this.f10248c;
    }

    public void h(int state) {
        this.f10252g = state;
    }

    public void i(int position, float positionOffset, int positionOffsetPixels) {
        boolean z;
        float f2 = position + positionOffset;
        float f3 = this.f10251f;
        boolean z2 = f3 <= f2;
        if (this.f10252g == 0) {
            for (int i2 = 0; i2 < this.f10248c; i2++) {
                if (i2 != this.f10249d) {
                    if (!this.f10246a.get(i2)) {
                        a(i2);
                    }
                    if (this.f10247b.get(i2, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i2, 1.0f, false, true);
                    }
                }
            }
            b(this.f10249d, 1.0f, false, true);
            d(this.f10249d);
        } else {
            if (f2 == f3) {
                return;
            }
            int i3 = position + 1;
            if (positionOffset == 0.0f && z2) {
                i3 = position - 1;
                z = false;
            } else {
                z = true;
            }
            for (int i4 = 0; i4 < this.f10248c; i4++) {
                if (i4 != position && i4 != i3 && this.f10247b.get(i4, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i4, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f4 = 1.0f - positionOffset;
                c(i3, f4, true, false);
                b(position, f4, true, false);
            } else if (z2) {
                c(position, positionOffset, true, false);
                b(i3, positionOffset, true, false);
            } else {
                float f5 = 1.0f - positionOffset;
                c(i3, f5, false, false);
                b(position, f5, false, false);
            }
        }
        this.f10251f = f2;
    }

    public void j(int position) {
        this.f10250e = this.f10249d;
        this.f10249d = position;
        d(position);
        for (int i2 = 0; i2 < this.f10248c; i2++) {
            if (i2 != this.f10249d && !this.f10246a.get(i2)) {
                a(i2);
            }
        }
    }

    public void k(a navigatorScrollListener) {
        this.f10254i = navigatorScrollListener;
    }

    public void l(boolean skimOver) {
        this.f10253h = skimOver;
    }

    public void m(int totalCount) {
        this.f10248c = totalCount;
        this.f10246a.clear();
        this.f10247b.clear();
    }
}
