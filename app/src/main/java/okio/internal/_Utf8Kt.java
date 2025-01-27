package okio.internal;

import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.mozilla.universalchardet.prober.g;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "beginIndex", "endIndex", "", "commonToUtf8String", "([BII)Ljava/lang/String;", "commonAsUtf8ToByteArray", "(Ljava/lang/String;)[B", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class _Utf8Kt {
    @d
    public static final byte[] commonAsUtf8ToByteArray(@d String commonAsUtf8ToByteArray) {
        int i2;
        int i3;
        char charAt;
        Intrinsics.checkParameterIsNotNull(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt2 = commonAsUtf8ToByteArray.charAt(i4);
            if (charAt2 >= 128) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i5 = i4;
                while (i4 < length2) {
                    char charAt3 = commonAsUtf8ToByteArray.charAt(i4);
                    if (charAt3 < 128) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) charAt3;
                        i4++;
                        while (i4 < length2 && commonAsUtf8ToByteArray.charAt(i4) < 128) {
                            bArr[i6] = (byte) commonAsUtf8ToByteArray.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (charAt3 < 2048) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> 6) | Downloads.Impl.STATUS_RUNNING);
                            byte b2 = (byte) ((charAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b2;
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((charAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((charAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b3;
                        } else if (charAt3 > 56319 || length2 <= (i3 = i4 + 1) || 56320 > (charAt = commonAsUtf8ToByteArray.charAt(i3)) || 57343 < charAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((charAt4 >> 18) | g.n);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((charAt4 >> 6) & 63) | 128);
                            byte b4 = (byte) ((charAt4 & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = b4;
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i5);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i4] = (byte) charAt2;
            i4++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        Intrinsics.checkExpressionValueIsNotNull(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x010f, code lost:
    
        if (((r16[r5] & 192) == 128) == false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0097, code lost:
    
        if (((r16[r5] & 192) == 128) == false) goto L163;
     */
    @f.b.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@f.b.a.d byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return commonToUtf8String(bArr, i2, i3);
    }
}
