package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bm;

/* loaded from: classes2.dex */
public final class n extends d implements View.OnClickListener {
    private ViewGroup AX;
    private TextView Ad;
    private KSCornerImageView Bd;
    private LinearLayout Be;
    private KsPriceView Bf;
    private TextView Bg;
    private View Bh;
    private KSCornerImageView Bi;
    private b Bj;
    private a Bk;

    /* renamed from: if */
    private ViewGroup f4if;

    /* renamed from: com.kwad.components.ad.reward.n.n$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdProductInfo Bl;

        /* renamed from: com.kwad.components.ad.reward.n.n$1$1 */
        public class C04011 extends bd {
            public C04011() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                n.this.Bk.hO();
            }
        }

        public AnonymousClass1(AdProductInfo adProductInfo) {
            adProductInfo = adProductInfo;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                n nVar = n.this;
                View a10 = n.a(nVar, nVar.Be.getContext(), couponInfo, n.this.Be);
                ViewGroup.LayoutParams layoutParams = a10.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -1);
                } else {
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                }
                n.this.Be.addView(a10, layoutParams);
                com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), n.this.Be);
            }
            if (n.this.Bk != null) {
                if (n.this.Be.getChildCount() > 0) {
                    n.this.Be.getChildAt(0).post(new bd() { // from class: com.kwad.components.ad.reward.n.n.1.1
                        public C04011() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            n.this.Bk.hO();
                        }
                    });
                } else {
                    n.this.Bk.hO();
                }
            }
        }
    }

    public interface a {
        void hO();
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.f4if = viewGroup;
        this.Bj = bVar;
        initView();
    }

    public static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.AX = (ViewGroup) this.f4if.findViewById(R.id.ksad_reward_order_root);
        this.Bd = (KSCornerImageView) this.f4if.findViewById(R.id.ksad_reward_order_icon);
        this.Ad = (TextView) this.f4if.findViewById(R.id.ksad_reward_order_title);
        this.Be = (LinearLayout) this.f4if.findViewById(R.id.ksad_reward_order_coupon_list);
        this.Bf = (KsPriceView) this.f4if.findViewById(R.id.ksad_reward_order_price);
        this.Bg = (TextView) this.f4if.findViewById(R.id.ksad_reward_order_btn_buy);
        this.Bh = this.f4if.findViewById(R.id.ksad_reward_order_text_area);
        this.Bi = (KSCornerImageView) this.f4if.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.Bg.setText(com.kwad.components.ad.e.b.aB());
        this.Bg.setOnClickListener(this);
        this.Bd.setOnClickListener(this);
        this.Bh.setOnClickListener(this);
        Context context = this.f4if.getContext();
        if (an.NS()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f4if.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.f4if.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.AX;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Bj == null) {
            return;
        }
        if (view.equals(this.Bg)) {
            this.Bj.he();
        } else if (view.equals(this.Bd)) {
            this.Bj.iC();
        } else if (view.equals(this.Bh)) {
            this.Bj.iE();
        }
    }

    public final void a(a aVar) {
        this.Bk = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.cW(com.kwad.sdk.core.response.b.e.eb(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    private void a(AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.Bd, adProductInfo.getIcon(), adTemplate);
        this.Ad.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.Be.setVisibility(8);
            this.Bk.hO();
        } else {
            this.Be.setVisibility(0);
            this.Be.post(new bd() { // from class: com.kwad.components.ad.reward.n.n.1
                final /* synthetic */ AdProductInfo Bl;

                /* renamed from: com.kwad.components.ad.reward.n.n$1$1 */
                public class C04011 extends bd {
                    public C04011() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        n.this.Bk.hO();
                    }
                }

                public AnonymousClass1(AdProductInfo adProductInfo2) {
                    adProductInfo = adProductInfo2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View a10 = n.a(nVar, nVar.Be.getContext(), couponInfo, n.this.Be);
                        ViewGroup.LayoutParams layoutParams = a10.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.Be.addView(a10, layoutParams);
                        com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), n.this.Be);
                    }
                    if (n.this.Bk != null) {
                        if (n.this.Be.getChildCount() > 0) {
                            n.this.Be.getChildAt(0).post(new bd() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                public C04011() {
                                }

                                @Override // com.kwad.sdk.utils.bd
                                public final void doTask() {
                                    n.this.Bk.hO();
                                }
                            });
                        } else {
                            n.this.Bk.hO();
                        }
                    }
                }
            });
        }
        this.Bf.h(adProductInfo2.getPrice(), adProductInfo2.getOriginPrice());
        String aC = com.kwad.components.ad.e.b.aC();
        if (bm.isNullString(aC)) {
            return;
        }
        KSImageLoader.loadImage(this.Bi, aC, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.n.m.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}
