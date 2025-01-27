package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import b5.a;
import com.kwad.sdk.api.model.AdnName;
import h3.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", e.f26408m, "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", AdnName.OTHER, "commonCopyInto", "", TypedValues.CycleType.S_WAVE_OFFSET, "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class _ByteStringKt {

    @k
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int codePointIndexToCharIndex(byte[] bArr, int i10) {
        byte b10;
        int i11;
        int length = bArr.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        loop0: while (i12 < length) {
            byte b11 = bArr[i12];
            if (b11 >= 0) {
                int i15 = i14 + 1;
                if (i14 == i10) {
                    return i13;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (Byte.MAX_VALUE <= b11 && b11 < 160))) || b11 == 65533) {
                    return -1;
                }
                i13 += b11 < 65536 ? 1 : 2;
                i12++;
                while (true) {
                    i14 = i15;
                    if (i12 < length && (b10 = bArr[i12]) >= 0) {
                        i12++;
                        i15 = i14 + 1;
                        if (i14 == i10) {
                            return i13;
                        }
                        if ((b10 == 10 || b10 == 13 || ((b10 < 0 || b10 >= 32) && (Byte.MAX_VALUE > b10 || b10 >= 160))) && b10 != 65533) {
                            i13 += b10 < 65536 ? 1 : 2;
                        }
                    }
                }
            } else if ((b11 >> 5) == -2) {
                int i16 = i12 + 1;
                if (length <= i16) {
                    if (i14 == i10) {
                        return i13;
                    }
                    return -1;
                }
                byte b12 = bArr[i16];
                if ((b12 & 192) != 128) {
                    if (i14 == i10) {
                        return i13;
                    }
                    return -1;
                }
                int i17 = (b11 << 6) ^ (b12 ^ 3968);
                if (i17 < 128) {
                    if (i14 == i10) {
                        return i13;
                    }
                    return -1;
                }
                int i18 = i14 + 1;
                if (i14 == i10) {
                    return i13;
                }
                if ((i17 != 10 && i17 != 13 && ((i17 >= 0 && i17 < 32) || (127 <= i17 && i17 < 160))) || i17 == 65533) {
                    return -1;
                }
                i13 += i17 < 65536 ? 1 : 2;
                i12 += 2;
                i14 = i18;
            } else {
                if ((b11 >> 4) == -2) {
                    int i19 = i12 + 2;
                    if (length <= i19) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    byte b13 = bArr[i12 + 1];
                    if ((b13 & 192) != 128) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    byte b14 = bArr[i19];
                    if ((b14 & 192) != 128) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    int i20 = (b11 << 12) ^ ((b14 ^ (-123008)) ^ (b13 << 6));
                    if (i20 < 2048) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    if (55296 <= i20 && i20 < 57344) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    i11 = i14 + 1;
                    if (i14 == i10) {
                        return i13;
                    }
                    if ((i20 != 10 && i20 != 13 && ((i20 >= 0 && i20 < 32) || (127 <= i20 && i20 < 160))) || i20 == 65533) {
                        return -1;
                    }
                    i13 += i20 < 65536 ? 1 : 2;
                    i12 += 3;
                } else {
                    if ((b11 >> 3) != -2) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    int i21 = i12 + 3;
                    if (length <= i21) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    byte b15 = bArr[i12 + 1];
                    if ((b15 & 192) != 128) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    byte b16 = bArr[i12 + 2];
                    if ((b16 & 192) != 128) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    byte b17 = bArr[i21];
                    if ((b17 & 192) != 128) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    int i22 = (b11 << a.f1194u) ^ (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12));
                    if (i22 > 1114111) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    if (55296 <= i22 && i22 < 57344) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    if (i22 < 65536) {
                        if (i14 == i10) {
                            return i13;
                        }
                        return -1;
                    }
                    i11 = i14 + 1;
                    if (i14 == i10) {
                        return i13;
                    }
                    if ((i22 != 10 && i22 != 13 && ((i22 >= 0 && i22 < 32) || (127 <= i22 && i22 < 160))) || i22 == 65533) {
                        return -1;
                    }
                    i13 += i22 < 65536 ? 1 : 2;
                    i12 += 4;
                }
                i14 = i11;
            }
        }
        return i13;
    }

    @k
    public static final String commonBase64(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData(), null, 1, null);
    }

    @k
    public static final String commonBase64Url(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@k ByteString byteString, @k ByteString other) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = byteString.getByte(i10) & 255;
            int i12 = other.getByte(i10) & 255;
            if (i11 != i12) {
                return i11 < i12 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final void commonCopyInto(@k ByteString byteString, int i10, @k byte[] target, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto(byteString.getData(), target, i11, i10, i12 + i10);
    }

    @l
    public static final ByteString commonDecodeBase64(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @k
    public static final ByteString commonDecodeHex(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) ((decodeHexDigit(str.charAt(i11)) << 4) + decodeHexDigit(str.charAt(i11 + 1)));
        }
        return new ByteString(bArr);
    }

    @k
    public static final ByteString commonEncodeUtf8(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@k ByteString byteString, @k ByteString suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@k ByteString byteString, @l Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData().length && byteString2.rangeEquals(0, byteString.getData(), 0, byteString.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@k ByteString byteString, int i10) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData()[i10];
    }

    public static final int commonGetSize(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData().length;
    }

    public static final int commonHashCode(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode = byteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(byteString.getData());
        byteString.setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @k
    public static final String commonHex(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[byteString.getData().length * 2];
        int i10 = 0;
        for (byte b10 : byteString.getData()) {
            int i11 = i10 + 1;
            cArr[i10] = getHEX_DIGIT_CHARS()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = getHEX_DIGIT_CHARS()[b10 & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final int commonIndexOf(@k ByteString byteString, @k byte[] other, int i10) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = byteString.getData().length - other.length;
        int max = Math.max(i10, 0);
        if (max > length) {
            return -1;
        }
        while (!_UtilKt.arrayRangeEquals(byteString.getData(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @k
    public static final byte[] commonInternalArray(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData();
    }

    public static final int commonLastIndexOf(@k ByteString byteString, @k ByteString other, int i10) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i10);
    }

    @k
    public static final ByteString commonOf(@k byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@k ByteString byteString, int i10, @k ByteString other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i11, byteString.getData(), i10, i12);
    }

    public static final boolean commonStartsWith(@k ByteString byteString, @k ByteString prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    @k
    public static final ByteString commonSubstring(@k ByteString byteString, int i10, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i11);
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (resolveDefaultParameter <= byteString.getData().length) {
            if (resolveDefaultParameter - i10 >= 0) {
                return (i10 == 0 && resolveDefaultParameter == byteString.getData().length) ? byteString : new ByteString(ArraysKt.copyOfRange(byteString.getData(), i10, resolveDefaultParameter));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
    }

    @k
    public static final ByteString commonToAsciiLowercase(@k ByteString byteString) {
        byte b10;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i10 = 0; i10 < byteString.getData().length; i10++) {
            byte b11 = byteString.getData()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] data = byteString.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @k
    public static final ByteString commonToAsciiUppercase(@k ByteString byteString) {
        byte b10;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i10 = 0; i10 < byteString.getData().length; i10++) {
            byte b11 = byteString.getData()[i10];
            byte b12 = (byte) 97;
            if (b11 >= b12 && b11 <= (b10 = (byte) 122)) {
                byte[] data = byteString.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @k
    public static final byte[] commonToByteArray(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data = byteString.getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @k
    public static final ByteString commonToByteString(@k byte[] bArr, int i10, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(bArr, i11);
        _UtilKt.checkOffsetAndCount(bArr.length, i10, resolveDefaultParameter);
        return new ByteString(ArraysKt.copyOfRange(bArr, i10, resolveDefaultParameter + i10));
    }

    @k
    public static final String commonToString(@k ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        if (byteString.getData().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (codePointIndexToCharIndex >= utf8.length()) {
                return "[text=" + replace$default + ']';
            }
            return "[size=" + byteString.getData().length + " text=" + replace$default + "…]";
        }
        if (byteString.getData().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(byteString.getData().length);
        sb2.append(" hex=");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
        if (resolveDefaultParameter > byteString.getData().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
        }
        if (resolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (resolveDefaultParameter != byteString.getData().length) {
            byteString2 = new ByteString(ArraysKt.copyOfRange(byteString.getData(), 0, resolveDefaultParameter));
        }
        sb2.append(byteString2.hex());
        sb2.append("…]");
        return sb2.toString();
    }

    @k
    public static final String commonUtf8(@k ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8 = byteString.getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@k ByteString byteString, @k Buffer buffer, int i10, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData(), i10, i11);
    }

    public static final int decodeHexDigit(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    @k
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(@k ByteString byteString, @k byte[] suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@k ByteString byteString, @k byte[] other, int i10) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i10), byteString.getData().length - other.length); -1 < min; min--) {
            if (_UtilKt.arrayRangeEquals(byteString.getData(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@k ByteString byteString, int i10, @k byte[] other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return i10 >= 0 && i10 <= byteString.getData().length - i12 && i11 >= 0 && i11 <= other.length - i12 && _UtilKt.arrayRangeEquals(byteString.getData(), i10, other, i11, i12);
    }

    public static final boolean commonStartsWith(@k ByteString byteString, @k byte[] prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }
}
