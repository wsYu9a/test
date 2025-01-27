package je;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.libugrowth.request.UpgradeDownloadLinkParams;
import com.martian.mibook.R;
import com.martian.mibook.activity.TeenagerGuideActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookInfoMenuBinding;
import com.martian.mibook.databinding.DialogCoinsExplainBinding;
import com.martian.mibook.databinding.DialogVideoBonusBinding;
import com.martian.mibook.databinding.MartianPopupwindowAuthorBinding;
import com.martian.mibook.databinding.PopupwindowParagraphCommentGuideBinding;
import com.martian.mibook.databinding.UpgradeDialogBinding;
import com.martian.mibook.lib.account.request.OfflineLinkParams;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExtraBonus;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import java.io.File;
import java.io.IOException;
import je.v0;
import l9.i0;
import l9.m0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import ya.j2;
import z8.e;

/* loaded from: classes3.dex */
public class v0 {

    public class a implements m0.c {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f27507a;

        /* renamed from: b */
        public final /* synthetic */ TYActivity f27508b;

        /* renamed from: c */
        public final /* synthetic */ e9.c f27509c;

        public a(FragmentActivity fragmentActivity, TYActivity tYActivity, e9.c cVar) {
            this.f27507a = fragmentActivity;
            this.f27508b = tYActivity;
            this.f27509c = cVar;
        }

        @Override // l9.m0.c
        public void a(Drawable drawable) {
            v0.J0(this.f27507a, this.f27508b, this.f27509c, "首页弹窗", drawable);
        }

        @Override // l9.m0.c
        public void onError() {
            v0.J0(this.f27507a, this.f27508b, this.f27509c, "首页弹窗", null);
        }
    }

    public class b extends d8.b {
    }

    public class d extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f27513a;

        /* renamed from: b */
        public final /* synthetic */ int f27514b;

        /* renamed from: c */
        public final /* synthetic */ long f27515c;

        public d(FragmentActivity fragmentActivity, int i10, long j10) {
            this.f27513a = fragmentActivity;
            this.f27514b = i10;
            this.f27515c = j10;
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            FragmentActivity fragmentActivity = this.f27513a;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            l9.t0.b(this.f27513a, "视频加载失败");
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            FragmentActivity fragmentActivity = this.f27513a;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            if (z10) {
                v0.V(this.f27513a, this.f27514b, this.f27515c);
            } else {
                l9.t0.b(this.f27513a, "视频观看失败");
            }
        }
    }

    public interface h {
        void a(TYActivity tYActivity);
    }

    public interface i {
        void a();
    }

    public interface j {
        void a(int i10);
    }

    public interface k {
        void a();

        void b();
    }

    public interface l {
        void a();
    }

    public interface m {
        void a();
    }

    public interface n {
        void a();
    }

    public interface o {
        void a(int i10);
    }

    public static /* synthetic */ void A0(CheckBox checkBox, CheckBox checkBox2, View view) {
        checkBox.setChecked(false);
        checkBox2.setChecked(true);
    }

    public static /* synthetic */ void C0(AlertDialog alertDialog, CheckBox checkBox, o oVar, View view) {
        alertDialog.dismiss();
        int i10 = !checkBox.isChecked() ? 1 : 0;
        if (oVar != null) {
            oVar.a(i10);
        }
    }

    public static /* synthetic */ void D0(Activity activity, AlertDialog alertDialog, View view) {
        ac.a.k(activity, "青少年模式-开启");
        activity.startActivity(new Intent(activity, (Class<?>) TeenagerGuideActivity.class));
        alertDialog.dismiss();
    }

    public static /* synthetic */ void E0(Activity activity, AlertDialog alertDialog, View view) {
        ac.a.k(activity, "青少年模式-关闭");
        alertDialog.dismiss();
    }

    public static /* synthetic */ void F0(Activity activity, AlertDialog alertDialog, View view) {
        ac.a.k(activity, "青少年模式-关闭");
        alertDialog.dismiss();
    }

    public static /* synthetic */ void I0(UpgradeInfo upgradeInfo, Activity activity, String str, AlertDialog alertDialog, UpgradeDialogBinding upgradeDialogBinding, String str2, View view) {
        if (upgradeInfo.getId() == null) {
            alertDialog.dismiss();
            return;
        }
        if (i8.g.l(activity, str) && i8.g.k(activity, new File(str))) {
            alertDialog.dismiss();
            return;
        }
        if (ConfigSingleton.D().G0()) {
            l9.t0.b(activity, "没有网络");
            alertDialog.dismiss();
        } else if (ConfigSingleton.D().N0()) {
            b1(activity, upgradeDialogBinding, alertDialog, upgradeInfo, str, str2);
        } else {
            l9.i0.z0(activity, activity.getString(R.string.confirm_message), activity.getString(R.string.not_wifi_hint), new i0.l() { // from class: je.l

                /* renamed from: a */
                public final /* synthetic */ Activity f27447a;

                /* renamed from: b */
                public final /* synthetic */ UpgradeDialogBinding f27448b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27449c;

                /* renamed from: d */
                public final /* synthetic */ UpgradeInfo f27450d;

                /* renamed from: e */
                public final /* synthetic */ String f27451e;

                /* renamed from: f */
                public final /* synthetic */ String f27452f;

                public /* synthetic */ l(Activity activity2, UpgradeDialogBinding upgradeDialogBinding2, AlertDialog alertDialog2, UpgradeInfo upgradeInfo2, String str3, String str22) {
                    activity = activity2;
                    upgradeDialogBinding = upgradeDialogBinding2;
                    alertDialog = alertDialog2;
                    upgradeInfo = upgradeInfo2;
                    str = str3;
                    str2 = str22;
                }

                @Override // l9.i0.l
                public final void a() {
                    v0.b1(activity, upgradeDialogBinding, alertDialog, upgradeInfo, str, str2);
                }
            });
        }
    }

    public static void J0(Activity activity, TYActivity tYActivity, e9.c cVar, String str, Drawable drawable) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_push, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rules_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.rd_close);
        TextView textView = (TextView) inflate.findViewById(R.id.rules_button);
        if (tYActivity.getMarginx() != null) {
            imageView.setPadding(ConfigSingleton.i(tYActivity.getMarginx().intValue()), 0, ConfigSingleton.i(tYActivity.getMarginx().intValue()), 0);
        }
        if (drawable != null) {
            l9.m0.h(activity, drawable, imageView, 8);
        } else {
            l9.m0.y(activity, tYActivity.getDialogImage(), imageView, 8);
        }
        if (ba.l.q(tYActivity.getButtonText())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            l9.a.d(textView);
        }
        ac.a.l(activity, str + "-" + tYActivity.getTitle() + "-曝光");
        AlertDialog P = P(activity, inflate, true);
        if (P == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: je.g0

            /* renamed from: b */
            public final /* synthetic */ Activity f27416b;

            /* renamed from: c */
            public final /* synthetic */ String f27417c;

            /* renamed from: d */
            public final /* synthetic */ TYActivity f27418d;

            /* renamed from: e */
            public final /* synthetic */ e9.c f27419e;

            /* renamed from: f */
            public final /* synthetic */ AlertDialog f27420f;

            public /* synthetic */ g0(Activity activity2, String str2, TYActivity tYActivity2, e9.c cVar2, AlertDialog P2) {
                activity = activity2;
                str = str2;
                tYActivity = tYActivity2;
                cVar = cVar2;
                P = P2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.Z(activity, str, tYActivity, cVar, P, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: je.h0

            /* renamed from: b */
            public final /* synthetic */ Activity f27422b;

            /* renamed from: c */
            public final /* synthetic */ String f27423c;

            /* renamed from: d */
            public final /* synthetic */ TYActivity f27424d;

            /* renamed from: e */
            public final /* synthetic */ AlertDialog f27425e;

            public /* synthetic */ h0(Activity activity2, String str2, TYActivity tYActivity2, AlertDialog P2) {
                activity = activity2;
                str = str2;
                tYActivity = tYActivity2;
                P = P2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.a0(activity, str, tYActivity, P, view);
            }
        });
    }

    public static void K0(FragmentActivity fragmentActivity, TYActivity tYActivity, e9.c cVar) {
        if (!l9.m0.B(fragmentActivity) || tYActivity == null) {
            return;
        }
        l9.m0.E(fragmentActivity, tYActivity.getDialogImage(), new a(fragmentActivity, tYActivity, cVar));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: je.l0.<init>(com.martian.mibook.databinding.DialogVideoBonusBinding, android.app.Activity, je.v0$k, android.app.AlertDialog):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public static void L0(android.app.Activity r5, boolean r6, boolean r7, je.v0.k r8) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            android.view.LayoutInflater r0 = r5.getLayoutInflater()
            int r1 = com.martian.mibook.R.layout.dialog_video_bonus
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            com.martian.mibook.databinding.DialogVideoBonusBinding r1 = com.martian.mibook.databinding.DialogVideoBonusBinding.bind(r0)
            com.martian.mibook.ui.reader.ReaderThemeTextView r2 = r1.videoAdsMinutes
            com.martian.mibook.application.MiConfigSingleton r3 = com.martian.mibook.application.MiConfigSingleton.b2()
            int r3 = r3.I1(r6)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.setText(r3)
            com.martian.mibook.application.MiConfigSingleton r2 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.ReaderThemeManager r2 = r2.h2()
            com.martian.mibook.data.theme.MiReadingTheme r2 = r2.k()
            com.martian.mibook.ui.reader.ReaderThemeTextView r3 = r1.videoAdsGrab
            int r4 = r2.getTextColorThirdly()
            r3.setTextColor(r4)
            com.martian.mibook.ui.reader.ReaderThemeTextView r3 = r1.videoAdsDesc
            int r2 = r2.getTextColorPrimary()
            r3.setTextColor(r2)
            if (r6 == 0) goto L7d
            com.martian.mibook.ui.reader.ReaderThemeTextView r6 = r1.videoAdsGrab
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = com.martian.mibook.R.string.video_ads_time_up
            java.lang.String r3 = r5.getString(r3)
            r2.append(r3)
            int r3 = com.martian.mibook.R.string.video_ads_time_out
            java.lang.String r3 = r5.getString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.setText(r2)
            com.martian.mibook.ui.reader.ReaderThemeTextView r6 = r1.videoAdsDesc
            int r2 = com.martian.mibook.R.string.video_ads_look_title
            java.lang.String r2 = r5.getString(r2)
            r6.setText(r2)
            com.martian.mibook.ui.reader.ReaderThemeTextView r6 = r1.videoAdsHint
            com.martian.mibook.application.MiConfigSingleton r2 = com.martian.mibook.application.MiConfigSingleton.b2()
            java.lang.String r3 = "再免"
            java.lang.String r2 = r2.s(r3)
            r6.setText(r2)
        L7d:
            r6 = 0
            android.app.AlertDialog r0 = P(r5, r0, r6)
            if (r7 == 0) goto La3
            com.martian.apptask.widget.CountdownNumberTextView r7 = r1.videoAdsCountdown
            if (r7 == 0) goto La3
            r7.setVisibility(r6)
            com.martian.apptask.widget.CountdownNumberTextView r6 = r1.videoAdsCountdown
            java.lang.String r7 = "秒后自动领取"
            r6.setSufText(r7)
            com.martian.apptask.widget.CountdownNumberTextView r6 = r1.videoAdsCountdown
            r7 = 5
            r6.m(r7)
            com.martian.apptask.widget.CountdownNumberTextView r6 = r1.videoAdsCountdown
            je.l0 r7 = new je.l0
            r7.<init>()
            r6.setOnCountDownFinishListener(r7)
            goto La8
        La3:
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r5 = r1.btOperate
            l9.a.d(r5)
        La8:
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r5 = r1.btOperate
            je.m0 r6 = new je.m0
            r6.<init>()
            r5.setOnClickListener(r6)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r5 = r1.videoAdsClose
            je.n0 r6 = new je.n0
            r6.<init>()
            r5.setOnClickListener(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: je.v0.L0(android.app.Activity, boolean, boolean, je.v0$k):void");
    }

    public static void M0(Activity activity, AppTask appTask, boolean z10, d8.b bVar) {
        CountdownNumberTextView countdownNumberTextView;
        if (l9.m0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_author, (ViewGroup) null);
            MartianPopupwindowAuthorBinding bind = MartianPopupwindowAuthorBinding.bind(inflate);
            bind.bonusNum.setText(String.valueOf(MiConfigSingleton.b2().e2().Q()));
            bind.bonusUnit.setText(activity.getString(R.string.bonus_unit));
            l9.a.d(bind.bonusGrab);
            ac.a.r(activity, "作者红包-" + W() + "曝光");
            MiConfigSingleton.b2().e2().y0();
            AlertDialog P = P(activity, inflate, false);
            if (P == null) {
                return;
            }
            bind.bonusGrab.setOnClickListener(new View.OnClickListener() { // from class: je.q0

                /* renamed from: b */
                public final /* synthetic */ Activity f27473b;

                /* renamed from: c */
                public final /* synthetic */ AppTask f27474c;

                /* renamed from: d */
                public final /* synthetic */ d8.b f27475d;

                /* renamed from: e */
                public final /* synthetic */ MartianPopupwindowAuthorBinding f27476e;

                /* renamed from: f */
                public final /* synthetic */ AlertDialog f27477f;

                public /* synthetic */ q0(Activity activity2, AppTask appTask2, d8.b bVar2, MartianPopupwindowAuthorBinding bind2, AlertDialog P2) {
                    activity = activity2;
                    appTask = appTask2;
                    bVar = bVar2;
                    bind = bind2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.e0(activity, appTask, bVar, bind, P, view);
                }
            });
            bind2.bonusClose.setOnClickListener(new View.OnClickListener() { // from class: je.r0

                /* renamed from: b */
                public final /* synthetic */ Activity f27480b;

                /* renamed from: c */
                public final /* synthetic */ MartianPopupwindowAuthorBinding f27481c;

                /* renamed from: d */
                public final /* synthetic */ AlertDialog f27482d;

                public /* synthetic */ r0(Activity activity2, MartianPopupwindowAuthorBinding bind2, AlertDialog P2) {
                    activity = activity2;
                    bind = bind2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.f0(activity, bind, P, view);
                }
            });
            if (!z10 || (countdownNumberTextView = bind2.bonusCountdown) == null) {
                return;
            }
            countdownNumberTextView.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) bind2.bonusClose.getLayoutParams()).setMargins(0, ConfigSingleton.i(44.0f), 0, 0);
            bind2.bonusCountdown.setSufText("秒后自动领取");
            bind2.bonusCountdown.m(5);
            bind2.bonusCountdown.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: je.s0

                /* renamed from: b */
                public final /* synthetic */ Activity f27485b;

                /* renamed from: c */
                public final /* synthetic */ AppTask f27486c;

                /* renamed from: d */
                public final /* synthetic */ d8.b f27487d;

                /* renamed from: e */
                public final /* synthetic */ AlertDialog f27488e;

                public /* synthetic */ s0(Activity activity2, AppTask appTask2, d8.b bVar2, AlertDialog P2) {
                    activity = activity2;
                    appTask = appTask2;
                    bVar = bVar2;
                    P = P2;
                }

                @Override // com.martian.apptask.widget.CountdownNumberTextView.b
                public final void a(CountdownNumberTextView countdownNumberTextView2) {
                    v0.g0(MartianPopupwindowAuthorBinding.this, activity, appTask, bVar, P, countdownNumberTextView2);
                }
            });
        }
    }

    public static void N0(Activity activity, int i10, boolean z10) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.martian_popupwindow_book_alert, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ba_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ba_close);
        TextView textView = (TextView) inflate.findViewById(R.id.ba_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ba_title1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ba_title2);
        if (i10 == 1 || i10 == 2) {
            l9.a.d(textView);
            imageView.setImageResource(R.drawable.bg_book_alert_offline);
            textView.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default));
            textView2.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default));
            textView3.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default));
            textView.setText("领取免费小说");
            textView2.setText(i10 == 1 ? "由于版权合作到期，本书于4月20日将正式下架。" : "由于版权合作到期，本书于4月20日正式下架。");
            textView3.setText("为表歉意，为您准备了大量免费好书");
        } else {
            imageView.setImageResource(R.drawable.bg_book_alert_free);
            textView.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_light_red));
            textView2.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_light_red));
            textView3.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_light_red));
            textView.setText("知道了");
            textView2.setText(i10 == 3 ? "由于版权合作升级，本书于4月20日将正式免费。" : "由于版权合作升级，本书于4月20日正式免费。");
            textView3.setText(i10 == 3 ? z10 ? "敬请期待" : "加入书架，提前养肥" : z10 ? "嗨起来" : "加入书架，嗨起来");
        }
        AlertDialog P = P(activity, inflate, false);
        if (P == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: je.m

            /* renamed from: b */
            public final /* synthetic */ int f27457b;

            /* renamed from: c */
            public final /* synthetic */ Activity f27458c;

            /* renamed from: d */
            public final /* synthetic */ AlertDialog f27459d;

            public /* synthetic */ m(int i102, Activity activity2, AlertDialog P2) {
                i10 = i102;
                activity = activity2;
                P = P2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.h0(i10, activity, P, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: je.n

            /* renamed from: b */
            public final /* synthetic */ AlertDialog f27462b;

            public /* synthetic */ n(AlertDialog P2) {
                P = P2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                P.dismiss();
            }
        });
    }

    public static View O(Activity activity, LinearLayout linearLayout, AppTask appTask) {
        if (!l9.m0.C(activity) || linearLayout == null || appTask == null) {
            return null;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_ads_item, (ViewGroup) null);
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) inflate.findViewById(R.id.bonus_ads_title);
        adViewHolder.mDescription = (TextView) inflate.findViewById(R.id.bonus_ads_desc);
        adViewHolder.mPoster = (ImageView) inflate.findViewById(R.id.bonus_ads_image);
        adViewHolder.mIcon = (ImageView) inflate.findViewById(R.id.bonus_ads_icon);
        adViewHolder.videoView = (FrameLayout) inflate.findViewById(R.id.iv_ads_video);
        adViewHolder.mCreativeButton = (Button) inflate.findViewById(R.id.bonus_ads_button);
        adViewHolder.mAdLogo = (ImageView) inflate.findViewById(R.id.tv_ads_logo);
        adViewHolder.mAdLogoDesc = (TextView) inflate.findViewById(R.id.tv_ads_logo_desc);
        ((LinearLayout) inflate.findViewById(R.id.bonus_ads_detail_view)).setVisibility(0);
        adViewHolder.mTitle.setText(appTask.getTitle());
        adViewHolder.mDescription.setText(appTask.getDesc());
        adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
        if (ba.l.q(appTask.getIconUrl())) {
            adViewHolder.mIcon.setVisibility(8);
        } else {
            adViewHolder.mIcon.setVisibility(0);
            l9.m0.e(activity, appTask.getIconUrl(), adViewHolder.mIcon);
        }
        if (!ba.l.q(appTask.getButtonText())) {
            adViewHolder.mCreativeButton.setText(appTask.getButtonText());
        }
        MiConfigSingleton.b2().H1().Q0(activity, adViewHolder.mPoster, adViewHolder.mIcon, appTask);
        l9.m0.l(activity.getApplicationContext(), appTask.getPosterUrl(), adViewHolder.mPoster, com.martian.libsupport.R.drawable.image_loading_default_horizontal);
        linearLayout.addView(inflate);
        MiConfigSingleton.b2().H1().A(activity, appTask, linearLayout, inflate.findViewById(R.id.bonus_ads_view), adViewHolder, new b());
        return inflate;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: je.i0.<init>(je.v0$k, l9.q0):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public static void O0(android.app.Activity r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, je.v0.k r15) {
        /*
            boolean r0 = l9.m0.B(r8)
            if (r0 != 0) goto L7
            return
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r1 = "-展示"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            ac.a.Y(r8, r0)
            android.view.LayoutInflater r0 = r8.getLayoutInflater()
            int r1 = com.martian.mibook.R.layout.popupwindow_close_reader_ads
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            r1 = -1
            l9.q0 r1 = l9.q0.b(r8, r0, r1, r1)
            int r2 = com.martian.libmars.R.style.updownpopwindow_anim_style
            l9.q0 r1 = r1.d(r2)
            r2 = 80
            l9.q0 r1 = r1.h(r2)
            l9.q0 r1 = r1.g()
            l9.q0 r7 = r1.k()
            com.martian.mibook.databinding.PopupwindowCloseReaderAdsBinding r0 = com.martian.mibook.databinding.PopupwindowCloseReaderAdsBinding.bind(r0)
            com.martian.mibook.ui.reader.ReaderThemeTextView r1 = r0.closeAdsTitle
            r1.setText(r9)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r9 = r0.closeAdsVideo
            r9.setText(r10)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r9 = r0.closeAdsVideo
            je.i0 r10 = new je.i0
            r10.<init>()
            r9.setOnClickListener(r10)
            com.martian.mibook.ui.reader.ReaderThemeImageView r9 = r0.closeAdsCancel
            je.j0 r10 = new je.j0
            r10.<init>()
            r9.setOnClickListener(r10)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r9 = r0.openVipMember
            r9.setText(r11)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r9 = r0.openVipMember
            boolean r10 = ba.l.q(r11)
            if (r10 == 0) goto L71
            r10 = 8
            goto L72
        L71:
            r10 = 0
        L72:
            r9.setVisibility(r10)
            com.martian.mibook.ui.reader.ReaderThemeItemTextView r9 = r0.openVipMember
            je.k0 r10 = new je.k0
            r2 = r10
            r3 = r8
            r4 = r12
            r5 = r13
            r6 = r14
            r2.<init>()
            r9.setOnClickListener(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: je.v0.O0(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, je.v0$k):void");
    }

    public static AlertDialog P(Context context, View view, boolean z10) {
        return l9.i0.G(context, view, z10);
    }

    @SuppressLint({"SetTextI18n"})
    public static void P0(FragmentActivity fragmentActivity, CheckinResult checkinResult) {
        if (l9.m0.B(fragmentActivity)) {
            View inflate = fragmentActivity.getLayoutInflater().inflate(R.layout.martian_popupwindow_checkined, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.checkined_close);
            TextView textView = (TextView) inflate.findViewById(R.id.checkined_video_bonus);
            ((TextView) inflate.findViewById(R.id.checkined_coins)).setText("+" + checkinResult.getCoins());
            int intValue = checkinResult.getExtraCoins().intValue() / checkinResult.getCoins().intValue();
            if (intValue > 1) {
                textView.setText("点我赚" + (intValue + 1) + "倍奖励");
            } else {
                textView.setText("点我奖励翻倍");
            }
            AlertDialog P = P(fragmentActivity, inflate, true);
            if (P == null) {
                return;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: je.a0

                /* renamed from: c */
                public final /* synthetic */ CheckinResult f27375c;

                /* renamed from: d */
                public final /* synthetic */ AlertDialog f27376d;

                public /* synthetic */ a0(CheckinResult checkinResult2, AlertDialog P2) {
                    checkinResult = checkinResult2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.m0(FragmentActivity.this, checkinResult, P, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: je.b0

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27383b;

                public /* synthetic */ b0(AlertDialog P2) {
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    P.dismiss();
                }
            });
        }
    }

    public static PopupWindow Q(View view, View view2, Activity activity) {
        return R(view, view2, activity, false);
    }

    public static void Q0(Context context) {
        if (l9.m0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_coins_explain, null);
            DialogCoinsExplainBinding bind = DialogCoinsExplainBinding.bind(inflate);
            AlertDialog P = P(context, inflate, true);
            if (P == null) {
                return;
            }
            bind.dialogShadeView.setVisibility(MiConfigSingleton.b2().A0() ? 0 : 8);
            bind.dialogNotarize.setOnClickListener(new View.OnClickListener() { // from class: je.z

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27548b;

                public /* synthetic */ z(AlertDialog P2) {
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    P.dismiss();
                }
            });
        }
    }

    public static PopupWindow R(View view, View view2, Activity activity, boolean z10) {
        return S(view, view2, activity, z10, true);
    }

    public static void R0(FragmentActivity fragmentActivity, int i10, long j10) {
        MiConfigSingleton.b2().H1().I0(fragmentActivity, true, new d(fragmentActivity, i10, j10));
    }

    public static PopupWindow S(View view, View view2, Activity activity, boolean z10, boolean z11) {
        PopupWindow popupWindow = new PopupWindow(view, -1, -2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        if (z10) {
            popupWindow.setClippingEnabled(false);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (z11) {
            l9.i0.s0(activity, true);
        }
        popupWindow.setAnimationStyle(com.martian.libmars.R.style.updownpopwindow_anim_style);
        popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: je.k

            /* renamed from: b */
            public final /* synthetic */ boolean f27440b;

            /* renamed from: c */
            public final /* synthetic */ Activity f27441c;

            public /* synthetic */ k(boolean z112, Activity activity2) {
                z11 = z112;
                activity = activity2;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                v0.X(z11, activity);
            }
        });
        return popupWindow;
    }

    public static void S0(FragmentActivity fragmentActivity, String str, String[] strArr, j jVar) {
        new AlertDialog.Builder(fragmentActivity).setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: je.p0
            public /* synthetic */ p0() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                v0.p0(v0.j.this, dialogInterface, i10);
            }
        }).show();
    }

    public static void T(Activity activity, UpgradeDialogBinding upgradeDialogBinding, AlertDialog alertDialog, String str, String str2, String str3) {
        if (activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: je.v

            /* renamed from: c */
            public final /* synthetic */ String f27502c;

            /* renamed from: d */
            public final /* synthetic */ String f27503d;

            /* renamed from: e */
            public final /* synthetic */ Activity f27504e;

            /* renamed from: f */
            public final /* synthetic */ String f27505f;

            /* renamed from: g */
            public final /* synthetic */ AlertDialog f27506g;

            public /* synthetic */ v(String str4, String str22, Activity activity2, String str32, AlertDialog alertDialog2) {
                str = str4;
                str2 = str22;
                activity = activity2;
                str3 = str32;
                alertDialog = alertDialog2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v0.Y(UpgradeDialogBinding.this, str, str2, activity, str3, alertDialog);
            }
        });
    }

    public static void T0(Activity activity, View view, Book book, Chapter chapter, Integer num) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.book_info_menu, (ViewGroup) null);
        BookInfoMenuBinding bind = BookInfoMenuBinding.bind(inflate);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(view, 0, 0);
        bind.menuReport.setOnClickListener(new View.OnClickListener() { // from class: je.w

            /* renamed from: b */
            public final /* synthetic */ Activity f27529b;

            /* renamed from: c */
            public final /* synthetic */ Book f27530c;

            /* renamed from: d */
            public final /* synthetic */ Chapter f27531d;

            /* renamed from: e */
            public final /* synthetic */ Integer f27532e;

            /* renamed from: f */
            public final /* synthetic */ PopupWindow f27533f;

            public /* synthetic */ w(Activity activity2, Book book2, Chapter chapter2, Integer num2, PopupWindow popupWindow2) {
                activity = activity2;
                book = book2;
                chapter = chapter2;
                num = num2;
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                v0.q0(activity, book, chapter, num, popupWindow, view2);
            }
        });
    }

    public static boolean U(Activity activity) {
        if (ConfigSingleton.D().B0()) {
            return true;
        }
        return MiConfigSingleton.b2().c2().getEnableVideoCountdown() && MiConfigSingleton.b2().H1().Q(activity) % 4 == 0;
    }

    public static void U0(Activity activity) {
        if (l9.m0.B(activity)) {
            ac.a.I(activity, "通知引导-展示");
            View inflate = activity.getLayoutInflater().inflate(com.martian.mipush.R.layout.dialog_notification_setting, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.rd_close);
            TextView textView = (TextView) inflate.findViewById(R.id.rules_button);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            ImageView imageView2 = (ImageView) inflate.findViewById(com.martian.mipush.R.id.rules_image_inform);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 15.0f, 1, 0.5f, 1, 0.0f);
            rotateAnimation.setInterpolator(new CycleInterpolator(1.0f));
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1120L);
            imageView2.setAnimation(rotateAnimation);
            rotateAnimation.start();
            if (MiConfigSingleton.b2().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            AlertDialog P = P(activity, inflate, true);
            if (P == null) {
                return;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: je.c0

                /* renamed from: b */
                public final /* synthetic */ Activity f27390b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27391c;

                public /* synthetic */ c0(Activity activity2, AlertDialog P2) {
                    activity = activity2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.t0(activity, P, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: je.d0

                /* renamed from: b */
                public final /* synthetic */ Activity f27398b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27399c;

                public /* synthetic */ d0(Activity activity2, AlertDialog P2) {
                    activity = activity2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.r0(activity, P, view);
                }
            });
            P2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: je.e0

                /* renamed from: b */
                public final /* synthetic */ RotateAnimation f27406b;

                public /* synthetic */ e0(RotateAnimation rotateAnimation2) {
                    rotateAnimation = rotateAnimation2;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    rotateAnimation.cancel();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void V(FragmentActivity fragmentActivity, int i10, long j10) {
        e eVar = new e(fragmentActivity, fragmentActivity, i10);
        ((FinishExtraBonusParams) eVar.k()).setExtraId(Long.valueOf(j10));
        eVar.j();
    }

    public static void V0(Activity activity) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.popupwindow_paragraph_comment_guide, (ViewGroup) null);
        PopupwindowParagraphCommentGuideBinding bind = PopupwindowParagraphCommentGuideBinding.bind(inflate);
        AlertDialog P = P(activity, inflate, false);
        if (P == null) {
            return;
        }
        bind.paragraphGuideKnown.setOnClickListener(new View.OnClickListener() { // from class: je.o0

            /* renamed from: b */
            public final /* synthetic */ AlertDialog f27467b;

            public /* synthetic */ o0(AlertDialog P2) {
                P = P2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                P.dismiss();
            }
        });
    }

    public static String W() {
        return MiConfigSingleton.b2().e2().m() ? "倒计时-" : "";
    }

    public static void W0(Activity activity, n nVar) {
        if (l9.m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_rate_view, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dialog_close);
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_notarize);
            TextView textView2 = (TextView) inflate.findViewById(R.id.rate_desc);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            AlertDialog P = P(activity, inflate, true);
            if (P == null) {
                return;
            }
            if (MiConfigSingleton.b2().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            SpannableString spannableString = new SpannableString("应用商店发表五星好评，到账速度提升100%，还有额外金币奖励。");
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default)), 6, 10, 33);
            spannableString.setSpan(new StyleSpan(1), 6, 10, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default)), 15, 21, 33);
            spannableString.setSpan(new StyleSpan(1), 15, 21, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(activity, com.martian.libmars.R.color.theme_default)), 26, 30, 33);
            spannableString.setSpan(new StyleSpan(1), 26, 30, 33);
            textView2.setText(spannableString);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: je.x

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27538b;

                public /* synthetic */ x(AlertDialog P2) {
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    P.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: je.y

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27543c;

                public /* synthetic */ y(AlertDialog P2) {
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.w0(v0.n.this, P, view);
                }
            });
        }
    }

    public static /* synthetic */ void X(boolean z10, Activity activity) {
        if (z10) {
            l9.i0.s0(activity, false);
        }
    }

    public static void X0(Activity activity, String str, int i10, o oVar) {
        if (l9.m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_recharge, null);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialog_wx_check);
            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.dialog_zfb_check);
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) inflate.findViewById(R.id.dialog_wx_view);
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) inflate.findViewById(R.id.dialog_zfb_view);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            View findViewById = inflate.findViewById(R.id.duration_conversion_view);
            AlertDialog P = P(activity, inflate, true);
            if (P == null) {
                return;
            }
            if (ConfigSingleton.D().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            if (!ba.l.q(str)) {
                themeTextView.setText(str);
            }
            checkBox.setChecked(i10 == 0);
            checkBox2.setChecked(i10 != 0);
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: je.o

                /* renamed from: b */
                public final /* synthetic */ CheckBox f27465b;

                /* renamed from: c */
                public final /* synthetic */ CheckBox f27466c;

                public /* synthetic */ o(CheckBox checkBox3, CheckBox checkBox22) {
                    checkBox = checkBox3;
                    checkBox2 = checkBox22;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.x0(checkBox, checkBox2, view);
                }
            });
            checkBox22.setOnClickListener(new View.OnClickListener() { // from class: je.p

                /* renamed from: b */
                public final /* synthetic */ CheckBox f27468b;

                /* renamed from: c */
                public final /* synthetic */ CheckBox f27469c;

                public /* synthetic */ p(CheckBox checkBox3, CheckBox checkBox22) {
                    checkBox = checkBox3;
                    checkBox2 = checkBox22;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.y0(checkBox, checkBox2, view);
                }
            });
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: je.q

                /* renamed from: b */
                public final /* synthetic */ CheckBox f27471b;

                /* renamed from: c */
                public final /* synthetic */ CheckBox f27472c;

                public /* synthetic */ q(CheckBox checkBox3, CheckBox checkBox22) {
                    checkBox = checkBox3;
                    checkBox2 = checkBox22;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.z0(checkBox, checkBox2, view);
                }
            });
            themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: je.r

                /* renamed from: b */
                public final /* synthetic */ CheckBox f27478b;

                /* renamed from: c */
                public final /* synthetic */ CheckBox f27479c;

                public /* synthetic */ r(CheckBox checkBox3, CheckBox checkBox22) {
                    checkBox = checkBox3;
                    checkBox2 = checkBox22;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.A0(checkBox, checkBox2, view);
                }
            });
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: je.s

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27483b;

                public /* synthetic */ s(AlertDialog P2) {
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    P.dismiss();
                }
            });
            themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: je.t

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27489b;

                /* renamed from: c */
                public final /* synthetic */ CheckBox f27490c;

                /* renamed from: d */
                public final /* synthetic */ v0.o f27491d;

                public /* synthetic */ t(AlertDialog P2, CheckBox checkBox3, v0.o oVar2) {
                    P = P2;
                    checkBox = checkBox3;
                    oVar = oVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.C0(P, checkBox, oVar, view);
                }
            });
        }
    }

    public static /* synthetic */ void Y(UpgradeDialogBinding upgradeDialogBinding, String str, String str2, Activity activity, String str3, AlertDialog alertDialog) {
        if (upgradeDialogBinding != null) {
            upgradeDialogBinding.tvUpgradeConfirm.setEnabled(false);
        }
        z8.e.c(str, str2, new g(activity, str3, upgradeDialogBinding, str2, alertDialog));
    }

    public static void Y0(Activity activity) {
        if (l9.m0.B(activity)) {
            ac.a.k(activity, "青少年模式-显示");
            MiConfigSingleton.b2().e2().C0();
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_teenage_guide, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.teenage_open);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.teenage_close);
            TextView textView = (TextView) inflate.findViewById(R.id.teenage_button);
            AlertDialog P = P(activity, inflate, true);
            if (P == null) {
                return;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: je.j

                /* renamed from: b */
                public final /* synthetic */ Activity f27437b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27438c;

                public /* synthetic */ j(Activity activity2, AlertDialog P2) {
                    activity = activity2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.D0(activity, P, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: je.u

                /* renamed from: b */
                public final /* synthetic */ Activity f27493b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27494c;

                public /* synthetic */ u(Activity activity2, AlertDialog P2) {
                    activity = activity2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.E0(activity, P, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: je.f0

                /* renamed from: b */
                public final /* synthetic */ Activity f27413b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f27414c;

                public /* synthetic */ f0(Activity activity2, AlertDialog P2) {
                    activity = activity2;
                    P = P2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v0.F0(activity, P, view);
                }
            });
        }
    }

    public static /* synthetic */ void Z(Activity activity, String str, TYActivity tYActivity, e9.c cVar, AlertDialog alertDialog, View view) {
        ac.a.l(activity, str + "-" + tYActivity.getTitle() + "-点击");
        if (cVar == null || tYActivity.getMissionType() == null) {
            if (!ba.l.q(tYActivity.getDeeplink()) && i8.g.h(activity, tYActivity.getDeeplink())) {
                i8.g.A(activity, tYActivity.getDeeplink(), "", "", true);
            } else if (!ba.l.q(tYActivity.getActivityUrl())) {
                MiWebViewActivity.I5(activity, tYActivity.getActivityUrl(), false, tYActivity.getShareUrl(), tYActivity.getShareable(), tYActivity.getShareImageUrl(), tYActivity.getFullscreen().booleanValue());
            }
        } else if (MiConfigSingleton.b2().e2().o(tYActivity.getMissionType().intValue())) {
            cVar.d(j2.f33261b, tYActivity.toMissionItem());
        } else {
            l9.t0.b(activity, "请升级到最新版");
        }
        alertDialog.dismiss();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: je.u0.<init>(com.martian.libugrowth.data.UpgradeInfo, android.app.Activity, java.lang.String, android.app.AlertDialog, com.martian.mibook.databinding.UpgradeDialogBinding, java.lang.String):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public static void Z0(android.app.Activity r9, com.martian.libugrowth.data.UpgradeInfo r10) {
        /*
            boolean r0 = l9.m0.B(r9)
            if (r0 == 0) goto Ld0
            if (r10 != 0) goto La
            goto Ld0
        La:
            boolean r0 = r10.isManual()
            if (r0 != 0) goto L1f
            com.martian.mibook.application.MiConfigSingleton r0 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.c r0 = r0.e2()
            boolean r0 = r0.b0()
            if (r0 == 0) goto L1f
            return
        L1f:
            android.view.LayoutInflater r0 = r9.getLayoutInflater()
            int r1 = com.martian.mibook.R.layout.upgrade_dialog
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            com.martian.mibook.databinding.UpgradeDialogBinding r6 = com.martian.mibook.databinding.UpgradeDialogBinding.bind(r0)
            boolean r1 = r10.forceUpgrade()
            r1 = r1 ^ 1
            android.app.AlertDialog r5 = P(r9, r0, r1)
            if (r5 != 0) goto L3b
            return
        L3b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.martian.mibook.R.string.app_name
            java.lang.String r1 = r9.getString(r1)
            r0.append(r1)
            java.lang.String r1 = r10.getVersionName()
            r0.append(r1)
            java.lang.String r1 = "."
            r0.append(r1)
            java.lang.Integer r1 = r10.getVersionCode()
            r0.append(r1)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ba.b.f()
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ".apk"
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            com.martian.mibook.application.MiConfigSingleton r0 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.c r0 = r0.e2()
            r0.C0()
            android.widget.RelativeLayout r0 = r6.upgradeHeader
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r1 = ba.m.i(r9)
            r2 = 1120403456(0x42c80000, float:100.0)
            int r2 = com.martian.libmars.common.ConfigSingleton.i(r2)
            int r1 = r1 - r2
            r0.width = r1
            int r1 = r1 / 2
            r0.height = r1
            android.widget.TextView r0 = r6.upgradeName
            r0.setText(r7)
            android.widget.ImageView r0 = r6.upgradeClose
            boolean r1 = r10.forceUpgrade()
            if (r1 == 0) goto Lac
            r1 = 8
            goto Lad
        Lac:
            r1 = 0
        Lad:
            r0.setVisibility(r1)
            com.martian.libmars.ui.theme.ThemeTextView r0 = r6.upgradeFeature
            java.lang.String r1 = r10.getContent()
            r0.setText(r1)
            android.widget.ImageView r0 = r6.upgradeClose
            je.t0 r1 = new je.t0
            r1.<init>()
            r0.setOnClickListener(r1)
            com.martian.libmars.ui.theme.ThemeTextView r0 = r6.tvUpgradeConfirm
            je.u0 r8 = new je.u0
            r1 = r8
            r2 = r10
            r3 = r9
            r1.<init>()
            r0.setOnClickListener(r8)
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: je.v0.Z0(android.app.Activity, com.martian.libugrowth.data.UpgradeInfo):void");
    }

    public static /* synthetic */ void a0(Activity activity, String str, TYActivity tYActivity, AlertDialog alertDialog, View view) {
        ac.a.l(activity, str + "-" + tYActivity.getTitle() + "-关闭");
        alertDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a1(FragmentActivity fragmentActivity, int i10, long j10) {
        c cVar = new c(fragmentActivity, fragmentActivity, i10, j10);
        ((StartExtraBonusParams) cVar.k()).setExtraId(Long.valueOf(j10));
        cVar.j();
    }

    public static /* synthetic */ void b0(DialogVideoBonusBinding dialogVideoBonusBinding, Activity activity, k kVar, AlertDialog alertDialog, CountdownNumberTextView countdownNumberTextView) {
        dialogVideoBonusBinding.videoAdsCountdown.n();
        dialogVideoBonusBinding.videoAdsCountdown.setVisibility(4);
        ac.a.r(activity, "作者红包-倒计时-自动播放");
        if (kVar != null) {
            kVar.b();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static void b1(Activity activity, UpgradeDialogBinding upgradeDialogBinding, AlertDialog alertDialog, UpgradeInfo upgradeInfo, String str, String str2) {
        new f(upgradeInfo, activity, upgradeDialogBinding, alertDialog, str, str2).executeParallel(new Void[0]);
    }

    public static /* synthetic */ void c0(k kVar, AlertDialog alertDialog, View view) {
        if (kVar != null) {
            kVar.b();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static /* synthetic */ void d0(k kVar, AlertDialog alertDialog, View view) {
        if (kVar != null) {
            kVar.a();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static /* synthetic */ void e0(Activity activity, AppTask appTask, d8.b bVar, MartianPopupwindowAuthorBinding martianPopupwindowAuthorBinding, AlertDialog alertDialog, View view) {
        ac.a.r(activity, "作者红包-" + W() + "点击");
        MiConfigSingleton.b2().H1().U0(activity, appTask, bVar, bVar);
        CountdownNumberTextView countdownNumberTextView = martianPopupwindowAuthorBinding.bonusCountdown;
        if (countdownNumberTextView != null) {
            countdownNumberTextView.n();
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void f0(Activity activity, MartianPopupwindowAuthorBinding martianPopupwindowAuthorBinding, AlertDialog alertDialog, View view) {
        ac.a.r(activity, "作者红包-" + W() + "关闭");
        CountdownNumberTextView countdownNumberTextView = martianPopupwindowAuthorBinding.bonusCountdown;
        if (countdownNumberTextView != null) {
            countdownNumberTextView.n();
        }
        martianPopupwindowAuthorBinding.bonusGrab.clearAnimation();
        alertDialog.dismiss();
    }

    public static /* synthetic */ void g0(MartianPopupwindowAuthorBinding martianPopupwindowAuthorBinding, Activity activity, AppTask appTask, d8.b bVar, AlertDialog alertDialog, CountdownNumberTextView countdownNumberTextView) {
        martianPopupwindowAuthorBinding.bonusCountdown.setVisibility(4);
        ac.a.r(activity, "作者红包-倒计时-自动播放");
        MiConfigSingleton.b2().H1().U0(activity, appTask, bVar, bVar);
        martianPopupwindowAuthorBinding.bonusCountdown.n();
        alertDialog.dismiss();
    }

    public static /* synthetic */ void h0(int i10, Activity activity, AlertDialog alertDialog, View view) {
        if (i10 < 3) {
            OfflineLinkParams offlineLinkParams = new OfflineLinkParams();
            if (ba.m.q(activity)) {
                offlineLinkParams.setNotchHeight(ConfigSingleton.W0(com.gyf.immersionbar.d.H0(activity)));
            }
            MiWebViewActivity.A4(activity, offlineLinkParams.toHttpUrl(z5.k.f33694e), false);
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void j0(k kVar, l9.q0 q0Var, View view) {
        if (kVar != null) {
            kVar.b();
        }
        q0Var.dismiss();
    }

    public static /* synthetic */ void l0(Activity activity, String str, String str2, String str3, l9.q0 q0Var, View view) {
        je.i.e0(activity, str, str2, str3);
        q0Var.dismiss();
    }

    public static /* synthetic */ void m0(FragmentActivity fragmentActivity, CheckinResult checkinResult, AlertDialog alertDialog, View view) {
        a1(fragmentActivity, checkinResult.getCoins().intValue(), checkinResult.getExtraId());
        alertDialog.dismiss();
    }

    public static /* synthetic */ void p0(j jVar, DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        if (jVar != null) {
            jVar.a(i10);
        }
    }

    public static /* synthetic */ void q0(Activity activity, Book book, Chapter chapter, Integer num, PopupWindow popupWindow, View view) {
        ac.a.u(activity, "举报");
        je.i.N(activity, book, chapter, num);
        popupWindow.dismiss();
    }

    public static /* synthetic */ void r0(Activity activity, AlertDialog alertDialog, View view) {
        ac.a.I(activity, "通知引导-关闭");
        alertDialog.dismiss();
    }

    public static /* synthetic */ void t0(Activity activity, AlertDialog alertDialog, View view) {
        ac.a.I(activity, "通知引导-设置");
        ba.h.b(activity);
        alertDialog.dismiss();
    }

    public static /* synthetic */ void w0(n nVar, AlertDialog alertDialog, View view) {
        if (nVar != null) {
            nVar.a();
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void x0(CheckBox checkBox, CheckBox checkBox2, View view) {
        checkBox.setChecked(true);
        checkBox2.setChecked(false);
    }

    public static /* synthetic */ void y0(CheckBox checkBox, CheckBox checkBox2, View view) {
        checkBox.setChecked(false);
        checkBox2.setChecked(true);
    }

    public static /* synthetic */ void z0(CheckBox checkBox, CheckBox checkBox2, View view) {
        checkBox.setChecked(true);
        checkBox2.setChecked(false);
    }

    public class g implements e.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f27524a;

        /* renamed from: b */
        public final /* synthetic */ String f27525b;

        /* renamed from: c */
        public final /* synthetic */ UpgradeDialogBinding f27526c;

        /* renamed from: d */
        public final /* synthetic */ String f27527d;

        /* renamed from: e */
        public final /* synthetic */ AlertDialog f27528e;

        public g(Activity activity, String str, UpgradeDialogBinding upgradeDialogBinding, String str2, AlertDialog alertDialog) {
            this.f27524a = activity;
            this.f27525b = str;
            this.f27526c = upgradeDialogBinding;
            this.f27527d = str2;
            this.f27528e = alertDialog;
        }

        public static /* synthetic */ void g(UpgradeDialogBinding upgradeDialogBinding, Activity activity, String str, AlertDialog alertDialog) {
            if (upgradeDialogBinding != null) {
                upgradeDialogBinding.rbsProgressBar.setProgress(100);
                upgradeDialogBinding.tvUpgradeConfirm.setText("安装中...");
            }
            i8.g.k(activity, new File(str));
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }

        public static /* synthetic */ void h(Activity activity, x8.c cVar, AlertDialog alertDialog) {
            l9.t0.b(activity, cVar.d());
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }

        public static /* synthetic */ void i(int i10, int i11, UpgradeDialogBinding upgradeDialogBinding, Activity activity) {
            long j10 = (i10 * 100) / i11;
            if (upgradeDialogBinding != null) {
                upgradeDialogBinding.rbsProgressBar.setProgress((int) j10);
                upgradeDialogBinding.tvUpgradeConfirm.setText(activity.getString(R.string.download_desc) + j10 + "%");
            }
        }

        @Override // z8.e.b
        @SuppressLint({"SetTextI18n"})
        public void a(int i10, int i11) {
            if (this.f27524a.isFinishing()) {
                return;
            }
            Activity activity = this.f27524a;
            activity.runOnUiThread(new Runnable() { // from class: je.y0

                /* renamed from: b */
                public final /* synthetic */ int f27544b;

                /* renamed from: c */
                public final /* synthetic */ int f27545c;

                /* renamed from: d */
                public final /* synthetic */ UpgradeDialogBinding f27546d;

                /* renamed from: e */
                public final /* synthetic */ Activity f27547e;

                public /* synthetic */ y0(int i102, int i112, UpgradeDialogBinding upgradeDialogBinding, Activity activity2) {
                    i10 = i102;
                    i11 = i112;
                    upgradeDialogBinding = upgradeDialogBinding;
                    activity = activity2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v0.g.i(i10, i11, upgradeDialogBinding, activity);
                }
            });
        }

        @Override // z8.e.b
        public void b(int i10) {
            if (this.f27524a.isFinishing()) {
                return;
            }
            Activity activity = this.f27524a;
            activity.runOnUiThread(new Runnable() { // from class: je.w0

                /* renamed from: c */
                public final /* synthetic */ Activity f27535c;

                /* renamed from: d */
                public final /* synthetic */ String f27536d;

                /* renamed from: e */
                public final /* synthetic */ AlertDialog f27537e;

                public /* synthetic */ w0(Activity activity2, String str, AlertDialog alertDialog) {
                    activity = activity2;
                    str = str;
                    alertDialog = alertDialog;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v0.g.g(UpgradeDialogBinding.this, activity, str, alertDialog);
                }
            });
        }

        @Override // z8.e.b
        public void c(x8.c cVar) {
            if (this.f27524a.isFinishing()) {
                return;
            }
            Activity activity = this.f27524a;
            activity.runOnUiThread(new Runnable() { // from class: je.x0

                /* renamed from: b */
                public final /* synthetic */ Activity f27539b;

                /* renamed from: c */
                public final /* synthetic */ x8.c f27540c;

                /* renamed from: d */
                public final /* synthetic */ AlertDialog f27541d;

                public /* synthetic */ x0(Activity activity2, x8.c cVar2, AlertDialog alertDialog) {
                    activity = activity2;
                    cVar = cVar2;
                    alertDialog = alertDialog;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v0.g.h(activity, cVar, alertDialog);
                }
            });
        }

        @Override // z8.e.b
        public void onStart() {
            if (this.f27524a.isFinishing()) {
                return;
            }
            l9.t0.b(this.f27524a, "开始下载" + this.f27525b);
        }

        @Override // z8.e.b
        public void onCancel() {
        }
    }

    public class c extends kb.b0 {

        /* renamed from: k */
        public final /* synthetic */ FragmentActivity f27510k;

        /* renamed from: l */
        public final /* synthetic */ int f27511l;

        /* renamed from: m */
        public final /* synthetic */ long f27512m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, FragmentActivity fragmentActivity, int i10, long j10) {
            super(activity);
            this.f27510k = fragmentActivity;
            this.f27511l = i10;
            this.f27512m = j10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            FragmentActivity fragmentActivity = this.f27510k;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            l9.t0.b(this.f27510k, "获取奖励失败");
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            FragmentActivity fragmentActivity = this.f27510k;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            if (bool == null || !bool.booleanValue()) {
                l9.t0.b(this.f27510k, "获取奖励失败");
            } else {
                v0.R0(this.f27510k, this.f27511l, this.f27512m);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class e extends kb.i {

        /* renamed from: k */
        public final /* synthetic */ FragmentActivity f27516k;

        /* renamed from: l */
        public final /* synthetic */ int f27517l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Activity activity, FragmentActivity fragmentActivity, int i10) {
            super(activity);
            this.f27516k = fragmentActivity;
            this.f27517l = i10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            FragmentActivity fragmentActivity = this.f27516k;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            l9.t0.b(this.f27516k, cVar.d());
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ExtraBonus extraBonus) {
            if (extraBonus != null && extraBonus.getCoins().intValue() > 0) {
                MiConfigSingleton.b2().G1().B(0, extraBonus.getCoins().intValue());
                MiConfigSingleton.b2().u2().S(this.f27516k, "签到", 0, this.f27517l + extraBonus.getCoins().intValue());
                return;
            }
            FragmentActivity fragmentActivity = this.f27516k;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            l9.t0.b(this.f27516k, "获取奖励失败");
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class f extends y8.f<Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ UpgradeInfo f27518a;

        /* renamed from: b */
        public final /* synthetic */ Activity f27519b;

        /* renamed from: c */
        public final /* synthetic */ UpgradeDialogBinding f27520c;

        /* renamed from: d */
        public final /* synthetic */ AlertDialog f27521d;

        /* renamed from: e */
        public final /* synthetic */ String f27522e;

        /* renamed from: f */
        public final /* synthetic */ String f27523f;

        public f(UpgradeInfo upgradeInfo, Activity activity, UpgradeDialogBinding upgradeDialogBinding, AlertDialog alertDialog, String str, String str2) {
            this.f27518a = upgradeInfo;
            this.f27519b = activity;
            this.f27520c = upgradeDialogBinding;
            this.f27521d = alertDialog;
            this.f27522e = str;
            this.f27523f = str2;
        }

        @Override // y8.f
        /* renamed from: f */
        public Void doInBackground(Void... voidArr) {
            OkHttpClient okHttpClient = new OkHttpClient();
            UpgradeDownloadLinkParams upgradeDownloadLinkParams = new UpgradeDownloadLinkParams();
            upgradeDownloadLinkParams.setId(this.f27518a.getId());
            try {
                v0.T(this.f27519b, this.f27520c, this.f27521d, okHttpClient.newCall(new Request.Builder().url(upgradeDownloadLinkParams.toHttpUrl(z5.k.f33694e)).build()).execute().request().url().getUrl(), this.f27522e, this.f27523f);
                return null;
            } catch (IOException e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Void r12) {
            super.onPostExecute(r12);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
