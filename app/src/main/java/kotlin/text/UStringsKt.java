package kotlin.text;

import f.b.a.d;
import f.b.a.e;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0013\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0016\u0010\u0016\u001a\u00020\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0016\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001e\u0010\u0019\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001b\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a \u0010\u001c\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a \u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\u0018\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0010%\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlin/UByte;", "", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "toString", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "UStringsKt")
/* loaded from: classes5.dex */
public final class UStringsKt {
    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-JSWoG40 */
    public static final String m1041toStringJSWoG40(long j2, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return UnsignedKt.ulongToString(j2, checkRadix);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-LxnNnR4 */
    public static final String m1042toStringLxnNnR4(byte b2, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        String num = Integer.toString(b2 & 255, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-V7xB4Y4 */
    public static final String m1043toStringV7xB4Y4(int i2, int i3) {
        int checkRadix;
        long j2 = i2 & 4294967295L;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        String l = Long.toString(j2, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-olVBNx4 */
    public static final String m1044toStringolVBNx4(short s, int i2) {
        int checkRadix;
        int i3 = s & UShort.MAX_VALUE;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        String num = Integer.toString(i3, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(@d String toUByte) {
        Intrinsics.checkParameterIsNotNull(toUByte, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(toUByte);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUByte);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UByte toUByteOrNull(@d String toUByteOrNull) {
        Intrinsics.checkParameterIsNotNull(toUByteOrNull, "$this$toUByteOrNull");
        return toUByteOrNull(toUByteOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(@d String toUInt) {
        Intrinsics.checkParameterIsNotNull(toUInt, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(toUInt);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUInt);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UInt toUIntOrNull(@d String toUIntOrNull) {
        Intrinsics.checkParameterIsNotNull(toUIntOrNull, "$this$toUIntOrNull");
        return toUIntOrNull(toUIntOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(@d String toULong) {
        Intrinsics.checkParameterIsNotNull(toULong, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(toULong);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toULong);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULong toULongOrNull(@d String toULongOrNull) {
        Intrinsics.checkParameterIsNotNull(toULongOrNull, "$this$toULongOrNull");
        return toULongOrNull(toULongOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(@d String toUShort) {
        Intrinsics.checkParameterIsNotNull(toUShort, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(toUShort);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUShort);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UShort toUShortOrNull(@d String toUShortOrNull) {
        Intrinsics.checkParameterIsNotNull(toUShortOrNull, "$this$toUShortOrNull");
        return toUShortOrNull(toUShortOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(@d String toUByte, int i2) {
        Intrinsics.checkParameterIsNotNull(toUByte, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(toUByte, i2);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUByte);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UByte toUByteOrNull(@d String toUByteOrNull, int i2) {
        Intrinsics.checkParameterIsNotNull(toUByteOrNull, "$this$toUByteOrNull");
        UInt uIntOrNull = toUIntOrNull(toUByteOrNull, i2);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (UnsignedKt.uintCompare(data, UInt.m168constructorimpl(255)) > 0) {
            return null;
        }
        return UByte.m95boximpl(UByte.m101constructorimpl((byte) data));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(@d String toUInt, int i2) {
        Intrinsics.checkParameterIsNotNull(toUInt, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(toUInt, i2);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUInt);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UInt toUIntOrNull(@d String toUIntOrNull, int i2) {
        Intrinsics.checkParameterIsNotNull(toUIntOrNull, "$this$toUIntOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toUIntOrNull.charAt(0);
        int i4 = 1;
        if (charAt >= '0') {
            i4 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int m168constructorimpl = UInt.m168constructorimpl(i2);
        int i5 = 119304647;
        while (i4 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(toUIntOrNull.charAt(i4), i2);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i3, i5) > 0) {
                if (i5 == 119304647) {
                    i5 = UnsignedKt.m394uintDivideJ1ME1BU(-1, m168constructorimpl);
                    if (UnsignedKt.uintCompare(i3, i5) > 0) {
                    }
                }
                return null;
            }
            int m168constructorimpl2 = UInt.m168constructorimpl(i3 * m168constructorimpl);
            int m168constructorimpl3 = UInt.m168constructorimpl(UInt.m168constructorimpl(digitOf) + m168constructorimpl2);
            if (UnsignedKt.uintCompare(m168constructorimpl3, m168constructorimpl2) < 0) {
                return null;
            }
            i4++;
            i3 = m168constructorimpl3;
        }
        return UInt.m162boximpl(i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(@d String toULong, int i2) {
        Intrinsics.checkParameterIsNotNull(toULong, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(toULong, i2);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toULong);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULong toULongOrNull(@d String toULongOrNull, int i2) {
        Intrinsics.checkParameterIsNotNull(toULongOrNull, "$this$toULongOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        long j2 = -1;
        int i3 = 0;
        char charAt = toULongOrNull.charAt(0);
        if (charAt < '0') {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long m237constructorimpl = ULong.m237constructorimpl(i2);
        long j3 = 0;
        long j4 = 512409557603043100L;
        while (i3 < length) {
            if (CharsKt__CharJVMKt.digitOf(toULongOrNull.charAt(i3), i2) < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j3, j4) > 0) {
                if (j4 == 512409557603043100L) {
                    j4 = UnsignedKt.m396ulongDivideeb3DHEI(j2, m237constructorimpl);
                    if (UnsignedKt.ulongCompare(j3, j4) > 0) {
                    }
                }
                return null;
            }
            long m237constructorimpl2 = ULong.m237constructorimpl(j3 * m237constructorimpl);
            long m237constructorimpl3 = ULong.m237constructorimpl(ULong.m237constructorimpl(UInt.m168constructorimpl(r15) & 4294967295L) + m237constructorimpl2);
            if (UnsignedKt.ulongCompare(m237constructorimpl3, m237constructorimpl2) < 0) {
                return null;
            }
            i3++;
            j3 = m237constructorimpl3;
            j2 = -1;
        }
        return ULong.m231boximpl(j3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(@d String toUShort, int i2) {
        Intrinsics.checkParameterIsNotNull(toUShort, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(toUShort, i2);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUShort);
        throw null;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UShort toUShortOrNull(@d String toUShortOrNull, int i2) {
        Intrinsics.checkParameterIsNotNull(toUShortOrNull, "$this$toUShortOrNull");
        UInt uIntOrNull = toUIntOrNull(toUShortOrNull, i2);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (UnsignedKt.uintCompare(data, UInt.m168constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m328boximpl(UShort.m334constructorimpl((short) data));
    }
}
