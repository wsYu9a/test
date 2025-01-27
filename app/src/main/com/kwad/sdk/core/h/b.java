package com.kwad.sdk.core.h;

/* loaded from: classes3.dex */
public abstract class b implements c {
    private boolean aIb = false;
    private boolean Ol = false;
    private boolean Om = false;

    public abstract void aH();

    public abstract void aI();

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        this.aIb = true;
        if (this.Om) {
            return;
        }
        aH();
        this.Om = true;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        if (this.aIb && !this.Ol) {
            aI();
            this.Ol = true;
        }
    }
}
