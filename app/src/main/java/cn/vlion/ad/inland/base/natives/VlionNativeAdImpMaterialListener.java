package cn.vlion.ad.inland.base.natives;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.l5;
import cn.vlion.ad.inland.base.m5;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public abstract class VlionNativeAdImpMaterialListener implements VlionNativeAdMaterialListener {
    public View adMediaView;
    public VlionNativesAdVideoListener madVideoListener;
    public l5 mcontainerLayout;
    public View mrootView;

    public class a implements m5 {
        public a() {
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public void destroy() {
        try {
            l5 l5Var = this.mcontainerLayout;
            if (l5Var == null || l5Var.getMvlionNativeAdData() == null) {
                return;
            }
            this.mcontainerLayout.destroy();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public View getMediaView() {
        return this.adMediaView;
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
        try {
            if (this.mcontainerLayout == null) {
                this.mcontainerLayout = new l5(context);
            }
            l5 l5Var = this.mcontainerLayout;
            if (l5Var != null) {
                a aVar = new a();
                try {
                    if (l5Var.getContext() != null && vlionNativeAdData != null) {
                        l5Var.f3076l = aVar;
                        l5Var.f3073i = vlionNativeAdData;
                        int vlionNativeType = vlionNativeAdData.getVlionNativeType();
                        if (vlionNativeType == 1 || vlionNativeType == 2) {
                            l5Var.b(vlionNativeAdData);
                        } else if (vlionNativeType == 3) {
                            l5Var.a(vlionNativeAdData);
                        } else if (vlionNativeType == 4) {
                            l5Var.c();
                        }
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            setAdMediaView(this.mcontainerLayout);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public void onNativeAdRenderFailure(VlionAdBaseError vlionAdBaseError) {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public void onNativeAdRenderSuccess() {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
        LogVlion.e("VlionNativeAdImpMaterialListener :  registerNativeView");
        this.mrootView = viewGroup;
    }

    public void setAdMediaView(View view) {
        this.adMediaView = view;
    }

    public void setAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        try {
            this.madVideoListener = vlionNativesAdVideoListener;
            l5 l5Var = this.mcontainerLayout;
            if (l5Var == null || l5Var.getMvlionNativeAdData() == null) {
                return;
            }
            this.mcontainerLayout.setAdVideoListener(vlionNativesAdVideoListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            l5 l5Var = this.mcontainerLayout;
            if (l5Var == null || l5Var.getMvlionNativeAdData() == null) {
                return;
            }
            this.mcontainerLayout.setClosedVolumePlay(z10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
