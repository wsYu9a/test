package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.Launcher;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "K", "it", "", Launcher.Method.INVOKE_CALLBACK, "(Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements Function1<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ Function1 $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1 function1, Comparable comparable) {
        super(1);
        this.$selector = function1;
        this.$key = comparable;
    }

    /* renamed from: invoke */
    public final int invoke2(T t) {
        int compareValues;
        compareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), this.$key);
        return compareValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2((CollectionsKt__CollectionsKt$binarySearchBy$1<T>) obj));
    }
}
