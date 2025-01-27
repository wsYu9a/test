package com.bytedance.pangle.apm;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public class ApmUtils {
    public static final int FLAG_ANR_MONITOR = 2;
    public static final int FLAG_JAVA_CRASH = 1;
    public static final int FLAG_NATIVE_CRASH = 4;
    public static final int FLAG_REGISTER_JAVA_CRASH = 8;
    private static volatile AbsApm sApm;

    /* renamed from: com.bytedance.pangle.apm.ApmUtils$1 */
    static class AnonymousClass1 extends AbsApm {
        AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final String getDid() {
            return "0";
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void init() {
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void reportError(String str, @NonNull Throwable th) {
        }
    }

    public static AbsApm getApmInstance() {
        if (sApm == null) {
            synchronized (AbsApm.class) {
                if (sApm == null) {
                    sApm = new AbsApm() { // from class: com.bytedance.pangle.apm.ApmUtils.1
                        AnonymousClass1() {
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final String getDid() {
                            return "0";
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void init() {
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void reportError(String str, @NonNull Throwable th) {
                        }
                    };
                }
            }
        }
        return sApm;
    }

    public static synchronized void register(AbsApm absApm) {
        synchronized (ApmUtils.class) {
            sApm = absApm;
        }
    }
}
