package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import f.b.a.d;
import f.b.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a2\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004¢\u0006\u0004\b\u0014\u0010\u0010\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0010\u001aE\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001aG\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c0\u001b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b0\u0004¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u001f\u0010\u0010\u001a-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\"\u0010\u0006\u001a?\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020 2\b\u0010#\u001a\u0004\u0018\u00018\u00002\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0007¢\u0006\u0004\b\"\u0010$\u001aC\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020 2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018¢\u0006\u0004\b\"\u0010&¨\u0006'"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "", "iterator", "Lkotlin/sequences/Sequence;", "Sequence", "(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;", "", "elements", "sequenceOf", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "()Lkotlin/sequences/Sequence;", "orEmpty", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "defaultValue", "ifEmpty", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "flatten", "", "flattenSequenceOfIterable", "R", "Lkotlin/Function1;", "flatten$SequencesKt__SequencesKt", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", TKDownloadReason.KSAD_TK_UNZIP, "(Lkotlin/sequences/Sequence;)Lkotlin/Pair;", "constrainOnce", "", "nextFunction", "generateSequence", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> function0) {
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$Sequence$1
            @Override // kotlin.sequences.Sequence
            @d
            public Iterator<T> iterator() {
                return (Iterator) Function0.this.invoke();
            }
        };
    }

    @d
    public static final <T> Sequence<T> asSequence(@d final Iterator<? extends T> asSequence) {
        Sequence<T> constrainOnce;
        Intrinsics.checkParameterIsNotNull(asSequence, "$this$asSequence");
        constrainOnce = constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @d
            public Iterator<T> iterator() {
                return asSequence;
            }
        });
        return constrainOnce;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static <T> Sequence<T> constrainOnce(@d Sequence<? extends T> constrainOnce) {
        Intrinsics.checkParameterIsNotNull(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof ConstrainedOnceSequence ? constrainOnce : new ConstrainedOnceSequence(constrainOnce);
    }

    @d
    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    @d
    public static final <T> Sequence<T> flatten(@d Sequence<? extends Sequence<? extends T>> flatten) {
        Intrinsics.checkParameterIsNotNull(flatten, "$this$flatten");
        return flatten$SequencesKt__SequencesKt(flatten, new Function1<Sequence<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // kotlin.jvm.functions.Function1
            @d
            public final Iterator<T> invoke(@d Sequence<? extends T> it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.iterator();
            }
        });
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(@d Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return sequence instanceof TransformingSequence ? ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1) : new FlatteningSequence(sequence, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t) {
                return t;
            }
        }, function1);
    }

    @d
    @JvmName(name = "flattenSequenceOfIterable")
    public static final <T> Sequence<T> flattenSequenceOfIterable(@d Sequence<? extends Iterable<? extends T>> flatten) {
        Intrinsics.checkParameterIsNotNull(flatten, "$this$flatten");
        return flatten$SequencesKt__SequencesKt(flatten, new Function1<Iterable<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$2
            @Override // kotlin.jvm.functions.Function1
            @d
            public final Iterator<T> invoke(@d Iterable<? extends T> it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.iterator();
            }
        });
    }

    @d
    public static final <T> Sequence<T> generateSequence(@d final Function0<? extends T> nextFunction) {
        Sequence<T> constrainOnce;
        Intrinsics.checkParameterIsNotNull(nextFunction, "nextFunction");
        constrainOnce = constrainOnce(new GeneratorSequence(nextFunction, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @e
            public final T invoke(@d T it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return (T) Function0.this.invoke();
            }
        }));
        return constrainOnce;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <T> Sequence<T> ifEmpty(@d Sequence<? extends T> ifEmpty, @d Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkParameterIsNotNull(ifEmpty, "$this$ifEmpty");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(ifEmpty, defaultValue, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(@e Sequence<? extends T> sequence) {
        return sequence != 0 ? sequence : emptySequence();
    }

    @d
    public static final <T> Sequence<T> sequenceOf(@d T... elements) {
        Sequence<T> asSequence;
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        if (elements.length == 0) {
            return emptySequence();
        }
        asSequence = ArraysKt___ArraysKt.asSequence(elements);
        return asSequence;
    }

    @d
    public static final <T, R> Pair<List<T>, List<R>> unzip(@d Sequence<? extends Pair<? extends T, ? extends R>> unzip) {
        Intrinsics.checkParameterIsNotNull(unzip, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : unzip) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    @d
    @LowPriorityInOverloadResolution
    public static final <T> Sequence<T> generateSequence(@e final T t, @d Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkParameterIsNotNull(nextFunction, "nextFunction");
        return t == null ? EmptySequence.INSTANCE : new GeneratorSequence(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @e
            public final T invoke() {
                return (T) t;
            }
        }, nextFunction);
    }

    @d
    public static <T> Sequence<T> generateSequence(@d Function0<? extends T> seedFunction, @d Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkParameterIsNotNull(seedFunction, "seedFunction");
        Intrinsics.checkParameterIsNotNull(nextFunction, "nextFunction");
        return new GeneratorSequence(seedFunction, nextFunction);
    }
}
