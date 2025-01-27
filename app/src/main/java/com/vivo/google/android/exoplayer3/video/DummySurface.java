package com.vivo.google.android.exoplayer3.video;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.view.Surface;
import com.vivo.google.android.exoplayer3.util.Util;

@TargetApi(17)
/* loaded from: classes4.dex */
public final class DummySurface extends Surface {
    static {
        String eglQueryString;
        if (Util.SDK_INT < 17 || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null) {
            return;
        }
        eglQueryString.contains("EGL_EXT_protected_content");
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        throw null;
    }
}
