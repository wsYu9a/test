package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class w6 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ g4 f3484a;

    /* renamed from: b */
    public final /* synthetic */ i0 f3485b;

    /* renamed from: c */
    public final /* synthetic */ VlionCustomParseAdData f3486c;

    /* renamed from: d */
    public final /* synthetic */ y6 f3487d;

    public w6(y6 y6Var, x5 x5Var, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3487d = y6Var;
        this.f3484a = x5Var;
        this.f3485b = i0Var;
        this.f3486c = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f3484a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3485b), "Main floating Window", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3486c);
                vlionClickParameterReplace.handleBaseParameter(this.f3487d);
                vlionClickParameterReplace.handleClickParameter(this.f3485b, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionRewardVideoActivity.a(((x5) this.f3484a).f3505a, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
