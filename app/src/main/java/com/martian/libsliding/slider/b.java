package com.martian.libsliding.slider;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class b extends a {
    public void o(int direction) {
        k().d(direction);
    }

    public void p(boolean forceRedraw, int direction) {
        k().e(forceRedraw, direction);
    }

    public void q() {
        k().f();
    }

    public Bitmap r() {
        return k().getCurrentViewBitmap();
    }

    public Bitmap s() {
        return k().getReuseBitmap();
    }

    protected void t() {
        k().j();
    }

    public boolean u() {
        return k().m();
    }

    public void v(boolean enable) {
        k().setCacheEnabled(enable);
    }
}
