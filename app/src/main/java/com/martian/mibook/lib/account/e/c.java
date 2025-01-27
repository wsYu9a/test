package com.martian.mibook.lib.account.e;

import android.app.Activity;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.d.q.p;
import com.martian.mibook.lib.account.d.q.q;
import com.martian.mibook.lib.account.request.auth.BParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public static String f13919a = "LOGIN_SWITCH_ACCOUNT";

    static class a extends p {

        /* renamed from: j */
        final /* synthetic */ e f13920j;
        final /* synthetic */ MartianIUserManager k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, final e val$martianIUserManager, final MartianIUserManager val$listener) {
            super(activity);
            this.f13920j = val$martianIUserManager;
            this.k = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            e eVar = this.f13920j;
            if (eVar != null) {
                eVar.a(errorResult);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(MartianRPAccount rpAccount) {
            if (rpAccount != null) {
                this.k.k(rpAccount);
                e eVar = this.f13920j;
                if (eVar != null) {
                    eVar.b(rpAccount);
                }
            }
        }
    }

    static class b extends q {

        /* renamed from: j */
        final /* synthetic */ d f13921j;
        final /* synthetic */ MartianIUserManager k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, final d val$martianIUserManager, final MartianIUserManager val$listener) {
            super(activity);
            this.f13921j = val$martianIUserManager;
            this.k = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            d dVar = this.f13921j;
            if (dVar != null) {
                dVar.a(errorResult);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(MiTaskAccount miTaskAccount) {
            if (miTaskAccount != null) {
                this.k.l(miTaskAccount);
                d dVar = this.f13921j;
                if (dVar != null) {
                    dVar.b(miTaskAccount);
                }
            }
        }
    }

    /* renamed from: com.martian.mibook.lib.account.e.c$c */
    static class C0272c extends com.martian.mibook.lib.account.d.q.b {

        /* renamed from: j */
        final /* synthetic */ f f13922j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0272c(j1 activity, final f val$listener) {
            super(activity);
            this.f13922j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean aBoolean) {
            f fVar = this.f13922j;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public interface d {
        void a(b.d.c.b.c errorResult);

        void b(MiTaskAccount miTaskAccount);
    }

    public interface e {
        void a(b.d.c.b.c errorResult);

        void b(MartianRPAccount rpAccount);
    }

    public interface f {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(j1 activity, int bt, String extra, final f listener) {
        C0272c c0272c = new C0272c(activity, listener);
        if (!k.p(extra)) {
            ((BParams) c0272c.k()).setExtra(extra);
        }
        ((BParams) c0272c.k()).setBt(Integer.valueOf(bt));
        c0272c.j();
    }

    public static String b() {
        return h.F().Q0() ? "http://testm.taoyuewenhua.cn/" : h.F().G0() ? "http://betam.taoyuewenhua.cn/" : "https://m.taoyuewenhua.cn/";
    }

    public static void c(Activity activity) {
        WebViewActivity.c4(activity, b() + "app_authority/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void d(Activity activity) {
        WebViewActivity.c4(activity, b() + "civilized_pledge/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void e(Activity activity, boolean phoneBound, boolean weixinBound) {
        WebViewActivity.c4(activity, b() + "personal_list/index.html?ostype=0&appid=" + h.F().f().f9879a + "&phoneBound=" + phoneBound + "&weixinBound=" + weixinBound, true);
    }

    public static void f(Activity activity) {
        WebViewActivity.c4(activity, b() + "privacy/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void g(Activity activity) {
        WebViewActivity.c4(activity, b() + "share_list/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void h(Activity activity) {
        WebViewActivity.c4(activity, b() + "children_information/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void i(Activity activity) {
        WebViewActivity.c4(activity, b() + "user_agreement/index.html?ostype=0&appid=" + h.F().f().f9879a, true);
    }

    public static void j(int bookCoins) {
        MartianRPAccount c2 = MartianIUserManager.b().c();
        if (c2 != null) {
            c2.setBookCoins(Integer.valueOf(c2.getBookCoins() + bookCoins));
            MartianIUserManager.b().k(c2);
        }
    }

    public static void k(Activity activity, final e listener) {
        MartianIUserManager b2 = MartianIUserManager.b();
        if (b2 == null || !b2.f()) {
            return;
        }
        new a(activity, listener, b2).j();
    }

    public static void l(Activity activity, final d listener) {
        MartianIUserManager b2 = MartianIUserManager.b();
        if (b2 == null || !b2.f()) {
            return;
        }
        new b(activity, listener, b2).j();
    }
}
