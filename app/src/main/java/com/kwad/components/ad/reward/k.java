package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k extends com.kwad.components.core.l.g {
    private static String pX = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String pY = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a pW;

    /* renamed from: com.kwad.components.ad.reward.k$1 */
    final class AnonymousClass1 implements DialogInterface.OnKeyListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            return i2 == 4 && keyEvent.getAction() == 0;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$10 */
    static class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.gf();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$2 */
    static class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass2(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.J(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$3 */
    static class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass3(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.J(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$4 */
    static class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass4(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gh();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$5 */
    final class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ a pT;
        final /* synthetic */ k qc;

        AnonymousClass5(k kVar, a aVar) {
            kVar = kVar;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            kVar.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.J(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$6 */
    final class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ a pT;
        final /* synthetic */ k qc;

        AnonymousClass6(k kVar, a aVar) {
            kVar = kVar;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            kVar.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gh();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$7 */
    static class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass7(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar2 = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar2;
            if (aVar != null) {
                aVar.J(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$8 */
    static class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass8(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar2 = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar2;
            if (aVar != null) {
                aVar.gh();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$9 */
    static class AnonymousClass9 implements View.OnClickListener {
        final /* synthetic */ DialogFragment qa;
        final /* synthetic */ a qb;

        AnonymousClass9(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gh();
            }
        }
    }

    public interface a extends com.kwad.components.core.webview.a.d.c {
        void g(int i2, int i3);

        void gf();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.a.d.c
        public void J(boolean z) {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void fZ() {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void g(int i2, int i3) {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void gf() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gg() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gh() {
        }
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public com.kwad.components.ad.reward.i.a.a pw;
        public com.kwad.components.ad.reward.i.kwai.a px;
        public String qd;
        public String qe;
        public String qf;
        public String qg;
        public String qh;
        public String qi;
        public String qj;
        public String qk;
        public int style;
        public String title;

        private c() {
        }

        static c N(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qd = "关闭广告";
            cVar.qe = "继续观看";
            return cVar;
        }

        public static c O(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qd = "奖励不要了";
            cVar.qe = "返回";
            return cVar;
        }

        public static c P(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void Q(String str) {
            this.qk = str;
        }

        static c a(com.kwad.components.ad.reward.i.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.pw = aVar;
            cVar.qg = str;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.i.kwai.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.px = aVar;
            cVar.qg = str;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j2) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            cVar.qi = com.kwad.sdk.core.response.a.a.an(adInfo);
            String name = ct.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.a.a.ap(adInfo);
            }
            cVar.qh = ct.getIcon();
            cVar.Q(j2 > 0 ? String.valueOf(j2) : null);
            return cVar;
        }

        static c a(AdTemplate adTemplate, long j2) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(cb);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j2));
            cVar.qi = com.kwad.sdk.core.response.a.a.bK(cb);
            cVar.qj = com.kwad.sdk.core.response.a.a.an(cb);
            cVar.qd = "放弃奖励";
            cVar.qe = "继续观看";
            cVar.qf = com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c b(AdTemplate adTemplate, long j2) {
            AdMatrixInfo.MerchantLiveReservationInfo bI = com.kwad.sdk.core.response.a.b.bI(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.qh = bI.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j2));
            cVar.qi = bI.title;
            cVar.qd = "放弃奖励";
            cVar.qe = "继续观看";
            cVar.qf = com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c i(long j2) {
            c cVar = new c();
            cVar.style = 6;
            cVar.qd = "残忍离开";
            cVar.qe = "留下看看";
            cVar.Q(j2 > 0 ? String.valueOf(j2) : null);
            return cVar;
        }

        static c i(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            cVar.title = com.kwad.sdk.core.response.a.a.an(adInfo);
            cVar.qh = ct.getIcon();
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.pw == null) {
                    this.pw = new com.kwad.components.ad.reward.i.a.a();
                }
                this.pw.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.px == null) {
                    this.px = new com.kwad.components.ad.reward.i.kwai.a();
                }
                this.px.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.i.a.a aVar = this.pw;
            if (aVar != null) {
                t.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.i.kwai.a aVar2 = this.px;
            if (aVar2 != null) {
                t.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gi() {
            return TextUtils.isEmpty(this.qd) ? "关闭广告" : this.qd;
        }

        public final String gj() {
            return TextUtils.isEmpty(this.qe) ? "继续观看" : this.qe;
        }

        public final com.kwad.components.ad.reward.i.a.a gk() {
            return this.pw;
        }

        public final com.kwad.components.ad.reward.i.kwai.a gl() {
            return this.px;
        }

        public final String gm() {
            return this.qh;
        }

        public final String gn() {
            return this.qi;
        }

        public final String go() {
            return this.qj;
        }

        public final String gp() {
            return TextUtils.isEmpty(this.qk) ? "" : String.format("再看%s秒，可获得优惠", this.qk);
        }
    }

    public static c M(String str) {
        return c.O(str);
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.gi());
        textView2.setText(cVar.gj());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.3
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass3(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.4
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass4(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gk(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View a(com.kwad.components.ad.reward.i.a aVar, DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar2) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.i.a.a) {
            com.kwad.components.ad.reward.i.a.a.a((com.kwad.components.ad.reward.i.a.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.jk(), cVar.qg);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.gm(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.jl());
        String sb2 = sb.toString();
        String str = cVar.qg;
        boolean equals = "0".equals(str);
        String format = equals ? String.format(pX, sb2) : String.format(pY, str);
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            int i2 = equals ? indexOf + 1 : str.length() > 1 ? indexOf + 3 : indexOf + 2;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i2, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.7
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass7(DialogFragment dialogFragment2, a aVar22) {
                dialogFragment = dialogFragment2;
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.8
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass8(DialogFragment dialogFragment2, a aVar22) {
                dialogFragment = dialogFragment2;
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.gh();
                }
            }
        });
        return inflate;
    }

    private View a(k kVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(inflate.getContext(), cVar.qk));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.gi());
        textView2.setText(cVar.gj());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.5
            final /* synthetic */ a pT;
            final /* synthetic */ k qc;

            AnonymousClass5(k kVar2, a aVar2) {
                kVar = kVar2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.6
            final /* synthetic */ a pT;
            final /* synthetic */ k qc;

            AnonymousClass6(k kVar2, a aVar2) {
                kVar = kVar2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        return inflate;
    }

    public static c a(j jVar, @Nullable String str) {
        int i2;
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        com.kwad.components.ad.reward.i.a.a aVar = jVar.pw;
        com.kwad.components.ad.reward.i.kwai.a aVar2 = jVar.px;
        int i3 = jVar.py;
        boolean g2 = com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        int i4 = 0;
        if (g2 || com.kwad.sdk.core.response.a.d.p(adTemplate)) {
            int U = (int) com.kwad.sdk.core.response.a.a.U(cb);
            int F = com.kwad.sdk.core.response.a.a.F(cb);
            if (U > F) {
                U = F;
            }
            long playDuration = jVar.oN.getPlayDuration();
            if (playDuration < (U * 1000) - 800 && (i2 = (int) (U - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i4 = i2;
            }
        }
        return (!g2 || aVar == null) ? (!com.kwad.sdk.core.response.a.d.p(adTemplate) || aVar2 == null) ? com.kwad.components.ad.reward.kwai.b.j(cb) ? c.i(cb) : (com.kwad.sdk.core.response.a.a.ck(cb) && com.kwad.components.ad.reward.kwai.b.gG() == 1) ? c.a(cb, i3) : com.kwad.sdk.core.response.a.a.bJ(cb) ? c.O(str) : com.kwad.sdk.core.response.a.a.cq(cb) ? c.a(adTemplate, i3) : com.kwad.sdk.core.response.a.a.aI(adTemplate) ? c.b(adTemplate, i3) : com.kwad.components.ad.reward.kwai.b.gA() == 1 ? c.i(i3) : c.N(str) : c.a(aVar2, adTemplate, String.valueOf(i4)) : c.a(aVar, adTemplate, String.valueOf(i4));
    }

    public static k a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        kVar.setArguments(bundle);
        kVar.a(aVar);
        kVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return kVar;
    }

    private void a(a aVar) {
        this.pW = aVar;
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gl(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.qh, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.9
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass9(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.10
            AnonymousClass10() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.gf();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.2
            final /* synthetic */ DialogFragment qa;
            final /* synthetic */ a qb;

            AnonymousClass2(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        int i2 = R.color.ksad_reward_main_color;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.kwai.a.getColor(context, i2));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.kwai.a.getColor(context, i2));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    @Override // com.kwad.components.core.l.g
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a2;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c P = c.P(string);
        int style = P.getStyle();
        if (style == 1) {
            a2 = a(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
        } else if (style == 2) {
            a2 = b(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
        } else if (style == 4) {
            a2 = c(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
            com.kwad.components.core.r.g.a(new com.kwad.components.core.widget.e(), (ViewGroup) a2);
        } else if (style == 5) {
            com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i(this, this.mAdTemplate, layoutInflater, viewGroup, this.pW);
            iVar.a(P);
            a2 = iVar.gK();
        } else if (style == 6) {
            a2 = a(this, layoutInflater, viewGroup, P, this.pW);
        } else if (style != 8) {
            a2 = a((DialogFragment) this, layoutInflater, viewGroup, P, this.pW);
        } else {
            com.kwad.components.ad.reward.k.l lVar = new com.kwad.components.ad.reward.k.l(this, this.mAdTemplate, layoutInflater, viewGroup, this.pW);
            lVar.a(P);
            a2 = lVar.gK();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.k.1
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return a2;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.pW;
        if (aVar != null) {
            aVar.fZ();
        }
    }
}
