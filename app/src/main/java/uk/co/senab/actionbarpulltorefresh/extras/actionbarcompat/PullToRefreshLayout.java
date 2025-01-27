package uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import uk.co.senab.actionbarpulltorefresh.library.b;
import uk.f;

/* loaded from: classes5.dex */
public class PullToRefreshLayout extends uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout {
    public PullToRefreshLayout(Context context) {
        super(context);
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout
    public f e(Activity activity, b bVar) {
        return new tk.a(activity, bVar);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
