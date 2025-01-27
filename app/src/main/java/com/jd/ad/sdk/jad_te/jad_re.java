package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_te.jad_ob;
import com.sigmob.sdk.videocache.h;
import ke.e;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class jad_re implements com.jd.ad.sdk.jad_ju.jad_ly<ParcelFileDescriptor, Bitmap> {
    public final jad_jw jad_an;

    public jad_re(jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    @Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new jad_ob.jad_cp(parcelFileDescriptor, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i10, i11, jad_jwVar, jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        String str = Build.MANUFACTURER;
        if ((!e.f27804b.equalsIgnoreCase(str) && !e.f27805c.equalsIgnoreCase(str)) || parcelFileDescriptor2.getStatSize() <= h.b.f20616f) {
            this.jad_an.getClass();
            if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
                return true;
            }
        }
        return false;
    }
}
