package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.logger.Logger;
import z3.a;

@RequiresApi(api = 28)
/* loaded from: classes2.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_ju.jad_ly<ImageDecoder.Source, Bitmap> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an = new com.jd.ad.sdk.jad_ny.jad_fs();

    /* renamed from: jad_an */
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an2(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new com.jd.ad.sdk.jad_sd.jad_an(i10, i11, jad_jwVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded [");
            jad_an.append(decodeBitmap.getWidth());
            jad_an.append("x");
            jad_an.append(decodeBitmap.getHeight());
            jad_an.append("] for [");
            jad_an.append(i10);
            jad_an.append("x");
            jad_an.append(i11);
            jad_an.append("]");
            Logger.v("BitmapImageDecoder", jad_an.toString());
        }
        return new jad_er(decodeBitmap, this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an2(a.a(source), i10, i11, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull ImageDecoder.Source source, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        a.a(source);
        return true;
    }
}
