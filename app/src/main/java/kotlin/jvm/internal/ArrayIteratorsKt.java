package kotlin.jvm.internal;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0015\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0015\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\r\u001a\u0015\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u000e¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0015\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0015\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u0014¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0015\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0017¢\u0006\u0004\b\u0003\u0010\u0019¨\u0006\u001a"}, d2 = {"", "array", "Lkotlin/collections/ByteIterator;", "iterator", "([B)Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "([C)Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/ShortIterator;", "([S)Lkotlin/collections/ShortIterator;", "", "Lkotlin/collections/IntIterator;", "([I)Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "([J)Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/FloatIterator;", "([F)Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/DoubleIterator;", "([D)Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/BooleanIterator;", "([Z)Lkotlin/collections/BooleanIterator;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class ArrayIteratorsKt {
    @d
    public static final ByteIterator iterator(@d byte[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayByteIterator(array);
    }

    @d
    public static final CharIterator iterator(@d char[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayCharIterator(array);
    }

    @d
    public static final ShortIterator iterator(@d short[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayShortIterator(array);
    }

    @d
    public static final IntIterator iterator(@d int[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayIntIterator(array);
    }

    @d
    public static final LongIterator iterator(@d long[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayLongIterator(array);
    }

    @d
    public static final FloatIterator iterator(@d float[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayFloatIterator(array);
    }

    @d
    public static final DoubleIterator iterator(@d double[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayDoubleIterator(array);
    }

    @d
    public static final BooleanIterator iterator(@d boolean[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        return new ArrayBooleanIterator(array);
    }
}
