package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "(Ljava/util/List;I)I", "reverseElementIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", ExifInterface.GPS_DIRECTION_TRUE, "asReversed", "(Ljava/util/List;)Ljava/util/List;", "", "asReversedMutable", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes5.dex */
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    @d
    public static final <T> List<T> asReversed(@d List<? extends T> asReversed) {
        Intrinsics.checkParameterIsNotNull(asReversed, "$this$asReversed");
        return new ReversedListReadOnly(asReversed);
    }

    @d
    @JvmName(name = "asReversedMutable")
    public static final <T> List<T> asReversedMutable(@d List<T> asReversed) {
        Intrinsics.checkParameterIsNotNull(asReversed, "$this$asReversed");
        return new ReversedList(asReversed);
    }

    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(@d List<?> list, int i2) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i2 >= 0 && lastIndex >= i2) {
            return CollectionsKt__CollectionsKt.getLastIndex(list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)) + "].");
    }

    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(@d List<?> list, int i2) {
        int size = list.size();
        if (i2 >= 0 && size >= i2) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
