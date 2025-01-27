package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
final class w implements b {
    w() {
    }

    @Override // com.opos.exoplayer.core.i.b
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.opos.exoplayer.core.i.b
    public g a(Looper looper, @Nullable Handler.Callback callback) {
        return new x(new Handler(looper, callback));
    }

    @Override // com.opos.exoplayer.core.i.b
    public long b() {
        return SystemClock.uptimeMillis();
    }
}
