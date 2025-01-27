package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.IBasicCPUAggregation;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class NativeCPUAggregationData implements IBasicCPUAggregation {
    private static final String CLASS_NAME = w.n;
    private final ClassLoader mClassLoader;
    private IBasicCPUAggregation.ICpuHotNativeStatus mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public aq remoteUtils;

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAggregationData$1 */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ View val$clickView;

        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAggregationData$1$1 */
        class RunnableC00641 implements Runnable {
            RunnableC00641() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = view2;
                if (view != null) {
                    view.setClickable(true);
                }
            }
        }

        AnonymousClass1(View view) {
            view2 = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeCPUAggregationData.this.handleClickView(view);
            view2.setClickable(false);
            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
                RunnableC00641() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view2 = view2;
                    if (view2 != null) {
                        view2.setClickable(true);
                    }
                }
            }, 1000L);
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAggregationData$2 */
    class AnonymousClass2 implements InvocationHandler {
        AnonymousClass2() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (NativeCPUAggregationData.this.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                NativeCPUAggregationData.this.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
            }
            return null;
        }
    }

    public NativeCPUAggregationData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = aq.a(context, CLASS_NAME);
        this.mClassLoader = bp.a(context);
    }

    public void handleClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "handleClickView", view);
    }

    private void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    private void setStatusListener(IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        this.mCpuNativeStatusCBListener = iCpuHotNativeStatus;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.mClassLoader, new Class[]{ar.a(w.o, this.mClassLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.2
                AnonymousClass2() {
                }

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (NativeCPUAggregationData.this.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                        NativeCPUAggregationData.this.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                    }
                    return null;
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getContentId() {
        Object b2 = this.remoteUtils.b(this.mInstance, "getContentId", new Object[0]);
        return b2 instanceof String ? (String) b2 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public List<String> getImagesList() {
        Object b2 = this.remoteUtils.b(this.mInstance, "getImagesList", new Object[0]);
        if (b2 instanceof List) {
            return (List) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getLongTitle() {
        Object b2 = this.remoteUtils.b(this.mInstance, "getLongTitle", new Object[0]);
        return b2 instanceof String ? (String) b2 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getShortTitle() {
        Object b2 = this.remoteUtils.b(this.mInstance, "getShortTitle", new Object[0]);
        return b2 instanceof String ? (String) b2 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getTitle() {
        Object b2 = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        return b2 instanceof String ? (String) b2 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public void registerViewForInteraction(View view, List<View> list, IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        setStatusListener(iCpuHotNativeStatus);
        onImpression(view);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (View view2 : list) {
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1
                    final /* synthetic */ View val$clickView;

                    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAggregationData$1$1 */
                    class RunnableC00641 implements Runnable {
                        RunnableC00641() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            View view2 = view2;
                            if (view2 != null) {
                                view2.setClickable(true);
                            }
                        }
                    }

                    AnonymousClass1(View view22) {
                        view2 = view22;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        NativeCPUAggregationData.this.handleClickView(view3);
                        view2.setClickable(false);
                        view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
                            RunnableC00641() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                View view22 = view2;
                                if (view22 != null) {
                                    view22.setClickable(true);
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }
}
