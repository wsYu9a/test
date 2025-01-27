package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.reward.model.VlionVideoAdDetailBottomView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class s6 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f3366a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f3367b;

    /* renamed from: c */
    public final /* synthetic */ VlionVideoAdDetailBottomView f3368c;

    public s6(VlionVideoAdDetailBottomView vlionVideoAdDetailBottomView, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3368c = vlionVideoAdDetailBottomView;
        this.f3366a = i0Var;
        this.f3367b = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f3368c.f2379h != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3366a), "main", "hotsplot", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3367b);
                vlionClickParameterReplace.handleBaseParameter(this.f3368c);
                vlionClickParameterReplace.handleClickParameter(this.f3366a, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionRewardVideoActivity.b(((x5) this.f3368c.f2379h).f3505a, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
