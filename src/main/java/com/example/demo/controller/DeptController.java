package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVo;
import com.google.gson.Gson;

@RestController
public class DeptController {

	@Autowired
	private DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listDept.do")
	public String listDept() {
		String r= "";
		List<DeptVo> list = dao.selectAll();
		Gson gson = new Gson();
		r = gson.toJson(list);
		return r;
	}
	
	@RequestMapping("/insertDept.do")	
	public String insertDept(@RequestParam Map map) {
		String data =(String) map.keySet().iterator().next();
		Gson gson = new Gson();
		DeptVo d =gson.fromJson(data, DeptVo.class);//json을 vo로 바꿔줌
		int re = dao.insert(d);
		return "ok";
	}
	
	@RequestMapping("/deleteDept.do")	
	public String deleteDept(@RequestParam Map map) {
		System.out.println("삭제");
		String data =(String) map.keySet().iterator().next();
		Gson gson = new Gson();
		DeptVo d =gson.fromJson(data, DeptVo.class);
		int re = dao.delete(d);
		return "ok";
	}
	
	@RequestMapping("/updateDept.do")	
	public String updateDept(@RequestParam Map map) {
		System.out.println("수정");
		String data =(String) map.keySet().iterator().next();
		Gson gson = new Gson();
		DeptVo d =gson.fromJson(data, DeptVo.class);
		int re = dao.update(d);
		return "ok";
	}
}