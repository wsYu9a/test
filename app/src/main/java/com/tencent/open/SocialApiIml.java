package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: c */
    private Activity f25369c;

    private class a implements IUiListener {

        /* renamed from: b */
        private IUiListener f25371b;

        /* renamed from: c */
        private String f25372c;

        /* renamed from: d */
        private String f25373d;

        /* renamed from: e */
        private Bundle f25374e;

        /* renamed from: f */
        private Activity f25375f;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f25371b = iUiListener;
            this.f25372c = str;
            this.f25373d = str2;
            this.f25374e = bundle;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f25371b.onCancel();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e2) {
                e2.printStackTrace();
                f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                str = null;
            }
            this.f25374e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f25369c, this.f25372c, this.f25374e, this.f25373d, this.f25371b);
            if (TextUtils.isEmpty(str)) {
                f.b("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f25375f);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f25371b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    protected Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (i.e(d.a()) && g.a(d.a(), intent3)) {
            return intent3;
        }
        if (g.a(d.a(), intent2) && g.c(d.a(), "4.7") >= 0) {
            return intent2;
        }
        if (g.a(d.a(), intent) && g.a(g.a(d.a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && g.a(d.a(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            return intent;
        }
        return null;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f25369c = activity;
        Intent c2 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c2 == null) {
            f.c("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c2 = c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, c2, SocialConstants.ACTION_INVITE, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f25369c = activity;
        Intent c2 = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, c2, SocialConstants.ACTION_STORY, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.f25282b.getAccessToken();
        String appId = this.f25282b.getAppId();
        String openId = this.f25282b.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = i.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        String str2 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f25282b.getOpenId() + "_" + this.f25282b.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>";
        String a2 = com.tencent.open.utils.f.a().a(context, "http://qzs.qq.com");
        bVar.loadDataWithBaseURL(a2, str2, "text/html", "utf-8", a2);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f25369c = activity;
        Intent c2 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c2 == null) {
            f.c("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c2 = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = c2;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", "request");
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        f.c("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        e a2 = e.a(d.a(), this.f25282b.getAppId());
        if (!z && !a2.b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent b2 = b("com.tencent.open.agent.AgentActivity");
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b3 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b3 != null && b2 != null && b2.getComponent() != null && b3.getComponent() != null && b2.getComponent().getPackageName().equals(b3.getComponent().getPackageName())) {
            b3.putExtra("oauth_consumer_key", this.f25282b.getAppId());
            b3.putExtra("openid", this.f25282b.getOpenId());
            b3.putExtra(Constants.PARAM_ACCESS_TOKEN, this.f25282b.getAccessToken());
            b3.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (a(b3)) {
                f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity, b3, Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String f2 = i.f("tencent&sdk&qazxc***14969%%" + this.f25282b.getAccessToken() + this.f25282b.getAppId() + this.f25282b.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, f2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.a("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f25282b.getAppId());
        if (this.f25282b.isSessionValid()) {
            bundle.putString(Constants.PARAM_ACCESS_TOKEN, this.f25282b.getAccessToken());
        }
        String openId = this.f25282b.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, d.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Exception e2) {
            e2.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f25369c, str, str3, iUiListener, this.f25282b).show();
        } else {
            f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.f25369c, str, str3, iUiListener, this.f25282b).show();
        }
    }
}
