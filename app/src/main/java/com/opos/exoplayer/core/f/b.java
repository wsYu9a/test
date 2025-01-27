package com.opos.exoplayer.core.f;

import android.graphics.Bitmap;
import android.text.Layout;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final CharSequence f18616a;

    /* renamed from: b */
    public final Layout.Alignment f18617b;

    /* renamed from: c */
    public final Bitmap f18618c;

    /* renamed from: d */
    public final float f18619d;

    /* renamed from: e */
    public final int f18620e;

    /* renamed from: f */
    public final int f18621f;

    /* renamed from: g */
    public final float f18622g;

    /* renamed from: h */
    public final int f18623h;

    /* renamed from: i */
    public final float f18624i;

    /* renamed from: j */
    public final float f18625j;
    public final boolean k;
    public final int l;

    public b(Bitmap bitmap, float f2, int i2, float f3, int i3, float f4, float f5) {
        this(null, null, bitmap, f3, 0, i3, f2, i2, f4, f5, false, -16777216);
    }

    public b(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, -16777216);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5) {
        this(charSequence, alignment, null, f2, i2, i3, f3, i4, f4, Float.MIN_VALUE, z, i5);
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, float f4, float f5, boolean z, int i5) {
        this.f18616a = charSequence;
        this.f18617b = alignment;
        this.f18618c = bitmap;
        this.f18619d = f2;
        this.f18620e = i2;
        this.f18621f = i3;
        this.f18622g = f3;
        this.f18623h = i4;
        this.f18624i = f4;
        this.f18625j = f5;
        this.k = z;
        this.l = i5;
    }
}
