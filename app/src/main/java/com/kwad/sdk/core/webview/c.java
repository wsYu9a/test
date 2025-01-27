package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* loaded from: classes2.dex */
public class c extends WebView {
    private boolean apu;
    private com.kwad.sdk.core.webview.kwai.a apv;

    public c(Context context) {
        super(be(context));
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(be(context), attributeSet);
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(be(context), attributeSet, i2);
        this.apu = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(be(context), attributeSet, i2, i3);
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(be(context), attributeSet, i2, z);
        this.apu = true;
        init();
    }

    private static Context be(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21 && i2 < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dl = k.dl(context);
        if (k.m62do(dl)) {
            return dl;
        }
        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dl.getClass().getName() + "--classloader:" + dl.getClass().getClassLoader() + "--context2:" + k.dl(ServiceProvider.CA()).getClass().getName()));
        return k.dl(ServiceProvider.CA());
    }

    private void init() {
        bn.a(this);
        com.kwad.sdk.core.webview.kwai.a aVar = new com.kwad.sdk.core.webview.kwai.a();
        this.apv = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.apu) {
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
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z) {
        this.apu = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.apv.setNeedHybridLoad(z);
    }
}
