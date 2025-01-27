package com.martian.mibook.lib.model.g;

import android.content.Context;
import android.text.TextUtils;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.q0;
import com.martian.libsupport.k;

/* loaded from: classes.dex */
public class b extends com.martian.libtps.b {
    public static void A(Context context, String name) {
        e(context, "bookmall_event", name);
        H(context, "书城:" + name);
    }

    public static void B(Context context, String name) {
        e(context, "bookrack_event", name);
        H(context, "书架:" + name);
    }

    public static void C(Context context, String name) {
        e(context, "bookrack_mission", name);
        H(context, name);
    }

    public static void D(Context context, String name) {
        e(context, "category_event", name);
        H(context, "分类:" + name);
    }

    public static void E(Context context, String value) {
        e(context, "chapter_comment", value);
    }

    public static void F(Context context, String name) {
        e(context, "commission_income", name);
        H(context, name);
    }

    public static void G(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            url = "Unknown";
        }
        e(context, "download", url);
    }

    public static void H(Context context, String value) {
        if (h.F().g0() > 1 || !h.F().h1()) {
            return;
        }
        com.martian.libugrowth.b.k().i(com.martian.libugrowth.b.f10665c, value);
    }

    public static void I(Context context, int fontsize) {
        e(context, "fontsize", "" + fontsize);
        H(context, "修改字体大小");
    }

    public static void J(Context context, String value) {
        e(context, "link_ad", value);
        H(context, value);
    }

    public static void K(Context context, String name) {
        e(context, "login_event_new", name);
        H(context, name);
    }

    public static void L(Context context, String name) {
        e(context, "mission_center_statistics_new", name);
        H(context, name);
    }

    public static void M(Context context, String name) {
        e(context, "money_income", name);
        H(context, name);
    }

    public static void N(Context context, String name) {
        e(context, "money_withdraw", name);
        H(context, "提现：" + name);
    }

    public static void O(Context context, String value) {
        e(context, "network_status", value);
        H(context, value);
    }

    public static void P(Context context, String name) {
        e(context, "notification_setting", name);
        H(context, name);
    }

    public static void Q(Context context, String filename) {
        try {
            filename = filename.substring(filename.lastIndexOf("/") + 1);
        } catch (Exception unused) {
        }
        e(context, "openUri", filename);
    }

    public static void R(Context context, String filename) {
        e(context, "others_download", filename);
    }

    public static void S(Context context, String recommend, String value) {
        e(context, "book_event", recommend + "-" + value);
        H(context, recommend + "-" + value);
    }

    public static void T(Context context) {
        com.martian.libtps.b.d(context, "post_comment");
        H(context, "发表评论");
    }

    public static void U(Context context, String value) {
        e(context, "reading_menu", value);
    }

    public static void V(Context context, String name) {
        e(context, "reading_page", name);
        H(context, name);
    }

    public static void W(Context context, String name) {
        e(context, "reading_setting", name);
        H(context, name);
    }

    public static void X(Context context, String filename) {
        e(context, "recommend_apk_download", filename);
    }

    public static void Y(Context context, String keyword) {
        e(context, "search", keyword);
        H(context, "搜索");
    }

    public static void Z(Context context, String value) {
        e(context, "security_event", value);
        H(context, value);
    }

    public static void a0(Context context, String name) {
        e(context, "setting", name);
        H(context, name);
    }

    public static void b0(Context context, String from, String value) {
        com.martian.libtps.b.f(context, "book_share", from, value);
        H(context, "分享小说");
    }

    public static void c0(Context context, String value) {
        e(context, "share_event", value);
        H(context, "分享");
    }

    public static void d0(Context context, String filename) {
        e(context, "txt_download_complete", filename);
    }

    public static void e(Context context, String key, String value) {
        if (h.F().H(h.f9882a)) {
            if (h.F().Q0()) {
                com.martian.libtps.b.h(context, key, "TEST", value);
            } else {
                com.martian.libtps.b.h(context, key, h.F().x0(), value);
            }
        }
    }

    public static void e0(Context context, String filename) {
        e(context, "txt_download", filename);
        H(context, "下载txt");
    }

    public static void f0(Context context, String keyword) {
        e(context, "tags", keyword);
        H(context, "标签页");
    }

    public static void g0(Context context, String name) {
        e(context, "txt_search", name);
        H(context, "txt:" + name);
    }

    public static void h0(Context context, String name) {
        e(context, "url_mission", name);
    }

    public static void i0(Context context, String name) {
        q0.e(name);
        e(context, "video_ads", "旧-" + name);
    }

    public static void j(Context context, String filename) {
        e(context, "apk_download_complete", filename);
    }

    public static void j0(Context context, String value) {
        e(context, "video_fullscreen", value);
    }

    public static void k(Context context, String filename) {
        e(context, "apk_download", filename);
    }

    public static void k0(Context context, String name) {
        e(context, "vip_member", name);
        H(context, "进入vip");
    }

    public static void l(Context context, String name) {
        e(context, "account", name);
        H(context, name);
    }

    public static void l0(Context context, String name) {
        e(context, "wbl", name);
    }

    public static void m(Context context, String name) {
        e(context, "activities", name);
        H(context, name);
    }

    public static void m0(Context context, String key, String value) {
        if (k.p(key)) {
            key = b.d.a.j.b.r;
        }
        e(context, key, value);
        H(context, value);
    }

    public static void n(Context context, String name) {
        e(context, "ad_block", name);
    }

    public static void n0(Context context, String name) {
        e(context, "xianwan_game_ads", name);
    }

    public static void o(Context context, String value) {
        e(context, "ad_cache_new", value);
        H(context, value);
    }

    public static void p(Context context, String name) {
        e(context, "ad_hint", name);
    }

    public static void q(Context context, String bookName) {
        e(context, "add_local_book", bookName);
        H(context, "导入txt");
    }

    public static void r(Context context, String name) {
        e(context, "ads_statistics_new", name);
    }

    public static void s(Context context, String name) {
        e(context, "adx", name);
    }

    public static void t(Context context, String dataString) {
        if (dataString.startsWith("package:")) {
            dataString = dataString.substring(8);
        }
        e(context, "app_task_installed", dataString);
    }

    public static void u(Context context, String name) {
        q0.e(name);
        e(context, "author_bonus", name);
    }

    public static void v(Context context, String keyword) {
        e(context, "bonus_detail", keyword);
        H(context, "奖励详情页");
    }

    public static void w(Context context, String value) {
        e(context, "book_ad", value);
    }

    public static void x(Context context, String name) {
        e(context, "txs_account", name);
        H(context, name);
    }

    public static void y(Context context, String name) {
        e(context, "book_info", name);
        H(context, name);
    }

    public static void z(Context context, String name) {
        e(context, "book_sale", name);
    }
}
