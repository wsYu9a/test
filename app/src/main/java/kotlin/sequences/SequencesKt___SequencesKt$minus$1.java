package kotlin.sequences;

import f.b.a.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SequencesKt___SequencesKt$minus$1<T> implements Sequence<T> {
    final /* synthetic */ Object $element;
    final /* synthetic */ Sequence $this_minus;

    SequencesKt___SequencesKt$minus$1(Sequence<? extends T> sequence, Object obj) {
        this.$this_minus = sequence;
        this.$element = obj;
    }

    @Override // kotlin.sequences.Sequence
    @d
    public Iterator<T> iterator() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        return SequencesKt___SequencesKt.filter(this.$this_minus, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1$iterator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2((SequencesKt___SequencesKt$minus$1$iterator$1<T>) obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(T t) {
                if (booleanRef.element || !Intrinsics.areEqual(t, SequencesKt___SequencesKt$minus$1.this.$element)) {
                    return true;
                }
                booleanRef.element = true;
                return false;
            }
        }).iterator();
    }
}
