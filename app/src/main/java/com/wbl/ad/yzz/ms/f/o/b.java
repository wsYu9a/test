package com.wbl.ad.yzz.ms.f.o;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class b extends WebViewClient {

    /* renamed from: a */
    public Context f33293a;

    public b(Context context) {
        this.f33293a = context;
    }

    public static b a(Context context) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11385, null, context);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11388, this, webView, str);
    }
}
