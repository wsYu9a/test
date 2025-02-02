package com.kwad.components.offline.api.core.api;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface IAsync {
    void execute(Runnable runnable);

    void runOnDefaultExecutor(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelay(Runnable runnable, long j10);

    void schedule(Runnable runnable, long j10, TimeUnit timeUnit);
}
