package com.vivo.mobilead.d;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* loaded from: classes4.dex */
public interface c {
    void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3);

    void onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    void surfaceCreated(SurfaceHolder surfaceHolder);

    void surfaceDestroyed(SurfaceHolder surfaceHolder);
}
