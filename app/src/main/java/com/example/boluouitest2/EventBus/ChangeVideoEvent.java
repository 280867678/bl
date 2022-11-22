package com.example.boluouitest2.EventBus;

import com.example.boluouitest2.bean.VideoBean;

public class ChangeVideoEvent {
    public VideoBean item;
    public int vid;

    public ChangeVideoEvent(int i, VideoBean videoBean) {
        this.vid = i;
        this.item = videoBean;
    }

    public VideoBean getItem() {
        return this.item;
    }

    public int getVid() {
        return this.vid;
    }

    public void setItem(VideoBean videoBean) {
        this.item = videoBean;
    }

    public void setVid(int i) {
        this.vid = i;
    }
}
