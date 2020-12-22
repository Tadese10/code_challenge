package com.webspoons.snippet_test.service;

import com.webspoons.snippet_test.data.SnippetEntity;
import com.webspoons.snippet_test.data.SnippetRepository;
import com.webspoons.snippet_test.shared.Constant;
import com.webspoons.snippet_test.shared.SnippetDto;
import com.webspoons.snippet_test.ui.model.AddSnippetResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
public class SnippetServiceImpl implements SnippetsService {

    private final SnippetRepository snippetRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public SnippetServiceImpl(SnippetRepository snippetRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.snippetRepository = snippetRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public AddSnippetResponseModel addSnippet(SnippetDto snippetDto) throws Exception {
        SnippetEntity query =  snippetRepository.findByName(snippetDto.getName());
        if(query == null || query.getExpires_at().before(Calendar.getInstance().getTime())){//Doesnt exist
            if(query == null)
            {
                query  = modelMapper.map(snippetDto, SnippetEntity.class);
                query.setLikes(0);
            }

            if(query.getPassword() != null && !query.getPassword().equals("")){
                query.setPassword(bCryptPasswordEncoder.encode(query.getPassword()));
            }
            query.setExpires_at(new Date(System.currentTimeMillis() + (Constant.milliSeconds * snippetDto.getExpires_in())));// 1 second equals to 1000 milliseconds and assumed that the expiry time is in seconds
            snippetRepository.save(query);
            return modelMapper.map(query, AddSnippetResponseModel.class);
        }
        else
            return null;
    }

    @Override
    public AddSnippetResponseModel getSnippet(String name) {
        SnippetEntity query =  snippetRepository.findByName(name);
        Timestamp date = new java.sql.Timestamp(new Date(System.currentTimeMillis()).getTime());
        if(query == null || date.after(query.getExpires_at()))
            return null;
        else{
            query.setExpires_at(new Date(System.currentTimeMillis() + (Constant.milliSeconds * Constant.extendAccessTime)));// 1 second equals to 1000 milliseconds
            snippetRepository.save(query);
            return modelMapper.map(query, AddSnippetResponseModel.class);
        }
    }

    @Override
    public AddSnippetResponseModel likeSnippet(String name) {
        SnippetEntity query =  snippetRepository.findByName(name);
        Timestamp date = new java.sql.Timestamp(new Date(System.currentTimeMillis()).getTime());
        if(query == null || date.after(query.getExpires_at()))
            return null;
        else{
            query.setLikes(query.getLikes()+1);
            query.setExpires_at(new Date(System.currentTimeMillis() +  Constant.extendAccessTime));// 1 second equals to 1000 milliseconds
            snippetRepository.save(query);
            return modelMapper.map(query, AddSnippetResponseModel.class);
        }
    }
}
