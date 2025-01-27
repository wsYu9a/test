package com.sigmob.sdk.splash;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: classes4.dex */
public class h extends d {

    /* renamed from: b */
    public final com.sigmob.sdk.base.views.c f20331b;

    /* renamed from: c */
    public final BaseAdUnit f20332c;

    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            h.this.f20309a = mediaPlayer.getDuration() / 1000;
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.start();
            BaseBroadcastReceiver.a(h.this.getContext(), h.this.f20332c.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
            SigmobLog.i("video onPrepared");
        }
    }

    public h(Context context, BaseAdUnit baseAdUnit) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.c cVar = new com.sigmob.sdk.base.views.c(context);
        this.f20331b = cVar;
        setBackgroundColor(-16777216);
        this.f20332c = baseAdUnit;
        addView(cVar, layoutParams);
    }

    @Override // com.sigmob.sdk.splash.d
    public void b() {
        this.f20331b.c();
    }

    @Override // com.sigmob.sdk.splash.d
    public void c() {
        super.setVisibility(0);
        SigmobLog.i("video showAd");
        this.f20331b.setVisibility(0);
        this.f20331b.f();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 == 8) {
            try {
                if (this.f20331b != null) {
                    SigmobLog.i("video GONE");
                    this.f20331b.a();
                    removeAllViews();
                }
            } catch (Throwable th2) {
                SigmobLog.e("set splash ad video content error: " + th2.getMessage());
            }
        }
        super.setVisibility(i10);
    }

    @Override // com.sigmob.sdk.splash.d
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || baseAdUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        String splashFilePath = baseAdUnit.getSplashFilePath();
        this.f20331b.a(0, 0);
        this.f20331b.setOnPreparedListener(new a());
        this.f20331b.setVideoPath(splashFilePath);
        return true;
    }

    @Override // com.sigmob.sdk.splash.d
    public void a() {
        this.f20331b.b();
    }
}
