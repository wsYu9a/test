package com.kwad.sdk.core.e.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class g {
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i10 >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                call.getString(b7.d.f1362o);
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
