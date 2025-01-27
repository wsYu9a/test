package com.vivo.advv.vaf.virtualview.container;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.ViewBase;

/* loaded from: classes4.dex */
public class ClickHelper {
    protected static final int LONG_PRESS_THRESHOLD = 500;
    private static final String TAG = "ClickHelper_TMTEST";
    protected boolean mClickFinished;
    protected IContainer mContainer;
    protected int mLastX;
    protected int mLastY;
    protected boolean mLongClickPressed;
    protected LongRunnable mRunnable;
    protected int mStartX;
    protected int mStartY;

    /* renamed from: com.vivo.advv.vaf.virtualview.container.ClickHelper$1 */
    class AnonymousClass1 implements View.OnTouchListener {
        final /* synthetic */ IActionListener val$actionListener;
        final /* synthetic */ View val$holderView;
        final /* synthetic */ ViewBase val$vb;

        AnonymousClass1(ViewBase viewBase, View view, IActionListener iActionListener) {
            virtualView = viewBase;
            holderView = view;
            iActionListener = iActionListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                ClickHelper clickHelper = ClickHelper.this;
                clickHelper.mClickFinished = false;
                clickHelper.mLongClickPressed = false;
                clickHelper.mStartX = (int) motionEvent.getX();
                ClickHelper.this.mStartY = (int) motionEvent.getY();
                ClickHelper clickHelper2 = ClickHelper.this;
                int i2 = clickHelper2.mStartX;
                clickHelper2.mLastX = i2;
                int i3 = clickHelper2.mStartY;
                clickHelper2.mLastY = i3;
                if (virtualView.handleEvent(i2, i3)) {
                    Handler handler = holderView.getHandler();
                    handler.removeCallbacks(ClickHelper.this.mRunnable);
                    ClickHelper clickHelper3 = ClickHelper.this;
                    clickHelper3.mRunnable.setView(clickHelper3.mContainer.getVirtualView());
                    ClickHelper.this.mRunnable.setHolderView(holderView);
                    handler.postDelayed(ClickHelper.this.mRunnable, 500L);
                    virtualView.onTouch(view, motionEvent);
                    return true;
                }
            } else {
                if (action == 1) {
                    ViewBase virtualView = ClickHelper.this.mContainer.getVirtualView();
                    if (virtualView != null) {
                        ClickHelper clickHelper4 = ClickHelper.this;
                        if (!clickHelper4.mLongClickPressed) {
                            boolean click = virtualView.click(clickHelper4.mStartX, clickHelper4.mStartY, false, clickHelper4.mContainer, iActionListener);
                            if (click) {
                                holderView.playSoundEffect(0);
                            }
                            z = click;
                        }
                    }
                    virtualView.onTouch(view, motionEvent);
                    ClickHelper.this.mClickFinished = true;
                    return z;
                }
                if (action == 2) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (Math.sqrt(Math.pow(x - ClickHelper.this.mLastX, 2.0d) + Math.pow(y - ClickHelper.this.mLastY, 2.0d)) > VafContext.SLOP) {
                        holderView.removeCallbacks(ClickHelper.this.mRunnable);
                    }
                    ClickHelper clickHelper5 = ClickHelper.this;
                    clickHelper5.mLastX = x;
                    clickHelper5.mLastY = y;
                    virtualView.onTouch(view, motionEvent);
                } else if (action == 3) {
                    virtualView.onTouch(view, motionEvent);
                    ClickHelper.this.mClickFinished = true;
                }
            }
            return false;
        }
    }

    class LongRunnable implements Runnable {
        protected IActionListener mActionListener;
        protected View mHolderView;
        protected ViewBase mView;

        public LongRunnable(IActionListener iActionListener) {
            this.mActionListener = iActionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewBase viewBase;
            View view;
            ClickHelper clickHelper = ClickHelper.this;
            if (clickHelper.mClickFinished || (viewBase = this.mView) == null || !viewBase.click(clickHelper.mStartX, clickHelper.mStartY, true, clickHelper.mContainer, this.mActionListener) || (view = this.mHolderView) == null) {
                return;
            }
            ClickHelper.this.mLongClickPressed = true;
            view.performHapticFeedback(0);
        }

        public void setHolderView(View view) {
            this.mHolderView = view;
        }

        public void setView(ViewBase viewBase) {
            this.mView = viewBase;
        }
    }

    public ClickHelper(IContainer iContainer) {
        this(iContainer, null);
    }

    public ClickHelper(IContainer iContainer, IActionListener iActionListener) {
        this.mClickFinished = true;
        this.mLongClickPressed = false;
        this.mContainer = iContainer;
        this.mRunnable = new LongRunnable(iActionListener);
        View holderView = iContainer.getHolderView();
        holderView.setOnTouchListener(new View.OnTouchListener() { // from class: com.vivo.advv.vaf.virtualview.container.ClickHelper.1
            final /* synthetic */ IActionListener val$actionListener;
            final /* synthetic */ View val$holderView;
            final /* synthetic */ ViewBase val$vb;

            AnonymousClass1(ViewBase viewBase, View holderView2, IActionListener iActionListener2) {
                virtualView = viewBase;
                holderView = holderView2;
                iActionListener = iActionListener2;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                boolean z = false;
                if (action == 0) {
                    ClickHelper clickHelper = ClickHelper.this;
                    clickHelper.mClickFinished = false;
                    clickHelper.mLongClickPressed = false;
                    clickHelper.mStartX = (int) motionEvent.getX();
                    ClickHelper.this.mStartY = (int) motionEvent.getY();
                    ClickHelper clickHelper2 = ClickHelper.this;
                    int i2 = clickHelper2.mStartX;
                    clickHelper2.mLastX = i2;
                    int i3 = clickHelper2.mStartY;
                    clickHelper2.mLastY = i3;
                    if (virtualView.handleEvent(i2, i3)) {
                        Handler handler = holderView.getHandler();
                        handler.removeCallbacks(ClickHelper.this.mRunnable);
                        ClickHelper clickHelper3 = ClickHelper.this;
                        clickHelper3.mRunnable.setView(clickHelper3.mContainer.getVirtualView());
                        ClickHelper.this.mRunnable.setHolderView(holderView);
                        handler.postDelayed(ClickHelper.this.mRunnable, 500L);
                        virtualView.onTouch(view, motionEvent);
                        return true;
                    }
                } else {
                    if (action == 1) {
                        ViewBase virtualView = ClickHelper.this.mContainer.getVirtualView();
                        if (virtualView != null) {
                            ClickHelper clickHelper4 = ClickHelper.this;
                            if (!clickHelper4.mLongClickPressed) {
                                boolean click = virtualView.click(clickHelper4.mStartX, clickHelper4.mStartY, false, clickHelper4.mContainer, iActionListener);
                                if (click) {
                                    holderView.playSoundEffect(0);
                                }
                                z = click;
                            }
                        }
                        virtualView.onTouch(view, motionEvent);
                        ClickHelper.this.mClickFinished = true;
                        return z;
                    }
                    if (action == 2) {
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        if (Math.sqrt(Math.pow(x - ClickHelper.this.mLastX, 2.0d) + Math.pow(y - ClickHelper.this.mLastY, 2.0d)) > VafContext.SLOP) {
                            holderView.removeCallbacks(ClickHelper.this.mRunnable);
                        }
                        ClickHelper clickHelper5 = ClickHelper.this;
                        clickHelper5.mLastX = x;
                        clickHelper5.mLastY = y;
                        virtualView.onTouch(view, motionEvent);
                    } else if (action == 3) {
                        virtualView.onTouch(view, motionEvent);
                        ClickHelper.this.mClickFinished = true;
                    }
                }
                return false;
            }
        });
    }
}
