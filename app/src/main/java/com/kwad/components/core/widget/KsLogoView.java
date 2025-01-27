package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class KsLogoView extends LinearLayout {
    private boolean WU;
    TextView WV;
    ImageView WW;
    private a WX;
    private SimpleImageLoadingListener ey;

    /* renamed from: com.kwad.components.core.widget.KsLogoView$1 */
    final class AnonymousClass1 extends SimpleImageLoadingListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            if (KsLogoView.this.WX != null) {
                KsLogoView.this.WX.jU();
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            KsLogoView.this.rA();
            if (KsLogoView.this.WX != null) {
                KsLogoView.this.WX.jU();
            }
        }
    }

    public interface a {
        void jU();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(k.wrapContextIfNeed(context), attributeSet, i2);
        this.ey = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.rA();
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(k.wrapContextIfNeed(context));
        this.ey = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.rA();
                if (KsLogoView.this.WX != null) {
                    KsLogoView.this.WX.jU();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int ceil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.kwai.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int a2 = com.kwad.sdk.c.kwai.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(ceil, a2);
        ksLogoView.layout(0, 0, ceil, a2);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        TextView textView;
        int i2;
        k.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.WV = (TextView) findViewById(R.id.ksad_logo_text);
        this.WW = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.WU = z;
        if (z) {
            this.WW.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.WV;
            i2 = -6513508;
        } else {
            this.WW.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.WV;
            i2 = -1711276033;
        }
        textView.setTextColor(i2);
    }

    public void rA() {
        this.WW.setImageDrawable(getContext().getResources().getDrawable(this.WU ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        r7.jU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
    
        if (r7 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        if (r7 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S(com.kwad.sdk.core.response.model.AdTemplate r7) {
        /*
            r6 = this;
            int r0 = com.kwad.sdk.R.id.ksad_logo_container
            android.view.View r0 = r6.findViewById(r0)
            com.kwad.sdk.core.response.model.AdInfo r1 = com.kwad.sdk.core.response.a.d.cb(r7)
            boolean r2 = r6.WU
            if (r2 == 0) goto L13
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r2 = r1.adBaseInfo
            java.lang.String r2 = r2.adGrayMarkIcon
            goto L17
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r2 = r1.adBaseInfo
            java.lang.String r2 = r2.adMarkIcon
        L17:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 0
            if (r3 == 0) goto L46
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r3 = r1.adBaseInfo
            java.lang.String r3 = r3.adSourceDescription
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L46
            android.widget.TextView r7 = r6.WV
            r7.setVisibility(r4)
            android.widget.TextView r7 = r6.WV
            java.lang.String r1 = com.kwad.sdk.core.response.a.a.av(r1)
            r7.setText(r1)
            android.widget.ImageView r7 = r6.WW
            r7.setVisibility(r4)
            r6.rA()
            com.kwad.components.core.widget.KsLogoView$a r7 = r6.WX
            if (r7 == 0) goto L90
        L42:
            r7.jU()
            goto L90
        L46:
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r3 = r1.adBaseInfo
            java.lang.String r3 = r3.adSourceDescription
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r5 = 8
            if (r3 != 0) goto L61
            android.widget.TextView r3 = r6.WV
            java.lang.String r1 = com.kwad.sdk.core.response.a.a.av(r1)
            r3.setText(r1)
            android.widget.TextView r1 = r6.WV
            r1.setVisibility(r4)
            goto L6d
        L61:
            android.widget.TextView r1 = r6.WV
            r1.setVisibility(r5)
            android.widget.TextView r1 = r6.WV
            java.lang.String r3 = ""
            r1.setText(r3)
        L6d:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L80
            android.widget.ImageView r1 = r6.WW
            com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener r3 = r6.ey
            com.kwad.sdk.core.imageloader.KSImageLoader.loadFeeImage(r1, r2, r7, r3)
            android.widget.ImageView r7 = r6.WW
            r7.setVisibility(r4)
            goto L90
        L80:
            android.widget.ImageView r7 = r6.WW
            r7.setVisibility(r5)
            android.widget.ImageView r7 = r6.WW
            r1 = 0
            r7.setImageDrawable(r1)
            com.kwad.components.core.widget.KsLogoView$a r7 = r6.WX
            if (r7 == 0) goto L90
            goto L42
        L90:
            r0.setVisibility(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.widget.KsLogoView.S(com.kwad.sdk.core.response.model.AdTemplate):void");
    }

    public ImageView getIcon() {
        return this.WW;
    }

    public TextView getTextView() {
        return this.WV;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.WX = aVar;
    }
}
