package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aFF = false;
    private static final Queue<d> aFG = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b WE;
    private final KSVodPlayerWrapper aFB;
    private final a aFC;
    private boolean aFD;
    private boolean aFE;
    private boolean aFH;
    private String aFw;
    private MediaDataSource aFx;
    private final Object aFy;
    private boolean aFz;
    private int mSarDen;
    private int mSarNum;

    /* renamed from: com.kwad.sdk.core.video.a.d$1 */
    public class AnonymousClass1 implements IKSVodPlayer.OnVodPlayerReleaseListener {
        public AnonymousClass1() {
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
        }
    }

    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d HT() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i10) {
            d HT = HT();
            if (HT != null) {
                HT.notifyOnBufferingUpdate(i10);
            }
        }

        public final void onError(int i10, int i11) {
            d HT = HT();
            if (HT != null) {
                d.a(HT, false);
                HT.notifyOnError(i10, i11);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i10, int i11) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i10);
            try {
                d HT = HT();
                if (HT != null) {
                    if (i10 == 10100) {
                        HT.notifyOnSeekComplete();
                    } else {
                        if (i10 == 10101) {
                            HT.notifyOnCompletion();
                            return;
                        }
                        if (i10 == 10209) {
                            HT.HS();
                        }
                        HT.notifyOnInfo(i10, i11);
                    }
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d HT = HT();
            if (HT != null) {
                HT.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i10, int i11, int i12, int i13) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onVideoSizeChanged width: " + i10 + ", height: " + i11 + ", sarNum:" + i12 + ", sarDen:" + i13);
            d HT = HT();
            if (HT != null) {
                HT.w(i10, i11);
                HT.mSarNum = i12;
                HT.mSarDen = i13;
            }
        }
    }

    public d(int i10) {
        Object obj = new Object();
        this.aFy = obj;
        this.aFE = false;
        this.aFH = true;
        synchronized (obj) {
            this.aFB = new KSVodPlayerWrapper(m.Qa());
        }
        String str = "KSMediaPlayer[" + i10 + "]";
        this.TAG = str;
        this.aFC = new a(this, str);
        HP();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(str, "create KwaiMediaPlayer");
    }

    private void HN() {
        MediaDataSource mediaDataSource = this.aFx;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.aFx = null;
        }
    }

    private void HP() {
        this.aFB.setOnPreparedListener(this.aFC);
        this.aFB.setBufferingUpdateListener(this.aFC);
        this.aFB.setOnEventListener(this.aFC);
        this.aFB.setVideoSizeChangedListener(this.aFC);
        this.aFB.setOnErrorListener(this.aFC);
    }

    private void HQ() {
        this.aFB.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aFB.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aFB.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aFB.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aFB.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void HR() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aFE);
        if (this.aFE) {
            return;
        }
        try {
            this.aFE = true;
            int prepareAsync = this.aFB.prepareAsync();
            HM();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e10) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e10);
        }
    }

    public void HS() {
        Iterator<d> it = aFG.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i10++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i10);
        int i11 = i10 + 1;
        if (i11 < aFG.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i12 = 0; i12 < i11; i12++) {
                aFG.poll();
            }
            Queue<d> queue = aFG;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean HO() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        HR();
        return true;
    }

    public final void bq(boolean z10) {
        this.aFH = z10;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aFB.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aFB;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aFB.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aFw;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aFB.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aFB.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aFB.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aFD;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aFB.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aFB.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (!this.aFH) {
            HR();
            return true;
        }
        Queue<d> queue = aFG;
        if (!queue.contains(this)) {
            queue.offer(this);
        }
        int size = queue.size();
        if (size == 1) {
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
            HR();
            return true;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aFG;
        boolean remove = queue.remove(this);
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aFz = true;
        this.aFB.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public AnonymousClass1() {
            }

            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            HN();
            resetListeners();
            HQ();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aFE = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aFB.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        HN();
        resetListeners();
        HP();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j10) {
        this.aFB.seekTo((int) j10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i10) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aFy) {
            try {
                if (!this.aFz) {
                    this.aFB.setDisplay(surfaceHolder);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z10) {
        this.aFD = z10;
        this.aFB.setLooping(z10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z10) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f10) {
        this.aFB.setSpeed(f10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aFB.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f10, float f11) {
        this.aFB.setVolume(f10, f11);
        com.kwad.sdk.core.video.a.a.h(f10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, "start");
        this.aFB.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aFB.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.aFE = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.WE = bVar;
        a(bVar.asp);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.uJ()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aFw = str;
        this.aFB.setDataSource(str, (Map) null);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aFB == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.Cy();
        this.aFB.updateVideoContext(kSVodVideoContext);
    }
}
