package kotlin.collections.unsigned;

import f.b.a.d;
import java.util.List;
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
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\u001a\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u0006\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0006\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0013*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\"\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a2\u0010\"\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a2\u0010\"\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/UIntArray;", "", "index", "Lkotlin/UInt;", "elementAt-qFRl0hI", "([II)I", "elementAt", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByteArray;", "Lkotlin/UByte;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "elementAt-nggk6HY", "([SI)S", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, pn = "kotlin.collections", xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes5.dex */
class UArraysKt___UArraysJvmKt {
    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList--ajY-9A */
    public static final List<UInt> m442asListajY9A(@d int[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(asList);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-GBYM_sE */
    public static final List<UByte> m443asListGBYM_sE(@d byte[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(asList);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-QwZRm1k */
    public static final List<ULong> m444asListQwZRm1k(@d long[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(asList);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-rL5Bavg */
    public static final List<UShort> m445asListrL5Bavg(@d short[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(asList);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-2fe2U9s */
    public static final int m446binarySearch2fe2U9s(@d int[] binarySearch, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i3, i4, UIntArray.m220getSizeimpl(binarySearch));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i6], i2);
            if (uintCompare < 0) {
                i3 = i6 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* renamed from: binarySearch-2fe2U9s$default */
    public static /* synthetic */ int m447binarySearch2fe2U9s$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UIntArray.m220getSizeimpl(iArr);
        }
        return m446binarySearch2fe2U9s(iArr, i2, i3, i4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-EtDCXyQ */
    public static final int m448binarySearchEtDCXyQ(@d short[] binarySearch, short s, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UShortArray.m384getSizeimpl(binarySearch));
        int i4 = s & UShort.MAX_VALUE;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i6], i4);
            if (uintCompare < 0) {
                i2 = i6 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default */
    public static /* synthetic */ int m449binarySearchEtDCXyQ$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UShortArray.m384getSizeimpl(sArr);
        }
        return m448binarySearchEtDCXyQ(sArr, s, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-K6DWlUc */
    public static final int m450binarySearchK6DWlUc(@d long[] binarySearch, long j2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, ULongArray.m289getSizeimpl(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(binarySearch[i5], j2);
            if (ulongCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (ulongCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default */
    public static /* synthetic */ int m451binarySearchK6DWlUc$default(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = ULongArray.m289getSizeimpl(jArr);
        }
        return m450binarySearchK6DWlUc(jArr, j2, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-WpHrYlw */
    public static final int m452binarySearchWpHrYlw(@d byte[] binarySearch, byte b2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UByteArray.m151getSizeimpl(binarySearch));
        int i4 = b2 & 255;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(binarySearch[i6], i4);
            if (uintCompare < 0) {
                i2 = i6 + 1;
            } else {
                if (uintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default */
    public static /* synthetic */ int m453binarySearchWpHrYlw$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UByteArray.m151getSizeimpl(bArr);
        }
        return m452binarySearchWpHrYlw(bArr, b2, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-PpDY95g */
    private static final byte m454elementAtPpDY95g(@d byte[] bArr, int i2) {
        return UByteArray.m150getimpl(bArr, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-nggk6HY */
    private static final short m455elementAtnggk6HY(@d short[] sArr, int i2) {
        return UShortArray.m383getimpl(sArr, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-qFRl0hI */
    private static final int m456elementAtqFRl0hI(@d int[] iArr, int i2) {
        return UIntArray.m219getimpl(iArr, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-r7IrZao */
    private static final long m457elementAtr7IrZao(@d long[] jArr, int i2) {
        return ULongArray.m288getimpl(jArr, i2);
    }
}
