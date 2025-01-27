package com.sigmob.sdk.base.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;

/* loaded from: classes4.dex */
public class c extends RelativeLayout implements SurfaceHolder.Callback, MediaPlayer.OnBufferingUpdateListener {

    /* renamed from: a */
    public MediaPlayer f18483a;

    /* renamed from: b */
    public SurfaceHolder f18484b;

    /* renamed from: c */
    public SurfaceView f18485c;

    /* renamed from: d */
    public String f18486d;

    /* renamed from: e */
    public int f18487e;

    /* renamed from: f */
    public int f18488f;

    /* renamed from: g */
    public int f18489g;

    public c(Context context) {
        super(context);
        this.f18483a = null;
        this.f18486d = "";
        SurfaceView surfaceView = new SurfaceView(context);
        this.f18485c = surfaceView;
        addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        SurfaceHolder holder = this.f18485c.getHolder();
        this.f18484b = holder;
        holder.addCallback(this);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f18483a = mediaPlayer;
        mediaPlayer.setLooping(true);
        this.f18483a.setOnBufferingUpdateListener(this);
    }

    public void a(boolean z10) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            float f10 = !z10 ? 1 : 0;
            mediaPlayer.setVolume(f10, f10);
        }
    }

    public void b() {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f18483a.pause();
        this.f18489g = this.f18483a.getCurrentPosition();
    }

    public void c() {
        if (this.f18483a != null) {
            if (r0.getCurrentPosition() == 0) {
                this.f18483a.seekTo(this.f18489g);
            }
            this.f18483a.start();
        }
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public final void e() {
        try {
            this.f18483a.reset();
            this.f18483a.setDataSource(this.f18486d);
            this.f18483a.prepareAsync();
        } catch (IOException e10) {
            SigmobLog.e(e10.getMessage());
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void g() {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int defaultSize = View.getDefaultSize(0, i10);
        int defaultSize2 = View.getDefaultSize(0, i11);
        int i12 = this.f18488f;
        int i13 = this.f18487e;
        if (defaultSize2 > defaultSize) {
            if (i12 <= i13) {
                defaultSize2 = (int) (defaultSize * (i12 / i13));
            }
        } else if (i12 > i13) {
            defaultSize = (int) (defaultSize2 * (i13 / i12));
        }
        int i14 = this.f18488f;
        if (i14 != this.f18487e) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else if (i14 == -1) {
            setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        } else {
            super.onMeasure(i10, i11);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f18483a.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setVideoPath(String str) {
        this.f18486d = str;
        e();
    }

    public void setVolume(int i10) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            float f10 = i10;
            mediaPlayer.setVolume(f10, f10);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f18483a.stop();
        this.f18483a.reset();
        this.f18483a.release();
        this.f18483a = null;
    }

    public void a() {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f18483a.reset();
            this.f18483a.release();
            this.f18483a = null;
        }
    }

    public void a(int i10) {
        MediaPlayer mediaPlayer = this.f18483a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i10);
        }
    }

    public void a(int i10, int i11) {
        this.f18487e = i10;
        this.f18488f = i11;
    }
}
