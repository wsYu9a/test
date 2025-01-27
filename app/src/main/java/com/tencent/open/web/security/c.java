package com.tencent.open.web.security;

import android.webkit.WebView;
import com.martian.mibook.application.MiConfigSingleton;
import com.tencent.open.a;
import com.tencent.open.a.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c extends a.C0530a {

    /* renamed from: d */
    private String f25564d;

    public c(WebView webView, long j2, String str, String str2) {
        super(webView, j2, str);
        this.f25564d = str2;
    }

    private void b(String str) {
        WebView webView = this.f25404a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f25564d);
            stringBuffer.append("){");
            stringBuffer.append(this.f25564d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            f.a("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.a.C0530a
    public void a(Object obj) {
        f.a("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0530a
    public void a() {
        f.b("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0530a
    public void a(String str) {
        f.a("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.c.c.f25495a ? -4 : 0);
            jSONObject.put("sn", this.f25405b);
            jSONObject.put(MiConfigSingleton.t0, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
