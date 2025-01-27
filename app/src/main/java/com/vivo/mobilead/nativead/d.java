package com.vivo.mobilead.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.vivo.ad.model.AppElement;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.ad.view.IActionView;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import com.vivo.mobilead.util.b0;
import com.vivo.mobilead.util.k0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements NativeResponse {

    /* renamed from: a */
    private NativeUnifiedADData f29608a;

    /* renamed from: b */
    private NativeAdListener f29609b;

    /* renamed from: c */
    private String f29610c;

    /* renamed from: d */
    private String f29611d;

    /* renamed from: e */
    private String f29612e;

    /* renamed from: f */
    private FrameLayout.LayoutParams f29613f;

    /* renamed from: g */
    private NativeAdContainer f29614g;

    /* renamed from: h */
    private List<View> f29615h;

    /* renamed from: i */
    private MediaView f29616i;

    /* renamed from: j */
    private e f29617j;

    class a implements NativeADEventListener {
        a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            if (d.this.f29609b != null) {
                d.this.f29609b.onClick(d.this);
            }
            k0.a("4", String.valueOf(c.a.f28914c), d.this.f29610c, d.this.f29612e, d.this.f29611d, 0, false);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            if (d.this.f29609b != null) {
                d.this.f29609b.onNoAD(new com.vivo.ad.model.AdError(adError == null ? 40215 : adError.getErrorCode(), adError == null ? "未知情况下导致的错误，请联系广告SDK对接人员处理" : adError.getErrorMsg(), d.this.f29610c, null));
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            if (d.this.f29609b != null) {
                d.this.f29609b.onAdShow(d.this);
            }
            k0.a("4", String.valueOf(c.a.f28914c), d.this.f29610c, d.this.f29612e, d.this.f29611d, 0);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }
    }

    public d(NativeUnifiedADData nativeUnifiedADData, NativeAdListener nativeAdListener) {
        this.f29608a = nativeUnifiedADData;
        this.f29609b = nativeAdListener;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void bindLogoView(FrameLayout.LayoutParams layoutParams) {
        NativeAdContainer nativeAdContainer;
        this.f29613f = layoutParams;
        if (layoutParams == null || (nativeAdContainer = this.f29614g) == null) {
            return;
        }
        a(nativeAdContainer.getContext(), this.f29614g, this.f29613f, this.f29615h, this.f29616i, this.f29617j);
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void bindPrivacyView(FrameLayout.LayoutParams layoutParams) {
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getAPPStatus() {
        return -1;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public IActionView getActionView() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdMarkText() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdMarkUrl() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdTag() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getAdType() {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.isAppAd() ? 2 : 1;
        }
        return -1;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public AppElement getAppMiitInfo() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getDesc() {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getDesc() : "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getIconUrl() : "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int[] getImgDimensions() {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        return nativeUnifiedADData != null ? new int[]{nativeUnifiedADData.getPictureWidth(), this.f29608a.getPictureHeight()} : new int[]{0, 0};
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public List<String> getImgUrl() {
        ArrayList arrayList = new ArrayList();
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        if (nativeUnifiedADData != null) {
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType != 1) {
                if (adPatternType != 3) {
                    if (adPatternType != 4) {
                        String imgUrl = this.f29608a.getImgUrl();
                        if (TextUtils.isEmpty(imgUrl)) {
                            arrayList.add(imgUrl);
                        }
                    }
                }
                arrayList.addAll(this.f29608a.getImgList());
            }
            arrayList.add(this.f29608a.getImgUrl());
            arrayList.addAll(this.f29608a.getImgList());
        }
        return arrayList;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getMaterialMode() {
        return b0.a(this.f29608a);
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public int getPrice() {
        return -2;
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public String getPriceLevel() {
        return "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getTitle() : "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view) {
        if (vivoNativeAdContainer == null || vivoNativeAdContainer.getChildCount() < 1) {
            return;
        }
        a(vivoNativeAdContainer, view, null, null);
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
    }

    public void a(String str, String str2, String str3) {
        this.f29610c = str;
        this.f29612e = str2;
        this.f29611d = str3;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view, NativeVideoView nativeVideoView) {
        e eVar;
        if (vivoNativeAdContainer == null || vivoNativeAdContainer.getChildCount() < 1) {
            return;
        }
        MediaView mediaView = null;
        if (nativeVideoView != null) {
            mediaView = new MediaView(vivoNativeAdContainer.getContext());
            mediaView.setBackgroundColor(Color.parseColor("#000000"));
            eVar = new e();
            eVar.a(this.f29608a);
            nativeVideoView.setView(mediaView, eVar);
        } else {
            eVar = null;
        }
        a(vivoNativeAdContainer, view, mediaView, eVar);
    }

    private void a(VivoNativeAdContainer vivoNativeAdContainer, View view, MediaView mediaView, e eVar) {
        this.f29615h = new ArrayList();
        this.f29614g = new NativeAdContainer(vivoNativeAdContainer.getContext());
        View childAt = vivoNativeAdContainer.getChildAt(0);
        if (childAt != null) {
            vivoNativeAdContainer.removeViewAt(0);
            this.f29614g.addView(childAt);
            if (this.f29613f == null) {
                this.f29613f = new FrameLayout.LayoutParams(-2, -2);
            }
            vivoNativeAdContainer.addView(this.f29614g);
            this.f29615h.add(childAt);
        }
        if (view != null) {
            this.f29615h.add(view);
        }
        this.f29616i = mediaView;
        this.f29617j = eVar;
        a(vivoNativeAdContainer.getContext(), this.f29614g, this.f29613f, this.f29615h, mediaView, eVar);
    }

    private void a(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, MediaView mediaView, e eVar) {
        NativeUnifiedADData nativeUnifiedADData = this.f29608a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.bindAdToView(context, nativeAdContainer, layoutParams, list);
            this.f29608a.setNativeAdEventListener(new a());
        }
        if (mediaView == null || eVar == null) {
            return;
        }
        eVar.a(mediaView);
    }
}
