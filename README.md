# 3-miniproject
- 3team / 기본적인 CRUD를 구현한 JSP 게시판 / 박대원, 이혜진, 조현철, 황원상

환경 : java 1.8 버전, 톰캣9.0버전, eclipse, workbanch(mysql)
db구성 : mysql noticeBoard(notice_id, notice_title, notice_date, notice_content, user_id)
               user(user_id, user_name, password)
형상관리 : sourcetree

기능 :
- 로그인(LoginController)) : ID가 존재하는지 확인하며 로그인 기능 구현. 세션에 ID값을 저장하여 화면 이동시 세션 정보 유지

- 회원가입(InsertUserController) : ID가 존재하는지 확인하여 DB에 (아이디, 비밀번호, 이름)을 저장

- 공지게시판 목록(GetBoardListController) : DB에 저장된 글의 목록을 보여줌

- 공지게시판 작성 글 조회(GetBoardController) : 게시글의 pk값을 통해 글정보 조회 (제목, 내용, 작성자, 작성시간)을 보여줌

- 공지게시판 글쓰기(InsertBoardController) : 글을 작성하여 DB에 (제목, 내용, 작성자, 작성시간)을 저장

- 공지게시판 글 수정(UPdateBoardController) : 작성된 글을 수정. 작성자와 로그인한 사람이 같아야 수정 가능

- 공지게시판 글 삭제(DeleteBoardController) : 작성된 글을 삭제. 작성자와 로그인한 사람이 같아야 삭제 가능

- 공지게시판 footer(css/footer) : 글 목록(HOME), 깃화면 연결(Github), 제작팀 등의 내용 표시

- 로그인/ 회원가입 비동기 기능 : 로그인/ 회원가입시 ID의 존재여부에 대해 체크하는 기능 구현

- Errors/ LoginErrors : 예외/에러 상황 발생 시 글목록으로 이동하는 Errors와 로그인/회원가입시 발생하는 에러 상황시 로그인화면으로 이동하는 LoginError 파일을 따로 구현

- EncodingFilter / LoginFilter : UTF-8로 인코딩을 해주는 enEncodingFilter와  로그인을 하지않았을때는 글을 조회할 수 없도록 하는 LoginFilter 구현


개선할점 
1. 회원가입시 비밀번호 두번 체크하는 기능
2. 게시글 입력시 비밀번호를 추가하여 저장 후 삭제 시 비밀번호를 체크하는 기능을 구현
3. 게시글 목록 페이징처리
4. 제목, 내용 검색기능
5. 로그아웃 세션처리  (현재 로그아웃 기능은 로그인 페이지로 넘기는 방식으로 구현)



아쉬웠던점 / 배운점 / 해결한 어려운 점
1. 코드를 짜고 기능을 구현하는 것도 중요하지만 각자의 환경이 다르다보니 깃에서 충돌나는 상황들이 많이 일어나서 힘들었음. 환경을 맞추는것의 중요성을 느낌.
2. 화면 설계를 먼저 하면 좋았을 것 (기본 틀/ 폴더의 위치/ Controller의 기능 / 함수의 표현, 이름 등) : 처음 설계를 같이 하지 않았기때문에 합치는 과정에서 충돌도 많이 일어나고 복잡했음. 설계의 중요성을 느끼는 좋은 시간이었음.
3. 로그인과 회원가입을 비동기로 구현하여 로그인의 Id체크 기능과 회원가입에서의 Id체크 기능이 둘 중 하나만 실행되는 문제를 겪었으나 두가지의 api.controller를 따로 구현하여 완전히 두가지 기능을 분리하였고 구현하는 메세지의 ID값이 겹치는 부분을 체크하지 못한것을 알게되어 메세지 ID 구분을 통해 해결하였음.