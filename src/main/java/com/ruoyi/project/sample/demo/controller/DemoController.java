package com.ruoyi.project.sample.demo.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.SampleConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.sample.demo.domain.Demo;
import com.ruoyi.project.sample.demo.service.IDemoService;

@Controller
@RequestMapping("/sample/demo")
public class DemoController extends BaseController {

	private String prefix = "sample/demo";

	@Value("${ruoyi.name}")
	private String rouyi_name;

	@Autowired
	private IDemoService service;

	@Autowired
	@Qualifier("configEdu")
	SampleConfig configEdu;

	@ModelAttribute
	public void call() {
		System.out.println("call sample controller." + LocaleContextHolder.getLocale());
		System.out.println("rouyi_name:" + rouyi_name);
		System.out.println("configEdu_list:" + configEdu.getList());
		System.out.println("configEdu_map:" + configEdu.getMap());
	}

	/**
	 * 主画面への遷移
	 * 
	 * @return 主画面
	 */
	@RequiresPermissions("sample:demo:view")
	@GetMapping()
	public String index(Model model) {
		//DBのコードより
		//model.addAttribute("edu", service.getCodeList("edu"));
		//プロパティーのコードより
		model.addAttribute("eduMap", configEdu.getMap());
		return prefix + "/demomain";
	}

	/**
	 * 一覧の取得
	 * 
	 * @return 一覧データ（JSON）
	 */
	@RequiresPermissions("sample:demo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Demo demo) {
		startPage();
		List<Demo> list = service.selectDemoList(demo);
		return getDataTable(list);
	}

	/**
	 * 追加画面への遷移
	 * 
	 * @return page
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/demoadd";
	}

	/**
	 * 新規
	 * 
	 * @return JSON
	 */
	@Log(title = "サンプル管理", businessType = BusinessType.INSERT)
	@RequiresPermissions("sample:demo:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addsave(@Validated Demo demo) {
		// 追加
		return toAjax(service.insertDemo(demo));
	}

	/**
	 * 編集画面への遷移
	 * 
	 * @return page
	 */
	@GetMapping("/edit/{demoId}")
	public String edit(@PathVariable("demoId") Long demoId, Model model) {
		model.addAttribute("demo", service.selectDemoById(demoId));
		return prefix + "/demoedit";
	}

	/**
	 * 更新
	 * 
	 * @param demo
	 * @return JSON
	 */
	@Log(title = "サンプル管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("sample:demo:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@Validated Demo demo) {
		// 権限チェック
		service.checkDemoAllowed(demo);
		return toAjax(service.updateDemo(demo));
	}

	/**
	 * IDより、削除（ロジック）
	 * 
	 * @param demo
	 * @return JSON
	 */
	@Log(title = "サンプル管理", businessType = BusinessType.DELETE)
	@RequiresPermissions("sample:demo:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		System.out.println("ids:" + ids);
		try {
			return toAjax(service.deleteDemoById(ids));
		} catch (Exception e) {
			return this.error(e.getMessage());
		}
	}

	/**
	 * 出力
	 * 
	 * @param demo
	 * @return
	 */
	@Log(title = "サンプル管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("sample:demo:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Demo demo) {
		List<Demo> list = service.selectDemoList(demo);
		ExcelUtil<Demo> util = new ExcelUtil<Demo>(Demo.class);
		return util.exportExcel(list, "abc");
	}

}
