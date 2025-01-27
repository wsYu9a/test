package com.vivo.google.android.exoplayer3;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class ExoPlaybackException extends Exception {
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public final int rendererIndex;
    public final int type;

    public ExoPlaybackException(int i2, String str, Throwable th, int i3) {
        super(str, th);
        this.type = i2;
        this.rendererIndex = i3;
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i2) {
        return new ExoPlaybackException(1, null, exc, i2);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, null, runtimeException, -1);
    }

    public Exception getRendererException() {
        g1.b(this.type == 1);
        return (Exception) getCause();
    }

    public IOException getSourceException() {
        g1.b(this.type == 0);
        return (IOException) getCause();
    }

    public RuntimeException getUnexpectedException() {
        g1.b(this.type == 2);
        return (RuntimeException) getCause();
    }
}
