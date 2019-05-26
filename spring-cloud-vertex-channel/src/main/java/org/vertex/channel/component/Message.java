/**
 * Copyright (C) 2014-2017, Hrfax and/or its affiliates. All rights reserved.
 * Hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package org.vertex.channel.component;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class Message implements Serializable {

	private static final long serialVersionUID = -4524287677101705866L;

	public final Map<String,Object> headers = new HashMap<>();
	
	public Object payload;
	
	public Message(Object payload){
		this(Collections.emptyMap(),payload);
	}
	
	public Message(Map<String,Object> headers, Object payload){
		this.headers.putAll(headers);
		this.payload = payload;
	}
	
	
	public void addHeader(String key,Object value){
		this.headers.put(key, value);
	}

	public void payLoad(Object payload) {
		this.payload = payload;
	}


	@SuppressWarnings("unchecked")
	public <E> E getHeader(String key,Class<E> cazz) {
		return (E) headers.get(key);
	}
}
