package cn.vlion.ad.inland.base;

import android.view.View;
import android.widget.LinearLayout;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class w2 implements g0 {

    /* renamed from: a */
    public final /* synthetic */ LinearLayout f3481a;

    /* renamed from: b */
    public final /* synthetic */ y2 f3482b;

    public w2(y2 y2Var, LinearLayout linearLayout) {
        this.f3482b = y2Var;
        this.f3481a = linearLayout;
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void a(i1 i1Var) {
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void onAdRenderSuccess(View view) {
        try {
            LinearLayout linearLayout = this.f3481a;
            if (linearLayout == null || view == null) {
                return;
            }
            this.f3482b.a(linearLayout, view, 0.6666667f);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
