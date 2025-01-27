package com.martian.mibook.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.JsonSyntaxException;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.appwall.request.MartianLuckyDrawParams;
import com.martian.appwall.request.auth.MartianFinishRewardVideoParams;
import com.martian.appwall.request.auth.MartianGetXianwanGamesParams;
import com.martian.appwall.request.auth.MartianPlayxianAppwallParams;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.activity.account.BindInviterActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.application.c;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.data.XianWanGameChannel;
import com.martian.mibook.databinding.CardViewLayoutBinding;
import com.martian.mibook.databinding.ItemMissionTaskBinding;
import com.martian.mibook.databinding.MissionSectionTitleBinding;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.request.auth.CheckinNotifyParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionBonusList;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.ShowWealthResult;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.account.response.TYActivityList;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import je.v0;
import kb.a0;
import kb.p;
import kb.v;
import l9.m0;
import l9.t0;
import lb.c;
import ya.e0;
import ya.j2;

/* loaded from: classes3.dex */
public class c {
    public static final int A = 9;
    public static final int B = 10;
    public static final int C = 11;
    public static final int D = 13;
    public static final int E = 17;
    public static final int F = 2000;
    public static final int G = 2001;
    public static final int H = 2002;
    public static final int I = 2008;
    public static final int J = 101;
    public static final int K = 102;
    public static final int L = 103;
    public static final int M = 106;
    public static final int N = 108;
    public static final int O = 110;
    public static final int P = 111;
    public static final int Q = 200;
    public static final int R = 202;
    public static final int S = 100000;
    public static final String T = "mimission_json_file";
    public static final int U = 2;
    public static final String V = "LAST_AUTHOR_VIDEO_SHOW_TIME";
    public static final String W = "MISSION_ITEM_WATCH_VIDEO";
    public static final String X = "ttbook_pref_qplay_mission_status";
    public static final String Y = "VIDEO_ADS_COUNT_TTBOOK";
    public static final String Z = "VIDEO_ADS_TIME_TTBOOK";

    /* renamed from: a0 */
    public static final String f13512a0 = "PREF_SHOW_WEALTH_STATUS";

    /* renamed from: q */
    public static final int f13513q = -1;

    /* renamed from: r */
    public static final int f13514r = 0;

    /* renamed from: s */
    public static final int f13515s = 1;

    /* renamed from: t */
    public static final int f13516t = 2;

    /* renamed from: u */
    public static final int f13517u = 3;

    /* renamed from: v */
    public static final int f13518v = 4;

    /* renamed from: w */
    public static final int f13519w = 5;

    /* renamed from: x */
    public static final int f13520x = 6;

    /* renamed from: y */
    public static final int f13521y = 7;

    /* renamed from: z */
    public static final int f13522z = 8;

    /* renamed from: a */
    public MissionBonusList f13523a;

    /* renamed from: b */
    public final Context f13524b;

    /* renamed from: c */
    public List<XianWanGame> f13525c;

    /* renamed from: e */
    public List<TYActivity> f13527e;

    /* renamed from: n */
    public long f13536n;

    /* renamed from: d */
    public List<TYActivity> f13526d = new ArrayList();

    /* renamed from: f */
    public long f13528f = -1;

    /* renamed from: g */
    public boolean f13529g = false;

    /* renamed from: h */
    public boolean f13530h = false;

    /* renamed from: i */
    public boolean f13531i = false;

    /* renamed from: j */
    public final List<MissionItem> f13532j = new ArrayList();

    /* renamed from: k */
    public long f13533k = -1;

    /* renamed from: l */
    public long f13534l = -1;

    /* renamed from: m */
    public long f13535m = -1;

    /* renamed from: o */
    public int f13537o = -1;

    /* renamed from: p */
    public final List<AppTask> f13538p = new LinkedList();

    public class a extends d8.b {
        public a() {
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            c.this.u0();
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
        }
    }

    public class e extends m8.b<MartianGetXianwanGamesParams, XianWanGameChannel> {
        public e(Class cls, Class cls2, Activity activity) {
            super(cls, cls2, activity);
        }

        @Override // m8.b, y8.a
        public void onResultError(x8.c cVar) {
            super.onResultError(cVar);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<XianWanGameChannel> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            for (XianWanGameChannel xianWanGameChannel : list) {
                if (xianWanGameChannel.getMcid().intValue() == 10001) {
                    c.this.f13525c = xianWanGameChannel.getGameList();
                    return;
                }
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class f extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f13549a;

        /* renamed from: b */
        public final /* synthetic */ boolean f13550b;

        /* renamed from: c */
        public final /* synthetic */ o f13551c;

        public f(FragmentActivity fragmentActivity, boolean z10, o oVar) {
            this.f13549a = fragmentActivity;
            this.f13550b = z10;
            this.f13551c = oVar;
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            c.this.p0(this.f13549a, this.f13550b ? e0.f33155i0 : e0.f33157j0, false, 0, this.f13551c);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            c cVar = c.this;
            FragmentActivity fragmentActivity = this.f13549a;
            boolean z11 = this.f13550b;
            cVar.q(fragmentActivity, z11 ? e0.f33159k0 : e0.f33161l0, "android", z11 ? e0.f33155i0 : e0.f33157j0, z10, 0, this.f13551c);
        }
    }

    public class g extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f13553a;

        /* renamed from: b */
        public final /* synthetic */ o f13554b;

        public g(FragmentActivity fragmentActivity, o oVar) {
            this.f13553a = fragmentActivity;
            this.f13554b = oVar;
        }

        @Override // d8.b, d8.a
        public void a() {
            super.a();
            c.this.p0(this.f13553a, e0.f33153h0, false, 2, this.f13554b);
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            c.this.p0(this.f13553a, e0.f33153h0, false, 2, this.f13554b);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            c.this.q(this.f13553a, e0.N, adConfig == null ? "android" : adConfig.getSource(), e0.f33153h0, z10, 2, this.f13554b);
        }
    }

    public class h extends jb.e<MartianFinishRewardVideoParams, Boolean> {

        /* renamed from: h */
        public final /* synthetic */ FragmentActivity f13556h;

        /* renamed from: i */
        public final /* synthetic */ String f13557i;

        /* renamed from: j */
        public final /* synthetic */ int f13558j;

        /* renamed from: k */
        public final /* synthetic */ o f13559k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Class cls, Class cls2, Context context, FragmentActivity fragmentActivity, String str, int i10, o oVar) {
            super(cls, cls2, context);
            this.f13556h = fragmentActivity;
            this.f13557i = str;
            this.f13558j = i10;
            this.f13559k = oVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            c.this.p0(this.f13556h, this.f13557i, true, this.f13558j, this.f13559k);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Boolean> list) {
            c.this.p0(this.f13556h, this.f13557i, true, this.f13558j, this.f13559k);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class i implements c.i {

        /* renamed from: a */
        public final /* synthetic */ o f13561a;

        public i(o oVar) {
            this.f13561a = oVar;
        }

        @Override // lb.c.i
        public void a(x8.c cVar) {
            o oVar = this.f13561a;
            if (oVar != null) {
                oVar.a();
            }
        }

        @Override // lb.c.i
        public void b(MartianRPAccount martianRPAccount) {
            o oVar = this.f13561a;
            if (oVar != null) {
                oVar.a();
            }
        }
    }

    public class j extends a0 {

        /* renamed from: k */
        public final /* synthetic */ FragmentActivity f13563k;

        /* renamed from: l */
        public final /* synthetic */ m f13564l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Activity activity, FragmentActivity fragmentActivity, m mVar) {
            super(activity);
            this.f13563k = fragmentActivity;
            this.f13564l = mVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            t0.b(this.f13563k, cVar.d());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ShowWealthResult showWealthResult) {
            if (showWealthResult == null || showWealthResult.getCoins().intValue() <= 0) {
                return;
            }
            c.this.F0();
            MiConfigSingleton.b2().u2().S(this.f13563k, "晒收入", 0, showWealthResult.getCoins().intValue());
            m mVar = this.f13564l;
            if (mVar != null) {
                mVar.a();
            }
        }
    }

    public class l implements ReadingInstance.d {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f13569a;

        /* renamed from: b */
        public final /* synthetic */ e9.c f13570b;

        /* renamed from: c */
        public final /* synthetic */ boolean f13571c;

        public l(FragmentActivity fragmentActivity, e9.c cVar, boolean z10) {
            this.f13569a = fragmentActivity;
            this.f13570b = cVar;
            this.f13571c = z10;
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void a() {
            c.this.u0();
            c.this.r0(this.f13569a, this.f13570b, this.f13571c);
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void onAdExposed() {
        }
    }

    public interface m {
        void a();
    }

    public interface n {
        void a(MissionItem missionItem);
    }

    public interface o {
        void a();
    }

    public c(Context context) {
        this.f13524b = context;
        n0();
    }

    public int A(int i10) {
        if (i10 == 1) {
            return 3200;
        }
        if (i10 == 4) {
            return 1800;
        }
        if (i10 == 7) {
            return 400;
        }
        if (i10 != 101) {
            return i10 != 102 ? 0 : 1000;
        }
        return 1000000;
    }

    public synchronized void A0(MissionBonusList missionBonusList) {
        this.f13523a = missionBonusList;
    }

    public final String B() {
        return "首次邀请好友可获得" + oe.f.n(Integer.valueOf(G(7))) + "元现金奖励和20%收益提成";
    }

    public void B0() {
        if (ConfigSingleton.D().B0()) {
            ba.j.n(this.f13524b, W, MartianRPUserManager.a() + 30000);
            z0();
        } else {
            ba.j.n(this.f13524b, W, MartianRPUserManager.a() + (MiConfigSingleton.b2().c2().getVideoMissionInterval().intValue() * 60 * 1000));
            z0();
        }
    }

    public long C() {
        return this.f13535m;
    }

    public void C0() {
        this.f13528f = System.currentTimeMillis();
    }

    public final String D() {
        return "每收1名徒弟即可获得" + oe.f.n(Integer.valueOf(G(1))) + "元现金奖励,徒弟看小说还会向您进贡20%金币,首次收徒送" + oe.f.n(Integer.valueOf(G(7))) + "元现金";
    }

    public void D0(int i10) {
        ba.j.m(this.f13524b, X, i10);
    }

    public MissionItem E(Context context, int i10) {
        if (context == null) {
            return null;
        }
        if (i10 == 0) {
            return new MissionItem(0, context.getString(R.string.mission_novel), context.getString(R.string.mission_novel_desc), context.getString(R.string.mission_novel_go), true, R.drawable.icon_mission_item_fiction_book, false, w(0), G(0), false, false).setBubbleTitle("看小说赚钱");
        }
        if (i10 == 1) {
            return new MissionItem(1, context.getString(R.string.mission_invite_friends), D(), context.getString(R.string.mission_invite_go), true, R.drawable.icon_mission_item_invite, false, w(1), G(1), false, false).setBubbleTitle(context.getString(R.string.mission_invite_friends));
        }
        if (i10 == 2) {
            return new MissionItem(2, context.getString(R.string.mission_show_wealth), context.getString(R.string.mission_show_wealth_desc), context.getString(R.string.mission_show_wealth_go), true, R.drawable.icon_mission_item_praise, i0(), w(2), G(2), false, false).setBubbleTitle(context.getString(R.string.mission_show_wealth));
        }
        if (i10 == 3) {
            return new MissionItem(3, context.getString(R.string.mission_bind_inviter), context.getString(R.string.mission_bind_inviter_desc), context.getString(R.string.mission_bind_inviter_go), true, R.drawable.icon_mission_item_invitation_code, MiConfigSingleton.b2().w2(), w(3), G(3), false, false);
        }
        if (i10 == 4) {
            return new MissionItem(4, context.getString(R.string.mission_fresh_redpaper), context.getString(R.string.mission_fresh_redpaper_desc), context.getString(R.string.mission_fresh_redpaper_grab), true, R.drawable.icon_mission_item_novice, f0(), w(4), G(4), false, false);
        }
        if (i10 == 13) {
            return new MissionItem(13, context.getString(R.string.mission_item_game), context.getString(R.string.mission_item_game_desc), J(context), true, R.drawable.icon_mission_item_qplay, false, w(13), G(13), false, false);
        }
        if (i10 == 106) {
            return new MissionItem(106, context.getString(R.string.mission_video), context.getString(R.string.mission_video_desc) + "，每天限量" + r(106) + "次（" + P() + "）", context.getString(R.string.mission_video_grab), true, R.drawable.icon_mission_item_video, U0(), w(106), G(106), O(), false, false);
        }
        if (i10 == 108) {
            return new MissionItem(108, context.getString(R.string.mission_play_mi_dong), context.getString(R.string.mission_play_mi_desc), context.getString(R.string.mission_forward), true, R.drawable.icon_mission_item_app_midong, false, w(108), G(108), false, true);
        }
        if (i10 == 111) {
            return new MissionItem(111, context.getString(R.string.mission_video_coin_title), context.getString(R.string.mission_video_coin_desc) + "，每天限量" + r(106) + "次（" + P() + "）", context.getString(R.string.mission_video_grab), true, R.drawable.icon_mission_item_video, U0(), w(111), G(111), 0, true, true).setBubbleTitle("视频赚金币");
        }
        if (i10 == 200) {
            String string = context.getString(R.string.mission_hbnews);
            String string2 = context.getString(R.string.mission_hbnews_desc);
            String string3 = context.getString(R.string.mission_hbnews_forward);
            int i11 = R.drawable.icon_mission_item_novice;
            return new MissionItem(200, string, string2, string3, true, i11, i11, false, w(200), G(200), false, false);
        }
        if (i10 == 202) {
            return new MissionItem(202, context.getString(R.string.mission_lucky_draw_title), context.getString(R.string.mission_lucky_draw_desc), context.getString(R.string.bonus_draw), true, R.drawable.icon_mission_item_praise, false, z(202), A(202), false, true);
        }
        if (i10 == 2008) {
            return new MissionItem(2008, context.getString(R.string.mission_withdraw_title), context.getString(R.string.mission_withdraw_desc), context.getString(R.string.mission_withdraw_button_text), true, R.drawable.icon_mission_item_novice, false, 0, 0, true, true);
        }
        if (i10 == 101) {
            return new MissionItem(101, context.getString(R.string.mission_play_xian), context.getString(R.string.mission_play_xian_desc), context.getString(R.string.mission_play_xian_go), true, R.drawable.icon_mission_item_play, false, w(101), G(101), false, true).setBubbleTitle("试玩赚钱");
        }
        if (i10 == 102) {
            return new MissionItem(102, context.getString(R.string.mission_play_mi), context.getString(R.string.mission_play_mi_desc), context.getString(R.string.mission_forward), true, R.drawable.icon_mission_item_app, false, w(102), G(102), false, true);
        }
        switch (i10) {
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                String string4 = context.getString(R.string.mission_click_ads);
                String string5 = context.getString(R.string.mission_click_ads_desc);
                String string6 = context.getString(R.string.mission_click_ads_grab);
                int i12 = R.drawable.icon_mission_item_fiction_book;
                break;
            default:
                switch (i10) {
                }
        }
        return null;
    }

    public void E0(boolean z10) {
        this.f13530h = z10;
    }

    public String F(int i10) {
        return "ttbook_mission_" + i10;
    }

    public void F0() {
        ba.j.n(this.f13524b, f13512a0, MartianRPUserManager.a());
    }

    public int G(int i10) {
        MissionBonusList missionBonusList = this.f13523a;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return A(i10);
        }
        for (MissionItem missionItem : this.f13523a.getBonusList()) {
            if (missionItem.getType() == i10) {
                return missionItem.getMoney();
            }
        }
        return A(i10);
    }

    public void G0() {
        long a10 = MartianRPUserManager.a();
        this.f13536n = a10;
        this.f13537o++;
        ba.j.n(this.f13524b, Z, a10);
        ConfigSingleton.D().t0(Y);
    }

    public long H() {
        return ba.j.h(this.f13524b, W, -1L);
    }

    public void H0(FragmentActivity fragmentActivity, boolean z10, o oVar) {
        MiConfigSingleton.b2().H1().I0(fragmentActivity, true, new f(fragmentActivity, z10, oVar));
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View I(Context context, MissionItem missionItem, ViewGroup viewGroup, boolean z10, n nVar) {
        View inflate;
        if (context == null) {
            return null;
        }
        if (z10) {
            inflate = viewGroup.findViewWithTag(Integer.valueOf(missionItem.getType()));
        } else {
            inflate = LayoutInflater.from(context).inflate(R.layout.item_mission_task, (ViewGroup) null);
            inflate.setTag(Integer.valueOf(missionItem.getType()));
        }
        if (inflate == null) {
            return null;
        }
        ItemMissionTaskBinding bind = ItemMissionTaskBinding.bind(inflate);
        bind.mcItemIntervalCountdown.setVisibility(8);
        if (ba.l.q(missionItem.getIcon())) {
            bind.mcItemIcon.setVisibility(8);
        } else {
            bind.mcItemIcon.setVisibility(0);
            String icon = missionItem.getIcon();
            ImageView imageView = bind.mcItemIcon;
            int i10 = missionItem.iconRes;
            m0.f(context, icon, imageView, i10, i10);
        }
        bind.mcBonusTagView.setVisibility(0);
        if (missionItem.getMoney() > 0) {
            bind.mcBonusTag.setImageResource(R.drawable.icon_red_envelope);
            bind.mcItemHintGrab.setTextColor(ContextCompat.getColor(context, com.martian.libmars.R.color.bonus_red));
            bind.mcItemHintGrab.setText("+" + oe.f.n(Integer.valueOf(missionItem.getMoney())) + "元");
        } else if (missionItem.getCoins() > 0) {
            bind.mcBonusTag.setImageResource(R.drawable.icon_coins);
            bind.mcItemHintGrab.setTextColor(ContextCompat.getColor(context, R.color.mission_center_text_color_default));
            bind.mcItemHintGrab.setText("+" + missionItem.getCoins() + context.getString(R.string.bonus_unit));
        } else if (missionItem.getBookCoins().intValue() > 0) {
            bind.mcBonusTag.setImageResource(R.drawable.icon_mission_bookcoins);
            bind.mcItemHintGrab.setTextColor(ContextCompat.getColor(context, com.martian.libmars.R.color.theme_default));
            bind.mcItemHintGrab.setText("+" + missionItem.getBookCoins() + "淘书币");
        } else {
            bind.mcBonusTagView.setVisibility(8);
        }
        bind.mcItemTitle.setText(missionItem.getTitle());
        if (missionItem.getFinished()) {
            bind.mcItemButton.setAlpha(0.5f);
            bind.mcItemButton.setSelectable(false);
            bind.mcItemButton.setText(context.getString(R.string.mission_finished));
        } else {
            bind.mcItemButton.setAlpha(1.0f);
            if (!ba.l.q(missionItem.getBonusString())) {
                bind.mcItemButton.setText(missionItem.getBonusString());
            }
            if (ba.l.q(missionItem.getButtonText())) {
                bind.mcItemButton.setText("领福利");
            } else {
                bind.mcItemButton.setText(missionItem.getButtonText());
            }
            if (missionItem.getType() == 0) {
                bind.mcItemHintDesc.setText(context.getString(R.string.mission_novel_desc));
                bind.mcItemButton.setText(context.getString(R.string.mission_forward));
            } else if (missionItem.getType() == 106 || missionItem.getType() == 111) {
                N0(bind.mcItemButton, bind.mcItemIntervalCountdown);
            }
        }
        bind.mcItemHintDesc.setText(missionItem.getDesc());
        if (nVar != null) {
            bind.mcItemView.setOnClickListener(new View.OnClickListener() { // from class: ya.e1

                /* renamed from: c */
                public final /* synthetic */ MissionItem f33191c;

                public /* synthetic */ e1(MissionItem missionItem2) {
                    missionItem = missionItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.n.this.a(missionItem);
                }
            });
            bind.mcItemButton.setOnClickListener(new View.OnClickListener() { // from class: ya.f1

                /* renamed from: c */
                public final /* synthetic */ MissionItem f33209c;

                public /* synthetic */ f1(MissionItem missionItem2) {
                    missionItem = missionItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.n.this.a(missionItem);
                }
            });
        }
        return inflate;
    }

    public final void I0(Activity activity) {
        E0(false);
        C0();
        MiConfigSingleton.b2().H1().H0(activity, e0.U, new a());
    }

    public final String J(Context context) {
        return i8.g.m(context, "com.martian.qplay") ? "去看看" : context.getString(R.string.mission_item_game_go);
    }

    public void J0(FragmentActivity fragmentActivity, o oVar) {
        if (U0()) {
            t0.b(fragmentActivity, "今日额度已用完，明天再来吧");
        } else if (n()) {
            K0(fragmentActivity);
        } else {
            MiConfigSingleton.b2().H1().I0(fragmentActivity, true, new g(fragmentActivity, oVar));
        }
    }

    public int K() {
        return ba.j.f(this.f13524b, X, 0);
    }

    public final void K0(Activity activity) {
        String str;
        int H2 = (int) ((H() - MartianRPUserManager.a()) / 1000);
        int i10 = H2 / 60;
        int i11 = H2 % 60;
        if (i10 > 0) {
            str = i10 + "分";
        } else {
            str = "";
        }
        if (i11 > 0) {
            str = str + i11 + "秒";
        }
        if (ba.l.q(str)) {
            str = "倒计时结束";
        }
        if (activity != null) {
            t0.b(activity, str + "后可继续观看");
        }
    }

    public List<TYActivity> L() {
        return this.f13526d;
    }

    public final boolean L0(FragmentActivity fragmentActivity) {
        if (!MiConfigSingleton.b2().L2()) {
            return false;
        }
        if (MiConfigSingleton.b2().v0("" + MiConfigSingleton.b2().v2())) {
            return false;
        }
        od.k.r(fragmentActivity, true);
        return true;
    }

    public final int M() {
        long N2 = N();
        if (N2 == -1 || !ConfigSingleton.D().K0(N2)) {
            ConfigSingleton.D().Y0(Y);
            this.f13537o = 0;
        }
        if (this.f13537o < 0) {
            this.f13537o = ConfigSingleton.D().v(Y);
        }
        return this.f13537o;
    }

    public void M0(FragmentActivity fragmentActivity, m mVar) {
        if (MiConfigSingleton.b2().F2()) {
            new j(fragmentActivity, fragmentActivity, mVar).j();
        }
    }

    public final long N() {
        if (this.f13536n == 0) {
            this.f13536n = ba.j.h(this.f13524b, Z, -1L);
        }
        return this.f13536n;
    }

    public final void N0(TextView textView, IntervalCountdownTextView intervalCountdownTextView) {
        T0(textView, intervalCountdownTextView, n());
        intervalCountdownTextView.setOnCountDownFinishListener(new IntervalCountdownTextView.b() { // from class: ya.h1

            /* renamed from: b */
            public final /* synthetic */ TextView f33225b;

            /* renamed from: c */
            public final /* synthetic */ IntervalCountdownTextView f33226c;

            public /* synthetic */ h1(TextView textView2, IntervalCountdownTextView intervalCountdownTextView2) {
                textView = textView2;
                intervalCountdownTextView = intervalCountdownTextView2;
            }

            @Override // com.martian.mibook.ui.IntervalCountdownTextView.b
            public final void a(IntervalCountdownTextView intervalCountdownTextView2) {
                com.martian.mibook.application.c.this.m0(textView, intervalCountdownTextView, intervalCountdownTextView2);
            }
        });
    }

    public int O() {
        return w(106);
    }

    public void O0(Activity activity, e9.c cVar) {
        if (MiConfigSingleton.b2().E2()) {
            return;
        }
        new k(activity, cVar).j();
    }

    public String P() {
        return M() + "/" + r(106);
    }

    public void P0(FragmentActivity fragmentActivity, e9.c cVar) {
        if (MiConfigSingleton.b2().M1().s2(fragmentActivity)) {
            C0();
        } else {
            w0();
            r0(fragmentActivity, cVar, false);
        }
    }

    public int Q() {
        return w(111);
    }

    public final boolean Q0(FragmentActivity fragmentActivity, e9.c cVar, boolean z10) {
        if (this.f13531i || MiConfigSingleton.b2().K2()) {
            return false;
        }
        this.f13531i = true;
        if (MiConfigSingleton.b2().c2().getInterstitialAdMerge() && ReadingInstance.z().o()) {
            C0();
            return ReadingInstance.z().j(fragmentActivity, new l(fragmentActivity, cVar, z10));
        }
        int interAdStartRuntimes = MiConfigSingleton.b2().c2().getInterAdStartRuntimes();
        int Z2 = MiConfigSingleton.b2().Z();
        if (Z2 < interAdStartRuntimes) {
            return false;
        }
        int interAdRuntimesInterval2 = MiConfigSingleton.b2().c2().getInterAdRuntimesInterval2();
        if (interAdStartRuntimes != Z2 && (interAdRuntimesInterval2 <= 0 || Z2 % interAdRuntimesInterval2 != 0)) {
            return false;
        }
        I0(fragmentActivity);
        return true;
    }

    public final String R() {
        String[] B1 = MiConfigSingleton.b2().B1();
        if (B1 == null || B1.length == 0) {
            return "";
        }
        if (B1.length == 1) {
            return "； 评论内容需包含\"" + B1[0] + "\"。";
        }
        return "； 评论内容需包含\"" + B1[0] + "\"和\"" + B1[1] + "\"。";
    }

    public void R0(Activity activity) {
        if (b0() || !h0()) {
            return;
        }
        I0(activity);
    }

    public void S(Activity activity) {
        if ((activity instanceof EnterRestartActivity) || !MiConfigSingleton.b2().F2() || MiConfigSingleton.b2().C2()) {
            return;
        }
        e eVar = new e(MartianGetXianwanGamesParams.class, XianWanGameChannel.class, activity);
        eVar.p();
        eVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S0(Activity activity) {
        C0527c c0527c = new C0527c(CheckinNotifyParams.class, Boolean.class, activity);
        ((CheckinNotifyParams) c0527c.k()).setEnable(Boolean.valueOf(MiConfigSingleton.b2().D1()));
        c0527c.j();
    }

    public List<XianWanGame> T() {
        if (this.f13525c == null) {
            this.f13525c = new ArrayList();
        }
        return this.f13525c;
    }

    public final void T0(TextView textView, IntervalCountdownTextView intervalCountdownTextView, boolean z10) {
        if (z10) {
            textView.setVisibility(8);
            intervalCountdownTextView.setVisibility(0);
            intervalCountdownTextView.m(H());
        } else {
            textView.setVisibility(0);
            intervalCountdownTextView.setVisibility(8);
            intervalCountdownTextView.r();
        }
    }

    public MissionItem U(XianWanGame xianWanGame) {
        if (xianWanGame == null || ba.l.q(xianWanGame.getUrl())) {
            return null;
        }
        return new MissionItem(110, xianWanGame.getGameName(), "试玩赚取大额佣金，提现秒到", "去试玩", true, R.drawable.icon_mission_item_play, false, 0, xianWanGame.getMoney().intValue(), true, true).setUrl(xianWanGame.getUrl()).setIcon(xianWanGame.getIcon());
    }

    public boolean U0() {
        return M() >= r(106);
    }

    public boolean V(Activity activity, e9.c cVar, boolean z10, m mVar) {
        if (MiConfigSingleton.b2().F2() && !MiConfigSingleton.b2().C2()) {
            MiTaskAccount p22 = MiConfigSingleton.b2().p2();
            if (p22 != null && p22.getFreshRedpaper() > 0) {
                ac.a.G(activity, "新手红包-领取-请求");
                new b(activity, z10, activity, cVar, mVar).j();
                return true;
            }
            if (z10) {
                t0.b(activity, "领取失败");
            }
        }
        return false;
    }

    public void W(Activity activity, TYActivity tYActivity, e9.c cVar, String str) {
        ac.a.l(activity, str + "-" + tYActivity.getTitle() + "-点击");
        if (tYActivity.getActivityId() == -1) {
            je.i.o(activity);
            return;
        }
        if (!ba.l.q(tYActivity.getDeeplink())) {
            if (i8.g.h(activity, tYActivity.getDeeplink())) {
                i8.g.A(activity, tYActivity.getDeeplink(), "", "", true);
                return;
            } else {
                if (ba.l.q(tYActivity.getActivityUrl())) {
                    return;
                }
                MiWebViewActivity.I5(activity, tYActivity.getActivityUrl(), false, tYActivity.getShareUrl(), tYActivity.getShareable(), tYActivity.getShareImageUrl(), tYActivity.getFullscreen().booleanValue());
                return;
            }
        }
        if (!ba.l.q(tYActivity.getActivityUrl())) {
            MiWebViewActivity.I5(activity, tYActivity.getActivityUrl(), false, tYActivity.getShareUrl(), tYActivity.getShareable(), tYActivity.getShareImageUrl(), tYActivity.getFullscreen().booleanValue());
        } else {
            if (ba.l.q(tYActivity.getDialogImage())) {
                return;
            }
            v0.J0(activity, tYActivity, cVar, str + "弹窗", null);
        }
    }

    public void X(FragmentActivity fragmentActivity, int i10, o oVar) {
        if (i10 == 0) {
            ac.a.E(fragmentActivity, "看小说");
            return;
        }
        if (i10 == 1) {
            ac.a.E(fragmentActivity, "邀请好友");
            je.i.o(fragmentActivity);
            return;
        }
        if (i10 == 2) {
            ac.a.E(fragmentActivity, "晒收入");
            if (MiConfigSingleton.b2().G1().i(fragmentActivity)) {
                ShareImageUrlActivity.n(fragmentActivity, 2);
                return;
            }
            return;
        }
        if (i10 == 3) {
            ac.a.E(fragmentActivity, "绑定邀请码");
            fragmentActivity.startActivityForResult(new Intent(fragmentActivity, (Class<?>) BindInviterActivity.class), 3);
            return;
        }
        if (i10 == 4) {
            ac.a.E(fragmentActivity, "新手红包");
            return;
        }
        if (i10 == 101) {
            q0(fragmentActivity);
            return;
        }
        if (i10 == 102) {
            ac.a.E(fragmentActivity, "米墙");
            return;
        }
        if (i10 != 106) {
            if (i10 == 108) {
                ac.a.E(fragmentActivity, "简单应用任务");
                return;
            }
            if (i10 != 111) {
                if (i10 == 200) {
                    ac.a.E(fragmentActivity, "红包头条");
                    MiWebViewActivity.A4(fragmentActivity, "http://news.fhbtt.com/hbnews/poster.html", false);
                    return;
                }
                if (i10 == 202) {
                    ac.a.E(fragmentActivity, "大转盘");
                    MiWebViewActivity.startWebViewActivity(fragmentActivity, new MartianLuckyDrawParams().toHttpUrl(z5.k.f33694e));
                    return;
                }
                if (i10 == 2008) {
                    ac.a.E(fragmentActivity, "0.3元提现");
                    if (MiConfigSingleton.b2().G1().g(fragmentActivity, 1023)) {
                        je.i.Q(fragmentActivity, "赚钱=新手任务", 20001);
                        return;
                    }
                    return;
                }
                switch (i10) {
                    case 7:
                        ac.a.E(fragmentActivity, "首次收徒");
                        je.i.g0(fragmentActivity, fragmentActivity.getString(R.string.invite_link), "", false, fragmentActivity.getString(R.string.invite_share_link));
                        break;
                    case 8:
                        ac.a.E(fragmentActivity, "绑定手机号");
                        if (!g0()) {
                            PhoneLoginActivity.y3(fragmentActivity, 1, "", 20003);
                            break;
                        } else {
                            t0.b(fragmentActivity, "您已绑定手机号");
                            break;
                        }
                    case 9:
                        ac.a.E(fragmentActivity, "发表评论");
                        break;
                    case 10:
                        ac.a.E(fragmentActivity, "五星好评");
                        if (MiConfigSingleton.b2().G1().g(fragmentActivity, 1013)) {
                            org.codechimp.apprater.a.m(new vi.d());
                            org.codechimp.apprater.a.g(fragmentActivity);
                            break;
                        }
                        break;
                    case 11:
                        ac.a.E(fragmentActivity, "广告");
                        break;
                }
                return;
            }
        }
        J0(fragmentActivity, oVar);
    }

    public void Y(FragmentActivity fragmentActivity, MissionItem missionItem, o oVar) {
        if (missionItem == null || fragmentActivity == null) {
            return;
        }
        Z(missionItem);
        if (missionItem.getType() == 110) {
            if (ba.l.q(missionItem.getRecommend())) {
                ac.a.b0(fragmentActivity, "赚钱-游戏-点击");
            } else {
                ac.a.b0(fragmentActivity, missionItem.getRecommend() + "-游戏-点击");
            }
            MiWebViewActivity.startWebViewActivity(fragmentActivity, missionItem.getUrl() + "&xwgame=true");
        } else if (missionItem.getType() >= 100000) {
            if (!ba.l.q(missionItem.getDeeplink()) && i8.g.h(fragmentActivity, missionItem.getDeeplink())) {
                i8.g.A(fragmentActivity, missionItem.getDeeplink(), "", "", true);
                return;
            } else {
                if (ba.l.q(missionItem.getUrl())) {
                    return;
                }
                je.i.g0(fragmentActivity, missionItem.getUrl(), missionItem.getUrl(), false, null);
                return;
            }
        }
        X(fragmentActivity, missionItem.getType(), oVar);
    }

    public void Z(MissionItem missionItem) {
        if (missionItem == null) {
            return;
        }
        MiConfigSingleton.b2().f3(F(missionItem.getType()), missionItem.getClickType() == 2);
    }

    public void a0(List<MissionItem> list) {
        this.f13532j.clear();
        for (MissionItem missionItem : list) {
            if (missionItem.getBubbleCoins() != null && missionItem.getBubbleCoins().intValue() > 0 && !ba.l.q(missionItem.getBubbleTitle()) && !MiConfigSingleton.b2().A1(F(missionItem.getType())) && (101 != missionItem.getType() || !MiConfigSingleton.b2().C2())) {
                this.f13532j.add(missionItem);
            }
        }
    }

    public boolean b0() {
        return System.currentTimeMillis() - this.f13528f <= ((long) (ConfigSingleton.D().B0() ? 60000 : m2.a.f28273a));
    }

    public final boolean c0() {
        return this.f13529g;
    }

    public boolean d0() {
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        return p22 != null && p22.getValidInviteeNum() > 0;
    }

    public boolean e0() {
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        return p22 != null && p22.getFiveStar();
    }

    public boolean f0() {
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        return p22 != null && p22.getFreshRedpaper() <= 0;
    }

    public boolean g0() {
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        return p22 != null && p22.getPhoneBound();
    }

    public void h(Context context, MissionSection missionSection, ViewGroup viewGroup, n nVar) {
        LayoutInflater from = LayoutInflater.from(context);
        CardViewLayoutBinding inflate = CardViewLayoutBinding.inflate(from, null, false);
        viewGroup.addView(inflate.getRoot());
        inflate.cardViewParent.addView(o0(from, missionSection.getTitle(), context.getString(R.string.txs_commission_mission).equals(missionSection.getTitle())));
        Iterator<MissionItem> it = missionSection.getMissionItems().iterator();
        while (it.hasNext()) {
            inflate.cardViewParent.addView(I(context, it.next(), viewGroup, false, nVar));
        }
        View view = new View(context);
        view.setMinimumHeight(ConfigSingleton.i(12.0f));
        viewGroup.addView(view);
    }

    public boolean h0() {
        return this.f13530h && !MiConfigSingleton.b2().C2();
    }

    public void i(Context context, List<MissionItem> list) {
        MissionBonusList missionBonusList = this.f13523a;
        if (missionBonusList == null || missionBonusList.getBonusList() == null || MiConfigSingleton.b2().C2()) {
            return;
        }
        for (MissionItem missionItem : this.f13523a.getBonusList()) {
            if (missionItem.getType() >= 100000 && !ba.l.q(missionItem.getTitle()) && !ba.l.q(missionItem.getUrl())) {
                list.add(new MissionItem(missionItem.getType(), missionItem.getTitle(), missionItem.getIntro(), J(context), true, R.drawable.icon_mission_item_novice, false, missionItem.getCoins(), missionItem.getMoney(), missionItem.getAuthShow(), missionItem.getIcon(), missionItem.getUrl()));
            }
        }
    }

    public boolean i0() {
        return ConfigSingleton.D().K0(ba.j.h(this.f13524b, f13512a0, -1L));
    }

    public void j() {
        new d().j();
    }

    public void k(AppTask appTask) {
        if (this.f13538p.size() < 10) {
            this.f13538p.add(appTask);
            return;
        }
        if (this.f13538p.size() > 100) {
            this.f13538p.clear();
        }
        Iterator<AppTask> it = this.f13538p.iterator();
        while (it.hasNext()) {
            if (System.currentTimeMillis() - it.next().createdOn > 600000) {
                it.remove();
            }
        }
        this.f13538p.add(appTask);
    }

    public boolean l() {
        return MartianRPUserManager.a() - this.f13533k > 3600000;
    }

    public final /* synthetic */ void l0(boolean z10, FragmentActivity fragmentActivity, int i10, String str, o oVar) {
        if (!z10) {
            t0.b(fragmentActivity, "领取奖励失败");
            return;
        }
        t0.b(fragmentActivity, "观看成功");
        if (i10 == 1 || i10 == 2) {
            G0();
            B0();
            int Q2 = Q();
            if (i10 == 2) {
                MiConfigSingleton.b2().u2().S(fragmentActivity, str, 0, Q2);
            } else {
                MiConfigSingleton.b2().u2().S(fragmentActivity, "作者红包奖励", 0, Q2);
            }
            MiConfigSingleton.b2().G1().B(0, Q2);
        }
        MiConfigSingleton.b2().G1().C(fragmentActivity, true, new i(oVar));
    }

    public boolean m() {
        if (this.f13534l < 0) {
            long h10 = ba.j.h(this.f13524b, V, 0L);
            this.f13534l = h10;
            if (h10 <= 0) {
                z0();
            }
        }
        int authorVideoCountdownInterval = MiConfigSingleton.b2().c2().getAuthorVideoCountdownInterval();
        return authorVideoCountdownInterval > 0 && MartianRPUserManager.a() - this.f13534l > ((long) (authorVideoCountdownInterval * SdkConfigData.DEFAULT_REQUEST_INTERVAL)) * 1000;
    }

    public final /* synthetic */ void m0(TextView textView, IntervalCountdownTextView intervalCountdownTextView, IntervalCountdownTextView intervalCountdownTextView2) {
        T0(textView, intervalCountdownTextView, false);
    }

    public boolean n() {
        return MartianRPUserManager.a() < ba.j.h(this.f13524b, W, -1L);
    }

    public void n0() {
        try {
            String B2 = ba.g.B(this.f13524b, T);
            if (!TextUtils.isEmpty(B2)) {
                this.f13523a = (MissionBonusList) GsonUtils.b().fromJson(B2, MissionBonusList.class);
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (this.f13523a == null) {
            this.f13523a = new MissionBonusList();
        }
    }

    public boolean o(int i10) {
        return (i10 >= 0 && i10 <= 17) || (i10 >= 101 && i10 <= 111) || i10 >= 100000;
    }

    public View o0(LayoutInflater layoutInflater, String str, boolean z10) {
        if (ba.l.q(str)) {
            return null;
        }
        MissionSectionTitleBinding inflate = MissionSectionTitleBinding.inflate(layoutInflater, null, false);
        inflate.missionTitle.setText(str);
        if (z10) {
            inflate.missionTitleIcon.setVisibility(0);
        }
        return inflate.getRoot();
    }

    public boolean p() {
        MiTaskAccount p22;
        return !MiConfigSingleton.b2().C2() && (p22 = MiConfigSingleton.b2().p2()) != null && p22.getCoinsRate() == 10000 && Q() > 0;
    }

    public final void p0(FragmentActivity fragmentActivity, String str, boolean z10, int i10, o oVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        ba.o.e(new Runnable() { // from class: ya.g1

            /* renamed from: c */
            public final /* synthetic */ boolean f33213c;

            /* renamed from: d */
            public final /* synthetic */ FragmentActivity f33214d;

            /* renamed from: e */
            public final /* synthetic */ int f33215e;

            /* renamed from: f */
            public final /* synthetic */ String f33216f;

            /* renamed from: g */
            public final /* synthetic */ c.o f33217g;

            public /* synthetic */ g1(boolean z102, FragmentActivity fragmentActivity2, int i102, String str2, c.o oVar2) {
                z10 = z102;
                fragmentActivity = fragmentActivity2;
                i10 = i102;
                str = str2;
                oVar = oVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.martian.mibook.application.c.this.l0(z10, fragmentActivity, i10, str, oVar);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(FragmentActivity fragmentActivity, String str, String str2, String str3, boolean z10, int i10, o oVar) {
        String str4;
        if (!z10) {
            p0(fragmentActivity, str3, false, i10, oVar);
            return;
        }
        h hVar = new h(MartianFinishRewardVideoParams.class, Boolean.class, fragmentActivity, fragmentActivity, str3, i10, oVar);
        ((MartianFinishRewardVideoParams) hVar.k()).setExtra(str);
        try {
            str4 = ba.d.a(str + hf.e.f26694a + str2 + hf.e.f26694a + System.currentTimeMillis(), "a1ba6ec3f4c28dce");
        } catch (Exception unused) {
            str4 = "";
        }
        ((MartianFinishRewardVideoParams) hVar.k()).setC(str4);
        ((MartianFinishRewardVideoParams) hVar.k()).setVendor(str2);
        hVar.j();
    }

    public void q0(Activity activity) {
        ac.a.b0(activity, "赚钱-主页-点击");
        if (MiConfigSingleton.b2().G1().g(activity, 1015)) {
            MartianPlayxianAppwallParams martianPlayxianAppwallParams = new MartianPlayxianAppwallParams();
            martianPlayxianAppwallParams.setUid(Long.valueOf(Long.parseLong(MiConfigSingleton.b2().t2())));
            martianPlayxianAppwallParams.setToken(MiConfigSingleton.b2().G1().p().getToken());
            martianPlayxianAppwallParams.setImei(ConfigSingleton.D().A());
            martianPlayxianAppwallParams.setOaid(ConfigSingleton.D().M());
            martianPlayxianAppwallParams.setAndroid_id(ConfigSingleton.D().j());
            martianPlayxianAppwallParams.setDevice_id(ConfigSingleton.D().y());
            MiWebViewActivity.startWebViewActivity(activity, martianPlayxianAppwallParams.toHttpUrl(z5.k.f33694e));
        }
    }

    public int r(int i10) {
        MissionBonusList missionBonusList = this.f13523a;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return x(i10);
        }
        for (MissionItem missionItem : this.f13523a.getBonusList()) {
            if (missionItem.getType() == i10) {
                if (missionItem.getBonusCount() == null) {
                    return 0;
                }
                return missionItem.getBonusCount().intValue();
            }
        }
        return x(i10);
    }

    public void r0(FragmentActivity fragmentActivity, e9.c cVar, boolean z10) {
        if (!c0() || b0() || MiConfigSingleton.b2().C2()) {
            return;
        }
        if (L0(fragmentActivity)) {
            C0();
            return;
        }
        if (Q0(fragmentActivity, cVar, z10)) {
            return;
        }
        for (TYActivity tYActivity : this.f13526d) {
            if (MiConfigSingleton.b2().Y() >= tYActivity.getRuntimes().intValue() && (tYActivity.getShowOnStart() || z10)) {
                if (tYActivity.getStarted() && !tYActivity.isInterAdActivity()) {
                    long activityId = tYActivity.getActivityId();
                    if (!ba.l.q(tYActivity.getDialogImage()) && activityId > 0) {
                        String str = "" + activityId;
                        String T2 = MiConfigSingleton.b2().T("mission_activity_ids");
                        if (ba.l.q(T2) || !T2.contains(str)) {
                            if (!ba.l.q(T2)) {
                                str = T2 + "," + str;
                            }
                            if (str.length() > 84) {
                                str = str.substring(42);
                            }
                            MiConfigSingleton.b2().j1("mission_activity_ids", str);
                            C0();
                            v0.K0(fragmentActivity, tYActivity, cVar);
                            return;
                        }
                    }
                }
            }
        }
    }

    public TYActivity s() {
        if (this.f13526d.isEmpty()) {
            return null;
        }
        if (this.f13527e == null) {
            this.f13527e = new ArrayList();
            for (TYActivity tYActivity : this.f13526d) {
                if (!ba.l.q(tYActivity.getBubbleImage())) {
                    this.f13527e.add(tYActivity);
                }
            }
        }
        if (this.f13527e.isEmpty()) {
            return null;
        }
        return this.f13527e.get(new Random().nextInt(this.f13527e.size()));
    }

    public void s0(String str) {
        Iterator<AppTask> it = this.f13538p.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().packageName)) {
                it.remove();
            }
        }
    }

    public MissionItem t() {
        if (this.f13532j.isEmpty()) {
            return null;
        }
        return this.f13532j.remove(0);
    }

    public void t0() {
    }

    public AppTask u(String str) {
        for (AppTask appTask : this.f13538p) {
            if (str.equals(appTask.filename)) {
                return appTask;
            }
        }
        return null;
    }

    public void u0() {
        this.f13528f = -1L;
        this.f13531i = false;
        E0(false);
    }

    public AppTask v(String str) {
        for (AppTask appTask : this.f13538p) {
            if (str.equals(appTask.packageName)) {
                return appTask;
            }
        }
        return null;
    }

    public void v0(String str) {
        try {
            ba.g.F(this.f13524b, T, str);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public int w(int i10) {
        MissionBonusList missionBonusList = this.f13523a;
        if (missionBonusList == null || missionBonusList.getBonusList() == null) {
            return z(i10);
        }
        for (MissionItem missionItem : this.f13523a.getBonusList()) {
            if (missionItem.getType() == i10) {
                return missionItem.getCoins();
            }
        }
        return z(i10);
    }

    public void w0() {
        this.f13529g = true;
    }

    public int x(int i10) {
        return (i10 == 106 || i10 == 111) ? 8 : 0;
    }

    public void x0(long j10) {
        if (j10 >= 0) {
            this.f13535m = MartianRPUserManager.a() + j10;
        } else {
            this.f13535m = j10;
        }
    }

    public int y(int i10) {
        return i10 == 106 ? 100 : 0;
    }

    public void y0() {
        this.f13533k = MartianRPUserManager.a();
    }

    public int z(int i10) {
        if (i10 == 0) {
            return 1000000;
        }
        if (i10 != 103) {
            if (i10 == 106) {
                return 10000;
            }
            if (i10 == 111) {
                return 60;
            }
            if (i10 == 202) {
                return 10000;
            }
            if (i10 == 2) {
                return 10;
            }
            if (i10 != 3) {
                if (i10 == 5) {
                    return 100;
                }
                if (i10 != 6) {
                    switch (i10) {
                        case 8:
                            break;
                        case 9:
                            return 100;
                        case 10:
                            return 20;
                        case 11:
                            return 10000;
                        default:
                            return 0;
                    }
                }
            }
        }
        return 20;
    }

    public void z0() {
        long a10 = MartianRPUserManager.a();
        this.f13534l = a10;
        ba.j.n(this.f13524b, V, a10);
    }

    public class b extends p {

        /* renamed from: k */
        public final /* synthetic */ boolean f13540k;

        /* renamed from: l */
        public final /* synthetic */ Activity f13541l;

        /* renamed from: m */
        public final /* synthetic */ e9.c f13542m;

        /* renamed from: n */
        public final /* synthetic */ m f13543n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, boolean z10, Activity activity2, e9.c cVar, m mVar) {
            super(activity);
            this.f13540k = z10;
            this.f13541l = activity2;
            this.f13542m = cVar;
            this.f13543n = mVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (this.f13540k) {
                t0.b(this.f13541l, cVar.d());
            }
            ac.a.G(this.f13541l, "新手红包-领取-失败");
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ExchangeMoney exchangeMoney) {
            if (exchangeMoney == null) {
                return;
            }
            e9.c cVar = this.f13542m;
            if (cVar != null) {
                cVar.d(j2.O, 4);
            }
            lb.c.x(this.f13541l, new a());
            ac.a.G(this.f13541l, "新手红包-领取-成功");
        }

        public class a implements c.g {
            public a() {
            }

            @Override // lb.c.g
            public void b(MiTaskAccount miTaskAccount) {
                m mVar = b.this.f13543n;
                if (mVar != null) {
                    mVar.a();
                }
            }

            @Override // lb.c.g
            public void a(x8.c cVar) {
            }
        }
    }

    /* renamed from: com.martian.mibook.application.c$c */
    public class C0527c extends v<CheckinNotifyParams, Boolean> {
        public C0527c(Class cls, Class cls2, Activity activity) {
            super(cls, cls2, activity);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Boolean> list) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // kb.v, y8.a
        public void onResultError(x8.c cVar) {
        }
    }

    public class d extends jb.f {
        public d() {
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(MissionBonusList missionBonusList) {
            if (missionBonusList == null || missionBonusList.getBonusList() == null || missionBonusList.getBonusList().size() == 0) {
                return;
            }
            try {
                c.this.v0(GsonUtils.b().toJson(missionBonusList));
                c.this.A0(missionBonusList);
                c.this.a0(missionBonusList.getBonusList());
            } catch (Exception unused) {
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }
    }

    public class k extends jb.a {

        /* renamed from: i */
        public final /* synthetic */ Activity f13566i;

        /* renamed from: j */
        public final /* synthetic */ e9.c f13567j;

        public k(Activity activity, e9.c cVar) {
            this.f13566i = activity;
            this.f13567j = cVar;
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TYActivityList tYActivityList) {
            if (tYActivityList == null || tYActivityList.getActivityList() == null || tYActivityList.getActivityList().isEmpty()) {
                return;
            }
            c.this.f13526d = tYActivityList.getActivityList();
            c.this.r0((FragmentActivity) this.f13566i, this.f13567j, false);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }
    }
}
