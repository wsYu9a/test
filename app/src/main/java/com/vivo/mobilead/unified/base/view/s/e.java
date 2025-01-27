package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.k0;

/* loaded from: classes4.dex */
public class e extends VivoNativeExpressView {

    /* renamed from: a */
    private NativeExpressADView f30089a;

    /* renamed from: b */
    private String f30090b;

    /* renamed from: c */
    private String f30091c;

    /* renamed from: d */
    private String f30092d;

    /* renamed from: e */
    private NativeExpressMediaListener f30093e;

    class a implements NativeExpressMediaListener {
        a() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoCached(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
            if (((VivoNativeExpressView) e.this).mediaListener != null) {
                ((VivoNativeExpressView) e.this).mediaListener.onVideoCompletion();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
            if (((VivoNativeExpressView) e.this).mediaListener != null) {
                VivoAdError vivoAdError = new VivoAdError(-1, "");
                if (adError != null) {
                    vivoAdError = new VivoAdError(adError.getErrorCode(), adError.getErrorMsg());
                }
                ((VivoNativeExpressView) e.this).mediaListener.onVideoError(vivoAdError);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoInit(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPause(NativeExpressADView nativeExpressADView) {
            if (((VivoNativeExpressView) e.this).mediaListener != null) {
                ((VivoNativeExpressView) e.this).mediaListener.onVideoPause();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoReady(NativeExpressADView nativeExpressADView, long j2) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoStart(NativeExpressADView nativeExpressADView) {
            if (((VivoNativeExpressView) e.this).mediaListener != null) {
                ((VivoNativeExpressView) e.this).mediaListener.onVideoStart();
            }
            k0.b("4", String.valueOf(c.a.f28914c), e.this.f30090b, e.this.f30091c, e.this.f30092d, 1);
        }
    }

    public e(Context context, NativeExpressADView nativeExpressADView, String str, String str2, String str3) {
        super(context, null);
        this.f30093e = new a();
        this.f30089a = nativeExpressADView;
        this.f30090b = str;
        this.f30091c = str2;
        this.f30092d = str3;
        if (nativeExpressADView != null) {
            addView(nativeExpressADView, new FrameLayout.LayoutParams(-2, -2));
            nativeExpressADView.setMediaListener(this.f30093e);
            if (c0.a(context) == 100) {
                nativeExpressADView.preloadVideo();
            }
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.VivoNativeExpressView
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.f30089a;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }
}
