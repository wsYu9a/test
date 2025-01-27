package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

@RequiresApi(api = 28)
/* loaded from: classes2.dex */
public final class jad_pc implements com.jd.ad.sdk.jad_ju.jad_ly<InputStream, Bitmap> {
    public final jad_dq jad_an = new jad_dq();

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(@NonNull InputStream inputStream, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(com.jd.ad.sdk.jad_ir.jad_an.jad_an(inputStream));
        return this.jad_an.jad_an2(createSource, i10, i11, jad_jwVar);
    }
}
