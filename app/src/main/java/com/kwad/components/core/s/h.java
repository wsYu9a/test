package com.kwad.components.core.s;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class h {
    private long CO;
    private a VP;
    private long VN = 100;
    private long VO = 0;
    private boolean NF = false;

    @Nullable
    private Handler VQ = new Handler(Looper.getMainLooper());
    private Runnable VR = new Runnable() { // from class: com.kwad.components.core.s.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.VQ == null) {
                return;
            }
            if (h.this.NF) {
                h.this.VQ.postDelayed(this, h.this.VN / 2);
                return;
            }
            h.this.sh();
            if (h.this.VQ != null) {
                h.this.VQ.postDelayed(this, h.this.VN);
            }
        }
    };

    public interface a {
        void onProgress(long j10, long j11);
    }

    public h(long j10) {
        this.CO = j10;
    }

    public final void pause() {
        this.NF = true;
    }

    public final void resume() {
        this.NF = false;
    }

    public final void sh() {
        a aVar = this.VP;
        if (aVar != null) {
            long j10 = this.CO;
            long j11 = j10 - this.VO;
            aVar.onProgress(j11, j10);
            if (j11 <= 0) {
                stop();
            }
        }
        this.VO += this.VN;
    }

    public final void start() {
        Handler handler = this.VQ;
        if (handler == null) {
            return;
        }
        handler.post(this.VR);
    }

    public final void stop() {
        Handler handler = this.VQ;
        if (handler != null) {
            handler.removeCallbacks(this.VR);
            this.VQ = null;
        }
    }

    public final void a(a aVar) {
        this.VP = aVar;
    }
}
