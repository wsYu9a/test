package aa;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public abstract class b extends a {
    public void q(int i10) {
        m().e(i10);
    }

    public void r() {
        m().g();
    }

    public Bitmap s() {
        return m().getCurrentViewBitmap();
    }

    public Bitmap t() {
        return m().getReuseBitmap();
    }

    public void u() {
        m().k();
    }

    public boolean v() {
        return m().o();
    }

    public void w(boolean z10) {
        m().setCacheEnabled(z10);
    }
}
