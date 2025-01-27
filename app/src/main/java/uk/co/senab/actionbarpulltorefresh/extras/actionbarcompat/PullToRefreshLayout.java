package uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import uk.co.senab.actionbarpulltorefresh.library.g;
import uk.co.senab.actionbarpulltorefresh.library.h;

/* loaded from: classes5.dex */
public class PullToRefreshLayout extends uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout {
    public PullToRefreshLayout(Context context) {
        super(context);
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout
    protected h e(Activity activity, g gVar) {
        return new b(activity, gVar);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
