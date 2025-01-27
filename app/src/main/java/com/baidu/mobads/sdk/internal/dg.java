package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class dg extends bi {

    /* renamed from: a */
    private WebView f7163a;

    /* renamed from: t */
    private BaiduHybridAdViewListener f7164t;

    /* renamed from: u */
    private IXHybridAdRenderer f7165u;

    public dg(WebView webView) {
        super(webView.getContext());
        this.f7163a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f7163a.removeJavascriptInterface("accessibility");
        this.f7163a.removeJavascriptInterface("accessibilityTraversal");
        this.f7163a.getSettings().setAllowContentAccess(false);
        this.f7163a.getSettings().setSavePassword(false);
        this.f7163a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f7164t = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f7165u;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) au.a(z.f7382j, bs.a(this.f6880i), (Class<?>[]) new Class[]{Context.class}, this.f6880i);
        this.f7165u = iXHybridAdRenderer;
        this.f6884m = iXHybridAdRenderer;
        if (this.f6885n) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f7164t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f7165u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f7165u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i10, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f7165u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i10, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f7164t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f7165u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.f7165u == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.f7165u.createProdHandler(jSONObject3);
            m();
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        this.f7165u.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(IOAdEvent iOAdEvent) {
        this.f7165u.setCustomerWebView(this.f7163a);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        super.a(str, i10, str2);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f7164t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }
}
