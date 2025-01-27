package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.a$1 */
    public class AnonymousClass1 implements ValueSet.ValueGetter<Integer> {
        public AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Integer get() {
            return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.a$2 */
    public class AnonymousClass2 implements ValueSet.ValueGetter<Integer> {
        public AnonymousClass2() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Integer get() {
            return Integer.valueOf(AdConfig.this.getAgeGroup());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.a$3 */
    public class AnonymousClass3 implements ValueSet.ValueGetter<Integer> {
        public AnonymousClass3() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Integer get() {
            return Integer.valueOf(AdConfig.this.getThemeStatus());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.a$4 */
    public class AnonymousClass4 implements ValueSet.ValueGetter<Map> {
        public AnonymousClass4() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Map get() {
            return AdConfig.this.getInitExtra();
        }
    }

    public static final ValueSet a(AdConfig adConfig) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a();
        if (adConfig == null) {
            return null;
        }
        a10.a(261001, adConfig.getAppId());
        a10.a(261002, adConfig.getAppName());
        a10.a(261003, adConfig.isPaid());
        a10.a(261004, adConfig.getKeywords());
        a10.a(261005, adConfig.getData());
        a10.a(261006, adConfig.getTitleBarTheme());
        a10.a(261007, adConfig.isAllowShowNotify());
        a10.a(261008, adConfig.isDebug());
        a10.a(261009, adConfig.getDirectDownloadNetworkType());
        a10.a(261011, adConfig.isSupportMultiProcess());
        a10.a(261012, adConfig.getCustomController() != null ? d.a(adConfig.getCustomController()) : null);
        a10.a(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.1
            public AnonymousClass1() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        a10.a(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.2
            public AnonymousClass2() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        a10.a(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.3
            public AnonymousClass3() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        a10.a(261018, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.4
            public AnonymousClass4() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Map get() {
                return AdConfig.this.getInitExtra();
            }
        });
        return a10.b();
    }
}
