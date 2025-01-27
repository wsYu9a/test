package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UArraySortingKt {
    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int m513partitionnroSd4(long[] r6, int r7, int r8) {
        /*
            int r0 = r7 + r8
            int r0 = r0 / 2
            long r0 = kotlin.ULongArray.m292getsVKNKU(r6, r0)
        L8:
            if (r7 > r8) goto L39
        La:
            long r2 = kotlin.ULongArray.m292getsVKNKU(r6, r7)
            int r2 = wh.e.a(r2, r0)
            if (r2 >= 0) goto L17
            int r7 = r7 + 1
            goto La
        L17:
            long r2 = kotlin.ULongArray.m292getsVKNKU(r6, r8)
            int r2 = wh.e.a(r2, r0)
            if (r2 <= 0) goto L24
            int r8 = r8 + (-1)
            goto L17
        L24:
            if (r7 > r8) goto L8
            long r2 = kotlin.ULongArray.m292getsVKNKU(r6, r7)
            long r4 = kotlin.ULongArray.m292getsVKNKU(r6, r8)
            kotlin.ULongArray.m297setk8EXiF4(r6, r7, r4)
            kotlin.ULongArray.m297setk8EXiF4(r6, r8, r2)
            int r7 = r7 + 1
            int r8 = r8 + (-1)
            goto L8
        L39:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.UArraySortingKt.m513partitionnroSd4(long[], int, int):int");
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c */
    private static final int m514partition4UcCI2c(byte[] bArr, int i10, int i11) {
        int i12;
        byte m134getw2LRezQ = UByteArray.m134getw2LRezQ(bArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                i12 = m134getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m134getw2LRezQ(bArr, i10) & 255, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (Intrinsics.compare(UByteArray.m134getw2LRezQ(bArr, i11) & 255, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                byte m134getw2LRezQ2 = UByteArray.m134getw2LRezQ(bArr, i10);
                UByteArray.m139setVurrAj0(bArr, i10, UByteArray.m134getw2LRezQ(bArr, i11));
                UByteArray.m139setVurrAj0(bArr, i11, m134getw2LRezQ2);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o */
    private static final int m515partitionAa5vz7o(short[] sArr, int i10, int i11) {
        int i12;
        short m397getMh2AYeg = UShortArray.m397getMh2AYeg(sArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                int m397getMh2AYeg2 = UShortArray.m397getMh2AYeg(sArr, i10) & UShort.MAX_VALUE;
                i12 = m397getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m397getMh2AYeg2, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (Intrinsics.compare(UShortArray.m397getMh2AYeg(sArr, i11) & UShort.MAX_VALUE, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                short m397getMh2AYeg3 = UShortArray.m397getMh2AYeg(sArr, i10);
                UShortArray.m402set01HTLdE(sArr, i10, UShortArray.m397getMh2AYeg(sArr, i11));
                UShortArray.m402set01HTLdE(sArr, i11, m397getMh2AYeg3);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int m516partitionoBK06Vg(int[] r3, int r4, int r5) {
        /*
            int r0 = r4 + r5
            int r0 = r0 / 2
            int r0 = kotlin.UIntArray.m213getpVg5ArA(r3, r0)
        L8:
            if (r4 > r5) goto L39
        La:
            int r1 = kotlin.UIntArray.m213getpVg5ArA(r3, r4)
            int r1 = wh.f.a(r1, r0)
            if (r1 >= 0) goto L17
            int r4 = r4 + 1
            goto La
        L17:
            int r1 = kotlin.UIntArray.m213getpVg5ArA(r3, r5)
            int r1 = wh.f.a(r1, r0)
            if (r1 <= 0) goto L24
            int r5 = r5 + (-1)
            goto L17
        L24:
            if (r4 > r5) goto L8
            int r1 = kotlin.UIntArray.m213getpVg5ArA(r3, r4)
            int r2 = kotlin.UIntArray.m213getpVg5ArA(r3, r5)
            kotlin.UIntArray.m218setVXSXFK8(r3, r4, r2)
            kotlin.UIntArray.m218setVXSXFK8(r3, r5, r1)
            int r4 = r4 + 1
            int r5 = r5 + (-1)
            goto L8
        L39:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.UArraySortingKt.m516partitionoBK06Vg(int[], int, int):int");
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4 */
    private static final void m517quickSortnroSd4(long[] jArr, int i10, int i11) {
        int m513partitionnroSd4 = m513partitionnroSd4(jArr, i10, i11);
        int i12 = m513partitionnroSd4 - 1;
        if (i10 < i12) {
            m517quickSortnroSd4(jArr, i10, i12);
        }
        if (m513partitionnroSd4 < i11) {
            m517quickSortnroSd4(jArr, m513partitionnroSd4, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c */
    private static final void m518quickSort4UcCI2c(byte[] bArr, int i10, int i11) {
        int m514partition4UcCI2c = m514partition4UcCI2c(bArr, i10, i11);
        int i12 = m514partition4UcCI2c - 1;
        if (i10 < i12) {
            m518quickSort4UcCI2c(bArr, i10, i12);
        }
        if (m514partition4UcCI2c < i11) {
            m518quickSort4UcCI2c(bArr, m514partition4UcCI2c, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o */
    private static final void m519quickSortAa5vz7o(short[] sArr, int i10, int i11) {
        int m515partitionAa5vz7o = m515partitionAa5vz7o(sArr, i10, i11);
        int i12 = m515partitionAa5vz7o - 1;
        if (i10 < i12) {
            m519quickSortAa5vz7o(sArr, i10, i12);
        }
        if (m515partitionAa5vz7o < i11) {
            m519quickSortAa5vz7o(sArr, m515partitionAa5vz7o, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg */
    private static final void m520quickSortoBK06Vg(int[] iArr, int i10, int i11) {
        int m516partitionoBK06Vg = m516partitionoBK06Vg(iArr, i10, i11);
        int i12 = m516partitionoBK06Vg - 1;
        if (i10 < i12) {
            m520quickSortoBK06Vg(iArr, i10, i12);
        }
        if (m516partitionoBK06Vg < i11) {
            m520quickSortoBK06Vg(iArr, m516partitionoBK06Vg, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4 */
    public static final void m521sortArraynroSd4(@k long[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m517quickSortnroSd4(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c */
    public static final void m522sortArray4UcCI2c(@k byte[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m518quickSort4UcCI2c(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o */
    public static final void m523sortArrayAa5vz7o(@k short[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m519quickSortAa5vz7o(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg */
    public static final void m524sortArrayoBK06Vg(@k int[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m520quickSortoBK06Vg(array, i10, i11 - 1);
    }
}
