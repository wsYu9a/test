package kotlin.time;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/time/TimeMark;", "", "Lkotlin/time/Duration;", "elapsedNow", "()D", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "minus-LRDsOJo", "minus", "", "hasPassedNow", "()Z", "hasNotPassedNow", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalTime
/* loaded from: classes5.dex */
public abstract class TimeMark {
    public abstract double elapsedNow();

    public final boolean hasNotPassedNow() {
        return Duration.m1069isNegativeimpl(elapsedNow());
    }

    public final boolean hasPassedNow() {
        return !Duration.m1069isNegativeimpl(elapsedNow());
    }

    @d
    /* renamed from: minus-LRDsOJo */
    public TimeMark m1096minusLRDsOJo(double duration) {
        return mo1045plusLRDsOJo(Duration.m1089unaryMinusimpl(duration));
    }

    @d
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo1045plusLRDsOJo(double duration) {
        return new AdjustedTimeMark(this, duration, null);
    }
}
