package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$1 */
    public class AnonymousClass1 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$10 */
    public class AnonymousClass10 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass10() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$11 */
    public class AnonymousClass11 implements ValueSet.ValueGetter<String> {
        public AnonymousClass11() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public String get() {
            return TTCustomController.this.getMacAddress();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$12 */
    public class AnonymousClass12 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass12() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$13 */
    public class AnonymousClass13 implements ValueSet.ValueGetter<String> {
        public AnonymousClass13() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public String get() {
            return TTCustomController.this.getDevOaid();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$2 */
    public class AnonymousClass2 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass2() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$3 */
    public class AnonymousClass3 implements ValueSet.ValueGetter<String> {
        public AnonymousClass3() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public String get() {
            return TTCustomController.this.getAndroidId();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$4 */
    public class AnonymousClass4 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass4() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$5 */
    public class AnonymousClass5 implements ValueSet.ValueGetter<Map> {
        public AnonymousClass5() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Map get() {
            return TTCustomController.this.userPrivacyConfig();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$6 */
    public class AnonymousClass6 implements ValueSet.ValueGetter<ValueSet> {
        public AnonymousClass6() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public ValueSet get() {
            return c.a(TTCustomController.this.getTTLocation());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$7 */
    public class AnonymousClass7 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass7() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.alist());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$8 */
    public class AnonymousClass8 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass8() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.d$9 */
    public class AnonymousClass9 implements ValueSet.ValueGetter<String> {
        public AnonymousClass9() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public String get() {
            return TTCustomController.this.getDevImei();
        }
    }

    public static final ValueSet a(TTCustomController tTCustomController) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a();
        if (tTCustomController == null) {
            return null;
        }
        a10.a(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.1
            public AnonymousClass1() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        a10.a(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.6
            public AnonymousClass6() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public ValueSet get() {
                return c.a(TTCustomController.this.getTTLocation());
            }
        });
        a10.a(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.7
            public AnonymousClass7() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        a10.a(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.8
            public AnonymousClass8() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        a10.a(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.9
            public AnonymousClass9() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        a10.a(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.10
            public AnonymousClass10() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        a10.a(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.11
            public AnonymousClass11() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        a10.a(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.12
            public AnonymousClass12() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        a10.a(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.13
            public AnonymousClass13() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        a10.a(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.2
            public AnonymousClass2() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        a10.a(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.3
            public AnonymousClass3() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        a10.a(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.4
            public AnonymousClass4() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        a10.a(262119, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.d.5
            public AnonymousClass5() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Map get() {
                return TTCustomController.this.userPrivacyConfig();
            }
        });
        return a10.b();
    }
}
