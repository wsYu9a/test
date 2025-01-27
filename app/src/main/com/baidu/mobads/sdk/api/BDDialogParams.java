package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final Builder mBuilder;

    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public BDDialogParams build() {
            return new BDDialogParams(this);
        }

        public Builder setDlDialogAnimStyle(int i10) {
            this.mDlDialogAnimStyle = i10;
            return this;
        }

        public Builder setDlDialogType(int i10) {
            this.mDlDialogType = i10;
            return this;
        }
    }

    public /* synthetic */ BDDialogParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        return jSONObject;
    }

    private BDDialogParams(Builder builder) {
        this.mBuilder = builder;
    }
}
