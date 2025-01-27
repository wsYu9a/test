package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.b$1 */
    public class AnonymousClass1 implements ValueSet.ValueGetter<String> {
        public AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public String get() {
            return AdSlot.this.getRewardName();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.b$2 */
    public class AnonymousClass2 implements ValueSet.ValueGetter<Integer> {
        public AnonymousClass2() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Integer get() {
            return Integer.valueOf(AdSlot.this.getRewardAmount());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.c.b$3 */
    public class AnonymousClass3 implements ValueSet.ValueGetter<Boolean> {
        public AnonymousClass3() {
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: a */
        public Boolean get() {
            return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
        }
    }

    public static final ValueSet a(AdSlot adSlot) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a();
        if (adSlot == null) {
            return null;
        }
        a10.a(260001, adSlot.getAdId());
        a10.a(260002, adSlot.getCreativeId());
        a10.a(260003, adSlot.getExt());
        a10.a(260004, adSlot.getCodeId());
        a10.a(260005, adSlot.isAutoPlay());
        a10.a(260006, adSlot.getImgAcceptedWidth());
        a10.a(260007, adSlot.getImgAcceptedHeight());
        a10.a(260008, adSlot.getExpressViewAcceptedWidth());
        a10.a(260009, adSlot.getExpressViewAcceptedHeight());
        a10.a(260010, adSlot.isSupportDeepLink());
        a10.a(260011, adSlot.isSupportRenderConrol());
        a10.a(2600012, adSlot.getAdCount());
        a10.a(260013, adSlot.getMediaExtra());
        a10.a(260014, adSlot.getUserID());
        a10.a(260015, adSlot.getOrientation());
        a10.a(260016, adSlot.getNativeAdType());
        a10.a(260017, adSlot.getExternalABVid());
        a10.a(260018, adSlot.getAdloadSeq());
        a10.a(260019, adSlot.getPrimeRit());
        a10.a(260020, adSlot.getAdType());
        a10.a(260021, adSlot.getBidAdm());
        a10.a(260022, adSlot.getUserData());
        a10.a(260023, adSlot.getAdLoadType());
        a10.a(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.1
            public AnonymousClass1() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        a10.a(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.2
            public AnonymousClass2() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        a10.a(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.3
            public AnonymousClass3() {
            }

            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        return a10.b();
    }
}
