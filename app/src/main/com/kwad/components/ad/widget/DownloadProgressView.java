package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView JU;

    @ColorInt
    private int JV;

    @ColorInt
    private int JW;

    @ColorInt
    private int JX;
    private int JY;
    private Drawable JZ;
    private Drawable Ka;
    private String Kb;
    private final KsAppDownloadListener dL;
    protected TextProgressBar ew;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.widget.DownloadProgressView$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DownloadProgressView.this.performClick();
        }
    }

    /* renamed from: com.kwad.components.ad.widget.DownloadProgressView$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.JU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
            DownloadProgressView.this.JU.setVisibility(0);
            DownloadProgressView.this.ew.setVisibility(8);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DownloadProgressView.this.JU.setVisibility(8);
            DownloadProgressView.this.ew.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.cg(downloadProgressView.mAdTemplate), DownloadProgressView.this.ew.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.JU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DownloadProgressView.this.JU.setVisibility(8);
            DownloadProgressView.this.ew.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.ac(downloadProgressView.mAdInfo), DownloadProgressView.this.ew.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            DownloadProgressView.this.JU.setVisibility(8);
            DownloadProgressView.this.ew.setVisibility(0);
            DownloadProgressView.this.ew.e(com.kwad.sdk.core.response.b.a.GN(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            DownloadProgressView.this.JU.setVisibility(8);
            DownloadProgressView.this.ew.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.t(i10, downloadProgressView.Kb), i10);
        }
    }

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.JV = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.JW = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.JX = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.JY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.JZ = drawable;
        if (drawable == null) {
            this.JZ = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.Ka = drawable2;
        if (drawable2 == null) {
            this.Ka = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.Kb = string;
        if (string == null) {
            this.Kb = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.ew = textProgressBar;
        textProgressBar.setTextDimen(this.JY);
        this.ew.setTextColor(this.JW, this.JX);
        this.ew.setProgressDrawable(this.JZ);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.JU = textView;
        textView.setTextColor(this.JV);
        this.JU.setTextSize(0, this.JY);
        this.JU.setVisibility(0);
        this.JU.setBackground(this.Ka);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void am(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.mAdInfo = eb2;
        this.JU.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        this.ew.setVisibility(8);
        this.JU.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.dL;
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(m.wrapContextIfNeed(context), attributeSet, i10);
        this.dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.JU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
                DownloadProgressView.this.JU.setVisibility(0);
                DownloadProgressView.this.ew.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.JU.setVisibility(8);
                DownloadProgressView.this.ew.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.cg(downloadProgressView.mAdTemplate), DownloadProgressView.this.ew.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.JU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.JU.setVisibility(8);
                DownloadProgressView.this.ew.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.ac(downloadProgressView.mAdInfo), DownloadProgressView.this.ew.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i102) {
                DownloadProgressView.this.JU.setVisibility(8);
                DownloadProgressView.this.ew.setVisibility(0);
                DownloadProgressView.this.ew.e(com.kwad.sdk.core.response.b.a.GN(), i102);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i102) {
                DownloadProgressView.this.JU.setVisibility(8);
                DownloadProgressView.this.ew.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.ew.e(com.kwad.sdk.core.response.b.a.t(i102, downloadProgressView.Kb), i102);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
