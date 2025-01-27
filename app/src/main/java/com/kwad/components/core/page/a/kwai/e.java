package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public final class e extends a {
    private LinearLayout Le;
    private TextView Lf;
    private ImageView Lg;

    /* renamed from: com.kwad.components.core.page.a.kwai.e$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.Le.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.e$2 */
    final class AnonymousClass2 implements KsAdWebView.c {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.c
        public final void ot() {
            if (e.this.LG.oa() && e.this.Le.getVisibility() == 0) {
                e.this.Le.setVisibility(8);
            }
        }
    }

    private void or() {
        this.Le = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.LG.mPageTitle)) {
            this.Le.setVisibility(8);
            return;
        }
        this.Lf = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.Lg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.kwai.e.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.Le.setVisibility(8);
            }
        });
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate);
        boolean bn = com.kwad.sdk.core.response.a.a.bn(cb);
        String bj = com.kwad.sdk.core.response.a.a.bj(cb);
        if (bn) {
            this.Le.setVisibility(0);
            this.Lf.setText(bj);
            this.Lf.setSelected(true);
        } else {
            this.Le.setVisibility(8);
        }
        this.LG.a(os());
    }

    @NonNull
    private KsAdWebView.c os() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.a.kwai.e.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void ot() {
                if (e.this.LG.oa() && e.this.Le.getVisibility() == 0) {
                    e.this.Le.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        or();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
