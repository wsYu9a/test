package kotlin;

import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\rH\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0013H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0014\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0015\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0016H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0017\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0018\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0019H\u0087\b¢\u0006\u0004\b\u000e\u0010\u001a\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u000e\u0010\u001b¨\u0006\u001c"}, d2 = {"Ljava/math/BigDecimal;", AdnName.OTHER, "plus", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "minus", "times", "div", "mod", "rem", "unaryMinus", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "inc", "dec", "", "toBigDecimal", "(I)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(ILjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(J)Ljava/math/BigDecimal;", "(JLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(F)Ljava/math/BigDecimal;", "(FLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(D)Ljava/math/BigDecimal;", "(DLjava/math/MathContext;)Ljava/math/BigDecimal;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal dec(@d BigDecimal dec) {
        Intrinsics.checkParameterIsNotNull(dec, "$this$dec");
        BigDecimal subtract = dec.subtract(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal div(@d BigDecimal div, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(div, "$this$div");
        BigDecimal divide = div.divide(bigDecimal, RoundingMode.HALF_EVEN);
        Intrinsics.checkExpressionValueIsNotNull(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal inc(@d BigDecimal inc) {
        Intrinsics.checkParameterIsNotNull(inc, "$this$inc");
        BigDecimal add = inc.add(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal minus(@d BigDecimal minus, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        BigDecimal subtract = minus.subtract(bigDecimal);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(other)");
        return subtract;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use rem(other) instead", replaceWith = @ReplaceWith(expression = "rem(other)", imports = {}))
    @InlineOnly
    private static final BigDecimal mod(@d BigDecimal mod, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(mod, "$this$mod");
        BigDecimal remainder = mod.remainder(bigDecimal);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal plus(@d BigDecimal plus, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        BigDecimal add = plus.add(bigDecimal);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal rem(@d BigDecimal rem, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(rem, "$this$rem");
        BigDecimal remainder = rem.remainder(bigDecimal);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal times(@d BigDecimal times, BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(times, "$this$times");
        BigDecimal multiply = times.multiply(bigDecimal);
        Intrinsics.checkExpressionValueIsNotNull(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf(i2);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    private static final BigDecimal unaryMinus(@d BigDecimal unaryMinus) {
        Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        BigDecimal negate = unaryMinus.negate();
        Intrinsics.checkExpressionValueIsNotNull(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j2) {
        BigDecimal valueOf = BigDecimal.valueOf(j2);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
