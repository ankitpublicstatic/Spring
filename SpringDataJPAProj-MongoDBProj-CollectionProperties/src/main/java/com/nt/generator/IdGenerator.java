package com.nt.generator;

import java.util.UUID;

public class IdGenerator {
	public static String genrateId() {
		//	return UUID.randomUUID().toString();
			return UUID.randomUUID().toString().replace("-","").substring(0,10);
		}
}
