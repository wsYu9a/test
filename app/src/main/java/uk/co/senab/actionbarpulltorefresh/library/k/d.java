package uk.co.senab.actionbarpulltorefresh.library.k;

import android.view.View;
import android.webkit.WebView;

/* loaded from: classes5.dex */
public class d implements c {

    /* renamed from: a */
    public static final Class[] f37189a = {WebView.class};

    @Override // uk.co.senab.actionbarpulltorefresh.library.k.c
    public boolean a(View view, float f2, float f3) {
        return view.getScrollY() <= 0;
    }
}
