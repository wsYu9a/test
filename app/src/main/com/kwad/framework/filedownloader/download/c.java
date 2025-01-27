package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.download.ConnectTask;

/* loaded from: classes3.dex */
public final class c implements Runnable {
    private final String Yx;
    private final int aiP;
    private final ConnectTask ajL;
    private final f ajM;
    private e ajN;
    final int ajO;
    private final boolean ajm;
    private volatile boolean lW;

    public static class a {
        private String Yx;
        private Boolean ajJ;
        private f ajM;
        private final ConnectTask.a ajP = new ConnectTask.a();
        private Integer ajQ;

        public final a a(f fVar) {
            this.ajM = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.ajP.a(aVar);
            return this;
        }

        public final a be(boolean z10) {
            this.ajJ = Boolean.valueOf(z10);
            return this;
        }

        public final a bm(String str) {
            this.ajP.bj(str);
            return this;
        }

        public final a bn(String str) {
            this.ajP.bk(str);
            return this;
        }

        public final a bo(String str) {
            this.Yx = str;
            return this;
        }

        public final a bu(int i10) {
            this.ajP.bt(i10);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.ajP.a(bVar);
            return this;
        }

        public final a d(Integer num) {
            this.ajQ = num;
            return this;
        }

        public final c wN() {
            if (this.ajM == null || this.Yx == null || this.ajJ == null || this.ajQ == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("%s %s %B", this.ajM, this.Yx, this.ajJ));
            }
            ConnectTask wv = this.ajP.wv();
            return new c(wv.aiP, this.ajQ.intValue(), wv, this.ajM, this.ajJ.booleanValue(), this.Yx, (byte) 0);
        }
    }

    public /* synthetic */ c(int i10, int i11, ConnectTask connectTask, f fVar, boolean z10, String str, byte b10) {
        this(i10, i11, connectTask, fVar, z10, str);
    }

    public final void pause() {
        this.lW = true;
        e eVar = this.ajN;
        if (eVar != null) {
            eVar.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016c A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.c.run():void");
    }

    public final void vS() {
        pause();
    }

    private c(int i10, int i11, ConnectTask connectTask, f fVar, boolean z10, String str) {
        this.aiP = i10;
        this.ajO = i11;
        this.lW = false;
        this.ajM = fVar;
        this.Yx = str;
        this.ajL = connectTask;
        this.ajm = z10;
    }
}
