package com.alimm.tanx.core.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.NotConfused;
import h3.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxJsBridge implements NotConfused {
    private static final String TAG = "TanxJsBridge";
    Context context;
    private final WebView webView;
    private Integer uniqueId = 0;
    public HashMap<String, Callback> responseCallbacks = new HashMap<>();
    public HashMap<String, JsHandler> messageHandlers = new HashMap<>();

    @SuppressLint({"SetJavaScriptEnabled"})
    public TanxJsBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.addJavascriptInterface(this, "normal");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: v1.c.<init>(com.alimm.tanx.core.bridge.TanxJsBridge, java.lang.String):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private void dispatch(java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "jsBridge dispatch failed"
            java.lang.String r1 = "TanxJsBridge"
            com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject
            r2.<init>(r6)
            java.lang.String r6 = r2.toString()
            java.lang.String r2 = "\\"
            java.lang.String r3 = "\\\\"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\""
            java.lang.String r3 = "\\\""
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "'"
            java.lang.String r3 = "\\'"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\n"
            java.lang.String r3 = "\\n"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\r"
            java.lang.String r3 = "\\r"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\f"
            java.lang.String r3 = "\\f"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\u2028"
            java.lang.String r3 = "\\u2028"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "\u2029"
            java.lang.String r3 = "\\u2029"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "MamaBridge.handleMessageFromNative('%s');"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r6
            java.lang.String r6 = java.lang.String.format(r2, r3)
            android.webkit.WebView r2 = r5.webView     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            boolean r2 = com.alimm.tanx.core.ad.base.tanxc_if.tanxc_if(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            if (r2 != 0) goto L72
            android.webkit.WebView r2 = r5.webView     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            v1.c r3 = new v1.c     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r3.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r2.post(r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            goto L7f
        L6e:
            r6 = move-exception
            goto L80
        L70:
            r6 = move-exception
            goto L7b
        L72:
            java.lang.String r6 = "webView已经回收，无法分发数据，终止！！！！"
            com.alimm.tanx.core.utils.LogUtils.e(r1, r6)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
        L77:
            com.alimm.tanx.core.utils.LogUtils.e(r1, r0)
            goto L7f
        L7b:
            com.alimm.tanx.core.utils.LogUtils.e(r1, r6)     // Catch: java.lang.Throwable -> L6e
            goto L77
        L7f:
            return
        L80:
            com.alimm.tanx.core.utils.LogUtils.e(r1, r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.bridge.TanxJsBridge.dispatch(java.util.HashMap):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: v1.a.<init>(com.alimm.tanx.core.bridge.TanxJsBridge, java.lang.String):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private void flush(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 != 0) goto La
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.String r0 = "Javascript give data is null"
            r6.println(r0)
            return
        La:
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject(r6, r0)
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.String r1 = "callbackId"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L22
            v1.a r2 = new v1.a
            r2.<init>()
            goto L27
        L22:
            v1.b r2 = new v1.b
            r2.<init>()
        L27:
            java.lang.String r1 = "TanxJsBridge"
            com.alimm.tanx.core.utils.LogUtils.d(r1, r6)
            java.lang.String r6 = "handlerName"
            java.lang.Object r6 = r0.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r3 = "data"
            java.lang.Object r0 = r0.get(r3)
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0
            java.util.HashMap<java.lang.String, com.alimm.tanx.core.bridge.JsHandler> r3 = r5.messageHandlers
            java.lang.Object r6 = r3.get(r6)
            com.alimm.tanx.core.bridge.JsHandler r6 = (com.alimm.tanx.core.bridge.JsHandler) r6
            if (r6 != 0) goto L51
            java.lang.String r6 = "jsHandler is null"
            com.alimm.tanx.core.utils.LogUtils.d(r1, r6)
            r6 = 0
            r0 = 0
            r2.call(r6, r0)
            return
        L51:
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Exception -> L7a
            r1.<init>()     // Catch: java.lang.Exception -> L7a
            if (r0 == 0) goto L7c
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Exception -> L7a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L7a
        L60:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Exception -> L7a
            if (r3 == 0) goto L7c
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Exception -> L7a
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Exception -> L7a
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Exception -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L7a
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Exception -> L7a
            r1.put(r4, r3)     // Catch: java.lang.Exception -> L7a
            goto L60
        L7a:
            r6 = move-exception
            goto L80
        L7c:
            r6.handler(r1, r2)     // Catch: java.lang.Exception -> L7a
            goto L83
        L80:
            r6.printStackTrace()
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.bridge.TanxJsBridge.flush(java.lang.String):void");
    }

    private String getFromAssets(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public /* synthetic */ void lambda$dispatch$5(String str) {
        this.webView.evaluateJavascript(str, null);
    }

    public /* synthetic */ void lambda$flush$3(String str, boolean z10, AbstractMap abstractMap) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("responseId", str);
        hashMap.put("responseData", abstractMap);
        hashMap.put("success", Boolean.valueOf(z10));
        dispatch(hashMap);
    }

    public void call(String str, HashMap<String, String> hashMap, Callback callback) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("handlerName", str);
        if (hashMap != null) {
            hashMap2.put(e.f26408m, hashMap);
        }
        if (callback != null) {
            this.uniqueId = Integer.valueOf(this.uniqueId.intValue() + 1);
            String str2 = "native_cb_" + this.uniqueId;
            this.responseCallbacks.put(str2, callback);
            hashMap2.put("callbackId", str2);
        }
        dispatch(hashMap2);
    }

    public void injectJavascript() {
        String fromAssets = getFromAssets(this.context, "mama.js");
        this.webView.loadUrl("javascript:" + fromAssets);
    }

    public void postEvent(String str, Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("eventName", str);
        hashMap.put("eventData", map);
        dispatch(hashMap);
    }

    @JavascriptInterface
    public void postMessage(String str) {
        flush(str);
    }

    public void ready() {
    }

    public void register(String str, JsHandler jsHandler) {
        this.messageHandlers.put(str, jsHandler);
    }

    public void remove(String str) {
        this.messageHandlers.remove(str);
    }
}
