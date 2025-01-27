package com.aggmoread.sdk.z.b.u;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static String f5041a = "com.aggmoread.sdk.a.adcomm.amsdk.AMAdVideoViewActivity";

    public static void a(Activity activity, Bundle bundle) {
        try {
            Intent intent = new Intent(activity, Class.forName(f5041a));
            intent.putExtra(h3.e.f26408m, bundle);
            activity.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void a(e eVar) {
        try {
            Class.forName(f5041a).getMethod("setActivityPresenter", e.class).invoke(null, eVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
