package com.real_estate.global.utils;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class CommonUtil {
    public static Point getLocation(Double longitude, Double latitude) throws ParseException {
        return (Point) new WKTReader().read(String.format("POINT(%s %s)", longitude, latitude));
    }
}
