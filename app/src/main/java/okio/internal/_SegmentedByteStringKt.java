package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kwad.sdk.api.model.AdnName;
import h3.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\bø\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", TypedValues.CycleType.S_WAVE_OFFSET, "target", "", "targetOffset", "byteCount", "commonEquals", "", AdnName.OTHER, "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", e.f26408m, "segment", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class _SegmentedByteStringKt {
    public static final int binarySearch(@k int[] iArr, int i10, int i11, int i12) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final void commonCopyInto(@k SegmentedByteString segmentedByteString, int i10, @k byte[] target, int i11, int i12) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        long j10 = i12;
        _UtilKt.checkOffsetAndCount(segmentedByteString.size(), i10, j10);
        _UtilKt.checkOffsetAndCount(target.length, i11, j10);
        int i13 = i12 + i10;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i15 = segmentedByteString.getDirectory()[segment] - i14;
            int i16 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            int i17 = i16 + (i10 - i14);
            ArraysKt.copyInto(segmentedByteString.getSegments()[segment], target, i11, i17, i17 + min);
            i11 += min;
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@k SegmentedByteString segmentedByteString, @l Object obj) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@k SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(@k SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int hashCode = segmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = segmentedByteString.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < length) {
            int i13 = segmentedByteString.getDirectory()[length + i10];
            int i14 = segmentedByteString.getDirectory()[i10];
            byte[] bArr = segmentedByteString.getSegments()[i10];
            int i15 = (i14 - i11) + i13;
            while (i13 < i15) {
                i12 = (i12 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i11 = i14;
        }
        segmentedByteString.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(@k SegmentedByteString segmentedByteString, int i10) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        _UtilKt.checkOffsetAndCount(segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1], i10, 1L);
        int segment = segment(segmentedByteString, i10);
        return segmentedByteString.getSegments()[segment][(i10 - (segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1])) + segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment]];
    }

    public static final boolean commonRangeEquals(@k SegmentedByteString segmentedByteString, int i10, @k ByteString other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i10 < 0 || i10 > segmentedByteString.size() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i15 = segmentedByteString.getDirectory()[segment] - i14;
            int i16 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!other.rangeEquals(i11, segmentedByteString.getSegments()[segment], i16 + (i10 - i14), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }

    @k
    public static final ByteString commonSubstring(@k SegmentedByteString segmentedByteString, int i10, int i11) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString, i11);
        if (i10 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
        if (resolveDefaultParameter > segmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i12 = resolveDefaultParameter - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i10).toString());
        }
        if (i10 == 0 && resolveDefaultParameter == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i10 == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int segment = segment(segmentedByteString, i10);
        int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(segmentedByteString.getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i13 = segment;
            int i14 = 0;
            while (true) {
                iArr[i14] = Math.min(segmentedByteString.getDirectory()[i13] - i10, i12);
                int i15 = i14 + 1;
                iArr[i14 + bArr.length] = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + i13];
                if (i13 == segment2) {
                    break;
                }
                i13++;
                i14 = i15;
            }
        }
        int i16 = segment != 0 ? segmentedByteString.getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i10 - i16);
        return new SegmentedByteString(bArr, iArr);
    }

    @k
    public static final byte[] commonToByteArray(@k SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = segmentedByteString.getDirectory()[length + i10];
            int i14 = segmentedByteString.getDirectory()[i10];
            int i15 = i14 - i11;
            ArraysKt.copyInto(segmentedByteString.getSegments()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public static final void commonWrite(@k SegmentedByteString segmentedByteString, @k Buffer buffer, int i10, int i11) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i12 = i10 + i11;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i12) {
            int i13 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i14 = segmentedByteString.getDirectory()[segment] - i13;
            int i15 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            Segment segment2 = new Segment(segmentedByteString.getSegments()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i10 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i11);
    }

    public static final void forEachSegment(@k SegmentedByteString segmentedByteString, @k Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = segmentedByteString.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = segmentedByteString.getDirectory()[length + i10];
            int i13 = segmentedByteString.getDirectory()[i10];
            action.invoke(segmentedByteString.getSegments()[i10], Integer.valueOf(i12), Integer.valueOf(i13 - i11));
            i10++;
            i11 = i13;
        }
    }

    public static final int segment(@k SegmentedByteString segmentedByteString, int i10) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int binarySearch = binarySearch(segmentedByteString.getDirectory(), i10 + 1, 0, segmentedByteString.getSegments().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i10, int i11, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(segmentedByteString, i10);
        while (i10 < i11) {
            int i12 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i13 = segmentedByteString.getDirectory()[segment] - i12;
            int i14 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i11, i13 + i12) - i10;
            function3.invoke(segmentedByteString.getSegments()[segment], Integer.valueOf(i14 + (i10 - i12)), Integer.valueOf(min));
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@k SegmentedByteString segmentedByteString, int i10, @k byte[] other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i10 < 0 || i10 > segmentedByteString.size() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i15 = segmentedByteString.getDirectory()[segment] - i14;
            int i16 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!_UtilKt.arrayRangeEquals(segmentedByteString.getSegments()[segment], i16 + (i10 - i14), other, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }
}
