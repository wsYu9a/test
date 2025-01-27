package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VideoOption {

    /* renamed from: a */
    private final boolean f16399a;

    /* renamed from: b */
    private final int f16400b;

    /* renamed from: c */
    private final boolean f16401c;

    /* renamed from: d */
    private final boolean f16402d;

    /* renamed from: e */
    private final boolean f16403e;

    /* renamed from: f */
    private final boolean f16404f;

    /* renamed from: g */
    private final boolean f16405g;

    /* renamed from: h */
    private final int f16406h;

    /* renamed from: i */
    private final int f16407i;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean f16408a = true;

        /* renamed from: b */
        private int f16409b = 1;

        /* renamed from: c */
        private boolean f16410c = true;

        /* renamed from: d */
        private boolean f16411d = true;

        /* renamed from: e */
        private boolean f16412e = true;

        /* renamed from: f */
        private boolean f16413f = false;

        /* renamed from: g */
        private boolean f16414g = false;

        /* renamed from: h */
        private int f16415h;

        /* renamed from: i */
        private int f16416i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z10) {
            this.f16408a = z10;
            return this;
        }

        public Builder setAutoPlayPolicy(int i10) {
            if (i10 < 0 || i10 > 2) {
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                i10 = 1;
            }
            this.f16409b = i10;
            return this;
        }

        @Deprecated
        public Builder setDetailPageMuted(boolean z10) {
            this.f16414g = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableDetailPage(boolean z10) {
            this.f16412e = z10;
            return this;
        }

        public Builder setEnableUserControl(boolean z10) {
            this.f16413f = z10;
            return this;
        }

        public Builder setMaxVideoDuration(int i10) {
            this.f16415h = i10;
            return this;
        }

        public Builder setMinVideoDuration(int i10) {
            this.f16416i = i10;
            return this;
        }

        public Builder setNeedCoverImage(boolean z10) {
            this.f16411d = z10;
            return this;
        }

        public Builder setNeedProgressBar(boolean z10) {
            this.f16410c = z10;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f16399a = builder.f16408a;
        this.f16400b = builder.f16409b;
        this.f16401c = builder.f16410c;
        this.f16402d = builder.f16411d;
        this.f16403e = builder.f16412e;
        this.f16404f = builder.f16413f;
        this.f16405g = builder.f16414g;
        this.f16406h = builder.f16415h;
        this.f16407i = builder.f16416i;
    }

    public boolean getAutoPlayMuted() {
        return this.f16399a;
    }

    public int getAutoPlayPolicy() {
        return this.f16400b;
    }

    public int getMaxVideoDuration() {
        return this.f16406h;
    }

    public int getMinVideoDuration() {
        return this.f16407i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f16399a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f16400b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f16405g));
        } catch (Exception e10) {
            GDTLogger.d("Get video options error: " + e10.getMessage());
        }
        return jSONObject;
    }

    @Deprecated
    public boolean isDetailPageMuted() {
        return this.f16405g;
    }

    @Deprecated
    public boolean isEnableDetailPage() {
        return this.f16403e;
    }

    public boolean isEnableUserControl() {
        return this.f16404f;
    }

    public boolean isNeedCoverImage() {
        return this.f16402d;
    }

    public boolean isNeedProgressBar() {
        return this.f16401c;
    }

    public /* synthetic */ VideoOption(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
