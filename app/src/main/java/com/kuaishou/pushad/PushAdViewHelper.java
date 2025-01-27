package com.kuaishou.pushad;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PushAdViewHelper {
    private static final String TAG = "PushAdViewHelper";

    public static void appendPushAd(Activity activity, View view) {
        ViewGroup obtainDecorView;
        if (view == null || (obtainDecorView = obtainDecorView(activity)) == null) {
            return;
        }
        removePushAd(obtainDecorView);
        obtainDecorView.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Nullable
    private static ViewGroup obtainDecorView(@Nullable Activity activity) {
        if (activity == null) {
            b.vS();
            activity = b.getCurrentActivity();
        }
        if (activity == null) {
            return null;
        }
        View findViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    public static void removePushAd(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            viewGroup = obtainDecorView(null);
        }
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (PushAdView.PUSH_VIEW_TAG.equals(childAt.getTag())) {
                    arrayList.add(childAt);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                viewGroup.removeView((View) it.next());
            }
        }
    }
}
