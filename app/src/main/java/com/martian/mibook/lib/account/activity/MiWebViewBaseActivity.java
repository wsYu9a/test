package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import ba.l;
import ba.m;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.mibook.lib.model.BaseConfigSingleton;

/* loaded from: classes3.dex */
public class MiWebViewBaseActivity extends WebViewActivity {
    public static void E4(Activity activity, String str, String str2, String str3, String str4, int i10) {
        Intent intent = new Intent(activity, (Class<?>) MiWebViewBaseActivity.class);
        String A3 = WebViewActivity.A3(str);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie(A3, "uid=" + str2);
        if (!l.q(str3)) {
            cookieManager.setCookie(A3, "token=" + str3);
        }
        if (!l.q(str4)) {
            cookieManager.setCookie(A3, "appid=" + str4);
        }
        if (m.m()) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.createInstance(activity);
            CookieSyncManager.getInstance().sync();
        }
        Bundle bundle = new Bundle();
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i10);
    }

    @Override // com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(BaseConfigSingleton.r1().s1().themeNoActionBar);
        super.onCreate(bundle);
    }
}
