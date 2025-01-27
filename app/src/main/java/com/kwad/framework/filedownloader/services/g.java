package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class g implements y {
    private final h ali = new h(com.kwad.framework.filedownloader.download.b.ww().wz());

    private boolean bJ(int i10) {
        return a(xL().bl(i10));
    }

    private static com.kwad.framework.filedownloader.b.a xL() {
        return com.kwad.framework.filedownloader.download.b.ww().wy();
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean bL = this.ali.bL(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bG(cVar.vd())) {
            if (bL) {
                return true;
            }
        } else {
            if (bL) {
                return true;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.vd()));
        }
        return false;
    }

    public final synchronized void b(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        com.kwad.framework.filedownloader.d.c cVar;
        List<com.kwad.framework.filedownloader.d.a> list;
        boolean z13 = true;
        synchronized (this) {
            try {
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    com.kwad.framework.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z10));
                }
                int g10 = com.kwad.framework.filedownloader.f.f.g(str, str2, z10);
                com.kwad.framework.filedownloader.b.a xL = xL();
                com.kwad.framework.filedownloader.d.c bl = xL.bl(g10);
                if (z10 || bl != null) {
                    cVar = bl;
                    list = null;
                } else {
                    int g11 = com.kwad.framework.filedownloader.f.f.g(str, com.kwad.framework.filedownloader.f.f.bA(str2), true);
                    com.kwad.framework.filedownloader.d.c bl2 = xL.bl(g11);
                    if (bl2 == null || !str2.equals(bl2.getTargetFilePath())) {
                        list = null;
                    } else {
                        if (com.kwad.framework.filedownloader.f.d.alt) {
                            com.kwad.framework.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(g10), Integer.valueOf(g11));
                        }
                        list = xL.bm(g11);
                    }
                    cVar = bl2;
                }
                if (com.kwad.framework.filedownloader.f.c.a(g10, cVar, (y) this, true)) {
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(g10));
                    }
                    return;
                }
                String targetFilePath = cVar != null ? cVar.getTargetFilePath() : com.kwad.framework.filedownloader.f.f.a(str2, z10, (String) null);
                if (com.kwad.framework.filedownloader.f.c.a(g10, targetFilePath, z11, true)) {
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(g10));
                    }
                    return;
                }
                if (com.kwad.framework.filedownloader.f.c.a(g10, cVar != null ? cVar.xt() : 0L, cVar != null ? cVar.wL() : com.kwad.framework.filedownloader.f.f.bx(targetFilePath), targetFilePath, this)) {
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(g10), targetFilePath);
                        if (cVar != null) {
                            xL.bo(g10);
                            xL.bn(g10);
                        }
                    }
                    return;
                }
                if (cVar == null || !(cVar.vd() == -2 || cVar.vd() == -1 || cVar.vd() == 1 || cVar.vd() == 6 || cVar.vd() == 2)) {
                    if (cVar == null) {
                        cVar = new com.kwad.framework.filedownloader.d.c();
                    }
                    cVar.setUrl(str);
                    cVar.d(str2, z10);
                    cVar.setId(g10);
                    cVar.T(0L);
                    cVar.V(0L);
                    cVar.d((byte) 1);
                    cVar.bE(1);
                } else if (cVar.getId() != g10) {
                    xL.bo(cVar.getId());
                    xL.bn(cVar.getId());
                    cVar.setId(g10);
                    cVar.d(str2, z10);
                    if (list != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : list) {
                            aVar.setId(g10);
                            xL.a(aVar);
                        }
                    }
                } else if (TextUtils.equals(str, cVar.getUrl())) {
                    z13 = false;
                } else {
                    cVar.setUrl(str);
                }
                if (z13) {
                    xL.b(cVar);
                }
                this.ali.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i11)).b(Integer.valueOf(i10)).a(Boolean.valueOf(z11)).b(Boolean.valueOf(z12)).c(Integer.valueOf(i12)).wM());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final long bA(int i10) {
        com.kwad.framework.filedownloader.d.c bl = xL().bl(i10);
        if (bl == null) {
            return 0L;
        }
        return bl.getTotal();
    }

    public final long bK(int i10) {
        com.kwad.framework.filedownloader.b.a xL = xL();
        com.kwad.framework.filedownloader.d.c bl = xL.bl(i10);
        if (bl == null) {
            return 0L;
        }
        int xw = bl.xw();
        if (xw <= 1) {
            return bl.xt();
        }
        List<com.kwad.framework.filedownloader.d.a> bm = xL.bm(i10);
        if (bm == null || bm.size() != xw) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.r(bm);
    }

    public final boolean be(int i10) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i10));
        }
        com.kwad.framework.filedownloader.d.c bl = xL().bl(i10);
        if (bl == null) {
            return false;
        }
        bl.d((byte) -2);
        this.ali.cancel(i10);
        return true;
    }

    public final byte bf(int i10) {
        com.kwad.framework.filedownloader.d.c bl = xL().bl(i10);
        if (bl == null) {
            return (byte) 0;
        }
        return bl.vd();
    }

    public final boolean bg(int i10) {
        if (i10 == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i10));
            return false;
        }
        if (bJ(i10)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i10));
            return false;
        }
        com.kwad.framework.filedownloader.b.a xL = xL();
        xL.bo(i10);
        xL.bn(i10);
        return true;
    }

    public final synchronized boolean by(int i10) {
        return this.ali.by(i10);
    }

    public final boolean isIdle() {
        return this.ali.xO() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int o(String str, int i10) {
        return this.ali.o(str, i10);
    }

    public final void xM() {
        List<Integer> xP = this.ali.xP();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(xP.size()));
        }
        Iterator<Integer> it = xP.iterator();
        while (it.hasNext()) {
            be(it.next().intValue());
        }
    }

    public final void xd() {
        xL().clear();
    }

    public final boolean y(String str, String str2) {
        return bJ(com.kwad.framework.filedownloader.f.f.A(str, str2));
    }
}
