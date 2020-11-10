package com.dev24.client.refund.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundVO {
	private int rf_num = 0;
	private String rf_reason = "";
	private int rf_price = 0;
	private String rf_confirmdate ="";
	private int pd_num = 0;
	private int c_num = 0;
	private int b_num = 0;
}