package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import f.b.a.e;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\u0003H\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0010\u001a\u0014\u0010\u0011\u001a\u00020\u0006*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\t*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0017\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u001a*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u001d*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0015\u0010 \u001a\u0004\u0018\u00010\u001a*\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u0004\u0018\u00010\u001d*\u00020\u0003H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u0014\u0010%\u001a\u00020$*\u00020\u0003H\u0087\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010%\u001a\u00020$*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b%\u0010'\u001a\u0015\u0010(\u001a\u0004\u0018\u00010$*\u00020\u0003H\u0007¢\u0006\u0004\b(\u0010&\u001a\u001d\u0010(\u001a\u0004\u0018\u00010$*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010'\u001a\u0014\u0010*\u001a\u00020)*\u00020\u0003H\u0087\b¢\u0006\u0004\b*\u0010+\u001a\u001c\u0010*\u001a\u00020)*\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0087\b¢\u0006\u0004\b*\u0010.\u001a\u0015\u0010/\u001a\u0004\u0018\u00010)*\u00020\u0003H\u0007¢\u0006\u0004\b/\u0010+\u001a\u001d\u0010/\u001a\u0004\u0018\u00010)*\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b/\u0010.\u001a4\u00106\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u001002\u0006\u00101\u001a\u00020\u00032\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u000002H\u0082\b¢\u0006\u0004\b4\u00105¨\u00067"}, d2 = {"", "", "radix", "", "toString", "(BI)Ljava/lang/String;", "", "(SI)Ljava/lang/String;", "(II)Ljava/lang/String;", "", "(JI)Ljava/lang/String;", "", "toBoolean", "(Ljava/lang/String;)Z", "toByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toLong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "", "toFloat", "(Ljava/lang/String;)F", "", "toDouble", "(Ljava/lang/String;)D", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "Ljava/math/BigInteger;", "toBigInteger", "(Ljava/lang/String;)Ljava/math/BigInteger;", "(Ljava/lang/String;I)Ljava/math/BigInteger;", "toBigIntegerOrNull", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(Ljava/lang/String;Ljava/math/MathContext;)Ljava/math/BigDecimal;", "toBigDecimalOrNull", ExifInterface.GPS_DIRECTION_TRUE, "str", "Lkotlin/Function1;", "parse", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenFloatValue", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return function1.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(@d String str) {
        return new BigDecimal(str);
    }

    @e
    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(@d String toBigDecimalOrNull) {
        Intrinsics.checkParameterIsNotNull(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(@d String str) {
        return new BigInteger(str);
    }

    @e
    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(@d String toBigIntegerOrNull) {
        Intrinsics.checkParameterIsNotNull(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        return toBigIntegerOrNull(toBigIntegerOrNull, 10);
    }

    @InlineOnly
    private static final boolean toBoolean(@d String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    private static final byte toByte(@d String str) {
        return Byte.parseByte(str);
    }

    @InlineOnly
    private static final double toDouble(@d String str) {
        return Double.parseDouble(str);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Double toDoubleOrNull(@d String toDoubleOrNull) {
        Intrinsics.checkParameterIsNotNull(toDoubleOrNull, "$this$toDoubleOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble(toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final float toFloat(@d String str) {
        return Float.parseFloat(str);
    }

    @e
    @SinceKotlin(version = "1.1")
    public static final Float toFloatOrNull(@d String toFloatOrNull) {
        Intrinsics.checkParameterIsNotNull(toFloatOrNull, "$this$toFloatOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat(toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final int toInt(@d String str) {
        return Integer.parseInt(str);
    }

    @InlineOnly
    private static final long toLong(@d String str) {
        return Long.parseLong(str);
    }

    @InlineOnly
    private static final short toShort(@d String str) {
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(byte b2, int i2) {
        int checkRadix;
        int checkRadix2;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(checkRadix);
        String num = Integer.toString(b2, checkRadix2);
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(@d String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(@d String str, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return new BigInteger(str, checkRadix);
    }

    @e
    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(@d String toBigIntegerOrNull, int i2) {
        int checkRadix;
        Intrinsics.checkParameterIsNotNull(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toBigIntegerOrNull.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i3 = toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                if (CharsKt__CharJVMKt.digitOf(toBigIntegerOrNull.charAt(i3), i2) < 0) {
                    return null;
                }
            }
        } else if (CharsKt__CharJVMKt.digitOf(toBigIntegerOrNull.charAt(0), i2) < 0) {
            return null;
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return new BigInteger(toBigIntegerOrNull, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte toByte(@d String str, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return Byte.parseByte(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int toInt(@d String str, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return Integer.parseInt(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long toLong(@d String str, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return Long.parseLong(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short toShort(@d String str, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return Short.parseShort(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(short s, int i2) {
        int checkRadix;
        int checkRadix2;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(checkRadix);
        String num = Integer.toString(s, checkRadix2);
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @e
    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(@d String toBigDecimalOrNull, @d MathContext mathContext) {
        Intrinsics.checkParameterIsNotNull(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        Intrinsics.checkParameterIsNotNull(mathContext, "mathContext");
        try {
            if (ScreenFloatValueRegEx.value.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(int i2, int i3) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        String num = Integer.toString(i2, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(long j2, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        String l = Long.toString(j2, checkRadix);
        Intrinsics.checkExpressionValueIsNotNull(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }
}
