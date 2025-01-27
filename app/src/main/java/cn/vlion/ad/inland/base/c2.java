package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class c2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f2678a;

    /* renamed from: b */
    public final /* synthetic */ i2 f2679b;

    public c2(i2 i2Var, i0 i0Var) {
        this.f2679b = i2Var;
        this.f2678a = i0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2678a), "main", "button", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2679b.A);
            vlionClickParameterReplace.handleBaseParameter(this.f2679b);
            vlionClickParameterReplace.handleClickParameter(this.f2678a, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            i2.a(this.f2679b, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
