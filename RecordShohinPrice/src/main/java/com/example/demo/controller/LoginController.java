package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginDto;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;

	@RequestMapping("/")
	public String login() {
		
		//DBからユーザーマスタの情報を取得する
		List<LoginDto> loginInfoList = LoginDao.findAll();
		
		
		
	}
	
	//入力したIDとパスワードを取得
	@RequestMapping("login")
	public String login(ModelMap modelMap, @RequestParam("ID") String ID, @RequestParam("password") String password) {
		//判定フラグ
		Boolean loginFlg = false;
		//名前取得用変数
		String name = "";
		
		
		//取得したログインリストを検索して存在の有無を確認する？
				for(LoginDto LoginInfo : loginInfoList) {
					if (LoginInfo.getUser_id() == ID) {
							if (LoginInfo.getPassword() == password) {
								loginFlg = true;
								name = LoginInfo.getUser_name();
								Exit for; //exitではない・・・？？？
							}
					}
				}
		
		modelMap.addAttribute("loginFlg", loginFlg);
		modelMap.addAttribute("name", name);
		Return login;
	}
}
