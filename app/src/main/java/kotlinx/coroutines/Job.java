package kotlinx.coroutines;

import com.kwad.sdk.api.model.AdnName;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 -2\u00020\u0001:\u0001-J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\u0014\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH'J\u001a\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH&J\f\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH'JE\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H'J1\u0010\u001f\u001a\u00020 2'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H&J\u0011\u0010(\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0097\u0002J\b\u0010,\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", AdnName.OTHER, "start", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: Key, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        public static <R> R fold(@k Job job, R r10, @k Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(job, r10, function2);
        }

        @l
        public static <E extends CoroutineContext.Element> E get(@k Job job, @k CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(job, key);
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z10, boolean z11, Function1 function1, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return job.invokeOnCompletion(z10, z11, function1);
        }

        @k
        public static CoroutineContext minusKey(@k Job job, @k CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(job, key);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k
        public static Job plus(@k Job job, @k Job job2) {
            return job2;
        }

        public static /* synthetic */ boolean cancel$default(Job job, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return job.cancel(th2);
        }

        @k
        public static CoroutineContext plus(@k Job job, @k CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(job, coroutineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.Job$Key, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @InternalCoroutinesApi
    @k
    ChildHandle attachChild(@k ChildJob child);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@l CancellationException cause);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable cause);

    @InternalCoroutinesApi
    @k
    CancellationException getCancellationException();

    @k
    Sequence<Job> getChildren();

    @k
    SelectClause0 getOnJoin();

    @l
    Job getParent();

    @k
    DisposableHandle invokeOnCompletion(@k Function1<? super Throwable, Unit> handler);

    @InternalCoroutinesApi
    @k
    DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @k Function1<? super Throwable, Unit> handler);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @l
    Object join(@k Continuation<? super Unit> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @k
    Job plus(@k Job r12);

    boolean start();
}
