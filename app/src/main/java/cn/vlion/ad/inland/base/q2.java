package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class q2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f3320a;

    /* renamed from: b */
    public final /* synthetic */ y2 f3321b;

    public q2(y2 y2Var, i0 i0Var) {
        this.f3321b = y2Var;
        this.f3320a = i0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f3320a), "main", "button", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f3321b.f3527z);
            vlionClickParameterReplace.handleBaseParameter(this.f3321b);
            vlionClickParameterReplace.handleClickParameter(this.f3320a, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            y2.a(this.f3321b, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
