package com.example.web;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.MovieVO;
import com.example.domain.MuserVO;
import com.example.domain.NaverAPI;
import com.example.persistence.MovieDAO;
import com.example.persistence.MuserDAO;

@Controller
public class MovieController {
	@Inject
	MovieDAO dao;

	@Inject
	MuserDAO mdao;

	@RequestMapping("/")
	public String moviejsp() {
		return "movie";
	}

	@ResponseBody // 데이터를 반환하는 어노테이션
	@RequestMapping("movie.json") // 주소설정
	public ArrayList<MovieVO> movie() throws Exception { // 메소드
		ArrayList<MovieVO> array = new ArrayList<MovieVO>();
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
		Elements es = doc.select("ol");
		for (Element e : es.select("li")) {
			MovieVO vo = new MovieVO();
			vo.setRank(e.select(".rank").text());
			vo.setImage(e.select("img").attr("src"));
			vo.setTitle(e.select(".title").text());
			vo.setPercent(e.select(".percent span").text());
			vo.setLink(e.select(".box-image a").attr("href"));
			vo.setTicketing(e.select(".link-reservation").attr("href"));
			if (!e.select(".rank").text().equals("")) {
				array.add(vo);
			}
		}
		return array;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert(MovieVO vo) throws Exception {
		dao.insert(vo);
	}

	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<MovieVO> list() throws Exception {
		return dao.list();
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete(String rank) throws Exception {
		dao.delete(rank);
	}

	@ResponseBody
	@RequestMapping("list.json")
	public List<MuserVO> mlist(String mrank) throws Exception {
		return mdao.list(mrank);
	}

	@ResponseBody
	@RequestMapping(value = "minsert", method = RequestMethod.POST)
	public void minsert(MuserVO vo) throws Exception {
		mdao.insert(vo);
	}

	@ResponseBody
	@RequestMapping("nmovie.json")
	public String movieList(String keyword, String start) throws Exception {
		String text = URLEncoder.encode(keyword, "UTF-8");
		String apiURL = "https://openapi.naver.com/v1/search/movie.json?"; // json
																			// 결과
		apiURL += "query=" + text;
		apiURL += "&start=" + start;
		apiURL += "$display=5";
		return NaverAPI.search(apiURL);
	}

	@ResponseBody
	@RequestMapping(value = "mdelete", method = RequestMethod.POST)
	public void mdelete(String mrank) throws Exception {
		mdao.delete(mrank);
	}
}
