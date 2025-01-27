package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class r {
    private static final Object aik = new Object();
    private static final Object aim = new Object();
    private w ail;
    private volatile v ain;

    public static final class a {
        private static final r aio = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwad.framework.filedownloader.f.c.aB(context.getApplicationContext());
        com.kwad.framework.filedownloader.download.b.ww().a(bVar);
    }

    public static void aA(Context context) {
        com.kwad.framework.filedownloader.f.c.aB(context.getApplicationContext());
    }

    public static com.kwad.framework.filedownloader.a bg(String str) {
        return new c(str);
    }

    private int bh(int i10) {
        List<a.InterfaceC0462a> bc2 = h.vJ().bc(i10);
        if (bc2.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i10));
            return 0;
        }
        Iterator<a.InterfaceC0462a> it = bc2.iterator();
        while (it.hasNext()) {
            it.next().vl().pause();
        }
        return bc2.size();
    }

    public static r wc() {
        return a.aio;
    }

    public static boolean we() {
        return n.vU().isConnected();
    }

    public final boolean q(int i10, String str) {
        bh(i10);
        if (!n.vU().bg(i10)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwad.framework.filedownloader.f.f.bx(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    public final void wd() {
        if (we()) {
            return;
        }
        n.vU().az(com.kwad.framework.filedownloader.f.c.xT());
    }

    public final w wf() {
        if (this.ail == null) {
            synchronized (aik) {
                try {
                    if (this.ail == null) {
                        this.ail = new ab();
                    }
                } finally {
                }
            }
        }
        return this.ail;
    }

    public final v wg() {
        if (this.ain == null) {
            synchronized (aim) {
                try {
                    if (this.ain == null) {
                        this.ain = new z();
                        a((e) this.ain);
                    }
                } finally {
                }
            }
        }
        return this.ain;
    }

    private static void a(e eVar) {
        f.vH().a("event.service.connect.changed", eVar);
    }
}
