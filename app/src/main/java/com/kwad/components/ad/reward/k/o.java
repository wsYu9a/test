package com.kwad.components.ad.reward.k;

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

/* loaded from: classes.dex */
public final class o extends w implements View.OnClickListener {
    private com.kwad.components.ad.reward.j qt;
    private ImageView zr;
    private TextView zs;
    private TextView zt;
    private TextView zu;
    private TextView zv;
    private TextView zw;
    private TextView zx;
    private TextView zy;

    public o(com.kwad.components.ad.reward.j jVar) {
        this.qt = jVar;
    }

    private void bindView(AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        KSImageLoader.loadCircleIcon(this.zr, com.kwad.sdk.core.response.a.a.bM(cb), this.zr.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.zs.setText(com.kwad.sdk.core.response.a.a.bK(cb));
    }

    private void initView() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup == null) {
            return;
        }
        this.zr = (ImageView) viewGroup.findViewById(R.id.ksad_live_end_page_author_icon);
        this.zs = (TextView) this.sn.findViewById(R.id.ksad_author_name_txt);
        this.zt = (TextView) this.sn.findViewById(R.id.ksad_live_end_detail_watch_person_count);
        this.zu = (TextView) this.sn.findViewById(R.id.ksad_live_end_detail_like_person_count);
        this.zv = (TextView) this.sn.findViewById(R.id.ksad_live_end_detail_watch_time);
        this.zw = (TextView) this.sn.findViewById(R.id.ksad_live_end_bottom_title);
        this.zx = (TextView) this.sn.findViewById(R.id.ksad_live_end_bottom_action_btn);
        this.zy = (TextView) this.sn.findViewById(R.id.ksad_live_end_bottom_des_btn);
        this.zx.setOnClickListener(this);
        this.zy.setOnClickListener(this);
    }

    private static String l(long j2) {
        long j3 = j2 / 3600000;
        long j4 = (j2 / 60000) - (j3 * 60);
        long j5 = ((j2 / 1000) - (60 * j4)) - (3600 * j3);
        return j3 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)) : String.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j5));
    }

    public final void W(int i2) {
        TextView textView = this.zw;
        if (textView == null || i2 <= 0) {
            return;
        }
        if (!this.qt.pf) {
            textView.setText("已获得奖励");
            return;
        }
        String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i2));
        SpannableString spannableString = new SpannableString(format);
        int color = gK().getResources().getColor(R.color.ksad_reward_main_color);
        spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        int length = format.length();
        spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
        this.zw.setText(spannableString);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.kwad.components.ad.reward.j jVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j2) {
        String str;
        TextView textView;
        this.zu.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.zv.setText(l(adLivePushEndInfo.mLiveDuration));
        this.zt.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (jVar.pf) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.a.a.X(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) - j2, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = gK().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            textView = this.zw;
            str = spannableString;
        } else {
            textView = this.zw;
            str = "内容很精彩，不要错过哦";
        }
        textView.setText(str);
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        bindView(vVar.getAdTemplate());
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
        iVar.bp(24);
        if (view.equals(this.zx)) {
            this.qt.a(2, view.getContext(), 38, 1, 0L, false, iVar);
        } else if (view.equals(this.zy)) {
            this.qt.a(2, view.getContext(), 37, 1, 0L, false, iVar);
        }
    }
}
