package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    final d f6309a;

    /* renamed from: b */
    final com.bytedance.pangle.util.b.a.b f6310b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f6309a = dVar;
    }

    static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j2, long j3, String str) {
        g.a(randomAccessFile, randomAccessFile2, j2, j2 + j3, str);
    }
}
