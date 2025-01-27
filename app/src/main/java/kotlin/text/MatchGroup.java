package kotlin.text;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lkotlin/text/MatchGroup;", "", "", "component1", "()Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", Downloads.RequestHeaders.COLUMN_VALUE, "range", "copy", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lkotlin/text/MatchGroup;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/IntRange;", "getRange", "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class MatchGroup {

    @d
    private final IntRange range;

    @d
    private final String value;

    public MatchGroup(@d String value, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(range, "range");
        this.value = value;
        this.range = range;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i2 & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    @d
    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @d
    /* renamed from: component2, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    @d
    public final MatchGroup copy(@d String r2, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(r2, "value");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return new MatchGroup(r2, range);
    }

    public boolean equals(@e Object r3) {
        if (this == r3) {
            return true;
        }
        if (!(r3 instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) r3;
        return Intrinsics.areEqual(this.value, matchGroup.value) && Intrinsics.areEqual(this.range, matchGroup.range);
    }

    @d
    public final IntRange getRange() {
        return this.range;
    }

    @d
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.range;
        return hashCode + (intRange != null ? intRange.hashCode() : 0);
    }

    @d
    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ")";
    }
}
