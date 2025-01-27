package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
class FragmentTransition {

    /* renamed from: a */
    private static final int[] f2462a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b */
    private static final FragmentTransitionImpl f2463b;

    /* renamed from: c */
    private static final FragmentTransitionImpl f2464c;

    /* renamed from: androidx.fragment.app.FragmentTransition$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2465a;

        AnonymousClass1(ArrayList arrayList) {
            arrayList = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.z(arrayList, 4);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f2466a;

        /* renamed from: b */
        final /* synthetic */ FragmentTransitionImpl f2467b;

        /* renamed from: c */
        final /* synthetic */ View f2468c;

        /* renamed from: d */
        final /* synthetic */ Fragment f2469d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2470e;

        /* renamed from: f */
        final /* synthetic */ ArrayList f2471f;

        /* renamed from: g */
        final /* synthetic */ ArrayList f2472g;

        /* renamed from: h */
        final /* synthetic */ Object f2473h;

        AnonymousClass2(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            obj = obj;
            fragmentTransitionImpl = fragmentTransitionImpl;
            view = view;
            fragment = fragment;
            arrayList = arrayList;
            arrayList2 = arrayList2;
            arrayList3 = arrayList3;
            obj2 = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = obj;
            if (obj != null) {
                fragmentTransitionImpl.removeTarget(obj, view);
                arrayList2.addAll(FragmentTransition.i(fragmentTransitionImpl, obj, fragment, arrayList, view));
            }
            if (arrayList3 != null) {
                if (obj2 != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(view);
                    fragmentTransitionImpl.replaceTargets(obj2, arrayList3, arrayList);
                }
                arrayList3.clear();
                arrayList3.add(view);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$3 */
    static class AnonymousClass3 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Fragment f2475b;

        /* renamed from: c */
        final /* synthetic */ boolean f2476c;

        /* renamed from: d */
        final /* synthetic */ ArrayMap f2477d;

        /* renamed from: e */
        final /* synthetic */ View f2478e;

        /* renamed from: f */
        final /* synthetic */ FragmentTransitionImpl f2479f;

        /* renamed from: g */
        final /* synthetic */ Rect f2480g;

        AnonymousClass3(Fragment fragment, boolean z, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
            fragment2 = fragment;
            z = z;
            f2 = arrayMap;
            view2 = view;
            fragmentTransitionImpl = fragmentTransitionImpl;
            rect = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.d(Fragment.this, fragment2, z, f2, false);
            View view = view2;
            if (view != null) {
                fragmentTransitionImpl.f(view, rect);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransition$4 */
    static class AnonymousClass4 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ArrayMap f2482b;

        /* renamed from: c */
        final /* synthetic */ Object f2483c;

        /* renamed from: d */
        final /* synthetic */ FragmentContainerTransition f2484d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2485e;

        /* renamed from: f */
        final /* synthetic */ View f2486f;

        /* renamed from: g */
        final /* synthetic */ Fragment f2487g;

        /* renamed from: h */
        final /* synthetic */ Fragment f2488h;

        /* renamed from: i */
        final /* synthetic */ boolean f2489i;

        /* renamed from: j */
        final /* synthetic */ ArrayList f2490j;
        final /* synthetic */ Object k;
        final /* synthetic */ Rect l;

        AnonymousClass4(ArrayMap arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            arrayMap = arrayMap;
            obj4 = obj;
            fragmentContainerTransition = fragmentContainerTransition;
            arrayList2 = arrayList;
            view = view;
            fragment = fragment;
            fragment2 = fragment2;
            z = z;
            arrayList = arrayList2;
            obj = obj2;
            rect2 = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayMap<String, View> f2 = FragmentTransition.f(FragmentTransitionImpl.this, arrayMap, obj4, fragmentContainerTransition);
            if (f2 != null) {
                arrayList2.addAll(f2.values());
                arrayList2.add(view);
            }
            FragmentTransition.d(fragment, fragment2, z, f2, false);
            Object obj = obj4;
            if (obj != null) {
                FragmentTransitionImpl.this.swapSharedElementTargets(obj, arrayList, arrayList2);
                View r = FragmentTransition.r(f2, fragmentContainerTransition, obj, z);
                if (r != null) {
                    FragmentTransitionImpl.this.f(r, rect2);
                }
            }
        }
    }

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    static {
        f2463b = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        f2464c = v();
    }

    private FragmentTransition() {
    }

    static void A(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z) {
        if (fragmentManagerImpl.y < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z);
            } else {
                calculateFragments(backStackRecord, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(fragmentManagerImpl.z.getContext());
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                ArrayMap<String, String> c2 = c(keyAt, arrayList, arrayList2, i2, i3);
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i5);
                if (z) {
                    m(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, c2);
                } else {
                    l(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, c2);
                }
            }
        }
    }

    static boolean B() {
        return (f2463b == null && f2464c == null) ? false : true;
    }

    private static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
    
        if (r10.mHidden == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        if (r10.mAdded != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0094, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0076, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(androidx.fragment.app.BackStackRecord r16, androidx.fragment.app.FragmentTransaction.Op r17, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.b(androidx.fragment.app.BackStackRecord, androidx.fragment.app.FragmentTransaction$Op, android.util.SparseArray, boolean, boolean):void");
    }

    private static ArrayMap<String, String> c(int i2, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            if (backStackRecord.h(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = backStackRecord.z;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.z;
                        arrayList4 = backStackRecord.A;
                    } else {
                        ArrayList<String> arrayList6 = backStackRecord.z;
                        arrayList3 = backStackRecord.A;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.l.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(backStackRecord, backStackRecord.l.get(i2), sparseArray, false, z);
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.E.A.onHasView()) {
            for (int size = backStackRecord.l.size() - 1; size >= 0; size--) {
                b(backStackRecord, backStackRecord.l.get(size), sparseArray, true, z);
            }
        }
    }

    static void d(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean e(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static ArrayMap<String, View> f(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback enterTransitionCallback;
        ArrayList<String> arrayList;
        String o;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.e(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.z;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.A;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String o2 = o(arrayMap, str);
                    if (o2 != null) {
                        arrayMap.remove(o2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (o = o(arrayMap, str)) != null) {
                    arrayMap.put(o, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            w(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> g(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.e(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.A;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.z;
        }
        arrayMap2.retainAll(arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl h(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f2463b;
        if (fragmentTransitionImpl != null && e(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f2464c;
        if (fragmentTransitionImpl2 != null && e(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> i(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.b(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static Object j(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object s;
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Rect rect;
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            s = null;
        } else {
            s = s(fragmentTransitionImpl, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> g2 = g(fragmentTransitionImpl, arrayMap2, s, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(g2.values());
            obj3 = s;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        d(fragment, fragment2, z, g2, true);
        if (obj3 != null) {
            rect = new Rect();
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            y(fragmentTransitionImpl, obj3, obj2, g2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.4

            /* renamed from: b */
            final /* synthetic */ ArrayMap f2482b;

            /* renamed from: c */
            final /* synthetic */ Object f2483c;

            /* renamed from: d */
            final /* synthetic */ FragmentContainerTransition f2484d;

            /* renamed from: e */
            final /* synthetic */ ArrayList f2485e;

            /* renamed from: f */
            final /* synthetic */ View f2486f;

            /* renamed from: g */
            final /* synthetic */ Fragment f2487g;

            /* renamed from: h */
            final /* synthetic */ Fragment f2488h;

            /* renamed from: i */
            final /* synthetic */ boolean f2489i;

            /* renamed from: j */
            final /* synthetic */ ArrayList f2490j;
            final /* synthetic */ Object k;
            final /* synthetic */ Rect l;

            AnonymousClass4(ArrayMap arrayMap3, Object obj32, FragmentContainerTransition fragmentContainerTransition2, ArrayList arrayList22, View view2, Fragment fragment3, Fragment fragment22, boolean z2, ArrayList arrayList3, Object obj4, Rect rect2) {
                arrayMap = arrayMap3;
                obj4 = obj32;
                fragmentContainerTransition = fragmentContainerTransition2;
                arrayList2 = arrayList22;
                view = view2;
                fragment = fragment3;
                fragment2 = fragment22;
                z = z2;
                arrayList = arrayList3;
                obj = obj4;
                rect2 = rect2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayMap<String, View> f2 = FragmentTransition.f(FragmentTransitionImpl.this, arrayMap, obj4, fragmentContainerTransition);
                if (f2 != null) {
                    arrayList2.addAll(f2.values());
                    arrayList2.add(view);
                }
                FragmentTransition.d(fragment, fragment2, z, f2, false);
                Object obj4 = obj4;
                if (obj4 != null) {
                    FragmentTransitionImpl.this.swapSharedElementTargets(obj4, arrayList, arrayList2);
                    View r = FragmentTransition.r(f2, fragmentContainerTransition, obj, z);
                    if (r != null) {
                        FragmentTransitionImpl.this.f(r, rect2);
                    }
                }
            }
        });
        return obj32;
    }

    private static Object k(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        Object s = arrayMap.isEmpty() ? null : s(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> g2 = g(fragmentTransitionImpl, arrayMap, s, fragmentContainerTransition);
        ArrayMap<String, View> f2 = f(fragmentTransitionImpl, arrayMap, s, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (g2 != null) {
                g2.clear();
            }
            if (f2 != null) {
                f2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, g2, arrayMap.keySet());
            a(arrayList2, f2, arrayMap.values());
            obj3 = s;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        d(fragment, fragment2, z, g2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            y(fragmentTransitionImpl, obj3, obj2, g2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            View r = r(f2, fragmentContainerTransition, obj, z);
            if (r != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = r;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.3

            /* renamed from: b */
            final /* synthetic */ Fragment f2475b;

            /* renamed from: c */
            final /* synthetic */ boolean f2476c;

            /* renamed from: d */
            final /* synthetic */ ArrayMap f2477d;

            /* renamed from: e */
            final /* synthetic */ View f2478e;

            /* renamed from: f */
            final /* synthetic */ FragmentTransitionImpl f2479f;

            /* renamed from: g */
            final /* synthetic */ Rect f2480g;

            AnonymousClass3(Fragment fragment22, boolean z2, ArrayMap f22, View view22, FragmentTransitionImpl fragmentTransitionImpl2, Rect rect3) {
                fragment2 = fragment22;
                z = z2;
                f2 = f22;
                view2 = view22;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                rect = rect3;
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.d(Fragment.this, fragment2, z, f2, false);
                View view3 = view2;
                if (view3 != null) {
                    fragmentTransitionImpl.f(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void l(FragmentManagerImpl fragmentManagerImpl, int i2, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl h2;
        Object obj;
        ViewGroup viewGroup = fragmentManagerImpl.A.onHasView() ? (ViewGroup) fragmentManagerImpl.A.onFindViewById(i2) : null;
        if (viewGroup == null || (h2 = h((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        Object p = p(h2, fragment, z);
        Object q = q(h2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object j2 = j(h2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, p, q);
        if (p == null && j2 == null) {
            obj = q;
            if (obj == null) {
                return;
            }
        } else {
            obj = q;
        }
        ArrayList<View> i3 = i(h2, obj, fragment2, arrayList, view);
        Object obj2 = (i3 == null || i3.isEmpty()) ? null : obj;
        h2.addTarget(p, view);
        Object t = t(h2, p, obj2, j2, fragment, fragmentContainerTransition.lastInIsPop);
        if (t != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            h2.scheduleRemoveTargets(t, p, arrayList3, obj2, i3, j2, arrayList2);
            x(h2, viewGroup, fragment, view, arrayList2, p, arrayList3, obj2, i3);
            h2.j(viewGroup, arrayList2, arrayMap);
            h2.beginDelayedTransition(viewGroup, t);
            h2.i(viewGroup, arrayList2, arrayMap);
        }
    }

    private static void m(FragmentManagerImpl fragmentManagerImpl, int i2, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl h2;
        Object obj;
        ViewGroup viewGroup = fragmentManagerImpl.A.onHasView() ? (ViewGroup) fragmentManagerImpl.A.onFindViewById(i2) : null;
        if (viewGroup == null || (h2 = h((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object p = p(h2, fragment, z);
        Object q = q(h2, fragment2, z2);
        Object k = k(h2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, p, q);
        if (p == null && k == null) {
            obj = q;
            if (obj == null) {
                return;
            }
        } else {
            obj = q;
        }
        ArrayList<View> i3 = i(h2, obj, fragment2, arrayList2, view);
        ArrayList<View> i4 = i(h2, p, fragment, arrayList, view);
        z(i4, 4);
        Object t = t(h2, p, obj, k, fragment, z);
        if (t != null) {
            u(h2, obj, fragment2, i3);
            ArrayList<String> h3 = h2.h(arrayList);
            h2.scheduleRemoveTargets(t, p, i4, obj, i3, k, arrayList);
            h2.beginDelayedTransition(viewGroup, t);
            h2.k(viewGroup, arrayList2, arrayList, h3, arrayMap);
            z(i4, 0);
            h2.swapSharedElementTargets(k, arrayList2, arrayList);
        }
    }

    private static FragmentContainerTransition n(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i2) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i2, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    private static String o(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(arrayMap.valueAt(i2))) {
                return arrayMap.keyAt(i2);
            }
        }
        return null;
    }

    private static Object p(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object q(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View r(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        ArrayList<String> arrayList;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.z) == null || arrayList.isEmpty()) {
            return null;
        }
        return arrayMap.get(z ? backStackRecord.z.get(0) : backStackRecord.A.get(0));
    }

    private static Object s(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object t(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3) : fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void u(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.1

                /* renamed from: a */
                final /* synthetic */ ArrayList f2465a;

                AnonymousClass1(ArrayList arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.z(arrayList, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl v() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void w(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void x(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.2

            /* renamed from: a */
            final /* synthetic */ Object f2466a;

            /* renamed from: b */
            final /* synthetic */ FragmentTransitionImpl f2467b;

            /* renamed from: c */
            final /* synthetic */ View f2468c;

            /* renamed from: d */
            final /* synthetic */ Fragment f2469d;

            /* renamed from: e */
            final /* synthetic */ ArrayList f2470e;

            /* renamed from: f */
            final /* synthetic */ ArrayList f2471f;

            /* renamed from: g */
            final /* synthetic */ ArrayList f2472g;

            /* renamed from: h */
            final /* synthetic */ Object f2473h;

            AnonymousClass2(Object obj3, FragmentTransitionImpl fragmentTransitionImpl2, View view2, Fragment fragment2, ArrayList arrayList4, ArrayList arrayList22, ArrayList arrayList32, Object obj22) {
                obj = obj3;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                view = view2;
                fragment = fragment2;
                arrayList = arrayList4;
                arrayList2 = arrayList22;
                arrayList3 = arrayList32;
                obj2 = obj22;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    fragmentTransitionImpl.removeTarget(obj3, view);
                    arrayList2.addAll(FragmentTransition.i(fragmentTransitionImpl, obj, fragment, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        fragmentTransitionImpl.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void y(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        ArrayList<String> arrayList = backStackRecord.z;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = arrayMap.get(z ? backStackRecord.A.get(0) : backStackRecord.z.get(0));
        fragmentTransitionImpl.setEpicenter(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.setEpicenter(obj2, view);
        }
    }

    static void z(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }
}
