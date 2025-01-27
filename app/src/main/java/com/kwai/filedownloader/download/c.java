package com.kwai.filedownloader.download;

import android.os.Process;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: classes2.dex */
public final class c implements Runnable {
    private final String RZ;
    private final int aGL;
    private final ConnectTask aHH;
    private final f aHI;
    private e aHJ;
    final int aHK;
    private final boolean aHi;
    private volatile boolean lh;

    public static class a {
        private String RZ;
        private Boolean aHF;
        private f aHI;
        private final ConnectTask.a aHL = new ConnectTask.a();
        private Integer aHM;

        public final c HV() {
            if (this.aHI == null || this.RZ == null || this.aHF == null || this.aHM == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("%s %s %B", this.aHI, this.RZ, this.aHF));
            }
            ConnectTask HE = this.aHL.HE();
            return new c(HE.aGL, this.aHM.intValue(), HE, this.aHI, this.aHF.booleanValue(), this.RZ, (byte) 0);
        }

        public final a a(f fVar) {
            this.aHI = fVar;
            return this;
        }

        public final a b(com.kwai.filedownloader.download.a aVar) {
            this.aHL.a(aVar);
            return this;
        }

        public final a bS(boolean z) {
            this.aHF = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwai.filedownloader.c.b bVar) {
            this.aHL.a(bVar);
            return this;
        }

        public final a cR(int i2) {
            this.aHL.cQ(i2);
            return this;
        }

        public final a d(Integer num) {
            this.aHM = num;
            return this;
        }

        public final a fq(String str) {
            this.aHL.fn(str);
            return this;
        }

        public final a fr(String str) {
            this.aHL.fo(str);
            return this;
        }

        public final a fs(String str) {
            this.RZ = str;
            return this;
        }
    }

    private c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.aGL = i2;
        this.aHK = i3;
        this.lh = false;
        this.aHI = fVar;
        this.RZ = str;
        this.aHH = connectTask;
        this.aHi = z;
    }

    /* synthetic */ c(int i2, int i3, ConnectTask connectTask, f fVar, boolean z, String str, byte b2) {
        this(i2, i3, connectTask, fVar, z, str);
    }

    public final void Hf() {
        pause();
    }

    public final void pause() {
        this.lh = true;
        e eVar = this.aHJ;
        if (eVar != null) {
            eVar.pause();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e2;
        Process.setThreadPriority(10);
        long j2 = this.aHH.HD().aGU;
        com.kwai.filedownloader.kwai.b bVar = null;
        boolean z2 = false;
        while (!this.lh) {
            try {
                try {
                    bVar = this.aHH.HA();
                    int responseCode = bVar.getResponseCode();
                    if (com.kwai.filedownloader.e.d.aJq) {
                        com.kwai.filedownloader.e.d.g(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.aHK), Integer.valueOf(this.aGL), this.aHH.HD(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwai.filedownloader.e.f.j("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.aHH.getRequestHeader(), bVar.W(), Integer.valueOf(responseCode), Integer.valueOf(this.aGL), Integer.valueOf(this.aHK)));
                    }
                    try {
                        e.a aVar = new e.a();
                        if (this.lh) {
                            bVar.X();
                            return;
                        }
                        e Ii = aVar.cU(this.aGL).cT(this.aHK).b(this.aHI).a(this).bU(this.aHi).d(bVar).c(this.aHH.HD()).ft(this.RZ).Ii();
                        this.aHJ = Ii;
                        Ii.run();
                        if (this.lh) {
                            this.aHJ.pause();
                        }
                        bVar.X();
                        return;
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                        e2 = e3;
                        z = true;
                        try {
                            if (!this.aHI.b(e2)) {
                                this.aHI.c(e2);
                                if (bVar != null) {
                                    bVar.X();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                e eVar = this.aHJ;
                                if (eVar == null) {
                                    com.kwai.filedownloader.e.d.h(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                                    this.aHI.c(e2);
                                    if (bVar != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                this.aHI.a(e2, eVar.aGU - j2);
                            } else {
                                this.aHI.a(e2, 0L);
                            }
                            if (bVar != null) {
                                bVar.X();
                            }
                            z2 = z;
                        } finally {
                            if (bVar != null) {
                                bVar.X();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                    e2 = e4;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e5) {
                z = z2;
                e2 = e5;
            }
        }
        if (bVar != null) {
            bVar.X();
        }
    }
}
