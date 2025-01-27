package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "complete", "", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CompletableJob extends Job {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@k CompletableJob completableJob, R r10, @k Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) Job.DefaultImpls.fold(completableJob, r10, function2);
        }

        @l
        public static <E extends CoroutineContext.Element> E get(@k CompletableJob completableJob, @k CoroutineContext.Key<E> key) {
            return (E) Job.DefaultImpls.get(completableJob, key);
        }

        @k
        public static CoroutineContext minusKey(@k CompletableJob completableJob, @k CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey(completableJob, key);
        }

        @k
        public static CoroutineContext plus(@k CompletableJob completableJob, @k CoroutineContext coroutineContext) {
            return Job.DefaultImpls.plus(completableJob, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k
        public static Job plus(@k CompletableJob completableJob, @k Job job) {
            return Job.DefaultImpls.plus((Job) completableJob, job);
        }
    }

    boolean complete();

    boolean completeExceptionally(@k Throwable exception);
}
