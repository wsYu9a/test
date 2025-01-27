package com.vivo.ad.view;

import android.view.View;

/* loaded from: classes4.dex */
public class d implements IActionView {

    /* renamed from: a */
    private final h f27002a;

    public d(h hVar) {
        this.f27002a = hVar;
    }

    @Override // com.vivo.ad.view.IActionView
    public void cancelAnimation() {
        h hVar = this.f27002a;
        if (hVar != null) {
            hVar.cancelAnimation();
        }
    }

    @Override // com.vivo.ad.view.IActionView
    public View getView() {
        return this.f27002a;
    }

    @Override // com.vivo.ad.view.IActionView
    public boolean isAnimating() {
        h hVar = this.f27002a;
        if (hVar != null) {
            return hVar.isAnimating();
        }
        return false;
    }

    @Override // com.vivo.ad.view.IActionView
    public void playAnimation() {
        h hVar = this.f27002a;
        if (hVar != null) {
            hVar.playAnimation();
        }
    }
}
