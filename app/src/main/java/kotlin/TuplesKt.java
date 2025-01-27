package kotlin;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\u0086\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "that", "Lkotlin/Pair;", "to", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "", "toList", "(Lkotlin/Pair;)Ljava/util/List;", "Lkotlin/Triple;", "(Lkotlin/Triple;)Ljava/util/List;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "TuplesKt")
/* loaded from: classes5.dex */
public final class TuplesKt {
    @d
    public static final <A, B> Pair<A, B> to(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    @d
    public static final <T> List<T> toList(@d Pair<? extends T, ? extends T> toList) {
        List<T> listOf;
        Intrinsics.checkParameterIsNotNull(toList, "$this$toList");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Object[]{toList.getFirst(), toList.getSecond()});
        return listOf;
    }

    @d
    public static final <T> List<T> toList(@d Triple<? extends T, ? extends T, ? extends T> toList) {
        List<T> listOf;
        Intrinsics.checkParameterIsNotNull(toList, "$this$toList");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Object[]{toList.getFirst(), toList.getSecond(), toList.getThird()});
        return listOf;
    }
}
