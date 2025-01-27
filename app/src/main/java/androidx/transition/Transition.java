package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    public static final int MATCH_ID = 3;
    public static final int MATCH_INSTANCE = 1;
    public static final int MATCH_ITEM_ID = 4;
    public static final int MATCH_NAME = 2;

    /* renamed from: a */
    private static final String f3814a = "Transition";

    /* renamed from: b */
    static final boolean f3815b = false;

    /* renamed from: c */
    private static final int f3816c = 1;

    /* renamed from: d */
    private static final int f3817d = 4;

    /* renamed from: e */
    private static final String f3818e = "instance";

    /* renamed from: f */
    private static final String f3819f = "name";

    /* renamed from: g */
    private static final String f3820g = "id";

    /* renamed from: h */
    private static final String f3821h = "itemId";

    /* renamed from: i */
    private static final int[] f3822i = {2, 1, 3, 4};

    /* renamed from: j */
    private static final PathMotion f3823j = new PathMotion() { // from class: androidx.transition.Transition.1
        AnonymousClass1() {
        }

        @Override // androidx.transition.PathMotion
        public Path getPath(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> k = new ThreadLocal<>();
    private ArrayList<TransitionValues> E;
    private ArrayList<TransitionValues> F;
    TransitionPropagation O;
    private EpicenterCallback P;
    private ArrayMap<String, String> Q;
    private String l = getClass().getName();
    private long m = -1;
    long n = -1;
    private TimeInterpolator o = null;
    ArrayList<Integer> p = new ArrayList<>();
    ArrayList<View> q = new ArrayList<>();
    private ArrayList<String> r = null;
    private ArrayList<Class<?>> s = null;
    private ArrayList<Integer> t = null;
    private ArrayList<View> u = null;
    private ArrayList<Class<?>> v = null;
    private ArrayList<String> w = null;
    private ArrayList<Integer> x = null;
    private ArrayList<View> y = null;
    private ArrayList<Class<?>> z = null;
    private TransitionValuesMaps A = new TransitionValuesMaps();
    private TransitionValuesMaps B = new TransitionValuesMaps();
    TransitionSet C = null;
    private int[] D = f3822i;
    private ViewGroup G = null;
    boolean H = false;
    ArrayList<Animator> I = new ArrayList<>();
    private int J = 0;
    private boolean K = false;
    private boolean L = false;
    private ArrayList<TransitionListener> M = null;
    private ArrayList<Animator> N = new ArrayList<>();
    private PathMotion R = f3823j;

    /* renamed from: androidx.transition.Transition$1 */
    static class AnonymousClass1 extends PathMotion {
        AnonymousClass1() {
        }

        @Override // androidx.transition.PathMotion
        public Path getPath(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* renamed from: androidx.transition.Transition$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ArrayMap f3824a;

        AnonymousClass2(ArrayMap arrayMap) {
            arrayMap = arrayMap;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            arrayMap.remove(animator);
            Transition.this.I.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.I.add(animator);
        }
    }

    /* renamed from: androidx.transition.Transition$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.j();
            animator.removeListener(this);
        }
    }

    private static class AnimationInfo {

        /* renamed from: a */
        View f3827a;

        /* renamed from: b */
        String f3828b;

        /* renamed from: c */
        TransitionValues f3829c;

        /* renamed from: d */
        WindowIdImpl f3830d;

        /* renamed from: e */
        Transition f3831e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f3827a = view;
            this.f3828b = str;
            this.f3829c = transitionValues;
            this.f3830d = windowIdImpl;
            this.f3831e = transition;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    public Transition() {
    }

    private void B(Animator animator, ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2

                /* renamed from: a */
                final /* synthetic */ ArrayMap f3824a;

                AnonymousClass2(ArrayMap arrayMap2) {
                    arrayMap = arrayMap2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.I.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.I.add(animator2);
                }
            });
            d(animator);
        }
    }

    private void a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i2 = 0; i2 < arrayMap.size(); i2++) {
            TransitionValues valueAt = arrayMap.valueAt(i2);
            if (s(valueAt.view)) {
                this.E.add(valueAt);
                this.F.add(null);
            }
        }
        for (int i3 = 0; i3 < arrayMap2.size(); i3++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i3);
            if (s(valueAt2.view)) {
                this.F.add(valueAt2);
                this.E.add(null);
            }
        }
    }

    private static void b(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f3856a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f3857b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f3857b.put(id, null);
            } else {
                transitionValuesMaps.f3857b.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.f3859d.containsKey(transitionName)) {
                transitionValuesMaps.f3859d.put(transitionName, null);
            } else {
                transitionValuesMaps.f3859d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f3858c.indexOfKey(itemIdAtPosition) < 0) {
                    ViewCompat.setHasTransientState(view, true);
                    transitionValuesMaps.f3858c.put(itemIdAtPosition, view);
                    return;
                }
                View view2 = transitionValuesMaps.f3858c.get(itemIdAtPosition);
                if (view2 != null) {
                    ViewCompat.setHasTransientState(view2, false);
                    transitionValuesMaps.f3858c.put(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean c(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void e(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.t;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.u;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.v;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.v.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues(view);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f3855a.add(this);
                    f(transitionValues);
                    if (z) {
                        b(this.A, view, transitionValues);
                    } else {
                        b(this.B, view, transitionValues);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.x;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.y;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.z;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.z.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                e(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> k(ArrayList<Integer> arrayList, int i2, boolean z) {
        return i2 > 0 ? z ? ArrayListManager.a(arrayList, Integer.valueOf(i2)) : ArrayListManager.b(arrayList, Integer.valueOf(i2)) : arrayList;
    }

    private static <T> ArrayList<T> l(ArrayList<T> arrayList, T t, boolean z) {
        return t != null ? z ? ArrayListManager.a(arrayList, t) : ArrayListManager.b(arrayList, t) : arrayList;
    }

    private ArrayList<Class<?>> m(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        return cls != null ? z ? ArrayListManager.a(arrayList, cls) : ArrayListManager.b(arrayList, cls) : arrayList;
    }

    private ArrayList<View> n(ArrayList<View> arrayList, View view, boolean z) {
        return view != null ? z ? ArrayListManager.a(arrayList, view) : ArrayListManager.b(arrayList, view) : arrayList;
    }

    private static ArrayMap<Animator, AnimationInfo> q() {
        ArrayMap<Animator, AnimationInfo> arrayMap = k.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        k.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean r(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static boolean t(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void u(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && s(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && s(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.E.add(transitionValues);
                    this.F.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void v(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && s(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && s(remove.view)) {
                this.E.add(arrayMap.removeAt(size));
                this.F.add(remove);
            }
        }
    }

    private void w(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = longSparseArray.valueAt(i2);
            if (valueAt != null && s(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i2))) != null && s(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.E.add(transitionValues);
                    this.F.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void x(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = arrayMap3.valueAt(i2);
            if (valueAt != null && s(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i2))) != null && s(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.E.add(transitionValues);
                    this.F.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void y(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.f3856a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.f3856a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.D;
            if (i2 >= iArr.length) {
                a(arrayMap, arrayMap2);
                return;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                v(arrayMap, arrayMap2);
            } else if (i3 == 2) {
                x(arrayMap, arrayMap2, transitionValuesMaps.f3859d, transitionValuesMaps2.f3859d);
            } else if (i3 == 3) {
                u(arrayMap, arrayMap2, transitionValuesMaps.f3857b, transitionValuesMaps2.f3857b);
            } else if (i3 == 4) {
                w(arrayMap, arrayMap2, transitionValuesMaps.f3858c, transitionValuesMaps2.f3858c);
            }
            i2++;
        }
    }

    private static int[] z(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if (f3818e.equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if (f3821h.equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else {
                if (!trim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            }
            i2++;
        }
        return iArr;
    }

    void A(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        y(this.A, this.B);
        ArrayMap<Animator, AnimationInfo> q = q();
        int size = q.size();
        WindowIdImpl d2 = ViewUtils.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator keyAt = q.keyAt(i2);
            if (keyAt != null && (animationInfo = q.get(keyAt)) != null && animationInfo.f3827a != null && d2.equals(animationInfo.f3830d)) {
                TransitionValues transitionValues = animationInfo.f3829c;
                View view = animationInfo.f3827a;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues p = p(view, true);
                if (transitionValues2 == null && p == null) {
                    p = this.B.f3856a.get(view);
                }
                if (!(transitionValues2 == null && p == null) && animationInfo.f3831e.isTransitionRequired(transitionValues, p)) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        q.remove(keyAt);
                    }
                }
            }
        }
        i(viewGroup, this.A, this.B, this.E, this.F);
        C();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void C() {
        F();
        ArrayMap<Animator, AnimationInfo> q = q();
        Iterator<Animator> it = this.N.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q.containsKey(next)) {
                F();
                B(next, q);
            }
        }
        this.N.clear();
        j();
    }

    void D(boolean z) {
        this.H = z;
    }

    Transition E(ViewGroup viewGroup) {
        this.G = viewGroup;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void F() {
        if (this.J == 0) {
            ArrayList<TransitionListener> arrayList = this.M;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.M.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList2.get(i2)).onTransitionStart(this);
                }
            }
            this.L = false;
        }
        this.J++;
    }

    String G(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.n != -1) {
            str2 = str2 + "dur(" + this.n + ") ";
        }
        if (this.m != -1) {
            str2 = str2 + "dly(" + this.m + ") ";
        }
        if (this.o != null) {
            str2 = str2 + "interp(" + this.o + ") ";
        }
        if (this.p.size() <= 0 && this.q.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.p.size() > 0) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.p.get(i2);
            }
        }
        if (this.q.size() > 0) {
            for (int i3 = 0; i3 < this.q.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.q.get(i3);
            }
        }
        return str3 + ")";
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.M == null) {
            this.M = new ArrayList<>();
        }
        this.M.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.q.add(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            this.I.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.M;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.M.clone();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((TransitionListener) arrayList2.get(i2)).onTransitionCancel(this);
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void d(Animator animator) {
        if (animator == null) {
            j();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            AnonymousClass3() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.j();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z) {
        this.y = n(this.y, view, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        this.u = n(this.u, view, z);
        return this;
    }

    void f(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.O == null || transitionValues.values.isEmpty() || (propagationProperties = this.O.getPropagationProperties()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= propagationProperties.length) {
                z = true;
                break;
            } else if (!transitionValues.values.containsKey(propagationProperties[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.O.captureValues(transitionValues);
    }

    void g(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        h(z);
        if ((this.p.size() > 0 || this.q.size() > 0) && (((arrayList = this.r) == null || arrayList.isEmpty()) && ((arrayList2 = this.s) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.p.get(i2).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f3855a.add(this);
                    f(transitionValues);
                    if (z) {
                        b(this.A, findViewById, transitionValues);
                    } else {
                        b(this.B, findViewById, transitionValues);
                    }
                }
            }
            for (int i3 = 0; i3 < this.q.size(); i3++) {
                View view = this.q.get(i3);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.f3855a.add(this);
                f(transitionValues2);
                if (z) {
                    b(this.A, view, transitionValues2);
                } else {
                    b(this.B, view, transitionValues2);
                }
            }
        } else {
            e(viewGroup, z);
        }
        if (z || (arrayMap = this.Q) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.A.f3859d.remove(this.Q.keyAt(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.A.f3859d.put(this.Q.valueAt(i5), view2);
            }
        }
    }

    public long getDuration() {
        return this.n;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.P;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.P;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.o;
    }

    @NonNull
    public String getName() {
        return this.l;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.R;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.O;
    }

    public long getStartDelay() {
        return this.m;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.p;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.r;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.s;
    }

    @NonNull
    public List<View> getTargets() {
        return this.q;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z) {
        TransitionSet transitionSet = this.C;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.A : this.B).f3856a.get(view);
    }

    void h(boolean z) {
        if (z) {
            this.A.f3856a.clear();
            this.A.f3857b.clear();
            this.A.f3858c.clear();
        } else {
            this.B.f3856a.clear();
            this.B.f3857b.clear();
            this.B.f3858c.clear();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void i(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Animator createAnimator;
        int i2;
        int i3;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        ArrayMap<Animator, AnimationInfo> q = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            TransitionValues transitionValues3 = arrayList.get(i4);
            TransitionValues transitionValues4 = arrayList2.get(i4);
            if (transitionValues3 != null && !transitionValues3.f3855a.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f3855a.contains(this)) {
                transitionValues4 = null;
            }
            if (transitionValues3 != null || transitionValues4 != null) {
                if ((transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) && (createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            i2 = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.f3856a.get(view);
                            if (transitionValues5 != null) {
                                int i5 = 0;
                                while (i5 < transitionProperties.length) {
                                    transitionValues2.values.put(transitionProperties[i5], transitionValues5.values.get(transitionProperties[i5]));
                                    i5++;
                                    i4 = i4;
                                    transitionValues5 = transitionValues5;
                                }
                            }
                            i3 = i4;
                            int size2 = q.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = createAnimator;
                                    break;
                                }
                                AnimationInfo animationInfo = q.get(q.keyAt(i6));
                                if (animationInfo.f3829c != null && animationInfo.f3827a == view && animationInfo.f3828b.equals(getName()) && animationInfo.f3829c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            i3 = i4;
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = transitionValues3.view;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.O;
                        if (transitionPropagation != null) {
                            long startDelay = transitionPropagation.getStartDelay(viewGroup, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.N.size(), (int) startDelay);
                            j2 = Math.min(startDelay, j2);
                        }
                        q.put(animator, new AnimationInfo(view, getName(), this, ViewUtils.d(viewGroup), transitionValues));
                        this.N.add(animator);
                        j2 = j2;
                    }
                    i4 = i3 + 1;
                    size = i2;
                }
            }
            i2 = size;
            i3 = i4;
            i4 = i3 + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.N.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j2) + animator3.getStartDelay());
            }
        }
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties == null) {
            Iterator<String> it = transitionValues.values.keySet().iterator();
            while (it.hasNext()) {
                if (t(transitionValues, transitionValues2, it.next())) {
                }
            }
            return false;
        }
        for (String str : transitionProperties) {
            if (!t(transitionValues, transitionValues2, str)) {
            }
        }
        return false;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void j() {
        int i2 = this.J - 1;
        this.J = i2;
        if (i2 == 0) {
            ArrayList<TransitionListener> arrayList = this.M;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.M.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((TransitionListener) arrayList2.get(i3)).onTransitionEnd(this);
                }
            }
            for (int i4 = 0; i4 < this.A.f3858c.size(); i4++) {
                View valueAt = this.A.f3858c.valueAt(i4);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i5 = 0; i5 < this.B.f3858c.size(); i5++) {
                View valueAt2 = this.B.f3858c.valueAt(i5);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.L = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void o(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> q = q();
        int size = q.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        WindowIdImpl d2 = ViewUtils.d(viewGroup);
        ArrayMap arrayMap = new ArrayMap(q);
        q.clear();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(i2);
            if (animationInfo.f3827a != null && d2 != null && d2.equals(animationInfo.f3830d)) {
                ((Animator) arrayMap.keyAt(i2)).end();
            }
        }
    }

    TransitionValues p(View view, boolean z) {
        TransitionSet transitionSet = this.C;
        if (transitionSet != null) {
            return transitionSet.p(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.E : this.F;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i3);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.F : this.E).get(i2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        if (this.L) {
            return;
        }
        ArrayMap<Animator, AnimationInfo> q = q();
        int size = q.size();
        WindowIdImpl d2 = ViewUtils.d(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AnimationInfo valueAt = q.valueAt(i2);
            if (valueAt.f3827a != null && d2.equals(valueAt.f3830d)) {
                AnimatorUtils.b(q.keyAt(i2));
            }
        }
        ArrayList<TransitionListener> arrayList = this.M;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.M.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((TransitionListener) arrayList2.get(i3)).onTransitionPause(this);
            }
        }
        this.K = true;
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.M;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.M.size() == 0) {
            this.M = null;
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.q.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        if (this.K) {
            if (!this.L) {
                ArrayMap<Animator, AnimationInfo> q = q();
                int size = q.size();
                WindowIdImpl d2 = ViewUtils.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    AnimationInfo valueAt = q.valueAt(i2);
                    if (valueAt.f3827a != null && d2.equals(valueAt.f3830d)) {
                        AnimatorUtils.c(q.keyAt(i2));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.M;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.M.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((TransitionListener) arrayList2.get(i3)).onTransitionResume(this);
                    }
                }
            }
            this.K = false;
        }
    }

    boolean s(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.t;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.u;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.v;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.v.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.w != null && ViewCompat.getTransitionName(view) != null && this.w.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.p.size() == 0 && this.q.size() == 0 && (((arrayList = this.s) == null || arrayList.isEmpty()) && ((arrayList2 = this.r) == null || arrayList2.isEmpty()))) || this.p.contains(Integer.valueOf(id)) || this.q.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.r;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.s != null) {
            for (int i3 = 0; i3 < this.s.size(); i3++) {
                if (this.s.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public Transition setDuration(long j2) {
        this.n = j2;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.P = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.o = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.D = f3822i;
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!r(iArr[i2])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (c(iArr, i2)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.D = (int[]) iArr.clone();
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.R = f3823j;
        } else {
            this.R = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.O = transitionPropagation;
    }

    @NonNull
    public Transition setStartDelay(long j2) {
        this.m = j2;
        return this;
    }

    public String toString() {
        return G("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i2) {
        if (i2 != 0) {
            this.p.add(Integer.valueOf(i2));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public Transition mo35clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.N = new ArrayList<>();
            transition.A = new TransitionValuesMaps();
            transition.B = new TransitionValuesMaps();
            transition.E = null;
            transition.F = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i2, boolean z) {
        this.x = k(this.x, i2, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i2, boolean z) {
        this.t = k(this.t, i2, z);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i2) {
        if (i2 != 0) {
            this.p.remove(Integer.valueOf(i2));
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(str);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z) {
        this.z = m(this.z, cls, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        this.w = l(this.w, str, z);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.r;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        this.v = m(this.v, cls, z);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.s;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3806c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(z(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
