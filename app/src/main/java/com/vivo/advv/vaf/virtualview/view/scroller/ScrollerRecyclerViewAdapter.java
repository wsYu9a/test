package com.vivo.advv.vaf.virtualview.view.scroller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alipay.sdk.util.g;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.cm.ContainerService;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ScrollerRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String STICKY_TOP = "stickyTop";
    private static final String TAG = "ScrRecyAdapter_TMTEST";
    private static final String WATERFALL = "waterfall";
    private ContainerService mContainerService;
    private VafContext mContext;
    private JSONArray mData;
    private ScrollerImp mScrollerImp;
    private String mStickyTopType;
    private ViewGroup mStickyView;
    private int mAutoRefreshThreshold = 5;
    private AtomicInteger mTypeId = new AtomicInteger(0);
    private int mStickyTopPos = 1000000;
    private int mSpan = 0;
    private ConcurrentHashMap<String, Integer> mTypeMap = new ConcurrentHashMap<>();
    private SparseArrayCompat<String> mId2Types = new SparseArrayCompat<>();

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public boolean mStickyTop;
        public ViewBase mViewBase;

        public MyViewHolder(View view, ViewBase viewBase) {
            super(view);
            this.mStickyTop = false;
            this.mViewBase = viewBase;
        }
    }

    public ScrollerRecyclerViewAdapter(VafContext vafContext, ScrollerImp scrollerImp) {
        this.mContext = vafContext;
        this.mScrollerImp = scrollerImp;
        this.mContainerService = vafContext.getContainerService();
    }

    public void appendData(Object obj) {
        if (!(obj instanceof JSONArray)) {
            VVLog.e(TAG, "appendData failed:" + obj);
            return;
        }
        JSONArray jSONArray = (JSONArray) obj;
        JSONArray jSONArray2 = this.mData;
        if (jSONArray2 == null) {
            this.mData = jSONArray;
            notifyDataSetChanged();
            return;
        }
        int length = jSONArray2.length();
        int length2 = jSONArray.length();
        for (int i2 = 0; i2 < length2; i2++) {
            try {
                this.mData.put(jSONArray.get(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        notifyItemRangeChanged(length, length2);
    }

    public void destroy() {
        this.mScrollerImp = null;
        this.mData = null;
        this.mContext = null;
        this.mContainerService = null;
    }

    public Object getData(int i2) {
        JSONArray jSONArray = this.mData;
        if (jSONArray == null || i2 >= jSONArray.length()) {
            return null;
        }
        try {
            return this.mData.getJSONObject(i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        JSONArray jSONArray = this.mData;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        JSONArray jSONArray = this.mData;
        if (jSONArray != null) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString("type");
                if (jSONObject.optInt(STICKY_TOP, -1) > 0) {
                    this.mStickyTopType = optString;
                }
                if (this.mTypeMap.containsKey(optString)) {
                    return this.mTypeMap.get(optString).intValue();
                }
                int andIncrement = this.mTypeId.getAndIncrement();
                this.mTypeMap.put(optString, Integer.valueOf(andIncrement));
                this.mId2Types.put(andIncrement, optString);
                return andIncrement;
            } catch (JSONException e2) {
                VVLog.e(TAG, "getItemViewType:" + e2);
            }
        } else {
            VVLog.e(TAG, "getItemViewType data is null");
        }
        return -1;
    }

    public int getStickyTopPos() {
        return this.mStickyTopPos;
    }

    public ViewGroup getStickyView() {
        return this.mStickyView;
    }

    public void setAutoRefreshThreshold(int i2) {
        this.mAutoRefreshThreshold = i2;
    }

    public void setData(Object obj) {
        if (obj == null || !(obj instanceof JSONArray)) {
            VVLog.e(TAG, "setData failed:" + obj);
        } else {
            this.mData = (JSONArray) obj;
        }
        this.mStickyTopPos = 1000000;
    }

    public void setSpan(int i2) {
        this.mSpan = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyViewHolder myViewHolder, int i2) {
        try {
            JSONArray jSONArray = this.mData;
            Object obj = jSONArray != null ? jSONArray.get(i2) : null;
            myViewHolder.itemView.setTag(Integer.valueOf(i2));
            int i3 = 2;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (2 == this.mScrollerImp.mMode) {
                    StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) myViewHolder.itemView.getLayoutParams();
                    if (jSONObject.optInt(WATERFALL, -1) <= 0) {
                        layoutParams.setFullSpan(true);
                    } else {
                        layoutParams.setFullSpan(false);
                    }
                }
                if (jSONObject.optInt(STICKY_TOP, -1) > 0) {
                    myViewHolder.mStickyTop = true;
                    this.mStickyTopPos = i2;
                } else {
                    myViewHolder.mStickyTop = false;
                }
                myViewHolder.mViewBase.setVData(obj);
                if (myViewHolder.mViewBase.supportExposure()) {
                    this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, myViewHolder.mViewBase));
                }
                myViewHolder.mViewBase.ready();
            } else {
                VVLog.e(TAG, g.f5460a);
            }
            int i4 = this.mAutoRefreshThreshold;
            JSONArray jSONArray2 = this.mData;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            if (length >= this.mAutoRefreshThreshold) {
                i3 = i4;
            }
            if (i2 + i3 == length) {
                this.mScrollerImp.callAutoRefresh();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            VVLog.e(TAG, "onBindViewHolder:" + e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.view.View] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        IContainer iContainer;
        ViewGroup viewGroup2;
        int i3;
        String str = this.mId2Types.get(i2);
        if (2 == this.mScrollerImp.mMode) {
            ?? container = this.mContainerService.getContainer(str, false);
            Layout.Params comLayoutParams = ((IContainer) container).getVirtualView().getComLayoutParams();
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight);
            container.setLayoutParams(layoutParams);
            iContainer = container;
        } else {
            layoutParams = null;
            iContainer = this.mContainerService.getContainer(str);
        }
        if (str == this.mStickyTopType) {
            Layout.Params comLayoutParams2 = iContainer.getVirtualView().getComLayoutParams();
            this.mStickyView = new FrameLayout(this.mContext.forViewConstruction());
            if (2 == this.mScrollerImp.mMode) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(comLayoutParams2.mLayoutWidth, comLayoutParams2.mLayoutHeight);
                this.mStickyView.setLayoutParams(layoutParams2);
                layoutParams = layoutParams2;
            }
            this.mStickyView.addView(iContainer, comLayoutParams2.mLayoutWidth, comLayoutParams2.mLayoutHeight);
            viewGroup2 = this.mStickyView;
        } else {
            viewGroup2 = iContainer;
        }
        if (layoutParams != null && (i3 = this.mSpan) != 0) {
            int i4 = i3 >> 1;
            if (this.mScrollerImp.mLM.canScrollVertically()) {
                layoutParams.setMargins(i4, 0, i4, 0);
            } else {
                layoutParams.setMargins(0, i4, 0, i4);
            }
        }
        return new MyViewHolder(viewGroup2, iContainer.getVirtualView());
    }
}
