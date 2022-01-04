package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentMapper {
    public void createComment(Comment comment);
    public void deleteComment(String 사번);
}
