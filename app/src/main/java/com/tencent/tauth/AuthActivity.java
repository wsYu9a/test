package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;

/* loaded from: classes4.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_KEY = "action";
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a */
    private static int f23299a;

    private void a(Uri uri) {
        f.c("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle a10 = i.a(uri2.substring(uri2.indexOf("#") + 1));
                if (a10 == null) {
                    f.d("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = a10.getString("action");
                f.c("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
                    if (string.equals("shareToQzone") && g.a(this, "com.tencent.mobileqq") != null && g.c(this, "5.2.0") < 0) {
                        int i10 = f23299a + 1;
                        f23299a = i10;
                        if (i10 == 2) {
                            f23299a = 0;
                            finish();
                            return;
                        }
                    }
                    f.c("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent = new Intent(this, (Class<?>) AssistActivity.class);
                    intent.putExtras(a10);
                    intent.setFlags(603979776);
                    startActivity(intent);
                    finish();
                    return;
                }
                if (string.equals("addToQQFavorites")) {
                    Intent intent2 = getIntent();
                    intent2.putExtras(a10);
                    intent2.putExtra(Constants.KEY_ACTION, "action_share");
                    IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                    if (listnerWithAction != null) {
                        UIListenerManager.getInstance().handleDataToListener(intent2, listnerWithAction);
                    }
                    finish();
                    return;
                }
                if (!string.equals(ACTION_SHARE_PRIZE)) {
                    finish();
                    return;
                }
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                try {
                    str = i.d(a10.getString("response")).getString("activityid");
                } catch (Exception e10) {
                    f.b("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e10);
                }
                if (!TextUtils.isEmpty(str)) {
                    launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                    Bundle bundle = new Bundle();
                    bundle.putString("activityid", str);
                    launchIntentForPackage.putExtras(bundle);
                }
                startActivity(launchIntentForPackage);
                finish();
                return;
            }
        }
        f.d("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri uri;
        super.onCreate(bundle);
        if (getIntent() == null) {
            f.d("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        try {
            uri = getIntent().getData();
        } catch (Exception e10) {
            f.e("openSDK_LOG.AuthActivity", "-->onCreate, getIntent().getData() has exception! " + e10.getMessage());
            uri = null;
        }
        f.a("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        a(uri);
    }
}
