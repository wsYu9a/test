package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes2.dex */
public class jad_bo implements com.jd.ad.sdk.jad_ju.jad_mz<BitmapDrawable> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_ju.jad_mz<Bitmap> jad_bo;

    public jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ju.jad_mz<Bitmap> jad_mzVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    @NonNull
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(@NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_bo.jad_an(jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public boolean jad_an(@NonNull Object obj, @NonNull File file, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_bo.jad_an(new jad_er(((BitmapDrawable) ((com.jd.ad.sdk.jad_mx.jad_xk) obj).get()).getBitmap(), this.jad_an), file, jad_jwVar);
    }
}
