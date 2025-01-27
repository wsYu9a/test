package com.czhj.sdk.common.models;

import android.text.TextUtils;
import com.czhj.volley.toolbox.Volley;

/* loaded from: classes2.dex */
public class Config {
    private static Config gInstance;
    private boolean disable_boot_mark;
    private boolean disable_oaid_api;
    private int disable_up_oaid;
    private String log;
    private boolean logenc;
    private int max_send_log_records = 100;
    private int send_log_interval = 3;
    private int networkTimeout = 5000;
    private boolean mIsGDPRRegion = false;

    private Config() {
    }

    public static Config sharedInstance() {
        if (gInstance == null) {
            synchronized (Config.class) {
                try {
                    if (gInstance == null) {
                        gInstance = new Config();
                    }
                } finally {
                }
            }
        }
        return gInstance;
    }

    public int getDisable_up_OAid() {
        return this.disable_up_oaid;
    }

    public String getLogUrl() {
        if (!TextUtils.isEmpty(this.log)) {
            return this.log;
        }
        return "https://dc.sigmob.cn/log";
    }

    public int getMax_send_log_records() {
        if (this.max_send_log_records < 10) {
            this.max_send_log_records = 100;
        }
        return this.max_send_log_records;
    }

    public int getNetworkTimeout() {
        return this.networkTimeout;
    }

    public boolean getOaidApiDisable() {
        return this.disable_oaid_api;
    }

    public int getSend_log_interval() {
        return this.send_log_interval;
    }

    public boolean isDisableBootMark() {
        return this.disable_boot_mark;
    }

    public boolean isEnc() {
        return this.logenc;
    }

    public boolean isGDPRRegion() {
        return this.mIsGDPRRegion;
    }

    public void setEnable_okhttp3(boolean z10) {
        Volley.setEnableOkhttp3(z10);
    }

    public void setNetworkTimeout(int i10) {
        if (i10 <= 0 || i10 > 30) {
            return;
        }
        this.networkTimeout = i10 * 1000;
    }

    public void update(boolean z10, boolean z11, boolean z12, int i10, String str, int i11, int i12, boolean z13) {
        this.mIsGDPRRegion = z10;
        this.disable_boot_mark = z11;
        this.disable_oaid_api = z12;
        this.disable_up_oaid = i10;
        this.max_send_log_records = i12;
        this.send_log_interval = i11;
        this.log = str;
        this.logenc = z13;
    }
}
