package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class m extends FutureTask<u> {

    /* renamed from: a */
    public final /* synthetic */ q f6386a;

    /* renamed from: b */
    public final /* synthetic */ l f6387b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.f6387b = lVar;
        this.f6386a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        o a10 = this.f6386a.a();
        if (a10.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (!isCancelled() && !a10.h()) {
                return;
            }
            a10.g();
            if (isCancelled() && isDone()) {
                return;
            }
            cancel(false);
        } catch (InterruptedException e10) {
            e10.toString();
        } catch (CancellationException unused) {
            a10.g();
        } catch (ExecutionException e11) {
            if (e11.getCause() == null || !(e11.getCause() instanceof HttpException)) {
                e11.toString();
                return;
            }
            HttpException httpException = (HttpException) e11.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th2) {
            throw new RuntimeException("An error occured while executing http request", th2);
        }
    }
}
