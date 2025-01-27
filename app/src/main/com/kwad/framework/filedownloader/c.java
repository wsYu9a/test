package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0462a, d.a {
    private final x agX;
    private final x.a agY;
    private int agZ;
    private ArrayList<Object> aha;
    private String ahb;
    private String ahc;
    private boolean ahd;
    private com.kwad.framework.filedownloader.d.b ahe;
    private i ahf;
    private Object ahg;
    private final Object ahp;
    private final String mUrl;
    private int ahh = 0;
    private boolean ahi = false;
    private boolean ahj = false;
    private int ahk = 100;
    private int ahl = 10;
    private boolean ahm = false;
    volatile int ahn = 0;
    private boolean aho = false;
    private final Object ahq = new Object();
    private volatile boolean ahr = false;

    public static final class a implements a.b {
        private final c ahs;

        public /* synthetic */ a(c cVar, byte b10) {
            this(cVar);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int vt() {
            int id2 = this.ahs.getId();
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id2));
            }
            h.vJ().c(this.ahs);
            return id2;
        }

        private a(c cVar) {
            this.ahs = cVar;
            c.a(cVar, true);
        }
    }

    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.ahp = obj;
        d dVar = new d(this, obj);
        this.agX = dVar;
        this.agY = dVar;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.aho = true;
        return true;
    }

    private boolean vv() {
        return this.agX.vd() != 0;
    }

    private int vw() {
        if (!vv()) {
            if (!uW()) {
                vo();
            }
            this.agX.vC();
            return getId();
        }
        if (isRunning()) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        }
        throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.agX.toString());
    }

    private void vx() {
        if (this.ahe == null) {
            synchronized (this.ahq) {
                try {
                    if (this.ahe == null) {
                        this.ahe = new com.kwad.framework.filedownloader.d.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aY(int i10) {
        this.ahh = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final boolean aZ(int i10) {
        return getId() == i10;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bb(boolean z10) {
        this.ahm = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bc(boolean z10) {
        this.ahi = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bd(boolean z10) {
        this.ahj = z10;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a be(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bf(String str) {
        if (this.ahe == null) {
            synchronized (this.ahq) {
                try {
                    if (this.ahe == null) {
                        return this;
                    }
                } finally {
                }
            }
        }
        this.ahe.bq(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z10) {
        this.ahb = str;
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.ahd = z10;
        if (z10) {
            this.ahc = null;
        } else {
            this.ahc = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a e(Object obj) {
        this.ahg = obj;
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final void free() {
        this.agX.free();
        if (h.vJ().a(this)) {
            this.ahr = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.ahc;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i10 = this.agZ;
        if (i10 != 0) {
            return i10;
        }
        if (TextUtils.isEmpty(this.ahb) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int g10 = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.ahb, this.ahd);
        this.agZ = g10;
        return g10;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.ahb;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.agX.vD() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.agX.vD();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.agX.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.agX.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.agX.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.agX.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.ahg;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), uZ(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.bG(vd());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.wc().wg().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.bH(vd());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean pause;
        synchronized (this.ahp) {
            pause = this.agX.pause();
        }
        return pause;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void setFileName(String str) {
        this.ahc = str;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (this.aho) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return vw();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a t(String str, String str2) {
        vx();
        this.ahe.x(str, str2);
        return this;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b uU() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uV() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.ahn = 0;
        this.aho = false;
        this.ahr = false;
        this.agX.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uW() {
        return this.ahn != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int uX() {
        return this.ahk;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int uY() {
        return this.ahl;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uZ() {
        return this.ahd;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> vA() {
        return this.aha;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i va() {
        return this.ahf;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long vb() {
        return this.agX.vD();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long vc() {
        return this.agX.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte vd() {
        return this.agX.vd();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean ve() {
        return this.ahm;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable vf() {
        return this.agX.vf();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int vg() {
        return this.ahh;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int vh() {
        return this.agX.vh();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean vi() {
        return this.ahi;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean vj() {
        return this.agX.vj();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean vk() {
        return this.ahj;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final com.kwad.framework.filedownloader.a vl() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final x.a vm() {
        return this.agY;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final int vn() {
        return this.ahn;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final void vo() {
        this.ahn = va() != null ? va().hashCode() : hashCode();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final boolean vp() {
        return this.ahr;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final void vq() {
        this.ahr = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final void vr() {
        vw();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0462a
    public final boolean vs() {
        ArrayList<Object> arrayList = this.aha;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b vy() {
        return this.ahe;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0462a vz() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.ahf = iVar;
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }
}
