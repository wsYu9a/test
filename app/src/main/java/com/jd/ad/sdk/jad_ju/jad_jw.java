package com.jd.ad.sdk.jad_ju;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.jd.ad.sdk.jad_ju.jad_iv;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class jad_jw implements jad_hu {
    public final ArrayMap<jad_iv<?>, Object> jad_bo = new com.jd.ad.sdk.jad_ir.jad_bo();

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_jw) {
            return this.jad_bo.equals(((jad_jw) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    public void jad_an(@NonNull jad_jw jad_jwVar) {
        this.jad_bo.putAll((SimpleArrayMap<? extends jad_iv<?>, ? extends Object>) jad_jwVar.jad_bo);
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Options{values=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }

    @Nullable
    public <T> T jad_an(@NonNull jad_iv<T> jad_ivVar) {
        return this.jad_bo.containsKey(jad_ivVar) ? (T) this.jad_bo.get(jad_ivVar) : jad_ivVar.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.jad_bo.size(); i10++) {
            jad_iv<?> keyAt = this.jad_bo.keyAt(i10);
            Object valueAt = this.jad_bo.valueAt(i10);
            jad_iv.jad_bo<?> jad_boVar = keyAt.jad_bo;
            if (keyAt.jad_dq == null) {
                keyAt.jad_dq = keyAt.jad_cp.getBytes(jad_hu.jad_an);
            }
            jad_boVar.jad_an(keyAt.jad_dq, valueAt, messageDigest);
        }
    }
}
