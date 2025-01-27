package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;

    /* renamed from: b */
    private static Tencent f23300b;

    /* renamed from: a */
    private final c f23301a;

    private Tencent(String str, Context context) {
        this.f23301a = c.a(str, context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            try {
                d.a(context.getApplicationContext());
                f.c("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
                Tencent tencent = f23300b;
                if (tencent == null) {
                    f23300b = new Tencent(str, context);
                } else if (!str.equals(tencent.getAppId())) {
                    f23300b.logout(context);
                    f23300b = new Tencent(str, context);
                }
                if (!a(context, str)) {
                    return null;
                }
                f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                return f23300b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleResultData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb2.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean onActivityResultData(int i10, int i11, Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onActivityResultData() reqcode = ");
        sb2.append(i10);
        sb2.append(", resultcode = ");
        sb2.append(i11);
        sb2.append(", data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb2.toString());
        return UIListenerManager.getInstance().onActivityResult(i10, i11, intent, iUiListener);
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "ask()");
        new SocialApi(this.f23301a.b()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "checkLogin()");
        this.f23301a.a(iUiListener);
    }

    public String getAccessToken() {
        return this.f23301a.b().getAccessToken();
    }

    public String getAppId() {
        return this.f23301a.b().getAppId();
    }

    public long getExpiresIn() {
        return this.f23301a.b().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.f23301a.b().getOpenId();
    }

    public QQToken getQQToken() {
        return this.f23301a.b();
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "gift()");
        new SocialApi(this.f23301a.b()).gift(activity, bundle, iUiListener);
        return 0;
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleLoginData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        f.c("openSDK_LOG.Tencent", sb2.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "invite()");
        new SocialApi(this.f23301a.b()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid() {
        return this.f23301a.c();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        if (i.e(activity) && g.a(activity, Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (g.a(activity, "com.tencent.mobileqq") == null) {
            return false;
        }
        return g.b(activity);
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f23301a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        return this.f23301a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.f23301a.a(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG.Tencent", "logout()");
        this.f23301a.b().setAccessToken(null, "0");
        this.f23301a.b().setOpenId(null);
    }

    public boolean onActivityResult(int i10, int i11, Intent intent) {
        f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.f23301a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.f23301a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        this.f23301a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        f.c("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.f23301a.b(), d.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.f23301a.b(), d.a(), str, bundle, str2, iRequestListener);
    }

    public void setAccessToken(String str, String str2) {
        f.a("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.f23301a.a(str, str2);
    }

    public void setOpenId(String str) {
        f.a("openSDK_LOG.Tencent", "setOpenId() --start");
        this.f23301a.a(d.a(), str);
        f.a("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.f23301a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.f23301a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "story()");
        new SocialApi(this.f23301a.b()).story(activity, bundle, iUiListener);
        return 0;
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f23301a.a(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        return this.f23301a.a(fragment, str + ",server_side", iUiListener, "");
    }
}
