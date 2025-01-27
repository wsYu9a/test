package okio;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f.b.a.d;
import f.b.a.e;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteStringKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020'0I\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u001f\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0004\b!\u0010\"J\u000f\u0010&\u001a\u00020\u001aH\u0010¢\u0006\u0004\b$\u0010%J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J'\u00100\u001a\u00020/2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0010¢\u0006\u0004\b6\u00107J/\u0010;\u001a\u00020:2\u0006\u00104\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010<J/\u0010;\u001a\u00020:2\u0006\u00104\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010=J\u001f\u0010?\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\bA\u0010@J\u000f\u0010C\u001a\u00020'H\u0010¢\u0006\u0004\bB\u0010)J\u001a\u0010E\u001a\u00020:2\b\u00108\u001a\u0004\u0018\u00010DH\u0096\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u001aH\u0016¢\u0006\u0004\bG\u0010%J\u000f\u0010H\u001a\u00020\tH\u0016¢\u0006\u0004\bH\u0010\rR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020'0I8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "toByteString", "()Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "toAsciiUppercase", Constant.Param.ALGORITHM, "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", AdnName.OTHER, "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "", DBDefinition.SEGMENT_TABLE_NAME, "[[B", "getSegments$okio", "()[[B", "", "directory", "[I", "getDirectory$okio", "()[I", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SegmentedByteString extends ByteString {

    @d
    private final transient int[] directory;

    @d
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@d byte[][] segments, @d int[] directory) {
        super(ByteString.EMPTY.getData());
        Intrinsics.checkParameterIsNotNull(segments, "segments");
        Intrinsics.checkParameterIsNotNull(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    @d
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkExpressionValueIsNotNull(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @d
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @d
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @d
    public ByteString digest$okio(@d String r7) {
        Intrinsics.checkParameterIsNotNull(r7, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(r7);
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            messageDigest.update(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkExpressionValueIsNotNull(digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(@e Object r5) {
        if (r5 == this) {
            return true;
        }
        if (r5 instanceof ByteString) {
            ByteString byteString = (ByteString) r5;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @d
    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @d
    /* renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            byte[] bArr = getSegments()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        setHashCode$okio(i3);
        return i3;
    }

    @Override // okio.ByteString
    @d
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @d
    public ByteString hmac$okio(@d String r6, @d ByteString key) {
        Intrinsics.checkParameterIsNotNull(r6, "algorithm");
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            Mac mac = Mac.getInstance(r6);
            mac.init(new SecretKeySpec(key.toByteArray(), r6));
            int length = getSegments().length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = getDirectory()[length + i2];
                int i5 = getDirectory()[i2];
                mac.update(getSegments()[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@d byte[] r2, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return toByteString().indexOf(r2, fromIndex);
    }

    @Override // okio.ByteString
    @d
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        Util.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int segment = SegmentedByteStringKt.segment(this, pos);
        return getSegments()[segment][(pos - (segment == 0 ? 0 : getDirectory()[segment - 1])) + getDirectory()[getSegments().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@d byte[] r2, int fromIndex) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return toByteString().lastIndexOf(r2, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @d ByteString r8, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(r8, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int segment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i4 = getDirectory()[segment] - i3;
            int i5 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, i4 + i3) - offset;
            if (!r8.rangeEquals(otherOffset, getSegments()[segment], i5 + (offset - i3), min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @d
    public String string(@d Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @d
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (!(endIndex <= size())) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " > length(" + size() + ')').toString());
        }
        int i2 = endIndex - beginIndex;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex == size()) {
            return this;
        }
        if (beginIndex == endIndex) {
            return ByteString.EMPTY;
        }
        int segment = SegmentedByteStringKt.segment(this, beginIndex);
        int segment2 = SegmentedByteStringKt.segment(this, endIndex - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i3 = segment;
            int i4 = 0;
            while (true) {
                iArr[i4] = Math.min(getDirectory()[i3] - beginIndex, i2);
                int i5 = i4 + 1;
                iArr[i4 + bArr.length] = getDirectory()[getSegments().length + i3];
                if (i3 == segment2) {
                    break;
                }
                i3++;
                i4 = i5;
            }
        }
        int i6 = segment != 0 ? getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i6);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @d
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @d
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @d
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            int i7 = i6 - i3;
            ArraysKt___ArraysJvmKt.copyInto(getSegments()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @d
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@d OutputStream out) throws IOException {
        Intrinsics.checkParameterIsNotNull(out, "out");
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            out.write(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@d Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        int i2 = byteCount + offset;
        int segment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i4 = getDirectory()[segment] - i3;
            int i5 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, i4 + i3) - offset;
            int i6 = i5 + (offset - i3);
            Segment segment2 = new Segment(getSegments()[segment], i6, i6 + min, true, false);
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
            offset += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + size());
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @d byte[] r8, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(r8, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > r8.length - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int segment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i4 = getDirectory()[segment] - i3;
            int i5 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, i4 + i3) - offset;
            if (!Util.arrayRangeEquals(getSegments()[segment], i5 + (offset - i3), r8, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }
}
