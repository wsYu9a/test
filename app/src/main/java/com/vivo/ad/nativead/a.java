package com.vivo.ad.nativead;

import android.content.Context;
import com.vivo.mobilead.nativead.NativeAdParams;

/* loaded from: classes4.dex */
public abstract class a extends com.vivo.ad.a {
    protected NativeAdListener n;

    public a(Context context, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(context, nativeAdParams);
        this.n = nativeAdListener;
    }

    @Override // com.vivo.ad.a
    protected String c() {
        return "4";
    }

    public abstract void e();
}
