package com.jd.ad.sdk.jad_vg;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* loaded from: classes2.dex */
public class jad_fs implements jad_ly<Drawable, Drawable> {
    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Drawable drawable, @NonNull jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    @Nullable
    public jad_xk<Drawable> jad_an(@NonNull Drawable drawable, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        Drawable drawable2 = drawable;
        if (drawable2 != null) {
            return new jad_dq(drawable2);
        }
        return null;
    }
}
