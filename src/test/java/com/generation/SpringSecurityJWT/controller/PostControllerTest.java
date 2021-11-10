package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostControllerTest {

    @Test
    @DisplayName("Probando el mockito")
    void testMockito() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test
    @DisplayName("Probando el mockito 2")
    public void simpleTest() {

        List<String> list = mock(List.class);

        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        verify(list).get(0);

        assertEquals("helloworld", result);

    }

    @Test
    @DisplayName("Probando el post")
    public void postSaveTest() {
        PostService postService = mock(PostService.class);

        PostController postController = new PostController(postService);

        Post post = new Post();

        //-
        post.setTitle("Pruebas del post con mokito");
        post.setContent("Contenido del post");
        //se puede crear un mock de esto

        when(postService.save(any(Post.class))).thenReturn(post);


        postController.post(post);

        Post result = postController.post(post);

        assertEquals(post.getTitle(), result.getTitle());
    }
}