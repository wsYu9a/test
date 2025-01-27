package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.sigmob.sdk.downloader.core.file.a$a */
    public interface InterfaceC0589a {
        a a(Context context, Uri uri, int i10) throws FileNotFoundException;

        a a(Context context, File file, int i10) throws FileNotFoundException;

        boolean a();
    }

    void a() throws IOException;

    void a(long j10) throws IOException;

    void b(long j10) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;
}
