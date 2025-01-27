package ac;

import android.content.Context;
import android.text.TextUtils;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.ss.android.download.api.constant.BaseConstants;
import ga.c;

/* loaded from: classes3.dex */
public class a extends c {
    public static void A(Context context, String str) {
        e(context, "chapter_comment", str);
    }

    public static void B(Context context, String str) {
        e(context, "commission_income", str);
    }

    public static void C(Context context, String str) {
        e(context, "link_ad", str);
    }

    public static void D(Context context, String str) {
        e(context, "login_event_new", str);
    }

    public static void E(Context context, String str) {
        e(context, "mission_center_statistics_new", str);
    }

    public static void F(Context context, String str) {
        e(context, "money_income", str);
    }

    public static void G(Context context, String str) {
        e(context, "money_withdraw", str);
    }

    public static void H(Context context, String str) {
        e(context, "network_status", str);
    }

    public static void I(Context context, String str) {
        e(context, "notification_setting", str);
    }

    public static void J(Context context, String str) {
        try {
            str = str.substring(str.lastIndexOf("/") + 1);
        } catch (Exception unused) {
        }
        e(context, "openUri", str);
    }

    public static void K(Context context, String str, String str2) {
        e(context, "book_event", str + "-" + str2);
    }

    public static void L(Context context, String str) {
        e(context, "reading_page", str);
    }

    public static void M(Context context, String str) {
        e(context, "reading_setting", str);
    }

    public static void N(Context context, String str) {
        e(context, "recommend_apk_download", str);
    }

    public static void O(Context context, String str) {
        e(context, BaseConstants.MARKET_URI_AUTHORITY_SEARCH, str);
    }

    public static void P(Context context, String str) {
        e(context, "security_event", str);
    }

    public static void Q(Context context, String str) {
        e(context, n3.a.f28756v, str);
    }

    public static void R(Context context, String str, String str2) {
        c.f(context, "book_share", str, str2);
    }

    public static void S(Context context, String str) {
        e(context, "share_event", str);
    }

    public static void T(Context context, String str) {
        e(context, "splash_event", str);
    }

    public static void U(Context context, String str) {
        e(context, "txt_download_complete", str);
    }

    public static void V(Context context, String str) {
        e(context, "tags", str);
    }

    public static void W(Context context, String str) {
        e(context, "tts_event", str);
    }

    public static void X(Context context, String str) {
        e(context, "txt_search", str);
    }

    public static void Y(Context context, String str) {
        e(context, "vip_member", str);
    }

    public static void Z(Context context, String str) {
        e(context, "vip_native", str);
    }

    public static void a0(Context context, String str, String str2) {
        if (l.q(str)) {
            str = "webview";
        }
        e(context, str, str2);
    }

    public static void b0(Context context, String str) {
        e(context, "xianwan_game_ads", str);
    }

    public static void e(Context context, String str, String str2) {
        if (ConfigSingleton.D().V0()) {
            if (ConfigSingleton.D().J0()) {
                c.h(context, str, "TEST", str2);
            } else {
                c.h(context, str, ConfigSingleton.D().p0(), str2);
            }
        }
    }

    public static void j(Context context, String str) {
        e(context, "apk_download_complete", str);
    }

    public static void k(Context context, String str) {
        e(context, "account", str);
    }

    public static void l(Context context, String str) {
        e(context, "activities", str);
    }

    public static void m(Context context, String str) {
        e(context, "ad_block", str);
    }

    public static void n(Context context, String str) {
        e(context, "mis_click_new", str);
    }

    public static void o(Context context, String str) {
        e(context, "add_local_book", str);
    }

    public static void p(Context context, String str) {
        e(context, "adx", str);
    }

    public static void q(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("package:")) {
            str = str.substring(8);
        }
        e(context, "app_task_installed", str);
    }

    public static void r(Context context, String str) {
        e(context, "author_bonus", str);
    }

    public static void s(Context context, String str) {
        e(context, "book_ad", str);
    }

    public static void t(Context context, String str) {
        e(context, "txs_account", str);
    }

    public static void u(Context context, String str) {
        e(context, "book_info", str);
    }

    public static void v(Context context, String str) {
        e(context, "book_placement", str);
    }

    public static void w(Context context, String str) {
        e(context, "bookmall_event", str);
    }

    public static void x(Context context, String str) {
        e(context, "bookrack_event", str);
    }

    public static void y(Context context, String str) {
        e(context, "bookworm", str);
    }

    public static void z(Context context, String str) {
        e(context, "category_event", str);
    }
}
