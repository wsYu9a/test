package kotlin.collections;

import f.b.a.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class CollectionsKt__IterablesKt$Iterable$1<T> implements Iterable<T>, KMappedMarker {
    final /* synthetic */ Function0 $iterator;

    public CollectionsKt__IterablesKt$Iterable$1(Function0 function0) {
        this.$iterator = function0;
    }

    @Override // java.lang.Iterable
    @d
    public Iterator<T> iterator() {
        return (Iterator) this.$iterator.invoke();
    }
}
