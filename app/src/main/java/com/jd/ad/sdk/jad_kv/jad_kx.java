package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_er;
import com.jd.ad.sdk.jad_te.jad_sf;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class jad_kx implements jad_er<InputStream> {
    public final jad_sf jad_an;

    public static final class jad_an implements jad_er.jad_an<InputStream> {
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

        public jad_an(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @NonNull
        public Class<InputStream> jad_an() {
            return InputStream.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @NonNull
        public jad_er<InputStream> jad_an(InputStream inputStream) {
            return new jad_kx(inputStream, this.jad_an);
        }
    }

    public jad_kx(InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        jad_sf jad_sfVar = new jad_sf(inputStream, jad_boVar);
        this.jad_an = jad_sfVar;
        jad_sfVar.mark(5242880);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
        this.jad_an.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    @NonNull
    /* renamed from: jad_cp */
    public InputStream jad_an() {
        this.jad_an.reset();
        return this.jad_an;
    }
}
