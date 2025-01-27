package kotlin.collections;

import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b=\u0010>J\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0004\u001a\u00020\t*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0004\u001a\u00020\r*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0004\u001a\u00020\u0011*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0018\u001a\u00020\u0015*\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0018\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\"\u001a\u00020\u001f*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u00020\u001f*\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0016\u0010\"\u001a\u00020\u001f*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0016\u0010\"\u001a\u00020\u001f*\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0016\u0010,\u001a\u00020)*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0016\u0010,\u001a\u00020)*\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0016\u0010,\u001a\u00020)*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0016\u0010,\u001a\u00020)*\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u000503*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\t03*\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\r03*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001103*\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lkotlin/collections/UArraysKt;", "", "Lkotlin/UIntArray;", "Lkotlin/random/Random;", "random", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UByteArray;", "Lkotlin/UByte;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", AdnName.OTHER, "", "contentEquals-ctEhBpI", "([I[I)Z", "contentEquals", "contentEquals-us8wMrg", "([J[J)Z", "contentEquals-kdPth3s", "([B[B)Z", "contentEquals-mazbYpA", "([S[S)Z", "", "contentHashCode--ajY-9A", "([I)I", "contentHashCode", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode-rL5Bavg", "([S)I", "", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UArraysKt {
    public static final UArraysKt INSTANCE = new UArraysKt();

    private UArraysKt() {
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-ctEhBpI */
    public static final boolean m414contentEqualsctEhBpI(@d int[] contentEquals, @d int[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-kdPth3s */
    public static final boolean m415contentEqualskdPth3s(@d byte[] contentEquals, @d byte[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-mazbYpA */
    public static final boolean m416contentEqualsmazbYpA(@d short[] contentEquals, @d short[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-us8wMrg */
    public static final boolean m417contentEqualsus8wMrg(@d long[] contentEquals, @d long[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode--ajY-9A */
    public static final int m418contentHashCodeajY9A(@d int[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-GBYM_sE */
    public static final int m419contentHashCodeGBYM_sE(@d byte[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-QwZRm1k */
    public static final int m420contentHashCodeQwZRm1k(@d long[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-rL5Bavg */
    public static final int m421contentHashCoderL5Bavg(@d short[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString--ajY-9A */
    public static final String m422contentToStringajY9A(@d int[] contentToString) {
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        return CollectionsKt___CollectionsKt.joinToString$default(UIntArray.m212boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-GBYM_sE */
    public static final String m423contentToStringGBYM_sE(@d byte[] contentToString) {
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        return CollectionsKt___CollectionsKt.joinToString$default(UByteArray.m143boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-QwZRm1k */
    public static final String m424contentToStringQwZRm1k(@d long[] contentToString) {
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        return CollectionsKt___CollectionsKt.joinToString$default(ULongArray.m281boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-rL5Bavg */
    public static final String m425contentToStringrL5Bavg(@d short[] contentToString) {
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        return CollectionsKt___CollectionsKt.joinToString$default(UShortArray.m376boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM */
    public static final int m426random2D5oskM(@d int[] random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UIntArray.m222isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.m219getimpl(random, random2.nextInt(UIntArray.m220getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA */
    public static final long m427randomJzugnMA(@d long[] random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (ULongArray.m291isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.m288getimpl(random, random2.nextInt(ULongArray.m289getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8 */
    public static final byte m428randomoSF2wD8(@d byte[] random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UByteArray.m153isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.m150getimpl(random, random2.nextInt(UByteArray.m151getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8 */
    public static final short m429randoms5X_as8(@d short[] random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UShortArray.m386isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.m383getimpl(random, random2.nextInt(UShortArray.m384getSizeimpl(random)));
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray--ajY-9A */
    public static final UInt[] m430toTypedArrayajY9A(@d int[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m220getSizeimpl = UIntArray.m220getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[m220getSizeimpl];
        for (int i2 = 0; i2 < m220getSizeimpl; i2++) {
            uIntArr[i2] = UInt.m162boximpl(UIntArray.m219getimpl(toTypedArray, i2));
        }
        return uIntArr;
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-GBYM_sE */
    public static final UByte[] m431toTypedArrayGBYM_sE(@d byte[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m151getSizeimpl = UByteArray.m151getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[m151getSizeimpl];
        for (int i2 = 0; i2 < m151getSizeimpl; i2++) {
            uByteArr[i2] = UByte.m95boximpl(UByteArray.m150getimpl(toTypedArray, i2));
        }
        return uByteArr;
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-QwZRm1k */
    public static final ULong[] m432toTypedArrayQwZRm1k(@d long[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m289getSizeimpl = ULongArray.m289getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[m289getSizeimpl];
        for (int i2 = 0; i2 < m289getSizeimpl; i2++) {
            uLongArr[i2] = ULong.m231boximpl(ULongArray.m288getimpl(toTypedArray, i2));
        }
        return uLongArr;
    }

    @d
    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-rL5Bavg */
    public static final UShort[] m433toTypedArrayrL5Bavg(@d short[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m384getSizeimpl = UShortArray.m384getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[m384getSizeimpl];
        for (int i2 = 0; i2 < m384getSizeimpl; i2++) {
            uShortArr[i2] = UShort.m328boximpl(UShortArray.m383getimpl(toTypedArray, i2));
        }
        return uShortArr;
    }
}
