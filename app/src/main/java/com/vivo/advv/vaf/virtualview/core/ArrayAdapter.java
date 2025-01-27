package com.vivo.advv.vaf.virtualview.core;

import androidx.collection.SparseArrayCompat;
import com.alipay.sdk.util.g;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.Adapter;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ArrayAdapter extends Adapter {
    private static final String TAG = "ArrayAdapter_TMTEST";
    private JSONArray mData;
    private SparseArrayCompat<String> mId2Types;
    private AtomicInteger mTypeId;
    private ConcurrentHashMap<String, Integer> mTypeMap;

    public ArrayAdapter(VafContext vafContext) {
        super(vafContext);
        this.mTypeId = new AtomicInteger(0);
        this.mTypeMap = new ConcurrentHashMap<>();
        this.mId2Types = new SparseArrayCompat<>();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Adapter
    public int getItemCount() {
        JSONArray jSONArray = this.mData;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Adapter
    public int getType(int i2) {
        JSONArray jSONArray = this.mData;
        if (jSONArray == null) {
            return 0;
        }
        try {
            String optString = jSONArray.getJSONObject(i2).optString("type");
            if (this.mTypeMap.containsKey(optString)) {
                return this.mTypeMap.get(optString).intValue();
            }
            int andIncrement = this.mTypeId.getAndIncrement();
            this.mTypeMap.put(optString, Integer.valueOf(andIncrement));
            this.mId2Types.put(andIncrement, optString);
            return andIncrement;
        } catch (JSONException unused) {
            return 0;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Adapter
    public void onBindViewHolder(Adapter.ViewHolder viewHolder, int i2) {
        try {
            JSONArray jSONArray = this.mData;
            Object obj = jSONArray != null ? jSONArray.get(i2) : null;
            if (!(obj instanceof JSONObject)) {
                VVLog.e(TAG, g.f5460a);
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            ViewBase virtualView = ((IContainer) viewHolder.mItemView).getVirtualView();
            if (virtualView != null) {
                virtualView.setVData(jSONObject);
            }
            if (virtualView.supportExposure()) {
                this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, virtualView));
            }
            virtualView.ready();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Adapter
    public Adapter.ViewHolder onCreateViewHolder(int i2) {
        return new Adapter.ViewHolder(this.mContainerService.getContainer(this.mId2Types.get(i2), this.mContainerId));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.Adapter
    public void setData(Object obj) {
        if (obj == null) {
            this.mData = null;
            return;
        }
        if (obj instanceof JSONArray) {
            this.mData = (JSONArray) obj;
            return;
        }
        VVLog.e(TAG, "setData failed:" + obj);
    }
}
