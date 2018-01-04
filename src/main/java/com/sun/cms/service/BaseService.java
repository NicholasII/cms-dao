package com.sun.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.cms.dao.BaseDao;
import com.sun.cms.model.BaseDto;
import com.sun.cms.model.PageDto;

public class BaseService<Dao extends BaseDao<Dto>,Dto extends BaseDto> {

	@Autowired
	Dao dao;
	
	/**
	 * 查询--分页
	 * @param dto
	 * @param currpage
	 * @param pagesize
	 * @return
	 */
	public PageDto<Dto> getPageList(Dto dto,int pageNum,int pageSize){
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Dto> pagelist = dao.select(dto);
			PageInfo<Dto> pageInfo = new PageInfo<>(pagelist);
			PageDto<Dto> pageDto = new PageDto<>();
			pageDto.setRows(pageInfo.getList());
			pageDto.setTotal(pageInfo.getTotal());
			return pageDto;
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查询——不分页
	 * @param dto
	 * @return
	 */
	public List<Dto> getAllList(Dto dto){
		try {
			List<Dto> list = dao.select(dto);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查询-当具有唯一结果时
	 * @param dto
	 * @return
	 */
	public Dto getOne(Dto dto){
		try {
			Dto result = dao.selectOne(dto);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 插入多条数据
	 * @param dtos
	 * @return
	 */
	public boolean insert(List<Dto> dtos){
		try {
			for (Dto dto : dtos) {
				dao.insert(dto);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 插入一条数据
	 * @param dto
	 * @return
	 */
	public boolean insert(Dto dto){
		try {
			dao.insert(dto);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除一条数据
	 * @param dto
	 * @return
	 */
	public boolean delete(Dto dto){
		try {
			dao.delete(dto);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 批量删除
	 * @author dongqun
	 * 2017年12月26日下午1:41:15
	 * @param dtos
	 * @return
	 */
	@Transactional
	public boolean delete(List<Dto> dtos){
		try {
			for (Dto dto : dtos) {
				dao.delete(dto);
			}			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 更新一条数据
	 * @param dto
	 * @return
	 */
	public boolean update(Dto dto){
		try {
			dao.update(dto);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
