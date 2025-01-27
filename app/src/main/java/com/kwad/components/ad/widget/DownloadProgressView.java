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
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView GL;

    @ColorInt
    private int GM;

    @ColorInt
    private int GN;

    @ColorInt
    private int GO;
    private int GP;
    private Drawable GQ;
    private Drawable GR;
    private String GS;
    private final KsAppDownloadListener cE;
    protected TextProgressBar dm;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.widget.DownloadProgressView$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DownloadProgressView.this.performClick();
        }
    }

    /* renamed from: com.kwad.components.ad.widget.DownloadProgressView$2 */
    final class AnonymousClass2 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.GL.setText(com.kwad.sdk.core.response.a.a.aw(downloadProgressView.mAdInfo));
            DownloadProgressView.this.GL.setVisibility(0);
            DownloadProgressView.this.dm.setVisibility(8);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DownloadProgressView.this.GL.setVisibility(8);
            DownloadProgressView.this.dm.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.aH(downloadProgressView.mAdTemplate), DownloadProgressView.this.dm.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.GL.setText(com.kwad.sdk.core.response.a.a.aw(downloadProgressView.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DownloadProgressView.this.GL.setVisibility(8);
            DownloadProgressView.this.dm.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.T(downloadProgressView.mAdInfo), DownloadProgressView.this.dm.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            DownloadProgressView.this.GL.setVisibility(8);
            DownloadProgressView.this.dm.setVisibility(0);
            DownloadProgressView.this.dm.f(com.kwad.sdk.core.response.a.a.xw(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            DownloadProgressView.this.GL.setVisibility(8);
            DownloadProgressView.this.dm.setVisibility(0);
            DownloadProgressView downloadProgressView = DownloadProgressView.this;
            downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.i(i2, downloadProgressView.GS), i2);
        }
    }

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(k.wrapContextIfNeed(context), attributeSet, i2);
        this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.GL.setText(com.kwad.sdk.core.response.a.a.aw(downloadProgressView.mAdInfo));
                DownloadProgressView.this.GL.setVisibility(0);
                DownloadProgressView.this.dm.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.GL.setVisibility(8);
                DownloadProgressView.this.dm.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.aH(downloadProgressView.mAdTemplate), DownloadProgressView.this.dm.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.GL.setText(com.kwad.sdk.core.response.a.a.aw(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.GL.setVisibility(8);
                DownloadProgressView.this.dm.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.T(downloadProgressView.mAdInfo), DownloadProgressView.this.dm.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i22) {
                DownloadProgressView.this.GL.setVisibility(8);
                DownloadProgressView.this.dm.setVisibility(0);
                DownloadProgressView.this.dm.f(com.kwad.sdk.core.response.a.a.xw(), i22);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i22) {
                DownloadProgressView.this.GL.setVisibility(8);
                DownloadProgressView.this.dm.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dm.f(com.kwad.sdk.core.response.a.a.i(i22, downloadProgressView.GS), i22);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.GM = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.GN = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.GO = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.GP = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.kwai.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.GQ = drawable;
        if (drawable == null) {
            this.GQ = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.GR = drawable2;
        if (drawable2 == null) {
            this.GR = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.GS = string;
        if (string == null) {
            this.GS = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        k.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.dm = textProgressBar;
        textProgressBar.setTextDimen(this.GP);
        this.dm.setTextColor(this.GN, this.GO);
        this.dm.setProgressDrawable(this.GQ);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.GL = textView;
        textView.setTextColor(this.GM);
        this.GL.setTextSize(0, this.GP);
        this.GL.setVisibility(0);
        this.GL.setBackground(this.GR);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void D(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.GL.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        this.dm.setVisibility(8);
        this.GL.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.cE;
    }
}
