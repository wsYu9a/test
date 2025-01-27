package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0006R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/Duration;", "duration", "", "overflow-LRDsOJo", "(D)V", "overflow", "", "read", "()J", "plusAssign-LRDsOJo", "plusAssign", "reading", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalTime
/* loaded from: classes5.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo */
    private final void m1094overflowLRDsOJo(double duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m1086toStringimpl(duration) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo */
    public final void m1095plusAssignLRDsOJo(double duration) {
        long j2;
        double m1080toDoubleimpl = Duration.m1080toDoubleimpl(duration, getUnit());
        long j3 = (long) m1080toDoubleimpl;
        if (j3 == Long.MIN_VALUE || j3 == Long.MAX_VALUE) {
            double d2 = this.reading;
            Double.isNaN(d2);
            double d3 = d2 + m1080toDoubleimpl;
            if (d3 > Long.MAX_VALUE || d3 < Long.MIN_VALUE) {
                m1094overflowLRDsOJo(duration);
            }
            j2 = (long) d3;
        } else {
            long j4 = this.reading;
            j2 = j4 + j3;
            if ((j3 ^ j4) >= 0 && (j4 ^ j2) < 0) {
                m1094overflowLRDsOJo(duration);
            }
        }
        this.reading = j2;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }
}
