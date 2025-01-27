package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: classes4.dex */
public class c implements DownloadEventConfig {

    /* renamed from: a */
    private String f20943a;

    /* renamed from: b */
    private boolean f20944b;

    /* renamed from: c */
    private String f20945c;

    /* renamed from: d */
    private String f20946d;

    /* renamed from: e */
    private String f20947e;

    /* renamed from: f */
    private String f20948f;

    /* renamed from: g */
    private String f20949g;

    /* renamed from: h */
    private String f20950h;

    /* renamed from: i */
    private String f20951i;

    /* renamed from: j */
    private String f20952j;

    /* renamed from: k */
    private String f20953k;

    /* renamed from: l */
    private Object f20954l;

    /* renamed from: m */
    private boolean f20955m;

    /* renamed from: n */
    private boolean f20956n;

    /* renamed from: o */
    private boolean f20957o;

    /* renamed from: p */
    private String f20958p;

    /* renamed from: q */
    private String f20959q;

    public static final class a {

        /* renamed from: a */
        private String f20960a;

        /* renamed from: b */
        private boolean f20961b;

        /* renamed from: c */
        private String f20962c;

        /* renamed from: d */
        private String f20963d;

        /* renamed from: e */
        private String f20964e;

        /* renamed from: f */
        private String f20965f;

        /* renamed from: g */
        private String f20966g;

        /* renamed from: h */
        private String f20967h;

        /* renamed from: i */
        private String f20968i;

        /* renamed from: j */
        private String f20969j;

        /* renamed from: k */
        private String f20970k;

        /* renamed from: l */
        private Object f20971l;

        /* renamed from: m */
        private boolean f20972m;

        /* renamed from: n */
        private boolean f20973n;

        /* renamed from: o */
        private boolean f20974o;

        /* renamed from: p */
        private String f20975p;

        /* renamed from: q */
        private String f20976q;

        public c a() {
            return new c(this);
        }
    }

    public /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f20943a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f20948f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f20949g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f20945c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f20947e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f20946d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f20954l;
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
        return this.f20959q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f20952j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f20944b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.f20955m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i10) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    private c(a aVar) {
        this.f20943a = aVar.f20960a;
        this.f20944b = aVar.f20961b;
        this.f20945c = aVar.f20962c;
        this.f20946d = aVar.f20963d;
        this.f20947e = aVar.f20964e;
        this.f20948f = aVar.f20965f;
        this.f20949g = aVar.f20966g;
        this.f20950h = aVar.f20967h;
        this.f20951i = aVar.f20968i;
        this.f20952j = aVar.f20969j;
        this.f20953k = aVar.f20970k;
        this.f20954l = aVar.f20971l;
        this.f20955m = aVar.f20972m;
        this.f20956n = aVar.f20973n;
        this.f20957o = aVar.f20974o;
        this.f20958p = aVar.f20975p;
        this.f20959q = aVar.f20976q;
    }
}
