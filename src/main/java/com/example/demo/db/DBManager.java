package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;

public class DBManager {
	public  static SqlSessionFactory factory = null;
	
	static {
		try {
			System.out.println("manager 시작:");
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			System.out.println("reader:"+reader);
			factory = (new SqlSessionFactoryBuilder()).build(reader);
			System.out.println("factory:"+factory);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<DeptVo> selectAll(){
		SqlSession session = factory.openSession();
		System.out.println("session:"+session);
		List<DeptVo> list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}	
	
	public static int insertDept(DeptVo d) {
		int re = -1;
		SqlSession session = factory.openSession();
		re= session.insert("dept.insert",d);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteDept(DeptVo d) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("dept.delete", d);
		session.commit();
		session.close();
		return re;
	}
	
	public static DeptVo detail(DeptVo d) {
		DeptVo vo = null;
		SqlSession session = factory.openSession();
		vo = session.selectOne("dept.detail", d);
		session.close();
		return vo;
	}
	
	public static int updateDept(DeptVo d) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("dept.update", d);
		session.commit();
		session.close();
		return re;
	}
}