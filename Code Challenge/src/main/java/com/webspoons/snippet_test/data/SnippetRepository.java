package com.webspoons.snippet_test.data;

import org.springframework.data.repository.CrudRepository;
public interface SnippetRepository extends CrudRepository<SnippetEntity,Long>{
    SnippetEntity findByName(String name);
}
