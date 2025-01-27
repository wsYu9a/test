package p5;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@DoNotMock("Use the methods in Futures (like immediateFuture) or SettableFuture")
@m
/* loaded from: classes2.dex */
public interface c0<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
