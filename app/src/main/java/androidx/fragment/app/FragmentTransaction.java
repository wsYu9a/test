package androidx.fragment.app;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    /* renamed from: a */
    static final int f2444a = 0;

    /* renamed from: b */
    static final int f2445b = 1;

    /* renamed from: c */
    static final int f2446c = 2;

    /* renamed from: d */
    static final int f2447d = 3;

    /* renamed from: e */
    static final int f2448e = 4;

    /* renamed from: f */
    static final int f2449f = 5;

    /* renamed from: g */
    static final int f2450g = 6;

    /* renamed from: h */
    static final int f2451h = 7;

    /* renamed from: i */
    static final int f2452i = 8;

    /* renamed from: j */
    static final int f2453j = 9;
    static final int k = 10;
    ArrayList<String> A;
    ArrayList<Runnable> C;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    boolean s;

    @Nullable
    String u;
    int v;
    CharSequence w;
    int x;
    CharSequence y;
    ArrayList<String> z;
    ArrayList<Op> l = new ArrayList<>();
    boolean t = true;
    boolean B = false;

    static final class Op {

        /* renamed from: a */
        int f2454a;

        /* renamed from: b */
        Fragment f2455b;

        /* renamed from: c */
        int f2456c;

        /* renamed from: d */
        int f2457d;

        /* renamed from: e */
        int f2458e;

        /* renamed from: f */
        int f2459f;

        /* renamed from: g */
        Lifecycle.State f2460g;

        /* renamed from: h */
        Lifecycle.State f2461h;

        Op() {
        }

        Op(int i2, Fragment fragment) {
            this.f2454a = i2;
            this.f2455b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f2460g = state;
            this.f2461h = state;
        }

        Op(int i2, @NonNull Fragment fragment, Lifecycle.State state) {
            this.f2454a = i2;
            this.f2455b = fragment;
            this.f2460g = fragment.mMaxState;
            this.f2461h = state;
        }
    }

    void a(Op op) {
        this.l.add(op);
        op.f2456c = this.m;
        op.f2457d = this.n;
        op.f2458e = this.o;
        op.f2459f = this.p;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        b(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (FragmentTransition.B()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.z == null) {
                this.z = new ArrayList<>();
                this.A = new ArrayList<>();
            } else {
                if (this.A.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.z.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
            }
            this.z.add(transitionName);
            this.A.add(str);
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (!this.t) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.s = true;
        this.u = str;
        return this;
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        a(new Op(7, fragment));
        return this;
    }

    void b(int i2, Fragment fragment, @Nullable String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        a(new Op(i3, fragment));
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        a(new Op(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (this.s) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.t = false;
        return this;
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        a(new Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.t;
    }

    public boolean isEmpty() {
        return this.l.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        a(new Op(3, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i2, @NonNull Fragment fragment) {
        return replace(i2, fragment, null);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @NonNull
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i2) {
        this.x = i2;
        this.y = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i2) {
        this.v = i2;
        this.w = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        return setCustomAnimations(i2, i3, 0, 0);
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        a(new Op(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        a(new Op(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.B = z;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i2) {
        this.q = i2;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransitionStyle(@StyleRes int i2) {
        this.r = i2;
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        a(new Op(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i2, @NonNull Fragment fragment) {
        b(i2, fragment, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i2, @NonNull Fragment fragment, @Nullable String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        b(i2, fragment, str, 2);
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.p = i5;
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i2, @NonNull Fragment fragment, @Nullable String str) {
        b(i2, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.x = 0;
        this.y = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.v = 0;
        this.w = charSequence;
        return this;
    }
}
