package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: classes4.dex */
public class i implements DownloadEventConfig {
    private String ei;

    /* renamed from: g */
    private String f24058g;
    private String gv;

    /* renamed from: i */
    private String f24059i;

    /* renamed from: j */
    private String f24060j;
    private String k;
    private String lg;
    private Object nt;
    private boolean p;
    private String pa;
    private String q;
    private boolean r;
    private String s;
    private String t;
    private boolean w;
    private String y;
    private boolean zx;

    public static final class j {
        private String ei;

        /* renamed from: g */
        private String f24061g;
        private String gv;

        /* renamed from: i */
        private String f24062i;

        /* renamed from: j */
        private String f24063j;
        private String k;
        private String lg;
        private Object nt;
        private boolean p;
        private String pa;
        private String q;
        private boolean r;
        private String s;
        private String t;
        private boolean w;
        private String y;
        private boolean zx;

        public i j() {
            return new i(this);
        }
    }

    /* synthetic */ i(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f24060j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.gv;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.lg;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f24059i;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f24058g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.nt;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.ei;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.pa;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.zx;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.p;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public i() {
    }

    private i(j jVar) {
        this.f24060j = jVar.f24063j;
        this.zx = jVar.zx;
        this.f24059i = jVar.f24062i;
        this.f24058g = jVar.f24061g;
        this.q = jVar.q;
        this.gv = jVar.gv;
        this.lg = jVar.lg;
        this.y = jVar.y;
        this.k = jVar.k;
        this.pa = jVar.pa;
        this.t = jVar.t;
        this.nt = jVar.nt;
        this.p = jVar.p;
        this.r = jVar.r;
        this.w = jVar.w;
        this.s = jVar.s;
        this.ei = jVar.ei;
    }
}
