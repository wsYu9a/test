package androidx.media3.common.util;

import android.os.Looper;
import androidx.annotation.Nullable;

@UnstableApi
/* loaded from: classes.dex */
public interface HandlerWrapper {

    public interface Message {
        HandlerWrapper getTarget();

        void sendToTarget();
    }

    Looper getLooper();

    boolean hasMessages(int i10);

    Message obtainMessage(int i10);

    Message obtainMessage(int i10, int i11, int i12);

    Message obtainMessage(int i10, int i11, int i12, @Nullable Object obj);

    Message obtainMessage(int i10, @Nullable Object obj);

    boolean post(Runnable runnable);

    boolean postAtFrontOfQueue(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j10);

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int i10);

    boolean sendEmptyMessage(int i10);

    boolean sendEmptyMessageAtTime(int i10, long j10);

    boolean sendEmptyMessageDelayed(int i10, int i11);

    boolean sendMessageAtFrontOfQueue(Message message);
}
