package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/CopyableThreadContextElement;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "mergeForChild", "Lkotlin/coroutines/CoroutineContext;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext$Element;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
/* loaded from: classes4.dex */
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <S, R> R fold(@k CopyableThreadContextElement<S> copyableThreadContextElement, R r10, @k Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) ThreadContextElement.DefaultImpls.fold(copyableThreadContextElement, r10, function2);
        }

        @l
        public static <S, E extends CoroutineContext.Element> E get(@k CopyableThreadContextElement<S> copyableThreadContextElement, @k CoroutineContext.Key<E> key) {
            return (E) ThreadContextElement.DefaultImpls.get(copyableThreadContextElement, key);
        }

        @k
        public static <S> CoroutineContext minusKey(@k CopyableThreadContextElement<S> copyableThreadContextElement, @k CoroutineContext.Key<?> key) {
            return ThreadContextElement.DefaultImpls.minusKey(copyableThreadContextElement, key);
        }

        @k
        public static <S> CoroutineContext plus(@k CopyableThreadContextElement<S> copyableThreadContextElement, @k CoroutineContext coroutineContext) {
            return ThreadContextElement.DefaultImpls.plus(copyableThreadContextElement, coroutineContext);
        }
    }

    @k
    CopyableThreadContextElement<S> copyForChild();

    @k
    CoroutineContext mergeForChild(@k CoroutineContext.Element overwritingElement);
}
