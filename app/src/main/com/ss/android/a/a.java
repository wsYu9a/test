package com.ss.android.a;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a */
    private final RandomAccessFile f20932a;

    public a(File file) throws FileNotFoundException {
        this.f20932a = new RandomAccessFile(file, t.f11211k);
    }

    @Override // com.ss.android.a.b
    public long a() throws IOException {
        return this.f20932a.length();
    }

    @Override // com.ss.android.a.b
    public void b() throws IOException {
        this.f20932a.close();
    }

    @Override // com.ss.android.a.b
    public int a(byte[] bArr, int i10, int i11) throws IOException {
        return this.f20932a.read(bArr, i10, i11);
    }

    @Override // com.ss.android.a.b
    public void a(long j10, long j11) throws IOException {
        this.f20932a.seek(j10);
    }
}
