package kotlin.collections.builders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.videocache.sourcestorage.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001eH\u0002¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"arrayOfUninitializedElements", "", ExifInterface.LONGITUDE_EAST, "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", ExifInterface.GPS_DIRECTION_TRUE, "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", TypedValues.CycleType.S_WAVE_OFFSET, a.f20681d, AdnName.OTHER, "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
/* loaded from: classes4.dex */
public final class ListBuilderKt {
    @k
    public static final <E> E[] arrayOfUninitializedElements(int i10) {
        if (i10 >= 0) {
            return (E[]) new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @k
    public static final <T> T[] copyOfUninitializedElements(@k T[] tArr, int i10) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void resetAt(@k E[] eArr, int i10) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void resetRange(@k E[] eArr, int i10, int i11) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        while (i10 < i11) {
            resetAt(eArr, i10);
            i10++;
        }
    }

    public static final <T> boolean subarrayContentEquals(T[] tArr, int i10, int i11, List<?> list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!Intrinsics.areEqual(tArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    public static final <T> int subarrayContentHashCode(T[] tArr, int i10, int i11) {
        int i12 = 1;
        for (int i13 = 0; i13 < i11; i13++) {
            T t10 = tArr[i10 + i13];
            i12 = (i12 * 31) + (t10 != null ? t10.hashCode() : 0);
        }
        return i12;
    }

    public static final <T> String subarrayContentToString(T[] tArr, int i10, int i11, Collection<? extends T> collection) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            T t10 = tArr[i10 + i12];
            if (t10 == collection) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(t10);
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }
}
