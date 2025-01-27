package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public final class ah extends bj {
    private int aTQ;
    private int aTR;
    private int aTS;
    private int aTT;

    public ah(int i10, int i11) {
        super(i10, i11);
    }

    private int NO() {
        return this.aTQ;
    }

    private int NP() {
        return this.aTR;
    }

    private int NQ() {
        return this.aTS;
    }

    private int NR() {
        return this.aTT;
    }

    public static ah a(int i10, int i11, int i12, int i13, int i14, int i15) {
        ah ahVar = new ah(i10, i11);
        ahVar.eh(0);
        ahVar.ei(0);
        ahVar.ef(i13);
        ahVar.eg(0);
        return ahVar;
    }

    private void eg(int i10) {
        this.aTR = i10;
    }

    public final ah c(Context context, float f10) {
        ah ahVar = new ah(com.kwad.sdk.c.a.a.a(context, this.mWidth * f10), com.kwad.sdk.c.a.a.a(context, this.mHeight * f10));
        ahVar.aTS = com.kwad.sdk.c.a.a.a(context, this.aTS * f10);
        ahVar.aTR = com.kwad.sdk.c.a.a.a(context, this.aTR * f10);
        ahVar.aTT = com.kwad.sdk.c.a.a.a(context, this.aTT * f10);
        ahVar.aTQ = com.kwad.sdk.c.a.a.a(context, this.aTQ * f10);
        return ahVar;
    }

    public final void ef(int i10) {
        this.aTQ = i10;
    }

    public final void eh(int i10) {
        this.aTS = i10;
    }

    public final void ei(int i10) {
        this.aTT = i10;
    }

    public static void a(View view, ah ahVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (ahVar.getHeight() > 0) {
            layoutParams.height = ahVar.getHeight();
        }
        if (ahVar.getWidth() > 0) {
            layoutParams.width = ahVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (ahVar.NQ() > 0) {
                marginLayoutParams.leftMargin = ahVar.NQ();
            }
            if (ahVar.NP() > 0) {
                marginLayoutParams.bottomMargin = ahVar.NP();
            }
            if (ahVar.NR() > 0) {
                marginLayoutParams.rightMargin = ahVar.NR();
            }
            if (ahVar.NO() > 0) {
                marginLayoutParams.topMargin = ahVar.NO();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
