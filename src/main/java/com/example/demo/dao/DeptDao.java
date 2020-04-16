package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptVo;

@Repository
public class DeptDao {
	public List<DeptVo> selectAll(){
		return DBManager.selectAll();
	}
	
	public int insert(DeptVo d) {
		return DBManager.insertDept(d);
	}
	
	public int delete(DeptVo d) {
		return DBManager.deleteDept(d);
	}
	
	public int update(DeptVo d) {
		return DBManager.updateDept(d);
	}
}