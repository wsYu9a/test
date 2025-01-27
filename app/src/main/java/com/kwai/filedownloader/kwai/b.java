package com.kwai.filedownloader.kwai;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface b {
    Map<String, List<String>> V();

    Map<String, List<String>> W();

    void X();

    void addHeader(String str, String str2);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    String o(String str);
}
