package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class jad_er implements com.jd.ad.sdk.jad_mx.jad_xk<Bitmap>, com.jd.ad.sdk.jad_mx.jad_tg {
    public final Bitmap jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_bo;

    public jad_er(@NonNull Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        this.jad_an = (Bitmap) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(bitmap, "Bitmap must not be null");
        this.jad_bo = (com.jd.ad.sdk.jad_ny.jad_er) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_erVar, "BitmapPool must not be null");
    }

    @Nullable
    public static jad_er jad_an(@Nullable Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        if (bitmap == null) {
            return null;
        }
        return new jad_er(bitmap, jad_erVar);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @NonNull
    public Bitmap get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @NonNull
    public Class<Bitmap> jad_cp() {
        return Bitmap.class;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
        this.jad_bo.jad_an(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        this.jad_an.prepareToDraw();
    }
}
