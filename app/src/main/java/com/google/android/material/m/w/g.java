package com.google.android.material.m.w;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
class g {

    /* renamed from: a */
    private static final f f7608a = new a();

    /* renamed from: b */
    private static final f f7609b = new b();

    static class a implements f {
        a() {
        }

        @Override // com.google.android.material.m.w.f
        public h a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float l = v.l(f5, f7, f3, f4, f2);
            float f9 = l / f5;
            float f10 = l / f7;
            return new h(f9, f10, l, f6 * f9, l, f8 * f10);
        }

        @Override // com.google.android.material.m.w.f
        public boolean b(h hVar) {
            return hVar.f7613d > hVar.f7615f;
        }

        @Override // com.google.android.material.m.w.f
        public void c(RectF rectF, float f2, h hVar) {
            rectF.bottom -= Math.abs(hVar.f7615f - hVar.f7613d) * f2;
        }
    }

    static class b implements f {
        b() {
        }

        @Override // com.google.android.material.m.w.f
        public h a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float l = v.l(f6, f8, f3, f4, f2);
            float f9 = l / f6;
            float f10 = l / f8;
            return new h(f9, f10, f5 * f9, l, f7 * f10, l);
        }

        @Override // com.google.android.material.m.w.f
        public boolean b(h hVar) {
            return hVar.f7612c > hVar.f7614e;
        }

        @Override // com.google.android.material.m.w.f
        public void c(RectF rectF, float f2, h hVar) {
            float abs = (Math.abs(hVar.f7614e - hVar.f7612c) / 2.0f) * f2;
            rectF.left += abs;
            rectF.right -= abs;
        }
    }

    private g() {
    }

    static f a(int i2, boolean z, RectF rectF, RectF rectF2) {
        if (i2 == 0) {
            return b(z, rectF, rectF2) ? f7608a : f7609b;
        }
        if (i2 == 1) {
            return f7608a;
        }
        if (i2 == 2) {
            return f7609b;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i2);
    }

    private static boolean b(boolean z, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f2 = (height2 * width) / width2;
        float f3 = (width2 * height) / width;
        if (z) {
            if (f2 >= height) {
                return true;
            }
        } else if (f3 >= height2) {
            return true;
        }
        return false;
    }
}
