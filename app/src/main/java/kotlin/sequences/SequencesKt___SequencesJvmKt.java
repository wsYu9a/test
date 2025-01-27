package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aC\u0010\t\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0012\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0010j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0011¢\u0006\u0004\b\u000e\u0010\u0013¨\u0006\u0014"}, d2 = {"R", "Lkotlin/sequences/Sequence;", "Ljava/lang/Class;", "klass", "filterIsInstance", "(Lkotlin/sequences/Sequence;Ljava/lang/Class;)Lkotlin/sequences/Sequence;", "", "C", "destination", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/SortedSet;", "toSortedSet", "(Lkotlin/sequences/Sequence;)Ljava/util/SortedSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @d
    public static final <R> Sequence<R> filterIsInstance(@d Sequence<?> filterIsInstance, @d final Class<R> klass) {
        Intrinsics.checkParameterIsNotNull(filterIsInstance, "$this$filterIsInstance");
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        Sequence<R> filter = SequencesKt___SequencesKt.filter(filterIsInstance, new Function1<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2(obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@e Object obj) {
                return klass.isInstance(obj);
            }
        });
        if (filter != null) {
            return filter;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @d
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@d Sequence<?> filterIsInstanceTo, @d C destination, @d Class<R> klass) {
        Intrinsics.checkParameterIsNotNull(filterIsInstanceTo, "$this$filterIsInstanceTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        for (Object obj : filterIsInstanceTo) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @d
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@d Sequence<? extends T> toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final <T> SortedSet<T> toSortedSet(@d Sequence<? extends T> toSortedSet, @d Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(toSortedSet, new TreeSet(comparator));
    }
}
