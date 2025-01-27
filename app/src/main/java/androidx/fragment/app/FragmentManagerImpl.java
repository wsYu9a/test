package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.DebugUtils;
import androidx.core.util.LogWriter;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;

    /* renamed from: c */
    static boolean f2354c = false;

    /* renamed from: d */
    static final String f2355d = "FragmentManager";

    /* renamed from: e */
    static final String f2356e = "android:target_req_state";

    /* renamed from: f */
    static final String f2357f = "android:target_state";

    /* renamed from: g */
    static final String f2358g = "android:view_state";

    /* renamed from: h */
    static final String f2359h = "android:user_visible_hint";

    /* renamed from: i */
    static final Interpolator f2360i = new DecelerateInterpolator(2.5f);

    /* renamed from: j */
    static final Interpolator f2361j = new DecelerateInterpolator(1.5f);
    static final int k = 220;
    FragmentContainer A;
    Fragment B;

    @Nullable
    Fragment C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    ArrayList<BackStackRecord> I;
    ArrayList<Boolean> J;
    ArrayList<Fragment> K;
    ArrayList<StartEnterTransitionListener> N;
    private FragmentManagerViewModel O;
    ArrayList<OpGenerator> l;
    boolean m;
    ArrayList<BackStackRecord> q;
    ArrayList<Fragment> r;
    private OnBackPressedDispatcher s;
    ArrayList<BackStackRecord> u;
    ArrayList<Integer> v;
    ArrayList<FragmentManager.OnBackStackChangedListener> w;
    FragmentHostCallback z;
    int n = 0;
    final ArrayList<Fragment> o = new ArrayList<>();
    final HashMap<String, Fragment> p = new HashMap<>();
    private final OnBackPressedCallback t = new OnBackPressedCallback(false) { // from class: androidx.fragment.app.FragmentManagerImpl.1
        AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManagerImpl.this.Q();
        }
    };
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> x = new CopyOnWriteArrayList<>();
    int y = 0;
    Bundle L = null;
    SparseArray<Parcelable> M = null;
    Runnable P = new Runnable() { // from class: androidx.fragment.app.FragmentManagerImpl.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$1 */
    class AnonymousClass1 extends OnBackPressedCallback {
        AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManagerImpl.this.Q();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$3 */
    class AnonymousClass3 implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2364a;

        /* renamed from: b */
        final /* synthetic */ Fragment f2365b;

        /* renamed from: androidx.fragment.app.FragmentManagerImpl$3$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (fragment.getAnimatingAway() != null) {
                    fragment.setAnimatingAway(null);
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                    Fragment fragment = fragment;
                    fragmentManagerImpl.d0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        }

        AnonymousClass3(ViewGroup viewGroup, Fragment fragment) {
            viewGroup = viewGroup;
            fragment = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            viewGroup.post(new Runnable() { // from class: androidx.fragment.app.FragmentManagerImpl.3.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (fragment.getAnimatingAway() != null) {
                        fragment.setAnimatingAway(null);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                        Fragment fragment = fragment;
                        fragmentManagerImpl.d0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                    }
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$4 */
    class AnonymousClass4 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2368a;

        /* renamed from: b */
        final /* synthetic */ View f2369b;

        /* renamed from: c */
        final /* synthetic */ Fragment f2370c;

        AnonymousClass4(ViewGroup viewGroup, View view, Fragment fragment) {
            viewGroup = viewGroup;
            view = view;
            fragment = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            viewGroup.endViewTransition(view);
            Animator animator2 = fragment.getAnimator();
            fragment.setAnimator(null);
            if (animator2 == null || viewGroup.indexOfChild(view) >= 0) {
                return;
            }
            FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
            Fragment fragment = fragment;
            fragmentManagerImpl.d0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2372a;

        /* renamed from: b */
        final /* synthetic */ View f2373b;

        /* renamed from: c */
        final /* synthetic */ Fragment f2374c;

        AnonymousClass5(ViewGroup viewGroup, View view, Fragment fragment) {
            viewGroup = viewGroup;
            view = view;
            fragment = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            viewGroup.endViewTransition(view);
            animator.removeListener(this);
            Fragment fragment = fragment;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManagerImpl$6 */
    class AnonymousClass6 extends FragmentFactory {
        AnonymousClass6() {
        }

        @Override // androidx.fragment.app.FragmentFactory
        @NonNull
        public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
            FragmentHostCallback fragmentHostCallback = FragmentManagerImpl.this.z;
            return fragmentHostCallback.instantiate(fragmentHostCallback.getContext(), str, null);
        }
    }

    private static final class FragmentLifecycleCallbacksHolder {

        /* renamed from: a */
        final FragmentManager.FragmentLifecycleCallbacks f2382a;

        /* renamed from: b */
        final boolean f2383b;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.f2382a = fragmentLifecycleCallbacks;
            this.f2383b = z;
        }
    }

    static class FragmentTag {
        public static final int[] Fragment = {R.attr.name, R.attr.id, R.attr.tag};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        private FragmentTag() {
        }
    }

    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class PopBackStackState implements OpGenerator {

        /* renamed from: a */
        final String f2384a;

        /* renamed from: b */
        final int f2385b;

        /* renamed from: c */
        final int f2386c;

        PopBackStackState(String str, int i2, int i3) {
            this.f2384a = str;
            this.f2385b = i2;
            this.f2386c = i3;
        }

        @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManagerImpl.this.C;
            if (fragment == null || this.f2385b >= 0 || this.f2384a != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManagerImpl.this.f0(arrayList, arrayList2, this.f2384a, this.f2385b, this.f2386c);
            }
            return false;
        }
    }

    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {

        /* renamed from: a */
        final boolean f2388a;

        /* renamed from: b */
        final BackStackRecord f2389b;

        /* renamed from: c */
        private int f2390c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.f2388a = z;
            this.f2389b = backStackRecord;
        }

        public void cancelTransaction() {
            BackStackRecord backStackRecord = this.f2389b;
            backStackRecord.E.i(backStackRecord, this.f2388a, false, false);
        }

        public void completeTransaction() {
            boolean z = this.f2390c > 0;
            FragmentManagerImpl fragmentManagerImpl = this.f2389b.E;
            int size = fragmentManagerImpl.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = fragmentManagerImpl.o.get(i2);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            BackStackRecord backStackRecord = this.f2389b;
            backStackRecord.E.i(backStackRecord, this.f2388a, !z, true);
        }

        public boolean isReady() {
            return this.f2390c == 0;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            int i2 = this.f2390c - 1;
            this.f2390c = i2;
            if (i2 != 0) {
                return;
            }
            this.f2389b.E.q0();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.f2390c++;
        }
    }

    FragmentManagerImpl() {
    }

    private void A(int i2) {
        try {
            this.m = true;
            b0(i2, false);
            this.m = false;
            execPendingActions();
        } catch (Throwable th) {
            this.m = false;
            throw th;
        }
    }

    private void C() {
        for (Fragment fragment : this.p.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    d0(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    private void D(boolean z) {
        if (this.m) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.z == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.z.a().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            g();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
            this.J = new ArrayList<>();
        }
        this.m = true;
        try {
            H(null, null);
        } finally {
            this.m = false;
        }
    }

    private static void F(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            BackStackRecord backStackRecord = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                backStackRecord.c(-1);
                backStackRecord.f(i2 == i3 + (-1));
            } else {
                backStackRecord.c(1);
                backStackRecord.e();
            }
            i2++;
        }
    }

    private void G(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        boolean z = arrayList.get(i6).B;
        ArrayList<Fragment> arrayList3 = this.K;
        if (arrayList3 == null) {
            this.K = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.K.addAll(this.o);
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i7 = i6; i7 < i3; i7++) {
            BackStackRecord backStackRecord = arrayList.get(i7);
            primaryNavigationFragment = !arrayList2.get(i7).booleanValue() ? backStackRecord.g(this.K, primaryNavigationFragment) : backStackRecord.m(this.K, primaryNavigationFragment);
            z2 = z2 || backStackRecord.s;
        }
        this.K.clear();
        if (!z) {
            FragmentTransition.A(this, arrayList, arrayList2, i2, i3, false);
        }
        F(arrayList, arrayList2, i2, i3);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            a(arraySet);
            int g0 = g0(arrayList, arrayList2, i2, i3, arraySet);
            Z(arraySet);
            i4 = g0;
        } else {
            i4 = i3;
        }
        if (i4 != i6 && z) {
            FragmentTransition.A(this, arrayList, arrayList2, i2, i4, true);
            b0(this.y, true);
        }
        while (i6 < i3) {
            BackStackRecord backStackRecord2 = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue() && (i5 = backStackRecord2.G) >= 0) {
                freeBackStackIndex(i5);
                backStackRecord2.G = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i6++;
        }
        if (z2) {
            j0();
        }
    }

    private void H(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.N;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.N.get(i2);
            if (arrayList != null && !startEnterTransitionListener.f2388a && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.f2389b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                this.N.remove(i2);
                i2--;
                size--;
                startEnterTransitionListener.cancelTransaction();
            } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.f2389b.i(arrayList, 0, arrayList.size()))) {
                this.N.remove(i2);
                i2--;
                size--;
                if (arrayList == null || startEnterTransitionListener.f2388a || (indexOf = arrayList.indexOf(startEnterTransitionListener.f2389b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.completeTransaction();
                } else {
                    startEnterTransitionListener.cancelTransaction();
                }
            }
            i2++;
        }
    }

    private Fragment I(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.o.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.o.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void J() {
        if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).completeTransaction();
            }
        }
    }

    private boolean K(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            ArrayList<OpGenerator> arrayList3 = this.l;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size = this.l.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= this.l.get(i2).generateOps(arrayList, arrayList2);
                }
                this.l.clear();
                this.z.a().removeCallbacks(this.P);
                return z;
            }
            return false;
        }
    }

    private boolean R(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.f();
    }

    static AnimationOrAnimator W(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f2361j);
        alphaAnimation.setDuration(220L);
        return new AnimationOrAnimator(alphaAnimation);
    }

    static AnimationOrAnimator Y(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f2360i);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f2361j);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    private void Z(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment valueAt = arraySet.valueAt(i2);
            if (!valueAt.mAdded) {
                View requireView = valueAt.requireView();
                valueAt.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private void a(ArraySet<Fragment> arraySet) {
        int i2 = this.y;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        int size = this.o.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.o.get(i3);
            if (fragment.mState < min) {
                d0(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void d(@NonNull Fragment fragment, @NonNull AnimationOrAnimator animationOrAnimator, int i2) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i2);
        if (animationOrAnimator.animation != null) {
            EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.FragmentManagerImpl.3

                /* renamed from: a */
                final /* synthetic */ ViewGroup f2364a;

                /* renamed from: b */
                final /* synthetic */ Fragment f2365b;

                /* renamed from: androidx.fragment.app.FragmentManagerImpl$3$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (fragment.getAnimatingAway() != null) {
                            fragment.setAnimatingAway(null);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                            Fragment fragment = fragment;
                            fragmentManagerImpl.d0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                        }
                    }
                }

                AnonymousClass3(ViewGroup viewGroup2, Fragment fragment2) {
                    viewGroup = viewGroup2;
                    fragment = fragment2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.FragmentManagerImpl.3.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                                Fragment fragment2 = fragment;
                                fragmentManagerImpl.d0(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            fragment2.mView.startAnimation(endViewTransitionAnimation);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment2.setAnimator(animator);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentManagerImpl.4

            /* renamed from: a */
            final /* synthetic */ ViewGroup f2368a;

            /* renamed from: b */
            final /* synthetic */ View f2369b;

            /* renamed from: c */
            final /* synthetic */ Fragment f2370c;

            AnonymousClass4(ViewGroup viewGroup2, View view2, Fragment fragment2) {
                viewGroup = viewGroup2;
                view = view2;
                fragment = fragment2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator22 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator22 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                Fragment fragment2 = fragment;
                fragmentManagerImpl.d0(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(fragment2.mView);
        animator.start();
    }

    private void e() {
        this.p.values().removeAll(Collections.singleton(null));
    }

    private boolean e0(String str, int i2, int i3) {
        execPendingActions();
        D(true);
        Fragment fragment = this.C;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean f0 = f0(this.I, this.J, str, i2, i3);
        if (f0) {
            this.m = true;
            try {
                h0(this.I, this.J);
            } finally {
                h();
            }
        }
        t0();
        B();
        e();
        return f0;
    }

    private void g() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private int g0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, ArraySet<Fragment> arraySet) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (backStackRecord.k() && !backStackRecord.i(arrayList, i5 + 1, i3)) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.N.add(startEnterTransitionListener);
                backStackRecord.l(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.e();
                } else {
                    backStackRecord.f(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, backStackRecord);
                }
                a(arraySet);
            }
        }
        return i4;
    }

    private void h() {
        this.m = false;
        this.J.clear();
        this.I.clear();
    }

    private void h0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        H(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).B) {
                if (i3 != i2) {
                    G(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).B) {
                        i3++;
                    }
                }
                G(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            G(arrayList, arrayList2, i3, size);
        }
    }

    public static int reverseTransit(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void s0(RuntimeException runtimeException) {
        Log.e(f2355d, runtimeException.getMessage());
        Log.e(f2355d, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(f2355d));
        FragmentHostCallback fragmentHostCallback = this.z;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e(f2355d, "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e(f2355d, "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void t0() {
        ArrayList<OpGenerator> arrayList = this.l;
        if (arrayList == null || arrayList.isEmpty()) {
            this.t.setEnabled(getBackStackEntryCount() > 0 && S(this.B));
        } else {
            this.t.setEnabled(true);
        }
    }

    public static int transitToStyleIndex(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? 1 : 2;
        }
        if (i2 == 4099) {
            return z ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void y(@Nullable Fragment fragment) {
        if (fragment == null || this.p.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    void B() {
        if (this.H) {
            this.H = false;
            r0();
        }
    }

    void E(Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view == null) {
            fragment.mInnerView = null;
            return;
        }
        fragment.mInnerView = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.mHidden) {
            fragment.mView.setVisibility(8);
        }
        fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
        w(fragment, fragment.mView, fragment.mSavedFragmentState, false);
    }

    int L() {
        return this.p.size();
    }

    @NonNull
    List<Fragment> M() {
        return new ArrayList(this.p.values());
    }

    @NonNull
    FragmentManagerViewModel N(@NonNull Fragment fragment) {
        return this.O.h(fragment);
    }

    LayoutInflater.Factory2 O() {
        return this;
    }

    @NonNull
    ViewModelStore P(@NonNull Fragment fragment) {
        return this.O.l(fragment);
    }

    void Q() {
        execPendingActions();
        if (this.t.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.s.onBackPressed();
        }
    }

    boolean S(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        return fragment == fragmentManagerImpl.getPrimaryNavigationFragment() && S(fragmentManagerImpl.B);
    }

    boolean T(int i2) {
        return this.y >= i2;
    }

    AnimationOrAnimator U(Fragment fragment, int i2, boolean z, int i3) {
        int transitToStyleIndex;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i2, z, nextAnim);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i2, z, nextAnim);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.z.getContext().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.z.getContext(), nextAnim);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.z.getContext(), nextAnim);
                    if (loadAnimator != null) {
                        return new AnimationOrAnimator(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.z.getContext(), nextAnim);
                    if (loadAnimation2 != null) {
                        return new AnimationOrAnimator(loadAnimation2);
                    }
                }
            }
        }
        if (i2 == 0 || (transitToStyleIndex = transitToStyleIndex(i2, z)) < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return Y(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return Y(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return Y(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return Y(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return W(0.0f, 1.0f);
            case 6:
                return W(1.0f, 0.0f);
            default:
                if (i3 == 0 && this.z.onHasWindowAnimations()) {
                    i3 = this.z.onGetWindowAnimations();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    void V(Fragment fragment) {
        if (this.p.get(fragment.mWho) != null) {
            return;
        }
        this.p.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                c(fragment);
            } else {
                i0(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (f2354c) {
            Log.v(f2355d, "Added fragment to active set " + fragment);
        }
    }

    void X(Fragment fragment) {
        if (this.p.get(fragment.mWho) == null) {
            return;
        }
        if (f2354c) {
            Log.v(f2355d, "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.p.values()) {
            if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                fragment2.mTarget = fragment;
                fragment2.mTargetWho = null;
            }
        }
        this.p.put(fragment.mWho, null);
        i0(fragment);
        String str = fragment.mTargetWho;
        if (str != null) {
            fragment.mTarget = this.p.get(str);
        }
        fragment.initState();
    }

    void a0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.p.containsKey(fragment.mWho)) {
            if (f2354c) {
                Log.v(f2355d, "Ignoring moving " + fragment + " to state " + this.y + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i2 = this.y;
        if (fragment.mRemoving) {
            i2 = fragment.isInBackStack() ? Math.min(i2, 1) : Math.min(i2, 0);
        }
        d0(fragment, i2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            Fragment I = I(fragment);
            if (I != null) {
                View view = I.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.mView, indexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                AnimationOrAnimator U = U(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (U != null) {
                    Animation animation = U.animation;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        U.animator.setTarget(fragment.mView);
                        U.animator.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            j(fragment);
        }
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (f2354c) {
            Log.v(f2355d, "add: " + fragment);
        }
        V(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.o.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.o) {
            this.o.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (R(fragment)) {
            this.D = true;
        }
        if (z) {
            c0(fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            ArrayList<Integer> arrayList = this.v;
            if (arrayList != null && arrayList.size() > 0) {
                int intValue = this.v.remove(r0.size() - 1).intValue();
                if (f2354c) {
                    Log.v(f2355d, "Adding back stack index " + intValue + " with " + backStackRecord);
                }
                this.u.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            int size = this.u.size();
            if (f2354c) {
                Log.v(f2355d, "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.u.add(backStackRecord);
            return size;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(@NonNull FragmentHostCallback fragmentHostCallback, @NonNull FragmentContainer fragmentContainer, @Nullable Fragment fragment) {
        if (this.z != null) {
            throw new IllegalStateException("Already attached");
        }
        this.z = fragmentHostCallback;
        this.A = fragmentContainer;
        this.B = fragment;
        if (fragment != null) {
            t0();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.s = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.addCallback(lifecycleOwner, this.t);
        }
        if (fragment != null) {
            this.O = fragment.mFragmentManager.N(fragment);
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            this.O = FragmentManagerViewModel.i(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
        } else {
            this.O = new FragmentManagerViewModel(false);
        }
    }

    public void attachFragment(Fragment fragment) {
        if (f2354c) {
            Log.v(f2355d, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.o.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f2354c) {
                Log.v(f2355d, "add from attach: " + fragment);
            }
            synchronized (this.o) {
                this.o.add(fragment);
            }
            fragment.mAdded = true;
            if (R(fragment)) {
                this.D = true;
            }
        }
    }

    void b(BackStackRecord backStackRecord) {
        if (this.q == null) {
            this.q = new ArrayList<>();
        }
        this.q.add(backStackRecord);
    }

    void b0(int i2, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.z == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.y) {
            this.y = i2;
            int size = this.o.size();
            for (int i3 = 0; i3 < size; i3++) {
                a0(this.o.get(i3));
            }
            for (Fragment fragment : this.p.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        a0(fragment);
                    }
                }
            }
            r0();
            if (this.D && (fragmentHostCallback = this.z) != null && this.y == 4) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    void c(@NonNull Fragment fragment) {
        if (isStateSaved()) {
            if (f2354c) {
                Log.v(f2355d, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.O.f(fragment) && f2354c) {
            Log.v(f2355d, "Updating retained Fragments: Added " + fragment);
        }
    }

    void c0(Fragment fragment) {
        d0(fragment, this.y, 0, 0, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r0 != 3) goto L538;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d0(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerImpl.d0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    public void detachFragment(Fragment fragment) {
        if (f2354c) {
            Log.v(f2355d, "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f2354c) {
                Log.v(f2355d, "remove from detach: " + fragment);
            }
            synchronized (this.o) {
                this.o.remove(fragment);
            }
            if (R(fragment)) {
                this.D = true;
            }
            fragment.mAdded = false;
        }
    }

    public void dispatchActivityCreated() {
        this.E = false;
        this.F = false;
        A(2);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.y < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.E = false;
        this.F = false;
        A(1);
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.y < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.r != null) {
            for (int i3 = 0; i3 < this.r.size(); i3++) {
                Fragment fragment2 = this.r.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.r = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.G = true;
        execPendingActions();
        A(0);
        this.z = null;
        this.A = null;
        this.B = null;
        if (this.s != null) {
            this.t.remove();
            this.s = null;
        }
    }

    public void dispatchDestroyView() {
        A(1);
    }

    public void dispatchLowMemory() {
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.o.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.y < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        if (this.y < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        A(3);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.o.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        if (this.y < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchResume() {
        this.E = false;
        this.F = false;
        A(4);
    }

    public void dispatchStart() {
        this.E = false;
        this.F = false;
        A(3);
    }

    public void dispatchStop() {
        this.F = true;
        A(2);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.p.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.p.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.o.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.o.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.r;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.r.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.q;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.q.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
            }
        }
        synchronized (this) {
            ArrayList<BackStackRecord> arrayList3 = this.u;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (BackStackRecord) this.u.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            ArrayList<Integer> arrayList4 = this.v;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.v.toArray()));
            }
        }
        ArrayList<OpGenerator> arrayList5 = this.l;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (OpGenerator) this.l.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.A);
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.B);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.y);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void enqueueAction(androidx.fragment.app.FragmentManagerImpl.OpGenerator r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.g()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.G     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            androidx.fragment.app.FragmentHostCallback r0 = r1.z     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<androidx.fragment.app.FragmentManagerImpl$OpGenerator> r3 = r1.l     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.l = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<androidx.fragment.app.FragmentManagerImpl$OpGenerator> r3 = r1.l     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.q0()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerImpl.enqueueAction(androidx.fragment.app.FragmentManagerImpl$OpGenerator, boolean):void");
    }

    public boolean execPendingActions() {
        D(true);
        boolean z = false;
        while (K(this.I, this.J)) {
            this.m = true;
            try {
                h0(this.I, this.J);
                h();
                z = true;
            } catch (Throwable th) {
                h();
                throw th;
            }
        }
        t0();
        B();
        e();
        return z;
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (z && (this.z == null || this.G)) {
            return;
        }
        D(z);
        if (opGenerator.generateOps(this.I, this.J)) {
            this.m = true;
            try {
                h0(this.I, this.J);
            } finally {
                h();
            }
        }
        t0();
        B();
        e();
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        J();
        return execPendingActions;
    }

    boolean f() {
        boolean z = false;
        for (Fragment fragment : this.p.values()) {
            if (fragment != null) {
                z = R(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    boolean f0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<BackStackRecord> arrayList3 = this.q;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.q.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = this.q.get(size2);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i2 >= 0 && i2 == backStackRecord.G)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.q.get(size2);
                        if (str == null || !str.equals(backStackRecord2.getName())) {
                            if (i2 < 0 || i2 != backStackRecord2.G) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.q.size() - 1) {
                return false;
            }
            for (int size3 = this.q.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.q.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentById(int i2) {
        for (int size = this.o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.o.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.p.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i2) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        if (str != null) {
            for (int size = this.o.size() - 1; size >= 0; size--) {
                Fragment fragment = this.o.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.p.values()) {
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(@NonNull String str) {
        Fragment findFragmentByWho;
        for (Fragment fragment : this.p.values()) {
            if (fragment != null && (findFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i2) {
        synchronized (this) {
            this.u.set(i2, null);
            if (this.v == null) {
                this.v = new ArrayList<>();
            }
            if (f2354c) {
                Log.v(f2355d, "Freeing back stack index " + i2);
            }
            this.v.add(Integer.valueOf(i2));
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public FragmentManager.BackStackEntry getBackStackEntryAt(int i2) {
        return this.q.get(i2);
    }

    @Override // androidx.fragment.app.FragmentManager
    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.q;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.p.get(string);
        if (fragment == null) {
            s0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentFactory getFragmentFactory() {
        if (super.getFragmentFactory() == FragmentManager.f2352a) {
            Fragment fragment = this.B;
            if (fragment != null) {
                return fragment.mFragmentManager.getFragmentFactory();
            }
            setFragmentFactory(new FragmentFactory() { // from class: androidx.fragment.app.FragmentManagerImpl.6
                AnonymousClass6() {
                }

                @Override // androidx.fragment.app.FragmentFactory
                @NonNull
                public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
                    FragmentHostCallback fragmentHostCallback = FragmentManagerImpl.this.z;
                    return fragmentHostCallback.instantiate(fragmentHostCallback.getContext(), str, null);
                }
            });
        }
        return super.getFragmentFactory();
    }

    @Override // androidx.fragment.app.FragmentManager
    public List<Fragment> getFragments() {
        List<Fragment> list;
        if (this.o.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.o) {
            list = (List) this.o.clone();
        }
        return list;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.C;
    }

    public void hideFragment(Fragment fragment) {
        if (f2354c) {
            Log.v(f2355d, "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    void i(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.f(z3);
        } else {
            backStackRecord.e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.A(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            b0(this.y, true);
        }
        for (Fragment fragment : this.p.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.h(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    void i0(@NonNull Fragment fragment) {
        if (isStateSaved()) {
            if (f2354c) {
                Log.v(f2355d, "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.O.n(fragment) && f2354c) {
            Log.v(f2355d, "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isDestroyed() {
        return this.G;
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isStateSaved() {
        return this.E || this.F;
    }

    void j(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            AnimationOrAnimator U = U(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (U == null || (animator = U.animator) == null) {
                if (U != null) {
                    fragment.mView.startAnimation(U.animation);
                    U.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    U.animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentManagerImpl.5

                        /* renamed from: a */
                        final /* synthetic */ ViewGroup f2372a;

                        /* renamed from: b */
                        final /* synthetic */ View f2373b;

                        /* renamed from: c */
                        final /* synthetic */ Fragment f2374c;

                        AnonymousClass5(ViewGroup viewGroup2, View view2, Fragment fragment2) {
                            viewGroup = viewGroup2;
                            view = view2;
                            fragment = fragment2;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            viewGroup.endViewTransition(view);
                            animator2.removeListener(this);
                            Fragment fragment2 = fragment;
                            View view2 = fragment2.mView;
                            if (view2 == null || !fragment2.mHidden) {
                                return;
                            }
                            view2.setVisibility(8);
                        }
                    });
                }
                U.animator.start();
            }
        }
        if (fragment2.mAdded && R(fragment2)) {
            this.D = true;
        }
        fragment2.mHiddenChanged = false;
        fragment2.onHiddenChanged(fragment2.mHidden);
    }

    void j0() {
        if (this.w != null) {
            for (int i2 = 0; i2 < this.w.size(); i2++) {
                this.w.get(i2).onBackStackChanged();
            }
        }
    }

    void k(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).k(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    void k0(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.z instanceof ViewModelStoreOwner) {
            s0(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.O.o(fragmentManagerNonConfig);
        l0(parcelable);
    }

    void l(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).l(fragment, context, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentAttached(this, fragment, context);
            }
        }
    }

    void l0(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f2394a == null) {
            return;
        }
        for (Fragment fragment : this.O.j()) {
            if (f2354c) {
                Log.v(f2355d, "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<FragmentState> it = fragmentManagerState.f2394a.iterator();
            while (true) {
                if (it.hasNext()) {
                    fragmentState = it.next();
                    if (fragmentState.f2413b.equals(fragment.mWho)) {
                        break;
                    }
                } else {
                    fragmentState = null;
                    break;
                }
            }
            if (fragmentState == null) {
                if (f2354c) {
                    Log.v(f2355d, "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f2394a);
                }
                d0(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                d0(fragment, 0, 0, 0, false);
            } else {
                fragmentState.n = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                Fragment fragment2 = fragment.mTarget;
                fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
                fragment.mTarget = null;
                Bundle bundle = fragmentState.m;
                if (bundle != null) {
                    bundle.setClassLoader(this.z.getContext().getClassLoader());
                    fragment.mSavedViewState = fragmentState.m.getSparseParcelableArray(f2358g);
                    fragment.mSavedFragmentState = fragmentState.m;
                }
            }
        }
        this.p.clear();
        Iterator<FragmentState> it2 = fragmentManagerState.f2394a.iterator();
        while (it2.hasNext()) {
            FragmentState next = it2.next();
            if (next != null) {
                Fragment instantiate = next.instantiate(this.z.getContext().getClassLoader(), getFragmentFactory());
                instantiate.mFragmentManager = this;
                if (f2354c) {
                    Log.v(f2355d, "restoreSaveState: active (" + instantiate.mWho + "): " + instantiate);
                }
                this.p.put(instantiate.mWho, instantiate);
                next.n = null;
            }
        }
        this.o.clear();
        ArrayList<String> arrayList = fragmentManagerState.f2395b;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment3 = this.p.get(next2);
                if (fragment3 == null) {
                    s0(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                }
                fragment3.mAdded = true;
                if (f2354c) {
                    Log.v(f2355d, "restoreSaveState: added (" + next2 + "): " + fragment3);
                }
                if (this.o.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.o) {
                    this.o.add(fragment3);
                }
            }
        }
        if (fragmentManagerState.f2396c != null) {
            this.q = new ArrayList<>(fragmentManagerState.f2396c.length);
            int i2 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f2396c;
                if (i2 >= backStackStateArr.length) {
                    break;
                }
                BackStackRecord instantiate2 = backStackStateArr[i2].instantiate(this);
                if (f2354c) {
                    Log.v(f2355d, "restoreAllState: back stack #" + i2 + " (index " + instantiate2.G + "): " + instantiate2);
                    PrintWriter printWriter = new PrintWriter(new LogWriter(f2355d));
                    instantiate2.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.q.add(instantiate2);
                int i3 = instantiate2.G;
                if (i3 >= 0) {
                    setBackStackIndex(i3, instantiate2);
                }
                i2++;
            }
        } else {
            this.q = null;
        }
        String str = fragmentManagerState.f2397d;
        if (str != null) {
            Fragment fragment4 = this.p.get(str);
            this.C = fragment4;
            y(fragment4);
        }
        this.n = fragmentManagerState.f2398e;
    }

    void m(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    @Deprecated
    FragmentManagerNonConfig m0() {
        if (this.z instanceof ViewModelStoreOwner) {
            s0(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.O.k();
    }

    void n(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).n(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentDestroyed(this, fragment);
            }
        }
    }

    Parcelable n0() {
        ArrayList<String> arrayList;
        int size;
        J();
        C();
        execPendingActions();
        this.E = true;
        BackStackState[] backStackStateArr = null;
        if (this.p.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.p.size());
        boolean z = false;
        for (Fragment fragment : this.p.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager != this) {
                    s0(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                arrayList2.add(fragmentState);
                if (fragment.mState <= 0 || fragmentState.m != null) {
                    fragmentState.m = fragment.mSavedFragmentState;
                } else {
                    fragmentState.m = o0(fragment);
                    String str = fragment.mTargetWho;
                    if (str != null) {
                        Fragment fragment2 = this.p.get(str);
                        if (fragment2 == null) {
                            s0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTargetWho));
                        }
                        if (fragmentState.m == null) {
                            fragmentState.m = new Bundle();
                        }
                        putFragment(fragmentState.m, f2357f, fragment2);
                        int i2 = fragment.mTargetRequestCode;
                        if (i2 != 0) {
                            fragmentState.m.putInt(f2356e, i2);
                        }
                    }
                }
                if (f2354c) {
                    Log.v(f2355d, "Saved state of " + fragment + ": " + fragmentState.m);
                }
                z = true;
            }
        }
        if (!z) {
            if (f2354c) {
                Log.v(f2355d, "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.o.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.o.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (next.mFragmentManager != this) {
                    s0(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (f2354c) {
                    Log.v(f2355d, "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<BackStackRecord> arrayList3 = this.q;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.q.get(i3));
                if (f2354c) {
                    Log.v(f2355d, "saveAllState: adding back stack #" + i3 + ": " + this.q.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2394a = arrayList2;
        fragmentManagerState.f2395b = arrayList;
        fragmentManagerState.f2396c = backStackStateArr;
        Fragment fragment3 = this.C;
        if (fragment3 != null) {
            fragmentManagerState.f2397d = fragment3.mWho;
        }
        fragmentManagerState.f2398e = this.n;
        return fragmentManagerState;
    }

    public void noteStateNotSaved() {
        this.E = false;
        this.F = false;
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.o.get(i2);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void o(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).o(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentDetached(this, fragment);
            }
        }
    }

    Bundle o0(Fragment fragment) {
        if (this.L == null) {
            this.L = new Bundle();
        }
        fragment.performSaveInstanceState(this.L);
        t(fragment, this.L, false);
        Bundle bundle = null;
        if (!this.L.isEmpty()) {
            Bundle bundle2 = this.L;
            this.L = null;
            bundle = bundle2;
        }
        if (fragment.mView != null) {
            p0(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(f2358g, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f2359h, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !FragmentFactory.a(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (f2354c) {
            Log.v(f2355d, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            findFragmentById = getFragmentFactory().instantiate(context.getClassLoader(), str2);
            findFragmentById.mFromLayout = true;
            findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
            findFragmentById.mContainerId = id;
            findFragmentById.mTag = string;
            findFragmentById.mInLayout = true;
            findFragmentById.mFragmentManager = this;
            FragmentHostCallback fragmentHostCallback = this.z;
            findFragmentById.mHost = fragmentHostCallback;
            findFragmentById.onInflate(fragmentHostCallback.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            addFragment(findFragmentById, true);
        } else {
            if (findFragmentById.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            findFragmentById.mInLayout = true;
            FragmentHostCallback fragmentHostCallback2 = this.z;
            findFragmentById.mHost = fragmentHostCallback2;
            findFragmentById.onInflate(fragmentHostCallback2.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
        }
        Fragment fragment = findFragmentById;
        if (this.y >= 1 || !fragment.mFromLayout) {
            c0(fragment);
        } else {
            d0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    void p(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).p(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentPaused(this, fragment);
            }
        }
    }

    void p0(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.M;
        if (sparseArray == null) {
            this.M = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.M);
        if (this.M.size() > 0) {
            fragment.mSavedViewState = this.M;
            this.M = null;
        }
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.m) {
                this.H = true;
            } else {
                fragment.mDeferStart = false;
                d0(fragment, this.y, 0, 0, false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate() {
        g();
        return e0(null, -1, 0);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            s0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    void q(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).q(fragment, context, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    void q0() {
        synchronized (this) {
            ArrayList<StartEnterTransitionListener> arrayList = this.N;
            boolean z = false;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList<OpGenerator> arrayList2 = this.l;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.z.a().removeCallbacks(this.P);
                this.z.a().post(this.P);
                t0();
            }
        }
    }

    void r(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).r(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    void r0() {
        for (Fragment fragment : this.p.values()) {
            if (fragment != null) {
                performPendingDeferredStart(fragment);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.x.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public void removeFragment(Fragment fragment) {
        if (f2354c) {
            Log.v(f2355d, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.o) {
                this.o.remove(fragment);
            }
            if (R(fragment)) {
                this.D = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = this.w;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    void s(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).s(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentResumed(this, fragment);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        Bundle o0;
        if (fragment.mFragmentManager != this) {
            s0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (o0 = o0(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(o0);
    }

    public void setBackStackIndex(int i2, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            int size = this.u.size();
            if (i2 < size) {
                if (f2354c) {
                    Log.v(f2355d, "Setting back stack index " + i2 + " to " + backStackRecord);
                }
                this.u.set(i2, backStackRecord);
            } else {
                while (size < i2) {
                    this.u.add(null);
                    if (this.v == null) {
                        this.v = new ArrayList<>();
                    }
                    if (f2354c) {
                        Log.v(f2355d, "Adding available back stack index " + size);
                    }
                    this.v.add(Integer.valueOf(size));
                    size++;
                }
                if (f2354c) {
                    Log.v(f2355d, "Adding back stack index " + i2 + " with " + backStackRecord);
                }
                this.u.add(backStackRecord);
            }
        }
    }

    public void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (this.p.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.p.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.C;
            this.C = fragment;
            y(fragment2);
            y(this.C);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void showFragment(Fragment fragment) {
        if (f2354c) {
            Log.v(f2355d, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void t(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).t(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.B;
        if (fragment != null) {
            DebugUtils.buildShortClassTag(fragment, sb);
        } else {
            DebugUtils.buildShortClassTag(this.z, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    void u(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).u(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentStarted(this, fragment);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.x) {
            int i2 = 0;
            int size = this.x.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (this.x.get(i2).f2382a == fragmentLifecycleCallbacks) {
                    this.x.remove(i2);
                    break;
                }
                i2++;
            }
        }
    }

    void v(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).v(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentStopped(this, fragment);
            }
        }
    }

    void w(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).w(fragment, view, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    void x(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.B;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).x(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.x.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.f2383b) {
                next.f2382a.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    void z() {
        t0();
        y(this.C);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(@Nullable String str, int i2) {
        enqueueAction(new PopBackStackState(str, -1, i2), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(int i2, int i3) {
        if (i2 >= 0) {
            enqueueAction(new PopBackStackState(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(@Nullable String str, int i2) {
        g();
        return e0(str, -1, i2);
    }

    private static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(int i2, int i3) {
        g();
        execPendingActions();
        if (i2 >= 0) {
            return e0(null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    private static class EndViewTransitionAnimation extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f2377a;

        /* renamed from: b */
        private final View f2378b;

        /* renamed from: c */
        private boolean f2379c;

        /* renamed from: d */
        private boolean f2380d;

        /* renamed from: e */
        private boolean f2381e;

        EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.f2381e = true;
            this.f2377a = viewGroup;
            this.f2378b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            this.f2381e = true;
            if (this.f2379c) {
                return !this.f2380d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f2379c = true;
                OneShotPreDrawListener.add(this.f2377a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2379c || !this.f2381e) {
                this.f2377a.endViewTransition(this.f2378b);
                this.f2380d = true;
            } else {
                this.f2381e = false;
                this.f2377a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f2381e = true;
            if (this.f2379c) {
                return !this.f2380d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f2379c = true;
                OneShotPreDrawListener.add(this.f2377a, this);
            }
            return true;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
