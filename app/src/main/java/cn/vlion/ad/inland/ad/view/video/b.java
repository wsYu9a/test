package cn.vlion.ad.inland.ad.view.video;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.b0;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f2563a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f2564b;

    /* renamed from: c */
    public final /* synthetic */ VlionVideoEndCardView f2565c;

    public b(VlionVideoEndCardView vlionVideoEndCardView, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f2565c = vlionVideoEndCardView;
        this.f2563a = i0Var;
        this.f2564b = vlionCustomParseAdData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (this.f2565c.f2547k != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2563a), "endcard", "hotsplot", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2564b);
                vlionClickParameterReplace.handleBaseParameter(this.f2565c.f2540d);
                vlionClickParameterReplace.handleClickParameter(this.f2563a, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                this.f2565c.f2547k.b(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
