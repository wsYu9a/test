package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface b {
    void addHeader(String str, String str2);

    String bh(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> wk();

    Map<String, List<String>> wl();

    void wm();
}
