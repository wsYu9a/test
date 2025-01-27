package okio.internal;

import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.application.MiConfigSingleton;
import f.b.a.d;
import f.b.a.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.mozilla.universalchardet.prober.g;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010 \u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b\"\u0010$\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b&\u0010#\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b&\u0010$\u001a$\u0010(\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b*\u0010+\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\u0080\b¢\u0006\u0004\b*\u0010)\u001a\u001e\u0010-\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010,H\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u0010/\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b/\u0010\u0014\u001a\u001c\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b0\u00101\u001a\u0018\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b5\u00106\u001a\u0014\u00107\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b7\u00108\u001a\u0016\u00109\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b9\u00108\u001a\u0014\u0010:\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b:\u00108\u001a+\u0010>\u001a\u00020=*\u00020\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\b>\u0010?\u001a\u0017\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010C\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\bD\u0010\u0003\u001a\u001f\u0010G\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\nH\u0002¢\u0006\u0004\bG\u0010H\"\u001c\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lokio/ByteString;", "", "commonUtf8", "(Lokio/ByteString;)Ljava/lang/String;", "commonBase64", "commonBase64Url", "commonHex", "commonToAsciiLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "commonToAsciiUppercase", "", "beginIndex", "endIndex", "commonSubstring", "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "commonGetByte", "(Lokio/ByteString;I)B", "commonGetSize", "(Lokio/ByteString;)I", "", "commonToByteArray", "(Lokio/ByteString;)[B", "commonInternalArray", "offset", AdnName.OTHER, "otherOffset", "byteCount", "", "commonRangeEquals", "(Lokio/ByteString;ILokio/ByteString;II)Z", "(Lokio/ByteString;I[BII)Z", "prefix", "commonStartsWith", "(Lokio/ByteString;Lokio/ByteString;)Z", "(Lokio/ByteString;[B)Z", "suffix", "commonEndsWith", "fromIndex", "commonIndexOf", "(Lokio/ByteString;[BI)I", "commonLastIndexOf", "(Lokio/ByteString;Lokio/ByteString;I)I", "", "commonEquals", "(Lokio/ByteString;Ljava/lang/Object;)Z", "commonHashCode", "commonCompareTo", "(Lokio/ByteString;Lokio/ByteString;)I", MiConfigSingleton.t0, "commonOf", "([B)Lokio/ByteString;", "commonToByteString", "([BII)Lokio/ByteString;", "commonEncodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "commonDecodeBase64", "commonDecodeHex", "Lokio/Buffer;", "buffer", "", "commonWrite", "(Lokio/ByteString;Lokio/Buffer;II)V", "", "c", "decodeHexDigit", "(C)I", "commonToString", "s", "codePointCount", "codePointIndexToCharIndex", "([BI)I", "", "HEX_DIGIT_CHARS", "[C", "getHEX_DIGIT_CHARS", "()[C", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class ByteStringKt {

    @d
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:232:0x0068, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @d
    public static final String commonBase64(@d ByteString commonBase64) {
        Intrinsics.checkParameterIsNotNull(commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default(commonBase64.getData(), null, 1, null);
    }

    @d
    public static final String commonBase64Url(@d ByteString commonBase64Url) {
        Intrinsics.checkParameterIsNotNull(commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64(commonBase64Url.getData(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@d ByteString commonCompareTo, @d ByteString other) {
        Intrinsics.checkParameterIsNotNull(commonCompareTo, "$this$commonCompareTo");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = commonCompareTo.getByte(i2) & 255;
            int i4 = other.getByte(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @e
    public static final ByteString commonDecodeBase64(@d String commonDecodeBase64) {
        Intrinsics.checkParameterIsNotNull(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(commonDecodeBase64);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @d
    public static final ByteString commonDecodeHex(@d String commonDecodeHex) {
        Intrinsics.checkParameterIsNotNull(commonDecodeHex, "$this$commonDecodeHex");
        if (!(commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
        }
        int length = commonDecodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((decodeHexDigit(commonDecodeHex.charAt(i3)) << 4) + decodeHexDigit(commonDecodeHex.charAt(i3 + 1)));
        }
        return new ByteString(bArr);
    }

    @d
    public static final ByteString commonEncodeUtf8(@d String commonEncodeUtf8) {
        Intrinsics.checkParameterIsNotNull(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(@d ByteString commonEndsWith, @d ByteString suffix) {
        Intrinsics.checkParameterIsNotNull(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@d ByteString commonEquals, @e Object obj) {
        Intrinsics.checkParameterIsNotNull(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData().length && byteString.rangeEquals(0, commonEquals.getData(), 0, commonEquals.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@d ByteString commonGetByte, int i2) {
        Intrinsics.checkParameterIsNotNull(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData()[i2];
    }

    public static final int commonGetSize(@d ByteString commonGetSize) {
        Intrinsics.checkParameterIsNotNull(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData().length;
    }

    public static final int commonHashCode(@d ByteString commonHashCode) {
        Intrinsics.checkParameterIsNotNull(commonHashCode, "$this$commonHashCode");
        int hashCode = commonHashCode.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(commonHashCode.getData());
        commonHashCode.setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @d
    public static final String commonHex(@d ByteString commonHex) {
        Intrinsics.checkParameterIsNotNull(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData().length * 2];
        int i2 = 0;
        for (byte b2 : commonHex.getData()) {
            int i3 = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = getHEX_DIGIT_CHARS()[b2 & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@d ByteString commonIndexOf, @d byte[] other, int i2) {
        Intrinsics.checkParameterIsNotNull(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int length = commonIndexOf.getData().length - other.length;
        int max = Math.max(i2, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(commonIndexOf.getData(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @d
    public static final byte[] commonInternalArray(@d ByteString commonInternalArray) {
        Intrinsics.checkParameterIsNotNull(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData();
    }

    public static final int commonLastIndexOf(@d ByteString commonLastIndexOf, @d ByteString other, int i2) {
        Intrinsics.checkParameterIsNotNull(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i2);
    }

    @d
    public static final ByteString commonOf(@d byte[] data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@d ByteString commonRangeEquals, int i2, @d ByteString other, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return other.rangeEquals(i3, commonRangeEquals.getData(), i2, i4);
    }

    public static final boolean commonStartsWith(@d ByteString commonStartsWith, @d ByteString prefix) {
        Intrinsics.checkParameterIsNotNull(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    @d
    public static final ByteString commonSubstring(@d ByteString commonSubstring, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonSubstring, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i3 <= commonSubstring.getData().length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == commonSubstring.getData().length) ? commonSubstring : new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(commonSubstring.getData(), i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.getData().length + ')').toString());
    }

    @d
    public static final ByteString commonToAsciiLowercase(@d ByteString commonToAsciiLowercase) {
        byte b2;
        Intrinsics.checkParameterIsNotNull(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i2 = 0; i2 < commonToAsciiLowercase.getData().length; i2++) {
            byte b3 = commonToAsciiLowercase.getData()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data = commonToAsciiLowercase.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + g.s);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + g.s);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @d
    public static final ByteString commonToAsciiUppercase(@d ByteString commonToAsciiUppercase) {
        byte b2;
        Intrinsics.checkParameterIsNotNull(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i2 = 0; i2 < commonToAsciiUppercase.getData().length; i2++) {
            byte b3 = commonToAsciiUppercase.getData()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data = commonToAsciiUppercase.getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @d
    public static final byte[] commonToByteArray(@d ByteString commonToByteArray) {
        Intrinsics.checkParameterIsNotNull(commonToByteArray, "$this$commonToByteArray");
        byte[] data = commonToByteArray.getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @d
    public static final ByteString commonToByteString(@d byte[] commonToByteString, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount(commonToByteString.length, i2, i3);
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(commonToByteString, i2, i3 + i2));
    }

    @d
    public static final String commonToString(@d ByteString byteString) {
        ByteString commonToString = byteString;
        Intrinsics.checkParameterIsNotNull(commonToString, "$this$commonToString");
        if (byteString.getData().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (codePointIndexToCharIndex >= utf8.length()) {
                return "[text=" + replace$default + ']';
            }
            return "[size=" + byteString.getData().length + " text=" + replace$default + "…]";
        }
        if (byteString.getData().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(byteString.getData().length);
        sb.append(" hex=");
        if (64 <= byteString.getData().length) {
            if (64 != byteString.getData().length) {
                commonToString = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData(), 0, 64));
            }
            sb.append(commonToString.hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
    }

    @d
    public static final String commonUtf8(@d ByteString commonUtf8) {
        Intrinsics.checkParameterIsNotNull(commonUtf8, "$this$commonUtf8");
        String utf8 = commonUtf8.getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = Platform.toUtf8String(commonUtf8.internalArray$okio());
        commonUtf8.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@d ByteString commonWrite, @d Buffer buffer, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        buffer.write(commonWrite.getData(), i2, i3);
    }

    public static final int decodeHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @d
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@d ByteString commonEndsWith, @d byte[] suffix) {
        Intrinsics.checkParameterIsNotNull(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@d ByteString commonLastIndexOf, @d byte[] other, int i2) {
        Intrinsics.checkParameterIsNotNull(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        for (int min = Math.min(i2, commonLastIndexOf.getData().length - other.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(commonLastIndexOf.getData(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@d ByteString commonRangeEquals, int i2, @d byte[] other, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return i2 >= 0 && i2 <= commonRangeEquals.getData().length - i4 && i3 >= 0 && i3 <= other.length - i4 && Util.arrayRangeEquals(commonRangeEquals.getData(), i2, other, i3, i4);
    }

    public static final boolean commonStartsWith(@d ByteString commonStartsWith, @d byte[] prefix) {
        Intrinsics.checkParameterIsNotNull(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }
}
