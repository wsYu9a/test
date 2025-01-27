package kotlin.text;

import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\n\u001a\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "", "toByteOrNull", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "(Ljava/lang/String;I)Ljava/lang/Byte;", "", "toShortOrNull", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "toLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "input", "", "numberFormatError", "(Ljava/lang/String;)Ljava/lang/Void;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    @d
    public static final Void numberFormatError(@d String input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(@d String toByteOrNull) {
        Intrinsics.checkParameterIsNotNull(toByteOrNull, "$this$toByteOrNull");
        return toByteOrNull(toByteOrNull, 10);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(@d String toIntOrNull) {
        Intrinsics.checkParameterIsNotNull(toIntOrNull, "$this$toIntOrNull");
        return toIntOrNull(toIntOrNull, 10);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Long toLongOrNull(@d String toLongOrNull) {
        Intrinsics.checkParameterIsNotNull(toLongOrNull, "$this$toLongOrNull");
        return toLongOrNull(toLongOrNull, 10);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(@d String toShortOrNull) {
        Intrinsics.checkParameterIsNotNull(toShortOrNull, "$this$toShortOrNull");
        return toShortOrNull(toShortOrNull, 10);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(@d String toByteOrNull, int i2) {
        int intValue;
        Intrinsics.checkParameterIsNotNull(toByteOrNull, "$this$toByteOrNull");
        Integer intOrNull = toIntOrNull(toByteOrNull, i2);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(@d String toIntOrNull, int i2) {
        boolean z;
        int i3;
        Intrinsics.checkParameterIsNotNull(toIntOrNull, "$this$toIntOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = toIntOrNull.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (charAt >= '0') {
            z = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(toIntOrNull.charAt(i6), i2);
            if (digitOf < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + digitOf) {
                return null;
            }
            i4 = i3 - digitOf;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    @f.b.a.e
    @kotlin.SinceKotlin(version = "1.1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long toLongOrNull(@f.b.a.d java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "$this$toLongOrNull"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)
            kotlin.text.CharsKt.checkRadix(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r5 >= r6) goto L35
            if (r2 != r9) goto L26
            return r3
        L26:
            r6 = 45
            if (r5 != r6) goto L2e
            r7 = -9223372036854775808
            r4 = 1
            goto L36
        L2e:
            r6 = 43
            if (r5 != r6) goto L34
            r4 = 1
            goto L35
        L34:
            return r3
        L35:
            r9 = 0
        L36:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L3e:
            if (r4 >= r2) goto L6f
            char r14 = r0.charAt(r4)
            int r14 = kotlin.text.CharsKt__CharJVMKt.digitOf(r14, r1)
            if (r14 >= 0) goto L4b
            return r3
        L4b:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5b
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L5a
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5b
        L5a:
            return r3
        L5b:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L66
            return r3
        L66:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L3e
        L6f:
            if (r9 == 0) goto L76
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L7b
        L76:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(java.lang.String, int):java.lang.Long");
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(@d String toShortOrNull, int i2) {
        int intValue;
        Intrinsics.checkParameterIsNotNull(toShortOrNull, "$this$toShortOrNull");
        Integer intOrNull = toIntOrNull(toShortOrNull, i2);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
