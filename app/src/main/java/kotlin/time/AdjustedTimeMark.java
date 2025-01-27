package kotlin.time;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow", "()D", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "mark", "Lkotlin/time/TimeMark;", "getMark", "()Lkotlin/time/TimeMark;", "adjustment", "D", "getAdjustment", "<init>", "(Lkotlin/time/TimeMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalTime
/* loaded from: classes5.dex */
final class AdjustedTimeMark extends TimeMark {
    private final double adjustment;

    @d
    private final TimeMark mark;

    private AdjustedTimeMark(TimeMark timeMark, double d2) {
        this.mark = timeMark;
        this.adjustment = d2;
    }

    @Override // kotlin.time.TimeMark
    public double elapsedNow() {
        return Duration.m1071minusLRDsOJo(this.mark.elapsedNow(), this.adjustment);
    }

    public final double getAdjustment() {
        return this.adjustment;
    }

    @d
    public final TimeMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeMark
    @d
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo1045plusLRDsOJo(double duration) {
        return new AdjustedTimeMark(this.mark, Duration.m1072plusLRDsOJo(this.adjustment, duration), null);
    }

    public /* synthetic */ AdjustedTimeMark(TimeMark timeMark, double d2, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, d2);
    }
}
