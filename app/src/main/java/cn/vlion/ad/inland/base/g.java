package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.j;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f2812a;

    /* renamed from: b */
    public final /* synthetic */ i f2813b;

    public g(i iVar, i0 i0Var) {
        this.f2813b = iVar;
        this.f2812a = i0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i0 i0Var;
        try {
            if (this.f2813b.f2878q == null || (i0Var = this.f2812a) == null) {
                return;
            }
            VlionADClickType vlionADClickType = new VlionADClickType("click", i0Var.b(), "main", "shakeIcon", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2813b.f2884w);
            vlionClickParameterReplace.handleBaseParameter(this.f2813b);
            vlionClickParameterReplace.handleClickParameter(this.f2812a, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            j.c cVar = (j.c) this.f2813b.f2878q;
            cVar.getClass();
            try {
                j.b(j.this, vlionADClickType);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
