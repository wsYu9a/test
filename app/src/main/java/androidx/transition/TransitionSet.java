package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private static final int S = 1;
    private static final int T = 2;
    private static final int U = 4;
    private static final int V = 8;
    private ArrayList<Transition> W;
    private boolean X;
    int Y;
    boolean Z;
    private int a0;

    /* renamed from: androidx.transition.TransitionSet$1 */
    class AnonymousClass1 extends TransitionListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ Transition f3845a;

        AnonymousClass1(Transition transition) {
            transition2 = transition;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            transition2.C();
            transition.removeListener(this);
        }
    }

    static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a */
        TransitionSet f3847a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f3847a = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f3847a;
            int i2 = transitionSet.Y - 1;
            transitionSet.Y = i2;
            if (i2 == 0) {
                transitionSet.Z = false;
                transitionSet.j();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f3847a;
            if (transitionSet.Z) {
                return;
            }
            transitionSet.F();
            this.f3847a.Z = true;
        }
    }

    public TransitionSet() {
        this.W = new ArrayList<>();
        this.X = true;
        this.Z = false;
        this.a0 = 0;
    }

    private void H(@NonNull Transition transition) {
        this.W.add(transition);
        transition.C = this;
    }

    private void J() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.W.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.Y = this.W.size();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void C() {
        if (this.W.isEmpty()) {
            F();
            j();
            return;
        }
        J();
        if (this.X) {
            Iterator<Transition> it = this.W.iterator();
            while (it.hasNext()) {
                it.next().C();
            }
            return;
        }
        for (int i2 = 1; i2 < this.W.size(); i2++) {
            this.W.get(i2 - 1).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1

                /* renamed from: a */
                final /* synthetic */ Transition f3845a;

                AnonymousClass1(Transition transition) {
                    transition2 = transition;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    transition2.C();
                    transition.removeListener(this);
                }
            });
        }
        Transition transition = this.W.get(0);
        if (transition != null) {
            transition.C();
        }
    }

    @Override // androidx.transition.Transition
    void D(boolean z) {
        super.D(z);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).D(z);
        }
    }

    @Override // androidx.transition.Transition
    String G(String str) {
        String G = super.G(str);
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(G);
            sb.append("\n");
            sb.append(this.W.get(i2).G(str + "  "));
            G = sb.toString();
        }
        return G;
    }

    @Override // androidx.transition.Transition
    /* renamed from: I */
    public TransitionSet E(ViewGroup viewGroup) {
        super.E(viewGroup);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).E(viewGroup);
        }
        return this;
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        H(transition);
        long j2 = this.n;
        if (j2 >= 0) {
            transition.setDuration(j2);
        }
        if ((this.a0 & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.a0 & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.a0 & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.a0 & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        super.cancel();
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (s(transitionValues.view)) {
            Iterator<Transition> it = this.W.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.s(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.f3855a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (s(transitionValues.view)) {
            Iterator<Transition> it = this.W.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.s(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.f3855a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    void f(TransitionValues transitionValues) {
        super.f(transitionValues);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).f(transitionValues);
        }
    }

    public int getOrdering() {
        return !this.X ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i2) {
        if (i2 < 0 || i2 >= this.W.size()) {
            return null;
        }
        return this.W.get(i2);
    }

    public int getTransitionCount() {
        return this.W.size();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void i(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.W.get(i2);
            if (startDelay > 0 && (this.X || i2 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.i(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void o(ViewGroup viewGroup) {
        super.o(viewGroup);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).o(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).pause(view);
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.W.remove(transition);
        transition.C = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.a0 |= 8;
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).setEpicenterCallback(epicenterCallback);
        }
    }

    @NonNull
    public TransitionSet setOrdering(int i2) {
        if (i2 == 0) {
            this.X = true;
        } else {
            if (i2 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
            }
            this.X = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.a0 |= 4;
        if (this.W != null) {
            for (int i2 = 0; i2 < this.W.size(); i2++) {
                this.W.get(i2).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.a0 |= 2;
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.W.get(i2).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo35clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo35clone();
        transitionSet.W = new ArrayList<>();
        int size = this.W.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.H(this.W.get(i2).mo35clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j2) {
        ArrayList<Transition> arrayList;
        super.setDuration(j2);
        if (this.n >= 0 && (arrayList = this.W) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.W.get(i2).setDuration(j2);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.a0 |= 1;
        ArrayList<Transition> arrayList = this.W;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.W.get(i2).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j2) {
        return (TransitionSet) super.setStartDelay(j2);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class cls) {
        return addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class cls) {
        return removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i2) {
        for (int i3 = 0; i3 < this.W.size(); i3++) {
            this.W.get(i3).removeTarget(i2);
        }
        return (TransitionSet) super.removeTarget(i2);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = new ArrayList<>();
        this.X = true;
        this.Z = false;
        this.a0 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3812i);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i2, boolean z) {
        for (int i3 = 0; i3 < this.W.size(); i3++) {
            this.W.get(i3).excludeTarget(i2, z);
        }
        return super.excludeTarget(i2, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i2) {
        for (int i3 = 0; i3 < this.W.size(); i3++) {
            this.W.get(i3).addTarget(i2);
        }
        return (TransitionSet) super.addTarget(i2);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
