package com.baidu.mobads.sdk.internal.concrete;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* loaded from: classes.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {

    /* renamed from: a */
    private final b f5747a;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate$1 */
    class AnonymousClass1 extends ViewPager2.DataSetChangeObserver {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RVAdapterDelegate.this.f5747a.a("onChanged");
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate$2 */
    class AnonymousClass2 extends RVViewHolderDelegate {
        AnonymousClass2(IAdInterListener iAdInterListener, View view) {
            super(iAdInterListener, view);
        }
    }

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f5747a = b.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.f5747a.a("onChanged");
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f5747a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f5747a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f5747a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object a2 = this.f5747a.a("getItemCount", new Object[0]);
        if (a2 instanceof Integer) {
            return ((Integer) a2).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.f5747a.a("getItemId", Integer.valueOf(i2)) instanceof Integer ? ((Integer) r0).intValue() : super.getItemId(i2);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f5747a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f5747a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f5747a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f5747a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f5747a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f5747a.setTarget(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i2) {
        this.f5747a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        Object a2 = this.f5747a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i2));
        return a2 instanceof RVViewHolderDelegate ? (RVViewHolderDelegate) a2 : new RVViewHolderDelegate(this.f5747a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
            AnonymousClass2(IAdInterListener iAdInterListener, View viewGroup2) {
                super(iAdInterListener, viewGroup2);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Object a2 = this.f5747a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        return a2 instanceof Boolean ? ((Boolean) a2).booleanValue() : super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f5747a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f5747a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
        this.f5747a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }
}
