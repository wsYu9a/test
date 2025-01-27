package com.kwad.sdk.core.webview.b.c;

import androidx.media3.common.MimeTypes;
import com.baidu.mobads.sdk.internal.am;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class c {
    private static final List<String> aIU;

    static {
        ArrayList arrayList = new ArrayList();
        aIU = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add(MimeTypes.IMAGE_JPEG);
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add(MimeTypes.IMAGE_PNG);
        arrayList.add("application/javascript");
        arrayList.add(MimeTypes.VIDEO_MP4);
        arrayList.add(MimeTypes.AUDIO_MPEG);
        arrayList.add(am.f6738d);
        arrayList.add(MimeTypes.IMAGE_WEBP);
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean fj(String str) {
        return aIU.contains(str);
    }
}
