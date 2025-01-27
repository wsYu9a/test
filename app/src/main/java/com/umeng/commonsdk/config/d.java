package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static final long f26117a = 1000;

    /* renamed from: b */
    public static final String f26118b = "_LAST_FIELD";

    /* renamed from: c */
    public static final String f26119c = "3749699455";

    /* renamed from: d */
    public static final String f26120d = "2130669566";

    /* renamed from: e */
    public static final String f26121e = "262139";

    /* renamed from: f */
    public static final String f26122f = "1983";

    /* renamed from: g */
    public static final int f26123g = 64;
    private static Map<String, String[]> l = new HashMap();

    /* renamed from: h */
    public static String[] f26124h = new String[a.values().length];

    /* renamed from: i */
    public static String[] f26125i = new String[b.values().length];

    /* renamed from: j */
    public static String[] f26126j = new String[c.values().length];
    public static String[] k = new String[EnumC0541d.values().length];

    public enum a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        header_sub_os_info,
        _LAST_FIELD
    }

    public enum b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        inner_batt2,
        inner_build2,
        inner_cpu2,
        _LAST_FIELD
    }

    public enum c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* renamed from: com.umeng.commonsdk.config.d$d */
    public enum EnumC0541d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        String[] strArr = f26124h;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < a.values().length; i2++) {
                f26124h[i2] = a.values()[i2].toString();
            }
            Map<String, String[]> map = l;
            if (map != null) {
                map.put(a.class.getName(), f26124h);
            }
        }
        String[] strArr2 = f26125i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i3 = 0; i3 < b.values().length; i3++) {
                f26125i[i3] = b.values()[i3].toString();
            }
            Map<String, String[]> map2 = l;
            if (map2 != null) {
                map2.put(b.class.getName(), f26125i);
            }
        }
        String[] strArr3 = f26126j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i4 = 0; i4 < c.values().length; i4++) {
                f26126j[i4] = c.values()[i4].toString();
            }
            Map<String, String[]> map3 = l;
            if (map3 != null) {
                map3.put(c.class.getName(), f26126j);
            }
        }
        String[] strArr4 = k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i5 = 0; i5 < EnumC0541d.values().length; i5++) {
            k[i5] = EnumC0541d.values()[i5].toString();
        }
        Map<String, String[]> map4 = l;
        if (map4 != null) {
            map4.put(EnumC0541d.class.getName(), k);
        }
    }

    public static boolean a(String str) {
        return (str == null || str.length() <= 0 || f26118b.equalsIgnoreCase(str)) ? false : true;
    }

    public static String[] b(String str) {
        if (str == null || str.length() <= 0 || !l.containsKey(str)) {
            return null;
        }
        return l.get(str);
    }
}
