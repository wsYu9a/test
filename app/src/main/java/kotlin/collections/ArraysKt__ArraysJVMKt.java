package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.OapsKey;
import f.b.a.d;
import f.b.a.e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a.\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0018\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "Ljava/nio/charset/Charset;", "charset", "", "toString", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "", "toTypedArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "reference", "", OapsKey.KEY_SIZE, "arrayOfNulls", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", "", "copyOfRangeToIndexCheck", "(II)V", "contentDeepHashCode", "([Ljava/lang/Object;)I", "contentDeepHashCodeImpl", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes5.dex */
class ArraysKt__ArraysJVMKt {
    @d
    public static final <T> T[] arrayOfNulls(@d T[] reference, int i2) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i2);
        if (newInstance != null) {
            return (T[]) ((Object[]) newInstance);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    public static final <T> int contentDeepHashCode(@d T[] contentDeepHashCodeImpl) {
        Intrinsics.checkParameterIsNotNull(contentDeepHashCodeImpl, "$this$contentDeepHashCodeImpl");
        return Arrays.deepHashCode(contentDeepHashCodeImpl);
    }

    @SinceKotlin(version = "1.3")
    public static final void copyOfRangeToIndexCheck(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    @d
    public static final /* synthetic */ <T> T[] orEmpty(@e T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }

    @InlineOnly
    private static final String toString(@d byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @d
    public static final /* synthetic */ <T> T[] toTypedArray(@d Collection<? extends T> toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) toTypedArray.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
