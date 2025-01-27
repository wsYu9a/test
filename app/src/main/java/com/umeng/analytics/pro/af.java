package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* loaded from: classes4.dex */
class af implements z {
    af() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a2 = OpenIdHelper.a();
        al.a("getOAID", "isSupported", Boolean.valueOf(a2));
        if (a2) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
