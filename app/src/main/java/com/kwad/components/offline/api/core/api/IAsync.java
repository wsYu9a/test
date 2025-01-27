package com.kwad.components.offline.api.core.api;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface IAsync {
    void execute(Runnable runnable);

    void runOnDefaultExecutor(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelay(Runnable runnable, long j2);

    void schedule(Runnable runnable, long j2, TimeUnit timeUnit);
}
