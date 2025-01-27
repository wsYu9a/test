package lb;

import android.app.Activity;
import android.text.TextUtils;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.MiWebViewBaseActivity;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.request.WXRegisterParams;
import com.martian.mibook.lib.account.request.auth.BParams;
import com.martian.mibook.lib.account.request.auth.TryWeixinBindParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.UserDetail;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;
import jb.l;
import kb.k;
import kb.v;
import l9.i0;
import l9.m0;
import l9.t0;
import z7.b;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public static String f28067a = "LOGIN_SWITCH_ACCOUNT";

    public class d implements b.a {

        /* renamed from: a */
        public final /* synthetic */ Activity f28073a;

        /* renamed from: b */
        public final /* synthetic */ h f28074b;

        /* renamed from: c */
        public final /* synthetic */ String f28075c;

        public d(Activity activity, h hVar, String str) {
            this.f28073a = activity;
            this.f28074b = hVar;
            this.f28075c = str;
        }

        @Override // z7.b.a
        public void a(String str) {
            if (MiUserManager.q() == null || !MiUserManager.q().f()) {
                c.t(this.f28073a, str, this.f28075c, this.f28074b);
            } else {
                c.u(this.f28073a, str, this.f28074b);
            }
        }

        @Override // z7.b.a
        public void b(String str) {
            h hVar = this.f28074b;
            if (hVar != null) {
                hVar.onResultError(new x8.c(-1, "登录失败：" + str));
            }
        }

        @Override // z7.b.a
        public void onLoginCancelled() {
            h hVar = this.f28074b;
            if (hVar != null) {
                hVar.onResultError(new x8.c(-1, "登录取消"));
            }
        }
    }

    public class e extends v<TryWeixinBindParams, UserDetail> {

        /* renamed from: j */
        public final /* synthetic */ Activity f28076j;

        /* renamed from: k */
        public final /* synthetic */ h f28077k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Class cls, Class cls2, Activity activity, Activity activity2, h hVar) {
            super(cls, cls2, activity);
            this.f28076j = activity2;
            this.f28077k = hVar;
        }

        @Override // kb.v, y8.a
        public void onResultError(x8.c cVar) {
            h hVar = this.f28077k;
            if (hVar != null) {
                hVar.onResultError(cVar);
            }
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<UserDetail> list) {
            if (m0.c(this.f28076j)) {
                return;
            }
            if (list == null || list.isEmpty()) {
                t0.b(this.f28076j, ConfigSingleton.D().s("登录失败"));
                this.f28076j.finish();
                return;
            }
            UserDetail userDetail = list.get(0);
            MiUser userInfo = userDetail.getUserInfo();
            if (userInfo == null) {
                this.f28076j.finish();
                return;
            }
            if (userInfo.getLoggingOff().booleanValue()) {
                c.i(this.f28076j, userInfo);
                return;
            }
            MiTaskAccount taskAccount = userDetail.getTaskAccount();
            if (taskAccount != null && MiUserManager.q() != null) {
                MiUserManager.q().k(taskAccount);
            }
            MartianRPAccount account = userDetail.getAccount();
            if (account != null && MartianIUserManager.b() != null) {
                MartianIUserManager.b().j(account);
            }
            h hVar = this.f28077k;
            if (hVar != null) {
                hVar.a(userInfo);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            h hVar = this.f28077k;
            if (hVar != null) {
                hVar.b(z10);
            }
        }
    }

    public class f extends l {

        /* renamed from: i */
        public final /* synthetic */ Activity f28078i;

        /* renamed from: j */
        public final /* synthetic */ h f28079j;

        public f(Activity activity, h hVar) {
            this.f28078i = activity;
            this.f28079j = hVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            h hVar = this.f28079j;
            if (hVar != null) {
                hVar.onResultError(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: q */
        public void onDataReceived(MiUser miUser) {
            if (m0.c(this.f28078i)) {
                return;
            }
            if (miUser.getLoggingOff().booleanValue()) {
                c.i(this.f28078i, miUser);
                return;
            }
            h hVar = this.f28079j;
            if (hVar != null) {
                hVar.a(miUser);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            h hVar = this.f28079j;
            if (hVar != null) {
                hVar.b(z10);
            }
        }
    }

    public interface g {
        void a(x8.c cVar);

        void b(MiTaskAccount miTaskAccount);
    }

    public interface h {
        void a(MiUser miUser);

        void b(boolean z10);

        void onResultError(x8.c cVar);
    }

    public interface i {
        void a(x8.c cVar);

        void b(MartianRPAccount martianRPAccount);
    }

    public interface j {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Activity activity, int i10, String str, j jVar) {
        C0733c c0733c = new C0733c(activity, jVar);
        if (!ba.l.q(str)) {
            ((BParams) c0733c.k()).setExtra(str);
        }
        ((BParams) c0733c.k()).setBt(Integer.valueOf(i10));
        c0733c.j();
    }

    public static String e() {
        return "https://privacy.taoyuewenhua.com/";
    }

    public static boolean f() {
        return ConfigSingleton.D().M0();
    }

    public static /* synthetic */ void g(Activity activity, MiUser miUser) {
        MiWebViewBaseActivity.E4(activity, ConfigSingleton.D().q(), miUser.getUid().toString(), miUser.getToken(), ConfigSingleton.D().l().f26178a, PopupLoginActivity.f13884f);
    }

    public static /* synthetic */ void h(Activity activity) {
        t0.b(activity, ConfigSingleton.D().s("登录取消"));
        activity.finish();
    }

    public static void i(Activity activity, MiUser miUser) {
        if (m0.c(activity)) {
            return;
        }
        i0.x0(activity, ConfigSingleton.D().s("确认信息"), ConfigSingleton.D().s("该账号正在注销审核中，继续登录将会放弃注销"), ConfigSingleton.D().s("取消“"), ConfigSingleton.D().s("放弃注销"), true, new i0.l() { // from class: lb.a

            /* renamed from: a */
            public final /* synthetic */ Activity f28064a;

            /* renamed from: b */
            public final /* synthetic */ MiUser f28065b;

            public /* synthetic */ a(Activity activity2, MiUser miUser2) {
                activity = activity2;
                miUser = miUser2;
            }

            @Override // l9.i0.l
            public final void a() {
                c.g(activity, miUser);
            }
        }, new i0.k() { // from class: lb.b

            /* renamed from: a */
            public final /* synthetic */ Activity f28066a;

            public /* synthetic */ b(Activity activity2) {
                activity = activity2;
            }

            @Override // l9.i0.k
            public final void a() {
                c.h(activity);
            }
        });
    }

    public static void j(Activity activity) {
        WebViewActivity.A4(activity, e() + "app_authority/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void k(Activity activity, String str, h hVar) {
        if (!i8.g.p(activity)) {
            t0.b(activity, ConfigSingleton.D().s("请先安装微信"));
            return;
        }
        if (hVar != null) {
            hVar.b(true);
        }
        z7.b.d().w(new d(activity, hVar, str));
    }

    public static void l(Activity activity) {
        WebViewActivity.A4(activity, e() + "civilized_pledge/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void m(Activity activity, boolean z10, boolean z11) {
        WebViewActivity.A4(activity, e() + "personal_list/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&phoneBound=" + z10 + "&weixinBound=" + z11 + "&traditional=" + f(), true);
    }

    public static void n(Activity activity) {
        WebViewActivity.A4(activity, e() + "index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void o(Activity activity) {
        WebViewActivity.A4(activity, e() + "share_list/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void p(Activity activity) {
        WebViewActivity.A4(activity, e() + "children_information/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void q(Activity activity) {
        WebViewActivity.A4(activity, e() + "user_agreement/index.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void r(Activity activity) {
        WebViewActivity.A4(activity, " https://m.taoyuewenhua.com/vip_rules?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    public static void s(Activity activity) {
        WebViewActivity.A4(activity, " https://m.taoyuewenhua.com/vip_renew_agreement.html?ostype=0&appid=" + ConfigSingleton.D().l().f26178a + "&traditional=" + f(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void t(Activity activity, String str, String str2, h hVar) {
        f fVar = new f(activity, hVar);
        fVar.o();
        ((WXRegisterParams) fVar.k()).setWx_appid(ConfigSingleton.D().q0().f33705a);
        ((WXRegisterParams) fVar.k()).setWx_code(str);
        if (!TextUtils.isEmpty(str2)) {
            ((WXRegisterParams) fVar.k()).setPhone(str2);
        }
        fVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u(Activity activity, String str, h hVar) {
        e eVar = new e(TryWeixinBindParams.class, UserDetail.class, activity, activity, hVar);
        ((TryWeixinBindParams) eVar.k()).setWx_code(str);
        ((TryWeixinBindParams) eVar.k()).setWx_appid(ConfigSingleton.D().q0().f33705a);
        eVar.j();
    }

    public static void v(int i10) {
        MartianRPAccount c10 = MartianIUserManager.b().c();
        if (c10 != null) {
            c10.setBookCoins(Integer.valueOf(c10.getBookCoins() + i10));
            MartianIUserManager.b().j(c10);
        }
    }

    public static void w(Activity activity, i iVar) {
        MartianIUserManager b10 = MartianIUserManager.b();
        if (b10 == null || !b10.f()) {
            return;
        }
        new a(activity, iVar, b10).j();
    }

    public static void x(Activity activity, g gVar) {
        MartianIUserManager b10 = MartianIUserManager.b();
        if (b10 == null || !b10.f()) {
            return;
        }
        new b(activity, gVar, b10).j();
    }

    public class a extends k {

        /* renamed from: k */
        public final /* synthetic */ i f28068k;

        /* renamed from: l */
        public final /* synthetic */ MartianIUserManager f28069l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, i iVar, MartianIUserManager martianIUserManager) {
            super(activity);
            this.f28068k = iVar;
            this.f28069l = martianIUserManager;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            i iVar = this.f28068k;
            if (iVar != null) {
                iVar.a(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(MartianRPAccount martianRPAccount) {
            if (martianRPAccount != null) {
                this.f28069l.j(martianRPAccount);
                i iVar = this.f28068k;
                if (iVar != null) {
                    iVar.b(martianRPAccount);
                }
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class b extends kb.l {

        /* renamed from: k */
        public final /* synthetic */ g f28070k;

        /* renamed from: l */
        public final /* synthetic */ MartianIUserManager f28071l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, g gVar, MartianIUserManager martianIUserManager) {
            super(activity);
            this.f28070k = gVar;
            this.f28071l = martianIUserManager;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            g gVar = this.f28070k;
            if (gVar != null) {
                gVar.a(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(MiTaskAccount miTaskAccount) {
            if (miTaskAccount != null) {
                this.f28071l.k(miTaskAccount);
                g gVar = this.f28070k;
                if (gVar != null) {
                    gVar.b(miTaskAccount);
                }
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    /* renamed from: lb.c$c */
    public class C0733c extends kb.b {

        /* renamed from: k */
        public final /* synthetic */ j f28072k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0733c(Activity activity, j jVar) {
            super(activity);
            this.f28072k = jVar;
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            j jVar = this.f28072k;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // jb.k
        public void s(x8.c cVar) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
