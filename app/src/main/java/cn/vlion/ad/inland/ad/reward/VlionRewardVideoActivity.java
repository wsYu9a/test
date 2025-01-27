package cn.vlion.ad.inland.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.download.VlionDownLoadSecondConfirmView;
import cn.vlion.ad.inland.ad.view.video.VlionBaseVideoView;
import cn.vlion.ad.inland.ad.view.video.VlionTimeView;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.ad.view.video.VlionVideoSkipDialogView;
import cn.vlion.ad.inland.ad.view.video.VolumeControlView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.a6;
import cn.vlion.ad.inland.base.b0;
import cn.vlion.ad.inland.base.b5;
import cn.vlion.ad.inland.base.g1;
import cn.vlion.ad.inland.base.h4;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.j7;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.q;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.s0;
import cn.vlion.ad.inland.base.t5;
import cn.vlion.ad.inland.base.u5;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.handle.VlionShakeParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v5;
import cn.vlion.ad.inland.base.w5;
import cn.vlion.ad.inland.base.y5;
import cn.vlion.ad.inland.base.z4;
import java.util.HashMap;

/* loaded from: classes.dex */
public class VlionRewardVideoActivity extends Activity {
    public static final /* synthetic */ int I = 0;
    public VlionSensorBean B;
    public FrameLayout D;
    public LinearLayout E;
    public ProgressBar F;
    public t5 G;

    /* renamed from: a */
    public g1 f2323a;

    /* renamed from: b */
    public b5 f2324b;

    /* renamed from: e */
    public VlionCustomParseAdData f2327e;

    /* renamed from: f */
    public int f2328f;

    /* renamed from: g */
    public VlionAdapterADConfig f2329g;

    /* renamed from: h */
    public FrameLayout f2330h;

    /* renamed from: i */
    public VolumeControlView f2331i;

    /* renamed from: j */
    public VlionTimeView f2332j;

    /* renamed from: k */
    public VlionBaseVideoView f2333k;

    /* renamed from: l */
    public VlionAdClosedView f2334l;

    /* renamed from: m */
    public VlionVideoEndCardView f2335m;

    /* renamed from: n */
    public boolean f2336n;

    /* renamed from: o */
    public VlionVideoSkipDialogView f2337o;

    /* renamed from: p */
    public FrameLayout f2338p;

    /* renamed from: q */
    public h4 f2339q;

    /* renamed from: r */
    public VlionDownLoadSecondConfirmView f2340r;

    /* renamed from: s */
    public q0 f2341s;

    /* renamed from: u */
    public DownloadApkData f2343u;

    /* renamed from: c */
    public int f2325c = 0;

    /* renamed from: d */
    public String f2326d = "";

    /* renamed from: t */
    public boolean f2342t = false;

    /* renamed from: v */
    public boolean f2344v = false;

    /* renamed from: w */
    public boolean f2345w = false;

    /* renamed from: x */
    public boolean f2346x = false;

    /* renamed from: y */
    public int f2347y = 0;

    /* renamed from: z */
    public boolean f2348z = false;
    public boolean A = false;
    public int C = 0;
    public boolean H = false;

    public class a implements SensorManagerManager.OnShakeListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f2349a;

        public a(VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
            this.f2349a = csBean;
        }

        @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
        public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
            try {
                LogVlion.e("端策略 : VlionRewardVideoViewActivity onShake =");
                VlionRewardVideoActivity vlionRewardVideoActivity = VlionRewardVideoActivity.this;
                if (vlionRewardVideoActivity.H) {
                    return;
                }
                vlionRewardVideoActivity.H = true;
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(VlionRewardVideoActivity.this.B);
                VlionRewardVideoActivity vlionRewardVideoActivity2 = VlionRewardVideoActivity.this;
                vlionRewardVideoActivity2.B = null;
                vlionRewardVideoActivity2.f2346x = false;
                try {
                    String a10 = vlionRewardVideoActivity2.a(false);
                    h4 h4Var = vlionRewardVideoActivity2.f2339q;
                    if (h4Var != null) {
                        h4Var.a(a10, vlionRewardVideoActivity2.f2346x);
                    }
                    VlionVideoEndCardView vlionVideoEndCardView = vlionRewardVideoActivity2.f2335m;
                    if (vlionVideoEndCardView != null) {
                        vlionVideoEndCardView.a(a10, vlionRewardVideoActivity2.f2346x);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                VlionVideoEndCardView vlionVideoEndCardView2 = VlionRewardVideoActivity.this.f2335m;
                VlionADClickType vlionADClickType = (vlionVideoEndCardView2 == null || vlionVideoEndCardView2.getVisibility() != 0) ? new VlionADClickType("shake", "", "main", "", "") : new VlionADClickType("shake", "", "endcard", "", "");
                VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(VlionRewardVideoActivity.this.f2327e);
                vlionShakeParameterReplace.handleBaseParameter(VlionRewardVideoActivity.this.f2339q);
                vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f2349a;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                    vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f2349a.getTriggerParam());
                }
                VlionRewardVideoActivity.a(VlionRewardVideoActivity.this, vlionADClickType);
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public class b implements VlionAdClosedView.d {
        public b() {
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a() {
            try {
                VlionRewardVideoActivity.a(VlionRewardVideoActivity.this, VlionRewardVideoActivity.this.f2332j.getLeftSec());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a(boolean z10) {
            try {
                VlionRewardVideoActivity.a(VlionRewardVideoActivity.this, VlionRewardVideoActivity.this.f2332j.getLeftSec());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ i0 f2352a;

        public c(i0 i0Var) {
            this.f2352a = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionRewardVideoActivity adAreaClickAction isOpenHot " + VlionRewardVideoActivity.this.A);
                if (VlionRewardVideoActivity.this.A) {
                    VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2352a), "main", "hotsplot", "");
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(VlionRewardVideoActivity.this.f2327e);
                    vlionClickParameterReplace.handleBaseParameter(VlionRewardVideoActivity.this.f2339q);
                    vlionClickParameterReplace.handleClickParameter(this.f2352a, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    VlionRewardVideoActivity.b(VlionRewardVideoActivity.this, vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements z4 {
        public d() {
        }

        @Override // cn.vlion.ad.inland.base.z4
        public final void a(int i10) {
            LogVlion.e(" initVideoView 正在下载 :" + i10);
        }

        @Override // cn.vlion.ad.inland.base.z4
        public final void a(String str) {
            try {
                LogVlion.e(" initVideoView filepath :" + str);
                if (VlionRewardVideoActivity.this.isFinishing() && VlionRewardVideoActivity.this.D == null) {
                    return;
                }
                VlionRewardVideoActivity.this.D.setVisibility(8);
                VlionRewardVideoActivity.a(VlionRewardVideoActivity.this, str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.z4
        public final void a(VlionAdBaseError vlionAdBaseError) {
            try {
                if (VlionRewardVideoActivity.this.isFinishing() && VlionRewardVideoActivity.this.D == null) {
                    return;
                }
                VlionRewardVideoActivity.this.D.setVisibility(0);
                VlionRewardVideoActivity.this.F.setVisibility(8);
                VlionRewardVideoActivity.this.E.setVisibility(0);
                VlionRewardVideoActivity.this.E.setOnClickListener(new cn.vlion.ad.inland.ad.reward.b(this));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static class e {

        /* renamed from: a */
        public static final HashMap<String, g1> f2355a = new HashMap<>();

        /* renamed from: b */
        public static b5 f2356b;
    }

    public final String a(boolean z10) {
        Resources resources;
        int i10;
        try {
            if (z10) {
                if (this.f2345w) {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_download_now_shake;
                } else if (this.f2344v) {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_download_now_shake_open;
                } else {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_click_now_shake_look;
                }
            } else if (this.f2345w) {
                resources = getResources();
                i10 = R.string.vlion_custom_ad_click_download;
            } else if (this.f2344v) {
                resources = getResources();
                i10 = R.string.vlion_custom_ad_click_open;
            } else {
                resources = getResources();
                i10 = R.string.vlion_custom_ad_click_look;
            }
            String string = resources.getString(i10);
            return TextUtils.isEmpty(string) ? getResources().getString(R.string.vlion_custom_ad_click_look) : string;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public final void b() {
        try {
            LogVlion.e("VlionRewardVideoActivity initOrientation orientation=" + getResources().getConfiguration().orientation + " mAdOrientation=" + this.f2325c);
            if (1 == this.f2325c) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(1);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c() {
        VlionCustomParseAdData vlionCustomParseAdData;
        try {
            if (this.f2329g != null && (vlionCustomParseAdData = this.f2327e) != null) {
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData.getCsBean(2, -1);
                if (csBean == null) {
                    csBean = this.f2327e.getDefaultShakeCsBean();
                }
                this.B = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new a(csBean));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" initVideoView rewardVlionDownloadVideoContextState :");
            sb2.append(this.f2324b != null);
            LogVlion.e(sb2.toString());
            if (this.f2324b == null) {
                this.f2324b = new b5();
            }
            if (this.f2324b != null) {
                LogVlion.e(" initVideoView videoUrl :" + this.f2326d);
                this.f2324b.a(this.f2326d, new d());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            a(intent);
            setContentView(R.layout.vlion_cn_ad_reward_media);
            if (this.f2329g != null && this.f2327e != null) {
                VlionAppInfo.getInstance().hideNavigationBar(this);
                this.f2330h = (FrameLayout) findViewById(R.id.fl_reward_video);
                this.f2333k = (VlionBaseVideoView) findViewById(R.id.vlionBaseVideoView);
                this.f2337o = (VlionVideoSkipDialogView) findViewById(R.id.ll_video_skip_show);
                this.f2332j = (VlionTimeView) findViewById(R.id.vlion_time_view);
                this.f2331i = (VolumeControlView) findViewById(R.id.soundView);
                this.f2334l = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
                this.f2338p = (FrameLayout) findViewById(R.id.vlion_ad_reward_model_container);
                this.f2335m = (VlionVideoEndCardView) findViewById(R.id.vlionVideoEndcardView);
                this.f2340r = (VlionDownLoadSecondConfirmView) findViewById(R.id.vlionDownLoadSecondConfirmView);
                this.D = (FrameLayout) findViewById(R.id.vlion_loadinglayout);
                this.E = (LinearLayout) findViewById(R.id.vlion_redownload_layout);
                this.F = (ProgressBar) findViewById(R.id.vlion_progressBar_circle);
                VlionADEventManager.getParameterEnter(this.f2329g);
                this.f2327e.isVideo();
                boolean isIs_download = this.f2327e.isIs_download();
                boolean a10 = q.a(getApplicationContext(), this.f2327e.getDp());
                this.f2344v = a10;
                this.f2345w = !a10 && isIs_download;
                this.f2341s = new q0();
                if (isIs_download) {
                    DownloadApkData downloadApkData = new DownloadApkData(this.f2327e, this.f2329g);
                    this.f2343u = downloadApkData;
                    this.f2341s.f3297a = downloadApkData;
                }
                VlionADEventManager.getParameterShow(this.f2329g, "VlionRewardVideoActivity");
                this.A = VlionServiceConfigParse.getInstance().isHotspot();
                int skipSec = this.f2329g.getSkipSec();
                this.C = skipSec;
                if (skipSec <= 0) {
                    this.f2334l.setVisibility(0);
                }
                b();
                a();
                d();
                try {
                    this.f2331i.setVolumeControlListener(new v5(this));
                    VolumeControlView volumeControlView = this.f2331i;
                    boolean z10 = this.f2336n;
                    volumeControlView.getClass();
                    try {
                        volumeControlView.f2560a = z10;
                        volumeControlView.setImageResource(z10 ? R.drawable.vlion_cn_ad_volume_close : R.drawable.vlion_cn_ad_volume_open);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                    finish();
                }
                g1 g1Var = this.f2323a;
                if (g1Var != null) {
                    g1Var.a(getWindow().getDecorView());
                    return;
                }
                return;
            }
            finish();
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            t5 t5Var = this.G;
            if (t5Var != null) {
                t5Var.a();
                this.G = null;
            }
            LogVlion.e("VlionRewardVideoActivity onDestroy------------");
            VlionBaseVideoView vlionBaseVideoView = this.f2333k;
            if (vlionBaseVideoView != null) {
                vlionBaseVideoView.destroy();
            }
            g1 g1Var = this.f2323a;
            if (g1Var != null) {
                g1Var.a(this.f2347y);
                this.f2323a = null;
            }
            e.f2355a.clear();
            b5 b5Var = this.f2324b;
            if (b5Var != null) {
                try {
                    b5Var.f2672d = true;
                    b5Var.f2669a = 1;
                    try {
                        if (j7.f2999a != null) {
                            LogVlion.e("WriteFileUtils onDestroy: ");
                            j7.f2999a.shutdownNow();
                            j7.f2999a = null;
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    b5Var.f2671c = null;
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                e.f2356b = null;
                this.f2324b = null;
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.B);
            DownloadApkData downloadApkData = this.f2343u;
            if (downloadApkData != null) {
                downloadApkData.cancelSchedule();
                this.f2343u.setAdClosed(true);
                if (this.f2343u.isInstallComplete()) {
                    s0.a(this.f2343u.getDownloadId());
                }
            }
            q0 q0Var = this.f2341s;
            if (q0Var != null) {
                q0Var.a();
                this.f2341s = null;
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        LogVlion.e("VlionRewardVideoActivity onKeyDown------------");
        if (i10 == 4) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public final void onPause() {
        MediaPlayer mediaPlayer;
        super.onPause();
        try {
            this.f2348z = false;
            LogVlion.e("VlionRewardVideoActivity onPause------------");
            if (this.f2346x) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.B);
            }
            VlionBaseVideoView vlionBaseVideoView = this.f2333k;
            if (vlionBaseVideoView != null) {
                try {
                    vlionBaseVideoView.f2501f = true;
                    if (vlionBaseVideoView.f2500e && (mediaPlayer = vlionBaseVideoView.f2499d) != null && mediaPlayer.isPlaying()) {
                        LogVlion.e("VlionBaseVideoView mMediaPlayer.pause():");
                        vlionBaseVideoView.f2499d.pause();
                        try {
                            LogVlion.e("VlionBaseVideoView cancelUpdateTimer");
                            if (vlionBaseVideoView.f2504i != null) {
                                VlionHandlerUtils.instant().removeCallbacks(vlionBaseVideoView.f2504i);
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
            t5 t5Var = this.G;
            if (t5Var != null) {
                t5Var.a(this.f2348z);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            this.f2348z = true;
            VlionAppInfo.getInstance().hideNavigationBar(this);
            LogVlion.e("VlionRewardVideoActivity onResume------------");
            if (this.f2346x && !this.f2342t) {
                VlionSensorManagerHelper.getInstance().registerShakeListener(getApplicationContext(), this.B);
            }
            if (this.f2333k != null && this.f2337o.getVisibility() != 0) {
                this.f2333k.c();
            }
            t5 t5Var = this.G;
            if (t5Var != null) {
                t5Var.a(this.f2348z);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(VlionRewardVideoActivity vlionRewardVideoActivity, VlionADClickType vlionADClickType) {
        vlionRewardVideoActivity.getClass();
        try {
            LogVlion.e("VlionRewardVideoViewActivity adAreaClickAction isOpenHot=" + vlionRewardVideoActivity.A);
            vlionRewardVideoActivity.f2341s.a(vlionRewardVideoActivity.getApplicationContext(), vlionRewardVideoActivity.f2327e.getDp(), vlionRewardVideoActivity.f2327e.isIs_download(), new a6(vlionRewardVideoActivity, vlionADClickType));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #2 {all -> 0x010b, blocks: (B:44:0x00f9, B:47:0x00fe), top: B:43:0x00f9, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity.a():void");
    }

    public static void a(VlionRewardVideoActivity vlionRewardVideoActivity, int i10) {
        MediaPlayer mediaPlayer;
        vlionRewardVideoActivity.getClass();
        try {
            boolean z10 = vlionRewardVideoActivity.f2329g.getRetainWin() == 1;
            LogVlion.e("VlionRewardVideoViewActivity btn_jump leftTime=" + i10 + " retainWin=" + z10 + " vlionAdapterADConfig.getRetainWin()=" + vlionRewardVideoActivity.f2329g.getRetainWin());
            if (z10) {
                vlionRewardVideoActivity.f2337o.setVlionVideoSkipCallBack(new y5(vlionRewardVideoActivity));
                vlionRewardVideoActivity.f2337o.a("再看" + i10 + "秒");
                VlionBaseVideoView vlionBaseVideoView = vlionRewardVideoActivity.f2333k;
                if (vlionBaseVideoView != null) {
                    try {
                        vlionBaseVideoView.f2501f = true;
                        if (vlionBaseVideoView.f2500e && (mediaPlayer = vlionBaseVideoView.f2499d) != null && mediaPlayer.isPlaying()) {
                            LogVlion.e("VlionBaseVideoView mMediaPlayer.pause():");
                            vlionBaseVideoView.f2499d.pause();
                            try {
                                LogVlion.e("VlionBaseVideoView cancelUpdateTimer");
                                if (vlionBaseVideoView.f2504i != null) {
                                    VlionHandlerUtils.instant().removeCallbacks(vlionBaseVideoView.f2504i);
                                }
                            } catch (Throwable th2) {
                                VlionSDkManager.getInstance().upLoadCatchException(th2);
                            }
                        }
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                    }
                }
            } else {
                vlionRewardVideoActivity.finish();
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public static void a(VlionRewardVideoActivity vlionRewardVideoActivity, String str) {
        VlionBaseVideoView vlionBaseVideoView;
        vlionRewardVideoActivity.getClass();
        try {
            if (!vlionRewardVideoActivity.isFinishing() && (vlionBaseVideoView = vlionRewardVideoActivity.f2333k) != null) {
                vlionBaseVideoView.setDataSource(str);
                vlionRewardVideoActivity.f2333k.setClosedVolumePlay(vlionRewardVideoActivity.f2336n);
                vlionRewardVideoActivity.f2333k.e();
                vlionRewardVideoActivity.f2333k.setVideoScaleMode(vlionRewardVideoActivity.f2328f);
                vlionRewardVideoActivity.f2333k.setAdVideoListener(new w5(vlionRewardVideoActivity));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(VlionRewardVideoActivity vlionRewardVideoActivity, VlionADClickType vlionADClickType) {
        vlionRewardVideoActivity.getClass();
        try {
            LogVlion.e("VlionRewardVideoViewActivity adButtonClickAction ");
            VlionCustomAdActiveType$VlionCustomTarget a10 = vlionRewardVideoActivity.f2341s.a(vlionRewardVideoActivity.getApplicationContext(), vlionRewardVideoActivity.f2329g, vlionRewardVideoActivity.f2327e, new u5(vlionRewardVideoActivity));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = vlionRewardVideoActivity.f2341s;
                Context applicationContext = vlionRewardVideoActivity.getApplicationContext();
                VlionCustomParseAdData vlionCustomParseAdData = vlionRewardVideoActivity.f2327e;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(applicationContext, vlionCustomParseAdData));
            }
            g1 g1Var = vlionRewardVideoActivity.f2323a;
            if (g1Var != null) {
                g1Var.a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(Intent intent) {
        try {
            this.f2326d = intent.getStringExtra("VlionVideoPath");
            this.f2329g = (VlionAdapterADConfig) intent.getSerializableExtra("VlionAdapterADConfig");
            this.f2327e = (VlionCustomParseAdData) intent.getSerializableExtra("VlionCustomParseAdDataString");
            this.f2323a = e.f2355a.get(this.f2326d);
            this.f2324b = e.f2356b;
            VlionAdapterADConfig vlionAdapterADConfig = this.f2329g;
            if (vlionAdapterADConfig != null) {
                this.f2328f = vlionAdapterADConfig.getImageScale();
                this.f2325c = this.f2329g.getScreenType();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }
}
