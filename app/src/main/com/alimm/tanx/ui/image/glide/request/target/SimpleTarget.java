package com.alimm.tanx.ui.image.glide.request.target;

import com.alimm.tanx.ui.image.glide.util.Util;
import ok.a;

/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder a10 = a.a("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        a10.append(this.width);
        a10.append(" and height: ");
        a10.append(this.height);
        a10.append(", either provide dimensions in the constructor");
        a10.append(" or call override()");
        throw new IllegalArgumentException(a10.toString());
    }

    public SimpleTarget(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }
}
