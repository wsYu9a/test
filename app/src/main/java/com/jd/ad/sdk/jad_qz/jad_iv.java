package com.jd.ad.sdk.jad_qz;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.jd.ad.sdk.jad_lu.jad_zm;
import p3.f;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class jad_iv<T> {

    @Nullable
    public T jad_an;

    @Nullable
    public T jad_bo;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f10 = pair.first;
        Object obj2 = this.jad_an;
        if (f10 != obj2 && (f10 == 0 || !f10.equals(obj2))) {
            return false;
        }
        S s10 = pair.second;
        Object obj3 = this.jad_bo;
        return s10 == obj3 || (s10 != 0 && s10.equals(obj3));
    }

    public int hashCode() {
        T t10 = this.jad_an;
        int hashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.jad_bo;
        return hashCode ^ (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("Pair{");
        jad_an.append(this.jad_an);
        jad_an.append(" ");
        jad_an.append(this.jad_bo);
        jad_an.append(f.f29748d);
        return jad_an.toString();
    }
}
