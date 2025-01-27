package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: j */
    private static final boolean f3199j = false;
    private static TimeInterpolator k;
    private ArrayList<RecyclerView.ViewHolder> l = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> m = new ArrayList<>();
    private ArrayList<MoveInfo> n = new ArrayList<>();
    private ArrayList<ChangeInfo> o = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> p = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> q = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> r = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> s = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> t = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> u = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> v = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3200a;

        AnonymousClass1(ArrayList arrayList) {
            arrayList = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MoveInfo moveInfo = (MoveInfo) it.next();
                DefaultItemAnimator.this.e(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
            }
            arrayList.clear();
            DefaultItemAnimator.this.q.remove(arrayList);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3202a;

        AnonymousClass2(ArrayList arrayList) {
            arrayList2 = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.d((ChangeInfo) it.next());
            }
            arrayList2.clear();
            DefaultItemAnimator.this.r.remove(arrayList2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3204a;

        AnonymousClass3(ArrayList arrayList) {
            arrayList3 = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.c((RecyclerView.ViewHolder) it.next());
            }
            arrayList3.clear();
            DefaultItemAnimator.this.p.remove(arrayList3);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$4 */
    class AnonymousClass4 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3206a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3207b;

        /* renamed from: c */
        final /* synthetic */ View f3208c;

        AnonymousClass4(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            viewHolder = viewHolder;
            animate = viewPropertyAnimator;
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            view.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
            DefaultItemAnimator.this.u.remove(viewHolder);
            DefaultItemAnimator.this.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3210a;

        /* renamed from: b */
        final /* synthetic */ View f3211b;

        /* renamed from: c */
        final /* synthetic */ ViewPropertyAnimator f3212c;

        AnonymousClass5(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            viewHolder = viewHolder;
            view = view;
            animate = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            view.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
            DefaultItemAnimator.this.s.remove(viewHolder);
            DefaultItemAnimator.this.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$6 */
    class AnonymousClass6 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3214a;

        /* renamed from: b */
        final /* synthetic */ int f3215b;

        /* renamed from: c */
        final /* synthetic */ View f3216c;

        /* renamed from: d */
        final /* synthetic */ int f3217d;

        /* renamed from: e */
        final /* synthetic */ ViewPropertyAnimator f3218e;

        AnonymousClass6(RecyclerView.ViewHolder viewHolder, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            viewHolder = viewHolder;
            i6 = i2;
            view = view;
            i7 = i3;
            animate = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (i6 != 0) {
                view.setTranslationX(0.0f);
            }
            if (i7 != 0) {
                view.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            DefaultItemAnimator.this.dispatchMoveFinished(viewHolder);
            DefaultItemAnimator.this.t.remove(viewHolder);
            DefaultItemAnimator.this.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(viewHolder);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ChangeInfo f3220a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3221b;

        /* renamed from: c */
        final /* synthetic */ View f3222c;

        AnonymousClass7(ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
            changeInfo = changeInfo;
            duration = viewPropertyAnimator;
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            duration.setListener(null);
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
            DefaultItemAnimator.this.v.remove(changeInfo.oldHolder);
            DefaultItemAnimator.this.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ChangeInfo f3224a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3225b;

        /* renamed from: c */
        final /* synthetic */ View f3226c;

        AnonymousClass8(ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
            changeInfo = changeInfo;
            animate = viewPropertyAnimator;
            view2 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            view2.setAlpha(1.0f);
            view2.setTranslationX(0.0f);
            view2.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
            DefaultItemAnimator.this.v.remove(changeInfo.newHolder);
            DefaultItemAnimator.this.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
        }
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            this.holder = viewHolder;
            this.fromX = i2;
            this.fromY = i3;
            this.toX = i4;
            this.toY = i5;
        }
    }

    private void f(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.u.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4

            /* renamed from: a */
            final /* synthetic */ RecyclerView.ViewHolder f3206a;

            /* renamed from: b */
            final /* synthetic */ ViewPropertyAnimator f3207b;

            /* renamed from: c */
            final /* synthetic */ View f3208c;

            AnonymousClass4(RecyclerView.ViewHolder viewHolder2, ViewPropertyAnimator animate2, View view2) {
                viewHolder = viewHolder2;
                animate = animate2;
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
                DefaultItemAnimator.this.u.remove(viewHolder);
                DefaultItemAnimator.this.h();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }

    private void i(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (k(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void j(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        if (viewHolder != null) {
            k(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            k(changeInfo, viewHolder2);
        }
    }

    private boolean k(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != viewHolder) {
                return false;
            }
            changeInfo.oldHolder = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    private void l(RecyclerView.ViewHolder viewHolder) {
        if (k == null) {
            k = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(k);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        l(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.m.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        l(viewHolder);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            l(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i6);
            viewHolder2.itemView.setTranslationY(-i7);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.o.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        l(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.n.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        l(viewHolder);
        this.l.add(viewHolder);
        return true;
    }

    void c(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.s.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5

            /* renamed from: a */
            final /* synthetic */ RecyclerView.ViewHolder f3210a;

            /* renamed from: b */
            final /* synthetic */ View f3211b;

            /* renamed from: c */
            final /* synthetic */ ViewPropertyAnimator f3212c;

            AnonymousClass5(RecyclerView.ViewHolder viewHolder2, View view2, ViewPropertyAnimator animate2) {
                viewHolder = viewHolder2;
                view = view2;
                animate = animate2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
                DefaultItemAnimator.this.s.remove(viewHolder);
                DefaultItemAnimator.this.h();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    void d(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.v.add(changeInfo.oldHolder);
            duration.translationX(changeInfo.toX - changeInfo.fromX);
            duration.translationY(changeInfo.toY - changeInfo.fromY);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7

                /* renamed from: a */
                final /* synthetic */ ChangeInfo f3220a;

                /* renamed from: b */
                final /* synthetic */ ViewPropertyAnimator f3221b;

                /* renamed from: c */
                final /* synthetic */ View f3222c;

                AnonymousClass7(ChangeInfo changeInfo2, ViewPropertyAnimator duration2, View view3) {
                    changeInfo = changeInfo2;
                    duration = duration2;
                    view = view3;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.v.remove(changeInfo.oldHolder);
                    DefaultItemAnimator.this.h();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.v.add(changeInfo2.newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8

                /* renamed from: a */
                final /* synthetic */ ChangeInfo f3224a;

                /* renamed from: b */
                final /* synthetic */ ViewPropertyAnimator f3225b;

                /* renamed from: c */
                final /* synthetic */ View f3226c;

                AnonymousClass8(ChangeInfo changeInfo2, ViewPropertyAnimator animate2, View view22) {
                    changeInfo = changeInfo2;
                    animate = animate2;
                    view2 = view22;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    DefaultItemAnimator.this.v.remove(changeInfo.newHolder);
                    DefaultItemAnimator.this.h();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    void e(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.t.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6

            /* renamed from: a */
            final /* synthetic */ RecyclerView.ViewHolder f3214a;

            /* renamed from: b */
            final /* synthetic */ int f3215b;

            /* renamed from: c */
            final /* synthetic */ View f3216c;

            /* renamed from: d */
            final /* synthetic */ int f3217d;

            /* renamed from: e */
            final /* synthetic */ ViewPropertyAnimator f3218e;

            AnonymousClass6(RecyclerView.ViewHolder viewHolder2, int i62, View view2, int i72, ViewPropertyAnimator animate2) {
                viewHolder = viewHolder2;
                i6 = i62;
                view = view2;
                i7 = i72;
                animate = animate2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(viewHolder);
                DefaultItemAnimator.this.t.remove(viewHolder);
                DefaultItemAnimator.this.h();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchMoveStarting(viewHolder);
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.n.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.n.get(size).holder == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.n.remove(size);
            }
        }
        i(this.o, viewHolder);
        if (this.l.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.m.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.r.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.r.get(size2);
            i(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.r.remove(size2);
            }
        }
        for (int size3 = this.q.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.q.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).holder == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.q.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.p.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.p.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.p.remove(size5);
                }
            }
        }
        this.u.remove(viewHolder);
        this.s.remove(viewHolder);
        this.v.remove(viewHolder);
        this.t.remove(viewHolder);
        h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.n.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.n.get(size);
            View view = moveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.n.remove(size);
        }
        for (int size2 = this.l.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.l.get(size2));
            this.l.remove(size2);
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.m.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.m.remove(size3);
        }
        for (int size4 = this.o.size() - 1; size4 >= 0; size4--) {
            j(this.o.get(size4));
        }
        this.o.clear();
        if (isRunning()) {
            for (int size5 = this.q.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.q.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.q.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.p.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.p.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.p.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.r.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.r.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    j(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.r.remove(arrayList3);
                    }
                }
            }
            g(this.u);
            g(this.t);
            g(this.s);
            g(this.v);
            dispatchAnimationsFinished();
        }
    }

    void g(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void h() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.m.isEmpty() && this.o.isEmpty() && this.n.isEmpty() && this.l.isEmpty() && this.t.isEmpty() && this.u.isEmpty() && this.s.isEmpty() && this.v.isEmpty() && this.q.isEmpty() && this.p.isEmpty() && this.r.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.l.isEmpty();
        boolean z2 = !this.n.isEmpty();
        boolean z3 = !this.o.isEmpty();
        boolean z4 = !this.m.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.l.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            this.l.clear();
            if (z2) {
                ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.n);
                this.q.add(arrayList);
                this.n.clear();
                AnonymousClass1 anonymousClass1 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1

                    /* renamed from: a */
                    final /* synthetic */ ArrayList f3200a;

                    AnonymousClass1(ArrayList arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            DefaultItemAnimator.this.e(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.q.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).holder.itemView, anonymousClass1, getRemoveDuration());
                } else {
                    anonymousClass1.run();
                }
            }
            if (z3) {
                ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.o);
                this.r.add(arrayList2);
                this.o.clear();
                AnonymousClass2 anonymousClass2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2

                    /* renamed from: a */
                    final /* synthetic */ ArrayList f3202a;

                    AnonymousClass2(ArrayList arrayList22) {
                        arrayList2 = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.d((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.r.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList22.get(0).oldHolder.itemView, anonymousClass2, getRemoveDuration());
                } else {
                    anonymousClass2.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.m);
                this.p.add(arrayList3);
                this.m.clear();
                AnonymousClass3 anonymousClass3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3

                    /* renamed from: a */
                    final /* synthetic */ ArrayList f3204a;

                    AnonymousClass3(ArrayList arrayList32) {
                        arrayList3 = arrayList32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.c((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.p.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(arrayList32.get(0).itemView, anonymousClass3, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                } else {
                    anonymousClass3.run();
                }
            }
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            this(viewHolder, viewHolder2);
            this.fromX = i2;
            this.fromY = i3;
            this.toX = i4;
            this.toY = i5;
        }
    }
}
