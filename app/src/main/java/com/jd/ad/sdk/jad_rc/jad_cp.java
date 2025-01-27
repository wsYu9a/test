package com.jd.ad.sdk.jad_rc;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_lw.jad_cp;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.jad_qb.jad_ob;
import com.jd.ad.sdk.jad_qb.jad_re;
import com.jd.ad.sdk.jad_te.jad_xk;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: classes2.dex */
public class jad_cp implements jad_na<Uri, InputStream> {
    public final Context jad_an;

    public static class jad_an implements jad_ob<Uri, InputStream> {
        public final Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_cp(this.jad_an);
        }
    }

    public jad_cp(Context context) {
        this.jad_an = context.getApplicationContext();
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    @Nullable
    public jad_na.jad_an<InputStream> jad_an(@NonNull Uri uri, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        Long l10;
        Uri uri2 = uri;
        if (!com.jd.ad.sdk.jad_lw.jad_bo.jad_an(i10, i11) || (l10 = (Long) jad_jwVar.jad_an(jad_xk.jad_dq)) == null || l10.longValue() != -1) {
            return null;
        }
        com.jd.ad.sdk.jad_hq.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hq.jad_bo(uri2);
        Context context = this.jad_an;
        return new jad_na.jad_an<>(jad_boVar, Collections.emptyList(), com.jd.ad.sdk.jad_lw.jad_cp.jad_an(context, uri2, new jad_cp.jad_bo(context.getContentResolver())));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri) && uri.getPathSegments().contains("video");
    }
}
