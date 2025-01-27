package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.l;
import java.util.List;

/* loaded from: classes.dex */
public class CpuChannelListManager {
    private static final String TAG = "CpuChannelListManager";
    private l mCPUChannelListProd;
    private CpuChannelListListener mChannelIdListListener;

    public interface CpuChannelListListener {
        void onChannelListError(String str, int i2);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        l lVar = new l(context);
        this.mCPUChannelListProd = lVar;
        this.mChannelIdListListener = cpuChannelListListener;
        lVar.a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bq.a().c(TAG, "SubChannelId is null!");
            CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", bm.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bq.a().c(TAG, "appsid is null!");
            CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", bm.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            l lVar = this.mCPUChannelListProd;
            if (lVar != null) {
                lVar.a(str, parseInt);
                this.mCPUChannelListProd.a();
            }
        } catch (Exception unused) {
            bq.a().c(TAG, "SubChannelId is not Integer!");
            if (this.mChannelIdListListener != null) {
                this.mChannelIdListListener.onChannelListError("SubChannelId is not Integer!", bm.INTERFACE_USE_PROBLEM.b());
            }
        }
    }
}
