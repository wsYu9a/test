package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bx;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements bx.a {
    private bx bO;

    /* renamed from: ia */
    private l f11512ia = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.ix) {
                return;
            }
            a.this.bO.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (!a.this.rO.f11689qf.kh()) {
                a.this.a(j10, j11);
                a.this.iy = j11;
            } else if (j11 > 800) {
                a.this.iy = j11;
                if (a.this.iy > j10) {
                    a.this.iv.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.iw.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.iw.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j10, j11);
                a.a(a.this, true);
            }
        }
    };
    private TextView iv;
    private View iw;
    private boolean ix;
    private long iy;
    private AdInfo mAdInfo;

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.ix) {
                return;
            }
            a.this.bO.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (!a.this.rO.f11689qf.kh()) {
                a.this.a(j10, j11);
                a.this.iy = j11;
            } else if (j11 > 800) {
                a.this.iy = j11;
                if (a.this.iy > j10) {
                    a.this.iv.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.iw.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.iw.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j10, j11);
                a.a(a.this, true);
            }
        }
    }

    private void cw() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        this.mAdInfo = eb2;
        this.iv.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(eb2)));
        this.iv.setVisibility(0);
        this.rO.f11689qf.a(this.f11512ia);
    }

    private void x(int i10) {
        this.iv.setText(String.valueOf(i10));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.bO = new bx(this);
        cw();
        if (this.rO.f11689qf.kh()) {
            x(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.iv = (TextView) findViewById(R.id.ksad_video_count_down);
        this.iw = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11512ia);
        this.ix = false;
        this.bO.removeCallbacksAndMessages(null);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.ix = true;
        return true;
    }

    public void a(long j10, long j11) {
        int i10 = (int) (((j10 - j11) / 1000.0f) + 0.5f);
        if (i10 <= 0) {
            i10 = 1;
        }
        x(i10);
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.rO.gg() && !this.rO.gf()) {
                long j10 = this.iy + 500;
                this.iy = j10;
                if (j10 > 30000) {
                    this.iv.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iw.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
                    this.iw.setLayoutParams(marginLayoutParams);
                    return;
                }
                a(30000L, j10);
                this.bO.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.bO.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
