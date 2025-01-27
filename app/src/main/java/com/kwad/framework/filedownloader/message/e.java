package com.kwad.framework.filedownloader.message;

/* loaded from: classes3.dex */
public final class e {
    private volatile g akA;
    private volatile b akB;

    public static final class a {
        private static final e akC = new e();
    }

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e xn() {
        return a.akC;
    }

    public final void a(b bVar) {
        this.akB = bVar;
        if (bVar == null) {
            this.akA = null;
        } else {
            this.akA = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.akB != null) {
                this.akB.r(messageSnapshot);
            }
        } else if (this.akA != null) {
            this.akA.u(messageSnapshot);
        }
    }
}
