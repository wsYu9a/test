package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.c.kwai.a;
import com.kwad.sdk.j.k;

/* loaded from: classes.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar dm;
    private View dn;
    private Context mContext;

    /* renamed from: com.kwad.components.ad.draw.view.DrawDownloadProgressBar$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DrawDownloadProgressBar.this.performClick();
        }
    }

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        D(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        this.mContext = context;
        k.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.dm = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.dn = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void f(String str, int i2) {
        View view;
        int i3;
        if (i2 == 0 || i2 == getMax()) {
            view = this.dn;
            i3 = 0;
        } else {
            view = this.dn;
            i3 = 8;
        }
        view.setVisibility(i3);
        this.dm.f(str, i2);
    }

    public int getMax() {
        return this.dm.getMax();
    }

    public void setTextColor(int i2) {
        this.dm.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        this.dm.setTextDimen(a.a(getContext(), i2));
    }
}
