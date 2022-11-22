package com.example.boluouitest2.bean;

import java.util.List;

public class VideoDetailBean {


    public List<AdBannerBean> ads;
    public int my_ticket_number;
    public VideoBean row;
    public VideoCollectInfoBean topic;
    public List<VideoBean> topic_mv;

    public List<AdBannerBean> getAds() {
        return this.ads;
    }

    public int getMy_ticket_number() {
        return this.my_ticket_number;
    }

    public VideoBean getRow() {
        return this.row;
    }

    public VideoCollectInfoBean getTopic() {
        return this.topic;
    }

    public List<VideoBean> getTopic_mv() {
        return this.topic_mv;
    }

    public void setAds(List<AdBannerBean> list) {
        this.ads = list;
    }

    public void setMy_ticket_number(int i) {
        this.my_ticket_number = i;
    }

    public void setRow(VideoBean videoBean) {
        this.row = videoBean;
    }

    public void setTopic(VideoCollectInfoBean videoCollectInfoBean) {
        this.topic = videoCollectInfoBean;
    }

    public void setTopic_mv(List<VideoBean> list) {
        this.topic_mv = list;
    }



}
