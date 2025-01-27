package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes4.dex */
class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@k Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 = UInt.m153constructorimpl(i10 + UInt.m153constructorimpl(it.next().getData() & 255));
        }
        return i10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@k Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 = UInt.m153constructorimpl(i10 + it.next().getData());
        }
        return i10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@k Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 = ULong.m232constructorimpl(j10 + it.next().getData());
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@k Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 = UInt.m153constructorimpl(i10 + UInt.m153constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return i10;
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(@k Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m128constructorimpl = UByteArray.m128constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            UByteArray.m139setVurrAj0(m128constructorimpl, i10, it.next().getData());
            i10++;
        }
        return m128constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(@k Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m207constructorimpl = UIntArray.m207constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            UIntArray.m218setVXSXFK8(m207constructorimpl, i10, it.next().getData());
            i10++;
        }
        return m207constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(@k Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m286constructorimpl = ULongArray.m286constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            ULongArray.m297setk8EXiF4(m286constructorimpl, i10, it.next().getData());
            i10++;
        }
        return m286constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @k
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(@k Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m391constructorimpl = UShortArray.m391constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            UShortArray.m402set01HTLdE(m391constructorimpl, i10, it.next().getData());
            i10++;
        }
        return m391constructorimpl;
    }
}
