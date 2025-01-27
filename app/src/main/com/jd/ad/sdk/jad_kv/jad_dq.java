package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface jad_dq<T> {

    public interface jad_an<T> {
        void jad_an(@NonNull Exception exc);

        void jad_an(@Nullable T t10);
    }

    @NonNull
    Class<T> jad_an();

    void jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @NonNull jad_an<? super T> jad_anVar);

    void jad_bo();

    void jad_cp();

    @NonNull
    com.jd.ad.sdk.jad_ju.jad_an jad_dq();
}
