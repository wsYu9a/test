package cn.vlion.ad.inland.ad.view.video;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.base.b0;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class d implements VlionButtonSolidBgView.e {

    /* renamed from: a */
    public final /* synthetic */ i0 f2567a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomParseAdData f2568b;

    /* renamed from: c */
    public final /* synthetic */ VlionVideoEndCardView f2569c;

    public d(VlionVideoEndCardView vlionVideoEndCardView, i0 i0Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f2569c = vlionVideoEndCardView;
        this.f2567a = i0Var;
        this.f2568b = vlionCustomParseAdData;
    }

    @Override // cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView.e
    public final void onClick() {
        try {
            if (this.f2569c.f2547k != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2567a), "endcard", "button", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2568b);
                vlionClickParameterReplace.handleBaseParameter(this.f2569c.f2540d);
                vlionClickParameterReplace.handleClickParameter(this.f2567a, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                this.f2569c.f2547k.a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
