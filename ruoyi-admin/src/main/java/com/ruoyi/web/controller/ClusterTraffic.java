package com.ruoyi.web.controller;

import com.ruoyi.system.domain.ClusterHistory;
import lombok.Getter;
import lombok.Setter;
import org.jcp.xml.dsig.internal.dom.DOMUtils;

/**
 * Author：Gavin
 * Datetime : 2021/5/11 20:31
 */

@Getter
@Setter
public class ClusterTraffic extends ClusterHistory implements Comparable<ClusterTraffic> {
    private Double lat;
    private Double lon;
    private Long cnt;
    private String roadName;
    private String name;


    public ClusterTraffic(Double lat, Double lon, Long cnt, String roadName) {
        this.lat = lat;
        this.lon = lon;
        this.cnt = cnt;
        this.roadName = roadName;
    }

    public ClusterTraffic() {
    }

    @Override
    public String toString() {
        return "ClusterTraffic{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", cnt=" + cnt +
                ", roadName='" + roadName + '\'' +
                '}';
    }



    @Override
    public int compareTo(ClusterTraffic o) {
        if(o.cnt>=this.cnt)
            return 1;
        return 0;
    }
}
