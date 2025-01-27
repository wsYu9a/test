package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\f\u001a/\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\t\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u000b\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b¢\u0006\u0004\b\u000b\u0010\n\u001a*\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\n¢\u0006\u0004\b\r\u0010\u0010\u001a0\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0087\n¢\u0006\u0004\b\r\u0010\u0012\u001a0\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n¢\u0006\u0004\b\r\u0010\u0014\u001a*\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u0015\u0010\u000e\u001a0\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\n¢\u0006\u0004\b\u0015\u0010\u0010\u001a0\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0012\u001a0\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0014\u001a-\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0016\u0010\u0018\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0016\u0010\u0019\u001a-\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\t\u0010\u0017\u001a-\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\t\u0010\u0018\u001a/\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\t\u0010\u0019\u001a-\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u000b\u0010\u0017\u001a/\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u000b\u0010\u0019\u001a-\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u000b\u0010\u0018\u001a\u0017\u0010\u001c\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0004\b\t\u0010 \u001a1\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0004\b\u000b\u0010 \u001a;\u0010$\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#\u001a-\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b(\u0010)\u001a(\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010,\u001a\u00020+H\u0087\b¢\u0006\u0004\b\u0005\u0010-\u001a\u001f\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*H\u0007¢\u0006\u0004\b.\u0010/\u001a!\u00100\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*H\u0007¢\u0006\u0004\b0\u0010/\u001a\u001f\u00101\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*H\u0007¢\u0006\u0004\b1\u0010/\u001a!\u00102\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*H\u0007¢\u0006\u0004\b2\u0010/\u001a1\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0004\b\t\u00103\u001a1\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0004\b\u000b\u00103\u001a;\u0010$\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u00104\u001a'\u00105\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "remove", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "elements", "removeAll", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "retainAll", "", "plusAssign", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "(Ljava/util/Collection;Ljava/lang/Iterable;)V", "", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/Sequence;", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)V", "minusAssign", "addAll", "(Ljava/util/Collection;Ljava/lang/Iterable;)Z", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)Z", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "retainNothing$CollectionsKt__MutableCollectionsKt", "(Ljava/util/Collection;)Z", "retainNothing", "", "Lkotlin/Function1;", "predicate", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Z", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;Z)Z", "filterInPlace", "Lkotlin/random/Random;", "random", "", "shuffled", "(Ljava/lang/Iterable;Lkotlin/random/Random;)Ljava/util/List;", "", "", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Z", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Z)Z", "shuffle", "(Ljava/util/List;Lkotlin/random/Random;)V", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean addAll(@d Collection<? super T> addAll, @d Iterable<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(addAll, "$this$addAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        if (elements instanceof Collection) {
            return addAll.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (addAll.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@d Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @InlineOnly
    private static final <T> void minusAssign(@d Collection<? super T> minusAssign, T t) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        minusAssign.remove(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void plusAssign(@d Collection<? super T> plusAssign, T t) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        plusAssign.add(t);
    }

    @InlineOnly
    private static final <T> boolean remove(@d Collection<? extends T> collection, T t) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).remove(t);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @InlineOnly
    private static final <T> boolean removeAll(@d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <T> T removeFirst(@d List<T> removeFirst) {
        Intrinsics.checkParameterIsNotNull(removeFirst, "$this$removeFirst");
        if (removeFirst.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return removeFirst.remove(0);
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <T> T removeFirstOrNull(@d List<T> removeFirstOrNull) {
        Intrinsics.checkParameterIsNotNull(removeFirstOrNull, "$this$removeFirstOrNull");
        if (removeFirstOrNull.isEmpty()) {
            return null;
        }
        return removeFirstOrNull.remove(0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <T> T removeLast(@d List<T> removeLast) {
        Intrinsics.checkParameterIsNotNull(removeLast, "$this$removeLast");
        if (removeLast.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return removeLast.remove(CollectionsKt__CollectionsKt.getLastIndex(removeLast));
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <T> T removeLastOrNull(@d List<T> removeLastOrNull) {
        Intrinsics.checkParameterIsNotNull(removeLastOrNull, "$this$removeLastOrNull");
        if (removeLastOrNull.isEmpty()) {
            return null;
        }
        return removeLastOrNull.remove(CollectionsKt__CollectionsKt.getLastIndex(removeLastOrNull));
    }

    @InlineOnly
    private static final <T> boolean retainAll(@d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(@d Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void shuffle(@d List<T> shuffle, @d Random random) {
        Intrinsics.checkParameterIsNotNull(shuffle, "$this$shuffle");
        Intrinsics.checkParameterIsNotNull(random, "random");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(shuffle); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            T t = shuffle.get(lastIndex);
            shuffle.set(lastIndex, shuffle.get(nextInt));
            shuffle.set(nextInt, t);
        }
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <T> List<T> shuffled(@d Iterable<? extends T> shuffled, @d Random random) {
        Intrinsics.checkParameterIsNotNull(shuffled, "$this$shuffled");
        Intrinsics.checkParameterIsNotNull(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(shuffled);
        shuffle(mutableList, random);
        return mutableList;
    }

    @InlineOnly
    private static final <T> void minusAssign(@d Collection<? super T> minusAssign, Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, iterable);
    }

    @InlineOnly
    private static final <T> void plusAssign(@d Collection<? super T> plusAssign, Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        addAll(plusAssign, iterable);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T remove(@d List<T> list, int i2) {
        return list.remove(i2);
    }

    public static final <T> boolean removeAll(@d Collection<? super T> removeAll, @d Iterable<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return TypeIntrinsics.asMutableCollection(removeAll).removeAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(elements, removeAll));
    }

    public static final <T> boolean retainAll(@d Collection<? super T> retainAll, @d Iterable<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(retainAll, "$this$retainAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return TypeIntrinsics.asMutableCollection(retainAll).retainAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(elements, retainAll));
    }

    @InlineOnly
    private static final <T> void minusAssign(@d Collection<? super T> minusAssign, T[] tArr) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, tArr);
    }

    @InlineOnly
    private static final <T> void plusAssign(@d Collection<? super T> plusAssign, T[] tArr) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        addAll(plusAssign, tArr);
    }

    public static final <T> boolean removeAll(@d Collection<? super T> removeAll, @d Sequence<? extends T> elements) {
        HashSet hashSet;
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        hashSet = SequencesKt___SequencesKt.toHashSet(elements);
        return (hashSet.isEmpty() ^ true) && removeAll.removeAll(hashSet);
    }

    public static final <T> boolean retainAll(@d Collection<? super T> retainAll, @d T[] elements) {
        HashSet hashSet;
        Intrinsics.checkParameterIsNotNull(retainAll, "$this$retainAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        if (!(elements.length == 0)) {
            hashSet = ArraysKt___ArraysKt.toHashSet(elements);
            return retainAll.retainAll(hashSet);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(retainAll);
    }

    public static <T> boolean addAll(@d Collection<? super T> addAll, @d Sequence<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(addAll, "$this$addAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (addAll.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @InlineOnly
    private static final <T> void minusAssign(@d Collection<? super T> minusAssign, Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, sequence);
    }

    @InlineOnly
    private static final <T> void plusAssign(@d Collection<? super T> plusAssign, Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        addAll(plusAssign, sequence);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@d List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            if (list != null) {
                return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (function1.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex2 < i2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i2) {
                return true;
            }
            lastIndex2--;
        }
    }

    public static final <T> boolean removeAll(@d Collection<? super T> removeAll, @d T[] elements) {
        HashSet hashSet;
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        if (!(!(elements.length == 0))) {
            return false;
        }
        hashSet = ArraysKt___ArraysKt.toHashSet(elements);
        return removeAll.removeAll(hashSet);
    }

    public static final <T> boolean addAll(@d Collection<? super T> addAll, @d T[] elements) {
        List asList;
        Intrinsics.checkParameterIsNotNull(addAll, "$this$addAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        asList = ArraysKt___ArraysJvmKt.asList(elements);
        return addAll.addAll(asList);
    }

    public static final <T> boolean removeAll(@d Iterable<? extends T> removeAll, @d Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) removeAll, (Function1) predicate, true);
    }

    public static final <T> boolean retainAll(@d Collection<? super T> retainAll, @d Sequence<? extends T> elements) {
        HashSet hashSet;
        Intrinsics.checkParameterIsNotNull(retainAll, "$this$retainAll");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        hashSet = SequencesKt___SequencesKt.toHashSet(elements);
        if (!hashSet.isEmpty()) {
            return retainAll.retainAll(hashSet);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(retainAll);
    }

    public static final <T> boolean removeAll(@d List<T> removeAll, @d Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) removeAll, (Function1) predicate, true);
    }

    public static <T> boolean retainAll(@d Iterable<? extends T> retainAll, @d Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(retainAll, "$this$retainAll");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) retainAll, (Function1) predicate, false);
    }

    public static final <T> boolean retainAll(@d List<T> retainAll, @d Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(retainAll, "$this$retainAll");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) retainAll, (Function1) predicate, false);
    }
}
