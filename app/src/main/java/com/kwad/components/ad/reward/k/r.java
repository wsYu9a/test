package com.kwad.components.ad.reward.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes.dex */
public class r extends w implements View.OnClickListener {
    protected KsLogoView mLogoView;
    protected ImageView xJ;

    @Nullable
    protected KsAppTagsView xN;
    protected TextView yY;
    protected KSCornerButton zK;
    protected KsConvertButton zL;
    protected View zM;
    protected TextView zN;

    @Nullable
    protected TextView zO;
    protected a zP;

    @LayoutRes
    protected int zQ = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean zR = true;

    public interface a {
        void hV();

        void hW();

        void hX();

        void hY();
    }

    private void X(int i2) {
        KSCornerButton kSCornerButton = this.zK;
        if (kSCornerButton == null || this.zL == null) {
            return;
        }
        if (i2 == 1) {
            kSCornerButton.getCornerConf().setAllCorner(true);
            this.zL.getCornerConf().setAllCorner(true);
            this.zM.setVisibility(0);
        } else if (i2 == 2) {
            kSCornerButton.getCornerConf().bK(true).bN(true).bM(false).bL(false);
            this.zL.getCornerConf().bK(false).bN(false).bM(true).bL(true);
            this.zM.setVisibility(8);
        }
        this.zK.postInvalidate();
        this.zL.postInvalidate();
    }

    public final void a(a aVar) {
        this.zP = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        a(com.kwad.components.ad.reward.model.a.a(vVar, this.zR));
    }

    protected void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i2;
        int i3;
        if (aVar == null || this.zK == null) {
            return;
        }
        X(aVar.he());
        this.mLogoView.S(aVar.ha());
        this.yY.setText(aVar.getTitle());
        this.zN.setText(aVar.gn());
        TextView textView2 = this.zO;
        if (textView2 != null) {
            textView2.setText(aVar.gn());
            if (TextUtils.isEmpty(aVar.gn())) {
                i3 = 8;
            } else if (aVar.hd()) {
                i3 = 8;
                i2 = 0;
                this.zN.setVisibility(i3);
                textView = this.zO;
            } else {
                i3 = 0;
            }
            i2 = 8;
            this.zN.setVisibility(i3);
            textView = this.zO;
        } else {
            textView = this.zN;
            i2 = TextUtils.isEmpty(aVar.gn()) ? 8 : 0;
        }
        textView.setVisibility(i2);
        KsAppTagsView ksAppTagsView = this.xN;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.hc(), this.zQ);
            this.xN.setVisibility(aVar.hd() ? 8 : 0);
        }
        this.zL.a(aVar.hb(), aVar.ha());
        KSImageLoader.loadAppIcon(this.xJ, aVar.gm(), aVar.ha(), 12);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, jY(), jZ());
        g(this.sn);
        ViewGroup viewGroup2 = this.sn;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.zK.setOnClickListener(this);
            this.zL.setOnClickListener(this);
        }
    }

    protected void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_reward_playable_logo);
        this.xJ = (ImageView) viewGroup.findViewById(R.id.ksad_reward_playable_icon);
        this.yY = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_name);
        this.xN = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_reward_playable_tags);
        this.zN = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc);
        this.zO = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc2);
        this.zK = (KSCornerButton) viewGroup.findViewById(R.id.ksad_reward_playable_install_try);
        this.zL = (KsConvertButton) viewGroup.findViewById(R.id.ksad_reward_playable_action);
        this.zM = viewGroup.findViewById(R.id.ksad_reward_playable_middle_divider);
    }

    protected int jY() {
        return R.id.ksad_reward_playable_card_stub;
    }

    protected int jZ() {
        return R.id.ksad_reward_playable_card_root;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.zK)) {
            a aVar2 = this.zP;
            if (aVar2 != null) {
                aVar2.hW();
                return;
            }
            return;
        }
        if (view.equals(this.zL)) {
            a aVar3 = this.zP;
            if (aVar3 != null) {
                aVar3.hX();
                return;
            }
            return;
        }
        if (!view.equals(this.sn) || (aVar = this.zP) == null) {
            return;
        }
        aVar.hY();
    }

    public final void show() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            a aVar = this.zP;
            if (aVar != null) {
                aVar.hV();
            }
        }
    }
}
