package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class b {
    private static boolean Wx = false;
    private static final AtomicInteger Wy = new AtomicInteger(0);
    private final String TAG;
    private com.kwad.sdk.core.video.a.c WA;
    private int WB;
    private long WC;
    private Runnable WD;
    private com.kwad.sdk.contentalliance.a.a.b WE;
    private int WF;
    private List<c.d> WG;
    private final AtomicBoolean WH;
    private boolean WI;
    private final int WJ;
    private volatile List<k> WK;
    private volatile List<com.kwad.components.core.video.a.c> WL;
    private volatile List<c.e> WM;
    private final c.f WN;
    private c.e WO;
    private c.i WP;
    private c.b WQ;
    private c.InterfaceC0500c WR;
    private c.d WS;
    private c.a WT;
    private int Wg;
    private int Wh;
    private volatile int Wz;

    /* renamed from: hf */
    private Handler f11940hf;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private long mStartTime;

    /* renamed from: com.kwad.components.core.video.b$1 */
    public class AnonymousClass1 implements c.f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.video.a.c.f
        public final void sB() {
            b.this.Wz = 1;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.Wz);
        }
    }

    /* renamed from: com.kwad.components.core.video.b$10 */
    public class AnonymousClass10 extends bd {
        final /* synthetic */ boolean WW;

        public AnonymousClass10(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.Wz));
            if (b.this.WA == null) {
                return;
            }
            try {
                synchronized (b.this.WA) {
                    b.this.aR(z10);
                }
            } finally {
                try {
                } finally {
                }
            }
            try {
                synchronized (b.this.WH) {
                    b.this.WH.notifyAll();
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$11 */
    public class AnonymousClass11 extends bd {
        final /* synthetic */ com.kwad.sdk.core.video.a.c WX;
        final /* synthetic */ a WY;

        public AnonymousClass11(com.kwad.sdk.core.video.a.c cVar, a aVar) {
            cVar = cVar;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.a(cVar, aVar);
        }
    }

    /* renamed from: com.kwad.components.core.video.b$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ int WV;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            for (k kVar : b.this.WK) {
                switch (i10) {
                    case -1:
                        b.this.setKeepScreenOn(false);
                        b.this.sA();
                        kVar.onMediaPlayError(b.this.Wg, b.this.Wh);
                        break;
                    case 1:
                        kVar.onMediaPreparing();
                        break;
                    case 2:
                        kVar.onMediaPrepared();
                        break;
                    case 3:
                        b.this.setKeepScreenOn(true);
                        kVar.onMediaPlayStart();
                        break;
                    case 4:
                        b.this.setKeepScreenOn(true);
                        kVar.onMediaPlaying();
                        break;
                    case 5:
                        b.this.setKeepScreenOn(false);
                        kVar.onMediaPlayPaused();
                        break;
                    case 6:
                        kVar.onVideoPlayBufferingPlaying();
                        break;
                    case 7:
                        kVar.onVideoPlayBufferingPaused();
                        break;
                    case 9:
                        if (b.this.WA != null && !b.this.WA.isLooping()) {
                            b.this.setKeepScreenOn(false);
                            b.this.sA();
                        }
                        kVar.onMediaPlayCompleted();
                        break;
                }
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.st();
            if (b.this.WD != null) {
                b.this.f11940hf.postDelayed(b.this.WD, 500L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$4 */
    public class AnonymousClass4 implements c.e {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.Wz) + "->STATE_PREPARED");
                b.this.Wz = 2;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Wz);
                Iterator it = b.this.WM.iterator();
                while (it.hasNext()) {
                    ((c.e) it.next()).a(b.this.WA);
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$5 */
    public class AnonymousClass5 implements c.i {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.video.a.c.i
        public final void k(int i10, int i11) {
            if (b.this.mDetailVideoView != null) {
                b.this.mDetailVideoView.adaptVideoSize(i10, i11);
            }
            com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i10 + "， height：" + i11);
        }
    }

    /* renamed from: com.kwad.components.core.video.b$6 */
    public class AnonymousClass6 implements c.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.video.a.c.b
        public final void pO() {
            b.this.Wz = 9;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.Wz);
            com.kwad.sdk.core.video.a.a.a.eH("videoFinishPlay");
        }
    }

    /* renamed from: com.kwad.components.core.video.b$7 */
    public class AnonymousClass7 implements c.InterfaceC0500c {
        public AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
        public final boolean l(int i10, int i11) {
            if (i10 == -38) {
                return true;
            }
            b.this.Wz = -1;
            b.this.Wg = i10;
            b.this.Wh = i11;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.Wz);
            com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i10 + ", extra: " + i11);
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.video.b$8 */
    public class AnonymousClass8 implements c.d {
        public AnonymousClass8() {
        }

        @Override // com.kwad.sdk.core.video.a.c.d
        public final boolean m(int i10, int i11) {
            if (i10 == 3) {
                b.this.Wz = 4;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Wz);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.Wz) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
            } else if (i10 == 701) {
                if (b.this.Wz == 5 || b.this.Wz == 7) {
                    b.this.Wz = 7;
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                } else {
                    b.this.Wz = 6;
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                }
                b bVar2 = b.this;
                bVar2.onPlayStateChanged(bVar2.Wz);
            } else if (i10 == 702) {
                if (b.this.Wz == 6) {
                    b.this.Wz = 4;
                    b bVar3 = b.this;
                    bVar3.onPlayStateChanged(bVar3.Wz);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                }
                if (b.this.Wz == 7) {
                    b.this.Wz = 5;
                    b bVar4 = b.this;
                    bVar4.onPlayStateChanged(bVar4.Wz);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                }
            } else if (i10 != 10001) {
                if (i10 == 801) {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                } else {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i10);
                }
            }
            b bVar5 = b.this;
            bVar5.a(bVar5.WA, i10, i11);
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.video.b$9 */
    public class AnonymousClass9 implements c.a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.video.a.c.a
        public final void aw(int i10) {
            b.this.WB = i10;
        }
    }

    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private void aN(int i10) {
        for (com.kwad.components.core.video.a.c cVar : this.WL) {
            if (i10 == 0) {
                cVar.onStart();
            } else if (i10 == 1) {
                cVar.onReset();
            } else if (i10 == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
            }
        }
    }

    private void aQ(boolean z10) {
        if (this.WA == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "start prepareAsync");
        if (this.WI) {
            if (this.WH.compareAndSet(false, true)) {
                com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.video.b.10
                    final /* synthetic */ boolean WW;

                    public AnonymousClass10(boolean z102) {
                        z10 = z102;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.Wz));
                        if (b.this.WA == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.WA) {
                                b.this.aR(z10);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.WH) {
                                b.this.WH.notifyAll();
                            }
                        } catch (Exception e10) {
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            aR(z102);
        } catch (Throwable th2) {
            if (getMediaPlayerType() != 2) {
                int i10 = this.WF;
                this.WF = i10 + 1;
                if (i10 <= 4) {
                    sy();
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.Wz));
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public void aR(boolean z10) {
        a(this.WE);
        boolean HO = z10 ? this.WA.HO() : this.WA.prepareAsync();
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync forcePrepare: " + z10 + ", result: " + HO);
    }

    public static String getStateString(int i10) {
        switch (i10) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    private void reset() {
        com.kwad.sdk.core.d.c.i(this.TAG, "reset:" + getStateString(this.Wz) + "->STATE_IDLE");
        aN(1);
        this.WA.reset();
        this.Wz = 0;
    }

    public void sA() {
        Runnable runnable = this.WD;
        if (runnable != null) {
            this.f11940hf.removeCallbacks(runnable);
            this.WD = null;
        }
    }

    public void setKeepScreenOn(boolean z10) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z10);
        }
    }

    private void setPlayType(int i10) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.WE;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i10;
    }

    public void st() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.WK != null) {
            Iterator<k> it = this.WK.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void sw() {
        this.WA.a(this.WN);
        this.WA.b(this.WO);
        this.WA.a(this.WP);
        this.WA.a(this.WQ);
        this.WA.a(this.WR);
        this.WA.c(this.WS);
        this.WA.a(this.WT);
    }

    private void sx() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0500c) null);
        this.WA.a((c.b) null);
        this.WA.b(null);
        this.WA.a((c.i) null);
        this.WA.c(null);
        this.WA.a((c.g) null);
        this.WA.a((c.a) null);
    }

    private void sz() {
        sA();
        if (this.WD == null) {
            this.WD = new bd() { // from class: com.kwad.components.core.video.b.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.this.st();
                    if (b.this.WD != null) {
                        b.this.f11940hf.postDelayed(b.this.WD, 500L);
                    }
                }
            };
        }
        this.f11940hf.post(this.WD);
    }

    public final void clear() {
        this.WK.clear();
        this.WL.clear();
    }

    public final int getBufferPercentage() {
        return this.WB;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.Wz == 2 || this.Wz == 3 || this.Wz == 5 || this.Wz == 8 || this.Wz == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.Wz == 1;
    }

    public final void onPlayStateChanged(int i10) {
        if (this.WK == null) {
            return;
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.video.b.2
            final /* synthetic */ int WV;

            public AnonymousClass2(int i102) {
                i10 = i102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                for (k kVar : b.this.WK) {
                    switch (i10) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.sA();
                            kVar.onMediaPlayError(b.this.Wg, b.this.Wh);
                            break;
                        case 1:
                            kVar.onMediaPreparing();
                            break;
                        case 2:
                            kVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            kVar.onMediaPlayPaused();
                            break;
                        case 6:
                            kVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            kVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.WA != null && !b.this.WA.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.sA();
                            }
                            kVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z10;
        com.kwad.sdk.core.d.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.Wz));
        if (this.Wz == 4) {
            this.WA.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.Wz = 5;
            onPlayStateChanged(this.Wz);
            com.kwad.sdk.core.video.a.a.a.eH("videoPausePlay");
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.Wz == 6) {
            this.WA.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.Wz = 7;
            onPlayStateChanged(this.Wz);
            z10 = true;
        }
        if (this.Wz == 3) {
            this.WA.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.Wz = 5;
            onPlayStateChanged(this.Wz);
            com.kwad.sdk.core.video.a.a.a.eH("videoPausePlay");
            z10 = true;
        }
        if (this.Wz != 9 || !this.WA.isLooping()) {
            return z10;
        }
        this.WA.pause();
        com.kwad.sdk.core.d.c.i(this.TAG, "pause " + getStateString(this.Wz) + "->STATE_PAUSED");
        this.Wz = 5;
        onPlayStateChanged(this.Wz);
        return true;
    }

    public final void prepareAsync() {
        aQ(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void restart() {
        if (this.WA != null && this.Wz == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.WA == null) {
                com.kwad.sdk.core.d.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume state: " + getStateString(this.Wz));
            if (this.Wz != 2 && this.Wz != 3 && this.Wz != 0) {
                if (this.Wz == 5) {
                    this.WA.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Wz) + "->STATE_PLAYING");
                    this.Wz = 4;
                    onPlayStateChanged(this.Wz);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.eH("videoResumePlay");
                    return;
                }
                if (this.Wz != 7) {
                    if (this.Wz != 1) {
                        com.kwad.sdk.core.d.c.w(this.TAG, "resume: " + getStateString(this.Wz) + " 此时不能调用resume()方法.");
                        return;
                    }
                    return;
                }
                this.WA.start();
                com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Wz) + "->STATE_BUFFERING_PLAYING");
                this.Wz = 6;
                onPlayStateChanged(this.Wz);
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Wz) + "->start()");
            start();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final void seekTo(long j10) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            cVar.seekTo(j10);
        }
    }

    public final void setAudioEnabled(boolean z10) {
        if (z10) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setRadius(float f10, float f11, float f12, float f13) {
        this.mDetailVideoView.setRadius(f10, f11, f12, f13);
    }

    public final void setSpeed(float f10) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f10);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f10, float f11) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f10, f11);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    public final void start() {
        try {
            if (this.WA == null) {
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start state: " + getStateString(this.Wz));
            aN(0);
            if (this.Wz == 0) {
                com.kwad.sdk.core.d.c.i(this.TAG, "start still not prepared well forcePrepare");
                aQ(true);
                return;
            }
            if (this.Wz != 2 && this.Wz != 9) {
                if (this.Wz == 3) {
                    this.WA.start();
                    return;
                }
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            this.WA.start();
            com.kwad.sdk.core.video.a.a.a.eH("videoStartPlay");
            if (this.WC != 0) {
                this.WA.seekTo((int) r5);
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start:" + getStateString(this.Wz) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.WE;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.Wz == 2) {
                    if (this.WE.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.Wz == 9) {
                    setPlayType(3);
                }
            }
            this.Wz = 3;
            onPlayStateChanged(this.Wz);
            sz();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.Wz));
        if (this.Wz == 1 || this.Wz == 2) {
            return;
        }
        if (this.Wz == 3 || this.Wz == 4 || this.Wz == 5 || this.Wz == 6 || this.Wz == 7 || this.Wz == 8 || this.Wz == 9) {
            try {
                this.WA.stop();
                this.Wz = 8;
                onPlayStateChanged(this.Wz);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    public final com.kwad.sdk.core.video.a.c sv() {
        return this.WA;
    }

    public final void sy() {
        if (this.WA == null) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.Wz == 2 || this.Wz == 3 || this.Wz == 4 || this.Wz == 5) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "can not resetAndPlay in state:");
            return;
        }
        reset();
        sx();
        sw();
        prepareAsync();
    }

    private b(@Nullable DetailVideoView detailVideoView, int i10) {
        this.Wz = 0;
        this.f11940hf = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.WF = 0;
        this.WG = new CopyOnWriteArrayList();
        this.WH = new AtomicBoolean(false);
        this.WI = false;
        this.WK = new CopyOnWriteArrayList();
        this.WL = new CopyOnWriteArrayList();
        this.WM = new CopyOnWriteArrayList();
        this.WN = new c.f() { // from class: com.kwad.components.core.video.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.video.a.c.f
            public final void sB() {
                b.this.Wz = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Wz);
            }
        };
        this.WO = new c.e() { // from class: com.kwad.components.core.video.b.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.Wz) + "->STATE_PREPARED");
                    b.this.Wz = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Wz);
                    Iterator it = b.this.WM.iterator();
                    while (it.hasNext()) {
                        ((c.e) it.next()).a(b.this.WA);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        };
        this.WP = new c.i() { // from class: com.kwad.components.core.video.b.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i102, int i11) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i102, i11);
                }
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i102 + "， height：" + i11);
            }
        };
        this.WQ = new c.b() { // from class: com.kwad.components.core.video.b.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.core.video.a.c.b
            public final void pO() {
                b.this.Wz = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Wz);
                com.kwad.sdk.core.video.a.a.a.eH("videoFinishPlay");
            }
        };
        this.WR = new c.InterfaceC0500c() { // from class: com.kwad.components.core.video.b.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0500c
            public final boolean l(int i102, int i11) {
                if (i102 == -38) {
                    return true;
                }
                b.this.Wz = -1;
                b.this.Wg = i102;
                b.this.Wh = i11;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Wz);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i102 + ", extra: " + i11);
                return true;
            }
        };
        this.WS = new c.d() { // from class: com.kwad.components.core.video.b.8
            public AnonymousClass8() {
            }

            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i102, int i11) {
                if (i102 == 3) {
                    b.this.Wz = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Wz);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.Wz) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i102 == 701) {
                    if (b.this.Wz == 5 || b.this.Wz == 7) {
                        b.this.Wz = 7;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.Wz = 6;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.Wz);
                } else if (i102 == 702) {
                    if (b.this.Wz == 6) {
                        b.this.Wz = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.Wz);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.Wz == 7) {
                        b.this.Wz = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.Wz);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i102 != 10001) {
                    if (i102 == 801) {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i102);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.WA, i102, i11);
                return true;
            }
        };
        this.WT = new c.a() { // from class: com.kwad.components.core.video.b.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aw(int i102) {
                b.this.WB = i102;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.WJ = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.d.c.i(str, "create DetailMediaPlayerImpl");
    }

    public final void c(k kVar) {
        this.WK.add(kVar);
    }

    public final void d(k kVar) {
        this.WK.remove(kVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.WG.remove(dVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z10, boolean z11, @NonNull DetailVideoView detailVideoView) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z10);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.a.c a10 = com.kwad.sdk.core.video.a.e.a(this.mContext, z10, com.kwad.sdk.core.config.d.zz(), com.kwad.sdk.core.config.d.zA(), this.WJ);
        a10.setLooping(false);
        a(bVar, z11, detailVideoView, a10);
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z10, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + this.WA);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.WI = z10;
        this.WE = bVar;
        com.kwad.components.core.video.a.a a10 = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl);
        c(a10);
        a(a10);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.WA != cVar) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.WA;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                sx();
                this.WA.release();
            }
            this.WA = cVar;
            reset();
            sw();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            sx();
            sw();
        }
        this.WA.setSurface(detailVideoView.Xc);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j10) {
        this.WC = j10;
        start();
    }

    public final void a(c.e eVar) {
        this.WM.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.WG.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i10, int i11) {
        Iterator<c.d> it = this.WG.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.m(i10, i11);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.WA.a(bVar);
                return;
            }
            com.kwad.sdk.core.d.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    public final void a(a aVar, boolean z10) {
        if (this.WA == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "release:" + getStateString(this.Wz) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.f11940hf.removeCallbacksAndMessages(null);
        sA();
        sx();
        this.mDetailVideoView = null;
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar != null) {
            if (z10) {
                com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.video.b.11
                    final /* synthetic */ com.kwad.sdk.core.video.a.c WX;
                    final /* synthetic */ a WY;

                    public AnonymousClass11(com.kwad.sdk.core.video.a.c cVar2, a aVar2) {
                        cVar = cVar2;
                        aVar = aVar2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar2, aVar2);
            }
            this.WA = null;
        }
        this.Wz = 0;
        this.WF = 0;
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.Wz) + "->STATE_IDLE");
        try {
            aN(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.WL.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.WA;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}
