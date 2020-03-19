package com.example.jenkinsdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * UUIDUtil
 *
 * @author shichunyang
 */
public class UUIDUtil {
	private UUIDUtil() {
	}

	/**
	 * 获取一个32位的UUID码
	 *
	 * @return 32位UUID
	 */
	public static String get32UUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String generateUniqueIdWithUUID() {
		return UUID.randomUUID().toString();
	}

	public static synchronized String getOrderNumber() {
		String currentDate = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

		try {
			Thread.sleep(1L);
		} catch (InterruptedException var2) {
			var2.printStackTrace();
		}

		return currentDate;
	}
}
