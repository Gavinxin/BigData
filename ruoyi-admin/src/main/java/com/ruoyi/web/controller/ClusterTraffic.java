package com.ruoyi.web.controller;

import org.jcp.xml.dsig.internal.dom.DOMUtils;

/**
 * Author：Gavin
 * Datetime : 2021/5/11 20:31
 */

public class ClusterTraffic {
    private double lat;
    private double lon;
    private Integer cnt;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public ClusterTraffic(double lat, double lon, Integer cnt) {
        this.lat = lat;
        this.lon = lon;
        this.cnt = cnt;
    }

    public ClusterTraffic() {
    }
}
