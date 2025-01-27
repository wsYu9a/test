package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003B\u001f\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\t\u0010\nR)\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlin/comparisons/ReversedComparator;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "()Ljava/util/Comparator;", "comparator", "Ljava/util/Comparator;", "getComparator", "<init>", "(Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class ReversedComparator<T> implements Comparator<T> {

    @d
    private final Comparator<T> comparator;

    public ReversedComparator(@d Comparator<T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        this.comparator = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T a2, T b2) {
        return this.comparator.compare(b2, a2);
    }

    @d
    public final Comparator<T> getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    @d
    public final Comparator<T> reversed() {
        return this.comparator;
    }
}
