package com.martian.mibook.mvvm.utils.coroutine;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/ActivelyCancelException;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "()V", "fillInStackTrace", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActivelyCancelException.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivelyCancelException.kt\ncom/martian/mibook/mvvm/utils/coroutine/ActivelyCancelException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,13:1\n26#2:14\n*S KotlinDebug\n*F\n+ 1 ActivelyCancelException.kt\ncom/martian/mibook/mvvm/utils/coroutine/ActivelyCancelException\n*L\n8#1:14\n*E\n"})
/* loaded from: classes3.dex */
public final class ActivelyCancelException extends CancellationException {
    @Override // java.lang.Throwable
    @k
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
