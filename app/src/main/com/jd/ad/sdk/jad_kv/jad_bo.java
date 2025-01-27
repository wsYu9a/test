package com.jd.ad.sdk.jad_kv;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class jad_bo<T> implements jad_dq<T> {
    public final String jad_an;
    public final AssetManager jad_bo;
    public T jad_cp;

    public jad_bo(AssetManager assetManager, String str) {
        this.jad_bo = assetManager;
        this.jad_an = str;
    }

    public abstract T jad_an(AssetManager assetManager, String str);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super T> jad_anVar) {
        try {
            T jad_an = jad_an(this.jad_bo, this.jad_an);
            this.jad_cp = jad_an;
            jad_anVar.jad_an((jad_dq.jad_an<? super T>) jad_an);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Logger.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            jad_anVar.jad_an((Exception) e10);
        }
    }

    public abstract void jad_an(T t10);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        T t10 = this.jad_cp;
        if (t10 == null) {
            return;
        }
        try {
            jad_an(t10);
        } catch (IOException unused) {
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @NonNull
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
    }
}
