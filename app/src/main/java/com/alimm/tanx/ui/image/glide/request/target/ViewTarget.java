package com.alimm.tanx.ui.image.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.alimm.tanx.ui.image.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ok.a;

/* loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce = false;
    private static Integer tagId;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    public static class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        private final List<SizeReadyCallback> cbs = new ArrayList();
        private Point displayDimens;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;

        public static class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called listener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
        }

        public SizeDeterminer(View view) {
            this.view = view;
        }

        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                notifyCbs(viewWidthOrParam, viewHeightOrParam);
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
            }
        }

        @TargetApi(13)
        private Point getDisplayDimens() {
            Point point = this.displayDimens;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            this.displayDimens = point2;
            defaultDisplay.getSize(point2);
            return this.displayDimens;
        }

        private int getSizeForParam(int i10, boolean z10) {
            if (i10 != -2) {
                return i10;
            }
            Point displayDimens = getDisplayDimens();
            return z10 ? displayDimens.y : displayDimens.x;
        }

        private int getViewHeightOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.height, true);
            }
            return 0;
        }

        private int getViewWidthOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.width, false);
            }
            return 0;
        }

        private boolean isSizeValid(int i10) {
            return i10 > 0 || i10 == -2;
        }

        private void notifyCbs(int i10, int i11) {
            Iterator<SizeReadyCallback> it = this.cbs.iterator();
            while (it.hasNext()) {
                it.next().onSizeReady(i10, i11);
            }
            this.cbs.clear();
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }
    }

    public ViewTarget(T t10) {
        if (t10 == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.view = t10;
        this.sizeDeterminer = new SizeDeterminer(t10);
    }

    private Object getTag() {
        Integer num = tagId;
        return num == null ? this.view.getTag() : this.view.getTag(num.intValue());
    }

    private void setTag(Object obj) {
        Integer num = tagId;
        if (num != null) {
            this.view.setTag(num.intValue(), obj);
        } else {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
        }
    }

    public static void setTagId(int i10) {
        if (tagId != null || isTagUsedAtLeastOnce) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = Integer.valueOf(i10);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        setTag(request);
    }

    public String toString() {
        StringBuilder a10 = a.a("Target for: ");
        a10.append(this.view);
        return a10.toString();
    }
}
