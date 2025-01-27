package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Deprecated(message = "changed in Okio 2.x")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", TypedValues.Custom.S_STRING, "", "beginIndex", "", "endIndex", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: okio.-DeprecatedUtf8 */
/* loaded from: classes4.dex */
public final class DeprecatedUtf8 {

    @k
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long size(@k String r42) {
        Intrinsics.checkNotNullParameter(r42, "string");
        return Utf8.size$default(r42, 0, 0, 3, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long size(@k String r22, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(r22, "string");
        return Utf8.size(r22, beginIndex, endIndex);
    }
}
