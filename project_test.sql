USE login;

select * from user;

insert into user values("hj", "혜진", 1234);
insert into user values("dw", "대원", 4567);
insert into user values("hc", "현철", 7894);
insert into user values("ws", "원상", 4062);

insert into notice_board(notice_title, notice_date,notice_content, user_id) values('공지1', CURRENT_TIMESTAMP, '공지 1 입니다.', 'hj');
insert into notice_board(notice_title, notice_date,notice_content, user_id) values('공지2', CURRENT_TIMESTAMP, '공지 2 입니다.', 'dw');
insert into notice_board(notice_title, notice_date,notice_content, user_id) values('공지3', CURRENT_TIMESTAMP, '공지 3 입니다.','hc');

insert into free_board(free_title, free_date,free_content, user_id) values('자유게시판1', CURRENT_TIMESTAMP, '자유게시판 1 입니다.', 'ws');
insert into free_board(free_title, free_date,free_content, user_id) values('자유게시판2', CURRENT_TIMESTAMP, '자유게시판 2 입니다.', 'hj');
insert into free_board(free_title, free_date,free_content, user_id) values('자유게시판3', CURRENT_TIMESTAMP, '자유게시판 3 입니다.','dw');

insert into question_board(question_title, question_date,question_content, user_id) values('질문1', CURRENT_TIMESTAMP, '질문 1 입니다.','hc');
insert into question_board(question_title, question_date,question_content, user_id) values('질문2', CURRENT_TIMESTAMP, '질문 2 입니다.','ws');
insert into question_board(question_title, question_date,question_content, user_id) values('질문3', CURRENT_TIMESTAMP, '질문 3 입니다.','dw');

commit;

select * from question_board; 