package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f2505a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f2506b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f2507c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f2508d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2509e;

        AnonymousClass1(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            size = i2;
            arrayList2 = arrayList;
            arrayList3 = arrayList2;
            arrayList = arrayList3;
            arrayList4 = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < size; i2++) {
                ViewCompat.setTransitionName((View) arrayList2.get(i2), (String) arrayList3.get(i2));
                ViewCompat.setTransitionName((View) arrayList.get(i2), (String) arrayList4.get(i2));
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2511a;

        /* renamed from: b */
        final /* synthetic */ Map f2512b;

        AnonymousClass2(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) arrayList.get(i2);
                String transitionName = ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view, FragmentTransitionImpl.d(map, transitionName));
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2514a;

        /* renamed from: b */
        final /* synthetic */ Map f2515b;

        AnonymousClass3(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) arrayList.get(i2);
                ViewCompat.setTransitionName(view, (String) map.get(ViewCompat.getTransitionName(view)));
            }
        }
    }

    protected static void a(List<View> list, View view) {
        int size = list.size();
        if (c(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!c(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean c(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    static String d(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean g(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void addTarget(Object obj, View view);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    void b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                b(arrayList, viewGroup.getChildAt(i2));
            }
        }
    }

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public abstract Object cloneTransition(Object obj);

    void e(Map<String, View> map, @NonNull View view) {
        if (view.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    e(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    protected void f(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    ArrayList<String> h(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, null);
        }
        return arrayList2;
    }

    void i(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.3

            /* renamed from: a */
            final /* synthetic */ ArrayList f2514a;

            /* renamed from: b */
            final /* synthetic */ Map f2515b;

            AnonymousClass3(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = (View) arrayList.get(i2);
                    ViewCompat.setTransitionName(view, (String) map.get(ViewCompat.getTransitionName(view)));
                }
            }
        });
    }

    void j(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.2

            /* renamed from: a */
            final /* synthetic */ ArrayList f2511a;

            /* renamed from: b */
            final /* synthetic */ Map f2512b;

            AnonymousClass2(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view2 = (View) arrayList.get(i2);
                    String transitionName = ViewCompat.getTransitionName(view2);
                    if (transitionName != null) {
                        ViewCompat.setTransitionName(view2, FragmentTransitionImpl.d(map, transitionName));
                    }
                }
            }
        });
    }

    void k(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String transitionName = ViewCompat.getTransitionName(view2);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view2, null);
                String str = map.get(transitionName);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i3))) {
                        ViewCompat.setTransitionName(arrayList2.get(i3), transitionName);
                        break;
                    }
                    i3++;
                }
            }
        }
        OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.1

            /* renamed from: a */
            final /* synthetic */ int f2505a;

            /* renamed from: b */
            final /* synthetic */ ArrayList f2506b;

            /* renamed from: c */
            final /* synthetic */ ArrayList f2507c;

            /* renamed from: d */
            final /* synthetic */ ArrayList f2508d;

            /* renamed from: e */
            final /* synthetic */ ArrayList f2509e;

            AnonymousClass1(int size2, ArrayList arrayList22, ArrayList arrayList32, ArrayList arrayList5, ArrayList arrayList42) {
                size = size2;
                arrayList2 = arrayList22;
                arrayList3 = arrayList32;
                arrayList = arrayList5;
                arrayList4 = arrayList42;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i22 = 0; i22 < size; i22++) {
                    ViewCompat.setTransitionName((View) arrayList2.get(i22), (String) arrayList3.get(i22));
                    ViewCompat.setTransitionName((View) arrayList.get(i22), (String) arrayList4.get(i22));
                }
            }
        });
    }

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public abstract void removeTarget(Object obj, View view);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view);

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);
}
