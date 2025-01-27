package com.kwad.sdk.core.webview.a.b;

import com.baidu.mobads.sdk.internal.am;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    private static final List<String> aqd;

    static {
        ArrayList arrayList = new ArrayList();
        aqd = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add("image/png");
        arrayList.add("application/javascript");
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add(am.f5520d);
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    /* renamed from: do, reason: not valid java name */
    public static boolean m60do(String str) {
        return aqd.contains(str);
    }
}
