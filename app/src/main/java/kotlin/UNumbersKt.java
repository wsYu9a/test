package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0017\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0017\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u001f\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0006\u001a\u00020\u0001*\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u0017\u0010\n\u001a\u00020\u0013*\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\f\u001a\u00020\u0013*\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u0010\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\u0006\u001a\u00020\u0001*\u00020\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010 \u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b\"\u0010 \u001a\u0017\u0010\n\u001a\u00020\u001e*\u00020\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010\f\u001a\u00020\u001e*\u00020\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010$\u001a\u001f\u0010\u0010\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u001f\u0010\u0012\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010'\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020)H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010\u0006\u001a\u00020\u0001*\u00020)H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010+\u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020)H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010+\u001a\u0017\u0010\n\u001a\u00020)*\u00020)H\u0087\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0017\u0010\f\u001a\u00020)*\u00020)H\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010/\u001a\u001f\u0010\u0010\u001a\u00020)*\u00020)2\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0012\u001a\u00020)*\u00020)2\u0006\u0010\r\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlin/UInt;", "", "countOneBits-WZ4Q5Ns", "(I)I", "countOneBits", "countLeadingZeroBits-WZ4Q5Ns", "countLeadingZeroBits", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit", "bitCount", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft", "rotateRight-V7xB4Y4", "rotateRight", "Lkotlin/ULong;", "countOneBits-VKZWuLQ", "(J)I", "countLeadingZeroBits-VKZWuLQ", "countTrailingZeroBits-VKZWuLQ", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeLowestOneBit-VKZWuLQ", "rotateLeft-JSWoG40", "(JI)J", "rotateRight-JSWoG40", "Lkotlin/UByte;", "countOneBits-7apg3OU", "(B)I", "countLeadingZeroBits-7apg3OU", "countTrailingZeroBits-7apg3OU", "takeHighestOneBit-7apg3OU", "(B)B", "takeLowestOneBit-7apg3OU", "rotateLeft-LxnNnR4", "(BI)B", "rotateRight-LxnNnR4", "Lkotlin/UShort;", "countOneBits-xj2QHRw", "(S)I", "countLeadingZeroBits-xj2QHRw", "countTrailingZeroBits-xj2QHRw", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit-xj2QHRw", "rotateLeft-olVBNx4", "(SI)S", "rotateRight-olVBNx4", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "UNumbersKt")
/* loaded from: classes5.dex */
public final class UNumbersKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countLeadingZeroBits-7apg3OU */
    private static final int m299countLeadingZeroBits7apg3OU(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countLeadingZeroBits-VKZWuLQ */
    private static final int m300countLeadingZeroBitsVKZWuLQ(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns */
    private static final int m301countLeadingZeroBitsWZ4Q5Ns(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countLeadingZeroBits-xj2QHRw */
    private static final int m302countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countOneBits-7apg3OU */
    private static final int m303countOneBits7apg3OU(byte b2) {
        return Integer.bitCount(UInt.m168constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countOneBits-VKZWuLQ */
    private static final int m304countOneBitsVKZWuLQ(long j2) {
        return Long.bitCount(j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countOneBits-WZ4Q5Ns */
    private static final int m305countOneBitsWZ4Q5Ns(int i2) {
        return Integer.bitCount(i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countOneBits-xj2QHRw */
    private static final int m306countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m168constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countTrailingZeroBits-7apg3OU */
    private static final int m307countTrailingZeroBits7apg3OU(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countTrailingZeroBits-VKZWuLQ */
    private static final int m308countTrailingZeroBitsVKZWuLQ(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns */
    private static final int m309countTrailingZeroBitsWZ4Q5Ns(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: countTrailingZeroBits-xj2QHRw */
    private static final int m310countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40 */
    private static final long m311rotateLeftJSWoG40(long j2, int i2) {
        return ULong.m237constructorimpl(Long.rotateLeft(j2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4 */
    private static final byte m312rotateLeftLxnNnR4(byte b2, int i2) {
        return UByte.m101constructorimpl(NumbersKt__NumbersKt.rotateLeft(b2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4 */
    private static final int m313rotateLeftV7xB4Y4(int i2, int i3) {
        return UInt.m168constructorimpl(Integer.rotateLeft(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4 */
    private static final short m314rotateLeftolVBNx4(short s, int i2) {
        return UShort.m334constructorimpl(NumbersKt__NumbersKt.rotateLeft(s, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40 */
    private static final long m315rotateRightJSWoG40(long j2, int i2) {
        return ULong.m237constructorimpl(Long.rotateRight(j2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4 */
    private static final byte m316rotateRightLxnNnR4(byte b2, int i2) {
        return UByte.m101constructorimpl(NumbersKt__NumbersKt.rotateRight(b2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4 */
    private static final int m317rotateRightV7xB4Y4(int i2, int i3) {
        return UInt.m168constructorimpl(Integer.rotateRight(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4 */
    private static final short m318rotateRightolVBNx4(short s, int i2) {
        return UShort.m334constructorimpl(NumbersKt__NumbersKt.rotateRight(s, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeHighestOneBit-7apg3OU */
    private static final byte m319takeHighestOneBit7apg3OU(byte b2) {
        return UByte.m101constructorimpl((byte) Integer.highestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeHighestOneBit-VKZWuLQ */
    private static final long m320takeHighestOneBitVKZWuLQ(long j2) {
        return ULong.m237constructorimpl(Long.highestOneBit(j2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeHighestOneBit-WZ4Q5Ns */
    private static final int m321takeHighestOneBitWZ4Q5Ns(int i2) {
        return UInt.m168constructorimpl(Integer.highestOneBit(i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeHighestOneBit-xj2QHRw */
    private static final short m322takeHighestOneBitxj2QHRw(short s) {
        return UShort.m334constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeLowestOneBit-7apg3OU */
    private static final byte m323takeLowestOneBit7apg3OU(byte b2) {
        return UByte.m101constructorimpl((byte) Integer.lowestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeLowestOneBit-VKZWuLQ */
    private static final long m324takeLowestOneBitVKZWuLQ(long j2) {
        return ULong.m237constructorimpl(Long.lowestOneBit(j2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeLowestOneBit-WZ4Q5Ns */
    private static final int m325takeLowestOneBitWZ4Q5Ns(int i2) {
        return UInt.m168constructorimpl(Integer.lowestOneBit(i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: takeLowestOneBit-xj2QHRw */
    private static final short m326takeLowestOneBitxj2QHRw(short s) {
        return UShort.m334constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }
}
