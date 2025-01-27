package com.opos.cmn.biz.ststrategy.entity;

/* loaded from: classes4.dex */
public class STConfigEntity {
    public final int code;
    public final DataEntity dataEntity;
    public final String msg;

    public static class Builder {
        public int code;
        public DataEntity dataEntity;
        public String msg;

        public STConfigEntity build() {
            return new STConfigEntity(this);
        }

        public Builder setCode(int i2) {
            this.code = i2;
            return this;
        }

        public Builder setDataEntity(DataEntity dataEntity) {
            this.dataEntity = dataEntity;
            return this;
        }

        public Builder setMsg(String str) {
            this.msg = str;
            return this;
        }
    }

    private STConfigEntity(Builder builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.dataEntity = builder.dataEntity;
    }

    /* synthetic */ STConfigEntity(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "STConfigEntity{code=" + this.code + ", msg='" + this.msg + "', dataEntity=" + this.dataEntity + '}';
    }
}
