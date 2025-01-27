package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.au;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.bs;
import com.baidu.mobads.sdk.internal.z;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import l5.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeCPUAdData implements IBasicCPUData, Observer {
    private static final String CLASS_NAME = z.f7384l;
    private final ClassLoader classLoader;
    private IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public at remoteUtils;

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$1 */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ View val$clickView;

        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$1$1 */
        class RunnableC02191 implements Runnable {
            public RunnableC02191() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = view2;
                if (view != null) {
                    view.setClickable(true);
                }
            }
        }

        public AnonymousClass1(View view) {
            view2 = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeCPUAdData.this.handleCanClickView(view);
            view2.setClickable(false);
            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                public RunnableC02191() {
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

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ List val$clickViews;
        final /* synthetic */ View val$creativeView;

        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$2$1 */
        class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (list != null) {
                    view3.setClickable(true);
                }
            }
        }

        public AnonymousClass2(View view, List list) {
            view3 = view;
            list = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeCPUAdData.this.handleCreativeView(view);
            view3.setClickable(false);
            view3.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    if (list != null) {
                        view3.setClickable(true);
                    }
                }
            }, 1000L);
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$3 */
    class AnonymousClass3 implements InvocationHandler {
        final /* synthetic */ IBasicCPUData.CpuNativeStatusCB val$cpuNativeStatusCBListener;

        public AnonymousClass3(IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
            cpuNativeStatusCB = cpuNativeStatusCB;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            ay.h("NativeCPUAdData").c("invoke: " + method.getName());
            if (cpuNativeStatusCB == null) {
                return null;
            }
            String name = method.getName();
            if ("onAdDownloadWindowShow".equals(name)) {
                cpuNativeStatusCB.onAdDownloadWindowShow();
            } else if ("onPermissionShow".equals(name)) {
                cpuNativeStatusCB.onPermissionShow();
            } else if ("onPermissionClose".equals(name)) {
                cpuNativeStatusCB.onPermissionClose();
            } else if ("onPrivacyClick".equals(name)) {
                cpuNativeStatusCB.onPrivacyClick();
            } else if ("onPrivacyLpClose".equals(name)) {
                cpuNativeStatusCB.onPrivacyLpClose();
            } else if ("onNotifyPerformance".equals(name)) {
                if (objArr != null && objArr.length >= 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof String) {
                        cpuNativeStatusCB.onNotifyPerformance((String) obj2);
                    }
                }
            } else if ("startRouter".equals(name)) {
                an.a((Context) objArr[0], (String) objArr[1]);
            }
            return null;
        }
    }

    public NativeCPUAdData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = at.a(context, CLASS_NAME);
        this.classLoader = bs.a(context);
    }

    private String getAdid() {
        return this.remoteUtils.c(this.mInstance, "getAdid", new Object[0]);
    }

    public void handleCanClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCanClickView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        as.a(this.mCtx.getApplicationContext()).b(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(View view) {
        this.remoteUtils.a(this.mInstance, "clickHotItem", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getActionType", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAdHeight", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAdLogoUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAdLogoUrl", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAdWidth", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPackageName() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getPackageName", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPermissionUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPublisher() {
        return this.remoteUtils.c(this.mInstance, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppVersion() {
        return this.remoteUtils.c(this.mInstance, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAttribute", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAuthor() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAuthor", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBaiduLogoUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getBaiduLogoUrl", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBrandName() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getBrandName", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelId() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getCatId", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelName() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getCatName", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getCommentCounts", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<Integer> getContentAttributesList() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getContentAttributesList", new Object[0]);
        if (b10 instanceof List) {
            return (List) b10;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getContentClickUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getContentClickUrl", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getCtime", new Object[0]);
        if (b10 instanceof Long) {
            return ((Long) b10).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getDesc() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getContent", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.remoteUtils.b(this.mInstance, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getDownloadStatus", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getDuration", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.remoteUtils.b(this.mInstance, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getHotId", new Object[0]);
        if (b10 instanceof Long) {
            return ((Long) b10).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getHotWord() {
        return this.remoteUtils.c(this.mInstance, "getHotWord", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getIconUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getAvatar", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getImage() {
        return this.remoteUtils.c(this.mInstance, "getImage", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getImageUrls() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getImageList", new Object[0]);
        if (b10 instanceof List) {
            return (List) b10;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getLabel() {
        return this.remoteUtils.c(this.mInstance, "getLabel", new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getPlayCounts", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getPresentationType", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getReadCounts", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getScore", new Object[0]);
        return b10 instanceof Double ? ((Double) b10).doubleValue() : c.f27899e;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getSmallImageList", new Object[0]);
        if (b10 instanceof List) {
            return (List) b10;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getStyleTypeCpu", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getThumbHeight", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getThumbUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getThumbUrl", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getThumbWidth", new Object[0]);
        if (b10 instanceof Integer) {
            return ((Integer) b10).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getTitle() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getType() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getType", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getUpdateTime() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getUpdateTime", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getVUrl() {
        Object b10 = this.remoteUtils.b(this.mInstance, "getVUrl", new Object[0]);
        return b10 instanceof String ? (String) b10 : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleClick(android.view.View r9, java.lang.Object... r10) {
        /*
            r8 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r8.mSettings
            if (r3 == 0) goto L14
            com.baidu.mobads.sdk.internal.at r4 = r8.remoteUtils
            java.lang.Object r5 = r8.mInstance
            java.lang.String r6 = "setConfigParams"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r1] = r3
            r4.a(r5, r6, r7)
        L14:
            if (r10 == 0) goto L26
            int r3 = r10.length
            if (r3 <= 0) goto L26
            r10 = r10[r1]
            boolean r3 = r10 instanceof java.lang.Long
            if (r3 == 0) goto L26
            java.lang.Long r10 = (java.lang.Long) r10
            long r3 = r10.longValue()
            goto L28
        L26:
            r3 = 0
        L28:
            boolean r10 = r9 instanceof com.baidu.mobads.sdk.api.CpuVideoView
            java.lang.String r5 = "handClickVideo"
            if (r10 == 0) goto L44
            com.baidu.mobads.sdk.internal.at r10 = r8.remoteUtils
            java.lang.Object r6 = r8.mInstance
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            r0[r2] = r3
            r10.a(r6, r5, r0)
            goto L5d
        L44:
            boolean r10 = r9 instanceof android.widget.TextView
            if (r10 == 0) goto L5d
            com.baidu.mobads.sdk.internal.at r10 = r8.remoteUtils
            java.lang.Object r6 = r8.mInstance
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            r0[r2] = r3
            r10.a(r6, r5, r0)
        L5d:
            com.baidu.mobads.sdk.internal.at r10 = r8.remoteUtils
            java.lang.Object r0 = r8.mInstance
            java.lang.String r3 = "handleClick"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r9
            r10.a(r0, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.api.NativeCPUAdData.handleClick(android.view.View, java.lang.Object[]):void");
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCreativeView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(View view, int i10) {
        this.remoteUtils.a(this.mInstance, "handleDislikeClick", view, Integer.valueOf(i10));
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        Object b10 = this.remoteUtils.b(this.mInstance, "isAutoplay", new Object[0]);
        if (b10 instanceof Boolean) {
            return ((Boolean) b10).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        Object b10 = this.remoteUtils.b(this.mInstance, "isCanGoLp", new Object[0]);
        if (b10 instanceof Boolean) {
            return ((Boolean) b10).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        return ((Boolean) this.remoteUtils.b(this.mInstance, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        Object b10 = this.remoteUtils.b(this.mInstance, "isTop", new Object[0]);
        if (b10 instanceof Boolean) {
            return ((Boolean) b10).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.remoteUtils.a(this.mInstance, "markDislike", strArr);
    }

    public void monitorVisibleTime(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "monitorVisibleTime", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        as.a(this.mCtx.getApplicationContext()).a(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        setStatusListener(cpuNativeStatusCB);
        onImpression(view);
        monitorVisibleTime(view);
        if (list != null && list.size() > 0) {
            for (View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1
                        final /* synthetic */ View val$clickView;

                        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$1$1 */
                        class RunnableC02191 implements Runnable {
                            public RunnableC02191() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                View view2 = view2;
                                if (view2 != null) {
                                    view2.setClickable(true);
                                }
                            }
                        }

                        public AnonymousClass1(View view22) {
                            view2 = view22;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            NativeCPUAdData.this.handleCanClickView(view3);
                            view2.setClickable(false);
                            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                                public RunnableC02191() {
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
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (View view3 : list2) {
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2
                    final /* synthetic */ List val$clickViews;
                    final /* synthetic */ View val$creativeView;

                    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$2$1 */
                    class AnonymousClass1 implements Runnable {
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (list != null) {
                                view3.setClickable(true);
                            }
                        }
                    }

                    public AnonymousClass2(View view32, List list3) {
                        view3 = view32;
                        list = list3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        NativeCPUAdData.this.handleCreativeView(view4);
                        view3.setClickable(false);
                        view3.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                if (list != null) {
                                    view3.setClickable(true);
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.classLoader, new Class[]{au.a(z.f7386n, this.classLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.3
                final /* synthetic */ IBasicCPUData.CpuNativeStatusCB val$cpuNativeStatusCBListener;

                public AnonymousClass3(IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB2) {
                    cpuNativeStatusCB = cpuNativeStatusCB2;
                }

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    ay.h("NativeCPUAdData").c("invoke: " + method.getName());
                    if (cpuNativeStatusCB == null) {
                        return null;
                    }
                    String name = method.getName();
                    if ("onAdDownloadWindowShow".equals(name)) {
                        cpuNativeStatusCB.onAdDownloadWindowShow();
                    } else if ("onPermissionShow".equals(name)) {
                        cpuNativeStatusCB.onPermissionShow();
                    } else if ("onPermissionClose".equals(name)) {
                        cpuNativeStatusCB.onPermissionClose();
                    } else if ("onPrivacyClick".equals(name)) {
                        cpuNativeStatusCB.onPrivacyClick();
                    } else if ("onPrivacyLpClose".equals(name)) {
                        cpuNativeStatusCB.onPrivacyLpClose();
                    } else if ("onNotifyPerformance".equals(name)) {
                        if (objArr != null && objArr.length >= 1) {
                            Object obj2 = objArr[0];
                            if (obj2 instanceof String) {
                                cpuNativeStatusCB.onNotifyPerformance((String) obj2);
                            }
                        }
                    } else if ("startRouter".equals(name)) {
                        an.a((Context) objArr[0], (String) objArr[1]);
                    }
                    return null;
                }
            }));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof ae) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof IOAdEvent)) {
            IOAdEvent iOAdEvent = (IOAdEvent) obj;
            String message = iOAdEvent.getMessage();
            Map<String, Object> data = iOAdEvent.getData();
            if (data != null) {
                Object obj2 = data.get("adid");
                if ((obj2 instanceof String) && ((String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }
}
