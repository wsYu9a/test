package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public abstract class b extends RelativeLayout {
    private Runnable QH;

    @NonNull
    protected final c anr;

    /* renamed from: com.kwad.sdk.core.video.videoview.b$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.qc();
            if (b.this.QH != null) {
                b bVar = b.this;
                bVar.postDelayed(bVar.QH, 1000L);
            }
        }
    }

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.anr = cVar;
    }

    public void m(int i2, int i3) {
    }

    protected abstract void onPlayStateChanged(int i2);

    protected abstract void qc();

    protected final void qi() {
        qj();
        if (this.QH == null) {
            this.QH = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.qc();
                    if (b.this.QH != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.QH, 1000L);
                    }
                }
            };
        }
        post(this.QH);
    }

    protected final void qj() {
        Runnable runnable = this.QH;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.QH = null;
        }
    }

    protected abstract void reset();
}
