package cn.vlion.ad.inland.ad.javabean;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VlionCustomAdData implements Serializable {
    private String bidid;
    private int code;

    /* renamed from: id */
    private String f2287id;
    private List<SeatbidBean> seatbid;

    public static class SeatbidBean implements Serializable {
        private List<List<BidBean>> bid;

        public static class BidBean implements Serializable {
            private AppInfoBean app_info;
            private String brand_logo;
            private String brand_name;
            private String btn_name;
            private List<String> clicktrackers;
            private List<ConvTrackingBean> conv_tracking;
            private String crid;
            private String deeplink;
            private String desc;
            private List<String> dp_tracking;
            private String dspid;
            private HeadInfoBean head_info;
            private List<ImageBean> image;
            private String impid;
            private List<String> imptrackers;
            private int is_download;
            private String ldp;
            private String marketurl;

            /* renamed from: mc */
            private McBean f2288mc;
            private String pkgname;
            private int price;
            private String templateid;
            private String title;
            private VideoBean video;
            private int wake_type = 0;
            private String wake_id = "";
            private String wake_path = "";

            public static class AppInfoBean implements Serializable {
                private String app_desc;
                private String app_desc_url;
                private AppLogoBean app_logo;
                private String app_name;
                private String app_permissions_link;
                private String developer_name;
                private int download_url_expires;
                private String md5;
                private String pkgname;
                private String privacy_policy;
                private int size;
                private String version_code;

                public static class AppLogoBean implements Serializable {
                    private int height;
                    private String url;
                    private int width;

                    public int getHeight() {
                        return this.height;
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setHeight(int i10) {
                        this.height = i10;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public void setWidth(int i10) {
                        this.width = i10;
                    }
                }

                public String getApp_desc() {
                    return this.app_desc;
                }

                public String getApp_desc_url() {
                    return this.app_desc_url;
                }

                public AppLogoBean getApp_logo() {
                    return this.app_logo;
                }

                public String getApp_name() {
                    return this.app_name;
                }

                public String getApp_permissions_link() {
                    return this.app_permissions_link;
                }

                public String getDeveloper_name() {
                    return this.developer_name;
                }

                public int getDownload_url_expires() {
                    return this.download_url_expires;
                }

                public String getMd5() {
                    return this.md5;
                }

                public String getPkgname() {
                    return this.pkgname;
                }

                public String getPrivacy_policy() {
                    return this.privacy_policy;
                }

                public int getSize() {
                    return this.size;
                }

                public String getVersion_code() {
                    return this.version_code;
                }

                public void setApp_desc(String str) {
                    this.app_desc = str;
                }

                public void setApp_desc_url(String str) {
                    this.app_desc_url = str;
                }

                public void setApp_logo(AppLogoBean appLogoBean) {
                    this.app_logo = appLogoBean;
                }

                public void setApp_name(String str) {
                    this.app_name = str;
                }

                public void setApp_permissions_link(String str) {
                    this.app_permissions_link = str;
                }

                public void setDeveloper_name(String str) {
                    this.developer_name = str;
                }

                public void setDownload_url_expires(int i10) {
                    this.download_url_expires = i10;
                }

                public void setMd5(String str) {
                    this.md5 = str;
                }

                public void setPkgname(String str) {
                    this.pkgname = str;
                }

                public void setPrivacy_policy(String str) {
                    this.privacy_policy = str;
                }

                public void setSize(int i10) {
                    this.size = i10;
                }

                public void setVersion_code(String str) {
                    this.version_code = str;
                }
            }

            public static class ConvTrackingBean implements Serializable {
                private int track_type;
                private String url;

                public int getTrack_type() {
                    return this.track_type;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setTrack_type(int i10) {
                    this.track_type = i10;
                }

                public void setUrl(String str) {
                    this.url = str;
                }
            }

            public static class HeadInfoBean implements Serializable {
                private List<Headerbean> click;
                private List<Headerbean> conv;
                private List<Headerbean> download_ldp;
                private List<Headerbean> download_url;
                private List<Headerbean> imp;
                private List<Headerbean> ldp;

                public static class Headerbean implements Serializable {
                    private String key;
                    private String value;

                    public String getKey() {
                        return this.key;
                    }

                    public String getValue() {
                        return this.value;
                    }

                    public void setKey(String str) {
                        this.key = str;
                    }

                    public void setValue(String str) {
                        this.value = str;
                    }
                }

                public List<Headerbean> getClick() {
                    return this.click;
                }

                public List<Headerbean> getConv() {
                    return this.conv;
                }

                public List<Headerbean> getDownload_ldp() {
                    return this.download_ldp;
                }

                public List<Headerbean> getDownload_url() {
                    return this.download_url;
                }

                public List<Headerbean> getImp() {
                    return this.imp;
                }

                public List<Headerbean> getLdp() {
                    return this.ldp;
                }

                public void setClick(List<Headerbean> list) {
                    this.click = list;
                }

                public void setConv(List<Headerbean> list) {
                    this.conv = list;
                }

                public void setDownload_ldp(List<Headerbean> list) {
                    this.download_ldp = list;
                }

                public void setDownload_url(List<Headerbean> list) {
                    this.download_url = list;
                }

                public void setImp(List<Headerbean> list) {
                    this.imp = list;
                }

                public void setLdp(List<Headerbean> list) {
                    this.ldp = list;
                }
            }

            public static class ImageBean implements Serializable {
                private int height;
                private String url;
                private int width;

                public int getHeight() {
                    return this.height;
                }

                public String getUrl() {
                    return this.url;
                }

                public int getWidth() {
                    return this.width;
                }

                public void setHeight(int i10) {
                    this.height = i10;
                }

                public void setUrl(String str) {
                    this.url = str;
                }

                public void setWidth(int i10) {
                    this.width = i10;
                }
            }

            public static class McBean implements Serializable {
                private List<CsFBean> cs;
                private String mDefaultVal = "";
                private List<macroValues> macroValues;

                public static class CsBean implements Serializable {
                    private int acc;
                    private int ang;
                    private int atype;
                    private int csi;

                    /* renamed from: dc */
                    private int f2290dc;
                    private float dui;

                    /* renamed from: h */
                    private int f2291h;

                    /* renamed from: w */
                    private int f2292w;

                    /* renamed from: d */
                    private boolean f2289d = true;
                    private boolean round_d = true;

                    public int getAcc() {
                        return this.acc;
                    }

                    public int getAng() {
                        return this.ang;
                    }

                    public int getAtype() {
                        return this.atype;
                    }

                    public int getCsi() {
                        return this.csi;
                    }

                    public int getDc() {
                        return this.f2290dc;
                    }

                    public float getDui() {
                        return this.dui;
                    }

                    public int getH() {
                        return this.f2291h;
                    }

                    public String getTriggerParam() {
                        try {
                            return isD() + "," + getDc() + "," + getCsi();
                        } catch (Throwable unused) {
                            return "";
                        }
                    }

                    public int getW() {
                        return this.f2292w;
                    }

                    public boolean isD() {
                        return this.f2289d;
                    }

                    public boolean isRound_d() {
                        return this.round_d;
                    }

                    public void setAcc(int i10) {
                        this.acc = i10;
                    }

                    public void setAng(int i10) {
                        this.ang = i10;
                    }

                    public void setAtype(int i10) {
                        this.atype = i10;
                    }

                    public void setCsi(int i10) {
                        this.csi = i10;
                    }

                    public void setD(boolean z10) {
                        this.f2289d = z10;
                    }

                    public void setDc(int i10) {
                        this.f2290dc = i10;
                    }

                    public void setDui(float f10) {
                        this.dui = f10;
                    }

                    public void setH(int i10) {
                        this.f2291h = i10;
                    }

                    public void setRound_d(boolean z10) {
                        this.round_d = z10;
                    }

                    public void setW(int i10) {
                        this.f2292w = i10;
                    }
                }

                public static class CsFBean implements Serializable {
                    private int csi;

                    /* renamed from: dc */
                    private int f2294dc;

                    /* renamed from: s */
                    private String f2295s = "";

                    /* renamed from: d */
                    private boolean f2293d = true;

                    public int getCsi() {
                        return this.csi;
                    }

                    public int getDc() {
                        return this.f2294dc;
                    }

                    public CsBean getS() {
                        try {
                            CsBean csBean = (CsBean) new Gson().fromJson(this.f2295s, CsBean.class);
                            csBean.setD(isD());
                            csBean.setDc(getDc());
                            csBean.setCsi(getCsi());
                            return csBean;
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                            return null;
                        }
                    }

                    public boolean isD() {
                        return this.f2293d;
                    }

                    public void setCsi(int i10) {
                        this.csi = i10;
                    }

                    public void setD(boolean z10) {
                        this.f2293d = z10;
                    }

                    public void setDc(int i10) {
                        this.f2294dc = i10;
                    }

                    public void setS(String str) {
                        this.f2295s = str;
                    }
                }

                public static class macroValues implements Serializable {

                    /* renamed from: m */
                    private String f2296m = "";

                    /* renamed from: v */
                    private String f2297v = "";

                    public String getM() {
                        return this.f2296m;
                    }

                    public String getV() {
                        return this.f2297v;
                    }

                    public void setM(String str) {
                        this.f2296m = str;
                    }

                    public void setV(String str) {
                        this.f2297v = str;
                    }
                }

                public List<CsFBean> getCs() {
                    return this.cs;
                }

                public List<macroValues> getMacroValues() {
                    return this.macroValues;
                }

                public String getmDefaultVal() {
                    return this.mDefaultVal;
                }

                public void setCs(List<CsFBean> list) {
                    this.cs = list;
                }

                public void setMacroValues(List<macroValues> list) {
                    this.macroValues = list;
                }

                public void setmDefaultVal(String str) {
                    this.mDefaultVal = str;
                }
            }

            public static class VideoBean implements Serializable {
                private int duration;

                /* renamed from: vh */
                private int f2298vh;
                private List<String> vm_p_start;
                private List<String> vm_p_succ;
                private List<VmPTrackingBean> vm_p_tracking;
                private String vsize;
                private String vurl;
                private int vw;

                public static class VmPTrackingBean implements Serializable {
                    private List<String> list;
                    private int play_sec;

                    public List<String> getList() {
                        return this.list;
                    }

                    public int getPlay_sec() {
                        return this.play_sec;
                    }

                    public void setList(List<String> list) {
                        this.list = list;
                    }

                    public void setPlay_sec(int i10) {
                        this.play_sec = i10;
                    }
                }

                public int getDuration() {
                    return this.duration;
                }

                public int getVh() {
                    return this.f2298vh;
                }

                public List<String> getVm_p_start() {
                    return this.vm_p_start;
                }

                public List<String> getVm_p_succ() {
                    return this.vm_p_succ;
                }

                public List<VmPTrackingBean> getVm_p_tracking() {
                    return this.vm_p_tracking;
                }

                public String getVsize() {
                    return this.vsize;
                }

                public String getVurl() {
                    return this.vurl;
                }

                public int getVw() {
                    return this.vw;
                }

                public void setDuration(int i10) {
                    this.duration = i10;
                }

                public void setVh(int i10) {
                    this.f2298vh = i10;
                }

                public void setVm_p_start(List<String> list) {
                    this.vm_p_start = list;
                }

                public void setVm_p_succ(List<String> list) {
                    this.vm_p_succ = list;
                }

                public void setVm_p_tracking(List<VmPTrackingBean> list) {
                    this.vm_p_tracking = list;
                }

                public void setVsize(String str) {
                    this.vsize = str;
                }

                public void setVurl(String str) {
                    this.vurl = str;
                }

                public void setVw(int i10) {
                    this.vw = i10;
                }
            }

            public AppInfoBean getApp_info() {
                return this.app_info;
            }

            public String getBrand_logo() {
                return this.brand_logo;
            }

            public String getBrand_name() {
                return this.brand_name;
            }

            public String getBtn_name() {
                return this.btn_name;
            }

            public List<String> getClicktrackers() {
                return this.clicktrackers;
            }

            public List<ConvTrackingBean> getConv_tracking() {
                return this.conv_tracking;
            }

            public String getCrid() {
                return this.crid;
            }

            public String getDeeplink() {
                return this.deeplink;
            }

            public String getDesc() {
                return this.desc;
            }

            public List<String> getDp_tracking() {
                return this.dp_tracking;
            }

            public String getDspid() {
                return this.dspid;
            }

            public HeadInfoBean getHead_info() {
                return this.head_info;
            }

            public List<ImageBean> getImage() {
                return this.image;
            }

            public String getImpid() {
                return this.impid;
            }

            public List<String> getImptrackers() {
                return this.imptrackers;
            }

            public int getIs_download() {
                return this.is_download;
            }

            public String getLdp() {
                return this.ldp;
            }

            public String getMarketurl() {
                return this.marketurl;
            }

            public McBean getMc() {
                return this.f2288mc;
            }

            public String getPkgname() {
                return this.pkgname;
            }

            public int getPrice() {
                return this.price;
            }

            public String getTemplateid() {
                return this.templateid;
            }

            public String getTitle() {
                return this.title;
            }

            public VideoBean getVideo() {
                return this.video;
            }

            public String getWake_id() {
                return this.wake_id;
            }

            public String getWake_path() {
                return this.wake_path;
            }

            public int getWake_type() {
                return this.wake_type;
            }

            public void setApp_info(AppInfoBean appInfoBean) {
                this.app_info = appInfoBean;
            }

            public void setBrand_logo(String str) {
                this.brand_logo = str;
            }

            public void setBrand_name(String str) {
                this.brand_name = str;
            }

            public void setBtn_name(String str) {
                this.btn_name = str;
            }

            public void setClicktrackers(List<String> list) {
                this.clicktrackers = list;
            }

            public void setConv_tracking(List<ConvTrackingBean> list) {
                this.conv_tracking = list;
            }

            public void setCrid(String str) {
                this.crid = str;
            }

            public void setDeeplink(String str) {
                this.deeplink = str;
            }

            public void setDesc(String str) {
                this.desc = str;
            }

            public void setDp_tracking(List<String> list) {
                this.dp_tracking = list;
            }

            public void setDspid(String str) {
                this.dspid = str;
            }

            public void setHead_info(HeadInfoBean headInfoBean) {
                this.head_info = headInfoBean;
            }

            public void setImage(List<ImageBean> list) {
                this.image = list;
            }

            public void setImpid(String str) {
                this.impid = str;
            }

            public void setImptrackers(List<String> list) {
                this.imptrackers = list;
            }

            public void setIs_download(int i10) {
                this.is_download = i10;
            }

            public void setLdp(String str) {
                this.ldp = str;
            }

            public void setMarketurl(String str) {
                this.marketurl = str;
            }

            public void setMc(McBean mcBean) {
                this.f2288mc = mcBean;
            }

            public void setPkgname(String str) {
                this.pkgname = str;
            }

            public void setPrice(int i10) {
                this.price = i10;
            }

            public void setTemplateid(String str) {
                this.templateid = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setVideo(VideoBean videoBean) {
                this.video = videoBean;
            }

            public void setWake_id(String str) {
                this.wake_id = str;
            }

            public void setWake_path(String str) {
                this.wake_path = str;
            }

            public void setWake_type(int i10) {
                this.wake_type = i10;
            }
        }

        public List<List<BidBean>> getBid() {
            return this.bid;
        }

        public void setBid(List<List<BidBean>> list) {
            this.bid = list;
        }
    }

    public String getBidid() {
        return this.bidid;
    }

    public int getCode() {
        return this.code;
    }

    public String getId() {
        return this.f2287id;
    }

    public List<SeatbidBean> getSeatbid() {
        return this.seatbid;
    }

    public void setBidid(String str) {
        this.bidid = str;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setId(String str) {
        this.f2287id = str;
    }

    public void setSeatbid(List<SeatbidBean> list) {
        this.seatbid = list;
    }
}
