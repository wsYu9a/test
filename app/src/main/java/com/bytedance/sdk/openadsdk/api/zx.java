package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes.dex */
public final class zx {

    /* renamed from: j */
    private boolean f6449j = false;
    private int zx = -1;

    /* renamed from: i */
    private String f6448i = null;

    /* renamed from: g */
    private ValueSet f6447g = null;

    private static final class j implements Result {

        /* renamed from: g */
        private final ValueSet f6450g;

        /* renamed from: i */
        private final String f6451i;

        /* renamed from: j */
        private final boolean f6452j;
        private final int zx;

        /* synthetic */ j(boolean z, int i2, String str, ValueSet valueSet, AnonymousClass1 anonymousClass1) {
            this(z, i2, str, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.zx;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f6452j;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f6451i;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f6450g;
        }

        private j(boolean z, int i2, String str, ValueSet valueSet) {
            this.f6452j = z;
            this.zx = i2;
            this.f6451i = str;
            this.f6450g = valueSet;
        }
    }

    private zx() {
    }

    public static final zx j() {
        return new zx();
    }

    public Result zx() {
        boolean z = this.f6449j;
        int i2 = this.zx;
        String str = this.f6448i;
        ValueSet valueSet = this.f6447g;
        if (valueSet == null) {
            valueSet = i.j().zx();
        }
        return new j(z, i2, str, valueSet);
    }

    public zx j(boolean z) {
        this.f6449j = z;
        return this;
    }

    public zx j(int i2) {
        this.zx = i2;
        return this;
    }

    public zx j(ValueSet valueSet) {
        this.f6447g = valueSet;
        return this;
    }
}
