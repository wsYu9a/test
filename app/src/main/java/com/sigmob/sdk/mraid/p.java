package com.sigmob.sdk.mraid;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* loaded from: classes4.dex */
public class p extends com.sigmob.sdk.base.views.g {

    /* renamed from: j */
    public static final int f19661j = 1;

    /* renamed from: h */
    public a f19662h;

    /* renamed from: i */
    public boolean f19663i;

    public interface a {
        void a(boolean z10);
    }

    public p(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT <= 22) {
            this.f19663i = getVisibility() == 0;
        }
    }

    private void setMraidViewable(boolean z10) {
        if (this.f19663i == z10) {
            return;
        }
        this.f19663i = z10;
        a aVar = this.f19662h;
        if (aVar != null) {
            aVar.a(z10);
        }
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.f19662h = null;
    }

    public boolean j() {
        return this.f19663i;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            return;
        }
        setMraidViewable(false);
    }

    public void setVisibilityChangedListener(a aVar) {
        this.f19662h = aVar;
    }
}
