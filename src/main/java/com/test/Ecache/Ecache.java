package com.test.Ecache;

import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public class Ecache {
	
	public static Object getCacheByKeyAndName(String ecName, String key) {
		Element el = null;
		CacheManager manager = CacheManager.create();
		Cache cache = manager.getCache(ecName);
		if (cache != null && cache.isKeyInCache(key)) {
			el = cache.get(key);
			if (el != null)
				return el.getObjectValue();
		}
		return null;
	}

	public static void setCacheByKeyAndName(String ecName, String key, Object value) {
		Element el = null;
		CacheManager manager = CacheManager.create();
		Cache cache = manager.getCache(ecName);
		if (value != null) {
			el = new Element(key, value);
			cache.put(el);
		}
	}
}
