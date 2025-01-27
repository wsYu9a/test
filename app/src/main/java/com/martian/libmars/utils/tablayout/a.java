package com.martian.libmars.utils.tablayout;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f12493a = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<Float> f12494b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    public int f12495c;

    /* renamed from: d, reason: collision with root package name */
    public int f12496d;

    /* renamed from: e, reason: collision with root package name */
    public int f12497e;

    /* renamed from: f, reason: collision with root package name */
    public float f12498f;

    /* renamed from: g, reason: collision with root package name */
    public int f12499g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12500h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0521a f12501i;

    /* renamed from: com.martian.libmars.utils.tablayout.a$a, reason: collision with other inner class name */
    public interface InterfaceC0521a {
        void b(int i10, int i11);

        void c(int i10, int i11, float f10, boolean z10);

        void d(int i10, int i11);

        void e(int i10, int i11, float f10, boolean z10);
    }

    public final void a(int i10) {
        InterfaceC0521a interfaceC0521a = this.f12501i;
        if (interfaceC0521a != null) {
            interfaceC0521a.b(i10, this.f12495c);
        }
        this.f12493a.put(i10, true);
    }

    public final void b(int i10, float f10, boolean z10, boolean z11) {
        if (this.f12500h || i10 == this.f12496d || this.f12499g == 1 || z11) {
            InterfaceC0521a interfaceC0521a = this.f12501i;
            if (interfaceC0521a != null) {
                interfaceC0521a.c(i10, this.f12495c, f10, z10);
            }
            this.f12494b.put(i10, Float.valueOf(1.0f - f10));
        }
    }

    public final void c(int i10, float f10, boolean z10, boolean z11) {
        if (!this.f12500h && i10 != this.f12497e && this.f12499g != 1) {
            int i11 = this.f12496d;
            if (((i10 != i11 - 1 && i10 != i11 + 1) || this.f12494b.get(i10, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z11) {
                return;
            }
        }
        InterfaceC0521a interfaceC0521a = this.f12501i;
        if (interfaceC0521a != null) {
            interfaceC0521a.e(i10, this.f12495c, f10, z10);
        }
        this.f12494b.put(i10, Float.valueOf(f10));
    }

    public final void d(int i10) {
        InterfaceC0521a interfaceC0521a = this.f12501i;
        if (interfaceC0521a != null) {
            interfaceC0521a.d(i10, this.f12495c);
        }
        this.f12493a.put(i10, false);
    }

    public int e() {
        return this.f12496d;
    }

    public int f() {
        return this.f12499g;
    }

    public int g() {
        return this.f12495c;
    }

    public void h(int i10) {
        this.f12499g = i10;
    }

    public void i(int i10, float f10, int i11) {
        boolean z10;
        float f11 = i10 + f10;
        float f12 = this.f12498f;
        boolean z11 = f12 <= f11;
        if (this.f12499g == 0) {
            for (int i12 = 0; i12 < this.f12495c; i12++) {
                if (i12 != this.f12496d) {
                    if (!this.f12493a.get(i12)) {
                        a(i12);
                    }
                    if (this.f12494b.get(i12, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i12, 1.0f, false, true);
                    }
                }
            }
            b(this.f12496d, 1.0f, false, true);
            d(this.f12496d);
        } else {
            if (f11 == f12) {
                return;
            }
            int i13 = i10 + 1;
            if (f10 == 0.0f && z11) {
                i13 = i10 - 1;
                z10 = false;
            } else {
                z10 = true;
            }
            for (int i14 = 0; i14 < this.f12495c; i14++) {
                if (i14 != i10 && i14 != i13 && this.f12494b.get(i14, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i14, 1.0f, z11, true);
                }
            }
            if (!z10) {
                float f13 = 1.0f - f10;
                c(i13, f13, true, false);
                b(i10, f13, true, false);
            } else if (z11) {
                c(i10, f10, true, false);
                b(i13, f10, true, false);
            } else {
                float f14 = 1.0f - f10;
                c(i13, f14, false, false);
                b(i10, f14, false, false);
            }
        }
        this.f12498f = f11;
    }

    public void j(int i10) {
        this.f12497e = this.f12496d;
        this.f12496d = i10;
        d(i10);
        for (int i11 = 0; i11 < this.f12495c; i11++) {
            if (i11 != this.f12496d && !this.f12493a.get(i11)) {
                a(i11);
            }
        }
    }

    public void k(InterfaceC0521a interfaceC0521a) {
        this.f12501i = interfaceC0521a;
    }

    public void l(boolean z10) {
        this.f12500h = z10;
    }

    public void m(int i10) {
        this.f12495c = i10;
        this.f12493a.clear();
        this.f12494b.clear();
    }
}
