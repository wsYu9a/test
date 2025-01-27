package com.ss.android.j;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class j implements zx {

    /* renamed from: j */
    private final RandomAccessFile f24405j;

    public j(File file) throws FileNotFoundException {
        this.f24405j = new RandomAccessFile(file, t.k);
    }

    @Override // com.ss.android.j.zx
    public long j() throws IOException {
        return this.f24405j.length();
    }

    @Override // com.ss.android.j.zx
    public void zx() throws IOException {
        this.f24405j.close();
    }

    @Override // com.ss.android.j.zx
    public int j(byte[] bArr, int i2, int i3) throws IOException {
        return this.f24405j.read(bArr, i2, i3);
    }

    @Override // com.ss.android.j.zx
    public void j(long j2, long j3) throws IOException {
        this.f24405j.seek(j2);
    }
}
