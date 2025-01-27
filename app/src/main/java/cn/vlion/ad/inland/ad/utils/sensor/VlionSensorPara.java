package cn.vlion.ad.inland.ad.utils.sensor;

import cn.vlion.ad.inland.base.l1;

/* loaded from: classes.dex */
public class VlionSensorPara {
    public int speedX = 0;
    public int speedY = 0;
    public int speedZ = 0;
    public int rotateX = 0;
    public int rotateY = 0;
    public int rotateZ = 0;
    public long rotateTime = 0;

    public long getRotateTime() {
        return this.rotateTime;
    }

    public int getRotateX() {
        return this.rotateX;
    }

    public int getRotateY() {
        return this.rotateY;
    }

    public int getRotateZ() {
        return this.rotateZ;
    }

    public int getSpeedX() {
        return this.speedX;
    }

    public int getSpeedY() {
        return this.speedY;
    }

    public int getSpeedZ() {
        return this.speedZ;
    }

    public void setRotate(int i10, int i11, int i12) {
        this.rotateX = i10;
        this.rotateY = i11;
        this.rotateZ = i12;
    }

    public void setRotateTime(long j10) {
        this.rotateTime = j10;
    }

    public void setSpeed(int i10, int i11, int i12) {
        this.speedX = i10;
        this.speedY = i11;
        this.speedZ = i12;
    }

    public String toString() {
        StringBuilder a10 = l1.a("VlionSensorPara{speedX=");
        a10.append(this.speedX);
        a10.append(", speedY=");
        a10.append(this.speedY);
        a10.append(", speedZ=");
        a10.append(this.speedZ);
        a10.append(", rotateX=");
        a10.append(this.rotateX);
        a10.append(", rotateY=");
        a10.append(this.rotateY);
        a10.append(", rotateZ=");
        a10.append(this.rotateZ);
        a10.append(", rotateTime=");
        a10.append(this.rotateTime);
        a10.append('}');
        return a10.toString();
    }
}
