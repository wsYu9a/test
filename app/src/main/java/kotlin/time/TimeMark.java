package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import xi.k;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes4.dex */
public interface TimeMark {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(@k TimeMark timeMark) {
            return Duration.m1415isNegativeimpl(timeMark.mo1372elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(@k TimeMark timeMark) {
            return !Duration.m1415isNegativeimpl(timeMark.mo1372elapsedNowUwyO8pc());
        }

        @k
        /* renamed from: minus-LRDsOJo */
        public static TimeMark m1519minusLRDsOJo(@k TimeMark timeMark, long j10) {
            return timeMark.mo1375plusLRDsOJo(Duration.m1435unaryMinusUwyO8pc(j10));
        }

        @k
        /* renamed from: plus-LRDsOJo */
        public static TimeMark m1520plusLRDsOJo(@k TimeMark timeMark, long j10) {
            return new AdjustedTimeMark(timeMark, j10, null);
        }
    }

    /* renamed from: elapsedNow-UwyO8pc */
    long mo1372elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @k
    /* renamed from: minus-LRDsOJo */
    TimeMark mo1373minusLRDsOJo(long duration);

    @k
    /* renamed from: plus-LRDsOJo */
    TimeMark mo1375plusLRDsOJo(long duration);
}
