package com.umeng.vt.diff;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Channel {
    private static final String UM_VISUAL_IMPRINT = "utm-visual";

    /* renamed from: com.umeng.vt.diff.Channel$1 */
    public class AnonymousClass1 implements UMImprintChangeCallback {
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(String str, String str2) {
            if (Channel.UM_VISUAL_IMPRINT.equals(str)) {
                Channel.this.loadConfig(context);
            }
        }
    }

    private void download() {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("download", null)) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", null).invoke(null, null), null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void storeConfig(Map<String, String> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("storeConfig", Map.class)) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", null).invoke(null, null), map);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void init(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        loadConfig(applicationContext);
        registerListener(applicationContext);
    }

    public void loadConfig(Context context) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, UM_VISUAL_IMPRINT, null);
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        String str = new String(Base64.decode(imprintProperty, 0));
        HashMap hashMap = new HashMap();
        hashMap.put("data-track", str);
        storeConfig(hashMap);
    }

    public void registerListener(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(UM_VISUAL_IMPRINT, new UMImprintChangeCallback() { // from class: com.umeng.vt.diff.Channel.1
            final /* synthetic */ Context val$context;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (Channel.UM_VISUAL_IMPRINT.equals(str)) {
                    Channel.this.loadConfig(context);
                }
            }
        });
    }
}
