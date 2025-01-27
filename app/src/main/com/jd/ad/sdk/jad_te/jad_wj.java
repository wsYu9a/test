package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class jad_wj implements com.jd.ad.sdk.jad_ju.jad_ly<Bitmap, Bitmap> {

    public static final class jad_an implements com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> {
        public final Bitmap jad_an;

        public jad_an(@NonNull Bitmap bitmap) {
            this.jad_an = bitmap;
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
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(@NonNull Bitmap bitmap, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new jad_an(bitmap);
    }
}
