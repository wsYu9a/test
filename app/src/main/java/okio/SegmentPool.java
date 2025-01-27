package okio;

import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lokio/SegmentPool;", "", "Lokio/Segment;", "take", "()Lokio/Segment;", "segment", "", "recycle", "(Lokio/Segment;)V", "", "byteCount", "J", "getByteCount", "()J", "setByteCount", "(J)V", "MAX_SIZE", "next", "Lokio/Segment;", "getNext", "setNext", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SegmentPool {
    public static final SegmentPool INSTANCE = new SegmentPool();
    public static final long MAX_SIZE = 65536;
    private static long byteCount;

    @e
    private static Segment next;

    private SegmentPool() {
    }

    public final long getByteCount() {
        return byteCount;
    }

    @e
    public final Segment getNext() {
        return next;
    }

    public final void recycle(@d Segment segment) {
        Intrinsics.checkParameterIsNotNull(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared) {
            return;
        }
        synchronized (this) {
            long j2 = byteCount;
            long j3 = 8192;
            if (j2 + j3 > 65536) {
                return;
            }
            byteCount = j2 + j3;
            segment.next = next;
            segment.limit = 0;
            segment.pos = 0;
            next = segment;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setByteCount(long j2) {
        byteCount = j2;
    }

    public final void setNext(@e Segment segment) {
        next = segment;
    }

    @d
    public final Segment take() {
        synchronized (this) {
            Segment segment = next;
            if (segment == null) {
                return new Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= 8192;
            return segment;
        }
    }
}
