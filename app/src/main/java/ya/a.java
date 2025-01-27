package ya;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.libugrowth.request.CheckUpgradeParams;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.request.auth.UserCommentParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;
import lb.c;
import ya.a;

/* loaded from: classes3.dex */
public class a {
    public static final int A = 1021;
    public static final int B = 1022;
    public static final int C = 1023;
    public static final int D = 1024;
    public static final int E = 10024;
    public static final int F = 10025;

    /* renamed from: g */
    public static final int f33079g = 1000;

    /* renamed from: h */
    public static final int f33080h = 1001;

    /* renamed from: i */
    public static final int f33081i = 1002;

    /* renamed from: j */
    public static final int f33082j = 1003;

    /* renamed from: k */
    public static final int f33083k = 1004;

    /* renamed from: l */
    public static final int f33084l = 1005;

    /* renamed from: m */
    public static final int f33085m = 1006;

    /* renamed from: n */
    public static final int f33086n = 1007;

    /* renamed from: o */
    public static final int f33087o = 1009;

    /* renamed from: p */
    public static final int f33088p = 1010;

    /* renamed from: q */
    public static final int f33089q = 1011;

    /* renamed from: r */
    public static final int f33090r = 1012;

    /* renamed from: s */
    public static final int f33091s = 1013;

    /* renamed from: t */
    public static final int f33092t = 1014;

    /* renamed from: u */
    public static final int f33093u = 1015;

    /* renamed from: v */
    public static final int f33094v = 1016;

    /* renamed from: w */
    public static final int f33095w = 1017;

    /* renamed from: x */
    public static final int f33096x = 1018;

    /* renamed from: y */
    public static final int f33097y = 1019;

    /* renamed from: z */
    public static final int f33098z = 1020;

    /* renamed from: c */
    public Boolean f33101c;

    /* renamed from: e */
    public int f33103e;

    /* renamed from: f */
    public boolean f33104f;

    /* renamed from: a */
    public final String f33099a = "pref_need_user_active";

    /* renamed from: b */
    public final String f33100b = "pref_user_active_sec";

    /* renamed from: d */
    public int f33102d = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public void A(Activity activity, int i10) {
        this.f33101c = Boolean.FALSE;
        b bVar = new b(UserCommentParams.class, Integer.class, activity, i10);
        try {
            ((UserCommentParams) bVar.k()).setS(ba.d.a(MiConfigSingleton.b2().t2() + hf.e.f26694a + MiConfigSingleton.b2().c2().getUserCommentSeconds(), e0.f33186y));
        } catch (Exception unused) {
        }
        ((UserCommentParams) bVar.k()).setSec(Integer.valueOf(i10));
        ((UserCommentParams) bVar.k()).setOaid(ConfigSingleton.D().M());
        ((UserCommentParams) bVar.k()).setAndroid_id(ConfigSingleton.D().j());
        ((UserCommentParams) bVar.k()).setImei(ConfigSingleton.D().A());
        bVar.j();
    }

    public void B(int i10, int i11) {
        MiTaskAccount o10;
        if ((i10 > 0 || i11 > 0) && (o10 = o()) != null) {
            if (i11 > 0) {
                o10.setCoins(Integer.valueOf(o10.getCoins() + i11));
            }
            if (i10 > 0) {
                o10.setMoney(Integer.valueOf(o10.getMoney() + i10));
            }
            MiConfigSingleton.b2().u2().f13078a.k(o10);
        }
    }

    public void C(Activity activity, boolean z10, c.i iVar) {
        if (MiConfigSingleton.b2().F2()) {
            if (!this.f33104f || z10) {
                new c(activity, iVar).j();
            }
        }
    }

    public void e(Activity activity, int i10) {
        if (l()) {
            int n10 = (i10 - n()) - this.f33103e;
            if (n10 < 0 || n10 >= 120) {
                this.f33103e = i10 - n();
                return;
            }
            if (n10 >= 60) {
                int n11 = n() + 60;
                if (n11 > 300 && n11 % 300 != 0) {
                    q();
                } else if (n11 <= 1800 || n11 % 1800 == 0) {
                    A(activity, n11);
                } else {
                    q();
                }
            }
        }
    }

    public boolean f(Activity activity) {
        return g(activity, 10001);
    }

    public boolean g(Activity activity, int i10) {
        if (t()) {
            return true;
        }
        ac.a.D(activity, k("提示登录", i10));
        lb.d.b(activity, i10, !MiConfigSingleton.b2().C2());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(Activity activity, boolean z10) {
        if (MiConfigSingleton.b2().C2()) {
            if (z10) {
                l9.t0.b(activity, "您已经是最新版本");
            }
        } else {
            C0849a c0849a = new C0849a(CheckUpgradeParams.class, UpgradeInfo.class, activity, z10, activity);
            ((CheckUpgradeParams) c0849a.k()).setForce(Boolean.valueOf(z10));
            c0849a.j();
        }
    }

    public boolean i(Activity activity) {
        return j(activity, 10001);
    }

    public boolean j(Activity activity, int i10) {
        if (u()) {
            return true;
        }
        ac.a.D(activity, k("提示登录", i10));
        PopupLoginActivity.q1(activity, i10, !MiConfigSingleton.b2().C2());
        return false;
    }

    public String k(String str, int i10) {
        switch (i10) {
            case 1000:
                return str + "-奖金池-签到";
            case 1001:
                return str + "-首页-点击侧滑充值";
            case 1002:
                return str + "-首页-点击书架同步";
            case 1003:
                return str + "-首页-点击时段奖励";
            case 1004:
                return str + "-评论-发表评论";
            case 1005:
                return str + "-阅读页-点击登录";
            case 1006:
                return str + "-阅读页-点击时长悬浮";
            case 1007:
                return str + "-任务中心-小说分销";
            case 1008:
            default:
                return "";
            case 1009:
                return str + "-任务中心-点击登录";
            case 1010:
                return str + "-任务中心-佣金收入";
            case 1011:
                return str + "-任务中心-签到";
            case 1012:
                return str + "-任务中心-互动红包";
            case 1013:
                return str + "-任务中心-好评";
            case 1014:
                return str + "-任务中心-视频赚书币";
            case 1015:
                return str + "-任务中心-闲玩";
            case 1016:
                return str + "-任务中心-加粉";
            case 1017:
                return str + "-首页-新手红包";
            case 1018:
                return str + "-Q玩任务";
            case 1019:
                return str + "-视频解锁章节";
            case 1020:
                return str + "-购买章节";
            case 1021:
                return str + "-打开赚钱模式";
            case 1022:
                return str + "-点击头像进行登录";
        }
    }

    public final boolean l() {
        if (this.f33101c == null) {
            this.f33101c = Boolean.valueOf(ConfigSingleton.D().Q("pref_need_user_active", false));
        }
        return this.f33101c.booleanValue();
    }

    public MartianRPAccount m() {
        return (MartianRPAccount) MiConfigSingleton.b2().u2().q();
    }

    public final int n() {
        if (this.f33102d < 0) {
            this.f33102d = ConfigSingleton.D().R("pref_user_active_sec", 0);
        }
        return this.f33102d;
    }

    public MiTaskAccount o() {
        return (MiTaskAccount) MiConfigSingleton.b2().u2().r();
    }

    public MiUser p() {
        return (MiUser) MiConfigSingleton.b2().u2().s();
    }

    public final void q() {
        this.f33102d += 60;
        ConfigSingleton.D().h1("pref_user_active_sec", this.f33102d);
    }

    public boolean r() {
        return l() && n() == 0;
    }

    public boolean s() {
        return MiConfigSingleton.b2().u2().v() && MiConfigSingleton.b2().u2().f13078a.u();
    }

    public boolean t() {
        return MiConfigSingleton.b2().u2().v();
    }

    public boolean u() {
        return MiConfigSingleton.b2().u2().v() && !MiConfigSingleton.b2().u2().f13078a.u();
    }

    public void v(Activity activity, MiCompoundUserManager.g gVar) {
        MiConfigSingleton.b2().u2().K();
        MiConfigSingleton.b2().e2().x0(-1L);
        MiConfigSingleton.b2().u2().o(activity, gVar);
    }

    public void w() {
        this.f33102d = 0;
        ConfigSingleton.D().h1("pref_user_active_sec", this.f33102d);
    }

    public void x(me.b bVar) {
        MiConfigSingleton.b2().u2().M(bVar);
    }

    public void y(boolean z10) {
        this.f33104f = z10;
    }

    public void z(boolean z10) {
        this.f33101c = Boolean.valueOf(z10);
        ConfigSingleton.D().g1("pref_need_user_active", z10);
    }

    /* renamed from: ya.a$a */
    public class C0849a extends jb.e<CheckUpgradeParams, UpgradeInfo> {

        /* renamed from: h */
        public final /* synthetic */ boolean f33105h;

        /* renamed from: i */
        public final /* synthetic */ Activity f33106i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0849a(Class cls, Class cls2, Context context, boolean z10, Activity activity) {
            super(cls, cls2, context);
            this.f33105h = z10;
            this.f33106i = activity;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f33105h) {
                l9.t0.b(this.f33106i, cVar.d());
            }
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<UpgradeInfo> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            UpgradeInfo upgradeInfo = list.get(0);
            upgradeInfo.setManual(this.f33105h);
            je.v0.Z0(this.f33106i, upgradeInfo);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class b extends jb.e<UserCommentParams, Integer> {

        /* renamed from: h */
        public final /* synthetic */ int f33108h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Class cls2, Context context, int i10) {
            super(cls, cls2, context);
            this.f33108h = i10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            new Handler().postDelayed(new Runnable() { // from class: ya.b
                public /* synthetic */ b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.r();
                }
            }, 60000L);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<Integer> list) {
            if (this.f33108h > 0) {
                a.this.q();
            }
            if (a.this.n() >= 7200) {
                a.this.z(false);
            } else {
                a.this.f33101c = Boolean.TRUE;
            }
        }

        public final /* synthetic */ void r() {
            a.this.f33101c = Boolean.TRUE;
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class c extends kb.k {

        /* renamed from: k */
        public final /* synthetic */ c.i f33110k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, c.i iVar) {
            super(activity);
            this.f33110k = iVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            c.i iVar = this.f33110k;
            if (iVar != null) {
                iVar.a(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(MartianRPAccount martianRPAccount) {
            if (martianRPAccount == null) {
                return;
            }
            a.this.f33104f = true;
            MartianIUserManager b10 = MartianIUserManager.b();
            if (b10 != null) {
                b10.j(martianRPAccount);
            }
            c.i iVar = this.f33110k;
            if (iVar != null) {
                iVar.b(martianRPAccount);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
