package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.a.a.a.a.a;
import com.bykv.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.EventListener;

/* loaded from: classes2.dex */
public class DislikeListView extends ListView {
    private EventListener mOnItemClickBridge;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    /* renamed from: com.bytedance.sdk.openadsdk.DislikeListView$1 */
    public class AnonymousClass1 implements AdapterView.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i10) == null || !(DislikeListView.this.getAdapter().getItem(i10) instanceof FilterWord)) {
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
            FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i10);
            if (filterWord.hasSecondOptions()) {
                return;
            }
            if (DislikeListView.this.mOnItemClickListener != null) {
                DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            if (DislikeListView.this.mOnItemClickBridge != null) {
                DislikeListView.this.mOnItemClickBridge.onEvent(0, a.a().a(b.a().a(0, filterWord.getId()).a(1, filterWord.getName()).b()).b());
            }
        }
    }

    public DislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            public AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i10) == null || !(DislikeListView.this.getAdapter().getItem(i10) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i10);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i10, j10);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, a.a().a(b.a().a(0, filterWord.getId()).a(1, filterWord.getName()).b()).b());
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.mOnItemClickBridge = (EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public DislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            public AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i10) == null || !(DislikeListView.this.getAdapter().getItem(i10) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i10);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i10, j10);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, a.a().a(b.a().a(0, filterWord.getId()).a(1, filterWord.getName()).b()).b());
                }
            }
        };
        init();
    }

    public DislikeListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            public AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i102, long j10) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i102) == null || !(DislikeListView.this.getAdapter().getItem(i102) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i102);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i102, j10);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, a.a().a(b.a().a(0, filterWord.getId()).a(1, filterWord.getName()).b()).b());
                }
            }
        };
        init();
    }
}
