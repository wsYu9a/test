package kotlin.text;

import b5.a;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;
import xi.k;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0004\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a@\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a@\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002\u001a,\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002\u001a,\u0010\u001b\u001a\u00020\u001c*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u001c\u0010!\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002\u001a\u0014\u0010\"\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0002\u001a*\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a0\u0010+\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tH\u0003\u001a*\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020-2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u001c\u0010/\u001a\u00020\u0003*\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u00100\u001a\u00020\tH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"HEX_DIGITS_TO_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "formattedStringLength", DBDefinition.TOTAL_BYTES, "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "part", "index", "endIndex", "partName", "checkHexLength", "", "startIndex", "maxDigits", "requireMaxLength", "", "checkNewLineAt", "decimalFromHexDigitAt", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "", "hexToInt", "hexToLong", "hexToLongImpl", "hexToShort", "", "toHexString", "toHexStringImpl", "bits", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,591:1\n1#2:592\n1183#3,3:593\n1183#3,3:596\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n13#1:593,3\n14#1:596,3\n*E\n"})
/* loaded from: classes4.dex */
public final class HexExtensionsKt {

    @k
    private static final int[] HEX_DIGITS_TO_DECIMAL;

    @k
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";

    @k
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[128];
        int i10 = 0;
        for (int i11 = 0; i11 < 128; i11++) {
            iArr[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr[LOWER_CASE_HEX_DIGITS.charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        while (i10 < UPPER_CASE_HEX_DIGITS.length()) {
            iArr[UPPER_CASE_HEX_DIGITS.charAt(i10)] = i14;
            i10++;
            i14++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr;
    }

    private static final long charsPerSet(long j10, int i10, int i11) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j11 = i10;
        return (j10 * j11) + (i11 * (j11 - 1));
    }

    private static final int checkContainsAt(String str, String str2, int i10, int i11, String str3) {
        int length = str2.length() + i10;
        if (length <= i11 && StringsKt.regionMatches(str, i10, str2, 0, str2.length(), true)) {
            return length;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected ");
        sb2.append(str3);
        sb2.append(" \"");
        sb2.append(str2);
        sb2.append("\" at index ");
        sb2.append(i10);
        sb2.append(", but was ");
        int coerceAtMost = RangesKt.coerceAtMost(length, i11);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb2.append(substring);
        throw new NumberFormatException(sb2.toString());
    }

    private static final void checkHexLength(String str, int i10, int i11, int i12, boolean z10) {
        int i13 = i11 - i10;
        if (z10) {
            if (i13 == i12) {
                return;
            }
        } else if (i13 <= i12) {
            return;
        }
        String str2 = z10 ? "exactly" : "at most";
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, i11);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + a.O + i12 + " hexadecimal digits at index " + i10 + ", but was " + substring + " of length " + i13);
    }

    private static final int checkNewLineAt(String str, int i10, int i11) {
        if (str.charAt(i10) == '\r') {
            int i12 = i10 + 1;
            return (i12 >= i11 || str.charAt(i12) != '\n') ? i12 : i10 + 2;
        }
        if (str.charAt(i10) == '\n') {
            return i10 + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i10 + ", but was " + str.charAt(i10));
    }

    private static final int decimalFromHexDigitAt(String str, int i10) {
        int i11;
        char charAt = str.charAt(i10);
        if (charAt <= 127 && (i11 = HEX_DIGITS_TO_DECIMAL[charAt]) >= 0) {
            return i11;
        }
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i10 + ", but was " + str.charAt(i10));
    }

    public static final int formattedStringLength(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i17 = (i10 - 1) / i11;
        int i18 = (i11 - 1) / i12;
        int i19 = i10 % i11;
        if (i19 != 0) {
            i11 = i19;
        }
        long j10 = i17 + (((i18 * i17) + ((i11 - 1) / i12)) * i13) + (((r0 - i17) - r2) * i14) + (i10 * (i15 + 2 + i16));
        if (RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(0, Integer.MAX_VALUE), j10)) {
            return (int) j10;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m278toStringimpl(ULong.m232constructorimpl(j10))));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(@k String str, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final byte[] hexToByteArray(@k String str, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(@k String str, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(@k String str, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String str, int i10, int i11, HexFormat hexFormat, int i12) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i10, i11, str.length());
        String prefix = hexFormat.getNumber().getPrefix();
        String suffix = hexFormat.getNumber().getSuffix();
        if (prefix.length() + suffix.length() < i11 - i10) {
            int checkContainsAt = checkContainsAt(str, prefix, i10, i11, "prefix");
            int length = i11 - suffix.length();
            checkContainsAt(str, suffix, length, i11, "suffix");
            checkHexLength(str, checkContainsAt, length, i12, false);
            long j10 = 0;
            while (checkContainsAt < length) {
                j10 = (j10 << 4) | decimalFromHexDigitAt(str, checkContainsAt);
                checkContainsAt++;
            }
            return j10;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected a hexadecimal number with prefix \"");
        sb2.append(prefix);
        sb2.append("\" and suffix \"");
        sb2.append(suffix);
        sb2.append("\", but was ");
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i10, i11);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb2.append(substring);
        throw new NumberFormatException(sb2.toString());
    }

    public static /* synthetic */ long hexToLongImpl$default(String str, int i10, int i11, HexFormat hexFormat, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = 0;
        }
        if ((i13 & 2) != 0) {
            i11 = str.length();
        }
        return hexToLongImpl(str, i10, i11, hexFormat, i12);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(@k String str, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    public static final int parsedByteArrayMaxSize(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        long charsPerSet;
        int i17;
        int i18;
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j10 = i15 + 2 + i16;
        long charsPerSet2 = charsPerSet(j10, i12, i14);
        if (i11 <= i12) {
            charsPerSet = charsPerSet(j10, i11, i14);
        } else {
            charsPerSet = charsPerSet(charsPerSet2, i11 / i12, i13);
            int i19 = i11 % i12;
            if (i19 != 0) {
                charsPerSet = charsPerSet + i13 + charsPerSet(j10, i19, i14);
            }
        }
        long j11 = i10;
        long wholeElementsPerSet = wholeElementsPerSet(j11, charsPerSet, 1);
        long j12 = j11 - ((charsPerSet + 1) * wholeElementsPerSet);
        long wholeElementsPerSet2 = wholeElementsPerSet(j12, charsPerSet2, i13);
        long j13 = j12 - ((charsPerSet2 + i13) * wholeElementsPerSet2);
        long wholeElementsPerSet3 = wholeElementsPerSet(j13, j10, i14);
        if (j13 - ((j10 + i14) * wholeElementsPerSet3) > 0) {
            i18 = i11;
            i17 = 1;
        } else {
            i17 = 0;
            i18 = i11;
        }
        return (int) ((wholeElementsPerSet * i18) + (wholeElementsPerSet2 * i12) + wholeElementsPerSet3 + i17);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final String toHexString(@k byte[] bArr, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long j10, HexFormat hexFormat, int i10) {
        if ((i10 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        String str = hexFormat.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        String prefix = hexFormat.getNumber().getPrefix();
        String suffix = hexFormat.getNumber().getSuffix();
        int length = prefix.length() + (i10 >> 2) + suffix.length();
        boolean removeLeadingZeros = hexFormat.getNumber().getRemoveLeadingZeros();
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(prefix);
        while (i10 > 0) {
            i10 -= 4;
            int i11 = (int) ((j10 >> i10) & 15);
            removeLeadingZeros = removeLeadingZeros && i11 == 0 && i10 > 0;
            if (!removeLeadingZeros) {
                sb2.append(str.charAt(i11));
            }
        }
        sb2.append(suffix);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    private static final long wholeElementsPerSet(long j10, long j11, int i10) {
        if (j10 <= 0 || j11 <= 0) {
            return 0L;
        }
        long j12 = i10;
        return (j10 + j12) / (j11 + j12);
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String str, int i10, int i11, HexFormat hexFormat) {
        return (byte) hexToLongImpl(str, i10, i11, hexFormat, 2);
    }

    public static /* synthetic */ byte hexToByte$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i10, i11, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String str, int i10, int i11, HexFormat hexFormat) {
        int i12 = i10;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i12, i11, str.length());
        if (i12 == i11) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        int bytesPerLine = bytes.getBytesPerLine();
        int bytesPerGroup = bytes.getBytesPerGroup();
        String bytePrefix = bytes.getBytePrefix();
        String byteSuffix = bytes.getByteSuffix();
        String byteSeparator = bytes.getByteSeparator();
        String groupSeparator = bytes.getGroupSeparator();
        String str2 = byteSeparator;
        int parsedByteArrayMaxSize = parsedByteArrayMaxSize(i11 - i12, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[parsedByteArrayMaxSize];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 < i11) {
            if (i14 == bytesPerLine) {
                i12 = checkNewLineAt(str, i12, i11);
                i14 = 0;
            } else if (i15 == bytesPerGroup) {
                i12 = checkContainsAt(str, groupSeparator, i12, i11, "group separator");
            } else {
                if (i15 != 0) {
                    i12 = checkContainsAt(str, str2, i12, i11, "byte separator");
                }
                i14++;
                i15++;
                int checkContainsAt = checkContainsAt(str, bytePrefix, i12, i11, "byte prefix");
                checkHexLength(str, checkContainsAt, RangesKt.coerceAtMost(checkContainsAt + 2, i11), 2, true);
                int decimalFromHexDigitAt = decimalFromHexDigitAt(str, checkContainsAt) << 4;
                bArr[i13] = (byte) (decimalFromHexDigitAt | decimalFromHexDigitAt(str, checkContainsAt + 1));
                i12 = checkContainsAt(str, byteSuffix, checkContainsAt + 2, i11, "byte suffix");
                i13++;
                str2 = str2;
            }
            i15 = 0;
            i14++;
            i15++;
            int checkContainsAt2 = checkContainsAt(str, bytePrefix, i12, i11, "byte prefix");
            checkHexLength(str, checkContainsAt2, RangesKt.coerceAtMost(checkContainsAt2 + 2, i11), 2, true);
            int decimalFromHexDigitAt2 = decimalFromHexDigitAt(str, checkContainsAt2) << 4;
            bArr[i13] = (byte) (decimalFromHexDigitAt2 | decimalFromHexDigitAt(str, checkContainsAt2 + 1));
            i12 = checkContainsAt(str, byteSuffix, checkContainsAt2 + 2, i11, "byte suffix");
            i13++;
            str2 = str2;
        }
        if (i13 == parsedByteArrayMaxSize) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i13);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i10, i11, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String str, int i10, int i11, HexFormat hexFormat) {
        return (int) hexToLongImpl(str, i10, i11, hexFormat, 8);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i10, i11, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLong(String str, int i10, int i11, HexFormat hexFormat) {
        return hexToLongImpl(str, i10, i11, hexFormat, 16);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i10, i11, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String str, int i10, int i11, HexFormat hexFormat) {
        return (short) hexToLongImpl(str, i10, i11, hexFormat, 4);
    }

    public static /* synthetic */ short hexToShort$default(String str, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i10, i11, hexFormat);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[SYNTHETIC] */
    @kotlin.SinceKotlin(version = "1.9")
    @xi.k
    @kotlin.ExperimentalStdlibApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String toHexString(@xi.k byte[] r17, int r18, int r19, @xi.k kotlin.text.HexFormat r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "format"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.collections.AbstractList$Companion r3 = kotlin.collections.AbstractList.INSTANCE
            int r5 = r0.length
            r3.checkBoundsIndexes$kotlin_stdlib(r1, r2, r5)
            if (r1 != r2) goto L1d
            java.lang.String r0 = ""
            return r0
        L1d:
            boolean r3 = r20.getUpperCase()
            if (r3 == 0) goto L26
            java.lang.String r3 = "0123456789ABCDEF"
            goto L28
        L26:
            java.lang.String r3 = "0123456789abcdef"
        L28:
            kotlin.text.HexFormat$BytesHexFormat r4 = r20.getBytes()
            int r12 = r4.getBytesPerLine()
            int r13 = r4.getBytesPerGroup()
            java.lang.String r14 = r4.getBytePrefix()
            java.lang.String r15 = r4.getByteSuffix()
            java.lang.String r11 = r4.getByteSeparator()
            java.lang.String r4 = r4.getGroupSeparator()
            int r5 = r2 - r1
            int r8 = r4.length()
            int r9 = r11.length()
            int r10 = r14.length()
            int r16 = r15.length()
            r6 = r12
            r7 = r13
            r1 = r11
            r11 = r16
            int r5 = formattedStringLength(r5, r6, r7, r8, r9, r10, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r8 = r18
            r9 = 0
            r10 = 0
        L68:
            if (r8 >= r2) goto La2
            r11 = r0[r8]
            r7 = r11 & 255(0xff, float:3.57E-43)
            if (r9 != r12) goto L78
            r9 = 10
            r6.append(r9)
            r9 = 0
        L76:
            r10 = 0
            goto L7e
        L78:
            if (r10 != r13) goto L7e
            r6.append(r4)
            goto L76
        L7e:
            if (r10 == 0) goto L83
            r6.append(r1)
        L83:
            r6.append(r14)
            int r7 = r7 >> 4
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r7 = r11 & 15
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r6.append(r15)
            int r10 = r10 + 1
            int r9 = r9 + 1
            int r8 = r8 + 1
            goto L68
        La2:
            int r0 = r6.length()
            if (r5 != r0) goto Lb2
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        Lb2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.HexExtensionsKt.toHexString(byte[], int, int, kotlin.text.HexFormat):java.lang.String");
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i10, int i11, HexFormat hexFormat, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i10, i11, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte b10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b10, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s10, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(int i10, HexFormat hexFormat, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i10, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j10, HexFormat hexFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j10, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final String toHexString(byte b10, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(b10, format, 8);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final String toHexString(short s10, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(s10, format, 16);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final String toHexString(int i10, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(i10, format, 32);
    }

    @SinceKotlin(version = "1.9")
    @k
    @ExperimentalStdlibApi
    public static final String toHexString(long j10, @k HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexStringImpl(j10, format, 64);
    }
}
