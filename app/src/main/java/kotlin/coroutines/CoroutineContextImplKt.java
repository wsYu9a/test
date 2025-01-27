package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import f.b.a.e;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "getPolymorphicElement", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "minusPolymorphicKey", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(@d CoroutineContext.Element getPolymorphicElement, @d CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(getPolymorphicElement, "$this$getPolymorphicElement");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            if (getPolymorphicElement.getKey() == key) {
                return getPolymorphicElement;
            }
            return null;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(getPolymorphicElement.getKey())) {
            return null;
        }
        E e2 = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(getPolymorphicElement);
        if (e2 instanceof CoroutineContext.Element) {
            return e2;
        }
        return null;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final CoroutineContext minusPolymorphicKey(@d CoroutineContext.Element minusPolymorphicKey, @d CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(minusPolymorphicKey, "$this$minusPolymorphicKey");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return minusPolymorphicKey.getKey() == key ? EmptyCoroutineContext.INSTANCE : minusPolymorphicKey;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(minusPolymorphicKey.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(minusPolymorphicKey) == null) ? minusPolymorphicKey : EmptyCoroutineContext.INSTANCE;
    }
}
