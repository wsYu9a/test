package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class v6 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ g4 f3471a;

    /* renamed from: b */
    public final /* synthetic */ i0 f3472b;

    /* renamed from: c */
    public final /* synthetic */ VlionCustomParseAdData f3473c;

    /* renamed from: d */
    public final /* synthetic */ y6 f3474d;

    public v6(y6 y6Var, x5 x5Var, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3474d = y6Var;
        this.f3471a = x5Var;
        this.f3472b = i0Var;
        this.f3473c = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f3471a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3472b), "Main floating Window", "hotsplot", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3473c);
                vlionClickParameterReplace.handleBaseParameter(this.f3474d);
                vlionClickParameterReplace.handleClickParameter(this.f3472b, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionRewardVideoActivity.b(((x5) this.f3471a).f3505a, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
