package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0007\u001a4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002¢\u0006\u0004\b\u0003\u0010\t\u001a4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u000b\u001a.\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\f\u0010\u0004\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\r\u0010\u0004\u001a6\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\r\u0010\u0007\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002¢\u0006\u0004\b\r\u0010\t\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000b\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "minus", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "(Ljava/util/Set;Ljava/lang/Iterable;)Ljava/util/Set;", "Lkotlin/sequences/Sequence;", "(Ljava/util/Set;Lkotlin/sequences/Sequence;)Ljava/util/Set;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/SetsKt")
/* loaded from: classes5.dex */
class SetsKt___SetsKt extends SetsKt__SetsKt {
    @d
    public static final <T> Set<T> minus(@d Set<? extends T> minus, T t) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(minus.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity);
        boolean z = false;
        for (T t2 : minus) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> minusElement(@d Set<? extends T> set, T t) {
        return minus(set, t);
    }

    @d
    public static final <T> Set<T> plus(@d Set<? extends T> plus, T t) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(plus.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(plus);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> plusElement(@d Set<? extends T> set, T t) {
        return plus(set, t);
    }

    @d
    public static final <T> Set<T> minus(@d Set<? extends T> minus, @d T[] elements) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(minus);
        CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @d
    public static final <T> Set<T> plus(@d Set<? extends T> plus, @d T[] elements) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(plus.size() + elements.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(plus);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @d
    public static final <T> Set<T> minus(@d Set<? extends T> minus, @d Iterable<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Collection<?> convertToSetForSetOperationWith = CollectionsKt__IterablesKt.convertToSetForSetOperationWith(elements, minus);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return CollectionsKt___CollectionsKt.toSet(minus);
        }
        if (convertToSetForSetOperationWith instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : minus) {
                if (!convertToSetForSetOperationWith.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(minus);
        linkedHashSet2.removeAll(convertToSetForSetOperationWith);
        return linkedHashSet2;
    }

    @d
    public static final <T> Set<T> plus(@d Set<? extends T> plus, @d Iterable<? extends T> elements) {
        int size;
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Integer collectionSizeOrNull = CollectionsKt__IterablesKt.collectionSizeOrNull(elements);
        if (collectionSizeOrNull != null) {
            size = plus.size() + collectionSizeOrNull.intValue();
        } else {
            size = plus.size() * 2;
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(size);
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(plus);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @d
    public static final <T> Set<T> plus(@d Set<? extends T> plus, @d Sequence<? extends T> elements) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(plus.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(plus);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @d
    public static final <T> Set<T> minus(@d Set<? extends T> minus, @d Sequence<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(minus);
        CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }
}
