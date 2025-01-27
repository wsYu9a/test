package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionManager {

    /* renamed from: a */
    private static final String f3835a = "TransitionManager";

    /* renamed from: b */
    private static Transition f3836b = new AutoTransition();

    /* renamed from: c */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f3837c = new ThreadLocal<>();

    /* renamed from: d */
    static ArrayList<ViewGroup> f3838d = new ArrayList<>();

    /* renamed from: e */
    private ArrayMap<Scene, Transition> f3839e = new ArrayMap<>();

    /* renamed from: f */
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> f3840f = new ArrayMap<>();

    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        Transition f3841a;

        /* renamed from: b */
        ViewGroup f3842b;

        /* renamed from: androidx.transition.TransitionManager$MultiListener$1 */
        class AnonymousClass1 extends TransitionListenerAdapter {

            /* renamed from: a */
            final /* synthetic */ ArrayMap f3843a;

            AnonymousClass1(ArrayMap arrayMap) {
                b2 = arrayMap;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ((ArrayList) b2.get(MultiListener.this.f3842b)).remove(transition);
                transition.removeListener(this);
            }
        }

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f3841a = transition;
            this.f3842b = viewGroup;
        }

        private void a() {
            this.f3842b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3842b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f3838d.remove(this.f3842b)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> b2 = TransitionManager.b();
            ArrayList<Transition> arrayList = b2.get(this.f3842b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b2.put(this.f3842b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f3841a);
            this.f3841a.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1

                /* renamed from: a */
                final /* synthetic */ ArrayMap f3843a;

                AnonymousClass1(ArrayMap b22) {
                    b2 = b22;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    ((ArrayList) b2.get(MultiListener.this.f3842b)).remove(transition);
                    transition.removeListener(this);
                }
            });
            this.f3841a.g(this.f3842b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f3842b);
                }
            }
            this.f3841a.A(this.f3842b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f3838d.remove(this.f3842b);
            ArrayList<Transition> arrayList = TransitionManager.b().get(this.f3842b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f3842b);
                }
            }
            this.f3841a.h(true);
        }
    }

    private static void a(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (f3838d.contains(sceneRoot)) {
            return;
        }
        Scene currentScene = Scene.getCurrentScene(sceneRoot);
        if (transition == null) {
            if (currentScene != null) {
                currentScene.exit();
            }
            scene.enter();
            return;
        }
        f3838d.add(sceneRoot);
        Transition mo35clone = transition.mo35clone();
        mo35clone.E(sceneRoot);
        if (currentScene != null && currentScene.a()) {
            mo35clone.D(true);
        }
        e(sceneRoot, mo35clone);
        scene.enter();
        d(sceneRoot, mo35clone);
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> b() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f3837c.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f3837c.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    private Transition c(Scene scene) {
        Scene currentScene;
        ArrayMap<Scene, Transition> arrayMap;
        Transition transition;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot != null && (currentScene = Scene.getCurrentScene(sceneRoot)) != null && (arrayMap = this.f3840f.get(scene)) != null && (transition = arrayMap.get(currentScene)) != null) {
            return transition;
        }
        Transition transition2 = this.f3839e.get(scene);
        return transition2 != null ? transition2 : f3836b;
    }

    private static void d(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        MultiListener multiListener = new MultiListener(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    private static void e(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.g(viewGroup, true);
        }
        Scene currentScene = Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        f3838d.remove(viewGroup);
        ArrayList<Transition> arrayList = b().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ((Transition) arrayList2.get(size)).o(viewGroup);
        }
    }

    public static void go(@NonNull Scene scene) {
        a(scene, f3836b);
    }

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.f3839e.put(scene, transition);
    }

    public void transitionTo(@NonNull Scene scene) {
        a(scene, c(scene));
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (f3838d.contains(viewGroup) || !ViewCompat.isLaidOut(viewGroup)) {
            return;
        }
        f3838d.add(viewGroup);
        if (transition == null) {
            transition = f3836b;
        }
        Transition mo35clone = transition.mo35clone();
        e(viewGroup, mo35clone);
        Scene.b(viewGroup, null);
        d(viewGroup, mo35clone);
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        a(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap<Scene, Transition> arrayMap = this.f3840f.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.f3840f.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }
}
