package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService aGT = GlobalThreadPools.Hi();

    public class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ew */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    private void A(List<File> list) {
        long B = B(list);
        list.size();
        for (File file : list) {
            if (!aD(B)) {
                long length = file.length();
                if (file.delete()) {
                    B -= length;
                } else {
                    com.kwad.sdk.core.d.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long B(List<File> list) {
        Iterator<File> it = list.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().length();
        }
        return j10;
    }

    public void z(File file) {
        d.w(file);
        A(d.v(file.getParentFile()));
    }

    public abstract boolean aD(long j10);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aGT.submit(new a(file));
    }
}
