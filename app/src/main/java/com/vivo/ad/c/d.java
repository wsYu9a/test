package com.vivo.ad.c;

import android.media.MediaPlayer;
import android.view.Surface;

/* loaded from: classes4.dex */
public class d extends com.vivo.ad.c.a {

    /* renamed from: d */
    private MediaPlayer f26596d;

    /* renamed from: e */
    private MediaPlayer.OnPreparedListener f26597e = new a();

    /* renamed from: f */
    private MediaPlayer.OnInfoListener f26598f = new b();

    /* renamed from: g */
    private MediaPlayer.OnErrorListener f26599g = new c();

    /* renamed from: h */
    private MediaPlayer.OnCompletionListener f26600h = new C0553d();

    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            com.vivo.ad.d.a.a aVar = d.this.f26580a;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }
    }

    class b implements MediaPlayer.OnInfoListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (i2 == 3) {
                com.vivo.ad.d.a.a aVar = d.this.f26580a;
                if (aVar == null) {
                    return false;
                }
                aVar.onInfo(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                return false;
            }
            switch (i2) {
                case 701:
                    com.vivo.ad.d.a.a aVar2 = d.this.f26580a;
                    if (aVar2 != null) {
                        aVar2.onLoading();
                        break;
                    }
                    break;
                case 702:
                    com.vivo.ad.d.a.a aVar3 = d.this.f26580a;
                    if (aVar3 != null) {
                        aVar3.onLoadEnd();
                        break;
                    }
                    break;
                case 703:
                    com.vivo.ad.d.a.a aVar4 = d.this.f26580a;
                    if (aVar4 != null) {
                        aVar4.onError(i2, i3);
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            com.vivo.ad.d.a.a aVar = d.this.f26580a;
            if (aVar == null) {
                return false;
            }
            aVar.onError(i2, i3);
            return false;
        }
    }

    /* renamed from: com.vivo.ad.c.d$d */
    class C0553d implements MediaPlayer.OnCompletionListener {
        C0553d() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.vivo.ad.d.a.a aVar = d.this.f26580a;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }
    }

    public d() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f26596d = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.f26597e);
        this.f26596d.setOnInfoListener(this.f26598f);
        this.f26596d.setOnErrorListener(this.f26599g);
        this.f26596d.setOnCompletionListener(this.f26600h);
    }

    @Override // com.vivo.ad.c.a
    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.f26596d;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.vivo.ad.c.a
    public long b() {
        if (this.f26596d == null) {
            return 0L;
        }
        try {
            return r0.getDuration();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.vivo.ad.c.a
    public void c() {
        MediaPlayer mediaPlayer = this.f26596d;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        com.vivo.ad.d.a.a aVar = this.f26580a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.vivo.ad.c.a
    public void d() {
        try {
            MediaPlayer mediaPlayer = this.f26596d;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(this.f26582c);
                this.f26596d.prepareAsync();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void e() {
        try {
            MediaPlayer mediaPlayer = this.f26596d;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f26596d.release();
                this.f26596d = null;
            }
            com.vivo.ad.d.a.a aVar = this.f26580a;
            if (aVar != null) {
                aVar.onRelease();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.c.a
    public void f() {
        MediaPlayer mediaPlayer = this.f26596d;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        com.vivo.ad.d.a.a aVar = this.f26580a;
        if (aVar != null) {
            aVar.onStart();
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(long j2) {
        MediaPlayer mediaPlayer = this.f26596d;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            if (j2 > 0) {
                this.f26596d.seekTo((int) j2);
            }
        }
        com.vivo.ad.d.a.a aVar = this.f26580a;
        if (aVar != null) {
            aVar.onStart();
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(String str) {
        this.f26582c = str;
    }

    @Override // com.vivo.ad.c.a
    public long a() {
        if (this.f26596d == null) {
            return 0L;
        }
        try {
            return r0.getCurrentPosition();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(float f2) {
        MediaPlayer mediaPlayer = this.f26596d;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f2);
        }
    }
}
