package com.example.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.domain.MuserVO;

@Repository
public class MuserDAOImpl implements MuserDAO {

	@Inject
	SqlSession session;
	public static final String namespace = "MuserMapper";

	@Override
	public List<MuserVO> list(String mrank) throws Exception {
		return session.selectList(namespace + ".list", mrank);
	}

	@Override
	public void insert(MuserVO vo) throws Exception {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void delete(String mrank) throws Exception {
		session.delete(namespace + ".delete", mrank);
	}

}
