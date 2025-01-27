package com.martian.mibook.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.multidex.MultiDex;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.martian.ads.ad.BaseAd;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeBottomNavigationBar;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.TeenagerBookmallActivity;
import com.martian.mibook.activity.book.search.SearchBookMainActivity;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.e.f7;
import com.martian.mibook.f.l3;
import com.martian.mibook.f.u3;
import com.martian.mibook.f.x3;
import com.martian.mibook.h.g;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.request.GetPromoteBookParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.service.TtsService;
import com.martian.mibook.ui.o.b4;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Homepage extends j1 implements g.a {
    private List<Fragment> B;
    private com.martian.mibook.e.l C;
    private com.martian.libmars.b.d D;
    private com.martian.mibook.h.e E;
    private com.martian.mibook.h.g F;
    private f7 G;
    private ObjectAnimator H;
    private BonusPool I;

    class a extends com.martian.mibook.lib.account.d.g<GetPromoteBookParams, TYInitialBook> {
        a(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<TYInitialBook> tyInitialBookList) {
            TYInitialBook tYInitialBook;
            if (tyInitialBookList == null || tyInitialBookList.isEmpty() || (tYInitialBook = tyInitialBookList.get(0)) == null) {
                return;
            }
            v2.P0(Homepage.this, tYInitialBook);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class b implements MiBookManager.a0 {
        b() {
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String errMsg) {
            if (com.martian.libsupport.k.p(errMsg)) {
                return;
            }
            Homepage.this.k1(errMsg);
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper item) {
            MiBook miBook;
            if (item == null || (miBook = item.mibook) == null) {
                return;
            }
            s2.f0(Homepage.this, miBook, item.book);
        }
    }

    class c implements c.e {
        c() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            if (Homepage.this.C.f12273d.getCurrentItem() == Homepage.this.B.size() - 1) {
                Homepage.this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
            }
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.w {
        d(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean hasInviter) {
            if (com.martian.libmars.utils.n0.c(Homepage.this)) {
                return;
            }
            MiConfigSingleton.V3().x7(hasInviter.booleanValue());
            Homepage.this.D.d(com.martian.mibook.application.v0.f11602f, 3);
        }
    }

    class e implements c.d {

        /* renamed from: a */
        final /* synthetic */ boolean f10828a;

        e(final boolean val$grabFresh) {
            this.f10828a = val$grabFresh;
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void b(MiTaskAccount miTaskAccount) {
            if (com.martian.libmars.utils.n0.c(Homepage.this)) {
                return;
            }
            Homepage.this.e3(true);
            if (this.f10828a) {
                Homepage.this.onFreshRedpaperClick(null);
            }
        }
    }

    class f implements c.e {
        f() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            if (com.martian.libmars.utils.n0.c(Homepage.this)) {
                return;
            }
            Homepage.this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
        }
    }

    class g extends com.martian.mibook.lib.account.d.b {
        g() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(BonusPool bonus) {
            if (bonus == null || com.martian.libmars.utils.n0.c(Homepage.this)) {
                return;
            }
            Homepage.this.I = bonus;
            Homepage.this.D.d(com.martian.mibook.application.v0.f11606j, Homepage.this.I);
            if (Homepage.this.I.getCheckinToday()) {
                MiConfigSingleton.V3().p7();
                Homepage.this.D.d(com.martian.mibook.application.v0.k, 13);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class h extends com.martian.mibook.lib.account.d.q.h {

        /* renamed from: j */
        final /* synthetic */ boolean f10832j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j1 x0, final boolean val$fromBookrack) {
            super(x0);
            this.f10832j = val$fromBookrack;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            Homepage.this.k1("抱歉,签到失败:" + errorResult.d());
            Homepage.this.o2();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(CheckinResult checkinResult) {
            MiConfigSingleton.V3().p7();
            MiConfigSingleton.V3().b7(false);
            if (checkinResult == null) {
                return;
            }
            MiConfigSingleton.V3().V8(checkinResult.getMoney(), checkinResult.getCoins().intValue());
            if (com.martian.libmars.utils.n0.c(Homepage.this)) {
                return;
            }
            Homepage.this.I = checkinResult.getBonusPool();
            Homepage.this.D.d(com.martian.mibook.application.v0.f11606j, Homepage.this.I);
            if (Homepage.this.I.getCheckinDays() == Homepage.this.I.getFullCheckinDays()) {
                Homepage homepage = Homepage.this;
                BonusDetailActivity.E3(homepage, homepage.getString(R.string.bonus_poll), checkinResult.getMoney(), checkinResult.getCoins().intValue(), 0, checkinResult.getExtraId(), checkinResult.getExtraCoins().intValue());
            } else if (this.f10832j && checkinResult.getExtraCoins().intValue() > 0 && checkinResult.getCoins().intValue() > 0 && MiConfigSingleton.V3().g0() <= 3) {
                v2.R0(Homepage.this, checkinResult);
            } else {
                Homepage homepage2 = Homepage.this;
                BonusDetailActivity.E3(homepage2, homepage2.getString(R.string.checkin), checkinResult.getMoney(), checkinResult.getCoins().intValue(), 0, checkinResult.getExtraId(), checkinResult.getExtraCoins().intValue());
            }
        }
    }

    public interface i {
        void a(b.d.c.b.c errorResult);

        void b(ExchangeMoney exchangeMoney);
    }

    /* renamed from: A2 */
    public /* synthetic */ void B2(Boolean gotoBonusDetail) {
        q2((gotoBonusDetail == null || gotoBonusDetail.booleanValue()) ? false : true);
    }

    /* renamed from: C2 */
    public /* synthetic */ void D2(Integer position) {
        a3(2);
    }

    static /* synthetic */ boolean E2(View view) {
        return true;
    }

    static /* synthetic */ boolean F2(View view) {
        return true;
    }

    /* renamed from: G2 */
    public /* synthetic */ boolean H2(MenuItem item) {
        int itemId = item.getItemId();
        int size = itemId == R.id.tab2 ? com.martian.mibook.application.v0.w : itemId == R.id.tab3 ? com.martian.mibook.application.v0.x : itemId == R.id.tab4 ? com.martian.mibook.application.v0.y : itemId == R.id.tab5 ? this.B.size() - 1 : 0;
        this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(size));
        this.C.f12273d.setCurrentItem(size, false);
        W2(size);
        if (size == 0 || size == this.B.size() - 1) {
            MiConfigSingleton.V3().L4.r0(this, this.D, size == 0);
        }
        A1(!MiConfigSingleton.V3().I0());
        return true;
    }

    /* renamed from: I2 */
    public /* synthetic */ void J2(MenuItem item) {
        if (item.getItemId() == R.id.tab1) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.A));
        } else if (item.getItemId() == R.id.tab2) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.B));
        }
    }

    static /* synthetic */ boolean K2(View view) {
        return true;
    }

    static /* synthetic */ boolean L2(View view) {
        return true;
    }

    static /* synthetic */ boolean M2(View view) {
        return true;
    }

    /* renamed from: N2 */
    public /* synthetic */ void O2(final int coins) {
        MiConfigSingleton.V3().M4.G(this, "本次阅读奖励", 0, coins);
        MiConfigSingleton.V3().L4.y0();
    }

    /* renamed from: P2 */
    public /* synthetic */ void Q2() {
        this.D.d(com.martian.mibook.application.v0.f11602f, 2);
    }

    /* renamed from: R2 */
    public /* synthetic */ void S2() {
        if (com.martian.libsupport.f.d(this)) {
            V2("通知引导", "设置成功");
            k1("开启成功");
        } else {
            k1("开启失败");
        }
        MiConfigSingleton.V3().L4.N0(this);
    }

    /* renamed from: T2 */
    public /* synthetic */ void U2() {
        moveTaskToBack(true);
    }

    private void V2(String event, String stag) {
        if (!com.martian.libsupport.k.p(stag)) {
            event = event + "-" + stag;
        }
        com.martian.mibook.lib.model.g.b.P(this, event);
    }

    private void W2(int position) {
        if (position == 0) {
            com.martian.mibook.lib.model.g.b.B(this, "书架-展示");
            return;
        }
        if (position == 1) {
            com.martian.mibook.lib.model.g.b.A(this, "书城-展示");
            return;
        }
        if (position == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(MiConfigSingleton.V3().k() == 2 ? "女频分类" : "男频分类");
            sb.append("展示");
            com.martian.mibook.lib.model.g.b.D(this, sb.toString());
            return;
        }
        if (position == 3) {
            com.martian.mibook.lib.model.g.b.L(this, "赚钱-展示");
            return;
        }
        if (position == 4) {
            com.martian.mibook.lib.model.g.b.l(this, "我的-展示");
        }
    }

    private void X2() {
        if (this.H == null || !com.martian.libsupport.l.p()) {
            return;
        }
        this.H.pause();
    }

    private void Y2() {
        this.E = new com.martian.mibook.h.e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.E, intentFilter);
    }

    private void Z2() {
        if (MiConfigSingleton.V3().H4.e()) {
            if (this.F == null) {
                com.martian.mibook.h.g gVar = new com.martian.mibook.h.g();
                this.F = gVar;
                gVar.a(this, this);
            }
            if (this.G == null) {
                this.C.f12274e.setLayoutResource(R.layout.tts_float_view);
                this.G = f7.a(this.C.f12274e.inflate());
                Book T = MiConfigSingleton.V3().l3().T(MiConfigSingleton.V3().H4.d());
                if (T != null) {
                    com.martian.libmars.utils.n0.f(this, T.getCover(), this.G.f11974c, R.drawable.cover_default, R.drawable.cover_default);
                }
            }
            this.G.getRoot().setVisibility(0);
            TtsService.U(this, TtsService.f14108i);
        }
    }

    private void a3(int position) {
        if (position < 0 || position >= this.C.f12271b.getMenu().size()) {
            return;
        }
        ThemeBottomNavigationBar themeBottomNavigationBar = this.C.f12271b;
        themeBottomNavigationBar.setSelectedItemId(themeBottomNavigationBar.getMenu().getItem(position).getItemId());
    }

    private void b3(Uri uri) {
        com.martian.mibook.lib.model.g.b.Q(this, uri.getPath());
        k1("正在加载文件中...");
        a3(0);
        MiConfigSingleton.V3().l3().M1(this, com.martian.libsupport.e.w(this, uri), false, new b());
    }

    private void l2() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.D = dVar;
        dVar.c(com.martian.mibook.application.v0.f11603g, new rx.k.b() { // from class: com.martian.mibook.activity.e0
            @Override // rx.k.b
            public final void call(Object obj) {
                Homepage.this.v2((Integer) obj);
            }
        });
        this.D.c(com.martian.mibook.application.v0.f11605i, new rx.k.b() { // from class: com.martian.mibook.activity.q
            @Override // rx.k.b
            public final void call(Object obj) {
                Homepage.this.x2((Integer) obj);
            }
        });
        this.D.c(com.martian.mibook.application.v0.f11604h, new rx.k.b() { // from class: com.martian.mibook.activity.z
            @Override // rx.k.b
            public final void call(Object obj) {
                Homepage.this.z2((BonusPool) obj);
            }
        });
        this.D.c(com.martian.mibook.application.v0.f11597a, new rx.k.b() { // from class: com.martian.mibook.activity.x
            @Override // rx.k.b
            public final void call(Object obj) {
                Homepage.this.B2((Boolean) obj);
            }
        });
        this.D.c(com.martian.mibook.application.v0.o, new rx.k.b() { // from class: com.martian.mibook.activity.a0
            @Override // rx.k.b
            public final void call(Object obj) {
                Homepage.this.D2((Integer) obj);
            }
        });
    }

    private void n2() {
        f7 f7Var = this.G;
        if (f7Var != null) {
            f7Var.getRoot().setVisibility(8);
        }
        ObjectAnimator objectAnimator = this.H;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.H = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r2(Intent intent) {
        Uri data;
        if (MiConfigSingleton.V3().T5()) {
            TeenagerBookmallActivity.t2(this, true);
            super.finish();
            return;
        }
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        String scheme = data.getScheme();
        if (com.martian.libsupport.k.p(scheme)) {
            return;
        }
        if (!scheme.equalsIgnoreCase(getString(R.string.scheme))) {
            b3(data);
            return;
        }
        String queryParameter = data.getQueryParameter("tab");
        if (!com.martian.libsupport.k.p(queryParameter)) {
            a3(Integer.parseInt(queryParameter));
        }
        String queryParameter2 = data.getQueryParameter(b.b.a.b.b.f4200c);
        if (!com.martian.libsupport.k.p(queryParameter2)) {
            this.D.d(com.martian.mibook.application.v0.q, Integer.valueOf(Integer.parseInt(queryParameter2)));
            return;
        }
        String queryParameter3 = data.getQueryParameter("sourceId");
        if (!com.martian.libsupport.k.p(queryParameter3)) {
            String queryParameter4 = data.getQueryParameter("sourceName");
            String queryParameter5 = data.getQueryParameter("recommendId");
            s2.C(this, queryParameter3, queryParameter4, queryParameter5, "Deeplink导入");
            if (com.martian.libsupport.k.p(queryParameter5)) {
                return;
            }
            MiConfigSingleton.V3().K7(true);
            MiConfigSingleton.V3().I6();
            return;
        }
        String queryParameter6 = data.getQueryParameter("deeplink");
        String queryParameter7 = data.getQueryParameter("url");
        String queryParameter8 = data.getQueryParameter("stag");
        String str = com.martian.mipush.d.b() + "-" + com.martian.libmars.d.h.F().b0(com.martian.libmars.d.h.f9889h);
        if (!com.martian.libsupport.k.p(queryParameter6)) {
            if (com.martian.apptask.g.g.b(this, queryParameter6)) {
                V2(str + "-deeplink", queryParameter8);
                com.martian.apptask.g.g.u(this, queryParameter6, "", "", true);
                return;
            }
            if (com.martian.libsupport.k.p(queryParameter7)) {
                return;
            }
            V2(str + "-url", queryParameter8);
            MiWebViewActivity.f5(this, queryParameter7);
            return;
        }
        if (com.martian.libsupport.k.p(queryParameter7)) {
            a aVar = new a(GetPromoteBookParams.class, TYInitialBook.class, this);
            ((GetPromoteBookParams) aVar.k()).setCtype(Integer.valueOf(MiConfigSingleton.V3().k()));
            ((GetPromoteBookParams) aVar.k()).setOaid(com.martian.libmars.d.h.F().V());
            ((GetPromoteBookParams) aVar.k()).setImei(com.martian.libmars.d.h.F().z());
            aVar.j();
            return;
        }
        V2(str + "-url", queryParameter8);
        if (queryParameter7.contains("sslocal")) {
            k1("不支持的类型");
        } else {
            MiWebViewActivity.f5(this, queryParameter7);
        }
    }

    private void s2() {
        ArrayList arrayList = new ArrayList();
        this.B = arrayList;
        arrayList.add(new u3());
        this.B.add(new com.martian.mibook.f.f4.f0());
        this.B.add(new com.martian.mibook.f.f4.h0());
        if (!MiConfigSingleton.V3().A5()) {
            this.B.add(new x3());
        }
        this.B.add(new l3());
    }

    private void t2() {
        if (this.C.f12273d.getAdapter() == null) {
            this.C.f12273d.setOffscreenPageLimit(this.B.size());
            this.C.f12273d.setScrollable(false);
            this.C.f12273d.setAdapter(new b4(getSupportFragmentManager(), this.B));
        }
        if (MiConfigSingleton.V3().A5()) {
            this.C.f12271b.getMenu().findItem(R.id.tab4).setVisible(false);
        }
        this.C.f12271b.setOnNavigationItemSelectedListener(new BottomNavigationView.d() { // from class: com.martian.mibook.activity.s
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.d
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return Homepage.this.H2(menuItem);
            }
        });
        this.C.f12271b.setOnNavigationItemReselectedListener(new BottomNavigationView.c() { // from class: com.martian.mibook.activity.b0
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.c
            public final void a(MenuItem menuItem) {
                Homepage.this.J2(menuItem);
            }
        });
        if (MiConfigSingleton.V3().S2()) {
            a3(com.martian.mibook.application.v0.w);
        }
        this.C.f12271b.findViewById(R.id.tab1).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.f0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Homepage.K2(view);
            }
        });
        this.C.f12271b.findViewById(R.id.tab2).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.u
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Homepage.L2(view);
            }
        });
        this.C.f12271b.findViewById(R.id.tab3).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.d0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Homepage.M2(view);
            }
        });
        this.C.f12271b.findViewById(R.id.tab4).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.y
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Homepage.E2(view);
            }
        });
        this.C.f12271b.findViewById(R.id.tab5).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.t
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return Homepage.F2(view);
            }
        });
    }

    /* renamed from: u2 */
    public /* synthetic */ void v2(Integer idx) {
        if (idx != null) {
            a3(idx.intValue());
        }
    }

    /* renamed from: w2 */
    public /* synthetic */ void x2(Integer idx) {
        onFreshRedpaperClick(null);
    }

    /* renamed from: y2 */
    public /* synthetic */ void z2(BonusPool mBonusPool) {
        if (mBonusPool != null) {
            this.D.d(com.martian.mibook.application.v0.f11606j, mBonusPool);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        if (this.C.f12273d.getCurrentItem() == this.B.size() - 1) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
        } else if (this.C.f12273d.getCurrentItem() == this.B.size() - 2) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.y));
        }
    }

    @Override // com.martian.mibook.h.g.a
    public void a(long targetTime) {
    }

    @Override // com.martian.mibook.h.g.a
    public void b0() {
        f7 f7Var = this.G;
        if (f7Var != null) {
            f7Var.f11975d.setImageResource(R.drawable.icon_tts_float_play);
            X2();
        }
    }

    public void c3(final boolean grabFresh) {
        if (MiConfigSingleton.V3().x5()) {
            com.martian.mibook.lib.account.e.c.l(this, new e(grabFresh));
            com.martian.mibook.lib.account.e.c.k(this, new f());
        }
    }

    @Override // com.martian.mibook.h.g.a
    public void d0(int chapterIndex, int contentIndex, String sourceString) {
        n2();
    }

    public void d3(boolean isScroll) {
        this.C.f12271b.getMenu().findItem(R.id.tab2).setIcon(isScroll ? R.drawable.main_tab_icon_bookstore_refresh_day : R.drawable.main_tab_icon_bookstore_day);
    }

    @Override // com.martian.mibook.h.g.a
    public void e0(boolean hide) {
    }

    public void e3(boolean updateStatusOnly) {
        this.D.d(com.martian.mibook.application.v0.f11599c, com.martian.mibook.application.v0.s);
        if (updateStatusOnly) {
            return;
        }
        o2();
        this.D.d(com.martian.mibook.application.v0.f11599c, com.martian.mibook.application.v0.u);
        if (this.C.f12273d.getCurrentItem() == this.B.size() - 1) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
        }
    }

    @Override // com.martian.libmars.activity.j1, g.b
    public void j0() {
        super.j0();
        if (this.C.f12273d.getCurrentItem() == com.martian.mibook.application.v0.z) {
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
        }
        this.D.d(com.martian.mibook.application.v0.f11602f, null);
        this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.C));
    }

    public void m2(final boolean fromBookrack) {
        if (MiConfigSingleton.V3().k2(this)) {
            new h(this, fromBookrack).j();
        }
    }

    @Override // com.martian.mibook.h.g.a
    public void n0() {
        f7 f7Var = this.G;
        if (f7Var != null) {
            f7Var.f11975d.setImageResource(R.drawable.icon_tts_float_pause);
            if (com.martian.libsupport.l.p()) {
                ObjectAnimator objectAnimator = this.H;
                if (objectAnimator == null) {
                    this.H = com.martian.libmars.utils.h0.b(this.G.f11974c);
                } else {
                    objectAnimator.resume();
                }
            }
        }
    }

    @Override // com.martian.mibook.h.g.a
    public void o0(int chapterIndex, int contentIndex) {
    }

    public void o2() {
        new g().j();
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if ((requestCode == 10001 || (requestCode >= 1000 && requestCode <= 1023)) && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.K(this, MiConfigSingleton.V3().T3("登录成功", requestCode));
            c3(requestCode == 1017);
            p2();
            e3(false);
        } else if (requestCode == 200) {
            if (resultCode == -1 && data != null) {
                final int intExtra = data.getIntExtra(ReadingActivity.E, 0);
                if (intExtra > 10) {
                    new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            Homepage.this.O2(intExtra);
                        }
                    });
                }
                if (data.getBooleanExtra(ReadingActivity.F, false)) {
                    j0();
                }
            }
            this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.v));
        } else if (requestCode == 300) {
            this.D.d(com.martian.mibook.application.v0.f11599c, com.martian.mibook.application.v0.t);
        } else if (requestCode == 3) {
            this.D.d(com.martian.mibook.application.v0.f11602f, 3);
        } else if (requestCode == 20003 && resultCode == -1) {
            this.D.d(com.martian.mibook.application.v0.f11602f, 8);
        } else if (requestCode == 2 && resultCode == -1) {
            MiConfigSingleton.V3().L4.H0(this, new o0.r() { // from class: com.martian.mibook.activity.c0
                @Override // com.martian.mibook.application.o0.r
                public final void a() {
                    Homepage.this.Q2();
                }
            });
        } else if (requestCode == 1001) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.w
                @Override // java.lang.Runnable
                public final void run() {
                    Homepage.this.S2();
                }
            });
        } else if (requestCode == 10002 && resultCode == -1) {
            if (this.C.f12273d.getCurrentItem() == this.B.size() - 1) {
                this.D.d(com.martian.mibook.application.v0.l, Integer.valueOf(com.martian.mibook.application.v0.z));
            }
        } else if (requestCode == 207 && resultCode == -1) {
            o2();
        } else if (requestCode == 876 && resultCode == -1) {
            this.D.d(com.martian.mibook.application.v0.n, 0);
        } else if (requestCode == 10024) {
            com.martian.mibook.lib.account.e.c.k(this, new c());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        MultiDex.install(this);
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        com.martian.mibook.e.l c2 = com.martian.mibook.e.l.c(LayoutInflater.from(this));
        this.C = c2;
        setContentView(c2.getRoot());
        d(false);
        W0(true);
        s2();
        l2();
        MiConfigSingleton.V3().A0();
        MiConfigSingleton.V3().Q1(this);
        com.martian.mibook.d.a.a().e();
        t2();
        r2(getIntent());
        o2();
        Y2();
        MiConfigSingleton.V3().O4();
        MiConfigSingleton.V3().m2(this, false);
        y1();
        MiConfigSingleton.V3().B7(true);
        MiConfigSingleton.V3().L4.J0(this, this.D);
        if (MiConfigSingleton.V3().W3().getGrayMode()) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            this.C.f12272c.setLayerType(2, paint);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.martian.libmars.b.d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        com.martian.mibook.h.e eVar = this.E;
        if (eVar != null) {
            unregisterReceiver(eVar);
        }
        com.martian.mibook.h.g gVar = this.F;
        if (gVar != null) {
            unregisterReceiver(gVar);
        }
        MiConfigSingleton.V3().L4.s0();
        if (MiConfigSingleton.V3().D5()) {
            BaseAd.exitOppoAd(this);
        }
        n2();
    }

    public void onExitTtsClick(View view) {
        TtsService.U(this, TtsService.f14104e);
    }

    public void onFreshRedpaperClick(View view) {
        if (MiConfigSingleton.V3().l2(this, 1017)) {
            MiConfigSingleton.V3().L4.V(this, this.D, true, null);
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        u3 u3Var;
        com.martian.mibook.ui.o.u3 u3Var2;
        if (keyCode == 4) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("android:switcher:2131232571:0");
            if ((findFragmentByTag instanceof u3) && (u3Var2 = (u3Var = (u3) findFragmentByTag).p) != null && u3Var2.e0()) {
                u3Var.X2(false);
                return true;
            }
            if (MiConfigSingleton.V3().g0() == 1) {
                if (this.C.f12273d.getCurrentItem() != 1) {
                    com.martian.mibook.lib.model.g.b.H(this, "书城引导");
                    a3(1);
                    return true;
                }
            } else if (this.C.f12273d.getCurrentItem() != 0) {
                a3(0);
                return true;
            }
            if (MiConfigSingleton.V3().H4.e()) {
                com.martian.libmars.utils.k0.P(this, getString(R.string.confirm_message), getString(R.string.confirm_exit) + getString(R.string.app_name) + getString(R.string.confirm_exit_end), new k0.l() { // from class: com.martian.mibook.activity.r
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        Homepage.this.U2();
                    }
                });
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.martian.libmars.activity.j1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        r2(intent);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        X2();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Z2();
    }

    public void onSearchClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(MiConfigSingleton.V3().k() == 2 ? "女频" : "男频");
        sb.append("搜索");
        com.martian.mibook.lib.model.g.b.A(this, sb.toString());
        startActivity(SearchBookMainActivity.class);
    }

    public void onTingshuActionClick(View view) {
        TtsService.U(this, TtsService.f14101b);
    }

    public void onTtsBookClick(View view) {
        MiReadingRecord W;
        String d2 = MiConfigSingleton.V3().H4.d();
        if (com.martian.libsupport.k.p(d2) || (W = MiConfigSingleton.V3().l3().W(d2)) == null) {
            return;
        }
        s2.j0(this, W);
    }

    public void p2() {
        if (MiConfigSingleton.V3().x5()) {
            new d(this).j();
        }
    }

    public void q2(boolean fromBookrack) {
        if (MiConfigSingleton.V3().k2(this)) {
            if (fromBookrack) {
                com.martian.mibook.lib.model.g.b.B(this, "签到");
            } else {
                com.martian.mibook.lib.model.g.b.L(this, "签到");
            }
            BonusPool bonusPool = this.I;
            if (bonusPool == null) {
                o2();
            } else if (bonusPool.getCheckinToday()) {
                k1(this.I.getCheckinDays() == this.I.getFullCheckinDays() ? "今日已分红" : "今日已签到");
            } else {
                m2(fromBookrack);
            }
        }
    }
}
