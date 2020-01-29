package com.hsc0426.example1.repository;

import com.hsc0426.example1.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)    //스프링 run기반
@SpringBootTest //junit4에서 springBoot를 테스트하겠다
@Transactional //이 단위로 트랜잭션
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Rollback(false)
    public void Board등록정상테스트() {
        //given
        Board requestData = Board.builder()
                .author("홍춘이")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();
        //Board build = requestData;

        //ctrl+alt+v => 리턴값

        //비교
        //new Board("홍춘이", "내용", "제목", LocalDateTime.now());

        //when
        Board newBoard = boardRepository.save(requestData);

        //then
        assertEquals("홍춘이",newBoard.getAuthor());
        assertEquals("내용",newBoard.getContent());
        assertEquals("제목",newBoard.getSubject());
        assertNotNull(newBoard.getId());
        assertNotNull(newBoard.getCreatedTime());
    }

    @Test
    @Rollback(false)
    public void Board수정정상테스트() {
        //given
        Board requestData = Board.builder()
                .author("홍춘이")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();
        Board newBoard = boardRepository.save(requestData);

        //when
        newBoard.setAuthor("박규태");
        Board selectBoard = boardRepository.findById(newBoard.getId()).get();

        //then
        assertEquals("박규태",selectBoard.getAuthor());
        assertEquals(newBoard.getId(), selectBoard.getId());
    }
}