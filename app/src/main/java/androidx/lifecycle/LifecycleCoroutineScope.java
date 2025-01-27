package androidx.lifecycle;

import com.sigmob.sdk.downloader.core.breakpoint.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import xi.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J7\u0010\u0007\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ7\u0010\u0010\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ7\u0010\u0011\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "launchWhenCreated", "Lkotlinx/coroutines/Job;", e.f19025e, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchWhenResumed", "launchWhenStarted", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements CoroutineScope {
    @k
    /* renamed from: getLifecycle$lifecycle_runtime_ktx_release */
    public abstract Lifecycle getLifecycle();

    @k
    public final Job launchWhenCreated(@k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r82) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(r82, "block");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, r82, null), 3, null);
        return launch$default;
    }

    @k
    public final Job launchWhenResumed(@k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r82) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(r82, "block");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, r82, null), 3, null);
        return launch$default;
    }

    @k
    public final Job launchWhenStarted(@k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r82) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(r82, "block");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, r82, null), 3, null);
        return launch$default;
    }
}
