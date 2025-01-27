package i;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class a {
    public static List<View> a(View target) {
        if (!(target instanceof ViewGroup)) {
            return Collections.singletonList(target);
        }
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) target;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(target);
            arrayList2.addAll(a(childAt));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public static void b(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void c(View rootView) {
        for (KeyEvent.Callback callback : a(rootView)) {
            if (callback instanceof g.a) {
                ((g.a) callback).g();
            }
        }
    }
}
