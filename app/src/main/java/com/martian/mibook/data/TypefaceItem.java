package com.martian.mibook.data;

import com.martian.libsupport.k;

/* loaded from: classes3.dex */
public class TypefaceItem {
    public static final int TYPEFACE_DEFAULT = 0;
    public static final int TYPEFACE_DOWNLOADED = 1;
    public static final int TYPEFACE_IMPORT = 2;
    public static final int TYPEFACE_SCAN = 3;
    private String downloadPath;
    private String downloadUrl;
    private int faceStatus = 0;
    private String filePath;
    private String fileSize;
    private int res;
    private int type;

    public interface TYPE_FACE_STATUS {
        public static final int DOWNLOAD = 1;
        public static final int FAILED = 3;
        public static final int IDLE = 0;
        public static final int UNZIP = 2;
        public static final int WAIT_DOWNLOAD = 4;
    }

    public static boolean isDefaultTypeface(String filePath) {
        if (k.p(filePath)) {
            return false;
        }
        return filePath.contains("SourceHanSerifCN-Regular") || filePath.contains("GenJyuuGothic-Regular-2") || filePath.contains("SIMKAI(1)");
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

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setFaceStatus(int faceStatus) {
        this.faceStatus = faceStatus;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void setType(int type) {
        this.type = type;
    }
}
