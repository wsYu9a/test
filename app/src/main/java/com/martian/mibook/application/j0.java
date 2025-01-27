package com.martian.mibook.application;

import android.os.AsyncTask;
import com.martian.mibook.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a */
    private List<com.martian.mibook.c.a> f11470a;

    /* renamed from: b */
    private List<com.martian.mibook.c.c> f11471b;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(ArrayList<FileInfo> list);
    }

    public void a(String path, final b fileScanListener, String[] filetype) {
        c();
        com.martian.mibook.c.c cVar = new com.martian.mibook.c.c(filetype, fileScanListener);
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, path, "");
        if (this.f11471b == null) {
            this.f11471b = new ArrayList();
        }
        this.f11471b.add(cVar);
    }

    public void b(String path, ArrayList<FileInfo> fileInfos, int scanDepth, String[] scanTypes, a fileScanListener) {
        d();
        com.martian.mibook.c.a aVar = new com.martian.mibook.c.a(fileInfos, scanTypes, scanDepth, fileScanListener);
        aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, path, "");
        if (this.f11470a == null) {
            this.f11470a = new ArrayList();
        }
        this.f11470a.add(aVar);
    }

    public void c() {
        List<com.martian.mibook.c.c> list = this.f11471b;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.martian.mibook.c.c> it = this.f11471b.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
            it.remove();
        }
    }

    public void d() {
        List<com.martian.mibook.c.a> list = this.f11470a;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.martian.mibook.c.a> it = this.f11470a.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
            it.remove();
        }
    }
}
