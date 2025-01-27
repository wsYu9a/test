package com.martian.mibook.lib.account.response;

import com.martian.libsupport.h;
import java.util.Date;

/* loaded from: classes3.dex */
public class MiVContributor {

    @h.a
    private String cont_header;

    @h.a
    private String cont_nickname;

    @h.a
    private Long cont_uid;

    @h.a
    private Date createdOn;

    public Long getContUid() {
        return this.cont_uid;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public String getHeader() {
        return this.cont_header;
    }

    public String getNickname() {
        return this.cont_nickname;
    }

    public void setContUid(Long cont_uid) {
        this.cont_uid = cont_uid;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setHeader(String cont_header) {
        this.cont_header = cont_header;
    }

    public void setNickname(String cont_nickname) {
        this.cont_nickname = cont_nickname;
    }
}
