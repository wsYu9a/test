package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class n3 implements VlionButtonSolidBgView.e {

    /* renamed from: a */
    public final /* synthetic */ w3 f3113a;

    /* renamed from: b */
    public final /* synthetic */ i0 f3114b;

    /* renamed from: c */
    public final /* synthetic */ VlionCustomParseAdData f3115c;

    /* renamed from: d */
    public final /* synthetic */ o3 f3116d;

    public n3(o3 o3Var, VlionCustomInterstitialActivity.e eVar, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3116d = o3Var;
        this.f3113a = eVar;
        this.f3114b = i0Var;
        this.f3115c = vlionCustomParseAdData;
    }

    @Override // cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView.e
    public final void onClick() {
        try {
            if (this.f3113a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3114b), "main", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3115c);
                vlionClickParameterReplace.handleBaseParameter(this.f3116d);
                vlionClickParameterReplace.handleClickParameter(this.f3114b, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionCustomInterstitialActivity.e eVar = (VlionCustomInterstitialActivity.e) this.f3113a;
                eVar.getClass();
                LogVlion.e("VlionCustomInterstitialActivity onAdButtonClick ");
                VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
