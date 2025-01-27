package com.kwai.filedownloader.services;

import com.kwai.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class g implements y {
    private final com.kwai.filedownloader.a.a aJe;
    private final h aJf;

    g() {
        com.kwai.filedownloader.download.b HF = com.kwai.filedownloader.download.b.HF();
        this.aJe = HF.HH();
        this.aJf = new h(HF.HI());
    }

    private boolean dg(int i2) {
        return a(this.aJe.cI(i2));
    }

    public final void IT() {
        List<Integer> IW = this.aJf.IW();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "pause all tasks %d", Integer.valueOf(IW.size()));
        }
        Iterator<Integer> it = IW.iterator();
        while (it.hasNext()) {
            cB(it.next().intValue());
        }
    }

    public final void Il() {
        this.aJe.clear();
    }

    @Override // com.kwai.filedownloader.y
    public final boolean a(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean di = this.aJf.di(cVar.getId());
        if (com.kwai.filedownloader.c.d.dd(cVar.Gq())) {
            if (!di) {
                return false;
            }
        } else if (!di) {
            com.kwai.filedownloader.e.d.e(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.Gq()));
            return false;
        }
        return true;
    }

    public final boolean ao(String str, String str2) {
        return dg(com.kwai.filedownloader.e.f.aq(str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0181 A[Catch: all -> 0x01cc, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0031, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:19:0x006f, B:21:0x0075, B:23:0x0079, B:28:0x008a, B:29:0x0093, B:31:0x009c, B:33:0x00a0, B:38:0x00b3, B:40:0x00bc, B:41:0x00c5, B:43:0x00d4, B:45:0x00d8, B:47:0x00e9, B:51:0x00f7, B:53:0x00fe, B:55:0x0105, B:57:0x010b, B:59:0x0112, B:61:0x0118, B:63:0x011e, B:65:0x0138, B:66:0x013c, B:68:0x0142, B:72:0x0181, B:73:0x0186, B:76:0x0151, B:78:0x015b, B:80:0x0161, B:81:0x0167, B:82:0x00c1, B:84:0x008f), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(java.lang.String r19, java.lang.String r20, boolean r21, int r22, int r23, int r24, boolean r25, com.kwai.filedownloader.c.b r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwai.filedownloader.c.b, boolean):void");
    }

    public final boolean cB(int i2) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "request pause the task %d", Integer.valueOf(i2));
        }
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i2);
        if (cI == null) {
            return false;
        }
        cI.e((byte) -2);
        this.aJf.cancel(i2);
        return true;
    }

    public final byte cC(int i2) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i2);
        if (cI == null) {
            return (byte) 0;
        }
        return cI.Gq();
    }

    public final boolean cD(int i2) {
        if (i2 == 0) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        if (dg(i2)) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        this.aJe.cL(i2);
        this.aJe.cK(i2);
        return true;
    }

    public final synchronized boolean cV(int i2) {
        return this.aJf.cV(i2);
    }

    public final long cX(int i2) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i2);
        if (cI == null) {
            return 0L;
        }
        return cI.getTotal();
    }

    public final long dh(int i2) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i2);
        if (cI == null) {
            return 0L;
        }
        int ID = cI.ID();
        if (ID <= 1) {
            return cI.IB();
        }
        List<com.kwai.filedownloader.c.a> cJ = this.aJe.cJ(i2);
        if (cJ == null || cJ.size() != ID) {
            return 0L;
        }
        return com.kwai.filedownloader.c.a.H(cJ);
    }

    public final boolean isIdle() {
        return this.aJf.IV() <= 0;
    }

    @Override // com.kwai.filedownloader.y
    public final int r(String str, int i2) {
        return this.aJf.r(str, i2);
    }
}
