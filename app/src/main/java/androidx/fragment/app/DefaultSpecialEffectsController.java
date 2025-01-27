package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ List val$awaitingContainerChanges;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;

        public AnonymousClass1(List list, SpecialEffectsController.Operation operation) {
            arrayList3 = list;
            operation4 = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (arrayList3.contains(operation4)) {
                arrayList3.remove(operation4);
                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10 */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ boolean val$isHideOperation;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass2(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, AnimationInfo animationInfo) {
            container = viewGroup;
            view2 = view;
            z14 = z10;
            operation2 = operation;
            next = animationInfo;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            container.endViewTransition(view2);
            if (z14) {
                operation2.getFinalState().applyState(view2);
            }
            next.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$3 */
    public class AnonymousClass3 implements CancellationSignal.OnCancelListener {
        final /* synthetic */ Animator val$animator;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;

        public AnonymousClass3(Animator animator, SpecialEffectsController.Operation operation) {
            animator = animator;
            operation = operation;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            animator.end();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has been canceled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4 */
    public class AnonymousClass4 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                container.endViewTransition(view3);
                animationInfo.completeSpecialEffect();
            }
        }

        public AnonymousClass4(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, AnimationInfo animationInfo) {
            operation3 = operation;
            container = viewGroup;
            view3 = view;
            animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    container.endViewTransition(view3);
                    animationInfo.completeSpecialEffect();
                }
            });
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has reached onAnimationStart.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$5 */
    public class AnonymousClass5 implements CancellationSignal.OnCancelListener {
        final /* synthetic */ AnimationInfo val$animationInfo;
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass5(View view, ViewGroup viewGroup, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
            view4 = view;
            container = viewGroup;
            animationInfo = animationInfo;
            operation3 = operation;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            view4.clearAnimation();
            container.endViewTransition(view4);
            animationInfo.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has been cancelled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ SpecialEffectsController.Operation val$firstOut;
        final /* synthetic */ boolean val$isPop;
        final /* synthetic */ SpecialEffectsController.Operation val$lastIn;
        final /* synthetic */ ArrayMap val$lastInViews;

        public AnonymousClass6(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z10, ArrayMap arrayMap) {
            operation2 = operation;
            operation = operation2;
            z10 = z10;
            arrayMap4 = arrayMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z10, arrayMap4, false);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ FragmentTransitionImpl val$impl;
        final /* synthetic */ Rect val$lastInEpicenterRect;
        final /* synthetic */ View val$lastInEpicenterView;

        public AnonymousClass7(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            view4 = view;
            rect = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            fragmentTransitionImpl2.getBoundsOnScreen(view4, rect);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$8 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ ArrayList val$transitioningViews;

        public AnonymousClass8(ArrayList arrayList) {
            arrayList14 = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.setViewVisibility(arrayList14, 4);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$9 */
    public class AnonymousClass9 implements Runnable {
        final /* synthetic */ SpecialEffectsController.Operation val$operation;
        final /* synthetic */ TransitionInfo val$transitionInfo;

        public AnonymousClass9(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
            transitionInfo3 = transitionInfo;
            operation13 = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            transitionInfo3.completeSpecialEffect();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Transition for operation " + operation13 + "has completed");
            }
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z10) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z10;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    public static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z10, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i10;
        boolean z11;
        Context context;
        View view;
        SpecialEffectsController.Operation operation;
        ViewGroup container = getContainer();
        Context context2 = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z12 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context2);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z13 = operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z13) {
                                list2.remove(operation2);
                            }
                            View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                final /* synthetic */ AnimationInfo val$animationInfo;
                                final /* synthetic */ ViewGroup val$container;
                                final /* synthetic */ boolean val$isHideOperation;
                                final /* synthetic */ SpecialEffectsController.Operation val$operation;
                                final /* synthetic */ View val$viewToAnimate;

                                public AnonymousClass2(ViewGroup container2, View view22, boolean z132, SpecialEffectsController.Operation operation22, AnimationInfo next2) {
                                    container = container2;
                                    view2 = view22;
                                    z14 = z132;
                                    operation2 = operation22;
                                    next = next2;
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view2);
                                    if (z14) {
                                        operation2.getFinalState().applyState(view2);
                                    }
                                    next.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view22);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                operation = operation22;
                                sb2.append(operation);
                                sb2.append(" has started.");
                                Log.v(FragmentManager.TAG, sb2.toString());
                            } else {
                                operation = operation22;
                            }
                            next2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                final /* synthetic */ Animator val$animator;
                                final /* synthetic */ SpecialEffectsController.Operation val$operation;

                                public AnonymousClass3(Animator animator2, SpecialEffectsController.Operation operation3) {
                                    animator = animator2;
                                    operation = operation3;
                                }

                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has been canceled.");
                                    }
                                }
                            });
                            z12 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo) it2.next();
            SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z10) {
                if (FragmentManager.isLoggingEnabled(i10)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo.completeSpecialEffect();
            } else if (z12) {
                if (FragmentManager.isLoggingEnabled(i10)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo.completeSpecialEffect();
            } else {
                View view3 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo.getAnimation(context2))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation2);
                    animationInfo.completeSpecialEffect();
                    z11 = z12;
                    context = context2;
                    view = view3;
                } else {
                    container2.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container2, view3);
                    z11 = z12;
                    context = context2;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        final /* synthetic */ AnimationInfo val$animationInfo;
                        final /* synthetic */ ViewGroup val$container;
                        final /* synthetic */ SpecialEffectsController.Operation val$operation;
                        final /* synthetic */ View val$viewToAnimate;

                        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4$1 */
                        public class AnonymousClass1 implements Runnable {
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                container.endViewTransition(view3);
                                animationInfo.completeSpecialEffect();
                            }
                        }

                        public AnonymousClass4(SpecialEffectsController.Operation operation32, ViewGroup container2, View view32, AnimationInfo animationInfo2) {
                            operation3 = operation32;
                            container = container2;
                            view3 = view32;
                            animationInfo = animationInfo2;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                public AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view3);
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation32 + " has started.");
                    }
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    final /* synthetic */ AnimationInfo val$animationInfo;
                    final /* synthetic */ ViewGroup val$container;
                    final /* synthetic */ SpecialEffectsController.Operation val$operation;
                    final /* synthetic */ View val$viewToAnimate;

                    public AnonymousClass5(View view4, ViewGroup container2, AnimationInfo animationInfo2, SpecialEffectsController.Operation operation32) {
                        view4 = view4;
                        container = container2;
                        animationInfo = animationInfo2;
                        operation3 = operation32;
                    }

                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view4.clearAnimation();
                        container.endViewTransition(view4);
                        animationInfo.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + operation3 + " has been cancelled.");
                        }
                    }
                });
                z12 = z11;
                context2 = context;
                i10 = 2;
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z10, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        ArrayMap arrayMap;
        SpecialEffectsController.Operation operation5;
        HashMap hashMap;
        ArrayList<View> arrayList3;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList<View> arrayList4;
        SpecialEffectsController.Operation operation6;
        Rect rect;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList5;
        int i10;
        View view4;
        String findKeyForValue;
        ArrayList<String> arrayList6;
        boolean z11 = z10;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap2 = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap2.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap2;
        }
        View view5 = new View(getContainer().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z12 = false;
        while (true) {
            boolean hasNext = it.hasNext();
            str = FragmentManager.TAG;
            if (!hasNext) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation7 == null || operation8 == null) {
                arrayMap = arrayMap2;
                operation5 = operation7;
                hashMap = hashMap2;
                arrayList3 = arrayList7;
                view3 = view5;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList4 = arrayList8;
                operation6 = operation8;
                rect = rect2;
                view6 = view6;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                View view7 = view6;
                HashMap hashMap3 = hashMap2;
                int i11 = 0;
                while (i11 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i11));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i11));
                    }
                    i11++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z11) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                View view8 = view5;
                int i12 = 0;
                while (i12 < size) {
                    arrayMap2.put(sharedElementSourceNames.get(i12), sharedElementTargetNames2.get(i12));
                    i12++;
                    size = size;
                    rect2 = rect2;
                }
                Rect rect3 = rect2;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v(FragmentManager.TAG, "Name: " + it2.next());
                    }
                    Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v(FragmentManager.TAG, "Name: " + it3.next());
                    }
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation7);
                    }
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str4 = sharedElementSourceNames.get(size2);
                        View view9 = arrayMap3.get(str4);
                        if (view9 == null) {
                            arrayMap2.remove(str4);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str4.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str4));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation8);
                    }
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str5 = sharedElementTargetNames2.get(size3);
                        View view10 = arrayMap4.get(str5);
                        if (view10 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str5);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str5.equals(ViewCompat.getTransitionName(view10)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str5)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList8;
                    operation5 = operation7;
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view6 = view7;
                    view3 = view8;
                    hashMap = hashMap3;
                    rect = rect3;
                    obj3 = null;
                    operation6 = operation8;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z11, arrayMap3, true);
                    arrayMap = arrayMap2;
                    ArrayList<View> arrayList10 = arrayList8;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        final /* synthetic */ SpecialEffectsController.Operation val$firstOut;
                        final /* synthetic */ boolean val$isPop;
                        final /* synthetic */ SpecialEffectsController.Operation val$lastIn;
                        final /* synthetic */ ArrayMap val$lastInViews;

                        public AnonymousClass6(SpecialEffectsController.Operation operation22, SpecialEffectsController.Operation operation9, boolean z102, ArrayMap arrayMap42) {
                            operation2 = operation22;
                            operation = operation9;
                            z10 = z102;
                            arrayMap4 = arrayMap42;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z10, arrayMap4, false);
                        }
                    });
                    arrayList7.addAll(arrayMap3.values());
                    if (arrayList5.isEmpty()) {
                        i10 = 0;
                        view6 = view7;
                    } else {
                        i10 = 0;
                        view6 = arrayMap3.get(arrayList5.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view6);
                    }
                    arrayList10.addAll(arrayMap42.values());
                    if (sharedElementTargetNames2.isEmpty() || (view4 = arrayMap42.get(sharedElementTargetNames2.get(i10))) == null) {
                        rect = rect3;
                        view3 = view8;
                    } else {
                        rect = rect3;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            final /* synthetic */ FragmentTransitionImpl val$impl;
                            final /* synthetic */ Rect val$lastInEpicenterRect;
                            final /* synthetic */ View val$lastInEpicenterView;

                            public AnonymousClass7(FragmentTransitionImpl fragmentTransitionImpl22, View view42, Rect rect4) {
                                fragmentTransitionImpl2 = fragmentTransitionImpl22;
                                view4 = view42;
                                rect = rect4;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view4, rect);
                            }
                        });
                        view3 = view8;
                        z12 = true;
                    }
                    fragmentTransitionImpl22.setSharedElementTargets(wrapTransitionInSet, view3, arrayList7);
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl22;
                    fragmentTransitionImpl22.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList10);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation9;
                    arrayList4 = arrayList10;
                    hashMap = hashMap3;
                    hashMap.put(operation5, bool);
                    operation6 = operation22;
                    hashMap.put(operation6, bool);
                    obj3 = wrapTransitionInSet;
                }
            }
            view5 = view3;
            rect2 = rect4;
            arrayList7 = arrayList3;
            arrayList8 = arrayList4;
            operation8 = operation6;
            z11 = z102;
            hashMap2 = hashMap;
            fragmentTransitionImpl22 = fragmentTransitionImpl;
            operation7 = operation5;
            arrayMap2 = arrayMap;
        }
        View view11 = view6;
        ArrayMap arrayMap5 = arrayMap2;
        SpecialEffectsController.Operation operation9 = operation7;
        HashMap hashMap4 = hashMap2;
        ArrayList<View> arrayList11 = arrayList7;
        View view12 = view5;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl22;
        ArrayList<View> arrayList12 = arrayList8;
        SpecialEffectsController.Operation operation10 = operation8;
        Rect rect4 = rect2;
        ArrayList arrayList13 = new ArrayList();
        Iterator<TransitionInfo> it4 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it4.hasNext()) {
            TransitionInfo next2 = it4.next();
            if (next2.isVisibilityUnchanged()) {
                hashMap4.put(next2.getOperation(), Boolean.FALSE);
                next2.completeSpecialEffect();
                it4 = it4;
            } else {
                Iterator<TransitionInfo> it5 = it4;
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(next2.getTransition());
                SpecialEffectsController.Operation operation11 = next2.getOperation();
                boolean z13 = obj3 != null && (operation11 == operation9 || operation11 == operation10);
                if (cloneTransition == null) {
                    if (!z13) {
                        hashMap4.put(operation11, Boolean.FALSE);
                        next2.completeSpecialEffect();
                    }
                    view = view12;
                    str3 = str;
                    arrayList = arrayList11;
                    arrayList2 = arrayList12;
                    obj = obj4;
                    obj2 = obj5;
                    operation3 = operation10;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList14 = new ArrayList<>();
                    Object obj6 = obj4;
                    captureTransitioningViews(arrayList14, operation11.getFragment().mView);
                    if (z13) {
                        if (operation11 == operation9) {
                            arrayList14.removeAll(arrayList11);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view12);
                        view = view12;
                        arrayList = arrayList11;
                        arrayList2 = arrayList12;
                        obj2 = obj5;
                        operation4 = operation11;
                        operation3 = operation10;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList14);
                        view = view12;
                        obj = obj6;
                        arrayList = arrayList11;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList14, null, null, null, null);
                        if (operation11.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operation11;
                            list2.remove(operation4);
                            ArrayList<View> arrayList15 = new ArrayList<>(arrayList14);
                            arrayList15.remove(operation4.getFragment().mView);
                            fragmentTransitionImpl3.scheduleHideFragmentView(cloneTransition, operation4.getFragment().mView, arrayList15);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                final /* synthetic */ ArrayList val$transitioningViews;

                                public AnonymousClass8(ArrayList arrayList142) {
                                    arrayList14 = arrayList142;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList14, 4);
                                }
                            });
                        } else {
                            operation4 = operation11;
                        }
                    }
                    if (operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList13.addAll(arrayList142);
                        if (z12) {
                            fragmentTransitionImpl3.setEpicenter(cloneTransition, rect4);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        fragmentTransitionImpl3.setEpicenter(cloneTransition, view2);
                    }
                    hashMap4.put(operation4, Boolean.TRUE);
                    if (next2.isOverlapAllowed()) {
                        obj2 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, cloneTransition, null);
                    } else {
                        obj = fragmentTransitionImpl3.mergeTransitionsTogether(obj, cloneTransition, null);
                    }
                }
                it4 = it5;
                obj4 = obj;
                view11 = view2;
                obj5 = obj2;
                operation10 = operation3;
                str = str3;
                view12 = view;
                arrayList11 = arrayList;
                arrayList12 = arrayList2;
            }
        }
        String str6 = str;
        ArrayList<View> arrayList16 = arrayList11;
        ArrayList<View> arrayList17 = arrayList12;
        SpecialEffectsController.Operation operation12 = operation10;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, obj4, obj3);
        if (mergeTransitionsInSequence == null) {
            return hashMap4;
        }
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.isVisibilityUnchanged()) {
                Object transition = transitionInfo3.getTransition();
                SpecialEffectsController.Operation operation13 = transitionInfo3.getOperation();
                boolean z14 = obj3 != null && (operation13 == operation9 || operation13 == operation12);
                if (transition == null && !z14) {
                    str2 = str6;
                } else if (ViewCompat.isLaidOut(getContainer())) {
                    str2 = str6;
                    fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo3.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo3.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                        final /* synthetic */ SpecialEffectsController.Operation val$operation;
                        final /* synthetic */ TransitionInfo val$transitionInfo;

                        public AnonymousClass9(TransitionInfo transitionInfo32, SpecialEffectsController.Operation operation132) {
                            transitionInfo3 = transitionInfo32;
                            operation13 = operation132;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            transitionInfo3.completeSpecialEffect();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Transition for operation " + operation13 + "has completed");
                            }
                        }
                    });
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        str2 = str6;
                        Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation132);
                    } else {
                        str2 = str6;
                    }
                    transitionInfo32.completeSpecialEffect();
                }
                str6 = str2;
            }
        }
        String str7 = str6;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap4;
        }
        FragmentTransition.setViewVisibility(arrayList13, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList17);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str7, ">>>>> Beginning transition <<<<<");
            Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it6 = arrayList16.iterator();
            while (it6.hasNext()) {
                View next3 = it6.next();
                Log.v(str7, "View: " + next3 + " Name: " + ViewCompat.getTransitionName(next3));
            }
            Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it7 = arrayList17.iterator();
            while (it7.hasNext()) {
                View next4 = it7.next();
                Log.v(str7, "View: " + next4 + " Name: " + ViewCompat.getTransitionName(next4));
            }
        }
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList16, arrayList17, prepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList13, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList16, arrayList17);
        return hashMap4;
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z10) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i10 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i10 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        syncAnimations(list);
        for (SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z10));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z11 = false;
            if (z10) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z10, z11));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        final /* synthetic */ List val$awaitingContainerChanges;
                        final /* synthetic */ SpecialEffectsController.Operation val$operation;

                        public AnonymousClass1(List arrayList32, SpecialEffectsController.Operation operation42) {
                            arrayList3 = arrayList32;
                            operation4 = operation42;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z11 = true;
                arrayList2.add(new TransitionInfo(operation42, cancellationSignal2, z10, z11));
                operation42.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    final /* synthetic */ List val$awaitingContainerChanges;
                    final /* synthetic */ SpecialEffectsController.Operation val$operation;

                    public AnonymousClass1(List arrayList32, SpecialEffectsController.Operation operation42) {
                        arrayList3 = arrayList32;
                        operation4 = operation42;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation42 != operation2) {
                    arrayList2.add(new TransitionInfo(operation42, cancellationSignal2, z10, z11));
                    operation42.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        final /* synthetic */ List val$awaitingContainerChanges;
                        final /* synthetic */ SpecialEffectsController.Operation val$operation;

                        public AnonymousClass1(List arrayList32, SpecialEffectsController.Operation operation42) {
                            arrayList3 = arrayList32;
                            operation4 = operation42;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z11 = true;
                arrayList2.add(new TransitionInfo(operation42, cancellationSignal2, z10, z11));
                operation42.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    final /* synthetic */ List val$awaitingContainerChanges;
                    final /* synthetic */ SpecialEffectsController.Operation val$operation;

                    public AnonymousClass1(List arrayList32, SpecialEffectsController.Operation operation42) {
                        arrayList3 = arrayList32;
                        operation4 = operation42;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList32, z10, operation, operation2);
        startAnimations(arrayList, arrayList32, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator<SpecialEffectsController.Operation> it = arrayList32.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList32.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z10, boolean z11) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z10 ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z10 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z10 ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z11) {
                this.mSharedElementTransition = null;
            } else if (z10) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
