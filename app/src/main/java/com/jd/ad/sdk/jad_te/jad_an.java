package com.jd.ad.sdk.jad_te;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class jad_an<DataType> implements com.jd.ad.sdk.jad_ju.jad_ly<DataType, BitmapDrawable> {
    public final com.jd.ad.sdk.jad_ju.jad_ly<DataType, Bitmap> jad_an;
    public final Resources jad_bo;

    public jad_an(@NonNull Resources resources, @NonNull com.jd.ad.sdk.jad_ju.jad_ly<DataType, Bitmap> jad_lyVar) {
        this.jad_bo = (Resources) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(resources);
        this.jad_an = (com.jd.ad.sdk.jad_ju.jad_ly) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_lyVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<BitmapDrawable> jad_an(@NonNull DataType datatype, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_qd.jad_an(this.jad_bo, this.jad_an.jad_an(datatype, i10, i11, jad_jwVar));
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@NonNull DataType datatype, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(datatype, jad_jwVar);
    }
}
