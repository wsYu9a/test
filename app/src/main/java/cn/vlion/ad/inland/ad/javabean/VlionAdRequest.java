package cn.vlion.ad.inland.ad.javabean;

import java.util.List;

/* loaded from: classes.dex */
public class VlionAdRequest {
    private AppBean app;
    private int at = 2;
    private DeviceBean device;
    private List<String> hitStrategys;

    /* renamed from: id, reason: collision with root package name */
    private String f2280id;
    private List<ImpBean> imp;
    private Sdkinfo sdkinfo;
    private int tmax;
    private UserBean user;

    public static class AppBean {
        private String bundle;

        /* renamed from: id, reason: collision with root package name */
        private String f2281id;
        private String name;
        private String storeurl;
        private String ver;
        private String version_code;
        private String version_name;

        public String getBundle() {
            return this.bundle;
        }

        public String getId() {
            return this.f2281id;
        }

        public String getName() {
            return this.name;
        }

        public String getStoreurl() {
            return this.storeurl;
        }

        public String getVer() {
            return this.ver;
        }

        public String getVersion_code() {
            return this.version_code;
        }

        public String getVersion_name() {
            return this.version_name;
        }

        public void setBundle(String str) {
            this.bundle = str;
        }

        public void setId(String str) {
            this.f2281id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStoreurl(String str) {
            this.storeurl = str;
        }

        public void setVer(String str) {
            this.ver = str;
        }

        public void setVersion_code(String str) {
            this.version_code = str;
        }

        public void setVersion_name(String str) {
            this.version_name = str;
        }
    }

    public static class DeviceBean {
        private String androidId;
        private String androidIdMd5;
        private int battery_status;
        private String boot_mark;
        private String carrierId;
        private int connectiontype;
        private float cpu_freq;
        private int devicetype;
        private String did;
        private String didmd5;
        private String gaid;
        private String gaidMd5;
        private GeoBean geo;

        /* renamed from: h, reason: collision with root package name */
        private int f2282h;
        private String imsi;
        private String ip;
        private String mac;
        private String mac_md5;
        private String make;
        private String model;
        private String oaId;
        private String oaIdMd5;
        private int orientation;
        private String os;
        private float osl;
        private String osv;
        private int ppi;
        private float pxratio;

        /* renamed from: ua, reason: collision with root package name */
        private String f2283ua;
        private String update_mark;

        /* renamed from: w, reason: collision with root package name */
        private int f2284w;
        private String density = "";
        private int dpi = 0;
        private String time_zone = "";
        private String sys_cmp_time = "";
        private String boot_time = "";
        private String update_time = "";
        private int cpu_num = 2;
        private String sys_disk_size = "";
        private String sys_memory = "";
        private String ssid = "";
        private String wifi_mac = "";
        private String hms_ver_code = "";
        private String hw_ag_ver_code = "";
        private String vaid = "";
        private String vivo_storever = "";
        private String oppo_storever = "";
        private String honor_storever = "";
        private String mi_storever = "";
        private String miui_version = "";
        private String sys_available_size = "";
        private int wxApiVer = 0;
        private String wxOpenAppid = "";
        private int wxOpenSdkVer = 0;
        private String wxOpenSdkVerS = "";
        private int wxInstalled = 0;
        private String region = "";
        private String lang = "";
        private int battery_level = 5;
        private String rom_version = "";
        private String device_name = "";
        private String device_name_md5 = "";
        private String mzuiVersion = "";
        private String viuiVersion = "";
        private String opuiVersion = "";
        private String huuiVersion = "";
        private String houiVersion = "";
        private String serialno = "";
        private String screensize = "";

        public static class GeoBean {
            private double lat;
            private double lon;

            public double getLat() {
                return this.lat;
            }

            public double getLon() {
                return this.lon;
            }

            public void setLat(double d10) {
                this.lat = d10;
            }

            public void setLon(double d10) {
                this.lon = d10;
            }
        }

        public String getAndroidId() {
            return this.androidId;
        }

        public String getAndroidIdMd5() {
            return this.androidIdMd5;
        }

        public int getBattery_level() {
            return this.battery_level;
        }

        public int getBattery_status() {
            return this.battery_status;
        }

        public String getBoot_mark() {
            return this.boot_mark;
        }

        public String getBoot_time() {
            return this.boot_time;
        }

        public String getCarrierId() {
            return this.carrierId;
        }

        public int getConnectiontype() {
            return this.connectiontype;
        }

        public String getCountry() {
            return this.region;
        }

        public float getCpu_freq() {
            return this.cpu_freq;
        }

        public int getCpu_num() {
            return this.cpu_num;
        }

        public String getDensity() {
            return this.density;
        }

        public String getDevice_name() {
            return this.device_name;
        }

        public String getDevice_name_md5() {
            return this.device_name_md5;
        }

        public int getDevicetype() {
            return this.devicetype;
        }

        public String getDid() {
            return this.did;
        }

        public String getDidmd5() {
            return this.didmd5;
        }

        public int getDpi() {
            return this.dpi;
        }

        public String getGaid() {
            return this.gaid;
        }

        public String getGaidMd5() {
            return this.gaidMd5;
        }

        public GeoBean getGeo() {
            return this.geo;
        }

        public int getH() {
            return this.f2282h;
        }

        public String getHms_ver_code() {
            return this.hms_ver_code;
        }

        public String getHonor_storever() {
            return this.honor_storever;
        }

        public String getHouiVersion() {
            return this.houiVersion;
        }

        public String getHuuiVersion() {
            return this.huuiVersion;
        }

        public String getHw_ag_ver_code() {
            return this.hw_ag_ver_code;
        }

        public String getImsi() {
            return this.imsi;
        }

        public String getIp() {
            return this.ip;
        }

        public String getLang() {
            return this.lang;
        }

        public String getMac() {
            return this.mac;
        }

        public String getMac_md5() {
            return this.mac_md5;
        }

        public String getMake() {
            return this.make;
        }

        public String getMi_storever() {
            return this.mi_storever;
        }

        public String getMiui_version() {
            return this.miui_version;
        }

        public String getModel() {
            return this.model;
        }

        public String getMzuiVersion() {
            return this.mzuiVersion;
        }

        public String getOaId() {
            return this.oaId;
        }

        public String getOaIdMd5() {
            return this.oaIdMd5;
        }

        public String getOppo_storever() {
            return this.oppo_storever;
        }

        public String getOpuiVersion() {
            return this.opuiVersion;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public String getOs() {
            return this.os;
        }

        public float getOsl() {
            return this.osl;
        }

        public String getOsv() {
            return this.osv;
        }

        public int getPpi() {
            return this.ppi;
        }

        public float getPxratio() {
            return this.pxratio;
        }

        public String getRegion() {
            return this.region;
        }

        public String getRom_version() {
            return this.rom_version;
        }

        public String getScreensize() {
            return this.screensize;
        }

        public String getSerialno() {
            return this.serialno;
        }

        public String getSsid() {
            return this.ssid;
        }

        public String getSys_available_size() {
            return this.sys_available_size;
        }

        public String getSys_cmp_time() {
            return this.sys_cmp_time;
        }

        public String getSys_disk_size() {
            return this.sys_disk_size;
        }

        public String getSys_memory() {
            return this.sys_memory;
        }

        public String getTime_zone() {
            return this.time_zone;
        }

        public String getUa() {
            return this.f2283ua;
        }

        public String getUpdate_mark() {
            return this.update_mark;
        }

        public String getUpdate_time() {
            return this.update_time;
        }

        public String getVaid() {
            return this.vaid;
        }

        public String getViuiVersion() {
            return this.viuiVersion;
        }

        public String getVivo_storever() {
            return this.vivo_storever;
        }

        public int getW() {
            return this.f2284w;
        }

        public String getWifi_mac() {
            return this.wifi_mac;
        }

        public int getWxApiVer() {
            return this.wxApiVer;
        }

        public int getWxInstalled() {
            return this.wxInstalled;
        }

        public String getWxOpenAppid() {
            return this.wxOpenAppid;
        }

        public int getWxOpenSdkVer() {
            return this.wxOpenSdkVer;
        }

        public String getWxOpenSdkVerS() {
            return this.wxOpenSdkVerS;
        }

        public void setAndroidId(String str) {
            this.androidId = str;
        }

        public void setAndroidIdMd5(String str) {
            this.androidIdMd5 = str;
        }

        public void setBattery_level(int i10) {
            this.battery_level = i10;
        }

        public void setBattery_status(int i10) {
            this.battery_status = i10;
        }

        public void setBoot_mark(String str) {
            this.boot_mark = str;
        }

        public void setBoot_time(String str) {
            this.boot_time = str;
        }

        public void setCarrierId(String str) {
            this.carrierId = str;
        }

        public void setConnectiontype(int i10) {
            this.connectiontype = i10;
        }

        public void setCpu_freq(float f10) {
            this.cpu_freq = f10;
        }

        public void setCpu_num(int i10) {
            this.cpu_num = i10;
        }

        public void setDensity(String str) {
            this.density = str;
        }

        public void setDevice_name(String str) {
            this.device_name = str;
        }

        public void setDevice_name_md5(String str) {
            this.device_name_md5 = str;
        }

        public void setDevicetype(int i10) {
            this.devicetype = i10;
        }

        public void setDid(String str) {
            this.did = str;
        }

        public void setDidmd5(String str) {
            this.didmd5 = str;
        }

        public void setDpi(int i10) {
            this.dpi = i10;
        }

        public void setGaid(String str) {
            this.gaid = str;
        }

        public void setGaidMd5(String str) {
            this.gaidMd5 = str;
        }

        public void setGeo(GeoBean geoBean) {
            this.geo = geoBean;
        }

        public void setH(int i10) {
            this.f2282h = i10;
        }

        public void setHms_ver_code(String str) {
            this.hms_ver_code = str;
        }

        public void setHonor_storever(String str) {
            this.honor_storever = str;
        }

        public void setHouiVersion(String str) {
            this.houiVersion = str;
        }

        public void setHuuiVersion(String str) {
            this.huuiVersion = str;
        }

        public void setHw_ag_ver_code(String str) {
            this.hw_ag_ver_code = str;
        }

        public void setImsi(String str) {
            this.imsi = str;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setLang(String str) {
            this.lang = str;
        }

        public void setMac(String str) {
            this.mac = str;
        }

        public void setMac_md5(String str) {
            this.mac_md5 = str;
        }

        public void setMake(String str) {
            this.make = str;
        }

        public void setMi_storever(String str) {
            this.mi_storever = str;
        }

        public void setMiui_version(String str) {
            this.miui_version = str;
        }

        public void setModel(String str) {
            this.model = str;
        }

        public void setMzuiVersion(String str) {
            this.mzuiVersion = str;
        }

        public void setOaId(String str) {
            this.oaId = str;
        }

        public void setOaIdMd5(String str) {
            this.oaIdMd5 = str;
        }

        public void setOppo_storever(String str) {
            this.oppo_storever = str;
        }

        public void setOpuiVersion(String str) {
            this.opuiVersion = str;
        }

        public void setOrientation(int i10) {
            this.orientation = i10;
        }

        public void setOs(String str) {
            this.os = str;
        }

        public void setOsl(float f10) {
            this.osl = f10;
        }

        public void setOsv(String str) {
            this.osv = str;
        }

        public void setPpi(int i10) {
            this.ppi = i10;
        }

        public void setPxratio(float f10) {
            this.pxratio = f10;
        }

        public void setRegion(String str) {
            this.region = str;
        }

        public void setRom_version(String str) {
            this.rom_version = str;
        }

        public void setScreensize(String str) {
            this.screensize = str;
        }

        public void setSerialno(String str) {
            this.serialno = str;
        }

        public void setSsid(String str) {
            this.ssid = str;
        }

        public void setSys_available_size(String str) {
            this.sys_available_size = str;
        }

        public void setSys_cmp_time(String str) {
            this.sys_cmp_time = str;
        }

        public void setSys_disk_size(String str) {
            this.sys_disk_size = str;
        }

        public void setSys_memory(String str) {
            this.sys_memory = str;
        }

        public void setTime_zone(String str) {
            this.time_zone = str;
        }

        public void setUa(String str) {
            this.f2283ua = str;
        }

        public void setUpdate_mark(String str) {
            this.update_mark = str;
        }

        public void setUpdate_time(String str) {
            this.update_time = str;
        }

        public void setVaid(String str) {
            this.vaid = str;
        }

        public void setViuiVersion(String str) {
            this.viuiVersion = str;
        }

        public void setVivo_storever(String str) {
            this.vivo_storever = str;
        }

        public void setW(int i10) {
            this.f2284w = i10;
        }

        public void setWifi_mac(String str) {
            this.wifi_mac = str;
        }

        public void setWxApiVer(int i10) {
            this.wxApiVer = i10;
        }

        public void setWxInstalled(int i10) {
            this.wxInstalled = i10;
        }

        public void setWxOpenAppid(String str) {
            this.wxOpenAppid = str;
        }

        public void setWxOpenSdkVer(int i10) {
            this.wxOpenSdkVer = i10;
        }

        public void setWxOpenSdkVerS(String str) {
            this.wxOpenSdkVerS = str;
        }
    }

    public static class ImpBean {
        private String adx_tagid;
        private int bidfloor;
        private int deepLink;
        private int height;

        /* renamed from: id, reason: collision with root package name */
        private String f2285id;
        private String impType;
        private int secure;
        private String tagid;
        private int width;

        public String getAdx_tagid() {
            return this.adx_tagid;
        }

        public int getBidfloor() {
            return this.bidfloor;
        }

        public int getDeepLink() {
            return this.deepLink;
        }

        public int getHeight() {
            return this.height;
        }

        public String getId() {
            return this.f2285id;
        }

        public String getImpType() {
            return this.impType;
        }

        public int getSecure() {
            return this.secure;
        }

        public String getTagid() {
            return this.tagid;
        }

        public int getWidth() {
            return this.width;
        }

        public void setAdx_tagid(String str) {
            this.adx_tagid = str;
        }

        public void setBidfloor(int i10) {
            this.bidfloor = i10;
        }

        public void setDeepLink(int i10) {
            this.deepLink = i10;
        }

        public void setHeight(int i10) {
            this.height = i10;
        }

        public void setId(String str) {
            this.f2285id = str;
        }

        public void setImpType(String str) {
            this.impType = str;
        }

        public void setSecure(int i10) {
            this.secure = i10;
        }

        public void setTagid(String str) {
            this.tagid = str;
        }

        public void setWidth(int i10) {
            this.width = i10;
        }
    }

    public static class Sdkinfo {
        private long cs_lstdate;
        private int cs_show;
        private String ctime;
        private String init_time;
        private String platform;
        private String sdkv;
        private String traceid;

        public long getCs_lstdate() {
            return this.cs_lstdate;
        }

        public int getCs_show() {
            return this.cs_show;
        }

        public String getCtime() {
            return this.ctime;
        }

        public String getInit_time() {
            return this.init_time;
        }

        public String getPlatform() {
            return this.platform;
        }

        public String getSdkv() {
            return this.sdkv;
        }

        public String getTraceid() {
            return this.traceid;
        }

        public void setCs_lstdate(long j10) {
            this.cs_lstdate = j10;
        }

        public void setCs_show(int i10) {
            this.cs_show = i10;
        }

        public void setCtime(String str) {
            this.ctime = str;
        }

        public void setInit_time(String str) {
            this.init_time = str;
        }

        public void setPlatform(String str) {
            this.platform = str;
        }

        public void setSdkv(String str) {
            this.sdkv = str;
        }

        public void setTraceid(String str) {
            this.traceid = str;
        }
    }

    public static class UserBean {
        private String age;
        private String consume_level;

        /* renamed from: id, reason: collision with root package name */
        private String f2286id;

        public String getAge() {
            return this.age;
        }

        public String getConsume_level() {
            return this.consume_level;
        }

        public String getId() {
            return this.f2286id;
        }

        public void setAge(String str) {
            this.age = str;
        }

        public void setConsume_level(String str) {
            this.consume_level = str;
        }

        public void setId(String str) {
            this.f2286id = str;
        }
    }

    public AppBean getApp() {
        return this.app;
    }

    public int getAt() {
        return this.at;
    }

    public DeviceBean getDevice() {
        return this.device;
    }

    public List<String> getHitStrategys() {
        return this.hitStrategys;
    }

    public String getId() {
        return this.f2280id;
    }

    public List<ImpBean> getImp() {
        return this.imp;
    }

    public Sdkinfo getSdkinfoBean() {
        return this.sdkinfo;
    }

    public int getTmax() {
        return this.tmax;
    }

    public UserBean getUser() {
        return this.user;
    }

    public void setApp(AppBean appBean) {
        this.app = appBean;
    }

    public void setAt(int i10) {
        this.at = i10;
    }

    public void setDevice(DeviceBean deviceBean) {
        this.device = deviceBean;
    }

    public void setHitStrategys(List<String> list) {
        this.hitStrategys = list;
    }

    public void setId(String str) {
        this.f2280id = str;
    }

    public void setImp(List<ImpBean> list) {
        this.imp = list;
    }

    public void setSdkinfo(Sdkinfo sdkinfo) {
        this.sdkinfo = sdkinfo;
    }

    public void setTmax(int i10) {
        this.tmax = i10;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }
}
