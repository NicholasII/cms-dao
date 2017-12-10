package com.sun.cms.model;

import java.util.List;

/**
 * 分页实例
 * @author dongq
 *
 * @param <Dto>
 */
public class PageDto<Dto extends BaseDto>{
 
	protected long total = -1; // 总记录数
	
    protected List<Dto> rows; // 当前页记录List形式  
    
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Dto> getRows() {
		return rows;
	}
	public void setRows(List<Dto> rows) {
		this.rows = rows;
	}
      
    
}
