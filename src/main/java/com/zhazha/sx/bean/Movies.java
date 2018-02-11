package com.zhazha.sx.bean;

import java.util.Date;

public class Movies {
    private int id;
    private String name;
    private int PerformerId;
    private String MainPerformerName;
    private String hasMosaic;
    private Date releaseTime;
    private String torrent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerformerId() {
        return PerformerId;
    }

    public void setPerformerId(int performerId) {
        PerformerId = performerId;
    }

    public String getMainPerformerName() {
        return MainPerformerName;
    }

    public void setMainPerformerName(String mainPerformerName) {
        MainPerformerName = mainPerformerName;
    }

    public String getHasMosaic() {
        return hasMosaic;
    }

    public void setHasMosaic(String hasMosaic) {
        this.hasMosaic = hasMosaic;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getTorrent() {
        return torrent;
    }

    public void setTorrent(String torrent) {
        this.torrent = torrent;
    }
}
