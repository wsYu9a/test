package kotlin.coroutines.experimental.migration;

import com.cdo.oaps.ad.Launcher;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B#\u0012\u001a\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R-\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction0Migration;", "R", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "continuation", Launcher.Method.INVOKE_CALLBACK, "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "function", "Lkotlin/jvm/functions/Function1;", "getFunction", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class ExperimentalSuspendFunction0Migration<R> implements Function1<Continuation<? super R>, Object> {

    @d
    private final Function1<kotlin.coroutines.Continuation<? super R>, Object> function;

    /* JADX WARN: Multi-variable type inference failed */
    public ExperimentalSuspendFunction0Migration(@d Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        this.function = function;
    }

    @d
    public final Function1<kotlin.coroutines.Continuation<? super R>, Object> getFunction() {
        return this.function;
    }

    @Override // kotlin.jvm.functions.Function1
    @e
    public Object invoke(@d Continuation<? super R> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return this.function.invoke(CoroutinesMigrationKt.toContinuation(continuation));
    }
}
