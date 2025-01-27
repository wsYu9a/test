package com.martian.libsliding.slider;

import aa.b;

/* loaded from: classes3.dex */
public abstract class AutoSlider extends b {

    /* renamed from: h */
    public SlideStatus f12938h;

    /* renamed from: i */
    public int f12939i;

    public enum SlideStatus {
        SS_STOP,
        SS_START,
        SS_PAUSE
    }

    public abstract boolean A();

    public abstract boolean B();

    public abstract void C(int i10);

    public abstract boolean D();

    public abstract boolean E();

    public boolean F() {
        if (this.f12938h != SlideStatus.SS_START || !A()) {
            return false;
        }
        this.f12938h = SlideStatus.SS_PAUSE;
        return true;
    }

    public boolean G() {
        if (this.f12938h != SlideStatus.SS_PAUSE || !B()) {
            return false;
        }
        this.f12938h = SlideStatus.SS_START;
        return true;
    }

    public void H() {
        SlideStatus slideStatus = this.f12938h;
        if (slideStatus == SlideStatus.SS_START) {
            F();
        } else if (slideStatus == SlideStatus.SS_PAUSE) {
            G();
        }
    }

    public void I(int i10, boolean z10) {
        this.f12939i = i10;
        C(i10);
        if (z10) {
            this.f12938h = SlideStatus.SS_PAUSE;
            G();
        }
    }

    public boolean J() {
        SlideStatus slideStatus = this.f12938h;
        SlideStatus slideStatus2 = SlideStatus.SS_START;
        if (slideStatus == slideStatus2 || !D()) {
            return false;
        }
        this.f12938h = slideStatus2;
        return true;
    }

    public boolean K() {
        SlideStatus slideStatus = this.f12938h;
        SlideStatus slideStatus2 = SlideStatus.SS_STOP;
        if (slideStatus == slideStatus2 || !E()) {
            return false;
        }
        this.f12938h = slideStatus2;
        return true;
    }

    public SlideStatus x() {
        return this.f12938h;
    }

    public boolean y() {
        return this.f12938h == SlideStatus.SS_START;
    }

    public boolean z() {
        return this.f12938h == SlideStatus.SS_STOP;
    }
}
