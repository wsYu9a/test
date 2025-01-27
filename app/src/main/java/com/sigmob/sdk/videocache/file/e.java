package com.sigmob.sdk.videocache.file;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public abstract class e implements com.sigmob.sdk.videocache.file.a {

    /* renamed from: a */
    public final ExecutorService f20596a = Executors.newSingleThreadExecutor();

    public class a implements Callable<Void> {

        /* renamed from: a */
        public final File f20597a;

        public a(File file) {
            this.f20597a = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            e.this.b(this.f20597a);
            return null;
        }
    }

    public abstract boolean a(File file, long j10, int i10);

    public final void b(File file) throws IOException {
        d.e(file);
        b(d.a(file.getParentFile()));
    }

    public final long a(List<File> list) {
        Iterator<File> it = list.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().length();
        }
        return j10;
    }

    public final void b(List<File> list) {
        long a10 = a(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, a10, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    a10 -= length;
                    SigmobLog.i("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    SigmobLog.e("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.file.a
    public void a(File file) throws IOException {
        this.f20596a.submit(new a(file));
    }
}
