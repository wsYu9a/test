package com.opos.videocache.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public abstract class d implements com.opos.videocache.a.a {

    /* renamed from: a */
    private final ExecutorService f23788a = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {

        /* renamed from: b */
        private final File f23790b;

        public a(File file) {
            this.f23790b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            d.this.b(this.f23790b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b2, size)) {
                long length = file.length();
                if (file.delete()) {
                    b2 -= length;
                    com.opos.cmn.an.f.a.a("LruDiskUsage", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size += -1;
                } else {
                    com.opos.cmn.an.f.a.d("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 += it.next().length();
        }
        return j2;
    }

    public void b(File file) {
        h.c(file);
        a(h.b(file.getParentFile()));
    }

    @Override // com.opos.videocache.a.a
    public void a(File file) {
        this.f23788a.submit(new a(file));
    }

    protected abstract boolean a(File file, long j2, int i2);
}
