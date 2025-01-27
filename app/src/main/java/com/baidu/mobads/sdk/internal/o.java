package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a */
    private static final String f5833a = "vstart";

    /* renamed from: b */
    private static final String f5834b = "vrepeatedplay";

    /* renamed from: c */
    private static final String f5835c = "vclose";

    /* renamed from: d */
    private static final String f5836d = "vreadyplay";

    /* renamed from: e */
    private static final String f5837e = "vplayfail";

    /* renamed from: f */
    private static final String f5838f = "vmute";

    /* renamed from: g */
    private static final String f5839g = "vfrozen";

    /* renamed from: h */
    private static final String f5840h = "vshow";

    /* renamed from: i */
    private static final String f5841i = "curTimeSec";

    /* renamed from: j */
    private static final String f5842j = "startTimeSec";
    private static final String k = "autoPlay";
    private static final String l = "reasonValue";
    private final dd m;
    private final a n;
    private boolean o = false;
    private int p = 0;

    public o(dd ddVar, a aVar) {
        this.m = ddVar;
        this.n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject S;
        if (this.m == null || (aVar = this.n) == null || (S = aVar.S()) == null) {
            return;
        }
        try {
            S.put("msg", "sendVideoThirdLog");
            S.put("trackType", str);
            S.put("trackInfo", jSONObject);
            this.m.a(S);
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        a(f5837e, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        a(f5839g, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(f5836d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z) {
        a(f5838f, a(this.p, i2, this.o, z ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, NativeResponse.VideoReason videoReason) {
        a(f5835c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.p = 0;
        a(f5834b, a(0, 0, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        this.p = i2;
        a(f5833a, a(i2, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(f5840h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        this.p = 0;
        this.o = z;
        a(f5833a, a(0, 0, z, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, NativeResponse.VideoReason videoReason) {
        a(f5835c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    private JSONObject a(int i2, int i3, boolean z, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f5842j, i2 / 1000);
            jSONObject.put(f5841i, i3 / 1000);
            jSONObject.put(k, z);
            jSONObject.put(l, i4);
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
        }
        return jSONObject;
    }
}
