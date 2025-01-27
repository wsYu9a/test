package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0005H\u0086\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\u0086\n¨\u0006\u0007"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "Landroidx/core/util/SizeFCompat;", "component2", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@k Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@k Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@k SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@k SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final float component1(@k SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.getWidth();
    }

    public static final float component2(@k SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.getHeight();
    }
}
