package com.shu.priory;

import android.content.Context;
import android.view.ViewGroup;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYSplashListener;
import com.shu.priory.splash.a;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class IFLYSplashAd {

    /* renamed from: a */
    private final Context f16787a;

    /* renamed from: b */
    private final a f16788b;

    /* renamed from: c */
    private final IFLYSplashListener f16789c;

    public IFLYSplashAd(Context context, String str, IFLYSplashListener iFLYSplashListener) {
        this.f16787a = context;
        this.f16789c = iFLYSplashListener;
        this.f16788b = new a(context, str, iFLYSplashListener);
    }

    public void destroy() {
        h.a(SDKConstants.TAG, "temp ad destroy");
        this.f16788b.c();
    }

    public void loadAd() {
        if (this.f16787a == null || this.f16789c == null) {
            h.d(SDKConstants.TAG, "param is defect");
        } else {
            this.f16788b.a((ViewGroup) null);
            this.f16788b.b();
        }
    }

    public void loadAndShowAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            h.d(SDKConstants.TAG, "ad container is null");
        } else {
            this.f16788b.a(viewGroup);
            loadAd();
        }
    }

    public void setParameter(String str, Object obj) {
        this.f16788b.a(str, obj);
    }

    public void showAd(ViewGroup viewGroup) {
        try {
            if (viewGroup == null) {
                h.a(SDKConstants.TAG, "ad container is null");
            } else {
                this.f16788b.b(viewGroup);
            }
        } catch (Throwable th2) {
            h.a(SDKConstants.TAG, "show ad error " + th2);
        }
    }
}
