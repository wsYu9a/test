package com.jd.ad.sdk.jad_qz;

import androidx.annotation.RestrictTo;
import com.jd.ad.sdk.jad_sb.jad_pc;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class jad_dq {
    public final List<jad_pc> jad_an;
    public final char jad_bo;
    public final double jad_cp;
    public final String jad_dq;
    public final String jad_er;

    public jad_dq(List<jad_pc> list, char c10, double d10, double d11, String str, String str2) {
        this.jad_an = list;
        this.jad_bo = c10;
        this.jad_cp = d11;
        this.jad_dq = str;
        this.jad_er = str2;
    }

    public static int jad_an(char c10, String str, String str2) {
        return str2.hashCode() + ((str.hashCode() + (c10 * 31)) * 31);
    }

    public int hashCode() {
        return jad_an(this.jad_bo, this.jad_er, this.jad_dq);
    }
}
