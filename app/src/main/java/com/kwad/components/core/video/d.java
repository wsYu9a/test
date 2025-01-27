package com.kwad.components.core.video;

/* loaded from: classes3.dex */
public final class d {
    private boolean Xo = false;
    private boolean Xp = false;
    private boolean Xq = false;
    private boolean Xr = false;
    private boolean Xs = false;
    private int Xt = -1;

    public final void aO(int i10) {
        this.Xt = i10;
    }

    public final void aS(boolean z10) {
        this.Xq = z10;
    }

    public final boolean sE() {
        return this.Xt > 0;
    }

    public final int sF() {
        return this.Xt;
    }

    public final boolean sG() {
        return this.Xo;
    }

    public final boolean sH() {
        return this.Xp;
    }

    public final boolean sI() {
        return this.Xq;
    }

    public final boolean sJ() {
        return this.Xr;
    }

    public final boolean sK() {
        return this.Xs;
    }

    public final void setAd(boolean z10) {
        this.Xp = z10;
    }

    public final void setFillXY(boolean z10) {
        this.Xs = z10;
    }

    public final void setForce(boolean z10) {
        this.Xo = z10;
    }

    public final void setHorizontalVideo(boolean z10) {
        this.Xr = z10;
    }
}
