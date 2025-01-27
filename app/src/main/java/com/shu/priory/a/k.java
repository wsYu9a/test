package com.shu.priory.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
final class k extends a {
    public k(f fVar, File file) {
        super(fVar, file);
    }

    private RandomAccessFile a(File file) {
        try {
            return new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e10) {
            throw new RuntimeException(e10);
        }
    }

    private void c() throws IOException {
        RandomAccessFile a10 = a(this.f16792b);
        a10.seek(0L);
        a10.write(new l(this.f16791a.b(), this.f16792b.length()).a());
        a10.close();
    }

    @Override // com.shu.priory.a.a, com.shu.priory.a.h
    public void b() {
        try {
            super.b();
            c();
        } catch (IOException e10) {
            throw new RuntimeException("Error in applying wav header", e10);
        }
    }
}
