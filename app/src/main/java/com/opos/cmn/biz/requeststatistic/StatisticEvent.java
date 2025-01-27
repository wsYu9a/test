package com.opos.cmn.biz.requeststatistic;

/* loaded from: classes4.dex */
public class StatisticEvent {
    public final String channel;
    public final long currentTime;
    public final String eventId;
    public final String ext;
    public final long maxResolveTime;
    public final String net;
    public final long resolveTime;
    public final long ret;
    public final String sdkVersion;
    public final String url;

    public static class Builder {

        /* renamed from: a */
        private String f16762a;

        /* renamed from: b */
        private String f16763b;

        /* renamed from: c */
        private long f16764c;

        /* renamed from: d */
        private String f16765d;

        /* renamed from: e */
        private long f16766e;

        /* renamed from: f */
        private long f16767f;

        /* renamed from: g */
        private long f16768g;

        /* renamed from: h */
        private String f16769h = "";

        /* renamed from: i */
        private String f16770i;

        /* renamed from: j */
        private String f16771j;

        public Builder(String str, String str2, long j2, long j3, long j4, String str3) {
            this.f16763b = str;
            this.f16765d = str2;
            this.f16766e = j2;
            this.f16767f = j3;
            this.f16768g = j4;
            this.f16770i = str3;
        }

        public StatisticEvent build() {
            return new StatisticEvent(this, (byte) 0);
        }

        public Builder setCurrentTime(long j2) {
            this.f16764c = j2;
            return this;
        }

        public Builder setExt(String str) {
            this.f16769h = str;
            return this;
        }

        public Builder setNet(String str) {
            this.f16762a = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.f16771j = str;
            return this;
        }
    }

    private StatisticEvent(Builder builder) {
        this.eventId = builder.f16763b;
        this.url = builder.f16765d;
        this.ret = builder.f16766e;
        this.currentTime = builder.f16764c;
        this.resolveTime = builder.f16767f;
        this.maxResolveTime = builder.f16768g;
        this.net = builder.f16762a;
        this.ext = builder.f16769h;
        this.channel = builder.f16770i;
        this.sdkVersion = builder.f16771j;
    }

    /* synthetic */ StatisticEvent(Builder builder, byte b2) {
        this(builder);
    }
}
