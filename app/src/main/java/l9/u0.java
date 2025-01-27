package l9;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class u0 {
    public static List<View> a(View view) {
        if (!(view instanceof ViewGroup)) {
            return Collections.singletonList(view);
        }
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(view);
            arrayList2.addAll(a(childAt));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public static void b(View view) {
        for (KeyEvent.Callback callback : a(view)) {
            if (callback instanceof k9.a) {
                ((k9.a) callback).p();
            }
        }
    }
}
