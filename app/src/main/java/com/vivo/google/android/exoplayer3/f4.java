package com.vivo.google.android.exoplayer3;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.vivo.google.android.exoplayer3.text.Cue;

/* loaded from: classes4.dex */
public final class f4 extends Cue implements Comparable<f4> {

    /* renamed from: a */
    public final int f27416a;

    public f4(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5, int i6) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4, z, i5);
        this.f27416a = i6;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull f4 f4Var) {
        int i2 = f4Var.f27416a;
        int i3 = this.f27416a;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }
}
