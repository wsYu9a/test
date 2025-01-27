package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public abstract class b extends RelativeLayout {
    private Runnable WD;

    @NonNull
    protected final c aFX;

    /* renamed from: com.kwad.sdk.core.video.videoview.b$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.st();
            if (b.this.WD != null) {
                b bVar = b.this;
                bVar.postDelayed(bVar.WD, 1000L);
            }
        }
    }

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aFX = cVar;
    }

    public void n(int i10, int i11) {
    }

    public abstract void onPlayStateChanged(int i10);

    public abstract void reset();

    public final void sA() {
        Runnable runnable = this.WD;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.WD = null;
        }
    }

    public abstract void st();

    public final void sz() {
        sA();
        if (this.WD == null) {
            this.WD = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.st();
                    if (b.this.WD != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.WD, 1000L);
                    }
                }
            };
        }
        post(this.WD);
    }
}
