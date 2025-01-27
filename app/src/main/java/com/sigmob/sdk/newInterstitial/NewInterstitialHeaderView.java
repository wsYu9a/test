package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: classes4.dex */
public class NewInterstitialHeaderView extends RelativeLayout {

    /* renamed from: a */
    public ImageView f20143a;

    /* renamed from: b */
    public TextView f20144b;

    /* renamed from: c */
    public ImageView f20145c;

    /* renamed from: d */
    public int f20146d;

    /* renamed from: e */
    public Runnable f20147e;

    /* renamed from: f */
    public w f20148f;

    /* renamed from: g */
    public boolean f20149g;

    /* renamed from: h */
    public View f20150h;

    /* renamed from: i */
    public b f20151i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewInterstitialHeaderView.this.f20146d > 0) {
                NewInterstitialHeaderView.this.f20144b.setText(String.valueOf(NewInterstitialHeaderView.b(NewInterstitialHeaderView.this)));
                NewInterstitialHeaderView.this.f20144b.postDelayed(NewInterstitialHeaderView.this.f20147e, 1000L);
                return;
            }
            if (NewInterstitialHeaderView.this.f20149g) {
                if (NewInterstitialHeaderView.this.f20151i != null) {
                    NewInterstitialHeaderView.this.f20151i.a();
                }
                NewInterstitialHeaderView.this.f20144b.setVisibility(8);
                NewInterstitialHeaderView.this.f20143a.setVisibility(0);
            } else {
                if (NewInterstitialHeaderView.this.f20151i != null) {
                    NewInterstitialHeaderView.this.f20151i.b();
                }
                NewInterstitialHeaderView.this.f20144b.setClickable(true);
                NewInterstitialHeaderView.this.f20144b.setText("   跳过   ");
            }
            NewInterstitialHeaderView.this.removeCallbacks(this);
        }
    }

    public interface b {
        void a();

        void b();
    }

    public NewInterstitialHeaderView(Context context) {
        super(context);
        a(context);
    }

    public static /* synthetic */ int b(NewInterstitialHeaderView newInterstitialHeaderView) {
        int i10 = newInterstitialHeaderView.f20146d;
        newInterstitialHeaderView.f20146d = i10 - 1;
        return i10;
    }

    public void hideSoundIcon() {
        this.f20145c.setVisibility(8);
    }

    public void setAdHeaderViewStateListener(b bVar) {
        this.f20151i = bVar;
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.f20143a.setOnClickListener(onClickListener);
    }

    public void setSkipClickListener(View.OnClickListener onClickListener) {
        this.f20144b.setOnClickListener(onClickListener);
    }

    public void setSoundClickListener(View.OnClickListener onClickListener) {
        this.f20145c.setOnClickListener(onClickListener);
    }

    public void setSoundStatus(boolean z10) {
        ImageView imageView;
        Context context;
        String str;
        if (z10) {
            imageView = this.f20145c;
            context = getContext();
            str = "sig_image_video_mute";
        } else {
            imageView = this.f20145c;
            context = getContext();
            str = "sig_image_video_unmute";
        }
        imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
    }

    public void showCloseView() {
        this.f20143a.setVisibility(0);
    }

    public void showFeedback(boolean z10, View.OnClickListener onClickListener) {
        if (this.f20148f == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.f20148f = wVar;
            wVar.setText("反馈");
            this.f20148f.setOnClickListener(onClickListener);
            this.f20148f.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(5.0f, context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            if (z10) {
                layoutParams.addRule(9);
                ((RelativeLayout.LayoutParams) this.f20145c.getLayoutParams()).addRule(1, this.f20148f.getId());
                layoutParams.setMargins(dipsToIntPixels, 0, 0, 0);
            } else {
                layoutParams.addRule(0, this.f20150h.getId());
                layoutParams.setMargins(0, 0, dipsToIntPixels, 0);
            }
            layoutParams.addRule(4, this.f20150h.getId());
            ViewParent parent = this.f20150h.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f20148f, layoutParams);
            }
        }
    }

    public void showSoundIcon() {
        this.f20145c.setVisibility(0);
    }

    public void startAdTimer(int i10, boolean z10) {
        this.f20149g = z10;
        if (i10 > 0) {
            this.f20144b.setVisibility(0);
            this.f20144b.setText(String.valueOf(i10));
            this.f20146d = i10 - 1;
            this.f20144b.setClickable(false);
            this.f20144b.postDelayed(this.f20147e, 1000L);
            return;
        }
        if (z10) {
            showCloseView();
            b bVar = this.f20151i;
            if (bVar != null) {
                bVar.a();
            }
            this.f20144b.setVisibility(8);
            return;
        }
        b bVar2 = this.f20151i;
        if (bVar2 != null) {
            bVar2.b();
        }
        this.f20144b.setClickable(true);
        this.f20144b.setText("   跳过   ");
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_header_layout"), this);
        this.f20143a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.f20150h = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_root"));
        ImageView imageView = this.f20143a;
        if (imageView != null) {
            imageView.setImageBitmap(s.CLOSE_OLD.b());
        }
        this.f20145c = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_sound"));
        TextView textView = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_timer"));
        this.f20144b = textView;
        textView.setClickable(false);
        this.f20147e = new a();
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }
}
