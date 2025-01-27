package com.jd.ad.sdk.jad_qb;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_qb.jad_na;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class jad_xk<Data> implements jad_na<Uri, Data> {
    public static final Set<String> jad_bo = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final jad_na<jad_jt, Data> jad_an;

    public static class jad_an implements jad_ob<Uri, InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_xk(jad_reVar.jad_an(jad_jt.class, InputStream.class));
        }
    }

    public jad_xk(jad_na<jad_jt, Data> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(@NonNull Uri uri, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(new jad_jt(uri.toString(), jad_hu.jad_an), i10, i11, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return jad_bo.contains(uri.getScheme());
    }
}
