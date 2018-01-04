package com.sun.cms.dao;

import java.util.List;

import com.sun.cms.model.BaseDto;

public interface BaseDao<Dto extends BaseDto> {
	/**
	 * 查询多条信息
	 * @param dto
	 * @return
	 */
	List<Dto> select(Dto dto);
	/**
	 * 查询一条信息
	 * @param dto
	 * @return
	 */
	Dto selectOne(Dto dto);
	/**
	 * 插入对象
	 * @param dto
	 * @return
	 */
	int insert(Dto dto);
	/**
	 * 删除对象
	 * @param dto
	 * @return
	 */
	int delete(Dto dto);
	/**
	 * 更新对象
	 * @param dto
	 * @return
	 */
	int update(Dto dto);
}
