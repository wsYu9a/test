package cn.vlion.ad.inland.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;

/* loaded from: classes.dex */
public abstract class h4 extends FrameLayout {
    public h4(Context context) {
        this(context, null);
    }

    public abstract void a(int i10);

    public abstract void a(VlionCustomParseAdData vlionCustomParseAdData, boolean z10, boolean z11, x5 x5Var);

    public abstract void a(String str, boolean z10);

    public abstract void setProgress(int i10);

    public h4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h4(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
