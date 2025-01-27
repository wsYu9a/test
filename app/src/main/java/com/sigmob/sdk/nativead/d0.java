package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.windad.natives.AdAppInfo;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: classes4.dex */
public class d0 implements WindNativeAdData {

    /* renamed from: a */
    public final String f19942a;

    /* renamed from: b */
    public final String f19943b;

    /* renamed from: c */
    public final String f19944c;

    /* renamed from: d */
    public final List<SigImage> f19945d;

    /* renamed from: e */
    public final SigVideo f19946e;

    /* renamed from: f */
    public final int f19947f;

    /* renamed from: g */
    public final y f19948g;

    /* renamed from: h */
    public AdAppInfo f19949h;

    public d0(BaseAdUnit baseAdUnit) {
        this.f19942a = baseAdUnit.getTitle();
        this.f19943b = baseAdUnit.getDesc();
        this.f19944c = baseAdUnit.getIconUrl();
        this.f19945d = baseAdUnit.getImageUrlList();
        this.f19947f = baseAdUnit.getNativeAd().type.intValue();
        this.f19949h = baseAdUnit.getAdAppInfo();
        this.f19946e = baseAdUnit.getNativeVideo();
        y yVar = new y();
        this.f19948g = yVar;
        yVar.a(baseAdUnit, this);
    }

    public View a() {
        y yVar = this.f19948g;
        if (yVar != null) {
            return yVar.s();
        }
        return null;
    }

    public int b() {
        y yVar = this.f19948g;
        if (yVar != null) {
            return yVar.t();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindImageViews(List<ImageView> list, int i10) {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.a(list, i10);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaView(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.a(viewGroup, nativeADMediaListener);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaViewWithoutAppInfo(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.b(viewGroup, nativeADMediaListener);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindViewForInteraction(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.a(view, list, list2, view2, nativeADEventListener);
        }
    }

    public int c() {
        return this.f19947f;
    }

    public int d() {
        y yVar = this.f19948g;
        if (yVar != null) {
            return yVar.u();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void destroy() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.p();
        }
    }

    public String e() {
        return "sigmob";
    }

    public double f() {
        y yVar = this.f19948g;
        return yVar != null ? yVar.B() : l5.c.f27899e;
    }

    public double g() {
        y yVar = this.f19948g;
        return yVar != null ? yVar.C() : l5.c.f27899e;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public AdAppInfo getAdAppInfo() {
        return this.f19949h;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public Bitmap getAdLogo() {
        return this.f19948g.r();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getAdPatternType() {
        return this.f19947f;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getCTAText() {
        y yVar = this.f19948g;
        return yVar != null ? yVar.v() : "";
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getDesc() {
        return this.f19943b;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getEcpm() {
        y yVar = this.f19948g;
        return yVar != null ? yVar.x() : "";
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getIconUrl() {
        return this.f19944c;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public List<SigImage> getImageList() {
        return this.f19945d;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getTitle() {
        return this.f19942a;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoHeight() {
        SigVideo sigVideo = this.f19946e;
        if (sigVideo != null) {
            return sigVideo.getHeight();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoWidth() {
        SigVideo sigVideo = this.f19946e;
        if (sigVideo != null) {
            return sigVideo.getWidth();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public View getWidgetView(int i10, int i11) {
        y yVar = this.f19948g;
        if (yVar != null) {
            return yVar.a(i10, i11);
        }
        return null;
    }

    public void h() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.N();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void pauseVideo() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.H();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void resumeVideo() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.I();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void setDislikeInteractionCallback(Activity activity, WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.a(dislikeInteractionCallback);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void startVideo() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.L();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void stopVideo() {
        y yVar = this.f19948g;
        if (yVar != null) {
            yVar.M();
        }
    }
}
