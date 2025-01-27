package kotlin.ranges;

import bi.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "(DD)V", "_endExclusive", "_start", "getEndExclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    public OpenEndDoubleRange(double d10, double d11) {
        this._start = d10;
        this._endExclusive = d11;
    }

    private final boolean lessThanOrEquals(double a10, double b10) {
        return a10 <= b10;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Double d10) {
        return contains(d10.doubleValue());
    }

    public boolean equals(@l Object r62) {
        if (r62 instanceof OpenEndDoubleRange) {
            if (!isEmpty() || !((OpenEndDoubleRange) r62).isEmpty()) {
                OpenEndDoubleRange openEndDoubleRange = (OpenEndDoubleRange) r62;
                if (this._start != openEndDoubleRange._start || this._endExclusive != openEndDoubleRange._endExclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a.a(this._start) * 31) + a.a(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    @k
    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }

    public boolean contains(double value) {
        return value >= this._start && value < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    @k
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    @k
    public Double getStart() {
        return Double.valueOf(this._start);
    }
}
