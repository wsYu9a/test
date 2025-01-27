package com.opos.cmn.biz.ststrategy;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class UpdateParams {
    public final String pkgName;

    public static class Builder {

        /* renamed from: a */
        private String f16812a;

        public UpdateParams build() {
            if (TextUtils.isEmpty(this.f16812a)) {
                throw new NullPointerException("update params can not be null!");
            }
            return new UpdateParams(this);
        }

        public Builder setPkgName(String str) {
            this.f16812a = str;
            return this;
        }
    }

    private UpdateParams(Builder builder) {
        this.pkgName = builder.f16812a;
    }

    /* synthetic */ UpdateParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
