package com.jd.ad.sdk.jad_kv;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class jad_ly<T> implements jad_dq<T> {
    public final Uri jad_an;
    public final ContentResolver jad_bo;
    public T jad_cp;

    public jad_ly(ContentResolver contentResolver, Uri uri) {
        this.jad_bo = contentResolver;
        this.jad_an = uri;
    }

    public abstract T jad_an(Uri uri, ContentResolver contentResolver);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public final void jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super T> jad_anVar) {
        try {
            T jad_an = jad_an(this.jad_an, this.jad_bo);
            this.jad_cp = jad_an;
            jad_anVar.jad_an((jad_dq.jad_an<? super T>) jad_an);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Logger.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            jad_anVar.jad_an((Exception) e10);
        }
    }

    public abstract void jad_an(T t10);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        T t10 = this.jad_cp;
        if (t10 != null) {
            try {
                jad_an(t10);
            } catch (IOException unused) {
            }
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
