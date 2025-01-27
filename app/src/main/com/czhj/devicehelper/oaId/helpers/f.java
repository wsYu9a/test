package com.czhj.devicehelper.oaId.helpers;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a */
    public Context f8322a;

    public f(Context context) {
        this.f8322a = context;
    }

    public String a() {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.f8322a.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i10 >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString(b7.d.f1362o);
            return null;
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
            return null;
        }
    }
}
