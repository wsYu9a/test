package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.libmars.activity.PermissionActivity;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import m5.h;
import okio.internal._SegmentedByteStringKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", DBDefinition.SEGMENT_TABLE_NAME, "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", AdnName.OTHER, "", "getSize", "getSize$okio", TTDownloadField.TT_HASHCODE, "hex", "hmac", PermissionActivity.f12046p, "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", TypedValues.Custom.S_STRING, h.f28414g, "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {

    @k
    private final transient int[] directory;

    @k
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@k byte[][] segments, @k int[] directory) {
        super(ByteString.EMPTY.getData());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    @Override // okio.ByteString
    @k
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @k
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @k
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int r12, @k byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        long j10 = byteCount;
        _UtilKt.checkOffsetAndCount(size(), r12, j10);
        _UtilKt.checkOffsetAndCount(target.length, targetOffset, j10);
        int i10 = byteCount + r12;
        int segment = _SegmentedByteStringKt.segment(this, r12);
        while (r12 < i10) {
            int i11 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i12 = getDirectory()[segment] - i11;
            int i13 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i10, i12 + i11) - r12;
            int i14 = i13 + (r12 - i11);
            ArraysKt.copyInto(getSegments()[segment], target, targetOffset, i14, i14 + min);
            targetOffset += min;
            r12 += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    @k
    public ByteString digest$okio(@k String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory()[length + i10];
            int i13 = getDirectory()[i10];
            messageDigest.update(getSegments()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(@l Object r52) {
        if (r52 == this) {
            return true;
        }
        if (r52 instanceof ByteString) {
            ByteString byteString = (ByteString) r52;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @k
    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @k
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
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            byte[] bArr = getSegments()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        setHashCode$okio(i11);
        return i11;
    }

    @Override // okio.ByteString
    @k
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @k
    public ByteString hmac$okio(@k String algorithm, @k ByteString r72) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(r72, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(r72.toByteArray(), algorithm));
            int length = getSegments().length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = getDirectory()[length + i10];
                int i13 = getDirectory()[i10];
                mac.update(getSegments()[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@k byte[] r22, int fromIndex) {
        Intrinsics.checkNotNullParameter(r22, "other");
        return toByteString().indexOf(r22, fromIndex);
    }

    @Override // okio.ByteString
    @k
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        _UtilKt.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int segment = _SegmentedByteStringKt.segment(this, pos);
        return getSegments()[segment][(pos - (segment == 0 ? 0 : getDirectory()[segment - 1])) + getDirectory()[getSegments().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@k byte[] r22, int fromIndex) {
        Intrinsics.checkNotNullParameter(r22, "other");
        return toByteString().lastIndexOf(r22, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r72, @k ByteString r82, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(r82, "other");
        if (r72 < 0 || r72 > size() - byteCount) {
            return false;
        }
        int i10 = byteCount + r72;
        int segment = _SegmentedByteStringKt.segment(this, r72);
        while (r72 < i10) {
            int i11 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i12 = getDirectory()[segment] - i11;
            int i13 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i10, i12 + i11) - r72;
            if (!r82.rangeEquals(otherOffset, getSegments()[segment], i13 + (r72 - i11), min)) {
                return false;
            }
            otherOffset += min;
            r72 += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @k
    public String string(@k Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @k
    public ByteString substring(int beginIndex, int endIndex) {
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, endIndex);
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (resolveDefaultParameter > size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        int i10 = resolveDefaultParameter - beginIndex;
        if (i10 < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && resolveDefaultParameter == size()) {
            return this;
        }
        if (beginIndex == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int segment = _SegmentedByteStringKt.segment(this, beginIndex);
        int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i11 = segment;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(getDirectory()[i11] - beginIndex, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr.length] = getDirectory()[getSegments().length + i11];
                if (i11 == segment2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = segment != 0 ? getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i14);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @k
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @k
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @k
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            int i15 = i14 - i11;
            ArraysKt.copyInto(getSegments()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @k
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@k OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory()[length + i10];
            int i13 = getDirectory()[i10];
            out.write(getSegments()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@k Buffer buffer, int r13, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i10 = r13 + byteCount;
        int segment = _SegmentedByteStringKt.segment(this, r13);
        while (r13 < i10) {
            int i11 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i12 = getDirectory()[segment] - i11;
            int i13 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i10, i12 + i11) - r13;
            int i14 = i13 + (r13 - i11);
            Segment segment2 = new Segment(getSegments()[segment], i14, i14 + min, true, false);
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
            r13 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + byteCount);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r72, @k byte[] r82, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(r82, "other");
        if (r72 < 0 || r72 > size() - byteCount || otherOffset < 0 || otherOffset > r82.length - byteCount) {
            return false;
        }
        int i10 = byteCount + r72;
        int segment = _SegmentedByteStringKt.segment(this, r72);
        while (r72 < i10) {
            int i11 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i12 = getDirectory()[segment] - i11;
            int i13 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i10, i12 + i11) - r72;
            if (!_UtilKt.arrayRangeEquals(getSegments()[segment], i13 + (r72 - i11), r82, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            r72 += min;
            segment++;
        }
        return true;
    }
}
