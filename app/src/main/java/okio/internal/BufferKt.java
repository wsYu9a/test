package okio.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import com.tencent.open.SocialConstants;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.mozilla.universalchardet.prober.g;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0012\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a>\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u000bH\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010'\u001a\u00020&*\u00020\u000bH\u0080\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b+\u0010\"\u001a\u001c\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010,\u001a\u00020\fH\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u000bH\u0080\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00102\u001a\u00020/*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b2\u00103\u001a0\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00109\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010;\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b;\u0010:\u001a\u001c\u0010=\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010<\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b=\u0010>\u001a\u001c\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\b6\u0010@\u001a,\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b6\u0010A\u001a\u0014\u0010B\u001a\u00020\u0004*\u00020\u000bH\u0080\b¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010B\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bB\u0010D\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bF\u0010G\u001a\u001c\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bH\u0010I\u001a,\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bF\u0010J\u001a\u0014\u0010K\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bK\u0010\"\u001a\u0014\u0010L\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bL\u0010\"\u001a\u0014\u0010M\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010M\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bM\u0010O\u001a\u001c\u0010P\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\b¢\u0006\u0004\bP\u0010Q\u001a$\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bH\u0010R\u001a\u001c\u0010T\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020SH\u0080\b¢\u0006\u0004\bT\u0010U\u001a\u001c\u0010V\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bV\u0010\u0010\u001a\u0016\u0010W\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\u0080\b¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010Z\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010Y\u001a\u00020\fH\u0080\b¢\u0006\u0004\bZ\u0010\u0010\u001a\u0014\u0010[\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b[\u0010*\u001a,\u0010_\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010b\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010a\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010e\u001a\u00020\f*\u00020\u000b2\u0006\u0010?\u001a\u00020dH\u0080\b¢\u0006\u0004\be\u0010f\u001a$\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020d2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b6\u0010g\u001a\u001c\u0010i\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010h\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bi\u0010c\u001a\u001c\u0010k\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010j\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bk\u0010c\u001a\u001c\u0010m\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010l\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bm\u0010c\u001a\u001c\u0010n\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\bn\u0010:\u001a$\u00106\u001a\u00020/*\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b6\u0010R\u001a$\u0010F\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bF\u0010o\u001a,\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010h\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010p\u001a\u00020\fH\u0080\b¢\u0006\u0004\bq\u0010r\u001a$\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bq\u0010s\u001a$\u0010u\u001a\u00020\f*\u00020\u000b2\u0006\u0010t\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bu\u0010s\u001a4\u0010v\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bv\u0010w\u001a\u001e\u0010z\u001a\u00020\b*\u00020\u000b2\b\u0010y\u001a\u0004\u0018\u00010xH\u0080\b¢\u0006\u0004\bz\u0010{\u001a\u0014\u0010|\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b|\u0010*\u001a\u0014\u0010}\u001a\u00020\u000b*\u00020\u000bH\u0080\b¢\u0006\u0004\b}\u0010~\u001a\u0014\u0010\u007f\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0004\b\u007f\u0010N\u001a\u001d\u0010\u007f\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0005\b\u007f\u0010\u0080\u0001\"!\u0010\u0081\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0019\u0010\u0085\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0019\u0010\u0087\u0001\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0019\u0010\u0089\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0086\u0001¨\u0006\u008a\u0001"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "rangeEquals", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", "", "newline", "", "readUtf8Line", "(Lokio/Buffer;J)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "fromIndex", "Lkotlin/Function2;", "lambda", "seek", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "(Lokio/Buffer;Lokio/Options;Z)I", "out", "offset", "byteCount", "commonCopyTo", "(Lokio/Buffer;Lokio/Buffer;JJ)Lokio/Buffer;", "commonCompleteSegmentByteCount", "(Lokio/Buffer;)J", "", "commonReadByte", "(Lokio/Buffer;)B", "", "commonReadShort", "(Lokio/Buffer;)S", "commonReadInt", "(Lokio/Buffer;)I", "commonReadLong", "pos", "commonGet", "(Lokio/Buffer;J)B", "", "commonClear", "(Lokio/Buffer;)V", "commonSkip", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "commonWrite", "(Lokio/Buffer;Lokio/ByteString;II)Lokio/Buffer;", "v", "commonWriteDecimalLong", "(Lokio/Buffer;J)Lokio/Buffer;", "commonWriteHexadecimalUnsignedLong", "minimumCapacity", "commonWritableSegment", "(Lokio/Buffer;I)Lokio/Segment;", SocialConstants.PARAM_SOURCE, "(Lokio/Buffer;[B)Lokio/Buffer;", "(Lokio/Buffer;[BII)Lokio/Buffer;", "commonReadByteArray", "(Lokio/Buffer;)[B", "(Lokio/Buffer;J)[B", "sink", "commonRead", "(Lokio/Buffer;[B)I", "commonReadFully", "(Lokio/Buffer;[B)V", "(Lokio/Buffer;[BII)I", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "(Lokio/Buffer;)Lokio/ByteString;", "(Lokio/Buffer;J)Lokio/ByteString;", "commonSelect", "(Lokio/Buffer;Lokio/Options;)I", "(Lokio/Buffer;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/Buffer;Lokio/Sink;)J", "commonReadUtf8", "commonReadUtf8Line", "(Lokio/Buffer;)Ljava/lang/String;", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "string", "beginIndex", "endIndex", "commonWriteUtf8", "(Lokio/Buffer;Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/Buffer;I)Lokio/Buffer;", "Lokio/Source;", "commonWriteAll", "(Lokio/Buffer;Lokio/Source;)J", "(Lokio/Buffer;Lokio/Source;J)Lokio/Buffer;", "b", "commonWriteByte", "s", "commonWriteShort", "i", "commonWriteInt", "commonWriteLong", "(Lokio/Buffer;Lokio/Buffer;J)J", "toIndex", "commonIndexOf", "(Lokio/Buffer;BJJ)J", "(Lokio/Buffer;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "commonRangeEquals", "(Lokio/Buffer;JLokio/ByteString;II)Z", "", AdnName.OTHER, "commonEquals", "(Lokio/Buffer;Ljava/lang/Object;)Z", "commonHashCode", "commonCopy", "(Lokio/Buffer;)Lokio/Buffer;", "commonSnapshot", "(Lokio/Buffer;I)Lokio/ByteString;", "HEX_DIGIT_BYTES", "[B", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "J", "SEGMENTING_THRESHOLD", "I", "OVERFLOW_ZONE", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class BufferKt {

    @d
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@d Buffer commonClear) {
        Intrinsics.checkParameterIsNotNull(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final long commonCompleteSegmentByteCount(@d Buffer commonCompleteSegmentByteCount) {
        Intrinsics.checkParameterIsNotNull(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    @d
    public static final Buffer commonCopy(@d Buffer commonCopy) {
        Intrinsics.checkParameterIsNotNull(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            if (segment3 == null) {
                Intrinsics.throwNpe();
            }
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    @d
    public static final Buffer commonCopyTo(@d Buffer commonCopyTo, @d Buffer out, long j2, long j3) {
        Intrinsics.checkParameterIsNotNull(commonCopyTo, "$this$commonCopyTo");
        Intrinsics.checkParameterIsNotNull(out, "out");
        Util.checkOffsetAndCount(commonCopyTo.size(), j2, j3);
        if (j3 == 0) {
            return commonCopyTo;
        }
        out.setSize$okio(out.size() + j3);
        Segment segment = commonCopyTo.head;
        while (true) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            segment = segment.next;
        }
        while (j3 > 0) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            Segment sharedCopy = segment.sharedCopy();
            int i4 = sharedCopy.pos + ((int) j2);
            sharedCopy.pos = i4;
            sharedCopy.limit = Math.min(i4 + ((int) j3), sharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                out.head = sharedCopy;
            } else {
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    Intrinsics.throwNpe();
                }
                segment3.push(sharedCopy);
            }
            j3 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j2 = 0;
        }
        return commonCopyTo;
    }

    public static final boolean commonEquals(@d Buffer commonEquals, @e Object obj) {
        Intrinsics.checkParameterIsNotNull(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (commonEquals.size() != buffer.size()) {
            return false;
        }
        if (commonEquals.size() == 0) {
            return true;
        }
        Segment segment = commonEquals.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        int i3 = segment2.pos;
        long j2 = 0;
        while (j2 < commonEquals.size()) {
            long min = Math.min(segment.limit - i2, segment2.limit - i3);
            long j3 = 0;
            while (j3 < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (segment.data[i2] != segment2.data[i3]) {
                    return false;
                }
                j3++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == segment.limit) {
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                i2 = segment.pos;
            }
            if (i3 == segment2.limit) {
                segment2 = segment2.next;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = segment2.pos;
            }
            j2 += min;
        }
        return true;
    }

    public static final byte commonGet(@d Buffer commonGet, long j2) {
        Intrinsics.checkParameterIsNotNull(commonGet, "$this$commonGet");
        Util.checkOffsetAndCount(commonGet.size(), j2, 1L);
        Segment segment = commonGet.head;
        if (segment == null) {
            Intrinsics.throwNpe();
            throw null;
        }
        if (commonGet.size() - j2 < j2) {
            long size = commonGet.size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size -= segment.limit - segment.pos;
            }
            return segment.data[(int) ((segment.pos + j2) - size)];
        }
        long j3 = 0;
        while (true) {
            int i2 = segment.limit;
            int i3 = segment.pos;
            long j4 = (i2 - i3) + j3;
            if (j4 > j2) {
                return segment.data[(int) ((i3 + j2) - j3)];
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j3 = j4;
        }
    }

    public static final int commonHashCode(@d Buffer commonHashCode) {
        Intrinsics.checkParameterIsNotNull(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.limit;
            for (int i4 = segment.pos; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.data[i4];
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
        } while (segment != commonHashCode.head);
        return i2;
    }

    public static final long commonIndexOf(@d Buffer commonIndexOf, byte b2, long j2, long j3) {
        Segment segment;
        int i2;
        Intrinsics.checkParameterIsNotNull(commonIndexOf, "$this$commonIndexOf");
        long j4 = 0;
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        if (j3 > commonIndexOf.size()) {
            j3 = commonIndexOf.size();
        }
        if (j2 == j3 || (segment = commonIndexOf.head) == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j2 < j2) {
            j4 = commonIndexOf.size();
            while (j4 > j2) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j4 -= segment.limit - segment.pos;
            }
            while (j4 < j3) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j3) - j4);
                i2 = (int) ((segment.pos + j2) - j4);
                while (i2 < min) {
                    if (bArr[i2] != b2) {
                        i2++;
                    }
                }
                j4 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (segment.limit - segment.pos) + j4;
            if (j5 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j4 = j5;
        }
        while (j4 < j3) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j3) - j4);
            i2 = (int) ((segment.pos + j2) - j4);
            while (i2 < min2) {
                if (bArr2[i2] != b2) {
                    i2++;
                }
            }
            j4 += segment.limit - segment.pos;
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j2 = j4;
        }
        return -1L;
        return (i2 - segment.pos) + j4;
    }

    public static final long commonIndexOfElement(@d Buffer commonIndexOfElement, @d ByteString targetBytes, long j2) {
        int i2;
        int i3;
        Intrinsics.checkParameterIsNotNull(commonIndexOfElement, "$this$commonIndexOfElement");
        Intrinsics.checkParameterIsNotNull(targetBytes, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        Segment segment = commonIndexOfElement.head;
        if (segment == null) {
            return -1L;
        }
        if (commonIndexOfElement.size() - j2 < j2) {
            j3 = commonIndexOfElement.size();
            while (j3 > j2) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j3 -= segment.limit - segment.pos;
            }
            if (targetBytes.size() == 2) {
                byte b2 = targetBytes.getByte(0);
                byte b3 = targetBytes.getByte(1);
                while (j3 < commonIndexOfElement.size()) {
                    byte[] bArr = segment.data;
                    i2 = (int) ((segment.pos + j2) - j3);
                    int i4 = segment.limit;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 != b2 && b4 != b3) {
                            i2++;
                        }
                        i3 = segment.pos;
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j2 = j3;
                }
            } else {
                byte[] internalArray$okio = targetBytes.internalArray$okio();
                while (j3 < commonIndexOfElement.size()) {
                    byte[] bArr2 = segment.data;
                    i2 = (int) ((segment.pos + j2) - j3);
                    int i5 = segment.limit;
                    while (i2 < i5) {
                        byte b5 = bArr2[i2];
                        for (byte b6 : internalArray$okio) {
                            if (b5 == b6) {
                                i3 = segment.pos;
                            }
                        }
                        i2++;
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j2 = j3;
                }
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j3 = j4;
        }
        if (targetBytes.size() == 2) {
            byte b7 = targetBytes.getByte(0);
            byte b8 = targetBytes.getByte(1);
            while (j3 < commonIndexOfElement.size()) {
                byte[] bArr3 = segment.data;
                i2 = (int) ((segment.pos + j2) - j3);
                int i6 = segment.limit;
                while (i2 < i6) {
                    byte b9 = bArr3[i2];
                    if (b9 != b7 && b9 != b8) {
                        i2++;
                    }
                    i3 = segment.pos;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j3;
            }
        } else {
            byte[] internalArray$okio2 = targetBytes.internalArray$okio();
            while (j3 < commonIndexOfElement.size()) {
                byte[] bArr4 = segment.data;
                i2 = (int) ((segment.pos + j2) - j3);
                int i7 = segment.limit;
                while (i2 < i7) {
                    byte b10 = bArr4[i2];
                    for (byte b11 : internalArray$okio2) {
                        if (b10 == b11) {
                            i3 = segment.pos;
                        }
                    }
                    i2++;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j3;
            }
        }
        return -1L;
        return (i2 - i3) + j3;
    }

    public static final boolean commonRangeEquals(@d Buffer commonRangeEquals, long j2, @d ByteString bytes, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || commonRangeEquals.size() - j2 < i3 || bytes.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (commonRangeEquals.getByte(i4 + j2) != bytes.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@d Buffer commonRead, @d byte[] sink) {
        Intrinsics.checkParameterIsNotNull(commonRead, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@d Buffer commonReadAll, @d Sink sink) {
        Intrinsics.checkParameterIsNotNull(commonReadAll, "$this$commonReadAll");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    public static final byte commonReadByte(@d Buffer commonReadByte) {
        Intrinsics.checkParameterIsNotNull(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() == 0) {
            throw new EOFException();
        }
        Segment segment = commonReadByte.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b2 = segment.data[i2];
        commonReadByte.setSize$okio(commonReadByte.size() - 1);
        if (i4 == i3) {
            commonReadByte.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b2;
    }

    @d
    public static final byte[] commonReadByteArray(@d Buffer commonReadByteArray) {
        Intrinsics.checkParameterIsNotNull(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    @d
    public static final ByteString commonReadByteString(@d Buffer commonReadByteString) {
        Intrinsics.checkParameterIsNotNull(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf A[EDGE_INSN: B:51:0x00cf->B:45:0x00cf BREAK  A[LOOP:0: B:4:0x0016->B:50:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@f.b.a.d okio.Buffer r17) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@d Buffer commonReadFully, @d byte[] sink) {
        Intrinsics.checkParameterIsNotNull(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int read = commonReadFully.read(sink, i2, sink.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7 A[EDGE_INSN: B:42:0x00b7->B:39:0x00b7 BREAK  A[LOOP:0: B:4:0x0012->B:41:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@f.b.a.d okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lc1
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L19
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L19:
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1f:
            if (r8 >= r9) goto La1
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L30
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L30
            int r11 = r10 - r11
            goto L4a
        L30:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3f
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3f
        L3a:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L4a
        L3f:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L82
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L82
            goto L3a
        L4a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L5a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1f
        L5a:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L82:
            if (r0 == 0) goto L86
            r1 = 1
            goto La1
        L86:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        La1:
            if (r8 != r9) goto Laf
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool r7 = okio.SegmentPool.INSTANCE
            r7.recycle(r6)
            goto Lb1
        Laf:
            r6.pos = r8
        Lb1:
            if (r1 != 0) goto Lb7
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lb7:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lc1:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            goto Lc8
        Lc7:
            throw r15
        Lc8:
            goto Lc7
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@d Buffer commonReadInt) {
        Intrinsics.checkParameterIsNotNull(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() < 4) {
            throw new EOFException();
        }
        Segment segment = commonReadInt.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & 255);
        commonReadInt.setSize$okio(commonReadInt.size() - 4);
        if (i9 == i3) {
            commonReadInt.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    public static final long commonReadLong(@d Buffer commonReadLong) {
        Intrinsics.checkParameterIsNotNull(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() < 8) {
            throw new EOFException();
        }
        Segment segment = commonReadLong.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((commonReadLong.readInt() & 4294967295L) << 32) | (4294967295L & commonReadLong.readInt());
        }
        byte[] bArr = segment.data;
        long j2 = (bArr[i2] & 255) << 56;
        long j3 = j2 | ((bArr[r6] & 255) << 48);
        long j4 = j3 | ((bArr[r1] & 255) << 40);
        int i4 = i2 + 1 + 1 + 1 + 1;
        long j5 = ((bArr[r6] & 255) << 32) | j4;
        long j6 = j5 | ((bArr[i4] & 255) << 24);
        long j7 = j6 | ((bArr[r8] & 255) << 16);
        long j8 = j7 | ((bArr[r1] & 255) << 8);
        int i5 = i4 + 1 + 1 + 1 + 1;
        long j9 = j8 | (bArr[r8] & 255);
        commonReadLong.setSize$okio(commonReadLong.size() - 8);
        if (i5 == i3) {
            commonReadLong.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return j9;
    }

    public static final short commonReadShort(@d Buffer commonReadShort) {
        Intrinsics.checkParameterIsNotNull(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() < 2) {
            throw new EOFException();
        }
        Segment segment = commonReadShort.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
        commonReadShort.setSize$okio(commonReadShort.size() - 2);
        if (i5 == i3) {
            commonReadShort.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @d
    public static final String commonReadUtf8(@d Buffer commonReadUtf8, long j2) {
        Intrinsics.checkParameterIsNotNull(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (commonReadUtf8.size() < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        Segment segment = commonReadUtf8.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        int i2 = segment.pos;
        if (i2 + j2 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j2), 0, 0, 3, null);
        }
        int i3 = (int) j2;
        String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i2, i2 + i3);
        segment.pos += i3;
        commonReadUtf8.setSize$okio(commonReadUtf8.size() - j2);
        if (segment.pos == segment.limit) {
            commonReadUtf8.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return commonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@d Buffer commonReadUtf8CodePoint) {
        int i2;
        int i3;
        int i4;
        Intrinsics.checkParameterIsNotNull(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() == 0) {
            throw new EOFException();
        }
        byte b2 = commonReadUtf8CodePoint.getByte(0L);
        if ((b2 & ByteCompanionObject.MIN_VALUE) == 0) {
            i2 = b2 & ByteCompanionObject.MAX_VALUE;
            i3 = 1;
            i4 = 0;
        } else if ((b2 & 224) == 192) {
            i2 = b2 & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b2 & 240) == 224) {
            i2 = b2 & 15;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                commonReadUtf8CodePoint.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (commonReadUtf8CodePoint.size() < j2) {
            throw new EOFException("size < " + i3 + ": " + commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + Util.toHexString(b2) + ')');
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte b3 = commonReadUtf8CodePoint.getByte(j3);
            if ((b3 & 192) != 128) {
                commonReadUtf8CodePoint.skip(j3);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = (i2 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        commonReadUtf8CodePoint.skip(j2);
        return i2 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? Utf8.REPLACEMENT_CODE_POINT : i2;
    }

    @e
    public static final String commonReadUtf8Line(@d Buffer commonReadUtf8Line) {
        Intrinsics.checkParameterIsNotNull(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long indexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, indexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    @d
    public static final String commonReadUtf8LineStrict(@d Buffer commonReadUtf8LineStrict, long j2) {
        Intrinsics.checkParameterIsNotNull(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
        byte b2 = (byte) 10;
        long indexOf = commonReadUtf8LineStrict.indexOf(b2, 0L, j3);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8LineStrict, indexOf);
        }
        if (j3 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j3 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j3) == b2) {
            return readUtf8Line(commonReadUtf8LineStrict, j3);
        }
        Buffer buffer = new Buffer();
        commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j2) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
    }

    public static final int commonSelect(@d Buffer commonSelect, @d Options options) {
        Intrinsics.checkParameterIsNotNull(commonSelect, "$this$commonSelect");
        Intrinsics.checkParameterIsNotNull(options, "options");
        int selectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@d Buffer commonSkip, long j2) {
        Intrinsics.checkParameterIsNotNull(commonSkip, "$this$commonSkip");
        while (j2 > 0) {
            Segment segment = commonSkip.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j2, segment.limit - segment.pos);
            long j3 = min;
            commonSkip.setSize$okio(commonSkip.size() - j3);
            j2 -= j3;
            int i2 = segment.pos + min;
            segment.pos = i2;
            if (i2 == segment.limit) {
                commonSkip.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    @d
    public static final ByteString commonSnapshot(@d Buffer commonSnapshot) {
        Intrinsics.checkParameterIsNotNull(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    @d
    public static final Segment commonWritableSegment(@d Buffer commonWritableSegment, int i2) {
        Intrinsics.checkParameterIsNotNull(commonWritableSegment, "$this$commonWritableSegment");
        if (!(i2 >= 1 && i2 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = commonWritableSegment.head;
        if (segment == null) {
            Segment take = SegmentPool.INSTANCE.take();
            commonWritableSegment.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.INSTANCE.take()) : segment2;
    }

    @d
    public static final Buffer commonWrite(@d Buffer commonWrite, @d ByteString byteString, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(commonWrite, i2, i3);
        return commonWrite;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = byteString.size();
        }
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(commonWrite, i2, i3);
        return commonWrite;
    }

    public static final long commonWriteAll(@d Buffer commonWriteAll, @d Source source) {
        Intrinsics.checkParameterIsNotNull(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.checkParameterIsNotNull(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(commonWriteAll, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    @d
    public static final Buffer commonWriteByte(@d Buffer commonWriteByte, int i2) {
        Intrinsics.checkParameterIsNotNull(commonWriteByte, "$this$commonWriteByte");
        Segment writableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        writableSegment$okio.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    @d
    public static final Buffer commonWriteDecimalLong(@d Buffer commonWriteDecimalLong, long j2) {
        Intrinsics.checkParameterIsNotNull(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j2 == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < C.NANOS_PER_SECOND ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < C.MICROS_PER_SECOND ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j2 != 0) {
            long j3 = 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + i2);
        return commonWriteDecimalLong;
    }

    @d
    public static final Buffer commonWriteHexadecimalUnsignedLong(@d Buffer commonWriteHexadecimalUnsignedLong, long j2) {
        Intrinsics.checkParameterIsNotNull(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j2 == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = getHEX_DIGIT_BYTES()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        writableSegment$okio.limit += i2;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + i2);
        return commonWriteHexadecimalUnsignedLong;
    }

    @d
    public static final Buffer commonWriteInt(@d Buffer commonWriteInt, int i2) {
        Intrinsics.checkParameterIsNotNull(commonWriteInt, "$this$commonWriteInt");
        Segment writableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        writableSegment$okio.limit = i6 + 1;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    @d
    public static final Buffer commonWriteLong(@d Buffer commonWriteLong, long j2) {
        Intrinsics.checkParameterIsNotNull(commonWriteLong, "$this$commonWriteLong");
        Segment writableSegment$okio = commonWriteLong.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        writableSegment$okio.limit = i9 + 1;
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    @d
    public static final Buffer commonWriteShort(@d Buffer commonWriteShort, int i2) {
        Intrinsics.checkParameterIsNotNull(commonWriteShort, "$this$commonWriteShort");
        Segment writableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        writableSegment$okio.limit = i4 + 1;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    @d
    public static final Buffer commonWriteUtf8(@d Buffer commonWriteUtf8, @d String string, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkParameterIsNotNull(string, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (!(i3 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + string.length()).toString());
        }
        while (i2 < i3) {
            char charAt = string.charAt(i2);
            if (charAt < 128) {
                Segment writableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i4 = writableSegment$okio.limit - i2;
                int min = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) charAt;
                while (i5 < min) {
                    char charAt2 = string.charAt(i5);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) charAt2;
                    i5++;
                }
                int i6 = writableSegment$okio.limit;
                int i7 = (i4 + i5) - i6;
                writableSegment$okio.limit = i6 + i7;
                commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + i7);
                i2 = i5;
            } else {
                if (charAt < 2048) {
                    Segment writableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i8 = writableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((charAt >> 6) | Downloads.Impl.STATUS_RUNNING);
                    bArr2[i8 + 1] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio2.limit = i8 + 2;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 2);
                } else if (charAt < 55296 || charAt > 57343) {
                    Segment writableSegment$okio3 = commonWriteUtf8.writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i9 = writableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio3.limit = i9 + 3;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 3);
                } else {
                    int i10 = i2 + 1;
                    char charAt3 = i10 < i3 ? string.charAt(i10) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        commonWriteUtf8.writeByte(63);
                        i2 = i10;
                    } else {
                        int i11 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        Segment writableSegment$okio4 = commonWriteUtf8.writableSegment$okio(4);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i12 = writableSegment$okio4.limit;
                        bArr4[i12] = (byte) ((i11 >> 18) | g.n);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        writableSegment$okio4.limit = i12 + 4;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
        return commonWriteUtf8;
    }

    @d
    public static final Buffer commonWriteUtf8CodePoint(@d Buffer commonWriteUtf8CodePoint, int i2) {
        Intrinsics.checkParameterIsNotNull(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i2 < 128) {
            commonWriteUtf8CodePoint.writeByte(i2);
        } else if (i2 < 2048) {
            Segment writableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i3 = writableSegment$okio.limit;
            bArr[i3] = (byte) ((i2 >> 6) | Downloads.Impl.STATUS_RUNNING);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            writableSegment$okio.limit = i3 + 2;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            commonWriteUtf8CodePoint.writeByte(63);
        } else if (i2 < 65536) {
            Segment writableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i4 = writableSegment$okio2.limit;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            writableSegment$okio2.limit = i4 + 3;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 3);
        } else {
            if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i2));
            }
            Segment writableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i5 = writableSegment$okio3.limit;
            bArr3[i5] = (byte) ((i2 >> 18) | g.n);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            writableSegment$okio3.limit = i5 + 4;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 4);
        }
        return commonWriteUtf8CodePoint;
    }

    @d
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@d Segment segment, int i2, @d byte[] bytes, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(segment, "segment");
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        int i5 = segment.limit;
        byte[] bArr = segment.data;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i2 = segment.pos;
                i5 = segment.limit;
            }
            if (bArr[i2] != bytes[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    @d
    public static final String readUtf8Line(@d Buffer readUtf8Line, long j2) {
        Intrinsics.checkParameterIsNotNull(readUtf8Line, "$this$readUtf8Line");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (readUtf8Line.getByte(j3) == ((byte) 13)) {
                String readUtf8 = readUtf8Line.readUtf8(j3);
                readUtf8Line.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8Line.readUtf8(j2);
        readUtf8Line.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@d Buffer seek, long j2, @d Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkParameterIsNotNull(seek, "$this$seek");
        Intrinsics.checkParameterIsNotNull(lambda, "lambda");
        Segment segment = seek.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (seek.size() - j2 < j2) {
            long size = seek.size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j3 = 0;
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                return lambda.invoke(segment, Long.valueOf(j3));
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j3 = j4;
        }
    }

    public static final int selectPrefix(@d Buffer selectPrefix, @d Options options, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        Segment segment;
        Intrinsics.checkParameterIsNotNull(selectPrefix, "$this$selectPrefix");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i6 = segment2.pos;
        int i7 = segment2.limit;
        int[] trie = options.getTrie();
        Segment segment3 = segment2;
        int i8 = 0;
        int i9 = -1;
        loop0: while (true) {
            int i10 = i8 + 1;
            int i11 = trie[i8];
            int i12 = i10 + 1;
            int i13 = trie[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (segment3 == null) {
                break;
            }
            if (i11 >= 0) {
                i2 = i6 + 1;
                int i14 = bArr[i6] & 255;
                int i15 = i12 + i11;
                while (i12 != i15) {
                    if (i14 == trie[i12]) {
                        i3 = trie[i12 + i11];
                        if (i2 == i7) {
                            segment3 = segment3.next;
                            if (segment3 == null) {
                                Intrinsics.throwNpe();
                            }
                            i2 = segment3.pos;
                            bArr = segment3.data;
                            i7 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            int i16 = i12 + (i11 * (-1));
            while (true) {
                int i17 = i6 + 1;
                int i18 = i12 + 1;
                if ((bArr[i6] & 255) != trie[i12]) {
                    return i9;
                }
                boolean z2 = i18 == i16;
                if (i17 == i7) {
                    if (segment3 == null) {
                        Intrinsics.throwNpe();
                    }
                    Segment segment4 = segment3.next;
                    if (segment4 == null) {
                        Intrinsics.throwNpe();
                    }
                    i5 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i4 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    Segment segment5 = segment3;
                    i4 = i7;
                    i5 = i17;
                    segment = segment5;
                }
                if (z2) {
                    i3 = trie[i18];
                    i2 = i5;
                    i7 = i4;
                    segment3 = segment;
                    break;
                }
                i6 = i5;
                i7 = i4;
                i12 = i18;
                segment3 = segment;
            }
            if (i3 >= 0) {
                return i3;
            }
            i8 = -i3;
            i6 = i2;
        }
        if (z) {
            return -2;
        }
        return i9;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@d Buffer commonRead, @d byte[] sink, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonRead, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i2, i3);
        Segment segment = commonRead.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i3, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i4 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr, sink, i2, i4, i4 + min);
        segment.pos += min;
        commonRead.setSize$okio(commonRead.size() - min);
        if (segment.pos == segment.limit) {
            commonRead.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return min;
    }

    @d
    public static final byte[] commonReadByteArray(@d Buffer commonReadByteArray, long j2) {
        Intrinsics.checkParameterIsNotNull(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (commonReadByteArray.size() < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        commonReadByteArray.readFully(bArr);
        return bArr;
    }

    @d
    public static final ByteString commonReadByteString(@d Buffer commonReadByteString, long j2) {
        Intrinsics.checkParameterIsNotNull(commonReadByteString, "$this$commonReadByteString");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (commonReadByteString.size() < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new ByteString(commonReadByteString.readByteArray(j2));
        }
        ByteString snapshot = commonReadByteString.snapshot((int) j2);
        commonReadByteString.skip(j2);
        return snapshot;
    }

    @d
    public static final Buffer commonWrite(@d Buffer commonWrite, @d byte[] source) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @d
    public static final Buffer commonWrite(@d Buffer commonWrite, @d byte[] source, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        long j2 = i3;
        Util.checkOffsetAndCount(source.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment writableSegment$okio = commonWrite.writableSegment$okio(1);
            int min = Math.min(i4 - i2, 8192 - writableSegment$okio.limit);
            int i5 = i2 + min;
            ArraysKt___ArraysJvmKt.copyInto(source, writableSegment$okio.data, writableSegment$okio.limit, i2, i5);
            writableSegment$okio.limit += min;
            i2 = i5;
        }
        commonWrite.setSize$okio(commonWrite.size() + j2);
        return commonWrite;
    }

    public static final void commonReadFully(@d Buffer commonReadFully, @d Buffer sink, long j2) {
        Intrinsics.checkParameterIsNotNull(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (commonReadFully.size() >= j2) {
            sink.write(commonReadFully, j2);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    @d
    public static final ByteString commonSnapshot(@d Buffer commonSnapshot, int i2) {
        Intrinsics.checkParameterIsNotNull(commonSnapshot, "$this$commonSnapshot");
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i2);
        Segment segment = commonSnapshot.head;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = commonSnapshot.head;
        int i8 = 0;
        while (i3 < i2) {
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            bArr[i8] = segment2.data;
            i3 += segment2.limit - segment2.pos;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @d
    public static final Buffer commonWrite(@d Buffer commonWrite, @d Source source, long j2) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        while (j2 > 0) {
            long read = source.read(commonWrite, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return commonWrite;
    }

    public static final long commonRead(@d Buffer commonRead, @d Buffer sink, long j2) {
        Intrinsics.checkParameterIsNotNull(commonRead, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (commonRead.size() == 0) {
            return -1L;
        }
        if (j2 > commonRead.size()) {
            j2 = commonRead.size();
        }
        sink.write(commonRead, j2);
        return j2;
    }

    public static final void commonWrite(@d Buffer commonWrite, @d Buffer source, long j2) {
        Segment segment;
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        if (source != commonWrite) {
            Util.checkOffsetAndCount(source.size(), 0L, j2);
            while (j2 > 0) {
                Segment segment2 = source.head;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                int i2 = segment2.limit;
                if (source.head == null) {
                    Intrinsics.throwNpe();
                }
                if (j2 < i2 - r2.pos) {
                    Segment segment3 = commonWrite.head;
                    if (segment3 != null) {
                        if (segment3 == null) {
                            Intrinsics.throwNpe();
                        }
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j2) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            if (segment4 == null) {
                                Intrinsics.throwNpe();
                            }
                            segment4.writeTo(segment, (int) j2);
                            source.setSize$okio(source.size() - j2);
                            commonWrite.setSize$okio(commonWrite.size() + j2);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    if (segment5 == null) {
                        Intrinsics.throwNpe();
                    }
                    source.head = segment5.split((int) j2);
                }
                Segment segment6 = source.head;
                if (segment6 == null) {
                    Intrinsics.throwNpe();
                }
                long j3 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = commonWrite.head;
                if (segment7 == null) {
                    commonWrite.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    if (segment7 == null) {
                        Intrinsics.throwNpe();
                    }
                    Segment segment8 = segment7.prev;
                    if (segment8 == null) {
                        Intrinsics.throwNpe();
                    }
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j3);
                commonWrite.setSize$okio(commonWrite.size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@d Buffer commonIndexOf, @d ByteString bytes, long j2) {
        long j3;
        int i2;
        long j4 = j2;
        Intrinsics.checkParameterIsNotNull(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = commonIndexOf.head;
            if (segment == null) {
                return -1L;
            }
            if (commonIndexOf.size() - j4 < j4) {
                j3 = commonIndexOf.size();
                while (j3 > j4) {
                    segment = segment.prev;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j3 -= segment.limit - segment.pos;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b2 = internalArray$okio[0];
                int size = bytes.size();
                long size2 = (commonIndexOf.size() - size) + 1;
                while (j3 < size2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size2) - j3);
                    i2 = (int) ((segment.pos + j4) - j3);
                    while (i2 < min) {
                        if (bArr[i2] != b2 || !rangeEquals(segment, i2 + 1, internalArray$okio, 1, size)) {
                            i2++;
                        }
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j4 = j3;
                }
                return -1L;
            }
            while (true) {
                long j6 = (segment.limit - segment.pos) + j5;
                if (j6 > j4) {
                    break;
                }
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j5 = j6;
            }
            byte[] internalArray$okio2 = bytes.internalArray$okio();
            byte b3 = internalArray$okio2[0];
            int size3 = bytes.size();
            long size4 = (commonIndexOf.size() - size3) + 1;
            j3 = j5;
            while (j3 < size4) {
                byte[] bArr2 = segment.data;
                long j7 = size4;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j3);
                i2 = (int) ((segment.pos + j4) - j3);
                while (i2 < min2) {
                    if (bArr2[i2] == b3 && rangeEquals(segment, i2 + 1, internalArray$okio2, 1, size3)) {
                    }
                    i2++;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size4 = j7;
                j4 = j3;
            }
            return -1L;
            return (i2 - segment.pos) + j3;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
    }
}
