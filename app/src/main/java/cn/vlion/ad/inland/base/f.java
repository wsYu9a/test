package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.active.VlionHalfCircleView;
import cn.vlion.ad.inland.base.j;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class f implements VlionHalfCircleView.b {

    /* renamed from: a */
    public final /* synthetic */ i0 f2772a;

    /* renamed from: b */
    public final /* synthetic */ i f2773b;

    public f(i iVar, i0 i0Var) {
        this.f2773b = iVar;
        this.f2772a = i0Var;
    }

    public final void a() {
        VlionHalfCircleView vlionHalfCircleView;
        try {
            LogVlion.e("vlion_halfCircleViewTouch onClick--------");
            i iVar = this.f2773b;
            if (iVar.f2878q == null || (vlionHalfCircleView = iVar.f2874m) == null) {
                return;
            }
            VlionADClickType vlionADClickType = new VlionADClickType("click", vlionHalfCircleView.getRawXY(), "main", "button", "");
            VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2773b.f2884w);
            vlionClickParameterReplace.handleBaseParameter(this.f2773b);
            vlionClickParameterReplace.handleClickParameter(this.f2772a, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
            j.c cVar = (j.c) this.f2773b.f2878q;
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
