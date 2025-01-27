package kotlin.collections;

import f.b.a.d;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0011H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlin/UByteArray;", "array", "", "left", "right", "partition-4UcCI2c", "([BII)I", "partition", "", "quickSort-4UcCI2c", "([BII)V", "quickSort", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray-GBYM_sE", "([B)V", "sortArray", "sortArray-rL5Bavg", "([S)V", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4 */
    private static final int m402partitionnroSd4(long[] jArr, int i2, int i3) {
        long m288getimpl = ULongArray.m288getimpl(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.ulongCompare(ULongArray.m288getimpl(jArr, i2), m288getimpl) < 0) {
                i2++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m288getimpl(jArr, i3), m288getimpl) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long m288getimpl2 = ULongArray.m288getimpl(jArr, i2);
                ULongArray.m293setk8EXiF4(jArr, i2, ULongArray.m288getimpl(jArr, i3));
                ULongArray.m293setk8EXiF4(jArr, i3, m288getimpl2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c */
    private static final int m403partition4UcCI2c(byte[] bArr, int i2, int i3) {
        int i4;
        byte m150getimpl = UByteArray.m150getimpl(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = m150getimpl & 255;
                if (Intrinsics.compare(UByteArray.m150getimpl(bArr, i2) & 255, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UByteArray.m150getimpl(bArr, i3) & 255, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte m150getimpl2 = UByteArray.m150getimpl(bArr, i2);
                UByteArray.m155setVurrAj0(bArr, i2, UByteArray.m150getimpl(bArr, i3));
                UByteArray.m155setVurrAj0(bArr, i3, m150getimpl2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o */
    private static final int m404partitionAa5vz7o(short[] sArr, int i2, int i3) {
        int i4;
        short m383getimpl = UShortArray.m383getimpl(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m383getimpl2 = UShortArray.m383getimpl(sArr, i2) & UShort.MAX_VALUE;
                i4 = m383getimpl & UShort.MAX_VALUE;
                if (Intrinsics.compare(m383getimpl2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UShortArray.m383getimpl(sArr, i3) & UShort.MAX_VALUE, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short m383getimpl3 = UShortArray.m383getimpl(sArr, i2);
                UShortArray.m388set01HTLdE(sArr, i2, UShortArray.m383getimpl(sArr, i3));
                UShortArray.m388set01HTLdE(sArr, i3, m383getimpl3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg */
    private static final int m405partitionoBK06Vg(int[] iArr, int i2, int i3) {
        int m219getimpl = UIntArray.m219getimpl(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.uintCompare(UIntArray.m219getimpl(iArr, i2), m219getimpl) < 0) {
                i2++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m219getimpl(iArr, i3), m219getimpl) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int m219getimpl2 = UIntArray.m219getimpl(iArr, i2);
                UIntArray.m224setVXSXFK8(iArr, i2, UIntArray.m219getimpl(iArr, i3));
                UIntArray.m224setVXSXFK8(iArr, i3, m219getimpl2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4 */
    private static final void m406quickSortnroSd4(long[] jArr, int i2, int i3) {
        int m402partitionnroSd4 = m402partitionnroSd4(jArr, i2, i3);
        int i4 = m402partitionnroSd4 - 1;
        if (i2 < i4) {
            m406quickSortnroSd4(jArr, i2, i4);
        }
        if (m402partitionnroSd4 < i3) {
            m406quickSortnroSd4(jArr, m402partitionnroSd4, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c */
    private static final void m407quickSort4UcCI2c(byte[] bArr, int i2, int i3) {
        int m403partition4UcCI2c = m403partition4UcCI2c(bArr, i2, i3);
        int i4 = m403partition4UcCI2c - 1;
        if (i2 < i4) {
            m407quickSort4UcCI2c(bArr, i2, i4);
        }
        if (m403partition4UcCI2c < i3) {
            m407quickSort4UcCI2c(bArr, m403partition4UcCI2c, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o */
    private static final void m408quickSortAa5vz7o(short[] sArr, int i2, int i3) {
        int m404partitionAa5vz7o = m404partitionAa5vz7o(sArr, i2, i3);
        int i4 = m404partitionAa5vz7o - 1;
        if (i2 < i4) {
            m408quickSortAa5vz7o(sArr, i2, i4);
        }
        if (m404partitionAa5vz7o < i3) {
            m408quickSortAa5vz7o(sArr, m404partitionAa5vz7o, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg */
    private static final void m409quickSortoBK06Vg(int[] iArr, int i2, int i3) {
        int m405partitionoBK06Vg = m405partitionoBK06Vg(iArr, i2, i3);
        int i4 = m405partitionoBK06Vg - 1;
        if (i2 < i4) {
            m409quickSortoBK06Vg(iArr, i2, i4);
        }
        if (m405partitionoBK06Vg < i3) {
            m409quickSortoBK06Vg(iArr, m405partitionoBK06Vg, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--ajY-9A */
    public static final void m410sortArrayajY9A(@d int[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m409quickSortoBK06Vg(array, 0, UIntArray.m220getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-GBYM_sE */
    public static final void m411sortArrayGBYM_sE(@d byte[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m407quickSort4UcCI2c(array, 0, UByteArray.m151getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-QwZRm1k */
    public static final void m412sortArrayQwZRm1k(@d long[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m406quickSortnroSd4(array, 0, ULongArray.m289getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-rL5Bavg */
    public static final void m413sortArrayrL5Bavg(@d short[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m408quickSortAa5vz7o(array, 0, UShortArray.m384getSizeimpl(array) - 1);
    }
}
