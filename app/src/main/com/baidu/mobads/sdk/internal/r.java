package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a */
    private static final String f7231a = "vstart";

    /* renamed from: b */
    private static final String f7232b = "vrepeatedplay";

    /* renamed from: c */
    private static final String f7233c = "vclose";

    /* renamed from: d */
    private static final String f7234d = "vreadyplay";

    /* renamed from: e */
    private static final String f7235e = "vplayfail";

    /* renamed from: f */
    private static final String f7236f = "vmute";

    /* renamed from: g */
    private static final String f7237g = "vfrozen";

    /* renamed from: h */
    private static final String f7238h = "vshow";

    /* renamed from: i */
    private static final String f7239i = "curTimeSec";

    /* renamed from: j */
    private static final String f7240j = "startTimeSec";

    /* renamed from: k */
    private static final String f7241k = "autoPlay";

    /* renamed from: l */
    private static final String f7242l = "reasonValue";

    /* renamed from: m */
    private final de f7243m;

    /* renamed from: n */
    private final a f7244n;

    /* renamed from: o */
    private boolean f7245o = false;

    /* renamed from: p */
    private int f7246p = 0;

    public r(de deVar, a aVar) {
        this.f7243m = deVar;
        this.f7244n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject U;
        if (this.f7243m == null || (aVar = this.f7244n) == null || (U = aVar.U()) == null) {
            return;
        }
        try {
            U.put("msg", "sendVideoThirdLog");
            U.put("trackType", str);
            U.put("trackInfo", jSONObject);
            this.f7243m.a(U);
        } catch (Throwable th2) {
            bt.a().d(th2.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.f7244n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i10) {
        a(f7235e, a(this.f7246p, i10, this.f7245o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i10) {
        a(f7237g, a(this.f7246p, i10, this.f7245o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(f7234d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i10, boolean z10) {
        a(f7236f, a(this.f7246p, i10, this.f7245o, z10 ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i10, NativeResponse.VideoReason videoReason) {
        a("vclose", a(this.f7246p, i10, this.f7245o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f7246p = 0;
        a(f7232b, a(0, 0, this.f7245o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i10) {
        this.f7246p = i10;
        a(f7231a, a(i10, i10, this.f7245o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(f7238h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z10) {
        this.f7246p = 0;
        this.f7245o = z10;
        a(f7231a, a(0, 0, z10, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i10, NativeResponse.VideoReason videoReason) {
        a("vclose", a(this.f7246p, i10, this.f7245o, videoReason.getCode()));
    }

    private JSONObject a(int i10, int i11, boolean z10, int i12) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f7240j, i10 / 1000);
            jSONObject.put(f7239i, i11 / 1000);
            jSONObject.put(f7241k, z10);
            jSONObject.put(f7242l, i12);
        } catch (Throwable th2) {
            bt.a().d(th2.getMessage());
        }
        return jSONObject;
    }
}
