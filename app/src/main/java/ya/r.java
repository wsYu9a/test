package ya;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.AdComplianceInfoViewBinding;
import com.martian.mibook.ui.AudiobookAdFrameLayout;
import java.util.Random;

/* loaded from: classes3.dex */
public class r extends com.martian.mibook.application.b {
    public final AudiobookAdFrameLayout G;
    public AppTaskList H;
    public final b I;
    public final int J;

    public class a extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ GroMoreAd.AdViewHolder f33353a;

        /* renamed from: b */
        public final /* synthetic */ AppTask f33354b;

        public a(GroMoreAd.AdViewHolder adViewHolder, AppTask appTask) {
            this.f33353a = adViewHolder;
            this.f33354b = appTask;
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (MiConfigSingleton.b2().B0()) {
                this.f33353a.mAdLogoDesc.setText(String.valueOf(this.f33354b.getEcpm()));
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            r.this.d0();
        }
    }

    public interface b {
        void a(int i10, int i11);
    }

    public r(Activity activity, String str, AudiobookAdFrameLayout audiobookAdFrameLayout, b bVar) {
        super(activity, str == null ? "" : str, null, false);
        this.G = audiobookAdFrameLayout;
        this.I = bVar;
        this.J = MiConfigSingleton.b2().c2().getAudiobookAdMisClickRate();
    }

    public static /* synthetic */ void r0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPermissionUrl());
    }

    public static /* synthetic */ void s0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPrivacyUrl());
    }

    public static /* synthetic */ void t0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppFunctionDescUrl());
    }

    @Override // com.martian.mibook.application.b
    public int A() {
        return 0;
    }

    @Override // com.martian.mibook.application.b
    public int B() {
        return 0;
    }

    @Override // com.martian.mibook.application.b
    public int C() {
        return MiConfigSingleton.b2().c2().getFlowMisClickPlatform();
    }

    @Override // com.martian.mibook.application.b
    public int D() {
        return 0;
    }

    @Override // com.martian.mibook.application.b
    public String E() {
        return e0.S;
    }

    @Override // com.martian.mibook.application.b
    public String F() {
        return "听书";
    }

    @Override // com.martian.mibook.application.b
    public void Y(AppTaskList appTaskList) {
        super.Y(appTaskList);
        w0();
    }

    @Override // com.martian.mibook.application.b
    public boolean j0() {
        return true;
    }

    @Override // com.martian.mibook.application.b
    public void m() {
        com.martian.mibook.application.a.G(this.H);
        this.H = null;
    }

    @Override // com.martian.mibook.application.b
    public AppTask r() {
        return MiConfigSingleton.b2().H1().S(E());
    }

    @Override // com.martian.mibook.application.b
    public int t() {
        return 0;
    }

    @Override // com.martian.mibook.application.b
    public int u() {
        return 0;
    }

    public final /* synthetic */ void u0(Activity activity, AppTask appTask, View view, GroMoreAd.AdViewHolder adViewHolder) {
        MiConfigSingleton.b2().H1().A(activity, appTask, this.G, view.findViewById(R.id.audiobook_ad_view), adViewHolder, new a(adViewHolder, appTask));
    }

    public void v0() {
        R();
    }

    @Override // com.martian.mibook.application.b
    public int w() {
        return 0;
    }

    public final void w0() {
        ViewStub viewStub;
        View findViewById;
        AppTaskList p10 = p();
        this.H = p10;
        if (p10 == null) {
            return;
        }
        AppTask appTask = p10.getApps().get(0);
        Activity activity = getActivity();
        if (appTask == null || activity == null) {
            return;
        }
        appTask.exposed = false;
        this.G.removeAllViews();
        View inflate = activity.getLayoutInflater().inflate(R.layout.audiobook_ad_item, (ViewGroup) null);
        this.G.addView(inflate);
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) inflate.findViewById(R.id.audiobook_ad_title);
        adViewHolder.mDescription = (TextView) inflate.findViewById(R.id.audiobook_ad_desc);
        adViewHolder.mPoster = (ImageView) inflate.findViewById(R.id.audiobook_ad_poster);
        adViewHolder.videoView = (FrameLayout) inflate.findViewById(R.id.audiobook_ad_video);
        adViewHolder.mCreativeButton = (Button) inflate.findViewById(R.id.audiobook_ad_native_creative);
        adViewHolder.mAdLogo = (ImageView) inflate.findViewById(R.id.audiobook_ad_logo);
        adViewHolder.mAdLogoDesc = (TextView) inflate.findViewById(R.id.audiobook_ad_logo_desc);
        adViewHolder.mIcon = (ImageView) inflate.findViewById(R.id.audiobook_ad_image);
        adViewHolder.complianceView = (ViewStub) inflate.findViewById(R.id.audiobook_ad_compliance_info_view);
        adViewHolder.mTitle.setText(appTask.getTitle());
        adViewHolder.mDescription.setText(appTask.getDesc());
        adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
        adViewHolder.mCreativeButton.setText(appTask.buttonText);
        MiConfigSingleton.b2().H1().R0(activity, adViewHolder.mPoster, adViewHolder.mIcon, appTask, 8);
        if (appTask.isShakeStyle() && AdConfig.UnionType.CSJ.equalsIgnoreCase(appTask.source) && (findViewById = inflate.findViewById(R.id.audiobook_ad_shake_view)) != null) {
            findViewById.setVisibility(0);
        }
        ComplianceInfo complianceInfo = appTask.getComplianceInfo();
        if (complianceInfo != null && (viewStub = adViewHolder.complianceView) != null) {
            viewStub.setLayoutResource(R.layout.ad_compliance_info_view);
            AdComplianceInfoViewBinding bind = AdComplianceInfoViewBinding.bind(adViewHolder.complianceView.inflate());
            bind.adCompliancePermission.setOnClickListener(new View.OnClickListener() { // from class: ya.n

                /* renamed from: b */
                public final /* synthetic */ Activity f33311b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33312c;

                public /* synthetic */ n(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.r0(activity, complianceInfo, view);
                }
            });
            bind.adCompliancePrivacy.setOnClickListener(new View.OnClickListener() { // from class: ya.o

                /* renamed from: b */
                public final /* synthetic */ Activity f33319b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33320c;

                public /* synthetic */ o(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.s0(activity, complianceInfo, view);
                }
            });
            bind.adComplianceFunction.setOnClickListener(new View.OnClickListener() { // from class: ya.p

                /* renamed from: b */
                public final /* synthetic */ Activity f33328b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33329c;

                public /* synthetic */ p(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.t0(activity, complianceInfo, view);
                }
            });
            bind.adComplianceCompany.setText(complianceInfo2.getAppDeveloperName());
            if (!ba.l.q(complianceInfo2.getAppVersion())) {
                bind.adComplianceVersion.setText(appTask.getComplianceInfo().getAppVersion());
            }
            if (!ba.l.q(complianceInfo2.getAppName())) {
                adViewHolder.mTitle.setText(complianceInfo2.getAppName());
            }
        }
        boolean x02 = x0();
        if (x02) {
            View findViewById2 = inflate.findViewById(R.id.mis_click_view);
            findViewById2.setVisibility(0);
            if (ConfigSingleton.D().B0()) {
                findViewById2.setBackgroundColor(ContextCompat.getColor(getActivity(), com.martian.libmars.R.color.night_text_color_unclickable));
            }
        }
        double picRatio = appTask.getPicRatio();
        int i10 = ba.m.i(activity2);
        int i11 = ConfigSingleton.i(64.0f);
        this.I.a(Math.min(i10 + i11, ((int) (ba.m.i(activity2) * picRatio)) + i11), x02 ? ConfigSingleton.i(332.0f) : 0);
        this.G.post(new Runnable() { // from class: ya.q

            /* renamed from: c */
            public final /* synthetic */ Activity f33343c;

            /* renamed from: d */
            public final /* synthetic */ AppTask f33344d;

            /* renamed from: e */
            public final /* synthetic */ View f33345e;

            /* renamed from: f */
            public final /* synthetic */ GroMoreAd.AdViewHolder f33346f;

            public /* synthetic */ q(Activity activity2, AppTask appTask2, View inflate2, GroMoreAd.AdViewHolder adViewHolder2) {
                activity = activity2;
                appTask = appTask2;
                inflate = inflate2;
                adViewHolder = adViewHolder2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r.this.u0(activity, appTask, inflate, adViewHolder);
            }
        });
    }

    @Override // com.martian.mibook.application.b
    public int x() {
        return 0;
    }

    public final boolean x0() {
        if (this.J <= 0) {
            return false;
        }
        return this.J <= new Random().nextInt(1000);
    }

    @Override // com.martian.mibook.application.b
    public int y() {
        return 0;
    }
}
