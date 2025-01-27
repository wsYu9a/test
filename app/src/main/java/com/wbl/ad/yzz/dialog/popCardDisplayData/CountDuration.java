package com.wbl.ad.yzz.dialog.popCardDisplayData;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/wbl/ad/yzz/dialog/popCardDisplayData/CountDuration;", "Ljava/io/Serializable;", "", "count", "", "match", "(I)Z", "countType", "I", "getCountType", "()I", "setCountType", "(I)V", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "getCount", "setCount", "<init>", "(IJ)V", "(IJI)V", "Companion", "a", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class CountDuration implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public static final int f31954a = 0;

    /* renamed from: b */
    public static final int f31955b = 1;
    private int count;
    private int countType;
    private long duration;

    /* renamed from: com.wbl.ad.yzz.dialog.popCardDisplayData.CountDuration$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14601, this, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CountDuration(int i2, long j2) {
        this(i2, j2, f31954a);
    }

    public final int getCount() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14598, this, null);
    }

    public final int getCountType() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14597, this, null);
    }

    public final long getDuration() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-14600, this, null);
    }

    public final boolean match(int count) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14599, this, Integer.valueOf(count));
    }

    public final void setCount(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14594, this, Integer.valueOf(i2));
    }

    public final void setCountType(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14593, this, Integer.valueOf(i2));
    }

    public final void setDuration(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14596, this, Long.valueOf(j2));
    }

    public CountDuration(int i2, long j2, int i3) {
        this.countType = f31954a;
        this.count = i2;
        this.duration = j2;
        this.countType = i3;
    }
}
