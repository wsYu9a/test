package org.apache.tools.zip;

import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class ZipEntry extends java.util.zip.ZipEntry implements Cloneable {
    private static final int PLATFORM_FAT = 0;
    private static final int PLATFORM_UNIX = 3;
    private long externalAttributes;
    private Vector extraFields;
    private int internalAttributes;
    private String name;
    private int platform;

    public ZipEntry(String str) {
        super(str);
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.name = null;
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        if (this.extraFields == null) {
            this.extraFields = new Vector();
        }
        ZipShort headerId = zipExtraField.getHeaderId();
        int size = this.extraFields.size();
        boolean z = false;
        for (int i2 = 0; !z && i2 < size; i2++) {
            if (((ZipExtraField) this.extraFields.elementAt(i2)).getHeaderId().equals(headerId)) {
                this.extraFields.setElementAt(zipExtraField, i2);
                z = true;
            }
        }
        if (!z) {
            this.extraFields.addElement(zipExtraField);
        }
        setExtra();
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipEntry zipEntry = (ZipEntry) super.clone();
        Vector vector = this.extraFields;
        zipEntry.extraFields = vector != null ? (Vector) vector.clone() : null;
        zipEntry.setInternalAttributes(getInternalAttributes());
        zipEntry.setExternalAttributes(getExternalAttributes());
        zipEntry.setExtraFields(getExtraFields());
        return zipEntry;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields());
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField[] getExtraFields() {
        Vector vector = this.extraFields;
        if (vector == null) {
            return new ZipExtraField[0];
        }
        ZipExtraField[] zipExtraFieldArr = new ZipExtraField[vector.size()];
        this.extraFields.copyInto(zipExtraFieldArr);
        return zipExtraFieldArr;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        return extra != null ? extra : new byte[0];
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String str = this.name;
        return str == null ? super.getName() : str;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getUnixMode() {
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    public void removeExtraField(ZipShort zipShort) {
        if (this.extraFields == null) {
            this.extraFields = new Vector();
        }
        int size = this.extraFields.size();
        boolean z = false;
        for (int i2 = 0; !z && i2 < size; i2++) {
            if (((ZipExtraField) this.extraFields.elementAt(i2)).getHeaderId().equals(zipShort)) {
                this.extraFields.removeElementAt(i2);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException();
        }
        setExtra();
    }

    public void setComprSize(long j2) {
        setCompressedSize(j2);
    }

    public void setExternalAttributes(long j2) {
        this.externalAttributes = j2;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            setExtraFields(ExtraFieldUtils.parse(bArr));
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArr) {
        this.extraFields = new Vector();
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            this.extraFields.addElement(zipExtraField);
        }
        setExtra();
    }

    public void setInternalAttributes(int i2) {
        this.internalAttributes = i2;
    }

    protected void setName(String str) {
        this.name = str;
    }

    protected void setPlatform(int i2) {
        this.platform = i2;
    }

    public void setUnixMode(int i2) {
        setExternalAttributes(((i2 & 128) == 0 ? 1 : 0) | (i2 << 16) | (isDirectory() ? 16 : 0));
        this.platform = 3;
    }

    protected void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getExtraFields()));
    }

    public ZipEntry(java.util.zip.ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.name = null;
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(ExtraFieldUtils.parse(extra));
        } else {
            setExtra();
        }
    }

    public ZipEntry(ZipEntry zipEntry) throws ZipException {
        this((java.util.zip.ZipEntry) zipEntry);
        setInternalAttributes(zipEntry.getInternalAttributes());
        setExternalAttributes(zipEntry.getExternalAttributes());
        setExtraFields(zipEntry.getExtraFields());
    }

    protected ZipEntry() {
        super("");
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.name = null;
    }
}
