package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/time/TimedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "component1", "()Ljava/lang/Object;", "Lkotlin/time/Duration;", "component2", "()D", Downloads.RequestHeaders.COLUMN_VALUE, "duration", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "copy", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getValue", "D", "getDuration", "<init>", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalTime
/* loaded from: classes5.dex */
public final /* data */ class TimedValue<T> {
    private final double duration;
    private final T value;

    private TimedValue(T t, double d2) {
        this.value = t;
        this.duration = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default */
    public static /* synthetic */ TimedValue m1097copyRFiDyg4$default(TimedValue timedValue, Object obj, double d2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i2 & 2) != 0) {
            d2 = timedValue.duration;
        }
        return timedValue.m1098copyRFiDyg4(obj, d2);
    }

    public final T component1() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDuration() {
        return this.duration;
    }

    @d
    /* renamed from: copy-RFiDyg4 */
    public final TimedValue<T> m1098copyRFiDyg4(T r2, double duration) {
        return new TimedValue<>(r2, duration);
    }

    public boolean equals(@e Object r5) {
        if (this == r5) {
            return true;
        }
        if (!(r5 instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) r5;
        return Intrinsics.areEqual(this.value, timedValue.value) && Double.compare(this.duration, timedValue.duration) == 0;
    }

    public final double getDuration() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        int hashCode = t != null ? t.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.duration);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @d
    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + Duration.m1086toStringimpl(this.duration) + ")";
    }

    public /* synthetic */ TimedValue(Object obj, double d2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, d2);
    }
}
