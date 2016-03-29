package me.qisama.jxlx.service;

import java.util.Comparator;

import me.qisama.jxlx.entity.Score;

/**
 * 对Score按照成绩降序
 * @author QISAMA
 * 2016年3月28日
 */
public class RankComparator implements Comparator<Score> {

	@Override
	public int compare(Score o1, Score o2) {
		// TODO Auto-generated method stub
		if (o1.getScore()>o2.getScore()) {
			return -1;
		} else if(o1.getScore()==o2.getScore()){
			return 0;
		}else {
			return 1;
		}
	}

}
