package com.sigmob.sdk.mraid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.mraid.j;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class o extends j implements j.a, com.sigmob.sdk.videocache.d {

    /* renamed from: f */
    public static final int f19646f = 0;

    /* renamed from: g */
    public static final int f19647g = 1;

    /* renamed from: h */
    public static final int f19648h = 2;

    /* renamed from: i */
    public static final int f19649i = 3;

    /* renamed from: j */
    public static final int f19650j = 4;

    /* renamed from: k */
    public static final int f19651k = 0;

    /* renamed from: l */
    public static final int f19652l = 1;

    /* renamed from: m */
    public static final int f19653m = 2;

    /* renamed from: n */
    public static final int f19654n = 4;

    /* renamed from: o */
    public static final int f19655o = 8;

    /* renamed from: c */
    public m f19656c;

    /* renamed from: d */
    public String f19657d;

    /* renamed from: e */
    public c f19658e;

    public class a implements com.sigmob.sdk.videoplayer.l {
        public a() {
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(long j10, long j11) {
            if (o.this.f19658e != null) {
                o.this.f19658e.a(o.this.f19592a, j10, j11);
            }
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(com.sigmob.sdk.videoplayer.e eVar) {
            c cVar;
            String str;
            SigmobLog.d("VIDEO_PLAYER_STATE change: " + eVar);
            int i10 = 4;
            switch (b.f19660a[eVar.ordinal()]) {
                case 1:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.a(o.this.f19592a, o.this.f19656c.getDuration(), o.this.f19656c.getVideoWidth(), o.this.f19656c.getVideoHeight());
                    }
                    if (o.this.f19658e != null) {
                        o.this.f19658e.b(o.this.f19592a, 2);
                    }
                    if (o.this.f19658e != null) {
                        cVar = o.this.f19658e;
                        str = o.this.f19592a;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.a(o.this.f19592a, o.this.f19656c.getErrorCode(), o.this.f19656c.getErrorMessage());
                        return;
                    }
                    return;
                case 3:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.a(o.this.f19592a, 2);
                        return;
                    }
                    return;
                case 4:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.a(o.this.f19592a, 1);
                        return;
                    }
                    return;
                case 5:
                    if (o.this.f19658e != null) {
                        c cVar2 = o.this.f19658e;
                        o oVar = o.this;
                        cVar2.a(oVar.f19592a, oVar.f19656c.getDuration(), o.this.f19656c.getDuration());
                        c cVar3 = o.this.f19658e;
                        o oVar2 = o.this;
                        cVar3.a(oVar2.f19592a, oVar2.f19656c.getDuration());
                        return;
                    }
                    return;
                case 6:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.b(o.this.f19592a, 1);
                        return;
                    }
                    return;
                case 7:
                    if (o.this.f19658e != null) {
                        o.this.f19656c.g();
                        cVar = o.this.f19658e;
                        str = o.this.f19592a;
                        i10 = 8;
                        break;
                    } else {
                        return;
                    }
                case 8:
                    if (o.this.f19658e != null) {
                        o.this.f19656c.h();
                        o.this.f19658e.b(o.this.f19592a, 2);
                        return;
                    }
                    return;
                case 9:
                    if (o.this.f19658e != null) {
                        o.this.f19658e.a(o.this.f19592a, 4);
                        return;
                    }
                    return;
                default:
                    return;
            }
            cVar.b(str, i10);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19660a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.e.values().length];
            f19660a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_PREPARING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19660a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public interface c {
        void a(String str, int i10);

        void a(String str, int i10, String str2);

        void a(String str, long j10);

        void a(String str, long j10, int i10, int i11);

        void a(String str, long j10, long j11);

        void b(String str, int i10);
    }

    public o(String str) {
        super(str);
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i10) {
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void b(JSONObject jSONObject) {
        m mVar = this.f19656c;
        if (mVar != null) {
            mVar.s();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void c(JSONObject jSONObject) {
        if (this.f19656c != null) {
            this.f19656c.setMute(jSONObject.optBoolean("muted", false));
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void d(JSONObject jSONObject) {
        if (this.f19656c != null) {
            String optString = jSONObject.optString("URL");
            if (jSONObject.optBoolean("proxy", false) && !TextUtils.isEmpty(optString) && optString.startsWith("http")) {
                Uri parse = Uri.parse(optString);
                if (parse != null && !com.sigmob.sdk.videocache.h.f20606j.equalsIgnoreCase(parse.getHost())) {
                    optString = com.sigmob.sdk.base.common.h.n().d(optString);
                }
                a(this.f19592a, optString);
            }
            this.f19656c.setUp(optString);
            this.f19656c.p();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void e(JSONObject jSONObject) {
        if (this.f19656c != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TypedValues.AttributesType.S_FRAME);
            int optDouble = (int) optJSONObject.optDouble("x", l5.c.f27899e);
            int optDouble2 = (int) optJSONObject.optDouble("y", l5.c.f27899e);
            int optDouble3 = (int) optJSONObject.optDouble(IAdInterListener.AdReqParam.WIDTH, -1.0d);
            int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
            if (optDouble3 > 0) {
                optDouble3 = Dips.dipsToIntPixels(optDouble3, com.sigmob.sdk.a.d());
            }
            if (optDouble4 > 0) {
                optDouble4 = Dips.dipsToIntPixels(optDouble4, com.sigmob.sdk.a.d());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
            this.f19656c.setX(Dips.dipsToIntPixels(optDouble, com.sigmob.sdk.a.d()));
            this.f19656c.setY(Dips.dipsToIntPixels(optDouble2, com.sigmob.sdk.a.d()));
            this.f19656c.setLayoutParams(layoutParams);
            this.f19656c.requestLayout();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void f(JSONObject jSONObject) {
        if (this.f19656c != null) {
            this.f19656c.a(((int) jSONObject.optDouble("seekTime", l5.c.f27899e)) * 1000);
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void g(JSONObject jSONObject) {
        m mVar = this.f19656c;
        if (mVar != null) {
            mVar.g();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void h(JSONObject jSONObject) {
        m mVar = this.f19656c;
        if (mVar != null) {
            mVar.a(0);
            this.f19656c.h();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(Context context, JSONObject jSONObject) {
        m mVar = new m(context);
        this.f19656c = mVar;
        mVar.setVideoPlayerStatusListener(new a());
    }

    @Override // com.sigmob.sdk.mraid.j
    public View c() {
        return this.f19656c;
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(JSONObject jSONObject) {
        m mVar = this.f19656c;
        if (mVar != null) {
            mVar.h();
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public void a() {
        m mVar = this.f19656c;
        if (mVar != null) {
            com.sigmob.sdk.base.utils.e.e(mVar);
            this.f19656c.removeAllViews();
            this.f19656c.f();
            this.f19656c = null;
        }
        if (this.f19657d != null) {
            com.sigmob.sdk.base.common.h.n().b(this, this.f19657d);
        }
    }

    public final void a(String str, String str2) {
        Uri parse = Uri.parse(str2);
        if (parse == null || !com.sigmob.sdk.videocache.h.f20606j.equalsIgnoreCase(parse.getHost())) {
            return;
        }
        Matcher matcher = Pattern.compile("/(.*)").matcher(parse.getPath());
        if (matcher.find()) {
            this.f19657d = matcher.group(1);
            com.sigmob.sdk.base.common.h.n().a(this, this.f19657d);
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th2) {
        SigmobLog.e("url", th2);
        c cVar = this.f19658e;
        if (cVar != null) {
            cVar.a(this.f19592a, 0, th2.getMessage());
        }
    }

    public void a(c cVar) {
        this.f19658e = cVar;
    }
}
