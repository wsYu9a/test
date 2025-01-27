package com.jd.ad.sdk.jad_qb;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.sigmob.sdk.base.k;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: classes2.dex */
public class jad_an<Data> implements jad_na<Uri, Data> {
    public final AssetManager jad_an;
    public final InterfaceC0346jad_an<Data> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_qb.jad_an$jad_an */
    public interface InterfaceC0346jad_an<Data> {
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_an(AssetManager assetManager, String str);
    }

    public static class jad_bo implements jad_ob<Uri, AssetFileDescriptor>, InterfaceC0346jad_an<AssetFileDescriptor> {
        public final AssetManager jad_an;

        public jad_bo(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0346jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<AssetFileDescriptor> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_kv.jad_hu(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public jad_na<Uri, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    public static class jad_cp implements jad_ob<Uri, InputStream>, InterfaceC0346jad_an<InputStream> {
        public final AssetManager jad_an;

        public jad_cp(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0346jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<InputStream> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_kv.jad_na(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    public jad_an(AssetManager assetManager, InterfaceC0346jad_an<Data> interfaceC0346jad_an) {
        this.jad_an = assetManager;
        this.jad_bo = interfaceC0346jad_an;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(@NonNull Uri uri, int i10, int i11, @NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        String substring = uri2.toString().substring(22);
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), Collections.emptyList(), this.jad_bo.jad_an(this.jad_an, substring));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        Uri uri2 = uri;
        return k.f18193y.equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
