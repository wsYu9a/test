package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import com.vivo.mobilead.util.k0;

/* loaded from: classes4.dex */
public class n extends VivoNativeExpressView {

    /* renamed from: a */
    private TTNativeExpressAd f30102a;

    /* renamed from: b */
    private String f30103b;

    /* renamed from: c */
    private String f30104c;

    /* renamed from: d */
    private String f30105d;

    /* renamed from: e */
    private TTNativeExpressAd.ExpressVideoAdListener f30106e;

    class a implements TTNativeExpressAd.ExpressVideoAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onClickRetry() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onProgressUpdate(long j2, long j3) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdComplete() {
            if (((VivoNativeExpressView) n.this).mediaListener != null) {
                ((VivoNativeExpressView) n.this).mediaListener.onVideoCompletion();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdContinuePlay() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdPaused() {
            if (((VivoNativeExpressView) n.this).mediaListener != null) {
                ((VivoNativeExpressView) n.this).mediaListener.onVideoPause();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdStartPlay() {
            if (((VivoNativeExpressView) n.this).mediaListener != null) {
                ((VivoNativeExpressView) n.this).mediaListener.onVideoStart();
            }
            k0.b("4", String.valueOf(c.a.f28913b), n.this.f30103b, n.this.f30104c, n.this.f30105d, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoError(int i2, int i3) {
            if (((VivoNativeExpressView) n.this).mediaListener != null) {
                ((VivoNativeExpressView) n.this).mediaListener.onVideoError(new VivoAdError(i2, ""));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoLoad() {
        }
    }

    public n(Context context, TTNativeExpressAd tTNativeExpressAd, String str, String str2, String str3) {
        super(context, null);
        View expressAdView;
        this.f30106e = new a();
        this.f30102a = tTNativeExpressAd;
        this.f30103b = str;
        this.f30104c = str2;
        this.f30105d = str3;
        if (tTNativeExpressAd == null || (expressAdView = tTNativeExpressAd.getExpressAdView()) == null) {
            return;
        }
        tTNativeExpressAd.setCanInterruptVideoPlay(true);
        tTNativeExpressAd.setVideoAdListener(this.f30106e);
        setBackgroundColor(-1);
        addView(expressAdView, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // com.vivo.mobilead.unified.nativead.VivoNativeExpressView
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.f30102a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }
}
