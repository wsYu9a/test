package com.vivo.mobilead.nativead;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
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
public class j implements NativeResponse {

    /* renamed from: a */
    private TTNativeAd f29646a;

    /* renamed from: b */
    private NativeAdListener f29647b;

    /* renamed from: c */
    private String f29648c;

    /* renamed from: d */
    private String f29649d;

    /* renamed from: e */
    private String f29650e;

    /* renamed from: f */
    private FrameLayout.LayoutParams f29651f;

    /* renamed from: g */
    private ImageView f29652g;

    /* renamed from: h */
    private TTNativeAd.AdInteractionListener f29653h = new a();

    class a implements TTNativeAd.AdInteractionListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            if (j.this.f29647b != null) {
                j.this.f29647b.onClick(j.this);
            }
            k0.a("4", String.valueOf(c.a.f28913b), j.this.f29648c, j.this.f29650e, j.this.f29649d, 0, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            if (j.this.f29647b != null) {
                j.this.f29647b.onClick(j.this);
            }
            k0.a("4", String.valueOf(c.a.f28913b), j.this.f29648c, j.this.f29650e, j.this.f29649d, 0, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            if (j.this.f29647b != null) {
                j.this.f29647b.onAdShow(j.this);
            }
            k0.a("4", String.valueOf(c.a.f28913b), j.this.f29648c, j.this.f29650e, j.this.f29649d, 0);
        }
    }

    public j(TTNativeAd tTNativeAd, NativeAdListener nativeAdListener) {
        this.f29646a = tTNativeAd;
        this.f29647b = nativeAdListener;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void bindLogoView(FrameLayout.LayoutParams layoutParams) {
        this.f29651f = layoutParams;
        ImageView imageView = this.f29652g;
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
        return this.f29646a.getAdLogo();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getAdMarkText() {
        return this.f29646a.getSource();
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
        int interactionType = this.f29646a.getInteractionType();
        if (interactionType == 2) {
            return 1;
        }
        if (interactionType != 3) {
            return interactionType != 5 ? 2 : 7;
        }
        return 3;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public AppElement getAppMiitInfo() {
        return null;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getDesc() {
        return this.f29646a.getDescription();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public String getIconUrl() {
        TTNativeAd tTNativeAd = this.f29646a;
        return (tTNativeAd == null || tTNativeAd.getIcon() == null) ? "" : this.f29646a.getIcon().getImageUrl();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int[] getImgDimensions() {
        TTImage tTImage;
        return (this.f29646a.getImageList() == null || this.f29646a.getImageList().get(0) == null || (tTImage = this.f29646a.getImageList().get(0)) == null) ? new int[]{0, 0} : new int[]{tTImage.getWidth(), tTImage.getHeight()};
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public List<String> getImgUrl() {
        if (this.f29646a.getImageList() == null || this.f29646a.getImageList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTImage> it = this.f29646a.getImageList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getImageUrl());
        }
        return arrayList;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public int getMaterialMode() {
        return b0.a(this.f29646a);
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
        return this.f29646a.getTitle();
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view) {
        if (vivoNativeAdContainer == null) {
            VOpenLog.e(j.class.getSimpleName(), "registed view cannot be null!");
            return;
        }
        a(vivoNativeAdContainer);
        if (view == null) {
            this.f29646a.registerViewForInteraction(vivoNativeAdContainer, vivoNativeAdContainer, this.f29653h);
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(vivoNativeAdContainer);
        arrayList.add(view);
        this.f29646a.registerViewForInteraction(vivoNativeAdContainer, arrayList, null, this.f29653h);
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
    }

    @Override // com.vivo.ad.nativead.NativeResponse, com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
    }

    public void a(String str, String str2, String str3) {
        this.f29648c = str;
        this.f29650e = str2;
        this.f29649d = str3;
    }

    private View a(VivoNativeAdContainer vivoNativeAdContainer) {
        y0.a((ViewGroup) vivoNativeAdContainer);
        ImageView imageView = new ImageView(com.vivo.mobilead.manager.f.j().c());
        this.f29652g = imageView;
        imageView.setTag("feedback");
        this.f29652g.setImageBitmap(this.f29646a.getAdLogo());
        if (this.f29651f == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f29651f = layoutParams;
            layoutParams.gravity = 51;
        }
        this.f29652g.setLayoutParams(this.f29651f);
        vivoNativeAdContainer.addView(this.f29652g);
        return this.f29652g;
    }

    @Override // com.vivo.ad.nativead.NativeResponse
    public void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view, NativeVideoView nativeVideoView) {
        registerView(vivoNativeAdContainer, view);
    }
}
