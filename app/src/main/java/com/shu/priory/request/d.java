package com.shu.priory.request;

import android.content.Context;
import android.content.Intent;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.param.AdParam;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class d {
    public static void a(Context context, String str, AdParam adParam, String str2, String str3, String str4, String str5) {
        h.a(SDKConstants.TAG, "openBrowser");
        Context applicationContext = context.getApplicationContext();
        try {
            Intent intent = new Intent(applicationContext, (Class<?>) IFLYBrowser.class);
            intent.putExtra("url_ad", str);
            intent.putExtra("is_show", adParam.getBooleanParam(AdKeys.DOWNLOAD_ALERT));
            intent.putExtra("ad_session_id", str2);
            intent.putExtra("close_url", str3);
            intent.putExtra("general_monitor_urls", str4);
            intent.putExtra("sjc", str5);
            intent.addFlags(268435456);
            applicationContext.startActivity(intent);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "openBrowser" + th2.getMessage());
        }
    }
}
