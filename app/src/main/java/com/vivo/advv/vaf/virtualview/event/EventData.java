package com.vivo.advv.vaf.virtualview.event;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class EventData {
    protected static List<EventData> sCache = new LinkedList();
    public Activity mActivity;
    public IContainer mContainer;
    public VafContext mContext;
    public MotionEvent mMotionEvent;
    public ViewBase mVB;
    public View mView;
    public HashMap<String, Object> paramMap = new HashMap<>();
    public int rawX;
    public int rawY;
    public int x;
    public int y;

    public EventData(VafContext vafContext, ViewBase viewBase) {
        this.mContext = vafContext;
        this.mActivity = vafContext.getCurActivity();
        this.mVB = viewBase;
    }

    public static void clear() {
        sCache.clear();
    }

    public static EventData obtainData(VafContext vafContext, ViewBase viewBase) {
        View view;
        if (viewBase != null) {
            view = viewBase.getNativeView();
            if (view == null && viewBase.getViewCache() != null) {
                view = viewBase.getViewCache().getHolderView();
            }
        } else {
            view = null;
        }
        return obtainData(vafContext, viewBase, view, null);
    }

    protected static void recycleData(EventData eventData) {
        if (eventData != null) {
            sCache.add(eventData);
        }
    }

    public void recycle() {
        recycleData(this);
        this.mVB = null;
        this.mActivity = null;
        this.mContext = null;
        this.mView = null;
        this.mMotionEvent = null;
        this.mContainer = null;
    }

    public static EventData obtainData(VafContext vafContext, ViewBase viewBase, View view, MotionEvent motionEvent) {
        if (sCache.size() > 0) {
            EventData remove = sCache.remove(0);
            remove.mVB = viewBase;
            remove.mView = view;
            remove.mContext = vafContext;
            remove.mActivity = vafContext.getCurActivity();
            return remove;
        }
        return new EventData(vafContext, viewBase, view, motionEvent);
    }

    public EventData(VafContext vafContext, ViewBase viewBase, View view, MotionEvent motionEvent) {
        this.mContext = vafContext;
        this.mActivity = vafContext.getCurActivity();
        this.mVB = viewBase;
        this.mView = view;
        this.mMotionEvent = motionEvent;
    }
}
