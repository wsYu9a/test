package kotlin;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.b.a.e;
import kotlin.internal.InlineOnly;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", TTDownloadField.TT_HASHCODE, "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class HashCodeKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int hashCode(@e Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
