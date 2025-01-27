package com.shu.priory.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import com.shu.priory.bean.AdAudio;
import com.shu.priory.bean.AdImage;
import com.shu.priory.bean.AudioMonitor;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.download.DialogListener;
import com.shu.priory.param.AdParam;
import com.shu.priory.utils.h;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;
import l5.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends NativeDataRef {

    /* renamed from: a */
    private final SensorManager f17035a;

    /* renamed from: b */
    private volatile SensorEventListener f17036b;

    /* renamed from: com.shu.priory.e.b$1 */
    public class AnonymousClass1 implements SensorEventListener {

        /* renamed from: a */
        final /* synthetic */ int f17037a;

        public AnonymousClass1(int i10) {
            optInt = i10;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            float[] fArr = sensorEvent.values;
            if (type == 1) {
                if (Math.abs(fArr[0]) > optInt || Math.abs(fArr[1]) > optInt || Math.abs(fArr[2]) > optInt) {
                    b.this.a();
                }
            }
        }
    }

    public b(Context context, com.shu.priory.g.b bVar, AdParam adParam, DialogListener dialogListener) {
        super(context, bVar, adParam, dialogListener);
        this.f17035a = (SensorManager) this.mContext.getSystemService(bt.f23586ac);
    }

    public void a() {
        if (this.mParams.getBooleanParam(AdKeys.IS_SHAKING_ALLOWED)) {
            h.a(SDKConstants.TAG, "shaking");
            onClick(null, 2, Float.valueOf(-999.0f), Float.valueOf(-999.0f), Float.valueOf(-999.0f), Float.valueOf(-999.0f));
        }
        if (this.f17035a == null || this.f17036b == null) {
            return;
        }
        this.f17035a.unregisterListener(this.f17036b);
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public AdAudio getAdAudio() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || aVar.f17084k == null) {
            return null;
        }
        AdAudio adAudio = new AdAudio();
        adAudio.setUrl(this.mAdData.f17084k.optString("url"));
        if (this.mAdData.f17084k.has("duration")) {
            adAudio.setDuration(this.mAdData.f17084k.optInt("duration"));
        }
        if (this.mAdData.f17084k.has("bitrate")) {
            adAudio.setBitrate(this.mAdData.f17084k.optInt("bitrate"));
        }
        if (this.mAdData.f17084k.has("format")) {
            adAudio.setFormat(this.mAdData.f17084k.optInt("format"));
        }
        if (this.mAdData.f17084k.has(f.f23909q)) {
            adAudio.setCacheDeadLine(this.mAdData.f17084k.optLong(f.f23909q));
        }
        return adAudio;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public List<AdImage> getAdImgList() {
        if (this.mAdData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mAdData.f17080g != null) {
            AdImage adImage = new AdImage();
            adImage.setUrl(this.mAdData.f17080g.optString("url"));
            adImage.setWidth(this.mAdData.f17080g.optInt("width"));
            adImage.setHeight(this.mAdData.f17080g.optInt("height"));
            arrayList.add(adImage);
        }
        if (this.mAdData.f17081h != null) {
            AdImage adImage2 = new AdImage();
            adImage2.setUrl(this.mAdData.f17081h.optString("url"));
            adImage2.setWidth(this.mAdData.f17081h.optInt("width"));
            adImage2.setHeight(this.mAdData.f17081h.optInt("height"));
            arrayList.add(adImage2);
        }
        if (this.mAdData.f17082i != null) {
            AdImage adImage3 = new AdImage();
            adImage3.setUrl(this.mAdData.f17082i.optString("url"));
            adImage3.setWidth(this.mAdData.f17082i.optInt("width"));
            adImage3.setHeight(this.mAdData.f17082i.optInt("height"));
            arrayList.add(adImage3);
        }
        return arrayList;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getAddress() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.C;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getAppName() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17090q;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public double getAppSize() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? c.f27899e : aVar.f17096w;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getAppVer() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17095v;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public AudioMonitor getAudioMonitor() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null || aVar.f17084k == null || aVar.J == null) {
            return null;
        }
        AudioMonitor audioMonitor = new AudioMonitor();
        audioMonitor.setStartUrls(this.mAdData.J.optJSONArray("start_urls"));
        audioMonitor.setFirstQuartileUrls(this.mAdData.J.optJSONArray("first_quartile_urls"));
        audioMonitor.setMidPointUrls(this.mAdData.J.optJSONArray("mid_point_urls"));
        audioMonitor.setThirdQuartileUrls(this.mAdData.J.optJSONArray("third_quartile_urls"));
        audioMonitor.setCompleteUrls(this.mAdData.J.optJSONArray("complete_urls"));
        audioMonitor.setPauseUrls(this.mAdData.J.optJSONArray("pause_urls"));
        audioMonitor.setResumeUrls(this.mAdData.J.optJSONArray("resume_urls"));
        audioMonitor.setSkipUrls(this.mAdData.J.optJSONArray("skip_urls"));
        audioMonitor.setMuteUrls(this.mAdData.J.optJSONArray("mute_urls"));
        audioMonitor.setUnmuteUrls(this.mAdData.J.optJSONArray("unmute_urls"));
        audioMonitor.setReplayUrls(this.mAdData.J.optJSONArray("replay_urls"));
        audioMonitor.setCloseUrls(this.mAdData.J.optJSONArray("close_linear_urls"));
        return audioMonitor;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public double getCurrentPrice() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? c.f27899e : aVar.A;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public ArrayList<String> getDisplayLabels() {
        com.shu.priory.g.a aVar = this.mAdData;
        ArrayList<String> arrayList = null;
        if (aVar == null) {
            return null;
        }
        JSONArray jSONArray = aVar.G;
        if (jSONArray != null) {
            arrayList = new ArrayList<>();
            int i10 = 0;
            while (i10 < jSONArray.length()) {
                int i11 = i10 + 1;
                try {
                    arrayList.add(jSONArray.getString(i10));
                } catch (JSONException e10) {
                    h.d(SDKConstants.TAG, "get labels" + e10.getMessage());
                }
                i10 = i11;
            }
        }
        return arrayList;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public int getDownloads() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null) {
            return 0;
        }
        return aVar.f17091r;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public List<String> getImgList() {
        if (this.mAdData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.mAdData.f17080g;
        if (jSONObject != null && jSONObject.has("url")) {
            arrayList.add(this.mAdData.f17080g.optString("url"));
        }
        JSONObject jSONObject2 = this.mAdData.f17081h;
        if (jSONObject2 != null && jSONObject2.has("url")) {
            arrayList.add(this.mAdData.f17081h.optString("url"));
        }
        JSONObject jSONObject3 = this.mAdData.f17082i;
        if (jSONObject3 != null && jSONObject3.has("url")) {
            arrayList.add(this.mAdData.f17082i.optString("url"));
        }
        return arrayList;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public int getLikes() {
        com.shu.priory.g.a aVar = this.mAdData;
        if (aVar == null) {
            return 0;
        }
        return aVar.f17098y;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public double getOriginalPrice() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? c.f27899e : aVar.f17099z;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getPhone() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17097x;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getRating() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.f17092s;
    }

    @Override // com.shu.priory.conn.NativeDataRef
    public String getSponsored() {
        com.shu.priory.g.a aVar = this.mAdData;
        return aVar == null ? "" : aVar.B;
    }

    @Override // com.shu.priory.b.c
    public boolean onExposure(View view) {
        com.shu.priory.g.a aVar;
        int i10;
        if (!this.mParams.getBooleanParam(AdKeys.LOCK_SCREEN_AD) && com.shu.priory.utils.b.b(this.mContext)) {
            h.a(SDKConstants.TAG, "曝光失败-L");
            return false;
        }
        boolean onExposure = super.onExposure(view);
        if (this.mParams.getBooleanParam(AdKeys.IS_SHAKING_ALLOWED) && onExposure && ((i10 = (aVar = this.mAdData).Q) == 2 || i10 == 4)) {
            a(aVar.S);
        }
        if (onExposure && !this.mRespData.c()) {
            com.shu.priory.utils.c.a(this.mContext).a(this.mRespData.f17102c);
        }
        return onExposure;
    }

    private void a(JSONObject jSONObject) {
        if (this.f17035a == null) {
            h.c(SDKConstants.TAG, "sensor manager is null! ");
        } else {
            this.f17036b = new SensorEventListener() { // from class: com.shu.priory.e.b.1

                /* renamed from: a */
                final /* synthetic */ int f17037a;

                public AnonymousClass1(int i10) {
                    optInt = i10;
                }

                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i10) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    int type = sensorEvent.sensor.getType();
                    float[] fArr = sensorEvent.values;
                    if (type == 1) {
                        if (Math.abs(fArr[0]) > optInt || Math.abs(fArr[1]) > optInt || Math.abs(fArr[2]) > optInt) {
                            b.this.a();
                        }
                    }
                }
            };
            this.f17035a.registerListener(this.f17036b, this.f17035a.getDefaultSensor(1), 3);
        }
    }
}
