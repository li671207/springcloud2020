package com.lihl.entities;

import cn.hutool.Hutool;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

	private Integer code;
	private String message;
	private T data;

	public CommonResult(Integer code, String message){
		this(code, message, null);
	}

	public static void main(String[] args) {
//		long wordId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
//		System.out.println(wordId);
		Snowflake snowflake = IdUtil.createSnowflake(1,1);
		String s = "1000101011111010100011101011100011001010000100001000000000000";
		System.out.println(s.length());
		Date date = new Date();
		date.setTime(1251809354202615808l);
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");

		System.out.println(ss.format(date));

		System.out.println(snowflake.nextId());
	}

}
