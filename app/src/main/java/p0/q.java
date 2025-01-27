package p0;

import androidx.media3.session.MediaController;

/* loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: b */
    public final /* synthetic */ MediaController f29675b;

    public /* synthetic */ q(MediaController mediaController) {
        this.f29675b = mediaController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f29675b.release();
    }
}
