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

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
