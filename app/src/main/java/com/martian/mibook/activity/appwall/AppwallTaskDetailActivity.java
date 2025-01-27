package com.martian.mibook.activity.appwall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.martian.apptask.AppTaskManager;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.g.g;
import com.martian.appwall.b.b;
import com.martian.appwall.request.MartianGetAppwallParams;
import com.martian.appwall.request.auth.MartianFinishNextSubTaskParams;
import com.martian.appwall.request.auth.MartianStartCurrentSubTaskParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.appwall.response.MartianFinishSubTask;
import com.martian.appwall.response.MartianStartSubTask;
import com.martian.appwall.response.MartianSubTask;
import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.q0;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.martian.mibook.activity.base.n;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.e.c;
import com.martian.rpauth.d.i;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class AppwallTaskDetailActivity extends n {
    private static final String Q = "COMPLETED";
    private static final String R = "INVALID";
    private static final String S = "EXECUTABLE";
    private static final String T = "46";
    private MartianAppwallTask U;
    private com.martian.mibook.e.d X;
    private com.martian.mibook.h.d Y;
    private MartianSubTask Z;
    private long b0;
    private boolean d0;
    private boolean V = false;
    private boolean W = false;
    private int a0 = 0;
    private final Runnable c0 = new Runnable() { // from class: com.martian.mibook.activity.appwall.c
        @Override // java.lang.Runnable
        public final void run() {
            AppwallTaskDetailActivity.this.U2();
        }
    };
    private boolean e0 = true;
    private boolean f0 = false;

    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            boolean z = true;
            if (AppwallTaskDetailActivity.this.X.f11811c.getChildCount() > 0 && (AppwallTaskDetailActivity.this.X.f11811c.getFirstVisiblePosition() != 0 || AppwallTaskDetailActivity.this.X.f11811c.getChildAt(0).getTop() != 0)) {
                z = false;
            }
            AppwallTaskDetailActivity.this.N.setEnabled(z);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }
    }

    class b extends com.martian.appwall.c.c {

        /* renamed from: h */
        final /* synthetic */ MartianFinishSubTask f10901h;

        b(final MartianFinishSubTask val$martianFinishSubTask) {
            this.f10901h = val$martianFinishSubTask;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            AppwallTaskDetailActivity.this.i3(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(MartianAppwallTask newAppwallTask) {
            AppwallTaskDetailActivity.this.g3(newAppwallTask);
            MartianFinishSubTask martianFinishSubTask = this.f10901h;
            if (martianFinishSubTask == null || martianFinishSubTask.getCoins() <= 0) {
                return;
            }
            MiConfigSingleton.V3().M4.G(AppwallTaskDetailActivity.this, "游戏奖励", 0, this.f10901h.getCoins());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            AppwallTaskDetailActivity.this.K2(show);
        }
    }

    class c implements com.martian.apptask.e.c {
        c() {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskActivated(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskClick(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskDownload(AppTask appTask) {
            AppwallTaskDetailActivity.this.k1("开始下载 " + appTask.name);
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskInstalled(AppTask appTask) {
        }
    }

    class d extends com.martian.appwall.c.d.d {
        d(j1 x0) {
            super(x0);
        }

        @Override // com.martian.appwall.c.d.b
        protected void o(b.d.c.b.c errorResult) {
            AppwallTaskDetailActivity.this.k1("任务未完成：" + errorResult.toString());
            MiConfigSingleton.V3().U7(0);
        }

        @Override // b.d.c.c.b
        /* renamed from: s */
        public void onDataReceived(MartianFinishSubTask martianFinishSubTask) {
            AppwallTaskDetailActivity.this.d0 = true;
            if (martianFinishSubTask == null || AppwallTaskDetailActivity.this.U == null) {
                return;
            }
            MiConfigSingleton.V3().U7(0);
            if (AppwallTaskDetailActivity.this.U.getApp() != null) {
                com.martian.mibook.lib.model.g.b.e(AppwallTaskDetailActivity.this, "appwall_task", "finish:" + AppwallTaskDetailActivity.this.U.getApp().getName());
            }
            if (h.F().E0()) {
                AppwallTaskDetailActivity.this.S2(martianFinishSubTask);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class e extends com.martian.appwall.c.d.e {
        e(j1 x0) {
            super(x0);
        }

        @Override // com.martian.appwall.c.d.b
        protected void o(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: s */
        public void onDataReceived(MartianStartSubTask martianStartSubTask) {
            com.martian.mibook.lib.model.g.b.e(AppwallTaskDetailActivity.this, "appwall_task", "start:" + AppwallTaskDetailActivity.this.U.getApp().getName());
            AppwallTaskDetailActivity.this.f0 = true;
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class f implements c.e {
        f() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
            AppwallTaskDetailActivity.this.X2(null);
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            AppwallTaskDetailActivity.this.X2(null);
        }
    }

    private boolean T2() {
        if (this.Z == null || this.a0 < 20) {
            return false;
        }
        int max = Math.max((int) ((System.currentTimeMillis() - this.b0) / 1000), this.a0);
        this.a0 = max;
        if (max < this.Z.getUserDurationInMins() * 60) {
            return false;
        }
        MiConfigSingleton.V3().U7(1);
        return true;
    }

    public void U2() {
        if (this.Z == null) {
            l3();
            return;
        }
        if (T2()) {
            this.X.f11811c.removeCallbacks(this.c0);
            return;
        }
        q0.f("zzz", h.F().u0() + " screenOn:" + g.j(this) + "   duration:" + this.a0);
        if (h.F().u0().equals(this.U.getApp().getPackageName()) && g.j(this)) {
            this.a0 += 3;
        }
        this.X.f11811c.removeCallbacks(this.c0);
        this.X.f11811c.postDelayed(this.c0, 3000L);
    }

    private void V2() {
        s2.B(this, this.U, true, new c());
    }

    /* renamed from: a3 */
    public /* synthetic */ void b3() {
        l1("进入" + this.U.getApp().getName() + this.Z.getContent());
        U2();
    }

    /* renamed from: c3 */
    public /* synthetic */ void d3(View view, int position) {
        String status = this.U.getSubtasks().get(position).getStatus();
        if (k.p(status)) {
            return;
        }
        status.hashCode();
        if (status.equals(S)) {
            onInstallClick(view);
        } else if (status.equals(Q)) {
            k1("已领取过该奖励");
        } else {
            k1("该任务未开始");
        }
    }

    private void f3() {
        if (MiConfigSingleton.V3().l2(this, 10001)) {
            if (!l.r()) {
                k1("正在打开" + this.U.getApp().getName());
                g.s(this, this.U.getApp().getPackageName());
                AppTaskManager.K(this, this.U.getApp().getPackageName());
                if (this.V) {
                    j3(this.U.getSubtasks().get(this.U.getStindex()));
                    k3();
                    return;
                }
                return;
            }
            if (!g.l(this) && !Q.equalsIgnoreCase(this.U.getStatus())) {
                g.A(this);
                return;
            }
            k1("正在打开" + this.U.getApp().getName());
            g.s(this, this.U.getApp().getPackageName());
            AppTaskManager.K(this, this.U.getApp().getPackageName());
            if (this.V) {
                j3(this.U.getSubtasks().get(this.U.getStindex()));
                k3();
            }
        }
    }

    public void g3(MartianAppwallTask newAppwallTask) {
        B2();
        if (newAppwallTask == null) {
            j2();
            return;
        }
        l2();
        this.U = newAppwallTask;
        n3();
    }

    private void h3() {
        this.Y = new com.martian.mibook.h.d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        registerReceiver(this.Y, intentFilter);
    }

    public void i3(b.d.c.b.c errorResult) {
        B2();
        k2(errorResult.d());
    }

    private void j3(MartianSubTask app) {
        this.b0 = System.currentTimeMillis() - (this.a0 * 1000);
        this.Z = app;
        this.X.f11811c.postDelayed(new Runnable() { // from class: com.martian.mibook.activity.appwall.b
            @Override // java.lang.Runnable
            public final void run() {
                AppwallTaskDetailActivity.this.b3();
            }
        }, 3000L);
    }

    private void l3() {
        this.X.f11811c.removeCallbacks(this.c0);
        if (this.Z == null || !T2()) {
            l1("完成任务后才能获取奖励");
        }
    }

    @Override // com.martian.libmars.activity.k1
    public void K2(boolean show) {
        if (show) {
            m2(getString(R.string.loading));
        }
    }

    public void S2(MartianFinishSubTask martianFinishSubTask) {
        MiConfigSingleton.V3().V8(0, martianFinishSubTask.getCoins());
        X2(martianFinishSubTask);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void W2() {
        if (this.d0 || !MiConfigSingleton.V3().x5()) {
            return;
        }
        d dVar = new d(this);
        ((MartianFinishNextSubTaskParams) dVar.k()).setAwid("46");
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X2(final MartianFinishSubTask martianFinishSubTask) {
        b bVar = new b(martianFinishSubTask);
        ((MartianGetAppwallParams) bVar.k()).setAwid("46");
        bVar.j();
    }

    public void Y2() {
        if (g.g(this, this.U.getApp().getPackageName())) {
            f3();
        } else {
            V2();
        }
    }

    public ThemeView e3() {
        ThemeView themeView = new ThemeView(this);
        themeView.setLayoutParams(new AbsListView.LayoutParams(-1, h.b(100.0f)));
        return themeView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k3() {
        if (this.f0 || !MiConfigSingleton.V3().x5()) {
            return;
        }
        e eVar = new e(this);
        ((MartianStartCurrentSubTaskParams) eVar.k()).setAwid("46");
        eVar.j();
    }

    public void m3() {
        if (MiConfigSingleton.V3().x5()) {
            com.martian.mibook.lib.account.e.c.k(this, new f());
        }
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
        X2(null);
    }

    @SuppressLint({"SetTextI18n"})
    public void n3() {
        String str;
        MartianAppwallTask martianAppwallTask = this.U;
        if (martianAppwallTask == null) {
            return;
        }
        if (martianAppwallTask.getApp() != null) {
            this.V = false;
            this.X.f11814f.setBackgroundResource(R.drawable.border_button_bonus_poll_sign_check_in);
            this.X.f11814f.setText(!s2.p(this, this.U.getApp().getPackageName()) ? "下载安装" : "立即前往");
            n0.l(this, this.U.getApp().getIconUrl(), this.X.f11813e, R.drawable.ic_launcher);
            if (k.p(this.U.getApp().getName())) {
                str = "";
            } else {
                str = this.U.getApp().getName();
                this.X.f11815g.setText(str);
            }
            if (this.U.getApp().getSizeInMB() > 0) {
                this.X.f11815g.setText(str + "  (" + this.U.getApp().getSizeInMB() + "MB)");
            }
            if (R.equalsIgnoreCase(this.U.getStatus())) {
                this.X.f11814f.setBackgroundResource(R.drawable.border_button_bonus_poll_sign_checked);
                this.X.f11814f.setText("之前已安装，无法获得奖励");
            } else if (Q.equalsIgnoreCase(this.U.getStatus())) {
                MiConfigSingleton.V3().U7(2);
            } else if (this.U.getSubtasks() != null && this.U.getSubtasks().size() > this.U.getStindex() && S.equalsIgnoreCase(this.U.getSubtasks().get(this.U.getStindex()).getStatus())) {
                this.V = true;
            }
        }
        if (this.U.getCoins() > 0) {
            this.X.f11812d.setVisibility(0);
            this.X.f11812d.setText("总奖金：" + i.q(this.U.getCoins()) + getString(R.string.bonus_unit));
        } else {
            this.X.f11812d.setVisibility(8);
        }
        if (this.U.getSubtasks() != null) {
            com.martian.appwall.b.b bVar = new com.martian.appwall.b.b(this, this.U.getSubtasks());
            this.X.f11811c.setAdapter((ListAdapter) bVar);
            bVar.e(new b.a() { // from class: com.martian.mibook.activity.appwall.a
                @Override // com.martian.appwall.b.b.a
                public final void a(View view, int i2) {
                    AppwallTaskDetailActivity.this.d3(view, i2);
                }
            });
            if (this.U.getSubtasks().size() <= 5 || this.W) {
                return;
            }
            this.W = true;
            this.X.f11811c.addFooterView(e3());
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1018 && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.K(this, MiConfigSingleton.V3().T3("登录成功", requestCode));
            m3();
        } else if (requestCode == 1100) {
            g.A(this);
        }
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appwall_task_detail);
        com.martian.mibook.e.d a2 = com.martian.mibook.e.d.a(h2());
        this.X = a2;
        a2.f11811c.setOnScrollListener(new a());
        h3();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.martian.mibook.h.d dVar = this.Y;
        if (dVar != null) {
            unregisterReceiver(dVar);
        }
    }

    public void onInstallClick(View view) {
        MartianAppwallTask martianAppwallTask = this.U;
        if (martianAppwallTask == null || martianAppwallTask.getApp() == null) {
            return;
        }
        if (R.equalsIgnoreCase(this.U.getStatus())) {
            k1("抱歉，您无法进行该任务");
        } else {
            Y2();
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        T2();
        n3();
        this.X.f11811c.removeCallbacks(this.c0);
        if (MiConfigSingleton.V3().h4() == 1) {
            W2();
            return;
        }
        if (this.e0) {
            this.e0 = false;
            return;
        }
        if (this.V) {
            MartianSubTask martianSubTask = this.Z;
            int userDurationInMins = martianSubTask == null ? 300 : martianSubTask.getUserDurationInMins() * 60;
            if (this.a0 > 0) {
                k1("时间不足（" + this.a0 + "/" + userDurationInMins + "秒），无法获得奖励");
            }
        }
    }
}
