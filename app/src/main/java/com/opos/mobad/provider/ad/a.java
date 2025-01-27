package com.opos.mobad.provider.ad;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.c;

/* loaded from: classes4.dex */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c */
    private static final String f23122c = AdCacheModel.class.getName();

    public a(Context context) {
        this.f23782a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    protected Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final AdEntity a(String str) throws c, com.opos.process.bridge.provider.b {
        return (AdEntity) a(this.f23782a, f23122c, this.f23783b, 2, str);
    }

    public final void a(String str, AdEntity adEntity) throws c, com.opos.process.bridge.provider.b {
        b(this.f23782a, f23122c, this.f23783b, 1, str, adEntity);
    }
}
