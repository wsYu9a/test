package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.ActiveWrapper;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.StrategyWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a */
    static String[] f6562a = {"/home"};

    /* renamed from: b */
    static String[] f6563b = {Launcher.Path.MALL, "/home"};

    /* renamed from: c */
    static String[] f6564c = {"/home", Launcher.Path.MALL, Launcher.Path.VIP, "/dt", Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, "/web", Launcher.Path.ONLINE_SERVICE, Launcher.Path.GIFTS};

    /* renamed from: d */
    static String[] f6565d = {"/home", Launcher.Path.MALL, Launcher.Path.VIP, "/dt", Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, "/web", Launcher.Path.FORUM_POSTS_DT, Launcher.Path.GIFTS, Launcher.Path.COIN_TICKET, Launcher.Path.GAME_GIFTS, Launcher.Path.ACTIVITIES, Launcher.Path.GAME_ACTIVITIES, Launcher.Path.FORUM_BOARD_DT};

    public static boolean a(Context context, String str) {
        float a2 = x.a(context);
        if (a2 >= 2.1f) {
            for (String str2 : f6565d) {
                if (!str2.equals(str)) {
                }
            }
            return false;
        }
        if (a2 >= 2.0f) {
            for (String str3 : f6564c) {
                if (!str3.equals(str)) {
                }
            }
            return false;
        }
        if (a2 >= 1.2f || Math.abs(a2 - 1.2f) < 1.0E-6d) {
            for (String str4 : f6563b) {
                if (!str4.equals(str)) {
                }
            }
            return false;
        }
        if (a2 <= 0.0f) {
            return false;
        }
        for (String str5 : f6562a) {
            if (!str5.equals(str)) {
            }
        }
        return false;
        return true;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }

    private static boolean b(Context context, Map<String, Object> map) {
        BaseWrapper wrapper = BaseWrapper.wrapper(map);
        if (wrapper.getPath().equals("/home")) {
            return w.a(context, wrapper.getEnterId());
        }
        if (wrapper.getPath().equals("/dt")) {
            return w.a(context, ResourceWrapper.wrapper(map).getId(), wrapper.getEnterId());
        }
        if (wrapper.getPath().equals(Launcher.Path.GAME_GIFT_BAG)) {
            ActiveWrapper wrapper2 = ActiveWrapper.wrapper(map);
            int activeCode = wrapper2.getActiveCode();
            long id = wrapper2.getId();
            String str = "actCode=giftbag" + activeCode + "&actPage=GIFT_BAG_DETAIL#/actDetail";
            String enterId = wrapper.getEnterId();
            return id > 0 ? w.a(context, str, id, enterId) : w.a(context, str, enterId);
        }
        if (wrapper.getPath().equals(Launcher.Path.GAME_ACTIVE)) {
            ActiveWrapper wrapper3 = ActiveWrapper.wrapper(map);
            int activeCode2 = wrapper3.getActiveCode();
            long id2 = wrapper3.getId();
            String str2 = "actCode=activity" + activeCode2 + "&actPage=ACTIVITY_DETAIL#/actDetail";
            String enterId2 = wrapper.getEnterId();
            return id2 > 0 ? w.b(context, str2, id2, enterId2) : w.b(context, str2, enterId2);
        }
        if (wrapper.getPath().equals(Launcher.Path.TOPIC)) {
            return w.b(context, IDWrapper.wrapper(map).getId(), wrapper.getEnterId());
        }
        if (wrapper.getPath().equals(Launcher.Path.STRATEGY)) {
            StrategyWrapper wrapper4 = StrategyWrapper.wrapper(map);
            wrapper4.setTab(1);
            return w.c(context, wrapper4.getId(), wrapper.getEnterId());
        }
        if (wrapper.getPath().equals("/point")) {
            return w.b(context, wrapper.getEnterId());
        }
        if (wrapper.getPath().equals(Launcher.Path.MALL)) {
            return w.c(context, wrapper.getEnterId());
        }
        if (!wrapper.getPath().equals(Launcher.Path.ONLINE_SERVICE)) {
            wrapper.getPath().equals("/web");
        }
        return false;
    }
}
