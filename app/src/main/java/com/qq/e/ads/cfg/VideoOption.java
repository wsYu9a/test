package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class VideoOption {

    /* renamed from: a */
    private final boolean f23888a;

    /* renamed from: b */
    private final int f23889b;

    /* renamed from: c */
    private final boolean f23890c;

    /* renamed from: d */
    private final boolean f23891d;

    /* renamed from: e */
    private final boolean f23892e;

    /* renamed from: f */
    private final boolean f23893f;

    /* renamed from: g */
    private final boolean f23894g;

    /* renamed from: h */
    private final int f23895h;

    /* renamed from: i */
    private final int f23896i;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean f23897a = true;

        /* renamed from: b */
        private int f23898b = 1;

        /* renamed from: c */
        private boolean f23899c = true;

        /* renamed from: d */
        private boolean f23900d = true;

        /* renamed from: e */
        private boolean f23901e = true;

        /* renamed from: f */
        private boolean f23902f = false;

        /* renamed from: g */
        private boolean f23903g = false;

        /* renamed from: h */
        private int f23904h;

        /* renamed from: i */
        private int f23905i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f23897a = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.f23898b = i2;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f23903g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.f23901e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f23902f = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f23904h = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f23905i = i2;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f23900d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f23899c = z;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f23888a = builder.f23897a;
        this.f23889b = builder.f23898b;
        this.f23890c = builder.f23899c;
        this.f23891d = builder.f23900d;
        this.f23892e = builder.f23901e;
        this.f23893f = builder.f23902f;
        this.f23894g = builder.f23903g;
        this.f23895h = builder.f23904h;
        this.f23896i = builder.f23905i;
    }

    /* synthetic */ VideoOption(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f23888a;
    }

    public int getAutoPlayPolicy() {
        return this.f23889b;
    }

    public int getMaxVideoDuration() {
        return this.f23895h;
    }

    public int getMinVideoDuration() {
        return this.f23896i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f23888a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f23889b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f23894g));
        } catch (Exception e2) {
            GDTLogger.d("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f23894g;
    }

    public boolean isEnableDetailPage() {
        return this.f23892e;
    }

    public boolean isEnableUserControl() {
        return this.f23893f;
    }

    public boolean isNeedCoverImage() {
        return this.f23891d;
    }

    public boolean isNeedProgressBar() {
        return this.f23890c;
    }
}
