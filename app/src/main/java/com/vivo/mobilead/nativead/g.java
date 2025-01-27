package com.vivo.mobilead.nativead;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.vivo.ad.model.AppElement;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.ad.view.IActionView;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.b0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class g implements NativeResponse {

    /* renamed from: a */
    private KsNativeAd f29632a;

    /* renamed from: b */
    private NativeAdListener f29633b;

    /* renamed from: c */
    private String f29634c;

    /* renamed from: d */
    private String f29635d;

    /* renamed from: e */
    private String f29636e;

    /* renamed from: f */
    private ImageView f29637f;

    /* renamed from: g */
    private FrameLayout.LayoutParams f29638g;

    /* renamed from: h */
    private KsNativeAd.AdInteractionListener f29639h = new a();

    class a implements KsNativeAd.AdInteractionListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            if (g.this.f29633b != null) {
                g.this.f29633b.onClick(g.this);
            }
            k0.a("4", String.valueOf(c.a.f28915d), g.this.f29634c, g.this.f29636e, g.this.f29635d, 0, false);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            if (g.this.f29633b != null) {
                g.this.f29633b.onAdShow(g.this);
            }
            k0.a("4", String.valueOf(c.a.f28915d), g.this.f29634c, g.this.f29636e, g.this.f29635d, 0);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public g(KsNativeAd ksNativeAd, NativeAdListener nativeAdListener) {
        this.f29632a = ksNativeAd;
        this.f29633b = nativeAdListener;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void bindLogoView(FrameLayout.LayoutParams layoutParams) {
        this.f29638g = layoutParams;
        ImageView imageView = this.f29637f;
        if (imageView == null || layoutParams == null) {
            return;
        }
        imageView.setLayoutParams(layoutParams);
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
        KsNativeAd ksNativeAd = this.f29632a;
        return (ksNativeAd == null || TextUtils.isEmpty(ksNativeAd.getAdSource())) ? "" : this.f29632a.getAdSource();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdMarkUrl() {
        KsNativeAd ksNativeAd = this.f29632a;
        if (ksNativeAd == null || ksNativeAd.getAdSourceLogoUrl(0) == null) {
            return null;
        }
        return this.f29632a.getAdSourceLogoUrl(0);
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdTag() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getAdType() {
        KsNativeAd ksNativeAd = this.f29632a;
        return (ksNativeAd != null && ksNativeAd.getInteractionType() == 2) ? 1 : 2;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public AppElement getAppMiitInfo() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getDesc() {
        KsNativeAd ksNativeAd = this.f29632a;
        return ksNativeAd != null ? ksNativeAd.getAdDescription() : "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getIconUrl() {
        KsNativeAd ksNativeAd = this.f29632a;
        return (ksNativeAd == null || TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) ? "" : this.f29632a.getAppIconUrl();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int[] getImgDimensions() {
        KsImage ksImage;
        KsNativeAd ksNativeAd = this.f29632a;
        return (ksNativeAd == null || ksNativeAd.getImageList() == null || this.f29632a.getImageList().size() <= 0 || (ksImage = this.f29632a.getImageList().get(0)) == null) ? new int[]{0, 0} : new int[]{ksImage.getWidth(), ksImage.getHeight()};
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public List<String> getImgUrl() {
        KsNativeAd ksNativeAd = this.f29632a;
        if (ksNativeAd == null || ksNativeAd.getImageList() == null || this.f29632a.getImageList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<KsImage> it = this.f29632a.getImageList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getImageUrl());
        }
        return arrayList;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getMaterialMode() {
        return b0.a(this.f29632a);
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
        KsNativeAd ksNativeAd = this.f29632a;
        return ksNativeAd != null ? ksNativeAd.getAppName() : "";
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view) {
        if (vivoNativeAdContainer == null) {
            VOpenLog.e(g.class.getSimpleName(), "registed view cannot be null!");
            return;
        }
        a(vivoNativeAdContainer);
        ArrayList arrayList = new ArrayList();
        arrayList.add(vivoNativeAdContainer);
        if (view != null) {
            arrayList.add(view);
        }
        this.f29632a.registerViewForInteraction(vivoNativeAdContainer, arrayList, this.f29639h);
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
    }

    public void a(String str, String str2, String str3) {
        this.f29634c = str;
        this.f29636e = str2;
        this.f29635d = str3;
    }

    private View a(VivoNativeAdContainer vivoNativeAdContainer) {
        y0.a((ViewGroup) vivoNativeAdContainer);
        ImageView imageView = new ImageView(com.vivo.mobilead.manager.f.j().c());
        this.f29637f = imageView;
        imageView.setTag("feedback");
        this.f29637f.setImageBitmap(com.vivo.mobilead.util.g.a(com.vivo.mobilead.manager.f.j().c(), "vivo_module_ks_logo.png"));
        if (this.f29638g == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f29638g = layoutParams;
            layoutParams.gravity = 51;
        }
        this.f29637f.setLayoutParams(this.f29638g);
        vivoNativeAdContainer.addView(this.f29637f);
        return this.f29637f;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view, NativeVideoView nativeVideoView) {
        registerView(vivoNativeAdContainer, view);
    }
}
