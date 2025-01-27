package okio;

import com.martian.mibook.application.MiConfigSingleton;
import f.b.a.d;
import f.b.a.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\b\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\t\b\u0016¢\u0006\u0004\b \u0010\u000fB1\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017¨\u0006#"}, d2 = {"Lokio/Segment;", "", "sharedCopy", "()Lokio/Segment;", "unsharedCopy", "pop", "segment", "push", "(Lokio/Segment;)Lokio/Segment;", "", "byteCount", "split", "(I)Lokio/Segment;", "", "compact", "()V", "sink", "writeTo", "(Lokio/Segment;I)V", "", "shared", "Z", "prev", "Lokio/Segment;", "pos", "I", "owner", "", MiConfigSingleton.t0, "[B", "limit", "next", "<init>", "([BIIZZ)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class Segment {
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @d
    @JvmField
    public final byte[] data;

    @JvmField
    public int limit;

    @e
    @JvmField
    public Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @e
    @JvmField
    public Segment prev;

    @JvmField
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i2 = 0;
        if (!(segment != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        if (segment.owner) {
            int i3 = this.limit - this.pos;
            Segment segment2 = this.prev;
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            int i4 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            if (segment3 == null) {
                Intrinsics.throwNpe();
            }
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                if (segment4 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = segment4.pos;
            }
            if (i3 > i4 + i2) {
                return;
            }
            Segment segment5 = this.prev;
            if (segment5 == null) {
                Intrinsics.throwNpe();
            }
            writeTo(segment5, i3);
            pop();
            SegmentPool.INSTANCE.recycle(this);
        }
    }

    @e
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        segment2.next = this.next;
        Segment segment3 = this.next;
        if (segment3 == null) {
            Intrinsics.throwNpe();
        }
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @d
    public final Segment push(@d Segment segment) {
        Intrinsics.checkParameterIsNotNull(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @d
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @d
    public final Segment split(int byteCount) {
        Segment take;
        if (!(byteCount > 0 && byteCount <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (byteCount >= 1024) {
            take = sharedCopy();
        } else {
            take = SegmentPool.INSTANCE.take();
            byte[] bArr = this.data;
            byte[] bArr2 = take.data;
            int i2 = this.pos;
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr2, 0, i2, i2 + byteCount, 2, (Object) null);
        }
        take.limit = take.pos + byteCount;
        this.pos += byteCount;
        Segment segment = this.prev;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        segment.push(take);
        return take;
    }

    @d
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@d Segment sink, int byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = sink.limit;
        if (i2 + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i3 = sink.pos;
            if ((i2 + byteCount) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i4 = sink.limit;
        int i5 = this.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr3, i4, i5, i5 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public Segment(@d byte[] data, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.data = data;
        this.pos = i2;
        this.limit = i3;
        this.shared = z;
        this.owner = z2;
    }
}
