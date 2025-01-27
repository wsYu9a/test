package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.a.f;
import h3.e;
import org.json.JSONException;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes4.dex */
public class c extends a.C0659a {

    /* renamed from: d */
    private String f23298d;

    public c(WebView webView, long j10, String str, String str2) {
        super(webView, j10, str);
        this.f23298d = str2;
    }

    private void b(String str) {
        WebView webView = this.f23133a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f23298d);
            stringBuffer.append("){");
            stringBuffer.append(this.f23298d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            f.a("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.a.C0659a
    public void a(Object obj) {
        f.a("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0659a
    public void a() {
        f.b("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0659a
    public void a(String str) {
        f.a("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(i.f29758c, !com.tencent.open.c.c.f23229a ? -4 : 0);
            jSONObject.put("sn", this.f23134b);
            jSONObject.put(e.f26408m, str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
