package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import f.b.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\u000f\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u0001*\u00028\u0001\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0018\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010!\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "flatten", "([[Ljava/lang/Object;)Ljava/util/List;", "R", "Lkotlin/Pair;", TKDownloadReason.KSAD_TK_UNZIP, "([Lkotlin/Pair;)Lkotlin/Pair;", "", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "C", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", AdnName.OTHER, "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEqualsImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringImpl", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "contentDeepToStringInternal", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes5.dex */
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean contentDeepEquals(@d T[] contentDeepEqualsImpl, @d T[] other) {
        boolean m509contentEqualsus8wMrg;
        boolean m506contentEqualsctEhBpI;
        boolean m508contentEqualsmazbYpA;
        boolean m507contentEqualskdPth3s;
        Intrinsics.checkParameterIsNotNull(contentDeepEqualsImpl, "$this$contentDeepEqualsImpl");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (contentDeepEqualsImpl == other) {
            return true;
        }
        if (contentDeepEqualsImpl.length != other.length) {
            return false;
        }
        int length = contentDeepEqualsImpl.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object[] objArr = contentDeepEqualsImpl[i2];
            Object[] objArr2 = other[i2];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof UByteArray) && (objArr2 instanceof UByteArray)) {
                    m507contentEqualskdPth3s = UArraysKt___UArraysKt.m507contentEqualskdPth3s(((UByteArray) objArr).getStorage(), ((UByteArray) objArr2).getStorage());
                    if (!m507contentEqualskdPth3s) {
                        return false;
                    }
                } else if ((objArr instanceof UShortArray) && (objArr2 instanceof UShortArray)) {
                    m508contentEqualsmazbYpA = UArraysKt___UArraysKt.m508contentEqualsmazbYpA(((UShortArray) objArr).getStorage(), ((UShortArray) objArr2).getStorage());
                    if (!m508contentEqualsmazbYpA) {
                        return false;
                    }
                } else if ((objArr instanceof UIntArray) && (objArr2 instanceof UIntArray)) {
                    m506contentEqualsctEhBpI = UArraysKt___UArraysKt.m506contentEqualsctEhBpI(((UIntArray) objArr).getStorage(), ((UIntArray) objArr2).getStorage());
                    if (!m506contentEqualsctEhBpI) {
                        return false;
                    }
                } else if ((objArr instanceof ULongArray) && (objArr2 instanceof ULongArray)) {
                    m509contentEqualsus8wMrg = UArraysKt___UArraysKt.m509contentEqualsus8wMrg(((ULongArray) objArr).getStorage(), ((ULongArray) objArr2).getStorage());
                    if (!m509contentEqualsus8wMrg) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @d
    @PublishedApi
    public static final <T> String contentDeepToString(@d T[] contentDeepToStringImpl) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(contentDeepToStringImpl, "$this$contentDeepToStringImpl");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(contentDeepToStringImpl.length, 429496729);
        StringBuilder sb = new StringBuilder((coerceAtMost * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(contentDeepToStringImpl, sb, new ArrayList());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(@d T[] tArr, StringBuilder sb, List<Object[]> list) {
        String m516contentToStringQwZRm1k;
        String m514contentToStringajY9A;
        String m517contentToStringrL5Bavg;
        String m515contentToStringGBYM_sE;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i2];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays2, "java.util.Arrays.toString(this)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays3, "java.util.Arrays.toString(this)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays4, "java.util.Arrays.toString(this)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays5, "java.util.Arrays.toString(this)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays6, "java.util.Arrays.toString(this)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays7, "java.util.Arrays.toString(this)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                Intrinsics.checkExpressionValueIsNotNull(arrays8, "java.util.Arrays.toString(this)");
                sb.append(arrays8);
            } else if (objArr instanceof UByteArray) {
                m515contentToStringGBYM_sE = UArraysKt___UArraysKt.m515contentToStringGBYM_sE(((UByteArray) objArr).getStorage());
                sb.append(m515contentToStringGBYM_sE);
            } else if (objArr instanceof UShortArray) {
                m517contentToStringrL5Bavg = UArraysKt___UArraysKt.m517contentToStringrL5Bavg(((UShortArray) objArr).getStorage());
                sb.append(m517contentToStringrL5Bavg);
            } else if (objArr instanceof UIntArray) {
                m514contentToStringajY9A = UArraysKt___UArraysKt.m514contentToStringajY9A(((UIntArray) objArr).getStorage());
                sb.append(m514contentToStringajY9A);
            } else if (objArr instanceof ULongArray) {
                m516contentToStringQwZRm1k = UArraysKt___UArraysKt.m516contentToStringQwZRm1k(((ULongArray) objArr).getStorage());
                sb.append(m516contentToStringQwZRm1k);
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    @d
    public static final <T> List<T> flatten(@d T[][] flatten) {
        Intrinsics.checkParameterIsNotNull(flatten, "$this$flatten");
        int i2 = 0;
        for (T[] tArr : flatten) {
            i2 += tArr.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] tArr2 : flatten) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, tArr2);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Object[] objArr, Function0 function0) {
        return objArr.length == 0 ? function0.invoke() : objArr;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(@e Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    @d
    public static final <T, R> Pair<List<T>, List<R>> unzip(@d Pair<? extends T, ? extends R>[] unzip) {
        Intrinsics.checkParameterIsNotNull(unzip, "$this$unzip");
        ArrayList arrayList = new ArrayList(unzip.length);
        ArrayList arrayList2 = new ArrayList(unzip.length);
        for (Pair<? extends T, ? extends R> pair : unzip) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
