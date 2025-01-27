package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewTransitionController {
    ArrayList<ViewTransition.Animate> animations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    private ArrayList<ViewTransition> viewTransitions = new ArrayList<>();
    private String TAG = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> removeList = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.motion.widget.ViewTransitionController$1 */
    public class AnonymousClass1 implements SharedValues.SharedValuesListener {
        final /* synthetic */ boolean val$isSet;
        final /* synthetic */ int val$listen_for_id;
        final /* synthetic */ int val$listen_for_value;
        final /* synthetic */ ViewTransition val$viewTransition;

        public AnonymousClass1(final ViewTransition val$viewTransition, final int val$listen_for_id, final boolean val$isSet, final int val$listen_for_value) {
            viewTransition = val$viewTransition;
            sharedValueID = val$listen_for_id;
            isSet = val$isSet;
            sharedValue = val$listen_for_value;
        }

        @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
        public void onNewValue(int id2, int value, int oldValue) {
            int sharedValueCurrent = viewTransition.getSharedValueCurrent();
            viewTransition.setSharedValueCurrent(value);
            if (sharedValueID != id2 || sharedValueCurrent == value) {
                return;
            }
            if (isSet) {
                if (sharedValue == value) {
                    int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i10);
                        if (viewTransition.matchesView(childAt)) {
                            int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                            ConstraintSet constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                            ViewTransition viewTransition = viewTransition;
                            ViewTransitionController viewTransitionController = ViewTransitionController.this;
                            viewTransition.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                        }
                    }
                    return;
                }
                return;
            }
            if (sharedValue != value) {
                int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                for (int i11 = 0; i11 < childCount2; i11++) {
                    View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i11);
                    if (viewTransition.matchesView(childAt2)) {
                        int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                        ConstraintSet constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                        ViewTransition viewTransition2 = viewTransition;
                        ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                        viewTransition2.applyTransition(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                    }
                }
            }
        }
    }

    public ViewTransitionController(MotionLayout layout) {
        this.mMotionLayout = layout;
    }

    private void listenForSharedVariable(ViewTransition viewTransition, boolean isSet) {
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new SharedValues.SharedValuesListener() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
            final /* synthetic */ boolean val$isSet;
            final /* synthetic */ int val$listen_for_id;
            final /* synthetic */ int val$listen_for_value;
            final /* synthetic */ ViewTransition val$viewTransition;

            public AnonymousClass1(ViewTransition viewTransition2, final int val$listen_for_id, boolean isSet2, final int val$listen_for_value) {
                viewTransition = viewTransition2;
                sharedValueID = val$listen_for_id;
                isSet = isSet2;
                sharedValue = val$listen_for_value;
            }

            @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
            public void onNewValue(int id2, int value, int oldValue) {
                int sharedValueCurrent = viewTransition.getSharedValueCurrent();
                viewTransition.setSharedValueCurrent(value);
                if (sharedValueID != id2 || sharedValueCurrent == value) {
                    return;
                }
                if (isSet) {
                    if (sharedValue == value) {
                        int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                        for (int i10 = 0; i10 < childCount; i10++) {
                            View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i10);
                            if (viewTransition.matchesView(childAt)) {
                                int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                ConstraintSet constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                                ViewTransition viewTransition2 = viewTransition;
                                ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                viewTransition2.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (sharedValue != value) {
                    int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount2; i11++) {
                        View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i11);
                        if (viewTransition.matchesView(childAt2)) {
                            int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                            ConstraintSet constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                            ViewTransition viewTransition22 = viewTransition;
                            ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                            viewTransition22.applyTransition(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                        }
                    }
                }
            }
        });
    }

    private void viewTransition(ViewTransition vt, View... view) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (vt.mViewTransitionMode == 2) {
            vt.applyTransition(this, this.mMotionLayout, currentState, null, view);
            return;
        }
        if (currentState != -1) {
            ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
            if (constraintSet == null) {
                return;
            }
            vt.applyTransition(this, this.mMotionLayout, currentState, constraintSet, view);
            return;
        }
        Log.w(this.TAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
    }

    public void add(ViewTransition viewTransition) {
        this.viewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    public void addAnimation(ViewTransition.Animate animation) {
        if (this.animations == null) {
            this.animations = new ArrayList<>();
        }
        this.animations.add(animation);
    }

    public void animate() {
        ArrayList<ViewTransition.Animate> arrayList = this.animations;
        if (arrayList == null) {
            return;
        }
        Iterator<ViewTransition.Animate> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().mutate();
        }
        this.animations.removeAll(this.removeList);
        this.removeList.clear();
        if (this.animations.isEmpty()) {
            this.animations = null;
        }
    }

    public boolean applyViewTransition(int viewTransitionId, MotionController motionController) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == viewTransitionId) {
                next.mKeyFrames.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    public void enableViewTransition(int id2, boolean enable) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == id2) {
                next.setEnabled(enable);
                return;
            }
        }
    }

    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    public boolean isViewTransitionEnabled(int id2) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == id2) {
                return next.isEnabled();
            }
        }
        return false;
    }

    public void remove(int id2) {
        ViewTransition viewTransition;
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (true) {
            if (!it.hasNext()) {
                viewTransition = null;
                break;
            } else {
                viewTransition = it.next();
                if (viewTransition.getId() == id2) {
                    break;
                }
            }
        }
        if (viewTransition != null) {
            this.mRelatedViews = null;
            this.viewTransitions.remove(viewTransition);
        }
    }

    public void removeAnimation(ViewTransition.Animate animation) {
        this.removeList.add(animation);
    }

    public void touchEvent(MotionEvent event) {
        ViewTransition viewTransition;
        int currentState = this.mMotionLayout.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.mRelatedViews == null) {
            this.mRelatedViews = new HashSet<>();
            Iterator<ViewTransition> it = this.viewTransitions.iterator();
            while (it.hasNext()) {
                ViewTransition next = it.next();
                int childCount = this.mMotionLayout.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.mMotionLayout.getChildAt(i10);
                    if (next.matchesView(childAt)) {
                        childAt.getId();
                        this.mRelatedViews.add(childAt);
                    }
                }
            }
        }
        float x10 = event.getX();
        float y10 = event.getY();
        Rect rect = new Rect();
        int action = event.getAction();
        ArrayList<ViewTransition.Animate> arrayList = this.animations;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ViewTransition.Animate> it2 = this.animations.iterator();
            while (it2.hasNext()) {
                it2.next().reactTo(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
            Iterator<ViewTransition> it3 = this.viewTransitions.iterator();
            while (it3.hasNext()) {
                ViewTransition next2 = it3.next();
                if (next2.supports(action)) {
                    Iterator<View> it4 = this.mRelatedViews.iterator();
                    while (it4.hasNext()) {
                        View next3 = it4.next();
                        if (next2.matchesView(next3)) {
                            next3.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                viewTransition = next2;
                                next2.applyTransition(this, this.mMotionLayout, currentState, constraintSet, next3);
                            } else {
                                viewTransition = next2;
                            }
                            next2 = viewTransition;
                        }
                    }
                }
            }
        }
    }

    public void viewTransition(int id2, View... views) {
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        ViewTransition viewTransition = null;
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.getId() == id2) {
                for (View view : views) {
                    if (next.checkTags(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = next;
            }
        }
        if (viewTransition == null) {
            Log.e(this.TAG, " Could not find ViewTransition");
        }
    }
}
