package com.opos.cmn.biz.ststrategy.entity;

import java.util.Map;

/* loaded from: classes4.dex */
public class DataEntity {
    public final EncryptEntity encryptEntity;
    public final Map<String, MetaEntity> metaEntityMap;
    public final StrategyEntity strategyEntity;

    public static class Builder {
        private EncryptEntity encryptEntity;
        public Map<String, MetaEntity> metaEntityMap;
        public StrategyEntity strategyEntity;

        public DataEntity build() {
            return new DataEntity(this);
        }

        public Builder setEncryptEntity(EncryptEntity encryptEntity) {
            this.encryptEntity = encryptEntity;
            return this;
        }

        public Builder setMetaEntityMap(Map<String, MetaEntity> map) {
            this.metaEntityMap = map;
            return this;
        }

        public Builder setStrategyEntity(StrategyEntity strategyEntity) {
            this.strategyEntity = strategyEntity;
            return this;
        }
    }

    private DataEntity(Builder builder) {
        this.strategyEntity = builder.strategyEntity;
        this.metaEntityMap = builder.metaEntityMap;
        this.encryptEntity = builder.encryptEntity;
    }

    /* synthetic */ DataEntity(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "DataEntity{strategyEntity=" + this.strategyEntity + ", metaEntityMap=" + this.metaEntityMap + ", encryptEntity=" + this.encryptEntity + '}';
    }
}
