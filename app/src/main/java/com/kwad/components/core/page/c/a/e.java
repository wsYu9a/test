package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes3.dex */
public final class e extends a {
    private LinearLayout Qe;
    private TextView Qf;
    private ImageView Qg;

    /* renamed from: com.kwad.components.core.page.c.a.e$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.Qe.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.e$2 */
    public class AnonymousClass2 implements KsAdWebView.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.c
        public final void qr() {
            if (e.this.QL.pX() && e.this.Qe.getVisibility() == 0) {
                e.this.Qe.setVisibility(8);
            }
        }
    }

    private void qp() {
        this.Qe = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.QL.mPageTitle)) {
            this.Qe.setVisibility(8);
            return;
        }
        this.Qf = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.Qg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.Qe.setVisibility(8);
            }
        });
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate);
        boolean by = com.kwad.sdk.core.response.b.a.by(eb2);
        String bu = com.kwad.sdk.core.response.b.a.bu(eb2);
        if (by) {
            this.Qe.setVisibility(0);
            this.Qf.setText(bu);
            this.Qf.setSelected(true);
        } else {
            this.Qe.setVisibility(8);
        }
        this.QL.a(qq());
    }

    @NonNull
    private KsAdWebView.c qq() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void qr() {
                if (e.this.QL.pX() && e.this.Qe.getVisibility() == 0) {
                    e.this.Qe.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        qp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
