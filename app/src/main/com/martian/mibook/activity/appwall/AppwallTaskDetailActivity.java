package com.martian.mibook.activity.appwall;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import ba.l;
import com.martian.apptask.AppTaskManager;
import com.martian.apptask.data.AppTask;
import com.martian.appwall.request.MartianGetAppwallParams;
import com.martian.appwall.request.auth.MartianFinishNextSubTaskParams;
import com.martian.appwall.request.auth.MartianStartCurrentSubTaskParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.appwall.response.MartianFinishSubTask;
import com.martian.appwall.response.MartianStartSubTask;
import com.martian.appwall.response.MartianSubTask;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.R;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityAppwallTaskDetailBinding;
import com.martian.mibook.receiver.MiAPKDownloadCompleteReceiver;
import i8.g;
import je.i;
import k8.b;
import l9.m0;
import oe.f;

/* loaded from: classes3.dex */
public class AppwallTaskDetailActivity extends MiRetryLoadingActivity {
    public static final String X = "COMPLETED";
    public static final String Y = "INVALID";
    public static final String Z = "EXECUTABLE";

    /* renamed from: a0 */
    public static final String f13149a0 = "46";
    public MartianAppwallTask L;
    public ActivityAppwallTaskDetailBinding O;
    public MiAPKDownloadCompleteReceiver P;
    public MartianSubTask Q;
    public long S;
    public boolean U;
    public boolean M = false;
    public boolean N = false;
    public int R = 0;
    public final Runnable T = new Runnable() { // from class: sa.b
        public /* synthetic */ b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppwallTaskDetailActivity.this.s3();
        }
    };
    public boolean V = true;
    public boolean W = false;

    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            boolean z10 = true;
            if (AppwallTaskDetailActivity.this.O.martianTaskListview.getChildCount() > 0 && (AppwallTaskDetailActivity.this.O.martianTaskListview.getFirstVisiblePosition() != 0 || AppwallTaskDetailActivity.this.O.martianTaskListview.getChildAt(0).getTop() != 0)) {
                z10 = false;
            }
            AppwallTaskDetailActivity.this.E.setEnabled(z10);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    public class b extends l8.c {

        /* renamed from: i */
        public final /* synthetic */ MartianFinishSubTask f13151i;

        public b(MartianFinishSubTask martianFinishSubTask) {
            this.f13151i = martianFinishSubTask;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            AppwallTaskDetailActivity.this.D3(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(MartianAppwallTask martianAppwallTask) {
            AppwallTaskDetailActivity.this.B3(martianAppwallTask);
            MartianFinishSubTask martianFinishSubTask = this.f13151i;
            if (martianFinishSubTask == null || martianFinishSubTask.getCoins() <= 0) {
                return;
            }
            MiConfigSingleton.b2().u2().S(AppwallTaskDetailActivity.this, "游戏奖励", 0, this.f13151i.getCoins());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            AppwallTaskDetailActivity.this.f3(z10);
        }
    }

    public class c implements g8.a {
        public c() {
        }

        @Override // g8.a
        public void a(AppTask appTask) {
        }

        @Override // g8.a
        public void b(AppTask appTask) {
        }

        @Override // g8.a
        public void c(AppTask appTask) {
        }

        @Override // g8.a
        public void d(AppTask appTask) {
            AppwallTaskDetailActivity.this.P1("开始下载 " + appTask.name);
        }
    }

    public class d extends m8.c {
        public d(Activity activity) {
            super(activity);
        }

        @Override // m8.a
        public void p(x8.c cVar) {
            AppwallTaskDetailActivity.this.P1("任务未完成：" + cVar.toString());
            MiConfigSingleton.b2().e2().D0(0);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(MartianFinishSubTask martianFinishSubTask) {
            AppwallTaskDetailActivity.this.U = true;
            if (martianFinishSubTask == null || AppwallTaskDetailActivity.this.L == null) {
                return;
            }
            MiConfigSingleton.b2().e2().D0(0);
            if (AppwallTaskDetailActivity.this.L.getApp() != null) {
                ac.a.e(AppwallTaskDetailActivity.this, "appwall_task", "finish:" + AppwallTaskDetailActivity.this.L.getApp().getName());
            }
            if (ConfigSingleton.D().x0()) {
                AppwallTaskDetailActivity.this.q3(martianFinishSubTask);
            }
        }
    }

    private void C3() {
        this.P = new MiAPKDownloadCompleteReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        registerReceiver(this.P, intentFilter);
    }

    public void D3(x8.c cVar) {
        X2();
        G2(cVar.d());
    }

    public final void A3() {
        if (MiConfigSingleton.b2().G1().g(this, 10001)) {
            if (!g.r(this) && !X.equalsIgnoreCase(this.L.getStatus())) {
                g.G(this);
                return;
            }
            P1("正在打开" + this.L.getApp().getName());
            g.y(this, this.L.getApp().getPackageName());
            AppTaskManager.K(this, this.L.getApp().getPackageName());
            if (this.M) {
                E3(this.L.getSubtasks().get(this.L.getStindex()));
                F3();
            }
        }
    }

    public final void B3(MartianAppwallTask martianAppwallTask) {
        X2();
        if (martianAppwallTask == null) {
            F2();
            return;
        }
        H2();
        this.L = martianAppwallTask;
        H3();
    }

    public final void E3(MartianSubTask martianSubTask) {
        this.S = System.currentTimeMillis() - (this.R * 1000);
        this.Q = martianSubTask;
        this.O.martianTaskListview.postDelayed(new Runnable() { // from class: sa.a
            public /* synthetic */ a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AppwallTaskDetailActivity.this.x3();
            }
        }, 3000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void F3() {
        if (this.W || !MiConfigSingleton.b2().F2()) {
            return;
        }
        e eVar = new e(this);
        ((MartianStartCurrentSubTaskParams) eVar.k()).setAwid(f13149a0);
        eVar.j();
    }

    public final void G3() {
        this.O.martianTaskListview.removeCallbacks(this.T);
        if (this.Q == null || !r3()) {
            Q1("完成任务后才能获取奖励");
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void H3() {
        String str;
        MartianAppwallTask martianAppwallTask = this.L;
        if (martianAppwallTask == null) {
            return;
        }
        if (martianAppwallTask.getApp() != null) {
            this.M = false;
            this.O.taskInstall.setBackgroundResource(R.drawable.border_button_bonus_poll_sign_check_in);
            this.O.taskInstall.setText(!i.p(this, this.L.getApp().getPackageName()) ? "下载安装" : "立即前往");
            m0.l(this, this.L.getApp().getIconUrl(), this.O.taskHeader, R.drawable.ic_launcher);
            if (l.q(this.L.getApp().getName())) {
                str = "";
            } else {
                str = this.L.getApp().getName();
                this.O.taskName.setText(str);
            }
            if (this.L.getApp().getSizeInMB() > 0) {
                this.O.taskName.setText(str + "  (" + this.L.getApp().getSizeInMB() + "MB)");
            }
            if (Y.equalsIgnoreCase(this.L.getStatus())) {
                this.O.taskInstall.setBackgroundResource(R.drawable.border_button_bonus_poll_sign_checked);
                this.O.taskInstall.setText("之前已安装，无法获得奖励");
            } else if (X.equalsIgnoreCase(this.L.getStatus())) {
                MiConfigSingleton.b2().e2().D0(2);
            } else if (this.L.getSubtasks() != null && this.L.getSubtasks().size() > this.L.getStindex() && Z.equalsIgnoreCase(this.L.getSubtasks().get(this.L.getStindex()).getStatus())) {
                this.M = true;
            }
        }
        if (this.L.getCoins() > 0) {
            this.O.taskCoins.setVisibility(0);
            this.O.taskCoins.setText("总奖金：" + f.r(this.L.getCoins()) + getString(R.string.bonus_unit));
        } else {
            this.O.taskCoins.setVisibility(8);
        }
        if (this.L.getSubtasks() != null) {
            k8.b bVar = new k8.b(this, this.L.getSubtasks());
            this.O.martianTaskListview.setAdapter((ListAdapter) bVar);
            bVar.d(new b.a() { // from class: sa.c
                public /* synthetic */ c() {
                }

                @Override // k8.b.a
                public final void a(View view, int i10) {
                    AppwallTaskDetailActivity.this.y3(view, i10);
                }
            });
            if (this.L.getSubtasks().size() <= 5 || this.N) {
                return;
            }
            this.N = true;
            this.O.martianTaskListview.addFooterView(z3());
        }
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
        v3(null);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void f3(boolean z10) {
        if (z10) {
            I2(getString(com.martian.libmars.R.string.loading));
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1100) {
            g.G(this);
        }
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_appwall_task_detail);
        ActivityAppwallTaskDetailBinding bind = ActivityAppwallTaskDetailBinding.bind(C2());
        this.O = bind;
        bind.martianTaskListview.setOnScrollListener(new a());
        C3();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MiAPKDownloadCompleteReceiver miAPKDownloadCompleteReceiver = this.P;
        if (miAPKDownloadCompleteReceiver != null) {
            unregisterReceiver(miAPKDownloadCompleteReceiver);
        }
    }

    public void onInstallClick(View view) {
        MartianAppwallTask martianAppwallTask = this.L;
        if (martianAppwallTask == null || martianAppwallTask.getApp() == null) {
            return;
        }
        if (Y.equalsIgnoreCase(this.L.getStatus())) {
            P1("抱歉，您无法进行该任务");
        } else {
            w3();
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        r3();
        H3();
        this.O.martianTaskListview.removeCallbacks(this.T);
        if (MiConfigSingleton.b2().e2().K() == 1) {
            u3();
            return;
        }
        if (this.V) {
            this.V = false;
            return;
        }
        if (this.M) {
            MartianSubTask martianSubTask = this.Q;
            int userDurationInMins = martianSubTask == null ? 300 : martianSubTask.getUserDurationInMins() * 60;
            if (this.R > 0) {
                P1("时间不足（" + this.R + "/" + userDurationInMins + "秒），无法获得奖励");
            }
        }
    }

    public void q3(MartianFinishSubTask martianFinishSubTask) {
        MiConfigSingleton.b2().G1().B(0, martianFinishSubTask.getCoins());
        v3(martianFinishSubTask);
    }

    public final boolean r3() {
        if (this.Q == null || this.R < 20) {
            return false;
        }
        int max = Math.max((int) ((System.currentTimeMillis() - this.S) / 1000), this.R);
        this.R = max;
        if (max < this.Q.getUserDurationInMins() * 60) {
            return false;
        }
        MiConfigSingleton.b2().e2().D0(1);
        return true;
    }

    public final void s3() {
        if (this.Q == null) {
            G3();
            return;
        }
        if (r3()) {
            this.O.martianTaskListview.removeCallbacks(this.T);
            return;
        }
        if (ConfigSingleton.D().m0().equals(this.L.getApp().getPackageName())) {
            this.R += 3;
        }
        this.O.martianTaskListview.removeCallbacks(this.T);
        this.O.martianTaskListview.postDelayed(this.T, 3000L);
    }

    public final void t3() {
        i.y(this, this.L, true, new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u3() {
        if (this.U || !MiConfigSingleton.b2().F2()) {
            return;
        }
        d dVar = new d(this);
        ((MartianFinishNextSubTaskParams) dVar.k()).setAwid(f13149a0);
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v3(MartianFinishSubTask martianFinishSubTask) {
        b bVar = new b(martianFinishSubTask);
        ((MartianGetAppwallParams) bVar.k()).setAwid(f13149a0);
        bVar.j();
    }

    public void w3() {
        if (g.m(this, this.L.getApp().getPackageName())) {
            A3();
        } else {
            t3();
        }
    }

    public final /* synthetic */ void x3() {
        Q1("进入" + this.L.getApp().getName() + this.Q.getContent());
        s3();
    }

    public final /* synthetic */ void y3(View view, int i10) {
        String status = this.L.getSubtasks().get(i10).getStatus();
        if (l.q(status)) {
            return;
        }
        status.hashCode();
        if (status.equals(Z)) {
            onInstallClick(view);
        } else if (status.equals(X)) {
            P1("已领取过该奖励");
        } else {
            P1("该任务未开始");
        }
    }

    public ThemeView z3() {
        ThemeView themeView = new ThemeView(this);
        themeView.setLayoutParams(new AbsListView.LayoutParams(-1, ConfigSingleton.i(100.0f)));
        return themeView;
    }

    public class e extends m8.d {
        public e(Activity activity) {
            super(activity);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(MartianStartSubTask martianStartSubTask) {
            ac.a.e(AppwallTaskDetailActivity.this, "appwall_task", "start:" + AppwallTaskDetailActivity.this.L.getApp().getName());
            AppwallTaskDetailActivity.this.W = true;
        }

        @Override // m8.a
        public void p(x8.c cVar) {
        }
    }
}
