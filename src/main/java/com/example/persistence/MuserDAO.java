package com.example.persistence;

import java.util.List;

import com.example.domain.MuserVO;

public interface MuserDAO {
	public List<MuserVO> list(String mrank) throws Exception;
	public void insert(MuserVO vo) throws Exception;
	public void delete(String mrank) throws Exception;
}
