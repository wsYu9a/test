package com.martian.libsliding.slider;

/* loaded from: classes3.dex */
public abstract class AutoSlider extends b {

    /* renamed from: h */
    protected SlideStatus f10524h;

    /* renamed from: i */
    protected int f10525i;

    public enum SlideStatus {
        SS_STOP,
        SS_START,
        SS_PAUSE
    }

    public abstract boolean A();

    protected abstract void B(int speed);

    public abstract boolean C();

    public abstract boolean D();

    public boolean E() {
        if (this.f10524h != SlideStatus.SS_START || !z()) {
            return false;
        }
        this.f10524h = SlideStatus.SS_PAUSE;
        return true;
    }

    public boolean F() {
        if (this.f10524h != SlideStatus.SS_PAUSE || !A()) {
            return false;
        }
        this.f10524h = SlideStatus.SS_START;
        return true;
    }

    public void G() {
        SlideStatus slideStatus = this.f10524h;
        if (slideStatus == SlideStatus.SS_START) {
            E();
        } else if (slideStatus == SlideStatus.SS_PAUSE) {
            F();
        }
    }

    public void H(int speed, boolean resume) {
        this.f10525i = speed;
        B(speed);
        if (resume) {
            this.f10524h = SlideStatus.SS_PAUSE;
            F();
        }
    }

    public boolean I() {
        SlideStatus slideStatus = this.f10524h;
        SlideStatus slideStatus2 = SlideStatus.SS_START;
        if (slideStatus == slideStatus2 || !C()) {
            return false;
        }
        this.f10524h = slideStatus2;
        return true;
    }

    public boolean J() {
        SlideStatus slideStatus = this.f10524h;
        SlideStatus slideStatus2 = SlideStatus.SS_STOP;
        if (slideStatus == slideStatus2 || !D()) {
            return false;
        }
        this.f10524h = slideStatus2;
        return true;
    }

    public SlideStatus w() {
        return this.f10524h;
    }

    public boolean x() {
        return this.f10524h == SlideStatus.SS_START;
    }

    public boolean y() {
        return this.f10524h == SlideStatus.SS_STOP;
    }

    public abstract boolean z();
}
