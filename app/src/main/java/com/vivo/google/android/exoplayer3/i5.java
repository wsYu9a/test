package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class i5 {

    /* renamed from: a */
    public final TrackGroupArray f27509a;

    /* renamed from: b */
    public final TrackSelectionArray f27510b;

    /* renamed from: c */
    public final Object f27511c;

    /* renamed from: d */
    public final h[] f27512d;

    public i5(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray, Object obj, h[] hVarArr) {
        this.f27509a = trackGroupArray;
        this.f27510b = trackSelectionArray;
        this.f27511c = obj;
        this.f27512d = hVarArr;
    }

    public boolean a(i5 i5Var, int i2) {
        return i5Var != null && Util.areEqual(this.f27510b.get(i2), i5Var.f27510b.get(i2)) && Util.areEqual(this.f27512d[i2], i5Var.f27512d[i2]);
    }
}
