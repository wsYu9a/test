package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;
import com.bytedance.sdk.openadsdk.api.i;
import com.bytedance.sdk.openadsdk.api.zx;

/* loaded from: classes.dex */
public class TTDislikeListView extends ListView {
    private TTDislikeController mDislikeController;
    private EventListener mOnItemClickBridge;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    /* renamed from: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView$1 */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i2) == null || !(TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
            FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
            if (filterWord.hasSecondOptions()) {
                return;
            }
            if (TTDislikeListView.this.mDislikeController != null) {
                TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
            }
            if (TTDislikeListView.this.mOnItemClickListener != null) {
                TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j2);
            }
            if (TTDislikeListView.this.mOnItemClickBridge != null) {
                TTDislikeListView.this.mOnItemClickBridge.onEvent(0, zx.j().j(i.j().j(0, filterWord.getId()).j(1, filterWord.getName()).zx()).zx());
            }
        }
    }

    public TTDislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i2) == null || !(TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j2);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, zx.j().j(i.j().j(0, filterWord.getId()).j(1, filterWord.getName()).zx()).zx());
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    public void setDislikeInfo(TTDislikeController tTDislikeController) {
        this.mDislikeController = tTDislikeController;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.mOnItemClickBridge = (EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i2) == null || !(TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j2);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, zx.j().j(i.j().j(0, filterWord.getId()).j(1, filterWord.getName()).zx()).zx());
                }
            }
        };
        init();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            AnonymousClass1() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i22) == null || !(TTDislikeListView.this.getAdapter().getItem(i22) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i22);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i22, j2);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, zx.j().j(i.j().j(0, filterWord.getId()).j(1, filterWord.getName()).zx()).zx());
                }
            }
        };
        init();
    }
}
