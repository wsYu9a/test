package com.kwai.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.crash.utils.h;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor aHq = com.kwai.filedownloader.e.b.fy("ConnectionBlock");
    private long aHA;
    private long aHB;
    private final com.kwai.filedownloader.a.a aHa;
    private final d aHd;
    private final int aHe;
    private final com.kwai.filedownloader.c.c aHf;
    private final com.kwai.filedownloader.c.b aHg;
    private final boolean aHh;
    private final boolean aHi;
    private final y aHj;
    private boolean aHk;
    int aHl;
    private final boolean aHm;
    private final ArrayList<c> aHn;
    private e aHo;
    private boolean aHp;
    private boolean aHr;
    private boolean aHs;
    private boolean aHt;
    private final AtomicBoolean aHu;
    private volatile boolean aHv;
    private volatile Exception aHw;
    private String aHx;
    private long aHy;
    private long aHz;
    private volatile boolean lh;

    class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    public static class a {
        private com.kwai.filedownloader.c.b aGM;
        private Integer aHC;
        private Integer aHD;
        private Boolean aHE;
        private Boolean aHF;
        private Integer aHG;
        private com.kwai.filedownloader.c.c aHf;
        private y aHj;

        public final DownloadLaunchRunnable HU() {
            if (this.aHf == null || this.aHj == null || this.aHC == null || this.aHD == null || this.aHE == null || this.aHF == null || this.aHG == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.aHf, this.aGM, this.aHj, this.aHC.intValue(), this.aHD.intValue(), this.aHE.booleanValue(), this.aHF.booleanValue(), this.aHG.intValue(), (byte) 0);
        }

        public final a a(y yVar) {
            this.aHj = yVar;
            return this;
        }

        public final a a(Integer num) {
            this.aHC = num;
            return this;
        }

        public final a b(com.kwai.filedownloader.c.b bVar) {
            this.aGM = bVar;
            return this;
        }

        public final a b(Boolean bool) {
            this.aHE = bool;
            return this;
        }

        public final a b(Integer num) {
            this.aHD = num;
            return this;
        }

        public final a c(Boolean bool) {
            this.aHF = bool;
            return this;
        }

        public final a c(Integer num) {
            this.aHG = num;
            return this;
        }

        public final a e(com.kwai.filedownloader.c.c cVar) {
            this.aHf = cVar;
            return this;
        }
    }

    private DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i2, int i3, boolean z, boolean z2, int i4) {
        this.aHe = 5;
        this.aHn = new ArrayList<>(5);
        this.aHy = 0L;
        this.aHz = 0L;
        this.aHA = 0L;
        this.aHB = 0L;
        this.aHu = new AtomicBoolean(true);
        this.lh = false;
        this.aHk = false;
        this.aHf = cVar;
        this.aHg = bVar;
        this.aHh = z;
        this.aHi = z2;
        this.aHa = b.HF().HH();
        this.aHm = b.HF().HJ();
        this.aHj = yVar;
        this.aHl = i4;
        this.aHd = new d(cVar, i4, i2, i3);
    }

    /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i2, int i3, boolean z, boolean z2, int i4, byte b2) {
        this(cVar, bVar, yVar, i2, i3, z, z2, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwai.filedownloader.download.a G(java.util.List<com.kwai.filedownloader.c.a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwai.filedownloader.c.c r1 = r0.aHf
            int r1 = r1.ID()
            com.kwai.filedownloader.c.c r2 = r0.aHf
            java.lang.String r2 = r2.HT()
            com.kwai.filedownloader.c.c r3 = r0.aHf
            java.lang.String r3 = r3.getTargetFilePath()
            r4 = 0
            r5 = 1
            if (r1 <= r5) goto L1a
            r6 = 1
            goto L1b
        L1a:
            r6 = 0
        L1b:
            r7 = 0
            if (r6 == 0) goto L23
            boolean r9 = r0.aHm
            if (r9 == 0) goto L54
        L23:
            com.kwai.filedownloader.c.c r9 = r0.aHf
            int r9 = r9.getId()
            com.kwai.filedownloader.c.c r10 = r0.aHf
            boolean r9 = com.kwai.filedownloader.e.f.b(r9, r10)
            if (r9 == 0) goto L54
            boolean r9 = r0.aHm
            if (r9 != 0) goto L40
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            long r9 = r1.length()
        L3e:
            r14 = r9
            goto L55
        L40:
            if (r6 == 0) goto L4d
            int r6 = r21.size()
            if (r1 != r6) goto L54
            long r9 = com.kwai.filedownloader.c.a.H(r21)
            goto L3e
        L4d:
            com.kwai.filedownloader.c.c r1 = r0.aHf
            long r9 = r1.IB()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwai.filedownloader.c.c r1 = r0.aHf
            r1.ao(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.aHr = r4
            if (r4 != 0) goto L71
            com.kwai.filedownloader.a.a r1 = r0.aHa
            com.kwai.filedownloader.c.c r4 = r0.aHf
            int r4 = r4.getId()
            r1.cK(r4)
            com.kwai.filedownloader.e.f.ar(r3, r2)
        L71:
            com.kwai.filedownloader.download.a r1 = new com.kwai.filedownloader.download.a
            r12 = 0
            r16 = 0
            com.kwai.filedownloader.c.c r2 = r0.aHf
            long r2 = r2.getTotal()
            long r18 = r2 - r14
            r11 = r1
            r11.<init>(r12, r14, r16, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.G(java.util.List):com.kwai.filedownloader.download.a");
    }

    private boolean HP() {
        return (!this.aHr || this.aHf.ID() > 1) && this.aHs && this.aHm && !this.aHt;
    }

    private void HR() {
        if (this.aHi && !com.kwai.filedownloader.e.f.fF(g.f9317b)) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aHf.getId()), g.f9317b));
        }
        if (this.aHi && com.kwai.filedownloader.e.f.Jg()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void HS() {
        int id = this.aHf.getId();
        if (this.aHf.Gm()) {
            String targetFilePath = this.aHf.getTargetFilePath();
            int aq = com.kwai.filedownloader.e.f.aq(this.aHf.getUrl(), targetFilePath);
            if (com.kwai.filedownloader.e.c.a(id, targetFilePath, this.aHh, false)) {
                this.aHa.cL(id);
                this.aHa.cK(id);
                throw new DiscardSafely();
            }
            com.kwai.filedownloader.c.c cI = this.aHa.cI(aq);
            if (cI != null) {
                if (com.kwai.filedownloader.e.c.a(id, cI, this.aHj, false)) {
                    this.aHa.cL(id);
                    this.aHa.cK(id);
                    throw new DiscardSafely();
                }
                List<com.kwai.filedownloader.c.a> cJ = this.aHa.cJ(aq);
                this.aHa.cL(aq);
                this.aHa.cK(aq);
                com.kwai.filedownloader.e.f.fJ(this.aHf.getTargetFilePath());
                if (com.kwai.filedownloader.e.f.b(aq, cI)) {
                    this.aHf.ao(cI.IB());
                    this.aHf.aq(cI.getTotal());
                    this.aHf.fv(cI.IC());
                    this.aHf.db(cI.ID());
                    this.aHa.b(this.aHf);
                    if (cJ != null) {
                        for (com.kwai.filedownloader.c.a aVar : cJ) {
                            aVar.setId(id);
                            this.aHa.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwai.filedownloader.e.c.a(id, this.aHf.IB(), this.aHf.HT(), targetFilePath, this.aHj)) {
                this.aHa.cL(id);
                this.aHa.cK(id);
                throw new DiscardSafely();
            }
        }
    }

    private void a(int i2, List<com.kwai.filedownloader.c.a> list) {
        if (i2 <= 1 || list.size() != i2) {
            throw new IllegalArgumentException();
        }
        b(list, this.aHf.getTotal());
    }

    private void a(long j2, String str) {
        com.kwai.filedownloader.d.a aVar = null;
        if (j2 != -1) {
            try {
                aVar = com.kwai.filedownloader.e.f.fH(this.aHf.HT());
                long length = new File(str).length();
                long j3 = j2 - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes < j3) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j3, length);
                }
                if (!com.kwai.filedownloader.e.e.Jb().aJw) {
                    aVar.setLength(j2);
                }
            } finally {
                if (0 != 0) {
                    aVar.close();
                }
            }
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.kwai.b bVar) {
        if (!this.aHs) {
            this.aHf.ao(0L);
            aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.aGV, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).cU(this.aHf.getId()).cT(-1).bU(this.aHi).d(bVar).c(aVar).ft(this.aHf.HT());
        this.aHf.db(1);
        this.aHa.A(this.aHf.getId(), 1);
        this.aHo = aVar2.Ii();
        if (!this.lh) {
            this.aHo.run();
        } else {
            this.aHf.e((byte) -2);
            this.aHo.pause();
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.kwai.b bVar) {
        int id = this.aHf.getId();
        int responseCode = bVar.getResponseCode();
        this.aHs = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String IC = this.aHf.IC();
        String a2 = com.kwai.filedownloader.e.f.a(id, bVar);
        if (!(responseCode == 412 || !(IC == null || IC.equals(a2) || (!z && !this.aHs)) || ((responseCode == 201 && connectTask.HB()) || (responseCode == 416 && this.aHf.IB() > 0)))) {
            this.aHx = connectTask.HC();
            if (!this.aHs && !z) {
                throw new FileDownloadHttpException(responseCode, map, bVar.W());
            }
            long b2 = com.kwai.filedownloader.e.f.b(id, bVar);
            String a3 = this.aHf.Gm() ? com.kwai.filedownloader.e.f.a(bVar, this.aHf.getUrl()) : null;
            boolean z2 = b2 == -1;
            this.aHt = z2;
            this.aHd.a(this.aHr && this.aHs, !z2 ? this.aHf.IB() + b2 : b2, a2, a3);
            return;
        }
        if (this.aHr) {
            com.kwai.filedownloader.e.d.h(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), IC, a2, Integer.valueOf(responseCode));
        }
        this.aHa.cK(this.aHf.getId());
        com.kwai.filedownloader.e.f.ar(this.aHf.getTargetFilePath(), this.aHf.HT());
        this.aHr = false;
        if (IC != null && IC.equals(a2)) {
            com.kwai.filedownloader.e.d.h(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", IC, a2, Integer.valueOf(responseCode), Integer.valueOf(id));
            a2 = null;
        }
        this.aHf.ao(0L);
        this.aHf.aq(0L);
        this.aHf.fv(a2);
        this.aHf.IE();
        this.aHa.a(id, this.aHf.IC(), this.aHf.IB(), this.aHf.getTotal(), this.aHf.ID());
        throw new RetryDirectly();
    }

    private void b(List<com.kwai.filedownloader.c.a> list, long j2) {
        int id = this.aHf.getId();
        String IC = this.aHf.IC();
        String str = this.aHx;
        if (str == null) {
            str = this.aHf.getUrl();
        }
        String HT = this.aHf.HT();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j2));
        }
        boolean z = this.aHr;
        long j3 = 0;
        long j4 = 0;
        for (com.kwai.filedownloader.c.a aVar : list) {
            long Ix = aVar.Iy() == j3 ? j2 - aVar.Ix() : (aVar.Iy() - aVar.Ix()) + 1;
            j4 += aVar.Ix() - aVar.getStartOffset();
            if (Ix != j3) {
                c HV = new c.a().cR(id).d(Integer.valueOf(aVar.getIndex())).a(this).fq(str).fr(z ? IC : null).c(this.aHg).bS(this.aHi).b(new com.kwai.filedownloader.download.a(aVar.getStartOffset(), aVar.Ix(), aVar.Iy(), Ix)).fs(HT).HV();
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "enable multiple connection: %s", aVar);
                }
                this.aHn.add(HV);
            } else if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
            j3 = 0;
        }
        if (j4 != this.aHf.IB()) {
            com.kwai.filedownloader.e.d.h(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aHf.IB()), Long.valueOf(j4));
            this.aHf.ao(j4);
        }
        ArrayList arrayList = new ArrayList(this.aHn.size());
        Iterator<c> it = this.aHn.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.lh) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.lh) {
            this.aHf.e((byte) -2);
            return;
        }
        List<Future> invokeAll = aHq.invokeAll(arrayList);
        if (com.kwai.filedownloader.e.d.aJq) {
            for (Future future : invokeAll) {
                com.kwai.filedownloader.e.d.g(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void e(long j2, int i2) {
        long j3 = j2 / i2;
        int id = this.aHf.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + (-1) ? 0L : (j4 + j3) - 1;
            com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
            aVar.setId(id);
            aVar.setIndex(i3);
            aVar.setStartOffset(j4);
            aVar.am(j4);
            aVar.an(j5);
            arrayList.add(aVar);
            this.aHa.a(aVar);
            j4 += j3;
            i3++;
        }
        this.aHf.db(i2);
        this.aHa.A(id, i2);
        b(arrayList, j2);
    }

    public final void HO() {
        if (this.aHf.ID() > 1) {
            List<com.kwai.filedownloader.c.a> cJ = this.aHa.cJ(this.aHf.getId());
            if (this.aHf.ID() == cJ.size()) {
                this.aHf.ao(com.kwai.filedownloader.c.a.H(cJ));
            } else {
                this.aHf.ao(0L);
                this.aHa.cK(this.aHf.getId());
            }
        }
        this.aHd.HX();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void HQ() {
        this.aHa.e(this.aHf.getId(), this.aHf.IB());
    }

    public final String HT() {
        return this.aHf.HT();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(c cVar, long j2, long j3) {
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aHf.getId()));
                return;
            }
            return;
        }
        int i2 = cVar == null ? -1 : cVar.aHK;
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.aHf.getTotal()));
        }
        if (!this.aHp) {
            synchronized (this.aHn) {
                this.aHn.remove(cVar);
            }
        } else {
            if (j2 == 0 || j3 == this.aHf.getTotal()) {
                return;
            }
            com.kwai.filedownloader.e.d.e(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.aHf.getTotal()), Integer.valueOf(this.aHf.getId()));
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(Exception exc, long j2) {
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aHf.getId()));
            }
        } else {
            int i2 = this.aHl;
            int i3 = i2 - 1;
            this.aHl = i3;
            if (i2 < 0) {
                com.kwai.filedownloader.e.d.e(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.aHf.getId()));
            }
            this.aHd.a(exc, this.aHl, j2);
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final boolean b(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.aHp && code == 416 && !this.aHk) {
                com.kwai.filedownloader.e.f.ar(this.aHf.getTargetFilePath(), this.aHf.HT());
                this.aHk = true;
                return true;
            }
        }
        return this.aHl > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwai.filedownloader.download.f
    public final void c(Exception exc) {
        this.aHv = true;
        this.aHw = exc;
        if (this.lh) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aHf.getId()));
            }
        } else {
            Iterator it = ((ArrayList) this.aHn.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.Hf();
                }
            }
        }
    }

    public final int getId() {
        return this.aHf.getId();
    }

    public final boolean isAlive() {
        return this.aHu.get() || this.aHd.isAlive();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void onProgress(long j2) {
        if (this.lh) {
            return;
        }
        this.aHd.onProgress(j2);
    }

    public final void pause() {
        this.lh = true;
        e eVar = this.aHo;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.aHn.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x016d, code lost:
    
        r17 = r14;
        r10 = com.kwai.filedownloader.download.b.HF().a(r19.aHf.getId(), r19.aHf.getUrl(), r19.aHf.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x018d, code lost:
    
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x009f, code lost:
    
        if (com.kwai.filedownloader.e.d.aJq == false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x00a1, code lost:
    
        com.kwai.filedownloader.e.d.g(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.aHf.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x00b2, code lost:
    
        r19.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00b9, code lost:
    
        if (r19.lh == false) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00be, code lost:
    
        if (r19.aHv == false) goto L415;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00c1, code lost:
    
        r19.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00c7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x00c8, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0120, code lost:
    
        if (r19.lh == false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0122, code lost:
    
        r19.aHf.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0127, code lost:
    
        if (r9 == null) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0129, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012c, code lost:
    
        r19.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0133, code lost:
    
        if (r19.lh == false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0139, code lost:
    
        if (r19.aHv == false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013d, code lost:
    
        r19.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0144, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0145, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0148, code lost:
    
        HS();
        r14 = r19.aHf.getTotal();
        a(r14, r19.aHf.HT());
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015e, code lost:
    
        if (HP() == false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0162, code lost:
    
        if (r19.aHr == false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0164, code lost:
    
        r10 = r19.aHf.ID();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0190, code lost:
    
        if (r10 <= 0) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0194, code lost:
    
        if (r19.lh == false) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0196, code lost:
    
        r19.aHf.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x019b, code lost:
    
        if (r9 == null) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019d, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a0, code lost:
    
        r19.aHd.HW();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a7, code lost:
    
        if (r19.lh == false) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ad, code lost:
    
        if (r19.aHv == false) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b1, code lost:
    
        r19.aHd.Ib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b9, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bc, code lost:
    
        if (r10 != 1) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01be, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01c1, code lost:
    
        r19.aHp = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c3, code lost:
    
        if (r11 == false) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c5, code lost:
    
        a(r8.HD(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e7, code lost:
    
        if (r9 == null) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e9, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cd, code lost:
    
        if (r9 == null) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cf, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d4, code lost:
    
        r19.aHd.HZ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01db, code lost:
    
        if (r19.aHr == false) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dd, code lost:
    
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e6, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:
    
        e(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01d3, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01c0, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ff, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.e.f.j("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x025e A[Catch: all -> 0x0219, TryCatch #27 {all -> 0x0219, blocks: (B:37:0x00cf, B:91:0x01d4, B:93:0x01dd, B:95:0x01e1, B:125:0x0258, B:127:0x025e, B:133:0x0266, B:115:0x021c), top: B:124:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0271 A[Catch: all -> 0x0291, TryCatch #26 {all -> 0x0291, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:26:0x0032, B:27:0x0090, B:29:0x0094, B:31:0x0099, B:162:0x009d, B:164:0x00a1, B:33:0x00ca, B:43:0x0129, B:63:0x019d, B:79:0x01e9, B:139:0x0271, B:140:0x0274, B:104:0x022b, B:118:0x0224, B:135:0x026b), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[Catch: all -> 0x0291, SYNTHETIC, TRY_LEAVE, TryCatch #26 {all -> 0x0291, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:26:0x0032, B:27:0x0090, B:29:0x0094, B:31:0x0099, B:162:0x009d, B:164:0x00a1, B:33:0x00ca, B:43:0x0129, B:63:0x019d, B:79:0x01e9, B:139:0x0271, B:140:0x0274, B:104:0x022b, B:118:0x0224, B:135:0x026b), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0280  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.run():void");
    }
}
