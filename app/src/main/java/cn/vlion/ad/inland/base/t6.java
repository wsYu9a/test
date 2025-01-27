package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.reward.model.VlionVideoAdDetailBottomView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class t6 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f3386a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f3387b;

    /* renamed from: c */
    public final /* synthetic */ VlionVideoAdDetailBottomView f3388c;

    public t6(VlionVideoAdDetailBottomView vlionVideoAdDetailBottomView, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3388c = vlionVideoAdDetailBottomView;
        this.f3386a = i0Var;
        this.f3387b = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f3388c.f2379h != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3386a), "main", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3387b);
                vlionClickParameterReplace.handleBaseParameter(this.f3388c);
                vlionClickParameterReplace.handleClickParameter(this.f3386a, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionRewardVideoActivity.a(((x5) this.f3388c.f2379h).f3505a, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
