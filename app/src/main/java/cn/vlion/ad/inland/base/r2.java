package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class r2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ y2 f3344a;

    public r2(y2 y2Var) {
        this.f3344a = y2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3344a.f3523v), "main", "hotsplot", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3344a.f3527z);
            vlionClickParameterReplace.handleBaseParameter(this.f3344a);
            vlionClickParameterReplace.handleClickParameter(this.f3344a.f3523v, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            LogVlion.e("VlionCustomFeedAdLayout adAreaClickAction isOpenHot");
            y2.b(this.f3344a, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
