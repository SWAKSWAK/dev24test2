package com.dev24.admin.stock.dao;

import java.util.List;

import com.dev24.admin.stock.vo.StockVO;
import com.dev24.client.book.vo.BookVO;

public interface StockDAO {
	public List<StockVO> stockList(StockVO svo);
	public List<BookVO> stockBInfoList(BookVO bvo);
}
