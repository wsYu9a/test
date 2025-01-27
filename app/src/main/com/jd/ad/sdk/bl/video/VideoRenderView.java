package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.bl.video.jad_an;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.multi.R;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class VideoRenderView extends FrameLayout implements Handler.Callback {
    public static final /* synthetic */ int jad_gp = 0;
    public MediaPlayer.OnVideoSizeChangedListener jad_al;
    public MediaPlayer jad_an;
    public MediaPlayer.OnCompletionListener jad_bm;
    public int jad_bo;
    public int jad_cn;
    public int jad_cp;
    public boolean jad_do;
    public Context jad_dq;
    public MediaPlayer.OnErrorListener jad_en;
    public boolean jad_ep;
    public com.jd.ad.sdk.bl.video.jad_an jad_er;
    public MediaPlayer.OnBufferingUpdateListener jad_fo;
    public ImageView jad_fq;
    public int jad_fs;
    public boolean jad_gr;
    public long jad_hs;
    public ShakeListener jad_hu;
    public VideoSkipView jad_it;
    public int jad_iv;
    public jad_an.jad_bo jad_jt;
    public FrameLayout jad_ju;
    public float jad_jw;
    public TextView jad_kv;
    public float jad_kx;
    public String jad_lw;
    public float jad_ly;
    public int jad_mx;
    public float jad_mz;
    public float jad_na;
    public SplashRenderVideoHelper jad_ny;
    public boolean jad_ob;
    public String jad_oz;
    public int jad_pa;
    public int jad_pc;
    public String jad_qb;
    public VideoInteractionListener jad_qd;
    public int jad_rc;
    public boolean jad_re;
    public boolean jad_sd;
    public jad_hu jad_sf;
    public String jad_te;
    public LottieAnimationView jad_tg;
    public VideoLoadListener jad_uf;
    public OnVideoRenderListener jad_uh;
    public int jad_vg;
    public double jad_vi;
    public boolean jad_wh;
    public double jad_wj;
    public String jad_xi;
    public String jad_xk;
    public boolean jad_yj;
    public int jad_yl;
    public MediaPlayer.OnPreparedListener jad_zk;
    public int jad_zm;

    public class jad_an implements MediaPlayer.OnPreparedListener {
        public jad_an() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoRenderView.this.jad_yj = true;
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_cp = 2;
            OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(2, videoRenderView.getDuration());
            }
            int i10 = VideoRenderView.this.jad_fs;
            if (i10 > 0 && mediaPlayer.getDuration() > 0) {
                VideoRenderView.this.jad_an.seekTo(i10);
                VideoRenderView.this.jad_fs = 0;
            }
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            int i11 = videoRenderView2.jad_bo;
            if (i11 == 3) {
                videoRenderView2.jad_bo = 3;
                try {
                    if (videoRenderView2.jad_an()) {
                        if (videoRenderView2.getState() != 2) {
                            if (videoRenderView2.getState() != 4) {
                                if (videoRenderView2.getState() == 6) {
                                }
                            }
                        }
                        if (videoRenderView2.jad_an != null && videoRenderView2.jad_bo() && videoRenderView2.jad_yj) {
                            videoRenderView2.jad_an.start();
                        }
                        videoRenderView2.jad_cp = 3;
                    }
                } catch (Exception e10) {
                    videoRenderView2.jad_an(e10);
                }
            } else if (i11 == 4) {
                try {
                    if (videoRenderView2.jad_an()) {
                        int state = videoRenderView2.getState();
                        if (videoRenderView2.jad_an() && state != -2 && state != -1 && state != 0 && state != 1 && state != 4 && state != 5) {
                            videoRenderView2.jad_an.pause();
                            videoRenderView2.jad_cp = 4;
                        }
                    }
                } catch (Exception e11) {
                    videoRenderView2.jad_an(e11);
                }
                videoRenderView2.jad_bo = 4;
            } else if (i11 == 5 || i11 == 0) {
                if (videoRenderView2.jad_an()) {
                    videoRenderView2.jad_an.reset();
                    videoRenderView2.jad_cp = 0;
                }
                videoRenderView2.jad_bo = 0;
            }
            VideoRenderView videoRenderView3 = VideoRenderView.this;
            OnVideoRenderListener onVideoRenderListener2 = videoRenderView3.jad_uh;
            if (onVideoRenderListener2 != null) {
                videoRenderView3.jad_vg = 1;
                onVideoRenderListener2.onVideoRenderSuccess(videoRenderView3);
            }
        }
    }

    public class jad_bo implements MediaPlayer.OnVideoSizeChangedListener {
        public jad_bo() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = videoRenderView.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an((int) videoRenderView.jad_vi, (int) videoRenderView.jad_wj);
            }
        }
    }

    public class jad_cp implements MediaPlayer.OnCompletionListener {
        public jad_cp() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoRenderView.jad_an(VideoRenderView.this, mediaPlayer);
        }
    }

    public class jad_dq implements MediaPlayer.OnErrorListener {
        public jad_dq() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            String jad_an;
            Logger.d("VideoRenderView Error: " + i10 + "," + i11);
            VideoRenderView.this.jad_re = true;
            VideoRenderView.this.jad_an(false);
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_cp = -1;
            videoRenderView.jad_bo = -1;
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
            int i12 = jad_anVar.jad_an;
            jad_anVar.jad_an(new String[0]);
            if (i10 == -1010) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNSUPPORTED_ERROR;
                i12 = jad_anVar2.jad_an;
                jad_an = jad_anVar2.jad_an(new String[0]);
            } else if (i10 == -1007) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_MALFORMED_ERROR;
                i12 = jad_anVar3.jad_an;
                jad_an = jad_anVar3.jad_an(new String[0]);
            } else if (i10 == -1004) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_IO_ERROR;
                i12 = jad_anVar4.jad_an;
                jad_an = jad_anVar4.jad_an(new String[0]);
            } else if (i10 == -110) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_TIMED_OUT_ERROR;
                i12 = jad_anVar5.jad_an;
                jad_an = jad_anVar5.jad_an(new String[0]);
            } else if (i10 == 1) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNKNOWN_ERROR;
                i12 = jad_anVar6.jad_an;
                jad_an = jad_anVar6.jad_an(new String[0]);
            } else if (i10 == 100) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_SERVER_DIED_ERROR;
                i12 = jad_anVar7.jad_an;
                jad_an = jad_anVar7.jad_an(new String[0]);
            } else if (i10 != 200) {
                jad_an = jad_anVar.jad_an(new String[0]) + " " + i10;
            } else {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PROGRESSIVE_PLAYBACK_ERROR;
                i12 = jad_anVar8.jad_an;
                jad_an = jad_anVar8.jad_an(new String[0]);
            }
            String str = jad_an;
            int i13 = i12;
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            OnVideoRenderListener onVideoRenderListener = videoRenderView2.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(7, videoRenderView2.getDuration());
                VideoRenderView videoRenderView3 = VideoRenderView.this;
                videoRenderView3.jad_uh.videoPlayerError(i13, i10, i11, videoRenderView3.getDuration(), str);
            }
            return true;
        }
    }

    public class jad_er implements MediaPlayer.OnBufferingUpdateListener {
        public jad_er() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            int i11 = VideoRenderView.jad_gp;
            videoRenderView.getClass();
        }
    }

    public class jad_fs implements View.OnTouchListener {
        public jad_fs(VideoRenderView videoRenderView) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class jad_hu implements ActLifecycle.jad_an {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            ShakeListener shakeListener = VideoRenderView.this.jad_hu;
            if (shakeListener != null) {
                shakeListener.unregister();
            }
        }
    }

    public static class jad_iv {
        public float jad_an;
        public float jad_bo;
        public OnVideoRenderListener jad_cp;
        public int jad_dq;
        public int jad_er;
        public String jad_fs;
        public boolean jad_hu;
        public boolean jad_iv;
        public int jad_jt;
        public String jad_jw;
        public String jad_kx;
        public String jad_ly;
        public VideoLoadListener jad_mz;
        public long jad_na;
        public int jad_ob;
        public int jad_pc;
    }

    public class jad_jt implements OnImageLoadListener {
        public jad_jt() {
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i10, String str, @Nullable Drawable drawable) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            videoRenderView.jad_pa = i10;
            videoRenderView.jad_qb = str;
            videoRenderView.jad_gr = false;
            VideoRenderView videoRenderView2 = VideoRenderView.this;
            videoRenderView2.jad_an(videoRenderView2.jad_wh);
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(@NonNull Drawable drawable) {
            VideoRenderView videoRenderView = VideoRenderView.this;
            if (videoRenderView.jad_fq != null) {
                videoRenderView.jad_gr = true;
                VideoRenderView.this.jad_fq.setImageDrawable(drawable);
                if (TextUtils.isEmpty(VideoRenderView.this.jad_lw)) {
                    VideoRenderView.this.jad_an(true);
                } else {
                    VideoRenderView videoRenderView2 = VideoRenderView.this;
                    videoRenderView2.jad_an(videoRenderView2.jad_wh);
                }
            }
        }
    }

    public VideoRenderView(Context context, jad_iv jad_ivVar) {
        super(context);
        this.jad_an = null;
        this.jad_bo = Integer.MAX_VALUE;
        this.jad_cp = 0;
        this.jad_iv = 100;
        this.jad_jw = 0.0f;
        this.jad_kx = 1.0f;
        this.jad_ly = 0.0f;
        this.jad_mz = 0.0f;
        this.jad_na = 45.0f;
        this.jad_re = false;
        this.jad_rc = 2;
        this.jad_vg = 0;
        this.jad_yj = false;
        this.jad_zk = new jad_an();
        this.jad_al = new jad_bo();
        this.jad_bm = new jad_cp();
        this.jad_en = new jad_dq();
        this.jad_fo = new jad_er();
        this.jad_dq = context;
        jad_iv();
        jad_cp();
        jad_an(jad_ivVar);
        jad_dq();
        if (!this.jad_wh) {
            JADMediator.getInstance().getAdVideoService().registerAd(this.jad_te);
        }
        jad_an(context);
        jad_jt();
        if (this.jad_wh) {
            return;
        }
        jad_er();
    }

    private String getStoreVideoPath() {
        if ("1".equals(this.jad_xi)) {
            return "";
        }
        if (this.jad_ny == null) {
            this.jad_ny = new SplashRenderVideoHelper(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), this.jad_oz);
        }
        com.jd.ad.sdk.jad_ly.jad_cp storageVideoByUrl = this.jad_ny.getStorageVideoByUrl(this.jad_lw);
        return storageVideoByUrl != null ? storageVideoByUrl.jad_dq : "";
    }

    public static void jad_an(VideoRenderView videoRenderView, MediaPlayer mediaPlayer) {
        int i10;
        videoRenderView.getClass();
        try {
            if (videoRenderView.jad_cp == 6 || (i10 = videoRenderView.jad_mx) <= 0 || i10 != videoRenderView.getDuration()) {
                return;
            }
            videoRenderView.jad_cp = 6;
            videoRenderView.jad_bo = 6;
            OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(4, videoRenderView.getDuration());
            }
            if (mediaPlayer == null || mediaPlayer.isLooping()) {
                return;
            }
            try {
                if (videoRenderView.jad_an() && (videoRenderView.getState() == 2 || videoRenderView.getState() == 3 || videoRenderView.getState() == 4 || videoRenderView.getState() == 6)) {
                    videoRenderView.jad_an.stop();
                    videoRenderView.jad_cp = 5;
                }
            } catch (Exception unused) {
            }
            videoRenderView.jad_bo = 5;
        } catch (Exception unused2) {
        }
    }

    public void destroy() {
        AudioManager audioManager;
        try {
            if (jad_an()) {
                this.jad_cp = -2;
                MediaPlayer mediaPlayer = this.jad_an;
                if (mediaPlayer != null) {
                    mediaPlayer.setOnPreparedListener(null);
                    this.jad_an.setOnVideoSizeChangedListener(null);
                    this.jad_an.setOnCompletionListener(null);
                    this.jad_an.setOnErrorListener(null);
                    this.jad_an.setOnInfoListener(null);
                    this.jad_an.setOnBufferingUpdateListener(null);
                }
                this.jad_an.release();
            }
            Context context = this.jad_dq;
            if (context != null && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.jad_jt = null;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an();
                this.jad_er = null;
            }
            jad_hu jad_huVar = this.jad_sf;
            CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
            if (jad_huVar != null) {
                copyOnWriteArrayList.remove(jad_huVar);
            }
            this.jad_sf = null;
            JADMediator.getInstance().getAdVideoService().unregisterAd(this.jad_te);
        } catch (Exception unused) {
        }
    }

    public int getAdAnimationType() {
        return this.jad_pc;
    }

    public int getAdClickAreaValue() {
        return this.jad_iv;
    }

    public int getDuration() {
        try {
            if (this.jad_re || !jad_an() || getState() == -1 || getState() == 1 || getState() == 0) {
                return 0;
            }
            return this.jad_an.getDuration();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getState() {
        return this.jad_cp;
    }

    public Exception getVideoRenderException() {
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 10001) {
            return false;
        }
        jad_an(true);
        return false;
    }

    public final void jad_cp() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 == null) {
            return;
        }
        this.jad_jw = jad_an2.jad_cp;
        this.jad_kx = jad_an2.jad_dq;
        this.jad_na = jad_an2.jad_jw;
        this.jad_ly = jad_an2.jad_er;
        this.jad_mz = jad_an2.jad_fs;
        this.jad_xi = jad_an2.jad_sf;
        this.jad_wh = "1".equals(jad_an2.jad_tg);
        if (this.jad_kx <= 0.0f) {
            this.jad_kx = 1.0f;
        }
        if (this.jad_na <= 0.0f) {
            this.jad_na = 45.0f;
        }
    }

    public final void jad_dq() {
        if (this.jad_zm == CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_cn == CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_pc = 1;
                return;
            } else {
                this.jad_pc = 0;
                return;
            }
        }
        if (this.jad_zm == CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_pc = 2;
        } else if (this.jad_zm == CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_pc = 3;
        }
    }

    public final void jad_er() {
        new Handler(Looper.getMainLooper(), this).sendEmptyMessageDelayed(10001, Math.max(this.jad_hs - 100, 5L));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[Catch: Exception -> 0x0011, TRY_LEAVE, TryCatch #1 {Exception -> 0x0011, blocks: (B:3:0x0001, B:5:0x0008, B:10:0x0018, B:12:0x005e, B:14:0x0077, B:16:0x007e, B:23:0x0074, B:26:0x002f, B:29:0x0049, B:20:0x006a), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_fs() {
        /*
            r13 = this;
            r0 = 0
            java.lang.String r1 = ""
            int r2 = r13.jad_pc     // Catch: java.lang.Exception -> L11
            r3 = 1
            if (r2 != r3) goto L14
            com.jd.ad.sdk.lottie.LottieAnimationView r1 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            r2 = 8
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L11
            goto L94
        L11:
            r1 = move-exception
            goto L95
        L14:
            r4 = 0
            if (r2 != 0) goto L2a
            double r1 = r13.jad_vi     // Catch: java.lang.Exception -> L11
            r6 = 4637018766331346944(0x405a000000000000, double:104.0)
            double r6 = r6 * r1
            r8 = 4649808285585637376(0x4087700000000000, double:750.0)
            double r6 = r6 / r8
            java.lang.String r8 = "jad_click.json"
        L26:
            r11 = r1
            r1 = r8
            r8 = r11
            goto L5e
        L2a:
            r6 = 2
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r2 != r6) goto L46
            double r1 = r13.jad_wj     // Catch: java.lang.Exception -> L11
            double r4 = r13.jad_vi     // Catch: java.lang.Exception -> L11
            double r1 = java.lang.Math.min(r1, r4)     // Catch: java.lang.Exception -> L11
            double r4 = r1 / r7
            r1 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r1 = r4 / r1
            double r1 = r1 * r7
            java.lang.String r6 = "jad_shake.json"
            r8 = r4
            r4 = r1
            r1 = r6
            r6 = r8
            goto L5e
        L46:
            r6 = 3
            if (r2 != r6) goto L5b
            double r1 = r13.jad_vi     // Catch: java.lang.Exception -> L11
            r4 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r1 = r1 / r4
            r9 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r1 = r1 * r9
            double r9 = r13.jad_wj     // Catch: java.lang.Exception -> L11
            double r6 = r9 / r7
            double r4 = r6 / r4
            java.lang.String r8 = "jad_slideup.json"
            goto L26
        L5b:
            r6 = r4
            r8 = r6
            r3 = 0
        L5e:
            com.jd.ad.sdk.lottie.LottieAnimationView r2 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            java.lang.String r10 = "images/"
            r2.setImageAssetsFolder(r10)     // Catch: java.lang.Exception -> L11
            com.jd.ad.sdk.lottie.LottieAnimationView r2 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            if (r2 != 0) goto L6a
            goto L77
        L6a:
            com.jd.ad.sdk.jad_hu.jad_er r10 = new com.jd.ad.sdk.jad_hu.jad_er     // Catch: java.lang.Exception -> L73
            r10.<init>()     // Catch: java.lang.Exception -> L73
            r2.setFontAssetDelegate(r10)     // Catch: java.lang.Exception -> L73
            goto L77
        L73:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Exception -> L11
        L77:
            com.jd.ad.sdk.lottie.LottieAnimationView r2 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            r2.setAnimation(r1)     // Catch: java.lang.Exception -> L11
            if (r3 == 0) goto L94
            com.jd.ad.sdk.lottie.LottieAnimationView r1 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()     // Catch: java.lang.Exception -> L11
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1     // Catch: java.lang.Exception -> L11
            int r2 = (int) r8     // Catch: java.lang.Exception -> L11
            r1.width = r2     // Catch: java.lang.Exception -> L11
            int r2 = (int) r6     // Catch: java.lang.Exception -> L11
            r1.height = r2     // Catch: java.lang.Exception -> L11
            int r2 = (int) r4     // Catch: java.lang.Exception -> L11
            r1.bottomMargin = r2     // Catch: java.lang.Exception -> L11
            com.jd.ad.sdk.lottie.LottieAnimationView r2 = r13.jad_tg     // Catch: java.lang.Exception -> L11
            r2.setLayoutParams(r1)     // Catch: java.lang.Exception -> L11
        L94:
            return
        L95:
            java.lang.Throwable r2 = new java.lang.Throwable
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.jd.ad.sdk.jad_wj.jad_an r4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR
            int r5 = r4.jad_an
            r3.append(r5)
            java.lang.String r5 = "-"
            r3.append(r5)
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r0 = r4.jad_an(r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.bl.video.VideoRenderView.jad_fs():void");
    }

    public void jad_hu() {
        try {
            if (TextUtils.isEmpty(this.jad_xk)) {
                this.jad_gr = false;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_EMPTY_IMAGES_ERROR;
                this.jad_pa = jad_anVar.jad_an;
                this.jad_qb = jad_anVar.jad_an(new String[0]);
                if (!this.jad_wh) {
                    if (!TextUtils.isEmpty(this.jad_lw)) {
                        if (this.jad_re) {
                        }
                    }
                }
                jad_an(true);
            } else {
                JADMediator.getInstance().getFoundationService().loadImage(this.jad_dq, this.jad_xk, new jad_jt());
            }
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_LOAD_IMAGES_ERROR;
            this.jad_pa = jad_anVar2.jad_an;
            this.jad_qb = jad_anVar2.jad_an(new String[0]) + e10.getMessage();
            this.jad_gr = false;
            jad_an(this.jad_wh);
        }
    }

    public final void jad_iv() {
        jad_hu jad_huVar = new jad_hu();
        this.jad_sf = jad_huVar;
        ActLifecycle.jad_an(jad_huVar);
    }

    public final void jad_jt() {
        setOnTouchListener(new jad_fs(this));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.jad_ob = z10;
        if (z10) {
            ShakeListener shakeListener = this.jad_hu;
            if (shakeListener != null) {
                shakeListener.register();
            }
        } else {
            ShakeListener shakeListener2 = this.jad_hu;
            if (shakeListener2 != null) {
                shakeListener2.unregister();
            }
        }
        try {
            if (this.jad_an == null || !jad_bo() || this.jad_re || this.jad_wh) {
                return;
            }
            if (this.jad_ob) {
                if (!this.jad_an.isPlaying() && this.jad_an != null && jad_bo() && this.jad_yj) {
                    this.jad_an.start();
                }
            } else if (this.jad_an.isPlaying()) {
                this.jad_an.pause();
            }
            OnVideoRenderListener onVideoRenderListener = this.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(this.jad_ob ? 6 : 5, getDuration());
            }
        } catch (Exception unused) {
        }
    }

    public void play() {
        MediaPlayer mediaPlayer;
        OnVideoRenderListener onVideoRenderListener;
        OnVideoRenderListener onVideoRenderListener2;
        try {
            if (this.jad_an != null && !jad_bo() && !this.jad_re && this.jad_yj) {
                this.jad_an.seekTo(0);
                this.jad_an.start();
                this.jad_an.pause();
                VideoSkipView videoSkipView = this.jad_it;
                if (videoSkipView != null) {
                    videoSkipView.setTotalCount(this.jad_yl);
                    return;
                }
                return;
            }
            if (this.jad_ju != null) {
                if (!this.jad_re && jad_an() && this.jad_yj) {
                    this.jad_ju.setVisibility(0);
                    this.jad_an.start();
                } else {
                    this.jad_ju.setVisibility(8);
                }
            }
            LottieAnimationView lottieAnimationView = this.jad_tg;
            if (lottieAnimationView != null && this.jad_pc != 1) {
                lottieAnimationView.setVisibility(0);
                this.jad_tg.jad_dq();
            }
            if (!this.jad_wh && (onVideoRenderListener2 = this.jad_uh) != null) {
                onVideoRenderListener2.videoPlayerStatusChanged(1, getDuration());
            }
            if (!this.jad_wh && !this.jad_re && (mediaPlayer = this.jad_an) != null && mediaPlayer.isPlaying() && (onVideoRenderListener = this.jad_uh) != null) {
                onVideoRenderListener.videoPlayerStatusChanged(3, getDuration());
            }
            if (this.jad_it != null) {
                HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_ly.jad_dq(this));
            }
        } catch (Exception unused) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
        }
    }

    public void setDataSource(String str) {
        try {
            if (this.jad_an == null) {
                this.jad_an = new MediaPlayer();
            }
            this.jad_bo = Integer.MAX_VALUE;
            this.jad_an.setOnPreparedListener(this.jad_zk);
            this.jad_an.setOnVideoSizeChangedListener(this.jad_al);
            this.jad_an.setOnErrorListener(this.jad_en);
            this.jad_an.setOnBufferingUpdateListener(this.jad_fo);
            if (this.jad_rc == 1) {
                if (jad_an()) {
                    this.jad_an.setVolume(1.0f, 1.0f);
                }
            } else if (jad_an()) {
                this.jad_an.setVolume(0.0f, 0.0f);
            }
            this.jad_cp = 1;
            this.jad_an.setDataSource(this.jad_dq, Uri.parse(str));
            this.jad_an.setOnCompletionListener(this.jad_bm);
            this.jad_an.setAudioStreamType(3);
            this.jad_an.setScreenOnWhilePlaying(true);
            this.jad_an.setLooping(false);
            this.jad_an.prepareAsync();
        } catch (Exception e10) {
            e10.printStackTrace();
            this.jad_cp = -1;
            this.jad_bo = -1;
        }
    }

    public void setVideoInteractionListener(VideoInteractionListener videoInteractionListener) {
        this.jad_qd = videoInteractionListener;
    }

    public final boolean jad_bo() {
        int i10;
        int i11;
        try {
            Rect rect = new Rect();
            if (getGlobalVisibleRect(rect)) {
                i11 = rect.width();
                i10 = rect.height();
            } else {
                i10 = 0;
                i11 = 0;
            }
            return com.jd.ad.sdk.jad_jt.jad_iv.jad_an(i10 * i11, JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) * JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) >= 50;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean jad_an(VideoRenderView videoRenderView, View view) {
        videoRenderView.getClass();
        return view != null && view.getGlobalVisibleRect(new Rect()) && view.isShown();
    }

    public final void jad_an(Context context) {
        View inflate;
        LottieAnimationView lottieAnimationView;
        try {
            if (this.jad_wh) {
                inflate = LayoutInflater.from(context).inflate(R.layout.jad_video_img_render_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.jad_video_render_layout, (ViewGroup) null);
                this.jad_kv = (TextView) inflate.findViewById(R.id.jad_text_video_preloaded);
                this.jad_ju = (FrameLayout) inflate.findViewById(R.id.fl_splash_video);
                this.jad_er = (com.jd.ad.sdk.bl.video.jad_an) inflate.findViewById(R.id.jad_video_texture_view);
                this.jad_an = new MediaPlayer();
                com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
                if (jad_anVar != null) {
                    jad_anVar.setRenderCallback(new com.jd.ad.sdk.bl.video.jad_cp(this));
                }
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.jad_video_lottie);
            this.jad_tg = lottieAnimationView2;
            int i10 = 8;
            lottieAnimationView2.setVisibility(8);
            this.jad_tg.setCacheComposition(false);
            this.jad_fq = (ImageView) inflate.findViewById(R.id.jad_splash_video_image);
            this.jad_it = (VideoSkipView) inflate.findViewById(R.id.jad_video_skip_btn);
            addView(inflate);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i11 = (int) this.jad_vi;
            int i12 = (int) this.jad_wj;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i11, i12);
            } else {
                layoutParams.height = i12;
                layoutParams.width = i11;
            }
            setLayoutParams(layoutParams);
            if (this.jad_yl > 5) {
                this.jad_yl = 5;
            }
            VideoSkipView videoSkipView = this.jad_it;
            if (videoSkipView != null) {
                videoSkipView.setVisibility(this.jad_do ? 8 : 0);
                if (!this.jad_do) {
                    VideoSkipView videoSkipView2 = this.jad_it;
                    int i13 = this.jad_yl;
                    com.jd.ad.sdk.bl.video.jad_bo jad_boVar = new com.jd.ad.sdk.bl.video.jad_bo(this);
                    videoSkipView2.jad_an = i13;
                    videoSkipView2.jad_bo = jad_boVar;
                    videoSkipView2.setOnClickListener(new com.jd.ad.sdk.bl.video.jad_dq(videoSkipView2));
                }
            }
            LottieAnimationView lottieAnimationView3 = this.jad_tg;
            if (lottieAnimationView3 != null && context != null) {
                lottieAnimationView3.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.jad_ly.jad_jt(this, context));
            }
            if (!this.jad_wh && !TextUtils.isEmpty(this.jad_lw)) {
                String str = this.jad_lw;
                this.jad_sd = false;
                String storeVideoPath = getStoreVideoPath();
                if (!TextUtils.isEmpty(storeVideoPath)) {
                    this.jad_sd = true;
                    str = storeVideoPath;
                }
                OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.updateMaterialMetaPreload(this.jad_sd);
                }
                TextView textView = this.jad_kv;
                if (this.jad_sd && !this.jad_ep) {
                    i10 = 0;
                }
                textView.setVisibility(i10);
                setDataSource(str);
            } else {
                this.jad_re = true;
            }
            if (this.jad_tg != null) {
                jad_fs();
            }
            jad_hu();
            int i14 = this.jad_pc;
            if (i14 == 3) {
                Context context2 = this.jad_dq;
                FrameLayout frameLayout = this.jad_ju;
                if (frameLayout != null) {
                    frameLayout.setOnTouchListener(new com.jd.ad.sdk.jad_ly.jad_fs(this, context2));
                }
            } else if (i14 == 1) {
                View view = this.jad_wh ? this.jad_fq : this.jad_ju;
                if (view != null) {
                    view.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_er(this));
                    jad_an(view.getWidth(), view.getHeight());
                }
            } else if (i14 == 0 && (lottieAnimationView = this.jad_tg) != null) {
                lottieAnimationView.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_er(this));
                jad_an(lottieAnimationView.getWidth(), lottieAnimationView.getHeight());
            }
            if (this.jad_wh || this.jad_sd || "1".equals(this.jad_xi) || TextUtils.isEmpty(this.jad_lw)) {
                return;
            }
            JADMediator.getInstance().getAdVideoService().loadAdVideo(context, this.jad_te, this.jad_lw, this.jad_oz, this.jad_uf);
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR;
            sb2.append(jad_anVar2.jad_an);
            sb2.append("-");
            sb2.append(jad_anVar2.jad_an(new String[0]));
            throw new Throwable(sb2.toString(), e10);
        }
    }

    public final void jad_an(int i10, int i11) {
        int i12 = (int) (this.jad_vi * this.jad_wj);
        if (i12 > 0) {
            this.jad_iv = ((i10 * i11) * 100) / i12;
        }
    }

    public final boolean jad_an() {
        return (this.jad_an == null || this.jad_wh) ? false : true;
    }

    public final void jad_an(Exception exc) {
        try {
            if (this.jad_uh != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
                int i10 = jad_anVar.jad_an;
                String jad_an2 = jad_anVar.jad_an(new String[0]);
                String message = exc.getMessage();
                this.jad_uh.videoPlayerError(i10, i10, i10, getDuration(), jad_an2 + message);
            }
            if (jad_an()) {
                this.jad_an.reset();
                this.jad_cp = 0;
            }
            this.jad_bo = 0;
        } catch (Exception unused) {
        }
    }

    public final void jad_an(boolean z10) {
        if ((z10 || this.jad_re) && this.jad_vg == 0) {
            if (this.jad_gr) {
                ImageView imageView = this.jad_fq;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.onVideoRenderSuccess(this);
                    this.jad_vg = 2;
                    return;
                }
                return;
            }
            OnVideoRenderListener onVideoRenderListener2 = this.jad_uh;
            if (onVideoRenderListener2 != null) {
                onVideoRenderListener2.onVideoRenderFailed(this.jad_pa, this.jad_qb);
            }
        }
    }

    public final void jad_an(jad_iv jad_ivVar) {
        this.jad_vi = jad_ivVar.jad_an;
        this.jad_wj = jad_ivVar.jad_bo;
        this.jad_xk = jad_ivVar.jad_fs;
        this.jad_yl = jad_ivVar.jad_jt;
        this.jad_uh = jad_ivVar.jad_cp;
        this.jad_zm = jad_ivVar.jad_dq;
        this.jad_cn = jad_ivVar.jad_er;
        this.jad_do = jad_ivVar.jad_hu;
        this.jad_ep = jad_ivVar.jad_iv;
        this.jad_lw = jad_ivVar.jad_jw;
        this.jad_oz = jad_ivVar.jad_kx;
        this.jad_te = jad_ivVar.jad_ly;
        this.jad_uf = jad_ivVar.jad_mz;
        this.jad_hs = jad_ivVar.jad_na;
        this.jad_rc = jad_ivVar.jad_ob;
        this.jad_mx = jad_ivVar.jad_pc;
    }
}
