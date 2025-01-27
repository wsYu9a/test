package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class b {
    private static boolean QB = false;
    private static final AtomicInteger QC = new AtomicInteger(0);
    private com.kwad.sdk.core.video.kwai.c QE;
    private int QF;
    private long QG;
    private Runnable QH;
    private com.kwad.sdk.contentalliance.kwai.kwai.b QI;
    private int Qm;
    private int Qn;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private String TAG = "MediaPlayerImpl";
    private volatile int QD = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private long mStartTime = 0;
    private int QJ = 0;
    private List<c.d> QK = new CopyOnWriteArrayList();
    private final AtomicBoolean QL = new AtomicBoolean(false);
    private boolean QM = false;
    private volatile List<i> QN = new CopyOnWriteArrayList();
    private volatile List<c.e> QO = new CopyOnWriteArrayList();
    private c.e QP = new c.e() { // from class: com.kwad.components.core.video.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.QD) + "->STATE_PREPARED");
            b.this.QD = 2;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            Iterator it = b.this.QO.iterator();
            while (it.hasNext()) {
                ((c.e) it.next()).a(b.this.QE);
            }
        }
    };
    private c.h QQ = new c.h() { // from class: com.kwad.components.core.video.b.3
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.h
        public final void i(int i2, int i3) {
            if (b.this.mDetailVideoView != null) {
                b.this.mDetailVideoView.adaptVideoSize(i2, i3);
            }
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
        }
    };
    private c.b QR = new c.b() { // from class: com.kwad.components.core.video.b.4
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.b
        public final void nU() {
            b.this.QD = 9;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoFinishPlay");
        }
    };
    private c.InterfaceC0220c QS = new c.InterfaceC0220c() { // from class: com.kwad.components.core.video.b.5
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0220c
        public final boolean j(int i2, int i3) {
            if (i2 == -38) {
                return true;
            }
            b.this.QD = -1;
            b.this.Qm = i2;
            b.this.Qn = i3;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPlayError");
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
            return true;
        }
    };
    private c.d QT = new c.d() { // from class: com.kwad.components.core.video.b.6
        AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.d
        public final boolean k(int i2, int i3) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i2 != 3) {
                if (i2 == 701) {
                    if (b.this.QD == 5 || b.this.QD == 7) {
                        b.this.QD = 7;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.QD = 6;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.b.i(str3, str4);
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.QD);
                } else if (i2 == 702) {
                    if (b.this.QD == 6) {
                        b.this.QD = 4;
                        b bVar2 = b.this;
                        bVar2.onPlayStateChanged(bVar2.QD);
                        com.kwad.sdk.core.d.b.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.QD == 7) {
                        b.this.QD = 5;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.QD);
                        str = b.this.TAG;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        str = b.this.TAG;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    } else {
                        str = b.this.TAG;
                        sb = new StringBuilder("onInfo ——> what：");
                        sb.append(i2);
                    }
                }
                b bVar4 = b.this;
                bVar4.a(bVar4.QE, i2, i3);
                return true;
            }
            b.this.QD = 4;
            b bVar5 = b.this;
            bVar5.onPlayStateChanged(bVar5.QD);
            str = b.this.TAG;
            sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - b.this.mStartTime);
            str2 = sb.toString();
            com.kwad.sdk.core.d.b.i(str, str2);
            b bVar42 = b.this;
            bVar42.a(bVar42.QE, i2, i3);
            return true;
        }
    };
    private c.a QU = new c.a() { // from class: com.kwad.components.core.video.b.7
        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.a
        public final void ax(int i2) {
            b.this.QF = i2;
        }
    };

    /* renamed from: com.kwad.components.core.video.b$1 */
    final class AnonymousClass1 implements c.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.QD) + "->STATE_PREPARED");
            b.this.QD = 2;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            Iterator it = b.this.QO.iterator();
            while (it.hasNext()) {
                ((c.e) it.next()).a(b.this.QE);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$10 */
    final class AnonymousClass10 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.video.kwai.c QX;
        final /* synthetic */ a QY;

        AnonymousClass10(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
            cVar = cVar;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = b.this;
            b.a(cVar, aVar);
        }
    }

    /* renamed from: com.kwad.components.core.video.b$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.qc();
            if (b.this.QH != null) {
                b.this.mHandler.postDelayed(b.this.QH, 500L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$3 */
    final class AnonymousClass3 implements c.h {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.h
        public final void i(int i2, int i3) {
            if (b.this.mDetailVideoView != null) {
                b.this.mDetailVideoView.adaptVideoSize(i2, i3);
            }
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
        }
    }

    /* renamed from: com.kwad.components.core.video.b$4 */
    final class AnonymousClass4 implements c.b {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.b
        public final void nU() {
            b.this.QD = 9;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoFinishPlay");
        }
    }

    /* renamed from: com.kwad.components.core.video.b$5 */
    final class AnonymousClass5 implements c.InterfaceC0220c {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0220c
        public final boolean j(int i2, int i3) {
            if (i2 == -38) {
                return true;
            }
            b.this.QD = -1;
            b.this.Qm = i2;
            b.this.Qn = i3;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPlayError");
            com.kwad.sdk.core.d.b.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.video.b$6 */
    final class AnonymousClass6 implements c.d {
        AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.d
        public final boolean k(int i2, int i3) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i2 != 3) {
                if (i2 == 701) {
                    if (b.this.QD == 5 || b.this.QD == 7) {
                        b.this.QD = 7;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.QD = 6;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.b.i(str3, str4);
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.QD);
                } else if (i2 == 702) {
                    if (b.this.QD == 6) {
                        b.this.QD = 4;
                        b bVar2 = b.this;
                        bVar2.onPlayStateChanged(bVar2.QD);
                        com.kwad.sdk.core.d.b.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.QD == 7) {
                        b.this.QD = 5;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.QD);
                        str = b.this.TAG;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        str = b.this.TAG;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.b.i(str, str2);
                    } else {
                        str = b.this.TAG;
                        sb = new StringBuilder("onInfo ——> what：");
                        sb.append(i2);
                    }
                }
                b bVar42 = b.this;
                bVar42.a(bVar42.QE, i2, i3);
                return true;
            }
            b.this.QD = 4;
            b bVar5 = b.this;
            bVar5.onPlayStateChanged(bVar5.QD);
            str = b.this.TAG;
            sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - b.this.mStartTime);
            str2 = sb.toString();
            com.kwad.sdk.core.d.b.i(str, str2);
            b bVar422 = b.this;
            bVar422.a(bVar422.QE, i2, i3);
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.video.b$7 */
    final class AnonymousClass7 implements c.a {
        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.a
        public final void ax(int i2) {
            b.this.QF = i2;
        }
    }

    /* renamed from: com.kwad.components.core.video.b$8 */
    final class AnonymousClass8 implements Runnable {

        /* renamed from: com.kwad.components.core.video.b$8$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.QD);
            }
        }

        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean prepareAsync;
            com.kwad.sdk.core.d.b.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.QD));
            if (b.this.QE == null) {
                return;
            }
            try {
                synchronized (b.this.QE) {
                    b bVar = b.this;
                    bVar.a(bVar.QI);
                    prepareAsync = b.this.QE.prepareAsync();
                    com.kwad.sdk.core.d.b.i(b.this.TAG, "prepareAsync:" + b.getStateString(b.this.QD) + "->STATE_PREPARING, success: " + prepareAsync);
                    b.this.QD = 1;
                }
                if (prepareAsync) {
                    b.this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.video.b.8.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b bVar2 = b.this;
                            bVar2.onPlayStateChanged(bVar2.QD);
                        }
                    });
                } else {
                    com.kwad.sdk.core.d.b.e(b.this.TAG, "prepareAsync failed");
                }
            } finally {
                try {
                } finally {
                }
            }
            try {
                synchronized (b.this.QL) {
                    b.this.QL.notifyAll();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.b$9 */
    final class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.QL.get()) {
                try {
                    synchronized (b.this.QL) {
                        b.this.QL.wait(5000L);
                    }
                } catch (InterruptedException e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
            }
            if (b.this.getMediaPlayerType() == 2) {
                b.this.QE.start();
                com.kwad.sdk.core.video.kwai.kwai.a.cN("videoStartPlay");
            }
        }
    }

    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer");
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.QM = z;
        this.QI = bVar;
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.QE != cVar) {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.kwai.c cVar2 = this.QE;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                qg();
                this.QE.release();
            }
            this.QE = cVar;
            reset();
            qf();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            qg();
            qf();
        }
        this.QE.setSurface(detailVideoView.Rc);
    }

    public static void a(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public static String getStateString(int i2) {
        switch (i2) {
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

    public void qc() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.QN != null) {
            Iterator<i> it = this.QN.iterator();
            while (it.hasNext()) {
                it.next().onVideoPlayProgress(duration, currentPosition);
            }
        }
    }

    private void qf() {
        this.QE.b(this.QP);
        this.QE.a(this.QQ);
        this.QE.a(this.QR);
        this.QE.a(this.QS);
        this.QE.c(this.QT);
        this.QE.a(this.QU);
    }

    private void qg() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0220c) null);
        this.QE.a((c.b) null);
        this.QE.b(null);
        this.QE.a((c.h) null);
        this.QE.c(null);
        this.QE.a((c.f) null);
        this.QE.a((c.a) null);
    }

    private void qi() {
        qj();
        if (this.QH == null) {
            this.QH = new Runnable() { // from class: com.kwad.components.core.video.b.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.qc();
                    if (b.this.QH != null) {
                        b.this.mHandler.postDelayed(b.this.QH, 500L);
                    }
                }
            };
        }
        this.mHandler.post(this.QH);
    }

    private void qj() {
        Runnable runnable = this.QH;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.QH = null;
        }
    }

    private void reset() {
        com.kwad.sdk.core.d.b.i(this.TAG, "reset:" + getStateString(this.QD) + "->STATE_IDLE");
        this.QE.reset();
        this.QD = 0;
    }

    private void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i2) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.QI;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void a(a aVar, boolean z) {
        if (this.QE == null) {
            return;
        }
        setKeepScreenOn(false);
        this.mHandler.removeCallbacksAndMessages(null);
        qj();
        qg();
        this.mDetailVideoView = null;
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.10
                    final /* synthetic */ com.kwad.sdk.core.video.kwai.c QX;
                    final /* synthetic */ a QY;

                    AnonymousClass10(com.kwad.sdk.core.video.kwai.c cVar2, a aVar2) {
                        cVar = cVar2;
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar = b.this;
                        b.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar2, aVar2);
            }
            this.QE = null;
        }
        com.kwad.sdk.core.d.b.i(this.TAG, "release:" + getStateString(this.QD) + "->STATE_IDLE");
        this.QD = 0;
        this.QJ = 0;
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
            ((com.kwad.sdk.core.video.kwai.d) cVar).a(aVar);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        try {
            if (TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.b.e(this.TAG, "videoUrl is null");
                return;
            }
            com.kwad.sdk.core.d.b.d(this.TAG, "videoUrl=" + bVar.videoUrl);
            this.QE.a(bVar);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        com.kwad.sdk.core.d.b.i(this.TAG, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.kwai.c a2 = com.kwad.sdk.core.video.kwai.e.a(this.mContext, z, com.kwad.sdk.core.config.d.sv(), com.kwad.sdk.core.config.d.sw());
        a2.setLooping(false);
        a(bVar, z2, detailVideoView, a2);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.QK.add(dVar);
    }

    public final void a(c.e eVar) {
        this.QO.add(eVar);
    }

    public final void a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
        Iterator<c.d> it = this.QK.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.k(i2, i3);
            }
        }
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.QK.remove(dVar);
    }

    public final void c(i iVar) {
        this.QN.add(iVar);
    }

    public final void clear() {
        this.QN.clear();
    }

    public final void d(i iVar) {
        this.QN.remove(iVar);
    }

    public final int getBufferPercentage() {
        return this.QF;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        return this.QD == 2 || this.QD == 3 || this.QD == 5 || this.QD == 8 || this.QD == 9;
    }

    public final boolean isPreparing() {
        return this.QD == 1;
    }

    public final void onPlayStateChanged(int i2) {
        if (this.QN == null) {
            return;
        }
        for (i iVar : this.QN) {
            if (iVar != null) {
                switch (i2) {
                    case -1:
                        setKeepScreenOn(false);
                        qj();
                        iVar.onVideoPlayError(this.Qm, this.Qn);
                        break;
                    case 1:
                        iVar.onVideoPreparing();
                        break;
                    case 2:
                        iVar.onVideoPrepared();
                        break;
                    case 3:
                        setKeepScreenOn(true);
                        iVar.onVideoPlayStart();
                        break;
                    case 4:
                        setKeepScreenOn(true);
                        iVar.onVideoPlaying();
                        break;
                    case 5:
                        setKeepScreenOn(false);
                        iVar.onVideoPlayPaused();
                        break;
                    case 6:
                        iVar.onVideoPlayBufferingPlaying();
                        break;
                    case 7:
                        iVar.onVideoPlayBufferingPaused();
                        break;
                    case 9:
                        try {
                            com.kwad.sdk.core.video.kwai.c cVar = this.QE;
                            if (cVar != null && !cVar.isLooping()) {
                                setKeepScreenOn(false);
                                qj();
                            }
                            iVar.onVideoPlayCompleted();
                            break;
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.d.b.i(this.TAG, "pause mCurrentState: " + getStateString(this.QD));
        if (this.QD == 4) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.QD = 5;
            onPlayStateChanged(this.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.QD == 6) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.QD = 7;
            onPlayStateChanged(this.QD);
            z = true;
        }
        if (this.QD == 3) {
            this.QE.pause();
            com.kwad.sdk.core.d.b.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.QD = 5;
            onPlayStateChanged(this.QD);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoPausePlay");
            z = true;
        }
        if (this.QD != 9 || !this.QE.isLooping()) {
            return z;
        }
        this.QE.pause();
        com.kwad.sdk.core.d.b.i(this.TAG, "pause " + getStateString(this.QD) + "->STATE_PAUSED");
        this.QD = 5;
        onPlayStateChanged(this.QD);
        return true;
    }

    public final void prepareAsync() {
        if (this.QE == null) {
            return;
        }
        if (this.QM) {
            if (this.QL.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.8

                    /* renamed from: com.kwad.components.core.video.b$8$1 */
                    final class AnonymousClass1 implements Runnable {
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b bVar2 = b.this;
                            bVar2.onPlayStateChanged(bVar2.QD);
                        }
                    }

                    AnonymousClass8() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean prepareAsync;
                        com.kwad.sdk.core.d.b.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.QD));
                        if (b.this.QE == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.QE) {
                                b bVar = b.this;
                                bVar.a(bVar.QI);
                                prepareAsync = b.this.QE.prepareAsync();
                                com.kwad.sdk.core.d.b.i(b.this.TAG, "prepareAsync:" + b.getStateString(b.this.QD) + "->STATE_PREPARING, success: " + prepareAsync);
                                b.this.QD = 1;
                            }
                            if (prepareAsync) {
                                b.this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.video.b.8.1
                                    AnonymousClass1() {
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        b bVar2 = b.this;
                                        bVar2.onPlayStateChanged(bVar2.QD);
                                    }
                                });
                            } else {
                                com.kwad.sdk.core.d.b.e(b.this.TAG, "prepareAsync failed");
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.QL) {
                                b.this.QL.notifyAll();
                            }
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            a(this.QI);
            if (!this.QE.prepareAsync()) {
                com.kwad.sdk.core.d.b.e(this.TAG, "prepareAsync failed");
                return;
            }
            com.kwad.sdk.core.d.b.i(this.TAG, "prepareAsync:" + getStateString(this.QD) + "->STATE_PREPARING");
            this.QD = 1;
            onPlayStateChanged(this.QD);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i2 = this.QJ;
                this.QJ = i2 + 1;
                if (i2 <= 4) {
                    qh();
                }
            }
            com.kwad.sdk.core.d.b.i(this.TAG, "prepareAsync Exception:" + getStateString(this.QD));
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public final com.kwad.sdk.core.video.kwai.c qe() {
        return this.QE;
    }

    public final void qh() {
        if (this.QE == null) {
            com.kwad.sdk.core.d.b.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.QD == 2 || this.QD == 3 || this.QD == 4 || this.QD == 5) {
            com.kwad.sdk.core.d.b.w("resetAndPlay", "can not resetAndPlay in sate:" + this.QD);
        } else {
            reset();
            qg();
            qf();
            prepareAsync();
        }
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.QE != null && this.QD == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        if (this.QE == null) {
            com.kwad.sdk.core.d.b.e(this.TAG, "resume but mMediaPlayer is null");
            return;
        }
        com.kwad.sdk.core.d.b.i(this.TAG, "resume mCurrentState: " + getStateString(this.QD));
        if (this.QD == 2 || this.QD == 0) {
            com.kwad.sdk.core.d.b.i(this.TAG, "resume:" + getStateString(this.QD) + "->start()");
            start();
            return;
        }
        if (this.QD == 5) {
            this.QE.start();
            com.kwad.sdk.core.d.b.i(this.TAG, "resume:" + getStateString(this.QD) + "->STATE_PLAYING");
            this.QD = 4;
            onPlayStateChanged(this.QD);
            setPlayType(2);
            com.kwad.sdk.core.video.kwai.kwai.a.cN("videoResumePlay");
            return;
        }
        if (this.QD != 7) {
            if (this.QD != 1) {
                com.kwad.sdk.core.d.b.w(this.TAG, "resume: " + getStateString(this.QD) + " 此时不能调用resume()方法.");
                return;
            }
            return;
        }
        this.QE.start();
        com.kwad.sdk.core.d.b.i(this.TAG, "resume:" + getStateString(this.QD) + "->STATE_BUFFERING_PLAYING");
        this.QD = 6;
        onPlayStateChanged(this.QD);
    }

    public final void seekTo(long j2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.seekTo(j2);
        }
    }

    public final void setAudioEnabled(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        setVolume(f2, f2);
    }

    public final void setRadius(float f2, float f3, float f4, float f5) {
        this.mDetailVideoView.setRadius(f2, f3, f4, f5);
    }

    public final void setSpeed(float f2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f2);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f2, float f3) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f2, f3);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00af, code lost:
    
        if (r7.QD == 9) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void start() {
        /*
            r7 = this;
            java.lang.String r0 = r7.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "start mCurrentState: "
            r1.<init>(r2)
            int r2 = r7.QD
            java.lang.String r2 = getStateString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.kwad.sdk.core.d.b.i(r0, r1)
            int r0 = r7.QD
            java.lang.String r1 = "videoStartPlay"
            r2 = 2
            if (r0 != 0) goto L4e
            java.lang.String r0 = r7.TAG
            java.lang.String r3 = "start, still not prepared well, prepare again"
            com.kwad.sdk.core.d.b.i(r0, r3)
            r7.prepareAsync()
            int r0 = r7.getMediaPlayerType()
            if (r0 != r2) goto L4d
            boolean r0 = r7.QM
            if (r0 == 0) goto L45
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.QL
            boolean r0 = r0.get()
            if (r0 == 0) goto L45
            com.kwad.components.core.video.b$9 r0 = new com.kwad.components.core.video.b$9
            r0.<init>()
            com.kwad.sdk.utils.g.execute(r0)
            return
        L45:
            com.kwad.sdk.core.video.kwai.c r0 = r7.QE
            r0.start()
            com.kwad.sdk.core.video.kwai.kwai.a.cN(r1)
        L4d:
            return
        L4e:
            int r0 = r7.QD
            r3 = 9
            if (r0 == r2) goto L58
            int r0 = r7.QD
            if (r0 != r3) goto Lbe
        L58:
            long r4 = java.lang.System.currentTimeMillis()
            r7.mStartTime = r4
            com.kwad.sdk.core.video.kwai.c r0 = r7.QE
            r0.start()
            com.kwad.sdk.core.video.kwai.kwai.a.cN(r1)
            long r0 = r7.QG
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L75
            com.kwad.sdk.core.video.kwai.c r4 = r7.QE
            int r1 = (int) r0
            long r0 = (long) r1
            r4.seekTo(r0)
        L75:
            java.lang.String r0 = r7.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "start:"
            r1.<init>(r4)
            int r4 = r7.QD
            java.lang.String r4 = getStateString(r4)
            r1.append(r4)
            java.lang.String r4 = "->STATE_STARTED"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.kwad.sdk.core.d.b.i(r0, r1)
            com.kwad.sdk.contentalliance.kwai.kwai.b r0 = r7.QI
            r1 = 3
            if (r0 == 0) goto Lb4
            com.kwad.sdk.core.response.model.VideoPlayerStatus r0 = r0.videoPlayerStatus
            if (r0 == 0) goto Lb4
            int r0 = r7.QD
            if (r0 != r2) goto Lad
            com.kwad.sdk.contentalliance.kwai.kwai.b r0 = r7.QI
            com.kwad.sdk.core.response.model.VideoPlayerStatus r0 = r0.videoPlayerStatus
            int r0 = r0.mVideoPlayerType
            if (r0 != 0) goto Lb1
            r0 = 1
            r7.setPlayType(r0)
            goto Lb4
        Lad:
            int r0 = r7.QD
            if (r0 != r3) goto Lb4
        Lb1:
            r7.setPlayType(r1)
        Lb4:
            r7.QD = r1
            int r0 = r7.QD
            r7.onPlayStateChanged(r0)
            r7.qi()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.b.start():void");
    }

    public final void start(long j2) {
        this.QG = j2;
        start();
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.b.i(this.TAG, "stopAndPrepareAsync mCurrentState:" + this.QD);
        if (this.QD == 1 || this.QD == 2) {
            return;
        }
        if (this.QD != 3 && this.QD != 4 && this.QD != 5 && this.QD != 6 && this.QD != 7 && this.QD != 8 && this.QD != 9) {
            release();
            return;
        }
        try {
            this.QE.stop();
            this.QD = 8;
            onPlayStateChanged(this.QD);
            prepareAsync();
        } catch (Exception unused) {
            release();
            com.kwad.sdk.core.d.b.e(this.TAG, "stopAndPrepareAsync mCurrentState:" + this.QD);
        }
    }
}
