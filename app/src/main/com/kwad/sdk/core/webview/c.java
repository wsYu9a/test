package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;

/* loaded from: classes3.dex */
public class c extends WebView {
    private boolean aIh;
    private com.kwad.sdk.core.webview.a.a aIi;

    public c(Context context) {
        super(bE(context));
        this.aIh = true;
        init();
    }

    private static Context bE(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dJ = m.dJ(context);
        if (m.dM(dJ)) {
            return dJ;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dJ.getClass().getName() + "--classloader:" + dJ.getClass().getClassLoader() + "--context2:" + m.dJ(ServiceProvider.MA()).getClass().getName()));
        return m.dJ(ServiceProvider.MA());
    }

    private void init() {
        by.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aIi = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aIh) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    public void setEnableDestroy(boolean z10) {
        this.aIh = z10;
    }

    public void setNeedHybridLoad(boolean z10) {
        this.aIi.setNeedHybridLoad(z10);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bE(context), attributeSet);
        this.aIh = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(bE(context), attributeSet, i10);
        this.aIh = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(bE(context), attributeSet, i10, i11);
        this.aIh = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i10, boolean z10) {
        super(bE(context), attributeSet, i10, z10);
        this.aIh = true;
        init();
    }
}
