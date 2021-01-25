package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhoneVo;

@Repository//new 연산자에서 만들어지는 코드라는것을 의미
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트 가져오기
	public List<PhoneVo> getPersonList(){
		System.out.println("dao : getPersonList()");
		
		List<PhoneVo> personList = sqlSession.selectList("phonebook.selectList2");
		
		System.out.println(personList.toString());
		
		return personList;
	}
	
	
	//정보 저장
	public int personInsert(PhoneVo phoneVo) {
		System.out.println(phoneVo.toString());
		
		int count = sqlSession.insert("phonebook.insert", phoneVo);
		System.out.println(count);
		
		return count;
	}
	
	//정보 삭제
	public int phoneDelete(int phoneId) {
		System.out.println("dao:  phoneDelete() " + phoneId);
		
		int count = sqlSession.delete("phonebook.delete", phoneId);
		System.out.println(count);
		
		return count;
	}
	
	//한 명 정보 가져오기
	public PhoneVo getPerson(int phoneId) {
		System.out.println("dao: getPerson()" + phoneId);
		
		PhoneVo phoneVo= sqlSession.selectOne("phonebook.selectOne", phoneId);
		System.out.println(phoneVo.toString());
		
		return phoneVo;
	}
	
	
	//한 명 정보 가져오기2
		public Map<String, Object>  getPerson2(int phoneId) {
			System.out.println("dao: getPerson2()" + phoneId);
			
			Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectOne2", phoneId);
			System.out.println(personMap.toString());
			
			String name = (String)personMap.get("name");
			System.out.println(name);
			
			int id = Integer.parseInt(String.valueOf(personMap.get("phoneId"))); 
			System.out.println(id);
			
			return personMap;
		}
	//수정
	
	public int personUpdate(PhoneVo phoneVo) {
		System.out.println("dao:  personUpdate()" + phoneVo);
		
		int count = sqlSession.update("phonebook.update", phoneVo);
		
		return count;
		
	}
	
	//수정 2
	public int personUpdate2(int phoneId, String name, String hp, String company) {
		
		//vo 대신 --> map이용
		//vo를 한 번만 사용할 것 같을 때 사용
		//PhoneVo phoneVo = new PhoneVo(phoneId, name, hp, company);
		
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("id", phoneId);
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		System.out.println(personMap.toString());
		
		return  sqlSession.update("phonebook.update2", personMap);
		
	}
	
	
	
	
	
}