package com.webspoons.snippet_test.service;

import com.webspoons.snippet_test.shared.SnippetDto;
import com.webspoons.snippet_test.ui.model.AddSnippetResponseModel;

public interface SnippetsService {
    AddSnippetResponseModel  addSnippet(SnippetDto snippetDto) throws Exception;
    AddSnippetResponseModel getSnippet(String name);
    AddSnippetResponseModel likeSnippet(String name);
}
