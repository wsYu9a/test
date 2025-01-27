package com.jd.ad.sdk.jad_yj;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* loaded from: classes2.dex */
public final class jad_cp implements jad_er<Drawable, byte[]> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final jad_er<Bitmap, byte[]> jad_bo;
    public final jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> jad_cp;

    public jad_cp(@NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar, @NonNull jad_er<Bitmap, byte[]> jad_erVar2, @NonNull jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> jad_erVar3) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_erVar2;
        this.jad_cp = jad_erVar3;
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @Nullable
    public jad_xk<byte[]> jad_an(@NonNull jad_xk<Drawable> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        Drawable drawable = jad_xkVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.jad_bo.jad_an(com.jd.ad.sdk.jad_te.jad_er.jad_an(((BitmapDrawable) drawable).getBitmap(), this.jad_an), jad_jwVar);
        }
        if (drawable instanceof com.jd.ad.sdk.jad_xi.jad_cp) {
            return this.jad_cp.jad_an(jad_xkVar, jad_jwVar);
        }
        return null;
    }
}
