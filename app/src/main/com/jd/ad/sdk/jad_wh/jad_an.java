package com.jd.ad.sdk.jad_wh;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;
import java.io.File;

/* loaded from: classes2.dex */
public class jad_an implements jad_ly<File, File> {
    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull File file, @NonNull jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public jad_xk<File> jad_an(@NonNull File file, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        return new jad_bo(file);
    }
}
