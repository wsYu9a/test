package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.aj;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class CPUAggregationManager {
    private static final String TAG = "CPUAggregationManager";
    private CPUAggregationListener mCPUListener;
    private Context mContext;
    private aj mNativeCpuAggregation;
    private int mPageSize = 3;
    private HashMap<String, Object> mParams = new HashMap<>();

    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i2);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        this.mNativeCpuAggregation = null;
        if (context == null || TextUtils.isEmpty(str)) {
            bq.a().c(TAG, "Init params error!");
            if (cPUAggregationListener != null) {
                cPUAggregationListener.onHotContentError("Input params error.", bm.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        this.mCPUListener = cPUAggregationListener;
        this.mContext = context;
        aj ajVar = new aj(context, str);
        this.mNativeCpuAggregation = ajVar;
        ajVar.a(cPUAggregationListener);
    }

    public void loadAd(int i2) {
        if (i2 <= 0) {
            bq.a().c(TAG, "Load with terrible params!");
            return;
        }
        aj ajVar = this.mNativeCpuAggregation;
        if (ajVar != null) {
            ajVar.a(i2, this.mPageSize, this.mParams);
            this.mNativeCpuAggregation.a();
        }
    }

    public void setPageSize(int i2) {
        if (i2 <= 0 || i2 > 10) {
            bq.a().c(TAG, "Input page size is wrong which should be in (0,10]!");
        } else {
            this.mPageSize = i2;
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        if (cPUAggregationRequest == null || cPUAggregationRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAggregationRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i2) {
        aj ajVar = this.mNativeCpuAggregation;
        if (ajVar != null) {
            ajVar.a(i2);
        }
    }
}
