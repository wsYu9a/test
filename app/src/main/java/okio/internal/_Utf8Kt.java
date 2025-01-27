package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import xi.k;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class _Utf8Kt {
    @k
    public static final byte[] commonAsUtf8ToByteArray(@k String str) {
        int i10;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            char charAt2 = str.charAt(i11);
            if (Intrinsics.compare((int) charAt2, 128) >= 0) {
                int length2 = str.length();
                int i12 = i11;
                while (i11 < length2) {
                    char charAt3 = str.charAt(i11);
                    if (Intrinsics.compare((int) charAt3, 128) < 0) {
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) charAt3;
                        i11++;
                        while (true) {
                            i12 = i13;
                            if (i11 < length2 && Intrinsics.compare((int) str.charAt(i11), 128) < 0) {
                                i13 = i12 + 1;
                                bArr[i12] = (byte) str.charAt(i11);
                                i11++;
                            }
                        }
                    } else {
                        if (Intrinsics.compare((int) charAt3, 2048) < 0) {
                            bArr[i12] = (byte) ((charAt3 >> 6) | 192);
                            i12 += 2;
                            bArr[i12 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i12] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i12 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i12 += 3;
                            bArr[i12 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) charAt3, 56319) > 0 || length2 <= (i10 = i11 + 1) || 56320 > (charAt = str.charAt(i10)) || charAt >= 57344) {
                            bArr[i12] = Utf8.REPLACEMENT_BYTE;
                            i11++;
                            i12++;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i10)) - 56613888;
                            bArr[i12] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i12 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i12 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i12 += 4;
                            bArr[i12 + 3] = (byte) ((charAt4 & 63) | 128);
                            i11 += 2;
                        }
                        i11++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i12);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i11] = (byte) charAt2;
            i11++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ec, code lost:
    
        if ((r16[r5] & 192) == 128) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008a, code lost:
    
        if ((r16[r5] & 192) == 128) goto L254;
     */
    @xi.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@xi.k byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return commonToUtf8String(bArr, i10, i11);
    }
}
