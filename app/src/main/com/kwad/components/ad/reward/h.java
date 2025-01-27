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
import com.kwad.sdk.utils.x;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String ro = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String rp = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a rn;

    /* renamed from: com.kwad.components.ad.reward.h$1 */
    public class AnonymousClass1 implements DialogInterface.OnKeyListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            return i10 == 4 && keyEvent.getAction() == 0;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$10 */
    public class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.gs();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass2(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.G(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass3(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.G(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$4 */
    public class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass4(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gu();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$5 */
    public class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ a rm;
        final /* synthetic */ h rt;

        public AnonymousClass5(h hVar, a aVar) {
            hVar = hVar;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            hVar.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.G(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$6 */
    public class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ a rm;
        final /* synthetic */ h rt;

        public AnonymousClass6(h hVar, a aVar) {
            hVar = hVar;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            hVar.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gu();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$7 */
    public class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass7(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar2 = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar2;
            if (aVar != null) {
                aVar.G(false);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$8 */
    public class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass8(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar2 = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar2;
            if (aVar != null) {
                aVar.gu();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.h$9 */
    public class AnonymousClass9 implements View.OnClickListener {
        final /* synthetic */ DialogFragment rr;
        final /* synthetic */ a rs;

        public AnonymousClass9(DialogFragment dialogFragment, a aVar) {
            dialogFragment = dialogFragment;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            dialogFragment.dismiss();
            a aVar = aVar;
            if (aVar != null) {
                aVar.gu();
            }
        }
    }

    public interface a extends com.kwad.components.core.webview.tachikoma.e.c {
        void g(int i10, int i11);

        void gs();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void G(boolean z10) {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void g(int i10, int i11) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void gl() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void gs() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void gt() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void gu() {
        }
    }

    public static c a(g gVar, @Nullable String str) {
        int i10;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.qO;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.qP;
        int i11 = gVar.qQ;
        boolean k10 = com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        int i12 = 0;
        if (k10 || com.kwad.sdk.core.response.b.e.J(adTemplate)) {
            int ad2 = (int) com.kwad.sdk.core.response.b.a.ad(eb2);
            int L = com.kwad.sdk.core.response.b.a.L(eb2);
            if (ad2 > L) {
                ad2 = L;
            }
            long playDuration = gVar.f11689qf.getPlayDuration();
            if (playDuration < (ad2 * 1000) - 800 && (i10 = (int) (ad2 - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i12 = i10;
            }
        }
        return (!k10 || aVar == null) ? (!com.kwad.sdk.core.response.b.e.J(adTemplate) || aVar2 == null) ? com.kwad.components.ad.reward.a.b.i(eb2) ? c.h(eb2) : (com.kwad.sdk.core.response.b.a.ci(eb2) == 1 && com.kwad.components.ad.reward.a.b.gU() == 1) ? c.a(eb2, i11) : adTemplate.isNativeRewardPreview ? c.h(str, i11) : com.kwad.sdk.core.response.b.a.cS(eb2) ? c.b(adTemplate, i11) : com.kwad.sdk.core.response.b.a.cj(adTemplate) ? c.c(adTemplate, i11) : com.kwad.components.ad.reward.a.b.gO() == 1 ? c.j(i11) : c.A(str) : c.a(aVar2, adTemplate, String.valueOf(i12)) : c.a(aVar, adTemplate, String.valueOf(i12));
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gy(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.ry, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass9(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gu();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            public AnonymousClass10() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.gs();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass2(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    public static c g(String str, int i10) {
        return c.h(str, i10);
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
        a aVar = this.rn;
        if (aVar != null) {
            aVar.gl();
        }
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public com.kwad.components.ad.reward.l.b.a qO;
        public com.kwad.components.ad.reward.l.a.a qP;
        public String rA;
        public String rB;
        public String ru;
        public String rv;
        public String rw;

        /* renamed from: rx */
        public String f11716rx;
        public String ry;
        public String rz;
        public int style;
        public String title;

        private c() {
        }

        public static c A(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.ru = "关闭广告";
            cVar.rv = "继续观看";
            return cVar;
        }

        public static c B(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void C(String str) {
            this.rB = str;
        }

        public static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.qO = aVar;
            cVar.f11716rx = str;
            cVar.ry = com.kwad.sdk.core.response.b.a.cm(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            return cVar;
        }

        public static c b(AdTemplate adTemplate, long j10) {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.ry = com.kwad.sdk.core.response.b.a.cm(eb2);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j10));
            cVar.rz = com.kwad.sdk.core.response.b.a.cj(eb2);
            cVar.rA = com.kwad.sdk.core.response.b.a.au(eb2);
            cVar.ru = "放弃奖励";
            cVar.rv = "继续观看";
            cVar.rw = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            return cVar;
        }

        public static c c(AdTemplate adTemplate, long j10) {
            AdMatrixInfo.MerchantLiveReservationInfo dk2 = com.kwad.sdk.core.response.b.b.dk(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.ry = dk2.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j10));
            cVar.rz = dk2.title;
            cVar.ru = "放弃奖励";
            cVar.rv = "继续观看";
            cVar.rw = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            return cVar;
        }

        public static c h(String str, int i10) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.ru = "残忍离开";
            cVar.rv = "留下看看";
            if (i10 > 0) {
                cVar.rB = String.valueOf(i10);
            }
            return cVar;
        }

        public static c j(long j10) {
            c cVar = new c();
            cVar.style = 6;
            cVar.ru = "残忍离开";
            cVar.rv = "留下看看";
            if (j10 > 0) {
                cVar.C(String.valueOf(j10));
            } else {
                cVar.C(null);
            }
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.qO == null) {
                    this.qO = new com.kwad.components.ad.reward.l.b.a();
                }
                this.qO.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.qP == null) {
                    this.qP = new com.kwad.components.ad.reward.l.a.a();
                }
                this.qP.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.qO;
            if (aVar != null) {
                x.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.qP;
            if (aVar2 != null) {
                x.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final String gA() {
            return this.rz;
        }

        public final String gB() {
            return this.rA;
        }

        public final String gC() {
            return TextUtils.isEmpty(this.rB) ? "" : String.format("再看%s秒，可获得优惠", this.rB);
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gv() {
            return TextUtils.isEmpty(this.ru) ? "关闭广告" : this.ru;
        }

        public final String gw() {
            return TextUtils.isEmpty(this.rv) ? "继续观看" : this.rv;
        }

        public final com.kwad.components.ad.reward.l.b.a gx() {
            return this.qO;
        }

        public final com.kwad.components.ad.reward.l.a.a gy() {
            return this.qP;
        }

        public final String gz() {
            return this.ry;
        }

        public static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.qP = aVar;
            cVar.f11716rx = str;
            cVar.ry = com.kwad.sdk.core.response.b.a.cm(com.kwad.sdk.core.response.b.e.eb(adTemplate));
            return cVar;
        }

        public static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.au(adInfo);
            cVar.ry = cW.getIcon();
            return cVar;
        }

        public static c a(AdInfo adInfo, long j10) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            cVar.rz = com.kwad.sdk.core.response.b.a.au(adInfo);
            String name = cW.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ax(adInfo);
            }
            cVar.ry = cW.getIcon();
            if (j10 > 0) {
                cVar.C(String.valueOf(j10));
            } else {
                cVar.C(null);
            }
            return cVar;
        }
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.rn = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a10;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c B = c.B(string);
        int style = B.getStyle();
        if (style == 1) {
            a10 = a(this, layoutInflater, viewGroup, B, this.mAdTemplate, this.rn);
        } else if (style == 2) {
            a10 = b(this, layoutInflater, viewGroup, B, this.mAdTemplate, this.rn);
        } else if (style == 4) {
            a10 = c(this, layoutInflater, viewGroup, B, this.mAdTemplate, this.rn);
            com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), (ViewGroup) a10);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.rn);
            jVar.a(B);
            a10 = jVar.ha();
        } else if (style == 6) {
            a10 = a(this, layoutInflater, viewGroup, B, this.rn);
        } else if (style != 8) {
            a10 = a((DialogFragment) this, layoutInflater, viewGroup, B, this.rn);
        } else {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.rn);
            mVar.a(B);
            a10 = mVar.ha();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return i10 == 4 && keyEvent.getAction() == 0;
            }
        });
        return a10;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.gv());
        textView2.setText(cVar.gw());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass3(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass4(DialogFragment dialogFragment2, a aVar2) {
                dialogFragment = dialogFragment2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gu();
                }
            }
        });
        return inflate;
    }

    private View a(h hVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(inflate.getContext(), cVar.rB));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.gv());
        textView2.setText(cVar.gw());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            final /* synthetic */ a rm;
            final /* synthetic */ h rt;

            public AnonymousClass5(h hVar2, a aVar2) {
                hVar = hVar2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            final /* synthetic */ a rm;
            final /* synthetic */ h rt;

            public AnonymousClass6(h hVar2, a aVar2) {
                hVar = hVar2;
                aVar = aVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gu();
                }
            }
        });
        return inflate;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar2) {
        String format;
        int i10;
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.jL(), cVar.f11716rx);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.gz(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.jM());
        String sb3 = sb2.toString();
        String str = cVar.f11716rx;
        boolean equals = "0".equals(str);
        if (equals) {
            format = String.format(ro, sb3);
        } else {
            format = String.format(rp, str);
        }
        int indexOf = equals ? format.indexOf(sb3) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i10 = 1 + indexOf;
            } else {
                i10 = str.length() > 1 ? indexOf + 3 : indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i10, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass7(DialogFragment dialogFragment2, a aVar22) {
                dialogFragment = dialogFragment2;
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            final /* synthetic */ DialogFragment rr;
            final /* synthetic */ a rs;

            public AnonymousClass8(DialogFragment dialogFragment2, a aVar22) {
                dialogFragment = dialogFragment2;
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.gu();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gx(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }
}
