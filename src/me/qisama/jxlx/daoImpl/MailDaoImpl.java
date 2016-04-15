package me.qisama.jxlx.daoImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import me.qisama.jxlx.dao.MailMapper;
import me.qisama.jxlx.entity.Mail;
import me.qisama.jxlx.entity.MailExample;
import me.qisama.jxlx.entity.MailExample.Criteria;

@Repository
public class MailDaoImpl {

	@Autowired
	private MailMapper mailMapper;
	
	public int create(Mail mail) {
		return mailMapper.insert(mail);
	}
	
	public int update(Mail mail) {
		return mailMapper.updateByPrimaryKey(mail);
	}
	
	public int updateSelective(Mail mail) {
		return mailMapper.updateByPrimaryKeySelective(mail);
	}
	
	public int delete(int id) {
		return mailMapper.deleteByPrimaryKey(id);
	}
	
	public Mail selectById(int id) {
		return mailMapper.selectByPrimaryKey(id);
	}
	
	public List<Mail> findAll() {
		MailExample mailExample = new MailExample();
		return mailMapper.selectByExample(mailExample);
	}
	
	/**
	 * 根据Id查看收到邮件
	 * @param id
	 * @return
	 */
	public List<Mail> selectByToId(Long id) {
		MailExample mailExample = new MailExample();
		Criteria criteria = mailExample.createCriteria();
		criteria.andToIdEqualTo(id);
		mailExample.setOrderByClause("time desc");
		return mailMapper.selectByExample(mailExample);
	}
	
	/**
	 * 得到未读邮件数量
	 * @param id
	 * @return
	 */
	public int countUnread(Long id) {
		MailExample mailExample = new MailExample();
		Criteria criteria = mailExample.createCriteria();
		criteria.andToIdEqualTo(id);
		criteria.andIsreadEqualTo(false);
		return mailMapper.countByExample(mailExample);
	}
	
	/**
	 * 根据时间和标题查找
	 * @param id
	 * @param fromTime
	 * @param totime
	 * @param title
	 * @return
	 */
	public List<Mail> selectBytimeAndtitle(Long id, String fromTime,String totime, String title) {
		MailExample mailExample = new MailExample();
		Criteria criteria = mailExample.createCriteria();
		criteria.andToIdEqualTo(id);
		criteria.andTitleLike("%"+title+"%");
		if (fromTime != null && totime != null) {
			criteria.andTimeBetween(fromTime, totime);
		}
		return mailMapper.selectByExample(mailExample);
	}
}
