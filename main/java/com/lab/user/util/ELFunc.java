package com.lab.user.util;

import org.apache.commons.codec.binary.Base64;

public class ELFunc {
	public static String getBase64DecodeString(String base64Encode) {
		Base64 base64 = new Base64();
		return new String(base64.decode(base64Encode));
	}
}
