package com.opos.exoplayer.core.c.d;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    public final int f17904a;

    /* renamed from: b */
    public final int f17905b;

    /* renamed from: c */
    public final long f17906c;

    /* renamed from: d */
    public final long f17907d;

    /* renamed from: e */
    public final long f17908e;

    /* renamed from: f */
    public final Format f17909f;

    /* renamed from: g */
    public final int f17910g;

    /* renamed from: h */
    @Nullable
    public final long[] f17911h;

    /* renamed from: i */
    @Nullable
    public final long[] f17912i;

    /* renamed from: j */
    public final int f17913j;

    @Nullable
    private final f[] k;

    public e(int i2, int i3, long j2, long j3, long j4, Format format, int i4, @Nullable f[] fVarArr, int i5, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f17904a = i2;
        this.f17905b = i3;
        this.f17906c = j2;
        this.f17907d = j3;
        this.f17908e = j4;
        this.f17909f = format;
        this.f17910g = i4;
        this.k = fVarArr;
        this.f17913j = i5;
        this.f17911h = jArr;
        this.f17912i = jArr2;
    }

    public f a(int i2) {
        f[] fVarArr = this.k;
        if (fVarArr == null) {
            return null;
        }
        return fVarArr[i2];
    }
}
