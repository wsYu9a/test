package com.shu.priory.utils.a.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a.a;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a */
    private Context f17284a;

    public g(Context context) {
        this.f17284a = context;
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            ContentProviderClient contentProviderClient = null;
            try {
                ContentProviderClient acquireContentProviderClient = this.f17284a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                if (acquireContentProviderClient != null) {
                    try {
                        Bundle call = acquireContentProviderClient.call("getOAID", null, null);
                        String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
                        if (interfaceC0558a != null) {
                            interfaceC0558a.a(string);
                        }
                    } catch (Throwable unused) {
                        contentProviderClient = acquireContentProviderClient;
                        if (contentProviderClient != null) {
                            contentProviderClient.release();
                        }
                    }
                }
                if (acquireContentProviderClient != null) {
                    acquireContentProviderClient.release();
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            com.shu.priory.utils.h.a(SDKConstants.TAG, "not support nubia oaid");
        }
    }
}
