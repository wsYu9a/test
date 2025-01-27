package com.opos.exoplayer.core.f.a;

import android.text.Layout;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
final class d extends com.opos.exoplayer.core.f.b implements Comparable<d> {
    public final int m;

    public d(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5, int i6) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4, z, i5);
        this.m = i6;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull d dVar) {
        int i2 = dVar.m;
        int i3 = this.m;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }
}
