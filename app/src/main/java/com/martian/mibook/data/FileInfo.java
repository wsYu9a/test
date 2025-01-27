package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class FileInfo {
    public String fileDate;
    public String fileName;
    public String filePath;
    public String fileSize;
    public boolean isChecked;

    public String getFileDate() {
        return this.fileDate;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setFileDate(String str) {
        this.fileDate = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setIsChecked(boolean z10) {
        this.isChecked = z10;
    }
}
