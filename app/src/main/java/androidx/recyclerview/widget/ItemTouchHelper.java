package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final int UP = 1;

    /* renamed from: a */
    private static final String f3293a = "ItemTouchHelper";

    /* renamed from: b */
    private static final boolean f3294b = false;

    /* renamed from: c */
    private static final int f3295c = -1;

    /* renamed from: d */
    static final int f3296d = 8;

    /* renamed from: e */
    private static final int f3297e = 255;

    /* renamed from: f */
    static final int f3298f = 65280;

    /* renamed from: g */
    static final int f3299g = 16711680;

    /* renamed from: h */
    private static final int f3300h = 1000;
    VelocityTracker B;
    private List<RecyclerView.ViewHolder> C;
    private List<Integer> D;
    GestureDetectorCompat H;
    private ItemTouchHelperGestureListener I;
    private Rect K;
    private long L;
    float l;
    float m;
    private float n;
    private float o;
    float p;
    float q;
    private float r;
    private float s;

    @NonNull
    Callback u;
    int w;
    private int y;
    RecyclerView z;

    /* renamed from: i */
    final List<View> f3301i = new ArrayList();

    /* renamed from: j */
    private final float[] f3302j = new float[2];
    RecyclerView.ViewHolder k = null;
    int t = -1;
    private int v = 0;
    List<RecoverAnimation> x = new ArrayList();
    final Runnable A = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.k == null || !itemTouchHelper.s()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.k;
            if (viewHolder != null) {
                itemTouchHelper2.n(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
            itemTouchHelper3.z.removeCallbacks(itemTouchHelper3.A);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.z, this);
        }
    };
    private RecyclerView.ChildDrawingOrderCallback E = null;
    View F = null;
    int G = -1;
    private final RecyclerView.OnItemTouchListener J = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation g2;
            ItemTouchHelper.this.H.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.t = motionEvent.getPointerId(0);
                ItemTouchHelper.this.l = motionEvent.getX();
                ItemTouchHelper.this.m = motionEvent.getY();
                ItemTouchHelper.this.o();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.k == null && (g2 = itemTouchHelper.g(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.l -= g2.f3326j;
                    itemTouchHelper2.m -= g2.k;
                    itemTouchHelper2.f(g2.f3321e, true);
                    if (ItemTouchHelper.this.f3301i.remove(g2.f3321e.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.u.clearView(itemTouchHelper3.z, g2.f3321e);
                    }
                    ItemTouchHelper.this.t(g2.f3321e, g2.f3322f);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.y(motionEvent, itemTouchHelper4.w, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.t = -1;
                itemTouchHelper5.t(null, 0);
            } else {
                int i2 = ItemTouchHelper.this.t;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    ItemTouchHelper.this.c(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.B;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.k != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.t(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.H.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.B;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.t == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.t);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.c(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.k;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.y(motionEvent, itemTouchHelper.w, findPointerIndex);
                        ItemTouchHelper.this.n(viewHolder);
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.z.removeCallbacks(itemTouchHelper2.A);
                        ItemTouchHelper.this.A.run();
                        ItemTouchHelper.this.z.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                    if (pointerId == itemTouchHelper3.t) {
                        itemTouchHelper3.t = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                        itemTouchHelper4.y(motionEvent, itemTouchHelper4.w, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.B;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            ItemTouchHelper.this.t(null, 0);
            ItemTouchHelper.this.t = -1;
        }
    };

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.k == null || !itemTouchHelper.s()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.k;
            if (viewHolder != null) {
                itemTouchHelper2.n(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
            itemTouchHelper3.z.removeCallbacks(itemTouchHelper3.A);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.z, this);
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$2 */
    class AnonymousClass2 implements RecyclerView.OnItemTouchListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation g2;
            ItemTouchHelper.this.H.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.t = motionEvent.getPointerId(0);
                ItemTouchHelper.this.l = motionEvent.getX();
                ItemTouchHelper.this.m = motionEvent.getY();
                ItemTouchHelper.this.o();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.k == null && (g2 = itemTouchHelper.g(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.l -= g2.f3326j;
                    itemTouchHelper2.m -= g2.k;
                    itemTouchHelper2.f(g2.f3321e, true);
                    if (ItemTouchHelper.this.f3301i.remove(g2.f3321e.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.u.clearView(itemTouchHelper3.z, g2.f3321e);
                    }
                    ItemTouchHelper.this.t(g2.f3321e, g2.f3322f);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.y(motionEvent, itemTouchHelper4.w, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.t = -1;
                itemTouchHelper5.t(null, 0);
            } else {
                int i2 = ItemTouchHelper.this.t;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    ItemTouchHelper.this.c(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.B;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.k != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.t(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.H.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.B;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.t == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.t);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.c(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.k;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.y(motionEvent, itemTouchHelper.w, findPointerIndex);
                        ItemTouchHelper.this.n(viewHolder);
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.z.removeCallbacks(itemTouchHelper2.A);
                        ItemTouchHelper.this.A.run();
                        ItemTouchHelper.this.z.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                    if (pointerId == itemTouchHelper3.t) {
                        itemTouchHelper3.t = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                        itemTouchHelper4.y(motionEvent, itemTouchHelper4.w, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.B;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            ItemTouchHelper.this.t(null, 0);
            ItemTouchHelper.this.t = -1;
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$3 */
    class AnonymousClass3 extends RecoverAnimation {
        final /* synthetic */ int o;
        final /* synthetic */ RecyclerView.ViewHolder p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RecyclerView.ViewHolder viewHolder, int i2, int i3, float f2, float f3, float f4, float f5, int i4, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i2, i3, f2, f3, f4, f5);
            r18 = i4;
            r19 = viewHolder2;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.l) {
                return;
            }
            if (r18 <= 0) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.u.clearView(itemTouchHelper.z, r19);
            } else {
                ItemTouchHelper.this.f3301i.add(r19.itemView);
                this.f3325i = true;
                int i2 = r18;
                if (i2 > 0) {
                    ItemTouchHelper.this.p(this, i2);
                }
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            View view = itemTouchHelper2.F;
            View view2 = r19.itemView;
            if (view == view2) {
                itemTouchHelper2.r(view2);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RecoverAnimation f3305a;

        /* renamed from: b */
        final /* synthetic */ int f3306b;

        AnonymousClass4(RecoverAnimation recoverAnimation, int i2) {
            recoverAnimation = recoverAnimation;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = ItemTouchHelper.this.z;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            RecoverAnimation recoverAnimation = recoverAnimation;
            if (recoverAnimation.l || recoverAnimation.f3321e.getAdapterPosition() == -1) {
                return;
            }
            RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.z.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.l()) {
                ItemTouchHelper.this.u.onSwiped(recoverAnimation.f3321e, i2);
            } else {
                ItemTouchHelper.this.z.post(this);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$5 */
    class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int i2, int i3) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            View view = itemTouchHelper.F;
            if (view == null) {
                return i3;
            }
            int i4 = itemTouchHelper.G;
            if (i4 == -1) {
                i4 = itemTouchHelper.z.indexOfChild(view);
                ItemTouchHelper.this.G = i4;
            }
            return i3 == i2 + (-1) ? i4 : i3 < i4 ? i3 : i3 + 1;
        }
    }

    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: a */
        static final int f3309a = 3158064;

        /* renamed from: b */
        private static final int f3310b = 789516;

        /* renamed from: c */
        private static final Interpolator f3311c = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            AnonymousClass1() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: d */
        private static final Interpolator f3312d = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            AnonymousClass2() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: e */
        private static final long f3313e = 2000;

        /* renamed from: f */
        private int f3314f = -1;

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$1 */
        static class AnonymousClass1 implements Interpolator {
            AnonymousClass1() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        }

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$2 */
        static class AnonymousClass2 implements Interpolator {
            AnonymousClass2() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        }

        private int b(RecyclerView recyclerView) {
            if (this.f3314f == -1) {
                this.f3314f = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f3314f;
        }

        public static int convertToRelativeDirection(int i2, int i3) {
            int i4;
            int i5 = i2 & f3310b;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ (-1));
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= (-789517) & i7;
                i4 = (i7 & f3310b) << 2;
            }
            return i6 | i4;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.f3330a;
        }

        public static int makeFlag(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int makeMovementFlags(int i2, int i3) {
            return makeFlag(2, i2) | makeFlag(1, i3) | makeFlag(0, i3 | i2);
        }

        final int a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        boolean c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & ItemTouchHelper.f3299g) != 0;
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i2, int i3) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i2 + viewHolder.itemView.getWidth();
            int height = i3 + viewHolder.itemView.getHeight();
            int left2 = i2 - viewHolder.itemView.getLeft();
            int top2 = i3 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i5);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i2) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i3) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.f3330a.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i2, int i3) {
            int i4;
            int i5 = i2 & f3309a;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ (-1));
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= (-3158065) & i7;
                i4 = (i7 & f3309a) >> 2;
            }
            return i6 | i4;
        }

        boolean d(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & 65280) != 0;
        }

        void e(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list.get(i3);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.f3321e, recoverAnimation.f3326j, recoverAnimation.k, recoverAnimation.f3322f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list.get(i3);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.f3321e, recoverAnimation.f3326j, recoverAnimation.k, recoverAnimation.f3322f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                RecoverAnimation recoverAnimation2 = list.get(i4);
                boolean z2 = recoverAnimation2.m;
                if (z2 && !recoverAnimation2.f3325i) {
                    list.remove(i4);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200L : 250L : i2 == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f2) {
            return f2;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f2) {
            return f2;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            int signum = (int) (((int) (((int) Math.signum(i3)) * b(recyclerView) * f3312d.getInterpolation(Math.min(1.0f, (Math.abs(i3) * 1.0f) / i2)))) * f3311c.getInterpolation(j2 <= f3313e ? j2 / 2000.0f : 1.0f));
            return signum == 0 ? i3 > 0 ? 1 : -1 : signum;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.f3330a.onDraw(canvas, recyclerView, viewHolder.itemView, f2, f3, i2, z);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.f3330a.onDrawOver(canvas, recyclerView, viewHolder.itemView, f2, f3, i2, z);
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i4, i5);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i3);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i3);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i3);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i3);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i2) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.f3330a.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i2);
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a */
        private boolean f3315a = true;

        ItemTouchHelperGestureListener() {
        }

        void a() {
            this.f3315a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View h2;
            RecyclerView.ViewHolder childViewHolder;
            if (!this.f3315a || (h2 = ItemTouchHelper.this.h(motionEvent)) == null || (childViewHolder = ItemTouchHelper.this.z.getChildViewHolder(h2)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.u.c(itemTouchHelper.z, childViewHolder)) {
                int pointerId = motionEvent.getPointerId(0);
                int i2 = ItemTouchHelper.this.t;
                if (pointerId == i2) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.l = x;
                    itemTouchHelper2.m = y;
                    itemTouchHelper2.q = 0.0f;
                    itemTouchHelper2.p = 0.0f;
                    if (itemTouchHelper2.u.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.t(childViewHolder, 2);
                    }
                }
            }
        }
    }

    private static class RecoverAnimation implements Animator.AnimatorListener {

        /* renamed from: a */
        final float f3317a;

        /* renamed from: b */
        final float f3318b;

        /* renamed from: c */
        final float f3319c;

        /* renamed from: d */
        final float f3320d;

        /* renamed from: e */
        final RecyclerView.ViewHolder f3321e;

        /* renamed from: f */
        final int f3322f;

        /* renamed from: g */
        private final ValueAnimator f3323g;

        /* renamed from: h */
        final int f3324h;

        /* renamed from: i */
        boolean f3325i;

        /* renamed from: j */
        float f3326j;
        float k;
        boolean l = false;
        boolean m = false;
        private float n;

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation$1 */
        class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
            }
        }

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f3322f = i3;
            this.f3324h = i2;
            this.f3321e = viewHolder;
            this.f3317a = f2;
            this.f3318b = f3;
            this.f3319c = f4;
            this.f3320d = f5;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f3323g = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                AnonymousClass1() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.f3323g.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.f3321e.setIsRecyclable(true);
            }
            this.m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public void setDuration(long j2) {
            this.f3323g.setDuration(j2);
        }

        public void setFraction(float f2) {
            this.n = f2;
        }

        public void start() {
            this.f3321e.setIsRecyclable(false);
            this.f3323g.start();
        }

        public void update() {
            float f2 = this.f3317a;
            float f3 = this.f3319c;
            if (f2 == f3) {
                this.f3326j = this.f3321e.itemView.getTranslationX();
            } else {
                this.f3326j = f2 + (this.n * (f3 - f2));
            }
            float f4 = this.f3318b;
            float f5 = this.f3320d;
            if (f4 == f5) {
                this.k = this.f3321e.itemView.getTranslationY();
            } else {
                this.k = f4 + (this.n * (f5 - f4));
            }
        }
    }

    public static abstract class SimpleCallback extends Callback {

        /* renamed from: g */
        private int f3328g;

        /* renamed from: h */
        private int f3329h;

        public SimpleCallback(int i2, int i3) {
            this.f3328g = i3;
            this.f3329h = i2;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f3329h;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f3328g;
        }

        public void setDefaultDragDirs(int i2) {
            this.f3329h = i2;
        }

        public void setDefaultSwipeDirs(int i2) {
            this.f3328g = i2;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i2, int i3);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.u = callback;
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.E == null) {
            this.E = new RecyclerView.ChildDrawingOrderCallback() { // from class: androidx.recyclerview.widget.ItemTouchHelper.5
                AnonymousClass5() {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public int onGetChildDrawingOrder(int i2, int i3) {
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    View view = itemTouchHelper.F;
                    if (view == null) {
                        return i3;
                    }
                    int i4 = itemTouchHelper.G;
                    if (i4 == -1) {
                        i4 = itemTouchHelper.z.indexOfChild(view);
                        ItemTouchHelper.this.G = i4;
                    }
                    return i3 == i2 + (-1) ? i4 : i3 < i4 ? i3 : i3 + 1;
                }
            };
        }
        this.z.setChildDrawingOrderCallback(this.E);
    }

    private int b(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = this.p > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null && this.t > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.u.getSwipeVelocityThreshold(this.o));
            float xVelocity = this.B.getXVelocity(this.t);
            float yVelocity = this.B.getYVelocity(this.t);
            int i4 = xVelocity <= 0.0f ? 4 : 8;
            float abs = Math.abs(xVelocity);
            if ((i4 & i2) != 0 && i3 == i4 && abs >= this.u.getSwipeEscapeVelocity(this.n) && abs > Math.abs(yVelocity)) {
                return i4;
            }
        }
        float width = this.z.getWidth() * this.u.getSwipeThreshold(viewHolder);
        if ((i2 & i3) == 0 || Math.abs(this.p) <= width) {
            return 0;
        }
        return i3;
    }

    private int d(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = this.q > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null && this.t > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.u.getSwipeVelocityThreshold(this.o));
            float xVelocity = this.B.getXVelocity(this.t);
            float yVelocity = this.B.getYVelocity(this.t);
            int i4 = yVelocity <= 0.0f ? 1 : 2;
            float abs = Math.abs(yVelocity);
            if ((i4 & i2) != 0 && i4 == i3 && abs >= this.u.getSwipeEscapeVelocity(this.n) && abs > Math.abs(xVelocity)) {
                return i4;
            }
        }
        float height = this.z.getHeight() * this.u.getSwipeThreshold(viewHolder);
        if ((i2 & i3) == 0 || Math.abs(this.q) <= height) {
            return 0;
        }
        return i3;
    }

    private void e() {
        this.z.removeItemDecoration(this);
        this.z.removeOnItemTouchListener(this.J);
        this.z.removeOnChildAttachStateChangeListener(this);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.u.clearView(this.z, this.x.get(0).f3321e);
        }
        this.x.clear();
        this.F = null;
        this.G = -1;
        q();
        w();
    }

    private List<RecyclerView.ViewHolder> i(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.C;
        if (list == null) {
            this.C = new ArrayList();
            this.D = new ArrayList();
        } else {
            list.clear();
            this.D.clear();
        }
        int boundingBoxMargin = this.u.getBoundingBoxMargin();
        int round = Math.round(this.r + this.p) - boundingBoxMargin;
        int round2 = Math.round(this.s + this.q) - boundingBoxMargin;
        int i2 = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i2;
        int height = viewHolder2.itemView.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.z.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.z.getChildViewHolder(childAt);
                if (this.u.canDropOver(this.z, this.k, childViewHolder)) {
                    int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.C.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > this.D.get(i8).intValue(); i8++) {
                        i7++;
                    }
                    this.C.add(i7, childViewHolder);
                    this.D.add(i7, Integer.valueOf(i6));
                }
            }
            i5++;
            viewHolder2 = viewHolder;
        }
        return this.C;
    }

    private RecyclerView.ViewHolder j(MotionEvent motionEvent) {
        View h2;
        RecyclerView.LayoutManager layoutManager = this.z.getLayoutManager();
        int i2 = this.t;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float x = motionEvent.getX(findPointerIndex) - this.l;
        float y = motionEvent.getY(findPointerIndex) - this.m;
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        int i3 = this.y;
        if (abs < i3 && abs2 < i3) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (h2 = h(motionEvent)) != null) {
            return this.z.getChildViewHolder(h2);
        }
        return null;
    }

    private void k(float[] fArr) {
        if ((this.w & 12) != 0) {
            fArr[0] = (this.r + this.p) - this.k.itemView.getLeft();
        } else {
            fArr[0] = this.k.itemView.getTranslationX();
        }
        if ((this.w & 3) != 0) {
            fArr[1] = (this.s + this.q) - this.k.itemView.getTop();
        } else {
            fArr[1] = this.k.itemView.getTranslationY();
        }
    }

    private static boolean m(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private void q() {
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.B = null;
        }
    }

    private void u() {
        this.y = ViewConfiguration.get(this.z.getContext()).getScaledTouchSlop();
        this.z.addItemDecoration(this);
        this.z.addOnItemTouchListener(this.J);
        this.z.addOnChildAttachStateChangeListener(this);
        v();
    }

    private void v() {
        this.I = new ItemTouchHelperGestureListener();
        this.H = new GestureDetectorCompat(this.z.getContext(), this.I);
    }

    private void w() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.I;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.a();
            this.I = null;
        }
        if (this.H != null) {
            this.H = null;
        }
    }

    private int x(RecyclerView.ViewHolder viewHolder) {
        if (this.v == 2) {
            return 0;
        }
        int movementFlags = this.u.getMovementFlags(this.z, viewHolder);
        int convertToAbsoluteDirection = (this.u.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.z)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i2 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.p) > Math.abs(this.q)) {
            int b2 = b(viewHolder, convertToAbsoluteDirection);
            if (b2 > 0) {
                return (i2 & b2) == 0 ? Callback.convertToRelativeDirection(b2, ViewCompat.getLayoutDirection(this.z)) : b2;
            }
            int d2 = d(viewHolder, convertToAbsoluteDirection);
            if (d2 > 0) {
                return d2;
            }
        } else {
            int d3 = d(viewHolder, convertToAbsoluteDirection);
            if (d3 > 0) {
                return d3;
            }
            int b3 = b(viewHolder, convertToAbsoluteDirection);
            if (b3 > 0) {
                return (i2 & b3) == 0 ? Callback.convertToRelativeDirection(b3, ViewCompat.getLayoutDirection(this.z)) : b3;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.z;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.z = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.n = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.o = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            u();
        }
    }

    void c(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.ViewHolder j2;
        int a2;
        if (this.k != null || i2 != 2 || this.v == 2 || !this.u.isItemViewSwipeEnabled() || this.z.getScrollState() == 1 || (j2 = j(motionEvent)) == null || (a2 = (this.u.a(this.z, j2) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        float f2 = x - this.l;
        float f3 = y - this.m;
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        int i4 = this.y;
        if (abs >= i4 || abs2 >= i4) {
            if (abs > abs2) {
                if (f2 < 0.0f && (a2 & 4) == 0) {
                    return;
                }
                if (f2 > 0.0f && (a2 & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < 0.0f && (a2 & 1) == 0) {
                    return;
                }
                if (f3 > 0.0f && (a2 & 2) == 0) {
                    return;
                }
            }
            this.q = 0.0f;
            this.p = 0.0f;
            this.t = motionEvent.getPointerId(0);
            t(j2, 1);
        }
    }

    void f(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.x.get(size);
            if (recoverAnimation.f3321e == viewHolder) {
                recoverAnimation.l |= z;
                if (!recoverAnimation.m) {
                    recoverAnimation.cancel();
                }
                this.x.remove(size);
                return;
            }
        }
    }

    RecoverAnimation g(MotionEvent motionEvent) {
        if (this.x.isEmpty()) {
            return null;
        }
        View h2 = h(motionEvent);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.x.get(size);
            if (recoverAnimation.f3321e.itemView == h2) {
                return recoverAnimation;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    View h(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.k;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (m(view, x, y, this.r + this.p, this.s + this.q)) {
                return view;
            }
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.x.get(size);
            View view2 = recoverAnimation.f3321e.itemView;
            if (m(view2, x, y, recoverAnimation.f3326j, recoverAnimation.k)) {
                return view2;
            }
        }
        return this.z.findChildViewUnder(x, y);
    }

    boolean l() {
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.x.get(i2).m) {
                return true;
            }
        }
        return false;
    }

    void n(RecyclerView.ViewHolder viewHolder) {
        if (!this.z.isLayoutRequested() && this.v == 2) {
            float moveThreshold = this.u.getMoveThreshold(viewHolder);
            int i2 = (int) (this.r + this.p);
            int i3 = (int) (this.s + this.q);
            if (Math.abs(i3 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i2 - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> i4 = i(viewHolder);
                if (i4.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder chooseDropTarget = this.u.chooseDropTarget(viewHolder, i4, i2, i3);
                if (chooseDropTarget == null) {
                    this.C.clear();
                    this.D.clear();
                    return;
                }
                int adapterPosition = chooseDropTarget.getAdapterPosition();
                int adapterPosition2 = viewHolder.getAdapterPosition();
                if (this.u.onMove(this.z, viewHolder, chooseDropTarget)) {
                    this.u.onMoved(this.z, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i2, i3);
                }
            }
        }
    }

    void o() {
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.B = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        r(view);
        RecyclerView.ViewHolder childViewHolder = this.z.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.k;
        if (viewHolder != null && childViewHolder == viewHolder) {
            t(null, 0);
            return;
        }
        f(childViewHolder, false);
        if (this.f3301i.remove(childViewHolder.itemView)) {
            this.u.clearView(this.z, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        this.G = -1;
        if (this.k != null) {
            k(this.f3302j);
            float[] fArr = this.f3302j;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.u.e(canvas, recyclerView, this.k, this.x, this.v, f2, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        if (this.k != null) {
            k(this.f3302j);
            float[] fArr = this.f3302j;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.u.f(canvas, recyclerView, this.k, this.x, this.v, f2, f3);
    }

    void p(RecoverAnimation recoverAnimation, int i2) {
        this.z.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4

            /* renamed from: a */
            final /* synthetic */ RecoverAnimation f3305a;

            /* renamed from: b */
            final /* synthetic */ int f3306b;

            AnonymousClass4(RecoverAnimation recoverAnimation2, int i22) {
                recoverAnimation = recoverAnimation2;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.z;
                if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                RecoverAnimation recoverAnimation2 = recoverAnimation;
                if (recoverAnimation2.l || recoverAnimation2.f3321e.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.z.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.l()) {
                    ItemTouchHelper.this.u.onSwiped(recoverAnimation.f3321e, i2);
                } else {
                    ItemTouchHelper.this.z.post(this);
                }
            }
        });
    }

    void r(View view) {
        if (view == this.F) {
            this.F = null;
            if (this.E != null) {
                this.z.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
    
        if (r1 > 0) goto L90;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean s() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.s():boolean");
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.u.c(this.z, viewHolder)) {
            Log.e(f3293a, "Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.z) {
            Log.e(f3293a, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        o();
        this.q = 0.0f;
        this.p = 0.0f;
        t(viewHolder, 2);
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.u.d(this.z, viewHolder)) {
            Log.e(f3293a, "Start swipe has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.z) {
            Log.e(f3293a, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        o();
        this.q = 0.0f;
        this.p = 0.0f;
        t(viewHolder, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void t(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.t(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    void y(MotionEvent motionEvent, int i2, int i3) {
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        float f2 = x - this.l;
        this.p = f2;
        this.q = y - this.m;
        if ((i2 & 4) == 0) {
            this.p = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.p = Math.min(0.0f, this.p);
        }
        if ((i2 & 1) == 0) {
            this.q = Math.max(0.0f, this.q);
        }
        if ((i2 & 2) == 0) {
            this.q = Math.min(0.0f, this.q);
        }
    }
}
