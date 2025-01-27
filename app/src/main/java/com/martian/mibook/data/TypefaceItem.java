package com.martian.mibook.data;

import ba.l;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes3.dex */
public class TypefaceItem {
    public static final int TYPEFACE_DEFAULT = 0;
    public static final int TYPEFACE_DOWNLOADED = 1;
    public static final int TYPEFACE_DOWNLOADED_VIP = 4;
    public static final int TYPEFACE_IMPORT = 2;
    public static final int TYPEFACE_SCAN = 3;
    private String downloadPath;
    private String downloadUrl;
    private String filePath;
    private String fileSize;
    private int res;
    private int type;
    private int faceStatus = 0;
    private int unlockExpLevel = 50;

    public interface TYPE_FACE_STATUS {
        public static final int DOWNLOAD = 1;
        public static final int FAILED = 3;
        public static final int IDLE = 0;
        public static final int UNZIP = 2;
        public static final int WAIT_DOWNLOAD = 4;
    }

    public static boolean isDefaultTypeface(String str) {
        if (l.q(str)) {
            return false;
        }
        return str.contains("SourceHanSerifCN-Regular") || str.contains("GenJyuuGothic-Regular-2") || str.contains("SIMKAI(1)");
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getFaceStatus() {
        return this.faceStatus;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public int getRes() {
        return this.res;
    }

    public int getType() {
        return this.type;
    }

    public int getUnlockExpLevel() {
        return this.unlockExpLevel;
    }

    public boolean isVipTypeface() {
        return this.type == 4 && MiConfigSingleton.b2().W1() < getUnlockExpLevel();
    }

    public void setDownloadPath(String str) {
        this.downloadPath = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFaceStatus(int i10) {
        this.faceStatus = i10;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setRes(int i10) {
        this.res = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUnlockExpLevel(int i10) {
        this.unlockExpLevel = i10;
    }
}
