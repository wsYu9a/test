package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.martian.libmars.activity.WebViewActivity;

/* loaded from: classes3.dex */
public class MiWebViewBaseActivity extends WebViewActivity {
    public static void c4(Activity activity, String url, boolean downloadHint) {
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.Q, url);
        bundle.putBoolean(WebViewActivity.S, downloadHint);
        Intent intent = new Intent(activity, (Class<?>) MiWebViewBaseActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void h4(Activity activity, String url, String uid, String token, String appid, int requestCode) {
        Intent intent = new Intent(activity, (Class<?>) MiWebViewBaseActivity.class);
        String V2 = WebViewActivity.V2(url);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie(V2, "uid=" + uid);
        if (!com.martian.libsupport.k.p(token)) {
            cookieManager.setCookie(V2, "token=" + token);
        }
        if (!com.martian.libsupport.k.p(appid)) {
            cookieManager.setCookie(V2, "appid=" + appid);
        }
        if (com.martian.libsupport.l.s()) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.createInstance(activity);
            CookieSyncManager.getInstance().sync();
        }
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.Q, url);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override // com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.martian.mibook.lib.model.a.G1().H1().themeNoActionBar);
        super.onCreate(savedInstanceState);
    }
}
