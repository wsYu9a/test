package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "", "iterator", "(Ljava/util/Enumeration;)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__IterablesKt {
    @d
    public static <T> Iterator<T> iterator(@d Enumeration<T> iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new CollectionsKt__IteratorsJVMKt$iterator$1(iterator);
    }
}
