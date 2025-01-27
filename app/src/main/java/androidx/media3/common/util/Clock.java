package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

@UnstableApi
/* loaded from: classes.dex */
public interface Clock {
    public static final Clock DEFAULT = new SystemClock();

    HandlerWrapper createHandler(Looper looper, @Nullable Handler.Callback callback);

    long currentTimeMillis();

    long elapsedRealtime();

    void onThreadBlocked();

    long uptimeMillis();
}
