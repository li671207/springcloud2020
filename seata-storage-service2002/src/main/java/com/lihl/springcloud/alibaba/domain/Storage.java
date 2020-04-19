package com.lihl.springcloud.alibaba.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	private Long id;
	private Long productId;
	private Long total;
	private Integer used;
	private Integer residue;
}
