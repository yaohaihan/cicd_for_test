package com.example.demo;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Service.FriendshipService;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@SpringBootTest(classes =  {DemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockMvcTestor {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FriendshipService friendshipService;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("测试 POST 创建好友关系接口")
    public void testFriendController_ValidUserId() throws Exception {
        // 模拟 userService 的行为
        when(userService.getUser(1)).thenReturn(new User()); // 返回一个有效用户
        when(userService.getUser(2)).thenReturn(new User()); // 返回一个有效用户
        when(friendshipService.getFriendshipByTwoUserId(1, 2)).thenReturn(null); // 模拟没有好友关系

        // 执行 POST 请求
        mockMvc.perform(MockMvcRequestBuilders.post("/friendship/BuildRelations")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userId1", "1")
                        .param("userId2", "2"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0)) // 验证返回的 code
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success")) // 验证返回的 message
                .andReturn();
    }

    @Test
    @DisplayName("测试 POST 创建用户接口")
    public void testAddUser_ValidUser() throws Exception {
        // 创建 UserDTO 对象
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setPassword("password");
        userDTO.setGender("Male");
        userDTO.setEmail("test@example.com");
        userDTO.setStatus("Active");

        // 模拟 userService.addUser() 方法，不返回任何值
        doNothing().when(userService).addUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(byte[].class));

        // 创建一个模拟的文件
        MockMultipartFile avatarFile = new MockMultipartFile("avatorPic", "avatar.jpg", MediaType.IMAGE_JPEG_VALUE, "dummy data".getBytes());

        // 发送 POST 请求
        mockMvc.perform(MockMvcRequestBuilders.multipart("/users/addUser")
                        .file(avatarFile)
                        .param("username", userDTO.getUsername())
                        .param("password", userDTO.getPassword())
                        .param("gender", userDTO.getGender())
                        .param("email", userDTO.getEmail())
                        .param("status", userDTO.getStatus()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success"));
    }


}

