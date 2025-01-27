package com.alimm.tanx.ui.request;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.List;

/* loaded from: classes.dex */
public class NewAdRequestBean extends BaseBean {
    public AdAppBean app;
    public AdContentBean content;
    public AdDeviceBean device;
    public boolean https_required;

    /* renamed from: id */
    public String f6335id;
    public List<AdImpBean> imp;
    public int render_type;
    public int version;

    public static class AdAppBean extends BaseBean {
        public String app_name;
        public String app_version;
        public String package_name;
        public String sdk_version;
    }

    public static class AdContentBean extends BaseBean {
        public List<String> category;
        public List<String> keywords;
        public List<String> query_term;
        public List<String> suggestion;
        public String title;
    }

    public static class AdDeviceBean extends BaseBean {
        public String ali_aaid;
        public String android_id;
        public String brand;
        public String clientId;
        public int device_type;
        public AdGeoBean geo;
        public String guid;
        public int height;
        public String imei;
        public List<String> installed_app;
        public String model;
        public int network;
        public String oaid;
        public int operator;
        public int orientation;
        public String os;
        public String osv;
        public int pixel_ratio;
        public String pseudoId;
        public String user_agent;
        public String widevineId;
        public int width;
    }

    public static class AdGeoBean extends BaseBean {
        public double lat;
        public double lon;
    }

    public static class AdImpBean extends BaseBean {

        /* renamed from: id */
        public String f6336id;
        public String[] native_template_id;
        public String pid;
        public int pos;
        public int slot_num;
    }
}
