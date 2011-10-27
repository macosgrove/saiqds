package models.interfaces;

import models.GeoMap;
import models.Image;
import models.Locality;

public interface Mappable {
	Image marker = null;
	public void draw(GeoMap map);
}