package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.sequences.Sequence;

@SinceKotlin(version = "1.1")
@RestrictsSuspension
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\rJ!\u0010\t\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0010\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/experimental/SequenceBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", Downloads.RequestHeaders.COLUMN_VALUE, "", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "", "iterator", "yieldAll", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "", "elements", "(Ljava/lang/Iterable;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public abstract class SequenceBuilder<T> {
    @e
    public abstract Object yield(T t, @d Continuation<? super Unit> continuation);

    @e
    public final Object yieldAll(@d Iterable<? extends T> iterable, @d Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return Unit.INSTANCE;
        }
        Object yieldAll = yieldAll(iterable.iterator(), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        return yieldAll == coroutine_suspended ? yieldAll : Unit.INSTANCE;
    }

    @e
    public abstract Object yieldAll(@d Iterator<? extends T> it, @d Continuation<? super Unit> continuation);

    @e
    public final Object yieldAll(@d Sequence<? extends T> sequence, @d Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object yieldAll = yieldAll(sequence.iterator(), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        return yieldAll == coroutine_suspended ? yieldAll : Unit.INSTANCE;
    }
}
