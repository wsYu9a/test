package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class d implements a.c, x, x.a, x.b {
    private long ahA;
    private long ahB;
    private int ahC;
    private boolean ahD;
    private boolean ahE;
    private String ahF;
    private final Object ahp;
    private t aht;
    private final a ahu;
    private volatile long ahw;
    private final s.b ahy;
    private final s.a ahz;
    private volatile byte ahv = 0;
    private Throwable ahx = null;
    private boolean ahG = false;

    public interface a {
        void setFileName(String str);

        ArrayList<Object> vA();

        com.kwad.framework.filedownloader.d.b vy();

        a.InterfaceC0462a vz();
    }

    public d(a aVar, Object obj) {
        this.ahp = obj;
        this.ahu = aVar;
        b bVar = new b();
        this.ahy = bVar;
        this.ahz = bVar;
        this.aht = new k(aVar.vz(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a vl = this.ahu.vz().vl();
        byte vd2 = messageSnapshot.vd();
        b(vd2);
        this.ahD = messageSnapshot.vj();
        if (vd2 == -4) {
            this.ahy.reset();
            int ba2 = h.vJ().ba(vl.getId());
            if (ba2 + ((ba2 > 1 || !vl.uZ()) ? 0 : h.vJ().ba(com.kwad.framework.filedownloader.f.f.A(vl.getUrl(), vl.getTargetFilePath()))) <= 1) {
                byte bf2 = n.vU().bf(vl.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(vl.getId()), Integer.valueOf(bf2));
                if (com.kwad.framework.filedownloader.d.d.bH(bf2)) {
                    b((byte) 1);
                    this.ahB = messageSnapshot.xi();
                    long xk2 = messageSnapshot.xk();
                    this.ahA = xk2;
                    this.ahy.start(xk2);
                    this.aht.f(((MessageSnapshot.a) messageSnapshot).xm());
                    return;
                }
            }
            h.vJ().a(this.ahu.vz(), messageSnapshot);
            return;
        }
        if (vd2 == -3) {
            this.ahG = messageSnapshot.xj();
            this.ahA = messageSnapshot.xi();
            this.ahB = messageSnapshot.xi();
            h.vJ().a(this.ahu.vz(), messageSnapshot);
            return;
        }
        if (vd2 == -1) {
            this.ahx = messageSnapshot.xl();
            this.ahA = messageSnapshot.xk();
            h.vJ().a(this.ahu.vz(), messageSnapshot);
            return;
        }
        if (vd2 == 1) {
            this.ahA = messageSnapshot.xk();
            this.ahB = messageSnapshot.xi();
            this.aht.f(messageSnapshot);
            return;
        }
        if (vd2 == 2) {
            this.ahB = messageSnapshot.xi();
            this.ahE = messageSnapshot.wY();
            this.ahF = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (vl.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", vl.getFilename(), fileName);
                }
                this.ahu.setFileName(fileName);
            }
            this.ahy.start(this.ahA);
            this.aht.h(messageSnapshot);
            return;
        }
        if (vd2 == 3) {
            this.ahA = messageSnapshot.xk();
            this.ahy.O(messageSnapshot.xk());
            this.aht.i(messageSnapshot);
        } else if (vd2 != 5) {
            if (vd2 != 6) {
                return;
            }
            this.aht.g(messageSnapshot);
        } else {
            this.ahA = messageSnapshot.xk();
            this.ahx = messageSnapshot.xl();
            this.ahC = messageSnapshot.vh();
            this.ahy.reset();
            this.aht.k(messageSnapshot);
        }
    }

    private int getId() {
        return this.ahu.vz().vl().getId();
    }

    private void prepare() {
        File file;
        com.kwad.framework.filedownloader.a vl = this.ahu.vz().vl();
        if (vl.getPath() == null) {
            vl.be(com.kwad.framework.filedownloader.f.f.bv(vl.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", vl.getPath());
            }
        }
        if (vl.uZ()) {
            file = new File(vl.getPath());
        } else {
            String bA = com.kwad.framework.filedownloader.f.f.bA(vl.getPath());
            if (bA == null) {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.b("the provided mPath[%s] is invalid, can't find its directory", vl.getPath()));
            }
            file = new File(bA);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.d.d.t(vd(), messageSnapshot.vd())) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.ahv), Byte.valueOf(vd()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte vd2 = vd();
        byte vd3 = messageSnapshot.vd();
        if (-2 == vd2 && com.kwad.framework.filedownloader.d.d.bH(vd3)) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (com.kwad.framework.filedownloader.d.d.u(vd2, vd3)) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.ahv), Byte.valueOf(vd()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.ahu.vz().vl())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.ahu.vz().vl().uZ() || messageSnapshot.vd() != -4 || vd() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.ahv));
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot g(Throwable th2) {
        b((byte) -1);
        this.ahx = th2;
        return com.kwad.framework.filedownloader.message.f.a(getId(), vD(), th2);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.ahz.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.ahw;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.ahB;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(vd()));
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bG(vd())) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(vd()), Integer.valueOf(this.ahu.vz().vl().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0462a vz = this.ahu.vz();
        com.kwad.framework.filedownloader.a vl = vz.vl();
        q.wa().b(this);
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.wc();
        if (r.we()) {
            n.vU().be(vl.getId());
        } else if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(vl.getId()));
        }
        h.vJ().b(vz);
        h.vJ().a(vz, com.kwad.framework.filedownloader.message.f.e(vl));
        r.wc().wg().e(vz);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.ahx = null;
        this.ahF = null;
        this.ahE = false;
        this.ahC = 0;
        this.ahG = false;
        this.ahD = false;
        this.ahA = 0L;
        this.ahB = 0L;
        this.ahy.reset();
        if (com.kwad.framework.filedownloader.d.d.bG(this.ahv)) {
            this.aht.vS();
            this.aht = new k(this.ahu.vz(), this);
        } else {
            this.aht.b(this.ahu.vz(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.ahv != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.ahv));
            return;
        }
        a.InterfaceC0462a vz = this.ahu.vz();
        com.kwad.framework.filedownloader.a vl = vz.vl();
        v wg2 = r.wc().wg();
        try {
            if (wg2.f(vz)) {
                return;
            }
            synchronized (this.ahp) {
                try {
                    if (this.ahv != 10) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.ahv));
                        return;
                    }
                    b((byte) 11);
                    h.vJ().b(vz);
                    if (com.kwad.framework.filedownloader.f.c.a(vl.getId(), vl.getTargetFilePath(), vl.ve(), true)) {
                        return;
                    }
                    boolean a10 = n.vU().a(vl.getUrl(), vl.getPath(), vl.uZ(), vl.uX(), vl.uY(), vl.vg(), vl.ve(), this.ahu.vy(), vl.vk());
                    if (this.ahv == -2) {
                        com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                        if (a10) {
                            n.vU().be(getId());
                            return;
                        }
                        return;
                    }
                    if (a10) {
                        wg2.e(vz);
                        return;
                    }
                    if (wg2.f(vz)) {
                        return;
                    }
                    MessageSnapshot g10 = g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.vJ().a(vz)) {
                        wg2.e(vz);
                        h.vJ().b(vz);
                    }
                    h.vJ().a(vz, g10);
                } finally {
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            h.vJ().a(vz, g(th2));
        }
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t vB() {
        return this.aht;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void vC() {
        synchronized (this.ahp) {
            try {
                if (this.ahv != 0) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.ahv));
                    return;
                }
                b((byte) 10);
                a.InterfaceC0462a vz = this.ahu.vz();
                com.kwad.framework.filedownloader.a vl = vz.vl();
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", vl.getUrl(), vl.getPath(), vl.va(), vl.getTag());
                }
                try {
                    prepare();
                    q.wa().a(this);
                } catch (Throwable th2) {
                    h.vJ().b(vz);
                    h.vJ().a(vz, g(th2));
                }
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long vD() {
        return this.ahA;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte vd() {
        return this.ahv;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable vf() {
        return this.ahx;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int vh() {
        return this.ahC;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean vj() {
        return this.ahD;
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void vu() {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(vd()));
        }
        this.ahy.end(this.ahA);
        if (this.ahu.vA() != null) {
            ArrayList arrayList = (ArrayList) this.ahu.vA().clone();
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.get(i10);
            }
        }
        r.wc().wg().e(this.ahu.vz());
    }

    private void b(byte b10) {
        this.ahv = b10;
        this.ahw = System.currentTimeMillis();
    }
}
