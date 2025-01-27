package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;

/* loaded from: classes3.dex */
public class KsLogoView extends LinearLayout {
    private boolean afq;
    TextView afr;
    ImageView afs;
    private a aft;
    private SimpleImageLoadingListener fV;

    /* renamed from: com.kwad.components.core.widget.KsLogoView$1 */
    public class AnonymousClass1 extends SimpleImageLoadingListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            if (KsLogoView.this.aft != null) {
                KsLogoView.this.aft.kx();
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            KsLogoView.this.uA();
            if (KsLogoView.this.aft != null) {
                KsLogoView.this.aft.kx();
            }
        }
    }

    public interface a {
        void kx();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int ceil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int a10 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(ceil, a10);
        ksLogoView.layout(0, 0, ceil, a10);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.afr = (TextView) findViewById(R.id.ksad_logo_text);
        this.afs = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z10 = getBackground() == null;
        this.afq = z10;
        if (z10) {
            this.afs.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.afr.setTextColor(-6513508);
        } else {
            this.afs.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.afr.setTextColor(-1711276033);
        }
    }

    public void uA() {
        this.afs.setImageDrawable(getContext().getResources().getDrawable(this.afq ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public final void aK(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        String str = this.afq ? eb2.adBaseInfo.adGrayMarkIcon : eb2.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(eb2.adBaseInfo.adSourceDescription)) {
            this.afr.setVisibility(0);
            this.afr.setText(com.kwad.sdk.core.response.b.a.aD(eb2));
            this.afs.setVisibility(0);
            uA();
            a aVar = this.aft;
            if (aVar != null) {
                aVar.kx();
            }
        } else {
            if (TextUtils.isEmpty(eb2.adBaseInfo.adSourceDescription)) {
                this.afr.setVisibility(8);
                this.afr.setText("");
            } else {
                this.afr.setText(com.kwad.sdk.core.response.b.a.aD(eb2));
                this.afr.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.afs.setVisibility(8);
                this.afs.setImageDrawable(null);
                a aVar2 = this.aft;
                if (aVar2 != null) {
                    aVar2.kx();
                }
            } else {
                KSImageLoader.loadFeeImage(this.afs, str, adTemplate, this.fV);
                this.afs.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.afs;
    }

    public TextView getTextView() {
        return this.afr;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.aft = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(m.wrapContextIfNeed(context), attributeSet, i10);
        this.fV = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aft != null) {
                    KsLogoView.this.aft.kx();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.uA();
                if (KsLogoView.this.aft != null) {
                    KsLogoView.this.aft.kx();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z10) {
        super(m.wrapContextIfNeed(context));
        this.fV = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aft != null) {
                    KsLogoView.this.aft.kx();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.uA();
                if (KsLogoView.this.aft != null) {
                    KsLogoView.this.aft.kx();
                }
            }
        };
        if (z10) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
