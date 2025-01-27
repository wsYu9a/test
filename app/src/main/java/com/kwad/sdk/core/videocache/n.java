package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.av;
import java.io.File;

/* loaded from: classes2.dex */
public final class n {
    static File aZ(Context context) {
        return new File(av.cA(context), "video-cache");
    }
}
