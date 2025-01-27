package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor aju = com.kwad.framework.filedownloader.f.b.bu("ConnectionBlock");
    private volatile Exception ajA;
    private String ajB;
    private long ajC;
    private long ajD;
    private long ajE;
    private long ajF;
    private final com.kwad.framework.filedownloader.b.a aje;
    private final d ajh;
    private final int aji;
    private final com.kwad.framework.filedownloader.d.c ajj;
    private final com.kwad.framework.filedownloader.d.b ajk;
    private final boolean ajl;
    private final boolean ajm;
    private final y ajn;
    private boolean ajo;
    int ajp;
    private final boolean ajq;
    private final ArrayList<c> ajr;
    private e ajs;
    private boolean ajt;
    private boolean ajv;
    private boolean ajw;
    private boolean ajx;
    private final AtomicBoolean ajy;
    private volatile boolean ajz;
    private volatile boolean lW;

    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        public DiscardSafely() {
        }
    }

    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        public RetryDirectly() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.b aiQ;
        private Integer ajG;
        private Integer ajH;
        private Boolean ajI;
        private Boolean ajJ;
        private Integer ajK;
        private com.kwad.framework.filedownloader.d.c ajj;
        private y ajn;

        public final a a(y yVar) {
            this.ajn = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.aiQ = bVar;
            return this;
        }

        public final a c(Integer num) {
            this.ajK = num;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.ajj = cVar;
            return this;
        }

        public final DownloadLaunchRunnable wM() {
            if (this.ajj == null || this.ajn == null || this.ajG == null || this.ajH == null || this.ajI == null || this.ajJ == null || this.ajK == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.ajj, this.aiQ, this.ajn, this.ajG.intValue(), this.ajH.intValue(), this.ajI.booleanValue(), this.ajJ.booleanValue(), this.ajK.intValue(), (byte) 0);
        }

        public final a a(Integer num) {
            this.ajG = num;
            return this;
        }

        public final a b(Integer num) {
            this.ajH = num;
            return this;
        }

        public final a a(Boolean bool) {
            this.ajI = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.ajJ = bool;
            return this;
        }
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i10, int i11, boolean z10, boolean z11, int i12, byte b10) {
        this(cVar, bVar, yVar, i10, i11, z10, z11, i12);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) {
        int id2 = this.ajj.getId();
        int responseCode = bVar.getResponseCode();
        this.ajw = responseCode == 206 || responseCode == 1;
        boolean z10 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String xu = this.ajj.xu();
        String a10 = com.kwad.framework.filedownloader.f.f.a(id2, bVar);
        if (responseCode != 412 && ((xu == null || xu.equals(a10) || !(z10 || this.ajw)) && (!(responseCode == 201 && connectTask.ws()) && (responseCode != 416 || this.ajj.xt() <= 0)))) {
            this.ajB = connectTask.wt();
            if (!this.ajw && !z10) {
                throw new FileDownloadHttpException(responseCode, map, bVar.wl());
            }
            long b10 = com.kwad.framework.filedownloader.f.f.b(id2, bVar);
            String a11 = this.ajj.uZ() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.ajj.getUrl()) : null;
            boolean z11 = b10 == -1;
            this.ajx = z11;
            if (!z11) {
                b10 = this.ajj.xt() + b10;
            }
            this.ajh.a(this.ajv && this.ajw, b10, a10, a11);
            return;
        }
        if (this.ajv) {
            com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id2), xu, a10, Integer.valueOf(responseCode));
        }
        this.aje.bn(this.ajj.getId());
        com.kwad.framework.filedownloader.f.f.B(this.ajj.getTargetFilePath(), this.ajj.wL());
        this.ajv = false;
        if (xu != null && xu.equals(a10)) {
            com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", xu, a10, Integer.valueOf(responseCode), Integer.valueOf(id2));
            a10 = null;
        }
        this.ajj.T(0L);
        this.ajj.V(0L);
        this.ajj.br(a10);
        this.ajj.xx();
        this.aje.a(id2, this.ajj.xu(), this.ajj.xt(), this.ajj.getTotal(), this.ajj.xw());
        throw new RetryDirectly();
    }

    private void b(long j10, int i10) {
        long j11 = j10 / i10;
        int id2 = this.ajj.getId();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        long j12 = 0;
        while (i11 < i10) {
            long j13 = i11 == i10 + (-1) ? 0L : (j12 + j11) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id2);
            aVar.setIndex(i11);
            aVar.setStartOffset(j12);
            aVar.R(j12);
            aVar.S(j13);
            arrayList.add(aVar);
            this.aje.a(aVar);
            j12 += j11;
            i11++;
        }
        this.ajj.bE(i10);
        this.aje.s(id2, i10);
        b(arrayList, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.framework.filedownloader.download.a q(java.util.List<com.kwad.framework.filedownloader.d.a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwad.framework.filedownloader.d.c r1 = r0.ajj
            int r1 = r1.xw()
            com.kwad.framework.filedownloader.d.c r2 = r0.ajj
            java.lang.String r2 = r2.wL()
            com.kwad.framework.filedownloader.d.c r3 = r0.ajj
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
            boolean r9 = r0.ajq
            if (r9 == 0) goto L54
        L23:
            com.kwad.framework.filedownloader.d.c r9 = r0.ajj
            int r9 = r9.getId()
            com.kwad.framework.filedownloader.d.c r10 = r0.ajj
            boolean r9 = com.kwad.framework.filedownloader.f.f.b(r9, r10)
            if (r9 == 0) goto L54
            boolean r9 = r0.ajq
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
            long r9 = com.kwad.framework.filedownloader.d.a.r(r21)
            goto L3e
        L4d:
            com.kwad.framework.filedownloader.d.c r1 = r0.ajj
            long r9 = r1.xt()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwad.framework.filedownloader.d.c r1 = r0.ajj
            r1.T(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.ajv = r4
            if (r4 != 0) goto L71
            com.kwad.framework.filedownloader.b.a r1 = r0.aje
            com.kwad.framework.filedownloader.d.c r4 = r0.ajj
            int r4 = r4.getId()
            r1.bn(r4)
            com.kwad.framework.filedownloader.f.f.B(r3, r2)
        L71:
            com.kwad.framework.filedownloader.download.a r1 = new com.kwad.framework.filedownloader.download.a
            com.kwad.framework.filedownloader.d.c r2 = r0.ajj
            long r2 = r2.getTotal()
            long r18 = r2 - r14
            r12 = 0
            r16 = 0
            r11 = r1
            r11.<init>(r12, r14, r16, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.q(java.util.List):com.kwad.framework.filedownloader.download.a");
    }

    private boolean wH() {
        return (!this.ajv || this.ajj.xw() > 1) && this.ajw && this.ajq && !this.ajx;
    }

    private void wJ() {
        if (this.ajm && !com.kwad.framework.filedownloader.f.f.bC(g.f11101b)) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.ajj.getId()), g.f11101b));
        }
        if (this.ajm && com.kwad.framework.filedownloader.f.f.ya()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void wK() {
        int id2 = this.ajj.getId();
        if (this.ajj.uZ()) {
            String targetFilePath = this.ajj.getTargetFilePath();
            int A = com.kwad.framework.filedownloader.f.f.A(this.ajj.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id2, targetFilePath, this.ajl, false)) {
                this.aje.bo(id2);
                this.aje.bn(id2);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c bl = this.aje.bl(A);
            if (bl != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id2, bl, this.ajn, false)) {
                    this.aje.bo(id2);
                    this.aje.bn(id2);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> bm = this.aje.bm(A);
                this.aje.bo(A);
                this.aje.bn(A);
                com.kwad.framework.filedownloader.f.f.bG(this.ajj.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(A, bl)) {
                    this.ajj.T(bl.xt());
                    this.ajj.V(bl.getTotal());
                    this.ajj.br(bl.xu());
                    this.ajj.bE(bl.xw());
                    this.aje.b(this.ajj);
                    if (bm != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : bm) {
                            aVar.setId(id2);
                            this.aje.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id2, this.ajj.xt(), this.ajj.wL(), targetFilePath, this.ajn)) {
                this.aje.bo(id2);
                this.aje.bn(id2);
                throw new DiscardSafely();
            }
        }
    }

    public final int getId() {
        return this.ajj.getId();
    }

    public final boolean isAlive() {
        return this.ajy.get() || this.ajh.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j10) {
        if (this.lW) {
            return;
        }
        this.ajh.onProgress(j10);
    }

    public final void pause() {
        this.lW = true;
        e eVar = this.ajs;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.ajr.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x022f, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.b("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0230, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x027f, code lost:
    
        r4.wm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0282, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0189, code lost:
    
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.b.ww().a(r19.ajj.getId(), r19.ajj.getUrl(), r19.ajj.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a9, code lost:
    
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x027a, code lost:
    
        if (r9 != null) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x00a3, code lost:
    
        if (com.kwad.framework.filedownloader.f.d.alt == false) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x00a5, code lost:
    
        com.kwad.framework.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.ajj.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x00b6, code lost:
    
        r19.ajh.wO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x00bd, code lost:
    
        if (r19.lW == false) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x00c2, code lost:
    
        if (r19.ajz == false) goto L670;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x00c5, code lost:
    
        r19.ajh.wT();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00cb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x00cc, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0124, code lost:
    
        if (r19.lW == false) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0126, code lost:
    
        r19.ajj.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012b, code lost:
    
        if (r9 == null) goto L514;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012d, code lost:
    
        r9.wm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0130, code lost:
    
        r19.ajh.wO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0137, code lost:
    
        if (r19.lW == false) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013d, code lost:
    
        if (r19.ajz == false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0141, code lost:
    
        r19.ajh.wT();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0148, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0149, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0164, code lost:
    
        wK();
        r14 = r19.ajj.getTotal();
        a(r14, r19.ajj.wL());
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017a, code lost:
    
        if (wH() == false) goto L547;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017e, code lost:
    
        if (r19.ajv == false) goto L546;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0180, code lost:
    
        r10 = r19.ajj.xw();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ac, code lost:
    
        if (r10 <= 0) goto L599;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01b0, code lost:
    
        if (r19.lW == false) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01b2, code lost:
    
        r19.ajj.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b7, code lost:
    
        if (r9 == null) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b9, code lost:
    
        r9.wm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01bc, code lost:
    
        r19.ajh.wO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c3, code lost:
    
        if (r19.lW == false) goto L557;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c9, code lost:
    
        if (r19.ajz == false) goto L667;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01cd, code lost:
    
        r19.ajh.wT();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01d5, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01d8, code lost:
    
        if (r10 != 1) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01da, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01dd, code lost:
    
        r19.ajt = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01df, code lost:
    
        if (r11 == false) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01e1, code lost:
    
        a(r8.wu(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0219, code lost:
    
        if (r9 == null) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x021b, code lost:
    
        r9.wm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e9, code lost:
    
        if (r9 == null) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01eb, code lost:
    
        r9.wm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01f0, code lost:
    
        r19.ajh.wR();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01f7, code lost:
    
        if (r19.ajv == false) goto L594;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01f9, code lost:
    
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0218, code lost:
    
        r9 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0213, code lost:
    
        b(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ef, code lost:
    
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dc, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027f A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #7 {all -> 0x0032, blocks: (B:3:0x0006, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:26:0x0036, B:27:0x0094, B:29:0x0098, B:31:0x009d, B:175:0x00a1, B:177:0x00a5, B:33:0x00ce, B:43:0x012d, B:63:0x01b9, B:79:0x021b, B:107:0x027f, B:108:0x0282, B:115:0x0246, B:144:0x0272, B:130:0x023f), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[Catch: all -> 0x0032, SYNTHETIC, TRY_LEAVE, TryCatch #7 {all -> 0x0032, blocks: (B:3:0x0006, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:26:0x0036, B:27:0x0094, B:29:0x0098, B:31:0x009d, B:175:0x00a1, B:177:0x00a5, B:33:0x00ce, B:43:0x012d, B:63:0x01b9, B:79:0x021b, B:107:0x027f, B:108:0x0282, B:115:0x0246, B:144:0x0272, B:130:0x023f), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x026b A[Catch: all -> 0x014c, TRY_LEAVE, TryCatch #18 {all -> 0x014c, blocks: (B:39:0x011b, B:41:0x0126, B:53:0x0164, B:55:0x017c, B:57:0x0180, B:59:0x01ae, B:61:0x01b2, B:75:0x01dd, B:77:0x01e1, B:90:0x01eb, B:98:0x0220, B:101:0x0228, B:102:0x022f, B:110:0x0189, B:139:0x0265, B:141:0x026b, B:148:0x0277), top: B:138:0x0265 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0277 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    public final void wG() {
        if (this.ajj.xw() > 1) {
            List<com.kwad.framework.filedownloader.d.a> bm = this.aje.bm(this.ajj.getId());
            if (this.ajj.xw() == bm.size()) {
                this.ajj.T(com.kwad.framework.filedownloader.d.a.r(bm));
            } else {
                this.ajj.T(0L);
                this.aje.bn(this.ajj.getId());
            }
        }
        this.ajh.wP();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void wI() {
        this.aje.b(this.ajj.getId(), this.ajj.xt());
    }

    public final String wL() {
        return this.ajj.wL();
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i10, int i11, boolean z10, boolean z11, int i12) {
        this.aji = 5;
        this.ajr = new ArrayList<>(5);
        this.ajC = 0L;
        this.ajD = 0L;
        this.ajE = 0L;
        this.ajF = 0L;
        this.ajy = new AtomicBoolean(true);
        this.lW = false;
        this.ajo = false;
        this.ajj = cVar;
        this.ajk = bVar;
        this.ajl = z10;
        this.ajm = z11;
        this.aje = b.ww().wy();
        this.ajq = b.ww().wA();
        this.ajn = yVar;
        this.ajp = i12;
        this.ajh = new d(cVar, i12, i10, i11);
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j10) {
        long xq;
        int id2 = this.ajj.getId();
        String xu = this.ajj.xu();
        String str = this.ajB;
        if (str == null) {
            str = this.ajj.getUrl();
        }
        String wL = this.ajj.wL();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id2), Long.valueOf(j10));
        }
        boolean z10 = this.ajv;
        long j11 = 0;
        long j12 = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.xq() == j11) {
                xq = j10 - aVar.xp();
            } else {
                xq = (aVar.xq() - aVar.xp()) + 1;
            }
            long j13 = xq;
            j12 += aVar.xp() - aVar.getStartOffset();
            if (j13 == j11) {
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
            } else {
                c wN = new c.a().bu(id2).d(Integer.valueOf(aVar.getIndex())).a(this).bm(str).bn(z10 ? xu : null).c(this.ajk).be(this.ajm).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.xp(), aVar.xq(), j13)).bo(wL).wN();
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.ajr.add(wN);
            }
            j11 = 0;
        }
        if (j12 != this.ajj.xt()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.ajj.xt()), Long.valueOf(j12));
            this.ajj.T(j12);
        }
        ArrayList arrayList = new ArrayList(this.ajr.size());
        Iterator<c> it = this.ajr.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.lW) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.lW) {
            this.ajj.d((byte) -2);
            return;
        }
        List<Future> invokeAll = aju.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.alt) {
            for (Future future : invokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) {
        if (!this.ajw) {
            this.ajj.T(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.aiZ, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).bx(this.ajj.getId()).bw(-1).bg(this.ajm).d(bVar).c(aVar).bp(this.ajj.wL());
        this.ajj.bE(1);
        this.aje.s(this.ajj.getId(), 1);
        this.ajs = aVar2.xa();
        if (this.lW) {
            this.ajj.d((byte) -2);
            this.ajs.pause();
        } else {
            this.ajs.run();
        }
    }

    private void a(int i10, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i10 > 1 && list.size() == i10) {
            b(list, this.ajj.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j10, String str) {
        com.kwad.framework.filedownloader.e.a aVar = null;
        if (j10 != -1) {
            try {
                aVar = com.kwad.framework.filedownloader.f.f.bE(this.ajj.wL());
                long length = new File(str).length();
                long j11 = j10 - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j11) {
                    if (!com.kwad.framework.filedownloader.f.e.xV().alz) {
                        aVar.setLength(j10);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j11, length);
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    aVar.close();
                }
                throw th2;
            }
        }
        if (aVar != null) {
            aVar.close();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.ajz = true;
        this.ajA = exc;
        if (this.lW) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.ajj.getId()));
            }
        } else {
            Iterator it = ((ArrayList) this.ajr.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.vS();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j10, long j11) {
        if (this.lW) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.ajj.getId()));
                return;
            }
            return;
        }
        int i10 = cVar == null ? -1 : cVar.ajO;
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(this.ajj.getTotal()));
        }
        if (!this.ajt) {
            synchronized (this.ajr) {
                this.ajr.remove(cVar);
            }
        } else {
            if (j10 == 0 || j11 == this.ajj.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(this.ajj.getTotal()), Integer.valueOf(this.ajj.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.ajt && code == 416 && !this.ajo) {
                com.kwad.framework.filedownloader.f.f.B(this.ajj.getTargetFilePath(), this.ajj.wL());
                this.ajo = true;
                return true;
            }
        }
        return this.ajp > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j10) {
        if (this.lW) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.ajj.getId()));
            }
        } else {
            int i10 = this.ajp;
            int i11 = i10 - 1;
            this.ajp = i11;
            if (i10 < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i11), Integer.valueOf(this.ajj.getId()));
            }
            this.ajh.a(exc, this.ajp, j10);
        }
    }
}
