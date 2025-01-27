package com.jd.ad.sdk.jad_yj;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class jad_an implements jad_er<Bitmap, byte[]> {
    public final Bitmap.CompressFormat jad_an;

    public jad_an() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @Nullable
    public jad_xk<byte[]> jad_an(@NonNull jad_xk<Bitmap> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jad_xkVar.get().compress(this.jad_an, 100, byteArrayOutputStream);
        jad_xkVar.jad_dq();
        return new com.jd.ad.sdk.jad_uf.jad_bo(byteArrayOutputStream.toByteArray());
    }

    public jad_an(@NonNull Bitmap.CompressFormat compressFormat, int i10) {
        this.jad_an = compressFormat;
    }
}
