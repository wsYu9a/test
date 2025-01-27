package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: classes4.dex */
public class bn implements be {

    /* renamed from: a */
    private boolean f23576a = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f23576a) {
            OpenIDSDK.a(context);
            this.f23576a = true;
        }
        boolean a10 = OpenIDSDK.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (a10) {
            return OpenIDSDK.c(context);
        }
        return null;
    }
}
