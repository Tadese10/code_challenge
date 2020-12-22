package com.webspoons.snippet_test.ui.controllers;

import com.webspoons.snippet_test.data.SnippetEntity;
import com.webspoons.snippet_test.service.SnippetsService;
import com.webspoons.snippet_test.shared.Constant;
import com.webspoons.snippet_test.shared.SnippetDto;
import com.webspoons.snippet_test.ui.model.AddSnippetRequestModel;
import com.webspoons.snippet_test.ui.model.AddSnippetResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/snippets")
public class SnippetsController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    SnippetsService snippetsService;

    @PostMapping(
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<AddSnippetResponseModel> AddSnippet(@Valid @RequestBody AddSnippetRequestModel requestModel) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        SnippetDto snippetDto = modelMapper.map(requestModel, SnippetDto.class);
        String ip = request.getRemoteAddr();
        if(ip.equals(Constant.localhostIp))//Local computer IP
            ip = Constant.localhost;
        ip = String.format("%s:%s",ip,request.getLocalPort());
        snippetDto.setUrl(String.format("%s/snippets/%s",ip, snippetDto.getName()));

        AddSnippetResponseModel responseModel = snippetsService.addSnippet(snippetDto);
        if(responseModel != null)
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(
            path = "/{snippetName}"
    )
    public ResponseEntity<AddSnippetResponseModel> GetSnippet(@PathVariable("snippetName") String snippetName) {
        AddSnippetResponseModel responseModel = snippetsService.getSnippet(snippetName);
        if(responseModel ==null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PostMapping(
            path = "/{snippetName}/like"
    )
    public ResponseEntity<AddSnippetResponseModel> LikeSnippet(@PathVariable("snippetName") String snippetName) {
        AddSnippetResponseModel responseModel = snippetsService.likeSnippet(snippetName);
        if(responseModel ==null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

}
