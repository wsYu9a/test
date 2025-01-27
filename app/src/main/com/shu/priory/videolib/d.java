package com.shu.priory.videolib;

import android.media.MediaPlayer;
import android.view.Surface;
import com.shu.priory.utils.h;
import java.util.Map;

/* loaded from: classes3.dex */
public class d extends b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: b */
    public MediaPlayer f17388b;

    /* renamed from: com.shu.priory.videolib.d$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().k();
            }
        }
    }

    /* renamed from: com.shu.priory.videolib.d$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().s();
            }
        }
    }

    /* renamed from: com.shu.priory.videolib.d$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f17391a;

        public AnonymousClass3(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().setBufferProgress(i10);
            }
        }
    }

    /* renamed from: com.shu.priory.videolib.d$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().H();
            }
        }
    }

    /* renamed from: com.shu.priory.videolib.d$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f17394a;

        /* renamed from: b */
        final /* synthetic */ int f17395b;

        public AnonymousClass5(int i10, int i11) {
            i10 = i10;
            i11 = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().a(i10, i11);
            }
        }
    }

    /* renamed from: com.shu.priory.videolib.d$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f17397a;

        public AnonymousClass6(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() == null || i10 != 3) {
                return;
            }
            f.c().k();
        }
    }

    /* renamed from: com.shu.priory.videolib.d$7 */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.c() != null) {
                f.c().z();
            }
        }
    }

    @Override // com.shu.priory.videolib.b
    public void a() {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.start();
            } catch (Throwable th2) {
                h.d("JZVideoPlayer", "media start" + th2.getMessage());
            }
        }
    }

    @Override // com.shu.priory.videolib.b
    public void b() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f17388b = mediaPlayer;
            mediaPlayer.setVolume(0.0f, 0.0f);
            this.f17388b.setAudioStreamType(3);
            this.f17388b.setLooping(this.f17375a.f17373f);
            this.f17388b.setOnPreparedListener(this);
            this.f17388b.setOnCompletionListener(this);
            this.f17388b.setOnBufferingUpdateListener(this);
            this.f17388b.setScreenOnWhilePlaying(true);
            this.f17388b.setOnSeekCompleteListener(this);
            this.f17388b.setOnErrorListener(this);
            this.f17388b.setOnInfoListener(this);
            this.f17388b.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.f17388b, this.f17375a.a().toString(), this.f17375a.f17372e);
            this.f17388b.prepareAsync();
        } catch (Throwable th2) {
            h.d("JZVideoPlayer", "media prepare:" + th2.getMessage());
        }
    }

    @Override // com.shu.priory.videolib.b
    public void c() {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.pause();
            } catch (Throwable th2) {
                h.d("JZVideoPlayer", "media pause:" + th2.getMessage());
            }
        }
    }

    @Override // com.shu.priory.videolib.b
    public void d() {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override // com.shu.priory.videolib.b
    public long e() {
        if (this.f17388b != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.shu.priory.videolib.b
    public long f() {
        if (this.f17388b != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.3

            /* renamed from: a */
            final /* synthetic */ int f17391a;

            public AnonymousClass3(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() != null) {
                    f.c().setBufferProgress(i10);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() != null) {
                    f.c().s();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.5

            /* renamed from: a */
            final /* synthetic */ int f17394a;

            /* renamed from: b */
            final /* synthetic */ int f17395b;

            public AnonymousClass5(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() != null) {
                    f.c().a(i10, i11);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.6

            /* renamed from: a */
            final /* synthetic */ int f17397a;

            public AnonymousClass6(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() == null || i10 != 3) {
                    return;
                }
                f.c().k();
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        String lowerCase = this.f17375a.a().toString().toLowerCase();
        if (lowerCase.contains("mp3") || lowerCase.contains("wav")) {
            c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (f.c() != null) {
                        f.c().k();
                    }
                }
            });
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() != null) {
                    f.c().H();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
        c.a().f17382g = i10;
        c.a().f17383h = i11;
        c.a().f17386k.post(new Runnable() { // from class: com.shu.priory.videolib.d.7
            public AnonymousClass7() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.c() != null) {
                    f.c().z();
                }
            }
        });
    }

    @Override // com.shu.priory.videolib.b
    public void a(long j10) {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo((int) j10);
            } catch (Throwable th2) {
                h.d("JZVideoPlayer", "media seek:" + th2.getMessage());
            }
        }
    }

    @Override // com.shu.priory.videolib.b
    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.shu.priory.videolib.b
    public void a(boolean z10) {
        MediaPlayer mediaPlayer = this.f17388b;
        if (mediaPlayer != null) {
            float f10 = z10 ? 0.0f : 1.0f;
            mediaPlayer.setVolume(f10, f10);
        }
    }
}
