package xk;

import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a */
    public static final Class[] f32938a = {ScrollView.class};

    @Override // xk.c
    public boolean a(View view, float f10, float f11) {
        return view.getScrollY() <= 0;
    }
}
