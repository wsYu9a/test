package okio.internal;

import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001aa\u0010\u0014\u001a\u00020\u0012*\u00020\u00072K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0080\b¢\u0006\u0004\b\u0014\u0010\u0015\u001aq\u0010\u0014\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0082\b¢\u0006\u0004\b\u0014\u0010\u0018\u001a$\u0010\u001a\u001a\u00020\u0019*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u001c*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0014\u0010\u001f\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u0007H\u0080\b¢\u0006\u0004\b!\u0010\"\u001a,\u0010%\u001a\u00020\u0012*\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b%\u0010&\u001a4\u0010*\u001a\u00020)*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b*\u0010+\u001a4\u0010*\u001a\u00020)*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b*\u0010,\u001a\u001e\u0010.\u001a\u00020)*\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010-H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b0\u0010 ¨\u00061"}, d2 = {"", "", Downloads.RequestHeaders.COLUMN_VALUE, "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", MiConfigSingleton.t0, "offset", "byteCount", "", "action", "forEachSegment", "(Lokio/SegmentedByteString;Lkotlin/jvm/functions/Function3;)V", "beginIndex", "endIndex", "(Lokio/SegmentedByteString;IILkotlin/jvm/functions/Function3;)V", "Lokio/ByteString;", "commonSubstring", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "commonInternalGet", "(Lokio/SegmentedByteString;I)B", "commonGetSize", "(Lokio/SegmentedByteString;)I", "commonToByteArray", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "commonWrite", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", AdnName.OTHER, "otherOffset", "", "commonRangeEquals", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "(Lokio/SegmentedByteString;I[BII)Z", "", "commonEquals", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "commonHashCode", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@d int[] binarySearch, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = binarySearch[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else {
                if (i7 <= i2) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final boolean commonEquals(@d SegmentedByteString commonEquals, @e Object obj) {
        Intrinsics.checkParameterIsNotNull(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@d SegmentedByteString commonGetSize) {
        Intrinsics.checkParameterIsNotNull(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory()[commonGetSize.getSegments().length - 1];
    }

    public static final int commonHashCode(@d SegmentedByteString commonHashCode) {
        Intrinsics.checkParameterIsNotNull(commonHashCode, "$this$commonHashCode");
        int hashCode = commonHashCode.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = commonHashCode.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            int i5 = commonHashCode.getDirectory()[length + i2];
            int i6 = commonHashCode.getDirectory()[i2];
            byte[] bArr = commonHashCode.getSegments()[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        commonHashCode.setHashCode$okio(i4);
        return i4;
    }

    public static final byte commonInternalGet(@d SegmentedByteString commonInternalGet, int i2) {
        Intrinsics.checkParameterIsNotNull(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory()[commonInternalGet.getSegments().length - 1], i2, 1L);
        int segment = segment(commonInternalGet, i2);
        return commonInternalGet.getSegments()[segment][(i2 - (segment == 0 ? 0 : commonInternalGet.getDirectory()[segment - 1])) + commonInternalGet.getDirectory()[commonInternalGet.getSegments().length + segment]];
    }

    public static final boolean commonRangeEquals(@d SegmentedByteString commonRangeEquals, int i2, @d ByteString other, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (i2 < 0 || i2 > commonRangeEquals.size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = segment(commonRangeEquals, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : commonRangeEquals.getDirectory()[segment - 1];
            int i7 = commonRangeEquals.getDirectory()[segment] - i6;
            int i8 = commonRangeEquals.getDirectory()[commonRangeEquals.getSegments().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!other.rangeEquals(i3, commonRangeEquals.getSegments()[segment], i8 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }

    @d
    public static final ByteString commonSubstring(@d SegmentedByteString commonSubstring, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonSubstring, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
        if (!(i3 <= commonSubstring.size())) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + commonSubstring.size() + ')').toString());
        }
        int i4 = i3 - i2;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        if (i2 == 0 && i3 == commonSubstring.size()) {
            return commonSubstring;
        }
        if (i2 == i3) {
            return ByteString.EMPTY;
        }
        int segment = segment(commonSubstring, i2);
        int segment2 = segment(commonSubstring, i3 - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(commonSubstring.getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i5 = segment;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(commonSubstring.getDirectory()[i5] - i2, i4);
                int i7 = i6 + 1;
                iArr[i6 + bArr.length] = commonSubstring.getDirectory()[commonSubstring.getSegments().length + i5];
                if (i5 == segment2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = segment != 0 ? commonSubstring.getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i2 - i8);
        return new SegmentedByteString(bArr, iArr);
    }

    @d
    public static final byte[] commonToByteArray(@d SegmentedByteString commonToByteArray) {
        Intrinsics.checkParameterIsNotNull(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = commonToByteArray.getDirectory()[length + i2];
            int i6 = commonToByteArray.getDirectory()[i2];
            int i7 = i6 - i3;
            ArraysKt___ArraysJvmKt.copyInto(commonToByteArray.getSegments()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void commonWrite(@d SegmentedByteString commonWrite, @d Buffer buffer, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        int i4 = i3 + i2;
        int segment = segment(commonWrite, i2);
        while (i2 < i4) {
            int i5 = segment == 0 ? 0 : commonWrite.getDirectory()[segment - 1];
            int i6 = commonWrite.getDirectory()[segment] - i5;
            int i7 = commonWrite.getDirectory()[commonWrite.getSegments().length + segment];
            int min = Math.min(i4, i6 + i5) - i2;
            int i8 = i7 + (i2 - i5);
            Segment segment2 = new Segment(commonWrite.getSegments()[segment], i8, i8 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                if (segment3 == null) {
                    Intrinsics.throwNpe();
                }
                Segment segment4 = segment3.prev;
                if (segment4 == null) {
                    Intrinsics.throwNpe();
                }
                segment4.push(segment2);
            }
            i2 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + commonWrite.size());
    }

    public static final void forEachSegment(@d SegmentedByteString forEachSegment, @d Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEachSegment, "$this$forEachSegment");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int length = forEachSegment.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = forEachSegment.getDirectory()[length + i2];
            int i5 = forEachSegment.getDirectory()[i2];
            action.invoke(forEachSegment.getSegments()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int segment(@d SegmentedByteString segment, int i2) {
        Intrinsics.checkParameterIsNotNull(segment, "$this$segment");
        int binarySearch = binarySearch(segment.getDirectory(), i2 + 1, 0, segment.getSegments().length);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    public static final void forEachSegment(@d SegmentedByteString segmentedByteString, int i2, int i3, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i5 = segmentedByteString.getDirectory()[segment] - i4;
            int i6 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i3, i5 + i4) - i2;
            function3.invoke(segmentedByteString.getSegments()[segment], Integer.valueOf(i6 + (i2 - i4)), Integer.valueOf(min));
            i2 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@d SegmentedByteString commonRangeEquals, int i2, @d byte[] other, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (i2 < 0 || i2 > commonRangeEquals.size() - i4 || i3 < 0 || i3 > other.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = segment(commonRangeEquals, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : commonRangeEquals.getDirectory()[segment - 1];
            int i7 = commonRangeEquals.getDirectory()[segment] - i6;
            int i8 = commonRangeEquals.getDirectory()[commonRangeEquals.getSegments().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments()[segment], i8 + (i2 - i6), other, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }
}
