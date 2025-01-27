package com.jd.ad.sdk.jad_lu;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class jad_sf<V> {

    @Nullable
    public final V jad_an;

    @Nullable
    public final Throwable jad_bo;

    public jad_sf(V v10) {
        this.jad_an = v10;
        this.jad_bo = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jad_sf)) {
            return false;
        }
        jad_sf jad_sfVar = (jad_sf) obj;
        V v10 = this.jad_an;
        if (v10 != null && v10.equals(jad_sfVar.jad_an)) {
            return true;
        }
        Throwable th2 = this.jad_bo;
        if (th2 == null || jad_sfVar.jad_bo == null) {
            return false;
        }
        return th2.toString().equals(this.jad_bo.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.jad_an, this.jad_bo});
    }

    public jad_sf(Throwable th2) {
        this.jad_bo = th2;
        this.jad_an = null;
    }
}
