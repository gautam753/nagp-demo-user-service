package com.demo.nagp.userservice.model;


import java.util.List;

import com.demo.nagp.userservice.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseModel {
	private List<User> users;
	private User userDetail;
	private String podName;
}
