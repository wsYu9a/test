package com.vivo.mobilead;

import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class BaseAdParams {
    private static final String TAG = "BaseAdParams";
    private int adCount;
    private String appId;
    private BackUrlInfo backUrlInfo;
    private int floorPrice;
    private String gameId;
    private String mSourceAppend;
    private String positionId;

    public static class a {
        private int adCount;
        private String appId;
        private BackUrlInfo backUrlInfo;
        private int floorPrice = -1;
        private String gameId;
        private String positionId;

        public a(String str) {
            this.positionId = str;
        }

        public BaseAdParams build() {
            throw null;
        }

        public a setAdCount(int i2) {
            this.adCount = i2;
            return this;
        }

        public a setBackUrlInfo(BackUrlInfo backUrlInfo) {
            this.backUrlInfo = backUrlInfo;
            return this;
        }

        public a setFloorPrice(int i2) {
            this.floorPrice = i2;
            return this;
        }

        public a setGameId(String str) {
            this.gameId = str;
            return this;
        }

        public a setWxAppId(String str) {
            this.appId = str;
            return this;
        }
    }

    public BaseAdParams(a aVar) {
        this.adCount = 1;
        this.positionId = aVar.positionId;
        this.gameId = aVar.gameId;
        this.backUrlInfo = aVar.backUrlInfo;
        this.mSourceAppend = w0.b(aVar.gameId);
        this.adCount = aVar.adCount;
        this.floorPrice = aVar.floorPrice;
        this.appId = aVar.appId;
    }

    public int getAdCount() {
        return this.adCount;
    }

    public BackUrlInfo getBackUrlInfo() {
        return this.backUrlInfo;
    }

    public int getFloorPrice() {
        return this.floorPrice;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getPositionId() {
        return this.positionId;
    }

    public String getSourceAppend() {
        return this.mSourceAppend;
    }

    public String getWxAppId() {
        return this.appId;
    }

    public void setPositionId(String str) {
        this.positionId = str;
    }
}
