package com.ruoyi.project.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.common.mapper.CodeMapper;
import com.ruoyi.project.sample.demo.domain.Demo;
import com.ruoyi.project.sample.demo.mapper.DemoMapper;

/**
 * サンプルのサービス
 * 
 * @author lnsylt
 *
 */
@Service
public class DemoServiceImpl implements IDemoService {

	@Autowired
	private DemoMapper demoMapper;
	
	@Autowired
	private CodeMapper codeMappger;

	/**
	 * 一覧データ（ページ分）
	 */
	@Override
	public List<Demo> selectDemoList(Demo demo) {
		return demoMapper.selectDemoList(demo);
	}

	/**
	 * IDより、データを取得
	 */
	@Override
	public Demo selectDemoById(Long demoId) {
		return demoMapper.selectDemoById(demoId);
	}

	/**
	 * 追加データ
	 */
	@Override
	@Transactional
	public int insertDemo(Demo demo) {
		demo.setCreateBy(ShiroUtils.getLoginName());
		return demoMapper.insertDemo(demo);
	}

	/**
	 * 更新データ
	 */
	@Override
	@Transactional
	public int updateDemo(Demo demo) {
		demo.setUpdateBy(ShiroUtils.getLoginName());
		return demoMapper.updateDemo(demo);
	}

	/**
	 * 権限チェック
	 */
	@Override
	public void checkDemoAllowed(Demo demo) {
		if (StringUtils.isNotNull(demo.getDemoId()) && demo.isAdmin()) {
			throw new BusinessException("権限なし");
		}
	}

	/**
	 * データの削除（ロジック）
	 */
	@Override
	@Transactional
	public int deleteDemoById(String ids) throws Exception {

		Long[] demoIds = Convert.toLongArray(ids);
		return demoMapper.deleteDemoByIds(demoIds);
	}

	@Override
	public List<String> getCodeList(String code) {
		return codeMappger.getCodeList(code);
	}

}
