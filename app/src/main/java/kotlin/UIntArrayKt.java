package kotlin;

import com.cdo.oaps.ad.OapsKey;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"", OapsKey.KEY_SIZE, "Lkotlin/Function1;", "Lkotlin/UInt;", "init", "Lkotlin/UIntArray;", "UIntArray", "(ILkotlin/jvm/functions/Function1;)[I", "elements", "uintArrayOf--ajY-9A", "([I)[I", "uintArrayOf", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class UIntArrayKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] UIntArray(int i2, Function1<? super Integer, UInt> function1) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = function1.invoke(Integer.valueOf(i3)).getData();
        }
        return UIntArray.m214constructorimpl(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: uintArrayOf--ajY-9A */
    private static final int[] m229uintArrayOfajY9A(int... iArr) {
        return iArr;
    }
}
