package kotlin.collections;

import f.b.a.d;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\b\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0014\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0014\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\r0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "toUByteArray", "(Ljava/util/Collection;)[B", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "toUIntArray", "(Ljava/util/Collection;)[I", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "toULongArray", "(Ljava/util/Collection;)[J", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "toUShortArray", "(Ljava/util/Collection;)[S", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sum", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes5.dex */
class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@d Iterable<UByte> sum) {
        Intrinsics.checkParameterIsNotNull(sum, "$this$sum");
        Iterator<UByte> it = sum.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = UInt.m168constructorimpl(i2 + UInt.m168constructorimpl(it.next().getData() & 255));
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@d Iterable<UInt> sum) {
        Intrinsics.checkParameterIsNotNull(sum, "$this$sum");
        Iterator<UInt> it = sum.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = UInt.m168constructorimpl(i2 + it.next().getData());
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@d Iterable<ULong> sum) {
        Intrinsics.checkParameterIsNotNull(sum, "$this$sum");
        Iterator<ULong> it = sum.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 = ULong.m237constructorimpl(j2 + it.next().getData());
        }
        return j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@d Iterable<UShort> sum) {
        Intrinsics.checkParameterIsNotNull(sum, "$this$sum");
        Iterator<UShort> it = sum.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = UInt.m168constructorimpl(i2 + UInt.m168constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return i2;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(@d Collection<UByte> toUByteArray) {
        Intrinsics.checkParameterIsNotNull(toUByteArray, "$this$toUByteArray");
        byte[] m144constructorimpl = UByteArray.m144constructorimpl(toUByteArray.size());
        Iterator<UByte> it = toUByteArray.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            UByteArray.m155setVurrAj0(m144constructorimpl, i2, it.next().getData());
            i2++;
        }
        return m144constructorimpl;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(@d Collection<UInt> toUIntArray) {
        Intrinsics.checkParameterIsNotNull(toUIntArray, "$this$toUIntArray");
        int[] m213constructorimpl = UIntArray.m213constructorimpl(toUIntArray.size());
        Iterator<UInt> it = toUIntArray.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            UIntArray.m224setVXSXFK8(m213constructorimpl, i2, it.next().getData());
            i2++;
        }
        return m213constructorimpl;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(@d Collection<ULong> toULongArray) {
        Intrinsics.checkParameterIsNotNull(toULongArray, "$this$toULongArray");
        long[] m282constructorimpl = ULongArray.m282constructorimpl(toULongArray.size());
        Iterator<ULong> it = toULongArray.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            ULongArray.m293setk8EXiF4(m282constructorimpl, i2, it.next().getData());
            i2++;
        }
        return m282constructorimpl;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(@d Collection<UShort> toUShortArray) {
        Intrinsics.checkParameterIsNotNull(toUShortArray, "$this$toUShortArray");
        short[] m377constructorimpl = UShortArray.m377constructorimpl(toUShortArray.size());
        Iterator<UShort> it = toUShortArray.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            UShortArray.m388set01HTLdE(m377constructorimpl, i2, it.next().getData());
            i2++;
        }
        return m377constructorimpl;
    }
}
