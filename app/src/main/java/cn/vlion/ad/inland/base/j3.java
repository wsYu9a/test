package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class j3 implements VlionButtonSolidBgView.e {

    /* renamed from: a */
    public final /* synthetic */ w3 f2986a;

    /* renamed from: b */
    public final /* synthetic */ i0 f2987b;

    /* renamed from: c */
    public final /* synthetic */ VlionCustomParseAdData f2988c;

    /* renamed from: d */
    public final /* synthetic */ k3 f2989d;

    public j3(k3 k3Var, VlionCustomInterstitialActivity.e eVar, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f2989d = k3Var;
        this.f2986a = eVar;
        this.f2987b = i0Var;
        this.f2988c = vlionCustomParseAdData;
    }

    @Override // cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView.e
    public final void onClick() {
        try {
            if (this.f2986a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2987b), "main", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2988c);
                vlionClickParameterReplace.handleBaseParameter(this.f2989d);
                vlionClickParameterReplace.handleClickParameter(this.f2987b, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionCustomInterstitialActivity.e eVar = (VlionCustomInterstitialActivity.e) this.f2986a;
                eVar.getClass();
                LogVlion.e("VlionCustomInterstitialActivity onAdButtonClick ");
                VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
