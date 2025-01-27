package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public final class c {
    private ah GI;
    private ah GJ;
    private ah GK;
    private ah GL;
    private ah GM;
    private ah GN;
    private float Gy = 1.0f;
    private int GO = 34;
    private int GP = 19;
    private int GQ = 8;
    private int GR = 12;

    public static c c(float f10) {
        c cVar = new c();
        cVar.GI = ah.a(174, 0, 0, 0, 0, 0);
        cVar.GJ = ah.a(33, 33, 0, 0, 0, 0);
        cVar.GK = ah.a(0, 26, 0, 11, 0, 0);
        cVar.GL = ah.a(174, 171, 0, 6, 0, 0);
        cVar.GM = ah.a(0, 0, 0, 6, 0, 0);
        cVar.GN = ah.a(0, 0, 0, 7, 0, 0);
        cVar.GO = 21;
        cVar.GP = 12;
        cVar.GQ = 6;
        cVar.Gy = f10;
        cVar.GR = 8;
        return cVar;
    }

    public static c mp() {
        c cVar = new c();
        cVar.GI = ah.a(278, 0, 0, 0, 0, 0);
        cVar.GJ = ah.a(53, 53, 0, 0, 0, 0);
        cVar.GK = ah.a(0, 43, 0, 11, 0, 0);
        cVar.GL = ah.a(278, 274, 0, 8, 0, 0);
        cVar.GM = ah.a(0, 0, 0, 8, 0, 0);
        cVar.GN = ah.a(0, 0, 0, 10, 0, 0);
        return cVar;
    }

    public final ah U(Context context) {
        return this.GI.c(context, this.Gy);
    }

    public final ah V(Context context) {
        return this.GJ.c(context, this.Gy);
    }

    public final ah W(Context context) {
        return this.GK.c(context, this.Gy);
    }

    public final ah X(Context context) {
        return this.GL.c(context, this.Gy);
    }

    public final ah Y(Context context) {
        return this.GM.c(context, this.Gy);
    }

    public final ah Z(Context context) {
        return this.GN.c(context, this.Gy);
    }

    public final int aa(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.GO) * this.Gy);
    }

    public final int ab(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.GP) * this.Gy);
    }

    public final int ac(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.GQ) * this.Gy);
    }

    public final int mq() {
        return this.GR;
    }
}
