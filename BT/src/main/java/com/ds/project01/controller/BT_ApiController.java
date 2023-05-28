package com.ds.project01.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.project01.domain.DeptEntity;
import com.ds.project01.domain.HobbyDataEntity;
import com.ds.project01.domain.HobbyEntity;
import com.ds.project01.domain.UserEntity;
import com.ds.project01.dto.HobbyDataDto;
import com.ds.project01.dto.UserDto;
import com.ds.project01.service.BT_DeptService;
import com.ds.project01.service.BT_HobbyService;
import com.ds.project01.service.BT_UserService;

@RestController
public class BT_ApiController {

	@Autowired
	private BT_UserService userService;
	
	@Autowired
	private BT_DeptService deptService;
	
	@Autowired
	private BT_HobbyService hobbyService;
	
	
	@GetMapping("/bt/deptList")
	public List<DeptEntity> user_deptList() {
		
		return deptService.deptList();
	}
	
	@GetMapping("/bt/hobbyList")
	public List<HobbyEntity> user_hobbyList() {
		
		return hobbyService.hobbyList();
	}
	
	@GetMapping("/bt/list")
	public List<UserEntity> admin_list(String searchKeyword) {
		
		return userService.adminList(searchKeyword);
	}

	@PostMapping("/bt/userSave")
	public ResponseEntity<UserDto> user_save(@RequestBody UserDto dto) {
		userService.insert(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/bt/hobbyDataSave")
	public ResponseEntity<HobbyDataDto> hobbyData_save(@RequestBody HobbyDataDto hdDto) {
		hobbyService.hobbyDataInsert(hdDto);
		return ResponseEntity.ok(hdDto);
	}

	
	@GetMapping("/bt/view")
	UserEntity userView(String userId){ 
		
		return userService.view(userId);
	}
	
	@GetMapping("/bt/hobbyDataList")
	List<HobbyDataEntity> HobbyDataList(String userId){
		return hobbyService.HobbyDataView(userId);
	}
	
	@PostMapping("/bt/delete")
	public ResponseEntity<UserDto> user_delete(@RequestBody UserDto dto) {
		System.out.println(dto);
		hobbyService.HobbyDataDelete(dto.getUserId());
		userService.delete(dto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/bt/idCheck")
	public boolean user_idCheck(String userId) {
		return userService.idcheck(userId);
	}
	
}