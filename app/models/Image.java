package models;

import siena.Id;
import siena.embed.EmbeddedMap;

@EmbeddedMap
public class Image {
	@Id
	protected long id;
	protected byte[] image;
	
	public long getId() {
		return id;
	}
}