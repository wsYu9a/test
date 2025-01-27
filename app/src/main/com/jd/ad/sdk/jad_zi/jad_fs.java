package com.jd.ad.sdk.jad_zi;

import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_xk.jad_iv;
import com.jd.ad.sdk.mdt.service.JADEventService;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_fs implements JADEventService {
    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, i20, i21, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExceptionEvent(@NonNull String str, int i10, @NonNull String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, i10, str2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, i15, i16, i17, i18, JsonUtils.parse2JSONObject(str3), i19, i20, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, i20, i21, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, i15, i16, i17, i18, JsonUtils.parse2JSONObject(str3), i19, i20, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 1, j11, i14, i15, i16, i17, i18, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 0, 0L, i14, i15, i16, i17, i18, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderFailedEvent(@NonNull String str, int i10, @NonNull String str2, int i11) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 10, i10, str2, i11);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 1, j11, i14, i15, i16, i17, i18, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRequestErrorEvent(@NonNull String str, int i10, @NonNull String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 7, i10, str2, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 0, 0L, i14, i15, i16, i17, i18, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoEvent(String str, String str2, int i10, int i11, int i12, int i13, long j10, long j11, long j12, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, double d10) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "pfid", 1);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(CommonConstants.ClickFrom.VIDEO.ordinal()));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "dety", 10);
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j10));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j11));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j12));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i14));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i15));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i16));
        JsonUtils.put(jSONObject, "atst", Integer.valueOf(i17));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i18));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i19));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i20));
        JsonUtils.put(jSONObject, "ipl", 0);
        JsonUtils.put(jSONObject, "vpst", Integer.valueOf(i21));
        JsonUtils.put(jSONObject, "vpdt", Double.valueOf(d10));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoExceptionEvent(@NonNull String str, int i10, @NonNull String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 11, i10, str2, 0);
    }
}
