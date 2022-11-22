package com.example.boluouitest2.EventBus;

public class CurSelectVideoIdEvent {
    public int videoId;

    public CurSelectVideoIdEvent(int i) {
        this.videoId = i;
    }

    public int getVideoId() {
        return this.videoId;
    }

    public void setVideoId(int i) {
        this.videoId = i;
    }

}
