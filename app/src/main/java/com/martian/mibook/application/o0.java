package com.martian.mibook.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.martian.ads.ad.AdConfig;
import com.martian.appwall.request.MartianLuckyDrawParams;
import com.martian.appwall.request.auth.MartianFinishRewardVideoParams;
import com.martian.appwall.request.auth.MartianGetXianwanGamesParams;
import com.martian.appwall.request.auth.MartianPlayxianAppwallParams;
import com.martian.appwall.response.MiDongMina;
import com.martian.appwall.response.MiDongMinaList;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.account.BindInviterActivity;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.o0;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.data.XianWanGameChannel;
import com.martian.mibook.e.d2;
import com.martian.mibook.e.i4;
import com.martian.mibook.e.j4;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.BookrackMissionsParams;
import com.martian.mibook.lib.account.request.auth.CheckinNotifyParams;
import com.martian.mibook.lib.account.request.auth.UrlMissionParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionBonusList;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.ShowWealthResult;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.account.response.TYActivityList;
import com.martian.mibook.lib.account.response.UrlMission;
import com.martian.mibook.lib.account.response.UrlMissionResult;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class o0 {

    /* renamed from: a */
    private static final String f11519a = "rul_mission_json_file";

    /* renamed from: b */
    private static final String f11520b = "mimission_json_file";

    /* renamed from: c */
    public static final int f11521c = 1;

    /* renamed from: d */
    public static final int f11522d = 2;

    /* renamed from: e */
    private MissionBonusList f11523e;

    /* renamed from: f */
    private final Context f11524f;

    /* renamed from: g */
    private UrlMission f11525g;

    /* renamed from: h */
    private MiDongMinaList f11526h;

    /* renamed from: i */
    private MiDongMina f11527i;

    /* renamed from: j */
    private List<XianWanGame> f11528j;
    private List<TYActivity> l;
    private List<TYActivity> k = new ArrayList();
    private long m = -1;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private final List<MissionItem> q = new ArrayList();
    private List<MissionItem> r = new ArrayList();
    private long s = 0;
    private List<MissionItem> t = new ArrayList();
    private int u = MiConfigSingleton.V3().r4();
    private long v = 0;

    /* loaded from: classes3.dex */
    class a extends com.martian.mibook.lib.account.d.a {

        /* renamed from: h */
        final /* synthetic */ j1 f11529h;

        /* renamed from: i */
        final /* synthetic */ com.martian.libmars.b.d f11530i;

        a(final j1 val$rxManager, final com.martian.libmars.b.d val$activity) {
            this.f11529h = val$rxManager;
            this.f11530i = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYActivityList rpActivityList) {
            if (rpActivityList == null || rpActivityList.getActivityList() == null || rpActivityList.getActivityList().isEmpty()) {
                return;
            }
            o0.this.k = rpActivityList.getActivityList();
            o0.this.r0(this.f11529h, this.f11530i, true);
            this.f11530i.d(v0.f11600d, rpActivityList.getActivityList());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class b extends b.d.a.k.b {
        b() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            o0.this.p = true;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            o0.this.p = false;
        }
    }

    /* loaded from: classes3.dex */
    class c extends com.martian.mibook.lib.account.d.q.v {

        /* renamed from: j */
        final /* synthetic */ boolean f11533j;
        final /* synthetic */ j1 k;
        final /* synthetic */ com.martian.libmars.b.d l;
        final /* synthetic */ r m;

        class a implements c.d {
            a() {
            }

            @Override // com.martian.mibook.lib.account.e.c.d
            public void a(b.d.c.b.c errorResult) {
            }

            @Override // com.martian.mibook.lib.account.e.c.d
            public void b(MiTaskAccount miTaskAccount) {
                r rVar = c.this.m;
                if (rVar != null) {
                    rVar.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(j1 x0, final boolean val$listener, final j1 val$rxManager, final com.martian.libmars.b.d val$activity, final r val$manual) {
            super(x0);
            this.f11533j = val$listener;
            this.k = val$rxManager;
            this.l = val$activity;
            this.m = val$manual;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (this.f11533j) {
                this.k.k1(errorResult.d());
            }
            com.martian.mibook.lib.model.g.b.N(this.k, "新手红包-领取-失败");
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExchangeMoney exchangeMoney) {
            if (exchangeMoney == null) {
                return;
            }
            com.martian.libmars.b.d dVar = this.l;
            if (dVar != null) {
                dVar.d(v0.f11602f, 4);
            }
            com.martian.mibook.lib.account.e.c.l(this.k, new a());
            com.martian.mibook.lib.model.g.b.N(this.k, "新手红包-领取-成功");
        }
    }

    /* loaded from: classes3.dex */
    class d extends com.martian.mibook.lib.account.d.q.d0<CheckinNotifyParams, Boolean> {
        d(Class x0, Class x1, Activity x2) {
            super(x0, x1, x2);
        }

        @Override // com.martian.mibook.lib.account.d.q.d0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Boolean> results) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class e extends com.martian.mibook.lib.account.d.g<BookrackMissionsParams, MissionItem> {

        /* renamed from: g */
        final /* synthetic */ p f11536g;

        /* renamed from: h */
        final /* synthetic */ j1 f11537h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Class x0, Class x1, Context x2, final p val$mActivity, final j1 val$listener) {
            super(x0, x1, x2);
            this.f11536g = val$mActivity;
            this.f11537h = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<MissionItem> missionItems) {
            if (missionItems == null || missionItems.isEmpty()) {
                return;
            }
            Iterator<MissionItem> it = missionItems.iterator();
            while (it.hasNext()) {
                MissionItem next = it.next();
                if (next.getType() == 17 || next.getType() == 101 || next.getType() == 15) {
                    it.remove();
                }
            }
            o0.this.r = missionItems;
            if (this.f11536g != null) {
                MissionItem M = o0.this.M();
                if (M == null && !o0.this.r.isEmpty()) {
                    M = (MissionItem) o0.this.r.remove(0);
                }
                this.f11536g.a(M);
            }
            o0.this.p(this.f11537h, this.f11536g);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class f extends com.martian.mibook.lib.account.d.g<BookrackMissionsParams, MissionItem> {

        /* renamed from: g */
        final /* synthetic */ p f11539g;

        /* renamed from: h */
        final /* synthetic */ j1 f11540h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Class x0, Class x1, Context x2, final p val$mActivity, final j1 val$listener) {
            super(x0, x1, x2);
            this.f11539g = val$mActivity;
            this.f11540h = val$listener;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<MissionItem> missionItems) {
            if (missionItems == null || missionItems.isEmpty()) {
                return;
            }
            o0.this.t = missionItems;
            p pVar = this.f11539g;
            if (pVar != null) {
                o0.this.N(this.f11540h, pVar);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class g extends com.martian.mibook.lib.account.d.h {
        g() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(MissionBonusList missionBonusList) {
            if (missionBonusList == null || missionBonusList.getBonusList() == null || missionBonusList.getBonusList().size() == 0) {
                return;
            }
            try {
                o0.this.t0(GsonUtils.b().toJson(missionBonusList));
                o0.this.w0(missionBonusList);
                o0.this.a0(missionBonusList.getBonusList());
            } catch (Exception unused) {
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class h extends com.martian.mibook.lib.account.d.q.o0 {

        /* renamed from: j */
        final /* synthetic */ u f11543j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j1 x0, final u val$listener) {
            super(x0);
            this.f11543j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.f11543j.a(null);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(UrlMission urlMission) {
            if (urlMission == null || this.f11543j == null) {
                return;
            }
            o0.this.A0(urlMission);
            this.f11543j.a(urlMission);
        }
    }

    /* loaded from: classes3.dex */
    class i extends com.martian.appwall.c.d.f {
        i(j1 x0) {
            super(x0);
        }

        @Override // com.martian.appwall.c.d.b
        protected void o(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(MiDongMinaList miDongMinaList) {
            MiConfigSingleton.V3().I7();
            if (miDongMinaList == null || miDongMinaList.getMinaList() == null || miDongMinaList.getMinaList().size() == 0) {
                return;
            }
            o0.this.f11526h = miDongMinaList;
        }
    }

    /* loaded from: classes3.dex */
    class j extends com.martian.appwall.c.d.c<MartianGetXianwanGamesParams, XianWanGameChannel> {
        j(Class x0, Class x1, Activity x2) {
            super(x0, x1, x2);
        }

        @Override // com.martian.appwall.c.d.c, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            super.onResultError(errorResult);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<XianWanGameChannel> gameChannels) {
            if (gameChannels == null || gameChannels.isEmpty()) {
                return;
            }
            for (XianWanGameChannel xianWanGameChannel : gameChannels) {
                if (xianWanGameChannel.getMcid().intValue() == 10001) {
                    o0.this.f11528j = xianWanGameChannel.getGameList();
                    return;
                }
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class k extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f11546a;

        /* renamed from: b */
        final /* synthetic */ boolean f11547b;

        /* renamed from: c */
        final /* synthetic */ t f11548c;

        k(final j1 val$listener, final boolean val$isFirstTime, final t val$mActivity) {
            this.f11546a = val$listener;
            this.f11547b = val$isFirstTime;
            this.f11548c = val$mActivity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            o0.this.q(this.f11546a, this.f11547b ? k0.k3 : k0.l3, config == null ? BaseWrapper.BASE_PKG_SYSTEM : config.getSource(), this.f11547b ? com.martian.mibook.b.b.H : com.martian.mibook.b.b.I, verify, 0, this.f11548c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            o0.this.p0(this.f11546a, this.f11547b ? com.martian.mibook.b.b.H : com.martian.mibook.b.b.I, false, 0, this.f11548c);
        }
    }

    /* loaded from: classes3.dex */
    class l extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f11550a;

        /* renamed from: b */
        final /* synthetic */ t f11551b;

        l(final j1 val$listener, final t val$mActivity) {
            this.f11550a = val$listener;
            this.f11551b = val$mActivity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            o0.this.q(this.f11550a, k0.b3, config == null ? BaseWrapper.BASE_PKG_SYSTEM : config.getSource(), com.martian.mibook.b.b.E, verify, 1, this.f11551b);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            o0.this.p0(this.f11550a, com.martian.mibook.b.b.E, false, 1, this.f11551b);
        }
    }

    /* loaded from: classes3.dex */
    class m extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f11553a;

        /* renamed from: b */
        final /* synthetic */ t f11554b;

        m(final j1 val$listener, final t val$mActivity) {
            this.f11553a = val$listener;
            this.f11554b = val$mActivity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            o0.this.q(this.f11553a, k0.Z2, config == null ? BaseWrapper.BASE_PKG_SYSTEM : config.getSource(), com.martian.mibook.b.b.G, verify, 2, this.f11554b);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            o0.this.p0(this.f11553a, com.martian.mibook.b.b.G, false, 2, this.f11554b);
        }
    }

    /* loaded from: classes3.dex */
    class n extends com.martian.mibook.lib.account.d.g<MartianFinishRewardVideoParams, Boolean> {

        /* renamed from: g */
        final /* synthetic */ j1 f11556g;

        /* renamed from: h */
        final /* synthetic */ String f11557h;

        /* renamed from: i */
        final /* synthetic */ int f11558i;

        /* renamed from: j */
        final /* synthetic */ t f11559j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Class x0, Class x1, Context x2, final j1 val$listener, final String val$videoType, final int val$bonus, final t val$activity) {
            super(x0, x1, x2);
            this.f11556g = val$listener;
            this.f11557h = val$videoType;
            this.f11558i = val$bonus;
            this.f11559j = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            o0.this.p0(this.f11556g, this.f11557h, true, this.f11558i, this.f11559j);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<Boolean> types) {
            o0.this.p0(this.f11556g, this.f11557h, true, this.f11558i, this.f11559j);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class o extends com.martian.mibook.lib.account.d.q.j0 {

        /* renamed from: j */
        final /* synthetic */ j1 f11560j;
        final /* synthetic */ r k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(j1 x0, final j1 val$listener, final r val$mActivity) {
            super(x0);
            this.f11560j = val$listener;
            this.k = val$mActivity;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            this.f11560j.k1(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(final ShowWealthResult showWealthResult) {
            if (showWealthResult == null || showWealthResult.getCoins().intValue() <= 0) {
                return;
            }
            MiConfigSingleton.V3().m8();
            BonusDetailActivity.E3(this.f11560j, "晒收入", 0, showWealthResult.getCoins().intValue(), 0, showWealthResult.getExtraId().longValue(), showWealthResult.getExtraCoins().intValue());
            r rVar = this.k;
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface p {
        void a(MissionItem missionItem);

        void b(MissionItem missionItem);
    }

    /* loaded from: classes3.dex */
    public interface q {
        void a(TYActivityList rpActivityList);
    }

    /* loaded from: classes3.dex */
    public interface r {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface s {
        void a(MissionItem item);
    }

    /* loaded from: classes3.dex */
    public interface t {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface u {
        void a(UrlMission urlMission);
    }

    o0(Context context) {
        this.f11524f = context;
        n0();
    }

    private String B() {
        return "每收1名徒弟即可获得" + com.martian.rpauth.d.i.m(Integer.valueOf(J(1))) + "元现金奖励,徒弟看小说还会向您进贡20%金币,首次收徒送" + com.martian.rpauth.d.i.m(Integer.valueOf(J(7))) + "元现金";
    }

    private void D0(Activity mActivity) {
        z0(false);
        this.m = System.currentTimeMillis();
        MiConfigSingleton.V3().N4.s(mActivity, b.d.a.j.b.q, new b());
    }

    private void F0(j1 activity) {
        String str;
        int b4 = (int) ((MiConfigSingleton.V3().b4() - MartianRPUserManager.t()) / 1000);
        int i2 = b4 / 60;
        int i3 = b4 % 60;
        if (i2 > 0) {
            str = i2 + "分";
        } else {
            str = "";
        }
        if (i3 > 0) {
            str = str + i3 + "秒";
        }
        if (com.martian.libsupport.k.p(str)) {
            str = "倒计时结束";
        }
        if (activity != null) {
            activity.k1(str + "后可继续观看");
        }
    }

    private boolean G0(j1 activity) {
        if (!MiConfigSingleton.V3().i6()) {
            return false;
        }
        if (MiConfigSingleton.V3().D0("" + MiConfigSingleton.V3().G4())) {
            return false;
        }
        v2.h1(activity);
        return true;
    }

    private void I0(final TextView hint_grab, final IntervalCountdownTextView mission_interval_countdown) {
        O0(hint_grab, mission_interval_countdown, MiConfigSingleton.V3().w2());
        mission_interval_countdown.setOnCountDownFinishListener(new IntervalCountdownTextView.b() { // from class: com.martian.mibook.application.b0
            @Override // com.martian.mibook.ui.IntervalCountdownTextView.b
            public final void a(IntervalCountdownTextView intervalCountdownTextView) {
                o0.this.m0(hint_grab, mission_interval_countdown, intervalCountdownTextView);
            }
        });
    }

    private String L(Context context) {
        return com.martian.apptask.g.g.g(context, "com.martian.qplay") ? "去看看" : context.getString(R.string.mission_item_game_go);
    }

    private boolean L0(j1 mActivity) {
        int interAdStartRuntimes;
        int h0;
        if (this.p || MiConfigSingleton.V3().j5() || MiConfigSingleton.V3().h6() || (h0 = MiConfigSingleton.V3().h0()) < (interAdStartRuntimes = MiConfigSingleton.V3().W3().getInterAdStartRuntimes())) {
            return false;
        }
        int interAdRuntimesInterval2 = MiConfigSingleton.V3().W3().getInterAdRuntimesInterval2();
        if (interAdStartRuntimes != h0 && (interAdRuntimesInterval2 <= 0 || h0 % interAdRuntimesInterval2 != 0)) {
            return false;
        }
        D0(mActivity);
        return true;
    }

    public MissionItem M() {
        MiReadingRecord Q3;
        if (!MiConfigSingleton.V3().J5() || (Q3 = MiConfigSingleton.V3().Q3()) == null) {
            return null;
        }
        Book S = MiConfigSingleton.V3().l3().S(com.martian.mibook.lib.model.manager.d.k(Q3.getSourceString()));
        if (S == null || MiConfigSingleton.V3().l3().v0(S.buildMibook())) {
            return null;
        }
        MissionItem missionItem = new MissionItem();
        missionItem.setRecommend("书架-上次阅读");
        missionItem.setIntro("最近阅读");
        missionItem.setType(16);
        missionItem.setTitle(Q3.getBookName());
        String chapterTitle = Q3.getChapterTitle();
        if (!com.martian.libsupport.k.p(chapterTitle) && chapterTitle.length() > 9) {
            chapterTitle = chapterTitle.substring(0, 10) + "...";
        }
        missionItem.setDesc(chapterTitle + "\n点击继续阅读");
        missionItem.setIcon(S.getCover());
        missionItem.setOrigin(Q3);
        return missionItem;
    }

    private void O0(TextView hint_grab, IntervalCountdownTextView mission_interval_countdown, boolean isTimeStarts) {
        if (isTimeStarts) {
            hint_grab.setVisibility(8);
            mission_interval_countdown.setVisibility(0);
            mission_interval_countdown.o(MiConfigSingleton.V3().b4());
        } else {
            hint_grab.setVisibility(0);
            mission_interval_countdown.setVisibility(8);
            mission_interval_countdown.s();
        }
    }

    private String Q() {
        String[] r2 = MiConfigSingleton.V3().r2();
        if (r2 == null || r2.length == 0) {
            return "";
        }
        if (r2.length == 1) {
            return "； 评论内容需包含\"" + r2[0] + "\"。";
        }
        return "； 评论内容需包含\"" + r2[0] + "\"和\"" + r2[1] + "\"。";
    }

    static /* synthetic */ int h0(MissionItem lhs, MissionItem rhs) {
        if (lhs == null || rhs == null) {
            return 0;
        }
        return rhs.getPriority() - lhs.getPriority();
    }

    static /* synthetic */ void k0(final boolean verified, final j1 activity, final int videoType, final String bonus, final t listener) {
        if (!verified) {
            activity.k1("领取奖励失败");
            return;
        }
        activity.k1("观看成功");
        if (videoType == 1 || videoType == 2) {
            MiConfigSingleton.V3().u8();
            MiConfigSingleton.V3().L7();
            if (videoType == 2) {
                BonusDetailActivity.E3(activity, bonus, 0, MiConfigSingleton.V3().E4(), 0, 0L, 0);
            } else {
                MiConfigSingleton.V3().M4.G(activity, "作者红包奖励", 0, MiConfigSingleton.V3().E4());
            }
        }
        if (listener != null) {
            listener.a();
        }
        com.martian.mibook.lib.account.e.c.k(activity, null);
    }

    /* renamed from: l0 */
    public /* synthetic */ void m0(final TextView hint_grab, final IntervalCountdownTextView mission_interval_countdown, IntervalCountdownTextView textView) {
        O0(hint_grab, mission_interval_countdown, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p(j1 mActivity, p listener) {
        if (this.t.isEmpty()) {
            if (this.v <= 0 || System.currentTimeMillis() - this.v >= 10000) {
                this.v = System.currentTimeMillis();
                f fVar = new f(BookrackMissionsParams.class, MissionItem.class, mActivity, listener, mActivity);
                ((BookrackMissionsParams) fVar.k()).setType(Integer.valueOf(BookrackMissionsParams.BOOKRACK_MISSION_RIGHT));
                ((BookrackMissionsParams) fVar.k()).setCtype(Integer.valueOf(MiConfigSingleton.V3().k()));
                fVar.j();
            }
        }
    }

    public void p0(final j1 activity, final String bonus, final boolean verified, final int videoType, final t listener) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.martian.mibook.application.c0
                @Override // java.lang.Runnable
                public final void run() {
                    o0.k0(verified, activity, videoType, bonus, listener);
                }
            });
        }
    }

    private String z() {
        return "首次邀请好友可获得" + com.martian.rpauth.d.i.m(Integer.valueOf(J(7))) + "元现金奖励和20%收益提成";
    }

    public MissionItem A(boolean isHeader) {
        MissionBonusList missionBonusList = this.f11523e;
        if (missionBonusList != null && !missionBonusList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (MissionItem missionItem : this.f11523e.getBonusList()) {
                if (n(missionItem.getType()) && !missionItem.getHide().booleanValue() && (isHeader || missionItem.getType() != 5)) {
                    if (!MiConfigSingleton.V3().k5() || !MiConfigSingleton.V3().l5(missionItem.getType())) {
                        if (!com.martian.libsupport.k.p(missionItem.getTitle()) || !com.martian.libsupport.k.p(missionItem.getDesc())) {
                            if (MiConfigSingleton.V3().x5() || !missionItem.getAuthShow()) {
                                if (missionItem.getRunTimes() <= 0 || MiConfigSingleton.V3().g0() > missionItem.getRunTimes()) {
                                    if (missionItem.getType() != 106 || (!MiConfigSingleton.V3().Z8() && !MiConfigSingleton.V3().w2())) {
                                        if (missionItem.getClickType() == 1) {
                                            if (!MiConfigSingleton.V3().q2(I(missionItem.getType())) && MiConfigSingleton.V3().Y3(I(missionItem.getType()), false) < missionItem.getClickTimes()) {
                                                arrayList.add(missionItem);
                                            }
                                        } else if (missionItem.getClickType() == 2 && MiConfigSingleton.V3().Y3(I(missionItem.getType()), true) < missionItem.getClickTimes()) {
                                            arrayList.add(missionItem);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (isHeader) {
                if (!MiConfigSingleton.V3().i5()) {
                    arrayList.add(new MissionItem(13, "签到领奖励，签满7天领奖金池分红", 1, 1, false, 13, "立即签到"));
                }
                if (arrayList.size() > 1) {
                    Collections.sort(arrayList, new Comparator() { // from class: com.martian.mibook.application.y
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return o0.h0((MissionItem) obj, (MissionItem) obj2);
                        }
                    });
                }
                if (arrayList.size() > 0) {
                    return (MissionItem) arrayList.get(0);
                }
            } else if (arrayList.size() > 0) {
                return (MissionItem) arrayList.get(new Random().nextInt(arrayList.size()));
            }
        }
        return null;
    }

    public void A0(UrlMission urlMission) {
        this.f11525g = urlMission;
        try {
            com.martian.libsupport.e.E(this.f11524f, f11519a, GsonUtils.b().toJson(urlMission));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void B0(final j1 mActivity, t listener) {
        if (com.martian.libmars.utils.n0.B(mActivity)) {
            if (MiConfigSingleton.V3().Z8()) {
                mActivity.k1("今日额度已用完，明天再来吧");
            } else if (MiConfigSingleton.V3().w2()) {
                F0(mActivity);
            } else {
                MiConfigSingleton.V3().N4.t(mActivity, b.d.a.j.b.f4375h, new l(mActivity, listener));
            }
        }
    }

    public void C(j1 mActivity, p listener) {
        if (this.r.isEmpty()) {
            o(mActivity, listener);
        } else if (listener != null) {
            listener.a(this.r.remove(0));
        }
    }

    public void C0(final j1 mActivity, boolean isFirstTime, t listener) {
        MiConfigSingleton.V3().N4.t(mActivity, b.d.a.j.b.f4374g, new k(mActivity, isFirstTime, listener));
    }

    public MiDongMina D() {
        MiDongMinaList miDongMinaList;
        if ((this.f11527i == null || MiConfigSingleton.V3().H0(this.f11527i.getId())) && (miDongMinaList = this.f11526h) != null && miDongMinaList.getMinaList().size() > 0) {
            Iterator<MiDongMina> it = this.f11526h.getMinaList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MiDongMina next = it.next();
                if (!MiConfigSingleton.V3().H0(next.getId())) {
                    this.f11527i = next;
                    break;
                }
            }
        }
        return this.f11527i;
    }

    public String E() {
        if (this.f11527i == null) {
            return "关注微信赚<font color='red'><big><big>100</big></big></font>元";
        }
        return "关注" + com.martian.libsupport.k.w(this.f11527i.getName(), 8) + " 赚<font color='red'><big>" + this.f11527i.getPrice() + "</big></font>" + this.f11527i.getExdw() + "（0.3元可提现）";
    }

    public void E0(final j1 mActivity, final t listener) {
        if (MiConfigSingleton.V3().Z8()) {
            mActivity.k1("今日额度已用完，明天再来吧");
        } else if (MiConfigSingleton.V3().w2()) {
            F0(mActivity);
        } else {
            MiConfigSingleton.V3().N4.t(mActivity, b.d.a.j.b.f4376i, new m(mActivity, listener));
        }
    }

    public void F(j1 mActivity) {
        if (!MiConfigSingleton.V3().x5() || MiConfigSingleton.V3().y5()) {
            return;
        }
        new i(mActivity).j();
    }

    public synchronized MissionBonusList G() {
        return this.f11523e;
    }

    public MissionItem H(j1 mActivity, int tag) {
        String str;
        if (mActivity == null) {
            return null;
        }
        if (tag == 0) {
            return new MissionItem(0, mActivity.getString(R.string.mission_novel), mActivity.getString(R.string.mission_novel_desc), mActivity.getString(R.string.mission_novel_go), true, R.drawable.icon_mission_item_fiction_book, false, u(0), J(0), false, false).setBubbleTitle("看小说赚钱");
        }
        if (tag == 1) {
            return new MissionItem(1, mActivity.getString(R.string.mission_invite_friends), B(), mActivity.getString(R.string.mission_invite_go), true, R.drawable.icon_mission_item_invite, false, u(1), J(1), false, false).setBubbleTitle(mActivity.getString(R.string.mission_invite_friends));
        }
        if (tag == 2) {
            return new MissionItem(2, mActivity.getString(R.string.mission_show_wealth), mActivity.getString(R.string.mission_show_wealth_desc), mActivity.getString(R.string.mission_show_wealth_go), true, R.drawable.icon_mission_item_praise, MiConfigSingleton.V3().P5(), u(2), J(2), false, false).setBubbleTitle(mActivity.getString(R.string.mission_show_wealth));
        }
        if (tag == 3) {
            return new MissionItem(3, mActivity.getString(R.string.mission_bind_inviter), mActivity.getString(R.string.mission_bind_inviter_desc), mActivity.getString(R.string.mission_bind_inviter_go), true, R.drawable.icon_mission_item_invitation_code, MiConfigSingleton.V3().J4(), u(3), J(3), false, false);
        }
        if (tag == 4) {
            return new MissionItem(4, mActivity.getString(R.string.mission_fresh_redpaper), mActivity.getString(R.string.mission_fresh_redpaper_desc), mActivity.getString(R.string.mission_fresh_redpaper_grab), true, R.drawable.icon_mission_item_novice, e0(), u(4), J(4), false, false);
        }
        if (tag == 5) {
            UrlMission urlMission = this.f11525g;
            if (urlMission == null) {
                return null;
            }
            String title = urlMission.getTitle();
            if (this.f11525g.getLeftCount() > 0) {
                str = title + "（剩" + this.f11525g.getLeftCount() + "次）";
            } else {
                str = title + "（今日已完成）";
            }
            return new MissionItem(5, str, mActivity.getString(R.string.mission_url_desc), mActivity.getString(R.string.mission_forward), true, R.drawable.icon_mission_item_gift_bag, false, u(5), J(5), false, true);
        }
        if (tag == 13) {
            return new MissionItem(13, mActivity.getString(R.string.mission_item_game), mActivity.getString(R.string.mission_item_game_desc), L(mActivity), true, R.drawable.icon_mission_item_qplay, false, u(201), J(201), false, false);
        }
        if (tag == 106) {
            return new MissionItem(106, mActivity.getString(R.string.mission_video), mActivity.getString(R.string.mission_video_desc) + "，每天限量" + MiConfigSingleton.V3().L4.r(106) + "次（" + MiConfigSingleton.V3().F4() + "）", mActivity.getString(R.string.mission_video_grab), true, R.drawable.icon_mission_item_video, MiConfigSingleton.V3().Z8(), u(106), J(106), false, true);
        }
        if (tag == 108) {
            return new MissionItem(108, mActivity.getString(R.string.mission_play_mi_dong), mActivity.getString(R.string.mission_play_mi_desc), mActivity.getString(R.string.mission_forward), true, R.drawable.icon_mission_item_app_midong, false, u(108), J(108), false, true);
        }
        if (tag == 111) {
            return new MissionItem(111, mActivity.getString(R.string.mission_video_coin_title), mActivity.getString(R.string.mission_video_coin_desc) + "，每天限量" + MiConfigSingleton.V3().L4.r(106) + "次（" + MiConfigSingleton.V3().F4() + "）", mActivity.getString(R.string.mission_video_grab), true, R.drawable.icon_mission_item_video, MiConfigSingleton.V3().Z8(), u(111), J(111), 0, true, true).setBubbleTitle("视频赚金币");
        }
        if (tag == 2008) {
            return new MissionItem(2008, mActivity.getString(R.string.mission_withdraw_title), mActivity.getString(R.string.mission_withdraw_desc), mActivity.getString(R.string.mission_withdraw_button_text), true, R.drawable.icon_mission_item_novice, false, 0, 0, true, true);
        }
        if (tag == 101) {
            return new MissionItem(101, mActivity.getString(R.string.mission_play_xian), mActivity.getString(R.string.mission_play_xian_desc), mActivity.getString(R.string.mission_play_xian_go), true, R.drawable.icon_mission_item_play, false, u(101), J(101), false, true).setBubbleTitle("试玩赚钱");
        }
        if (tag == 102) {
            return new MissionItem(102, mActivity.getString(R.string.mission_play_mi), mActivity.getString(R.string.mission_play_mi_desc), mActivity.getString(R.string.mission_forward), true, R.drawable.icon_mission_item_app, false, u(102), J(102), false, true);
        }
        switch (tag) {
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                if (MiConfigSingleton.V3().V4 && MiConfigSingleton.V3().g0() < 50) {
                    break;
                } else {
                    break;
                }
            case 11:
                break;
            default:
                switch (tag) {
                    case 200:
                        break;
                    case 201:
                        break;
                    case 202:
                        break;
                    default:
                        switch (tag) {
                        }
                }
        }
        return null;
    }

    public void H0(final j1 mActivity, final r listener) {
        if (MiConfigSingleton.V3().x5()) {
            new o(mActivity, mActivity, listener).j();
        }
    }

    public String I(int type) {
        return "ttbook_mission_" + type;
    }

    public int J(int type) {
        MissionBonusList missionBonusList = this.f11523e;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return y(type);
        }
        for (MissionItem missionItem : this.f11523e.getBonusList()) {
            if (missionItem.getType() == type) {
                return missionItem.getMoney();
            }
        }
        return y(type);
    }

    public void J0(j1 activity, com.martian.libmars.b.d rxManager) {
        if (MiConfigSingleton.V3().u5()) {
            return;
        }
        new a(activity, rxManager).j();
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View K(Activity activity, final MissionItem item, ViewGroup container, boolean isUpdate, final s listener) {
        View inflate;
        if (activity == null) {
            return null;
        }
        if (isUpdate) {
            inflate = container.findViewWithTag(Integer.valueOf(item.getType()));
        } else {
            inflate = activity.getLayoutInflater().inflate(R.layout.mission_item, (ViewGroup) null);
            inflate.setTag(Integer.valueOf(item.getType()));
        }
        if (inflate == null) {
            return null;
        }
        boolean I0 = MiConfigSingleton.V3().I0();
        i4 a2 = i4.a(inflate);
        a2.f12123h.setVisibility(8);
        if (com.martian.libsupport.k.p(item.getIcon())) {
            a2.f12122g.setVisibility(8);
        } else {
            a2.f12122g.setVisibility(0);
            String icon = item.getIcon();
            ImageView imageView = a2.f12122g;
            int i2 = item.iconRes;
            com.martian.libmars.utils.n0.f(activity, icon, imageView, i2, i2);
        }
        a2.f12118c.setVisibility(0);
        int money = item.getMoney();
        int i3 = R.drawable.border_mission_button_night;
        if (money > 0) {
            a2.f12117b.setImageResource(R.drawable.icon_mission_money);
            a2.f12118c.setBackgroundResource(I0 ? R.drawable.border_mission_money_night : R.drawable.border_mission_money);
            a2.f12121f.setTextColor(ContextCompat.getColor(activity, R.color.bonus_red));
            a2.f12121f.setText("+" + com.martian.rpauth.d.i.m(Integer.valueOf(item.getMoney())) + "元");
        } else if (item.getCoins() > 0) {
            a2.f12117b.setImageResource(R.drawable.icon_mission_coins);
            a2.f12118c.setBackgroundResource(I0 ? R.drawable.border_mission_coins_night : R.drawable.border_mission_coins);
            a2.f12121f.setTextColor(ContextCompat.getColor(activity, R.color.material_orange_400));
            a2.f12121f.setText("+" + item.getCoins() + activity.getString(R.string.bonus_unit));
        } else if (item.getBookCoins().intValue() > 0) {
            a2.f12117b.setImageResource(R.drawable.icon_mission_bookcoins);
            a2.f12118c.setBackgroundResource(I0 ? R.drawable.border_mission_button_night : R.drawable.border_mission_button);
            a2.f12121f.setTextColor(ContextCompat.getColor(activity, R.color.theme_default));
            a2.f12121f.setText("+" + item.getBookCoins() + "淘书币");
        } else {
            a2.f12118c.setVisibility(8);
        }
        a2.f12124i.setText(item.getTitle());
        a2.f12119d.setBackgroundResource(I0 ? R.drawable.border_mission_button_night : R.drawable.border_mission_button);
        IntervalCountdownTextView intervalCountdownTextView = a2.f12123h;
        if (!I0) {
            i3 = R.drawable.border_mission_button;
        }
        intervalCountdownTextView.setBackgroundResource(i3);
        if (item.getFinished()) {
            a2.f12119d.setAlpha(0.5f);
            a2.f12119d.setSelectable(false);
            a2.f12119d.setText(activity.getString(R.string.mission_finished));
        } else {
            a2.f12119d.setAlpha(1.0f);
            if (!com.martian.libsupport.k.p(item.getBonusString())) {
                a2.f12119d.setText(item.getBonusString());
            }
            if (com.martian.libsupport.k.p(item.getButtonText())) {
                a2.f12119d.setText("领福利");
            } else {
                a2.f12119d.setText(item.getButtonText());
            }
            if (item.getType() == 0) {
                a2.f12120e.setText(activity.getString(R.string.mission_novel_desc));
                a2.f12119d.setText(activity.getString(R.string.mission_forward));
            } else if (item.getType() == 106 || item.getType() == 111) {
                I0(a2.f12119d, a2.f12123h);
            }
        }
        a2.f12120e.setText(item.getDesc());
        if (listener != null) {
            a2.f12125j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.application.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0.s.this.a(item);
                }
            });
            a2.f12119d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.application.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0.s.this.a(item);
                }
            });
        }
        return inflate;
    }

    public void K0(j1 mActivity, com.martian.libmars.b.d rxManager) {
        if (MiConfigSingleton.V3().l3().X2(mActivity)) {
            this.m = System.currentTimeMillis();
        } else {
            this.n = true;
            r0(mActivity, rxManager, true);
        }
    }

    public void M0(Activity mActivity) {
        if (this.p || !g0()) {
            return;
        }
        D0(mActivity);
    }

    public void N(j1 mActivity, p listener) {
        if (this.t.isEmpty()) {
            p(mActivity, listener);
            return;
        }
        if (this.u >= this.t.size()) {
            this.u = 0;
        }
        MissionItem missionItem = this.t.get(this.u);
        if (missionItem.getType() == 100027 || (missionItem.getType() == 13 && MiConfigSingleton.V3().i5())) {
            this.t.remove(this.u);
            N(mActivity, listener);
            return;
        }
        if ((missionItem.getType() == 106 || missionItem.getType() == 111) && MiConfigSingleton.V3().w2()) {
            if (this.t.size() > 1) {
                this.u++;
                N(mActivity, listener);
                return;
            }
            return;
        }
        this.u++;
        if (listener != null) {
            listener.b(missionItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N0(j1 mActivity) {
        d dVar = new d(CheckinNotifyParams.class, Boolean.class, mActivity);
        ((CheckinNotifyParams) dVar.k()).setEnable(Boolean.valueOf(MiConfigSingleton.V3().D2()));
        dVar.j();
    }

    public UrlMission O() {
        if (this.f11525g == null) {
            try {
                String B = com.martian.libsupport.e.B(this.f11524f, f11519a);
                if (!TextUtils.isEmpty(B)) {
                    this.f11525g = (UrlMission) GsonUtils.b().fromJson(B, UrlMission.class);
                }
            } catch (IOException unused) {
            }
        }
        return this.f11525g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(j1 activity, int position, final u listener) {
        if (MiConfigSingleton.V3().z5(true)) {
            listener.a(null);
            return;
        }
        h hVar = new h(activity, listener);
        ((UrlMissionParams) hVar.k()).setRandom(Boolean.TRUE);
        ((UrlMissionParams) hVar.k()).setPosition(Integer.valueOf(position));
        hVar.j();
    }

    public void R(j1 mActivity) {
        if ((mActivity instanceof EnterRestartActivity) || !MiConfigSingleton.V3().x5() || MiConfigSingleton.V3().j5()) {
            return;
        }
        j jVar = new j(MartianGetXianwanGamesParams.class, XianWanGameChannel.class, mActivity);
        jVar.n();
        jVar.j();
    }

    public List<XianWanGame> S() {
        if (this.f11528j == null) {
            this.f11528j = new ArrayList();
        }
        return this.f11528j;
    }

    public MissionItem T() {
        XianWanGame xianWanGame;
        List<XianWanGame> S = S();
        Collections.shuffle(S);
        if (S.size() <= 0 || (xianWanGame = S.get(0)) == null || com.martian.libsupport.k.p(xianWanGame.getUrl())) {
            return null;
        }
        return new MissionItem(110, xianWanGame.getGameName(), "试玩赚取大额佣金，提现秒到", "去试玩", true, R.drawable.icon_mission_item_play, false, 0, xianWanGame.getMoney().intValue(), true, true).setUrl(xianWanGame.getUrl()).setIcon(xianWanGame.getIcon());
    }

    public MissionItem U(XianWanGame xianWanGame) {
        if (xianWanGame == null || com.martian.libsupport.k.p(xianWanGame.getUrl())) {
            return null;
        }
        return new MissionItem(110, xianWanGame.getGameName(), "试玩赚取大额佣金，提现秒到", "去试玩", true, R.drawable.icon_mission_item_play, false, 0, xianWanGame.getMoney().intValue(), true, true).setUrl(xianWanGame.getUrl()).setIcon(xianWanGame.getIcon());
    }

    public boolean V(j1 activity, final com.martian.libmars.b.d rxManager, boolean manual, final r listener) {
        if (MiConfigSingleton.V3().x5() && !MiConfigSingleton.V3().A5()) {
            MiTaskAccount x4 = MiConfigSingleton.V3().x4();
            if (x4 != null && x4.getFreshRedpaper() > 0) {
                com.martian.mibook.lib.model.g.b.N(activity, "新手红包-领取-请求");
                new c(activity, manual, activity, rxManager, listener).j();
                return true;
            }
            if (manual) {
                activity.k1("领取失败");
            }
        }
        return false;
    }

    public void W(j1 mActivity, TYActivity tyActivity, com.martian.libmars.b.d rxManager, String position) {
        com.martian.mibook.lib.model.g.b.m(mActivity, position + "-" + tyActivity.getTitle() + "-点击");
        if (tyActivity.getActivityId() == -1) {
            s2.o(mActivity);
            return;
        }
        if (!com.martian.libsupport.k.p(tyActivity.getDeeplink())) {
            if (com.martian.apptask.g.g.b(mActivity, tyActivity.getDeeplink())) {
                com.martian.apptask.g.g.u(mActivity, tyActivity.getDeeplink(), "", "", true);
                return;
            } else {
                if (com.martian.libsupport.k.p(tyActivity.getActivityUrl())) {
                    return;
                }
                MiWebViewActivity.i5(mActivity, tyActivity.getActivityUrl(), false, tyActivity.getShareUrl(), tyActivity.getShareable(), tyActivity.getShareImageUrl(), tyActivity.getFullscreen().booleanValue());
                return;
            }
        }
        if (!com.martian.libsupport.k.p(tyActivity.getActivityUrl())) {
            MiWebViewActivity.i5(mActivity, tyActivity.getActivityUrl(), false, tyActivity.getShareUrl(), tyActivity.getShareable(), tyActivity.getShareImageUrl(), tyActivity.getFullscreen().booleanValue());
        } else {
            if (com.martian.libsupport.k.p(tyActivity.getDialogImage())) {
                return;
            }
            v2.I0(mActivity, tyActivity, rxManager, position + "弹窗", null);
        }
    }

    public void X(final j1 mActivity, int type) {
        if (type == 0) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "看小说");
            return;
        }
        if (type == 1) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "邀请好友");
            s2.o(mActivity);
            return;
        }
        if (type == 2) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "晒收入");
            if (MiConfigSingleton.V3().n2(mActivity)) {
                ShareImageUrlActivity.n(mActivity, 2);
                return;
            }
            return;
        }
        if (type == 3) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "绑定邀请码");
            mActivity.startActivityForResult(BindInviterActivity.class, 3);
            return;
        }
        if (type == 4) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "新手红包");
            return;
        }
        if (type == 101) {
            q0(mActivity);
            return;
        }
        if (type == 102) {
            com.martian.mibook.lib.model.g.b.L(mActivity, "米墙");
            return;
        }
        if (type != 106) {
            if (type == 108) {
                com.martian.mibook.lib.model.g.b.L(mActivity, "简单应用任务");
                return;
            }
            if (type != 111) {
                if (type == 2008) {
                    com.martian.mibook.lib.model.g.b.L(mActivity, "0.3元提现");
                    if (MiConfigSingleton.V3().l2(mActivity, 1023)) {
                        s2.e0(mActivity, "赚钱=新手任务", MartianRPUserManager.f14923j);
                        return;
                    }
                    return;
                }
                switch (type) {
                    case 7:
                        com.martian.mibook.lib.model.g.b.L(mActivity, "首次收徒");
                        s2.s0(mActivity, mActivity.getString(R.string.invite_link), "", false, mActivity.getString(R.string.invite_share_link));
                        break;
                    case 8:
                        com.martian.mibook.lib.model.g.b.L(mActivity, "绑定手机号");
                        if (!f0()) {
                            PhoneLoginActivity.j3(mActivity, 1, "", 20003);
                            break;
                        } else {
                            mActivity.k1("您已绑定手机号");
                            break;
                        }
                    case 9:
                        com.martian.mibook.lib.model.g.b.L(mActivity, "发表评论");
                        break;
                    case 10:
                        com.martian.mibook.lib.model.g.b.L(mActivity, "五星好评");
                        if (MiConfigSingleton.V3().l2(mActivity, 1013)) {
                            org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
                            org.codechimp.apprater.b.g(mActivity);
                            break;
                        }
                        break;
                    case 11:
                        com.martian.mibook.lib.model.g.b.L(mActivity, "广告");
                        break;
                    default:
                        switch (type) {
                            case 200:
                                com.martian.mibook.lib.model.g.b.L(mActivity, "红包头条");
                                MiWebViewActivity.g5(mActivity, "http://news.fhbtt.com/hbnews/poster.html", false);
                                break;
                            case 201:
                                com.martian.mibook.lib.model.g.b.L(mActivity, "Q玩任务");
                                if (MiConfigSingleton.V3().h4() != 2 || !com.martian.apptask.g.g.g(mActivity, "com.martian.qplay")) {
                                    mActivity.startActivity(AppwallTaskDetailActivity.class);
                                    break;
                                } else {
                                    com.martian.apptask.g.g.s(mActivity, "com.martian.qplay");
                                    break;
                                }
                                break;
                            case 202:
                                com.martian.mibook.lib.model.g.b.L(mActivity, "大转盘");
                                MiWebViewActivity.f5(mActivity, new MartianLuckyDrawParams().toHttpUrl("UTF8"));
                                break;
                        }
                }
                return;
            }
        }
        E0(mActivity, null);
    }

    public void Y(final j1 mActivity, MissionItem item) {
        if (item == null || mActivity == null) {
            return;
        }
        MiConfigSingleton.V3().L4.Z(item);
        if (item.getType() == 110) {
            if (com.martian.libsupport.k.p(item.getRecommend())) {
                com.martian.mibook.lib.model.g.b.n0(mActivity, "赚钱-游戏-点击");
            } else {
                com.martian.mibook.lib.model.g.b.n0(mActivity, item.getRecommend() + "-游戏-点击");
            }
            MiWebViewActivity.f5(mActivity, item.getUrl() + "&xwgame=true");
        } else if (item.getType() >= 100000) {
            if (!com.martian.libsupport.k.p(item.getDeeplink()) && com.martian.apptask.g.g.b(mActivity, item.getDeeplink())) {
                com.martian.apptask.g.g.u(mActivity, item.getDeeplink(), "", "", true);
                return;
            } else {
                if (com.martian.libsupport.k.p(item.getUrl())) {
                    return;
                }
                s2.s0(mActivity, item.getUrl(), item.getUrl(), false, null);
                return;
            }
        }
        X(mActivity, item.getType());
    }

    public void Z(MissionItem item) {
        if (item == null) {
            return;
        }
        MiConfigSingleton.V3().E7(I(item.getType()), item.getClickType() == 2);
    }

    public void a0(List<MissionItem> missionItems) {
        this.q.clear();
        for (MissionItem missionItem : missionItems) {
            if (missionItem.getBubbleCoins() != null && missionItem.getBubbleCoins().intValue() > 0 && !com.martian.libsupport.k.p(missionItem.getBubbleTitle()) && !MiConfigSingleton.V3().q2(I(missionItem.getType())) && (101 != missionItem.getType() || !MiConfigSingleton.V3().j5())) {
                this.q.add(missionItem);
            }
        }
    }

    public boolean b0() {
        return System.currentTimeMillis() - this.m <= ((long) (com.martian.libmars.d.h.F().J0() ? BaseConstants.Time.MINUTE : 180000));
    }

    public boolean c0() {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        return x4 != null && x4.getValidInviteeNum() > 0;
    }

    public boolean d0() {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        return x4 != null && x4.getFiveStar();
    }

    public boolean e0() {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        return x4 != null && x4.getFreshRedpaper() <= 0;
    }

    public boolean f0() {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        return x4 != null && x4.getPhoneBound();
    }

    public boolean g0() {
        return this.o && !MiConfigSingleton.V3().j5();
    }

    public void k(Activity activity, MissionSection missionSection, ViewGroup container, s listener) {
        d2 d2 = d2.d(activity.getLayoutInflater(), null, false);
        container.addView(d2.getRoot());
        d2.f11835b.addView(o0(activity.getLayoutInflater(), missionSection.getTitle(), activity.getString(R.string.txs_commission_mission).equals(missionSection.getTitle())));
        Iterator<MissionItem> it = missionSection.getMissionItems().iterator();
        while (it.hasNext()) {
            d2.f11835b.addView(K(activity, it.next(), container, false, listener));
        }
        View view = new View(activity);
        view.setMinimumHeight(com.martian.libmars.d.h.b(12.0f));
        container.addView(view);
    }

    public void l(j1 activity, List<MissionItem> missionItems) {
        MissionBonusList missionBonusList = this.f11523e;
        if (missionBonusList == null || missionBonusList.getBonusList() == null || MiConfigSingleton.V3().j5()) {
            return;
        }
        for (MissionItem missionItem : this.f11523e.getBonusList()) {
            if (missionItem.getType() >= 100000 && !com.martian.libsupport.k.p(missionItem.getTitle()) && !com.martian.libsupport.k.p(missionItem.getUrl())) {
                missionItems.add(new MissionItem(missionItem.getType(), missionItem.getTitle(), missionItem.getIntro(), L(activity), true, R.drawable.icon_mission_item_novice, false, missionItem.getCoins(), missionItem.getMoney(), missionItem.getAuthShow(), missionItem.getIcon(), missionItem.getUrl()));
            }
        }
    }

    public void m() {
        new g().j();
    }

    public boolean n(int type) {
        return (type >= 0 && type <= 17) || (type >= 101 && type <= 111) || type == 300 || type >= 100000;
    }

    public void n0() {
        try {
            String B = com.martian.libsupport.e.B(this.f11524f, f11520b);
            if (TextUtils.isEmpty(B)) {
                return;
            }
            this.f11523e = (MissionBonusList) GsonUtils.b().fromJson(B, MissionBonusList.class);
        } catch (IOException unused) {
            this.f11523e = new MissionBonusList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(j1 mActivity, p listener) {
        if (!MiConfigSingleton.V3().A5() && this.r.isEmpty() && !(mActivity instanceof EnterRestartActivity) && MiConfigSingleton.V3().g0() > 1) {
            if (this.s <= 0 || System.currentTimeMillis() - this.s >= 1000) {
                this.s = System.currentTimeMillis();
                e eVar = new e(BookrackMissionsParams.class, MissionItem.class, mActivity, listener, mActivity);
                ((BookrackMissionsParams) eVar.k()).setType(Integer.valueOf(BookrackMissionsParams.BOOKRACK_MISSION_LEFT));
                ((BookrackMissionsParams) eVar.k()).setCtype(Integer.valueOf(MiConfigSingleton.V3().k()));
                eVar.j();
            }
        }
    }

    public View o0(LayoutInflater inflater, String title, boolean showTitleIcon) {
        if (com.martian.libsupport.k.p(title)) {
            return null;
        }
        j4 d2 = j4.d(inflater, null, false);
        d2.f12185b.setText(title);
        if (showTitleIcon) {
            d2.f12186c.setVisibility(0);
        }
        return d2.getRoot();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(j1 activity, String extra, String vendor, String bonus, boolean verified, int videoType, t listener) {
        String str;
        if (!verified) {
            p0(activity, bonus, false, videoType, listener);
            return;
        }
        n nVar = new n(MartianFinishRewardVideoParams.class, Boolean.class, activity, activity, bonus, videoType, listener);
        ((MartianFinishRewardVideoParams) nVar.k()).setExtra(extra);
        try {
            str = com.martian.libsupport.b.a(extra + "_" + vendor + "_" + System.currentTimeMillis(), "a1ba6ec3f4c28dce");
        } catch (Exception unused) {
            str = "";
        }
        ((MartianFinishRewardVideoParams) nVar.k()).setC(str);
        ((MartianFinishRewardVideoParams) nVar.k()).setVendor(vendor);
        nVar.j();
    }

    public void q0(j1 activity) {
        com.martian.mibook.lib.model.g.b.n0(activity, "赚钱-主页-点击");
        if (MiConfigSingleton.V3().l2(activity, 1015)) {
            MartianPlayxianAppwallParams martianPlayxianAppwallParams = new MartianPlayxianAppwallParams();
            martianPlayxianAppwallParams.setUid(Long.valueOf(Long.parseLong(MiConfigSingleton.V3().D4())));
            martianPlayxianAppwallParams.setToken(MiConfigSingleton.V3().C4().getToken());
            martianPlayxianAppwallParams.setImei(com.martian.libmars.d.h.F().z());
            martianPlayxianAppwallParams.setOaid(com.martian.libmars.d.h.F().V());
            martianPlayxianAppwallParams.setDevice_id(com.martian.libmars.d.h.F().t());
            MiWebViewActivity.f5(activity, martianPlayxianAppwallParams.toHttpUrl("UTF8"));
        }
    }

    public int r(int type) {
        MissionBonusList missionBonusList = this.f11523e;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return v(type);
        }
        for (MissionItem missionItem : this.f11523e.getBonusList()) {
            if (missionItem.getType() == type) {
                if (missionItem.getBonusCount() == null) {
                    return 0;
                }
                return missionItem.getBonusCount().intValue();
            }
        }
        return v(type);
    }

    public void r0(j1 activity, com.martian.libmars.b.d rxManager, boolean inFirstTab) {
        if (!this.n || MiConfigSingleton.V3().A5() || b0()) {
            return;
        }
        if (V(activity, rxManager, false, null)) {
            this.m = System.currentTimeMillis();
            return;
        }
        if (G0(activity)) {
            this.m = System.currentTimeMillis();
            return;
        }
        if (L0(activity)) {
            return;
        }
        for (TYActivity tYActivity : this.k) {
            if (MiConfigSingleton.V3().g0() >= tYActivity.getRuntimes().intValue() && (!inFirstTab || tYActivity.getShowOnStart())) {
                if (tYActivity.getStarted() && !tYActivity.isInterAdActivity()) {
                    long activityId = tYActivity.getActivityId();
                    if (!com.martian.libsupport.k.p(tYActivity.getDialogImage()) && activityId > 0) {
                        String str = "" + activityId;
                        String b0 = MiConfigSingleton.V3().b0("mission_activity_ids");
                        if (com.martian.libsupport.k.p(b0) || !b0.contains(str)) {
                            if (!com.martian.libsupport.k.p(b0)) {
                                str = b0 + "," + str;
                            }
                            if (str.length() > 84) {
                                str = str.substring(42);
                            }
                            MiConfigSingleton.V3().y1("mission_activity_ids", str);
                            this.m = System.currentTimeMillis();
                            v2.H0(activity, tYActivity, rxManager);
                            return;
                        }
                    }
                }
            }
        }
    }

    public TYActivity s() {
        if (this.k.isEmpty()) {
            return null;
        }
        if (this.l == null) {
            this.l = new ArrayList();
            for (TYActivity tYActivity : this.k) {
                if (!com.martian.libsupport.k.p(tYActivity.getBubbleImage())) {
                    this.l.add(tYActivity);
                }
            }
        }
        if (this.l.isEmpty()) {
            return null;
        }
        return this.l.get(new Random().nextInt(this.l.size()));
    }

    public void s0() {
        this.m = -1L;
        this.p = false;
        z0(false);
    }

    public MissionItem t() {
        if (this.q.isEmpty()) {
            return null;
        }
        return this.q.remove(0);
    }

    public void t0(String json) {
        try {
            com.martian.libsupport.e.E(this.f11524f, f11520b, json);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int u(int type) {
        MissionBonusList missionBonusList = this.f11523e;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return x(type);
        }
        for (MissionItem missionItem : this.f11523e.getBonusList()) {
            if (missionItem.getType() == type) {
                return missionItem.getCoins();
            }
        }
        return x(type);
    }

    public void u0() {
        MiConfigSingleton.V3().d8(this.u);
    }

    public int v(int type) {
        return (type == 106 || type == 111) ? 8 : 0;
    }

    public void v0() {
        this.n = true;
    }

    public int w(int type) {
        return type == 106 ? 100 : 0;
    }

    public synchronized void w0(MissionBonusList missionSections) {
        this.f11523e = missionSections;
    }

    public int x(int type) {
        if (type == 0) {
            return 1000000;
        }
        if (type == 103) {
            return 20;
        }
        if (type == 106 || type == 111) {
            return 60;
        }
        if (type == 2) {
            return 10;
        }
        if (type == 3) {
            return 20;
        }
        if (type == 5) {
            return 100;
        }
        if (type == 6) {
            return 20;
        }
        if (type == 201 || type == 202) {
            return 10000;
        }
        switch (type) {
            case 8:
                return 20;
            case 9:
                return 100;
            case 10:
                return 50;
            case 11:
                return 10000;
            default:
                return 0;
        }
    }

    public void x0(UrlMissionResult urlMissionResult) {
        if (urlMissionResult.getNextMission() != null) {
            A0(urlMissionResult.getNextMission());
            return;
        }
        UrlMission O = MiConfigSingleton.V3().L4.O();
        if (O != null) {
            O.setLeftCount(0);
            A0(O);
        }
    }

    public int y(int type) {
        if (type == 1) {
            return 3200;
        }
        if (type == 4) {
            return 1800;
        }
        if (type == 7) {
            return 400;
        }
        if (type == 108 || type == 200) {
            return 10000;
        }
        if (type != 101) {
            return type != 102 ? 0 : 1000;
        }
        return 1000000;
    }

    public void y0() {
        this.m = System.currentTimeMillis();
    }

    public void z0(boolean showInterAd) {
        this.o = showInterAd;
    }
}
