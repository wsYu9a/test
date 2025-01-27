package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import n9.l;

/* loaded from: classes3.dex */
public class RLScrollView extends ScrollView {

    /* renamed from: b */
    public l f12666b;

    /* renamed from: c */
    public a f12667c;

    public interface a {
        void a();
    }

    public RLScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        a aVar;
        super.onOverScrolled(i10, i11, z10, z11);
        if (i11 <= 0 || !z11 || (aVar = this.f12667c) == null) {
            return;
        }
        aVar.a();
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        l lVar = this.f12666b;
        if (lVar != null) {
            lVar.onScrollChanged(i10, i11, i12, i13);
        }
    }

    public void setOnOverScrollListener(a aVar) {
        this.f12667c = aVar;
    }

    public void setOnScrollListener(l lVar) {
        this.f12666b = lVar;
    }

    public RLScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RLScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
