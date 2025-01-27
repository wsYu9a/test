package com.jd.ad.sdk.jad_gr;

import com.jd.ad.sdk.jad_gr.jad_kx;

/* loaded from: classes2.dex */
public abstract class jad_kx<CHILD extends jad_kx<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public Object clone() {
        try {
            return (jad_kx) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final CHILD jad_an() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }
}
