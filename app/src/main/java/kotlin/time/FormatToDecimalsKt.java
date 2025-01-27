package kotlin.time;

import com.kwad.sdk.ranger.e;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"", "decimals", "Ljava/text/DecimalFormat;", "createFormatForDecimals", "(I)Ljava/text/DecimalFormat;", "", Downloads.RequestHeaders.COLUMN_VALUE, "", "formatToExactDecimals", "(DI)Ljava/lang/String;", "formatUpToDecimals", "formatScientific", "(D)Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "scientificFormat", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormatSymbols;", "rootNegativeExpFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "", "precisionFormats", "[Ljava/lang/ThreadLocal;", "rootPositiveExpFormatSymbols", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class FormatToDecimalsKt {
    private static final ThreadLocal<DecimalFormat>[] precisionFormats;
    private static final DecimalFormatSymbols rootNegativeExpFormatSymbols;
    private static final DecimalFormatSymbols rootPositiveExpFormatSymbols;
    private static final ThreadLocal<DecimalFormat> scientificFormat;

    static {
        Locale locale = Locale.ROOT;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
        decimalFormatSymbols.setExponentSeparator(e.TAG);
        rootNegativeExpFormatSymbols = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(locale);
        decimalFormatSymbols2.setExponentSeparator("e+");
        rootPositiveExpFormatSymbols = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        precisionFormats = threadLocalArr;
        scientificFormat = new ThreadLocal<>();
    }

    private static final DecimalFormat createFormatForDecimals(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", rootNegativeExpFormatSymbols);
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @d
    public static final String formatScientific(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = scientificFormat;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", rootNegativeExpFormatSymbols);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) (-1))) ? rootPositiveExpFormatSymbols : rootNegativeExpFormatSymbols);
        String format = decimalFormat2.format(d2);
        Intrinsics.checkExpressionValueIsNotNull(format, "scientificFormat.getOrSe… }\n        .format(value)");
        return format;
    }

    @d
    public static final String formatToExactDecimals(double d2, int i2) {
        DecimalFormat createFormatForDecimals;
        ThreadLocal<DecimalFormat>[] threadLocalArr = precisionFormats;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = createFormatForDecimals(i2);
                threadLocal.set(decimalFormat);
            }
            createFormatForDecimals = decimalFormat;
        } else {
            createFormatForDecimals = createFormatForDecimals(i2);
        }
        String format = createFormatForDecimals.format(d2);
        Intrinsics.checkExpressionValueIsNotNull(format, "format.format(value)");
        return format;
    }

    @d
    public static final String formatUpToDecimals(double d2, int i2) {
        DecimalFormat createFormatForDecimals = createFormatForDecimals(0);
        createFormatForDecimals.setMaximumFractionDigits(i2);
        String format = createFormatForDecimals.format(d2);
        Intrinsics.checkExpressionValueIsNotNull(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }
}
