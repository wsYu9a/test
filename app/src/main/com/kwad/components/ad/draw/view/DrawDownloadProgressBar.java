package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar ew;
    private View ex;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.draw.view.DrawDownloadProgressBar$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DrawDownloadProgressBar.this.performClick();
        }
    }

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.ew = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.ex = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void e(String str, int i10) {
        if (i10 == 0 || i10 == getMax()) {
            this.ex.setVisibility(0);
        } else {
            this.ex.setVisibility(8);
        }
        this.ew.e(str, i10);
    }

    public int getMax() {
        return this.ew.getMax();
    }

    public void setTextColor(int i10) {
        this.ew.setTextColor(i10);
    }

    public void setTextSize(int i10) {
        this.ew.setTextDimen(a.a(getContext(), i10));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        A(context);
    }
}
