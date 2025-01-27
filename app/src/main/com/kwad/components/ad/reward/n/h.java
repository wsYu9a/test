package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class h extends s implements View.OnClickListener {
    protected KsConvertButton Ac;
    protected TextView Ad;

    @Nullable
    protected TextView Ae;

    @Nullable
    protected TextView Af;
    protected a Ag;

    @LayoutRes
    protected int Ah = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Ai = true;

    @Nullable
    protected KsLogoView mLogoView;
    protected ImageView zH;

    @Nullable
    protected KsAppTagsView zL;

    public interface a {
        void iu();

        void iv();

        void iw();

        void ix();

        void iy();

        void iz();
    }

    private void T(int i10) {
        KsConvertButton ksConvertButton = this.Ac;
        if (ksConvertButton == null) {
            return;
        }
        if (i10 == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i10 == 2) {
            ksConvertButton.getCornerConf().ci(false).cl(false).ck(true).cj(true);
        }
        this.Ac.postInvalidate();
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.zH = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.Ad = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.zL = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.Ae = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.Af = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.Ac = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int kp() {
        return R.id.ksad_common_app_card_root;
    }

    public final void a(a aVar) {
        this.Ag = aVar;
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, it(), kp());
        g(this.f11741uc);
        ViewGroup viewGroup2 = this.f11741uc;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.Ac.setOnClickListener(this);
            this.zH.setOnClickListener(this);
            this.Ad.setOnClickListener(this);
            TextView textView = this.Ae;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.Af;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.zL;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    public int it() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.Ac)) {
            a aVar2 = this.Ag;
            if (aVar2 != null) {
                aVar2.iu();
                return;
            }
            return;
        }
        if (view.equals(this.zH)) {
            a aVar3 = this.Ag;
            if (aVar3 != null) {
                aVar3.iv();
                return;
            }
            return;
        }
        if (view.equals(this.Ad)) {
            a aVar4 = this.Ag;
            if (aVar4 != null) {
                aVar4.iw();
                return;
            }
            return;
        }
        if (view.equals(this.Ae) || view.equals(this.Af)) {
            a aVar5 = this.Ag;
            if (aVar5 != null) {
                aVar5.ix();
                return;
            }
            return;
        }
        if (view.equals(this.zL)) {
            a aVar6 = this.Ag;
            if (aVar6 != null) {
                aVar6.iy();
                return;
            }
            return;
        }
        if (!view.equals(this.f11741uc) || (aVar = this.Ag) == null) {
            return;
        }
        aVar.iz();
    }

    public final void show() {
        ViewGroup viewGroup = this.f11741uc;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Ai));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.hx()
            r5.T(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.ht()
            r0.aK(r1)
        L15:
            android.widget.TextView r0 = r5.Ad
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.Ae
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.gA()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.Af
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L5c
            java.lang.String r3 = r6.gA()
            r0.setText(r3)
            java.lang.String r0 = r6.gA()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L46
            r0 = 8
        L43:
            r3 = 8
            goto L52
        L46:
            boolean r0 = r6.hw()
            if (r0 == 0) goto L50
            r0 = 8
            r3 = 0
            goto L52
        L50:
            r0 = 0
            goto L43
        L52:
            android.widget.TextView r4 = r5.Ae
            if (r4 == 0) goto L59
            r4.setVisibility(r0)
        L59:
            android.widget.TextView r0 = r5.Af
            goto L6e
        L5c:
            android.widget.TextView r0 = r5.Ae
            if (r0 == 0) goto L71
            java.lang.String r3 = r6.gA()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L6d
            r3 = 8
            goto L6e
        L6d:
            r3 = 0
        L6e:
            r0.setVisibility(r3)
        L71:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.zL
            if (r0 == 0) goto L8b
            java.util.List r3 = r6.hv()
            int r4 = r5.Ah
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.zL
            boolean r3 = r6.hw()
            if (r3 == 0) goto L88
            r1 = 8
        L88:
            r0.setVisibility(r1)
        L8b:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.Ac
            if (r0 == 0) goto L9a
            com.kwad.components.core.e.d.c r1 = r6.hu()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.ht()
            r0.a(r1, r2)
        L9a:
            android.widget.ImageView r0 = r5.zH
            java.lang.String r1 = r6.gz()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.ht()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }
}
