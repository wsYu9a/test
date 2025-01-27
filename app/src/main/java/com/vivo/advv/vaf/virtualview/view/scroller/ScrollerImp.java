package com.vivo.advv.vaf.virtualview.view.scroller;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.view.scroller.ScrollerRecyclerViewAdapter;

/* loaded from: classes4.dex */
public class ScrollerImp extends RecyclerView implements IView, IContainer {
    private static final String TAG = "ScrollerImp_TMTEST";
    protected ScrollerRecyclerViewAdapter mAdapter;
    protected VafContext mAppContext;
    protected RecyclerView.LayoutManager mLM;
    protected Listener mListener;
    protected int mMode;
    protected int mOrientation;
    protected Scroller mScroller;
    protected ScrollerListener mScrollerListener;
    protected boolean mSupportSticky;

    /* renamed from: com.vivo.advv.vaf.virtualview.view.scroller.ScrollerImp$1 */
    class AnonymousClass1 implements RecyclerView.RecyclerListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            ViewBase viewBase = ((ScrollerRecyclerViewAdapter.MyViewHolder) viewHolder).mViewBase;
            if (viewBase != null) {
                viewBase.reset();
                return;
            }
            VVLog.e(ScrollerImp.TAG, "recycled failed:" + viewBase);
        }
    }

    public interface Listener {
        void onScrollStateChanged(RecyclerView recyclerView, int i2);

        void onScrolled(RecyclerView recyclerView, int i2, int i3);
    }

    class ScrollerListener extends RecyclerView.OnScrollListener {
        private View mStickView;
        private boolean mStickied = false;
        private int mStickiedItemHeight;

        ScrollerListener() {
        }

        private void addStickyWindow() {
            ((ViewGroup) ScrollerImp.this.getParent()).addView(this.mStickView);
        }

        private void removeStickyWindow() {
            ((ViewGroup) ScrollerImp.this.getParent()).removeView(this.mStickView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            Listener listener = ScrollerImp.this.mListener;
            if (listener != null) {
                listener.onScrollStateChanged(recyclerView, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            Listener listener = ScrollerImp.this.mListener;
            if (listener != null) {
                listener.onScrolled(recyclerView, i2, i3);
            }
            ScrollerImp scrollerImp = ScrollerImp.this;
            if (scrollerImp.mSupportSticky) {
                int stickyTopPos = scrollerImp.mAdapter.getStickyTopPos();
                if (this.mStickied) {
                    if (((Integer) ScrollerImp.this.findChildViewUnder(0.0f, this.mStickiedItemHeight).getTag()).intValue() <= stickyTopPos) {
                        this.mStickied = false;
                        removeStickyWindow();
                        ViewGroup stickyView = ScrollerImp.this.mAdapter.getStickyView();
                        stickyView.addView(this.mStickView, stickyView.getMeasuredWidth(), stickyView.getMeasuredHeight());
                        return;
                    }
                    return;
                }
                View findChildViewUnder = ScrollerImp.this.findChildViewUnder(0.0f, 0.0f);
                if (((Integer) findChildViewUnder.getTag()).intValue() >= stickyTopPos) {
                    this.mStickied = true;
                    ViewGroup stickyView2 = ScrollerImp.this.mAdapter.getStickyView();
                    if (stickyView2.getChildCount() == 1) {
                        this.mStickView = stickyView2.getChildAt(0);
                        stickyView2.addView(new View(ScrollerImp.this.getContext()), stickyView2.getMeasuredWidth(), stickyView2.getMeasuredHeight());
                    }
                    stickyView2.removeView(this.mStickView);
                    addStickyWindow();
                    this.mStickiedItemHeight = findChildViewUnder.getMeasuredHeight();
                }
            }
        }
    }

    public ScrollerImp(VafContext vafContext, Scroller scroller) {
        super(vafContext.forViewConstruction());
        this.mSupportSticky = false;
        this.mAppContext = vafContext;
        this.mScroller = scroller;
        setOverScrollMode(2);
        ScrollerRecyclerViewAdapter scrollerRecyclerViewAdapter = new ScrollerRecyclerViewAdapter(vafContext, this);
        this.mAdapter = scrollerRecyclerViewAdapter;
        setAdapter(scrollerRecyclerViewAdapter);
        setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.vivo.advv.vaf.virtualview.view.scroller.ScrollerImp.1
            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                ViewBase viewBase = ((ScrollerRecyclerViewAdapter.MyViewHolder) viewHolder).mViewBase;
                if (viewBase != null) {
                    viewBase.reset();
                    return;
                }
                VVLog.e(ScrollerImp.TAG, "recycled failed:" + viewBase);
            }
        });
    }

    public void appendData(Object obj) {
        this.mAdapter.appendData(obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void attachViews() {
    }

    public void callAutoRefresh() {
        this.mScroller.callAutoRefresh();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void destroy() {
        this.mScroller = null;
        this.mAdapter.destroy();
        this.mAdapter = null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public Object getData(int i2) {
        ScrollerRecyclerViewAdapter scrollerRecyclerViewAdapter = this.mAdapter;
        if (scrollerRecyclerViewAdapter != null) {
            return scrollerRecyclerViewAdapter.getData(i2);
        }
        return null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public View getHolderView() {
        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public int getType() {
        return -1;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mScroller;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    public void setAutoRefreshThreshold(int i2) {
        this.mAdapter.setAutoRefreshThreshold(i2);
    }

    public void setData(Object obj) {
        this.mAdapter.setData(obj);
        this.mAdapter.notifyDataSetChanged();
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
        if (this.mScrollerListener == null) {
            ScrollerListener scrollerListener = new ScrollerListener();
            this.mScrollerListener = scrollerListener;
            setOnScrollListener(scrollerListener);
        }
    }

    public void setModeOrientation(int i2, int i3) {
        if (this.mMode == i2 && this.mOrientation == i3) {
            return;
        }
        this.mMode = i2;
        this.mOrientation = i3;
        if (i2 == 1) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mAppContext.forViewConstruction());
            this.mLM = linearLayoutManager;
            linearLayoutManager.setOrientation(i3);
        } else if (i2 != 2) {
            VVLog.e(TAG, "mode invalidate:" + i2);
        } else {
            this.mLM = new StaggeredGridLayoutManager(2, i3);
        }
        setLayoutManager(this.mLM);
    }

    public void setSpan(int i2) {
        this.mAdapter.setSpan(i2);
    }

    public void setSupportSticky(boolean z) {
        if (this.mSupportSticky != z) {
            this.mSupportSticky = z;
            if (!z) {
                setOnScrollListener(null);
                return;
            }
            ScrollerListener scrollerListener = new ScrollerListener();
            this.mScrollerListener = scrollerListener;
            setOnScrollListener(scrollerListener);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void setVirtualView(ViewBase viewBase, IActionListener iActionListener) {
    }
}
