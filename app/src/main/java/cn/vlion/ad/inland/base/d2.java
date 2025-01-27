package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class d2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i2 f2702a;

    public d2(i2 i2Var) {
        this.f2702a = i2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LogVlion.e("VlionCustomDrawAdLayout vlionBaseVideoView isOpenHot");
            VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2702a.f2930p), "main", "hotsplot", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2702a.A);
            vlionClickParameterReplace.handleBaseParameter(this.f2702a);
            vlionClickParameterReplace.handleClickParameter(this.f2702a.f2930p, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            i2.b(this.f2702a, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
