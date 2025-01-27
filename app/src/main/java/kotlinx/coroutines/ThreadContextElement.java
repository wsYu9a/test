package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/ThreadContextElement;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/coroutines/CoroutineContext$Element;", "restoreThreadContext", "", f.X, "Lkotlin/coroutines/CoroutineContext;", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ThreadContextElement<S> extends CoroutineContext.Element {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <S, R> R fold(@k ThreadContextElement<S> threadContextElement, R r10, @k Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(threadContextElement, r10, function2);
        }

        @l
        public static <S, E extends CoroutineContext.Element> E get(@k ThreadContextElement<S> threadContextElement, @k CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(threadContextElement, key);
        }

        @k
        public static <S> CoroutineContext minusKey(@k ThreadContextElement<S> threadContextElement, @k CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(threadContextElement, key);
        }

        @k
        public static <S> CoroutineContext plus(@k ThreadContextElement<S> threadContextElement, @k CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(threadContextElement, coroutineContext);
        }
    }

    void restoreThreadContext(@k CoroutineContext r12, S oldState);

    S updateThreadContext(@k CoroutineContext r12);
}
