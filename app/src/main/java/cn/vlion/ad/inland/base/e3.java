package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class e3 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ w3 f2759a;

    /* renamed from: b */
    public final /* synthetic */ i0 f2760b;

    /* renamed from: c */
    public final /* synthetic */ VlionCustomParseAdData f2761c;

    /* renamed from: d */
    public final /* synthetic */ f3 f2762d;

    public e3(f3 f3Var, VlionCustomInterstitialActivity.e eVar, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f2762d = f3Var;
        this.f2759a = eVar;
        this.f2760b = i0Var;
        this.f2761c = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f2759a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2760b), "main", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2761c);
                vlionClickParameterReplace.handleBaseParameter(this.f2762d);
                vlionClickParameterReplace.handleClickParameter(this.f2760b, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionCustomInterstitialActivity.e eVar = (VlionCustomInterstitialActivity.e) this.f2759a;
                eVar.getClass();
                LogVlion.e("VlionCustomInterstitialActivity onAdButtonClick ");
                VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
