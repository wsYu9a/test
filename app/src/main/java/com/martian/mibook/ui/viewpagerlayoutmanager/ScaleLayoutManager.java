package com.martian.mibook.ui.viewpagerlayoutmanager;

import android.content.Context;
import android.view.View;

/* loaded from: classes3.dex */
public class ScaleLayoutManager extends ViewPagerLayoutManager {
    public int G;
    public float H;
    public float I;
    public float J;
    public float K;

    public static class a {

        /* renamed from: j */
        public static final float f16138j = 0.8f;

        /* renamed from: k */
        public static final float f16139k = 1.0f;

        /* renamed from: l */
        public static final float f16140l = 1.0f;

        /* renamed from: m */
        public static final float f16141m = 1.0f;

        /* renamed from: a */
        public int f16142a;

        /* renamed from: b */
        public int f16143b = 0;

        /* renamed from: c */
        public float f16144c = 0.8f;

        /* renamed from: d */
        public float f16145d = 1.0f;

        /* renamed from: e */
        public float f16146e = 1.0f;

        /* renamed from: f */
        public float f16147f = 1.0f;

        /* renamed from: g */
        public boolean f16148g = false;

        /* renamed from: i */
        public int f16150i = Integer.MAX_VALUE;

        /* renamed from: h */
        public int f16149h = -1;

        public ScaleLayoutManager j(Context context) {
            return new ScaleLayoutManager(context, this);
        }

        public a k(int i10) {
            this.f16150i = i10;
            return this;
        }

        public a l(int i10) {
            this.f16142a = i10;
            return this;
        }

        public a m(float f10) {
            if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            this.f16146e = f10;
            return this;
        }

        public a n(int i10) {
            this.f16149h = i10;
            return this;
        }

        public a o(float f10) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            this.f16147f = f10;
            return this;
        }

        public a p(float f10) {
            this.f16144c = f10;
            return this;
        }

        public a q(float f10) {
            this.f16145d = f10;
            return this;
        }

        public a r(int i10) {
            this.f16143b = i10;
            return this;
        }

        public a s(boolean z10) {
            this.f16148g = z10;
            return this;
        }
    }

    public ScaleLayoutManager(Context context, int i10) {
        this(context, new a().l(i10));
    }

    @Override // com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager
    public float P() {
        return this.G + this.f16153c;
    }

    @Override // com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager
    public void Q(View view, float f10) {
        float Z = Z(this.f16156f + f10);
        float Y = Y(f10);
        view.setScaleX(Z);
        view.setScaleY(Z);
        view.setTranslationX(Y);
        float X = X(f10);
        if (view.getBackground() != null) {
            view.getBackground().setAlpha((int) (X * 255.0f));
        }
    }

    public final float X(float f10) {
        float abs = Math.abs(f10);
        float f11 = this.K;
        float f12 = this.J;
        float f13 = this.f16165o;
        return abs >= f13 ? f11 : (((f11 - f12) / f13) * abs) + f12;
    }

    public final float Y(float f10) {
        int i10 = (int) ((this.f16165o * (1.0f - this.H)) / 2.0f);
        float abs = Math.abs(f10);
        float f11 = this.f16165o;
        int i11 = (int) (abs / f11);
        float f12 = abs % f11;
        if (i11 == 0) {
            return 0.0f;
        }
        if (i11 != 1) {
            return f10 > 0.0f ? -i10 : i10;
        }
        float f13 = f12 / f11;
        return f10 > 0.0f ? (-f13) * i10 : f13 * i10;
    }

    public final float Z(float f10) {
        float abs = Math.abs(f10 - this.f16156f);
        int i10 = this.f16153c;
        if (abs - i10 > 0.0f) {
            abs = i10;
        }
        return 1.0f - ((abs / i10) * (1.0f - this.H));
    }

    public int a0() {
        return this.G;
    }

    public float b0() {
        return this.J;
    }

    public float c0() {
        return this.K;
    }

    public float d0() {
        return this.H;
    }

    public float e0() {
        return this.I;
    }

    public void f0(int i10) {
        assertNotInLayoutOrScroll(null);
        if (this.G == i10) {
            return;
        }
        this.G = i10;
        removeAllViews();
    }

    public void g0(float f10) {
        assertNotInLayoutOrScroll(null);
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (this.J == f10) {
            return;
        }
        this.J = f10;
        requestLayout();
    }

    public void h0(float f10) {
        assertNotInLayoutOrScroll(null);
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (this.K == f10) {
            return;
        }
        this.K = f10;
        requestLayout();
    }

    public void i0(float f10) {
        assertNotInLayoutOrScroll(null);
        if (this.H == f10) {
            return;
        }
        this.H = f10;
        removeAllViews();
    }

    public void j0(float f10) {
        assertNotInLayoutOrScroll(null);
        if (this.I == f10) {
            return;
        }
        this.I = f10;
    }

    @Override // com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager
    public float r() {
        float f10 = this.I;
        if (f10 == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f10;
    }

    public ScaleLayoutManager(Context context, int i10, int i11) {
        this(context, new a().l(i10).r(i11));
    }

    public ScaleLayoutManager(Context context, int i10, int i11, boolean z10) {
        this(context, new a().l(i10).r(i11).s(z10));
    }

    public ScaleLayoutManager(Context context, a aVar) {
        this(context, aVar.f16142a, aVar.f16144c, aVar.f16146e, aVar.f16147f, aVar.f16143b, aVar.f16145d, aVar.f16149h, aVar.f16150i, aVar.f16148g);
    }

    public ScaleLayoutManager(Context context, int i10, float f10, float f11, float f12, int i11, float f13, int i12, int i13, boolean z10) {
        super(context, i11, z10);
        M(i13);
        R(i12);
        this.G = i10;
        this.H = f10;
        this.I = f13;
        this.J = f11;
        this.K = f12;
    }
}
