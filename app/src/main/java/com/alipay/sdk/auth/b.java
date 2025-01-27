package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public class b {
    public static void a(Activity activity, a aVar) {
        if (r.c(activity)) {
            r.b(activity, "alipayauth://platformapi/startapp?appId=20000122&approveType=005&scope=kuaijie&productId=" + aVar.c() + "&thirdpartyId=" + aVar.a() + "&redirectUri=" + aVar.d());
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) AuthActivity.class);
        intent.putExtra("params", "app_id=" + aVar.a() + "&partner=" + aVar.b() + "&scope=kuaijie&login_goal=auth&redirect_url=" + aVar.d() + "&view=wap&prod_code=" + aVar.c());
        intent.putExtra("redirectUri", aVar.d());
        activity.startActivity(intent);
    }
}
