package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import xi.k;
import xi.l;

@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt {
    @k
    public static final <T> Deferred<T> async(@k CoroutineScope coroutineScope, @k CoroutineContext coroutineContext, @k CoroutineStart coroutineStart, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @l
    public static final <T> Object invoke(@k CoroutineDispatcher coroutineDispatcher, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @k Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.invoke(coroutineDispatcher, function2, continuation);
    }

    @k
    public static final Job launch(@k CoroutineScope coroutineScope, @k CoroutineContext coroutineContext, @k CoroutineStart coroutineStart, @k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T runBlocking(@k CoroutineContext coroutineContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) BuildersKt__BuildersKt.runBlocking(coroutineContext, function2);
    }

    @l
    public static final <T> Object withContext(@k CoroutineContext coroutineContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @k Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.withContext(coroutineContext, function2, continuation);
    }
}
