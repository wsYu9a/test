package com.opos.cmn.i;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public class b {
    public static final boolean a(Context context, Uri uri) {
        try {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            r0 = acquireContentProviderClient != null;
            if (acquireContentProviderClient != null) {
                acquireContentProviderClient.release();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("", "check provider", e2);
        }
        return r0;
    }
}
