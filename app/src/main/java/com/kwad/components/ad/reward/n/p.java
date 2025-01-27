package com.kwad.components.ad.reward.n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class p extends s implements View.OnClickListener {
    private TextView BA;
    private TextView BB;
    private TextView BC;
    private TextView BD;
    private ImageView Bw;
    private TextView Bx;
    private TextView By;
    private TextView Bz;
    private com.kwad.components.ad.reward.g rO;

    public p(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
    }

    private void f(AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        KSImageLoader.loadCircleIcon(this.Bw, com.kwad.sdk.core.response.b.a.cm(eb2), this.Bw.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.Bx.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
    }

    private void initView() {
        if (this.f11741uc == null) {
            return;
        }
        if (this.rO.mContext.getResources().getConfiguration().orientation == 2) {
            this.Bw = (ImageView) this.f11741uc.findViewById(R.id.ksad_live_end_page_author_icon_landscape);
            this.Bx = (TextView) this.f11741uc.findViewById(R.id.ksad_author_name_txt_landscape);
            this.By = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_watch_person_count_landscape);
            this.Bz = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_like_person_count_landscape);
            this.BA = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_watch_time_landscape);
            this.BB = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_title_landscape);
            this.BC = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_action_btn_landscape);
            this.BD = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_des_btn_landscape);
        } else {
            this.Bw = (ImageView) this.f11741uc.findViewById(R.id.ksad_live_end_page_author_icon);
            this.Bx = (TextView) this.f11741uc.findViewById(R.id.ksad_author_name_txt);
            this.By = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_watch_person_count);
            this.Bz = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_like_person_count);
            this.BA = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_detail_watch_time);
            this.BB = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_title);
            this.BC = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_action_btn);
            this.BD = (TextView) this.f11741uc.findViewById(R.id.ksad_live_end_bottom_des_btn);
        }
        this.BC.setOnClickListener(this);
        this.BD.setOnClickListener(this);
    }

    private static String m(long j10) {
        long j11 = (j10 / 3600000) % 24;
        long j12 = (j10 / 60000) % 60;
        long j13 = (j10 / 1000) % 60;
        return j11 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13)) : String.format("%02d:%02d", Long.valueOf(j12), Long.valueOf(j13));
    }

    public final void U(int i10) {
        TextView textView = this.BB;
        if (textView != null) {
            if (i10 <= 0) {
                textView.setText("已获得奖励");
                return;
            }
            if (!this.rO.qu) {
                textView.setText("已获得奖励");
                return;
            }
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i10));
            SpannableString spannableString = new SpannableString(format);
            int color = ha().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.BB.setText(spannableString);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        f(rVar.getAdTemplate());
    }

    public final void h(ViewGroup viewGroup) {
        if (this.rO.mContext.getResources().getConfiguration().orientation == 2) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub_landscape, R.id.ksad_live_end_page_layout_root_landscape);
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        }
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.cU(24);
        if (view.equals(this.BC)) {
            this.rO.a(2, view.getContext(), 38, 1, 0L, false, bVar);
        } else if (view.equals(this.BD)) {
            this.rO.a(2, view.getContext(), 37, 1, 0L, false, bVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j10) {
        this.Bz.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.BA.setText(m(adLivePushEndInfo.mLiveDuration));
        this.By.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.qu) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate)) - j10, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = ha().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.BB.setText(spannableString);
            return;
        }
        this.BB.setText("内容很精彩，不要错过哦");
    }
}
