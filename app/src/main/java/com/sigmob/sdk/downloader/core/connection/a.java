package com.sigmob.sdk.downloader.core.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface a {

    /* renamed from: a */
    public static final int f19110a = 0;

    /* renamed from: com.sigmob.sdk.downloader.core.connection.a$a */
    public interface InterfaceC0584a {
        String b();

        InputStream c() throws IOException;

        String c(String str);

        Map<String, List<String>> e();

        int f() throws IOException;
    }

    public interface b {
        a a(String str) throws IOException;
    }

    void a();

    void a(String str, String str2);

    boolean a(String str) throws ProtocolException;

    String b(String str);

    Map<String, List<String>> d();

    InterfaceC0584a execute() throws IOException;
}
