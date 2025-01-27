package xk;

import android.view.View;
import android.webkit.WebView;

/* loaded from: classes5.dex */
public class d implements c {

    /* renamed from: a */
    public static final Class[] f32939a = {WebView.class};

    @Override // xk.c
    public boolean a(View view, float f10, float f11) {
        return view.getScrollY() <= 0;
    }
}
