package com.opos.mobad.provider.openId;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: classes4.dex */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c */
    private static final String f23138c = IdModel.class.getName();

    public a(Context context, IdModelIdentify idModelIdentify) {
        this.f23782a = context;
        this.f23783b = idModelIdentify;
    }

    @Override // com.opos.process.bridge.provider.a
    protected Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final OpenIdData a() throws c, b {
        return (OpenIdData) a(this.f23782a, f23138c, this.f23783b, 1, new Object[0]);
    }

    public final boolean b() throws c, b {
        return ((Boolean) a(this.f23782a, f23138c, this.f23783b, 2, new Object[0])).booleanValue();
    }

    public final String c() throws c, b {
        return (String) a(this.f23782a, f23138c, this.f23783b, 3, new Object[0]);
    }
}
