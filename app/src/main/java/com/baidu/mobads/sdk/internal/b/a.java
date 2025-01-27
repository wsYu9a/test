package com.baidu.mobads.sdk.internal.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements IOAdEventListener {

    /* renamed from: com.baidu.mobads.sdk.internal.b.a$a */
    public static class C0220a {
        public static final String A = "ic_gray_unlike";
        public static final String B = "ic_white_ad_logo_gray_bg";
        public static final String C = "ic_white_bqt_logo_gray_bg";
        public static final String D = "ic_white_shake_gesture";
        public static final String E = "ic_arrow_up";
        public static final String F = "ic_blue_no_ad";
        public static final String G = "ic_fallback_gray";
        public static final String H = "ic_gift_box";
        public static final String I = "ic_gift_ribbon";
        public static final String J = "ic_gold_star";
        public static final String K = "ic_gray_left_quot";
        public static final String L = "ic_gray_right_quot";
        public static final String M = "ic_gray_star";
        public static final String N = "ic_half_gold_star";
        public static final String O = "ic_orange_cross";
        public static final String P = "ic_twist_phone";
        public static final String Q = "ic_white_answer_error";
        public static final String R = "ic_white_answer_right";
        public static final String S = "ic_white_ad_logo";
        public static final String T = "ic_white_cross_in_circle";
        public static final String U = "ic_black_arrow_left";
        public static final String V = "ic_black_three_points";
        public static final String W = "ic_gray_ad";
        public static final String X = "ic_gray_ad_logo";
        public static final String Y = "ic_gray_bqt_logo";
        public static final String Z = "ic_gray_cross_black_round";

        /* renamed from: a */
        public static final String f6817a = "rsp_big_red_heart";
        public static final String aA = "ic_yellow_dl_black_bg";
        public static final String aB = "ic_yellow_lp_black_bg";

        /* renamed from: aa */
        public static final String f6818aa = "ic_gray_cross_white_oval";

        /* renamed from: ab */
        public static final String f6819ab = "ic_gray_logo";

        /* renamed from: ac */
        public static final String f6820ac = "ic_slide_arrow_duplicate";

        /* renamed from: ad */
        public static final String f6821ad = "ic_slide_arrow_point";

        /* renamed from: ae */
        public static final String f6822ae = "ic_white_ad_gray_bg";

        /* renamed from: af */
        public static final String f6823af = "ic_white_arrow_left";

        /* renamed from: ag */
        public static final String f6824ag = "ic_white_arrow_right";

        /* renamed from: ah */
        public static final String f6825ah = "ic_white_bqt_gray_bg";

        /* renamed from: ai */
        public static final String f6826ai = "ic_white_bqt_logo";

        /* renamed from: aj */
        public static final String f6827aj = "ic_white_comments";

        /* renamed from: ak */
        public static final String f6828ak = "ic_white_cross_circle_shadow";
        public static final String al = "ic_white_finger_shadow";
        public static final String am = "ic_white_logo";
        public static final String an = "ic_white_logo_gray_bg";
        public static final String ao = "ic_white_replay";
        public static final String ap = "ic_white_replay_gray_round";
        public static final String aq = "ic_white_speed075";
        public static final String ar = "ic_white_speed100";
        public static final String as = "ic_white_speed125";
        public static final String at = "ic_white_speed150";
        public static final String au = "ic_white_speed175";
        public static final String av = "ic_white_speed200";
        public static final String aw = "ic_white_three_points";
        public static final String ax = "ic_white_voice";
        public static final String ay = "ic_white_voice_mute";
        public static final String az = "ic_white_pause_gray_round";

        /* renamed from: b */
        public static final String f6829b = "rsp_small_red_heart";

        /* renamed from: c */
        public static final String f6830c = "bg_blur_white";

        /* renamed from: d */
        public static final String f6831d = "bg_app_icon";

        /* renamed from: e */
        public static final String f6832e = "bg_hot_recommendation";

        /* renamed from: f */
        public static final String f6833f = "bg_black_round_rectangle";

        /* renamed from: g */
        public static final String f6834g = "ic_video_play";

        /* renamed from: h */
        public static final String f6835h = "ic_stars";

        /* renamed from: i */
        public static final String f6836i = "ic_fallback";

        /* renamed from: j */
        public static final String f6837j = "ic_guide_circle";

        /* renamed from: k */
        public static final String f6838k = "ic_guide_finger";

        /* renamed from: l */
        public static final String f6839l = "ic_white_play";

        /* renamed from: m */
        public static final String f6840m = "ic_white_pause";

        /* renamed from: n */
        public static final String f6841n = "ic_white_apo";

        /* renamed from: o */
        public static final String f6842o = "ic_white_dl";

        /* renamed from: p */
        public static final String f6843p = "ic_white_link";

        /* renamed from: q */
        public static final String f6844q = "ic_white_fullscreen_shrink";

        /* renamed from: r */
        public static final String f6845r = "ic_white_fullscreen_stretch";

        /* renamed from: s */
        public static final String f6846s = "ic_black_cross";

        /* renamed from: t */
        public static final String f6847t = "ic_white_cross_dark_round";

        /* renamed from: u */
        public static final String f6848u = "ic_gray_cross";

        /* renamed from: v */
        public static final String f6849v = "ic_light_gray_cross";

        /* renamed from: w */
        public static final String f6850w = "ic_white_cross";

        /* renamed from: x */
        public static final String f6851x = "ic_gray_complaints";

        /* renamed from: y */
        public static final String f6852y = "ic_gray_low_quality";

        /* renamed from: z */
        public static final String f6853z = "ic_gray_repeat";
    }

    private Integer a(String str) {
        if (C0220a.f6830c.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if (C0220a.f6831d.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_app_icon);
        }
        if (C0220a.f6832e.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_hot_recommendation);
        }
        if (C0220a.f6833f.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_black_round_rectangle);
        }
        if (C0220a.f6834g.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_video_play);
        }
        if (C0220a.f6835h.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_stars);
        }
        if (C0220a.f6836i.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback);
        }
        if (C0220a.f6837j.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_circle);
        }
        if (C0220a.f6838k.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_finger);
        }
        if (C0220a.f6839l.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_play);
        }
        if (C0220a.f6840m.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause);
        }
        if (C0220a.f6841n.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_apo);
        }
        if (C0220a.f6842o.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_dl);
        }
        if (C0220a.f6843p.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_link);
        }
        if (C0220a.f6844q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_shrink);
        }
        if (C0220a.f6845r.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_stretch);
        }
        if (C0220a.f6846s.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_cross);
        }
        if (C0220a.f6847t.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_dark_round);
        }
        if (C0220a.f6817a.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if (C0220a.f6829b.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if (C0220a.f6848u.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross);
        }
        if (C0220a.f6849v.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_light_gray_cross);
        }
        if (C0220a.f6850w.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross);
        }
        if (C0220a.f6851x.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_complaints);
        }
        if (C0220a.f6852y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_low_quality);
        }
        if (C0220a.f6853z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_repeat);
        }
        if (C0220a.A.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_unlike);
        }
        if (C0220a.B.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo_gray_bg);
        }
        if (C0220a.C.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo_gray_bg);
        }
        if (C0220a.D.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_shake_gesture);
        }
        if (C0220a.E.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_arrow_up);
        }
        if (C0220a.F.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_blue_no_ad);
        }
        if (C0220a.G.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback_gray);
        }
        if (C0220a.H.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_box);
        }
        if (C0220a.I.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_ribbon);
        }
        if (C0220a.J.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gold_star);
        }
        if (C0220a.K.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_left_quot);
        }
        if (C0220a.L.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_right_quot);
        }
        if (C0220a.M.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_star);
        }
        if (C0220a.N.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_half_gold_star);
        }
        if (C0220a.O.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_orange_cross);
        }
        if (C0220a.P.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_twist_phone);
        }
        if (C0220a.S.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo);
        }
        if (C0220a.Q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_error);
        }
        if (C0220a.R.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_right);
        }
        if (C0220a.T.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_in_circle);
        }
        if (C0220a.U.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_arrow_left);
        }
        if (C0220a.V.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_three_points);
        }
        if (C0220a.W.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad);
        }
        if (C0220a.X.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad_logo);
        }
        if (C0220a.Y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_bqt_logo);
        }
        if (C0220a.Z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_black_round);
        }
        if (C0220a.f6818aa.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_white_oval);
        }
        if (C0220a.f6819ab.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_logo);
        }
        if (C0220a.f6820ac.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_duplicate);
        }
        if (C0220a.f6821ad.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_point);
        }
        if (C0220a.f6822ae.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_gray_bg);
        }
        if (C0220a.f6823af.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_left);
        }
        if (C0220a.f6824ag.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_right);
        }
        if (C0220a.f6825ah.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_gray_bg);
        }
        if (C0220a.f6826ai.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo);
        }
        if (C0220a.f6827aj.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_comments);
        }
        if (C0220a.f6828ak.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_circle_shadow);
        }
        if (C0220a.al.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_finger_shadow);
        }
        if (C0220a.am.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo);
        }
        if (C0220a.an.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo_gray_bg);
        }
        if (C0220a.az.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause_gray_round);
        }
        if (C0220a.ao.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay);
        }
        if (C0220a.ap.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay_gray_round);
        }
        if (C0220a.aq.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed075);
        }
        if (C0220a.ar.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed100);
        }
        if (C0220a.as.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed125);
        }
        if (C0220a.at.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed150);
        }
        if (C0220a.au.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed175);
        }
        if (C0220a.av.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed200);
        }
        if (C0220a.aw.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_three_points);
        }
        if (C0220a.ax.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice);
        }
        if (C0220a.ay.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice_mute);
        }
        if (C0220a.aA.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_dl_black_bg);
        }
        if (C0220a.aB.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_lp_black_bg);
        }
        return null;
    }

    private Integer b(String str) {
        return null;
    }

    private Integer c(String str) {
        return null;
    }

    private Integer d(String str) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            String type = iOAdEvent.getType();
            Map<String, Object> data = iOAdEvent.getData();
            String str = (String) data.get("name");
            data.put("id", "drawable".equals(type) ? a(str) : "layout".equals(type) ? b(str) : TypedValues.Custom.S_STRING.equals(type) ? c(str) : "style".equals(type) ? d(str) : null);
        }
    }
}
