package com.webspoons.snippet_test;

import com.webspoons.snippet_test.data.SnippetEntity;
import com.webspoons.snippet_test.data.SnippetRepository;
import com.webspoons.snippet_test.service.SnippetsService;
import com.webspoons.snippet_test.ui.model.AddSnippetRequestModel;
import com.webspoons.snippet_test.ui.model.AddSnippetResponseModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnippetRepositoryTest {

    @Autowired
    private SnippetsService service;

    @MockBean
    private SnippetRepository repository;

    private AddSnippetResponseModel snippetResponseModel;

    @Before
    public void init() {

        // Setup our mock repository
        SnippetEntity snippetEntity = new SnippetEntity();
        snippetEntity.setUrl("localhost:8020:snippets/recipe");
        snippetEntity.setLikes(0);
        snippetEntity.setSnippet("1 apple");
        snippetEntity.setName("recipe");
        snippetEntity.setExpires_at(new Date(System.currentTimeMillis()+ 30));

        snippetResponseModel = new AddSnippetResponseModel();
        snippetResponseModel.setExpires_at(new Date(System.currentTimeMillis() +30));
        snippetResponseModel.setUrl("localhost:8020:snippets/recipe");
        snippetResponseModel.setName("recipe");
        snippetResponseModel.setSnippet("1 apple");

        doReturn(Optional.of(snippetEntity)).when(repository).findByName("recipe");

        doReturn(Optional.of(snippetEntity)).when(repository).save(snippetEntity);

        doReturn(Optional.of(snippetResponseModel)).when(service).getSnippet("recipe");
        when(service.getSnippet("recipe")).thenReturn(snippetResponseModel);

    }


    @Test
    @DisplayName("Test getSnippet Success")
  public  void testFindById() {
        // Execute the service call
        AddSnippetResponseModel response = service.getSnippet("recipe");

        // Assert the response
        Assertions.assertEquals(response.getName(), "recipe");
    }


}
