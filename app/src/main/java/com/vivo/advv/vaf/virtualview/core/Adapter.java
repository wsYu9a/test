package com.vivo.advv.vaf.virtualview.core;

import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.cm.ContainerService;

/* loaded from: classes4.dex */
public abstract class Adapter {
    protected static final String TYPE = "type";
    protected ContainerService mContainerService;
    protected VafContext mContext;
    protected boolean mDataIsChange = true;
    protected int mContainerId = 0;

    public static class ViewHolder {
        public View mItemView;
        public int mPos;
        public int mType;

        public ViewHolder(View view) {
            this.mItemView = view;
            view.setTag(this);
        }
    }

    public Adapter(VafContext vafContext) {
        this.mContainerService = vafContext.getContainerService();
        this.mContext = vafContext;
    }

    public abstract int getItemCount();

    public int getType(int i2) {
        return 0;
    }

    public void notifyChange() {
        this.mDataIsChange = true;
    }

    public abstract void onBindViewHolder(ViewHolder viewHolder, int i2);

    public abstract ViewHolder onCreateViewHolder(int i2);

    public void setContainerId(int i2) {
        this.mContainerId = i2;
    }

    public abstract void setData(Object obj);
}
