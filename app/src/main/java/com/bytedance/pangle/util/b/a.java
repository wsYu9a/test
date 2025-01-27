package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    final d f7832a;

    /* renamed from: b */
    final com.bytedance.pangle.util.b.a.b f7833b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f7832a = dVar;
    }

    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j10, long j11, String str) {
        g.a(randomAccessFile, randomAccessFile2, j10, j10 + j11, str);
    }
}
