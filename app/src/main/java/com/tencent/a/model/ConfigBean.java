package com.tencent.a.model;

/* loaded from: classes7.dex */
public class ConfigBean {
    private int code;
    private DataBean data;
    private String msg;
    private String token;

    public static class DataBean {
        private DataInfo dataInfo;

        public DataInfo getDataInfo() {
            return this.dataInfo;
        }

        public void setDataInfo(DataInfo dataInfo) {
            this.dataInfo = dataInfo;
        }
    }

    public static class DataInfo {
        private float ad_handoff_seconds;
        private String adimages;
        private String adimages2;
        private String adimages3;
        private String adshow;
        private String adurl;
        private String adurl2;
        private String adurl3;
        private String alertcontent;
        private int alerttype;
        private String bindingpackagename;
        private int bindingswitch;
        private String bindingtips;
        private String bindingurl;
        private String bjimg;
        private String buttonfourtext;
        private String buttonfoururl;
        private String buttononetext;
        private String buttonthreetext;
        private String buttonthreeurl;
        private String buttontwotext;
        private String buttontwourl;
        private String crack;
        private String csqq;
        private String declare_d;
        private String declare_t;
        private long delayed_time;
        private int display_share_count;
        private int forceinstall;
        private String groupqq;
        private int is_delayed;
        private int is_open_task;
        private int is_redo_task;
        private int is_show_group;
        private int is_show_qq;
        private int is_task_dialog;
        private int is_to_url;
        private String isalert;
        private String isalertcancel;
        private String lanzouurl;
        private int open;
        private int page_show;
        private String rolltxt;
        private String rolltxton;
        private String sharecontent;
        private String sharecount;
        private float sharedelayedseconds;
        private String shareimg;
        private int sharemode;
        private String shareon;
        private String sharetype;
        private String shareurl;
        private String status;
        private String task_dialog_text;
        private String task_redo_time;
        private String taskanswer;
        private String taskanswertips;
        private String taskimage;
        private String taskimageone;
        private String taskimagethree;
        private String taskimagetwo;
        private String taskname;
        private String tasktip;
        private String tasktipone;
        private String tasktipthree;
        private String tasktiptwo;
        private String taskurl;
        private String teamintroduce;
        private int template;
        private String to_url;
        private String toasturl;

        public float getAd_handoff_seconds() {
            return this.ad_handoff_seconds;
        }

        public String getAdimages() {
            return this.adimages;
        }

        public String getAdimages2() {
            return this.adimages2;
        }

        public String getAdimages3() {
            return this.adimages3;
        }

        public String getAdshow() {
            return this.adshow;
        }

        public String getAdurl() {
            return this.adurl;
        }

        public String getAdurl2() {
            return this.adurl2;
        }

        public String getAdurl3() {
            return this.adurl3;
        }

        public String getAlertcontent() {
            return this.alertcontent;
        }

        public int getAlerttype() {
            return this.alerttype;
        }

        public String getBindingpackagename() {
            return this.bindingpackagename;
        }

        public int getBindingswitch() {
            return this.bindingswitch;
        }

        public String getBindingtips() {
            return this.bindingtips;
        }

        public String getBindingurl() {
            return this.bindingurl;
        }

        public String getBjimg() {
            return this.bjimg;
        }

        public String getButtonfourtext() {
            return this.buttonfourtext;
        }

        public String getButtonfoururl() {
            return this.buttonfoururl;
        }

        public String getButtononetext() {
            return this.buttononetext;
        }

        public String getButtonthreetext() {
            return this.buttonthreetext;
        }

        public String getButtonthreeurl() {
            return this.buttonthreeurl;
        }

        public String getButtontwotext() {
            return this.buttontwotext;
        }

        public String getButtontwourl() {
            return this.buttontwourl;
        }

        public String getCrack() {
            return this.crack;
        }

        public String getCsqq() {
            return this.csqq;
        }

        public String getDeclare_d() {
            return this.declare_d;
        }

        public String getDeclare_t() {
            return this.declare_t;
        }

        public long getDelayed_time() {
            return this.delayed_time;
        }

        public int getDisplay_share_count() {
            return this.display_share_count;
        }

        public int getForceinstall() {
            return this.forceinstall;
        }

        public String getGroupqq() {
            return this.groupqq;
        }

        public int getIs_delayed() {
            return this.is_delayed;
        }

        public int getIs_open_task() {
            return this.is_open_task;
        }

        public int getIs_redo_task() {
            return this.is_redo_task;
        }

        public int getIs_show_group() {
            return this.is_show_group;
        }

        public int getIs_show_qq() {
            return this.is_show_qq;
        }

        public int getIs_task_dialog() {
            return this.is_task_dialog;
        }

        public int getIs_to_url() {
            return this.is_to_url;
        }

        public String getIsalert() {
            return this.isalert;
        }

        public String getIsalertcancel() {
            return this.isalertcancel;
        }

        public String getLanzouurl() {
            return this.lanzouurl;
        }

        public int getOpen() {
            return this.open;
        }

        public int getPage_show() {
            return this.page_show;
        }

        public String getRolltxt() {
            return this.rolltxt;
        }

        public String getRolltxton() {
            return this.rolltxton;
        }

        public String getSharecontent() {
            return this.sharecontent;
        }

        public String getSharecount() {
            return this.sharecount;
        }

        public float getSharedelayedseconds() {
            return this.sharedelayedseconds;
        }

        public String getShareimg() {
            return this.shareimg;
        }

        public int getSharemode() {
            return this.sharemode;
        }

        public String getShareon() {
            return this.shareon;
        }

        public String getSharetype() {
            return this.sharetype;
        }

        public String getShareurl() {
            return this.shareurl;
        }

        public String getStatus() {
            return this.status;
        }

        public String getTask_dialog_text() {
            return this.task_dialog_text;
        }

        public String getTask_redo_time() {
            return this.task_redo_time;
        }

        public String getTaskanswer() {
            return this.taskanswer;
        }

        public String getTaskanswertips() {
            return this.taskanswertips;
        }

        public String getTaskimage() {
            return this.taskimage;
        }

        public String getTaskimageone() {
            return this.taskimageone;
        }

        public String getTaskimagethree() {
            return this.taskimagethree;
        }

        public String getTaskimagetwo() {
            return this.taskimagetwo;
        }

        public String getTaskname() {
            return this.taskname;
        }

        public String getTasktip() {
            return this.tasktip;
        }

        public String getTasktipone() {
            return this.tasktipone;
        }

        public String getTasktipthree() {
            return this.tasktipthree;
        }

        public String getTasktiptwo() {
            return this.tasktiptwo;
        }

        public String getTaskurl() {
            return this.taskurl;
        }

        public String getTeamintroduce() {
            return this.teamintroduce;
        }

        public int getTemplate() {
            return this.template;
        }

        public String getTo_url() {
            return this.to_url;
        }

        public String getToasturl() {
            return this.toasturl;
        }

        public void setAdimages(String str) {
            this.adimages = str;
        }

        public void setAdshow(String str) {
            this.adshow = str;
        }

        public void setAdurl(String str) {
            this.adurl = str;
        }

        public void setAlertcontent(String str) {
            this.alertcontent = str;
        }

        public void setAlerttype(int i2) {
            this.alerttype = i2;
        }

        public void setBjimg(String str) {
            this.bjimg = str;
        }

        public void setCrack(String str) {
            this.crack = str;
        }

        public void setCsqq(String str) {
            this.csqq = str;
        }

        public void setDeclare_d(String str) {
            this.declare_d = str;
        }

        public void setDeclare_t(String str) {
            this.declare_t = str;
        }

        public void setDelayed_time(long j2) {
            this.delayed_time = j2;
        }

        public void setGroupqq(String str) {
            this.groupqq = str;
        }

        public void setIs_delayed(int i2) {
            this.is_delayed = i2;
        }

        public void setIs_show_group(int i2) {
            this.is_show_group = i2;
        }

        public void setIs_show_qq(int i2) {
            this.is_show_qq = i2;
        }

        public void setIsalert(String str) {
            this.isalert = str;
        }

        public void setIsalertcancel(String str) {
            this.isalertcancel = str;
        }

        public void setLanzouurl(String str) {
            this.lanzouurl = str;
        }

        public void setOpen(int i2) {
            this.open = i2;
        }

        public void setPage_show(int i2) {
            this.page_show = i2;
        }

        public void setRolltxt(String str) {
            this.rolltxt = str;
        }

        public void setRolltxton(String str) {
            this.rolltxton = str;
        }

        public void setSharecontent(String str) {
            this.sharecontent = str;
        }

        public void setSharecount(String str) {
            this.sharecount = str;
        }

        public void setShareimg(String str) {
            this.shareimg = str;
        }

        public void setShareon(String str) {
            this.shareon = str;
        }

        public void setSharetype(String str) {
            this.sharetype = str;
        }

        public void setShareurl(String str) {
            this.shareurl = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setTeamintroduce(String str) {
            this.teamintroduce = str;
        }

        public void setToasturl(String str) {
            this.toasturl = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getToken() {
        return this.token;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
