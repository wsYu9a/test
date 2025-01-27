package com.martian.mibook.application;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import androidx.fragment.app.FragmentActivity;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.mibook.R;
import com.martian.mibook.application.RewardVideoAdManager;
import com.martian.mibook.fragment.dialog.VideoBlockAdFragment;
import com.martian.mibook.mvvm.utils.SensorHook;
import java.lang.ref.WeakReference;
import je.v0;
import l9.t0;
import ya.e0;

/* loaded from: classes3.dex */
public class RewardVideoAdManager {

    /* renamed from: a */
    public final WeakReference<FragmentActivity> f13404a;

    /* renamed from: b */
    public VideoType f13405b;

    /* renamed from: c */
    public AppTask f13406c;

    /* renamed from: d */
    public final d8.b f13407d = new a();

    public enum VideoType {
        AUTHOR_BONUS,
        BLOCK_AD_FIRST,
        BLOCK_AD_SECOND,
        BLOCK_AD_DIALOG,
        BLOCK_AD_MANUAL,
        CACHE_CHAPTERS,
        TTS,
        AUTO_SLIDE,
        UNLOCK_CHAPTER,
        BOOK_ACTIVATE
    }

    public class a extends d8.b {

        /* renamed from: com.martian.mibook.application.RewardVideoAdManager$a$a */
        public class C0524a implements v0.k {
            public C0524a() {
            }

            @Override // je.v0.k
            public void a() {
                RewardVideoAdManager.this.i();
            }

            @Override // je.v0.k
            public void b() {
                Activity activity = (Activity) RewardVideoAdManager.this.f13404a.get();
                ReadingInstance.z().m0(activity, MiConfigSingleton.b2().I1(VideoType.BLOCK_AD_SECOND.equals(RewardVideoAdManager.this.f13405b)));
                MiConfigSingleton.b2().H1().N0(activity, 1);
                MiConfigSingleton.b2().H1().U0(activity, RewardVideoAdManager.this.f13406c, RewardVideoAdManager.this.f13407d, RewardVideoAdManager.this.f13407d);
            }
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d8.b, d8.a
        public void a() {
            Activity activity;
            super.a();
            if (VideoType.BLOCK_AD_SECOND.equals(RewardVideoAdManager.this.f13405b)) {
                RewardVideoAdManager.this.i();
                return;
            }
            if (!RewardVideoAdManager.this.k() || (activity = (Activity) RewardVideoAdManager.this.f13404a.get()) == 0) {
                return;
            }
            t0.b(activity, "视频加载失败");
            if (activity instanceof gd.b) {
                ((gd.b) activity).y(false, "");
            }
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (adConfig.isCsjAd() || adConfig.isDxAd()) {
                MiConfigSingleton.b2().H1().y(adConfig);
                SensorHook.INSTANCE.getInstance().enableSensor();
            }
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.isEmpty()) {
                return;
            }
            RewardVideoAdManager.this.f13406c = appTaskList.getApps().get(0);
            int rewardVideoAdEnquiryEcpm = MiConfigSingleton.b2().c2().getRewardVideoAdEnquiryEcpm();
            boolean z10 = rewardVideoAdEnquiryEcpm > 0 && RewardVideoAdManager.this.f13406c.getEcpm() >= rewardVideoAdEnquiryEcpm;
            if (VideoType.AUTHOR_BONUS.equals(RewardVideoAdManager.this.f13405b)) {
                v0.M0((Activity) RewardVideoAdManager.this.f13404a.get(), RewardVideoAdManager.this.f13406c, z10, this);
                return;
            }
            if (VideoType.BLOCK_AD_FIRST.equals(RewardVideoAdManager.this.f13405b) || VideoType.BLOCK_AD_SECOND.equals(RewardVideoAdManager.this.f13405b)) {
                v0.L0((Activity) RewardVideoAdManager.this.f13404a.get(), VideoType.BLOCK_AD_SECOND.equals(RewardVideoAdManager.this.f13405b), z10, new C0524a());
                return;
            }
            if (RewardVideoAdManager.this.k()) {
                ComponentCallbacks2 componentCallbacks2 = (Activity) RewardVideoAdManager.this.f13404a.get();
                if (componentCallbacks2 != null && (componentCallbacks2 instanceof gd.b)) {
                    ((gd.b) componentCallbacks2).y(false, "");
                }
                MiConfigSingleton.b2().H1().U0((Activity) RewardVideoAdManager.this.f13404a.get(), RewardVideoAdManager.this.f13406c, RewardVideoAdManager.this.f13407d, RewardVideoAdManager.this.f13407d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            if (VideoType.AUTHOR_BONUS.equals(RewardVideoAdManager.this.f13405b)) {
                MiConfigSingleton.b2().e2().q((FragmentActivity) RewardVideoAdManager.this.f13404a.get(), e0.O, "android", e0.f33151g0, z10, 1, null);
                return;
            }
            Activity activity = (Activity) RewardVideoAdManager.this.f13404a.get();
            if (z10) {
                t0.b(activity, "观看成功！");
            } else {
                t0.b(activity, "视频观看失败");
            }
            if (activity != 0 && (activity instanceof gd.b)) {
                if (VideoType.BLOCK_AD_FIRST.equals(RewardVideoAdManager.this.f13405b) || VideoType.BLOCK_AD_SECOND.equals(RewardVideoAdManager.this.f13405b) || VideoType.BLOCK_AD_DIALOG.equals(RewardVideoAdManager.this.f13405b) || VideoType.BLOCK_AD_MANUAL.equals(RewardVideoAdManager.this.f13405b)) {
                    if (z10) {
                        ((gd.b) activity).k0();
                        return;
                    } else {
                        RewardVideoAdManager.this.i();
                        return;
                    }
                }
                if (z10) {
                    if (VideoType.CACHE_CHAPTERS.equals(RewardVideoAdManager.this.f13405b)) {
                        ((gd.b) activity).c();
                        return;
                    }
                    if (VideoType.TTS.equals(RewardVideoAdManager.this.f13405b)) {
                        ((gd.b) activity).s0();
                        return;
                    }
                    if (VideoType.AUTO_SLIDE.equals(RewardVideoAdManager.this.f13405b)) {
                        ((gd.b) activity).p0();
                    } else if (VideoType.UNLOCK_CHAPTER.equals(RewardVideoAdManager.this.f13405b)) {
                        ((gd.b) activity).W();
                    } else if (VideoType.BOOK_ACTIVATE.equals(RewardVideoAdManager.this.f13405b)) {
                        ((gd.b) activity).R();
                    }
                }
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (adConfig.isCsjAd() || adConfig.isDxAd()) {
                MiConfigSingleton.b2().H1().x(adConfig);
            }
        }
    }

    public RewardVideoAdManager(FragmentActivity fragmentActivity) {
        this.f13404a = new WeakReference<>(fragmentActivity);
    }

    public final void i() {
        FragmentActivity fragmentActivity = this.f13404a.get();
        if (fragmentActivity == null || !(fragmentActivity instanceof gd.b)) {
            return;
        }
        ((gd.b) fragmentActivity).O0();
    }

    public void j() {
        AppTask appTask = this.f13406c;
        if (appTask != null) {
            appTask.origin = null;
            this.f13406c = null;
        }
    }

    public final boolean k() {
        return VideoType.BLOCK_AD_DIALOG.equals(this.f13405b) || VideoType.BLOCK_AD_MANUAL.equals(this.f13405b) || VideoType.CACHE_CHAPTERS.equals(this.f13405b) || VideoType.TTS.equals(this.f13405b) || VideoType.AUTO_SLIDE.equals(this.f13405b) || VideoType.UNLOCK_CHAPTER.equals(this.f13405b) || VideoType.BOOK_ACTIVATE.equals(this.f13405b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void l(FragmentActivity fragmentActivity) {
        if (fragmentActivity == 0 || fragmentActivity.isFinishing()) {
            return;
        }
        if (fragmentActivity instanceof gd.b) {
            ((gd.b) fragmentActivity).y(true, fragmentActivity.getString(R.string.reward_video_loading));
        }
        m(VideoType.BLOCK_AD_DIALOG);
    }

    public void m(VideoType videoType) {
        this.f13405b = videoType;
        if (com.martian.mibook.application.a.z(this.f13406c)) {
            MiConfigSingleton.b2().H1().I0(this.f13404a.get(), false, this.f13407d);
        } else {
            this.f13407d.i(null, new AppTaskList().addAppTask(this.f13406c));
        }
    }

    public boolean n() {
        c e22 = MiConfigSingleton.b2().e2();
        if (!e22.l() || !e22.p() || e22.U0() || e22.n()) {
            return false;
        }
        m(VideoType.AUTHOR_BONUS);
        return true;
    }

    public boolean o(boolean z10) {
        if (!ReadingInstance.z().h(this.f13404a.get())) {
            return false;
        }
        m(z10 ? VideoType.BLOCK_AD_SECOND : VideoType.BLOCK_AD_FIRST);
        return true;
    }

    public void p(FragmentActivity fragmentActivity, String str, boolean z10) {
        VideoBlockAdFragment.P(fragmentActivity, str, z10, new VideoBlockAdFragment.a() { // from class: ya.i2

            /* renamed from: b */
            public final /* synthetic */ FragmentActivity f33250b;

            public /* synthetic */ i2(FragmentActivity fragmentActivity2) {
                fragmentActivity = fragmentActivity2;
            }

            @Override // com.martian.mibook.fragment.dialog.VideoBlockAdFragment.a
            public final void a() {
                RewardVideoAdManager.this.l(fragmentActivity);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(VideoType videoType) {
        FragmentActivity fragmentActivity = this.f13404a.get();
        if (fragmentActivity != 0 && (fragmentActivity instanceof gd.b)) {
            ((gd.b) fragmentActivity).y(true, fragmentActivity.getString(R.string.reward_video_loading));
        }
        m(videoType);
    }
}
