package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.bb;
import java.io.File;

/* loaded from: classes3.dex */
public final class o {
    public static File bB(Context context) {
        return new File(bb.dd(context), "video-cache");
    }
}
