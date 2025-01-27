package com.jd.ad.sdk.jad_te;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class jad_ly implements com.jd.ad.sdk.jad_ju.jad_na<Drawable> {
    public final com.jd.ad.sdk.jad_ju.jad_na<Bitmap> jad_bo;
    public final boolean jad_cp;

    public jad_ly(com.jd.ad.sdk.jad_ju.jad_na<Bitmap> jad_naVar, boolean z10) {
        this.jad_bo = jad_naVar;
        this.jad_cp = z10;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_ly) {
            return this.jad_bo.equals(((jad_ly) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_na
    @NonNull
    public com.jd.ad.sdk.jad_mx.jad_xk<Drawable> jad_an(@NonNull Context context, @NonNull com.jd.ad.sdk.jad_mx.jad_xk<Drawable> jad_xkVar, int i10, int i11) {
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_an;
        Drawable drawable = jad_xkVar.get();
        com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an = jad_kx.jad_an(jad_erVar, drawable, i10, i11);
        if (jad_an != null) {
            com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an2 = this.jad_bo.jad_an(context, jad_an, i10, i11);
            if (!jad_an2.equals(jad_an)) {
                return jad_qd.jad_an(context.getResources(), jad_an2);
            }
            jad_an2.jad_dq();
            return jad_xkVar;
        }
        if (!this.jad_cp) {
            return jad_xkVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }
}
