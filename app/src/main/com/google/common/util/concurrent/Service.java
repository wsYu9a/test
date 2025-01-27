package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@DoNotMock("Create an AbstractIdleService")
@a5.c
@p5.m
/* loaded from: classes2.dex */
public interface Service {

    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    public static abstract class a {
        public void a(State state, Throwable th2) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }
    }

    void a(a aVar, Executor executor);

    void b(long j10, TimeUnit timeUnit) throws TimeoutException;

    void c(long j10, TimeUnit timeUnit) throws TimeoutException;

    void d();

    @CanIgnoreReturnValue
    Service e();

    State f();

    void g();

    Throwable h();

    @CanIgnoreReturnValue
    Service i();

    boolean isRunning();
}
