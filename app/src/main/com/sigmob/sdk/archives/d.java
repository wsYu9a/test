package com.sigmob.sdk.archives;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    public static final String f17511a = "ar";

    /* renamed from: b */
    public static final String f17512b = "cpio";

    /* renamed from: c */
    public static final String f17513c = "dump";

    /* renamed from: d */
    public static final String f17514d = "jar";

    /* renamed from: e */
    public static final String f17515e = "tar";

    /* renamed from: f */
    public static final String f17516f = "zip";

    public c a(InputStream inputStream) throws b {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] bArr = new byte[12];
        inputStream.mark(12);
        try {
            inputStream.read(bArr);
            inputStream.reset();
            inputStream.mark(32);
            inputStream.read(new byte[32]);
            inputStream.reset();
            byte[] bArr2 = new byte[512];
            inputStream.mark(512);
            int read = inputStream.read(bArr2);
            inputStream.reset();
            if (com.sigmob.sdk.archives.tar.b.a(bArr2, read)) {
                return new com.sigmob.sdk.archives.tar.b(inputStream);
            }
            new com.sigmob.sdk.archives.tar.b(new ByteArrayInputStream(bArr2)).c();
            return new com.sigmob.sdk.archives.tar.b(inputStream);
        } catch (IOException e10) {
            throw new b("Could not use reset and mark operations.", e10);
        }
    }

    public c a(String str, InputStream inputStream) throws b {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if (f17515e.equalsIgnoreCase(str)) {
            return new com.sigmob.sdk.archives.tar.b(inputStream);
        }
        throw new b("Archiver: " + str + " not found.");
    }
}
